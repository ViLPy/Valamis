var PptxElementModule = slidesApp.module('PptxElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function(PptxElementModule, slidesApp, Backbone, Marionette, $, _){
        PptxElementModule.startWithParent = false;
    }
});

PptxElementModule.on('start', function() {
    slidesApp.commands.execute('toolbar:item:add', {title: 'PPTX', slideEntityType: 'pptx'});
});