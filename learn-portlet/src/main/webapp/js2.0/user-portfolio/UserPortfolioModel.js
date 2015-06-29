var UserAccountService = new Backbone.Service({ url: path.root,
    sync:{
        'read':{
            path: function (model, options) {
                return path.api.users + options.data.userId;
            },
            'data': function () {
                return {
                    withOpenBadges: 'true',
                    resultAs: 'none',
                    courseId: Utils.getCourseId()
                }
            },
            'method': 'get'
        }
    }
});


var UserAccountModel = Backbone.Model.extend({
    defaults:{
        userID:"",
        name:""
    }
}).extend(UserAccountService);
