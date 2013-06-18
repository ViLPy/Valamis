PackageModel = Backbone.Model.extend({
    defaults:{
        isDefault: false,
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
            return window.LearnAjax.post(Utils.getContextPath() + "services/packages/update/" + model.id + "?courseID=" + jQuery("#courseID").val() + "&scopeType=" + jQuery("#adminScopeSelect").val() , model.toJSON());
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
            if (jQuery("#adminScopeSelect").val() == "siteScope")
            return window.LearnAjax.get(Utils.getContextPath() + "/services/packages/allInSite" + "?courseID=" + jQuery("#courseID").val());
            else return window.LearnAjax.get(Utils.getContextPath() + "/services/packages/all");
        }
    }
});