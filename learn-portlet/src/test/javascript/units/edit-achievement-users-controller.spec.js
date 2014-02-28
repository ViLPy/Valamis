/**
 * Created by iliya.tryapitsin on 29.01.14.
 */

describe("Edit achievement users controller", function () {
    var scope = null,
        http = null,
        window = null,
        httpBackend = null,
        achievement = null,
        tab = null;

    beforeEach(module('curriculum'));

    beforeEach(inject(function ($rootScope, $http, $window, $httpBackend) {
        scope = $rootScope.$new(false);
        http = $http;
        window = $window;
        httpBackend = $httpBackend;

        scope.disabledTestMode = true;
        window.scormContextPath = "test";
        window.users = [{
            id: 1,
            login: "Test user 1",
            name: "Test Name1"
        }, {
            id: 2,
            login: "Test user 2",
            name: "Test Name2"
        },{
            id: 3,
            login: "Test user 3",
            name: "Test Name3"
        }, {
            id: 4,
            login: "Test user 4",
            name: "Test Name4"
        }]

        achievement = {
            id: 1,
            title: "Test achievement 1",
            logo: 'Test logo',
            description: 'test description',
            users: [{
                id: 1,
                login: "Test user 1",
                name: "Test Name1"
            }, {
                id: 2,
                login: "Test user 2",
                name: "Test Name2"
            }]
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
        $controller('EditAchievementUsersController', {
            '$scope': scope,
            '$http': http,
            '$window': window
        });

        expect(scope.achievement).toEqual(achievement);   // Check achievement count
        expect(scope.achievement.users).toEqual(achievement.users);

    }));
});
