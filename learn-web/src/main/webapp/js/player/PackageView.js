PlayerPackageView = Backbone.View.extend({
    events:{
        "click":"setActive",
        "click #startPackage":"startPackage",
        "click #resumePackage":"resumePackage"
    },

    initialize:function () {
        this.$el = jQuery('<tr>');
        this.$el.attr("id", this.model.id);
    },

    startPackage:function () {
        this.trigger('start', {id:this.model.id, packageName:this.model.get('title')});
    },

    resumePackage:function () {
        this.trigger('resume', {id:this.model.id, packageName:this.model.get('title')});
    },

    setActive:function () {
        this.$el.addClass("SCORMHighlitedPackage");
        this.trigger('change-active', this);
    },

    render:function () {
        this.showDefault();
        return this.$el;
    },

    showDefault:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#packageRow").html(), _.extend(this.model.toJSON(), language));
        this.$el.html(template);
    }
});

PlayerPackageListView = Backbone.View.extend({
    events:{
        "click .sortable":"sortPackages",
        "click #SCORMPackageListReload":"reloadPackageList"
    },

    initialize:function () {
        this.activePackageView = null;
        this.sortableAscOrder = [];
        this.collection.on('add', this.addPackage, this);
        this.collection.on('reset', this.addPackagesFromCollection, this);
        this.render();
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#packageListTemplate").html(), language);
        this.$el.html(template);
        this.$("#SCORMPackageDone").hide();
        this.scormPackageList = jQuery("#SCORMPackagesGrid").List();
        this.$(".sortable").each(jQuery.proxy(function (index, element) {
            var dom = jQuery(element);
            this.sortableAscOrder[dom.attr('ref')] = true;
            var icon = jQuery('<div>');
            icon.addClass('ui-icon');
            icon.addClass('ui-icon-triangle-1-n');
            icon.addClass('scormSortIcon');
            dom.append(icon);
        }, this));

        return this.$el;
    },

    reloadPackageList:function () {
        this.collection.fetch();
    },

    filterPackages:function (text) {
        this.scormPackageList.filter(text);
    },

    sortPackages:function (event) {
        var targetRow = jQuery(event.target);
        var ref = targetRow.attr('ref');
        this.sortableAscOrder[ref] = !this.sortableAscOrder[ref];
        jQuery('.ui-icon', targetRow).toggleClass("ui-icon-triangle-1-n").toggleClass("ui-icon-triangle-1-s");
        this.scormPackageList.sort(ref, this.sortableAscOrder[ref] ? "asc" : "desc");
    },

    addPackage:function (pkg) {
        var view = new PlayerPackageView({
            model:pkg,
            language:this.options.language
        });
        view.on('change-active', this.changeActive, this);
        view.on('start', function (id) {
            this.trigger('start', id)
        }, this);
        view.on('resume', function (id) {
            this.trigger('resume', id)
        }, this);
        var renderedView = view.render();
        this.scormPackageList.add(pkg.id, renderedView, pkg.toJSON());
        this.$("#SCORMPackagesGrid").append(renderedView);
    },

    changeActive:function (view) {
        if (!this.activeEditing) {
            this.activePackageView = view;
        }
        this.$("tr[id!='" + this.activePackageView.model.id + "']").removeClass('SCORMHighlitedPackage');
    },

    addPackagesFromCollection:function () {
        this.$("#SCORMPackagesGrid").empty();
        this.collection.each(this.addPackage, this);
    }
});
