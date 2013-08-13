 CertificateUserBankCollectionProxy = Backbone.Collection.extend({
    model:jsTreeModel,
    initialize:function () {
        var Users = Backbone.Collection.extend({
            model:CertificateUserModel
        });

        this.users = new Users();
    },

    addUser:function (entity) {
        var user = new CertificateUserModel(entity);

        var model = {
            title:user.get('name'),
            content:user,
            parentID:-1,
            type:"entity",
            state:null,
            id:user.cid
        };

        this.users.add(user);
        this.add(model);
        return user.cid;
    },

    addUsers:function (users) {
        _.each(users, this.addUser, this);
    },

    // Read
    getEntity:function (id) {
        var treeModel = this.get(id);
        if (!treeModel) return null;
        return this.users.get(id);
    },

    createCertificateUser:function (certificateID, userID) {
        return window.LearnAjax.post(Utils.getContextPath() + "services/certificating/users/addUser/" + certificateID , {
            'userID':userID, 'companyID':jQuery("#companyID").val()
        });
    },

    // Delete
    drop:function (id) {
        // remove real model from inner collection and destroy it
        var realModel = this.getEntity(id);
        this.users.remove(realModel);
        realModel.destroy();

        // and remove from collection
        var treeModel = this.get(id);
        this.remove(treeModel);
    },

    fetchUsers:function (certificateID) {
        jQuery.when(this.getCertificateUsers(certificateID))
            .done(jQuery.proxy(function (users) {
            this.addUsers(users);
            //this.trigger('loaded', id);
        }, this));
    },
    getCertificateUsers:function (certificateID) {
        return window.LearnAjax.get(Utils.getContextPath() + "services/certificating/users/" + certificateID);
    }
});