LiferayOrganizationModel = Backbone.Model.extend({
  defaults: {
    'id': '',
    'name': ''
  }
});

LiferayOrganizationCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'read': function () {
      return  'api/users/orgs';
    }
  }
});

LiferayOrganizationCollection = Backbone.Collection.extend({
  model: LiferayOrganizationModel
}).extend(LiferayOrganizationCollectionService);