LessonModelView = Backbone.View.extend({
    initialize: function(){
        this.model.on('change', this.render, this);
    },
    events: {
        'click .js-toggle-button': function(){ this.model.toggle(); }
    },
    tagName: 'tr',
    template: jQuery('#curriculum-select-lesson-goals-lesson').html(),
    render: function(){
        this.$el.html(Mustache.render(this.template, _.extend({}, this.model.attributes, scormLanguageDataCurriculum)));
        return this;
    }
});

AddLessonGoalsDialogView = Backbone.View.extend({
    SEARCH_TIMEOUT: 800,
    events: {
      'keyup #searchLesson': 'filterLessons',
      'click .dropdown-menu > li': 'filterLessons',
      'click .js-addLesson': 'addLessons'
    },
    template: jQuery('#curriculum-select-lesson-goals-dialog').html(),
    initialize: function(options){
        this.language = options.language;
        this.certificateId = options.certificateId;
        this.$el.html(Mustache.render(this.template, scormLanguageDataCurriculum));
        this.collectionContainer = this.$('#lessonList');

        this.model = new LessonGoalsDialogModel();
        this.model.on('sync', this.render, this);

        var that = this;
        this.tags = new Valamis.TagCollection();
        this.tags.fetch({
          success: function (){
            that.appendTags();
          }
        });

        this.paginator = new ValamisPaginator({
          el: this.$el.find('#lessonListPaginator'),
          language: this.language,
          model: this.model.paginationModel
        });

        this.paginatorShowing = new ValamisPaginatorShowing({
          el: this.$el.find('#lessonListPagingShowing'),
          language: this.language,
          model: this.paginator.model
        });
        this.$('.dropdown').valamisDropDown();
    },
    appendTags: function() {
        this.tags.each(function(item) {
          this.$('#lessonListTags .dropdown-menu').append('<li data-value="' + item.id + '"> ' + item.get('text') + ' </li>');
        }, this);
        this.$('.dropdown').valamisDropDown();
    },
    render: function(){
       this.collectionContainer.empty();
       this.model.lessonCollection.each(this.addOne, this);
    },
    addOne: function(item) {
       var view = new LessonModelView({model: item});
       this.collectionContainer.append(view.render().$el);
    },
    filterLessons: function () {
        clearTimeout(this.inputTimeout);
        this.inputTimeout = setTimeout(this.applyFilter.bind(this), this.SEARCH_TIMEOUT);
    },
    applyFilter: function () {
        clearTimeout(this.inputTimeout);
        var order = this.$('#sortLesson').data('value');
        var sortBy = order.split(':')[0];
        var asc = order.split(':')[1];
        this.model.searchModel.set({
          'title': this.$('#searchLesson').val(),
          'sortBy': sortBy,
          'sortAscDirection': asc,
          'tagId': this.$('#lessonListTags').data('value')
        });
    },
    addLessons: function() {
        var selectedLessons = this.model.lessonCollection.filter(function(item) {
          return item.get('toggled')
        }).map(function (item) {
          return item.get('id');
        });

        var that = this;

        this.model.lessonCollection.saveToCertificate({}, {certificateId: this.certificateId, lessons: selectedLessons}).then(function (res) {
          that.trigger('closeModal', that);
          toastr.success(that.language['overlayCompleteMessageLabel']);
        }, function (err, res) {
          toastr.error(that.language['overlayFailedMessageLabel']);
        });
    }
});