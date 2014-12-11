var AvailableCertificateItemView = Backbone.View.extend({
  events: {
    'click .viewCertificateDetailsCommand': 'openDetails',
    'click .viewCertificateGoalsCommand': 'openGoals',
    'click .joinCertificateCommand': 'joinCertificate',
    'mouseenter .flip-container'   : 'hoverOn',
    'mouseleave .flip-container'   : 'hoverOff'
  },

  initialize: function (options) {
    this.language = options.language;
    this.displayType = options.displayType;
  },

  render: function () {
    var templateID = '#userCertificateTileItemViewTemplate';
    if (this.displayType == DISPLAY_TYPE.LIST) {
      this.$el.addClass('valamis-list-item clearfix');
      templateID = '#userCertificateListItemViewTemplate';
    }
    else {
      this.$el.addClass('valamis-tile-item clearfix');
    }
    var goalsCount = this.model.get('activityCount')
        + this.model.get('courseCount') + this.model.get('statementCount');

    var template = Mustache.to_html(jQuery(templateID).html(),
      _.extend(this.model.toJSON(),
        _.extend(
          {
            isMyCollection: false,
            contextPath: Utils.getContextPath,
            goalsCount: goalsCount,
            description: decodeURIComponent(this.model.get('description'))},
        this.language
      )));
    this.$el.html(template);
    return this;
  },
  hoverOn: function() {
    this.$el.find('.flip-container .back > div').removeClass('hidden');
  },
  hoverOff: function() {
    this.$el.find('.flip-container .back > div').addClass('hidden');
  },
  openDetails: function () {
    this.trigger('editCertificateDetails', {id: this.model.id, status: ''});
  },
  openGoals: function () {
    this.trigger('editCertificateGoals', {id: this.model.id});
  },
  joinCertificate: function () {
    var that = this;
    this.model.join({}).then(function (res) {
      that.trigger('reloadWithMessage', that);
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  }

});


var AvailableCertificateListView = Backbone.View.extend({
  events: {
    'click #userCertificatesListView': 'displayList',
    'click #userCertificatesTilesView': 'displayTiles',
    'click .menu-open': 'searchMenuToggle'
  },

  initialize: function (options) {
    this.language = options.language;
    this.portletID = options.portletID;
    this.itemDisplayType = options.displayType || DISPLAY_TYPE.TILES;

    if (curriculumUserSettings.get('layout-avail') === DISPLAY_TYPE.LIST) {
      this.itemDisplayType = DISPLAY_TYPE.LIST;
    } else {
      this.itemDisplayType = options.displayType || DISPLAY_TYPE.TILES;
    }

    this.collection = new AvailableCertificateCollection();
    this.collection.bind('reset', this.addAll, this);

    this.paginatorModel = new PageModel();

    var that = this;
    this.collection.on('certificateCollection:updated', function (details) {
      that.updatePagination(details, that);
    });
  },

  render: function () {
    this.views = [];
    var template = Mustache.to_html(jQuery('#userCertificatesListTemplate').html(),
      _.extend({talesView: (this.itemDisplayType == DISPLAY_TYPE.TILES), isMyCollection: false}, this.language));
    this.$el.html(template);
  },

  reloadFirstPage: function () {
    this.paginatorModel.set({'currentPage': 1});

    var that = this;
    this.paginator = new ValamisPaginator({
      el: jQuery('#userAvailableCertificateListPaginator'),
      language: this.language,
      model: this.paginatorModel,
      needDisplay: true
    });
    this.paginator.on('pageChanged', function () {
      that.reload();
    });

    this.paginatorBottom = new ValamisPaginator({
      el: jQuery('#userAvailableCertificateListBottomPaginator'),
      language: this.language,
      model: this.paginatorModel
    });
    this.paginatorBottom.on('pageChanged', function () {
      that.reload();
    });

    this.collection.fetch({
      reset: true,
      currentPage: 1,
      itemsOnPage: this.paginatorModel.get('itemsOnPage'),
      portletID: this.portletID});
  },
  reloadWithMessage: function () {
    toastr.success(this.language['overlayCompleteMessageLabel']);
    this.reload();
  },
  reload: function () {
    this.collection.fetch({
      reset: true,
      currentPage: this.paginatorModel.get('currentPage'),
      itemsOnPage: this.paginatorModel.get('itemsOnPage'),
      portletID: this.portletID});
  },

  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
  },


  addAll: function () {
    valamisTileResize(this.$el);
    this.$('.certificate-items').html('');
    if (this.collection.length == 0)
      this.$('#userAvailableCertificateListBottomPaginator').hide();
    else
      this.$('#userAvailableCertificateListBottomPaginator').show();
    this.collection.each(this.addOne, this);
  },
  addOne: function (element) {
    var viewportWidth = jQuery(window).width();
    if (viewportWidth <= 767) {
      this.itemDisplayType = DISPLAY_TYPE.LIST;
    }

    var view = new AvailableCertificateItemView({
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
    curriculumUserSettings.set('layout-avail',DISPLAY_TYPE.LIST);
    curriculumUserSettings.save();
  },
  displayTiles: function () {
    this.$('#userCertificatesTilesView').addClass('active');
    this.$('#userCertificatesListView').removeClass('active');
    this.setDisplayType(DISPLAY_TYPE.TILES);
    curriculumUserSettings.set('layout-avail',DISPLAY_TYPE.TILES);
    curriculumUserSettings.save();
  },

  setDisplayType: function (displayType) {
    this.itemDisplayType = displayType;
    this.reload();
  },

  resize: function () {
    var viewportWidth = jQuery(window).width();
    if (viewportWidth <= 767) {
      window.availableCollection.displayList();
    }
  },
  searchMenuToggle: function (e) {
    e.preventDefault();
    this.trigger('certificateToggleMenu', e);
  }
});