PackageModel = Backbone.Model.extend({
    defaults:{
        title:"",
        summary:""
    }
});

_.extend(PackageModel.prototype, {
    storage:{
        create:function (model) {
        },

        update:function (model) {
        },

        find:function (model) {
        },

        destroy:function (model) {
        }
    }
});

PackageModelCollection = Backbone.Collection.extend({
    model:PackageModel,

    storage:{
        findAll:function () {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/packages/");
        }
    }
});