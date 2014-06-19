/**
 * Created by igorborisov on 27.05.14.
 */
PackageManager.module("PackagesApp.FileUpload", function(FileUpload, PackageManager,
                                                          Backbone, Marionette, $, _){

    FileUpload.Controller = {
        fileUploadView : function(){
            var fileuploadView = new FileUpload.ButtonView({});

              fileuploadView.on("fileupload:show:modal", function(){
                //TODO add endpoin here as option
                  var fileUploadModal = new FileUpload.Modal();

                  PackageManager.request("package:show:modal", fileUploadModal);
              });


        }
    }
});
