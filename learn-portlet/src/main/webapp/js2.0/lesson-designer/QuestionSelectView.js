var BankQuestionSelectModal = Backbone.Modal.extend({
  template: _.template(Mustache.render($('#modal-template').html(), _.extend({header: GLOBAL_translations['addQuestionLabel']}, GLOBAL_translations))),
  submitEl: '.modal-submit',
  cancelEl: '.close-button',
  className: 'question-select-modal',
  onRender: function () {
    this.view = new BankTreeView({
      language: GLOBAL_translations,
      multiselectEnabled: true,
      courseId: jQuery('#courseID').val(),
      baseTitle: GLOBAL_translations['treeRootElement']
    });
    this.$('.content').html(this.view.render().$el);
    var _this = this;
    //webkit bug, need to force repaint for modal on scroll
    this.$el.scroll(function(){
      _this.$el.css('opacity', 0.99);
      _this.$el.css('opacity', 1);
    });
  },
  submit: function () {
    if (this.view)
    {
      var questions = this.view.getEntities();
      if (!questions || questions.length === 0) return;

      var categoryId = this.model.get("selectedCategoryId");
      var lessonId = this.model.id;
      var questionModel = new LessonContentQuestionModel({
        contentType: 'questions',
        categoryId: categoryId,
        lessonId: lessonId
      });
      questionModel.save({}, {bankQuestionIds: jQuery.param({'bankQuestionIds': questions.map(function(i){ return i.id; })}, true)}).then(
        function(response) {
          contentManagerEvent.trigger("question:added", {isCollection: true, items: response.map(
            function(i){
              return new LessonContentQuestionModel({
                id: i.id,
                title: i.question.title,
                categoryId: categoryId,
                lessonId: lessonId,
                bankQuestionId: i.question.id
              });
            })});

        }
      );
    }
  }
});