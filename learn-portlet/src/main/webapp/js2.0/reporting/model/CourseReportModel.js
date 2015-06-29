var CourseReportTargets = {
    load: {
        path: path.api.report,
        'data': function (model) {
            if (jQuery1816Report('.select-scope').val() == 'instance')
                return {
                    action: 'COURSE',
                    scope: 'instance',
                    courseId: Utils.getCourseId()
                }

            else return {
                action: 'COURSE',
                courseId: Utils.getCourseId()
            }
        },
        method:'GET'
    }
};

CourseReportService = new Backbone.Service({ url: '/',targets: CourseReportTargets});

var CourseReportModel = Backbone.Model.extend({
    defaults: {
    }
}).extend(CourseReportService);