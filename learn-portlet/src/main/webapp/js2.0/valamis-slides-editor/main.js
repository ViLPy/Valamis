function showSlideSet(slideSetModel) {
    if(!slidesConfig.googleClientApiReady)
        slidesConfig.googleClientAPILoadTryCount++;
    if(!slidesConfig.youtubeIframeAPIReady)
        slidesConfig.youtubeIframeAPILoadTryCount++;

    if(slidesConfig.googleClientApiReady && slidesConfig.youtubeIframeAPIReady) {
        if(slidesConfig.googleClientAPILoadTryCount > 10)
            slidesConfig.googleClientApiReady = false;
        if(slidesConfig.youtubeIframeAPILoadTryCount > 10)
            slidesConfig.youtubeIframeAPIReady = false;
        slidesConfig.googleAPIsLoadTryCount = 0;
        slidesApp.slideSetModel = slideSetModel;
        slidesApp.mode = 'edit';
        slidesApp.slideCollection = new SlideCollection();
        window.collection = Backbone.Collection.extend({});
        slidesApp.slideElementCollection = new window.collection();
        slidesApp.newSlideId = -1;
        slidesApp.newSlideElementId = -1;
        slidesApp.categories = [];
        slidesApp.questions = [];
        slidesApp.questionCollection = new window.collection();
        slidesApp.slideCollection.on('sync', function () {
            if (slidesApp.slideCollection && slidesApp.slideElementCollection) {
                revealModule.start();
            }
        });
        slidesApp.slideCollection.fetch({model: slideSetModel});
        slidesApp.isSaved = false;
        toggleSavedState();
    }
    else {
        if(slidesConfig.youtubeIframeAPILoadTryCount <= 10 && slidesConfig.googleClientAPILoadTryCount <= 10)
            setTimeout(function() {
                showSlideSet(slideSetModel);
            }, 500);
        else {
            if(!slidesConfig.youtubeIframeAPIReady) {
                toastr.warning(slidesConfig.translations['youtubeAPILoadingFailedLabel']);
                slidesConfig.youtubeIframeAPIReady = true;
            }
            if(!slidesConfig.googleClientApiReady) {
                toastr.warning(slidesConfig.translations['googleClientAPILoadingFailedLabel']);
                slidesConfig.googleClientApiReady = true;
            }
            showSlideSet(slideSetModel);
        }
    }
    slidesConfig.eventAggregator.on('editor-reloaded', function() {
        jQueryValamis('#arrangeContainer').prevAll().show();
        jQueryValamis('#arrangeContainer').empty();
        arrangeModule.stop();
        toastr.clear();
        slidesApp.commands.execute('controls:place');
        if(slidesApp.mode === 'preview') {
            togglePreviewMode();
            switchMode('preview', true);
        }
    });
}

function saveSlideset(options) {
    slidesApp.deferred = jQueryValamis.Deferred();
    var close = options.close;
    if(!slidesApp.isSaved) {
        var totalSlideCount = 0;
        var totalSlideElementCount = 0;
        var i = 0;

        function saveElement(oldSlideModel, newSlideModel, slideElementModel) {
            var deferred = jQueryValamis.Deferred();
            if(slidesApp.slideElementCollection.where({ slideId: oldSlideModel.get('tempId') }).length + slidesApp.slideElementCollection.where({ slideId: newSlideModel.id }).length == 0) {
                deferred.resolve();
            }
            if (slideElementModel) {
                if (slideElementModel.get('toBeRemoved') && Marionette.ItemView.Registry.getByModelId(slideElementModel.cid)) {
                    Marionette.ItemView.Registry.remove(Marionette.ItemView.Registry.getByModelId(slideElementModel.cid).cid);
                    slideElementModel.destroy();
                }
                else {
                    if (slideElementModel.get('slideId') === oldSlideModel.get('tempId') || slideElementModel.get('slideId') === newSlideModel.id) {
                        if (slideElementModel.get('slideId') === oldSlideModel.get('tempId'))
                            slideElementModel.set('slideId', newSlideModel.id);
                        if (slideElementModel.get('tempId') && slidesApp.addedSlideElements.indexOf(slideElementModel.get('tempId')) === -1) {
                            var slideElementDOMElement = jQueryValamis('div#slideEntity_' + slideElementModel.get('tempId'));
                            slideElementModel.save().then(function (newSlideElementModel) {
                                slideElementDOMElement.attr('id', 'slideEntity_' + newSlideElementModel.id);
                                i++;
                                totalSlideElementCount++;
                                if (i == slidesApp.slideElementCollection.where({ slideId: oldSlideModel.get('tempId') }).length + slidesApp.slideElementCollection.where({ slideId: newSlideModel.id }).length)
                                    deferred.resolve();
                            });
                        }
                        else {
                            slideElementModel.save().then(function () {
                                i++;
                                totalSlideElementCount++;
                                if (i == slidesApp.slideElementCollection.where({ slideId: oldSlideModel.get('tempId') }).length + slidesApp.slideElementCollection.where({ slideId: newSlideModel.id }).length)
                                    deferred.resolve();
                            });
                        }
                    }
                }
            }
            return deferred.promise();
        }

        function saveSlide(oldSlideModel) {
            var deferred = jQueryValamis.Deferred();
            if(oldSlideModel) {
                if (oldSlideModel.get('toBeRemoved'))
                    oldSlideModel.destroy();
                else {
                    var slideDOMElement = jQueryValamis('section#slide_' + (oldSlideModel.get('tempId') || oldSlideModel.id));

                    if (!oldSlideModel.get('title'))
                        oldSlideModel.set('title', 'Page');
                    oldSlideModel.save().then(function (newSlideModel) {
                        i = 0;
                        if(slidesApp.addedSlides.indexOf(newSlideModel.id) === -1)
                            slidesApp.addedSlides.push(newSlideModel.id);
                        var slideIsLeftFor = slidesApp.slideCollection.where({ leftSlideId: oldSlideModel.get('tempId') || newSlideModel.id });
                        var slideIsTopFor = slidesApp.slideCollection.where({topSlideId: oldSlideModel.get('tempId') || newSlideModel.id });

                        slideDOMElement.attr('id', 'slide_' + newSlideModel.id);

                        // Update linked slide ids
                        var elementsWithCorrectLinkedSlides = slidesApp.slideElementCollection.where({ correctLinkedSlideId: oldSlideModel.get('tempId') });
                        var elementsWithIncorrectLinkedSlides = slidesApp.slideElementCollection.where({ incorrectLinkedSlideId: oldSlideModel.get('tempId') });
                        _.each(elementsWithCorrectLinkedSlides, function(slideElementModel) {
                            slideElementModel.set('correctLinkedSlideId', newSlideModel.id);
                            slideElementModel.save();
                        });
                        _.each(elementsWithIncorrectLinkedSlides, function(slideElementModel) {
                            slideElementModel.set('incorrectLinkedSlideId', newSlideModel.id);
                            slideElementModel.save();
                        });

                        var slideElements = slidesApp.slideElementCollection.where({ slideId: oldSlideModel.get('tempId') })
                            .concat(slidesApp.slideElementCollection.where({ slideId: newSlideModel.id }));
                        if(slideElements.length == 0)
                            jQueryValamis.when(saveRelatedSlides(newSlideModel, slideIsLeftFor, slideIsTopFor)).then(function() {
                                totalSlideCount++;
                                deferred.resolve();
                            });
                        else
                            for(var j in slideElements) {
                                jQueryValamis.when(saveElement(oldSlideModel, newSlideModel, slideElements[j])).then(function() {
                                    if(j == slideElements.length - 1) {
                                        jQueryValamis.when(saveRelatedSlides(newSlideModel, slideIsLeftFor, slideIsTopFor)).then(function () {
                                            deferred.resolve();
                                        });
                                    }
                                    if (totalSlideCount == slidesApp.slideCollection.size() && totalSlideElementCount == slidesApp.slideElementCollection.size()) {
                                        deferred.resolve(slidesApp.slideSetModel);
                                    }
                                });
                            }
                    });
                }
            }
            return deferred.promise();
        }

        function saveRelatedSlides(newSlideModel, slideIsLeftFor, slideIsTopFor) {
            var deferred = jQueryValamis.Deferred();
            if(slideIsLeftFor.length > 0) {
                for (var j in slideIsLeftFor) {
                    slideIsLeftFor[j].set('leftSlideId', newSlideModel.id);
                    jQueryValamis.when(saveSlide(slideIsLeftFor[j])).then(function () {
                        if(slideIsTopFor.length > 0) {
                            for (var k in slideIsTopFor) {
                                slideIsTopFor[k].set('topSlideId', newSlideModel.id);
                                jQueryValamis.when(saveSlide(slideIsTopFor[k])).then(function() {
                                    if(k == slideIsTopFor.length - 1)
                                        deferred.resolve();
                                });
                            }
                        }
                        else {
                            if(j == slideIsLeftFor.length - 1)
                                deferred.resolve();
                        }
                    });
                }
            }
            else if(slideIsTopFor.length > 0) {
                for (var j in slideIsTopFor) {
                    slideIsTopFor[j].set('topSlideId', newSlideModel.id);
                    jQueryValamis.when(saveSlide(slideIsTopFor[j])).then(function() {
                        if(j == slideIsTopFor.length - 1)
                            deferred.resolve();
                    });
                }
            }
            else
                deferred.resolve();

            return deferred.promise();
        }

        function destroyRemovedModels(type) {
            var deferred = jQueryValamis.Deferred();
            var collection = type === 'slide' ? slidesApp.slideCollection : slidesApp.slideElementCollection;
            var models = _.clone(collection.models);
            var collectionSize = collection.size();
            if(collectionSize > 0) {
                _.each(models, function (model, index) {
                    if (model.get('toBeRemoved'))
                        model.destroy().then(function () {
                            if (index == collectionSize - 1)
                                deferred.resolve();
                        });
                    else if (index == collectionSize - 1)
                        deferred.resolve();
                });
            } else deferred.resolve();

            return deferred.promise();
        }

        function unsetTempIds() {
            slidesApp.slideCollection.each(function(slideModel) {
                slideModel.unset('tempId');
            });
            slidesApp.slideElementCollection.each(function(slideElementModel) {
                slideElementModel.unset('tempId');
            });
        }

        var rootSlide = jQueryValamis('.slides > section > section').first().length == 1
            ? jQueryValamis('.slides > section > section').first()
            : jQueryValamis(jQueryValamis(window.parent.document).find('.js-slideset-iframe')[0].contentDocument).find('.slides > section > section').first();
        var rootSlideModel = slidesApp.getSlideModel(rootSlide.attr('id').replace('slide_', ''));
        rootSlideModel.unset('leftSlideId');
        rootSlideModel.unset('topSlideId');
        jQueryValamis.when.apply(jQueryValamis, [ destroyRemovedModels('slide'), destroyRemovedModels('slideElement') ]).then(function(slideModels, slideElementModels) {
            jQueryValamis.when(saveSlide(rootSlideModel)).then(
                function(slideSetModel) {
                    unsetTempIds();
                    if (close)
                        window.slidesConfig.eventAggregator.trigger('slideset-saved-close');
                    toggleSavedState();
                    toastr.success(window.slidesConfig.translations['lessonWasSavedSuccessfullyLabel']);
                },
                function(slideSetModel) {
                    toastr.error(window.slidesConfig.translations['lessonFailedToSaveLabel']);
                }
            );
        });
    }

    return slidesApp.deferred.promise();
}

function toggleSavedState() {
    if(!slidesApp.initializing) {
        var saveButton = jQueryValamis(window.parent.document).find('.slides-editor-save');
        var changesSavedButton = jQueryValamis(window.parent.document).find('.slides-editor-changes-saved');
        var unsavedLabel = jQueryValamis(window.parent.document).find('.presentation-unsaved');
        if (slidesApp.actionStack.length === 0 || !slidesApp.isSaved) {
            saveButton.hide();
            changesSavedButton.show();
            unsavedLabel.hide();
            slidesApp.isSaved = true;
        }
        else {
            saveButton.show();
            changesSavedButton.hide();
            unsavedLabel.show();
            slidesApp.isSaved = false;
        }
    }
}

function togglePreviewMode() {
    if( slidesApp.mode == 'preview' ){//previous mode
        _.each(Marionette.ItemView.Registry.items,function(item){
            item.$el.removeClass('unactive');
            item.goToSlideActionDestroy();
            item.delegateEvents();
        });
        slidesApp.getRegion('editorArea').$el.removeAttr('style');
        jQueryValamis('.slides').css('border', '1px dashed #DEDEDE');
    }
    else {
        _.each(Marionette.ItemView.Registry.items,function(item){
            item.$el.addClass('unactive');
            item.undelegateEvents();
            item.goToSlideActionInit();
        });
        slidesApp.getRegion('editorArea').$el.css('left',0);
        jQueryValamis('.slides').css('border', 'none');
    }

    slidesApp.commands.execute('item:blur');

    slidesApp.getRegion('sidebar').$el.toggle();
    slidesApp.getRegion('revealControls').$el.toggle();
    jQueryValamis('.slides-grid').toggle();
    jQueryValamis('div[id^="slideEntity_"] .video-js').toggleClass('no-pointer-events');
    jQueryValamis('div[id^="slideEntity_"] iframe').toggleClass('no-pointer-events');
    window.parent.jQueryValamis('.js-slides-editor-topbar .js-editor-save-container').toggle();
    window.parent.jQueryValamis('.js-slides-editor-topbar .js-undo').toggle();

    placeSlideControls(jQueryValamis(window.parent).width(), jQueryValamis(window.parent).height());
}

function switchMode(mode, visualOnly, slideId) {
    slidesApp.commands.execute('item:blur');
    var btn = window.parent.jQueryValamis('.js-editor-' + mode.replace(':select', '') + '-mode');
    btn.siblings().removeClass('slides-primary');
    btn.siblings().removeClass('active');
    btn.siblings().addClass('slides-dark');
    btn.addClass('active');
    btn.addClass('slides-primary');
    btn.removeClass('slides-dark');

    if(!visualOnly) {
        switch (mode) {
            case 'arrange':
                arrangeModule.start();
                if (slidesApp.mode === 'preview') {
                    window.parent.jQueryValamis('.js-slides-editor-topbar .js-editor-save-container').toggle();
                    window.parent.jQueryValamis('.js-slides-editor-topbar .js-undo').toggle();
                }
                break;
            case 'preview':
                if (slidesApp.mode === 'arrange') {
                    toastr.info(slidesConfig.translations['slideSetModeSwitchingLabel'], { 'timeOut': '60000' });
                    setTimeout(function() {
                        revealModule.stop();
                        revealModule.start();
                        arrangeModule.stop();
                        jQueryValamis('#arrangeContainer').prevAll().show();
                        jQueryValamis('#arrangeContainer').empty();
                        if (slideId) {
                            var slideIndices = slidesApp.slideRegistry.getBySlideId(slideId);
                            Reveal.slide(slideIndices.h, slideIndices.v);
                        }
                        toggleSavedState();
                        togglePreviewMode();
                    }, 0);
                }
                else togglePreviewMode();
                break;
            case 'edit':
                if (slidesApp.selectedItemView) {
                    var selectedEntityId = slidesApp.selectedItemView.model.id || slidesApp.selectedItemView.model.get('tempId');
                    var entitySlideId = slidesApp.selectedItemView.model.get('slideId');
                }
                if (slideId) {
                    var linkTypeName = window.editorMode == 'arrange:select' ? 'correctLinkedSlideId' : 'incorrectLinkedSlideId';
                    slidesApp.getSlideElementModel(selectedEntityId).set(linkTypeName, slideId);
                    slidesApp.newValue = { linkType: linkTypeName, linkedSlideId: slideId };
                    slidesApp.commands.execute('action:push');
                }
                if (slidesApp.mode === 'preview')
                    togglePreviewMode();
                else {
                    toastr.info(slidesConfig.translations['slideSetModeSwitchingLabel'], { 'timeOut': '60000' });
                    setTimeout(function() {
                        revealModule.stop();
                        revealModule.start();
                        toggleSavedState();
                    }, 0);
                }
                if (slideId) {
                    if (slideId != entitySlideId) {
                        var slideIndices = slidesApp.slideRegistry.getBySlideId(entitySlideId);
                        Reveal.slide(slideIndices.h, slideIndices.v);
                    }
                    var currentEntity = slidesApp.getSlideElementModel(selectedEntityId);
                    var selectedView = Marionette.ItemView.Registry.getByModelId(currentEntity.cid);
                    selectedView.selectEl();
                }
                break;
        }
    }
    setTimeout(function() {
        slidesApp.mode = mode;
    }, 200);
}

var slidesApp = new Backbone.Marionette.Application({container: '#revealEditor'});

slidesApp.addRegions({
    sidebar: '.sidebar',
    editorArea: '.reveal-wrapper',
    revealControls: '.reveal-controls',
    arrangeArea: '#arrangeContainer'
});

slidesApp.activeElement = {
    model: null,
    view: null,
    moduleName: '',
    offsetX: 0,
    offsetY: 0,
    startX: 0,
    startY: 0,
    isMoving: false,
    isResizing: false
};

Marionette.ItemView.Registry = {
    items: {},
    register: function (id, object) {
        this.items[id] = object;
    },
    getByViewId: function (id) {
        return this.items[id] || null;
    },
    getByModelId: function (id) {
        for(var view in this.items) {
            if(this.items[view].model.cid === id) {
                return this.items[view];
                break;
            }
        }
    },
    remove: function (id) {
        delete this.items[id];
    },
    size: function() {
        return Object.keys(this.items).length;
    }
};

slidesApp.slideRegistry = {
    items: {},
    register: function (id, indices) {
        this.items[id] = indices;
    },
    getBySlideId: function (id) {
        return this.items[id] || null;
    },
    remove: function (id) {
        delete this.items[id];
    },
    size: function() {
        return Object.keys(this.items).length;
    }
};

slidesApp.getSlideModel = function (id) {
    var intId = parseInt(id);
    return (intId > 0)
        ? slidesApp.slideCollection.get(intId)
        : slidesApp.slideCollection.findWhere({tempId: intId});
};

slidesApp.getSlideElementModel = function (id) {
    var intId = parseInt(id);
    return (intId > 0)
        ? slidesApp.slideElementCollection.get(intId)
        : slidesApp.slideElementCollection.findWhere({tempId: intId});
};

slidesApp.initDnD = function() {
    jQueryValamis(slidesApp.container).mousemove(function(e) {
        if (slidesApp.activeElement.isMoving) {
            e.preventDefault();
            if (!slidesApp.activeElement.view) {
                slidesApp.commands.execute('item:create', true);
            }
            var offset = jQueryValamis('.slides').offset(),
                posSideTop = e.clientY - offset.top - slidesApp.activeElement.offsetY,
                posSideLeft = e.clientX - offset.left - slidesApp.activeElement.offsetX;

            posSideTop = slidesApp.GridSnapModule.getPosSideTop(posSideTop);
            posSideLeft = slidesApp.GridSnapModule.getPosSideLeft(posSideLeft);

            slidesApp.activeElement.view.model.set('top', posSideTop);
            slidesApp.activeElement.view.model.set('left', posSideLeft);

            slidesApp.activeElement.view.model.set('slideEntityType', slidesApp.activeElement.moduleName.substr(0, slidesApp.activeElement.moduleName.toLowerCase().indexOf("element")).toLowerCase());
        }
    });

    jQueryValamis(document).mousedown(function(e) {
        if (!slidesApp.activeElement.isMoving && slidesApp.activeElement.view !== null) {
            if(!slidesApp.activeElement.isResizing) {
                if (jQueryValamis(e.target).closest('div.rj-element').length == 0
                    && jQueryValamis(e.target).closest('div[id^="cke_editor"]').length == 0
                    && jQueryValamis(e.target).closest('div[class*="val-modal"]').length == 0) {
                    slidesApp.commands.execute('item:blur');
                    if(slidesApp.activeElement.view.editor)
                        slidesApp.activeElement.view.destroyEditor();
                }
            }
        }
        if(jQueryValamis(e.target).closest('.slide-popup-panel').length == 0) {
            if (jQueryValamis(e.target).closest('div.rj-element').length == 0
                && jQueryValamis(e.target).closest('div[id^="cke_editor"]').length == 0
                && jQueryValamis(e.target).closest('div[class*="val-modal"]').length == 0) {
                jQueryValamis('.slide-popup-panel').hide();
            }
        }
    });

    jQueryValamis(slidesApp.container).mouseup(function(e) {
        if(!slidesApp.activeElement.view) return;

        if (!slidesApp.activeElement.isResizing) {
            e.stopPropagation();
            if (!(e.clientX > slidesApp.activeElement.view.$el.offset().left
                && e.clientY > slidesApp.activeElement.view.$el.offset().top
                && e.clientX < slidesApp.activeElement.view.controls.offset().left + slidesApp.activeElement.view.controls.width()
                && e.clientY < slidesApp.activeElement.view.content.offset().top + slidesApp.activeElement.view.content.height())
                && jQueryValamis(e.target).closest('div[id^="cke_editor"]').length === 0
                && jQueryValamis(e.target).closest('div[class*="val-modal"]').length === 0) {
                slidesApp.activeElement.view = null;
                slidesApp.activeElement.moduleName = null;
            }
            else {
                if (slidesApp.oldValue)
                    slidesApp.newValue = {'top': slidesApp.activeElement.view.model.get('top'), 'left': slidesApp.activeElement.view.model.get('left')};
                else {
                    slidesApp.viewId = slidesApp.activeElement.view.cid;
                    slidesApp.actionType = 'itemCreated';
                    slidesApp.oldValue = null;
                    slidesApp.newValue = {indices: Reveal.getIndices(), view: slidesApp.activeElement.view.cid};
                    Marionette.ItemView.Registry.register(slidesApp.activeElement.view.cid, slidesApp.activeElement.view);
                }
            }
        }

        if(slidesApp.activeElement.view) {
            if(slidesApp.oldValue && slidesApp.newValue && JSON.stringify(slidesApp.newValue) !== JSON.stringify(slidesApp.oldValue)) {
                slidesApp.viewId = slidesApp.activeElement.view.cid;
                if(slidesApp.viewId && slidesApp.newValue && slidesApp.actionType)
                    slidesApp.commands.execute('action:push');
            }
        }

        slidesApp.activeElement.isMoving = false;
        slidesApp.GridSnapModule.removeLines();
    });
};

slidesApp.on('start', function(options){
    CKEDITOR.disableAutoInline = true;
    slidesApp.module('TextElementModule').start();
    slidesApp.module('ImageElementModule').start();
    slidesApp.module('IframeElementModule').start();
    slidesApp.module('QuestionElementModule').start();
    slidesApp.module('VideoElementModule').start();
    slidesApp.module('PdfElementModule').start();
    slidesApp.module('PptxElementModule').start();
    slidesApp.module('MathElementModule').start();
    slidesApp.actionStack = [];

    window.slidesConfig.eventAggregator.on('save-slideset', function(options) {
        saveSlideset(options);
    });
    window.slidesConfig.eventAggregator.on('switch-mode', switchMode, slidesApp);

    jQueryValamis(function() {
        jQueryValamis(document).unbind('keydown').keydown(function( event ) {
            if (slidesApp.activeElement.view) {
                if (slidesApp.activeElement.view && !slidesApp.isEditing) {
                    if (!event.ctrlKey && !event.shiftKey && event.keyCode == 46) {
                        slidesApp.commands.execute('item:delete', slidesApp.activeElement.view);
                    }
                }
                if (event.ctrlKey) {
                    if (!slidesApp.isEditing) {
                        if (event.keyCode == 67) {
                            slidesApp.itemCopy = slidesApp.activeElement.view;
                        }
                        if (event.keyCode == 86) {
                            slidesApp.commands.execute('item:duplicate', slidesApp.itemCopy);
                        }
                        if (event.keyCode == 90) {
                            undoAction();
                        }
                    }
                }
            }
            if (event.ctrlKey && event.keyCode == 83 && !slidesApp.isEditing) {
                event.preventDefault();
                window.slidesConfig.eventAggregator.trigger('save-slideset', { close: false });
            }
        });
    });
});

function isEditorEnabled() {
    for (var i in CKEDITOR.instances) {
        if (jQueryValamis('.cke_editor_' + i).is(':visible')) {
            return true;
        }
    }
    return false;
}

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
        _.extend(mustacheAccumulator,  window.slidesConfig.translations);
        _.extend(mustacheAccumulator, { header : this.header });
        this.template = _.template(Mustache.to_html(jQueryValamis(this.template).html(), mustacheAccumulator));
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