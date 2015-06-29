/**
 * Created by aklimov on 07.04.15.
 */
var arrangeModule = slidesApp.module('ArrangeModule', function (ArrangeModule, slidesApp, Backbone, Marionette, $, _) {
    ArrangeModule.startWithParent = false;
    ArrangeModule.subAction = 'default';
    ArrangeModule.sortableEnabled = true;

    ArrangeModule.View = Marionette.ItemView.extend({
        tagName: 'table',
        template: '#arrangeTemplate',
        id: 'arrangeSlides'
    });

    ArrangeModule.tileListView = Marionette.ItemView.extend({
        tagName: 'td',
        template: '#arrangeListTemplate',
        className: 'tileListTemp js-sortable-slide-list'
    });
    ArrangeModule.tileView = Marionette.ItemView.extend({
        template: '#arrangeTileTemplate',
        className: 'slides-arrange-tile js-slides-arrange-tile text-center',
        events: {
            'mouseover': 'onMouseOver',
            'mouseout': 'onMouseOut',
            'click': 'onClick',
            'click .js-arrange-tile-preview': 'goToSlide',
            'click .js-arrange-tile-delete': 'deleteSlide',
            'click .js-arrange-tile-select': 'selectSlide'
        },
        onMouseOver: function (e) {
            if( _.indexOf(['select','select-incorrect'], arrangeModule.subAction) > -1 ) {
                this.$('.js-arrange-tile-controls > div').addClass('hidden');
                this.$('.js-arrange-tile-controls').find('.js-arrange-tile-select').parent().removeClass('hidden');
                this.$('.js-arrange-tile-controls').show();
                jQueryValamis('#arrangeContainer .js-slides-arrange-tile').removeClass('arrange-tile-active');
                this.$el.addClass('arrange-tile-active');
            }
            else{
                this.$('.js-arrange-tile-controls').show();
            }
        },
        onMouseOut: function (e) {
            this.$('.js-arrange-tile-controls').hide();
        },
        onClick: function (e) {
            e.stopPropagation();
            if( jQueryValamis(e.target).is('.arrange-tile-cover') && _.indexOf(['select','select-incorrect'], arrangeModule.subAction) > -1 ){
                this.selectSlide();
            }
        },
        goToSlide: function () {
            var slideId = parseInt(this.$el.attr('id').slice(this.$el.attr('id').indexOf('_') + 1));
            switchMode('preview', false, slideId);
        },
        deleteSlide: function (e) {
            var slideId = parseInt(this.$el.attr('id').slice(this.$el.attr('id').indexOf('_') + 1));
            var slideModel = slidesApp.getSlideModel(slideId);
            slideModel.set('toBeRemoved', true);
            var listElement = jQueryValamis(e.target).closest('.js-slides-arrange-tile'),
                topListElement = listElement.prev(),
                leftListElement = listElement.parent().prevAll('.js-sortable-slide-list:has(>div)').first().children().first();
            var slideIndices = slidesApp.slideRegistry.getBySlideId(slideId);
            var slideEntities = slidesApp.slideElementCollection.where({slideId: slideId});
            var slideThumbnail = jQueryValamis('#slidesArrangeTile_' + slideId).clone();
            var rightSlideModel = slidesApp.slideCollection.where({leftSlideId: slideId || slideModel.get('tempId')})[0];
            var bottomSlideModel = slidesApp.slideCollection.where({topSlideId: slideId || slideModel.get('tempId')})[0];

            slidesApp.oldValue = {
                indices: { h: slideIndices.h, v: slideIndices.v },
                slideModel: slideModel,
                slideEntities: slideEntities,
                slideThumbnail: slideThumbnail,
                rightSlideId: rightSlideModel ? (rightSlideModel.id || rightSlideModel.get('tempId')) : undefined,
                bottomSlideId: bottomSlideModel ? (bottomSlideModel.id || bottomSlideModel.get('tempId')) : undefined
            };
            if(topListElement.length > 0)
                slidesApp.oldValue.direction = 'down';
            else if(leftListElement.length > 0)
                slidesApp.oldValue.direction = 'right';
            slidesApp.viewId = this.cid;
            slidesApp.actionType = 'slideRemoved';
            slidesApp.newValue = null;
            slidesApp.commands.execute('action:push');

            if (listElement.siblings().length === 0) {
                listElement.parent().prev().remove();
                listElement.parent().remove();
            }
            listElement.remove();

            ArrangeModule.updateSlideRefs();
        },
        selectSlide: function(){
            var slideId = parseInt(this.$el.attr('id').replace('slidesArrangeTile_',''));
            switchMode('edit', false, slideId);
        }
    });
    ArrangeModule.slideThumbnailView = Marionette.ItemView.extend({
        template: '#slideThumbnailTemplate',
        className: 'slides-thumbnail js-slides-thumbnail'
    });

    ArrangeModule.initSortable = function(elem) {
        if( !ArrangeModule.sortableEnabled ){
            return;
        }
        elem.sortable({
            placeholder: 'slides-arrange-placeholder',
            revert: true,
            delay: 50,
            connectWith: '.js-sortable-slide-list',
            sort: function(e, ui) {
                var placeholderBackground = jQueryValamis('<div></div>').css({
                    'background-color': '#DEDEDE',
                    'width': '196px',
                    'height': '146px'
                });
                jQueryValamis(ui.placeholder).html('');
                jQueryValamis(ui.placeholder).append(placeholderBackground);
                jQueryValamis(ui.placeholder).addClass('slides-arrange-placeholder');
            },
            start: function(e, ui) {
                var slideId = parseInt(jQueryValamis(ui.item).attr('id').slice(jQueryValamis(ui.item).attr('id').indexOf('_') + 1));
                var slideModel = slidesApp.getSlideModel(slideId);
                ArrangeModule.slideSourceList = jQueryValamis(e.currentTarget);
                var rightSlideModel = slidesApp.slideCollection.where({leftSlideId: slideId || slideModel.get('tempId')})[0];
                var bottomSlideModel = slidesApp.slideCollection.where({topSlideId: slideId || slideModel.get('tempId')})[0];
                slidesApp.oldValue = {
                    slideAttrs: {
                        slideId: slideModel.id || slideModel.get('tempId'),
                        leftSlideId: slideModel.get('leftSlideId'),
                        topSlideId: slideModel.get('topSlideId')
                    },
                    rightSlideId: rightSlideModel ? (rightSlideModel.id || rightSlideModel.get('tempId')) : undefined,
                    bottomSlideId: bottomSlideModel ? (bottomSlideModel.id || bottomSlideModel.get('tempId')) : undefined
                };
            },
            stop: function(e, ui) {
                jQueryValamis(ui.placeholder).html('');
                jQueryValamis(ui.placeholder).removeClass('slides-arrange-placeholder');
            },
            receive: function(e, ui) {
                ArrangeModule.slideTargetList = jQueryValamis(e.target);
                ArrangeModule.manageSortableLists();
            },
            update: function(e, ui) {
                if(ui.sender === null) {
                    ArrangeModule.updateSlideRefs();
                    var slideId = parseInt(jQueryValamis(ui.item).attr('id').slice(jQueryValamis(ui.item).attr('id').replace('slidesArrangeTile_', '')));
                    var slideModel = slidesApp.getSlideModel(slideId);
                    slidesApp.viewId = undefined;
                    slidesApp.actionType = 'slideOrderChanged';
                    slidesApp.newValue = { slideModel: slideModel };
                    slidesApp.commands.execute('action:push');
                }
            }
        }).disableSelection();
    };

    ArrangeModule.manageSortableLists = function() {
        if(ArrangeModule.slideSourceList && ArrangeModule.slideSourceList.children().length === 0) {
            if(ArrangeModule.slideSourceList.prev().children().length === 0)
                ArrangeModule.slideSourceList.prev().remove();
            ArrangeModule.slideSourceList.remove();
        }
        // If the target list was empty before current item appeared in it
        if(ArrangeModule.slideTargetList.children().length === 1) {
            ArrangeModule.slideTargetList.removeClass('empty-arrange-list');
            if (ArrangeModule.slideTargetList.prev().length === 0 || ArrangeModule.slideTargetList.prev().children().length > 0) {
                var arrangeList = jQueryValamis((new ArrangeModule.tileListView()).render().el);
                arrangeList.addClass('empty-arrange-list');
                arrangeList.insertBefore(ArrangeModule.slideTargetList);
                ArrangeModule.initSortable(arrangeList);
            }
            if (ArrangeModule.slideTargetList.next().length === 0 || ArrangeModule.slideTargetList.next().children().length > 0) {
                var arrangeList = jQueryValamis((new ArrangeModule.tileListView()).render().el);
                arrangeList.addClass('empty-arrange-list');
                arrangeList.insertAfter(ArrangeModule.slideTargetList);
                ArrangeModule.initSortable(arrangeList);
            }
        }
    };
    ArrangeModule.createSortableLists = function() {
        // Create  a sortable list for each stack of slides
        jQueryValamis('.slides > section').each(function() {
            var arrangeList = jQueryValamis((new ArrangeModule.tileListView()).render().el);
            jQueryValamis('#arrangeSlides > tr').append(arrangeList);
            jQueryValamis(this).find('> section').each(function() {
                var slideId = parseInt(jQueryValamis(this).attr('id').slice(6));
                var slideModel = slidesApp.getSlideModel(slideId);
                var arrangeTile = jQueryValamis((new ArrangeModule.tileView({ id: 'slidesArrangeTile_' + slideId })).render().el);
                arrangeList.append(arrangeTile);
                // Create a thumbnail for the slide
                var slideThumbnail = jQueryValamis((new ArrangeModule.slideThumbnailView()).render().el);
                jQueryValamis('#slide_' + slideId).clone().attr('id', 'slideThumbnail_' + slideId).appendTo(slideThumbnail);
                var slideBackgroundImageParts = slideModel.get('bgImage') ? slideModel.get('bgImage').split(' ') : ['', ''];
                slideThumbnail.css({
                    'background': slideBackgroundImageParts[0] + ' no-repeat',
                    'background-size': slideBackgroundImageParts[1],
                    'background-position': 'center',
                    'background-color': unescape(slideModel.get('bgColor')) || ''
                });
                slideThumbnail.insertBefore(arrangeTile.find('.js-arrange-tile-controls'));
            });

            ArrangeModule.initSortable(arrangeList);
            // Create an empty sortable list after each list
            arrangeList = jQueryValamis((new ArrangeModule.tileListView()).render().el);
            arrangeList.addClass('empty-arrange-list');
            jQueryValamis('#arrangeSlides > tr').append(arrangeList);
            ArrangeModule.initSortable(arrangeList);
        });
        // Add an additional sortable list at the beginning
        var firstList = jQueryValamis(new ArrangeModule.tileListView().render().el);
        firstList.addClass('empty-arrange-list');
        firstList.insertBefore(jQueryValamis('.js-sortable-slide-list').first());
        ArrangeModule.initSortable(firstList);

        if(jQueryValamis('.js-slides-arrange-tile').length == 1)
            jQueryValamis('.js-arrange-tile-delete').hide();

        jQueryValamis(document).trigger('arrange-module-ready');
    };

    ArrangeModule.updateSlideRefs = function() {
        var lists = jQueryValamis('.js-sortable-slide-list:has(>div)'), i = 0, j = 0;
        lists.each(function() {
            j = 0;
            var list = jQueryValamis(this);
            list.find('.js-slides-arrange-tile').each(function() {
                var listElement = jQueryValamis(this),
                    listElementId = parseInt(listElement.attr('id').slice(listElement.attr('id').indexOf('_') + 1)),
                    slideModel = slidesApp.getSlideModel(listElementId),
                    topListElement = listElement.prev(),
                    leftListElement = listElement.parent().prevAll('.js-sortable-slide-list:has(>div)').first().children().first(),
                    topListElementId = topListElement.length > 0
                        ? parseInt(topListElement.attr('id').slice(topListElement.attr('id').indexOf('_') + 1))
                        : undefined,
                    leftListElementId = leftListElement.length > 0
                        ? parseInt(leftListElement.attr('id').slice(leftListElement.attr('id').indexOf('_') + 1))
                        : undefined;
                // If it is the first slide stack (list)
                if(i === 0) {
                    slideModel.unset('leftSlideId');
                }
                if(topListElementId)
                    slideModel.set('topSlideId', topListElementId);
                if(j === 0) {
                    slideModel.unset('topSlideId');
                    // If it is a slide from the top row (where slides CAN refer to the left)
                    if(leftListElementId) {
                        slideModel.set('leftSlideId', leftListElementId);
                    }
                }
                j++;
            });
            i++;
        });
        if(jQueryValamis('.js-slides-arrange-tile').length == 1)
            jQueryValamis('.js-arrange-tile-delete').hide();
        else
            jQueryValamis('.js-arrange-tile-delete').show();
    };

    ArrangeModule.initDraggable = function() {
        jQueryValamis('#arrangeSlides').css('width', 'auto');
        var defaultTableWidth = jQueryValamis('#arrangeSlides').width();
        var sortableListContainerWidth = jQueryValamis('#arrangeContainer').width(),
            sortableListContainerHeight = jQueryValamis('#arrangeContainer').height();
        var sortableListTableWidth = Math.max(jQueryValamis('#arrangeSlides').width(), jQueryValamis('#arrangeContainer').width()),
            sortableListTableHeight = jQueryValamis('#arrangeSlides').height();
        var containmentStartX = 0 - Math.abs(sortableListContainerWidth - sortableListTableWidth),
            containmentStartY = 0 - Math.abs(sortableListContainerHeight - sortableListTableHeight),
            containmentEndX = 0,
            containmentEndY = 0;
        if(sortableListTableWidth < sortableListContainerWidth) {
            containmentStartX = Math.abs(sortableListContainerWidth - sortableListTableWidth) / 2;
            containmentEndX = containmentStartX;
        }
        if(sortableListTableHeight < sortableListContainerHeight) {
            containmentStartY = Math.abs(sortableListContainerHeight - sortableListTableHeight) / 2;
            containmentEndY = containmentStartY;
        }
        if(sortableListTableWidth > sortableListContainerWidth || sortableListTableHeight > sortableListContainerHeight) {
            jQueryValamis('#arrangeSlides').draggable({
                containment: [ containmentStartX, containmentStartY, containmentEndX, containmentEndY ]
            });
        }
        if(sortableListTableHeight > sortableListContainerHeight && sortableListTableWidth <= sortableListContainerWidth) {

            jQueryValamis('#arrangeSlides').draggable("option", "axis", "y");
            jQueryValamis('td.empty-arrange-list').first().width((sortableListContainerWidth - defaultTableWidth) / 2);
            jQueryValamis('td.empty-arrange-list').last().width((sortableListContainerWidth - defaultTableWidth) / 2);
            jQueryValamis('#arrangeSlides').width(sortableListTableWidth);
        }
    };
});

var arrangeView = new arrangeModule.View();

arrangeModule.on('start', function() {
    setTimeout(function() {
        toastr.info(slidesConfig.translations['slideSetModeSwitchingLabel'], { 'timeOut': '60000' });
    }, 0);
    setTimeout(function() {
        jQueryValamis(document).on('arrange-module-ready', function(){
            setTimeout(function () {
                jQueryValamis('#arrangeContainer').prevAll().hide();
                toastr.clear();
            }, 0);
        });
        jQueryValamis('#arrangeContainer').append(arrangeView.render().el);
        jQueryValamis('#arrangeContainer').height(jQueryValamis(window.parent).height() - jQueryValamis(window.parent.document).find('.js-slides-editor-topbar').outerHeight());
        jQueryValamis('#arrangeContainer').width(jQueryValamis(window.parent).width());
        jQueryValamis('body').css('background-color', '#f2f2f2');
        arrangeModule.subAction = window.editorMode && window.editorMode.indexOf(':') > -1
            ? _.last(window.editorMode.split(':'))
            : 'default';
        arrangeModule.sortableEnabled = _.indexOf(['select', 'select-incorrect'], arrangeModule.subAction) == -1;
        arrangeModule.createSortableLists();
        if (jQueryValamis('#arrangeSlides').width() <= jQueryValamis('#arrangeContainer').width())
            jQueryValamis('#arrangeSlides').addClass('centered');
            arrangeModule.initDraggable();
    }, 500);
});

arrangeModule.on('stop', function() {
    window.editorMode = null;
    jQueryValamis('#arrangeSlides').removeClass('centered');
    jQueryValamis('body').css('background-color', '');
});