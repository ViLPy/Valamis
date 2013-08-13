AvailableCertificateService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
            return "/services/certificating/availableForStudent/" + jQuery("#studentID").val();
        }
    }
});


AvailableCertificateCollection = Backbone.Collection.extend({
    model:Certificate
}).extend(AvailableCertificateService);

