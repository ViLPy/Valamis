var revealModule = slidesApp.module('RevealModule', function (RevealModule, MyApp, Backbone, Marionette, $, _) {
    RevealModule.startWithParent = false;

    RevealModule.View = Marionette.ItemView.extend({
        template: '#revealTemplate',
        className: 'reveal',
        initialize: function() {
            this.listenTo(window.slidesConfig.eventAggregator, 'show-questionbank', this.showQuestionBank);
        },
        initReveal: function() {
            var self = this;
            Reveal.initialize({
                controls: true,
                progress: false,
                history: false,
                keyboard: true,
                loop: false,
                center: true,
                embedded: true,
                // Bounds for smallest/largest possible scale to apply to content
                minScale: 1.0,
                maxScale: 1.0,

                theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
                transition: Reveal.getQueryHash().transition || 'linear', // default/cube/page/concave/zoom/linear/fade/none
                keyboard: {
                    27: null // do nothing when ESC is pressed
                }
            });

            Reveal.addEventListener( 'slidechanged', function( event ) {
                this.indexh = event.indexh;
                this.indexv = event.indexv;
                slidesApp.maxZIndex = 0;
                _.each(jQueryValamis(Reveal.getCurrentSlide()).find('div[id^="slideEntity_"] > .item-content'), function(slideEntityContent) {
                    slidesApp.maxZIndex = Math.max(slidesApp.maxZIndex, parseInt(slideEntityContent.style.zIndex));
                });
                if(!slidesApp.initializing) {
                    if(!slidesApp.slideAdd)
                        slidesApp.activeSlideModel = slidesApp.getSlideModel(parseInt(jQueryValamis(Reveal.getCurrentSlide()).attr('id').slice(6)));
                    if(jQueryValamis('.slides > section > section').length > 1)
                        jQueryValamis('.js-slide-delete').show();
                    else
                        jQueryValamis('.js-slide-delete').hide();
                }
                if(jQueryValamis(Reveal.getCurrentSlide()).find('.question-element').length > 0) {
                    jQueryValamis('.toolbar').find('span.val-icon-question').closest('div').hide();
                }
                else {
                    jQueryValamis('.toolbar').find('span.val-icon-question').closest('div').show();
                }
                RevealModule.fitContent(event);
            }.bind(this) );

            Reveal.addEventListener( 'ready', function( event ) {
                RevealModule.fitContent(event);
            }.bind(this) );

            Reveal.slide(0);
            slidesApp.commands.execute('controls:place');
        },
        addPage: function(direction, slideModel, type) {
            slidesApp.viewId = this.cid;
            slidesApp.actionType = 'slideAdded';
            slidesApp.oldValue = Reveal.getIndices();
            slidesApp.oldValue.type = type || 'singleSlide';
            var currentPage = jQueryValamis(Reveal.getCurrentSlide());
            slidesApp.slideAdd = true;
            if(direction === 'right') {
                jQueryValamis('<section><section></section></section>').insertAfter(currentPage.parent());
                Reveal.right();
            }
            else if(direction === 'down') {
                jQueryValamis('<section></section>').insertAfter(currentPage);
                Reveal.down();
            }
            else
                return;

            slidesApp.slideAdd = false;
            currentPage = jQueryValamis(Reveal.getCurrentSlide());
            currentPage.attr('id', 'slide_' + (slideModel.id || slideModel.get('tempId')));
            if(slideModel.get('bgColor'))
                currentPage.attr('data-background-color', unescape(slideModel.get('bgColor')))

            if(slideModel.get('bgImage')) {
                var bgImageParts = unescape(slideModel.get('bgImage')).split(' '),
                    bgImageUrl = bgImageParts[0],
                    bgImageSize = bgImageParts[1];
                currentPage.attr('data-background', bgImageUrl);
                currentPage.attr('data-background-repeat', 'no-repeat');
                currentPage.attr('data-background-size', bgImageSize);
                currentPage.attr('data-background-position', 'center');
            }
            if(!slideModel.get('title'))
                slideModel.set('title', '');

            Reveal.sync();
            slidesApp.newValue = Reveal.getIndices();
            slidesApp.activeSlideModel = slideModel;
            if(!slidesApp.initializing) {
                slidesApp.commands.execute('reveal:page:updateRefs', currentPage, 'add');
                slidesApp.commands.execute('action:push');
            }
            var slideIndices = { h: Reveal.getIndices().h, v: Reveal.getIndices().v };
            if(slidesApp.initializing)
                slideIndices.h--;
            slidesApp.slideRegistry.register(slideModel.id || slideModel.get('tempId'), slideIndices);
            slidesApp.slideCollection.add(slideModel);
            slidesApp.commands.execute('reveal:page:makeActive');
        },
        deleteCurrentPage: function() {
            jQueryValamis('.toolbar').find('.question-element').first().remove();
            var currentPage = jQueryValamis(Reveal.getCurrentSlide());
            var currentPageSiblingsBefore = currentPage.prevAll().length + currentPage.parent().prevAll().length;
            var isOnlyPageInGroup = (jQueryValamis('section', currentPage.parent()).length == 1);

            if(!slidesApp.initializing) {
//                if (slidesApp.activeSlideModel.id) {
                    slidesApp.activeSlideModel.set('toBeRemoved', true);
                    var prevPageLeft = currentPage.parent().prev().children('section[id^="slide_"]').first();
                    var prevPageUp = currentPage.prev('section[id^="slide_"]');
                    var currentPageIndices = Reveal.getIndices();
                    var slideElements = slidesApp.slideElementCollection.where({ slideId: slidesApp.activeSlideModel.id || slidesApp.activeSlideModel.get('tempId') });
                    var correctLinkedSlideElements = slidesApp.slideElementCollection.where({ correctLinkedSlideId: slidesApp.activeSlideModel.id || slidesApp.activeSlideModel.get('tempId') });
                    var incorrectLinkedSlideElements = slidesApp.slideElementCollection.where({ incorrectLinkedSlideId: slidesApp.activeSlideModel.id || slidesApp.activeSlideModel.get('tempId') });
                    _.each(correctLinkedSlideElements, function(slideElementModel) {
                        slideElementModel.set('correctLinkedSlideId', undefined);
                        Marionette.ItemView.Registry.getByModelId(slideElementModel.cid).applyLinkedType('correctLinkedSlideId');
                    });
                    _.each(incorrectLinkedSlideElements, function(slideElementModel) {
                        slideElementModel.set('incorrectLinkedSlideId', undefined);
                        Marionette.ItemView.Registry.getByModelId(slideElementModel.cid).applyLinkedType('incorrectLinkedSlideId');
                    });

                    slidesApp.oldValue = {
                        indices: { h: currentPageIndices.h, v: currentPageIndices.v - 1, f: currentPageIndices.f },
                        slideModel: slidesApp.activeSlideModel,
                        slideEntities: slideElements
                    };
                    if(prevPageUp.length > 0)
                        slidesApp.oldValue.direction = 'down';
                    else if(prevPageLeft.length > 0)
                        slidesApp.oldValue.direction = 'right';
                    slidesApp.commands.execute('reveal:page:updateRefs', currentPage, 'delete');
                    slidesApp.viewId = this.cid;
                    slidesApp.actionType = 'slideRemoved';
                    slidesApp.newValue = null;

                    slidesApp.commands.execute('action:push');
//                }

                slidesApp.slideRegistry.remove(slidesApp.activeSlideModel.id || slidesApp.activeSlideModel.get('tempId'));
            }

            if (isOnlyPageInGroup) {
                // can delete the whole group and move to the right/left
                currentPage.parent().remove();
            } else {
                // can delete only section and move to the down/up
                currentPage.remove();
            }

            if(currentPageSiblingsBefore > 0)
                Reveal.prev();
            else
                Reveal.slide(0, 0);
            Reveal.sync();
            slidesApp.activeSlideModel = slidesApp.getSlideModel(parseInt(jQueryValamis(Reveal.getCurrentSlide()).attr('id').slice(6)));
            slidesApp.commands.execute('reveal:page:makeActive');

            if(jQueryValamis('.slides > section > section').length == 1)
                jQueryValamis('.js-slide-delete').hide();
        },
        updateSlideRefs: function(currentPage, actionType) {
            var nextPageRight = currentPage.parent().next().children('section[id^="slide_"]').first();
            var nextPageDown = currentPage.next('section[id^="slide_"]');
            var prevPageLeft = currentPage.parent().prev().children('section[id^="slide_"]').first();
            var prevPageUp = currentPage.prev('section[id^="slide_"]');
            switch(actionType) {
                case 'add':
                    if(nextPageRight.length > 0 && currentPage.prevAll('section').length === 0) {
                        var idToChangeLeft = parseInt(nextPageRight.attr('id').slice(6));
                        var newLeftId = parseInt(currentPage.attr('id').slice(6));
                        slidesApp.getSlideModel(idToChangeLeft).set('leftSlideId', newLeftId);
                    }
                    if(nextPageDown.length > 0) {
                        var idToChangeTop = parseInt(nextPageDown.attr('id').slice(6));
                        var newTopId = parseInt(currentPage.attr('id').slice(6));
                        slidesApp.getSlideModel(idToChangeTop).set('topSlideId', newTopId);
                    }

                    if(prevPageUp.length > 0)
                        slidesApp.activeSlideModel.set('topSlideId', parseInt(prevPageUp.attr('id').slice(6)));
                    else if(prevPageLeft.length > 0)
                        slidesApp.activeSlideModel.set('leftSlideId', parseInt(prevPageLeft.attr('id').slice(6)));
                    break;
                case 'delete':
                    if(nextPageRight.length > 0 && prevPageUp.length == 0) {
                        var idToChangeLeft = parseInt(nextPageRight.attr('id').slice(6));
                        var newLeftId = (currentPage.next('section[id^="slide_"]').length > 0)
                            ? parseInt(currentPage.next('section[id^="slide_"]').attr('id').slice(6))
                            : (currentPage.parent().prev().children('section[id^="slide_"]').first().length > 0)
                                ? parseInt(currentPage.parent().prev().children('section[id^="slide_"]').first().attr('id').slice(6))
                                : undefined;
                        slidesApp.getSlideModel(idToChangeLeft).set('leftSlideId', newLeftId);
                    }
                    if(nextPageDown.length > 0) {
                        var idToChangeTop = parseInt(nextPageDown.attr('id').slice(6));
                        var newTopId = (currentPage.prev('section[id^="slide_"]').length > 0)
                            ? parseInt(currentPage.prev('section[id^="slide_"]').attr('id').slice(6))
                            : undefined;

                        slidesApp.getSlideModel(idToChangeTop).set('topSlideId', newTopId);
                    }
                    break;
            }
        },
        changeBackground: function(color) {
            var slide = jQueryValamis(Reveal.getCurrentSlide());
            slidesApp.viewId = this.cid;
            slidesApp.actionType = 'slideBackgroundChanged';
            slidesApp.oldValue = {indices: Reveal.getIndices(), backgroundType: 'color', background: slide.attr('data-background-color') || ''};
            slidesApp.newValue = {indices: Reveal.getIndices(), backgroundType: 'color', background: color};
            slidesApp.activeSlideModel.set('bgColor', color);
            slide.attr('data-background-color', color);
            Reveal.sync();
//            if(slidesApp.isSaved)
                slidesApp.commands.execute('action:push');

            // Update slide thumbnails in tooltips
            var slideId = slidesApp.activeSlideModel.id || slidesApp.activeSlideModel.get('tempId');
            var slideIsLinkedTo = slidesApp.slideElementCollection.where({ correctLinkedSlideId: slideId }).concat(
                slidesApp.slideElementCollection.where({ incorrectLinkedSlideId: slideId })
            );
            for(var i in slideIsLinkedTo) {
                var slideElementDOMNode = jQueryValamis('#slideEntity_' + (slideIsLinkedTo[i].id || slideIsLinkedTo[i].get('tempId')));
                if(slideIsLinkedTo[i].get('correctLinkedSlideId') == slideId)
                    slideElementDOMNode.find('.linked-slide-thumbnail').css('background-color', color);
                if(slideIsLinkedTo[i].get('incorrectLinkedSlideId') == slideId)
                    slideElementDOMNode.find('.linked-slide-thumbnail.incorrect').css('background-color', color);
            }
        },
        changeBackgroundImage: function(image) {
            var imageParts = image.split(' ');
            var slide = jQueryValamis(Reveal.getCurrentSlide());
            slidesApp.viewId = this.cid;
            slidesApp.actionType = 'slideBackgroundChanged';
            slidesApp.oldValue = { indices: Reveal.getIndices(), backgroundType: 'image', background: slide.attr('data-background') || '' };
            slidesApp.newValue = { indices: Reveal.getIndices(), backgroundType: 'image', background: image !== '' ? ('url("' + imageParts[0] + '") ' + imageParts[1]) : '' };
            slide.attr('data-background', imageParts[0] || '');
            slide.attr('data-background-image', imageParts[0] || '');
            slide.attr('data-background-size', imageParts[1] || '');
            slidesApp.activeSlideModel.set('bgImage', image !== '' ? ('url("' + imageParts[0] + '") ' + imageParts[1]) : '');
            Reveal.sync();

//            if(slidesApp.isSaved)
                slidesApp.commands.execute('action:push');

            // Update slide thumbnails in tooltips
            var slideIsLinkedTo = slidesApp.slideElementCollection.where({ correctLinkedSlideId: slidesApp.activeSlideModel.id || slidesApp.activeSlideModel.get('tempId') }).concat(
                slidesApp.slideElementCollection.where({ incorrectLinkedSlideId: slidesApp.activeSlideModel.id || slidesApp.activeSlideModel.get('tempId') })
            );
            for(var slideElement in slideIsLinkedTo) {
                var slideElementDOMNode = jQueryValamis('#slideEntity_' + (slideElement.id || slideElement.get('tempId')));
                slideElementDOMNode.find('.linked-slide-thumbnail').css({
                    'background': imageParts[0] + ' no-repeat',
                    'background-size': imageParts[1],
                    'background-position': 'center'
                });
                slideElementDOMNode.find('.linked-slide-thumbnail.incorrect').css({
                    'background': imageParts[0] + ' no-repeat',
                    'background-size': imageParts[1],
                    'background-position': 'center'
                });
            }
        },
        showQuestionBank: function(SlideElementModel) {
            slidesApp.commands.execute('questionbank:show:modal', SlideElementModel);
        }
    });

    var view;

    RevealModule.onStart = function() {
        view = new RevealModule.View();

        slidesApp.commands.setHandler('reveal:page:addRight', function(model) {
            var slideModel = model
                ? model
                : new SlideModel({
                    tempId: slidesApp.newSlideId--,
                    slideSetId: slidesApp.slideSetModel.id
                });
            view.addPage('right', slideModel);
        });
        slidesApp.commands.setHandler('reveal:page:addDown', function(model, type) {
            var slideModel = model
                ? model
                : new SlideModel({
                tempId: slidesApp.newSlideId--,
                slideSetId: slidesApp.slideSetModel.id
            });
            view.addPage('down', slideModel, type);
        });
        slidesApp.commands.setHandler('reveal:page:delete', view.deleteCurrentPage);
        slidesApp.commands.setHandler('reveal:page:changeBackground', function(color) {view.changeBackground(color)});
        slidesApp.commands.setHandler('reveal:page:changeBackgroundImage', function(image) {view.changeBackgroundImage(image)});
        slidesApp.commands.setHandler('reveal:page:updateRefs', function(currentPage, actionType) {view.updateSlideRefs(currentPage, actionType)});
        slidesApp.commands.setHandler('reveal:page:makeActive', function() {
            if(!slidesApp.initializing) {
                var activeSlide = slidesApp.slideCollection.where({tempId: parseInt(jQueryValamis(Reveal.getCurrentSlide()).attr('id').slice(6))});
                for(var i in activeSlide) {
                    slidesApp.activeSlideModel = activeSlide[i];
                }
            }
        });
    };

    RevealModule.fitContent = function(event){
        var windowHeight = window.parent ? jQueryValamis(window.parent).height() : jQueryValamis(window).height(),
            currentSlide = event && event.currentSlide ? jQueryValamis(event.currentSlide) : jQueryValamis(Reveal.getCurrentSlide()),
            slidesWrapper = jQueryValamis('.reveal-wrapper:first'),
            contentHeight = 0;
        var revealControlsPosY = windowHeight - jQueryValamis('.controls', slidesWrapper).outerHeight() - 60;
        if( windowHeight > 860 ){ revealControlsPosY += 10; }
        slidesWrapper.scrollTop(0).removeClass('scroll-y').unbind('scroll');
        jQueryValamis('.backgrounds', slidesWrapper).css('top','auto');
        jQueryValamis('.controls', slidesWrapper).css('top', revealControlsPosY+'px');
        jQueryValamis('.item-content', currentSlide).each(function(i){
            if( !jQueryValamis(this).parent().hasClass('rj-video') && jQueryValamis.trim(jQueryValamis(this).text()).length > 10 ){
                var realHeight = jQueryValamis(this).css('height','auto').outerHeight(true);
                if( realHeight > contentHeight ){
                    contentHeight = realHeight;
                }
            }
        });
        if( contentHeight > slidesWrapper.height() ){
            RevealModule.fitContentScrollInit();
        }
    };

    RevealModule.fitContentScrollInit = function(){
        var slidesWrapper = jQueryValamis('.reveal-wrapper:first');
        slidesWrapper
            .addClass('scroll-y')
            .bind('scroll',function(){
                var windowHeight = window.parent ? jQueryValamis(window.parent).height() : jQueryValamis(window).height();
                var scrollTop = jQueryValamis(this).scrollTop();
                var revealControlsPosY = windowHeight - jQueryValamis('.controls', slidesWrapper).outerHeight() - 60;
                if( windowHeight > 860 ){ revealControlsPosY += 10; }
                revealControlsPosY += scrollTop;
                jQueryValamis('.backgrounds', slidesWrapper).css('top', scrollTop + 'px');
                jQueryValamis('.controls', slidesWrapper).css('top', revealControlsPosY + 'px');
            });
    };

    RevealModule.renderSlideset = function() {
        slidesApp.editorArea.on('show', view.initReveal);
        slidesApp.editorArea.show(view);

        slidesApp.addedSlides = [];
        slidesApp.addedSlideIndices = [];
        slidesApp.addedSlideElements = [];
        slidesApp.maxZIndex = 0;
        Marionette.ItemView.Registry.items = {};
        slidesApp.initializing = true;

        jQueryValamis('.slides').find('> section:gt(0)').remove();
        jQueryValamis('.slides').find('> section > section:gt(0)').remove();
        var rootSlide = slidesApp.slideCollection.where({ leftSlideId: undefined, topSlideId: undefined })[0];
        if (slidesApp.addedSlides.indexOf(rootSlide.id) === -1) {
            view.addPage('right', rootSlide);
            slidesApp.addedSlideIndices[rootSlide.id || rootSlide.get('tempId')] = Reveal.getIndices();
            if(!slidesApp.isRunning)
                var slideElements = rootSlide.get('slideElements');
            else
                var slideElements = slidesApp.slideElementCollection.where({slideId: (rootSlide.id || rootSlide.get('tempId'))});
            if (slideElements.length > 0)
                RevealModule.forEachSlideElement(new SlideElementCollection(slideElements));
            slidesApp.addedSlides.push(rootSlide.id);
            RevealModule.forEachSlide(rootSlide.id || rootSlide.get('tempId'));
        }
        Reveal.slide(0, 0);
        view.deleteCurrentPage();
        Reveal.sync();
        if(jQueryValamis(Reveal.getCurrentSlide()).find('.question-element').length > 0)
            jQueryValamis('.toolbar').find('span.val-icon-question').closest('div').hide();
        slidesApp.initializing = false;
        slidesApp.isSaved = true;
        slidesApp.maxZIndex = 0;
        _.each(jQueryValamis(Reveal.getCurrentSlide()).find('div[id^="slideEntity_"] > .item-content'), function(slideEntityContent) {
            slidesApp.maxZIndex = Math.max(slidesApp.maxZIndex, parseInt(slideEntityContent.style.zIndex));
        });

        var slideElementControls = jQueryValamis('.item-controls').find('button');
        _.each(slideElementControls, function(btn) {
            if(jQueryValamis(btn).is('.js-item-link') || jQueryValamis(btn).is('.js-item-link-incorrect')) {
                var slideElementModel = slidesApp.getSlideElementModel(jQueryValamis(btn).closest('div[id^="slideEntity_"]').attr('id').replace('slideEntity_', ''));
                var linkTypeName = jQueryValamis(btn).is('.js-item-link') ? 'correct' : 'incorrect';
                var slideModel = slideElementModel.get(linkTypeName + 'LinkedSlideId') ? slidesApp.getSlideModel(slideElementModel.get(linkTypeName + 'LinkedSlideId')) : undefined;
                if(slideModel) {
                    var slideBackgroundImageParts = slideModel.get('bgImage') ? slideModel.get('bgImage').split(' ') : ['', ''];
                    var slideThumbnail = jQueryValamis(btn).find('.linked-slide-thumbnail').css({
                        'background': slideBackgroundImageParts[0] + ' no-repeat',
                        'background-size': slideBackgroundImageParts[1],
                        'background-position': 'center',
                        'background-color': unescape(slideModel.get('bgColor')) || ''
                    });
                    slideThumbnail.html(jQueryValamis('#slide_' + slideElementModel.get(linkTypeName + 'LinkedSlideId')).clone().html());
                    slideThumbnail.addClass('slide-thumbnail-bordered');
                    slideThumbnail.find('.item-border, .item-controls, .ui-resizable-handle').hide();
                } else {
                    var slideThumbnail = jQueryValamis(btn).find('.linked-slide-thumbnail').css({
                        'background-color': 'transparent',
                        'background-image': ''
                    });
                    slideThumbnail.html('');
                    slideThumbnail.removeClass('slide-thumbnail-bordered');
                }
            }
        });
        Reveal.sync();

        slidesApp.activeSlideModel = slidesApp.slideCollection.get(parseInt(jQueryValamis(Reveal.getCurrentSlide()).attr('id').slice(6)));

        slidesApp.module('RevealControlsModule').start();
        slidesApp.initDnD();
        if (slidesApp.slideCollection.models.length > 1)
           jQueryValamis('.js-slide-delete').show();
        else
           jQueryValamis('.js-slide-delete').hide();

//        slidesApp.saveInterval = setInterval(saveSlideset, 60000, {close: false});
        slidesApp.commands.execute('controls:place');
        slidesApp.commands.execute('item:blur');
        if(!slidesApp.isRunning)
            slidesConfig.eventAggregator.trigger('editor-ready', slidesApp.slideSetModel);
        else
            slidesConfig.eventAggregator.trigger('editor-reloaded');
        slidesApp.isRunning = true;
        jQueryValamis('#js-slide-title').attr('placeholder', translations['pageDefaultTitleLabel']);
        jQueryValamis('#js-slide-statement-object').attr('placeholder', translations['pageDefaultTitleLabel']);

        var canvas = jQueryValamis('#grid-canvas');
        var context = canvas[0].getContext("2d");

        for (var x = 80; x < canvas.width(); x += 80) {
            context.moveTo(x, 0);
            context.lineTo(x, canvas.height());
        }

        for (var y = 70; y < canvas.height(); y += 70) {
            context.moveTo(0, y);
            context.lineTo(canvas.width(), y);
        }

        context.strokeStyle = "#DEDEDE";
        context.lineWidth = 1;
        context.stroke();
    };

    RevealModule.forEachSlide = function(id) {
        slidesApp.slideCollection.each(function(slide) {
            if(!slide.get('toBeRemoved')) {
                if (slide.get('leftSlideId') == id || slide.get('topSlideId') == id) {
                    if (slide.id != id || slide.get('tempId') != id) {
                        Reveal.slide(slidesApp.addedSlideIndices[id].h, slidesApp.addedSlideIndices[id].v);
                        if (slide.get('leftSlideId') == id) {
                            view.addPage('right', slide);
                        }
                        else if (slide.get('topSlideId') == id) {
                            view.addPage('down', slide);
                        }
                        slidesApp.addedSlideIndices[slide.id || slide.get('tempId')] = Reveal.getIndices();
                        if(!slidesApp.isRunning)
                            var slideElements = slide.get('slideElements');
                        else
                            var slideElements = slidesApp.slideElementCollection.where({slideId: (slide.id || slide.get('tempId'))});
                        if (slideElements.length > 0)
                            RevealModule.forEachSlideElement(new SlideElementCollection(slideElements));
                        slidesApp.addedSlides.push(slide.id);
                        RevealModule.forEachSlide(slide.id || slide.get('tempId'));
                    }
                }
            }
        });
    };

    RevealModule.forEachSlideElement = function(slideElements) {
        slideElements.each(function(SlideElementModel) {
            if(!SlideElementModel.get('toBeRemoved')) {
                slidesApp.commands.execute('drag:prepare:new', SlideElementModel, 0, 0);
                slidesApp.commands.execute('item:create', false);
                slidesApp.activeElement.isMoving = false;

                slidesApp.slideElementCollection.add(SlideElementModel);
                slidesApp.addedSlideElements.push(SlideElementModel.id);
            }
        });
    };
});

revealModule.on('start', function(options){
    revealModule.onStart();
    revealModule.renderSlideset();
    if( jQueryValamis('#arrangeContainer').size() == 0 ) {
        jQueryValamis('#revealEditor').append('<div id="arrangeContainer"></div>');
    }
});

revealModule.on('stop', function() {
    window.isEditorReady = false;
});