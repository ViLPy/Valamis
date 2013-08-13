CertificateService = new Backbone.Service({ url: Utils.getContextPath,
        sync: {
            'create': {
                'path': "/services/certificating/",
                'method': "post"
            },
            'update': {
                'path': function (model) {
                    return "/services/certificating/update/" + model.id;
                },
                'method': "post"
            },
            'read': {
                'path': function (model) {
                    return "/services/certificating/" + model.id;
                }
            },
            'delete': {
                'path': function (model) {
                    return "/services/certificating/delete/" + model.id;
                },
                'method': "post"
            }
        }
})

Certificate = Backbone.Model.extend({
    defaults:{
        title:"New certificate",
        description:"Certificate info",
        sitesCount:0,
        usersCount:0
    }
}).extend(CertificateService);

CertificateCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
            return "/services/certificating/";
        }
    }
});

CertificateCollection = Backbone.Collection.extend({
    model: Certificate
}).extend(CertificateCollectionService);

