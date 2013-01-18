ScopeRuleModel = Backbone.Model.extend({
    defaults:{
        title:"",
        summary:"",
        visibility: true
    }
});

_.extend(ScopeRuleModel.prototype, {
    storage:{
        create:function (model) {
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "services/packages/updatePackageScopeVisibility/" + model.id + "?courseID=" + jQuery("#courseID").val() + "&scopeType=" + jQuery("#scopeOptions").val() + "&pageID=" + jQuery("#pageID").val() + "&playerID=" + jQuery("#playerID").val(), model.toJSON());
        },

        find:function (model) {
        },

        destroy:function (model) {
        }
    }
});

ScopeRuleModelCollection = Backbone.Collection.extend({
    model:ScopeRuleModel,
    storage:{
        findAll:function () {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/packages/getByScope" + "?courseID=" + jQuery("#courseID").val()+ "&pageID=" + jQuery("#pageID").val() + "&playerID=" + jQuery("#playerID").val() + "&scope=" + jQuery("#scopeOptions").val());
        }
    }
});