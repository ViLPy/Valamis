/**
 * Search for certificates in curriculum
 */
var CertificateSearchView = Backbone.View.extend({
  events: {
    'keyup #certificateFilter': 'filterCertificates',
    'change #certificateOrder': 'filterCertificates',
    'change #certificateScopeFilter': 'filterCertificates',
    'click .menu-close': 'closeSearchMenuToggle'
  },
  initialize: function (options) {
    this.options = options;
    this.inputTimeout = null;
    this.filterValue = null;
    this.render(options.scopeAvailable);
  },
  updateScopeSetting: function (scope) {
    this.render(scope);
  },
  render: function (scopeAvailable) {
    var language = this.options.language;
    var renderedTemplate = Mustache.to_html(jQuery('#curriculumSearchTemplate').html(), _.extend({
      scopeAvailable: scopeAvailable,
      currentCertificateID: jQuery('#courseID').val()
    }, language));
    this.$el.html(renderedTemplate);
  },
  filterCertificates: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);

    this.trigger('filterCertificates', this);
  },
  closeSearchMenuToggle: function (e) {
    e.preventDefault();
    this.trigger('certificateToggleMenu', e);
  },
  setDefault: function () {
    jQuery("#certificateFilter").val("");
    jQuery('#certificateOrder option[value="name:true"]').prop('selected', true);
  }
});