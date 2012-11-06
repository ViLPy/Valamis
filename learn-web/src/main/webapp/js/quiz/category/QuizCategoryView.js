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
        this.$el = jQuery("<div>");
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
        var template = Mustache.to_html(jQuery("#quizCategoryView").html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.empty().append(template);
    },

    renderEdit:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#quizCategoryEditView").html(), _.extend(this.model.toJSON(), _.extend({
            cid:this.cid,
            description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.empty().append(template);
        this.$("#SCORMCategoryNameEdit").tipsy({trigger:'focus', gravity:'w'});
    },

    saveModel:function () {
        if (!this.updateModel()) return false;
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        this.model.save(this.temporaryModel.toJSON(), {
            success:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlaySaveQuizCategoryMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            },
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlaySaveQuizCategoryMessageLabel'], that.options.language['overlayFailedMessageLabel']);
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
            description:encodeURIComponent(this.$("#SCORMCategoryDescription").html()),
            isNew:false
        });
        return true;
    },

    editDescription:function () {
        window.RichEdit.show(this.options.language['categoryDescriptionRichTextWindowTitleLabel'], this.$("#SCORMCategoryDescription"), this.updateModel, this);
    }
});