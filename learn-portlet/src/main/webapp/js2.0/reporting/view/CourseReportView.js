/*
 * Course report view with statistic data within course or within instance's courses
 * READONLY View*/

CourseReportView = Backbone.View.extend({
    events: {
        "change .select-scope": "onScopeChange"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQueryValamis('.reportBody');
        var templateFilter = Mustache.to_html(jQueryValamis("#reportFilter").html(), _.extend(this.model.toJSON(), language));
        this.$('.sidebar-wrapper').append(templateFilter);
        this.onScopeChange();
    },

    loadView: function () {
        var template = Mustache.to_html(jQueryValamis("#loadingViewTemplate").html(), language);
        this.$('.report-content').html(template);
    },

    render: function () {
        var result = new Object();
        result.studentsUnknownPercentage = this.model.get('studentsCount')?(this.model.get('studentsUnknownCount') * 100 / this.model.get('studentsCount')).toFixed(0):0;
        result.studentsIncompletedPercentage = this.model.get('studentsCount')?(this.model.get('studentsIncompletedCount') * 100 / this.model.get('studentsCount')).toFixed(0):0;
        result.studentsCompletedPercentage = this.model.get('studentsCount')?(this.model.get('studentsCompletedCount') * 100 / this.model.get('studentsCount')).toFixed(0):0;
        result.studentsFailedPercentage = this.model.get('studentsCount')?(this.model.get('studentsFailedCount') * 100 / this.model.get('studentsCount')).toFixed(0):0;
        result.studentsPassedPercentage = this.model.get('studentsCount')?(this.model.get('studentsPassedCount') * 100 / this.model.get('studentsCount')).toFixed(0):0;
        var template = Mustache.to_html(jQueryValamis("#courseViewTemplate").html(), _.extend(this.model.toJSON(), language, result));

        this.$('.report-content').html(template);

        return this.$el;
    },

    onScopeChange:function() {
        //model.set('scope', this.$('.select-scope').val())
        this.loadView();
        this.model.load({}, {
            success: jQueryValamis.proxy(function (res) {
                this.model = new CourseReportModel(res);
                this.render();
            }, this),
            error: function (err, res) {
                // do something in case of an error
                toastr.error(language['loadFailed']);
            }
        });
    }
});