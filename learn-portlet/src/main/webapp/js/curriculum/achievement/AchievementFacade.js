AchiviementFacade = new Backbone.Service({
    url: Utils.getContextPath,
    sync: {
        create: {
            'path': function(){
                return "/services/achievement?companyID=" + jQuery("#companyID").val();
            },
            'method' : "post"
        },
        update: {
            'path': function (model) {
                return "/services/achievement/update/" + model.id;
            },
            'method': "post"
        },
        read: {
            'path': function (model) {
                return "/services/achievement/" + model.id;
            },
            method: "get"
        },
        delete: {
            'path': function (model) {
                return "/services/achievement/delete/" + model.id;
            },
            'method': "post"
        }
    }
})

Achievement = Backbone.Model.extend({
    defaults:{
        title:"New achievement",
        description:"Achievement info",
        sitesCount:0,
        usersCount:0
    }
}).extend(AchiviementFacade);