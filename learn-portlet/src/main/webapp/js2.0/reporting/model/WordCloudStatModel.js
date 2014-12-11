var WordCloudStatModelService = new Backbone.Service({ url: '/',
    sync: {
        'read': path.api.report + "?action=STATEMENT_VERBS"
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