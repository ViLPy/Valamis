LiferayImageModel = Backbone.Model.extend({
  defaults: {
    title: '',
    version: ''
  }
});

LiferayImageGalleryService = new Backbone.Service({ url: path.root,
  sync: {
    'read': function (collection, options) {
      var filter = '';
      if (jQuery('#gallerySearch').val() != undefined)
        filter = jQuery('#gallerySearch').val();
      var sort = 'true';
      if (jQuery('#sortGallery').val() != undefined)
        sort = jQuery('#sortGallery').val();

      return path.api.liferay + '?action=GETIMAGES&groupID=' + jQuery('#courseID').val() +
        '&filter=' + filter +
        '&sortAscDirection=' + sort +
        '&page=' + options.currentPage +
        '&count=' + options.itemsOnPage;
    }
  },
  targets: {
    'saveToFileStorage': {
      'path': function (model, options) {
        return path.api.files + '?action=ADD&contentType=document-library&folderId=' + options.folderID +
          '&fileEntryID=' + options.fileID + '&file=' + options.fileName + '&fileVersion=' + options.version;
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
    this.$el = jQuery('<div>');
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferayGalleryElementView').html(), {
      title: this.model.get('title'),
      imageUrl: '/documents/' + jQuery('#courseID').val() + '/0/' + this.model.get('title') + '/?version=' + this.model.get('version') + '&imageThumbnail=1'});
    this.$el.html(template);
    return this;
  },
  addThis: function () {
    this.model.trigger('select', this.model);
  }
});

// Dialog

GalleryView = Backbone.View.extend({
  events: {
  },
  callback: function (certId, title) {
  },
  initialize: function (options) {
    this.saveToFileStorage = options.saveToFileStorage;
    this.language = options.language;
    this.folderID = options.folderID;
    this.collection = new LiferayGallery();
    this.collection.on('select', this.pickUp, this);
    this.collection.on('reset', this.renderGallery, this);
    var that = this;
    this.collection.on('galleryCollection:updated', function (details) {
      that.updatePagination(details, that);
    });

    this.render();
  },

  addImage: function (item) {
    var view = new LiferayGalleryElement({ model: item });
    this.$('#gallery').append(view.render().$el);
  },
  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
    jQuery('#imagesListedAmount').text(details.listed);
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferayGalleryDialogView').html());
    this.$el.html(template);

    var that = this;
    this.paginator = new ValamisPaginator({el: this.$('#galleryPaginator'), language: this.language});
    this.paginator.on('pageChanged', function () {
      that.fetchGallery();
    });
  },
  fetchFirstPage: function () {
    this.fetchGalleryCollection(1);
  },
  fetchGallery: function () {
    this.fetchGalleryCollection(this.paginator.currentPage());
  },
  fetchGalleryCollection: function (page) {
    this.collection.fetch({reset: true, currentPage: page, itemsOnPage: this.paginator.itemsOnPage()});
  },
  renderGallery: function () {
    jQuery('#gallery').html('');
    this.collection.each(this.addImage, this);
    return this;
  },

  pickUp: function (model) {
    var that = this;
    if (this.saveToFileStorage) {
      this.collection.saveToFileStorage({}, {
        fileID: model.id,
        fileName: model.get('title'),
        version: model.get('version'),
        folderID: this.folderID}).then(function (res) {
        that.trigger('savedLogo', model);
        toastr.success(that.language['overlayCompleteMessageLabel']);
      }, function (err, res) {
        toastr.error(that.language['overlayFailedMessageLabel']);
      });
    }
    else  that.trigger('savedLogo', model);

  }
});


var GalleryContainer = Backbone.View.extend({
  events: {
    'keyup #gallerySearch': 'filterGallery',
    'change #sortGallery': 'filterGallery',
    'click .menu-close': 'searchMenuToggle',
    'click .menu-open': 'searchMenuToggle'
  },
  initialize: function (options) {
    this.language = options.language;
    this.folderID = options.folderID;
    this.saveToFileStorage = options.saveToFileStorage;
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferayImageGalleryDialogView').html(), this.language);
    this.$el.html(template);

    this.listView = new GalleryView({
      el: this.$('#galleryContainer'),
      folderID: this.folderID,
      language: this.language,
      saveToFileStorage: this.saveToFileStorage });
    this.listView.on('savedLogo', this.trigSaveLogo, this);

    this.fetchGallery();
    return this;
  },
  fetchGallery: function () {
    this.listView.fetchFirstPage();
  },
  searchMenuToggle: function (e) {
    e.preventDefault();
    jQuery('#liferayGalleryWrapper').toggleClass('active');
  },
  trigCloseModal: function (model) {
    this.trigger('closeModal', this);
  },
  trigSaveLogo: function (model) {
    this.trigger('savedLogo', model);
  },

  filterGallery: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);
    this.fetchGallery();
  }

});
