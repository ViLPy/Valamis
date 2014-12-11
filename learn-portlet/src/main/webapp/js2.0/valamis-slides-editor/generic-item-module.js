var GenericEditorItemModule = Marionette.Module.extend({
    Model: Backbone.Model.extend({
        defaults: {
            width: 300,
            top: 0,
            left: 0,
            content: ''
        }
    }),

    BaseView: Marionette.ItemView.extend({
        template: '',
        className: 'rj-element',
        events: {
            'mousedown': 'onMouseDown'
        },
        initialize: function() {
            this.listenTo(this.model, 'change', this.updateEl);
        },
        updateEl: function() {
            this.$el.css('width', this.model.get('width'));
            this.$el.css('top', this.model.get('top'));
            this.$el.css('left', this.model.get('left'));
        },
        onRender: function() {
            this.updateEl();
        },
        onMouseDown: function(e) {
            var offsetX = e.pageX - this.$el.offset().left;
            var offsetY = e.pageY - this.$el.offset().top;
            MyApp.commands.execute('drag:prepare:existing', this, e.clientX, e.clientY, offsetX, offsetY);
        }
    })
});