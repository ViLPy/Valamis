var StudentMostActiveModel = Backbone.Model.extend({
    defaults: {}
});

StudentMostActiveModelCollectionService = new Backbone.Service({ url: '/',
    sync: {
        'read': {
            path: path.api.report,
            'data': function (collection, options) {
                return {
                    action: 'MOST_ACTIVE_USERS',
                    courseId: Utils.getCourseId(),
                    offset: (options.offset || 0),
                    amount: (options.amount || 5)
                }
            },
            'method': 'get'
        }
    }
});

var StudentMostActiveModelCollection = Backbone.Collection.extend({
    model: StudentMostActiveModel,
    parse: function(data) {
        if (_.isObject(data.records)) {
            this.trigger('update:statementCollection', {totalStatements: data.total, currentPage: data.page});
            return data.records;
        } else {
            return data;
        }
    }
}).extend(StudentMostActiveModelCollectionService);