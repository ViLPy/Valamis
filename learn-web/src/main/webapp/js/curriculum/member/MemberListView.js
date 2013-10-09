MemberListView = Backbone.View.extend({
    events:{
        "click #addMember":"addMember"
      //  "click #sortList":"sortList",
      //  "keyup #certificateSearch":"searchList"
    },

    initialize:function () {
        this.views = [];
        //this.sortAZ = true;

        this.collection = new MemberCollection();

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('reset', this.addAll, this);

        this.render();

    },
    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#certificateMemberListView").html(), _.extend({
            cid:this.cid, id: this.model.id
        }, language));
        this.$el.append(template);
        this.collection.fetch({reset: true, certificateID: this.model.id});
       //this.certificateList = this.$("#certificateList").List();
        return this;
    },
    addMember:function(){
        window.UsersDialog.choose(jQuery.proxy(function (userID, name) {
            this.addLiferayUser(userID, name)
        }, this));
    },
    addLiferayUser: function (userID, name) {
        var member = new Member({userID: userID, certificateID: this.model.id, name: name });
        var that = this;
        member.save({}, {
            success:jQuery.proxy(function (responce, item) {
                if (item.id != 0){
                member.id = item.id;
                member.portrait = item.portrait;
                this.collection.add(member);
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayCreateQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
                }
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayCreateQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
    },

    addOne:function (element) {
        var view = new MemberListItemView({
            model:element,
            language:this.options.language,
            isAdmin:this.options.isAdmin
        });

        this.views[element.get('userID')] = view;

        view.on('member-remove', this.removeMember, this);

        var viewDOM = view.render();
        this.$("#certificateMemberList").prepend(viewDOM);
        this.updateCertificateFromServer();
    },
    addAll:function (id) {
        this.collection.each(this.addOne, this);
    },
    removeMember:function(userID){
        var item = this.collection.findWhere({userID: userID});
        this.collection.remove(item);
        item.destroy();
        this.views[userID].remove();
        delete this.views[userID];
        _.delay(jQuery.proxy(this.updateCertificateFromServer, this), 1000);
    },
    updateCertificateFromServer: function(){
        this.model.fetch();
    }
    /*

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
    membershipChanged:function(){
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
        this.certificateList.remove(id)
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

        //element.on('change', function (element) {
        //    this.certificateList.update(element.id, {"title":element.get('title'), "description":element.get('description')});
        //}, this);

        this.certificateList.add(element.id, viewDOM, {"title":element.get('title'), "description":element.get('description')}, true);
    },

    addAll:function () {
        this.collection.each(this.addOne, this);
 },

    searchList:function () {
        this.certificateList.filter(this.$("#certificateSearch").val() || "");
    },
    sortList:function () {
        if (this.certificateList) {
            this.certificateList.sort("title", this.sortAZ ? "asc" : "desc");

            var sortOrderString = (this.sortAZ) ? this.options.language['sortOrderAscLabel'] : this.options.language['sortOrderDescLabel'];
            this.$("#sortList").html(sortOrderString);
            this.sortAZ = !this.sortAZ;
        }
    },
*/

});
