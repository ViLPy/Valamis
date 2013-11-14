/**
 * Certificate management UI.
 */
AvailableCertificateListItemView = Backbone.View.extend({
    events:{
        "click #certificateDelete":"removeCertificate",
        "click #certificateEdit":"editCertificate",
        "click #certificateEditUsers":"editUsers",
        "click .joinCertificate":"joinCertificate",
        "click .leaveCertificate":"leaveCertificate"
    },
    initialize:function () {
        this.$el = jQuery('<li>');
        this.model.on('change', this.renderView, this);
    },
    editCertificate:function () {
        this.trigger('certificateSite-open', this.model.id);
    },
    editUsers:function () {
        this.trigger('certificateUser-open', this.model.id);
    },
    removeCertificate:function () {
        if (confirm(this.options.language['warningDeleteCertificateMessageLabel'])) this.trigger('certificate-remove', this.model.id);
    },
    renderView:function () {
        var language = this.options.language;

        var template = Mustache.to_html(jQuery("#availableCertificateListItemView").html(), _.extend(this.model.toJSON(), _.extend({
            id:this.model.get('id'),
            isAdmin:this.options.isAdmin,
            description:decodeURIComponent(this.model.get('description')),
            logo: this.model.get('logo')
        }, language)));

        this.$el.html(template);
    },
    render:function () {
        this.renderView();

        if (this.model.get('isMemberOf')) { this.leave(); }
        else { this.join(); }

        return this.$el;
    },
    joinCertificate:function () {
        window.LearnAjax.post(Utils.getContextPath() + "services/certificating/users/addUser",
            { 'certificateID':this.model.id,
                'userID':jQuery("#studentID").val()
            },
            jQuery.proxy(function () {
                this.trigger('membership-changed');
                var count = this.model.get('usersCount') + 1;
                this.model.set({"usersCount": count });
                this.leave();
            }, this));
    },
    leaveCertificate:function () {
        window.LearnAjax.post(Utils.getContextPath() + "services/certificating/users/removeUser/" + this.model.id,
            { 'userID':jQuery("#studentID").val()},
            jQuery.proxy(function () {
                this.trigger('membership-changed');
                var count = this.model.get('usersCount') - 1;
                this.model.set({"usersCount": count });
                this.join();
            }, this));
    },
    leave:function () {
        this.$("#leaveCertificate_" + this.model.id).show();
        this.$("#joinCertificate_" + this.model.id).hide();
    },
    join:function () {
        this.$("#leaveCertificate_" + this.model.id).hide();
        this.$("#joinCertificate_" + this.model.id).show();
    }
});
