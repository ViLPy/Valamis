var UserAccountService = new Backbone.Service({ url: path.root,
    sync:{
        'read':{
            'path':function (model) {
                return path.api.users + jQuery("#userID").val() + "?withOpenBadges=true&resultAs=none";
            }
        }
    }
});


var UserAccountModel = Backbone.Model.extend({
    defaults:{
        userID:"",
        name:""
    }
}).extend(UserAccountService);
