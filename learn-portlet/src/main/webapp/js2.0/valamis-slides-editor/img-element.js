MyApp.module('ImageElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function (ImageElementModule, MyApp, Backbone, Marionette, $, _) {
        ImageElementModule.startWithParent = false;

        ImageElementModule.View = this.BaseView.extend({
            template: '#imageElementTemplate'
        });

        ImageElementModule.addInitializer(function () {
            MyApp.commands.execute('toolbar:item:add', {title: 'Image element', moduleName: ImageElementModule.moduleName});
        });
    }
});