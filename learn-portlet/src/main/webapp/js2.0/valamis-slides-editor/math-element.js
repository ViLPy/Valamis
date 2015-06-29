var mathElementModule = slidesApp.module('MathElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function(MathElementModule, slidesApp, Backbone, Marionette, $, _){
        MathElementModule.startWithParent = false;

        MathElementModule.View = this.BaseView.extend({
            template: '#mathElementTemplate',
            className: 'rj-element rj-math no-select',
            events: _.extend({}, this.BaseView.prototype.events, {
                'click .js-item-edit-math-expression': 'openMathEditPanel',
                'click .js-close-slide-popup-panel': 'closeMathEditPanel',
                'click .js-update-math-expr': 'updateMathExpr'
            }),
            onRender: function() {
                var self = this;
                this.constructor.__super__.onRender.apply(this, arguments);
                this.content.css({
                    'font-size': this.model.get('height') + 'px',
                    width: 'auto',
                    height: 'auto'
                });
                katex.render(this.model.get('content'), this.$el.find('.math-content')[0], { displayMode: true });
                this.$el.find('.math-expr').bind('input', function(e) {
                    try {
                        katex.render(jQueryValamis(e.target).val(), self.$el.find('.math-content')[0], { displayMode: true });
                    } catch(error) {
                        self.$el.find('.math-content').html('An error occured while parsing expression.');
                    }
                });
            },
            openMathEditPanel: function() {
                this.$('.math-edit-panel').show();
                this.$('.math-expr').val(this.model.get('content'));
                this.$('.math-expr').focus();
                slidesApp.isEditing = true;
            },
            closeMathEditPanel: function() {
                katex.render(this.model.get('content'), this.$el.find('.math-content')[0], { displayMode: true });
                this.$('.math-edit-panel').hide();
                slidesApp.isEditing = false;
                this.selectEl();
            },
            updateMathExpr: function () {
                this.model.set('content', this.$el.find('.math-expr').val());
                this.closeMathEditPanel();
            }    
        });
    }
});

mathElementModule.on('start', function() {
    slidesApp.commands.execute('toolbar:item:add', {title: 'Math', slideEntityType: 'math'});
});