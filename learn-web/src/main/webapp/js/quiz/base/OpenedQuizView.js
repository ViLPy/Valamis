/**
 * View for displaying opened quizes. Contain tabs with quizes.
 */
OpenedQuizView = Backbone.View.extend({

    getUID:function (id) {
        return "#quizTab" + id;
    },

    initialize:function () {
        var that = this;
        var quizTabs = this.$el.tabs({
            add:jQuery.proxy(function (e, ui) {
                var id = ui.panel.id.replace("quizTab", "");
                // append close thingy
                jQuery(ui.tab).parents('li:first')
                    .append('<span class="ui-tabs-close ui-icon ui-icon-close" title="' + this.options.language['tabsCloseTabButtonLabel'] + '"></span>')
                    .find('span.ui-tabs-close')
                    .click((function (quizID) {
                    return function () {
                        that.collection.remove(quizID);
                    }
                })(id));

                var editView = new QuizEditView({
                    el:jQuery(this.getUID(id)),
                    model:this.collection.get(id),
                    language:this.options.language
                });

                // select just added tab
                quizTabs.tabs('select', '#' + ui.panel.id);
            }, this)
        });

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('remove', this.remove, this);
    },

    remove:function (element) {
        this.$el.tabs('remove', this.$el.children().index(jQuery(this.getUID(element.id))) - 1);
    },

    select:function (element) {
        this.$el.tabs('select', this.getUID(element.id));
    },

    addOne:function (quizModel) {
        quizModel.on('change', this.updateQuiz, this);
        this.$el.tabs('add', this.getUID(quizModel.id), quizModel.get('title'));
    },

    updateQuiz:function (model) {
        this.$("a[href='#quizTab" + model.id + "'] > span").html(model.get('title'));
    }
});