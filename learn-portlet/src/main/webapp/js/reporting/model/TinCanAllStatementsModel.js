var TinCanOverallByPeriodModelService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function(model, params){
            var getUTCTime = function(date) {
                return date.getTime() - (date.getTimezoneOffset() * 60000)
            };

            return "/services/reporting/tincan/statementInformation/overallBy/" + params.period +
                '/from/' + getUTCTime(params.from) +
                '/to/' + getUTCTime(params.to);
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