QuizCategoryModel = Backbone.Model.extend({
    defaults:{
        quizID:0,
        title:"New category",
        description:"",
        parentID:-1,
        isNew:false
    },
    move:function (options, callback) {
        jQuery.when(this.storage.move(this, options)).done(callback)
    }
});

_.extend(QuizCategoryModel.prototype, {
    storage:{
        create:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizcategory/", model.toJSON());
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "services/quizcategory/update/" + model.id, model.toJSON());
        },

        move:function (model, options) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizcategory/move/" + model.id, _.extend(model.toJSON(), options));
        },

        find:function (model) {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/quizcategory/" + model.id);
        },

        destroy:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizcategory/delete", model.toJSON());
        }
    }
});

QuizCategoryView = Backbone.View.extend({
    events:{
        "click #buttonShowCategoryEdit":"renderEdit",
        "click #buttonShowCategoryInfo":"renderView",
        "click #buttonUpdateCategory":"saveModel",
        "change #SCORMCategoryNameEdit":"updateModel",
        "click #SCORMEditButtonDescription":"editDescription"
    },

    attributes:{
        id:this.cid
    },

    initialize:function () {
        this.$el = $("<div>");
        this.resetTemporaryModel();
        this.renderView();
    },

    resetTemporaryModel:function () {
        this.temporaryModel = this.model.clone();
    },

    render:function () {
        return this;
    },

    renderView:function () {
        var language = this.options.language;
        var template = Mustache.to_html($("#quizCategoryView").html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.empty().append(template);
    },

    renderEdit:function () {
        var language = this.options.language;
        var template = Mustache.to_html($("#quizCategoryEditView").html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.empty().append(template);
        this.$("#SCORMCategoryNameEdit").tipsy({trigger:'focus', gravity:'w'});
    },

    saveModel:function () {
        if (!this.updateModel()) return false;
        $('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        this.model.save(this.temporaryModel.toJSON(), {
            success:function () {
                $('#projectLearnGeneric').unblock();
                $.growlUI(that.options.language['overlaySaveQuizCategoryMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            },
            error:function () {
                $('#projectLearnGeneric').unblock();
                $.growlWarning(that.options.language['overlaySaveQuizCategoryMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
        this.renderView();
        return true;
    },

    updateModel:function () {
        if (this.$("#SCORMCategoryNameEdit").val() == "") {
            this.$("#SCORMCategoryNameEdit").tipsy('show');
            return false;
        }
        this.temporaryModel.set({
            title:this.$("#SCORMCategoryNameEdit").val(),
            description:encodeURIComponent(this.$("#SCORMCategoryDescription").html())
        });
        return true;
    },

    editDescription:function () {
        window.RichEdit.show(this.options.language['categoryDescriptionRichTextWindowTitleLabel'], this.$("#SCORMCategoryDescription"), this.updateModel, this);
    }
});