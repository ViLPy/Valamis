var RevealJSModel = LessonContentModel.extend({
  defaults: {
    contentType: 'questionRevealJS',
    title: '',
    text: ''
  }
});

var RevealJSView = Backbone.View.extend({
  template: $('#revealJSViewTemplate').html(),
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
      text: this.$('.content-edit').val()
    });
    this.model.save();
    contentManagerEvent.trigger('question:added', this.model);
  }
});

var RevealJSModal = Backbone.Modal.extend({
  template: _.template(Mustache.render($('#modal-template').html(), _.extend({header: GLOBAL_translations['addPresentationLabel']}, GLOBAL_translations))),
  submitEl: '.modal-submit',
  cancelEl: '.close-button',
  className: 'add-presentation-modal',
  onRender: function () {
    this.view = new RevealJSView({
      model: this.model,
      el: this.$('.content')
    });
    this.view.render();
  },
  submit: function () {
    if (this.view)
      this.view.submit();
  }
});