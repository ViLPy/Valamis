app.controller('CurriculumController', ['$scope', '$http', '$window', function ($scope, $http, $window) {
    function init() {
        $scope.tabs = [];
        $scope.$on('achievementChanged', function (e, achievement) {
            var tab = findAchievementTabById(achievement.id);
            if (tab)
                tab.title = 'Edit: {0}'.replace('{0}', achievement.title);
        });

        $scope.$on('achievementDeleted', function(e, achievement) {
            var tab = findAchievementTabById(achievement.id);
            $scope.close(tab);
        });
        $scope.$on('achievementEditing', function(e, achievement) {
            createNewTab(achievement, 'editItem');
        });
        $scope.$on('achievementUsersEditing', function(e, achievement) {
            createNewTab(achievement, 'editUsers');
        });
    }

    function findAchievementTabById(id) {
        var tab = from($scope.tabs)
            .where('$.achievement.id == ' + id)
            .firstOrDefault();

        return tab;
    }

    function deactivateAllTabs() {
        angular.forEach($scope.tabs, function (item) {
            item.isActive = false;
        })
    }

    function createNewTab(achievement, tabType) {
        deactivateAllTabs();

        var tab = findAchievementTabById(achievement.id)
        if (tab)
            $scope.close(tab)

        switch (tabType) {
            case 'editItem':
                tab = {
                    key: 'achievement_{0}'.replace('{0}', achievement.id),
                    title: 'Edit: {0}'.replace('{0}', achievement.title),
                    template: "achievementItemEditSites.html",
                    achievement: achievement,
                    isActive: true
                }
                break;

            case 'editUsers':
                tab = {
                    key: 'achievement_{0}'.replace('{0}', achievement.id),
                    title: 'Edit Users: {0}'.replace('{0}', achievement.title),
                    template: "achievementUserListEdit.html",
                    achievement: achievement,
                    isActive: true
                }
                break;
        }
        // TODO: doesnt work. check
        $scope.$watch('achievement.title', function() {
             tab.title = 'Edit Users: {0}'.replace('{0}', achievement.title);
        });
        $scope.tabs.push(tab);
    }

    $scope.unescape = $window.unescape;

    $scope.findAchievementTabById = findAchievementTabById;

    $scope.close = function (tab) {
        var index = $scope.tabs.indexOf(tab);
        $scope.tabs.splice(index, 1);
    }

    init();
}]);