var LessonGoalsDialogService = new Backbone.Service({ url: path.root,
    sync: {
        'read': {
            path: path.api.lesson,
            'data': function (model, options) {
                return {
                    action: 'ALL',
                    courseId: model.searchModel.get('courseId'),
                    filter: model.searchModel.get('title'),
                    packageType: model.searchModel.get('packageType'),
                    tagId: model.searchModel.get('tagId'),
                    sortBy: model.searchModel.get('sortBy'),
                    scope: model.searchModel.get('scope'),
                    sortAscDirection: model.searchModel.get('sortAscDirection'),
                    page: model.paginationModel.get('currentPage'),
                    count: model.paginationModel.get('itemsOnPage')
                }
            },
            'method': 'get'
        }
    }
});

LessonCollectionService = new Backbone.Service({ url: path.root,
  targets: {
    'saveToCertificate': {
      'path': function (collection, options) {
        return path.api.certificates + options.certificateId;
      },
        'data': function(collection, options){
            var params = {
                action: 'ADDPACKAGES',
                courseId: Utils.getCourseId(),
                packageIds: options.lessons
            };
            return params;
        },
      method: 'post'
    }
  }
});

LessonModel = Backbone.Model.extend({
    toggle: function(){
        if(this.get("toggled")) this.set("toggled", false);
        else this.set("toggled", true);
    }
});

LessonCollection = Backbone.Collection.extend({
    model: LessonModel
}).extend(LessonCollectionService);

SearchModel = Backbone.Model.extend({
    defaults: {
        courseId: Utils.getCourseId(),
        title: '',
        packageType: 'tincan',
        sortBy: 'name',
        sortAscDirection: true,
        scope: 'instance',
        tagId: ''
    }
});


LessonGoalsDialogModel = Backbone.Model.extend({
    initialize: function(){
        this.searchModel = new SearchModel();
        this.lessonCollection = null;
        this.paginationModel = new PageModel();
        this.paginationModel.set({'itemsOnPage': 10});

        this.searchModel.on("change",this.fetch,this);
        this.paginationModel.on("change",this.fetch,this);
        this.fetch();
    },
    parse: function(response){
        this.lessonCollection = new LessonCollection(response.records);
        this.paginationModel.set('totalElements',response.total)
    }
}).extend(LessonGoalsDialogService);