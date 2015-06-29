var textElementModule = slidesApp.module('TextElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function(TextElementModule, slidesApp, Backbone, Marionette, $, _){
        TextElementModule.startWithParent = false;

        TextElementModule.View = this.BaseView.extend({
            template: '#textElementTemplate',
            className: 'rj-element rj-text no-select',
            events: _.extend({}, this.BaseView.prototype.events, {
                'dblclick': 'initEditor',
                'blur': 'destroyEditor',
                'click  .js-item-select-liferay-article': 'selectLiferayArticle'
            }),
            updateEl: function() {
                this.constructor.__super__.updateEl.apply(this, arguments);
                this.content.html(this.model.get('content'));
            },
            onRender: function() {
                var self = this;
                this.constructor.__super__.onRender.apply(this, arguments);
                this.model.on('sync', function () {
                    self.destroyEditor();
                });
            },
            initEditor: function() {
                this.undelegateEvents();
                this.content[0].contentEditable = true;
                var self = this;
                this.editor = CKEDITOR.inline(this.content[0], {
                    enterMode: CKEDITOR.ENTER_BR,
                    on:{
                        blur: function(event){
                            self.destroyEditor();
                        },
                        change: function (event) {
                            if(slidesApp.isSaved)
                                toggleSavedState();
                        }
                    }
                });
                this.content[0].focus();
                this.$el.removeClass('no-select');
                slidesApp.isEditing = true;
                slidesApp.RevealModule.fitContentScrollInit();
            },
            destroyEditor: function() {

                if(this.editor && this.editor.focusManager.hasFocus)
                {
                    slidesApp.commands.execute('item:focus', this);
                    return;
                }

                slidesApp.oldValue = {contentType: 'text', content: this.model.get('content')};
                this.model.set('content', this.content.html());
                this.content[0].contentEditable = false;
                if(this.editor) {
                    this.editor.destroy();
                    this.editor = undefined;
                }
                this.$el.addClass('no-select');
                this.wrapperUpdate();

                this.delegateEvents();
                slidesApp.isEditing = false;

                slidesApp.viewId = this.cid;
                slidesApp.actionType = 'itemContentChanged';
                slidesApp.newValue = {contentType: 'text', content: this.model.get('content')};
                slidesApp.commands.execute('action:push');
            },
            selectLiferayArticle: function() {
                slidesApp.commands.execute('fileupload:show:modal', TextElementModule.moduleName);
            }
        });
    }
});

textElementModule.on('start', function() {
    slidesApp.commands.execute('toolbar:item:add', {title: 'Text', slideEntityType: 'text'});
});