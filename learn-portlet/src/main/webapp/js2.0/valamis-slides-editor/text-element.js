MyApp.module('TextElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function(TextElementModule, MyApp, Backbone, Marionette, $, _){
        TextElementModule.startWithParent = false;

        TextElementModule.Model = Backbone.Model.extend({
            defaults: {
                width: 300,
                top: 0,
                left: 0,
                content: 'New Text Element',
                'borderWidth': 0
            }
        });

        TextElementModule.EditView = Marionette.ItemView.extend({
            template: '#textElementEditTemplate',
            events: {
                'change .border-width':'updateBorder'
            },
            onRender: function() {
                this.$('.border-width').val(this.model.get('borderWidth'));
            },
            updateBorder: function() {
                this.model.set('borderWidth', this.$('.border-width').val());
            }
        });

        TextElementModule.View = this.BaseView.extend({
            template: '#textElementTemplate',
            className: 'rj-element rj-text no-select',
            events: _.extend({}, this.BaseView.prototype.events, {
                'dblclick': 'initEditor',
                'click': 'showEdit',
                'blur': 'destroyEditor'
            }),
            initialize: function() {
                this.listenTo(this.model, 'change', this.updateEl);
            },
            updateEl: function() {
                this.$el.css('width', this.model.get('width'));
                this.$el.css('top', this.model.get('top'));
                this.$el.css('left', this.model.get('left'));
                //this.$('.text-content').css('border', this.model.get('borderWidth') + 'px solid #333');
                this.$el.html(this.model.get('content'));
            },
            onRender: function() {
                this.updateEl();
            },
            initEditor: function() {
                this.el.contentEditable = true;
                this.editor = CKEDITOR.inline(this.el, {
                    enterMode: CKEDITOR.ENTER_BR
                });
                this.el.focus();
                this.$el.removeClass('no-select');
            },
            destroyEditor: function() {
                this.model.set('content', this.$el.html());
                this.el.contentEditable = false;
                this.editor.destroy();
                this.$el.addClass('no-select');
            },
            showEdit: function() {
                var model = this.model;
                _.debounce(function(){
                    MyApp.commands.execute('toolbar:edit:show', TextElementModule.moduleName, model);
                }, 200)();
            }
        });

        TextElementModule.addInitializer(function(){
            MyApp.commands.execute('toolbar:item:add', {title: 'Text element', moduleName: TextElementModule.moduleName});
        });

    }
});