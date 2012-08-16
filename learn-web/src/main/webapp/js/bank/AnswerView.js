AnswerViewFactory = function (answerModel, language) {
    // info: Categorization answer view separated because of complexity
    if (answerModel instanceof ChoiceAnswer) {
        return new ChoiceAnswerView({
            model:answerModel,
            language:language
        });
    } else if (answerModel instanceof ShortAnswer) {
        return new ShortAnswerView({
            model:answerModel,
            language:language
        });
    } else if (answerModel instanceof NumericAnswer) {
        return new NumericAnswerView({
            model:answerModel,
            language:language
        });
    } else if (answerModel instanceof PositioningAnswer) {
        return new PositioningAnswerView({
            model:answerModel,
            language:language
        });
    } else if (answerModel instanceof MatchingAnswer) {
        return new MatchingAnswerView({
            model:answerModel,
            language:language
        });
    } else {
        return new AnswerView({
            model:answerModel,
            language:language
        });
    }
};
// implement base model
AnswerView = Backbone.View.extend({
    events:{
        "click #SCORMAnswerRemove":"destroy"
    },
    initialize:function () {
        this.$el = $('<div>');
        this.$el.attr('id', this.cid);
    },

    destroy:function () {
        this.model.destroy();
        this.trigger('destroy', this);
        this.remove();
    },

    updatePosition:function (position) {
        this.options.position = position;
        this.render();
    },

    setRenderType:function (renderType) {
        this.renderType = renderType;
    },

    render:function () {
        this.$el.html(this.options.language['defaultModelViewLabel']);
        return this.$el;
    },

    updateModel:function () {
        return this.model;
    }
});

// Views
ChoiceAnswerView = AnswerView.extend({
    events:{
        "click #buttonSCORMEditText":"editText",
        "click #SCORMAnswerRemove":"destroy"
    },
    render:function () {
        var language = this.options.language;
        var templateName = (this.renderType == 'edit') ? '#choiceAnswerEditView' : '#choiceAnswerView';
        var template = Mustache.to_html($(templateName).html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            position:this.options.position,
            answerText:decodeURIComponent(this.model.get('answerText'))
        }, language)));
        this.$el.html(template);

        this.$("#SCORMAnswerIsCorrect").attr("checked", this.model.get('isCorrect'));

        return this.$el;
    },
    updateModel:function () {
        this.model.set({
            answerText:encodeURIComponent(this.$("#SCORMAnswerText").html()),
            isCorrect:this.$("#SCORMAnswerIsCorrect").is(':checked')
        });
        return this.model;
    },
    editText:function () {
        window.RichEdit.show(this.options.language['questionAnswerRichTextWindowTitleLabel'], this.$("#SCORMAnswerText"), this.updateModel, this);
    }
});

ShortAnswerView = AnswerView.extend({
    events:{
        "change #SCORMAnswerText":"updateModel",
        "click #SCORMAnswerRemove":"destroy"
    },
    render:function () {
        var language = this.options.language;
        var templateName = (this.renderType == 'edit') ? '#shortAnswerEditView' : '#shortAnswerView';
        var template = Mustache.to_html($(templateName).html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            position:this.options.position,
            answerText:decodeURIComponent(this.model.get('answerText'))
        }, language)));
        this.$el.html(template);

        return this.$el;
    },
    updateModel:function () {
        this.model.set({
            answerText:encodeURIComponent(this.$("#SCORMAnswerText").val())
        });
        return this.model;
    }
});

NumericAnswerView = AnswerView.extend({
    render:function () {
        var language = this.options.language;
        var templateName = (this.renderType == 'edit') ? '#numericAnswerEditView' : '#numericAnswerView';
        var template = Mustache.to_html($(templateName).html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            position:this.options.position
        }, language)));
        this.$el.html(template);

        return this.$el;
    },
    updateModel:function () {
        this.model.set({
            rangeFrom:parseFloat(this.$("#SCORMAnswerRangeFrom").val()),
            rangeTo:parseFloat(this.$("#SCORMAnswerRangeTo").val())
        });
        return this.model;
    }
});

PositioningAnswerView = AnswerView.extend({
    events:{
        "click #buttonSCORMEditText":"editText",
        "click #SCORMAnswerRemove":"destroy"
    },
    render:function () {
        var language = this.options.language;
        var templateName = (this.renderType == 'edit') ? '#positioningAnswerEditView' : '#positioningAnswerView';
        var template = Mustache.to_html($(templateName).html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            position:this.options.position,
            answerText:decodeURIComponent(this.model.get('answerText'))
        }, language)));
        this.$el.html(template);

        return this.$el;
    },
    updateModel:function () {
        this.model.set({
            answerText:encodeURIComponent(this.$("#SCORMAnswerText").html())
        });
        return this.model;
    },
    editText:function () {
        window.RichEdit.show(this.options.language['questionAnswerRichTextWindowTitleLabel'], this.$("#SCORMAnswerText"), this.updateModel, this);
    }
});

MatchingAnswerView = AnswerView.extend({
    events:{
        "click #buttonSCORMEditText":"editText",
        "change #SCORMAnswerMatchingText":"updateModel",
        "click #SCORMAnswerRemove":"destroy"
    },
    render:function () {
        var language = this.options.language;
        var templateName = (this.renderType == 'edit') ? '#matchingAnswerEditView' : '#matchingAnswerView';
        var template = Mustache.to_html($(templateName).html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            position:this.options.position,
            answerText:decodeURIComponent(this.model.get('answerText')),
            matchingText:decodeURIComponent(this.model.get('matchingText'))
        }, language)));
        this.$el.html(template);

        return this.$el;
    },
    updateModel:function () {
        this.model.set({
            answerText:encodeURIComponent(this.$("#SCORMAnswerText").html()),
            matchingText:encodeURIComponent(this.$("#SCORMAnswerMatchingText").val())
        });
        return this.model;
    },
    editText:function () {
        window.RichEdit.show(this.options.language['questionAnswerRichTextWindowTitleLabel'], this.$("#SCORMAnswerText"), this.updateModel, this);
    }
});