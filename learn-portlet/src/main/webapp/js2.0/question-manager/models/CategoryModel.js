CategoryService = new Backbone.Service({ url: path.root,
  targets: {
    'move': {
      'path': function (model) {
        return path.api.category + model.id + '?action=move';
      },
      'method': 'post',
      'data': function (model, options) {
        return _.extend(model.toJSON(), options);
      }
    }
  },
  sync: {
    'read': {
        'path': function(model){
            return path.api.category + '?parentId=' + model.id + '&courseID=' + Utils.getCourseID();
        },
        'method': 'get'
    },
    'create': {
      'path': function () {
        return path.api.category + '?action=add&courseID=' + Utils.getCourseID();
      },
      'method': 'post'
    },
    'update': {
      'path': function (model) {
        return path.api.category + model.id + '?action=update';
      },
      'method': 'post'
    },
    'delete': {
      'path': function (model) {
        return path.api.category + model.id + '?action=delete&courseID=' + Utils.getCourseID();
      },
      'method': 'post'
    }
  }
});

CategoriesService = new Backbone.Service({ url: path.root,
    sync: {
        'read': {
            'path': function(id){
                return path.api.category + '?parentId='+id+'&courseID=' + Utils.getCourseID();
            },
            'method': 'get'
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