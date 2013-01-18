/**
 * Quiz management UI. Contain list of available quizes and management controls.
 */
AvailableQuizListItemView = Backbone.View.extend({
    events:{
        "click #quizDelete":"removeQuiz",
        "click #buttonOpen":"openQuiz",
        "click #buttonDownload":"downloadQuiz",
        "click #buttonInstall":"installQuiz",
        "click #quizEdit":"editQuiz",
        "click #quizUpdate":"updateQuiz",
        "click #quizCancelUpdate":"cancelUpdateQuiz",
        "click #SCORMEditText":"editText"
    },

    initialize:function () {
        this.$el = jQuery('<li>');
        this.model.on('change', this.rerender, this);
    },

    openQuiz:function () {
        this.trigger('quiz-open', this.model.id);
    },

    downloadQuiz:function () {
        window.location.href = Utils.getContextPath() + "/services/generator/Zip/" + this.model.id + "?courseID="+jQuery("#courseID").val();
    },

    installQuiz:function () {
        var that = this;
        this.model.install(function () {
            alert(that.options.language['infoPackagesHasBeenInstalled']);
        });
    },

    editQuiz:function () {
        this.renderEdit();
    },

    updateQuiz:function () {
        if (this.$("#quizTitle").val().length === 0) {
            this.$("#quizTitle").tipsy('show');
            return false;
        }
        var that = this;
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        this.model.set({
            title:this.$("#quizTitle").val(),
            description:encodeURIComponent(this.$("#quizDescription").html())
        });
        this.model.save({}, {
            success:jQuery.proxy(function (question) {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
        this.renderView();
        return true;
    },

    cancelUpdateQuiz:function () {
        this.renderView();
        return true;
    },

    removeQuiz:function () {
        if (confirm(this.options.language['warningDeleteQuizMessageLabel'])) this.trigger('quiz-remove', this.model.id);
    },

    rerender:function () {
        switch (this.state) {
            case 'edit':
                this.renderEdit();
                break;
            case 'view':
                this.renderView();
                break;
        }
    },

    renderView:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#availableQuizListItemView").html(), _.extend(this.model.toJSON(), _.extend({
            description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.html(template);
        this.state = 'view';
    },

    renderEdit:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#availableQuizListItemEdit").html(), _.extend(this.model.toJSON(), _.extend({
            description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.html(template);
        this.state = 'edit';
        this.$("#quizTitle").tipsy({trigger:'focus', gravity:'w'});
    },

    render:function () {
        this.renderView();
        return this.$el;
    },

    editText:function () {
        window.RichEdit.show(this.options.language['quizDescriptionRichTextWindowTitleLabel'], this.$("#quizDescription"));
    }
});
