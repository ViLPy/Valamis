PackageModel = Backbone.Model.extend({
    defaults:{
        title:"",
        summary:"",
        visibility:true
    }
});

_.extend(PackageModel.prototype, {
    storage:{
        create:function (model) {
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "services/packages/update/" + model.id, model.toJSON());
        },

        find:function (model) {

        },

        destroy:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/packages/delete", model.toJSON());
        }
    }
});

PackageModelCollection = Backbone.Collection.extend({
    model:PackageModel,

    storage:{
        findAll:function () {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/packages/all");
        }
    }
});