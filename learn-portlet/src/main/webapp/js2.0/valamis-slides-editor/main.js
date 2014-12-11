var MyApp = new Backbone.Marionette.Application({container: '#revealEditor'});

MyApp.addRegions({
    sidebar: '.sidebar',
    editorArea: '.reveal-wrapper',
    revealControls: '.reveal-controls'
});

MyApp.activeElement = {
    view: null,
    moduleName: '',
    offsetX: 0,
    offsetY: 0,
    startX: 0,
    startY: 0,
    isMoving: false
};

MyApp.addInitializer(function initDnD(){
    jQuery(MyApp.container).mousemove(function(e) {
        if (MyApp.activeElement.isMoving) {
            e.preventDefault();
            if (!MyApp.activeElement.view) {
                var ViewModel = MyApp.module(MyApp.activeElement.moduleName).View;
                var Model = MyApp.module(MyApp.activeElement.moduleName).Model;

                var view = new ViewModel({model: new Model()});
                var elem = view.render().$el;
                jQuery(Reveal.getCurrentSlide()).append(elem);

                MyApp.activeElement.view = view;
                MyApp.activeElement.offsetX = elem.width() / 2;
                MyApp.activeElement.offsetY = elem.height() / 2;

                jQuery('.active').removeClass('active');
                MyApp.activeElement.view.$el.addClass('active');
            }
            var offset = jQuery('.slides').offset();
            MyApp.activeElement.view.model.set('top', e.clientY - offset.top - MyApp.activeElement.offsetY);
            MyApp.activeElement.view.model.set('left', e.clientX - offset.left - MyApp.activeElement.offsetX);
        }
    });

    jQuery(MyApp.editorArea.$el).mousedown(function() {
        if (!MyApp.activeElement.isMoving) jQuery('.active').removeClass('active');
    });

    jQuery(MyApp.container).mouseup(function(e) {
        MyApp.activeElement.isMoving = false;
        MyApp.activeElement.view = null;
    });
});

MyApp.on('start', function(options){
    CKEDITOR.disableAutoInline = true;
    MyApp.module('TextElementModule').start();
    MyApp.module('ImageElementModule').start();

    MyApp.module('RevealModule').start();
});

function isEditorEnabled() {
    for (var i in CKEDITOR.instances) {
        if (jQuery('.cke_editor_' + i).is(':visible')) {
            return true;
        }
    }
    return false;
}

MyApp.commands.setHandler('drag:prepare:new', function(model, mx, my){
//    if (isEditorEnabled()) return;

    MyApp.activeElement.isMoving = true;
    MyApp.activeElement.moduleName = model.get('moduleName');
    MyApp.activeElement.startX = mx;
    MyApp.activeElement.startY = my;
});

MyApp.commands.setHandler('drag:prepare:existing', function(view, mx, my, offsetX, offsetY){
    if (isEditorEnabled()) return;

    MyApp.activeElement.isMoving = true;
    MyApp.activeElement.view = view;
    MyApp.activeElement.startX = mx;
    MyApp.activeElement.startY = my;
    MyApp.activeElement.offsetX = offsetX;
    MyApp.activeElement.offsetY = offsetY;

    jQuery('.active').removeClass('active');
    MyApp.activeElement.view.$el.addClass('active');
});

jQuery(function() {
    MyApp.start();
});