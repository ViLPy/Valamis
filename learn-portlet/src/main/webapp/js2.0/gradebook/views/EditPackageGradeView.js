/**
 * Package grade edit.
 */

EditPackageGradeView = Backbone.View.extend({
    events: {
        "click .save-package-grade-button": "save"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQueryValamis('<div>');
        this.$el.attr("id", this.model.id);
    },

    render: function () {
        var template = Mustache.to_html(jQueryValamis("#editPackageGradeTemplate").html(), _.extend(this.model.toJSON(), language, {contextPath: Utils.getContextPath()}));
        this.$el.html(template);
        var gradeSelect = this.$('#totalGradeChoice');
        gradeSelect.empty();
        for (var i = 0; i <= 100; i += 10) {
            if (Math.abs(i - this.model.get('grade')) < 10)
                gradeSelect.append('<option selected value=' + i + '>' + i + '%</option>');
            else
                gradeSelect.append('<option value=' + i + '>' + i + '%</option>');
        }
        return this.$el;
    },

    save: function () {
        this.model.set('grade', this.$('#totalGradeChoice :selected').val());
        this.model.set('comment', this.$('#courseComment').val());

        // TODO: save data and trigger to update list
        this.model.saveGrade(
            {}
            ,{
                success: jQueryValamis.proxy(function (res) {
                    toastr.success(language['saveCompleted']);
                }, this),
                error: jQueryValamis.proxy(function (err, res) {
                    toastr.error(language['saveFailed']);
                }, this)
            });
        this.trigger('refreshPackageGrade');
    }
});
