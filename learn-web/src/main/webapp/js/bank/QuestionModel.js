var QuestionType = {
    "ChoiceQuestion":0,
    "ShortAnswerQuestion":1,
    "NumericQuestion":2,
    "PositioningQuestion":3,
    "MatchingQuestion":4,
    "EssayQuestion":5,
    "EmbeddedAnswerQuestion":6,
    "CategorizationQuestion":7
};

var QuestionAnswerType = {
    "ChoiceQuestion":ChoiceAnswer,
    "ShortAnswerQuestion":ShortAnswer,
    "NumericQuestion":NumericAnswer,
    "PositioningQuestion":PositioningAnswer,
    "MatchingQuestion":MatchingAnswer,
    "CategorizationQuestion":CategorizationAnswer
};

QuestionModel = Backbone.Model.extend({
    defaults:{
        title:"New question",
        text:"",
        explanationText:"",
        questionType:QuestionType.ChoiceQuestion,
        categoryID:null,
        forceCorrectCount:false,
        isCaseSensitive:false,
        answers:"[]",
        newModel:false
    },

    initialize:function () {
        this.updateAnswerModel();
        this.on('change', this.updateAnswerModel, this);
        this.on('sync', this.updateAnswerModel, this);
    },

    getStringType:function () {
        switch (this.get('questionType')) {
            case QuestionType.ChoiceQuestion:
                return "Choice question";
                break;
            case QuestionType.ShortAnswerQuestion:
                return "Short answer question";
                break;
            case QuestionType.NumericQuestion:
                return "Numeric question";
                break;
            case QuestionType.PositioningQuestion:
                return "Positioning question";
                break;
            case QuestionType.MatchingQuestion:
                return "Matching question";
                break;
            case QuestionType.EssayQuestion:
                return "Essay question";
                break;
            case QuestionType.EmbeddedAnswerQuestion:
                return "Embedded question";
                break;
            case QuestionType.CategorizationQuestion:
                return "Categorization question";
                break;
            default:
                return "";
        }
    },

    updateAnswerModel:function () {
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
    },

    move:function (options, callback) {
        jQuery.when(this.storage.move(this, options)).done(callback)
    }
});

_.extend(QuestionModel.prototype, {
    storage:{
        create:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/question/?courseID="+jQuery("#courseID").val(), model.toJSON());
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/question/update/" + model.id, model.toJSON());
        },

        move:function (model, options) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/question/move/" + model.id, _.extend(model.toJSON(), options));
        },

        find:function (model) {
        },

        findAll:function () {
        },

        destroy:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/question/delete/" + model.id);
        }
    }
});