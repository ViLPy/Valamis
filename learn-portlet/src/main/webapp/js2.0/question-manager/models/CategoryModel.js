CategoryService = new Backbone.Service({ url: path.root,
  targets: {
    'move': {
      'path': function (model) {
        return path.api.category + model.id;
      },
      'data': function (model, options) {
          var params = {
              action: 'move',
              courseId: Utils.getCourseId()
          };
          _.extend(params, model.toJSON());
          _.extend(params, options);

          return params;
      },
        'method': 'post'
    }
  },
  sync: {
    'read': {
        'path': path.api.category,
        'data': function(model){
            var params = {
                parentId: model.get('id'),
                courseId: Utils.getCourseId()
            };
            return params;
        },
        'method': 'get'
    },
    'create': {
      'path': path.api.category,
        'data': function(model){
            var params = {
                action: 'add',
                courseId: Utils.getCourseId()
            };
            _.extend(params, model.toJSON());
            return params;
        },
      'method': 'post'
    },
    'update': {
        'path': function (model) {
                return path.api.category + model.id
            },
        'data': function(model){
            var params = {
                action: 'update',
                courseId: Utils.getCourseId()
            };
            _.extend(params, model.toJSON());
            return params;
        },
        'method': 'post'
    },
    'delete': {
        'path': function (model) {
          return path.api.category + model.id
        },
        'data': function(model){
            var params = {
                action: 'delete',
                courseId: Utils.getCourseId()
            };
            _.extend(params, model.toJSON());
            return params;
        },
        'method': 'post'
    }
  }
});

CategoriesService = new Backbone.Service({ url: path.root,
    sync: {
        'read': {
            'path': path.api.category,
            'data': function(id){
                var params = {
                    parentId: id,
                    courseId: Utils.getCourseId()
                };

                return params;
            },
            'method': 'get'
        }
    }
});

CategoryModel = Backbone.Model.extend({
  defaults: {
    title: 'New category',
    description: '',
    contentType: '',
    children: [],
    parentId: -1
  }
}).extend(CategoryService);
