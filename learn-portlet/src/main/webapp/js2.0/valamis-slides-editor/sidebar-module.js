MyApp.module('SideBarModule', function(SideBarModule, MyApp, Backbone, Marionette, $, _){
    SideBarModule.ToolbarView = Marionette.ItemView.extend({
        template: '#textToolbarView',
        events: {
            'mousedown': 'onMouseDown'
        },
        onMouseDown: function(e) {
            MyApp.commands.execute('drag:prepare:new', this.model, e.clientX, e.clientY);
        }
    });

    SideBarModule.ToolbarCollectionView = Marionette.CollectionView.extend({
        childView: SideBarModule.ToolbarView
    });

    var collection = new Backbone.Collection();
    var collectionView = new SideBarModule.ToolbarCollectionView({collection: collection});

    var SideBarLayoutView = Marionette.LayoutView.extend({
        template: '#sideBarLayoutTemplate',

        regions: {
            menu: '.toolbar',
            content: '.edit-view'
        }
    });
    var sidebarView = new SideBarLayoutView();

    MyApp.commands.setHandler('toolbar:item:add', function(model){
        collection.add(model);
    });

    MyApp.commands.setHandler('toolbar:edit:show', function(moduleName, model){
        var EditViewClass = MyApp.module(moduleName).EditView;
        var editView = new EditViewClass({model: model});
        sidebarView.content.show(editView);
        sidebarView.content.$el.addClass('active');
    });

    MyApp.commands.setHandler('toolbar:edit:hide', function() {
        
    });

    SideBarModule.addInitializer(function(){
        MyApp.sidebar.show(sidebarView);
        sidebarView.menu.show(collectionView);
    });
});