/**
 * Search for packages in package manager
 * @event filter {enteredFilter, sort, display}
 */
var PackageManagerSearchView = Backbone.Marionette.ItemView.extend({
  template: '#packageManagerSearch',
  className: 'search-wrapper',
  tagName: 'div',
  events: {
    'keyup .search': 'filter',
    'change .display': 'applyFilter',
    'change .sorting': 'applyFilter',
    'change .scope': 'applyFilter'
  },
  initialize: function () {
    this.inputTimeout = null;
    this.filterValue = null;
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
    var scope = this.$('.scope').val();

    this.trigger('filter', {
      enteredFilter: this.filterValue,
      sort: sorting,
      display: display,
      scope: scope
    });
  }
});