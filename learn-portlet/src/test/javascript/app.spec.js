/**
 * Created by iliya.tryapitsin on 27.01.14.
 */
describe("Achievement app", function() {

    beforeEach(module('curriculum'));

    it("should initialize settings", inject(function($rootScope, $http, $interpolate) {
        expect($rootScope.overlayCreateQuizMessageLabel).toBe(localizedResources.overlayCreateQuizMessageLabel);
        expect($rootScope.overlayFailedMessageLabel).toBe(localizedResources.overlayFailedMessageLabel);
        expect($http.defaults.headers.post['Content-Type']).toBe('application/x-www-form-urlencoded; charset=UTF-8');
        expect($http.defaults.transformRequest({test: 'test1', test2: 'test2'})).toBe('test=test1&test2=test2');
        expect($interpolate.startSymbol()).toBe('[[');
        expect($interpolate.endSymbol()).toBe(']]');
    }));

    it("should be learningHttpInterceptor", function() {
        var httpProvider = null;

        module(function($httpProvider) {
            httpProvider = $httpProvider;
        });

        inject(function() {
            expect(httpProvider.interceptors).toContain("learningHttpInterceptor")
        });
    })
});