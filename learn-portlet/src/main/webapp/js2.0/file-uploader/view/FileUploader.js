/**
 * Generic file uploader item view
 *
 * @constructor
 * @param {{template:String}} options - selector
 */
var FileUploaderItemView = Backbone.View.extend({
  initialize: function (options) {
    options = options || {};
    this.listenTo(this.model, 'change:progress', this.updateUploadProgress);
    this._modelBinder = new Backbone.ModelBinder();
    this.template = options.template || '#fileUploaderItem';
  },
  render: function () {
    this.$el.html(Mustache.render(jQuery(this.template).html(), this.model.toJSON()));
    this._modelBinder.bind(this.model, this.el);
    return this;
  },
  updateUploadProgress: function () {
    var progressPercents = this.model.get('progress') + '%';
    this.$('.progress-bar').css('width', progressPercents);
    this.$('.progress-bar').html(progressPercents);
  },
  hideInfo: function () {
    this.$('.info-block').hide();
    this.$('.progress-bar').html('');
  }
});

/**
 * File uploader, based on https://github.com/blueimp/jQuery-File-Upload (MIT License)
 *
 * @constructor
 * @param {{endpoint: String, itemView: Backbone.View}} options
 *    endpoint - where to upload files
 *    itemView - view to render for each uploading item
 * @fires itemDone on file uploading complete
 *
 * @event itemDone
 * @param {Object} result - response from server
 * @param {FileUploaderItemView} view - view of file item uploading process
 * @param {FileUploaderItemModel} model - model instance used for view
 */
var FileUploader = Backbone.View.extend({
  initialize: function (options) {
    options = options || {};
    this.fileUploadEndpoint = options.endpoint;
    this.itemViewClass = options.itemView || FileUploaderItemView;
    this.fileUploadAdditionalInfo = options.message || "";
    this.amount = 0;
    this.uploadsData = [];
  },
  render: function () {
    this.$el.html(Mustache.render(jQuery('#fileUploaderDropZone').html(), {
        fileUploadEndpoint: this.fileUploadEndpoint,
        fileUploadAdditionalInfo: this.fileUploadAdditionalInfo
    }));
    this.$('#fileupload').fileupload({
      dataType: 'json',
      dropZone: this.$('#dropzone')
    }).bind('fileuploaddone', jQuery.proxy(this.onDone, this)).
      bind('fileuploadprogress', jQuery.proxy(this.onProgress, this)).
      bind('fileuploadprogressall', jQuery.proxy(this.onProgressAll, this)).
      bind('fileuploadadd', jQuery.proxy(this.onAdd, this));

    // TODO: for testing with CORS on IE only, remove in production
    this.$('#fileupload').fileupload(
      'option',
      'redirect',
      window.location.href.replace(
        /\/[^\/]*$/,
        '/cors/result.html?%s'
      )
    );

    return this;
  },
  onAdd: function (e, data) {
    this.amount += 1;
    data.itemModel = new FileUploaderItemModel({
      filename: data.files[0].name
    });
    data.itemView = new this.itemViewClass({model: data.itemModel});
    this.$el.parent().append(data.itemView.render().$el);
    this.$('.dropzone-wrapper').hide();
    if (this.amount > 1) this.$('.progress').removeClass('hidden');

    this.trigger('fileuploadadd',  data.files[0]);
  },
  onDone: function (e, data) {
    data.itemView.hideInfo();

    data.result.filename = data.itemModel.get('filename');

    this.trigger('itemDone', data.result, data.itemView, data.itemModel);
    this.uploadsData.push(data.result);

    this.amount -= 1;
    if (this.amount === 0) {
      this.$('.progress').addClass('hidden');
      this.trigger('fileuploaddone', this.uploadsData.length === 1 ? this.uploadsData[0] : this.uploadsData);
    }
  },
  onProgress: function (e, data) {
    var progress = ~~(data.loaded / data.total * 100);
    var remaining = (data.total - data.loaded) * 8 / data.bitrate;
    data.itemModel.set({
      'progress': progress,
      'bitrate': this._formatBitrate(data.bitrate),
      'remaining': this._formatTime(remaining),
      'fileSize': this._formatFileSize(data.total),
      'uploadedBytes': this._formatFileSize(data.loaded)
    });
  },
  onProgressAll: function (e, data) {
    var progress = ~~(data.loaded / data.total * 100);
    this.updateOverallProgress(progress);
  },
  updateOverallProgress: function (value) {
    var percentage = value + '%';
    this.$('.progress-bar').css('width', percentage).html(percentage);
  },
  _formatTime: function (seconds) {
    var date = new Date(seconds * 1000),
      days = Math.floor(seconds / 86400);
    days = days ? days + 'd ' : '';
    return days +
      ('0' + date.getUTCHours()).slice(-2) + ':' +
      ('0' + date.getUTCMinutes()).slice(-2) + ':' +
      ('0' + date.getUTCSeconds()).slice(-2);
  },
  _formatFileSize: function (bytes) {
    if (typeof bytes !== 'number') {
      return '';
    }
    if (bytes >= 1000000000) {
      return (bytes / 1000000000).toFixed(2) + ' GB';
    }
    if (bytes >= 1000000) {
      return (bytes / 1000000).toFixed(2) + ' MB';
    }
    return (bytes / 1000).toFixed(2) + ' KB';
  },
  _formatBitrate: function (bits) {
    if (typeof bits !== 'number') {
      return '';
    }
    if (bits >= 1000000000) {
      return (bits / 1000000000).toFixed(2) + ' Gbit/s';
    }
    if (bits >= 1000000) {
      return (bits / 1000000).toFixed(2) + ' Mbit/s';
    }
    if (bits >= 1000) {
      return (bits / 1000).toFixed(2) + ' kbit/s';
    }
    return bits.toFixed(2) + ' bit/s';
  }
});