var SlideSetEditDialogView = Backbone.View.extend({
    events: {
        'click .js-upload-img': 'uploadImage',
        'click .js-upload-button': 'uploadImage',
        'click .js-media-gallery': 'openMediaGallery'
    },
    className: 'div-table val-info-table',
    template: null,
    getTemplate: function(){
        if(!this.template) this.template = jQueryValamis('#edit-slide-dialog').html();
        return this.template;
    },
    render: function(){
        this.$el.html(Mustache.render(this.getTemplate(), _.extend({}, this.model.attributes, slidesConfig.translations)));
        return this;
    },
    uploadImage: function(){ this.trigger('showUploadLogoModal', this.model) },
    openMediaGallery: function() { this.trigger('showMediaGallery', this.model) }
});

var SlideModalsLayout = Backbone.Marionette.LayoutView.extend({
    template: function(){ return jQuery('#slide-modals').html() },
    regions: {
        modals: {
            selector: '.js-slide-extra-modal-container',
            regionClass: Backbone.Marionette.Modals
        }
    }
});

var SlideSetEditModal = Backbone.Modal.extend({
    className: 'val-modal',
    events: {
        'click .modal-close': function(){ this.triggerCancel() },
        'click .js-cancel-slide': function(){ this.triggerCancel() },
        'click .js-save-slide': function(){
            if(this.$('.js-title-field').val().length > 75) {
                toastr.warning(slidesConfig.translations['lessonTitleTooLongLabel']);
                return;
            }
            var self = this;
            var newModelAttrs = {
                title: this.$('.js-title-field').val() || this.$('.js-title-field').attr('placeholder'),
                description: this.$('.js-description-field').val() || this.$('.js-description-field').attr('placeholder'),
                courseId: Utils.getCourseId()
            };

            if('logo-file' in this.slideSetModel.attributes) _.extend(newModelAttrs, {logo: this.slideSetModel.get('logo-file').name});
            var logoFile = this.slideSetModel.get('logo-file');
            this.slideSetModel.unset('logo-file');

            this.slideSetModel.set(newModelAttrs).save().then(function(){
                toastr.success(slidesConfig.translations['lessonWasSavedSuccessfullyLabel']);

                function closeAndFetch(){
                    self.triggerCancel();
                    slidesConfig.eventAggregator.trigger('fetchRequired');
                }

                if(logoFile) {
                    if (self.slideSetModel.get('logo-file-type') == 'icon') {
                      slidesConfig.formDataHelper.contentType = self.slideSetModel.get('logo-file-type');
                      slidesConfig.formDataHelper.file = logoFile;
                      slidesConfig.formDataHelper.fileName = logoFile.name;
                    }

                    slidesConfig.formDataHelper.folderId = "slideset_logo_" + self.slideSetModel.get('id');

                    slidesConfig.formDataHelper.submitData({
                        success: closeAndFetch,
                        error: function(){
                            toastr.error(slidesConfig.translations['errorWhenSavingLogoLabel']);
                            closeAndFetch();
                        }
                    });
                } else {
                    closeAndFetch();
                }
            });
        }
    },
    initialize: function(opts){
        this.slideSetModel = opts.slideSetModel;

        this.slideSetModel.on('logo-uploaded', function(src){
            this.$('.js-upload-img').attr('src', src)
        },this);
    },
    template: function(){return Mustache.to_html(jQueryValamis('#slide-edit-modal').html(), slidesConfig.translations)},
    onRender: function () {
        var slideSetEditDialogView = new SlideSetEditDialogView({model: this.slideSetModel});
        slideSetEditDialogView.on('closeModal', function () { this.trigger('closeModal') }, this);
        slideSetEditDialogView.on('showUploadLogoModal', function (model) { this.trigger('showUploadLogoModal', model) }, this);
        slideSetEditDialogView.on('showMediaGallery', function (model) { this.trigger('showMediaGallery', model) }, this);
        this.$('.js-edit-slide-area').append(slideSetEditDialogView.render().$el);
    }
});