app.controller('EditAchievementActivitiesController', ['$scope', '$http', '$window', function ($scope, $http, $window) {
    function init() {
        var url = '{0}/services/requiredActivity/'
            .replace('{0}', $window.scormContextPath)
            .replace('{1}', $scope.achievement.id);

        $http.
            get(url)
            .success(function (response) {

                // TODO: Kill Artyom for it
                var activities = from(response)
                    .select(function(item) {
                        return {name: item}
                    })
                    .toArray();
                $scope.allActivities = activities;
                $scope.activities = getAvailableActivities();
            });
    }

    function getAvailableActivities() {
        return from($scope.allActivities)
            .except($scope.achievement.activities, function (activity1, activity2) {
                return activity1.name == activity2.name;
            })
            .toArray();
    }

    $scope.hasExceptedActivities = function(){
        return $scope.activities && $scope.activities.length > 0;
    }

    $scope.addActivity = function(activity) {
        var url = '{0}/services/requiredActivity/'
            .replace('{0}', $window.scormContextPath);

        $http
            .post(url, {
                achievementId: $scope.achievement.id,
                activityClassName: activity.name
            })
            .success(function(response) {
                $scope.achievement.activities.push({id: response.id, name: activity.name, requiredCount: response.removeActivity});

                var index = $scope.activities.indexOf(activity);
                $scope.activities.splice(index, 1);
            })
    }

    init();
}]);
