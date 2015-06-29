LiferayImageModel = Backbone.Model.extend({
  defaults: {
    title: '',
    version: ''
  }
});

LiferayImageGalleryService = new Backbone.Service({ url: path.root,
  sync: {
    'read': {
      path: path.api.liferay,
      'data': function (collection, options) {
        return {
          action: 'GETIMAGES',
          courseId: Utils.getCourseId(),
          filter: options.filter,
          sortAscDirection: options.sort,
          page: options.currentPage,
          count: options.itemsOnPage
        }
      },
      'method': 'get'
    }
  },
  targets: {
    'saveToFileStorage': {
      path: path.api.files,
      'data': function (model, options) {
        return {
            action: 'ADD',
            courseId: Utils.getCourseId(),
            contentType: "document-library",
            folderId:  options.folderID,
            fileEntryID: options.fileID,
            file: options.fileName,
            fileVersion: options.version
        }
    },
      method: 'post'
    }
  }
});

LiferayGallery = Backbone.Collection.extend({
  model: LiferayImageModel,
  parse: function (response) {
    this.trigger('galleryCollection:updated', { total: response.total, currentPage: response.currentPage, listed: response.records.length });
    return response.records;
  }
}).extend(LiferayImageGalleryService);


LiferayGalleryElement = Backbone.View.extend({
  events: {
    'click': 'addThis'
  },
  initialize: function () {
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferayGalleryElementView').html(), {
      title: this.model.get('title'),
      imageUrl: '/documents/' + Utils.getCourseId() + '/' + this.model.get('folderId') + '/' + this.model.get('title') + '/?version=' + this.model.get('version') + '&imageThumbnail=1'});
    this.$el.html(template);
    return this;
  },
  addThis: function () {
    this.model.trigger('select', this.model);
  }
});

var GalleryContainer = Backbone.View.extend({
  SEARCH_TIMEOUT: 800,
  events: {
    'keyup #gallerySearch': 'filterGallery',
    'click .dropdown-menu > li': 'filterGallery'
  },
  initialize: function (options) {
    this.language = options.language;
    this.folderID = options.folderID;
    this.saveToFileStorage = options.saveToFileStorage;

    this.collection = new LiferayGallery();
    this.collection.on('select', this.pickUp, this);
    this.collection.on('reset', this.renderGallery, this);
    var that = this;
    this.collection.on('galleryCollection:updated', function (details) {
      that.updatePagination(details, that);
    });
    this.paginatorModel = new PageModel();
    this.paginatorModel.set({'itemsOnPage': 12});
    this.render();    // TODO: causes that view renders twice
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferayImageGalleryDialogView').html(), this.language);
    this.$el.html(template);
    this.$el.find('.dropdown').valamisDropDown();

    var that = this;
    this.paginator = new ValamisPaginator({
      el: this.$el.find("#galleryPaginator"),
      language: this.language,
      model: this.paginatorModel
    });
    this.paginator.on('pageChanged', function () {
      that.fetchGallery();
    });
    this.paginatorShowing = new ValamisPaginatorShowing({
      el: this.$el.find("#galeryPagingShowing"),
      language: this.language,
      model: this.paginator.model
    });

    this.fetchFirstPage();
    return this;
  },

  filterGallery: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), this.SEARCH_TIMEOUT);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);
    this.fetchFirstPage();
  },

  addImage: function (item) {
    var view = new LiferayGalleryElement({ model: item });
    this.$('.gallery-modal-container').append(view.render().$el);
  },
  renderGallery: function () {
    this.$('.gallery-modal-container').html('');
    this.collection.each(this.addImage, this);
    return this;
  },
  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
  },

  fetchFirstPage: function () {
    this.fetchGalleryCollection(1);
  },
  fetchGallery: function () {
    this.fetchGalleryCollection(this.paginator.currentPage());
  },
  fetchGalleryCollection: function (page) {
    this.collection.fetch({
      reset: true,
      currentPage: page,
      itemsOnPage: this.paginator.itemsOnPage(),
      filter: this.$('#gallerySearch').val(),
      sort: this.$('#sortGallery').data('value')
    });
  },

  pickUp: function (model) {
    var that = this;
    if (this.saveToFileStorage && model.get('id') != undefined) {
      this.collection.saveToFileStorage({}, {
        fileID: model.get('id'),
        fileName: model.get('title'),
        version: model.get('version'),
        folderID: this.folderID}).then(function (res) {
        that.trigger('savedLogo', model);
        toastr.success(that.language['overlayCompleteMessageLabel']);
      }, function (err, res) {
        toastr.error(that.language['overlayFailedMessageLabel']);
      });
    }
    else that.trigger('savedLogo', model);
  }

});
