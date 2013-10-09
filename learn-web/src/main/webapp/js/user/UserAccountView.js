UserAccountView = Backbone.View.extend({
    events:{

    },

    initialize:function () {
        this.render();
    },

    addOne:function (element) {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#userCertificateItemView").html(), _.extend(element, _.extend({
            description:decodeURIComponent(element.description),
            logo: element.logo
        }, language)));

        var id = "#userCertificatesList";
        this.$(id).append(template);
    },

    render:function () {
        var language = this.options.language;
        var model = this.options.model;
        var template = Mustache.to_html(jQuery("#liferayAccountInfoView").html(), _.extend(model.toJSON(), _.extend({
            description:decodeURIComponent(model.get('description'))}, language)));
        this.$el.append(template);

        if (this.model.get('certificates') != null &&
            this.model.get('certificates') != undefined){
            for(var i=0; i<this.model.get('certificates').length; i++){
                this.addOne(this.model.get('certificates')[i]);
            }
        }
        return this;
    }
});
