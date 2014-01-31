app.controller('EditCertificateController', ['$scope', '$window', '$http', function ($scope, $window, $http) {
    var currentTab = $scope.tabs[$scope.tabs.length - 1];
    $scope.certificateId = currentTab.certificate.id;
    $scope.isEditingTitle = false;
    $scope.availableCourses = courses;

    function saveCertificateChanges (){
        var url = '{0}services/certificating/update/{1}'
            .replace('{0}', Utils.getContextPath())
            .replace('{1}', $scope.certificateId);

        var data = {
            title: $scope.title,
            description: $scope.description,
            isPermanent: $scope.isPermanent,
            publishBadge: $scope.publishBadge,
            shortDescription: $scope.shortDescription
        };

        $http
            .post(url, data)
            .success(function(){
                $scope.$emit(
                    'certificateTitleChanged',
                    {
                        newTitle: $scope.title,
                        id: $scope.certificateId
                    });
            });
    }

    function deleteCourse(site){
        var url = '{0}services/certificating/sites/delete/{1}'
            .replace('{0}', Utils.getContextPath())
            .replace('{1}', site.id);

        $http
            .get(url)
            .success(function(response){
                $scope.sites.pop(site);

                $scope.$emit(
                    'certificateCourseCountChanged',
                    {
                        usersCount: $scope.sites.length,
                        id: $scope.certificateId
                    });

            });
    }

    function addCourse(course) {
        var url = '{0}services/certificating/sites/addSite/{1}'
            .replace('{0}', Utils.getContextPath())
            .replace('{1}', site.id);

        $http
            .get(url)
            .success(function(response){
                $scope.sites.push(site);

                $scope.$emit(
                    'certificateCourseCountChanged',
                    {
                        usersCount: $scope.sites.length,
                        id: $scope.certificateId
                    });
            })
    }

    function getFullCertificate(){
        var url = '{0}services/certificating/{1}'
            .replace('{0}', Utils.getContextPath())
            .replace('{1}', $scope.certificateId);

        $http
            .get(url)
            .success(function(response){
                angular.extend($scope, response);

                $scope.$watch('isPermanent', saveCertificateChanges);
                $scope.$watch('publishBadge', saveCertificateChanges);
            });
    }

    $scope.editTitle = function() {
        $scope.isEditingTitle = true;
        $scope.newTitle = $scope.title;
    }

    $scope.designBadge = function(){
        var url = 'https://www.openbadges.me/designer.html?origin=http://{0}&email=developer@example.com&close=true'
            .replace('{0}', $window.location.host);
        var options = 'width=1015,height=680,location=0,menubar=0,status=0,toolbar=0';
        var designerWindow = $window.open(url, '', options);
    }

    $scope.applyTitle = function() {
        $scope.isEditingTitle = false;
        $scope.title = $scope.newTitle;

        saveCertificateChanges();
    }

    $scope.editDescription = function () {

    };

    $scope.addCourse = function(course) {
        addCourse(course);
    };

    $scope.deleteCourse = function(course) {
        deleteCourse(course);
    };

    $scope.$on('certificateDescriptionChanged', function (e, args) {
        if($scope.certificateId != args.id)
            return;

        $scope.description = args.newDescription;

        saveCertificateChanges();
    });

    getFullCertificate();
}]);

