var LessonView = Backbone.View.extend({
  ITEM_TEMPLATES: {
    LIST: $('#lessonListViewTemplate').html(),
    TILE: $('#lessonTileViewTemplate').html(),
    COMMAND: $('#lessonCommandViewTemplate').html()
  },
  initialize: function (opts) {
    this.mode = opts.mode;
    this.model.on('change', this.onModelChanged, this);
  },
  tagName: 'li',
  classNamePrefix: 'lesson-item-',
  events: {
    'click .download-lesson': 'downloadLesson',
    'click .edit-lesson-info': 'editLessonInfo',
    'click .edit-lesson-content': 'editLessonContent',
    'click .delete-lesson': 'confirmDeleteLesson',
    'click .pubilsh-lesson': 'publishLesson',
    'click .clone-lesson': 'cloneLesson'
  },
  onModelChanged: function () {
    this.render();
  },
  downloadLesson: function () {
    window.location = '/learn-portlet/api/quiz/?action=DOWNLOAD'
      + '&id=' + this.model.id
      + '&courseID=' + GLOBAL_courseID;
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
  publishLesson: function () {
    toastr.info(GLOBAL_translations['overlayProcessMessageLabel']);
    this.model.publish().then(function (response) {
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
  editLessonInfo: function () {
    contentManagerEvent.trigger('modals:show:editLessonInfoView', this.model);
  },
  render: function () {
    var mustacheAccumulator = {};
    _.extend(mustacheAccumulator, GLOBAL_translations);
    _.extend(mustacheAccumulator, this.model.toJSON());
    var template = this.ITEM_TEMPLATES[this.mode];
    this.$el.html(Mustache.render(template, mustacheAccumulator))
      .addClass(this.classNamePrefix + this.mode.toLowerCase());

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
