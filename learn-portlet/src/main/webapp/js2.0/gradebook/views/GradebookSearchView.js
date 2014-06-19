/**
 * Search for packages in package manager
 * @event filter {enteredFilter, sort, display}
 */
var GradebookSearchView = Backbone.Marionette.ItemView.extend({
    template: '#gradebookSearch',
    className: 'search-wrapper',
    tagName: 'div',
    events: {
        'keyup .search': 'filter',
        'change .display': 'applyFilter',
        'change .sorting': 'applyFilter'
    },
    initialize: function () {
        this.inputTimeout = null;
        this.filterValue = null;

//        var packageCollection = new PackageFilterCollection();
//        this.packageListView = new PackageFilterListView({collection: packageCollection, language: language});
//        packageCollection.add({
//            id: 1,
//            packageName: 'Package 1'
//        });
//
//        packageCollection.add({
//            id: 2,
//            packageName: 'Package 2'
//        });
    },
    onRender: function () {
        //this.$('#package-multiselect').html(this.packageListView.render());
    },
    filter: function () {
        clearTimeout(this.inputTimeout);
        this.filterValue = this.$('.search').val();
        this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
    },
    applyFilter: function () {
        clearTimeout(this.inputTimeout);
        var sorting = this.$('.sorting').val();
        var display = this.$('.display').val();

        this.trigger('filter', {
            enteredFilter: this.filterValue,
            sort: sorting,
            display: display
        });
    },

    hidePackagePanel: function () {
        this.$('.package-panel').hide();
    },

    showPackagePanel: function () {
        this.$('.package-panel').show();
    }
});