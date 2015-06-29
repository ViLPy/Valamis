var _LessonDisplayMode = {};

_LessonDisplayMode.Model = Backbone.Model.extend({
    defaults: {
        displayMode: 'list'
    }
});

_LessonDisplayMode.View = _LessonDefaultView.extend({
    tagName: 'span',
    templateSelector: '#lesson-collection-display-mode',
    initialize: function(){
        this.listenTo(this.model, 'change:displayMode', function(){
            this.$('.js-tile-view').toggleClass('active', this.model.get('displayMode') == 'tile');
            this.$('.js-list-view').toggleClass('active', this.model.get('displayMode') == 'list');
        });
    },
    events: {
        'click .js-tile-view': function(){ this.model.set('displayMode', 'tile') },
        'click .js-list-view': function(){ this.model.set('displayMode', 'list') }
    }
});
