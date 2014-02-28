/**
 * Created by iliya.tryapitsin on 28.01.14.
 */

describe("Edit achievement controller", function () {
    var scope = null,
        http = null,
        window = null,
        httpBackend = null,
        fileUploader = null,
        log = null,
        achievement = null,
        tab = null;

    beforeEach(module('curriculum'));

    beforeEach(inject(function ($rootScope, $http, $window, $httpBackend, $fileUploader, $log) {
        scope = $rootScope.$new(false);
        http = $http;
        window = $window;
        httpBackend = $httpBackend;
        fileUploader = $fileUploader;
        log = $log;

        scope.disabledTestMode = true;
        window.scormContextPath = "test";

        achievement = {
            id: 1,
            title: "Test achievement 1",
            logo: 'Test logo',
            description: 'test description',
            activities: [{
                id: 1,
                numberActivitiesRequired: 1,
                activityClassName: 'test class name',
                achievementId: 1}],
            users: []
        };

        scope.tabs = [];
        tab = {
            key: 'achievement_{0}'.replace('{0}', achievement.id),
            title: 'Edit: {0}'.replace('{0}', achievement.title),
            template: "achievementItemEditSites.html",
            achievement: achievement,
            isActive: true
        };
        scope.tabs.push(tab);
    }));

    it("should be initialized", inject(function ($controller) {
        $controller('EditAchievementController', {
            '$scope': scope,
            '$http': http,
            '$window': window,
            '$fileUploader': fileUploader,
            '$log': log
        });

        expect(scope.achievement).toEqual(achievement);   // Check achievement count
    }));

    it("should turn on edit title mode", inject(function ($controller) {
        $controller('EditAchievementController', {
            '$scope': scope,
            '$http': http,
            '$window': window,
            '$fileUploader': fileUploader,
            '$log': log
        });

        scope.editTitle();

        expect(scope.isEditingTitle).toBe(true);
        expect(scope.newTitle).toBe(scope.achievement.title);
    }));

    it("should turn off edit title mode and save changes", inject(function ($controller) {
        httpBackend
            .whenGET('test/services/activity/')
            .respond({data: {}});

        httpBackend
            .whenPOST('test/services/achievement/1')
            .respond();

        $controller('EditAchievementController', {
            '$scope': scope,
            '$http': http,
            '$window': window,
            '$fileUploader': fileUploader,
            '$log': log
        });

        httpBackend.flush();

        scope.newTitle = "new test title"

        scope.applyTitle();

        expect(scope.isEditingTitle).toBe(false);
        expect(scope.newTitle).toBe(scope.achievement.title);

        httpBackend
             .whenPOST('test/services/achievement/1')
             .respond();

         spyOn(scope, '$broadcast');

         httpBackend.flush();

         //expect(scope.$broadcast).toHaveBeenCalledWith('achievementChanged', scope.achievement);  // Check have been called achievementTitleChanged event
    }));

    it("should remove activity", inject(function ($controller) {
        httpBackend
            .whenGET('test/services/activity/')
            .respond({data: {}});

        httpBackend
            .whenPOST('test/services/achievement/1')
            .respond();

        $controller('EditAchievementController', {
            '$scope': scope,
            '$http': http,
            '$window': window,
            '$fileUploader': fileUploader,
            '$log': log
        });

        httpBackend.flush();

        httpBackend
            .whenPOST('test/services/achievement/activity/1')
            .respond();

        var activityCount = scope.achievement.activities.length;

        scope.removeActivity(scope.achievement.activities[0]);

        httpBackend.flush();

        expect(scope.achievement.activities.length).toBe(activityCount - 1);
    }));

    it("should change required activities count", inject(function ($controller) {
        httpBackend
            .whenGET('test/services/activity/')
            .respond({data: {}});

        httpBackend
            .whenPOST('test/services/achievement/1')
            .respond();

        $controller('EditAchievementController', {
            '$scope': scope,
            '$http': http,
            '$window': window,
            '$fileUploader': fileUploader,
            '$log': log
        });

        httpBackend.flush();

        httpBackend
            .whenPOST('test/services/achievement/activity/1')
            .respond();

        scope.requiredActivityNumberChanged(scope.achievement.activities[0]);

        httpBackend.flush();
    }));
});
