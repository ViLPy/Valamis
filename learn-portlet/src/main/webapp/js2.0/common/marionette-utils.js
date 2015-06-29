/**
 * Created by igorborisov on 10.04.15.
 */


window.Valamis = window.Valamis || {};
window.Valamis.language = window.Valamis.language || {};

Marionette.TemplateCache.prototype.compileTemplate = function(rawTemplate, options) {
    Mustache.parse(rawTemplate);
    return _.partial(Mustache.render, rawTemplate);
};

// Render a template with data by passing in the template
// selector and the data to render.
Marionette.Renderer = {

    // Render a template with data. The `template` parameter is
    // passed to the `TemplateCache` object to retrieve the
    // template function. Override this method to provide your own
    // custom rendering and template handling for all of Marionette.
    render: function(template, data, view) {

        _.extend(data, Valamis.language);
        _.extend(data, Valamis.permissions);

        if (!template) {
            throw new Marionette.Error({
                name: 'TemplateNotFoundError',
                message: 'Cannot render the template since its false, null or undefined.'
            });
        }

        var templateFunc = _.isFunction(template) ? template : Marionette.TemplateCache.get(template);
        return templateFunc(data);
    }
};


Behaviors = {};

Backbone.Marionette.Behaviors.behaviorsLookup = function() {
    return Behaviors;
};

Behaviors.ValamisUIControls = Backbone.Marionette.Behavior.extend({
    defaults:{
        'dropdown':'.dropdown',
        'plusminus':'.js-plus-minus',
        'digitsOnly':'.js-digits-only',
        'sidebarToggler': '.js-toggle-sidebar'
    },
    onRender:function(){
        this.$(this.options.dropdown).valamisDropDown();
        this.$(this.options.plusminus).valamisPlusMinus();
        this.$(this.options.digitsOnly).valamisDigitsOnly();
        this.$(this.options.sidebarToggler).valamisSidebar();

        if(this.view.onValamisControlsInit){
            this.view.onValamisControlsInit();
        }
    }
});

Behaviors.ImageUpload = Backbone.Marionette.Behavior.extend({
    defaults:{
        'postponeLoading': false,
        'uploadImage':'.js-upload-image',
        'uploadLogoMessage' : 'uploadLogoMessage',
        'fileUploadModalHeader' : 'fileUploadModalHeader',
        'selectImageModalHeader': 'selectImageModalHeader',
        'getFolderId' : function() {return 'getDefaultFolderId'},
        'getFileUploaderUrl': function() {return ''}
    },
    events: {
        'click .js-upload-image': 'uploadImage',
        'click .js-select-from-media-gallery': 'selectImage'
    },
    initialize: function(){
        var self = this;
        self.logoData = new FormDataHelper();
        self.view.on('view:submit:image', function(callback){
          var folderId = self.options.getFolderId(self.view.model);
          self.logoData.setFolderId(folderId);
          var portletFileUploaderUrl = self.options.getFileUploaderUrl(self.view.model);
          self.logoData.setPortletFileUploaderUrl(portletFileUploaderUrl);
          self.logoData.submitData({success: function(name) { callback(name);} });
        });
    },
    uploadImage:function(){
        var postponeLoading = this.options.postponeLoading;
        var imageModel = {
            logo: '',
            logoSrc: ''
        };

        var self = this;

        var folderId = this.options.getFolderId(this.view.model);
//        self.logoData.setFolderId(folderId);

        var fileUploaderUrl = '';
        if(!postponeLoading || !self.logoData.supports()){
            var endpointparam = {
                action:'ADD',
                courseId:  Utils.getCourseId(),
                contentType: 'icon',
                folderId: folderId
            };
            var portletFileUploaderUrl = self.options.getFileUploaderUrl(self.view.model);
            fileUploaderUrl = portletFileUploaderUrl || path.root + path.api.files + "?" + jQueryValamis.param(endpointparam);
        }

        var uploader = new FileUploader({ endpoint: fileUploaderUrl, message: this.options.uploadLogoMessage });

        if(postponeLoading && self.logoData.supports()){
            uploader.on('fileuploadadd', function (data) {
                self.logoData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'icon');
                self.logoData.setSetting(IMAGE_PARAM_TYPE.FILE, data);

                self.logoData.readAsDataURL(data, function (img) {
                    uploader.trigger("fileupload:done", { src: img });
                });
            });
        }else{
            uploader.on("fileuploaddone", function (result) {
                uploader.trigger("fileupload:done", result);
            });
        }

        var imageUploaderModalView = new valamisApp.Views.ModalView({
            contentView: uploader,
            header: this.options.fileUploadModalHeader
        });

        uploader.on("fileupload:done", function (result) {
            imageModel.logo = result.name;
            imageModel.logoSrc = result.src;

            self.onImageUploaded(imageModel);
            valamisApp.execute('modal:close', imageUploaderModalView);
        });

        valamisApp.execute('modal:show', imageUploaderModalView);
    },
    onImageUploaded: function(imageModel){
        if (imageModel.logo) this.view.model.set('logo', imageModel.logo);
        this.view.model.set('logoSrc', imageModel.logoSrc);
    },
    onSubmit: function(){

    },
    selectImage: function() {
      var that = this;

      var galleryView = new GalleryContainer({
        language: Valamis.language,
        folderID: this.options.getFolderId(that.view.model),
        saveToFileStorage: !that.logoData.supports()});

      var galleryModalView = new valamisApp.Views.ModalView({
        contentView: galleryView,
        submitEl: '.js-save-package',
        header: this.options.selectImageModalHeader
      });

      galleryView.on('savedLogo', function(data){
        var imgdata = {};
        if (that.logoData.supports()) {
          that.logoData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'document-library');
          that.logoData.setSetting(IMAGE_PARAM_TYPE.FILE_ENTRY_ID, data.get('id'));
          that.logoData.setSetting(IMAGE_PARAM_TYPE.FILE, data.get('title'));
          that.logoData.setSetting(IMAGE_PARAM_TYPE.FILE_VERSION, data.get('version'));

          imgdata.src = "/documents/" + Utils.getCourseId() + "/" + data.get('folderId') + "/" + data.get('title') + "/?version=" + data.get('version') + "&imageThumbnail=1";
          imgdata.fileName = data.get('fileName');
        }else { // old browsers, image saved immediately in GalleryContainer
          imgdata.fileName = data.get('title');
        }

        that.view.model.set('logo', imgdata.fileName);
        that.view.model.set('logoSrc', imgdata.src);

        valamisApp.execute('modal:close', galleryModalView);
      });

      valamisApp.execute('modal:show', galleryModalView);
    }
});
