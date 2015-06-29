/**
 * Total course grade edit.
 */

EditGradeView = Backbone.View.extend({
    events: {
        "click .save-total-grade-button": "save"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQueryValamis('<div>');
        this.$el.attr("id", this.model.id);
        this.model.loadTotalGrade({}, {
            success: jQueryValamis.proxy(function (res) {
                this.model.set('gradeTotal',res.value);
                this.model.set('commentTotal',res.comment);
                this.render();
            }, this),
            error: function (err, res) {
                // do something in case of an error
            }
        });
    },

    render: function () {
        var template = Mustache.to_html(jQueryValamis("#editTotalGradeTemplate").html(), _.extend(this.model.toJSON(), language));
        this.$el.html(template);
        var gradeSelect = this.$('#totalGradeChoice');
        gradeSelect.empty();
        for (var i = 0; i <= 100; i += 10) {
            if (Math.abs(i - this.model.get('gradeTotal')) < 10)
                gradeSelect.append('<option selected value=' + i + '>' + i + '%</option>');
            else
                gradeSelect.append('<option value=' + i + '>' + i + '%</option>');
        }
        return this.$el;
    },

    save: function () {
        this.model.set('gradeTotal', this.$('#totalGradeChoice :selected').val());
        this.model.set('commentTotal', this.$('#courseComment').val());

        // TODO: save data and trigger to update list
        this.model.saveTotalGrade({},{
                success: jQueryValamis.proxy(function (res) {
                    toastr.success(language['saveCompleted']);
                }, this),
                error: jQueryValamis.proxy(function (err, res) {
                    toastr.error(language['saveFailed']);
                }, this)
        });
        this.trigger('refreshTotalGrade');
    }
});

