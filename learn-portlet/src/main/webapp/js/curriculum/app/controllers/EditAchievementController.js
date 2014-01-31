function EditAchievementController($scope, $http){
    var currentTab = $scope.tabs[$scope.tabs.length - 1];
    $scope.achievement = currentTab.achievement;
    $scope.isEditingTitle = false;

    $scope.editTitle = function() {
        $scope.isEditingTitle = true;
        $scope.newTitle = $scope.achievement.title;
    }

    $scope.applyTitle = function() {
        $scope.isEditingTitle = false;
        $scope.achievement.title = $scope.newTitle;

        $scope.$emit(
            'achievementTitleChanged',
            {
                newTitle: $scope.achievement.title,
                id: $scope.achievement.id
            });
    }

    $scope.editDescription = function () {
    };

    $scope.$on('achievementDescriptionChanged', function (e, args) {
        if($scope.achievement.id != args.id)
            return;

        $scope.achievement.description = args.newDescription;
    });
}