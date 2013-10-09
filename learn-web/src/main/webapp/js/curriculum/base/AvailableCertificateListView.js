AvailableCertificateListView = Backbone.View.extend({
    events:{
        "click #SCORMButtonAddCertificate":"createCertificate",
        "click #sortList":"sortList",
        "click #filterList":"searchList"
    },

    initialize:function () {
        this.views = [];
        this.sortAZ = true;

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('reset', this.addAll, this);
        this.collection.bind('remove', this.deleteCertificate, this);

        this.render();

        var that = this;
        this.collection.on("collection:updated", function (details) {
            that.updatePagination(details, that);
        });

        jQuery("#allCertificatesPaginator").pagination({
            items:0,
            itemsOnPage:10,
            cssStyle:'light-theme',
            prevText:this.options.language['previous'],
            nextText:this.options.language['next'],
            onPageClick:function (pageNumber, event) {
                that.collection.fetch({reset:true});
            }
        });
    },

    updatePagination:function (details, context) {
        jQuery("#allCertificatesPaginator").pagination('updateItems', details.total);
        if (details.total <= 10) jQuery("#allCertificatesPaginator").hide();
        else jQuery("#allCertificatesPaginator").show();
    },

    createCertificate:function () {
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        var certificate = new Certificate();
        certificate.save({}, {
            success:jQuery.proxy(function (certificate, response) {
                certificate.set(response);
                this.collection.add(certificate);
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayCreateQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayCreateQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
    },

    openCertificate:function (id) {
        this.trigger('certificateSite-open', this.collection.get(id));
    },
    openCertificateUsers:function (id) {
        this.trigger('certificateUser-open', this.collection.get(id));
    },
    membershipChanged:function () {
        this.trigger('membership-changed');
    },


    deleteCertificate:function (model) {
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        var modelID = model.id;
        model.destroy({
            success:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayDeleteQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            },
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayDeleteQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
        this.views[modelID].remove();
        delete this.views[modelID];

        this.trigger('certificate-remove', modelID);
    },

    removeCertificate:function (id) {
        var model = this.collection.get(id);
        this.collection.remove(model);
    },

    addOne:function (element) {
        var view = new AvailableCertificateListItemView({
            model:element,
            language:this.options.language,
            isAdmin:this.options.isAdmin
        });

        this.views[element.id] = view;
        var viewDOM = view.render();
        this.$("#certificateList").prepend(viewDOM);

        view.on('certificateSite-open', this.openCertificate, this);
        view.on('certificateUser-open', this.openCertificateUsers, this);
        view.on('certificate-remove', this.removeCertificate, this);
        view.on('membership-changed', this.membershipChanged, this);

    },

    addAll:function () {
        this.$("#certificateList").html('');
        this.collection.each(this.addOne, this);
    },

    searchList:function () {
        jQuery("#allCertificatesPaginator").pagination('selectPage', 1);
        this.collection.fetch({reset:true});
    },
    sortList:function () {
        var sortOrderString = (this.sortAZ) ? this.options.language['sortOrderDescLabel'] : this.options.language['sortOrderAscLabel'];
        this.$("#sortList").html(sortOrderString);
        this.sortAZ = !this.sortAZ;
        this.$("#sortAZ").val(this.sortAZ);


        this.searchList();
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#availableCertificateListView").html(), _.extend({
            cid:this.cid, isAdmin:this.options.isAdmin
        }, language));

        this.$el.append(template);

        return this;
    }
});
