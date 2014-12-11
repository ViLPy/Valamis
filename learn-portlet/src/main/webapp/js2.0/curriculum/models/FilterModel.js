LiferayOrganizationModel = Backbone.Model.extend({
  defaults: {
    'id': '',
    'name': ''
  }
});

LiferayOrganizationCollectionService = new Backbone.Service({ url: path.root,
  sync: {
    'read': function () {
      return  path.api.users + 'orgs';
    }
  }
});

LiferayOrganizationCollection = Backbone.Collection
    .extend({
        model: LiferayOrganizationModel
    })
    .extend(LiferayOrganizationCollectionService);