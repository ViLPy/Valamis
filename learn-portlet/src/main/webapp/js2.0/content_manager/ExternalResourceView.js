var ExternalResourceModel = LessonContentModel.extend({
  defaults: {
    contentType: 'questionExternalResource',
    title: '',
    url: ''
  }
});

var ExternalResourceView = Backbone.View.extend({
  template: $('#externalResourceTemplate').html(),
  events: {
    'click .action-preview': 'preview'
  },
  render: function () {
    var mustacheAccumulator = {};
    _.extend(mustacheAccumulator, this.model.toJSON(), GLOBAL_translations);

    this.$el.html(Mustache.render(this.template, mustacheAccumulator));

    return this;
  },
  preview: function () {
    this.$('.content').attr('src', this.$('.url-edit').val());
  },
  submit: function () {
    this.model.set({
      title: this.$('.title-edit').val(),
      url: this.$('.url-edit').val()
    });
    this.model.save();
    contentManagerEvent.trigger('question:added', this.model);
  }
});

var ExternalResourceModal = Backbone.Modal.extend({
  template: _.template(Mustache.render($('#modal-template').html(), _.extend({header: GLOBAL_translations['addExternalResourceLabel']}, GLOBAL_translations))),
  submitEl: '.modal-submit',
  cancelEl: '.close-button',
  className: 'add-external-resource-modal',
  onRender: function () {
    this.view = new ExternalResourceView({
      model: this.model,
      el: this.$('.content')
    });
    this.view.render();
  },
  submit: function () {
    if (this.view)
      this.view.submit(this.model);
  }
});