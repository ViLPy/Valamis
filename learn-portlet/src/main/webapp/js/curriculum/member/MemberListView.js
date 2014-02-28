MemberListView = Backbone.View.extend({
    events:{
        "click #addMember":"addMember"
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
        window.UsersDialog.choose(this.model.id, jQuery.proxy(function (userID, name) {
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


});
