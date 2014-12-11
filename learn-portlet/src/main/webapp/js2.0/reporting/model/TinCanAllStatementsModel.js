var TinCanOverallByPeriodModelService = new Backbone.Service({ url: '/',
    sync: {
        'read': function(model, params){
            var getUTCTime = function(date) {
                return date.getTime() - (date.getTimezoneOffset() * 60000)
            };

            return path.api.report + "?action=OVERALL_BY_PERIOD&period=" + params.period +
                '&from=' + getUTCTime(params.from) +
                '&to=' + getUTCTime(params.to);
        }
    }
});

var TinCanOverallByPeriodModel = Backbone.Model.extend({
    defaults: {
        startedData: [],
        completedData: [],
        passedData: [],
        averageScore: 0
    }
}).extend(TinCanOverallByPeriodModelService);