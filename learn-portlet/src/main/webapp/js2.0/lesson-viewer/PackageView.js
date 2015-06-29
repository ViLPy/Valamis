PlayerPackageView = Backbone.View.extend({
    events: {
      'click .js-share-package': 'sharePackage'
    },

    initialize: function (options) {
        this.language = options.language;
        this.template = options.template;
        this.permissions = options.permissions;
    },

    render: function () {
        this.showDefault();
        this.$el.attr('id', this.model.id);
        return this;
    },

    showDefault: function () {
        var remain = 0;
        var limit = this.model.get('passingLimit');
        if (limit > 0)
          remain = limit - this.model.get('attemptsCount');

        var isSuspended = false;
        if (this.model.get('suspendedID') != undefined)
          isSuspended = true;

        var winHref = window.location.href;
        var shIndex = winHref.indexOf('#');
        var href = winHref;
        if (shIndex > -1)
          href = winHref.substr(0, shIndex);

        var link = href + '#/lesson/'+this.model.get('id')+'/'+this.model.get('packageType') + '/'+encodeURIComponent(this.model.get('title')) + '/' + isSuspended;

        var tags = Array();
        this.model.get('tags').forEach(function(item) {
          tags.push(item.text);
        });
        var categories = tags.join(' • ');

        var statusLabel = '';
        if (this.model.get('suspendedID'))
          statusLabel = 'suspendedPackageStatusLabel';
        else
          statusLabel = this.model.get('status') + 'PackageStatusLabel';

        var template = Mustache.to_html(jQueryValamis(this.template).html(), _.extend({
            remain: remain,
            link: link,
            categories: categories,
            packageStatusLabel: this.language[statusLabel]
          }, this.model.toJSON(), this.language, this.permissions));
        this.$el.html(template);
    },
    sharePackage: function() {
        this.trigger('showSharePackageModal', this.model);
    }
});

var PLAYER_LIST_VIEW_MODE = {
    LIST: 'list',
    TILE: 'tile'
};

var PlayerPackageListView = Backbone.View.extend({
    events: {
        'keyup #playerPackageFilter': 'filterPackages',
        'click .js-filter-dropdown li': 'filterPackages',
        'click .js-list-view': 'renderAsList',
        'click .js-tile-view': 'renderAsTiles'
    },

    initialize: function (options) {
        if (playerSettings.get('layout') === PLAYER_LIST_VIEW_MODE.TILE) {
          this.viewMode = PLAYER_LIST_VIEW_MODE.TILE;
        } else {
          this.viewMode = PLAYER_LIST_VIEW_MODE.LIST;
        }

        this.permissions = options.permissions;
        this.language = options.language;
        this.activePackageView = null;
        this.sortableAscOrder = [];
        this.childViews = [];
        this.paginatorModel = new PageModel();
        this.collection.on('reset', this.addPackagesFromCollection, this);
        this.render();
        var that = this;

        this.setDisplayModeActiveState(this.viewMode);
        this.tags = new Valamis.TagCollection();
        this.tags.fetch({
          success: function() {
            that.addTags();
          }
        });

        if (playerSettings.get('sort')) {
          var elem = this.$el.find('#playerPackageOrder');
          var sort = playerSettings.get('sort');
          elem.data('value', sort);
          var selected = this.$el.find('li[data-value="'+sort+'"]');
          elem.find('li').removeClass('selected');
          selected.addClass('selected');
          elem.find('.dropdown-text').html(selected.html());
        }

        this.collection.on('packageCollection:updated', function (details) {
            that.updatePagination(details, that);
        });
    },

    addTags: function() {
      this.tags.each(function(item) {
        this.$el.find('#playerPackageTags').find('.dropdown-menu').append('<li data-value="'+ item.get('id') +'"> '+ item.get('text') +' </li>');
      }, this);
      this.$('.dropdown').valamisDropDown();
    },

    render: function () {
        var that = this;
        var template = Mustache.to_html(jQueryValamis('#packageListTemplate').html(), _.extend(that.language));
        this.$el.html(template);

        that.paginator = new ValamisPaginator({
            el: that.$el.find("#packageListPaginator"),
            language: that.language,
            model: that.paginatorModel
        });
        that.paginator.on('pageChanged', function () {
            that.reload();
        });

        that.paginatorShowing = new ValamisPaginatorShowing({
            el: that.$el.find("#lessonViewerPagingShowing"),
            language: that.language,
            model: that.paginator.model
        });
    },
    reloadFirstPage: function () {
        this.collection.fetch({
            reset: true,
            currentPage: 1,
            itemsOnPage: this.paginatorModel.get('itemsOnPage'),
            portletID: this.portletID});
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

    renderAsTiles: function(e, silent){
        this.viewMode = PLAYER_LIST_VIEW_MODE.TILE;
        if (!silent) {
          playerSettings.set('layout',this.viewMode);
          playerSettings.save();
        }
        this.setDisplayModeActiveState(this.viewMode);
        jQueryValamis(window).trigger('viewModeChanged', this.$el);
    },

    renderAsList: function(){
      this.viewMode = PLAYER_LIST_VIEW_MODE.LIST;
      playerSettings.set('layout',this.viewMode);
      playerSettings.save();
      this.setDisplayModeActiveState(this.viewMode);
      jQueryValamis(window).trigger('viewModeChanged', this.$el);
    },

    setDisplayModeActiveState: function(mode) {
      switch (mode) {
        case PLAYER_LIST_VIEW_MODE.LIST:
          this.$el.find('.js-tile-view').removeClass('active');
          this.$el.find('.js-list-view').addClass('active');
          this.$el.find('.js-package-items').removeClass('tiles');
          this.$el.find('.js-package-items').addClass('list');
          break;
        case PLAYER_LIST_VIEW_MODE.TILE:
          this.$el.find('.js-tile-view').addClass('active');
          this.$el.find('.js-list-view').removeClass('active');
          this.$el.find('.js-package-items').removeClass('list');
          this.$el.find('.js-package-items').addClass('tiles');
          break;
      }
    },

    reloadPackageList: function () {
        this.collection.fetch({
            reset: true,
            currentPage: this.paginatorModel.get('currentPage'),
            itemsOnPage: this.paginatorModel.get('itemsOnPage')
        });
    },

    filterPackages: function () {
        clearTimeout(this.inputTimeout);
        this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
    },
    applyFilter: function () {
      clearTimeout(this.inputTimeout);
      this.updateSettings();
      this.reloadPackageList();
    },

    updateSettings: function() {
      playerSettings.set('sort',this.$el.find('#playerPackageOrder').data('value'));
      playerSettings.save();
    },

    addPackage: function (pkg) {
        var view = new PlayerPackageView({
                    model: pkg,
                    language: this.language,
                    template: '#playerTileItemView',
                    className: 'tile s-12 m-4 l-2',
                    permissions: this.permissions
                });
        view.on('showSharePackageModal', function(model) {
          this.trigger('showSharePackageModal', model);
        }, this);

        this.childViews.push(view);
        this.$el.find('.js-package-items').append(view.render().$el);
    },

    addPackagesFromCollection: function () {
        _.forEach(this.childViews, function(e) {
            this.stopListening(e);
            e.remove();
        }, this);
        this.$('.js-package-items').empty();
        this.collection.each(this.addPackage, this);
        jQueryValamis(window).trigger('portlet-ready');
    }
});

var SharePackageModalView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
  },
  render: function () {
    var template = Mustache.to_html(jQueryValamis('#sharePackageModalViewTemplate').html(), this.language);
    this.$el.html(template);

    return this;
  }
});
