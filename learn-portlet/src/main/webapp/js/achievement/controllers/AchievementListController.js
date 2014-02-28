/**
 * Created by iliya.tryapitsin on 28.01.14.
 */
app.filter('range', function() {
    return function(input) {
        var lowBound, highBound;
        switch (input.length) {
            case 1:
                lowBound = 0;
                highBound = parseInt(input[0]) - 1;
                break;
            case 2:
                lowBound = parseInt(input[0]);
                highBound = parseInt(input[1]);
                break;
            default:
                return input;
        }
        var result = [];
        for (var i = lowBound; i <= highBound; i++)
            result.push(i);
        return result;
    };
});

app.controller('AchievementListController', ['$scope', '$http', '$window', function ($scope, $http, $window) {
    function init() {
        $scope.achievements = { records: [] };
        $scope.availableAchievements = {records: []};
        $scope.achievementSortLabel = $scope.sortOrderAscLabel;

        // set default values if cookies empty
        if (!$scope.achievementPage)
            $scope.achievementPage = 1;
        if (!$scope.count)
            $scope.count = 10;
        if (!$scope.companyId)
            $scope.companyId = companyID;
        if (!$scope.achievementSortAZ)
            $scope.achievementSortAZ = true;

        // on changed values save to cookies
        $scope.$watch('achievementPage', function () {
            $scope.getAchievements();
        });
        $scope.$watch('achievementSortAZ', function () {
            $scope.achievementSortLabel = $scope.achievementSortAZ
                ? $scope.sortOrderAscLabel
                : $scope.sortOrderDescLabel;
        });
    }

    $scope.unescape = $window.decodeURIComponent;

    function findAchievementById(id) {
        var achievement = from($scope.achievements.records)
            .where('$.id == ' + id)
            .firstOrDefault();

        return achievement;
    }

    $scope.unescape = $window.unescape;

    $scope.hasAchievements = function () {
        return $scope.achievements
            && $scope.achievements.records
            && $scope.achievements.records.length > 0;
    }

    $scope.getAchievements = function (onSuccess) {
        var url = '{0}/services/achievement'
            .replace('{0}', scormContextPath);

        $http
            .get(url, {
                params: {
                    action: "all",
                    companyID: $scope.companyId,
                    page: $scope.achievementPage,
                    count: $scope.count,
                    filter: $scope.achievementFilter,
                    sortAZ: $scope.achievementSortAZ
                }
            })
            .success(function (response) {
                angular.copy(response, $scope.achievements);
                if (onSuccess)
                    onSuccess();
            });
    }

    $scope.addAchievement = function () {
        var url = '{0}/services/achievement?companyID={1}'
            .replace('{0}', scormContextPath)
            .replace('{1}', $scope.companyId);

        $http
            .post(url, {action: "add"})
            .success(function (response) {

                $scope.getAchievements(function () {
                    var achievement = findAchievementById(response.data.id);
                    if (achievement)
                        $scope.$emit('achievementEditing', achievement);
                });
            });
    }

    $scope.editAchievementUsers = function (achievement) {
        $scope.$emit('achievementUsersEditing', achievement);
    }

    $scope.editAchievement = function (achievement) {
        $scope.$emit('achievementEditing', achievement);
    }

    $scope.achievementFiltering = $scope.getAchievements;

    $scope.achievementSort = function () {
        $scope.achievementSortAZ = !$scope.achievementSortAZ;
        $scope.getAchievements();
    }

    $scope.deleteAchievement = function (achievement) {
        var url = '{0}/services/achievement/{1}'
            .replace('{0}', scormContextPath)
            .replace('{1}', achievement.id);

        $http
            .post(url, {action: "delete"})
            .success(function () {
                $scope.getAchievements();
                $scope.$emit('achievementDeleted', achievement);
            });
    }

    $scope.isShowPager = function () {
        return $scope.achievements && $scope.achievements.total > $scope.count;
    }

    $scope.previousAchievementPage = function () {
        if ($scope.achievementPage > 1)
            $scope.achievementPage = $scope.achievementPage - 1;
    }

    $scope.nextAchievementPage = function () {
        if ($scope.achievementPage < ($scope.achievements.total / $scope.count))
            $scope.achievementPage = $scope.achievementPage + 1;
    }

    $scope.isFirstPage = function () {
        return $scope.achievementPage == 1;
    }

    $scope.totalPages = function () {
        var result =  Math.round($scope.achievements.total / $scope.count);
        if(($scope.achievements.total % $scope.count) > 0
            && ($scope.achievements.total % $scope.count) < 5)
            result++;
        return result;
    }

    $scope.toPage = function (page) {
        $scope.achievementPage = page;
    }

    $scope.isLastPage = function () {
        return $scope.achievementPage == $scope.totalPages();
    }

    init();
}]);
