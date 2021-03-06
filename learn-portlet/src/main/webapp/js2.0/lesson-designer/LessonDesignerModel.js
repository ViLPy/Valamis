var ContentManagerService = new Backbone.Service({
    url: path.root,
    sync: {
        'read':{
            'path': path.api.quiz,
            'data': function (model) {
                return {
                    action: 'GETALL',
                    courseId: Utils.getCourseId(),
                    filter: model.get('filter'),
                    sortBy: model.get('sortBy'),
                    sortAscDirection: model.get('isSortDirectionAsc'),
                    count: model.get('paginatorModel').get('itemsOnPage'),
                    page: model.get('paginatorModel').get('currentPage')
                }
            },
        'method': 'post'
    }
}});

var ContentManagerModel = Backbone.Model.extend({
    parse: function (response) {
        this.get('paginatorModel').set({totalElements: response.total});
        this.get('paginatorModel').set({currentPage: response.page});
        this.get('lessonCollection').reset(response.records);

        this.trigger("paginationAppearance");
    },
    initialize: function () {
        var collection = new LessonCollection();
        this.set({
            namePattern: '',
            sortBy: '',
            paginatorModel: new PageModel(),
            lessonCollection: collection,
            tileViewTemplate: true
        });
        this.get('paginatorModel').on('pageChanged', function () {
            this.fetch();
        }, this);
        this.get('lessonCollection').on('itemRequestDone collectionRequestDone', function () {
            this.fetch();
        }, this);
        this.listenTo(contentManagerEvent, 'lesson:model:changed', function () {
            this.fetch();
        });

        //collection.on('change', this.fetch, this);
    }
}).extend(ContentManagerService);