if(!('$' in window)) throw new Error('$ is not defined');
if(!('_' in window)) throw new Error('_ is not defined');
if(!('Backbone' in window && 'Model' in window.Backbone && 'View' in window.Backbone && 'Modal' in window.Backbone)) throw new Error('Backbone View/Model/Modal is not defined');
if(!('Mustache' in window)) throw new Error('Mustache is not defined');
if(jQueryValamis('#modal-clear-template').length > 1) throw new Error('There should exist only one #modal-clear-template');
if(jQueryValamis('#fileUploaderDropZone').length > 1) throw new Error('There should exist only one #fileUploaderDropZone');

/*
  Description:
    The intent is to defer image upload to server, while show it to user immediately.

  Usage:
    var imageUploaderModel = new ImageUploader.Model();
    this.imageUploaderModel.on('onloadend',function(src){ doWhateverYouWantWithSrc(SRC) },this);
    this.imageUploaderModel.on('change:file',function(model){ doWhateverYouWantWithModel(model) }, this);

    var imageUploaderView = new ImageUploader.View({model: this.imageUploaderModel});
                            OR
    var imageUploaderModal = new ImageUploader.Modal({imageUploaderModel: imageUploaderModel, headerLabel: 'headerLabelGoesHere'});
*/

var ImageUploader = {};

ImageUploader.Model = Backbone.Model.extend({
    supports: 'FileReader' in window,
    initialize: function(){ if(this.supports){
        var self = this;

        this.reader = new FileReader();
        this.reader.onloadend = function(e){
            self.trigger('onloadend',e.target.result)
        };

        this.on("change:file", this.read, this);
    }},
    read: function(){ this.reader.readAsDataURL(this.get('file')) }
});

ImageUploader.View = DefaultView.extend({
    templateSelector: '#fileUploaderDropZone',
    events: {
        'change .js-file-uploader-input': function(){ this.model.set('file', this.$('.js-file-uploader-input')[0].files[0]); }
    }
});

ImageUploader.Modal = Backbone.Modal.extend({
    events: {
        'click .modal-close': function(){ this.triggerCancel() }
    },
    initialize: function(opts){
        this.imageUploaderModel = opts.imageUploaderModel;
        this.headerLabel = opts.headerLabel;
        this.uploadLogoMessageLabel = opts.uploadLogoMessageLabel;
    },
    className: 'val-modal',
    template: function(){ return Mustache.to_html($('#modal-clear-template').html(), {headerLabel: this.headerLabel}) },
    onRender: function () {
        var imageUploaderView = new ImageUploader.View({model: this.imageUploaderModel});

        this.imageUploaderModel.on('onloadend',function(src){ this.trigger('logo-uploaded',src) },this);
        this.imageUploaderModel.on('change:file',function(){ this.triggerCancel(); }, this);

        this.$('.js-content-area').html(imageUploaderView.render().$el);
    }
});