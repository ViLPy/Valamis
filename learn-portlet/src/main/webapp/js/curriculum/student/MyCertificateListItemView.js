MyCertificateListItemView = Backbone.View.extend({
    events:{
        "click .toggleCertificate":"toggleCertificate",
        "click #issueBadge":"issueBadge"
    },
    initialize:function () {
    },

    toggleCertificate:function (e) {
        var id =  this.model.id;
        this.$("#collapseCertificate_" + id).toggle();
        this.$("#expandCertificate_" + id).toggle();
        this.$("#myCertificateBody_" + id).toggle();
    },

    issueBadge:function(){
        OpenBadges.issue(["http://" + jQuery("#rootUrl").val() + "/" + Utils.getContextPath() +
            "services/certificating/issueBadge/" + jQuery("#studentID").val() + "/" +this.model.id + "?rootUrl=" + jQuery("#rootUrl").val() ],
            function(errors, successes) { });
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#myCertificateListItemView").html(), _.extend(this.model.toJSON(),
            _.extend({
                id:this.model.get('id'),
                description:decodeURIComponent(this.model.get('description')),
                logo: this.model.get('logo')
            }, language)));
        this.$el.html(template);

        this.isFirstNotPassed = true;
        for (var i = 0; i < this.model.get('sites').length; i++) {
            this.addSite(this.model.get('sites')[i]);
        }
        return this.$el;
    },

    addSite:function (value) {
        var language = this.options.language;
        var id = "#SCORMMyCertificatesGrid_" + this.model.get('id');
        var template = null;

        if (value.grade == "") value.grade = "-";
        else value.grade = (Math.round((parseFloat(value.grade) * 100) * 100) / 100) + "%";

        if (value.grade != "-" || this.isFirstNotPassed)
            template = Mustache.to_html(jQuery("#myCertificateSiteLinkRow").html(), _.extend(value, language));
        else
            template = Mustache.to_html(jQuery("#myCertificateSiteRow").html(), _.extend(value, language));

        if (value.grade == "-" && this.isFirstNotPassed) this.isFirstNotPassed = false;

        this.$(id).append(template);

    }


});
