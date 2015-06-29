var LessonContentPreviewModal = Backbone.Modal.extend({
  template: function (data) {
    return Mustache.to_html(jQueryValamis('#modal-clear-template').html(),
      _.extend({header: GLOBAL_translations['previewLabel']},window.permissionActions))
  },
  submitEl: '.modal-submit',
  cancelEl: '.modal-close',
  className: 'val-modal preview-modal',
  onRender: function () {
    new LessonContentPreviewView({
      model: this.model,
      el: this.$('.js-modal-content')
    }).render();
  }
});

var LessonContentPreviewView = Backbone.View.extend({
  events: {
    'click .action-preview': 'preview'
  },
  getUrl: function () {
    return LessonContentModelService.options.url
      + path.api.quiz + '?action=GETQUESTIONPREVIEW'
      + '&id=' + this.model.id
      + '&lessonId=' + this.model.get('lessonId')
      + '&courseId=' + Utils.getCourseId()
  },
  render: function () {
    this.$el.html(Mustache.render(jQueryValamis('#lessonContentPreviewTemplate').html(),
      _.extend({url: this.getUrl()},window.permissionActionsLessonDesigner)));
    return this;
  }
});