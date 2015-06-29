var GenericEditorItemModule = Marionette.Module.extend({
    Model: SlideElementModel,

    BaseView: Marionette.ItemView.extend({
        className: 'rj-element',
        id: 'slide-entity-' + (Marionette.ItemView.Registry.size() + 1),
        events: {
            'mousedown': 'onMouseDown',
            'click .js-item-delete': 'deleteEl',
            'click .js-item-duplicate': 'duplicateEl',
            'click .item-content': 'showEdit',
            'click .js-item-link': 'linkUpdate',
            'click .js-item-link-incorrect': 'linkUpdate'
        },
        initialize: function(options) {
            this.model.set('googleClientApiAvailable', slidesConfig.googleClientApiReady);
            this.listenTo(this.model, 'change', this.updateEl);
            Marionette.ItemView.prototype.initialize.apply(this);
            this.cid = this.options.id || this.cid;
            Marionette.ItemView.Registry.register(this.cid, this);
        },
        selectEl: function() {
            slidesApp.selectedItemView = this;
            slidesApp.commands.execute('item:focus', this);
        },
        updateEl: function() {
            this.$el.css('width', this.model.get('width') + 'px');
            this.$el.css('height', this.model.get('height') + 'px');
            this.$el.css('top', this.model.get('top') + 'px');
            this.$el.css('left', this.model.get('left') + 'px');
            this.content.css('z-index', this.model.get('zIndex'));
        },
        onRender: function() {
            this.content = this.$('.item-content');
            this.controls = this.$('.item-controls');
            this.resizeControls = this.$('.item-border');
            var self = this;
            this.$el.resizable({
                resize: function( event, ui ) {
                    var direction = jQueryValamis(this).data('ui-resizable').axis;
                    // Keep aspect ratio if resized with corner handles, don't keep otherwise.
                    var aspectRatio = false;
                    if(self.model.get('slideEntityType') === 'image'){
                        aspectRatio = (direction.length === 1) ? false : true;
                        jQueryValamis(this).resizable( "option", "aspectRatio", 'se').data('uiResizable')._aspectRatio = aspectRatio;
                    }

                    //Sizes
                    slidesApp.GridSnapModule.snapSize(direction,ui.size,ui.originalPosition,aspectRatio);

                    //Positions
                    switch (direction) {
                        case 'nw':
                            var posSideTop = ui.originalPosition.top + ui.originalSize.height - Math.max(Math.min(ui.size.height, 800), 32);
                            var posSideLeft = ui.originalPosition.left + ui.originalSize.width - Math.max(Math.min(ui.size.width, 800), 32);
                            posSideTop = slidesApp.GridSnapModule.snapTopResize(posSideTop,self.model.get('top'),ui.size);
                            posSideLeft = slidesApp.GridSnapModule.snapLeftResize(posSideLeft,self.model.get('left'),ui.size);
                            self.model.set({
                                'top': posSideTop,
                                'left': posSideLeft
                            });
                            break;
                        case 'n':
                        case 'ne':
                            var posSideTop = ui.originalPosition.top + ui.originalSize.height - Math.max(Math.min(ui.size.height, 800), 2);
                            posSideTop = slidesApp.GridSnapModule.snapTopResize(posSideTop,self.model.get('top'),ui.size);
                            self.model.set('top', posSideTop);
                            break;
                        case 'w':
                        case 'sw':
                            var posSideLeft = ui.originalPosition.left + ui.originalSize.width - Math.max(Math.min(ui.size.width, 800), 32);
                            posSideLeft = slidesApp.GridSnapModule.snapLeftResize(posSideLeft,self.model.get('left'),ui.size);
                            self.model.set('left',posSideLeft);
                            break;
                        default:
                            break;
                    }

                    slidesApp.commands.execute('item:resize', ui.size.width, ui.size.height);
                    self.updateEl();
                },
                start: function( event, ui ){
                    if(!slidesApp.activeElement.view)
                        slidesApp.commands.execute('item:focus', self);
                    slidesApp.commands.execute('resize:prepare', self);
                    slidesApp.GridSnapModule.prepareItemsSnap();
                },
                stop: function( event, ui ) {
                    slidesApp.newValue = {
                        'top': self.model.get('top'),
                        'left': self.model.get('left'),
                        'width': self.model.get('width'),
                        'height': self.model.get('height')
                    };
                    slidesApp.commands.execute('action:push');
                    slidesApp.activeElement.isResizing = false;
                },
                handles: {
                    'n': '.ui-resizable-n',
                    'e': '.ui-resizable-e',
                    's': '.ui-resizable-s',
                    'w': '.ui-resizable-w',
                    'ne': '.ui-resizable-ne',
                    'se': '.ui-resizable-se',
                    'sw': '.ui-resizable-sw',
                    'nw': '.ui-resizable-nw'
                }
            });
            this.updateEl();
            this.applyLinkedType('correctLinkedSlideId');
            this.applyLinkedType('incorrectLinkedSlideId');
        },
        onMouseDown: function(e) {
            if(!slidesApp.isEditing) {
                if (this.$('.iframe-edit-panel').is(':hidden') || this.$('.iframe-edit-panel').length === 0)
                    e.preventDefault();
                var offsetX = e.pageX - this.$el.offset().left;
                var offsetY = e.pageY - this.$el.offset().top;

                if (offsetX > 7 &&
                    offsetY > 7 &&
                    offsetX < parseInt(this.$el.css('width').slice(0, -2)) - 7 &&
                    offsetY < parseInt(this.$el.css('height').slice(0, -2)) - 7) {
                    if (this.$('.iframe-edit-panel').is(':hidden') || this.$('.iframe-edit-panel').length === 0)
                        slidesApp.commands.execute('drag:prepare:existing', this, e.clientX, e.clientY, offsetX, offsetY);
                }
            }
        },
        duplicateEl: function() {
            slidesApp.commands.execute('item:duplicate', this);
        },
        deleteEl: function() {
            slidesApp.selectedItemView = this;
            slidesApp.commands.execute('item:delete');
        },
        showEdit: function() {
            this.selectEl();
        },
        wrapperUpdate: function(){
            var height = this.$el.height();
            var realHeight = this.$el.css({height:'auto',maxHeight:'none'}).outerHeight(true);
            this.$el.css('height',realHeight+'px');
            if( slidesApp.activeElement.view ) {
                slidesApp.commands.execute('item:resize', this.$el.width(), realHeight);
                slidesApp.actionStack.pop();
            }
            slidesApp.RevealModule.fitContent();
        },
        applyLinkedType: function(linkTypeName) {
            this.controls.find('.js-item-link')
                .toggleClass('active-button', !!this.model.get('correctLinkedSlideId'));
            this.controls.find('.js-item-link-incorrect')
                .toggleClass('active-button', !!this.model.get('incorrectLinkedSlideId'));
            if(this.model.get('correctLinkedSlideId') || this.model.get('incorrectLinkedSlideId')) {
                this.$el.addClass('linked');
                this.controls.find('.js-item-link > .linked-slide-thumbnail').addClass('slide-thumbnail-bordered');
                if(this.model.get('slideEntityType') === 'question') {
                    if(this.model.get('correctLinkedSlideId'))
                        this.controls.find('.js-item-link > .val-badge').html(
                                'Remove link to correct answer (' + slidesApp.getSlideModel(parseInt(this.model.get('correctLinkedSlideId'))).get('title') + ')'
                        );
                    if(this.model.get('incorrectLinkedSlideId'))
                        this.controls.find('.js-item-link-incorrect > .val-badge').html(
                            'Remove link to incorrect answer (' + slidesApp.getSlideModel(parseInt(this.model.get('incorrectLinkedSlideId'))).get('title') + ')'
                        );
                }
                else
                    this.controls.find('.js-item-link > .val-badge').html(
                        'Remove link to another slide (' + slidesApp.getSlideModel(parseInt(this.model.get('correctLinkedSlideId'))).get('title') + ')'
                    );
            } else {
                this.$el.removeClass('linked');
                if(this.model.get('slideEntityType') === 'question') {
                    if(!this.model.get('correctLinkedSlideId'))
                        this.controls.find('.js-item-link > .val-badge').html('Link to correct answer');
                    if(!this.model.get('incorrectLinkedSlideId'))
                        this.controls.find('.js-item-link-incorrect > .val-badge').html('Link to incorrect answer');
                }
                else
                    this.controls.find('.js-item-link > .val-badge').html('Link to another slide');
            }

            var slideThumbnail = this.controls.find('button.' + linkTypeName.substr(0, linkTypeName.indexOf('LinkedSlideId')) + ' > .linked-slide-thumbnail');
            slideThumbnail.html('');
            slideThumbnail.css({
                'background-color': 'transparent',
                'background-image': ''
            });
            slideThumbnail.removeClass('slide-thumbnail-bordered');
        },
        goToSlideActionInit: function() {
            var self = this;
            if( _.indexOf(['text','image'], this.model.get('slideEntityType')) > -1 && this.model.get('correctLinkedSlideId') ) {
                this.$el.bind('click', {slideId: this.model.get('correctLinkedSlideId')}, self.goToSlideAction);
            }
        },
        goToSlideAction: function(e) {
            if(e.data && e.data.slideId ) {
                var slideIndices = slidesApp.slideRegistry.getBySlideId(e.data.slideId);
                Reveal.slide(slideIndices.h, slideIndices.v);
            }
        },
        goToSlideActionDestroy: function() {
            var self = this;
            this.$el.unbind('click',self.goToSlideAction);
        },
        linkUpdate: function(e) {
            var linkTypeName = jQueryValamis(e.target).closest('button').is('.js-item-link') ? 'correctLinkedSlideId' : 'incorrectLinkedSlideId';
            slidesApp.viewId = this.cid;
            slidesApp.actionType = 'itemLinkedSlideChanged';
            slidesApp.oldValue = { linkType: linkTypeName, linkedSlideId: this.model.get(linkTypeName) };
            if(this.model.get(linkTypeName)){
                this.model.set(linkTypeName, null);
                this.applyLinkedType(linkTypeName);
                slidesApp.newValue = { linkType: linkTypeName, linkedSlideId: this.model.get(linkTypeName) };
                slidesApp.commands.execute('action:push');
            } else {
                slidesApp.commands.execute('linkUpdate', linkTypeName);
            }
        }
    })
});