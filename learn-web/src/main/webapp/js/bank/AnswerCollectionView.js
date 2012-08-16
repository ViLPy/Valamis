AnswerCollectionView = Backbone.View.extend({
    events:{
        "click #SCORMButtonAddAnswer":"createAnswer"
    },

    initialize:function () {
        this.answerViewCollection = [];
        this.$el = jQuery('<div>');
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html($("#answerCollectionView").html(), _.extend({
            cid:this.cid
        }, language));
        this.$el.empty().append(template);
        this.$("#SCORMQuestionAnswersEditors").sortable({
            placeholder:"ui-state-highlight",
            stop:jQuery.proxy(function () {
                this.updateAnswerViewPositions();
            }, this)
        });

        if (this.options.renderType == 'edit') {
            this.$('#SCORMAddAnswersButtonBlock').show();
        } else {
            this.$('#SCORMAddAnswersButtonBlock').hide();
            this.$("#SCORMQuestionAnswersEditors").sortable('disable');
        }

        return this.$el;
    },

    createAnswer:function () {
        this.addAnswer();
    },

    addAnswer:function (data) {
        if (!this.options.answerModel) return;

        var model = new this.options.answerModel(data);
        if (!model) return;

        var answerView = AnswerViewFactory(model, this.options.language);
        answerView.setRenderType(this.options.renderType);
        answerView.updatePosition(this.$("#SCORMQuestionAnswersEditors").sortable("toArray").length + 1);
        answerView.on('destroy', this.removeAnswerView, this);
        this.answerViewCollection[answerView.cid] = answerView;

        this.$("#SCORMQuestionAnswersEditors").append(answerView.render());
        if (this.options.renderType == 'edit') this.$("#SCORMQuestionAnswersEditors").sortable("refresh");
    },

    getAnswers:function () {
        var answers = new Backbone.Collection;
        var sortedAnswers = this.$("#SCORMQuestionAnswersEditors").sortable("toArray")
        for (var i = 0; i < sortedAnswers.length; i++) {
            var view = this.answerViewCollection[sortedAnswers[i]];
            if (!(view instanceof AnswerView)) continue;
            answers.add(view.updateModel().toJSON());
        }

        return answers;
    },

    removeAnswerView:function (removedView) {
        delete this.answerViewCollection[removedView.cid];
        this.updateAnswerViewPositions();
    },

    updateAnswerViewPositions:function () {
        var index = 1;
        var sortedAnswers = this.$("#SCORMQuestionAnswersEditors").sortable("toArray");
        for (key in sortedAnswers) {
            var view = this.answerViewCollection[sortedAnswers[key]];
            if (!(view instanceof AnswerView)) continue;
            view.updatePosition(index++);
        }
    },

    resetAnswers:function () {
        for (key in this.answerViewCollection) {
            this.answerViewCollection[key].destroy();
        }
        this.answerViewCollection = [];
    }
});

// Partially reimplement answer collection view for Categorization answer
CategorizationAnswerCollectionView = AnswerCollectionView.extend({
    events:{
        "click #SCORMButtonAddAnswer":"createAnswer"

    },
    initialize:function () {
        this.categoryToCIDMap = [];
        this.answerViewCollection = [];
        this.$el = jQuery('<div>');

        this.render();
    },

    getAnswers:function () {
        var answers = new Backbone.Collection;
        var sortedAnswers = this.$("#SCORMQuestionAnswersEditors").sortable("toArray")
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

    addAnswer:function (data) {
        if (!this.options.answerModel) return;

        var model = new this.options.answerModel(data);
        if (!model) return;

        var categoryName = model.get('answerText');
        var categoryView = this.answerViewCollection[this.categoryToCIDMap[categoryName]]

        if (categoryView && categoryName.length > 0) {
            // in case if already have this category, but don't have this option
            categoryView.addOption(model.get('matchingText'));
        } else {
            var answerView = new CategorizationAnswerView({
                model:model,
                language:this.options.language
            });
            answerView.setRenderType(this.options.renderType);
            answerView.updatePosition(this.$("#SCORMQuestionAnswersEditors").sortable("toArray").length + 1);
            answerView.on('destroy', this.removeAnswerView, this);

            this.$("#SCORMQuestionAnswersEditors").append(answerView.render());
            this.$("#SCORMQuestionAnswersEditors").sortable("refresh");

            this.answerViewCollection[answerView.cid] = answerView;
            this.categoryToCIDMap[categoryName] = answerView.cid;
            // append answer after! rendering
            if (model.get('matchingText') != "") answerView.addOption(model.get('matchingText'));
        }
    }
});