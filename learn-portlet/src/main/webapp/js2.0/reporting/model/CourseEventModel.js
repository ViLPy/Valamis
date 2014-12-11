var CourseEventModelService = new Backbone.Service({ url: '/',
    sync: {
        'read': function (model, params) {
            var getUTCTime = function (date) {
                return date.getTime() - (date.getTimezoneOffset() * 60000)
            };

            return path.api.report + "?action=COURSE_EVENT" +
                "&groupBy=" + params.groupBy +
                "&groupPeriod=" + params.groupPeriod +
                "&period=" + params.period +
                '&from=' + getUTCTime(params.from) +
                '&to=' + getUTCTime(params.to);
        }
    }
});

var CourseEventModel = Backbone.Model.extend({
    defaults: {
        completionsCount: 0,
        enrollmentsCount: 0,
        groupName: ''
    }
})

var CourseEventModelCollection = Backbone.Collection.extend({
    model: CourseEventModel
}).extend(CourseEventModelService);