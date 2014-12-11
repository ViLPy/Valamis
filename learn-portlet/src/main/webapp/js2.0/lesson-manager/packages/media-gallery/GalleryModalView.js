PackageManager.module("PackagesApp.Gallery", function (Gallery, PackageManager, Backbone, Marionette, $, _) {

  Gallery.Modal = Backbone.Modal.extend({
    template: function () {
      var mustacheAccumulator = {};
      if (this.model) {
        _.extend(mustacheAccumulator, this.model.toJSON());
      }
      _.extend(mustacheAccumulator, PackageManager.request("get:languageBank"));

      return  Mustache.to_html($('#liferayGallery-modal-template').html(), mustacheAccumulator);
    },
    submitEl: '.bbm-button',
    cancelEl: '.modal-close',
    initialize: function (options) {
      this.folderID = options.folderID;
    },
    onRender: function () {
      var self = this;
      this.$el.addClass('image-galley-container');
      var gallery = new GalleryContainer({
        language: PackageManager.request("get:languageBank"),
        folderID: this.folderID,
        saveToFileStorage: !packageLogoData.supports()});
      gallery.on('savedLogo', jQuery.proxy(function (data) {
        // IE10+
        if (packageLogoData.supports()) {
          packageLogoData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'document-library');
          packageLogoData.setSetting(IMAGE_PARAM_TYPE.FILE_ENTRY_ID, data.id);
          packageLogoData.setSetting(IMAGE_PARAM_TYPE.FILE, data.get('title'));
          packageLogoData.setSetting(IMAGE_PARAM_TYPE.FILE_VERSION, data.get('version'));

          var src = "/documents/" + jQuery("#courseID").val() + "/0/" + data.get('title') + "/?version=" + data.get('version') + "&imageThumbnail=1";
          self.trigger("savedLogo:done", {src: src, fileName: data.get('fileName')});
        }
        // old browsers, save image immediately
        else {
          self.trigger("savedLogo:done", {fileName: data.get('title')});
        }
        self.close();
      }, this), this);

      self.$('.lf-gallery-dialog').append(gallery.render().$el);
    }
  });
});