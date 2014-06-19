var ITEM_TEMPLATES_NAME = {
  LIST: 'LIST',
  TILE: 'TILE',
  COMMAND: 'COMMAND'
};

var RESOLUTION_THRESHOLDS = {
  0: 768,
  1: 992,
  2: 1200
};

var ContentManager = Backbone.View.extend({
  template: $('#content-manager-template').html(),
  events: {
    'change .search-by-name': 'onFilterNameChanged',
    'change #lessonSort': 'onFilterSortChanged',
    'click .tileButton': 'setTileMode',
    'click .listButton': 'setListMode',
    'click .show-filter-button': function () {
      var searchPanel = this.$('.sidebar-wrapper');       // was .filter-panel
      if (searchPanel.hasClass('show')) searchPanel.removeClass('show');
      else searchPanel.addClass('show');
    },
    'click .hide-filter': function () {
      this.$('.sidebar-wrapper').removeClass('show');    // was .filter-panel
    },
    'click .create-lesson': function () {
      var me = this;
      var model = new LessonModel();
      model.save().then(function () {
        contentManagerEvent.trigger('modals:show:editLessonInfoView', model);
        me.model.get('lessonCollection').add(model);
      });
    }
  },
  initialize: function () {
    this.model = new ContentManagerModel();

    $(window).on('resize', _.bind(this.changeViewOnWindowResize, this));
    this.render();
    if (quizSettings.get('sort')) this.$('#lessonSort').val(quizSettings.get('sort'));

    var order = this.getLessonOrder();
    this.model.set({
      filter: this.getLessonFilter(),
      sortBy: order.split(':')[0],
      isSortDirectionAsc: order.split(':')[1]
    });

    this.model.fetch();

    this.lessonCollectionView = new LessonCollectionView({
      collection: this.model.get('lessonCollection'),
      el: $('.content-manager .lesson-list')
    });

    if ($(window).width() <= RESOLUTION_THRESHOLDS[0]) {
      this.lessonCollectionView.setMode(ITEM_TEMPLATES_NAME.LIST);
    } else {
      if (quizSettings.get('layout') === ITEM_TEMPLATES_NAME.LIST) {
        this.setListMode();
      } else {
        this.setTileMode();
      }
    }
    var pageModel = this.model.get('paginatorModel');
    new ValamisPaginator({el: $('.content-manager .paginator'), model: pageModel, language: GLOBAL_translations});
    new ValamisPaginator({el: $('.content-manager .bottom-paginator'), model: pageModel, language: GLOBAL_translations});

    this.model.on('change', this.onModelChanged, this);
  },
  setTileMode: function() {
    this.lessonCollectionView.setMode(ITEM_TEMPLATES_NAME.TILE);
    this.$('.tileButton').addClass('active');
    this.$('.listButton').removeClass('active');
    quizSettings.set('layout',ITEM_TEMPLATES_NAME.TILE);
    quizSettings.save();
  },
  setListMode: function() {
    this.lessonCollectionView.setMode(ITEM_TEMPLATES_NAME.LIST);
    this.$('.tileButton').removeClass('active');
    this.$('.listButton').addClass('active');
    quizSettings.set('layout',ITEM_TEMPLATES_NAME.LIST);
    quizSettings.save();
  },
  updateSettings: function() {
    quizSettings.set('sort',this.$('#lessonSort').val());
    quizSettings.save();
  },
  changeViewOnWindowResize: function () {
    if ($(window).width() < RESOLUTION_THRESHOLDS[0]) {
      if (typeof(this.previousViewType) === 'undefined') {
        this.previousViewType = this.lessonCollectionView.getViewType();
        this.lessonCollectionView.setMode(ITEM_TEMPLATES_NAME.LIST);
      } else {
        return;
      }
    } else {
      if (typeof(this.previousViewType) !== 'undefined') {
        this.lessonCollectionView.setMode(this.previousViewType);
        delete(this.previousViewType);
      }
    }
  },
  onFilterNameChanged: function () {
    this.model.set({filter: this.getLessonFilter()});
    this.model.get('paginatorModel').set('currentPage', 1);
    this.model.fetch();
  },
  onFilterSortChanged: function () {
    var order = this.getLessonOrder();
    this.model.set({sortBy: order.split(':')[0], isSortDirectionAsc: order.split(':')[1]});
    this.model.set();
    this.model.fetch();
    this.updateSettings();
  },
  render: function () {
    this.$el.html(Mustache.render(this.template, GLOBAL_translations));
    return this;
  },
  getLessonFilter: function () {
    var filter = '';
    if (this.$('.search-by-name').val() != undefined)
      filter = this.$('.search-by-name').val();
    return filter;
  },
  getLessonOrder: function () {
    var order = 'TITLE:true';
    if (this.$('#lessonSort').val() != undefined)
      order = this.$('#lessonSort').val();
    return order;
  }
});

var UploadLessonLogoModel = Backbone.Model.extend({
  defaults: { src: '' }
});

var UploadLessonLogoModal = Backbone.Modal.extend({
  template: _.template(Mustache.to_html($('#modal-clear-template').html(), {header: GLOBAL_translations['uploadLabel']})),
  submitEl: '.bbm-button',
  cancelEl: '.modal-close',
  className: 'upload-modal',
  onRender: function () {
    var me = this;
    var uploader = new FileUploader({
      endpoint: '/learn-portlet/api/files?action=ADD&contentType=icon&folderId=' + this.model.get('folder')
    });

    uploader.on('fileuploaddone', function (data) {
      var src = '/learn-portlet/api/files/images?folderId=' + me.model.get('folder') + '&file=' + data.name + '&ts=' + Date.now();
      me.model.set({src: src, fileName: data.name});
      me.trigger('modal:close');
    });

    this.$('.content').append(uploader.render().$el);
  }
});