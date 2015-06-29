LRS2ActivityMapperApp.module("Entities", function(Entities, LRS2ActivityMapperApp, Backbone, Marionette, $, _){
  Entities.EntityModelService = new Backbone.Service({ url: path.root,
    sync: {
      'create': {
        path: path.api.lrs2activity,
        'data': function (model) {
          parameters = {
            action: 'add',
            courseId: Utils.getCourseId()
          }
          _.extend(parameters, model.toJSON())
          return parameters
        },
        'method': 'post'
      },
      'update': {
        path: path.api.lrs2activity,
        'data': function (model) {
          parameters = {
              action: 'update',
              courseId: Utils.getCourseId()
          }
          _.extend(parameters, model.toJSON())
          return parameters
        },
        'method': 'post'
      },
      'delete': {
        path: path.api.lrs2activity,
        'data': function (model) {
          parameters= {
              action: 'delete',
              courseId:  Utils.getCourseId()
          }
          _.extend(parameters, model.toJSON())
          return parameters
        },
        'method': 'post'
      }
    }
  });

  Entities.EntityCollectionService = new Backbone.Service({ url: path.root,
    sync: {
      'read': {
        path: path.api.lrs2activity,
        'data': function (model) {
          return {
            courseId: Utils.getCourseId()
          }
        },
        'method': 'get'
      }
    }
  });

  Entities.ActivityMapperModel = Backbone.Model.extend({
    defaults: {
      title: 'new rule',
      courseId: 0,
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