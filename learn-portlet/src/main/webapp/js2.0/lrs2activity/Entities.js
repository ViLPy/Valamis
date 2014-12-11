LRS2ActivityMapperApp.module("Entities", function(Entities, LRS2ActivityMapperApp, Backbone, Marionette, $, _){
  Entities.EntityModelService = new Backbone.Service({ url: path.root,
    sync: {
      'create': {
        'path': function () {
          return path.api.lrs2activity + '?action=add&courseID=' + Utils.getCourseID();
        },
        'method': 'post'
      },
      'update': {
        'path': function (model) {
          return path.api.lrs2activity + '?action=update';
        },
        'method': 'post'
      },
      'delete': {
        'path': function (model) {
          return path.api.lrs2activity + '?action=delete';
        },
        'method': 'post'
      }
    }
  });

  Entities.EntityCollectionService = new Backbone.Service({ url: path.root,
    sync: {
      'read': {
        'path': function () {
          return path.api.lrs2activity + Utils.getCourseID();
        },
        'method': 'get'
      }
    }
  });

  Entities.ActivityMapperModel = Backbone.Model.extend({
    defaults: {
      title: 'new rule',
      courseID: 0,
      mappedActivity: null,
      mappedVerb: null
    }
  }).extend(Entities.EntityModelService);

  Entities.ActivityMapperModelCollection = Backbone.Collection.extend({
    model: Entities.ActivityMapperModel
  }).extend(Entities.EntityCollectionService);

  var collection = new Entities.ActivityMapperModelCollection();

  LRS2ActivityMapperApp.reqres.setHandler('event:list', function () {
    return collection;
  });

  LRS2ActivityMapperApp.reqres.setHandler('event:get', function (id) {
    return collection.get(id);
  });

  Entities.on('start', function () {
    collection.fetch();
  });
});