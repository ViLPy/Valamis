var PDFModel = LessonContentModel.extend({
  defaults: {
    contentType: 'questionPDF',
    title: '',
    text: '',
      icon: 'pdf'
  }
});

var PDFView = Backbone.View.extend({
  render: function () {
    this.isNew = this.model.isNew();
    var mustacheAccumulator = {};
    _.extend(mustacheAccumulator, this.model.toJSON(), GLOBAL_translations);

    this.$el.html(Mustache.render(jQueryValamis('#pdfViewTemplate').html(), mustacheAccumulator));

    if (this.isNew) {
      var uploaderPath = path.root + path.api.files +
          '?action=ADD&contentType=pdf&quizID=' + (this.model.get('lessonId') || this.model.get('tempId')) +
          '&courseId=' + Utils.getCourseId();
      if (this.model.get('categoryId')) uploaderPath += '&categoryID=' + this.model.get('categoryId');

      var uploader = new FileUploader({
        endpoint:  uploaderPath,
        message: GLOBAL_translations['uploadPdfMessage']
      });
      uploader.on('itemDone', function(response) {
        this.model.set({
          id: response.id,
          title: this.$('.js-title-edit').val() || response.title || response.name.replace('.pdf', '')
        });
        if (this.cancelled) {
          if(this.model.get('lessonId'))
            this.model.destroy();
        } else {
          if(this.model.get('lessonId'))
            this.model.save();
          else
            this.trigger('pdf:added', this.model);
        }

        this.$('.progress').removeClass('progress-striped active');
      }.bind(this));

      this.$('.js-file-uploader').append(uploader.render().$el);
      this.$('.progress').addClass('progress-striped active');
    }

    return this;
  },
  preview: function () {
    this.$('.content').attr('src', this.$('.url-edit').val());
  },
  submit: function () {
    this.model.set({
      title: this.$('.js-title-edit').val() || 'New PDF file'
    });
    this.model.save();
    contentManagerEvent.trigger('question:added', this.model);
  },
  cancel: function() {
    this.cancelled = true;
    if (this.isNew) {
      this.model.destroy();
    }
  }
});

var PDFModal = Backbone.Modal.extend({
  template: function (data) {
    return Mustache.to_html(jQueryValamis('#lessonDesignerEmptyModalTemplate').html(),
      _.extend({header: GLOBAL_translations['AddPDFFileLabel']}, GLOBAL_translations))
  },
  submitEl: '.bbm-button',
  cancelEl: '.modal-close',
  className: 'val-modal',
  onRender: function () {
    this.view = new PDFView({
      model: this.model,
      el: this.$('.js-modal-content')
    });
    this.view.render();
    var that = this;
    this.view.on('pdf:added', function(model) {
        that.trigger('pdf:added', model);
    });
  },
  submit: function () {
    if (this.view)
      this.view.submit();
  },
  cancel: function() {
    if (this.view)
      this.view.cancel();
  }
});