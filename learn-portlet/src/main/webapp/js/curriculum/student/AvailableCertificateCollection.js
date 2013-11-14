AvailableCertificateService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
            return "/services/certificating/availableForStudent/" + jQuery("#studentID").val() +
                "?companyID=" + jQuery("#companyID").val() + "&page="+ jQuery("#allCertificatesPaginator").pagination('getCurrentPage') +
            "&count="+10+"&filter="+jQuery("#certificateSearch").val()+"&sortAZ=" + jQuery("#sortAZ").val();
        }
    }
});


AvailableCertificateCollection = Backbone.Collection.extend({
    model:Certificate,
    parse : function( response ){
        this.trigger("collection:updated", { total : response.total, currentPage : response.currentPage } );
        return response.records;
    }
}).extend(AvailableCertificateService);

