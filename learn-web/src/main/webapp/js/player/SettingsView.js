SettingsView = Backbone.View.extend({
    events:{
        //"click":"setActive",
        "click #visibility":"updateScopePackageVisibility"
    },

    initialize:function () {
        this.$el = jQuery('<tr>');
        this.$el.attr("id", this.model.id);
    },

    setActive:function () {
        //this.$el.addClass("SCORMHighlitedPackage");
        //this.trigger('change-active', this);
    },

    updateScopePackageVisibility:function () {
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
        var template = Mustache.to_html(jQuery("#packageScopeRuleRowEdit").html(), _.extend(this.model.toJSON(), language));
        this.$el.html(template);
    },

    showDefault:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#packageScopeRuleRow").html(), _.extend(this.model.toJSON(), language));
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

PlayerSettingsListView = Backbone.View.extend({
    events:{
        "click .sortable":"sortPackages"
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
        var template = Mustache.to_html(jQuery("#packageScopeRuleListTemplate").html(), language);
        this.$el.html(template);
        //this.$("#SCORMPackageDone").hide();
        this.scormPlayerSettingsPackageList = this.$("#SCORMPackageScopeRuleGrid").List();
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

    filterPackages:function (text) {
        this.scormPlayerSettingsPackageList.filter(text);
    },

    sortPackages:function (event) {
        var targetRow = jQuery(event.target);
        var ref = targetRow.attr('ref');
        this.sortableAscOrder[ref] = !this.sortableAscOrder[ref];
        jQuery('.ui-icon', targetRow).toggleClass("ui-icon-triangle-1-n").toggleClass("ui-icon-triangle-1-s");
        this.scormPlayerSettingsPackageList.sort(ref, this.sortableAscOrder[ref] ? "asc" : "desc");
    },

    addPackage:function (pkg) {
        var view = new SettingsView({
            model:pkg,
            language:this.options.language
        });
        view.on('change-active', this.changeActive, this);

        var renderedView = view.render();
        this.scormPlayerSettingsPackageList.add(pkg.id, renderedView, pkg.toJSON());
        this.$("#SCORMPackageScopeRuleGrid").append(renderedView);
    },
    addPackagesFromCollection:function () {
        this.$("#SCORMPackageScopeRuleGrid").empty();
        this.collection.each(this.addPackage, this);
    }
});
