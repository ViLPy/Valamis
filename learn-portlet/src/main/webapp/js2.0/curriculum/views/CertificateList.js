var DISPLAY_TYPE = {
  LIST: 'list',
  TILES: 'tiles'
};

var VIEW_TYPE = {
  ADMIN: 'adminView',
  MY_COLLECTION: 'myCollection',
  AVAILABLE_COLLECTION: 'availableCollection'
};

var CertificatesListView = Backbone.View.extend({
  SEARCH_TIMEOUT: 800,
  events: {
    'click .js-list-view': 'displayList',
    'click .js-tile-view': 'displayTiles',
    'click #addCertificate': 'addCertificate',
    'keyup .js-certificate-filter': 'filterCertificates',
    'click .js-filter-dropdown li': 'filterCertificates'
  },

  initialize: function (options) {
    this.portletId = options.portletId;
    this.language = options.language;
    this.permissions = options.permissions;

    this.collection = options.collection;
    this.collection.bind('add', this.addOne, this);
    this.collection.bind('reset', this.addAll, this);
    this.settings = options.settings;
    this.viewType = options.viewType;
    this.paginatorModel = new PageModel();

    var that = this;
    this.collection.on('certificateCollection:updated', function (details) {
      that.updatePagination(details, that);
    });

    this.render(options.scopeAvailable);

    this.reloadFirstPage();
  },

  setDropdowns: function(elem, sort) {
    if (sort) {
      elem.data('value', sort);
      elem.find('li').removeClass('selected');
      var selected = elem.find('li[data-value="' + sort + '"]');
      selected.addClass('selected');
      elem.find('.dropdown-text').html(selected.html());
    }
  },

  render: function (scopeAvailable) {
    this.views = [];
    var template = Mustache.to_html(jQuery('#curriculumLayoutTemplate').html(),
      _.extend({
          scopeAvailable: scopeAvailable,
          currentCertificateID: Utils.getCourseId(),
          portletId: this.portletId
        }, this.language, this.permissions));
    this.$el.html(template);
    this.$('.dropdown').valamisDropDown();


    if (this.settings.get('layout') === DISPLAY_TYPE.TILES) {
      this.displayTiles();
    } else {
      this.displayList();
    }

    this.setDropdowns(this.$el.find('#certificateOrder_' + this.portletId), this.settings.get('sort_'+this.viewType));
    this.setDropdowns(this.$el.find('#certificateScopeFilter_' + this.portletId), this.settings.get('scope_'+this.viewType));

    var that = this;

    this.paginator = new ValamisPaginator({
      el: this.$el.find("#certificateListPaginator"),
      language: this.language,
      model: this.paginatorModel
    });
    this.paginator.on('pageChanged', function () {
      that.reload();
    });

    this.paginatorShowing = new ValamisPaginatorShowing({
      el: this.$el.find("#certificateListPagingShowing"),
      language: this.language,
      model: this.paginator.model
    });
  },

  reloadFirstPage: function () {
    this.fetchCollection(1);
  },
  reloadWithMessage: function () {
    toastr.success(this.language['overlayCompleteMessageLabel']);
    this.reload();
  },
  reload: function () {
    var page = this.paginatorModel.get('currentPage');
    this.fetchCollection(page);
  },
  fetchCollection: function(pageNumber) {
    this.collection.fetch({
      reset: true,
      currentPage: pageNumber,
      itemsOnPage: this.paginatorModel.get('itemsOnPage'),
      filter: this.$el.find('.js-certificate-filter').val(),
      order: this.$el.find('#certificateOrder_' + this.portletId).data('value'),
      scope: this.$el.find('#certificateScopeFilter_' + this.portletId).data('value'),
      portletId: this.portletId});
  },

  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
  },


  addAll: function () {
    this.$el.find('.js-certificate-items').html('');
    this.collection.each(this.addOne, this);
    jQuery(window).trigger('portlet-ready');
  },
  addOne: function (element) {
    var view = new CertificateItemView({
      model: element,
      language: this.language,
      viewType: this.viewType,
      permissions: this.permissions
    });
    view.on('editCertificateDetails', this.editDetails, this);
    view.on('editCertificateGoals', this.editGoals, this);
    view.on('editCertificateMembers', this.editMembers, this);
    view.on('reload', this.reload, this);
    view.on('item:model:removed', function(model) {
      this.collection.remove(model);
      if (this.collection.length === 0)
        this.paginatorModel.set('currentPage', this.paginatorModel.get('currentPage')-1);
      this.reload();
    }, this);
    view.on('reloadWithMessage', this.reloadWithMessage, this);

    this.views[element.id] = view;
    var viewDOM = view.render().el;
    this.$el.find('.js-certificate-items').append(viewDOM);
  },

  editDetails: function (model) {
    this.trigger('editDetails', model);
  },
  editGoals: function (model) {
    this.trigger('editGoals', model);
  },
  editMembers: function (model) {
    this.trigger('editMembers', model);
  },

  displayList: function () {
    this.setDisplayType(DISPLAY_TYPE.LIST);
  },
  displayTiles: function () {
    this.setDisplayType(DISPLAY_TYPE.TILES);
  },

  setDisplayType: function (displayType) {
    this.itemDisplayType = displayType;
    this.settings.set('layout',displayType);
    this.settings.save();

    this.$el.find('.js-tile-view').toggleClass('active', this.itemDisplayType == DISPLAY_TYPE.TILES);
    this.$el.find('.js-list-view').toggleClass('active', this.itemDisplayType == DISPLAY_TYPE.LIST);
    this.$el.find('.js-certificate-items').toggleClass('tiles', this.itemDisplayType == DISPLAY_TYPE.TILES);
    this.$el.find('.js-certificate-items').toggleClass('list', this.itemDisplayType == DISPLAY_TYPE.LIST);
    jQuery(window).trigger('viewModeChanged', this.$el);
  },

  remove: function () {
    Backbone.View.prototype.remove.apply(this, arguments);
  },

  addCertificate: function () {
    this.trigger('addCertificate');
  },
  filterCertificates: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), this.SEARCH_TIMEOUT);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);
    this.trigger('filterCertificates', this);

    this.settings.set('sort_'+this.viewType, this.$el.find('#certificateOrder_' + this.portletId).data('value'));
    this.settings.set('scope_'+this.viewType, this.$el.find('#certificateScopeFilter_' + this.portletId).data('value'));
    this.settings.save();

    this.reloadFirstPage();
  }
});
