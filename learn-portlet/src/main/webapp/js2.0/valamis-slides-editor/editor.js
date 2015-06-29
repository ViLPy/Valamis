window.isEditorReady = false;
window.isEditorIframeLoaded = false;
window.editorMode = 'edit';

jQueryValamis(window).resize(function() {
    var windowHeight = jQueryValamis(window).height(),
        windowWidth = jQueryValamis(window).width();

    jQueryValamis('.js-slides-editor-topbar').css({
        'width': windowWidth + 'px'
    });
    jQueryValamis('.js-slideset-editor').css({
        'width': windowWidth + 'px',
        'height': windowHeight + 'px'
    });

    if(windowHeight > 720) {
        jQueryValamis('.js-editor-wrapper').css({
            'height': windowHeight + 'px'
        });
        jQueryValamis('.js-slideset-iframe').css({
            'height': (windowHeight - jQueryValamis('.js-slides-editor-topbar').height()) + 'px'
        });
    }
    if(windowWidth > 1200) {
        jQueryValamis('.js-editor-wrapper').css({
            'width': windowWidth + 'px'
        });
    }
    if(window.isEditorReady) {
        jQueryValamis('.js-slideset-iframe')[0].contentWindow.placeSlideControls(windowWidth, windowHeight);
    }
});

var SlideEditorModel = Backbone.Model.extend({
    initialize: function() {
        this.searchModel = new SlideSearchModel();
        this.slideSetCollection = null;
        this.paginationModel = new PageModel();

        this.searchModel.on("change",this.searchModelChange,this);
        this.paginationModel.on("change:currentPage",this.fetch,this);
        this.paginationModel.on("change:itemsOnPage",this.fetch,this);
        slidesConfig.eventAggregator.on('fetchRequired', this.fetch, this);
    },
    parse: function(response) {
        this.slideSetCollection = new SlideSetCollection(response.records);
        this.paginationModel.set('totalElements',response.total);
    },
    searchModelChange: function() {
        if(this.paginationModel.get("currentPage") == 1 ) this.fetch();
        else this.paginationModel.set("currentPage", 1);
    }
}).extend(SlideSetService);

var PLAYER_LIST_VIEW_MODE = {
    LIST: 'list',
    TILE: 'tile'
};

var SlideEditorView = Backbone.View.extend({
    events: {
        'click .js-create-slideset': 'createSlideset',
        'click .close-slideset': 'returnToOverview',
        'keyup #slidesetFilter': 'filterPackages',
        'click #slidesetOrder > .dropdown-menu > li': 'filterPackages',
        'click #slidesetCategories > .dropdown-menu > li': 'filterPackages',
        'click .js-list-view': 'renderAsList',
        'click .js-tile-view': 'renderAsTiles',
        'click .js-slides-editor-topbar .mode-switcher > .button-group > .slides-dark': function(e) {
            var btn = jQueryValamis(e.target).closest('button');
            if(btn.hasClass('js-editor-edit-mode'))
                window.editorMode = 'edit';
            else if(btn.hasClass('js-editor-arrange-mode'))
                window.editorMode = 'arrange';
            else if(btn.hasClass('js-editor-preview-mode'))
                window.editorMode = 'preview';
            slidesConfig.eventAggregator.trigger('switch-editor-mode', window.editorMode);
        },
        'click .js-undo': 'triggerUndoAction',
        'click .slides-editor-save': 'saveSlidesetWithoutClosing'
    },
    template: null,
    id: 'js-slideset',
    getTemplate: function() {
        if(!this.template) this.template = jQueryValamis('#slide-editor').html();
        return this.template;
    },
    initialize: function() {
        if (slideEditorSettings.get('layout') === PLAYER_LIST_VIEW_MODE.LIST) {
            this.viewMode = PLAYER_LIST_VIEW_MODE.LIST;
        } else {
            this.viewMode = PLAYER_LIST_VIEW_MODE.TILE;
        }

        this.$el.html(Mustache.render(this.getTemplate(), slidesConfig.translations));
        this.collectionContainer = this.$(".js-slideset-items");

        this.searchView = new SlideSearchView({model: this.model.searchModel});
        this.$(".js-search-container").html(this.searchView.render().$el);

        this.paginationView = new ValamisPaginator({model: this.model.paginationModel, language: slidesConfig.translations});
        this.$(".js-pagination-container").html(this.paginationView.render().$el);

        this.paginationShowingView = new ValamisPaginatorShowing({model: this.model.paginationModel, language: slidesConfig.translations});
        this.$(".js-pagination-container-showing").html(this.paginationShowingView.render().$el);

        this.slideModalsLayout = new SlideModalsLayout();
        this.$('.js-slide-modal-container').html(this.slideModalsLayout.render().el);

        slidesConfig.eventAggregator.on('compose-slideset', this.composeSlideset, this);
        slidesConfig.eventAggregator.on('edit-slideset', this.editSlideset, this);
        slidesConfig.eventAggregator.on('publish-slideset', this.publishSlideset, this);
        slidesConfig.eventAggregator.on('switch-editor-mode', this.switchEditorMode, this);
        slidesConfig.eventAggregator.on('load-gapi-picker', this.loadGAPIPicker, this);
        slidesConfig.eventAggregator.on('editor-iframe-loaded', function() {
            window.isEditorIframeLoaded = true;
        });

        this.setDisplayModeActiveState(this.viewMode);
        if (slideEditorSettings.get('sort')) this.$('#slidesetOrder').val(slideEditorSettings.get('sort'));
        this.changeViewOnWindowResize();

        slidesConfig.eventAggregator.on('slideset-saved-close', this.closeEditor, this);

        var self = this;
        slidesConfig.eventAggregator.on('editor-ready', function (slideSetModel) {
            setTimeout(function () {
                window.isEditorReady = true;
                self.$('.js-slideset-items').hide();
                self.$('.filters-row').hide();
                self.$('.js-slideset-editor').css('visibility', 'visible');
                self.$('.js-slideset-editor').css({
                    width: window.innerWidth + 'px',
                    height: window.innerHeight + 'px'
                });
                self.$('.js-editor-wrapper').css({
                    height: (window.innerHeight - self.$('.js-slides-editor-topbar').height()) + 'px'
                });
                self.$('.js-slideset-iframe').css({
                    'height': (jQueryValamis(window).innerHeight - self.$('.js-slides-editor-topbar').height()) + 'px'
                });

                self.$('.js-presentation-title').html((slideSetModel || slidesApp.slideSetModel).get('title'));

                slidesApp.execute('controls:place');

                toastr.clear();
            }, 0);
            window.slidesConfig.eventAggregator.trigger('switch-editor-mode', 'edit', true);
        });
    },
    composeSlideset: function(slideSetModel) {
        setTimeout(function () {
            toastr.info(slidesConfig.translations['slideSetLoadingLabel'], { 'timeOut': '60000' });
        }, 0);
        jQueryValamis('.js-slideset-iframe').attr('src', '/learn-portlet/valamis-edit-slideset.html');
        onEditorIframeLoaded();
        function onEditorIframeLoaded() {
            if (window.isEditorIframeLoaded) {
                setTimeout(function () {
                    window.slidesApp = jQueryValamis('.js-slideset-iframe')[0].contentWindow.slidesApp;

                    jQueryValamis('.js-slideset-iframe')[0].contentWindow.postMessage({ action: 'renderSlideSet', modelJSON: slideSetModel.toJSON() }, document.location.origin);
                }, 500);
            }
            else
                setTimeout(onEditorIframeLoaded, 500);
        }
    },
    publishSlideset: function(slideSetModel) {
        toastr.info(slidesConfig.translations['publishProcessingLabel']);
        slideSetModel.publish().then(function(){ toastr.success(slidesConfig.translations['presentationSuccessfullyPublishedLabel']); });
    },
    returnToOverview: function() {
        if(!slidesApp.isSaved) {
            var self = this;
            var confirmView = new SaveConfirmationView({language: slidesConfig.translations});
            confirmView.on('saveConfirmed', function() {
                self.triggerSaveSlideset({close: true});
            }, this);
            confirmView.on('saveDeclined', function () {
                self.closeEditor();
            }, this);

            toastr.info(confirmView.render().$el, slidesConfig.translations['changesDetectedLabel'],
                {
                    'positionClass': 'toast-center',
                    'timeOut': '0',
                    'showDuration': '0',
                    'hideDuration': '0',
                    'extendedTimeOut': '0'
                }
            );
        }
        else
            this.closeEditor();
    },
    closeEditor: function() {
        this.model.fetch();
        slidesApp.execute('app:stop');
        this.$('.js-slideset-items').show();
        this.$('.filters-row').show();
        this.$('.js-slideset-editor').css({
            width: '',
            height: ''
        });
    },
    changeViewOnWindowResize: function () {
        if (jQueryValamis(window).width() < 768) { // mobile
            this.renderAsTiles(null, true);
        }
    },
    render: function() {
        var deferred = jQueryValamis.Deferred();
        var self = this;
        this.collectionContainer.html('');
        _.each(this.model.slideSetCollection.models, function(model, index) {
            self.addOneSlide(model);
            if(index == self.model.slideSetCollection.models.length - 1)
                deferred.resolve();
        }, this);

        this.$el.find('.dropdown').valamisDropDown();
        return deferred.promise();
    },
    addOneSlide: function(model){
        var slideSetView = new SlideSetView({model: model, className: 'tile s-12 m-4 l-2'});
        this.collectionContainer.append(slideSetView.render().$el);
    },
    createSlideset: function() {
        var slideSetModel = new SlideSetModel();
        var slideSetEditModal = new SlideSetEditModal({slideSetModel: slideSetModel, action: 'create'});
        slideSetEditModal.on('showUploadLogoModal', this.showUploadLogoDialog, this);
        slideSetEditModal.on('showMediaGallery', this.showMediaGallery, this);
        this.slideModalsLayout.modals.show(slideSetEditModal);
    },
    editSlideset: function(model) {
        var slideSetEditModal = new SlideSetEditModal({slideSetModel: model, action: 'edit'});
        slideSetEditModal.on('showUploadLogoModal', this.showUploadLogoDialog, this);
        slideSetEditModal.on('showMediaGallery', this.showMediaGallery, this);
        this.slideModalsLayout.modals.show(slideSetEditModal);
    },
    showUploadLogoDialog: function(model){
        var imageUploaderModel = new ImageUploader.Model();
        imageUploaderModel.on('onloadend',function(src){ model.trigger('logo-uploaded',src) });
        imageUploaderModel.on('change:file',function(fileModel){
          model.set('logo-file', fileModel.get('file'));
          model.set('logo-file-type', 'icon');
        });
        imageUploaderModel.set('fileUploadAdditionalInfo', slidesConfig.translations['uploadLogoMessage']);
        var uploadSlideLogoModal = new ImageUploader.Modal({
            imageUploaderModel: imageUploaderModel,
            headerLabel: slidesConfig.translations['uploadLabel']
        });
        this.slideModalsLayout.modals.show(uploadSlideLogoModal);
    },
    showMediaGallery: function(model) {
        var mediaGalleryModal = new GalleryModal(model);
        this.slideModalsLayout.modals.show(mediaGalleryModal);
    },
    setDisplayModeActiveState: function(mode) {
        switch (mode) {
            case PLAYER_LIST_VIEW_MODE.LIST:
                this.$('.js-tile-view').removeClass('active');
                this.$('.js-list-view').addClass('active');
                this.$('.js-slideset-items').removeClass('tiles');
                this.$('.js-slideset-items').addClass('list');
                break;
            case PLAYER_LIST_VIEW_MODE.TILE:
                this.$('.js-tile-view').addClass('active');
                this.$('.js-list-view').removeClass('active');
                this.$('.js-slideset-items').removeClass('list');
                this.$('.js-slideset-items').addClass('tiles');
                break;
        }
        jQueryValamis(window).trigger('viewModeChanged', this.$el);
    },
    renderAsTiles: function(e, silent) {
        this.viewMode = PLAYER_LIST_VIEW_MODE.TILE;
        if (!silent) {
            slideEditorSettings.set('layout',this.viewMode);
            slideEditorSettings.save();
        }
        this.setDisplayModeActiveState(this.viewMode);
    },
    renderAsList: function() {
        this.viewMode = PLAYER_LIST_VIEW_MODE.LIST;
        slideEditorSettings.set('layout',this.viewMode);
        slideEditorSettings.save();
        this.setDisplayModeActiveState(this.viewMode);
    },
    reloadSlidesetList: function () {
        this.model.fetch({
            reset: true/*,
            currentPage: this.paginatorModel.get('currentPage'),
            itemsOnPage: this.paginatorModel.get('itemsOnPage')*/
        });
    },
    filterPackages: function () {
        clearTimeout(this.inputTimeout);
        this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
    },
    applyFilter: function () {
        clearTimeout(this.inputTimeout);
        this.updateSettings();
        this.reloadSlidesetList();
    },

    updateSettings: function() {
        var order = this.$el.find('#slidesetOrder').data('value');
        var sortTitleAsc = order.split(':')[1];
        this.model.searchModel.set("title", this.$('#slidesetFilter').val());
        this.model.searchModel.set('sortAscDirection', sortTitleAsc);
        slideEditorSettings.save();
    },
    switchEditorMode: function(mode, isInitialLaunch) {
        if(!isInitialLaunch)
            slidesConfig.eventAggregator.trigger('switch-mode', mode);
    },
    triggerUndoAction: function() {
        this.$('.js-slideset-iframe')[0].contentWindow.undoAction();
    },
    saveSlidesetWithoutClosing: function() {
        this.triggerSaveSlideset({close: false});
    },
    triggerSaveSlideset: function(options) {
        slidesConfig.eventAggregator.trigger('save-slideset', {close: options.close});
    },
    loadGAPIPicker: function() {
        loadPicker();
    }
});

var GalleryModal = Backbone.Modal.extend({
  template: function (data) {
    return Mustache.to_html(jQueryValamis('#liferayGallery-modal-template').html(), {galleryLabel: slidesConfig.translations['galleryLabel']})
  },
  submitEl: '.bbm-button',
  cancelEl: '.modal-close',
  className: 'val-modal',
  initialize: function(model) {
    this.slideSetModel = model;
  },
  onRender: function () {
    var dialog = new GalleryContainer({
      language: slidesConfig.translations,
      folderID: "slideset_logo_" + this.slideSetModel.get('id'),
      saveToFileStorage: !slidesConfig.formDataHelper.supports()
});
    var that = this;
    dialog.on('savedLogo', jQueryValamis.proxy(function (data) {

      // IE10+
      if (slidesConfig.formDataHelper.supports()) {
        slidesConfig.formDataHelper.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'document-library');
        slidesConfig.formDataHelper.setSetting(IMAGE_PARAM_TYPE.FILE_ENTRY_ID, data.id);
        slidesConfig.formDataHelper.setSetting(IMAGE_PARAM_TYPE.FILE, data.get('title'));
        slidesConfig.formDataHelper.setSetting(IMAGE_PARAM_TYPE.FILE_VERSION, data.get('version'));

        slidesConfig.formDataHelper.setSetting(IMAGE_PARAM_TYPE.FILE_NAME, data.get('title'));

        this.slideSetModel.set('logo-file', {'name': data.get('title')});
        this.slideSetModel.set('logo-file-type', 'document-library');
      }
      else {
        this.slideSetModel.set({logo: data.get('title')}).save();
      }

      var src = "/documents/" + Utils.getCourseId() + "/" + data.get('folderId') + "/" + data.get('title') + "/?version=" + data.get('version') + "&imageThumbnail=1";
      that.slideSetModel.trigger('logo-uploaded',src);
      this.triggerCancel();
    }, this), this);
    dialog.on('closeModal', jQueryValamis.proxy(function () {
      this.triggerCancel();
    }, this), this);
    this.$('.lf-gallery-dialog').append(dialog.render().$el);
  }
});
