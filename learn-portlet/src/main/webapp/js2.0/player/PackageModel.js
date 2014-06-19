PlayerPackageModel = Backbone.Model.extend({
  defaults: {
    title: '',
    summary: '',
    version: '2004 4th Edition',
    visibility: true,
    type: 'undefined'
  }
});

PlayerPackageCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'read': function () {
      var order = jQuery('#playerPackageOrder').val();
      var sortBy = order.split(':')[0]
      var asc = order.split(':')[1]
      return 'services/packages?' +
        'courseID=' + Utils.getCourseID() +
        '&pageID=' + jQuery('#pageID').val() +
        '&playerID=' + jQuery('#playerID').val() +
        '&filter=' + jQuery('#playerPackageFilter').val() +
        '&sortBy=' + sortBy +
        '&sortAscDirection=' + asc;
    }
  }
});

PlayerPackageModelCollection = Backbone.Collection.extend({
  model: PlayerPackageModel
}).extend(PlayerPackageCollectionService);