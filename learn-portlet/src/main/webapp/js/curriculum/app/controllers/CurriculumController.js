function CurriculumController($scope, $http, $cookieStore, $log){
    function init() {
        $scope.achievements = [];
        $scope.availableAchievements = [];
        $scope.certificates = [];
        $scope.availableCertificates = [];
        $scope.tabs = [];

        // get data from cookies
        $scope.page = $cookieStore.get('curriculumPage');
        $scope.achievementPage = $cookieStore.get('curriculumAchievementPage');
        $scope.count = $cookieStore.get('curriculumCount');
        $scope.achievementSortAZ = $cookieStore.get('curriculumAchievementSortAZ');
        $scope.achievementFilter = $cookieStore.get('curriculumAchievementFilter');
        $scope.certificateSortAZ = $cookieStore.get('curriculumCertificateSortAZ');
        $scope.certificateFilter = $cookieStore.get('curriculumCertificateFilter');
        $scope.companyId = $cookieStore.get('COMPANY_ID');
        $scope.achievementSortLabel = $scope.sortOrderAscLabel;

        // on changed values save to cookies
        $scope.$watch('page', function(){
            $cookieStore.put('curriculumPage', $scope.page);
            $scope.getCertificates();
        });
        $scope.$watch('achievementPage', function(){
            $cookieStore.put('curriculumAchievementPage', $scope.achievementPage);
            $scope.getAchievements();
        });
        $scope.$watch('count', function(){
            $cookieStore.put('curriculumCount', $scope.count);
        });
        $scope.$watch('certificateSortAZ', function(){
            $cookieStore.put('curriculumCertificateSortAZ', $scope.certificateSortAZ);

            $scope.certificateSortLabel = $scope.certificateSortAZ
                ? $scope.sortOrderAscLabel
                : $scope.sortOrderDescLabel;
        });
        $scope.$watch('certificateFilter', function(){
            $cookieStore.put('curriculumCertificateFilter', $scope.certificateFilter);
        });
        $scope.$watch('achievementSortAZ', function(){
            $cookieStore.put('curriculumAchievementSortAZ', $scope.sortAZ);

            $scope.achievementSortLabel = $scope.achievementSortAZ
                ? $scope.sortOrderAscLabel
                : $scope.sortOrderDescLabel;
        });
        $scope.$watch('achievementFilter', function(){
            $cookieStore.put('curriculumAchievementFilter', $scope.achievementFilter);
        });

        $scope.$on('achievementTitleChanged', function(e, args) {
            var achievement = findAchievementById(args.id);
            if(!achievement)
                return;

            achievement.title = args.newTitle;
        })
        $scope.$on('achievementDescriptionChanged', function (e, args) {
            var achievement = findCertificateById(args.id);
            if(!achievement)
                return;

            achievement.description = args.newDescription;
        });
        $scope.$on('certificateTitleChanged', function(e, args) {
            var certificate = findCertificateById(args.id);
            if(!certificate)
                return;

            certificate.title = args.newTitle;
        })
        $scope.$on('certificateDescriptionChanged', function (e, args) {
            var certificate = findAchievementById(args.id);
            if(!certificate)
                return;

            certificate.description = args.newDescription;
        });
        $scope.$on('certificateCourseCountChanged', function (e, args) {
            var certificate = findAchievementById(args.id);
            if(!certificate)
                return;

            certificate.sitesCount = args.courseCount;
        });
        $scope.$on('certificateUserCountChanged', function (e, args) {
            var certificate = findAchievementById(args.id);
            if(!certificate)
                return;

            certificate.usersCount = args.usersCount;
        });

        // set default values if cookies empty
        if(!$scope.page)
            $scope.page = 1;
        if(!$scope.count)
            $scope.count = 10;
        if(!$scope.certificateSortAZ)
            $scope.certificateSortAZ = true;
        if(!$scope.achievementSortAZ)
            $scope.achievementSortAZ = true;
    }

    function findAchievementById(id) {
        var achievement = from($scope.achievements)
            .where('$.id == ' + id)
            .firstOrDefault();

        return achievement;
    }

    function findCertificateById(id) {
        var certificate = from($scope.certificates)
            .where('$.id == ' + id)
            .firstOrDefault();

        return certificate;
    }

    $scope.doCertificateSort = function () {
        $scope.certificateSortAZ = !$scope.certificateSortAZ;

        if($scope.certificateSortAZ)
            $scope.certificates = from($scope.availableCertificates)
                .orderBy("$title")
                .toArray();
        else
            $scope.certificates = from($scope.availableCertificates)
                .orderByDesc("$title")
                .toArray();
    }

    $scope.doCertificateFilter = function () {
        if($scope.certificateFilter)
            $scope.certificates = from($scope.availableCertificates)
                .where(function(item) {
                    return item.title.indexOf($scope.certificateFilter) != -1;
                })
                .toArray();
        else
            $scope.certificates = $scope.availableCertificates;

        $cookieStore.put('curriculumCertificateFilter', $scope.certificateFilter);
    }

    $scope.previousCertificatePage = function () {
        if($scope.page > 1) {
            $scope.page--;
        }
    }

    $scope.nextCertificatePage = function () {
        $scope.page++;
    }

    $scope.hasCertificates = function () {
        return $scope.certificates && $scope.certificates.length > 0;
    }

    $scope.getCertificates = function () {
        var url = '{0}services/certificating'
            .replace('{0}', Utils.getContextPath());

        $http
            .get(
            url,
            {
                params: {
                    companyID: $scope.companyId,
                    page: $scope.page,
                    count: $scope.count,
                    filter: $scope.filter,
                    sortAZ: $scope.certificateSortAZ
                }
            })
            .success(function(response){
                $scope.availableCertificates = response.records;
                $scope.certificates = $scope.availableCertificates;
            })
            .error(function(){

            });
    }

    $scope.addCertificate = function(){
        var url = '{0}services/certificating?companyID={1}'
            .replace('{0}', Utils.getContextPath())
            .replace('{1}', $scope.companyId);

        $http
            .post(url)
            .success(function(response){
                $scope.availableCertificates.push(response);
                $scope.certificates = $scope.availableCertificates;
            });
    }

    $scope.editCertificate = function(certificate) {
        var tab = {
            key: 'certificate_{0}'.replace('{0}', certificate.id),
            title: 'Edit: {0}'.replace('{0}', certificate.title),
            template: "certificateItemEditSites.html",
            certificate: {}
        }

        angular.copy(certificate, tab.certificate);

        if(jQuery1816Curriculum.inArray(tab, $scope.tabs) == -1)
            $scope.tabs.push(tab);
    }

    $scope.editCertificateUsers = function(certificate) {
        var tab = {
            key: 'certificate_{0}'.replace('{0}', certificate.id),
            title: 'Edit: {0}'.replace('{0}', certificate.title),
            template: "certificateUsersEditSites.html",
            certificate: {}
        }

        angular.copy(certificate, tab.certificate);

        if(jQuery1816Curriculum.inArray(tab, $scope.tabs) == -1)
            $scope.tabs.push(tab);
    }

    $scope.deleteCertificate = function (certificate) {
        var url = '{0}services/certificating/delete/{1}'
            .replace('{0}', Utils.getContextPath())
            .replace('{1}', certificate.id);

        $http
            .post(url)
            .success(function(response){
                $scope.availableCertificates.pop(certificate);
                $scope.certificates = $scope.availableCertificates;
            });
    }


    $scope.hasAchievements = function() {
        return $scope.achievements && $scope.achievements.length > 0;
    }

    $scope.getAchievements = function(){
        var url = '{0}services/achievement'
            .replace('{0}', Utils.getContextPath());

        $http
            .get(
            url,
            {
                params: {
                    companyID: $scope.companyId,
                    page: $scope.page,
                    count: $scope.count,
                    filter: $scope.achievementFilter,
                    sortAZ: $scope.achievementSortAZ
                }
            })
            .success(function(response){
                $scope.achievements = response;
                $scope.availableAchievements = response;
            })
            .error(function(){

            });
    }

    $scope.addAchievement = function(){
        var url = '{0}services/achievement?companyID={1}'
            .replace('{0}', Utils.getContextPath())
            .replace('{1}', $scope.companyId);

        $http
            .post(url)
            .success(function(response){
                $scope.achievements.push(response);
            });
    }

    $scope.editAchievement = function(achievement) {

        var tab = {
            key: 'achievement_{0}'.replace('{0}', achievement.id),
            title: 'Edit: {0}'.replace('{0}', achievement.title),
            template: "achievementItemEditSites.html",
            achievement: {}
        }

        angular.copy(achievement, tab.achievement);

        if(jQuery1816Curriculum.inArray(tab, $scope.tabs) == -1)
            $scope.tabs.push(tab);
    }

    $scope.editAchievementUsers = function() {
        $log.error('Not implemented exception: editAchievementUsers method');
    }

    $scope.doAchievementFilter = function () {
        if($scope.achievementFilter)
            $scope.achievements = from($scope.availableAchievements)
                .where(function(item) {
                    return item.title.indexOf($scope.achievementFilter) != -1;
                })
                .toArray();
        else
            $scope.achievements = $scope.availableAchievements;

        $cookieStore.put('curriculumAchievementFilter', $scope.achievementFilter);
    }

    $scope.doAchievementSort = function () {
        $scope.achievementSortAZ = !$scope.achievementSortAZ;

        if($scope.certificateSortAZ)
            $scope.achievements = from($scope.availableAchievements)
                .orderBy("$title")
                .toArray();
        else
            $scope.achievements = from($scope.availableAchievements)
                .orderByDesc("$title")
                .toArray();
    }

    $scope.deleteAchievement = function (achievement) {
        var url = '{0}services/achievement/delete/{1}'
            .replace('{0}', Utils.getContextPath())
            .replace('{1}', achievement.id);

        $scope.achievements.pop(achievement);

        $http
            .post(url)
            .success(function(response){
                $scope.achievements.pop(achievement);
            });
    }

    $scope.close = function(tab) {
        var index = $scope.tabs.indexOf(tab);
        $scope.tabs.splice(index, 1);
    }

    init();

    $scope.getCertificates();
    $scope.getAchievements();
}