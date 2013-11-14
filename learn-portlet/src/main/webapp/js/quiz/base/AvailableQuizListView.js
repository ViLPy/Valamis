AvailableQuizListView = Backbone.View.extend({
    events:{
        "click #SCORMButtonAddQuiz":"createQuiz",
        "click #sortList":"sortList",
        "keyup #quizSearch":"searchList"
    },

    initialize:function () {
        this.views = [];
        this.sortAZ = true;

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('reset', this.addAll, this);
        this.collection.bind('remove', this.deleteQuiz, this);

        this.render();
    },

    createQuiz:function () {
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        var quiz = new Quiz();
        quiz.save({}, {
            success:jQuery.proxy(function (quiz, response) {
                quiz.set(response);
                this.collection.add(quiz);
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayCreateQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayCreateQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
    },

    openQuiz:function (id) {
        this.trigger('quiz-open', this.collection.get(id));
    },

    deleteQuiz:function (model) {
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        var modelID = model.id;
        model.destroy({
            success:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayDeleteQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            },
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayDeleteQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
        this.views[modelID].remove();
        delete this.views[modelID];

        this.trigger('quiz-remove', modelID);
    },

    removeQuiz:function (id) {
        var model = this.collection.get(id);
        this.collection.remove(model);
        this.quizList.remove(id)
    },

    addOne:function (element) {
        var view = new AvailableQuizListItemView({
            model:element,
            language:this.options.language
        });

        this.views[element.id] = view;

        var viewDOM = view.render();

        this.$("#quizList").prepend(viewDOM);
        view.on('quiz-open', this.openQuiz, this);
        view.on('quiz-remove', this.removeQuiz, this);

        element.on('change', function (element) {
            this.quizList.update(element.id, {"title":element.get('title'), "description":element.get('description')});
        }, this);

        this.quizList.add(element.id, viewDOM, {"title":element.get('title'), "description":element.get('description')}, true);
    },

    addAll:function () {
        this.collection.each(this.addOne, this);
    },

    searchList:function () {
        this.quizList.filter(this.$("#quizSearch").val() || "");
    },

    sortList:function () {
        if (this.quizList) {
            this.quizList.sort("title", this.sortAZ ? "asc" : "desc");

            var sortOrderString = (this.sortAZ) ? this.options.language['sortOrderAscLabel'] : this.options.language['sortOrderDescLabel'];
            this.$("#sortList").html(sortOrderString);
            this.sortAZ = !this.sortAZ;
        }
    },

    removeQuizView:function (quizView) {
        quizView.remove();
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#availableQuizListView").html(), _.extend({
            cid:this.cid
        }, language));
        this.$el.append(template);

        this.quizList = this.$("#quizList").List();

        return this;
    }
});
