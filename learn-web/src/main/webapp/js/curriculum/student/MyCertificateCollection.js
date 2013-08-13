MyCertificateCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
           return  "/services/certificating/getByUser/" + jQuery("#studentID").val() + "?rootUrl=" + jQuery("#rootUrl").val() ;
        }
    }
});

MyCertificateCollection = Backbone.Collection.extend({
    model:Certificate
}).extend(MyCertificateCollectionService);