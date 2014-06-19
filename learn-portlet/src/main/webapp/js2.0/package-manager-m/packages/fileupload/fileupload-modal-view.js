/**
 * Created by igorborisov on 27.05.14.
 */
PackageManager.module("PackagesApp.FileUpload", function(FileUpload, PackageManager,
                                                          Backbone, Marionette, $, _){

    FileUpload.Modal = Backbone.Modal.extend({
        template: function() {
            var mustacheAccumulator = {};
            if (this.model) {
                _.extend(mustacheAccumulator, this.model.toJSON());
            }
            _.extend(mustacheAccumulator, PackageManager.request("get:languageBank"));

            return  Mustache.to_html($('#package-manager-fileupload-modal-template').html(), mustacheAccumulator);
            //return _.template($('#package-manager-fileupload-modal-template').html());
        },
        submitEl: '.bbm-button',
        cancelEl: '.modal-close',
        className: 'file-upload-modal',
        initialize: function(options){
            this.endpointParams = options.endpointParams;
        },
        onRender: function()
        {
           var self = this;

            var endpoint = Utils.getContextPath() + 'api/files?' + $.param(self.endpointParams);
            var uploader = new FileUploader({ endpoint: endpoint });

            uploader.on("fileuploaddone", function(result){
                self.trigger("fileupload:done", result);
                self.close();
            });

            self.$('.package-uploader-dialog').append(uploader.render().$el);
        }
    });
});