/**
 * Created by igorborisov on 19.05.14.
 */





var PackageManagerFileUploaderView = Backbone.Marionette.ItemView.extend({
    template: '#packageManagerFileUploader',
    initialize: function(){
    },
    triggers: {
        "click .val-icon-upload": {
            event: "fileupload:opendialog",
            preventDefault: true, // this param is optional and will default to true
            stopPropagation: false
        }
    }
});

var PackageManagerToolbarView = Backbone.Marionette.ItemView.extend({
    template: '#packageManagerToolbar', //_.template($('#packageManagerToolbar').html()),
    //TODO use model values instead of different events
    triggers: {
        "click #packageManagerListView": {
            event: "toolbar:listview",
            preventDefault: true, // this param is optional and will default to true
            stopPropagation: false
        },
        "click #packageManagerTilesView": {
            event: "toolbar:tileview",
            preventDefault: true, // this param is optional and will default to true
            stopPropagation: false
        }
    }
});


var PackageManagerView = Backbone.Marionette.ItemView.extend({

    toolbarView : new PackageManagerToolbarView(),
    searchView : new PackageManagerSearchView(),
    packageCollection : new PackageManagerPackageCollection(),
    fileuploaderView : new PackageManagerFileUploaderView(),
    initialize: function(){
        var me = this;
        me.modalLayout = new ModalsLayout();

        jQuery('#packagesFileUploaderWrapper').append(me.fileuploaderView.render().$el);

        var packageManagerTileListModel = new PackageManagerTileListModel();

        me.packageListView = new PackageManagerTileListView({
            collection: packageManagerTileListModel.get("packageCollection"),
            displayType: DisplayType.LIST
        });

        jQuery('.package-items').append(me.packageListView.render().$el);

        jQuery('#packageManagerToolbarWrapper').append(me.toolbarView.render().$el);


        me.searchView.on('filter', function(params){
           // console.log(params);
            // set searchfilter criteries to model. Add methods to packageManagerTileListModel to fetch by filters
            //packageManagerTileListModel.set();
            packageManagerTileListModel.get("packageCollection").fetch();
        }, me);

        me.toolbarView.on('toolbar:listview', function(){
            $('#packageManagerTilesView').removeClass('active');
            $('#packageManagerListView').addClass('active');
            me.packageListView.setDisplayType(DisplayType.LIST);
        });
        me.toolbarView.on('toolbar:tileview', function(){
            me.packageListView.setDisplayType(DisplayType.TILES);
            $('#packageManagerListView').removeClass('active');
            $('#packageManagerTilesView').addClass('active');
        });

        jQuery('body').append(me.modalLayout.render().el);

        jQuery('#packagesSearchWrapper').append(me.searchView.render().$el);

        me.fileuploaderView.on('fileupload:opendialog', function(){
            var fileUploadModal = new FileUploadModal();
            me.modalLayout.modals.show(fileUploadModal);
        });


        var pageModel = packageManagerTileListModel.get("paginatorModel");

        console.log(pageModel);

        new ValamisPaginator({el: $('.paginator'), model: pageModel});
        new ValamisPaginator({el: $('.package-manager .bottom-paginator'), model: pageModel});

        me.searchView.applyFilter();
    }


});
