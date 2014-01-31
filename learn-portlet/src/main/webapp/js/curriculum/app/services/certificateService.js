app.factory('certificateService', ['$resource', function($resource){
    this.get  = function(companyId, page, count, filter, certificateSortAZ){
        var url = '{0}services/certificating'
            .replace('{0}', Utils.getContextPath());

        $http
            .get(
            url,
            {
                params: {
                    companyID: companyId,
                    page: page,
                    count: count,
                    filter: filter,
                    sortAZ: certificateSortAZ
                }
            })
            .success(function(response){
                $scope.availableCertificates = response.records;
                $scope.certificates = $scope.availableCertificates;
            })
            .error(function(){

            });
    };

    this.getById = function (id){
        var url = '{0}services/certificating/{1}'
            .replace('{0}', Utils.getContextPath())
            .replace('{1}', id);

        $http
            .get(url)
            .success(function(response){
                $scope.certificate = response;
            });
    }
}]);
