var DISPLAY_TYPE = {
  LIST: 'list',
  TILES: 'tiles'
};

var VIEW_TYPE = {
    ADMIN: 'adminView',
    MY_COLLECTION: 'myCollection',
    AVAILABLE_COLLECTION: 'availableCollection'
};

var CertificateItemView = Backbone.View.extend({
  events: {
    'click .js-editCertificateCommand': 'openDetails',
    'click .js-editCourseCertificateCommand': 'openGoals',
    'click .js-editUserCertificateCommand': 'openUsers',
    'click .js-cloneCertificateCommand': 'cloneCertificate',
    'click .js-publishCertificateCommand': 'publishCertificate',
    'click .js-unpublishCertificateCommand': 'confirmUnpublishCertificate',
    'click .js-deleteCertificateCommand': 'confirmDeleteCertificate',
    'click .js-exportCertificateCommand': 'exportCertificate',
    'click .js-leaveCertificateCommand': 'leaveCertificate',
    'click .js-joinCertificateCommand': 'joinCertificate'
  },
  className: 'tile s-12 m-4 l-2',

  initialize: function (options) {
    this.language = options.language;
    this.viewType = options.viewType;
    this.permissions = options.permissions;
  },

  render: function () {
    if (!this.model.get('isPublished')) {
      this.$el.addClass('unpublished');
    }

    var goalsCount = this.model.get('activityCount')
      + this.model.get('courseCount') + this.model.get('statementCount') + this.model.get('packageCount');
    var statusClass = '';
    if (this.model.get('status'))
      statusClass = this.model.get('status').toLowerCase();

    var templateId = '#certificateItemViewTemplate';
    if (this.viewType == VIEW_TYPE.MY_COLLECTION || this.viewType == VIEW_TYPE.AVAILABLE_COLLECTION)
        templateId = '#userCertificateItemViewTemplate';

    var template = Mustache.to_html(jQuery(templateId).html(),
      _.extend({
        isMyCollection: this.viewType == VIEW_TYPE.MY_COLLECTION,
        goalsCount: goalsCount,
        contextPath: Utils.getContextPath,
        decodedDescription: this.model.get('description'),
        statusClass: statusClass
      },
      this.model.toJSON(), this.language, this.permissions));
    this.$el.html(template);
    this.$el.find(".dropdown").valamisDropDown();
    return this;
  },
  openDetails: function () {
      this.trigger('editCertificateDetails', {id: this.model.id, status: this.model.get('status')});
  },
  openGoals: function () {
    this.trigger('editCertificateGoals', {id: this.model.id});
  },
  openUsers: function () {
    this.trigger('editCertificateMembers', {id: this.model.id});
  },
  cloneCertificate: function () {
    var that = this;
    this.model.clone({}).then(function (res) {
      that.trigger('reloadWithMessage', that);
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },
  publishCertificate: function () {
    var that = this;
    this.model.publish({}).then(function (res) {
      that.trigger('reload', that);
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },
  confirmUnpublishCertificate: function() {
    var confirmView = new DeleteConfirmationView({language: this.language, template: '#certificateUnpublishConfirmationTemplate'});
    confirmView.on('deleteConfirmed', this.unpublishCertificate, this);
    var title = this.language['deleteConfirmationTitle'];
    toastr.info(confirmView.render().$el, title,
      {
        'positionClass': 'toast-center',
        'timeOut': '0',
        'showDuration': '0',
        'hideDuration': '0',
        'extendedTimeOut': '0'
      });
  },
  unpublishCertificate: function () {
    var that = this;
    this.model.unpublish({}).then(function (res) {
      that.trigger('reload', that);
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },
  confirmDeleteCertificate: function () {
    var confirmView = new DeleteConfirmationView({language: this.language});
    confirmView.on('deleteConfirmed', this.deleteCertificate, this);
    var title = this.language['deleteConfirmationTitle'];
    toastr.info(confirmView.render().$el, title,
      {
        'positionClass': 'toast-center',
        'timeOut': '0',
        'showDuration': '0',
        'hideDuration': '0',
        'extendedTimeOut': '0'
      });
  },
  deleteCertificate: function () {
    var that = this;
    this.model.destroy({
      success: function (model, response) {
        toastr.success(that.language['overlayCompleteMessageLabel']);
        that.remove();
        that.trigger('item:model:removed', that.model);
      },
      error: function (model, response) {
        toastr.error(that.language['overlayFailedMessageLabel']);
      }
    });

  },
  exportCertificate: function () {
    window.location = path.root + path.api.files + 'export/?action=EXPORT&contentType=certificate'
      +'&companyID=' + jQuery('#curriculumCompanyID').val()
      +'&id=' + this.model.get('id');
  },
    joinCertificate: function () {
        var that = this;
        this.model.join({}).then(function (res) {
            that.trigger('reloadWithMessage', that);
        }, function (err, res) {
            toastr.error(that.language['overlayFailedMessageLabel']);
        });
    },
    leaveCertificate: function () {
        var that = this;
        this.model.leave({}).then(function (res) {
            that.trigger('reloadWithMessage', that);
        }, function (err, res) {
            toastr.error(that.language['overlayFailedMessageLabel']);
        });
    }
});
