var SlideElementService = new Backbone.Service({ url: path.root,
    sync: {
        'read': function (e, options) {
            return path.api.slideEntities + '?slideId=' + model.get('slideId');
        },
        'delete': {
            'path': function (model) {
                return path.api.slideEntities;
            },
            'data': function(model){
                var params = _.extend(
                    model.toJSON(),
                    { action: 'DELETE' }
                );
                return params;
            },
            'method': 'post'
        },
        'update': {
            'path': path.api.slideEntities,
            'data': function(model){
                var params = _.extend(
                    model.toJSON(),
                    { action: 'UPDATE' }
                );
                return params;
            },
            'method': 'post'
        },
        'create': {
            'path': path.api.slideEntities,
            'data': function(model){
                var params = _.extend(
                    model.toJSON(),
                    { action: 'CREATE' }
                );
                return params;
            },
            'method': 'post'
        }
    }
});

var SlideElementCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read': function (e, options) {
            return path.api.slideEntities + '?slideId=' + options.model.id;
        },
        'delete': {
            'path': function (model) {
                return path.api.slideEntities;
            },
            'data': function(model) {
                var params = _.extend(
                    model.toJSON(),
                    { action: 'DELETE' }
                );
                return params;
            },
            'method': 'post'
        },
        'update': {
            'path': path.api.slideEntities,
            'data': function(model) {
                var params = _.extend(
                    model.toJSON(),
                    { action: 'UPDATE' }
                );
                return params;
            },
            'method': 'post'
        },
        'create': {
            path: path.api.slideEntities,
            data: function(model) {
                var params = _.extend(
                    model.toJSON(),
                    { action: 'CREATE' }
                );
                return params;
            },
            'method': 'post'
        }
    }
});

var SlideElementModel = Backbone.Model.extend({
    defaults: {
        width: 300,
        height: 50,
        top: 0,
        left: 0,
        zIndex: 0,
        slideEntityType: '',
        content: '',
        slideId: 0,
        correctLinkedSlideId: null,
        incorrectLinkedSlideId: null,
        notifyCorrectAnswer: false
    }
}).extend(SlideElementService);

var SlideElementCollection = Backbone.Collection.extend({
    model: SlideElementModel,
    parse: function (response) {
        return response;
    }
}).extend(SlideElementCollectionService);
