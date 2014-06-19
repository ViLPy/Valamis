var CertificateHeaderView = Backbone.View.extend({
  events: {
    'click #addCertificate': 'addCertificate',
    'click .menu-open': 'searchMenuToggle'
  },
  initialize: function (options) {
    this.options = options;
    this.language = this.options.language;
    this.render();
  },

  render: function () {
    var renderedTemplate = _.template(Mustache.to_html(jQuery('#curriculumHeaderTemplate').html(), this.language));
    this.$el.html(renderedTemplate);

    return this;
  },

  addCertificate: function () {
    var that = this;
    this.certificate = new CertificateModel();
    this.certificate.save({}, {
      success: jQuery.proxy(function (certificate, response) {
        that.certificate.set(response);
        that.trigger('addCertificate', that.certificate.get('id'));
        //this.collection.add(certificate);
        toastr.success(this.language['overlayCompleteMessageLabel']);
      }, this),
      error: function () {
        toastr.error(this.language['overlayFailedMessageLabel']);
      }
    });


    //this.editCertificateLayout.modals.show(new EditCertificateModal());
  },

  searchMenuToggle: function (e) {
    e.preventDefault();
    this.trigger('certificateToggleMenu', e);
  }
});