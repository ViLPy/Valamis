LiferaySiteModel = Backbone.Model.extend({
  defaults: {
    siteID: '',
    title: '',
    url: '',
    description: ''
  }
});

LiferaySiteCollectionService = new Backbone.Service({ url: Utils.getContextPath,
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
  },
  targets: {
    'saveToCertificate': {
      'path': function (model, options) {
        return 'api/certificates/' + jQuery('#selectedCertificateID').val() + '?action=ADDCOURSES&' + options.courseIds ;
      },
      method: 'post'
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
    this.$('#siteList').append(view.render().$el);
  },

  addCourses: function () {
    var selectedSites = this.collection.filter(function (item) {
      return item.get('selected');
    }).map(function (item) {
        return item.get('id');
      });
    var courses = jQuery.param({'courseIds': selectedSites}, true);
    var that = this;

    that.collection.saveToCertificate({}, {courseIds: courses}).then(function (res) {
      that.trigger('sitesAdded', that);
      toastr.success(that.language['overlayCompleteMessageLabel']);
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });

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

  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferaySiteDialogView').html(), this.language);
    this.$el.html(template);

    this.listView = new LiferaySitesView({el: this.$('#sitesContainer'), language: this.language});
    this.listView.on('sitesAdded', this.trigCloseModal, this);
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
  trigCloseModal: function () {
    this.trigger('closeModal', this)
  },

  addCourses: function () {
    this.listView.addCourses();
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

