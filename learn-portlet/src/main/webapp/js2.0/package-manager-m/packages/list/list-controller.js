/**
 * Created by igorborisov on 26.05.14.
 */

PackageManager.module("PackagesApp.List", function(List, PackageManager,
                                                   Backbone, Marionette, $, _){

    List.Controller = {
        listPackages : function(filterParam){
            var packages = PackageManager.request("package:entities", filterParam);

            var packagesListView = new List.Packages({
                collection: packages
            });

            //packagesListView.collection = packages;

            PackageManager.mainRegion.show(packagesListView);

            PackageManager.trigger("packagelist:paginatormodel", packages.paginatorModel);
        }

    }
});