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
            var sortAZ = true;
            if (jQuery("#sortAZ").val() != undefined) sortAZ = jQuery("#sortAZ").val();
            return "/services/certificating?page="+ jQuery("#allCertificatesPaginator").pagination('getCurrentPage') +
                "&count="+10+"&filter="+jQuery("#certificateSearch").val()+"&sortAZ=" + sortAZ;
        }
    }
});

CertificateCollection = Backbone.Collection.extend({
    model: Certificate,
    parse : function( response ){
        this.trigger("collection:updated", { total : response.total, currentPage : response.currentPage } );
        return response.records;
    }
}).extend(CertificateCollectionService);

