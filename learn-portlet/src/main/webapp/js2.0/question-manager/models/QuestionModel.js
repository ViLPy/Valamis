var QuestionType = {
    "ChoiceQuestion": 0,
    "ShortAnswerQuestion": 1,
    "NumericQuestion": 2,
    "PositioningQuestion": 3,
    "MatchingQuestion": 4,
    "EssayQuestion": 5,
    "EmbeddedAnswerQuestion": 6,
    "CategorizationQuestion": 7,
    "PlainText": 8,
    "PurePlainText": 9
};


var QuestionAnswerType = {
    "ChoiceQuestion": ChoiceAnswer,
    "ShortAnswerQuestion": ShortAnswer,
    "NumericQuestion": NumericAnswer,
    "PositioningQuestion": PositioningAnswer,
    "MatchingQuestion": MatchingAnswer,
    "CategorizationQuestion": CategorizationAnswer
};


QuestionService = new Backbone.Service({
    url: path.root,
    targets: {
        'move': {
            'path': function (model) {
                return path.api.questions + model.id
            },
            'method': 'post',
            'data': function (model, options) {
                return {
                    'action': 'move',
                    'id': model.id,
                    'parentID': options.parentID,
                    'index': options.index,
                    'courseId': Utils.getCourseId()
                }
            }
        }
    },
    sync: {
        'read': {
            'path': function (model) {
                return path.api.questions + model.id
            },
            'data': function () {
                var params = {
                    'action' : 'getById',
                    'courseId': Utils.getCourseId()
                };

                return params;
            },
            'method': 'get'
        },
        'create': {
            'path': path.api.questions,
            'data': function(model){
                var params = {
                    'action' : 'add',
                    'courseId': Utils.getCourseId()
                };

                _.extend(params, model.toJSON());
                return params;
            },
            'method': 'post'
        },
        'update': {
            'path': function (model) {
                return path.api.questions + model.id;
            },
            'data': function(model){
                var params = {
                    'action' : 'update',
                    'courseId': Utils.getCourseId()
                };

                _.extend(params, model.toJSON());
                return params;
            },
            'method': 'post'
        },
        'delete': {
            'path': function (model) {
                return path.api.questions + model.id;
            },
            'data': function(model){
                var params = {
                    'action' : 'delete',
                    'courseId': Utils.getCourseId()
                };

                return params;
            },
            'method': 'post'
        }
    }
});

QuestionModel = Backbone.Model.extend({
    defaults: {
        title: 'New question',
        text: '',
        explanationText: '',
        rightAnswerText: '',
        wrongAnswerText: '',
        questionType: QuestionType.ChoiceQuestion,
        categoryId: null,
        forceCorrectCount: false,
        isCaseSensitive: false,
        answers: '[]'
    },

    initialize: function () {
        this.updateAnswerModel();
        this.on('change', this.updateAnswerModel, this);
        this.on('sync', this.updateAnswerModel, this);
    },

    getStringType: function () {
        switch (this.get('questionType')) {
            case QuestionType.ChoiceQuestion:
                return 'Choice question';
                break;
            case QuestionType.ShortAnswerQuestion:
                return 'Short answer question';
                break;
            case QuestionType.NumericQuestion:
                return 'Numeric question';
                break;
            case QuestionType.PositioningQuestion:
                return 'Positioning question';
                break;
            case QuestionType.MatchingQuestion:
                return 'Matching question';
                break;
            case QuestionType.EssayQuestion:
                return 'Essay question';
                break;
            case QuestionType.EmbeddedAnswerQuestion:
                return 'Embedded question';
                break;
            case QuestionType.CategorizationQuestion:
                return 'Categorization question';
                break;
            case QuestionType.PlainText:
                return 'Plain text';
                break;
            case QuestionType.PurePlainText:
                return 'Plain text';
                break;
            default:
                return '';
        }
    },

    updateAnswerModel: function () {
        switch (this.get('questionType')) {
            case QuestionType.ChoiceQuestion:
                this.answerModel = QuestionAnswerType.ChoiceQuestion;
                break;
            case QuestionType.ShortAnswerQuestion:
                this.answerModel = QuestionAnswerType.ShortAnswerQuestion;
                break;
            case QuestionType.NumericQuestion:
                this.answerModel = QuestionAnswerType.NumericQuestion;
                break;
            case QuestionType.PositioningQuestion:
                this.answerModel = QuestionAnswerType.PositioningQuestion;
                break;
            case QuestionType.MatchingQuestion:
                this.answerModel = QuestionAnswerType.MatchingQuestion;
                break;
            case QuestionType.CategorizationQuestion:
                this.answerModel = QuestionAnswerType.CategorizationQuestion;
                break;
            default:
                this.answerModel = null;
        }
    }
}).extend(QuestionService);