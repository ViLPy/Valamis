PlayerPackageView = Backbone.View.extend({
    events: {
        'click': 'setActive',
        'click #startPackage': 'startPackage',
        'click #resumePackage': 'resumePackage'
    },

    initialize: function (options) {
        this.language = options.language;
        this.template = options.template;
//        this.$el = jQuery('<tr>');
//        this.$el.attr('id', this.model.id);
    },

    startPackage: function () {
        this.trigger('start', this.model);
    },

    resumePackage: function () {
        this.trigger('resume', this.model);
    },

    setActive: function () {
        this.$el.addClass('SCORMHighlitedPackage');
        this.trigger('change-active', this);
    },

    render: function () {
        this.showDefault();
        this.$el.attr('id', this.model.id);
        return this;
    },

    showDefault: function () {
        var template = Mustache.to_html(jQuery(this.template).html(), _.extend(this.model.toJSON(), this.language));
        this.$el.html(template);
    }
});

var PLAYER_LIST_VIEW_MODE = {
    LIST: 'list',
    TILE: 'tile'
};

var PlayerPackageListView = Backbone.View.extend({
    events: {
        'click .menu-toggle': 'menuToggle',
        'click #SCORMPackageListReload': 'reloadPackageList',
        'keyup #playerPackageFilter': 'filterPackages',
        'change #playerPackageOrder': 'filterPackages',
        'change #playerShowMode': 'updateSettings',
        'click .js-list-view': 'renderAsList',
        'click .js-tile-view': 'renderAsTiles'
    },

    initialize: function (options) {
        if (playerSettings.get('layout') === PLAYER_LIST_VIEW_MODE.LIST) {
          this.viewMode = PLAYER_LIST_VIEW_MODE.LIST;
        } else {
          this.viewMode = PLAYER_LIST_VIEW_MODE.TILE;
        }

        this.language = options.language;
        this.activePackageView = null;
        this.sortableAscOrder = [];
        this.childViews = [];
        this.collection.on('add', this.addPackage, this);
        this.collection.on('reset', this.addPackagesFromCollection, this);
        this.render();
        this.setDisplayModeActiveState(this.viewMode);
        if (playerSettings.get('sort')) this.$('#playerPackageOrder').val(playerSettings.get('sort'));
        if (playerSettings.get('showIn')) this.$('#playerShowMode').val(playerSettings.get('showIn'));

        jQuery(window).on('resize', _.bind(this.changeViewOnWindowResize, this));
    },

    changeViewOnWindowResize: function () {
        if (jQuery(window).width() < 768) { // mobile
            this.renderAsList(null, true);
        }
    },

    render: function () {
        var template = Mustache.to_html(jQuery('#packageListTemplate').html(), this.language);
        this.$el.html(template);
        this.$('#SCORMPackageDone').hide();
        return this.$el;
    },

    renderAsList: function(e, silent){
        this.viewMode = PLAYER_LIST_VIEW_MODE.LIST;
        if (!silent) {
          playerSettings.set('layout',this.viewMode);
          playerSettings.save();
        }
        this.setDisplayModeActiveState(this.viewMode);
        this.addPackagesFromCollection();
    },

    setDisplayModeActiveState: function(mode) {
      switch (mode) {
        case PLAYER_LIST_VIEW_MODE.LIST:
          this.$('.js-tile-view').removeClass('active');
          this.$('.js-list-view').addClass('active');
          break;
        case PLAYER_LIST_VIEW_MODE.TILE:
          this.$('.js-tile-view').addClass('active');
          this.$('.js-list-view').removeClass('active');
          break;
      }
    },

    renderAsTiles: function(){
        this.viewMode = PLAYER_LIST_VIEW_MODE.TILE;
        playerSettings.set('layout',this.viewMode);
        playerSettings.save();
        this.setDisplayModeActiveState(this.viewMode);
        this.addPackagesFromCollection();
    },

    menuToggle: function (e) {
        e.preventDefault();
        this.$('#playerContentWrapper').toggleClass('active');
    },

    reloadPackageList: function () {
        /*var element = document.getElementById('scormPackageTable');
         if(element.requestFullScreen) {
         element.requestFullScreen();
         } else if(element.webkitRequestFullScreen ) {
         element.webkitRequestFullScreen();
         } else if(element.mozRequestFullScreen) {
         element.mozRequestFullScreen();
         }*/
        this.collection.fetch({reset: true});
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
      playerSettings.set('sort',this.$('#playerPackageOrder').val());
      playerSettings.set('showIn',this.$('#playerShowMode').val());
      playerSettings.save();
    },

    addPackage: function (pkg) {
        var view;
        switch (this.viewMode) {
            case PLAYER_LIST_VIEW_MODE.TILE:
                view = new PlayerPackageView({
                    model: pkg,
                    language: this.language,
                    template: '#playerTileItemView',
                    className: 'certificate-tile'
                });
                break;
            case PLAYER_LIST_VIEW_MODE.LIST:
            default :
                view = new PlayerPackageView({
                    model: pkg,
                    language: this.language,
                    template: '#playerListItemView',
                    className: 'certificate-list-item clearfix'
                });
                break;
        }
        this.listenTo(view, 'change-active', this.changeActive);
        this.listenTo(view, 'start', function (id) {
            this.trigger('start', id);
        });
        this.listenTo(view, 'resume', function (id) {
            this.trigger('resume', id);
        });
        this.childViews.push(view);
        this.$('.player.package-items').append(view.render().$el);
    },

    changeActive: function (view) {
        if (!this.activeEditing) {
            this.activePackageView = view;
        }
        this.$('tr[id!=' + this.activePackageView.model.id + ']').removeClass('SCORMHighlitedPackage');
    },

    addPackagesFromCollection: function () {
        _.forEach(this.childViews, function(e) {
            this.stopListening(e);
            e.remove();
        }, this);
        this.$('.player.package-items').empty();
        this.collection.each(this.addPackage, this);
    }
});
