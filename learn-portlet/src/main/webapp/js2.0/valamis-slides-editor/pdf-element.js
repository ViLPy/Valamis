var PdfElementModule = slidesApp.module('PdfElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function(PdfElementModule, slidesApp, Backbone, Marionette, $, _){
        PdfElementModule.startWithParent = false;

        PdfElementModule.View = this.BaseView.extend({
            template: '#iframeElementTemplate',
            className: 'rj-element rj-iframe no-select',
            events: _.extend({}, this.BaseView.prototype.events, {
                'click .js-upload-pdf': 'uploadPdf'
            }),
            onRender: function() {
                this.$('.js-edit-iframe-url').parent().hide();
                this.$('.content-icon-iframe').hide();
                this.constructor.__super__.onRender.apply(this, arguments);
            },
            updateUrl: function(url) {
                slidesApp.viewId = this.cid;
                slidesApp.actionType = 'itemContentChanged';
                slidesApp.oldValue = {contentType: 'url', content: this.model.get('content')};
                this.model.set('content', url);
                slidesApp.newValue = {contentType: 'url', content: this.model.get('content')};
                slidesApp.commands.execute('action:push');
                this.$('iframe').attr('src', url);
                this.content.css('background-color', 'transparent');
                this.$('.content-icon-pdf').first().hide();
                this.$('.iframe-item').show();
            },
            uploadPdf: function () {
                slidesApp.commands.execute('fileupload:show:modal', PdfElementModule.moduleName);
            }
        });
    }
});

PdfElementModule.on('start', function() {
    slidesApp.commands.execute('toolbar:item:add', {title: 'PDF', slideEntityType: 'pdf'});
});