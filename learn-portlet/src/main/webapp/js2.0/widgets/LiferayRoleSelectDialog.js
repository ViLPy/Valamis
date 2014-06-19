LiferayRoleModel = Backbone.Model.extend({
    defaults:{
        roleID:"",
        roleName:"",
        usersCount:0,
        roleDescription:""
    }
});

LiferayRoleCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
            return "api/roles/"+"?companyID="+ jQuery("#companyID").val();
        }
    }
});

LiferayRoleCollection = Backbone.Collection.extend({
    model:LiferayRoleModel
}).extend(LiferayRoleCollectionService);


LiferayRoleListElement = Backbone.View.extend({
    events:{
        "click #selectSiteButton":"addThis"
    },
    initialize:function () {
        this.$el = jQuery('<div>');
    },
    render:function () {
        var template = Mustache.to_html(jQuery('#liferayRoleElementView').html(), {roleName:this.model.get('roleName'), description:this.model.get('description')});
        this.$el.html(template);
        return this.$el;
    },
    addThis:function () {
        this.model.trigger('select', this.model);
    }
});

// Dialog

LiferayRoleSelectDialog = Backbone.View.extend({
    events:{
    },
    callback:function (roleID) {
    },
    initialize:function () {
        this.$el = jQuery('<div>');
        this.collection = new LiferayRoleCollection();
        this.collection.on('select', this.pickUp, this);

        this.collection.fetch();
        this.currentCertificate = null;
    },
    addSite:function (site) {
        if (!this.checkIfExists(site)){
            var view = new LiferayRoleListElement({model:site});
            this.$('#roleList').append(view.render());
        }
    },
    checkIfExists: function(site){
       var existed = this.excludedRoles.find(function(item){
            if (item.get('roleName') == site.get('roleName')) return true;
            else return false; });
        if (existed != null) return true
        else return false;

    },
    render:function () {
        this.$el.html(jQuery('#liferayRoleDialogView').html());
        return this;
    }   ,
    renderRoles:function () {
        this.$el.html(jQuery('#liferayRoleDialogView').html());
        this.collection.each(this.addSite, this);
        return this;
    },
    choose:function (permission, roleIds, onChoose) {
        this.callback = onChoose;
        this.excludedRoles = roleIds;

        this.renderRoles();
    },
    pickUp:function(model){
        this.callback(model.get('roleID'));
    }

});

