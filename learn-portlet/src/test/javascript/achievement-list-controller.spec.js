/**
 * Created by iliya.tryapitsin on 27.01.14.
 */

describe("Achievement list controller", function () {
    var scope = null,
        http = null,
        window = null,
        httpBackend = null;

    beforeEach(module('curriculum'));

    beforeEach(inject(function ($rootScope, $http, $window, $httpBackend) {
        scope = $rootScope.$new(false);
        http = $http;
        window = $window;
        httpBackend = $httpBackend;

        window.scormContextPath = "test";
        window.companyID = 1;
    }));

    /*function getUrlVars(url) {
        var hash;
        var myJson = {};
        var hashes = url.slice(url.indexOf('?') + 1).split('&');
        for (var i = 0; i < hashes.length; i++) {
            hash = hashes[i].split('=');
            myJson[hash[0]] = hash[1];
        }
        return myJson;
    }

    function unorderedArgs(url, params) {
        return {
            test: function (requestedUrl) {
                // check the base url (i.g. /some/url)
                if (requestedUrl.indexOf(url) !== 0) return false;
                var urlEncodedArgs = requestedUrl.substr(url.length);
                return angular.equals(params, getUrlVars(urlEncodedArgs));
            }
        };
    }*/

    it("should be initialized", inject(function ($controller) {
        $controller('AchievementListController', {
            '$scope': scope,
            '$http': http,
            '$window': window});

        var achievementList = [
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'},
            {id: 4, title: 'Achievement 4'}
        ];

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&page=1&sortAZ=true')
            .respond({records: achievementList});

        httpBackend.flush();

        expect(scope.achievements.records.length).toBe(achievementList.length);   // Check achievement count
        expect(scope.achievementSortLabel).toBe(localizedResources.sortOrderAscLabel);   // Check achievement sort label
    }));

    it("should return TRUE for hasAchievements method", inject(function ($controller) {
        $controller('AchievementListController', {
            '$scope': scope,
            '$http': http,
            '$window': window});

        var achievementList = [
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'},
            {id: 4, title: 'Achievement 4'}
        ];

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&page=1&sortAZ=true')
            .respond({records: achievementList});

        httpBackend.flush();

        expect(scope.hasAchievements()).toBe(true);   // Check has achievements
    }));

    it("should add achievement", inject(function ($controller) {
        $controller('AchievementListController', {
            '$scope': scope,
            '$http': http,
            '$window': window});
        var newAchievement = { id: 5, title: 'Achievement 5' };

        var achievementList = [
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'},
            {id: 4, title: 'Achievement 4'},
            newAchievement
        ];

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&page=1&sortAZ=true')
            .respond({records: achievementList});

        httpBackend
            .whenPOST('test/services/achievement?companyID=1')
            .respond({data: newAchievement});

        spyOn(scope, '$emit');

        scope.addAchievement()

        httpBackend.flush();

        expect(scope.achievements.records.length).toBe(achievementList.length);   // Check achievement count
        expect(scope.$emit).toHaveBeenCalledWith('achievementEditing', newAchievement);  // Check have been called achievementEditing event

    }));

    it("should edit achievement users", inject(function ($controller) {
        $controller('AchievementListController', {
            '$scope': scope,
            '$http': http,
            '$window': window});

        var achievementList = [
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'},
            {id: 4, title: 'Achievement 4'},
        ];

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&page=1&sortAZ=true')
            .respond({records: achievementList});

        spyOn(scope, '$emit');

        scope.editAchievementUsers(achievementList[2]);

        httpBackend.flush();

        expect(scope.$emit).toHaveBeenCalledWith('achievementUsersEditing', achievementList[2]);  // Check have been called achievementUsersEditing event

    }));

    it("should delete achievement", inject(function ($controller) {
        $controller('AchievementListController', {
            '$scope': scope,
            '$http': http,
            '$window': window});

        var achievementList = [
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'}
        ];

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&page=1&sortAZ=true')
            .respond({records: achievementList});

        httpBackend
            .whenPOST('test/services/achievement/delete/4')
            .respond();

        spyOn(scope, '$emit');

        scope.deleteAchievement({id: 4, title: 'Achievement 4'})

        httpBackend.flush();

        expect(scope.achievements.records.length).toBe(achievementList.length);   // Check achievement count
        expect(scope.$emit).toHaveBeenCalledWith('achievementDeleted', {id: 4, title: 'Achievement 4'});  // Check have been called achievementEditing event
    }));

    it("should sort achievements", inject(function ($controller) {
        $controller('AchievementListController', {
            '$scope': scope,
            '$http': http,
            '$window': window});

        var achievementList = [
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'}
        ];

        var sortedAchievementList = from(achievementList)
            .orderBy()
            .toArray();

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&page=1&sortAZ=true')
            .respond({records: achievementList});

        httpBackend.flush();

        expect(scope.achievements.records.length).toBe(achievementList.length);   // Check achievement count

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&page=1&sortAZ=false')
            .respond({ records: sortedAchievementList });

        scope.achievementSort();

        httpBackend.flush();

        expect(scope.achievements.records).toEqual(sortedAchievementList);
    }));

    it("should filtered achievements", inject(function ($controller) {
        $controller('AchievementListController', {
            '$scope': scope,
            '$http': http,
            '$window': window});

        var achievementList = [
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'}
        ];

        var filteredAchievementList = [achievementList[1]];

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&page=1&sortAZ=true')
            .respond({records: achievementList});

        httpBackend.flush();

        expect(scope.achievements.records.length).toBe(achievementList.length);   // Check achievement count

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&filter=Achievement+2&page=1&sortAZ=true')
            .respond({
                records: filteredAchievementList
            });

        scope.achievementFilter = "Achievement 2"
        scope.achievementFiltering();

        httpBackend.flush();

        expect(scope.achievements.records).toEqual(filteredAchievementList);
    }));

    it("should check is show pager", inject(function ($controller) {
        $controller('AchievementListController', {
            '$scope': scope,
            '$http': http,
            '$window': window});

        var achievementList = [
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'}
        ];

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=10&page=1&sortAZ=true')
            .respond({records: achievementList, total: 3});

        httpBackend.flush();

        expect(scope.achievements.records.length).toBe(achievementList.length);   // Check achievement count

        expect(scope.isShowPager()).toBe(false);

        var newAchievementList = [
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'},
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'},
            {id: 1, title: 'Achievement 1'},
            {id: 2, title: 'Achievement 2'},
            {id: 3, title: 'Achievement 3'},
        ];

        httpBackend
            .whenGET('test/services/achievement?companyID=1&count=9&page=1&sortAZ=true')
            .respond({records: newAchievementList, total: 21});

        scope.count = 9;

        scope.getAchievements();

        httpBackend.flush();

        expect(scope.achievements.records.length).toBe(newAchievementList.length);   // Check achievement count

        expect(scope.isShowPager()).toBe(true);
    }));
});