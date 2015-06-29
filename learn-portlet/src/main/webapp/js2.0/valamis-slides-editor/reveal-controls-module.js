var revealControlsModule = slidesApp.module('RevealControlsModule', function (RevealControlsModule, slidesApp, Backbone, Marionette, $, _) {
    RevealControlsModule.startWithParent = false;

    RevealControlsModule.View = Marionette.ItemView.extend({
        template: '#revealControlsTemplate',
        id: 'slideset-controls',
        events: {
            'click .js-add-page-right': 'addPageRight',
            'click .js-add-page-down': 'addPageDown',
            'click .js-slide-delete': 'deleteSlide',
            'click .js-change-slide-background-image': 'changeBackgroundImage',
            'change #background-image-selector': 'updateBackgroundImageSize',
            'click .js-select-mediagallery-image': 'selectMediaGalleryImage',
            'click .js-remove-background-image': 'removeBackgroundImage',
            'click .js-edit-slide-title': 'openSlideTitleEditPanel',
            'click .js-edit-slide-statement': 'openSlideStatementEditPanel',
            'click .js-confirm-slide-title': 'confirmSlideTitle',
            'click .js-confirm-slide-statement': 'confirmSlideStatement',
            'click .js-cancel-slide-title': 'closeSlideTitleEditPanel',
            'click .js-cancel-slide-statement': 'closeSlideStatementEditPanel',
            'click .js-close-slide-popup-panel': 'closeSlideStatementEditPanel',
            'click .image-upload-panel .js-close-slide-popup-panel': 'closeImageUploadPanel',
            'click .slide-title-edit-panel .js-close-slide-popup-panel': 'closeSlideTitleEditPanel'
        },
        initialize: function() {
            this.categories = [];
            this.verbs = [];
            this.uriCollection = new URICollection();
            this.verbUriCollection = new VerbURICollection();
            var self = this;
            this.uriCollection.on('sync', function() {
                self.verbUriCollection.fetch({reset: true})
            });
            self.verbUriCollection.on('sync', function() {
                self.verbs = [];
                self.categories = [];
                self.verbUriCollection.each(function(verb) {
                    self.verbs.push({ id: verb.get('uri').slice(verb.get('uri').lastIndexOf('_') + 1), text: verb.get('title') });
                });
                self.uriCollection.each(function(uri) {
                    if(uri.get('uri').indexOf('/delegate/uri/category') != -1)
                        self.categories.push({ id: uri.get('objId'), text: uri.get('content') });
                    if(uri.get('uri').indexOf('/delegate/uri/verb') != -1)
                        self.verbs.push({ id: uri.get('objId'), text: uri.get('content') });
                });

                self.initSelectize();
            });
        },
        uploadImage: function(entityIdBase, entityId) {
            var courseID = Utils.getCourseId();
            var imageData = new FormDataHelper();
            var endpointparam = {
                action:'ADD',
                courseId:  courseID,
                contentType: 'icon',
                folderId: entityIdBase + entityId
            };
            var self = this;

            var fileUploaderUrl = path.root + path.api.files + "?" + jQueryValamis.param(endpointparam);

            if (!imageData.supports()) {
                fileUploaderUrl = path.root + path.api.files + '&folderId=' + entityIdBase + entityId + '&courseId=' + courseID;
            }

            slidesApp.uploader = new FileUploader({ endpoint: fileUploaderUrl, message: translations['uploadLogoMessage'] });
            if (imageData.supports()) {
                slidesApp.uploader.on('fileuploadadd', function (data) {
                    imageData.setSetting(IMAGE_PARAM_TYPE.CONTENT_TYPE, 'icon');
                    imageData.setSetting(IMAGE_PARAM_TYPE.FILE, data);
                    imageData.setSetting(IMAGE_PARAM_TYPE.FILE_NAME, data.name);

                    imageData.readAsDataURL(data, function (img) {
                        var slide = jQueryValamis(Reveal.getCurrentSlide());
                        slidesApp.oldValue = {
                            indices: Reveal.getIndices(),
                            backgroundType: 'image',
                            background: (slide.attr('data-background') + ' ' + slide.attr('data-background-size')) || ''
                        };
                        slide.attr('data-background-repeat', 'no-repeat');
                        slidesApp.commands.execute('reveal:page:changeBackgroundImage', img + ' ' + (jQueryValamis('#background-image-selector').val() || 'contain'));
                        slide.attr('data-background-position', 'center');
                        jQueryValamis('.background-image-edit').css('display', 'block');
                        Reveal.sync();
                    });
                });

                slidesApp.uploader.on('fileuploaddone', function (data) {
                    var src = path.root + path.api.files +
                        "images?folderId=" + entityIdBase + entityId +
                        "&file=" + data.name + "&date=" + Date.now();
                    slidesApp.commands.execute('reveal:page:changeBackgroundImage', src + ' ' + (jQueryValamis('#background-image-selector').val() || 'contain'));
                    self.$('.background-image-uploader').html(slidesApp.uploader.render().$el);
                    self.$('#slide-background-image-thumbnail').show();
                    self.$('#slide-background-image-thumbnail').css('background', 'url("' + src + '") no-repeat');
                    self.$('#slide-background-image-thumbnail').css('background-size', 'contain');
                    slidesApp.actionStack.pop();
                });
            }
            else {
                slidesApp.uploader.on('fileuploaddone', function (data) {
                    window.LearnAjax.post(
                            path.root + path.api.slides + entityId + '?action=UPDATE&bgImage=' + escape(data.name + ' ' + jQueryValamis('#background-image-selector').val())
                    );
                });
            }
            this.$('.background-image-uploader').html(slidesApp.uploader.render().$el);
        },
        addPageRight: function() {
            slidesApp.commands.execute('reveal:page:addRight');
        },
        addPageDown: function() {
            slidesApp.commands.execute('reveal:page:addDown');
        },
        deleteSlide: function() {
            slidesApp.commands.execute('reveal:page:delete');
        },
        changeBackgroundImage: function() {
            if(!this.$('.image-upload-panel').is(':visible')) {
                this.$('.image-upload-panel').show();

                if(jQueryValamis(Reveal.getCurrentSlide()).attr('data-background')) {
                    this.$('#slide-background-image-thumbnail').show();
                    this.$('#background-image-selector').val(jQueryValamis(Reveal.getCurrentSlide()).attr('data-background-size'));
                }

                this.$('#slide-background-image-thumbnail').css('background', jQueryValamis(Reveal.getCurrentSlide()).attr('data-background') + ' no-repeat');
                this.$('#slide-background-image-thumbnail').css('background-size', 'contain');

                var self = this;
                if(!slidesApp.activeSlideModel.id) {
                    slidesApp.activeSlideModel.save().then(function(slideModel) {
                        self.uploadImage('slide_', slideModel.id);
                    });
                }
                else
                    self.uploadImage('slide_', slidesApp.activeSlideModel.id);
            }
            else
                this.$('.image-upload-panel').hide();
        },
        updateBackgroundImageSize: function () {
            var slide = jQueryValamis(Reveal.getCurrentSlide());
            slidesApp.viewId = this.cid;
            slidesApp.actionType = 'slideBackgroundChanged';
            slidesApp.oldValue = { indices: Reveal.getIndices(), backgroundType: 'image', background: slidesApp.activeSlideModel.get('bgImage') };
            slide.attr('data-background-size', jQueryValamis('#background-image-selector').val());
            Reveal.sync();

            if(slidesApp.activeSlideModel.get('bgImage')) {
                var bgImageUrl = slidesApp.activeSlideModel.get('bgImage').split(' ')[0];
                slidesApp.activeSlideModel.set('bgImage', bgImageUrl + ' ' + jQueryValamis('#background-image-selector').val());
                slidesApp.newValue = {indices: Reveal.getIndices(), backgroundType: 'image', background: slidesApp.activeSlideModel.get('bgImage')};
                slidesApp.commands.execute('action:push');
            }
        },
        selectMediaGalleryImage: function () {
            slidesApp.commands.execute('mediagallery:show:modal', 'slide');
        },
        removeBackgroundImage: function () {
            if(slidesApp.activeSlideModel.get('bgImage')) {
                var slide = jQueryValamis(Reveal.getCurrentSlide());
                slidesApp.oldValue = {
                    indices: Reveal.getIndices(),
                    backgroundType: 'image',
                    background: (slide.attr('data-background') + ' ' + slide.attr('data-background-size')) || ''
                };
                slide.attr('data-background', '');
                Reveal.sync();
                slidesApp.activeSlideModel.unset('bgImage');
                this.$('#slide-background-image-thumbnail').hide();
                this.$('#slide-background-image-thumbnail').css('background', '');
                this.$('.background-image-uploader').html(slidesApp.uploader.render().$el);
                slidesApp.viewId = this.cid;
                slidesApp.actionType = 'slideBackgroundChanged';
                slidesApp.newValue = { indices: Reveal.getIndices(), backgroundType: 'image', background: '' };
                slidesApp.commands.execute('action:push');
            }
        },
        initSelectize: function() {
            var self = this;
            slidesApp.selectizeVerb = self.$('#page-statement-verb-selector').selectize({
                delimiter: ',',
                persist: false,
                valueField: 'id',
                options: self.verbs,
                create: true,
                createOnBlur: true
            })[0].selectize;
            slidesApp.selectizeCategory = self.$('#page-statement-category-selector').selectize({
                delimiter: ',',
                persist: false,
                valueField: 'id',
                options: self.categories,
                create: true,
                createOnBlur: true
            })[0].selectize;
            slidesApp.selectizeVerb.setValue(slidesApp.activeSlideModel.get('statementVerb') || 'http://adlnet.gov/expapi/verbs/experienced');
            slidesApp.selectizeCategory.setValue(slidesApp.activeSlideModel.get('statementCategoryId'));
        },
        closeImageUploadPanel: function() {
            this.$('.image-upload-panel').hide();
        },
        openSlideTitleEditPanel: function() {
            if(!this.$('.slide-title-edit-panel').is(':visible')) {
                this.$('.slide-title-edit-panel').show();

                this.$('#js-slide-title').val(slidesApp.activeSlideModel.get('title') === undefined ? '' : unescape(slidesApp.activeSlideModel.get('title')));
                slidesApp.isEditing = true;
            }
            else {
                this.$('.slide-title-edit-panel').hide();
                slidesApp.isEditing = false;
            }
        },
        openSlideStatementEditPanel: function() {
            if(!this.$('.slide-statement-edit-panel').is(':visible')) {
                this.$('.slide-statement-edit-panel').show();

                this.$('#js-slide-statement-object').val(slidesApp.activeSlideModel.get('statementObject') || (slidesApp.activeSlideModel.get('title') || ''));

                this.uriCollection.fetch({reset: true});

                slidesApp.isEditing = true;
            }
            else {
                this.$('.slide-statement-edit-panel').hide();
                slidesApp.isEditing = false;
            }
        },
        closeSlideTitleEditPanel: function() {
            this.$('.slide-title-edit-panel').hide();
            slidesApp.isEditing = false;
        },
        closeSlideStatementEditPanel: function() {
            slidesApp.selectizeVerb.destroy();
            slidesApp.selectizeCategory.destroy();
            this.$('.slide-statement-edit-panel').hide();
            slidesApp.isEditing = false;
        },
        confirmSlideTitle: function() {
            slidesApp.viewId = this.cid;
            slidesApp.actionType = 'slideTitleChanged';
            slidesApp.oldValue = {
                indices: Reveal.getIndices(),
                title: slidesApp.activeSlideModel.get('title')
            };
            slidesApp.activeSlideModel.set('title', (this.$('#js-slide-title').val() === '' ? this.$('#js-slide-title').attr('placeholder') : this.$('#js-slide-title').val()));
            slidesApp.newValue = {
                indices: Reveal.getIndices(),
                title: slidesApp.activeSlideModel.get('title')
            };
            slidesApp.commands.execute('action:push');
            this.closeSlideTitleEditPanel();
        },
        confirmSlideStatement: function() {
            var verb = this.$('#page-statement-verb-selector').val() || undefined,
                category = this.$('#page-statement-category-selector').val();
            slidesApp.viewId = this.cid;
            slidesApp.actionType = 'slideStatementChanged';
            slidesApp.oldValue = {
                indices: Reveal.getIndices(),
                statementVerb: slidesApp.activeSlideModel.get('statementVerb'),
                statementObject: slidesApp.activeSlideModel.get('statementObject'),
                statementCategoryId: slidesApp.activeSlideModel.get('statementCategoryId')
            };

            slidesApp.activeSlideModel.set({
                'statementVerb': verb,
                'statementObject': this.$('#js-slide-statement-object').val(),
                'statementCategoryId': category
            });

            // Add new option to DB and replace it's value in the dropdown list
            var self = this;
            function addURI(type) {
                var uris = type === 'verb' ? self.verbs : self.categories;
                var deferred = jQueryValamis.Deferred();
                var newURI = type === 'verb' ? self.$('#page-statement-verb-selector').val() : self.$('#page-statement-category-selector').val();
                if(newURI && uris.filter(function(item) { return item.id === newURI }).length == 0) {
                    var valamisURI = new ValamisURI({
                        content: newURI,
                        id: newURI,
                        type: type
                    });
                    valamisURI.save().then(function (uri) {
                        var attrName = type === 'verb' ? 'statementVerb' : 'statementCategoryId';
                        slidesApp.activeSlideModel.set(attrName, uri.objId);
                        slidesApp.selectizeCategory.removeOption(newURI);
                        slidesApp.selectizeCategory.addOption({ value: uri.objId, text: uri.content });
                        slidesApp.selectizeCategory.refreshOptions();
                        deferred.resolve(uri.objId);
                    });
                } else {
                    deferred.resolve(type === 'verb' ? verb : category);
                }
                return deferred.promise();
            }

            jQueryValamis.when.apply(jQueryValamis, [ addURI('verb'), addURI('category') ]).then(function(selectedVerb, selectedCategory) {
                console.log(selectedVerb, selectedCategory);
                slidesApp.newValue = {
                    indices: Reveal.getIndices(),
                    statementVerb: slidesApp.activeSlideModel.get('statementVerb'),
                    statementObject: slidesApp.activeSlideModel.get('statementObject'),
                    statementCategoryId: slidesApp.activeSlideModel.get('statementCategoryId')
                };
                slidesApp.commands.execute('action:push');
            });

            this.closeSlideStatementEditPanel();
        }
    });

    var view;

    RevealControlsModule.onStart = function() {
        view = new revealControlsModule.View();
        slidesApp.revealControls.show(view);

        jQueryValamis('.js-change-slide-background').ColorPicker({
            onSubmit: function(hsb, hex, rgb, el) {
               jQueryValamis(el).val(hex);
               jQueryValamis(el).ColorPickerHide();
                slidesApp.commands.execute('reveal:page:changeBackground', '#'+hex);
            },
            onChange: function(hsb, hex, rgb, el) {
               jQueryValamis(el).val(hex);
                slidesApp.commands.execute('reveal:page:changeBackground', '#'+hex);
            },
            onBeforeShow: function (colpkr) {
               jQueryValamis(this).ColorPickerSetColor(jQueryValamis(Reveal.getCurrentSlide()).attr('data-background-color') || '#000000');
                jQueryValamis(colpkr).css({
                    'position': 'absolute',
                    'margin-left': (jQueryValamis(colpkr).offset().left - jQueryValamis(colpkr).width() - 13) + 'px',
                    'margin-top':  (jQueryValamis(colpkr).offset().top - jQueryValamis(this).height()) + 'px',
                    'display': 'block'
                });
            }
        });
    }
});

revealControlsModule.on('start', function () {
    revealControlsModule.onStart();
});