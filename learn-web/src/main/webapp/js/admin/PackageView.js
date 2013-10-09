PackageView = Backbone.View.extend({
    events:{
        "click":"setActive",
        "click #visibility":"updateVisibility",
        "click #isDefault":"updateDefaultPackage"
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
    updateDefaultPackage:function () {
        this.model.save({
            isDefault:this.$("#isDefault").is(":checked")
        });
        this.setActive();
        this.trigger('change-isDefault', this);
    },

    render:function () {
        this.showDefault();
        return this.$el;
    },

    showEdit:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#packageAdminRowEdit").html(), _.extend(this.model.toJSON(), language, {isTincan: this.model.get("type") == "tincan"}));
        this.$el.html(template);
    },

    showDefault:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#packageAdminRow").html(), _.extend(this.model.toJSON(), language, {isTincan: this.model.get("type") == "tincan"}));
        this.$el.html(template);
    },

    onSave:function () {
        this.model.save({
            title:this.$("#title").val(),
            summary:this.$("#summary").val(),
            visibility:this.$("#visibility").is(":checked"),
            isDefault:this.$("#isDefault").is(":checked")
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
        var template = Mustache.to_html(jQuery("#packageAdminListTemplate").html(), language);
        this.$el.html(template);
        this.$("#SCORMPackageDone").hide();
        this.scormPackageList = this.$("#SCORMAdminPackagesGrid").List();
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
            this.activeEditing = false;
        }
    },

    removePackage:function () {
        if (this.activePackageView) {
            this.activeEditing = false;
            this.scormPackageList.remove(this.activePackageView.model.id);
            this.activePackageView.onDestroy();
        }
    },

    reloadPackageList:function () {
        this.activePackageView = null;
        this.activeEditing = false;
        this.collection.fetch({reset: true});
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
        view.on('change-isDefault', this.changeIsDefault, this);
        var renderedView = view.render();
        this.scormPackageList.add(pkg.id, renderedView, pkg.toJSON());
        this.$("#SCORMAdminPackagesGrid").append(renderedView);
    },

    changeActive:function (view) {
        if (!this.activeEditing) {
            this.activePackageView = view;
        }
        this.$("tr[id!='" + this.activePackageView.model.id + "']").removeClass('SCORMHighlitedPackage');
    },

    changeIsDefault: function(){
        this.collection.each(this.uncheckDefaults, this)
    },

    uncheckDefaults: function(item){
        if (item.id != this.activePackageView.model.id){
            this.$("tr[id='" + item.id + "']>td>#isDefault").attr('checked', false);
        }
    },

    addPackagesFromCollection:function () {
        this.$("#SCORMAdminPackagesGrid").empty();
        this.collection.each(this.addPackage, this);
    },

    destroyPackage:function (pkg) {
        this.collection.remove(pkg);
    }
});
