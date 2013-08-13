CertificateSiteBankCollectionProxy = Backbone.Collection.extend({
    initialize:function () {
        var Sites = Backbone.Collection.extend({
            model:CertificateSiteModel
        });

        this.sites = new Sites();

        this.certificateID = 0;
    },

    addSite:function (entity) {
        var site = new CertificateSiteModel(entity);
        var template = Mustache.to_html(jQuery("#certificateSiteItem").html(), entity);
        jQuery("#certificateSitesSortable_" + this.certificateID).append(template);

        this.sites.add(site);
    },

    addSites:function (sites) {
        _.each(sites, this.addSite, this);
        this.reinitialize();
    },

    reinitialize: function(){
        var certID = this.certificateID;
        var id = "#certificateSitesSortable_" + this.certificateID;
        jQuery(id).sortable({
            handle: ".handle",
            stop: function( event, ui ) {
                    var sortedAnswers = jQuery(id).sortable("toArray", {key:'value'});
                    window.LearnAjax.post(Utils.getContextPath() + "services/certificating/sites/move/" + certID , {
                        'siteIDs':sortedAnswers.toString()
                    });
                }
            })
            .selectable({
                selected: function( event, ui ) {
                    jQuery(ui.selected).addClass("ui-selected").siblings().removeClass("ui-selected");
            }})
            .find( "li" )
            .addClass( "ui-corner-all" )
            .prepend( "<div class='handle'><span class='ui-icon ui-icon-carat-2-n-s'></span></div>" );
    },

    // Read
    getEntity:function (id) {
        return this.sites.find(function(item){ return item.get('siteID') == id });
    },
    getSelected:function(){
         var selected = -1;
         jQuery(".ui-selected").each(function() {
            selected = jQuery(this).find(".hiddenSiteID").val();
         });
         return selected;
    },

    createCertificateSite:function (certificateID, siteID, title) {
        return window.LearnAjax.post(Utils.getContextPath() + "services/certificating/sites/addSite/" + certificateID , {
            'siteID':siteID
        });
    },

    // Delete
    drop:function () {
        var currentSite = this.getSelected();
        if (currentSite == -1) return;

        var realModel = this.getEntity(currentSite);
        if (realModel == null || realModel == undefined) return;

        this.sites.remove(realModel);
        jQuery(".ui-selected").remove();
        realModel.destroy();
    },

    fetchSites:function (certificateID) {
        this.certificateID = certificateID;
        jQuery.when(this.getCertificateSites(certificateID))
            .done(jQuery.proxy(function (sites) {
            this.addSites(sites);
        }, this));
    },
    getCertificateSites:function (certificateID) {
        return window.LearnAjax.get(Utils.getContextPath() + "services/certificating/sites/" + certificateID);
    }
});
