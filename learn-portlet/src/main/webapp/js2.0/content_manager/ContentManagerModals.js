var ModalContainer = Backbone.Marionette.Layout.extend({
  template: _.template($('#modals-template').html()),
  className: 'content-manager',
  initialize: function () {
    this.listenTo(contentManagerEvent, 'modals:show:editLessonInfoView', this.ShowEditLessonInfoView);
    this.listenTo(contentManagerEvent, 'modals:show:editLessonContentView', this.ShowEditLessonContentView);
    this.listenTo(contentManagerEvent, 'modals:show:addTextArticleView', this.ShowAddTextArticleView);
    this.listenTo(contentManagerEvent, 'modals:show:addExternalResourceView', this.ShowAddExternalResourceView);
    this.listenTo(contentManagerEvent, 'modals:show:addRevealJSView', this.ShowAddRevealJSView);
    this.listenTo(contentManagerEvent, 'modals:show:lessonContentPreviewView', this.ShowLessonContentPreview);
    this.listenTo(contentManagerEvent, 'modals:show:bankQuestionSelect', this.ShowBankQuestionSelect);
    this.listenTo(contentManagerEvent, 'modals:show:uploadLessonLogoView', this.ShowUploadLessonLogo);

  },
  regions: {
    modals: {
      selector: '.modals-container',
      regionType: Backbone.Marionette.Modals
    }
  },
  ShowEditLessonInfoView: function (lessonModel) {
    this.modals.show(new LessonInfoEditModal({
      model: lessonModel
    }));
  },
  ShowEditLessonContentView: function (lessonModel) {
    this.modals.show(new LessonContentEditModal({
      model: lessonModel
    }));
  },
  ShowAddTextArticleView: function (lessonModel) {
    this.modals.show(new AddTextArticleModal({
      model: lessonModel
    }));
  },
  ShowAddExternalResourceView: function (externalResourceModel) {
    this.modals.show(new ExternalResourceModal({
      model: externalResourceModel
    }));
  },
  ShowAddRevealJSView: function (model) {
    this.modals.show(new RevealJSModal({
      model: model
    }));
  },
  ShowLessonContentPreview: function (model) {
    this.modals.show(new LessonContentPreviewModal({
      model: model
    }));
  },
  ShowBankQuestionSelect: function (lessonModel) {
    this.modals.show(new BankQuestionSelectModal({
      model: lessonModel
    }));
  },
  ShowUploadLessonLogo: function (uploadModel) {
    this.modals.show(new UploadLessonLogoModal({
      model: uploadModel
    }));
  }
});