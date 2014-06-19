UserAccountService = new Backbone.Service({ url:Utils.getContextPath,
    sync:{
        'read':{
            'path':function (model) {
                return "api/users/" + jQuery("#userID").val() + "?withOpenBadges=true&resultAs=none";
            }
        }
    }
});


UserAccountModel = Backbone.Model.extend({
    defaults:{
        userID:"",
        name:""
    }
}).extend(UserAccountService);
