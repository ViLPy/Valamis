PlayerPackageModel = Backbone.Model.extend({
    defaults:{
        title:"",
        summary:"",
        version:"2004 4th Edition"
    }
});

_.extend(PlayerPackageModel.prototype, {
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

PlayerPackageModelCollection = Backbone.Collection.extend({
    model:PlayerPackageModel,

    storage:{
        findAll:function () {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/packages/");
        }
    }
});