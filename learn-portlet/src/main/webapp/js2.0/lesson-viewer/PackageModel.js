PlayerPackageModelService = new Backbone.Service({
  url: path.root,
  targets: {
    sharePackage: {
      'path': path.api.valamisActivity,
      'data': function(model, options){
        var params =  {
          action: 'SHARELESSON',
          packageId: model.get('id'),
          comment: options.comment,
          courseId: Utils.getCourseId()
        };
        return params;
      },
      'method': 'post'
    }
  }
});

PlayerPackageModel = Backbone.Model.extend({
  defaults: {
    title: '',
    summary: '',
    version: '2004 4th Edition',
    visibility: true,
    type: 'undefined'
  }
}).extend(PlayerPackageModelService);

PlayerPackageCollectionService = new Backbone.Service({ url: path.root,
  sync: {
    'read': {
      'path': path.api.packages,
      'data': function (e, options) {
        var order = jQueryValamis('#playerPackageOrder').data('value');
        var sortBy = order.split(':')[0];
        var asc = order.split(':')[1];
        var tagID = jQueryValamis('#playerPackageTags').data('value');
        return {
          action: 'VISIBLE',
          page: options.currentPage,
          count: options.itemsOnPage,
          courseId: Utils.getCourseId(),
          pageID: jQueryValamis('#pageID').val(),
          playerID: jQueryValamis('#playerID').val(),
          filter: jQueryValamis('#playerPackageFilter').val(),
          sortBy: sortBy,
          sortAscDirection: asc,
          tagID: tagID

        }
      },
      'method': 'get'
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
