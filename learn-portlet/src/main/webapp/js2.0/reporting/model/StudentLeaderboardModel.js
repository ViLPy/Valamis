var StudentLeaderboardModel = Backbone.Model.extend({
    defaults: {}
});

StudentLeaderboardModelCollectionService = new Backbone.Service({ url: '/',
    sync: {
        'read': {
            path: path.api.report,
            'data': function (collection, options) {
                return {
                    action: 'LEADERBOARD',
                    courseId: Utils.getCourseId(),
                    period:jQueryValamis('.show-mode').val(),
                    offset: (options.offset || 0),
                    amount: (options.amount || 5)
                }
            },
            'method': 'get'

        }
    }
});

var StudentLeaderboardModelCollection = Backbone.Collection.extend({
    model: StudentLeaderboardModel,
    parse: function(data) {
        if (_.isObject(data.records)) {
            this.trigger('update:statementCollection', {totalStatements: data.total, currentPage: data.page});
            return data.records;
        } else {
            return data;
        }
    }
}).extend(StudentLeaderboardModelCollectionService);