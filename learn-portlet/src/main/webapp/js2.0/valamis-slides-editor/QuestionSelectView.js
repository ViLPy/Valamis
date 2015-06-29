var BankQuestionSelectModal = Backbone.Modal.extend({
  template: _.template(Mustache.render(jQueryValamis('#question-select-modal-template').html(), _.extend({header: window.slidesConfig.translations['selectQuestionLabel']}, window.slidesConfig.translations))),
  submitEl: '.modal-submit',
  cancelEl: '.close-button',
  className: 'val-modal question-select-modal',
  events: {
    'click span.js-tree-item *': 'selectQuestionAndClose'
  },
  onRender: function () {
    this.view = new BankTreeView({
      language: window.slidesConfig.translations,
      multiselectEnabled: false,
      isSortable: false,
      courseId: Utils.getCourseId(),
      baseTitle: window.slidesConfig.translations['treeRootElement']
    });
    this.$('.js-modal-content').html(this.view.render().$el);
    var _this = this;
    //webkit bug, need to force repaint for modal on scroll
    this.$el.scroll(function(){
      _this.$el.css('opacity', 0.99);
      _this.$el.css('opacity', 1);
    });
  },
  selectQuestionAndClose: function(e) {
    if(jQueryValamis(e.target).closest('li').attr('id').slice(0,1) !== 'c') {
        var questionId = parseInt(jQueryValamis(e.target).closest('li[id^="q"]').attr('id').slice(1));
        slidesApp.commands.execute('question:update', questionId);
        slidesEditorModalsLayout.modals.currentView.destroy(this);
    }
  }
});