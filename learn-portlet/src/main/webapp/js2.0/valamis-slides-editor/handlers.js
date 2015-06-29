/**
 * Created by aklimov on 24.04.15.
 */
(function(){
    var onPostMessage = function(event) {
        if (event.data.action === 'renderSlideSet')
            showSlideSet(new Backbone.Model(event.data.modelJSON));
    }
    if (window.addEventListener) {
        window.addEventListener("message", onPostMessage);
    } else {
        // IE8
        window.attachEvent("onmessage", onPostMessage);
    }
})();

slidesApp.commands.setHandler('drag:prepare:new', function(model, mx, my) {
    slidesApp.activeElement.isMoving = true;
    slidesApp.actionType = 'itemCreated';
    slidesApp.oldValue = null;
    slidesApp.activeElement.model = model;
    slidesApp.activeElement.view = null;
    slidesApp.activeElement.moduleName = model.get('slideEntityType').charAt(0).toUpperCase() + model.get('slideEntityType').slice(1) + 'ElementModule';
    slidesApp.activeElement.startX = mx;
    slidesApp.activeElement.startY = my;
});

slidesApp.commands.setHandler('item:create', function(isNew) {
    var ViewModel = slidesApp.module(slidesApp.activeElement.moduleName).View;
    var Model = slidesApp.module(slidesApp.activeElement.moduleName).Model;
    if(!isNew) {
        var model = slidesApp.activeElement.model;
        model.set('content', unescape(model.get('content')));
    }
    else var model = new Model();

    if(isNew) {
        switch(slidesApp.activeElement.moduleName) {
            case slidesApp.TextElementModule.moduleName:
                model.set('content', 'New text element');
                model.set('slideEntityType', 'text');
                break;
            case slidesApp.QuestionElementModule.moduleName:
                model.set('content', '');
                model.set('slideEntityType', 'question');
                model.set('width', 800);
                model.set('height', 100);
                model.set('left', (jQueryValamis('.slides').width() - model.get('width')) / 2);
                model.set('top', (jQueryValamis('.slides').height() - model.get('height')) / 2);
                model.set('notifyCorrectAnswer', false);
                break;
            case slidesApp.ImageElementModule.moduleName:
                model.set('content', '');
                model.set('slideEntityType', 'image');
                model.set('width', 200);
                model.set('height', 200);
                break;
            case slidesApp.IframeElementModule.moduleName:
                model.set('content', '');
                model.set('slideEntityType', 'iframe');
                model.set('width', 300);
                model.set('height', 500);
                break;
            case slidesApp.VideoElementModule.moduleName:
                model.set('content', '');
                model.set('slideEntityType', 'video');
                model.set('width', 640);
                model.set('height', 360);
                break;
            case slidesApp.PdfElementModule.moduleName:
                model.set('content', '');
                model.set('slideEntityType', 'pdf');
                model.set('width', 640);
                model.set('height', 360);
                break;
            case slidesApp.MathElementModule.moduleName:
                model.set('content', 'e^{x-n}');
                model.set('slideEntityType', 'math');
                break;
        }
        model.set('zIndex', ++slidesApp.maxZIndex);
        model.set('tempId', slidesApp.newSlideElementId--);
        model.set('slideId', parseInt(jQueryValamis('section.present[id^="slide_"]').attr('id').slice(6)));
        slidesApp.slideElementCollection.add(model);
        var slideEntities = [];
        _.each(slidesApp.slideElementCollection.where({slideId: model.get('slideId')}), function(slideEntity) {
            slideEntities = slideEntities.concat(slideEntity.toJSON());
        });
        slidesApp.activeSlideModel.set('slideElements', slideEntities);
    }

    var view = new ViewModel({model: model});
    var elem = view.render().$el;
    slidesApp.selectedItemView = slidesApp.activeElement.view = view;

    view.$('div[class*="content-icon-"]').css('font-size', Math.min(view.model.get('width') / 2, view.model.get('height') / 2) + 'px');
    if(!isNew && view.model.get('content') !== '') {
        view.$('div[class*="content-icon-"]').hide();
        view.content.css('background-color', 'transparent');
    }

    switch(slidesApp.activeElement.moduleName) {
        case slidesApp.IframeElementModule.moduleName:
        case slidesApp.PdfElementModule.moduleName:
            if(!isNew && view.model.get('content') !== '')
                view.$('.iframe-item').show();
            break;
        case slidesApp.ImageElementModule.moduleName:
            view.updateUrl(model.get('content'), model.get('width'), model.get('height'));
            break;
        case slidesApp.QuestionElementModule.moduleName:
            jQueryValamis('.toolbar').find('span.val-icon-question').closest('div').hide();
            if(!isNew && view.model.get('content') !== '') {
                slidesApp.commands.execute('question:update', model.get('content'));
                slidesApp.actionStack.pop();
                toggleSavedState();
            }
            break;
        case slidesApp.VideoElementModule.moduleName:
            if(!isNew && view.model.get('content') !== '') {
                view.$('.video-js').show();
                view.updateUrl(view.model.get('content'));
                slidesApp.actionStack.pop();
                toggleSavedState();
            }
            break;
        case slidesApp.MathElementModule.moduleName:
            view.$('.ui-resizable-handle').hide();
            break;
    }
    elem.attr('id', 'slideEntity_' + (model.id || model.get('tempId')));
    jQueryValamis(Reveal.getCurrentSlide()).append(elem);

    slidesApp.activeElement.offsetX = elem.width() / 2;
    slidesApp.activeElement.offsetY = elem.height() / 2;

    if(slidesApp.activeElement.moduleName === slidesApp.TextElementModule.moduleName)
        view.wrapperUpdate();

    slidesApp.activeElement.view.selectEl();

    if(!slidesApp.initializing) {
        slidesApp.viewId = view.cid;
        slidesApp.actionType = 'itemCreated';
        slidesApp.oldValue = null;
        slidesApp.newValue = {indices: Reveal.getIndices(), view: view.cid};
        slidesApp.commands.execute('action:push');
        Marionette.ItemView.Registry.register(view.cid, view);
    }
});

slidesApp.commands.setHandler('drag:prepare:existing', function(view, mx, my, offsetX, offsetY) {
    if (isEditorEnabled()) return;

    slidesApp.activeElement.isMoving = true;
    slidesApp.actionType = 'itemMoved';
    slidesApp.oldValue = {'top': view.model.get('top'), 'left': view.model.get('left')};
    slidesApp.activeElement.startX = mx;
    slidesApp.activeElement.startY = my;
    slidesApp.activeElement.offsetX = offsetX;
    slidesApp.activeElement.offsetY = offsetY;
    slidesApp.commands.execute('item:focus', view);
    slidesApp.GridSnapModule.prepareItemsSnap();
});

slidesApp.commands.setHandler('resize:prepare', function(view) {
    slidesApp.activeElement.isResizing = true;
    slidesApp.commands.execute('item:focus', view);
    slidesApp.actionType = 'itemResized';
    slidesApp.viewId = view.cid;
    slidesApp.oldValue = {
        'top': view.model.get('top'), 'left': view.model.get('left'),
        'width': view.model.get('width'), 'height': view.model.get('height')
    };
});

slidesApp.commands.setHandler('item:delete', function() {
    slidesApp.viewId = slidesApp.selectedItemView.cid;
    slidesApp.actionType = 'itemRemoved';
    slidesApp.oldValue = {indices: Reveal.getIndices(), view: slidesApp.selectedItemView};
    slidesApp.newValue = null;
    slidesApp.commands.execute('action:push');

    slidesApp.selectedItemView.model.set('toBeRemoved', true);
    slidesApp.selectedItemView.$el.hide();
    if(slidesApp.selectedItemView.model.get('slideEntityType') === 'question') {
        if (jQueryValamis(Reveal.getCurrentSlide()).find('.question-element:not(:hidden)').length > 0) {
            jQueryValamis('.toolbar').find('span.val-icon-question').closest('div').hide();
        }
        else {
            jQueryValamis('.toolbar').find('span.val-icon-question').closest('div').show();
        }
    }
    slidesApp.commands.execute('item:blur');
});

slidesApp.commands.setHandler('item:focus', function(view) {
    jQueryValamis('.ui-resizable-handle').hide();
    jQueryValamis('.item-controls').hide();
    jQueryValamis('.item-border').hide();
    slidesApp.activeElement.view = view;
    slidesApp.activeElement.moduleName = view.model.get('slideEntityType').charAt(0).toUpperCase() + view.model.get('slideEntityType').slice(1) + 'ElementModule';
    view.controls.show();
    view.resizeControls.show();
    view.$el.find('> .ui-resizable-handle').show();
    jQueryValamis('.rj-element').removeClass('active');
    view.resizeControls.addClass('active');
    jQueryValamis('#slide-controls').hide();
});

slidesApp.commands.setHandler('item:blur', function() {
    jQueryValamis('#slide-controls').show();
    jQueryValamis('.item-controls').hide();
    jQueryValamis('.item-border').show();
    jQueryValamis('.ui-resizable-handle').hide();
    jQueryValamis('.iframe-edit-panel').hide();
    jQueryValamis('.active').removeClass('active');
    slidesApp.isEditing = false;
});

slidesApp.commands.setHandler('item:duplicate', function(view) {
    var moduleName = view.model.get('slideEntityType').charAt(0).toUpperCase() + view.model.get('slideEntityType').slice(1) + 'ElementModule';
    var Model = slidesApp.module(moduleName).Model;
    var model = new Model(_.cloneDeep(view.model.toJSON()));
    model.unset('id');
    var offsetX = parseInt(view.model.get('left')),
        offsetY = parseInt(view.model.get('top')) + parseInt(view.model.get('height')) + 10 + parseInt(view.$el.css('borderBottomWidth').slice(0, -2));
    model.set({
        'left': offsetX,
        'top': offsetY,
        'tempId': slidesApp.newSlideElementId--,
        'slideId': parseInt(jQueryValamis(Reveal.getCurrentSlide()).attr('id').replace('slide_', ''))
    });
    if(view.model.get('slideEntityType') === 'image') {
        if(model.get('content').indexOf('url("/delegate/') === 0)
            model.save().then(function() {
                model.get('content').replace(/slide_item_([^&)]*)/g, 'slide_item_' + model.id);
            });
    }

    slidesApp.slideElementCollection.add(model);
    slidesApp.commands.execute('drag:prepare:new', model, 0, 0);
    slidesApp.commands.execute('item:create', false);
    slidesApp.activeElement.isMoving = false;
    slidesApp.commands.execute('item:focus', view);
});

slidesApp.commands.setHandler('item:resize', function(width, height) {
    if(slidesApp.activeElement.view) {
        var view = slidesApp.activeElement.view;
        view.model.set('width', Math.min(Math.max(width, 32), 800));
        view.model.set('height', Math.min(Math.max(height, 32), 800));
        view.content.find('div[class*="content-icon-"]').first().css('font-size', Math.min(view.model.get('width') / 2, view.model.get('height') / 2) + 'px');
        switch (slidesApp.activeElement.moduleName) {
            case slidesApp.MathElementModule.moduleName:
                view.content.css('font-size', view.model.get('height') + 'px');
                break;
            case slidesApp.TextElementModule.moduleName:
                view.model.set('height', height);
                break;
            case slidesApp.VideoElementModule.moduleName:
                view.model.set('height', Math.min(720, Math.max(360, height)));
                view.model.set('width', Math.min(1280, Math.max(640, width)));
                break;
            case slidesApp.IframeElementModule.moduleName:
            case slidesApp.PdfElementModule.moduleName:
                view.model.set('height', Math.min(1024, Math.max(360, height)));
                view.model.set('width', Math.min(1280, Math.max(640, width)));
                view.content.find('iframe').css({
                    'width': Math.min(1280, Math.max(640, width)) + 'px',
                    'height': Math.min(1024, Math.max(360, height)) + 'px'
                });
                break;
        }
    }
});

slidesApp.commands.setHandler('controls:place', function() {
    window.placeSlideControls(jQueryValamis(window.parent).width(), jQueryValamis(window.parent).height());
    slidesApp.commands.execute('item:blur');
});

slidesApp.commands.setHandler('action:push', function() {
    if(!slidesApp.initializing) {
        slidesApp.actionStack.push({
            viewId: slidesApp.viewId,
            type: slidesApp.actionType,
            oldValue: slidesApp.oldValue,
            newValue: slidesApp.newValue
        });
        if (slidesApp.isSaved)
            toggleSavedState();
    }
});

slidesApp.commands.setHandler('app:stop', function() {
//    clearInterval(slidesApp.saveInterval);
    revealModule.stop();
    arrangeModule.stop();
    if(slidesApp.mode === 'preview')
        togglePreviewMode();
    jQueryValamis('#arrangeContainer').prevAll().show();
    jQueryValamis('#arrangeContainer').empty();
    slidesApp.slideSetModel = null;
    slidesApp.editorArea.reset();
    jQueryValamis('.slide-popup-panel').hide();
    toggleSavedState();
    switchMode('edit', true);
    window.parent.isEditorReady = false;
    window.parent.isEditorIframeLoaded = false;
    slidesApp.isRunning = false;
});

slidesApp.commands.setHandler('question:update', function(id) {
    slidesApp.activeElement.view.updateQuestion(id);
});

jQueryValamis(function() {
    slidesApp.start();
});

slidesApp.commands.setHandler("fileupload:show:modal", function (moduleName) {
    function uploadPdf(elementId) {
        var pdfModel = new Backbone.Model();
        pdfModel.set('tempId', elementId);
        var pdfModalView = new PDFModal({ model: pdfModel });
        slidesEditorModalsLayout.modals.show(pdfModalView);
        pdfModalView.$el.find('.js-title-edit').closest('tr').hide();

        pdfModalView.on('pdf:added', function (data) {
            var src = '/learn-portlet/preview-resources/pdf/web/viewer.html?file=/learn-portlet/SCORMData/files/quizData' + elementId
                + '/' + data.get('title') + '.pdf';

            slidesApp.activeElement.view.updateUrl(src);
            slidesEditorModalsLayout.modals.currentView.destroy(pdfModalView);
        });
    }
    function uploadPptx(slideId) {
        var pptxModel = new Backbone.Model();
        pptxModel.set('tempId', slideId);
        var pptxModalView = new PPTXModal({ model: pptxModel });
        slidesEditorModalsLayout.modals.show(pptxModalView);
        pptxModalView.$el.find('.js-title-edit').closest('tr').hide();

        pptxModalView.on('pptx:added', function (data) {
            var slides = data.get('slides');
            var i = 0;
            _.each(slides, function(slide) {
                var src = '/' + path.api.quiz + '?action=GETQUESTIONPREVIEW'
                    + '&id=' + slide.id
                    + '&lessonId=' + slideId
                    + '&courseId=' + Utils.getCourseId();
                jQueryValamis.get(src, function(data) {
                    var imgSrc = jQueryValamis(data).find('img').attr('src');
                    if(i > 0) {
                        slidesApp.commands.execute('reveal:page:addDown', undefined, 'pptx');
                    }
                    slidesApp.commands.execute('reveal:page:changeBackgroundImage', imgSrc + ' contain');
                    i++;
                    if(i == slides.length) {
                        slidesApp.viewId = undefined;
                        slidesApp.actionType = 'PPTXAdded';
                        slidesApp.oldValue = undefined;
                        slidesApp.newValue = { slideCount: slides.length };
                        slidesApp.commands.execute('action:push');
                    }
                });
            });

            slidesEditorModalsLayout.modals.currentView.destroy(pptxModalView);
        });
    }
    function selectLiferayArticle(elementId) {
        var liferayArticleModel = new Backbone.Model();
        liferayArticleModel.set('tempId', elementId);
        var AddTextArticleModalView = new AddTextArticleModal({ model: liferayArticleModel });
        slidesEditorModalsLayout.modals.show(AddTextArticleModalView);
        AddTextArticleModalView.$el.find('.js-title-edit').closest('tr').hide();

        AddTextArticleModalView.on('article:added', function (data) {
            slidesApp.oldValue = { contentType: 'text', content: slidesApp.activeElement.view.model.get('content') };
            slidesApp.activeElement.view.model.set('width', 'auto');
            slidesApp.activeElement.view.model.set('content', data.replace(/\+/g, ' '));
            slidesApp.activeElement.view.model.set('width', Math.min(800, slidesApp.activeElement.view.content.width()));
            slidesEditorModalsLayout.modals.currentView.destroy(AddTextArticleModalView);
            slidesApp.activeElement.view.content.find('img').last().load(function() {
                slidesApp.activeElement.view.wrapperUpdate();
                slidesApp.viewId = slidesApp.activeElement.view.cid;
                slidesApp.actionType = 'itemContentChanged';
                slidesApp.newValue = { contentType: 'text', content: slidesApp.activeElement.view.model.get('content') };
                slidesApp.commands.execute('action:push');
            });
        });
    }
    switch(moduleName) {
        case 'PdfElementModule':
            if (!slidesApp.activeElement.view.model.id)
                slidesApp.activeElement.view.model.save().then(function (SlideElementModel) {
                    uploadPdf(SlideElementModel.id);
                });
            else
                uploadPdf(slidesApp.activeElement.view.model.id);
            break;
        case 'PptxElementModule':
            if (!slidesApp.activeSlideModel.id)
                slidesApp.activeSlideModel.save().then(function (slideModel) {
                    uploadPptx(slideModel.id);
                });
            else
                uploadPptx(slidesApp.activeSlideModel.id);
            break;
        case 'TextElementModule':
            selectLiferayArticle(slidesApp.activeElement.view.model.id || slidesApp.activeElement.view.model.get('tempId'));
            break;
        default:
            slidesEditorModalsLayout.modals.show(new slidesImageLayout({moduleName: moduleName}));
    }
});

slidesApp.commands.setHandler("questionbank:show:modal", function () {
    slidesEditorModalsLayout.modals.show(new BankQuestionSelectModal());
});

slidesApp.commands.setHandler('mediagallery:show:modal', function(type) {
    var model = (type === 'slide') ? slidesApp.activeSlideModel : slidesApp.activeElement.view.model;
    if(type === 'video') {
        var videoModel = new Backbone.Model();
        var videoModalView = new VideoModal({ model: videoModel });
        // Hide the "Embed YouTube video" row, because there is a YT search already
        slidesEditorModalsLayout.modals.show(videoModalView);
        videoModalView.$el.find('#EMBED').closest('tr').hide();

        videoModalView.on('video:added', function (data) {
            if(data.get('fromDocLibrary')) {
                var src = '/documents/' + Utils.getCourseId() + '/0/' +
                    data.get('title') + '/' + data.get('uuid') +
                    '?groupId=' + data.get('groupID') +
                    '&ext=' + getExtByMime(data.get('mimeType'));

                if (data.get('title') && data.get('uuid'))
                    slidesApp.activeElement.view.updateUrl(src);
            }
            else {
                var src = /<iframe.*src="([^"]*)".*<\/iframe>/g.exec(data.get('url'))[1];
                slidesApp.activeElement.view.updateUrl(src);
            }
            slidesEditorModalsLayout.modals.currentView.destroy(videoModalView);
        });
    }
    else if(type === 'image') {
        var galleryView = new GalleryContainer({
            language: window.slidesConfig.translations,
            folderID: 'slide_item_' + (model.id || model.get('tempId')),
            saveToFileStorage: true});

        var galleryModalView = new ValamisEmptyModalView({
            contentView: galleryView,
            header: window.slidesConfig.translations['galleryLabel']
        });

        slidesEditorModalsLayout.modals.show(galleryModalView);

        galleryView.on('savedLogo', function (data) {
            var imgdata = {};
            if (imageData.supports()) {
                imageData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'document-library');
                imageData.setSetting(IMAGE_PARAM_TYPE.FILE_ENTRY_ID, data.id);
                imageData.setSetting(IMAGE_PARAM_TYPE.FILE, data.get('title'));
                imageData.setSetting(IMAGE_PARAM_TYPE.FILE_VERSION, data.get('version'));

                imgdata.src = '/documents/' + Utils.getCourseId() +
                    '/' + data.get('folderId') + '/' +
                    data.get('title') + '/?version=' + data.get('version') +
                    '&imageThumbnail=0&entryId=' + data.id +
                    '&ext=' + getExtByMime(data.get('mimeType'));
                imgdata.fileName = data.get('fileName');
            } else {
                imgdata.fileName = data.get('title');
            }

            switch (type) {
                case 'slide':
                    var slide = jQueryValamis(Reveal.getCurrentSlide());
                    slidesApp.oldValue = {
                        indices: Reveal.getIndices(),
                        backgroundType: 'image',
                        background: (slide.attr('data-background') + ' ' + slide.attr('data-background-size')) || ''
                    };
                    slide.attr('data-background', 'url("' + imgdata.src + '")');
                    slide.attr('data-background-repeat', 'no-repeat');
                    slide.attr('data-background-position', 'center');
                    jQuery('.background-image-edit').css('display', 'block');
                    Reveal.sync();

                    jQueryValamis('#slide-background-image-thumbnail').show();
                    jQueryValamis('#slide-background-image-thumbnail').css('background', 'url("' + imgdata.src + '") no-repeat');
                    jQueryValamis('#slide-background-image-thumbnail').css('background-size', 'contain');
                    slidesApp.activeSlideModel.set('bgImage', 'url("' + imgdata.src + '") ' + jQueryValamis('#background-image-selector').val());
                    slidesApp.viewId = this.cid;
                    slidesApp.actionType = 'slideBackgroundChanged';
                    slidesApp.newValue = { indices: Reveal.getIndices(), backgroundType: 'image', background: 'url("' + imgdata.src + '") ' + jQueryValamis('#background-image-selector').val() };
                    break;
                case 'image':
                    slidesApp.oldValue = {
                        contentType: 'image',
                        content: slidesApp.activeElement.view.model.get('content'),
                        width: slidesApp.activeElement.view.model.get('width'),
                        height: slidesApp.activeElement.view.model.get('height')
                    };

                    slidesApp.activeElement.view.content.css({
                        'background-image': 'url("' + imgdata.src + '")'
                    });
                    var image = new Image();
                    image.onload = function () {
                        var newSize = window.resizeImage(image.width, image.height, 800, 800);
                        slidesApp.commands.execute('item:resize', newSize.width, newSize.height);
                    };
                    image.src = imgdata.src;
                    model.set('content', 'url("' + imgdata.src + '")');
                    slidesApp.activeElement.view.content.css('background-color', 'transparent');
                    slidesApp.activeElement.view.$('.content-icon-image').first().hide();
                    slidesApp.viewId = slidesApp.activeElement.view.cid;
                    slidesApp.actionType = 'itemContentChanged';
                    slidesApp.newValue = {
                        contentType: 'image',
                        content: slidesApp.activeElement.view.model.get('content'),
                        width: slidesApp.activeElement.view.model.get('width'),
                        height: slidesApp.activeElement.view.model.get('height')
                    };
                    break;
            }
            slidesApp.commands.execute('action:push');

            slidesEditorModalsLayout.modals.currentView.destroy(galleryModalView);
        });
    }
    else if(type === 'gapi') {
        slidesConfig.eventAggregator.trigger('load-gapi-picker');
    }
});

slidesApp.commands.setHandler('linkUpdate', function (linkTypeName) {
    window.editorMode = linkTypeName == 'correctLinkedSlideId' ? 'arrange:select' : 'arrange:select-incorrect';
    slidesConfig.eventAggregator.trigger('switch-editor-mode', 'arrange');
});

slidesApp.commands.setHandler('picker:file:selected', function(url) {
    if(slidesApp.activeElement.view && slidesApp.activeElement.view.model.get('slideEntityType') === 'video') {
        slidesApp.activeElement.view.updateUrl(url);
    }
});
