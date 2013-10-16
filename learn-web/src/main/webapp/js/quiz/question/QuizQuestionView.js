QuizQuestionView = Backbone.View.extend({
    events:{
    },

    attributes:{
        id:this.cid
    },

    initialize:function () {
        this.$el = jQuery("<div>");
        this.temporaryModel = this.model.clone();
        this.renderView();
    },

    render:function () {
        return this;
    },

    saveModel:function () {
        if (!this.updateModel()) return false;
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        this.model.save(this.temporaryModel.toJSON(), {
            success:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlaySaveQuizQuestionMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            },
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlaySaveQuizQuestionMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
        this.renderView();
        return true;
    },

    updateModel:function () {
        if (this.$("#externalContentTitle").val() == "") {
            this.$("#externalContentTitle").tipsy('show');
            return false;
        }
        if (this.$("#externalContentURL").val() == "") {
            this.$("#externalContentURL").tipsy('show');
            return false;
        }
        this.temporaryModel.set({
            title:this.$("#externalContentTitle").val(),
            url:this.$("#externalContentURL").val(),
            isNew:false
        });
        return true;
    },

    renderView:function () {
        switch (this.model.get("questionType")) {
            case "QuestionBank":
                this.renderRegularQuestion();
                break;
            case "External":
                this.renderExternalQuestion();
                break;
            case "PlainText":
                this.renderPlainTextQuestion();
                break;
        }
    },

    renderEdit:function () {
        switch (this.model.get("questionType")) {
            case "QuestionBank":
                this.renderRegularQuestion(); // don't have edit
                break;
            case "External":
                this.renderExternalQuestionEdit();
                break;
            case "PlainText":
                this.renderPlainTextQuestion(); // don't have edit
                break;
        }
    },

    renderExternalQuestion:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#quizExternalQuestionView").html(), _.extend(this.model.toJSON(), language));
        this.$el.empty().append(template);
    },

    renderPlainTextQuestion:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#quizPlainTextQuestionView").html(), _.extend(this.model.toJSON(), language));
        this.$el.empty().append(template.trim().split("\r").join("").split("%2B").join("+"));
    },

    renderExternalQuestionEdit:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#quizExternalQuestionEditView").html(), _.extend(this.model.toJSON(), language));
        this.$el.empty().append(template);
        this.$("#externalContentTitle").tipsy({trigger:'focus', gravity:'w'});
        this.$("#externalContentURL").tipsy({trigger:'focus', gravity:'w'});
    },

    renderRegularQuestion:function () {
        var questionModel = new QuestionModel(this.model.get('question'));
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#quizQuestionView").html(), _.extend(questionModel.toJSON(), _.extend({
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
    },

    updateElementVisibility:function (model) {
        this.$("#SCORMQuestionIsBounded").hide();
        this.$("#SCORMQuestionIsCaseSensitive").hide();
        this.$("#SCORMQuestionAnswers").show();

        switch (model.get('questionType')) {
            case QuestionType.ChoiceQuestion:
                this.$("#SCORMQuestionIsBounded").show();
                break;
            case QuestionType.ShortAnswerQuestion:
                this.$("#SCORMQuestionIsCaseSensitive").show();
                break;
            case QuestionType.PlainText:
            case QuestionType.EssayQuestion:
            case QuestionType.EmbeddedAnswerQuestion:
                this.$("#SCORMQuestionAnswers").hide();
                break;
        }
    }

});