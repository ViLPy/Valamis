try {
  jQuery1816Curriculum = $.noConflict();
} catch(e) {}

var app = angular.module('curriculum', ['ngCookies', 'angularFileUpload', 'ngSanitize']);

app.config(['$provide', '$httpProvider', '$interpolateProvider',
    function ($provide, $httpProvider, $interpolateProvider) {

        // Because has conflict with mustache
        $interpolateProvider.startSymbol('[[');
        $interpolateProvider.endSymbol(']]');

        // from json to query string
        $httpProvider.defaults.transformRequest = function (data) {
            if (data === undefined) {
                return data;
            }
            return jQuery1816Curriculum.param(data);
        }

        // set to 'form data' for a post requests
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';

        $provide.factory('learningHttpInterceptor', ['$q', function ($q) {
            return {
                'request': function (config) {
                    return config || $q.when(config);
                },
                'requestError': function (rejection) {
                    return $q.reject(rejection);
                },
                'response': function (response) {
                    return response || $q.when(response);
                },
                'responseError': function (rejection) {
                    jQuery('#projectLearnGeneric').unblock();
                    jQuery.growlWarning(
                        localizedResources.overlayCreateQuizMessageLabel,
                        localizedResources.overlayFailedMessageLabel);
                    return $q.reject(rejection);
                }
            };
        }]);

        $httpProvider.interceptors.push('learningHttpInterceptor');
    }]);

app.run(['$rootScope', function ($rootScope) {
    angular.extend($rootScope, localizedResources);
}]);