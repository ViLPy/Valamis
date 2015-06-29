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
    'read': {
      path: path.api.courses,
      'data': function (collection, options) {
        var filter = options.filter || '';
        var sort = 'true';
        if (options.sort)
          sort = options.sort;
        return {
          companyID: jQuery('#curriculumCompanyID').val(),
          filter: filter,
          sortAscDirection: sort,
          page: options.currentPage,
          count: options.itemsOnPage
        }
      },
      'method': 'get'
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
    "click .js-toggle-site-button": "toggleThis"
  },
  tagName: 'tr',
  initialize: function (options) {
     this.singleSelect = options.singleSelect;
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferaySiteElementView').html(), {title: this.model.get('title')});
    this.$el.html(template);
    return this;
  },
  toggleThis: function () {
    if (this.singleSelect)
      this.trigger('lfSiteSelected', this.model);

    var alreadySelected = this.model.get('selected');
    if (alreadySelected) {
      this.model.set({selected: false });
      this.$('.js-toggle-site-button').removeClass('primary');
      this.$('.js-toggle-site-button').addClass('neutral');
    }
    else {
      this.model.set({selected: true });
      this.$('.js-toggle-site-button').removeClass('neutral');
      this.$('.js-toggle-site-button').addClass('primary');
    }
  },
  isSelected: function () {
    return this.model.get('selected');
  }
});

LiferaySitesContainer = Backbone.View.extend({
  events: {
    'keyup #siteSearch': 'filterCourses',
    'click .dropdown-menu > li': 'filterCourses',
    'click .js-addCourses': 'addCourses'
  },
  initialize: function (options) {
    this.language = options.language;
    this.singleSelect = options.singleSelect;

    this.collection = new LiferaySiteCollection();
    this.collection.on('reset', this.addSites, this);

    var template = Mustache.to_html(jQuery('#liferaySiteDialogView').html(), _.extend({singleSelect: this.singleSelect}, this.language));
    this.$el.html(template);
    this.$el.find('.dropdown').valamisDropDown();

    var that = this;
    this.collection.on("siteCollection:updated", function (details) {
      that.updatePagination(details, that);
    }, this);

    this.pageModel = new PageModel();
    this.pageModel.set({'itemsOnPage': 10});
    this.paginator = new ValamisPaginator({
      el: this.$('#siteListPaginator'),
      language: this.language,
      model: this.pageModel
    });
    this.paginatorShowing = new ValamisPaginatorShowing({
      el: this.$('#siteListPagingShowing'),
      language: this.language,
      model: this.paginator.model
    });

    this.paginator.on('pageChanged', function () {
      that.collection.fetch({reset: true, currentPage: that.paginator.currentPage(), itemsOnPage: that.paginator.itemsOnPage()});
    });

  },
  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
  },
  fetchSites: function () {
    this.collection.fetch({
      reset: true,
      currentPage: this.paginator.currentPage(),
      itemsOnPage: this.paginator.itemsOnPage(),
      filter: this.$('#siteSearch').val(),
      sort: this.$('#sortSite').data('value')
    });
  },
  addSites: function() {
    this.$('#siteList').empty();
    this.collection.each(this.addSite, this);
  },
  addSite: function (site) {
    var view = new LiferaySiteListElement({model: site, singleSelect: this.singleSelect});
    view.on('lfSiteSelected', function (item) {
      this.trigger('lfSiteSelected', item);
    }, this);
    this.$('#siteList').append(view.render().$el);
  },
  render: function () {
    this.fetchSites();
    return this;
  },
  addCourses: function () {
    this.trigger('addSelectedLfSite', this.collection);
  },
  filterCourses: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);
    this.fetchSites();
  }
});

