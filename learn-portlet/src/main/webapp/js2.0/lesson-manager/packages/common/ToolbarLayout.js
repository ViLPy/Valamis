/**
 * Created by igorborisov on 02.06.14.
 */

PackageManager.module("PackagesApp.Common", function(Common, PackageManager,
                                                     Backbone, Marionette, $, _){
    // Create a layout class
    var DisplayType = {
        LIST: 1,
        TILES: 2
    };


    Common.PageContentLayout = Marionette.Layout.extend({
        template: function() {
            return  Mustache.to_html($('#packagesPageContentTemplate').html(), PackageManager.request("get:languageBank"));
        },
        events: {
            "click .menu-toggle": "menuToggle"
        },
        menuToggle: function(e) {
            e.preventDefault();
            jQuery("#packagesContentWrapper").toggleClass("active");
        }
    });

    Common.ToolbarLayout = Marionette.Layout.extend({
        template: function() { //"#packageManagerToolbar",
            var mustacheAccumulator = {};
            if (this.model) {
                _.extend(mustacheAccumulator, this.model.toJSON());
            }
            _.extend(mustacheAccumulator, PackageManager.request("get:languageBank"));

            return  Mustache.to_html($('#packageManagerToolbar').html(), mustacheAccumulator);
        },
        className: 'clearfix',
        regions: {
            paging: "#pagingWrapper"
        },

        events: {
            "click button.js-list-view": "setListViewDisplayType",
            "click button.js-tile-view": "setTileViewDisplayType"
        },
        setListViewDisplayType: function(){
            this.setDisplayType(DisplayType.LIST);
        },
        setTileViewDisplayType: function(){
            this.setDisplayType(DisplayType.TILES);
        },
        itemViewsData: {
            1: {
                button: "button.js-list-view"
            },
            2: {
                button: "button.js-tile-view"
            }
        },
        setDisplayType: function(displayType){
            this.trigger("toolbar:displaytype:change", displayType);
            this.$("button.js-display-option").removeClass("active");
            var itemsData = this.itemViewsData[displayType];
            this.$(itemsData.button).addClass("active");
        }
    });

    /*
     Common.Toolbar = Marionette.ItemView.extend({
     template: '#packageManagerToolbar' // function(){ return _.template($('#package-manager-modals-template').html()); },

     });
     */
});