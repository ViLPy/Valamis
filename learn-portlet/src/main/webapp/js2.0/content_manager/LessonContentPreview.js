var LessonContentPreviewModal = Backbone.Modal.extend({
  template: _.template(Mustache.render($('#modal-clear-template').html(), {header: GLOBAL_translations['previewLabel']})),
  submitEl: '.modal-submit',
  cancelEl: '.modal-close',
  className: 'preview-modal',
  onRender: function () {
    new LessonContentPreviewView({
      model: this.model,
      el: this.$('.content')
    }).render();
  }
});

var LessonContentPreviewView = Backbone.View.extend({
  template: $('#lessonContentPreviewTemplate').html(),
  events: {
    'click .action-preview': 'preview'
  },
  getUrl: function () {
    return LessonContentModelService.options.url
      + '/api/quiz/?action=GETQUESTIONPREVIEW'
      + '&id=' + this.model.id
  },
  render: function () {
    this.$el.html(Mustache.render(this.template, {url: this.getUrl() }));
    return this;
  }
});