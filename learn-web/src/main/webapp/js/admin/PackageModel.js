PackageService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'update': {
            'path': function (model) {
                return "services/packages/update/" + model.id + "?courseID=" + Utils.getCourseID() + "&scopeType=" + jQuery("#adminScopeSelect").val();
            },
            'method': "post"
        },
        'delete': {
            'path': function () {
                return "/services/packages/delete"
            },
            'method': "post"
        }
    }
});

PackageModel = Backbone.Model.extend({
    defaults: {
        isDefault: false,
        title: "",
        summary: "",
        visibility: true
    }
}).extend(PackageService);

PackageCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
            if (jQuery("#adminScopeSelect").val() == "siteScope")
                return "/services/packages/allInSite?courseID=" + Utils.getCourseID();
            else
                return "/services/packages/all";
        }
    }
});

PackageModelCollection = Backbone.Collection.extend({
    model: PackageModel
}).extend(PackageCollectionService);