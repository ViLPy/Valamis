/**
 * Created by igorborisov on 27.05.14.
 */

PackageManager.module("PackagesApp.Common", function(Common, PackageManager,
                                                   Backbone, Marionette, $, _){
    // Create a layout class
    Common.ModalsLayout = Marionette.Layout.extend({
        template: function(){ return _.template($('#package-manager-modals-template').html()); },
        regions: {
            modals: {
                selector: '.modals-container',
                regionType: Marionette.Modals
            }
        }
    });

});