LiferayUserModel = Backbone.Model.extend({
    defaults:{
        userID:"",
        name:""
    }
});

LiferayUserCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
           return  "services/liferay/user/";
        }
    }
});

LiferayUserCollection = Backbone.Collection.extend({
    model:LiferayUserModel
}).extend(LiferayUserCollectionService);


LiferayUserListElement = Backbone.View.extend({
    events:{
        "click #selectUserButton":"addThis"
    },
    initialize:function () {
        this.$el = jQuery('<div>');
    },
    render:function () {
        var template = Mustache.to_html(jQuery('#liferayUserElementView').html(), this.model.toJSON());
        this.$el.html(template);
        return this.$el;
    },
    addThis:function () {
        this.model.trigger('select', this.model);
    }
});

// Dialog

LiferayUserSelectDialog = Backbone.View.extend({
    events:{
        "click #sortUser":"sortList",
        "keyup #userSearch":"searchList"
    },
    callback:function (userID, name) {
    },
    initialize:function () {
        this.views = [];
        this.sortAZ = true;

        //this.collection = new LiferayUserCollection();
        this.collection.on('reset', this.addAll, this);
        this.collection.on('select', this.pickUp, this);
        this.$el.dialog({
            autoOpen:false,
            modal:true,
            width:350,
            height:400
        });

        this.render();

      //  alert("exists  " +  this.$('#userList').length > 0 + ", " + jQuery('#userList').length > 0);
      //  this.userList = this.$("#userList").List();
        //this.collection.fetch({reset: true});
    },
    addAll: function(){
        this.userList = this.$("#userList").List();
        this.collection.each(this.addUser, this);
    },
    addUser:function (user) {
        var view = new LiferayUserListElement({model:user});
        this.views[user.get('userID')] = view;
        var viewDOM = view.render();
        this.$('#userList').append(viewDOM);
        this.userList.add(user.get('userID'), viewDOM, {"name":user.get('name')}, false);
    },
    render:function () {
        var renderedTemplate = Mustache.to_html(jQuery('#liferayUserDialogView').html(), this.options.language)
        this.$el.html(renderedTemplate);
    },
    choose:function (onChoose) {
        this.callback = onChoose;
        this.clear();
        this.$el.dialog('open');
    },
    pickUp:function(model){
        this.callback(model.get('userID'), model.get('name'));
        this.clear();
       // this.$el.dialog('close');
    },
    clear: function(){
        this.$("#userSearch").val('');
        this.searchList();
    },
    searchList:function () {
        this.userList.filter(this.$("#userSearch").val() || "");
    },
    sortList:function () {
        if (this.userList) {
            this.userList.sort("name", this.sortAZ ? "asc" : "desc");
            var sortOrderString = (this.sortAZ) ? this.options.language['sortOrderAscLabel'] : this.options.language['sortOrderDescLabel'];
            this.$("#sortUser").html(sortOrderString);
            this.sortAZ = !this.sortAZ;
        }
    }

});

