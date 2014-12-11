/**
 * Created by igorborisov on 27.05.14.
 */
PackageManager.module("PackagesApp.FileUpload", function (FileUpload, PackageManager, Backbone, Marionette, $, _) {

  FileUpload.ButtonView = ValamisItemView.extend({
    tagName: 'div',
    template: '#packageManagerFileUploader',
    events: {
        "click button.js-file-upload": "uploadPackage"
    },
    uploadPackage: function () {
      this.trigger("fileupload:show:modal");
    }
  });

});

