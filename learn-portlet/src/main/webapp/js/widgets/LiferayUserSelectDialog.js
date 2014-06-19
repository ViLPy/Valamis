LiferayUserModel = Backbone.Model.extend({
    defaults: {
        userID: "",
        name: "",
        checked: false
    }
});

LiferayUserCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function (collection, options) {
            return  "services/liferay/user?companyID=" + jQuery("#companyID").val() + "&name=" + jQuery("#userSearch").val() +
                "&sort=" + jQuery("#sortUser").val() + "&orgID=" + jQuery("#userOrganization").val() +
                "&module=cert&moduleID=" + options.certificateID +
                "&page=" + jQuery("#allUsersPaginator").pagination('getCurrentPage') + "&count=" + 8;
        }
    }
});

LiferayUserCollection = Backbone.Collection.extend({
    model: LiferayUserModel,
    parse: function (response) {
        this.trigger("userCollection:updated", { total: response.total, currentPage: response.currentPage });
        return response.records;
    }
}).extend(LiferayUserCollectionService);

// model for organizations, locations, etc

LiferayFilterModelService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
            return  "services/liferay/user/filters";
        }
    }
});

LiferayFilterModel = Backbone.Model.extend({
    defaults: {
        "orgID": ""
    }
}).extend(LiferayFilterModelService);


// user element

LiferayUserListElement = Backbone.View.extend({
    events: {
        "click #selectUserCheckbox": "updateThis"
    },
    initialize: function () {
        this.$el = jQuery('<div>');
    },
    render: function () {
        var template = Mustache.to_html(jQuery('#liferayUserElementView').html(), this.model.toJSON());
        this.$el.html(template);
        return this.$el;
    },
    addThis: function () {
        this.model.trigger('select', this.model);
    },
    updateThis: function () {
        this.model.set({
            checked: this.$("#selectUserCheckbox").is(":checked")
        });
    }
});

// user list

LiferayUserList = Backbone.View.extend({
    events: {
        "click #addUsersButton": "addAllMembers"
    },

    initialize: function () {
        this.collection = new LiferayUserCollection();

        this.collection.on('reset', this.addAll, this);

        var that = this;
        this.collection.on("userCollection:updated", function (details) {
            that.updatePagination(details, that);
        });

        this.render();
    },

    updatePagination: function (details, context) {
        jQuery("#allUsersPaginator").pagination('updateItems', details.total);
        if (details.total <= 8) jQuery("#allUsersPaginator").hide();
        else jQuery("#allUsersPaginator").show();
    },

    addAllMembers: function () {
        this.collection.each(this.pickUp, this);
        this.trigger('clear', this);
        this.trigger('close', this);
    },

    addAll: function () {
        this.$('#userList').empty();
        this.collection.each(this.addUser, this);
        if (this.collection.length > 0) {
            jQuery("#addUsersButton").show();
        } else {
            jQuery("#noUsersLabel").show();
        }
    },
    addUser: function (user) {
        var view = new LiferayUserListElement({model: user});
        var viewDOM = view.render();
        this.$('#userList').append(viewDOM);
    },
    render: function () {
        var renderedTemplate = Mustache.to_html(jQuery('#liferayUserListView').html(), this.options.language)
        this.$el.html(renderedTemplate);

        var that = this;

        jQuery("#allUsersPaginator").pagination({
            items: 0,
            itemsOnPage: 8,
            cssStyle: 'light-theme',
            prevText: this.options.language['previous'],
            nextText: this.options.language['next'],
            onPageClick: function (pageNumber, event) {
                that.collection.fetch({reset: true, certificateID: that.certificateID});
            }
        });

        return this.$el;
    },

    pickUp: function (model) {
        if (model != null) {
            if (model.get('checked')) {
                this.trigger('callback', {a: model.get('userID'), b: model.get('name')});
            }
        }
    },

    fetch: function () {
        jQuery("#allUsersPaginator").pagination('selectPage', 1);
        jQuery("#addUsersButton").hide();
        jQuery("#noUsersLabel").hide();
        this.collection.fetch({reset: true, certificateID: this.certificateID});
    },

    setCertificateID: function (certificateID) {
        this.certificateID = certificateID
    }
});

// user dialog

LiferayUserSelectDialog = Backbone.View.extend({
    events: {
        "click #userSearchButton": "searchButtonClick"
    },
    callback: function (userID, name) {
    },
    initialize: function () {
        this.$el.dialog({
            autoOpen: false,
            modal: true,
            width: 1200,
            height: 790,
            resizable: false
        });

        this.model = new LiferayFilterModel();
        this.model.on('change', this.render, this);
        this.model.fetch({reset: true});
    },
    render: function () {
        var renderedTemplate = Mustache.to_html(jQuery('#liferayUserDialogView').html(), this.options.language)
        this.$el.html(renderedTemplate);

        this.userListView = new LiferayUserList({el: jQuery('#allUsersList'), language: this.options.language});
        this.userListView.on('callback', this.callbackCall, this);
        this.userListView.on('clear', this.clear, this);
        this.userListView.on('close', function () {
            this.$el.dialog('close')
        }, this);

        var organizations = this.model.get('organizations');
        for (var item in organizations) {
            jQuery("#userOrganization").append('<option value="' + item.orgID + '"> ' + item.name + ' </option>');
        }

    },
    callbackCall: function (user) {
        this.callback(user.a, user.b);
    },
    searchButtonClick: function () {
        this.userListView.fetch();
    },
    choose: function (certificateID, onChoose) {
        this.userListView.setCertificateID(certificateID);
        this.callback = onChoose;
        this.clear();
        this.$el.dialog('open');
    },
    clear: function () {
        this.$("#userSearch").val('');
        this.$("#sortUser").val('asc');
        this.$("#userOrganization").val('-1');
        this.userListView.fetch();
    }
});
