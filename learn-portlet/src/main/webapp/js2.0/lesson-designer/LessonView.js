var LessonView = Backbone.View.extend({
  ITEM_TEMPLATES: {
    LIST: jQueryValamis('#lessonListViewTemplate').html(),
    TILE: jQueryValamis('#lessonTileViewTemplate').html(),
    COMMAND: jQueryValamis('#lessonCommandViewTemplate').html()
  },
  initialize: function (opts) {
    this.mode = opts.mode;
    this.model.on('change', this.onModelChanged, this);
  },
  events: {
    'click .download-tincan-lesson': 'downloadLessonTinCan',
    'click .download-scorm-lesson': 'downloadLessonSCORM',
    'click .edit-lesson-info': 'editLessonInfo',
    'click .edit-lesson-content': 'editLessonContent',
    'click .delete-lesson': 'confirmDeleteLesson',
    'click .publish-tincan-lesson': 'publishTinCanLesson',
    'click .process-tincan-lesson': 'processTinCanLesson',
    'click .publish-scorm-lesson': 'publishSCORMLesson',
    //'click .process-tincan-lesson': 'processTinCanLesson',
    'click .clone-lesson': 'cloneLesson',
    'click .export-lesson': 'exportLesson',
    'mouseenter .flip-container'   : 'hoverOn',
    'mouseleave .flip-container'   : 'hoverOff'
  },
  onModelChanged: function () {
    this.render();
  },
  downloadLessonSCORM: function () {
    this._downloadLesson('scorm');
  },
  downloadLessonTinCan: function() {
    this._downloadLesson('tincan');
  },
  _downloadLesson: function (lessonType) {
    window.location = path.root + path.api.files + 'export/?action=DOWNLOAD&contentType=lesson'
      + '&id=' + this.model.id
      + '&courseId=' + Utils.getCourseId()
      + '&publishType=' + lessonType;
  },
  editLessonContent: function () {
    contentManagerEvent.trigger('modals:show:editLessonContentView', this.model);
  },
  confirmDeleteLesson: function () {
    var confirmView = new DeleteConfirmationView({language: GLOBAL_translations});
    confirmView.on('deleteConfirmed', this.deleteLesson, this);
    var title = GLOBAL_translations['deleteConfirmationTitle'];
    toastr.info(confirmView.render().$el, title,
      {
        'positionClass': 'toast-center',
        'timeOut': '0',
        'showDuration': '0',
        'hideDuration': '0',
        'extendedTimeOut': '0'
      });
  },
  deleteLesson: function () {
    var me = this;
    me.model.deleteLesson().then(function () {
      toastr.success(GLOBAL_translations['overlayCompleteMessageLabel']);
      me.model.trigger('itemRequestDone');
    }, function () {
      toastr.error(GLOBAL_translations['overlayFailedMessageLabel']);
    });
  },
  publishTinCanLesson: function () {
    this._publishLesson('tincan')
  },
  publishSCORMLesson: function () {
    this._publishLesson('scorm')
  },
  processTinCanLesson: function() {
    contentManagerEvent.trigger('modals:show:processTinCan', this.model);
  },
  _publishLesson: function (lessonType) {
    toastr.info(GLOBAL_translations['overlayProcessMessageLabel']);
    this.model.publish({publishType: lessonType}).then(function (response) {
      if (response.status) {
        toastr.success(GLOBAL_translations['overlayCompleteMessageLabel']);
      } else {
        toastr.error(GLOBAL_translations['overlayContentNeededMessageLabel']);
      }
    }, function () {
      toastr.error(GLOBAL_translations['overlayFailedMessageLabel']);
    });
  },
  cloneLesson: function () {
    var me = this;
    me.model.clone().then(function () {
      me.model.trigger('itemRequestDone');
    });
  },
  exportLesson: function () {
    var me = this;
      window.location = path.root + path.api.files + 'export/?action=EXPORT&contentType=lesson'
          + '&id=' + me.model.id;
  },
  editLessonInfo: function () {
    contentManagerEvent.trigger('modals:show:editLessonInfoView', this.model);
  },
  hoverOn: function() {
    this.$el.find('.flip-container .back > div').removeClass('hidden');
  },
  hoverOff: function() {
    this.$el.find('.flip-container .back > div').addClass('hidden');
  },
  render: function () {
    var mustacheModel = _.extend({description: this.model.get('description')}, GLOBAL_translations, this.model.toJSON());
    this.$el.html(Mustache.render(this.template, mustacheModel));
    this.$el.addClass("list");

    return this;
  }
});

var LessonCollectionView = Backbone.View.extend({
  initialize: function () {
    this.collection.on('reset', this.render, this);
    this.collection.on('add', this.addOne, this);
  },
  setMode: function (mode) {
    this.mode = mode;
    this.render();
  },
  render: function () {
    this.$el.html('');
    this.collection.each(this.addOne, this);
  },
  addOne: function (lesson) {
    this.$el.append(new LessonView({model: lesson, mode: this.mode}).render().el)
  },
  getViewType: function () {
    return this.mode;
  }
});
