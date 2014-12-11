LessonService = new Backbone.Service({  url: path.root,
  sync: {
    create: {
      path: function () {
        return path.api.quiz + '?action=ADD'
          + '&courseID=' + GLOBAL_courseID;
      },
      'method': 'post'
    },
    update: {
      path: function () {
        return path.api.quiz + '?action=UPDATE'
      },
      'method': 'post'
    }
  },
  targets: {
    publish: {
      'path': function (model) {
        return path.api.quiz + '?action=PUBLISH'
          + '&id=' + model.id
          + '&groupID=' + GLOBAL_groupID;
        +'&courseID=' + GLOBAL_courseID;
      },
      'method': 'post'
    },
    clone: {
      'path': function (model) {
        return path.api.quiz + '?action=CLONE'
          + '&id=' + model.id;
      },
      'method': 'post'
    },
    deleteLesson: {
      'path': function (model) {
        return path.api.quiz + '?action=DELETE'
          + '&id=' + model.id;
      },
      'method': 'post'
    },
    updateLogo: {
      'path': function (model) {
        return path.api.quiz + '?action=UPDATELOGO&id=' + model.id;
      },
      'method': 'post'
    }
  }
});

var LessonModel = Backbone.Model.extend({
  defaults: {
    title: 'New lesson',
    description: 'New description',
    logo: ''
  }
}).extend(LessonService);

var LessonCollection = Backbone.Collection.extend({
  model: LessonModel
});