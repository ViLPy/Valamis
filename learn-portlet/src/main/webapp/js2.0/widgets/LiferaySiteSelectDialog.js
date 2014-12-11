LiferaySiteModel = Backbone.Model.extend({
  defaults: {
    siteID: '',
    title: '',
    url: '',
    description: ''
  }
});

LiferaySiteCollectionService = new Backbone.Service({ url: '/',
  sync: {
    'read': function (collection, options) {
      var filter = '';
      if (jQuery('#siteSearch').val() != undefined)
        filter = jQuery('#siteSearch').val();
      var sort = 'true';
      if (jQuery('#sortSite').val() != undefined)
        sort = jQuery('#sortSite').val();

      return path.api.courses + '?companyID=' + jQuery('#curriculumCompanyID').val() +
        '&filter=' + filter +
        '&sortAscDirection=' + sort +
        '&page=' + options.currentPage +
        '&count=' + options.itemsOnPage;
    }
  }
});

LiferaySiteCollection = Backbone.Collection.extend({
  model: LiferaySiteModel,
  parse: function (response) {
    this.trigger('siteCollection:updated', { total: response.total, currentPage: response.currentPage, listed: response.records.length });
    return response.records;
  }
}).extend(LiferaySiteCollectionService);


LiferaySiteListElement = Backbone.View.extend({
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
    this.trigger('lfSiteSelected', this.model);  // TODO: do it only if single select
    var alreadySelected = this.model.get('selected');
    if (alreadySelected) {
      this.model.set({selected: false });
      this.$('#toggleSiteButton').removeClass('green');
      this.$('#toggleSiteButton').addClass('grey');
    }
    else {
      this.model.set({selected: true });
      this.$('#toggleSiteButton').removeClass('grey');
      this.$('#toggleSiteButton').addClass('green');
    }
  },
  isSelected: function () {
    return this.model.get('selected');
  }
});

LiferaySitesView = Backbone.View.extend({
  events: {

  },

  initialize: function (options) {
    this.language = options.language;
    this.collection = new LiferaySiteCollection();
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
    var view = new LiferaySiteListElement({model: site});
    view.on('lfSiteSelected', function (item) {
      this.trigger('lfSiteSelected', item);
    }, this);
    this.$('#siteList').append(view.render().$el);
  }

});

LiferaySitesContainer = Backbone.View.extend({
  events: {
    'keyup #siteSearch': 'filterUsers',
    'change #sortSite': 'filterUsers',
    'click .menu-close': 'searchMenuToggle',
    'click .addCourses': 'addCourses',
    'click .menu-open': 'searchMenuToggle'
  },
  initialize: function (options) {
    this.language = options.language;
    this.singleSelect = options.singleSelect;
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferaySiteDialogView').html(), _.extend({singleSelect: this.singleSelect}, this.language));
    this.$el.html(template);

    this.listView = new LiferaySitesView({el: this.$('#sitesContainer'), language: this.language});
    this.listView.on('lfSiteSelected', function (item) {
      this.trigger('lfSiteSelected', item);
    }, this);
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

  addCourses: function () {
    this.trigger('addSelectedLfSite', this.listView.collection);
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

