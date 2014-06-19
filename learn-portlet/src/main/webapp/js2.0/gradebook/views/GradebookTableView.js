
GradebookRowView = Backbone.View.extend({
    events:{
        "click":"setActive",
        "click .val-icon-edit": "showEditGradeView",
        "click .student-click": "showStudent"
    },

    initialize:function (options) {
        this.options = options;
        this.$el = jQuery('<tr>');
        this.$el.attr("id", this.model.id);
        //this.$el.addClass('nth-child');
    },

    setActive:function () {
        //this.$el.addClass("SCORMHighlitedPackage");
        //this.trigger('change-active', this);
    },

    render:function () {
        var language = this.options.language;
        var lastModifiedDate = '';
        if (this.model.get('lastModified') != 0) {
            var momentFromServer = moment(this.model.get('lastModified'));
            var clampedMoment = momentFromServer.max();
            lastModifiedDate = clampedMoment.fromNow();
        }
        if (this.model.get('avatarUrl') == "")
            this.model.set('avatarUrl', 'http://placehold.it/48x48');
        var template = Mustache.to_html(jQuery("#gradebookRow").html(), _.extend(this.model.toJSON(), language, {lastModifiedDate: lastModifiedDate}));
        this.$el.html(template);
        return this.$el;
    },

    // Student view  modal
    showStudent: function () {
        var view = new StudentView({
            model: this.model,
            language: this.options.language
        });
        view.on('refreshTotalGrade',jQuery1816Gradebook.proxy(function () {
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
        view.on('refreshTotalGrade',this.render,this);
        myLayout.modals.show(new EditGradeViewModal({view: view}));
    }
});

GradebookListView = Backbone.View.extend({
    events:{
        "click .sortable":"sortStudents"
    },

    initialize:function (options) {
        this.options = options;
        this.sortableAscOrder = [];
        var template = Mustache.to_html(jQuery("#simpleTableTemplate").html(), this.options.language);

        this.$el.html(template);


//        this.$(".sortable").each(jQuery.proxy(function (index, element) {
//            var dom = jQuery(element);
//            this.sortableAscOrder[dom.attr('ref')] = true;
//            var icon = jQuery('<div>');
//            icon.addClass('sortable-icon');
//            dom.append(icon);
//        }, this));

        this.paginator = new ValamisPaginator({el: jQuery('.paginator'), model: this.model.get('paginatorModel'), language: this.options.language});

    },

    render: function () {
        this.paginator.render();
        return this.$el;
    },


    reloadGradeList: function () {
        this.model.loadList({}, {
            success: jQuery1816Gradebook.proxy(function (res) {
                //this.model = new GradebookModel(res);
                this.collection = new GradebookStudentCollection(res.records);
                this.addStudentsFromCollection();
                this.paginator.updateItems(res.total);
                //this.options.paginator.render();
            }, this),
            error: function (err, res) {
                // do something in case of an error
                toastr.error(language['loadFailed']);
            }
        });
    },

    sortStudents:function (event) {
//        var targetRow = jQuery(event.target);
//        var ref = targetRow.attr('ref');
//        this.sortableAscOrder[ref] = !this.sortableAscOrder[ref];
//        this.studentGradeList.sort(ref, this.sortableAscOrder[ref] ? "asc" : "desc");
        //TODO
    },


    addStudent:function (pkg) {
        var view = new GradebookRowView({
            model:pkg,
            language:this.options.language
        });
        var renderedView = view.render();
        this.$("#gradeGrid").append(renderedView);
    },


    addStudentsFromCollection:function () {
        this.$("#gradeGrid").empty();
        this.collection.each(this.addStudent, this);
    }
});
