valamisActivities.module('Entities', function(Entities, valamisActivities, Backbone, Marionette, $, _) {

  var ActivitiesModelService = new Backbone.Service({
    url: path.root,
    targets: {
      'likeActivity': {
        'path': path.api.valamisActivityLike,
        'data': function (model) {
          var params = {
            action: 'CREATE',
            userId: Valamis.currentUserId,
            activityId: model.get('id')
          };
          return params;
        },
        'method': 'post'
      },
      'unlikeActivity': {
        'path': path.api.valamisActivityLike,
        'data': function (model) {
          var params = {
            action: 'DELETE',
            userId: Valamis.currentUserId,
            activityId: model.get('id')
          };
          return params;
        },
        'method': 'post'
      },
      'commentActivity': {
        'path': path.api.valamisActivityComment,
        'data': function (model, options) {
          var params = {
            action: 'CREATE',
            userId: Valamis.currentUserId,
            activityId: model.get('id'),
            content: options.content
          };
          return params;
        },
        'method': 'post'
      },
      shareActivity: {
        'path': path.api.valamisActivity,
        'data': function(model){
          var params =  {
            action: 'SHARELESSON' ,
            packageId: model.get('obj')['id'],
            courseId: Utils.getCourseId()
          };
          return params;
        },
        'method': 'post'
      }
    }
  });

  Entities.ActivitiesModel = Backbone.Model.extend({
    parse: function (response) {
      var currentUserLike = false;
      _.forEach(response['userLiked'], function(item) {
        if (item['id'] === Valamis.currentUserId)
          currentUserLike = true;
      });
      response['currentUserLike'] = currentUserLike;
      return response;
    }
  }).extend(ActivitiesModelService);

  var ActivitiesCollectionService = new Backbone.Service({
    url: path.root,
    sync: {
      'read': {
        'path': path.api.valamisActivity,
        'method': 'get'
      }
    }
  });

  Entities.ActivitiesCollection = Backbone.Collection.extend({
    model: Entities.ActivitiesModel
  }).extend(ActivitiesCollectionService);

  var LiferayUserModelService = new Backbone.Service({
    url: path.root,
    sync: {
      'read': {
        'path': function (model, options) {
          return path.api.users + options.userId;
        },
        'data': function (collection) {
          var params = {
            courseId: Utils.getCourseId(),
            resultAs: 'detailed'
          };
          return params;
        },
        'method': 'get'
      }
    },
    targets: {
      'postStatus': {
        'path': path.api.valamisActivity,
        'data': function (model, options) {
          var params = {
            action: 'CREATEUSERSTATUS',
            content: options.content
          };
          return params;
        },
        'method': 'post'
      }
    }
  });

  Entities.LiferayUserModel = Backbone.Model.extend({
    parse: function (response) {
      delete response['certificates'];
      return response;
    }
  }).extend(LiferayUserModelService);

  Entities.LiferayUserCollection = Backbone.Collection.extend({
    model: Entities.LiferayUserModel
  });

});