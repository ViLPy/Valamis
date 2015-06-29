/**
 * Created by igorborisov on 12.03.15.
 */


ValamisLocalizedView = {
    render: function(){
        var mustacheAccumulator = {};
        _.extend(mustacheAccumulator, window.permissionActionsLessonDesigner);
        _.extend(mustacheAccumulator, this.serializeData());
        _.extend(mustacheAccumulator, this.language);
        var template = jQuery(this.template).html();
        this.$el.html(Mustache.to_html(template, mustacheAccumulator));

        this.setUIControls();

        if(this.onRender) {
            this.onRender();
        }

        return this;
    },
    setUIControls: function(){
        this.$el.find('.dropdown').valamisDropDown();
        this.$el.find('.js-plus-minus').valamisPlusMinus();
        this.$el.find('.js-toggle-sidebar').valamisSidebar();
    }
};

ValamisItemView = Marionette.ItemView.extend(ValamisLocalizedView);


ValamisEmptyModalView = Backbone.Modal.extend({
    template: '#valamisEmptyModalTemplate',
    className:'val-modal',
    submitEl: '.bbm-button',
    cancelEl: '.modal-close',
    initialize: function(options){
        this.header= options.header;
        this.contentView = options.contentView;
        var mustacheAccumulator = {};
        if (this.model) {
            _.extend(mustacheAccumulator, this.model.toJSON());
        }
        _.extend(mustacheAccumulator,  lessonDesigner.language);
        _.extend(mustacheAccumulator, { header : this.header });
        this.template = _.template(Mustache.to_html(jQuery(this.template).html(), mustacheAccumulator));
    },
    onRender: function(){
        this.$('.js-modal-content').html(this.contentView.render().el);
        this.setUIControls();
    },
    setUIControls: function(){
        this.$el.find('.dropdown').valamisDropDown();
        this.$el.find('.js-plus-minus').valamisPlusMinus();
        this.$el.find('.js-toggle-sidebar').valamisSidebar();
    }
});

ValamisModalView = Backbone.Modal.extend({
    template: '#lessonDesignerEmptyModalTemplate',
    className:'val-modal',
    submitEl: '.bbm-button',
    cancelEl: '.modal-close',
    initialize: function(options){
        this.header= options.header;
        this.contentView = options.contentView;
        var mustacheAccumulator = {};
        if (this.model) {
            _.extend(mustacheAccumulator, this.model.toJSON());
        }
        _.extend(mustacheAccumulator,  lessonDesigner.language);
        _.extend(mustacheAccumulator, { header : this.header });
        this.template = _.template(Mustache.to_html(jQuery(this.template).html(), mustacheAccumulator));
    },
    onRender: function(){
        this.$('.js-modal-content').html(this.contentView.render().el);
    },
    submit: function(){
        this.contentView.submit();
    }
});


//TODO add async languages loading
var LessonDesigner = Marionette.Application.extend({
    channelName:'lessonDesigner',
    initialize: function(options) {
        this.addRegions({
            mainRegion: '#lessonDesignerAppRegion'
        });

        this.settings = new SettingsHelper({url: window.location.href, portlet: 'quiz'});
        this.settings.fetch();

    },
    start: function(options){
        this.language = options.language;

        var previousFilter = this.settings.get('searchParams');
        this.filter = new lessonDesigner.Entities.Filter(previousFilter);
        this.filter.on('change', function(){
            lessonDesigner.commands.execute('lessons:reload', true);
            lessonDesigner.settings.set('searchParams', this.filter.toJSON());
            lessonDesigner.settings.save();
        }, this);

        this.lessons = new lessonDesigner.Entities.LessonCollection();

        this.paginatorModel = new PageModel();

        var layoutView = new lessonDesigner.Views.AppLayoutView();

        this.mainRegion.show(layoutView);
    }
});

var lessonDesigner = new LessonDesigner();

//lesson model
lessonDesigner.commands.setHandler('lesson:create', function(model){

    model.save().then(function(){
            quizLogoData.setFolderId('quiz_logo_' + model.get('id'));
            if(quizLogoData.isReadyToSubmit()){
                quizLogoData.submitData( {
                    success: function(name){
                        model.set({'logo': name});
                        model.updateLogo().then(function() {
                                lessonDesigner.commands.execute('lessons:reload');
                            }
                        );
                    },
                    error: function(){
                        lessonDesigner.commands.execute('lessons:reload');
                    }
                });
            }else {
                lessonDesigner.commands.execute('lessons:reload');
            }
        }
    );
});

lessonDesigner.commands.setHandler('lesson:save', function(model){
    model.save({}, {silent: true});
});

lessonDesigner.commands.setHandler('lesson:remove', function(model){
    model.destroy().then( function() {
            lessonDesigner.commands.execute('lessons:reload');
        }
    );
});

lessonDesigner.commands.setHandler('lesson:clone', function(model){
    model.clone().then(function(){
        lessonDesigner.commands.execute('lessons:reload');
    });
});

lessonDesigner.commands.setHandler('lesson:processTincan', function(model){

    var tincanProcessModal = new TinCanProcessModal({
        model: model
    });

    lessonDesigner.commands.execute('modal:show', tincanProcessModal);

    tincanProcessModal.on('modal:close', function(){
        lessonDesigner.commands.execute('modal:close', tincanProcessModal);
    });

});

lessonDesigner.commands.setHandler('lesson:download', function(id, lessonType){
    window.location = path.root + path.api.files + 'export/?action=DOWNLOAD&contentType=lesson'
    + '&id=' + id
    + '&courseId=' + Utils.getCourseId()
    + '&publishType=' + lessonType;
});

lessonDesigner.commands.setHandler('lesson:publish', function(model, lessonType){

    toastr.info(GLOBAL_translations['overlayProcessMessageLabel']);
    model.publish({publishType: lessonType}).then(function (response) {
        if (response.status) {
            toastr.success(GLOBAL_translations['overlayCompleteMessageLabel']);
        } else {
            toastr.error(GLOBAL_translations['overlayContentNeededMessageLabel']);
        }
    }, function () {
        toastr.error(GLOBAL_translations['overlayFailedMessageLabel']);
    });

});

lessonDesigner.commands.setHandler('lesson:convert', function(model){

    toastr.info(GLOBAL_translations['overlayProcessMessageLabel']);
    model.convert().then(function () {
        toastr.success(GLOBAL_translations['overlayCompleteMessageLabel']);
    }, function () {
        toastr.error(GLOBAL_translations['overlayFailedMessageLabel']);
    });

});

//collection methods
lessonDesigner.commands.setHandler('lessons:reload', function(filterChanged){
    var filter = lessonDesigner.filter.toJSON();

    if(filterChanged) {
        lessonDesigner.paginatorModel.set('currentPage', 1);
    }

    lessonDesigner.lessons.fetch({
        reset: true,
        filter: filter,
        currentPage: lessonDesigner.paginatorModel.get('currentPage'),
        itemsOnPage: lessonDesigner.paginatorModel.get('itemsOnPage')
    });
});

lessonDesigner.commands.setHandler('recompute:size', function(viewEl){
    jQuery(window).trigger('recompute:tile:sizes', viewEl);
});

lessonDesigner.commands.setHandler('modal:show', function(modalView){
    lessonDesigner.mainRegion.currentView.modals.show(modalView);
});
lessonDesigner.commands.setHandler('modal:close', function(modalView){
    lessonDesigner.mainRegion.currentView.modals.destroy(modalView);
});

lessonDesigner.commands.setHandler('edit:open:modal:upload:image', function(model, postponeLoading){
    var fileUploaderUrl = '';
    if(!postponeLoading || !quizLogoData.supports()){
        var endpointparam = {
            action:'ADD',
            courseId:  Utils.getCourseId(),
            contentType: 'icon',
            folderId: 'quiz_logo_' + model.get('id')
        };
        fileUploaderUrl = path.root + path.api.files + "?" + jQuery.param(endpointparam);
    }

    var uploader = new FileUploader({ endpoint: fileUploaderUrl, message: GLOBAL_translations['uploadLogoMessage'] });

    if(postponeLoading && quizLogoData.supports()){
        uploader.on('fileuploadadd', function (data) {
            quizLogoData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'icon');
            quizLogoData.setSetting(IMAGE_PARAM_TYPE.FILE, data);

            quizLogoData.readAsDataURL(data, function (img) {
                uploader.trigger("fileupload:done", {src: img});
            });
        });
    }else{
        uploader.on("fileuploaddone", function (result) {
            uploader.trigger("fileupload:done", result);
        });
    }

    var imageUploaderModalView = new ValamisEmptyModalView({
        contentView: uploader,
        header: lessonDesigner.language['uploadLabel']
    });

    uploader.on("fileupload:done", function (result) {
        model.set('logo', result.name);
        model.set('logoSrc', result.src);
        lessonDesigner.commands.execute('modal:close', imageUploaderModalView);
    });

    lessonDesigner.commands.execute('modal:show', imageUploaderModalView);
});

lessonDesigner.commands.setHandler('open:modal:mediagallery', function(model){

    var galleryView = new GalleryContainer({
        language: lessonDesigner.language,
        folderID: 'quiz_logo_' + model.get('id'),
        saveToFileStorage: !quizLogoData.supports()});

    var galleryModalView = new ValamisEmptyModalView({
        contentView: galleryView,
        header: lessonDesigner.language['galleryLabel']
    });

    galleryView.on('savedLogo', function(data){
        var imgdata = {};
        if (quizLogoData.supports()) {
            quizLogoData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'document-library');
            quizLogoData.setSetting(IMAGE_PARAM_TYPE.FILE_ENTRY_ID, data.id);
            quizLogoData.setSetting(IMAGE_PARAM_TYPE.FILE, data.get('title'));
            quizLogoData.setSetting(IMAGE_PARAM_TYPE.FILE_VERSION, data.get('version'));

            imgdata.src = "/documents/" + Utils.getCourseId() + "/" + data.get('folderId') + "/" + data.get('title') + "/?version=" + data.get('version') + "&imageThumbnail=1";
            imgdata.fileName = data.get('fileName');
        }else { // old browsers, save image immediately
            imgdata.fileName = data.get('title');
        }

        model.set('logo', imgdata.fileName);
        model.set('logoSrc', imgdata.src);

        lessonDesigner.commands.execute('modal:close', galleryModalView);
    });

    lessonDesigner.commands.execute('modal:show', galleryModalView);
});