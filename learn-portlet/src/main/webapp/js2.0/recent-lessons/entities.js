recentLessons.module('Entities', function(Entities, recentLessons, Backbone, Marionette, $, _) {

  var RecentCollectionService = new Backbone.Service({
    url: path.root,
    sync: {
      'read': {
        'path': function (model, options) {
          return path.api.packages+'getLastOpen';
        },
        'data': function (collection, options) {
          var params = {
            courseId: Utils.getCourseId(),
            countPackage: 4
          };
          return params;
        },
        'method': 'get'
      }
    }
  });

  Entities.RecentCollection = Backbone.Collection.extend({
    model: Backbone.Model.extend({})
  }).extend(RecentCollectionService);

});