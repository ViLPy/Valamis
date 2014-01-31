app.controller('EditAchievementUsersController', ['$scope', '$http', '$window', function ($scope, $http, $window) {
    function getUsers() {
        return from($window.users)
            .except($scope.achievement.users, function (user1, user2) {
                return user1.userID == user2.id;
            })
            .toArray();
    }

    function getSearchingUsers(users) {
        return from(users)
            .where(function (user) {
                return user.name
                    .toLowerCase()
                    .indexOf($scope.userSearchFilter.toLowerCase()) != -1;
            })
            .toArray();
    }

    function getSortedUsers(users) {
        var sortedUsers = [];

        if ($scope.sortDirection)
            sortedUsers = from(users)
                .orderBy("$name")
                .toArray();
        else
            sortedUsers = from(users)
                .orderByDesc("$name")
                .toArray();

        return sortedUsers;
    }

    function organizeUsers() {
        var availableUsers = getUsers();
        availableUsers = getSortedUsers(availableUsers);
        $scope.users = getSearchingUsers(availableUsers);
    }

    function init() {
        var currentTab = $scope.tabs[$scope.tabs.length - 1];
        $scope.achievement = currentTab.achievement;
        $scope.sortDirection = true;
        $scope.sortLabel = $scope.sortDirection
            ? $scope.sortOrderDescLabel
            : $scope.sortOrderAscLabel;

        $scope.userSearchFilter = "";
        $scope.usersDialogConfig = {
            width: 370,
            height: 350,
            resizable: false,
            modal: true,
            buttons: {
                Cancel: function () {
                    jQuery1816Curriculum(this).dialog("close");
                }
            }
        }

        organizeUsers();

        $scope.$watch('sortDirection', function () {
            $scope.sortLabel = $scope.sortDirection
                ? $scope.sortOrderAscLabel
                : $scope.sortOrderDescLabel;
        });
        $scope.$watchCollection('achievement.users', organizeUsers);
    }

    $scope.hasUsers = function () {
        return $scope.users && $scope.users.length > 0;
    }

    $scope.hasAchievementUsers = function() {
        return $scope.achievement.users && $scope.achievement.users.length > 0;
    }

    $scope.search = function () {
        var availableUsers = getUsers();
        $scope.users = getSearchingUsers(availableUsers);
    }

    $scope.sort = function () {
        var availableUsers = getUsers();
        $scope.users = getSortedUsers(availableUsers);
        $scope.sortDirection = !$scope.sortDirection;
    }

    $scope.addUser = function (user) {
        var url = "{0}/services/achievementUser"
            .replace("{0}", $window.scormContextPath);

        var data = {
            userId: user.userID,
            achievementId: $scope.achievement.id
        }

        $http
            .post(url, data)
            .success(function () {
                var userModel = {
                    id: user.userID,
                    login: user.name,
                    portrait: 0
                }

                $scope.achievement.users.push(userModel);
            })
    }

    $scope.removeUser = function (user) {
        var url = "{0}/services/achievementUser/delete/"
            .replace("{0}", $window.scormContextPath);

        var data = {
            userId: user.id,
            achievementId: $scope.achievement.id
        }

        $http
            .post(url, data)
            .success(function () {
                var index = $scope.achievement.users.indexOf(user);
                $scope.achievement.users.splice(index, 1);
            })
    }

    $scope.showUserDetails = function (user) {
        user.isShowDetail = true;
    }

    $scope.hideUserDetails = function (user) {
        user.isShowDetail = false;
    }

    init();
}]);
