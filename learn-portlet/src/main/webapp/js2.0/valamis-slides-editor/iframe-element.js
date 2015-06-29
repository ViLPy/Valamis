var iframeElementModule = slidesApp.module('IframeElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function(IframeElementModule, slidesApp, Backbone, Marionette, $, _){
        IframeElementModule.startWithParent = false;

        IframeElementModule.View = this.BaseView.extend({
            template: '#iframeElementTemplate',
            className: 'rj-element rj-iframe no-select',
            events: _.extend({}, this.BaseView.prototype.events, {
                'click .js-edit-iframe-url': 'openIframeEditPanel',
                'click .js-close-slide-popup-panel': 'closeIframeEditPanel',
                'click .js-update-iframe-url': 'updateUrl'
            }),
            onRender: function() {
                this.$('.js-upload-pdf').parent().hide();
                this.$('.content-icon-pdf').hide();
                this.constructor.__super__.onRender.apply(this, arguments);
            },
            updateUrl: function() {
                slidesApp.viewId = this.cid;
                slidesApp.actionType = 'itemContentChanged';
                slidesApp.oldValue = {contentType: 'url', content: this.model.get('content')};
                this.model.set('content', this.$('.iframe-url').val());
                slidesApp.newValue = {contentType: 'url', content: this.model.get('content')};
                slidesApp.commands.execute('action:push');
                this.$('iframe').attr('src', this.$('.iframe-url').val());
                this.closeIframeEditPanel();
                this.$('.content-icon-iframe').first().hide();
                this.$('.iframe-item').show();
            },
            openIframeEditPanel: function() {
                this.$('.iframe-edit-panel').show();
                this.$('.iframe-url').focus();
                slidesApp.isEditing = true;
            },
            closeIframeEditPanel: function() {
                this.$('.iframe-edit-panel').hide();
                slidesApp.isEditing = false;
                this.selectEl();
            }
        });
    }
});

iframeElementModule.on('start', function() {
    slidesApp.commands.execute('toolbar:item:add', {title: 'Iframe', slideEntityType: 'iframe'});
});