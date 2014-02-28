/**
 * Created by iliya.tryapitsin on 30.01.14.
 */

function achievementResponseModel(id, title, description, logo, users, activities) {
    this.id = id,
        this.title = title,
        this.description = description,
        this.logo = logo,
        this.users = users,
        this.activities = activities;
}

function generalResponseModel(data, isSuccess, message) {
    this.data = data,
        this.isSuccess = isSuccess,
        this.message = message;
}

function achievementDataSource() {
    var self = this;

    this.data = [];

    for (var i = 1; i < 16; i++) {
        this.data.push(
            new achievementResponseModel(i,
                "Test title {0}".replace('{0}', i),
                "Test description {0}".replace('{0}', i),
                "/learn-portlet/services/openbadges?directory={0}&fileName=icon.png".replace('{0}', i),
                [],
                []))
    }

    function applyFilter(filter) {
        var enumerator = from(self.data);

        if (filter && filter != "")
            enumerator = enumerator.where(function (item) {
                return item.title.indexOf(filter) != -1;
            });

        return enumerator;
    }

    function find(page, count, filter) {
        return applyFilter(filter)
            .skip((page - 1) * count)
            .take(count)
    }

    this.take = function (page, count, filter, sortByDesc) {
        return sortByDesc
            ? find(page, count, filter)
            .orderBy()
            .toArray()

            : find(page, count, filter)
            .orderByDesc()
            .toArray();
    }

    this.addAchievement = function() {
        var newAchievement = new achievementResponseModel(
            self.data.length,
            "Test title {0}".replace('{0}', self.data.length),
            "Test description {0}".replace('{0}', self.data.length),
            "/learn-portlet/services/openbadges?directory={0}&fileName=icon.png".replace('{0}', self.data.length),
            [],
            []);

        this.data.push(newAchievement);

        return newAchievement;
    }

    this.totalPages = function (count, filter) {
        var data = applyFilter(filter)
            .toArray();

        var result = Math.round(data.length / count);
        if ((data.length % count) > 0 && (data.length % count) < 5)
            result++;
        return result;
    }

}

function achievementWebServiceMock(injector) {
    var self = this;
    var httpBackend = injector.get('$httpBackend');
    var window = injector.get('$window');
    var dataSource = new achievementDataSource();

    this.dataSource = dataSource;

    this.mockGetAchievementRequest = function (companyId, page, count, sortByDesc, filter) {
        httpBackend
            .whenGET('{0}/services/achievement?action={1}&companyID={2}&count={3}&page={4}&sortAZ={6}'
                .replace('{0}', window.scormContextPath)
                .replace('{1}', "all")
                .replace('{2}', companyId)
                .replace('{3}', count)
                .replace('{4}', page)
                .replace('{5}', filter)
                .replace('{6}', sortByDesc))
            .respond({
                page: page,
                records: dataSource.take(page, count, filter, sortByDesc),
                total: dataSource.data.length
            });

        httpBackend
            .expectGET('{0}/services/achievement?action={1}&companyID={2}&count={3}&page={4}&sortAZ={6}'
                .replace('{0}', window.scormContextPath)
                .replace('{1}', "all")
                .replace('{2}', companyId)
                .replace('{3}', count)
                .replace('{4}', page)
                .replace('{5}', filter)
                .replace('{6}', sortByDesc));

        return httpBackend;
    }

    this.mockAddAchievementRequest = function (companyId) {

        httpBackend
            .expectPOST('{0}/services/achievement?companyID={1}'
                .replace('{0}', window.scormContextPath)
                .replace('{1}', companyId))
            .respond(
                new generalResponseModel(
                    self.dataSource.addAchievement(),
                    true,
                    ""))

        return httpBackend;
    }

    this.mockUpdateAchievementRequest = function () {

        httpBackend
            .expectPOST(
            '{0}/services/achievement'.replace('{0}', window.scormContextPath),
            {
                companyId: companyId,
                count: count,
                page: page,
                sortByDesc: sortByDesc,
                //achievementId:
            })
            .respond();

        return httpBackend;
    }
}