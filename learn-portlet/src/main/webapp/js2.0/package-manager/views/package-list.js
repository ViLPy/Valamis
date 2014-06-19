var DisplayType = {
  LIST: 1,
  TILES: 2
};

var PackageDisplayTypeTemplates = {
  LIST: '#packageManagerListItemView',
  TILES: '#packageManagerTileItemView'
};

var PackageManagerItemView = Backbone.Marionette.ItemView.extend({
  className: 'certificate',
  template: '#packageManagerTileItemView',
  tagName: 'div',
  events: {
    'click .package-visibility-flag': 'updateFlags',
    'click .package-default-flag': 'updateFlags',
    'click': 'openPackage'
  },
  updateFlags: function () {

    this.model.set('isVisible', this.$('.package-visibility-flag').is(':checked'));
    this.model.set('isDefault', this.$('.package-default-flag').is(':checked'));

      this.model.save();
  },
  openPackage: function () {
     console.log('goo');
     //console.log(this.model);
    window.location.hash = 'showPackage/helloWorld';
  }
});


//var PackageManagerTileListModelService = new Backbone.Service({ url: "/learn-portlet",
//    sync: {
//        'read': function (model) {
//            console.log('PackageManagerTileListModelService read');
////            return "/services/quiz" +
////                "?sortBy=" + model.get('sortBy') +
////                "&namePattern=" + model.get('namePattern') +
////                "&itemsOnPage=" + model.get('paginatorModel').get('itemsOnPage') +
////                "&currentPage=" + model.get('paginatorModel').get('currentPage');
//        }
//    }
//});

var PackageManagerTileListModel = Backbone.Model.extend({
    parse: function(response){
        console.log('PackageManagerTileListModel parse');
        this.get('paginatorModel').set({totalElements: response.totalElements});
        this.get('packageCollection').reset(response.elements);
    },
    initialize: function(){
        this.set({
            displayType:  DisplayType.LIST,
            paginatorModel: new PageModel({itemsOnPage : 2}),
            packageCollection: new PackageManagerPackageCollection()//,
        });
        this.get("paginatorModel").on("pageChanged", function(){
            console.log('paginatorModel pageChanged');
            this.packageCollection.fetch();
        },this);
        this.get('packageCollection').on('requestRender', function(){
            console.log('paginatorModel packageCollection');
            this.fetch();
        },this);

        this.get('packageCollection').fetch();
    }
})//.extend();//PackageManagerTileListModelService);

/**
 * @param displayType - collection view display type from DISPLAY_TYPE enumeration value
 */
var PackageManagerTileListView = Backbone.Marionette.CollectionView.extend({
  itemView: PackageManagerItemView,
  tagName: 'div',
  className: 'grid-view',
  initialize: function (options) {
    this.itemDisplayType = options.displayType || DisplayType.TILES;
  },
  itemViewOptions: function () {
    // override class name and template for different display types
    var className,
      template;

    switch (this.itemDisplayType) {
      case DisplayType.LIST:
        className = 'certificate-list-item clearfix';
        template = PackageDisplayTypeTemplates.LIST;
        break;
      case DisplayType.TILES:
      default:
        className = 'certificate-tile';
        template = PackageDisplayTypeTemplates.TILES;
        break;
    }

    return {
      className: className,
      template: template
    };
  },
  setDisplayType: function (displayType) {
    this.itemDisplayType = displayType;
    this.render();
  }
});
