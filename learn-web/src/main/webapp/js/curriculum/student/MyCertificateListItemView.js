MyCertificateListItemView = Backbone.View.extend({
    events:{ },
    initialize:function () {    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#myCertificateListItemView").html(), _.extend(this.model.toJSON(), _.extend({
            id:this.model.get('id'), description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.prepend(template);

        this.isFirstNotPassed = true;
        for(var i=0; i<this.model.get('sites').length; i++){
            this.addSite(this.model.get('sites')[i]);
        }
        return template;
    },

    addSite: function(value){
        var language = this.options.language;
        var id = "#SCORMMyCertificatesGrid_" + this.model.get('id');
        var template = null;

        if (value.grade == "") value.grade = "-";
        else value.grade =  (Math.round((parseFloat(value.grade) * 100) * 100) / 100) + "%" ;

        if (value.grade != "-" || this.isFirstNotPassed)
            template = Mustache.to_html(jQuery("#myCertificateSiteLinkRow").html(), _.extend(value, language));
        else
            template = Mustache.to_html(jQuery("#myCertificateSiteRow").html(), _.extend(value, language));

        if (value.grade == "-" && this.isFirstNotPassed) this.isFirstNotPassed = false;

        this.$(id).append(template);
        /*
        if (value.grade != "" || this.isFirstNotPassed)
        {
            if (this.isFirstNotPassed) this.isFirstNotPassed = false;
            if (value.grade == "") value.grade = "-";
            else value.grade =  (Math.round((parseFloat(value.grade) * 100) * 100) / 100) + "%" ;
            var template = Mustache.to_html(jQuery("#myCertificateSiteLinkRow").html(), _.extend(value, language));
            this.$(id).append(template);
        }
        else {
            this.isFirstNotPassed = false;
            value.grade = "-";
            var template = Mustache.to_html(jQuery("#myCertificateSiteRow").html(), _.extend(value, language));
            this.$(id).append(template);
        }*/
    }


});
