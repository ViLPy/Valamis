/**
 * Certificate management UI.
 */
CertificateSiteEditView = Backbone.View.extend({
    events:{
        "click #addSites":"addSites",
        "click #removeSite":"removeSite",
        "click .certificateEditTitle":"editCertificate",
        "click .certificateTitleUpdate":"updateCertificate",
        "click #SCORMEditDescription":"editText"
    },

    initialize:function () {
        this.processMessage = this.options.language['overlayProcessMessageLabel'];
        this.render();
    },

    removeSite: function(){
        if (this.treeData.getSelected() == -1) return;
        if (this.treeData.getSelected() == undefined) return;

        if (confirm(this.options.language['warningDeleteNodeMessageLabel'])) {
            this.treeData.drop();
            _.delay(_.bind(this.updateCertificateFromServer, this), 1000);
        }
    },

    addSites:function () {
        window.SitesDialog.choose(this.model.id, this.treeData.sites ,jQuery.proxy(function (siteID, title, description) {
                this.addLiferaySite(siteID, title, description)
        }, this));
    },
    addLiferaySite: function (siteID, title, description) {
        this.treeData.createCertificateSite(this.model.id, siteID, title).done(jQuery.proxy(function (param) {
            if (param != 0){
                this.updateCertificateFromServer();
                var id = this.treeData.addSite({"title": title, "siteID": siteID, "id": param, "description": description});
                this.treeData.reinitialize();
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayCompleteMessageLabel']);
            }
        }, this)).error(jQuery.proxy(function (err) {
            jQuery('#projectLearnGeneric').unblock();
            jQuery.growlWarning(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayFailedMessageLabel']);
        }, this));
    },

    editCertificate:function () {
        this.renderEdit();
    },

    renderEdit: function(){
        var id = this.model.get('id');
        jQuery('#editSitesCertificateTitleInput_' + id).show();
        jQuery('#certificateTitleUpdate_' + id).show();
        jQuery('#editSitesCertificateTitle_' + id).hide();
        jQuery('#certificateEditTitle_' + id).hide();
    },

    renderView: function(){
        var id = this.model.get('id');
        jQuery('#editSitesCertificateTitle_' + id).show();
        jQuery('#certificateEditTitle_' + id).show();
        jQuery('#editSitesCertificateTitleInput_' + id).hide();
        jQuery('#certificateTitleUpdate_' + id).hide();
    },

    updateCertificate:function () {
        var id = this.model.get('id');
        if (this.$("#editSitesCertificateTitleInput_" + id).val().length === 0) {
            this.$("#editSitesCertificateTitleInput_" + id).tipsy('show');
            return false;
        }
        this.updateModel(this.$("#editSitesCertificateTitleInput_" + id).val(), this.renderTitle);
    },
    renderTitle: function(){
        var id = this.model.get('id');
        var title = this.$("#editSitesCertificateTitleInput_" + id).val();
        jQuery('#editSitesCertificateTitle_' + id).text(title);
    },

    callbackFunction: function(){},

    updateModel: function(title, callback){
        var that = this;
        this.callbackFunction = callback || this.callbackFunction;
        jQuery('#projectLearnGeneric').block({ message: this.processMessage });
        this.model.set({
            title: title,
            description:encodeURIComponent(this.$("#certificateDescription").html())
        });
        this.model.save({}, {
            success:jQuery.proxy(function (question) {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
                this.updateCertificateFromServer();
                this.renderView();
                this.callbackFunction();
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
                this.renderView();
            }
        });
        return true;
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#certificateItemEditSites").html(), _.extend(this.model.toJSON(), _.extend({
            id:this.model.get('id'), description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.html(template);
        this.initSitesView(this.$("#certificateSitesSortable_" + this.model.get('id')));
        this.renderView();
        return this;
    },

    editText:function () {
        window.RichEdit.show(this.options.language['certificateDescriptionRichTextWindowTitleLabel'], this.$("#certificateDescription"), this.editTextCallback, this);
    },

    editTextCallback: function(){
        this.updateModel(this.$("#editSitesCertificateTitle_"+ this.model.get('id')).text(), function(){});
    },

    updateCertificateFromServer: function(){
        this.model.fetch();
    },

    initSitesView: function(node){
        var treeData = this.treeData = new CertificateSiteBankCollectionProxy();
        treeData.fetchSites(this.model.id);

    }
});
