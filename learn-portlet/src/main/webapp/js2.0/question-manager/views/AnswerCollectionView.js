AnswerCollectionView = Backbone.View.extend({
  events: {
    'click #SCORMButtonAddAnswer': 'createAnswer',
    'keypress .onlyDigits': 'preventNonDigits',
    'keypress #SCORMAnswerRangeFrom': 'preventNonDigits',
    'keypress #SCORMAnswerRangeTo': 'preventNonDigits'
  },

  initialize: function (options) {
    this.language = options.language;
    this.renderType = options.renderType;

    this.answerModel = options.answerModel;
    this.answerViewCollection = [];
    this.isPositioning = options.isPositioning;
    this.$el = jQuery('<div>');
  },

  render: function () {
    var template = Mustache.to_html(jQuery('#answerCollectionView').html(), _.extend({
      isPositioning: this.isPositioning,
      readOnly: this.renderType == 'view',
      cid: this.cid
    }, this.language));
    this.$el.empty().append(template);
    this.$('#SCORMQuestionAnswersEditors').sortable({
      placeholder: 'ui-state-highlight',
      stop: jQuery.proxy(function () {
        this.updateAnswerViewPositions();
      }, this)
    });

    if (this.renderType == 'edit') {
      this.$('#SCORMAddAnswersButtonBlock').show();
      if (this.isCategorization) {
        this.$('#SCORMQuestionAnswersEditors').sortable('disable');
      }
    } else {
      this.$('#SCORMAddAnswersButtonBlock').hide();
      this.$('#SCORMQuestionAnswersEditors').sortable('disable');
    }

    return this;
  },
  renderEditor: function () {
    var sortedAnswers = this.$('#SCORMQuestionAnswersEditors').sortable('toArray');
    for (key in sortedAnswers) {
      var view = this.answerViewCollection[sortedAnswers[key]];
      if (view) view.renderEditor();
    }
  },
  createAnswer: function () {
    var answerView = this.addAnswer();
    if (this.renderType == 'edit') {
      answerView.renderEditor();
    }
  },

  addAnswer: function (data) {
    if (!this.answerModel) return;

    var model = new this.answerModel(data);
    if (!model) return;

    var answerView = AnswerViewFactory(model, this.language);
    answerView.setRenderType(this.renderType);
    answerView.updatePosition(this.$('#SCORMQuestionAnswersEditors').sortable('toArray').length + 1);
    answerView.on('destroy', this.removeAnswerView, this);
    this.answerViewCollection[answerView.cid] = answerView;

    this.$('#SCORMQuestionAnswersEditors').append(answerView.render().$el);
    if (this.renderType == 'edit') {
      this.$('#SCORMQuestionAnswersEditors').sortable('refresh');
    }

    if (this.isPositioning && model.get('score')!=null){
      this.$('#positioningAnswerScore').val(model.get('score'));
    }
    return answerView;
  },

  getAnswers: function () {
    var answers = new Backbone.Collection;
    var sortedAnswers = this.$('#SCORMQuestionAnswersEditors').sortable('toArray');
    for (var i = 0; i < sortedAnswers.length; i++) {
      var view = this.answerViewCollection[sortedAnswers[i]];
      if (!(view instanceof AnswerView)) continue;
      answers.add(view.updateModel().toJSON());
    }

    return answers;
  },

  removeAnswerView: function (removedView) {
    delete this.answerViewCollection[removedView.cid];
    //  this.updateAnswerViewPositions();
  },

  updateAnswerViewPositions: function () {
    var index = 1;
    var sortedAnswers = this.$('#SCORMQuestionAnswersEditors').sortable('toArray');
    for (key in sortedAnswers) {
      var view = this.answerViewCollection[sortedAnswers[key]];
      if (!(view instanceof AnswerView)) continue;
      view.updatePosition(index++);
      view.renderEditor();
    }
  },

  resetAnswers: function () {
    for (key in this.answerViewCollection) {
      this.answerViewCollection[key].destroy();
    }
    this.answerViewCollection = [];
  },
  preventNonDigits: function (e) {
    if (e.keyCode != 46 && e.keyCode != 8 && e.keyCode != 9) {
      if (String.fromCharCode(e.charCode).match(/[^0-9]/g)) return false;
    }
  }
});

// Partially reimplement answer collection view for Categorization answer
CategorizationAnswerCollectionView = AnswerCollectionView.extend({
  events: {
    'click #SCORMButtonAddAnswer': 'createAnswer'

  },
  initialize: function (options) {
    this.language = options.language;
    this.renderType = options.renderType;
    this.categoryToCIDMap = [];
    this.answerModel = options.answerModel;
    this.answerViewCollection = [];
    this.$el = jQuery('<div>');
    this.isCategorization = options.isCategorization;
    this.render();
  },

  getAnswers: function () {
    var answers = new Backbone.Collection;
    var sortedAnswers = this.$('#SCORMQuestionAnswersEditors').sortable('toArray')
    for (answerID in sortedAnswers) {
      var view = this.answerViewCollection[sortedAnswers[answerID]];
      if (!(view instanceof CategorizationAnswerView)) continue;
      var expandedAnswers = view.expandToAnswers();
      for (id in expandedAnswers) {
        answers.add(expandedAnswers[id]);
      }
    }

    return answers;
  },

  addAnswer: function (data) {
    if (!this.answerModel) return;

    var model = new this.answerModel(data);
    if (!model) return;

    var categoryName = model.get('answerText');
    var categoryView = this.answerViewCollection[this.categoryToCIDMap[categoryName]]

    if (categoryView && categoryName.length > 0) {
      // in case if already have this category, but don't have this option
      categoryView.addOption(model.get('matchingText'), model.get('score'));
    } else {
      var answerView = new CategorizationAnswerView({
        model: model,
        language: this.language
      });
      answerView.setRenderType(this.renderType);
      answerView.updatePosition(this.$('#SCORMQuestionAnswersEditors').sortable('toArray').length + 1);
      answerView.on('destroy', this.removeAnswerView, this);

      this.$('#SCORMQuestionAnswersEditors').append(answerView.render().$el);
      this.$('#SCORMQuestionAnswersEditors').sortable('refresh');

      this.answerViewCollection[answerView.cid] = answerView;
      this.categoryToCIDMap[categoryName] = answerView.cid;
      // append answer after! rendering
      if (model.get('matchingText') != '') answerView.addOption(model.get('matchingText'), model.get('score'));

      return answerView;
    }
  }
});