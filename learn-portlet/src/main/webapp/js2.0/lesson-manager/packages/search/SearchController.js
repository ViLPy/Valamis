/**
 * Created by igorborisov on 26.05.14.
 */
PackageManager.module("PackagesApp.Search", function(Search, PackageManager,
                                                   Backbone, Marionette, $, _){
    Search.Controller = {
        searchView : function(){
            var searchFormView = new Search.Form({ });

            searchFormView.on("search:filter", function(model){
               PackageManager.trigger("packages:filter", model);
            });

            PackageManager.searchRegion.show(searchFormView);

            searchFormView.applyFilter();
        }
    }
});