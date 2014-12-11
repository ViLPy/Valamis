/**
 * Created by igorborisov on 27.05.14.
 */
PackageManager.module("PackagesApp.FileUpload", function (FileUpload, PackageManager, Backbone, Marionette, $, _) {

  FileUpload.Modal = Backbone.Modal.extend({
    template: function () {
      var mustacheAccumulator = {};
      if (this.model) {
        _.extend(mustacheAccumulator, this.model.toJSON());
      }
      _.extend(mustacheAccumulator, PackageManager.request("get:languageBank"));

      return  Mustache.to_html($('#package-manager-fileupload-modal-template').html(), mustacheAccumulator);
    },
    submitEl: '.bbm-button',
    cancelEl: '.modal-close',
    className: 'file-upload-modal',
    initialize: function (options) {
      this.endpointParams = options.endpointParams;
      this.postponeLoading = options.postponeLoading;
    },
    onRender: function () {
      var self = this;
      var fileUploaderUrl = path.root + path.api.files + "?" + $.param(self.endpointParams);

      if (this.postponeLoading && packageLogoData.supports()) {
        fileUploaderUrl = '';
      }
      var uploader = new FileUploader({ endpoint: fileUploaderUrl });

      if (this.postponeLoading && packageLogoData.supports()) {
        uploader.on('fileuploadadd', function (data) {
          packageLogoData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'icon');
          packageLogoData.setSetting(IMAGE_PARAM_TYPE.FILE, data);

          packageLogoData.readAsDataURL(data, function (img) {
            self.trigger("fileupload:done", {src: img});
          });
          self.close();
        });
      }
      else {
        uploader.on("fileuploaddone", function (result) {
          self.trigger("fileupload:done", result);
          self.close();
        });
      }

      self.$('.package-uploader-dialog').append(uploader.render().$el);
    }
  });
});