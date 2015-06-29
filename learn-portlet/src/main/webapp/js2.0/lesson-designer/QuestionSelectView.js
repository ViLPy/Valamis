var BankQuestionSelectModal = Backbone.Modal.extend({
  template: function (data) {
    return Mustache.to_html(jQueryValamis('#lessonDesignerEmptyModalTemplate').html(),
      _.extend({header: GLOBAL_translations['addQuestionLabel']}, GLOBAL_translations))
  },
  submitEl: '.bbm-button',
  cancelEl: '.modal-close',
  className: 'val-modal',
  onRender: function () {
    this.view = new BankTreeView({
      language: GLOBAL_translations,
      multiselectEnabled: true,
      courseId: Utils.getCourseId(),
      baseTitle: GLOBAL_translations['treeRootElement'],
      isSortable: false
    });
    this.$('.js-modal-content').html(this.view.render().$el);
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
      //questionModel.save({}, {bankQuestionIds: jQueryValamis.param({'bankQuestionIds': questions.map(function(i){ return i.id; })}, true)}).then(
      questionModel.save({}, {bankQuestionIds: questions.map(function(i){ return i.id; })}, true).then(
        function(response) {
            var items = response.map(
                function(i){
                    return new LessonContentQuestionModel({
                        id: i.id,
                        title: i.question.title,
                        categoryId: categoryId,
                        lessonId: lessonId,
                        bankQuestionId: i.question.id,
                        questionTypeCode: i.questionTypeCode
                    });
                });
        contentManagerEvent.trigger("question:added", {isCollection: true, items: items });
        }
      );
    }
  }
});