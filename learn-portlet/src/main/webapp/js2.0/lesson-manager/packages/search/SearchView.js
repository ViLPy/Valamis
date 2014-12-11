/**
 * Created by igorborisov on 26.05.14.
 */
/**
 * Search for packages in package manager
 * @event filter {enteredFilter, sort, display}
 */

PackageManager.module("PackagesApp.Search", function(Search, PackageManager,
                                                   Backbone, Marionette, $, _) {
    Search.Form = ValamisItemView.extend({
        tagName: 'div',
        //className: 'search-wrapper',
        template: '#packageManagerSearch',
        events: {
            'keyup .js-search': 'filter',
            'change .js-display': 'applyFilter',
            'change .js-sorting': 'applyFilter',
            'change .js-scope': 'applyFilter'
        },

        initialize: function (options) {
            var self = this;
            self.inputTimeout = null;
            self.filterValue = null;

            if(options && options.searchParams) {
                self.searchParams = options.searchParams;
            }
            this.resetCurrentPage = false;
        },
        onRender: function(){
            if(this.searchParams) {
               Backbone.Syphon.deserialize(this, this.searchParams);
            }
        },
        filter: function () {
            clearTimeout(this.inputTimeout);
            this.filterValue = this.$('.js-search').val();
            this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
            this.resetCurrentPage = true;
        },
        applyFilter: function () {
            clearTimeout(this.inputTimeout);

            var formData = Backbone.Syphon.serialize(this);

            this.trigger('search:filter', {
                enteredFilter: formData.enteredFilter,
                sort: formData.sort,
                display: formData.display,
                scope: formData.scope,
                resetCurrentPage: this.resetCurrentPage
            });
            this.resetCurrentPage = false;
        }
    });
});
