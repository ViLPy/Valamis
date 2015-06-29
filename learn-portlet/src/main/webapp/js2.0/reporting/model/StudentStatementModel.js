var StudentStatementModel = Backbone.Model.extend({
    defaults: {}
});

StudentStatementModelCollectionService = new Backbone.Service({ url: '/',
    sync: {
        'read': {
            path: path.api.report,
            'data': function (collection, options) {
                return {
                    action: 'STUDENTS_LATEST_STATEMENTS',
                    courseId: Utils.getCourseId(),
                    offset: (options.offset || 0),
                    amount: (options.amount || 5)
                }
            },
            'method': 'get'

        }
    }
});

var StudentStatementModelCollection = Backbone.Collection.extend({
    model: StudentStatementModel,
    parse: function(data) {
        if (_.isObject(data.records)) {
            this.trigger('update:statementCollection', {totalStatements: data.total, currentPage: data.page});
            return data.records;
        } else {
            return data;
        }
    }
}).extend(StudentStatementModelCollectionService);