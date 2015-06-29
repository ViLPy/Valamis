var CertificateDetailsView = Backbone.View.extend({
  events: {
    'click #permanentPeriod': 'disablePeriodUpdate',
    'click #nonPermanentPeriod': 'enablePeriodUpdate',
    'keypress #validPeriodValue': 'preventNonDigits',
    'click .js-design-badge': 'designBadge',
    'change #openBadgeIntegration': 'publishBadgeChanged',
    'click .js-upload-logo': 'uploadDialog',
    'click .js-saveNextCertificate': 'saveContinue',
    'click .js-saveCloseCertificate': 'saveClose',
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
      success: function(){
        curriculumLogoData.resetImageSettings(certificateID);
        me.render();
      }
    });
  },

  render: function () {
    curriculumLogoData.setSetting(IMAGE_PARAM_TYPE.FILE_NAME, this.model.get('logo'));
    this.language = this.options.language;
    var scopeName = this.language['instanceScopeLabel'];
    if (this.model.get('scope') != undefined && this.model.get('scope').title != '') scopeName = this.model.get('scope').title;
    var description = jQuery1816Curriculum('<i>').html(this.model.get('description')).text();
    var renderedTemplate = _.template(
      Mustache.to_html(
        jQuery('#certificateItemEditDetailsTemplate').html(),
        _.extend({
          scopeName: scopeName,
          contextPath: Utils.getContextPath,
          decodedDescription: description}, this.model.toJSON(), this.language, permissionActionsCurriculum)));
    this.$el.html(renderedTemplate);
    if (this.model.get('isPublished')){
      this.$('#publishCertificate').hide();
      this.$('#unpublishCertificate').show();
    }
    else {
      this.$('#publishCertificate').show();
      this.$('#unpublishCertificate').hide();
    }
    this.$('.js-valid-period-value').valamisPlusMinus();
    if (!permissionActionsCurriculum.MODIFY) this.$('.js-valid-period-value').valamisPlusMinus('disable');
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
        this.$('.js-valid-period-value').valamisPlusMinus('value', validPeriod.value);
      }
    }

    var isPublishBadge = this.model.get('isOpenBadgesIntegration');
    if (isPublishBadge) {
      this.$('.js-openBadgesDescription').show();
      this.$('#openBadgeIntegration').prop('checked', true);
    }
    else {
      this.$('.js-openBadgesDescription').hide();
    }
  },

  disablePeriodUpdate: function () {
    this.$('.js-valid-period-value').valamisPlusMinus('disable');
    this.$('#periodType').attr('disabled', true);
  },
  enablePeriodUpdate: function () {
    this.$('.js-valid-period-value').valamisPlusMinus('enable');
    this.$('#periodType').removeAttr('disabled');
  },
  preventNonDigits: function (e) {
    if (e.keyCode != 46 && e.keyCode != 8 && e.keyCode != 9) {
      if (String.fromCharCode(e.charCode).match(/[^0-9]/g)) return false;
    }
  },
  publishBadgeChanged: function () {
    if(this.$('#openBadgeIntegration').is(':checked'))
      this.$('.js-openBadgesDescription').show();
    else
      this.$('.js-openBadgesDescription').hide();
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
    var isPermanent = (this.$('input:radio[id=permanentPeriod]:checked').val() == 'true');
    var validPeriod = 0;
    var type = 'UNLIMITED';
    if (!isPermanent) {
      validPeriod = this.$('.js-valid-period-value').valamisPlusMinus('value');
      type = this.$('#periodType').val();
    }
    var data = {
        title: this.$('#certificateTitle').val() || this.language['newCertificatePlaceholderLabel'],
        description: this.$('#certificateDescription').val() || this.language['descriptionPlaceholderLabel'],
        shortDescription: this.$('#shortDescription').val(),
        publishBadge: this.$('#openBadgeIntegration').prop('checked'),
        isPermanent: isPermanent,
        validPeriod: validPeriod,
        validPeriodType: type,
        scope: this.$('#certificateScopeID').val()
    };
    this.model.set(data);

    this.model.save({}, {
      success: function (model, response) {
        jQuery('#selectedCertificateID').val(that.model.id);
        curriculumLogoData.setFolderId(that.model.id);

        if(curriculumLogoData.isReadyToSubmit()) {
          curriculumLogoData.submitData(function (name) {
              window.LearnAjax.post(
                  path.root + path.api.certificates + that.model.id +
                  '?action=UPDATELOGO' +
                  '&courseId=' + Utils.getCourseId() +
                  '&logo=' + curriculumLogoData.getFileName()
              ).done(function() {
                  that.afterSave(that, trigName, data);
                });
          });
        }
        else {
          that.afterSave(that, trigName, data);
        }
      },
      error: function (model, response) {
        toastr.error(that.language['overlayFailedMessageLabel']);
      }
    });
  },

  afterSave: function(that, trigName, data) {
    if(that.model.hasChanged()) {
      that.model.set(data);
      that.model.save(data);
    }

    if (trigName === 'openGoals')
      that.trigger('certificateAdded', that);

    toastr.success(that.language['overlayCompleteMessageLabel']);
    that.trigger(trigName, this);
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