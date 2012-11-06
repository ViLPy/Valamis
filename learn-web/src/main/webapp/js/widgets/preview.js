QuizQuestionPreviewDialog = Backbone.View.extend({
    initialize:function () {
        this.$el.dialog({
            modal:true,
            autoOpen:false,
            width:640,
            height: 480
        });
    },
    show:function (src) {
        jQuery('iframe',this.$el).attr("src", src);
        this.$el.dialog('open');
    },
    close:function () {
        this.$el.dialog('close');
    }
});
