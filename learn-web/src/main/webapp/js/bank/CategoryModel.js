CategoryService = new Backbone.Service({ url: Utils.getContextPath,
    targets: {
        'move': {
            'path': function (model) {
                return "/services/category/move/" + model.id;
            },
            'method': "post",
            'data': function(model, options){
                return _.extend(model.toJSON(), options);
            }
        }
    },
    sync: {
        'create': {
            'path': function () {
                return "/services/category/?courseID=" + Utils.getCourseID();
            },
            'method': "post"
        },
        'update': {
            'path': function (model) {
                return "/services/category/update/" + model.id;
            },
            'method': "post"
        },
        'delete': {
            'path': function (model) {
                return "/services/category/delete/" + model.id;
            },
            'method': "post"
        }
    }
});

CategoryModel = Backbone.Model.extend({
    defaults:{
        title:"New category",
        description:"",
        parentID:null,
        newModel:false
    }
}).extend(CategoryService);