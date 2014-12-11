AnswerModel = Backbone.Model.extend({});
AnswerModelCollection = Backbone.Collection.extend({
  model: AnswerModel
});

ChoiceAnswer = AnswerModel.extend({
  defaults: {
    answerText: '',
    isCorrect: false,
    score: null
  }
});

ShortAnswer = AnswerModel.extend({
  defaults: {
    answerText: '',
    score: null
  }
});

NumericAnswer = AnswerModel.extend({
  defaults: {
    rangeFrom: 0,
    rangeTo: 0,
    score: null
  }
});

PositioningAnswer = AnswerModel.extend({
  defaults: {
    answerText: '',
    isCorrect: false,
    score: null
  }
});

MatchingAnswer = AnswerModel.extend({
  defaults: {
    answerText: '',
    matchingText: '',
    score: null
  }
});

CategorizationAnswer = AnswerModel.extend({
  defaults: {
    answerText: '',
    matchingText: '',
    score: null
  }
});

$("#SCORMButtonAddAnswer").on('click', function(){

});