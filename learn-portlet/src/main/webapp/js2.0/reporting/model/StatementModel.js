var StatementModel = Backbone.Model.extend({
    defaults: {}
});

StatementModelCollectionService = new Backbone.Service({ url: '/',
    sync: {
        'read':{
            path: path.api.report,
            'data': function (collection, options) {
                return {
                    action: 'USER_LATEST_STATEMENTS',
                    offset: (options.offset || 0),
                    amount: (options.amount || 5)
                }
            },
            'method': 'get'
        }
    }
});

var StatementModelCollection = Backbone.Collection.extend({
    model: StatementModel,
    parse: function (data) {
        if (_.isObject(data.records)) {
            this.trigger('update:statementCollection', {totalStatements: data.total, currentPage: data.page});
            return data.records;
        } else {
            return data;
        }
    }
}).extend(StatementModelCollectionService);