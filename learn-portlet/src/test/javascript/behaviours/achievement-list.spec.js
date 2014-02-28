/**
 * Created by iliya.tryapitsin on 30.01.14.
 */

describe("Achievement list workflow", function () {
    var scope = null,
        http = null,
        window = null;

    beforeEach(module('curriculum'));
    beforeEach(inject(function ($rootScope, $http, $window) {
        scope = $rootScope.$new(false);
        http = $http;
        window = $window;

        window.scormContextPath = "test";
        window.companyID = 1;
    }));

    it("paging", inject(function($injector, $controller){
        var _achievementWebServiceMock = new achievementWebServiceMock($injector);
        $controller('AchievementListController', {
            '$scope': scope,
            '$http': http,
            '$window': window});

        var request = _achievementWebServiceMock.mockGetAchievementRequest(
            window.companyID,
            scope.achievementPage,
            scope.count,
            scope.achievementSortAZ,
            scope.achievementFilter)

        request.flush();

        var real = _achievementWebServiceMock.dataSource.take(
            scope.achievementPage,
            scope.count,
            scope.achievementFilter,
            scope.achievementSortAZ);

        expect(scope.achievements.records.length).not.toBe(0);
        expect(scope.achievements.records.length).toBe(real.length);
        expect(scope.achievements.records).toEqual(real);
        expect(scope.isFirstPage()).toBe(true);
        expect(scope.isLastPage()).toBe(false);
        expect(scope.totalPages()).toBe(_achievementWebServiceMock.dataSource.totalPages(scope.count));

        // change to second page
        scope.achievementPage = 2;

        var request = _achievementWebServiceMock.mockGetAchievementRequest(
            window.companyID,
            scope.achievementPage,
            scope.count,
            scope.achievementSortAZ,
            scope.achievementFilter)

        request.flush();

        var real = _achievementWebServiceMock.dataSource.take(
            scope.achievementPage,
            scope.count,
            scope.achievementFilter,
            scope.achievementSortAZ);

        expect(scope.achievements.records.length).not.toBe(0);
        expect(scope.achievements.records.length).toBe(real.length);
        expect(scope.achievements.records).toEqual(real);
        expect(scope.isFirstPage()).toBe(false);
        expect(scope.isLastPage()).toBe(true);
        expect(scope.totalPages()).toBe(2);

        // change to first page
        scope.achievementPage = 1;

        var request = _achievementWebServiceMock.mockGetAchievementRequest(
            window.companyID,
            scope.achievementPage,
            scope.count,
            scope.achievementSortAZ,
            scope.achievementFilter)

        request.flush();

        var real = _achievementWebServiceMock.dataSource.take(
            scope.achievementPage,
            scope.count,
            scope.achievementFilter,
            scope.achievementSortAZ);

        expect(scope.achievements.records.length).not.toBe(0);
        expect(scope.achievements.records.length).toBe(real.length);
        expect(scope.achievements.records).toEqual(real);
        expect(scope.isFirstPage()).toBe(true);
        expect(scope.isLastPage()).toBe(false);
        expect(scope.totalPages()).toBe(2);
    }));

    it("add new achievement", inject(function($injector, $controller){

    }));
});
