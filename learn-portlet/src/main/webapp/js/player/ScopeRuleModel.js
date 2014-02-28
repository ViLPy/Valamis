ScopeRuleService = new Backbone.Service({ url: Utils.getContextPath,
    targets: {
        'addToPlayer': {
            'path': function(){
                return "services/packages/addPackageToPlayer/" + jQuery("#playerID").val()
            },
            'method': 'post'
        }
    },
    sync: {
        'update': {
            'path': function (model) {
                return "services/packages/updatePackageScopeVisibility/" + model.id + "?courseID=" + Utils.getCourseID() + "&scopeType=" + jQuery("#scopeOptions").val() + "&pageID=" + jQuery("#pageID").val() + "&playerID=" + jQuery("#playerID").val();
            },
            'method': "post"
        }
    }
});

ScopeRuleModel = Backbone.Model.extend({
    defaults: {
        title: "",
        summary: "",
        visibility: true,
        isDefault: false
    }
}).extend(ScopeRuleService);


ScopeRuleCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function (collection, options) {
            if (options.isPersonalOnly)
                return "/services/packages/getPersonalForPlayer/" + jQuery("#playerID").val();
            else
                return "/services/packages/getByScope?courseID=" + Utils.getCourseID() + "&pageID=" + jQuery("#pageID").val() + "&playerID=" + jQuery("#playerID").val() + "&scope=" + jQuery("#scopeOptions").val();

        }
    }
});

ScopeRuleModelCollection = Backbone.Collection.extend({
    model: ScopeRuleModel
}).extend(ScopeRuleCollectionService);