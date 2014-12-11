var CollectionItemDetailsView = Backbone.View.extend({
  events: {
    "click #issueBadge": "issueBadge"
  },
  initialize: function (options) {
    this.options = options;
    this.model = new CertificateModel();
    this.model.on('change', this.render, this);
  },

  setCertificateID: function (certificateID, status) {
    this.model.set({ id: certificateID, status: status, success: status == 'Success' });
    this.model.fetch();
  },

  render: function () {
    this.language = this.options.language;
    var description = jQuery1816Curriculum('<i>').html(decodeURIComponent(this.model.get('description'))).text();
    var renderedTemplate = _.template(
      Mustache.to_html(
        jQuery('#userCertificateItemEditDetailsTemplate').html(),
        _.extend(this.model.toJSON(), this.language, {
          contextPath: Utils.getContextPath,
          description: description})));
    this.$el.html(renderedTemplate);

    this.setValidPeriod();

    return this;
  },

  setValidPeriod: function () {
    var validPeriod = this.model.get('validPeriod');

    if (validPeriod != undefined) {
      if (validPeriod.valueType == 'UNLIMITED') {
        this.$('#nonPermanentLabel').hide();
      }
      else {
        this.$('#permanentLabel').hide();
        this.$('#nonPermanentLabel').text(this.language['validForLabel'] + ' ' + validPeriod.value + ' ' + validPeriod.valueType);
      }
    }

  },
  issueBadge: function () {
    OpenBadges.issue(['http://' + jQuery('#rootUrl').val() + path.root + path.api.certificates +  this.model.id + '?action=GETISSUEBADGE&userID=' + jQuery('#curriculumStudentID').val() + '&rootUrl=' + jQuery('#rootUrl').val() ],
      function (errors, successes) {
      });
  }

});