var DISPLAY_TYPE = {
  LIST: 'list',
  TILES: 'tiles'
};

var CertificateItemView = Backbone.View.extend({
  events: {
    'click .editCertificateCommand': 'openDetails',
    'click .editCourseCertificateCommand': 'openGoals',
    'click .editUserCertificateCommand': 'openUsers',
    'click .cloneCertificateCommand': 'cloneCertificate',
    'click .publishCertificateCommand': 'publishCertificate',
    'click .unpublishCertificateCommand': 'unpublishCertificate',
    'click .deleteCertificateCommand': 'confirmDeleteCertificate'
  },

  initialize: function (options) {
    this.language = options.language;
    this.displayType = options.displayType;
  },

  render: function () {
    var templateID = '#certificateTileItemViewTemplate';
    if (this.displayType == DISPLAY_TYPE.LIST) {
      this.$el.addClass('certificate-list-item clearfix');
      templateID = '#certificateListItemViewTemplate';
    }
    if (!this.model.get('isPublished')) {
      this.$el.addClass('unpublished');
    }

    var goalsCount = this.model.get('activityCount') + this.model.get('courseCount') + this.model.get('statementCount');

    var template = Mustache.to_html(jQuery(templateID).html(),
      _.extend(this.model.toJSON(), this.language, {goalsCount: goalsCount, contextPath: Utils.getContextPath}));
    this.$el.html(template);
    return this;
  },

  openDetails: function () {
    this.trigger('editCertificateDetails', this.model.id);
  },
  openGoals: function () {
    this.trigger('editCertificateGoals', this.model.id);
  },
  openUsers: function () {
    this.trigger('editCertificateMembers', this.model.id);
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
        that.trigger('reload', this);
      },
      error: function (model, response) {
        toastr.error(that.language['overlayFailedMessageLabel']);
      }
    });

  }

});

/*
 var DeleteConfirmationView = Backbone.View.extend({
 events: {
 'click .confirmation': 'confirmDelete'
 },
 initialize: function (options) {
 this.language = options.language;
 },
 render: function () {
 var template = Mustache.to_html(jQuery('#deleteConfirmationTemplate').html(), this.language);
 this.$el.html(template);
 return this;
 },
 confirmDelete: function () {
 this.trigger('certificateDeleteConfirmed', this);
 }
 });
 */


var CertificatesListView = Backbone.View.extend({
  events: {
    'click #certificatesListView': 'displayList',
    'click #certificatesTilesView': 'displayTiles'
  },

  initialize: function (options) {
    this.$el.addClass('grid-view');
    this.language = options.language;
    this.itemDisplayType = options.displayType || DISPLAY_TYPE.TILES;
    this.collection = new CertificateCollection();
    this.collection.bind('add', this.addOne, this);
    this.collection.bind('reset', this.addAll, this);
    this.collection.bind('remove', this.deleteCertificate, this);

    var that = this;
    this.collection.on('certificateCollection:updated', function (details) {
      that.updatePagination(details, that);
    });

    jQuery(window).on('resize', this.resize);
    this.render();

    if (curriculumAdminSettings.get('layout') === DISPLAY_TYPE.LIST) {
      this.displayList();
    } else {
      this.displayTiles();
    }
  },

  render: function () {
    this.views = [];
    var template = Mustache.to_html(jQuery('#certificatesListTemplate').html(),
      _.extend({talesView: (this.itemDisplayType == DISPLAY_TYPE.TILES)}, this.language));
    this.$el.html(template);

    var that = this;
    this.paginator = new ValamisPaginator({el: jQuery('#certificateListPaginator'), language: this.language});
    this.paginator.on('pageChanged', function () {
      that.reload();
    });

    this.reloadFirstPage();
  },

  reloadFirstPage: function () {
    this.collection.fetch({reset: true, currentPage: 1, itemsOnPage: this.paginator.itemsOnPage()});
  },
  reloadWithMessage: function () {
    toastr.success(this.language['overlayCompleteMessageLabel']);
    this.reload();
  },
  reload: function () {
    this.collection.fetch({reset: true, currentPage: this.paginator.currentPage(), itemsOnPage: this.paginator.itemsOnPage()});
  },

  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
  },


  addAll: function () {
    this.$('.certificate-items').html('');
    this.collection.each(this.addOne, this);
  },
  addOne: function (element) {
    var viewportWidth = jQuery(window).width();
    if (viewportWidth <= 767) {
      this.itemDisplayType = DISPLAY_TYPE.LIST;
    }

    var view = new CertificateItemView({
      model: element,
      displayType: this.itemDisplayType,
      language: this.language
      //isAdmin: this.options.isAdmin
    });
    view.on('editCertificateDetails', this.editDetails, this);
    view.on('editCertificateGoals', this.editGoals, this);
    view.on('editCertificateMembers', this.editMembers, this);
    view.on('reload', this.reload, this);
    view.on('reloadWithMessage', this.reloadWithMessage, this);

    this.views[element.id] = view;
    var viewDOM = view.render().el;
    this.$('.certificate-items').append(viewDOM);
  },

  editDetails: function (certificateID) {
    this.trigger('editDetails', certificateID);
  },
  editGoals: function (certificateID) {
    this.trigger('editGoals', certificateID);
  },
  editMembers: function (certificateID) {
    this.trigger('editMembers', certificateID);
  },

  displayList: function () {
    this.$('#certificatesListView').addClass('active');
    this.$('#certificatesTilesView').removeClass('active');
    this.setDisplayType(DISPLAY_TYPE.LIST);
    curriculumAdminSettings.set('layout',DISPLAY_TYPE.LIST);
    curriculumAdminSettings.save();
  },
  displayTiles: function () {
    this.$('#certificatesTilesView').addClass('active');
    this.$('#certificatesListView').removeClass('active');
    this.setDisplayType(DISPLAY_TYPE.TILES);
    curriculumAdminSettings.set('layout',DISPLAY_TYPE.TILES);
    curriculumAdminSettings.save();
  },

  setDisplayType: function (displayType) {
    this.itemDisplayType = displayType;
    this.render();
  },

  resize: function () {
    var viewportWidth = jQuery(window).width();
    if (viewportWidth <= 767) {
      window.certificateList.displayList();
    }
  },

  remove: function () {
    jQuery(window).off('resize', this.resize);
    Backbone.View.prototype.remove.apply(this, arguments);
  }
});
