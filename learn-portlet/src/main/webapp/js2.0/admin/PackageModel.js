PackageService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'update': {
      'path': function (model) {
        if (model.get('type') == 'tincan') {
          return 'services/tincan-packages/update/' + model.id + '?courseID=' + Utils.getCourseID() + '&scopeType=' + jQuery('#adminScopeSelect').val();
        } else {
          return 'services/packages/update/' + model.id + '?courseID=' + Utils.getCourseID() + '&scopeType=' + jQuery('#adminScopeSelect').val();
        }
      },
      'method': 'post'
    },
    'delete': {
      'path': function (model) {
        if (model.get('type') == 'tincan') {
          return '/services/tincan-packages/delete'
        } else {
          return '/services/packages/delete'
        }
      },
      'method': 'post'
    }
  }
});

PackageModel = Backbone.Model.extend({
  defaults: {
    isDefault: false,
    title: '',
    summary: '',
    visibility: true,
    type: 'undefined'
  }
}).extend(PackageService);

PackageCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'read': function () {
      if (jQuery('#adminScopeSelect').val() == 'siteScope')
        return '/services/packages/allInSite?courseID=' + Utils.getCourseID();
      else
        return '/services/packages/all';
    }
  }
});

PackageModelCollection = Backbone.Collection.extend({
  model: PackageModel
}).extend(PackageCollectionService);