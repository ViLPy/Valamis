var _LessonDesigner = {};

_LessonDesigner.service = new Backbone.Service({
    url: path.root,
    sync: {
        'read':{
            'path': path.api.quiz,
            'data': function (model) {
                return {
                    action: 'GETALL',
                    courseId: Utils.getCourseId(),
                    filter: model.searchModel.get('filter'),
                    sortBy: model.searchModel.get('sortBy'),
                    sortAscDirection: model.searchModel.get('ascendingOrder'),
                    count: model.paginationModel.get('itemsOnPage'),
                    page: model.paginationModel.get('currentPage')
                }
            },
            'method': 'get'
        }
    }
});

_LessonDesigner.Model = Backbone.Model.extend({
    searchModel: null,
    lessonCollection:null,
    paginationModel: null,
    displayModeModel: null,
    initialize: function(){
        this.searchModel = new _LessonSearch.Model();
        this.paginationModel = new PageModel();
        this.lessonCollection = new _Lesson.Collection();
        this.displayModeModel = new _LessonDisplayMode.Model();

        this.lessonCollection.displayMode = this.displayModeModel.get('displayMode');

        this.listenTo(this.searchModel,'change',this.searchModelChange);
        this.listenTo(this.paginationModel,'change:currentPage',this.fetch);
        this.listenTo(this.paginationModel,'change:itemsOnPage',this.fetch);
        this.listenTo(_LessonDesigner.config.eventAggregator, '_LessonDesignerModel:fetchRequired', this.fetch);
        this.listenTo(this.displayModeModel, 'change:displayMode', function(){
            this.lessonCollection.displayMode = this.displayModeModel.get('displayMode');
            this.lessonCollection.trigger('change:displayMode');
            _LessonDesigner.config.eventAggregator.trigger("elementQuery:displayModeChanged"); //Is it called only after lessonCollection processed the change.
        })
    },
    parse: function(response){
        this.lessonCollection.reset(response.records);
        this.paginationModel.set('totalElements',response.total);
    },
    searchModelChange: function(){
        if(this.paginationModel.get('currentPage') == 1 ) this.fetch();
        else this.paginationModel.set('currentPage', 1); //and fetch on event
    }
}).extend(_LessonDesigner.service);


_LessonDesigner.View = _LessonDefaultView.extend({
    templateSelector: '#lesson-manager-template',
    events: {
        'click .js-create-lesson': 'createLesson'
    },
    createLesson: function(){ _LessonDesigner.config.eventAggregator.trigger('modals:show:editLessonInfoView', new LessonModel()); },
    render: function(){
        this.$el.html(Mustache.render(this.getTemplate(), _.extend({}, _LessonDesigner.config.translations, _LessonDesigner.config.permissions)));

        this.paginationItemsPerPageView = new ValamisPaginatorShowing({language: _LessonDesigner.config.translations, model: this.model.paginationModel});
        this.$(".js-pagination-items-per-page-container").html(this.paginationItemsPerPageView.render().$el);

        this.searchByNameView = new _LessonSearch.SearchByNameView({model: this.model.searchModel});
        this.$(".js-search-by-name-container").html(this.searchByNameView.render().$el);

        this.orderView = new _LessonSearch.OrderView({model: this.model.searchModel});
        this.$(".js-order-container").html(this.orderView.render().$el);

        this.displayModeView = new _LessonDisplayMode.View({model: this.model.displayModeModel});
        this.$('.js-collection-mode-container').html(this.displayModeView.render().$el);

        this.collectionView = new _Lesson.CollectionView({collection: this.model.lessonCollection});
        this.$(".js-lesson-collection-container").html(this.collectionView.render().$el);

        this.paginationPageSelectionView = new ValamisPaginator({language: _LessonDesigner.config.translations, model: this.model.paginationModel});
        this.$(".js-pagination-page-selection-container").html(this.paginationPageSelectionView.render().$el);

        return this;
    }
});