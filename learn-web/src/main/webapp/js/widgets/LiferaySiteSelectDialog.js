LiferaySiteModel = Backbone.Model.extend({
    defaults:{
        siteID:"",
        title:"",
        url:"",
        description:""
    }
});

LiferaySiteCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
            return "services/liferay/site/"+"?companyID="+ jQuery("#companyID").val();
        }
    }
});

LiferaySiteCollection = Backbone.Collection.extend({
    model:LiferaySiteModel
}).extend(LiferaySiteCollectionService);


LiferaySiteListElement = Backbone.View.extend({
    events:{
        "click #selectSiteButton":"addThis"
    },
    initialize:function () {
        this.$el = jQuery('<div>');
    },
    render:function () {
        var template = Mustache.to_html(jQuery('#liferaySiteElementView').html(), {title:this.model.get('title'), description:this.model.get('description')});
        this.$el.html(template);
        return this.$el;
    },
    addThis:function () {
        this.model.trigger('select', this.model);
    }
});

// Dialog

LiferaySiteSelectDialog = Backbone.View.extend({
    events:{
    },
    callback:function (siteID, siteName, description) {
    },
    initialize:function () {
        this.collection = new LiferaySiteCollection();
        //this.collection.on('reset', this.render, this);
        this.collection.on('select', this.pickUp, this);
        this.$el.dialog({
            autoOpen:false,
            modal:true,
            width:540,
            height:400
        });
        this.collection.fetch();
        this.currentCertificate = null;
    },
    addSite:function (site) {
        if (!this.checkIfExists(site)){
            var view = new LiferaySiteListElement({model:site});
            this.$('#siteList').append(view.render());
        }
    },
    checkIfExists: function(site){
        var existed = this.excludedSites.find(function(item){
            if (item.get('title') == site.get('title')) return true;
            else return false; });
        if (existed != null) return true
        else return false;
    },
    render:function () {
        this.$el.html(jQuery('#liferaySiteDialogView').html());
        this.collection.each(this.addSite, this);
    },
    choose:function (certificateID, siteIds, onChoose) {
        this.callback = onChoose;
        this.excludedSites = siteIds;
        if (this.currentCertificate != certificateID){
            this.currentCertificate = certificateID;
        }

        this.render();
        this.$el.dialog('open');
    },
    pickUp:function(model){
        this.callback(model.get('siteID'), model.get('title'), model.get('description'));
        this.$el.dialog('close');
    }

});

