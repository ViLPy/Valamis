var StudentStatementModel = Backbone.Model.extend({
    defaults: {}
});

StudentStatementModelCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function (collection, options) {
            return 'api/report?action=STUDENTS_LATEST_STATEMENTS&offset=' + (options.offset || 0)+ '&amount=' + (options.amount || 5);
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