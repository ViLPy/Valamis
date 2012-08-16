CategoryModel = Backbone.Model.extend({
    defaults:{
        title:"New category",
        description:"",
        parentID:null,
        newModel:false
    },
    move:function (options, callback) {
        jQuery.when(this.storage.move(this, options)).done(callback)
    }
});

_.extend(CategoryModel.prototype, {
    storage:{
        create:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/category/", model.toJSON());
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/category/update/" + model.id, model.toJSON());
        },

        move:function (model, options) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/category/move/" + model.id, _.extend(model.toJSON(), options));
        },

        find:function (model) {
        },

        findAll:function () {
        },

        destroy:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/category/delete/" + model.id);
        }
    }
});