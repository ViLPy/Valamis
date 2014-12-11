var CertificateDetailsView = Backbone.View.extend({
  events: {
    'click #permanentPeriod': 'disablePeriodUpdate',
    'click #nonPermanentPeriod': 'enablePeriodUpdate',
    'keypress .onlyDigits': 'preventNonDigits',
    'click .designBadge': 'designBadge',
    'click #openBadgeIntegration': 'publishBadgeChanged',
    'click .val-icon-upload': 'uploadDialog',
    'click #publishCertificate': 'publish',
    'click #unpublishCertificate': 'unpublish',
    'click .saveNextCertificate': 'saveContinue',
    'click .saveCloseCertificate': 'saveClose',
    'click #cleanScope':'cleanScope'
  },
  initialize: function (options) {
    this.options = options;
    this.model = new CertificateModel();
  },

  setCertificateID: function (certificateID) {
    this.model.set({ id: certificateID });
    var me = this;
    this.model.fetch({
      success: function(){ me.render(); }
    });
    curriculumLogoData.resetImageSettings(certificateID);
  },

  render: function () {
    this.language = this.options.language;
    var scopeName = this.language['instanceScopeLabel'];
    if (this.model.get('scope') != undefined && this.model.get('scope').title != '') scopeName = this.model.get('scope').title;
    var description = jQuery1816Curriculum('<i>').html(decodeURIComponent(this.model.get('description'))).text();
    var renderedTemplate = _.template(
      Mustache.to_html(
        jQuery('#certificateItemEditDetailsTemplate').html(),
        _.extend(this.model.toJSON(), this.language, {
          scopeName: scopeName,
          contextPath: Utils.getContextPath,
          description: description})));
    this.$el.html(renderedTemplate);
    if (this.model.get('isPublished')){
      this.$('#publishCertificate').hide();
      this.$('#unpublishCertificate').show();
    }
    else {
      this.$('#publishCertificate').show();
      this.$('#unpublishCertificate').hide();
    }
    this.setValues();

    return this;
  },

  setValues: function () {
    var validPeriod = this.model.get('validPeriod');

    if (validPeriod != undefined) {
      if (validPeriod.valueType == 'UNLIMITED') {
        this.$('input:radio[id=permanentPeriod]').prop('checked', true);
        this.disablePeriodUpdate();
      }
      else {
        this.$('input:radio[id=nonPermanentPeriod]').prop('checked', true);
        this.$('#periodType option[value=' + validPeriod.valueType + ']').prop('selected', true);
        this.$('#validPeriodValue').val(validPeriod.value);
      }
    }

    var isPublishBadge = this.model.get('isOpenBadgesIntegration');
    if (isPublishBadge) {
      this.$('.openBadgesDescription').show();
    }
    else {
      this.$('.openBadgesDescription').hide();
    }
  },

  disablePeriodUpdate: function () {
    this.$('#validPeriodValue').attr('disabled', true);
    this.$('#periodType').attr('disabled', true);
  },
  enablePeriodUpdate: function () {
    this.$('#validPeriodValue').removeAttr('disabled');
    this.$('#periodType').removeAttr('disabled');
  },
  preventNonDigits: function (e) {
    if (e.keyCode != 46 && e.keyCode != 8 && e.keyCode != 9) {
      if (String.fromCharCode(e.charCode).match(/[^0-9]/g)) return false;
    }
  },
  publishBadgeChanged: function () {
    this.$('#openBadgeIntegration').toggleClass('checked');
    this.$('.openBadgesDescription').toggle();
  },

  saveClose: function () {
    this.saveCertificate('closeCertificate');
  },

  saveContinue: function () {
    this.saveCertificate('openGoals');
  },

  publish: function(){
    var that = this;
    this.model.publish({}).then(function (res) {
      that.$('#publishCertificate').hide();
      that.$('#unpublishCertificate').show();
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },
  unpublish: function(){
    var that = this;
    this.model.unpublish({}).then(function (res) {
      that.$('#publishCertificate').show();
      that.$('#unpublishCertificate').hide();
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },

  saveCertificate: function (trigName) {
    var that = this;
    if(curriculumLogoData.supports()) {
      curriculumLogoData.submitData(function (name) {
      });
      window.LearnAjax.post(path.root + path.api.certificates + that.model.id + '?action=UPDATELOGO&logo=' + curriculumLogoData.getFileName());
    }
    var isPermanent = (this.$('input:radio[id=permanentPeriod]:checked').val() == 'true');
    var validPeriod = 0;
    var type = 'UNLIMITED';
    if (!isPermanent) {
      validPeriod = this.$('#validPeriodValue').val();
      type = this.$('#periodType').val();
    }
    this.model.set({
      title: this.$('.certificateTitle').val(),
      description: this.$('.certificateDescription').val(),
      shortDescription: this.$('#shortDescription').val(),
      publishBadge: this.$('#openBadgeIntegration').hasClass('checked'),
      isPermanent: isPermanent,
      validPeriod: validPeriod,
      validPeriodType: type,
      scope: this.$('#certificateScopeID').val()
    });

    this.model.save({}, {
      success: function (model, response) {
        toastr.success(that.language['overlayCompleteMessageLabel']);
        that.trigger(trigName, this);
      },
      error: function (model, response) {
        toastr.error(that.language['overlayFailedMessageLabel']);
      }
    });
  },

  uploadDialog: function () {
    this.trigger('uploadDialogOpen', this);
  },

  designBadge: function () {
    var URL = 'https://www.openbadges.me/designer.html?origin=http://' + jQuery('#rootUrl').val();
    URL = URL + '&email=developer@example.com';
    URL = URL + '&close=true';
    var options = 'width=1015,height=680,location=0,menubar=0,status=0,toolbar=0';
    var designerWindow = window.open(URL, '', options);
  },
  cleanScope: function(){
    this.$('#certificateScopeName').val(this.language['instanceScopeLabel']);
    this.$('#certificateScopeID').val('');
  }
});