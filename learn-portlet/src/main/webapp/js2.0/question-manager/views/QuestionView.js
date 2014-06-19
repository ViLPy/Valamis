/*
 *   Question view
 *   TODO: create separate AnswerCollection view
 */
var QuestionView = Backbone.View.extend({
  events: {
    'change #SCORMQuestionType': 'onTypeChange',
    'click .saveQuestion': 'saveModel',
    'click #SCORMQuestionBounded': 'toggleBounded',
    'click #SCORMQuestionCaseSensitive': 'toggleCase'
  },

  initialize: function (options) {
    this.language = options.language;
    this.answerCollectionView = null;
    this.categoryChild = options.categoryChild;
    this.categoryTitle = options.categoryTitle;
    this.resetTemporaryModel();
    this.renderView();
  },

  render: function () {
    return this;
  },

  updateModel: function () {
    if (this.$('#SCORMQuestionTitleEdit').val().length === 0) {
      toastr.warning(this.language['overlayWarningMessageLabel']);
      return false;
    }
    this.temporaryModel.set({
      title: this.$('#SCORMQuestionTitleEdit').val(),
      text: encodeURIComponent(CKEDITOR.instances.SCORMQuestionTextView.getData()),
      explanationText: encodeURIComponent(this.$('#SCORMExplanationTextView').html()),
      questionType: parseInt(this.$('#SCORMQuestionType').val().replace('type', '')),
      forceCorrectCount: this.$('#SCORMQuestionBounded').hasClass('checked'),
      isCaseSensitive: this.$('#SCORMQuestionCaseSensitive').hasClass('checked'),
      answers: JSON.stringify(this.answerCollectionView.getAnswers())
    });
    return true;
  },

  saveModel: function () {
    if (!this.updateModel()) return false;

    this.model.save(this.temporaryModel.toJSON(), {
      success: jQuery.proxy(function () {
        this.trigger('qb-entity-updated', this);
        toastr.success(this.language['overlayCompleteMessageLabel']);
      }, this),
      error: jQuery.proxy(function () {
        this.trigger('qb-entity-updated', this);
        toastr.error(this.language['overlayFailedMessageLabel']);
      }, this)
    });
  },

  resetTemporaryModel: function () {
    this.temporaryModel = this.model.clone();
  },

  renderView: function () {

    var template = Mustache.to_html(jQuery('#questionView').html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      text: decodeURIComponent(this.model.get('text')),
      explanationText: decodeURIComponent(this.model.get('explanationText')),
      questionTypeString: this.model.getStringType(),
      categoryChild: this.categoryChild,
      categoryTitle: this.categoryTitle
    }, this.language)));

    this.$el.empty().append(template);

    if (this.model.get('forceCorrectCount')) this.$('#SCORMQuestionBounded').addClass('checked');
    if (this.model.get('isCaseSensitive')) this.$('#SCORMQuestionCaseSensitive').addClass('checked');

    this.updateElementVisibility();
    this.renderType = 'view';
    this.renderAnswers(this.renderType);

    return this;
  },

  renderEdit: function () {

    var template = Mustache.to_html(jQuery('#questionEditView').html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      text: decodeURIComponent(this.model.get('text')),
      explanationText: decodeURIComponent(this.model.get('explanationText')),
      questionTypeString: this.model.getStringType()
    }, this.language)));

    this.$el.empty().append(template);

    this.$('#SCORMQuestionType').val('type' + this.model.get('questionType'));
    if (this.model.get('forceCorrectCount')) this.$('#SCORMQuestionBounded').addClass('checked');
    if (this.model.get('isCaseSensitive')) this.$('#SCORMQuestionCaseSensitive').addClass('checked');

    this.updateElementVisibility();
    this.renderType = 'edit';
    this.renderAnswers(this.renderType);

    return this;
  },
  renderEditor: function () {
    CKEDITOR.replace('SCORMQuestionTextView');
    this.answerCollectionView.renderEditor();
  },

  updateElementVisibility: function () {
    this.$('#SCORMQuestionIsBounded').hide();
    this.$('#SCORMQuestionIsCaseSensitive').hide();
    this.$('#SCORMQuestionAnswers').show();

    switch (this.temporaryModel.get('questionType')) {
      case QuestionType.ChoiceQuestion:
        this.$('#SCORMQuestionIsBounded').show();
        break;
      case QuestionType.ShortAnswerQuestion:
        this.$('#SCORMQuestionIsCaseSensitive').show();
        break;
      case QuestionType.PlainText:
      case QuestionType.EssayQuestion:
      case QuestionType.EmbeddedAnswerQuestion:
        this.$('#SCORMQuestionAnswers').hide();
        break;
    }
  },

  renderAnswers: function (renderType) {
    if (this.answerCollectionView) this.answerCollectionView.remove();

    if (this.temporaryModel.get('questionType') == QuestionType.CategorizationQuestion) {
      this.answerCollectionView = new CategorizationAnswerCollectionView({
        answerModel: this.temporaryModel.answerModel,
        renderType: renderType,
        language: this.language,
        isCategorization: true
      });

    } else {
      this.answerCollectionView = new AnswerCollectionView({
        answerModel: this.temporaryModel.answerModel,
        renderType: renderType,
        language: this.language
      });
    }

    this.$('#SCORMQuestionAnswers').html(this.answerCollectionView.render().$el);

    // fill answers
    var answers = eval(this.temporaryModel.get('answers'));
    _.each(answers, function (answer) {
      this.answerCollectionView.addAnswer(answer);
    }, this);
  },

  onTypeChange: function () {
    this.answerCollectionView.resetAnswers();
    this.updateModel();
    this.updateElementVisibility();
    this.renderAnswers('edit');
  },
  toggleBounded: function(){
    if (this.renderType == 'edit') this.$('#SCORMQuestionBounded').toggleClass('checked');
  },
  toggleCase: function(){
    if (this.renderType == 'edit') this.$('#SCORMQuestionCaseSensitive').toggleClass('checked');
  }
});
