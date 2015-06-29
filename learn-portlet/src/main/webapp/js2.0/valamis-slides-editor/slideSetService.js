var slidesConfig = null;

var SlideSetService = new Backbone.Service({ url: path.root,
    'sync': {
        'read': {
            'path': path.api.slideSets,
            'data': function(model) {
                var params = {
                    page: model.paginationModel.get('currentPage'),
                    itemsOnPage: model.paginationModel.get('itemsOnPage'),
                    titleFilter: model.searchModel.get('title'),
                    sortTitleAsc: model.searchModel.get('sortAscDirection'),
                    courseId: Utils.getCourseId()
                };
                return params;
            },
            'method': 'get'
        },
        'delete': {
            'path': path.api.slideSets,
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
            'path': path.api.slideSets,
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
            'path': path.api.slideSets,
            'data': function(model){
                var params = _.extend(
                    model.toJSON(),
                    { action: 'CREATE' }
                );
                return params;
            },
            'method': 'post'
        }
    },
    'targets': {
        'publish': {
           'path': path.api.slideSets,
            'data': function(model){
                var params = _.extend(
                    model.toJSON(),
                    {
                        action: 'PUBLISH',
                        courseId: Utils.getCourseId()
                    }
                );
                return params;
            },
            'method': 'post'
        }
    }
});