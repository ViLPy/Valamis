PackageFilterView = Backbone.View.extend({
    events:{
        "click":"setActive"
    },

    initialize:function (options) {
        this.options = options;
        this.$el = jQueryValamis('<div>');
        this.$el.attr("id", this.model.id);
    },

    setActive:function () {
        //this.$el.addClass("SCORMHighlitedPackage");
        //this.trigger('change-active', this);
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQueryValamis("#gradebookPackageRow").html(), _.extend(this.model.toJSON(), language));
        this.$el.html(template);
        return this.$el;
    }
});

PackageFilterListView = Backbone.View.extend({

    initialize:function (options) {
        this.options = options;
        this.collection.on('add', this.addPackage, this);
        this.collection.on('reset', this.addPackagesFromCollection, this);
        //this.$el = jQueryValamis("#package-multiselect");

        this.render();
    },

    render:function () {
//        var language = 'en'; //this.options.language;
//        var template = Mustache.to_html(jQueryValamis("#gradebookTable").html(), language);
        //var template = jQueryValamis("#gradebookTable").html();
        //this.$el.html(template);
        //this.studentGradeList = this.$("#package-multiselect").List();

        return this.$el;
    },


//    reloadPackageList:function () {
//        this.activePackageView = null;
//        this.activeEditing = false;
//        this.studentGradeList.removeAll();

//        this.collection.fetch({reset: true});
//    },

    filterStudents:function (text) {
        //this.studentGradeList.filter(text);
    },

    sortStudents:function (event) {
//        var targetRow = jQueryValamis(event.target);
//        var ref = targetRow.attr('ref');
//        this.sortableAscOrder[ref] = !this.sortableAscOrder[ref];
//        jQueryValamis('.ui-icon', targetRow).toggleClass("ui-icon-triangle-1-n").toggleClass("ui-icon-triangle-1-s");
//        this.studentGradeList.sort(ref, this.sortableAscOrder[ref] ? "asc" : "desc");
    },


    addPackage:function (pkg) {
        var view = new PackageFilterView({
            model:pkg,
            language:this.options.language
        });
        view.on('change-active', this.changeActive, this);
        var renderedView = view.render();
        var pkgJSON = pkg.toJSON();
        var filterData = {
            summary: pkgJSON.summary || "",
            title: pkgJSON.title || ""
        };
        //this.studentGradeList.add(pkg.id, renderedView, filterData);
        this.$el.append(renderedView);
    },

    changeActive:function (view) {
//        if (!this.activeEditing) {
//            this.activePackageView = view;
//        }
//        this.$("tr[id!='" + this.activePackageView.model.id + "']").removeClass('SCORMHighlitedPackage');
    },

    addPackagesFromCollection:function () {
        this.$el.empty();
        this.collection.each(this.addPackage, this);
    }
});
