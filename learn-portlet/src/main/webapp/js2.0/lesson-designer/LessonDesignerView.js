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
  template: jQueryValamis('#content-manager-template').html(),
  events: {
    'keyup .js-search-by-name': 'onFilterNameChanged',
    'change #lessonSort': 'onFilterSortChanged',
    'click .tileButton': 'setTileMode',
    'click .listButton': 'setListMode',
    'click .show-filter-button': function () {
      var searchPanel = this.$('.sidebar-wrapper');
      if (searchPanel.hasClass('show')) searchPanel.removeClass('show');
      else searchPanel.addClass('show');
    },
    'click .hide-filter': function () {
      this.$('.sidebar-wrapper').removeClass('show');
    },
    'click .js-create-lesson': function () {
        var model = new LessonModel();
        contentManagerEvent.trigger('modals:show:editLessonInfoView', model);
    }
  },
  showOrHidePaginator: function(){
    var paginatorTotalElements = this.model.attributes.paginatorModel.get('totalElements');

    if(paginatorTotalElements > this.model.attributes.paginatorModel.get('itemsOnPage')) {
      jQueryValamis('#paginatorWrapper').show();
      jQueryValamis('#bottomPaginatorWrapper').show();
      jQueryValamis('.item-view-picker').show();
    }
    else {
      jQueryValamis('#paginatorWrapper').hide();
      jQueryValamis('#bottomPaginatorWrapper').hide();
      jQueryValamis('.item-view-picker').show();
      if(paginatorTotalElements == 0)
        jQueryValamis('.item-view-picker').hide();
    }
  },
  initialize: function () {
    this.model = new ContentManagerModel();
    this.model.on("paginationAppearance", this.showOrHidePaginator, this);
    this.inputTimeout = null;

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
      el: jQueryValamis('.content-manager .js-lesson-collection-container')
    });

    if (jQueryValamis(window).width() <= RESOLUTION_THRESHOLDS[0]) {
      this.lessonCollectionView.setMode(ITEM_TEMPLATES_NAME.LIST);
    } else {
      if (quizSettings.get('layout') === ITEM_TEMPLATES_NAME.LIST) {
        this.setListMode();
      } else {
        this.setTileMode();
      }
    }
    var pageModel = this.model.get('paginatorModel');
    this.topValamisPaginator = new ValamisPaginator({el: jQueryValamis('.content-manager #paginatorWrapper'), model: pageModel, needDisplay: true, language: GLOBAL_translations});
    this.bottomValamisPaginator = new ValamisPaginator({el: jQueryValamis('.content-manager #bottomPaginatorWrapper'), model: pageModel, language: GLOBAL_translations});

    this.model.on('change', this.onModelChanged, this);
    this.model.get("lessonCollection").on('add', this.updateValamisPaginator, this);
  },

  updateValamisPaginator: function () {
    this.topValamisPaginator.updateItems(this.model.get("lessonCollection").length);
    this.bottomValamisPaginator.updateItems(this.model.get("lessonCollection").length);
  },
  setTileMode: function () {
    this.lessonCollectionView.setMode(ITEM_TEMPLATES_NAME.TILE);
    this.$('.tileButton').addClass('active');
    this.$('.listButton').removeClass('active');
    quizSettings.set('layout', ITEM_TEMPLATES_NAME.TILE);
    quizSettings.save();
  },
  setListMode: function () {
    this.lessonCollectionView.setMode(ITEM_TEMPLATES_NAME.LIST);
    this.$('.tileButton').removeClass('active');
    this.$('.listButton').addClass('active');
    quizSettings.set('layout', ITEM_TEMPLATES_NAME.LIST);
    quizSettings.save();
  },
  updateSettings: function () {
    quizSettings.set('sort', this.$('#lessonSort').val());
    quizSettings.save();
  },
  changeViewOnWindowResize: function () {
    if (jQueryValamis(window).width() < RESOLUTION_THRESHOLDS[0]) {
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
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilterName.bind(this), 800);
  },
    applyFilterName: function () {
        clearTimeout(this.inputTimeout);
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
    this.$el.html(Mustache.render(this.template, _.extend(GLOBAL_translations,window.permissionActionsLessonDesigner)));
    return this;
  },
  getLessonFilter: function () {
    var filter = '';
    if (this.$('.js-search-by-name').val() != undefined)
      filter = this.$('.js-search-by-name').val();
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
  template: _.template(Mustache.to_html(jQueryValamis('#modal-clear-template').html(), {header: GLOBAL_translations['uploadLabel']})),
  submitEl: '.bbm-button',
  cancelEl: '.modal-close',
  className: 'val-modal upload-modal',
  onRender: function () {
    var me = this;
    var fileUploaderUrl = '';
    if (!quizLogoData.supports()) {
      fileUploaderUrl = path.root + path.api.files + '?action=ADD&contentType=icon&folderId=' + this.model.get('folder');
    }
    var uploader = new FileUploader({ endpoint: fileUploaderUrl, message: GLOBAL_translations['uploadLogoMessage'] });
    if (quizLogoData.supports()) {
      uploader.on('fileuploadadd', function (data) {
        quizLogoData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'icon');
        quizLogoData.setSetting(IMAGE_PARAM_TYPE.FILE, data);

        quizLogoData.readAsDataURL(data, function (img) {
          me.model.set({ src: img });
          me.trigger('modal:close');
        });
      });
    }
    else {
      uploader.on('fileuploaddone', function (data) {
        var src = path.root + path.api.files + 'images?folderId=' + me.model.get('folder') + '&file=' + data.name + '&ts=' + Date.now();
        me.model.set({src: src, fileName: data.name});
        me.trigger('modal:close');
      });
    }

    this.$('.js-modal-content').append(uploader.render().$el);
  }
});

var GalleryModal = Backbone.Modal.extend({
  template: _.template(Mustache.to_html(jQueryValamis('#liferayGallery-modal-template').html(), GLOBAL_translations)),
  submitEl: '.bbm-button',
  cancelEl: '.modal-close',
    className: 'val-modal',
  onRender: function () {
    var me = this;
    this.$el.addClass('image-galley-container');

    var dialog = new GalleryContainer({
      language: GLOBAL_translations,
      folderID: me.model.get('folder'),
      saveToFileStorage: !quizLogoData.supports()
    });
    dialog.on('savedLogo', jQueryValamis.proxy(function (data) {
      if (quizLogoData.supports()) {
        quizLogoData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'document-library');
        quizLogoData.setSetting(IMAGE_PARAM_TYPE.FILE_ENTRY_ID, data.id);
        quizLogoData.setSetting(IMAGE_PARAM_TYPE.FILE, data.get('title'));
        quizLogoData.setSetting(IMAGE_PARAM_TYPE.FILE_VERSION, data.get('version'));

        me.model.set({fileName: data.get('title')});
      }
      // old browsers, save image immediately
      else {
        me.model.set({fileName: data.get('title')});
        me.model.set({logo: data.get('title')});
      }
      var src = "/documents/" + Utils.getCourseId() + "/" + data.get('folderId') + "/" + data.get('title') + "/?version=" + data.get('version') + "&imageThumbnail=1";
      me.model.set({src: src});
      me.trigger('modal:close');
    }, this), this);
    this.$('.lf-gallery-dialog').append(dialog.render().$el);
  }
});