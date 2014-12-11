var CertificateCollectionView = Backbone.View.extend({
  events: {
    'click .menu-open': 'searchMenuToggle'
  },
  initialize: function (options) {
    this.options = options;
    this.portletID = options.portletID;
    this.forcedView = options.forcedView;
    this.language = this.options.language;
    this.render();
  },

  render: function () {
    var renderedTemplate = _.template(Mustache.to_html(jQuery('#curriculumUserViewTemplate').html(),
      _.extend({
        portletID: this.portletID,
        forcedView: this.forcedView},
    this.language)));
    this.$el.html(renderedTemplate);

    return this;
  },

  searchMenuToggle: function (e) {
    e.preventDefault();
    this.trigger('certificateToggleMenu', e);
  }

});