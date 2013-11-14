/**
 * Certificate management UI.
 */
CertificateSiteEditView = Backbone.View.extend({
    events:{
        "click #addSites":"addSites",
        "click .certificateEditTitle":"editCertificate",
        "click .certificateTitleUpdate":"updateCertificate",
        "click #SCORMEditDescription":"editText",
        "click .certificateRemoveSite":"removeSite",
        "click .validPeriod":"validPeriodChanged",
        "click .publishBadgeCheckbox":"publishBadgeChanged",
        "click .designBadge":"designBadge",
        "click .shortDescriptionUpdate":"shortDescriptionUpdate",
        "blur .shortDescription":"shortDescriptionUpdate"
    },

    initialize:function () {
        this.processMessage = this.options.language['overlayProcessMessageLabel'];
        this.render();
    },

    removeSite:function (e) {
        var id = e.target.id.replace('certificateRemoveSite_', '');

        if (confirm(this.options.language['warningDeleteNodeMessageLabel'])) {
            this.treeData.drop(this.model.id, id);
            _.delay(_.bind(this.updateCertificateFromServer, this), 1000);
        }
    },

    addSites:function () {
        window.SitesDialog.choose(this.model.id, this.treeData.sites, jQuery.proxy(function (siteID, title, description) {
            this.addLiferaySite(siteID, title, description)
        }, this));
    },
    addLiferaySite:function (siteID, title, description) {
        this.treeData.createCertificateSite(this.model.id, siteID, title).done(jQuery.proxy(function (param) {
            if (param != 0) {
                this.updateCertificateFromServer();
                var id = this.treeData.addSite({"title":title, "siteID":siteID, "id":param, "description":description});
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

    renderEdit:function () {
        var id = this.model.get('id');
        jQuery('#editSitesCertificateTitleInput_' + id).show();
        jQuery('#certificateTitleUpdate_' + id).show();
        jQuery('#editSitesCertificateTitle_' + id).hide();
        jQuery('#certificateEditTitle_' + id).hide();
    },

    renderView:function () {
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
    validPeriodChanged:function () {
        this.model.set({
            isPermanent:jQuery("input:radio[name=validPeriod_"+this.model.get('id')+"]:checked").val()
        });
        this.model.save({}, {
            success:jQuery.proxy(function (item) {
                this.updateCertificateFromServer();
            }, this)});
    },
    publishBadgeChanged:function () {
        var publish = jQuery("#publishBadge_" + this.model.get('id')).is(':checked')
        jQuery("#shortDescriptionSection_" + this.model.get('id')).toggle();

        this.model.set({
            publishBadge:publish
        });
        this.model.save({}, {
            success:jQuery.proxy(function (item) {
                this.updateCertificateFromServer();
            }, this)});
    },
    shortDescriptionUpdate: function(){
        this.model.set({
            shortDescription:jQuery("#shortDescription_" + this.model.get('id')).val()
        });
        this.model.save({}, {
            success:jQuery.proxy(function(i){
                jQuery.growlUI(this.options.language['overlaySaveQuizMessageLabel'], this.options.language['overlayCompleteMessageLabel']);
            }, this)
        });
    },
    renderTitle:function () {
        var id = this.model.get('id');
        var title = this.$("#editSitesCertificateTitleInput_" + id).val();
        jQuery('#editSitesCertificateTitle_' + id).text(title);
    },

    callbackFunction:function () {
    },

    updateModel:function (title, callback) {
        var that = this;
        this.callbackFunction = callback || this.callbackFunction;
        jQuery('#projectLearnGeneric').block({ message:this.processMessage });
        this.model.set({
            title:title,
            description:encodeURIComponent(this.$("#certificateDescription_" + this.model.get('id')).html())
        });
        this.model.save({}, {
            success:jQuery.proxy(function (item) {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
                this.updateCertificateFromServer();
                this.renderView();
                this.callbackFunction();
            }, this),
            error:jQuery.proxy(function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
                this.renderView();
            }, this)
        });
        return true;
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#certificateItemEditSites").html(), _.extend(this.model.toJSON(), _.extend({
            id:this.model.get('id'),
            description:decodeURIComponent(this.model.get('description')),
            logo:this.model.get('logo'),
            isPermanent:this.model.get('isPermanent'),
            publishBadge:this.model.get('publishBadge'),
            shortDescription: this.model.get('shortDescription')
        }, language)));
        this.$el.html(template);
        this.initSitesView(this.$("#certificateSitesSortable_" + this.model.get('id')));
        this.renderView();

        if (!this.model.get('publishBadge')) jQuery("#shortDescriptionSection_" + this.model.get('id')).hide();

        var that = this;

        jQuery('#fileupload_' + this.model.id).fileupload({
            maxNumberOfFiles:1,
            url:Utils.getContextPath() + "services/upload/upload-icon/" + this.model.get('id'),
            dataType:'json',
            disableImageResize:/Android(?!.*Chrome)|Opera/
                .test(window.navigator && navigator.userAgent),
            process:[
                {
                    action:'load',
                    fileTypes:/^image\/(gif|jpeg|png)$/,
                    maxFileSize:1000000 // 20MB
                },
                {
                    action:'resize',
                    maxWidth:200,
                    maxHeight:200,
                    minWidth:140,
                    minHeight:140
                },
                {
                    action:'save'
                }
            ],
            add:function (e, data) {
                var goUpload = true;
                var uploadFile = data.files[0];
                if (!(/\.(gif|jpg|jpeg|png)$/i).test(uploadFile.name)) {
                    alert(that.options.language['notImageError']);
                    goUpload = false;
                }
                if (uploadFile.size > 1000000) { // 1mb
                    alert('Please upload a smaller image, max size is 1 MB');
                    goUpload = false;
                }
                if (goUpload == true) {
                    data.submit();
                }
            },
            done:function (e, data) {
                jQuery.each(data.files, function (index, file) {
                    that.updateCertificateFromServer();
                    jQuery("#certificateIcon_" + that.model.id).html("<img src=\"" + Utils.getContextPath() +
                        "services/openbadges?directory=" + that.model.id +
                        "&fileName=" + file.name.replace(" ", "_").replace("%20", "_") + "\" class=\"logo\">");

                });
            }
        });

        return this;
    },

    editText:function () {
        window.RichEdit.show(this.options.language['certificateDescriptionRichTextWindowTitleLabel'], this.$("#certificateDescription_" + this.model.id), this.editTextCallback, this);
    },

    editTextCallback:function () {
        this.updateModel(this.$("#editSitesCertificateTitle_" + this.model.get('id')).text(), function () {
        });
    },

    updateCertificateFromServer:function () {
        this.model.fetch();
    },

    initSitesView:function (node) {
        var treeData = this.treeData = new CertificateSiteBankCollectionProxy();
        treeData.fetchSites(this.model.id);

    },

    designBadge:function () {
        var URL = 'https://www.openbadges.me/designer.html?origin=http://' + jQuery("#rootUrl").val();
        URL = URL + '&email=developer@example.com';
        URL = URL + '&close=true';
        var options = 'width=1015,height=680,location=0,menubar=0,status=0,toolbar=0';
        var designerWindow = window.open(URL, '', options);
    }
});
