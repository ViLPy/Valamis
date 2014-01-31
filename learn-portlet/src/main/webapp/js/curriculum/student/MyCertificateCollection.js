MyCertificateCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
           return  "/services/certificating/getByUser/" + jQuery("#studentID").val() + "?rootUrl=" + jQuery("#rootUrl").val() +
               "&page="+ jQuery("#myCertificatesPaginator").pagination('getCurrentPage') + "&count="+10;
               //+"&filter="+jQuery("#certificateSearch").val()+"&sortAZ=" + jQuery("#sortAZ").val();
        }
    }
});

MyCertificateCollection = Backbone.Collection.extend({
    model:Certificate,
    parse : function( response ){
        this.trigger("certificateCollection:updated", { total : response.total, currentPage : response.currentPage } );
        return response.records;
    }
}).extend(MyCertificateCollectionService);