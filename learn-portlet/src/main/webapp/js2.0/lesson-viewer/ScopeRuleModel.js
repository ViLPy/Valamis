ScopeRuleService = new Backbone.Service({ url: path.root,
  targets: {
    'addToPlayer': {
      'path': function () {
        return path.api.packages + 'addPackageToPlayer/' + jQuery('#playerID').val()
      },
      'method': 'post'
    }
  },
  sync: {
    'update': {
      'path': function (model) {
        return path.api.packages + 'updatePackageScopeVisibility/' + model.id + '?courseID=' + Utils.getCourseID() + '&scope=' + jQuery('#scopeOptions').val() + '&pageID=' + jQuery('#pageID').val() + '&playerID=' + jQuery('#playerID').val();
      },
      'method': 'post'
    }
  }
});

ScopeRuleModel = Backbone.Model.extend({
  defaults: {
    title: '',
    summary: '',
    visibility: true,
    isdefault: false
  }
}).extend(ScopeRuleService);


ScopeRuleCollectionService = new Backbone.Service({ url: path.root,
  sync: {
    'read': function (collection, options) {
      if (options.isPersonalOnly)
        return path.api.packages + 'getPersonalForPlayer?playerID=' + jQuery('#playerID').val();
      else
        return path.api.packages + 'getByScope?courseID=' + Utils.getCourseID() + '&pageID=' + jQuery('#pageID').val() + '&playerID=' + jQuery('#playerID').val() + '&scope=' + jQuery('#scopeOptions').val();

    }
  }
});

ScopeRuleModelCollection = Backbone.Collection.extend({
  model: ScopeRuleModel
}).extend(ScopeRuleCollectionService);