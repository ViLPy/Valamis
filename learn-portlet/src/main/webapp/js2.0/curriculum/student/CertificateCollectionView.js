var CertificateCollectionView = Backbone.View.extend({
  events: {
    'click .menu-open': 'searchMenuToggle',
    'click .certificate-collection-tab': 'changeTab'
  },
  initialize: function (options) {
    this.options = options;
    this.language = this.options.language;
    this.render();
  },

  render: function () {
    var renderedTemplate = _.template(Mustache.to_html(jQuery('#curriculumUserViewTemplate').html(), this.language));
    this.$el.html(renderedTemplate);

    return this;
  },

  searchMenuToggle: function (e) {
    e.preventDefault();
    this.trigger('certificateToggleMenu', e);
  },

  changeTab: function() {
    this.trigger('changeTab');
  }

});