myLessons.module('Entities', function(Entities, myLessons, Backbone, Marionette, $, _) {

  Entities.LessonModel = Backbone.Model.extend({
  });

  var LessonCollectionService = new Backbone.Service({
    url: path.root,
    sync: {
      'read': {
        'path': path.api.gradebooks,
        'data': function (model, options) {
          return {
            action: 'GRADED_PACKAGE',
            courseId: Utils.getCourseId()
          };
        },
        'method': 'get'
      }
    }
  });

  Entities.LessonCollection = Backbone.Collection.extend({
    model: Entities.LessonModel
  }).extend(LessonCollectionService);

});