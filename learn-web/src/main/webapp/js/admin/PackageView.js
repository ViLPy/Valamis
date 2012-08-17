PackageView = Backbone.View.extend({
    events:{
        "click":"setActive",
        "click #visibility":"updateVisibility"
    },

    initialize:function () {
        this.$el = jQuery('<tr>');
        this.$el.attr("id", this.model.id);
    },

    setActive:function () {
        this.$el.addClass("SCORMHighlitedPackage");
        this.trigger('change-active', this);
    },

    updateVisibility:function () {
        this.model.save({
            visibility:this.$("#visibility").is(":checked")
        });
    },

    render:function () {
        this.showDefault();
        return this.$el;
    },

    showEdit:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#packageRowEdit").html(), _.extend(this.model.toJSON(), language));
        this.$el.html(template);
    },

    showDefault:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#packageRow").html(), _.extend(this.model.toJSON(), language));
        this.$el.html(template);
    },

    onSave:function () {
        this.model.save({
            title:this.$("#title").val(),
            summary:this.$("#summary").val(),
            visibility:this.$("#visibility").is(":checked")
        });
        this.showDefault();
    },

    onDestroy:function () {
        this.model.destroy();
        this.remove();
    }
});

PackageListView = Backbone.View.extend({
    events:{
        "click .sortable":"sortPackages",
        "click #SCORMPackageEdit":"editPackage",
        "click #SCORMPackageDone":"updatePackage",
        "click #SCORMPackageListReload":"reloadPackageList",
        "click #SCORMPackageRemove":"removePackage"
    },

    initialize:function () {
        this.activePackageView = null;
        this.activeEditing = false;
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

    editPackage:function () {
        if (this.activePackageView && !this.activeEditing) {
            this.activeEditing = true;
            this.activePackageView.showEdit();
            this.$("#SCORMPackageDone").show();
            this.$("#SCORMPackageEdit").hide();
        } else if (!this.activePackageView) {
            alert(this.options.language['selectPackageInfoMessageLabel']);
        }
    },

    updatePackage:function () {
        if (this.activePackageView && this.activeEditing) {
            this.activePackageView.onSave();
            this.activePackageView.showDefault();
            this.$("#SCORMPackageDone").hide();
            this.$("#SCORMPackageEdit").show();
        }
    },

    removePackage:function () {
        if (this.activePackageView) {
            this.activeEditing = false;
            this.activePackageView.onDestroy();
        }
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
        pkg.on('destroy', this.destroyPackage, this);
        var view = new PackageView({
            model:pkg
        });
        view.on('change-active', this.changeActive, this);
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
    },

    destroyPackage:function (pkg) {
        this.collection.remove(pkg);
    }
});
