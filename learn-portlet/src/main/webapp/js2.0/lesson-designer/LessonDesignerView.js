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
    'keyup .search-by-name': 'onFilterNameChanged',
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
    'click .create-lesson': function () {
      var me = this;
      var model = new LessonModel();
      model.save().then(function () {
        contentManagerEvent.trigger('modals:show:editLessonInfoView', model);
        me.model.get('lessonCollection').add(model);
        contentManagerEvent.trigger('lesson:created', model.id);
      });
    }
  },
  initialize: function () {
    this.model = new ContentManagerModel();
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
      el: $('.content-manager .lesson-list-container')
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
    this.topValamisPaginator = new ValamisPaginator({el: $('.content-manager #paginatorWrapper'), model: pageModel, needDisplay: true, language: GLOBAL_translations});
    this.bottomValamisPaginator = new ValamisPaginator({el: $('.content-manager #bottomPaginatorWrapper'), model: pageModel, language: GLOBAL_translations});

    this.model.on('change', this.onModelChanged, this);
    this.model.get("lessonCollection").on('add', this.updateValamisPaginator, this);

    jQuery(window).on('resize', this.resize);
    valamisTileResize(this.$el);
  },

  resize: function () {
    valamisTileResize(contentManagerView.$el);
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
    var fileUploaderUrl = '';
    if (!quizLogoData.supports()) {
      fileUploaderUrl = path.root + path.api.files + '?action=ADD&contentType=icon&folderId=' + this.model.get('folder');
    }
    var uploader = new FileUploader({ endpoint: fileUploaderUrl });
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

    this.$('.content').append(uploader.render().$el);
  }
});

var GalleryModal = Backbone.Modal.extend({
  template: _.template(Mustache.to_html($('#liferayGallery-modal-template').html(), GLOBAL_translations)),
  submitEl: '.bbm-button',
  cancelEl: '.modal-close',
  onRender: function () {
    var me = this;
    this.$el.addClass('image-galley-container');

    var dialog = new GalleryContainer({
      language: GLOBAL_translations,
      folderID: me.model.get('folder'),
      saveToFileStorage: !quizLogoData.supports()
    });
    dialog.on('savedLogo', jQuery.proxy(function (data) {
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
      var src = "/documents/" + jQuery("#courseID").val() + "/0/" + data.get('title') + "/?version=" + data.get('version') + "&imageThumbnail=1";
      me.model.set({src: src});
      me.trigger('modal:close');
    }, this), this);
    this.$('.lf-gallery-dialog').append(dialog.render().$el);
  }
});