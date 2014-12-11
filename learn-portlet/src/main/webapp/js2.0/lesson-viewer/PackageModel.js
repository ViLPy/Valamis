PlayerPackageModel = Backbone.Model.extend({
  defaults: {
    title: '',
    summary: '',
    version: '2004 4th Edition',
    visibility: true,
    type: 'undefined'
  }
});

PlayerPackageCollectionService = new Backbone.Service({ url: path.root,
  sync: {
    'read': function (e, options) {
      var order = jQuery('#playerPackageOrder').val();
      var sortBy = order.split(':')[0]
      var asc = order.split(':')[1]
      return path.api.packages + '?action=VISIBLE' +
        '&page=' + options.currentPage +
        '&count=' + options.itemsOnPage +
        '&courseID=' + Utils.getCourseID() +
        '&pageID=' + jQuery('#pageID').val() +
        '&playerID=' + jQuery('#playerID').val() +
        '&filter=' + jQuery('#playerPackageFilter').val() +
        '&sortBy=' + sortBy +
        '&sortAscDirection=' + asc;
    }
  }
});

PlayerPackageModelCollection = Backbone.Collection.extend({
  model: PlayerPackageModel,
  parse: function (response) {
      this.trigger('packageCollection:updated', { total: response.total, currentPage: response.currentPage });
      return response.records;
  }
}).extend(PlayerPackageCollectionService);