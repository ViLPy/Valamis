/**
 * Created by iliya.tryapitsin on 27.01.14.
 */

describe("Curriculum controller", function() {

    var scope = null,
        http = null,
        window = null;

    beforeEach(module('curriculum'));

    beforeEach(inject(function($rootScope, $http, $window) {
       scope = $rootScope.$new(false);
        http = $http;
        window = $window;
    }));

    it("should be initialized", inject(function($controller) {
        var controller = $controller('CurriculumController', {
            '$scope': scope,
            '$http': http,
            '$window': window});

        expect(scope.tabs.length).toBe(0);   // Check opened tab count
    }));

    it("should open new tab for created achievement", inject(function($controller) {
        $controller('CurriculumController', {
            '$scope': scope,
            '$http': http,
            '$window': window
        });

        var tabCount = scope.tabs.length;

        scope.$emit('achievementEditing', {id: 1});
        expect(scope.tabs.length).toBe(tabCount + 1);   // Check opened tab count

        scope.$emit('achievementEditing', {id: 2});
        expect(scope.tabs.length).toBe(tabCount + 2);   // Check opened tab count
    }));

    it("should open new tab for editing achievement", inject(function($controller) {
        $controller('CurriculumController', {
            '$scope': scope,
            '$http': http,
            '$window': window
        });

        var tabCount = scope.tabs.length;

        scope.$emit('achievementEditing', {id: 1});
        expect(scope.tabs.length).toBe(tabCount + 1);   // Check opened tab count

        scope.$emit('achievementEditing', {id: 4});
        expect(scope.tabs.length).toBe(tabCount + 2);   // Check opened tab count

        scope.$emit('achievementEditing', {id: 5});
        expect(scope.tabs.length).toBe(tabCount + 3);   // Check opened tab count
    }));

    it("should open new tab for editing achievement users", inject(function($controller) {
        $controller('CurriculumController', {
            '$scope': scope,
            '$http': http,
            '$window': window
        });

        var tabCount = scope.tabs.length;

        scope.$emit('achievementUsersEditing', {id: 1});

        expect(scope.tabs.length).toBe(tabCount + 1);   // Check opened tab count
    }));

    it("should change tab title when achievement title changed", inject(function($controller) {
        $controller('CurriculumController', {
            '$scope': scope,
            '$http': http,
            '$window': window
        });

        var tabCount = scope.tabs.length;
        var achievement = {
            id: 1,
            title: 'Achievement title'
        };

        scope.$emit('achievementEditing', achievement);
        expect(scope.tabs.length).toBe(tabCount + 1);   // Check opened tab count

        achievement.title = "New achievement title";
        scope.$emit('achievementChanged', achievement);
        expect(scope.tabs.length).toBe(tabCount + 1);   // Check opened tab count

        var tab = scope.findAchievementTabById(achievement.id);
        expect(tab.title).toBe('Edit: {0}'.replace('{0}', achievement.title));   // Check tab title
    }));

    it("should close opened tab when achievement deleted", inject(function($controller) {
        $controller('CurriculumController', {
            '$scope': scope,
            '$http': http,
            '$window': window
        });

        var tabCount = scope.tabs.length;
        var achievement = {
            id: 1,
            title: 'Achievement title'
        };

        scope.$emit('achievementEditing', achievement);
        expect(scope.tabs.length).toBe(tabCount + 1);   // Check opened tab count

        achievement.title = "New achievement title";
        scope.$emit('achievementDeleted', achievement);
        expect(scope.tabs.length).toBe(tabCount);   // Check opened tab count
    }));

    it("should close opened tab when achievement deleted", inject(function($controller) {
        $controller('CurriculumController', {
            '$scope': scope,
            '$http': http,
            '$window': window
        });

        var tabCount = scope.tabs.length;
        var achievement = {
            id: 1,
            title: 'Achievement title'
        };

        scope.$emit('achievementEditing', achievement);
        expect(scope.tabs.length).toBe(tabCount + 1);   // Check opened tab count

        achievement.title = "New achievement title";
        scope.$emit('achievementDeleted', achievement);
        expect(scope.tabs.length).toBe(tabCount);   // Check opened tab count
    }));
});