var WordCloudStatModelService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': "api/report?action=STATEMENT_VERBS"
    }
});

/*
 startedData - data is like - [{date: 1231231, name: "Foo Bar"}]
 passed data has also a score attribute
 */
var WordCloudStatModel = Backbone.Model.extend({
    defaults: {
        data: {}
    }
}).extend(WordCloudStatModelService);