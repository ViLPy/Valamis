CategorizationAnswerView = AnswerView.extend({
    events:{
        "click #buttonSCORMEditText":"editText",
        "click #SCORMButtonAddOption":"onAddOption",
        "click #deleteAnswer":"destroy"
    },

    initialize:function () {
        this.optionsList = [];

        this.$el = $('<div>');
        this.$el.attr('id', this.cid);

        this.render();
    },

    render:function () {
        var language = this.options.language;
        var templateName = (this.renderType == 'edit') ? '#categorizationAnswerEditView' : '#categorizationAnswerView'
        var template = Mustache.to_html($(templateName).html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            position:this.options.position,
            answerText:decodeURIComponent(this.model.get('answerText'))
        }, language)));
        this.$el.html(template);

        for (key in this.optionsList) {
            this.$("#SCORMAnswerOptions").append(this.optionsList[key].render(this.renderType));
        }

        return this.$el;
    },

    expandToAnswers:function () {
        var answerModels = [];
        var categoryName = this.model.get('answerText');

        var categorizationModel;

        if (this.optionsList.length == 0) {
            if (categoryName.length > 0) {
                categorizationModel = new CategorizationAnswer({
                    answerText:categoryName,
                    matchingText:""
                });
                answerModels.push(categorizationModel.toJSON());
            }
        } else {
            if (categoryName.length > 0) {
                for (key in this.optionsList) {
                    categorizationModel = new CategorizationAnswer({
                        answerText:categoryName,
                        matchingText:this.optionsList[key].getOptionText()
                    });
                    answerModels.push(categorizationModel.toJSON())
                }
            }
        }

        return answerModels;
    },

    updateModel:function () {
        this.model.set({
            answerText:encodeURIComponent(this.$("#SCORMAnswerText").html())
        });
    },

    addOption:function (option) {
        var view = new CategorizationOptionView({
            optionText:option,
            language: this.options.language
        });
        this.optionsList.push(view);
        this.$("#SCORMAnswerOptions").append(view.render(this.renderType));

        view.on('destroy', this.removeOption, this);
    },

    removeOption:function (option) {
        this.optionsList = _.filter(this.optionsList, function (e) {
            return e.cid != option.cid
        }, this);
    },

    editText:function () {
        window.RichEdit.show(this.options.language['categorizationQuestionCategoryRichTextWindowTitleLabel'], this.$("#SCORMAnswerText"), this.updateModel, this);
    },

    onAddOption:function () {
        this.addOption("");
    }
});

CategorizationOptionView = Backbone.View.extend({
    events:{
        "click #buttonSCORMEditOptionText":"editOptionText",
        "click #SCORMButtonRemoveOption":"destroy"
    },

    initialize:function () {
        this.$el = $('<div>');
        this.optionText = this.options.optionText;
    },

    destroy:function () {
        this.trigger('destroy', this);
        this.remove();
    },

    render:function (renderType) {
        var language = this.options.language;
        var templateName = (renderType == 'edit') ? '#categorizationOptionEdit' : '#categorizationOption';
        var template = Mustache.to_html($(templateName).html(), _.extend({
            text:decodeURIComponent(this.optionText)
        }, language));
        this.$el.empty().append(template);

        return this.$el;
    },

    getOptionText:function () {
        return this.optionText;
    },

    updateText:function (text) {
        this.optionText = encodeURIComponent(text);
    },

    editOptionText:function () {
        window.RichEdit.show(this.options.language['categorizationQuestionOptionRichTextWindowTitleLabel'], this.$("#SCORMAnswerOptionText"), this.updateText, this);
    }
});