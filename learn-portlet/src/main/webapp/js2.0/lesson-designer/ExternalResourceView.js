var ExternalResourceModel = LessonContentModel.extend({
  defaults: {
    contentType: 'questionExternalResource',
    title: '',
    url: '',
      icon: 'globe'
  }
});

var ExternalResourceView = Backbone.View.extend({
  events: {
    'click .js-action-preview': 'preview'
  },
  render: function () {
    var mustacheAccumulator = {};
    _.extend(mustacheAccumulator, this.model.toJSON(), GLOBAL_translations);

    this.$el.html(Mustache.render(jQueryValamis('#externalResourceTemplate').html(), mustacheAccumulator));

    return this;
  },
  preview: function () {
    this.$('.js-resource-content').attr('src', this.$('.js-url-edit').val());
  },
  submit: function () {
    this.model.set({
      title: this.$('.js-title-edit').val() ||  'New resource',
      url: this.$('.js-url-edit').val()
    });
    this.model.save();
    contentManagerEvent.trigger('question:added', this.model);
  }
});

var ExternalResourceModal = Backbone.Modal.extend({
  template: function (data) {
    return Mustache.to_html(jQueryValamis('#lessonDesignerEmptyModalTemplate').html(),
      _.extend({header: GLOBAL_translations['addExternalResourceLabel']}, GLOBAL_translations))
  },
  submitEl: '.bbm-button',
  cancelEl: '.modal-close',
  className: 'val-modal external-resource-modal',
  onRender: function () {
    this.view = new ExternalResourceView({
      model: this.model,
      el: this.$('.js-modal-content')
    });
    this.view.render();
  },
  submit: function () {
    if (this.view)
      this.view.submit(this.model);
  }
});