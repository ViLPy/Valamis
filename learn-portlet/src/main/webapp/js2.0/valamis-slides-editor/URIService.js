/**
 * Created by aklimov on 06.05.15.
 */
var URIService = new Backbone.Service({ url: path.root,
    'sync': {
        'read': {
            'path': path.api.uri,
            'data': {
                    'action': 'GETALL'
                },
            'method': 'get'
        },
        'update': {
            'path': path.api.uri,
            'data': function(model){
                var params = _.extend(
                    model.toJSON(),
                    { prefix: document.location.protocol + "//" + document.location.host + path.root + path.api.uri }
                )
                return params;
            },
            'method': 'get'
        },
        'create': {
            'path': path.api.uri,
            'data': function(model){
                return model.toJSON();
            },
            'method': 'get'
        }
    }
});

var VerbURIService = new Backbone.Service({ url: path.root,
    'sync': {
        'read': {
            'path': path.api.uri + 'verbs/',
            'method': 'get'
        }
    }
});

var ValamisURI = Backbone.Model.extend({
    defaults: {}
}).extend(URIService);

var VerbURI = Backbone.Model.extend({
    defaults: {}
}).extend(VerbURIService);

var URICollection = Backbone.Collection.extend({
    'parse': function(response){
        return response;
    },
    'model': ValamisURI
}).extend(URIService);

var VerbURICollection = Backbone.Collection.extend({
    'parse': function(response){
        return response;
    },
    'model': VerbURI
}).extend(VerbURIService);