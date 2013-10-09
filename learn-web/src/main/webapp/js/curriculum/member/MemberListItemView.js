/**
 * Certificate management UI.
 */
MemberListItemView = Backbone.View.extend({
    events:{
        "click #memberDelete":"removeMember",
        "click .expandMember":"expandMember",
        "click .collapseMember":"toggleMember",
        "click .userCourseReview":"review"
    },
    initialize:function () {
        this.$el = jQuery('<div>');
    },

    removeMember:function () {
        if (confirm(this.options.language['warningDeleteCertificateMessageLabel'])) this.trigger('member-remove', this.model.get('userID'));
    },
    renderView:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#certificateMemberListItemView").html(), _.extend(this.model.toJSON(), _.extend({
            id:this.model.id
        }, language)));
        this.$el.html(template);
    },
    render:function () {
        this.renderView();
        return this.$el;
    },
    expandMember:function () {
        this.renderCertificateProgress(this.model.get('userID'));
        this.toggleMember();
    },
    toggleMember:function(){
        this.$("#collapseUserInfo_" + this.model.id).toggle();
        this.$("#expandUserInfo_" + this.model.id).toggle();
        this.$("#userInfoBody_" + this.model.id).toggle();
    },

    renderCertificateProgress:function (userID) {
        jQuery("#userCoursesGrid_" + this.model.get('id')).html('');
        window.LearnAjax.get(Utils.getContextPath() + "/services/certificating/users/GetCertificateProgress/" + userID + "/" + this.model.get('certificateID') + "?rootUrl=" + jQuery("#rootUrl").val() ,
            jQuery.proxy(function (data) {
                for (var i = 0; i < data.length; i++) {
                    this.addSite(data[i]);
                }
            }, this)
        )
    },

    addSite:function (value) {
        var language = this.options.language;
        var id = "#userCoursesGrid_" + this.model.get('id');

        if (value.grade == "") value.grade = "-";
        else value.grade = (Math.round((parseFloat(value.grade) * 100) * 100) / 100) + "%";

        var template = Mustache.to_html(jQuery("#userCourseProgressLinkRow").html(), _.extend(value, language));

        this.$(id).append(template);
    },

    review: function(e) {
        var id = e.target.id.replace('reviewButton_', '');

        var gradeLabelID = "#reviewGrade_" + id;
        var userID = this.model.get('userID');

        window.LearnAjax.get(Utils.getContextPath() + "/services/certificating/users/GetCourseGrade/" + userID + "/" + id,
            jQuery.proxy(function (data) {
                window.CourseGradeDialog.choose(data, jQuery.proxy(function (newGrade) {
                    if (newGrade != null)
                    {
                        var formatted = (Math.round((parseFloat(newGrade) * 100) * 100) / 100) + "%" ;
                        this.$(gradeLabelID).text(formatted);
                    }
                }, this))
            }, this)
        )
    }
});
