learningPaths.module('Entities', function(Entities, learningPaths, Backbone, Marionette, $, _) {

  var CertificateService = new Backbone.Service({
    url: path.root,
    sync: {
      'read': {
        'path': function (model) {
          return path.api.certificates + model.id + '?action=GETBYID'+
            '&courseId=' + Utils.getCourseId();
        }
      }
    }
  });

  Entities.CertificateModel = Backbone.Model.extend({
  }).extend(CertificateService);

  var CertificateCollectionService = new Backbone.Service({
    url: path.root,
    sync: {
      'read': {
        'path': function (collection, options) {
          return path.api.certificates;
        },
        'data': function (collection, options) {
          return {
            courseId: Utils.getCourseId(),
            action: 'GETCERTIFICATESTATES',
            statuses: ['inprogress', 'failed']
          }
        },
        'method': 'get'
      }
    }
  });

  Entities.CertificateCollection = Backbone.Collection.extend({
    model: Entities.CertificateModel
  }).extend(CertificateCollectionService);


  var UserGoalModelService = new Backbone.Service({
    url: path.root,
    sync: {
      'read': {
        'path': function (model, options) {
          return path.api.users + options.userId + '/certificates/'+ options.certificateId + '/goals';
        },
        method: 'get'
      }
    }
  });

  Entities.UserGoalModel = Backbone.Model.extend({
  }).extend(UserGoalModelService);

  Entities.UserGoalCollection = Backbone.Collection.extend({
    model: Backbone.Model.extend({})
  });

});