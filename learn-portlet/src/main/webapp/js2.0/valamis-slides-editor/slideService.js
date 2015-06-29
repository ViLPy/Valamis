var SlideService = new Backbone.Service({ url: path.root,
    sync: {
        'read': function (e, options) {
            return path.api.slides + '?slideSetId=' + model.get('slideSetId');
        },
        'delete': {
            'path': path.api.slides,
            'data': function(model) {
                var params = _.extend(
                    model.toJSON(),
                    { action: 'DELETE' }
                );
                return params;
            },
            method: 'post'
        },
        'update': {
            'path': path.api.slides,
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
            'path': path.api.slides,
            'data': function(model) {
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

var SlideModel = Backbone.Model.extend({
    defaults: {
    },
    toJSON: function() {
        return _.omit(this.attributes, ['slideElements']);
    }
}).extend(SlideService);

SlideCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read': function (e, options) {
            return path.api.slides + '?slideSetId=' + options.model.id;
        },
        'delete': {
            'path': function (model) {
                return path.api.slides;
            },
            'data': function(model) {
                var params = _.extend(
                    model.toJSON(),
                    { action: 'DELETE' }
                );
                return params;
            },
            method: 'post'
        },
        'update': {
            'path': path.api.slides,
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
            'path': path.api.slides,
            'data': function(model) {
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

SlideCollection = Backbone.Collection.extend({
    model: SlideModel,
    parse: function (response) {
        return response;
    }
}).extend(SlideCollectionService);