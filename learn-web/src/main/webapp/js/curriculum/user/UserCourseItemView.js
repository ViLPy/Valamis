UserCourseItemView = Backbone.View.extend({
    events:{ },
    initialize:function () {    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#myCertificateListItemView").html(), _.extend(this.model.toJSON(), _.extend({
            id:this.model.get('id'), description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.prepend(template);

        for(var i=0; i<this.model.get('sites').length; i++){
            this.addSite(this.model.get('sites')[i]);
        }
        return template;
    },

    addSite: function(value){
        var language = this.options.language;
        if (value.grade != "")
            value.grade =  (Math.round((parseFloat(value.grade) * 100) * 100) / 100) + "%" ;
        else value.grade = "-";

        var template = Mustache.to_html(jQuery("#myCertificateSiteRow").html(), _.extend(value, language));
        var id = "#SCORMMyCertificatesGrid_" + this.model.get('id');
        this.$(id).append(template);
    }


});
