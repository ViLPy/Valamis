/* Student table row for package*/
StudentTableRowView = Backbone.View.extend({
    events: {
        "click .expand-col > .expand-icon": "expand",
        "click .edit-button": "editGrade"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQueryValamis('<tr>');
        this.$el.attr("id", this.model.id);
        this.threadPool = this.options.threadPool

        this.threadPool.addTask(jQueryValamis.proxy(this.loadStatements, this));
    },

    render: function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQueryValamis("#studentViewTablePackageRowTemplate").html(), _.extend(this.model.toJSON(), language));
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
            $el: jQueryValamis('.edit-package-grade-view-dialog'),
            model: this.model,
            language: this.language
        });
        view.on('refreshPackageGrade', jQueryValamis.proxy(function () {
            this.render();
            this.trigger('refreshTotalGrade');
        }, this));

        myLayout.modals.show(new EditPackageGradeViewModal({view: view}));
    },


    loadStatements: function() {
        var that = this;
        this.model.loadStatements({}).then(function(res){
            that.model.set('gradeAuto', res.gradeAuto);
            that.model.set('statements', res.statements);
            var statementResult = JSON.parse(that.model.get('statements'));
            if (statementResult.statements.length > 0) {
                that.$el.addClass('expand');
                that.tableView = new StudentPackageTableView({
                    language: that.options.language,
                    model: statementResult,
                    activityIds:that.model.get('activityIds')
                });
                that.$el.after(that.tableView.render());
            }
            that.render();
            that.threadPool.taskCompleted();
        });
    }
});

StudentView = Backbone.View.extend({
    events: {
        "click .edit-total-grade": "showEditGradeView"
    },

    initialize: function (options) {
        this.options = options;
        var template = Mustache.to_html(jQueryValamis("#studentViewTemplate").html(), _.extend(this.model.toJSON(), language));
        this.$el.html(template);
        var windowHeight = jQueryValamis(window).height() - 200;
        this.$('.page-content-div').height(windowHeight);

        this.$el.attr("id", this.model.id);
        this.collection = new StudentGradesCollection();

        this.threadPool = new ThreadPool(3);

        var that = this;
        this.paginator = new ValamisPaginator({
            el: this.$el.find("#packageGradesListPaginator"),
            language: this.options.language,
            model: this.model.get('paginatorModel')
        });
        this.paginator.on('pageChanged', function () {
            that.reloadList();
        });

        this.paginatorShowing = new ValamisPaginatorShowing({
            el: this.$el.find("#packageGradesPagingShowing"),
            language: this.options.language,
            model: this.paginator.model
        });

        this.reloadList();
    },

    reloadList: function () {

        this.$("#studentGradeGrid").empty();

        this.showLoading();

        this.model.loadStudentInfo({}, {
            success: jQueryValamis.proxy(function (res) {
                this.hideLoading();
                this.model = new GradebookStudentModel(res);
                this.collection = new StudentGradesCollection(res.packageGrades);
                this.addGradesFromCollection();
                this.paginator.updateItems(res.packagesCount);
                //this.render();
            }, this),
            error: function (err, res) {
                this.hideLoading();
                this.$("#studentGradeGrid").empty();
                // do something in case of an error
                toastr.error(language['loadFailed']);
            }
        });
    },
    showLoading: function() {
        this.$('#loading-packages').html(Mustache.to_html(jQueryValamis("#loadingGradebookTableTemplate").html(), this.options.language));
    },
    hideLoading: function() {
        this.$('#loading-packages').empty();
    },

    render: function () {
        this.paginator.render();
        var template = Mustache.to_html(jQueryValamis("#studentTotalGradeViewTemplate").html(), _.extend(this.model.toJSON(), language));
        this.$('#studentTotalGrade').html(template);

        return this.$el;
    },

    addGrade: function (grade) {
        grade.set('studentId', this.model.id);
        var view = new StudentTableRowView({
            model: grade,
            language: this.options.language,
            isActivity: false,
            threadPool: this.threadPool
        });
        view.on('refreshTotalGrade', jQueryValamis.proxy(function () {
            var countCompleted = 0;
            this.collection.each(function (grade) {
                if (grade.get('grade') != 0) countCompleted++;
            }, this);
            this.model.set('completedPackagesCount', countCompleted);
            this.trigger('refreshTotalGrade', this);

        }, this));
        var renderedView = view.render();
        this.$("#studentGradeGrid").append(renderedView);

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
        view.on('refreshTotalGrade', jQueryValamis.proxy(function () {
            this.render();
            this.trigger('refreshTotalGrade', this);
        }, this));
        myLayout.modals.show(new EditGradeViewModal({view: view}));
    }
});


