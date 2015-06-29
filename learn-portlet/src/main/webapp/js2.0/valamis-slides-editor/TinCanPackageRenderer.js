/**
 * Created by aklimov on 18.03.15.
 */
var slidesApp = new Backbone.Marionette.Application({container: 'body'});

var translations = { 'typeYourAnswerLabel': 'Type your answer here' };

slidesApp.addRegions({
    editorArea: '.reveal-wrapper'
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

slidesApp.getSlideModel = function (id) {
    return (id > 0)
        ? slidesApp.slideCollection.get(id)
        : slidesApp.slideCollection.where({tempId: id})[0];
};

var revealModule = slidesApp.module('RevealModule', function (RevealModule, slidesApp, Backbone, Marionette, $, _) {
    RevealModule.startWithParent = false;

    RevealModule.View = Marionette.ItemView.extend({
        template: '#revealTemplate',
        className: 'reveal',
        initReveal: function() {
            this.defaultParams = {
                controls: true,
                progress: true,
                history: true,
                center: true,
                viewDistance: 2,
//                theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
                transition: 'linear', // default/cube/page/concave/zoom/linear/fade/none
                transitionSpeed: 'default',
                backgroundTransition: 'none',
                dependencies: [
                    // Syntax highlight for <code> elements
                    { src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } }
                ],
                help: false
            };
            var self = this;
            if(jQuery(window).width() > 1024)
                Reveal.initialize(jQuery.extend({minScale: 1.0, maxScale: 1.0}, self.defaultParams));
            else Reveal.initialize(self.defaultParams);
            Reveal.slide(0, 0);

            Reveal.addEventListener( 'slidechanged', function(event){
                if(!slidesApp.slideAdd)
                    slidesApp.activeSlideModel = slidesApp.getSlideModel(parseInt(jQuery(event.previousSlide).attr('id').replace('slide_', '')));
                self.currentView.fitContent(event);
            });
            Reveal.addEventListener( 'ready', function(event){
                self.currentView.fitContent(event);
                RevealModule.bindEventsToControls();
            });

        },
        fitContent: function(event){
            var currentSlide = event && event.currentSlide ? jQuery(event.currentSlide) : jQuery(Reveal.getCurrentSlide()),
                slidesWrapper = jQuery('.reveal-wrapper:first'),
                contentHeight = 0;
            slidesWrapper.scrollTop(0).removeClass('scroll-y').unbind('scroll');
            jQuery('.backgrounds',slidesWrapper).css('top','auto');
            jQuery('.controls',slidesWrapper).css('bottom','10px');
            jQuery('.item-content',currentSlide).each(function(i){
                if( jQuery.trim(jQuery(this).text()).length > 10 ){
                    var realHeight = jQuery(this).css('height','auto').outerHeight(true);
                    if( realHeight > contentHeight ){
                        contentHeight = realHeight;
                    }
                }
            });
            if( contentHeight > slidesWrapper.height() ){
                slidesWrapper
                    .addClass('scroll-y')
                    .bind('scroll',function(){
                        var scrollTop = jQuery(this).scrollTop();
                        jQuery('.backgrounds',slidesWrapper).css('top',scrollTop+'px');
                        jQuery('.controls',slidesWrapper).css('bottom',(0 - scrollTop + 10)+'px');
                    })
            }
        },
        addPage: function (direction, slideModel) {
            var currentPage = jQuery(Reveal.getCurrentSlide());
            slidesApp.slideAdd = true;
            if (direction === 'right') {
                jQuery('<section><section></section></section>').insertAfter(currentPage.parent());
                Reveal.right();
            }
            else if (direction === 'down') {
                jQuery('<section></section>').insertAfter(currentPage);
                Reveal.down();
            }
            else
                return;

            slidesApp.slideAdd = false;
            currentPage = jQuery(Reveal.getCurrentSlide());
            currentPage.attr('id', 'slide_' + (slideModel.id || slideModel.get('tempId')));
            currentPage.attr('title', slideModel.get('title') || '');
            if(slideModel.get('bgColor'))
                currentPage.attr('data-background-color', unescape(slideModel.get('bgColor')));

            if (slideModel.get('bgImage')) {
                var bgImageParts = slideModel.get('bgImage').split(' '),
                    bgImageUrl = bgImageParts[0],
                    bgImageSize = bgImageParts[1];
                currentPage.attr('data-background', RevealModule.getFileURL(bgImageUrl));
                currentPage.attr('data-background-repeat', 'no-repeat');
                currentPage.attr('data-background-size', bgImageSize);
                currentPage.attr('data-background-position', 'center');
            }
            Reveal.sync();
        },
        deleteCurrentPage: function() {
            var currentPage = jQuery(Reveal.getCurrentSlide());
            var currentPageSiblingsBefore = currentPage.parent().prevAll().length;
            var isOnlyPageInGroup = (jQuery('section', currentPage.parent()).length === 1);
            if (isOnlyPageInGroup) {
                // can delete the whole group and move to the right/left
                currentPage.parent().remove();
            } else {
                // can delete only section and move to the down/up
                currentPage.remove();
            }
            for(var i in slidesApp.addedSlideIndices){
                if(slidesApp.addedSlideIndices.hasOwnProperty(i)) {
                    slidesApp.addedSlideIndices[i].h--;
                }
            }
            if(currentPageSiblingsBefore > 0)
                Reveal.prev();
            else
                Reveal.slide(0, 0);

            slidesApp.activeSlideModel = slidesApp.getSlideModel(parseInt(jQuery(Reveal.getCurrentSlide()).attr('id').replace('slide_', '')));
        }
    });

    RevealModule.getFileURL = function(content) {
//        var data = '#1C1C1C';
        var data = content || '#1C1C1C';
        if(content.indexOf('url("../') == 0)
            data = content.replace('url("../', '').replace('")', '');
        else if(content.indexOf('url("/delegate') == 0) {
            var folderName = /folderId=([^&]*)/g.exec(content)[1];
            var fileName =  /file=([^&]*).*"\)/g.exec(content)[1];
            data = 'url("resources/' + folderName + '/' + fileName + '") no-repeat';
        }
        else if(content.indexOf('url("/documents') == 0) {
            var folderName = /entryId=([^&]*)/g.exec(content)[1];
            var fileName =  /documents\/[^/]*\/[^/]*\/([^/]*)/g.exec(content)[1];
            var fileExt =  /ext=([^&]*).*"\)/g.exec(content)[1];
            data = 'url("resources/' + folderName + '/' + fileName + '.' + fileExt + '") no-repeat';
        }
        else if(content.indexOf('/documents/') == 0) {
            var folderName = /([^/?]*)\?groupId=/g.exec(content)[1];
            var fileName =  /documents\/[^/]*\/[^/]*\/([^/]*)/g.exec(content)[1];
            var fileExt =  /ext=([^&]*).*/g.exec(content)[1];
            data = 'resources/' + folderName + '/' + fileName + '.' + fileExt;
        }
        else if(content.indexOf('/learn-portlet/preview-resources/pdf/') == 0) {
            var folderName = /files\/([^/]*)/g.exec(content)[1];
            var fileName =  /files\/[^/]*\/([^/]*)/g.exec(content)[1];
            data = 'pdf/web/viewer.html?file=../../resources/' + folderName + '/' + fileName;
        }
        else if(content.indexOf('docs.google.com/file/d/') != -1 || content.indexOf('youtube.com/') != -1)
            data = content.replace(/watch\?v=/g, 'embed/');

        return data;
    };

    var revealView = new RevealModule.View();

    RevealModule.forEachSlide = function (id) {
        slidesApp.slideCollection.each(function (slide) {
            if (slide.get('leftSlideId') === id || slide.get('topSlideId') === id) {
                if (slidesApp.addedSlides.indexOf(slide.id) === -1) {
                    Reveal.slide(slidesApp.addedSlideIndices[id].h, slidesApp.addedSlideIndices[id].v);
                    if (slide.get('leftSlideId') === id) {
                        revealView.addPage('right', slide);
                    }
                    else if (slide.get('topSlideId') === id) {
                        revealView.addPage('down', slide);
                    }
                    slidesApp.addedSlideIndices[slide.id] = Reveal.getIndices();
                    var slideEntities = slide.get('slideElements');
                    if (slideEntities.length > 0)
                        RevealModule.forEachSlideElement(new SlideElementCollection(slideEntities));
                    slidesApp.addedSlides.push(slide.id);
                    RevealModule.forEachSlide(slide.id);
                }
            }
        });
    };

    RevealModule.forEachSlideElement = function (slideEntities) {
        slideEntities.each(function (model) {
            slidesApp.activeElement.model = model;
            slidesApp.activeElement.view = null;
            slidesApp.activeElement.moduleName = model.get('slideEntityType').charAt(0).toUpperCase() + model.get('slideEntityType').slice(1) + 'ElementModule';

            var ViewModel = slidesApp.TinCanPackageGenericItem.GenericItemView;
            var model = slidesApp.activeElement.model;
            model.set('content', model.get('content'));

            slidesApp.activeElement.model = model;

            var view = new ViewModel({model: model});
            var elem = view.render().$el;
            elem.attr('id', 'slideEntity_' + (model.id || model.get('tempId')));
            jQuery(Reveal.getCurrentSlide()).append(elem);
            view.goToSlideActionInit();
            slidesApp.activeElement.view = view;
        });
    };

    RevealModule.renderSlideset = function() {
        slidesApp.editorArea.on('show', revealView.initReveal);
        slidesApp.editorArea.show(revealView);
        slidesApp.addedSlides = [];
        slidesApp.addedSlideIndices = [];
        slidesApp.playerCheckIntervals = [];
        slidesApp.initializing = true;
        jQuery('.slides').find('> section:gt(0)').remove();
        jQuery('.slides').find('> section > section:gt(0)').remove();
        jQuery('.slides').css('border', 'none');
        jQuery('.slides-grid').hide();
        var rootSlide = slidesApp.slideCollection.where({ leftSlideId: undefined, topSlideId: undefined })[0];
        if (slidesApp.addedSlides.indexOf(rootSlide.id) === -1) {
            revealView.addPage('right', rootSlide);
            slidesApp.addedSlideIndices[rootSlide.id] = Reveal.getIndices();
            var slideEntities = rootSlide.get('slideElements');
            if (slideEntities.length > 0)
                RevealModule.forEachSlideElement(new SlideElementCollection(slideEntities));
            slidesApp.addedSlides.push(rootSlide.id);
            RevealModule.forEachSlide(rootSlide.id);
        }
        Reveal.slide(0, 0);
        revealView.deleteCurrentPage();
        Reveal.sync();
        window.slideId = $(Reveal.getCurrentSlide()).attr('id');
        window.slideTitle = slidesApp.getSlideModel(parseInt($(Reveal.getCurrentSlide()).attr('id').replace('slide_', ''))).get('title');
        slidesApp.initializing = false;
    };

    RevealModule.bindEventsToControls = function() {
        var pointerEvents = navigator.userAgent.match( /android/gi )
            ? [ 'touchstart' ]
            : [ 'touchstart', 'click' ];
        Reveal.removeEventListeners();
        pointerEvents.forEach( function( eventName ) {
            jQuery('.reveal-wrapper .controls > div').each(function(){
                jQuery(this).get(0)
                    .addEventListener( eventName, RevealModule.onControlBeforeAction, false );
            });
        });
        Reveal.addEventListeners();
    };

    RevealModule.onControlBeforeAction = function(e) {

        var currentSlide = Reveal.getCurrentSlide(),
            currentSlideId = jQuery(currentSlide).attr('id').replace('slide_',''),
            currentStateId = jQuery(currentSlide).data('state'),
            questionID = currentStateId ? _.last(currentStateId.split('_')) : null;

        if( questionID ){

            var currentSlideModel = slidesApp.slideCollection.get( { id: currentSlideId }),
                questionElement = _.find(currentSlideModel.get('slideElements'), function(slideElement) {
                    return slideElement.slideEntityType == 'question';
                }),
                questionResults = TinCanCourseHelpers['collectAnswers_'+questionID] ? TinCanCourseHelpers['collectAnswers_'+questionID]() : null;

            if( questionElement && questionResults && ( questionElement.correctLinkedSlideId || questionElement.incorrectLinkedSlideId ) ) {
                var nextSlideId = questionResults.isPassed ? questionElement.correctLinkedSlideId : questionElement.incorrectLinkedSlideId;
                if( nextSlideId && slidesApp.addedSlideIndices[parseInt(nextSlideId)] ) {
                    var slideIndices = slidesApp.addedSlideIndices[parseInt(nextSlideId)];
                    Reveal.slide(slideIndices.h, slideIndices.v);
                    e.stopImmediatePropagation();
                }
            }
        }
    };
});

slidesApp.on('start', function() {
    if(typeof slidesJson !== 'undefined') {
        slidesApp.slideCollection = new SlideCollection(slidesJson);
        slidesApp.slideElementCollection = new SlideElementCollection({});
    }
    if(typeof questionsJson !== 'undefined') {
        slidesApp.questionCollection = new Backbone.Collection(questionsJson);
    }
    revealModule.start();
});

revealModule.on('start', function(options){
    revealModule.renderSlideset();
});