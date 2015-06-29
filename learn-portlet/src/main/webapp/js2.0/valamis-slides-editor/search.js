var SlideSearchModel = Backbone.Model.extend({
    defaults: {
        title: '',
        sortAscDirection: true
    }
});

var SlideSearchView = Backbone.View.extend({
    events: {
        'keyup .js-title-search': 'changeTitle',
        'change .js-sort-ordering-select': 'changeSortOrdering'
    },
    template: null,
    getTemplate: function(){
        if(!this.template) this.template = jQueryValamis("#search-panel").html();
        return this.template;
    },
    changeTitle: function(){this.model.set("title", this.$(".js-title-search").val());},
    changeSortOrdering: function(){this.model.set("sortAscDirection", this.$(".js-sort-ordering-select option:selected").val());},
    render: function(){
        this.$el.html(Mustache.render(this.getTemplate(), _.extend({}, this.model.attributes, slidesConfig.translations)));
        return this;
    }
});