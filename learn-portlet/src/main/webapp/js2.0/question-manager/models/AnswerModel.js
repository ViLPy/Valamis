AnswerModel = Backbone.Model.extend({});
AnswerModelCollection = Backbone.Collection.extend({
  model: AnswerModel
});

ChoiceAnswer = AnswerModel.extend({
  defaults: {
    answerText: '',
    isCorrect: false
  }
});

ShortAnswer = AnswerModel.extend({
  defaults: {
    answerText: ''
  }
});

NumericAnswer = AnswerModel.extend({
  defaults: {
    rangeFrom: 0,
    rangeTo: 0
  }
});

PositioningAnswer = AnswerModel.extend({
  defaults: {
    answerText: '',
    isCorrect: false
  }
});

MatchingAnswer = AnswerModel.extend({
  defaults: {
    answerText: '',
    matchingText: ''
  }
});

CategorizationAnswer = AnswerModel.extend({
  defaults: {
    answerText: '',
    matchingText: ''
  }
});