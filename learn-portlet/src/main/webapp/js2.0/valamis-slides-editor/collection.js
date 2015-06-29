var SlideSetModel = Backbone.Model.extend().extend(SlideSetService);

var SlideSetCollection = Backbone.Collection.extend({
    model: SlideSetModel
});

var SlideSetView = Backbone.View.extend({
    events: {
        'click .js-delete-slideset': 'deleteSlideset',
        'click .js-edit-slideset': 'editModel',
        'click .js-compose-slideset': function(){ slidesConfig.eventAggregator.trigger("compose-slideset",this.model) },
        'click .js-publish-slideset': function(){ slidesConfig.eventAggregator.trigger("publish-slideset",this.model) },
        'click .js-export': function(){
            window.location = path.root + path.api.files + 'export/?action=EXPORT&contentType=SLIDE_SET' + '&id=' + this.model.id;
        }
    },
    initialize: function(){
        this.model.on('destroy',this.onAfterDelete, this);
    },
    template: null,
    getTemplate: function(){
        if(!this.template) this.template = jQueryValamis("#slideEditorTileItemView").html();
        return this.template;
    },
    render: function(){
        this.$el.html(Mustache.render(this.getTemplate(), _.extend({slidesCount: this.model.get('slides').length}, this.model.attributes, slidesConfig.translations)));
        return this;
    },
    deleteSlideset: function(){
        var confirmView = new DeleteConfirmationView({language: slidesConfig.translations});
        confirmView.on('deleteConfirmed', this.destroyModel, this);

        var title = slidesConfig.translations['deleteConfirmationTitle'];
        toastr.info(confirmView.render().$el, title,
            {
                'positionClass': 'toast-center',
                'timeOut': '0',
                'showDuration': '0',
                'hideDuration': '0',
                'extendedTimeOut': '0'
            });
    },
    destroyModel: function(){
        this.model.destroy().then(function(){ slidesConfig.eventAggregator.trigger("fetchRequired"); });
        this.remove();
    },
    editModel: function(){
        slidesConfig.eventAggregator.trigger("edit-slideset", this.model);
    }
});