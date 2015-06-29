/*
 Modal for changing such lesson attributes as:
 - title
 - description
 - logo
 */
var LessonInfoEditModal = Backbone.Modal.extend({
  template: _.template(Mustache.render(jQueryValamis('#lessonDesignerEmptyModalTemplate').html(), _.extend({header: GLOBAL_translations['editLessonInfoLabel']}, GLOBAL_translations))),
  submitEl: '.bbm-button',
  cancelEl: '.modal-close',
    className:'val-modal',
  events: {
      'click .modal-submit': 'bodyOverflowHidden',
      'click .close-button': 'bodyOverflowHidden',
      'keypress .js-max-duration-picker': 'preventNonDigits'
  },
  onRender: function () {
    jQueryValamis('#content-manager-body').addClass("body-overflow-hidden");

    this.view = new LessonEditInfoView({
      model: this.model,
      el: this.$('.js-modal-content')
    });
    this.view.render();
    quizLogoData.resetImageSettings('quiz_logo_' + this.model.id);
    this.$el.addClass('lesson-content-info');
  },
  submit: function () {
    this.view.submit();
  },
  bodyOverflowHidden: function () {
        jQueryValamis('#content-manager-body').removeClass("body-overflow-hidden");
  },
  preventNonDigits: function (e) {
        if (e.keyCode != 46 && e.keyCode != 8 && e.keyCode != 9) {
            if (String.fromCharCode(e.charCode).match(/[^0-9]/g)) {
                return false;
            }
        }
  }
});

var LessonEditInfoView = Backbone.View.extend({
  template: jQueryValamis('#lesson-edit-info').html(),
  events: {
    'click .logo-field': 'uploadNewLogo',
    'click .logo': 'uploadNewLogo',
    'click .openMediaGallery':'openMediaGallery',
    'click .js-max-duration-checkbox': 'checkboxClicked'
  },
  uploadNewLogo: function () {
    var model = new UploadLessonLogoModel({
      folder: 'quiz_logo_' + this.model.id
    });
    model.once('change:src', this.onLogoChanged, this);
    contentManagerEvent.trigger('modals:show:uploadLessonLogoView', model)
  },
  checkboxClicked: function(){ //We don't need here a model. Model changes only on save.
    var picker = this.$(".js-max-duration-picker");
    picker.prop('disabled',!picker.prop('disabled'));
  },
  render: function () {
    var description = jQueryValamis('<i>').html(this.model.get('description')).text();
    this.$el.html(Mustache.render(this.template, _.extend(this.model.toJSON(),
      _.extend({description: description} ,GLOBAL_translations))));

    //Initialize duration picker
    this.$('.js-max-duration-picker').timepicker({
      defaultTime: false,
      showMeridian: false,
      minuteStep: 5
    });
    if(this.model.attributes.maxDuration != null) {
      var hours = Math.floor(this.model.attributes.maxDuration / 60);
      var minutes = this.model.attributes.maxDuration % 60;
      this.$('.js-max-duration-picker').timepicker('setTime', hours + ':' + minutes);
    }
    return this;
  },
  onLogoChanged: function (uploaderModel) {
    this.$('.logo').attr('src', uploaderModel.get('src'));

    if (!quizLogoData.supports()) {
       this.model.set({
       logo: uploaderModel.get('fileName')
       });
       this.model.updateLogo();
    }
  },
  submit: function () {
    this.model.set({
      title: this.$('.js-title-field').val(),
      description: this.$('.js-description-field').val(),
      maxDuration: this.getMaxDurationInMinutes()
    });
    var me = this;
    quizLogoData.submitData(
      function(name){
        me.model.set({'logo': name});
        me.model.updateLogo();
      });
    this.model.save().then(function () {
        contentManagerEvent.trigger('lesson:created', me.model.id);
    });
  },
  openMediaGallery: function(){
    var model = new UploadLessonLogoModel({
      folder: 'quiz_logo_' + this.model.id
    });
    model.once('change:src', this.onLogoChanged, this);
    contentManagerEvent.trigger('modals:show:mediaLibraryView', model);
  },
  getMaxDurationInMinutes: function(){
      var maxDurationInMinutes = null; // Unchecked
      if(this.$(".js-max-duration-checkbox").prop("checked")){
          var maxDuration = this.$(".js-max-duration-picker").val().split(':');

          var maxDurationHours = parseInt(maxDuration[0]);
          var maxDurationMinutes = parseInt(maxDuration[1]);

          maxDurationInMinutes = maxDurationHours * 60 + maxDurationMinutes;
      }
      return maxDurationInMinutes;
  }
});