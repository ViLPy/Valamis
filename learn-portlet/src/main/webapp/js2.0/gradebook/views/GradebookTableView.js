GradebookRowView = Backbone.View.extend({
    events:{
        "click .val-icon-edit": "showEditGradeView",
        "click .student-click": "showStudent"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQueryValamis('<tr>');
        this.$el.attr("id", this.model.id);
        this.threadPool = this.options.threadPool;

        this.threadPool.addTask(jQueryValamis.proxy(this.loadLastModified, this));
    },


    render: function () {
        var language = this.options.language;
        var lastModifiedDate = '';
        if (this.model.get('lastModified') != '' && this.model.get('lastModified') != 0) {
            var momentFromServer = moment(this.model.get('lastModified'));
            var clampedMoment = momentFromServer.max();
            lastModifiedDate = clampedMoment.fromNow();
        }
        if (this.model.get('avatarUrl') == "")
            this.model.set('avatarUrl', 'http://placehold.it/48x48');

        var data = _.extend(this.model.toJSON(), language, {lastModifiedDate: lastModifiedDate});
        data = _.extend(data, window.permissionActionsGradebook);

        var template = Mustache.to_html(jQueryValamis("#gradebookRow").html(), data);
        this.$el.html(template);
        return this.$el;
    },

    // Student view  modal
    showStudent: function () {
        var view = new StudentView({
            model: this.model,
            language: this.options.language
        });
        view.on('refreshTotalGrade',jQueryValamis.proxy(function () {
            this.model = view.model;
            this.render();
        }, this));
        myLayout.modals.show(new StudentViewModal({view: view}));
    },

    // Edit total grade modal
    showEditGradeView: function () {
        var view = new EditGradeView({
            model: this.model,
            language: this.language
        });
        view.on('refreshTotalGrade', this.render, this);
        myLayout.modals.show(new EditGradeViewModal({view: view}));
    },

    loadLastModified: function () {
        var view = this;
        if (view.model.get('lastModified') == '' || view.model.get('lastModified') == 0) {
            var that = view;
            this.model.loadLastModified({}).then(function(res){
                that.model.set('lastModified', res);
                that.render();
                that.threadPool.taskCompleted();
            });
        }
    }
});

GradebookListView = Backbone.View.extend({
    events:{
        "click .sortable": "sortStudents"
    },

    initialize:function (options) {
        this.options = options;
        this.sortableAscOrder = [];
        var template = Mustache.to_html(jQueryValamis("#simpleTableTemplate").html(), this.options.language);
        this.threadPool = new ThreadPool(3);

        this.$el.html(template);

        this.paginator = new ValamisPaginator({el: jQueryValamis('#gradebookPaginator'), model: this.model.get('paginatorModel'), language: this.options.language});

    },

    render: function () {
        this.paginator.render();
        return this.$el;
    },


    reloadGradeList: function () {
        this.model.loadList({}, {
            success: jQueryValamis.proxy(function (res) {
                //this.model = new GradebookModel(res);
                this.collection = new GradebookStudentCollection(res.records);
                this.addStudentsFromCollection();
                this.paginator.updateItems(res.total);
                this.model.trigger("getValueTotalElements", res.total);
            }, this),
            error: function (err, res) {
                // do something in case of an error
                toastr.error(language['loadFailed']);
            }
        });
    },

    sortStudents:function (event) {
    },


    addStudent:function (pkg) {
        var view = new GradebookRowView({
            model:pkg,
            language:this.options.language,
            threadPool: this.threadPool

        });
        var renderedView = view.render();
        this.$("#gradeGrid").append(renderedView);
    },


    addStudentsFromCollection:function () {
        this.$("#gradeGrid").empty();
        this.collection.each(this.addStudent, this);
    }
});
