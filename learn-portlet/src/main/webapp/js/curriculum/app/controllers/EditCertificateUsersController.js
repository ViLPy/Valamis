function EditCertificateUsersController($scope) {
    $scope.availableUsers = [];

    $scope.applyFilter = function() {
        if($scope.userFilter)
            $scope.availableFilteredUsers = from($scope.availableUsers)
                .where(function(item) {
                    return item.title.indexOf($scope.userFilter) != -1;
                })
                .toArray();
        else
            $scope.availableFilteredUsers = $scope.availableUsers;
    }
}