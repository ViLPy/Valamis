QuizQuestionModel = Backbone.Model.extend({
    defaults:{
        quizID:0,
        title:"New quiz question",
        questionID:-1,
        categoryID:-1,
        question:null
    },

    initialize:function () {
        try {
            this.set('title', this.get('question').title);
            this.set('questionID', this.get('question').id);
        } catch (e) {
        }
    },

    move:function (options, callback) {
        jQuery.when(this.storage.move(this, options)).done(callback);
    }
});

_.extend(QuizQuestionModel.prototype, {
    storage:{
        create:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizquestion/", model.toJSON());
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizquestion/update/" + model.id, model.toJSON());
        },

        move:function (model, options) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizquestion/move/" + model.id, _.extend(model.toJSON(), options));
        },

        find:function (model) {
        },

        findAll:function () {
        },

        destroy:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizquestion/delete/" + model.id);
        }
    }
});

QuizQuestionView = Backbone.View.extend({
    events:{
    },

    attributes:{
        id:this.cid
    },

    initialize:function () {
        this.$el = $("<div>");
        this.render();
    },

    render:function () {
        var questionModel = new QuestionModel(this.model.get('question'));
        var language = this.options.language;
        var template = Mustache.to_html($("#quizQuestionView").html(), _.extend(questionModel.toJSON(), _.extend({
            cid:this.cid,
            typeString:questionModel.getStringType(),
            text:decodeURIComponent(questionModel.get('text')),
            description:decodeURIComponent(questionModel.get('description')),
            explanationText:decodeURIComponent(questionModel.get('explanationText')),
            questionTypeString:questionModel.getStringType()
        }, language)));
        this.$el.empty().append(template);

        this.$("#SCORMQuestionBounded").attr("checked", questionModel.get('forceCorrectCount')).attr('disabled', true);
        this.$("#SCORMQuestionCaseSensitive").attr("checked", questionModel.get('isCaseSensitive')).attr('disabled', true);

        this.updateElementVisibility(questionModel);

        return this;
    },

    updateElementVisibility:function (model) {
        this.$("#SCORMQuestionIsBounded").hide();
        this.$("#SCORMQuestionIsCaseSensitive").hide();
        this.$("#SCORMQuestionAnswers").show();

        switch (model.get('questionType')) {
            case QuestionType.ChoiceQuestion:
            case QuestionType.PositioningQuestion:
                this.$("#SCORMQuestionIsBounded").show();
                break;
            case QuestionType.ShortAnswerQuestion:
                this.$("#SCORMQuestionIsCaseSensitive").show();
                break;
            case QuestionType.EssayQuestion:
            case QuestionType.EmbeddedAnswerQuestion:
                this.$("#SCORMQuestionAnswers").hide();
                break;
        }
    }

});