CertificateUserService = new Backbone.Service({ url: Utils.getContextPath,
        sync: {
            'delete': {
                'path': function (model) {
                    return  "/services/certificating/users/delete/" + model.id;
                },
                'method': "post"
            }
        }
})

CertificateUserModel = Backbone.Model.extend({
    defaults:{
        certificateID:0,
        userID:0,
        name:"",
        email:""
    }
}).extend(CertificateUserService);


