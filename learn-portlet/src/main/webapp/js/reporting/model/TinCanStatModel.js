var TinCanOverallByTimeModelService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': "/services/reporting/tincan/completionInformation/overallByTime"
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
        passedData: [],
        averageScore: 0
    }
}).extend(TinCanOverallByTimeModelService);