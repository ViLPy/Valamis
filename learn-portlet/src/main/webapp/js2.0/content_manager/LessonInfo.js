/*
 Modal for changing such lesson attributes as:
 - title
 - description
 - logo
 */
var LessonInfoEditModal = Backbone.Modal.extend({
  template: _.template(Mustache.render($('#modal-template').html(), _.extend({header: GLOBAL_translations['editLessonInfoLabel']}, GLOBAL_translations))),
  submitEl: '.modal-submit',
  cancelEl: '.close-button',
  onRender: function () {
    this.view = new LessonEditInfoView({
      model: this.model,
      el: this.$('.content')
    });
    this.view.render();
    this.$el.addClass('lesson-content-info');
  },
  submit: function () {
    this.view.submit()
  }
});

var LessonEditInfoView = Backbone.View.extend({
  template: $('#lesson-edit-info').html(),
  events: {
    'click .logo-field': 'uploadNewLogo',
    'click .logo': 'uploadNewLogo'
  },
  uploadNewLogo: function () {
    var model = new UploadLessonLogoModel({
      folder: 'quiz_logo_' + this.model.id
    });
    model.once('change:fileName', this.onLogoChanged, this);
    contentManagerEvent.trigger('modals:show:uploadLessonLogoView', model)
  },
  render: function () {
    this.$el.html(Mustache.render(this.template, _.extend(this.model.toJSON(), GLOBAL_translations)));
    return this;
  },
  onLogoChanged: function (uploaderModel) {
    this.$('.logo').attr('src', uploaderModel.get('src'));
    this.model.set({
      logo: uploaderModel.get('fileName')
    });
    this.model.save();
  },
  submit: function () {
    this.model.set({
      title: this.$('.title-field').val(),
      description: this.$('.description-field').val()
    });

    this.model.save();
  }
});