var TinCanOverallByTimeModelService = new Backbone.Service({ url: '/',
    sync: {
        'read': {
            path: path.api.report,
            'data': function () {
                return {
                    action: 'OVERALL_BY_TIME'
                }
            },
            'method': 'get'
        }
    }
});

/*
 startedData - data is like - [{date: 1231231, name: "Foo Bar"}]
 passed data has also a score attribute
 */
var TinCanOverallByTimeModel = Backbone.Model.extend({
    defaults: {
        startedData: [],
        completedData: [],
        experiencedData: [],
        averageScore: 0
    }
}).extend(TinCanOverallByTimeModelService);