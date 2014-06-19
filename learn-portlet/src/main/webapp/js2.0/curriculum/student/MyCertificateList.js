var DISPLAY_TYPE = {
  LIST: 1,
  TILES: 2
};

var MyCertificateItemView = Backbone.View.extend({
  events: {
    'click .viewCertificateDetailsCommand': 'openDetails',
    'click .viewCertificateGoalsCommand': 'openGoals',
    'click .leaveCertificateCommand': 'leaveCertificate'
  },

  initialize: function (options) {
    this.language = options.language;
    this.displayType = options.displayType;
  },

  render: function () {
    var templateID = '#userCertificateTileItemViewTemplate';
    if (this.displayType == DISPLAY_TYPE.LIST) {
      this.$el.addClass('certificate-list-item clearfix');
      templateID = '#userCertificateListItemViewTemplate';
    }
    if (!this.model.get('isPublished')) {
      this.$el.addClass('unpublished');
    }
    var goalsCount = this.model.get('activityCount') + this.model.get('courseCount') + this.model.get('statementCount');
    var status = this.model.get('status');
    var template = Mustache.to_html(jQuery(templateID).html(),
      _.extend({
        isMyCollection: true,
        contextPath: Utils.getContextPath,
        successStatus: status == 'Success',
        failedStatus: status == 'Failed',
        overdueStatus: status == 'Overdue',
        goalsCount: goalsCount}, this.model.toJSON(), this.language));
    this.$el.html(template);
    return this;
  },

  openDetails: function () {
    this.trigger('editCertificateDetails', {id: this.model.id, status: this.model.get('status')});
  },
  openGoals: function () {
    this.trigger('editCertificateGoals', {id: this.model.id});
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

var MyCertificateListView = Backbone.View.extend({
  events: {
    'click #userCertificatesListView': 'displayList',
    'click #userCertificatesTilesView': 'displayTiles',
    'click .menu-open': 'searchMenuToggle'
  },

  initialize: function (options) {
    this.language = options.language;
    this.itemDisplayType = options.displayType || DISPLAY_TYPE.TILES;

    if (curriculumUserSettings.get('layout-my') === DISPLAY_TYPE.LIST) {
      this.itemDisplayType = DISPLAY_TYPE.LIST;
    } else {
      this.itemDisplayType = options.displayType || DISPLAY_TYPE.TILES;
    }

    this.collection = new MyCertificateCollection();
    this.collection.bind('reset', this.addAll, this);

    var that = this;
    this.collection.on('certificateCollection:updated', function (details) {
      that.updatePagination(details, that);
    });

    jQuery(window).on('resize', this.resize);

  },

  render: function () {
    this.views = [];
    var template = Mustache.to_html(jQuery('#userCertificatesListTemplate').html(),
      _.extend({talesView: (this.itemDisplayType == DISPLAY_TYPE.TILES), isMyCollection: true}, this.language));
    this.$el.html(template);

    return this;
  },

  reloadFirstPage: function () {
    var that = this;
    this.paginator = new ValamisPaginator({el: jQuery('#userMyCertificateListPaginator'), language: this.language});
    this.paginator.on('pageChanged', function () {
      that.reload();
    });
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

    var view = new MyCertificateItemView({
      model: element,
      displayType: this.itemDisplayType,
      language: this.language
    });
    view.on('editCertificateDetails', this.editDetails, this);
    view.on('editCertificateGoals', this.editGoals, this);
    view.on('reloadWithMessage', this.reloadWithMessage, this);

    this.views[element.id] = view;
    var viewDOM = view.render().el;
    this.$('.certificate-items').append(viewDOM);
  },

  editDetails: function (data) {
    this.trigger('editDetails', data);
  },
  editGoals: function (certificateID) {
    this.trigger('editGoals', certificateID);
  },

  displayList: function () {
    this.$('#userCertificatesListView').addClass('active');
    this.$('#userCertificatesTilesView').removeClass('active');
    this.setDisplayType(DISPLAY_TYPE.LIST);
    curriculumUserSettings.set('layout-my',DISPLAY_TYPE.LIST);
    curriculumUserSettings.save();
  },
  displayTiles: function () {
    this.$('#userCertificatesTilesView').addClass('active');
    this.$('#userCertificatesListView').removeClass('active');
    this.setDisplayType(DISPLAY_TYPE.TILES);
    curriculumUserSettings.set('layout-my',DISPLAY_TYPE.TILES);
    curriculumUserSettings.save();
  },

  setDisplayType: function (displayType) {
    this.itemDisplayType = displayType;
    this.reload();
  },

  resize: function () {
    var viewportWidth = jQuery(window).width();
    if (viewportWidth <= 767) {
      window.myCollection.displayList();
    }
  },
  searchMenuToggle: function (e) {
    e.preventDefault();
    this.trigger('certificateToggleMenu', e);
  }
});