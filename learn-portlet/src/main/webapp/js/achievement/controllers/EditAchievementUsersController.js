app.controller('EditAchievementUsersController', ['$scope', '$http', '$window', function ($scope, $http, $window) {

    function getOrganizations() {
        var url = '{0}/services/liferay/user/filters'
            .replace('{0}', scormContextPath);

        $http
            .get(url)
            .success(function (response) {
                jQuery.each(
                    response.organizations, function (index, item) {
                        $scope.organizations.push(item)
                    }
                )
            });


    }

    function getUsers() {
        var url = '{0}/services/liferay/user'
            .replace('{0}', scormContextPath);

        $http
            .get(url, {
                params: {
                    companyID: $scope.companyId,
                    module: "ach",
                    moduleID: $scope.achievement.id,
                    name: $scope.userSearchName,
                    sort: $scope.sortType,
                    orgID: $scope.selectedOrganization,
                    page: $scope.userPage,
                    count: $scope.count
                }
            })
            .success(function (response) {
                angular.copy(response, $scope.userResponse);
                $scope.totalUsers = $scope.userResponse.total;
                $scope.userPage = $scope.userResponse.currentPage;
                $scope.filteredUsers = [];
                angular.forEach(response.records, function(item){
                    var user = {id: item.userID, name: item.name, portrait: item.portrait, email: item.email}
                    $scope.filteredUsers.push(user)
                });

            });
    }

    function setDefaultValues () {
        $scope.userSearchName = "";
        $scope.sortType = "asc";
        $scope.selectedOrganization = -1;
        $scope.userResponse = [];
        $scope.filteredUsers = [];
        $scope.totalUsers = 0;
        $scope.currentPage = 1;
        $scope.userPage = 1;
    }

    function init() {
        var currentTab = $scope.tabs[$scope.tabs.length - 1];
        $scope.achievement = currentTab.achievement;

        if (!$scope.userPage)
            $scope.userPage = 1;
        if (!$scope.count)
            $scope.count = 8;
        if (!$scope.companyId)
            $scope.companyId = companyID;

        setDefaultValues();

        $scope.organizations = [
            {orgID: -1, name: ""}
        ];

        var buttonsOpts = {};
        buttonsOpts[$window.localizedResources.addUsersLabel] = function () {
            angular.forEach($scope.filteredUsers, function(item){
                if(item.selected)
                    $scope.addUser(item);
            });
            jQuery1816Curriculum(this).dialog("close");
        }

        $scope.usersDialogConfig = {
            width: 1200,
            height: 790,
            resizable: false,
            modal: true,
            open: function() {
                setDefaultValues();
                getUsers();
            },
            buttons: buttonsOpts
        }

        getOrganizations();

        $scope.$watch('userPage', function () {
            getUsers();
        });
    }

    $scope.searchUsers = function () {
        $scope.userPage = 1;
        getUsers();
    }

    $scope.hasUsers = function () {
//        return $scope.users && $scope.users.length > 0;
        return $scope.filteredUsers && $scope.filteredUsers.length > 0;
    }

    $scope.hasAchievementUsers = function () {
        return $scope.achievement.users && $scope.achievement.users.length > 0;
    }

    $scope.addUser = function (user) {
        var url = "{0}/services/achievement/{1}/user/{2}"
            .replace("{0}", $window.scormContextPath)
            .replace("{1}", $scope.achievement.id)
            .replace("{2}", user.id);

        var data = {
            //userId: user.id,
            //achievementId: $scope.achievement.id
            action: "apply"
        }

        $http
            .post(url, data)
            .success(function () {
                $scope.achievement.users.push(user);
            })
    }

    $scope.removeUser = function (user) {
        var url = "{0}/services/achievement/{1}/user/{2}"
            .replace("{0}", $window.scormContextPath)
            .replace("{1}", $scope.achievement.id)
            .replace("{2}", user.id);

        var data = {
            //userId: user.id,
            //achievementId: $scope.achievement.id
            action: "remove"
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

    //paging
    $scope.isShowPager = function () {
        return $scope.totalUsers > $scope.count;
    }

    $scope.previousUserPage = function () {
        if ($scope.userPage > 1)
            $scope.userPage = $scope.userPage - 1;
    }

    $scope.nextUserPage = function () {
        if ($scope.userPage < ($scope.totalUsers / $scope.count))
            $scope.userPage = $scope.userPage + 1;
    }

    $scope.isFirstPage = function () {
        return $scope.userPage == 1;
    }

    $scope.totalPages = function () {
        var result =  Math.round($scope.totalUsers / $scope.count);
        if(($scope.totalUsers % $scope.count) > 0
            && ($scope.totalUsers % $scope.count) < 5)
            result++;
        return result;
    }

    $scope.toPage = function (page) {
        $scope.userPage = page;
    }

    $scope.isLastPage = function () {
        return $scope.userPage == $scope.totalPages();
    }

    init();
}]);
