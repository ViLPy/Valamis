var sidebarModule = slidesApp.module('SideBarModule', function(SideBarModule, slidesApp, Backbone, Marionette, $, _){
    SideBarModule.ToolbarView = Marionette.ItemView.extend({
        template: '#itemToolbarView',
        events: {
            'mousedown': 'onMouseDown',
            'click': 'onClick'
        },
        onMouseDown: function(e) {
            if(this.model.get('slideEntityType') !== 'pptx')
                slidesApp.commands.execute('drag:prepare:new', this.model, e.clientX, e.clientY);
        },
        onClick: function(e) {
            if(this.model.get('slideEntityType') === 'pptx') {
                slidesApp.commands.execute("fileupload:show:modal", PptxElementModule.moduleName);
            }
            else
            {
                slidesApp.commands.execute('drag:prepare:new', this.model, 0, 0);
                slidesApp.commands.execute('item:create', true);
                slidesApp.activeElement.isMoving = false;
            }
        }
    });

    SideBarModule.ToolbarCollectionView = Marionette.CollectionView.extend({
        childView: SideBarModule.ToolbarView
    });

    var collection = new Backbone.Collection();
    SideBarModule.collectionView = new SideBarModule.ToolbarCollectionView({collection: collection});

    var SideBarLayoutView = Marionette.LayoutView.extend({
        template: '#sideBarLayoutTemplate',

        regions: {
            menu: '.toolbar',
            content: '.edit-view'
        }
    });
    SideBarModule.sidebarView = new SideBarLayoutView();

    slidesApp.commands.setHandler('toolbar:item:add', function(model){
        collection.add(model);
    });

    slidesApp.commands.setHandler('toolbar:item:delete', function(model){
        collection.remove(model);
    });
});

sidebarModule.addInitializer(function(){
    slidesApp.sidebar.show(sidebarModule.sidebarView);
    sidebarModule.sidebarView.menu.show(sidebarModule.collectionView);
});