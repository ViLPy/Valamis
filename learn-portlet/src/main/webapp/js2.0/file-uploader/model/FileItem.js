var FileUploaderItemModel = Backbone.Model.extend({
  defaults: {
    filename: '',
    progress: 0,
    bitrate: '',
    remaining: '',
    fileSize: 0,
    uploadedBytes: 0
  }
});