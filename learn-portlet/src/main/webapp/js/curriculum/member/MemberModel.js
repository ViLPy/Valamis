MemberService = new Backbone.Service({ url:Utils.getContextPath,
    sync:{
        'create':{
            'path':function () {
                return "/services/certificating/users/addUser";
            },
            'method':"post"
        },
        'delete':{
            'path':function (model) {
                return "/services/certificating/users/removeUser/" + model.get('certificateID');
            },
            'method':"post"
        }
    }
});

Member = Backbone.Model.extend({
    defaults:{
        certificateID:0,
        userID:0,
        name:"",
        portrait:""
    }
}).extend(MemberService);


MemberCollectionService = new Backbone.Service({ url:Utils.getContextPath,
    sync:{
        'read':function (collection, options) {
            return "/services/certificating/users/" + options.certificateID;
        }
    }
});


MemberCollection = Backbone.Collection.extend({
    model:Member
}).extend(MemberCollectionService);

