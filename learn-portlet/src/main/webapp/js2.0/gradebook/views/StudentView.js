/* Student table row for package*/
StudentTableRowView = Backbone.View.extend({
    events: {
        "click .expand-col > .expand-icon": "expand",
        "click .edit-button": "editGrade"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQuery('<tr>');
        this.$el.attr("id", this.model.id);
        var statementResult = JSON.parse(this.model.get('statements'));
        if (statementResult.statements.length > 0) {
            this.$el.addClass('expand');
            this.tableView = new StudentPackageTableView({
                language: this.options.language,
                model: statementResult
            });
        }
        //this.activities = new StudentGradesCollection(this.model.get('activities'));
    },

    render: function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#studentViewTablePackageRowTemplate").html(), _.extend(this.model.toJSON(), language));
        this.$el.html(template);

        return this.$el;
    },

    expand: function () {
        if (this.tableView == null)
            return;

        if (this.$el.hasClass('expand')) {
            this.tableView.$el.show(300);
        }
        else {
            this.tableView.$el.hide(300);
        }
        this.$el.toggleClass('expand').toggleClass('collapse');
    },

    // Edit package grade modal
    editGrade: function () {
        var view = new EditPackageGradeView({
            $el: jQuery('.edit-package-grade-view-dialog'),
            model: this.model,
            language: this.language
        });
        view.on('refreshPackageGrade', jQuery1816Gradebook.proxy(function () {
            this.render();
            this.trigger('refreshTotalGrade');
        }, this));

        myLayout.modals.show(new EditPackageGradeViewModal({view: view}));
    }
});

StudentView = Backbone.View.extend({
    events: {
        "click .edit-total-grade": "showEditGradeView"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQuery('<div>');
        this.$el.attr("id", this.model.id);
        this.collection = new StudentGradesCollection();

        this.model.loadStudentInfo({
            studentId: this.model.id,
            courseId: jQuery1816Gradebook('#courseID').val(),
            page: '0',
            count: '10',
            sortAscDirection: 'true'
        }, {
            success: jQuery1816Gradebook.proxy(function (res) {
                this.model = new GradebookStudentModel(res);
                this.collection = new StudentGradesCollection(res.packageGrades);
                //this.collection.parse(res.packageGrades);
                this.render();
            }, this),
            error: function (err, res) {
                // do something in case of an error
                toastr.error(language['loadFailed']);
            }
        });
    },

    render: function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#studentViewTemplate").html(), _.extend(this.model.toJSON(), language));
        //this.studentGradeList = this.$("#studentGradeGrid").List();
        this.$el.html(template);
        this.addGradesFromCollection();
        return this.$el;
    },

    addGrade: function (grade) {
        grade.set('studentId', this.model.id);
        var view = new StudentTableRowView({
            model: grade,
            language: this.options.language,
            isActivity: false
        });
        view.on('refreshTotalGrade', jQuery1816Gradebook.proxy(function () {
            var countCompleted = 0;
            this.collection.each(function (grade) {
                if (grade.get('grade') != 0) countCompleted++;
            }, this)
            this.model.set('completedPackagesCount', countCompleted);
            this.trigger('refreshTotalGrade', this);

        }, this));
        var renderedView = view.render();
        //var gradeJSON = grade.toJSON();
        var filterData = {};
        // this.studentGradeList.add(grade.id, renderedView, filterData);
        this.$("#studentGradeGrid").append(renderedView);
        if (view.tableView) {
            var templateTable = view.tableView.render();
            this.$("#studentGradeGrid").append(templateTable);
        }
    },

    addGradesFromCollection: function () {
        this.$("#studentGradeGrid").empty();
        this.collection.each(this.addGrade, this);
    },

    // Edit total grade modal
    showEditGradeView: function () {
        var view = new EditGradeView({
            model: this.model,
            language: this.language
        });
        view.on('refreshTotalGrade', jQuery1816Gradebook.proxy(function () {
            this.render();
            this.trigger('refreshTotalGrade', this);
        }, this));
        myLayout.modals.show(new EditGradeViewModal({view: view}));
    }
});


