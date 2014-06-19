ScopeModel = Backbone.Model.extend({
  defaults: {
    siteID: '',
    title: '',
    url: '',
    description: ''
  }
});

ScopeCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'read': function (collection, options) {
      var filter = '';
      if (jQuery('#siteSearch').val() != undefined)
        filter = jQuery('#siteSearch').val();
      var sort = 'true';
      if (jQuery('#sortSite').val() != undefined)
        sort = jQuery('#sortSite').val();

      return 'api/courses' + '?companyID=' + jQuery('#curriculumCompanyID').val() +
        '&filter=' + filter +
        '&sortAscDirection=' + sort +
        '&page=' + options.currentPage +
        '&count=' + options.itemsOnPage;
    }
  }
});

ScopeCollection = Backbone.Collection.extend({
  model: ScopeModel,
  parse: function (response) {
    this.trigger('siteCollection:updated', { total: response.total, currentPage: response.currentPage, listed: response.records.length });
    return response.records;
  }
}).extend(ScopeCollectionService);


ScopeListElement = Backbone.View.extend({
  events: {
    "click #toggleSiteButton": "toggleThis"
  },
  initialize: function () {
    this.$el = jQuery('<tr>');
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferaySiteElementView').html(), {title: this.model.get('title'), description: this.model.get('description')});
    this.$el.html(template);
    return this;
  },
  toggleThis: function () {
    this.trigger('scopeSelected', this.model);
  }
});

var ScopesView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
    this.collection = new ScopeCollection();
    this.collection.on('reset', this.render, this);

    var that = this;
    this.collection.on("siteCollection:updated", function (details) {
      that.updatePagination(details, that);
    }, this);

    this.$el.html(Mustache.to_html(jQuery('#liferaySiteListView').html(), this.language));
    this.paginator = new ValamisPaginator({el: this.$('#siteListPaginator'), language: this.language});
    this.paginator.on('pageChanged', function () {
      that.collection.fetch({reset: true, currentPage: that.paginator.currentPage(), itemsOnPage: that.paginator.itemsOnPage()});
    });
  },
  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
    jQuery('#sitesListedAmount').text(details.listed);
  },
  render: function () {
    this.$('#siteList').empty();

    this.collection.each(this.addSite, this);
    return this;
  },
  fetchSites: function () {
    this.collection.fetch({reset: true, currentPage: this.paginator.currentPage(), itemsOnPage: this.paginator.itemsOnPage()});
  },
  addSite: function (site) {
    var view = new ScopeListElement({model: site});
    view.on('scopeSelected', function (model) {
      this.trigger('scopeSelected', model);
    }, this);
    this.$('#siteList').append(view.render().$el);
  }
});

var ScopeContainer = Backbone.View.extend({
  events: {
    'keyup #siteSearch': 'filterUsers',
    'change #sortSite': 'filterUsers',
    'click .menu-close': 'searchMenuToggle',

    'click .menu-open': 'searchMenuToggle'
  },
  initialize: function (options) {
    this.language = options.language;

  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferaySiteDialogView').html(), _.extend({singleSelect: true}, this.language));
    this.$el.html(template);

    this.listView = new ScopesView({el: this.$('#sitesContainer'), language: this.language});
    this.listView.on('scopeSelected', this.trigCloseModal, this);
    this.fetchSites();
    return this;
  },
  fetchSites: function () {
    this.listView.fetchSites();
  },
  searchMenuToggle: function (e) {
    e.preventDefault();
    jQuery('#liferaySitesWrapper').toggleClass('active');
  },
  trigCloseModal: function (model) {
    jQuery('#certificateScopeName').val(model.get('title'));
    jQuery('#certificateScopeID').val(model.id);
    this.trigger('closeModal', this);
  },

  filterUsers: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);
    this.listView.fetchSites();
  }

});

