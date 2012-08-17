EntityView = Backbone.View.extend({
    initialize:function () {
        this.clear();
    },

    edit:function () {
        if (this.currentView) {
            this.currentView.renderEdit();
        }
    },

    saveModel:function () {
        if (this.currentView) {
            return this.currentView.saveModel();
        }
    },

    render:function (model) {
        if (this.currentView) this.currentView.remove();

        if (model instanceof CategoryModel) {
            this.currentView = new CategoryView({
                model:model,
                language:this.options.language
            });
            this.$el.html(this.currentView.render().$el);
            this.trigger('change-view', 'category');
        } else if (model instanceof QuestionModel) {
            this.currentView = new QuestionView({
                model:model,
                language:this.options.language
            });
            this.$el.html(this.currentView.render().$el);
            this.trigger('change-view', 'question');
        } else {
            this.clear();
        }
        return this;
    },

    clear:function () {
        this.$el.empty();
        var language = this.options.language;
        this.$el.html(Mustache.to_html(jQuery("#defaultView").html(), language));
        this.trigger('change-view', 'default');
    }
});


/*
 *  Category View
 */
CategoryView = Backbone.View.extend({
    events:{
        "click #buttonShowCategoryEdit":"renderEdit",
        "click #buttonShowCategoryInfo":"renderView",
        "click #SCORMEditButtonDescription":"editDescription",
        "change #SCORMCategoryNameEdit":"updateModel",
        "click #buttonUpdateCategory":"saveModel"
    },

    initialize:function () {
        this.$el = jQuery("<div>");
        this.resetTemporaryModel();
        this.renderView();
    },


    updateModel:function () {
        if (this.$("#SCORMCategoryNameEdit").val().length === 0) {
            this.$("#SCORMCategoryNameEdit").tipsy("show");
            return false;
        }
        this.temporaryModel.set({
            title:this.$("#SCORMCategoryNameEdit").val(),
            description:encodeURIComponent(this.$("#SCORMCategoryDescription").html())
        });
        return true;
    },

    saveModel:function () {
        if (!this.updateModel()) return false;
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        this.model.save(this.temporaryModel.toJSON(), {
            success:jQuery.proxy(function (question) {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayCategorySaveMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayCategorySaveMessageLabel'], that.options.language['overlayProcessMessageLabel']);
            }
        });
        this.renderView();
        return true;
    },

    resetTemporaryModel:function () {
        this.temporaryModel = this.model.clone();
    },

    render:function () {
        return this;
    },

    renderView:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#categoryView").html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            description:decodeURIComponent(this.model.get('description'))
        }, language)));

        this.$el.empty().append(template);
    },

    renderEdit:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#categoryEditView").html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            description:decodeURIComponent(this.model.get('description'))
        }, language)));

        this.$el.empty().append(template);
        this.$("#SCORMCategoryNameEdit").tipsy({trigger:'focus', gravity:'w'});
    },

    editDescription:function () {
        window.RichEdit.show(this.options.language["categoryDescriptionRichTextWindowTitleLabel"], this.$("#SCORMCategoryDescription"), this.updateModel, this);
    }
});

/*
 *   Question view
 *   TODO: create separate AnswerCollection view
 */
QuestionView = Backbone.View.extend({
    events:{
        "change #SCORMQuestionType":"onTypeChange",
        "click #SCORMEditText":"editText",
        "click #SCORMEditExplanation":"editExplanation",
        "click #buttonUpdateQuestion":"saveModel"
    },

    initialize:function () {
        this.answerCollectionView = null;
        this.$el = jQuery("<div>");
        this.resetTemporaryModel();
        this.renderView();
    },

    render:function () {
        return this;
    },

    updateModel:function () {
        if (this.$("#SCORMQuestionTitleEdit").val().length === 0) {
            this.$("#SCORMQuestionTitleEdit").tipsy("show");
            return false;
        }
        this.temporaryModel.set({
            title:this.$("#SCORMQuestionTitleEdit").val(),
            text:encodeURIComponent(this.$("#SCORMQuestionTextView").html()),
            explanationText:encodeURIComponent(this.$("#SCORMExplanationTextView").html()),
            questionType:parseInt(this.$("#SCORMQuestionType").val().replace("type", "")),
            forceCorrectCount:this.$("#SCORMQuestionBounded").is(':checked'),
            isCaseSensitive:this.$("#SCORMQuestionCaseSensitive").is(':checked'),
            answers:JSON.stringify(this.answerCollectionView.getAnswers())
        });
        return true;
    },

    saveModel:function () {
        if (!this.updateModel()) return false;
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        this.model.save(this.temporaryModel.toJSON(), {
            success:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayQuestionSaveMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            },
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayQuestionSaveMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
        this.renderView();
        return true;
    },

    resetTemporaryModel:function () {
        this.temporaryModel = this.model.clone();
    },

    renderView:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#questionView").html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            text:decodeURIComponent(this.model.get('text')),
            explanationText:decodeURIComponent(this.model.get('explanationText')),
            questionTypeString:this.model.getStringType()
        }, language)));

        this.$el.empty().append(template);

        this.$("#SCORMQuestionBounded").attr("checked", this.model.get('forceCorrectCount'));
        this.$("#SCORMQuestionCaseSensitive").attr("checked", this.model.get('isCaseSensitive'));

        this.updateElementVisibility();
        this.renderAnswers('view');

        return this;
    },

    renderEdit:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#questionEditView").html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            text:decodeURIComponent(this.model.get('text')),
            explanationText:decodeURIComponent(this.model.get('explanationText')),
            questionTypeString:this.model.getStringType()
        }, language)));

        this.$el.empty().append(template);

        this.$("#SCORMQuestionType").val("type" + this.model.get('questionType'));
        this.$("#SCORMQuestionBounded").attr("checked", this.model.get('forceCorrectCount'));
        this.$("#SCORMQuestionCaseSensitive").attr("checked", this.model.get('isCaseSensitive'));

        this.updateElementVisibility();
        this.renderAnswers('edit');
        this.$("#SCORMQuestionTitleEdit").tipsy({trigger:'focus', gravity:'w'});

        return this;
    },

    updateElementVisibility:function () {
        this.$("#SCORMQuestionIsBounded").hide();
        this.$("#SCORMQuestionIsCaseSensitive").hide();
        this.$("#SCORMQuestionAnswers").show();

        switch (this.temporaryModel.get('questionType')) {
            case QuestionType.ChoiceQuestion:
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
    },

    renderAnswers:function (renderType) {
        if (this.answerCollectionView) this.answerCollectionView.remove();

        if (this.temporaryModel.get('questionType') == QuestionType.CategorizationQuestion) {
            this.answerCollectionView = new CategorizationAnswerCollectionView({
                answerModel:this.temporaryModel.answerModel,
                renderType:renderType,
                language:this.options.language
            });
        } else {
            this.answerCollectionView = new AnswerCollectionView({
                answerModel:this.temporaryModel.answerModel,
                renderType:renderType,
                language:this.options.language
            });
        }

        this.$("#SCORMQuestionAnswers").html(this.answerCollectionView.render());

        // fill answers
        var answers = eval(this.temporaryModel.get('answers'));
        _.each(answers, function (answer) {
            this.answerCollectionView.addAnswer(answer);
        }, this);
    },

    editText:function () {
        window.RichEdit.show(this.options.language['questionTextRichEditWindowTitleLabel'], this.$("#SCORMQuestionTextView"), this.updateModel, this);
    },

    editExplanation:function () {
        window.RichEdit.show(this.options.language['questionExplanationTextRichEditWindowTitleLabel'], this.$("#SCORMExplanationTextView"), this.updateModel, this);
    },

    onTypeChange:function () {
        this.answerCollectionView.resetAnswers();
        this.updateModel();
        this.updateElementVisibility();
        this.renderAnswers('edit');
    }
});