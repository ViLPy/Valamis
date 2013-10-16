RoleBankCollectionProxy = Backbone.Collection.extend({
    initialize:function () {
        var Roles = Backbone.Collection.extend({
            model:RoleModel
        });

        this.roles = new Roles();

        this.permission = "";
        this.activePackageView = null;
    },

    addRole:function (entity) {
        var entityModel = new RoleModel(entity)
        var view = new RoleView({model:entityModel});
        view.on('change-active', this.changeActive, this);
        view.on('change-isDefault', this.changeIsDefault, this);
        var renderedView = view.render();

        if (this.permission == Permissions.Teacher) jQuery("#teacherRoleList").append(renderedView);
        else jQuery("#studentRoleList").append(renderedView);

        this.roles.add(entityModel);
    },

    changeActive:function (view) {
        this.activePackageView = view;
        jQuery("tr[id!='" + this.activePackageView.model.id + "']").removeClass('SCORMHighlitedPackage');
    },

    changeIsDefault:function () {
        this.roles.each(this.uncheckDefaults, this)
    },

    uncheckDefaults:function (item) {
        if (item.id != this.activePackageView.model.id) {
            jQuery("tr[id='" + item.id + "']>td>#isDefaultRole").attr('checked', false);
        }
    },

    addRoles:function (roles) {
        _.each(roles, this.addRole, this);
    },

    getEntity:function (id) {
        return this.roles.find(function (item) {
            return item.get('id') == id
        });
    },

    createRoleMap:function (roleID, permission) {
        return window.LearnAjax.post(Utils.getContextPath() + "services/roles/add/" + roleID + "/" + permission);
    },

    drop:function () {
        var currentRole = this.activePackageView.model.id;
        var realModel = this.getEntity(currentRole);
        this.roles.remove(realModel);
        realModel.destroy();
        this.activePackageView.onDestroy();
    },

    isSelected:function(){
        return this.activePackageView != null;
    },

    fetchRolesByPermission:function (permission) {
        this.permission = permission;
        jQuery.when(this.getRolesList(permission))
            .done(jQuery.proxy(function (roles) {
                this.addRoles(roles);
            }, this));
    },
    getRolesList:function (permission) {
        return window.LearnAjax.get(Utils.getContextPath() + "services/roles/" + permission);
    }
});


RoleView = Backbone.View.extend({
    events:{
        "click":"setActive",
        "click #isDefaultRole":"updateDefault"
    },

    initialize:function () {
        this.$el = jQuery('<tr>');
        this.$el.attr("id", this.model.id);
    },

    setActive:function () {
        this.$el.addClass("SCORMHighlitedPackage");
        this.trigger('change-active', this);
    },


    updateDefault:function () {
        this.model.save({
            isDefault:this.$("#isDefaultRole").is(":checked")
        });
        this.setActive();
        this.trigger('change-isDefault', this);
    },

    render:function () {
        var template = Mustache.to_html(jQuery("#roleItemTemplate").html(), this.model.toJSON());
        this.$el.html(template);
        return this.$el;
    },

    onDestroy:function () {
        this.remove();
    }
});
