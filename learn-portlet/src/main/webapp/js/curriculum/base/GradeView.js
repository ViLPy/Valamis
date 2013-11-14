UserCourseGradeDialog = Backbone.View.extend({
    events:{
        "click #saveCourseGradeButton":"saveCourseGrade",
        "click #cancelCourseGradeButton":"cancelCourseGrade"
    },
    callback:function (newGrade) {
    },
    initialize:function () {
        var language = this.options.language;
        var renderedTemplate = Mustache.to_html(jQuery('#userCourseGradeDialog').html(), language)
        this.$el.html(renderedTemplate);

        this.$el.dialog({
            autoOpen:false,
            modal:true,
            width:350
        });
    },
    render:function (model) {
        jQuery("#certificateCourseComment").val("");
        jQuery('input:radio[name="grade"]').attr('checked', false);

        var grade = decodeURIComponent(model.grade);
        jQuery('input:radio[name="grade"]').filter('[value="'+grade+'"]').attr('checked', 'checked');
        jQuery("#certificateCourseComment").val(model.comment);
        jQuery("#certificatingCourseID").val(model.siteID);
        jQuery("#certificatingUserID").val(model.userID);
    },
    choose:function (model, onChoose) {
        this.callback = onChoose;
        this.render(model);
        this.$el.dialog('open');
    },

    saveCourseGrade: function(){
        return window.LearnAjax.post(Utils.getContextPath() + "services/gradebook/SaveCourseGradeAndComment",
                {courseID: jQuery("#certificatingCourseID").val(),
                userID: jQuery("#certificatingUserID").val(),
                grade: jQuery("input:radio[name=grade]:checked").val(),
                comment: jQuery("#certificateCourseComment").val()},
                this.close(this)
                )
    },

    close: function(view){
        this.callback(jQuery("input:radio[name=grade]:checked").val());
        view.$el.dialog('close');
    },

    cancelCourseGrade: function(){
        this.$el.dialog('close');
    }

})
