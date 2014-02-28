var StatementModel = Backbone.Model.extend({
    defaults: {}
});

StatementModelCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function (collection, options) {
            return '/services/reporting/tincan/getUserLatestStatements?offset=' + (options.offset || 0)+ '&amount=' + (options.amount || 5);
        }
    }
});

var StatementModelCollection = Backbone.Collection.extend({
    model: StatementModel,
    parse: function(data) {
        if (_.isObject(data.statementData)) {
            this.trigger('update:statementCollection', {totalStatements: data.totalStatements, currentPage: data.currentPage});
            return data.statementData;
        } else {
            return data;
        }
    }
}).extend(StatementModelCollectionService);