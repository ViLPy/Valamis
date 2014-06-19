CategoryService = new Backbone.Service({ url: Utils.getContextPath,
  targets: {
    'move': {
      'path': function (model) {
        return 'api/category/' + model.id + '?action=move';
      },
      'method': 'post',
      'data': function (model, options) {
        return _.extend(model.toJSON(), options);
      }
    }
  },
  sync: {
    'create': {
      'path': function () {
        return 'api/category/?action=add&courseID=' + Utils.getCourseID();
      },
      'method': 'post'
    },
    'update': {
      'path': function (model) {
        return 'api/category/' + model.id + '?action=update';
      },
      'method': 'post'
    },
    'delete': {
      'path': function (model) {
        return 'api/category/' + model.id + '?action=delete';
      },
      'method': 'post'
    }
  }
});

CategoryModel = Backbone.Model.extend({
  defaults: {
    title: 'New category',
    description: '',
    parentID: null
  }
}).extend(CategoryService);