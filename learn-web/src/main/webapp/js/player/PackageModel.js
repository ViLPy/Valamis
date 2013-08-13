PlayerPackageModel = Backbone.Model.extend({
    defaults:{
        title:"",
        summary:"",
        version:"2004 4th Edition",
        visibility: true
    }
});

PlayerPackageCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
            return "/services/packages?courseID=" + Utils.getCourseID() + "&pageID=" + jQuery("#pageID").val() + "&playerID=" + jQuery("#playerID").val();
        }
    }
});

PlayerPackageModelCollection = Backbone.Collection.extend({
    model:PlayerPackageModel
}).extend(PlayerPackageCollectionService);