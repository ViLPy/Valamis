CertificateSiteService = new Backbone.Service({ url: Utils.getContextPath,
        sync: {
            'delete': {
                'path': function (model) {
                    return "/services/certificating/sites/delete/" + model.id;
                },
                'method': "post"
            }
        }
})


CertificateSiteModel = Backbone.Model.extend({
    defaults:{
        certificateID:0,
        siteID:0,
        title:"Liferay Site",
        url:"",
        description:""
    }
}).extend(CertificateSiteService);
