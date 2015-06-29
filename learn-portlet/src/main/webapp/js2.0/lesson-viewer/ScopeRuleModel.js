ScopeRuleService = new Backbone.Service({ url: path.root,
  targets: {
    'addToPlayer': {
      path: function () {
        return path.api.packages + 'addPackageToPlayer/' + jQueryValamis('#playerID').val();
      },
      'data': function (model) {
        return {
            id: model.get('id'),
            courseId: Utils.getCourseId()
        }
      },
      'method': 'post'
    }
  },
  sync: {
    'update': {
      path: function (model) {
        return  path.api.packages + 'updatePackageScopeVisibility/' + model.id;
      },
      'data': function (model) {
        return {
            courseId: Utils.getCourseId(),
            scope: jQueryValamis('#scopeOptions').val(),
            pageID: jQueryValamis('#pageID').val(),
            playerID: jQueryValamis('#playerID').val(),
            isDefault: model.get('isDefault'),
            visibility: model.get('visibility')
        }
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
    isDefault: false
  }
}).extend(ScopeRuleService);


ScopeRuleCollectionService = new Backbone.Service({ url: path.root,
  sync: {
    'read': function (collection, options) {
      if (options.isPersonalOnly)
        return path.api.packages + 'getPersonalForPlayer?playerID=' + jQueryValamis('#playerID').val() + '&courseId=' + Utils.getCourseId();
      else
        return path.api.packages + 'getByScope?courseId=' + Utils.getCourseId() + '&pageID=' + jQueryValamis('#pageID').val() + '&playerID=' + jQueryValamis('#playerID').val() + '&scope=' + jQueryValamis('#scopeOptions').val();

    }
  }
});

ScopeRuleModelCollection = Backbone.Collection.extend({
  model: ScopeRuleModel
}).extend(ScopeRuleCollectionService);