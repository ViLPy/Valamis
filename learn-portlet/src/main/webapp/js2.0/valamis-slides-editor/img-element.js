var imageElementModule = slidesApp.module('ImageElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function (ImageElementModule, slidesApp, Backbone, Marionette, $, _) {
        ImageElementModule.startWithParent = false;

        ImageElementModule.View = this.BaseView.extend({
            template: '#imageElementTemplate',
            className: 'rj-element rj-image no-select',
            events: _.extend({}, this.BaseView.prototype.events, {
                'click .js-image-upload': 'uploadImage',
                'click .js-select-mediagallery-image': 'selectMediaGalleryImage',
                'click .js-select-google-image': 'selectGoogleImage'
            }),
            uploadImage: function () {
                slidesApp.commands.execute('fileupload:show:modal', ImageElementModule.moduleName);
            },
            selectMediaGalleryImage: function () {
                slidesApp.commands.execute('mediagallery:show:modal', 'image');
            },
            updateUrl: function(url, width, height) {
                slidesApp.viewId = this.cid;
                slidesApp.actionType = 'itemContentChanged';
                slidesApp.oldValue = {
                    contentType: 'image',
                    content: this.model.get('content'),
                    width: this.model.get('width'),
                    height: this.model.get('height')
                };
                this.model.set('content', url);
                if(url.indexOf('docs.google.com/file/d/') != -1) {
                    this.content.css('background-color', 'transparent');
                    this.$('.content-icon-image').first().hide();
                    this.$('iframe').attr('src', url);
                    this.$('iframe').show();
                }
                else {
                    this.$('iframe').attr('src', '');
                    this.$('iframe').hide();
                    if(url) {
                        this.content.css('background-image', url);
                        this.content.css('background-color', 'transparent');
                        this.$('.content-icon-image').first().hide();
                    }
                    else {
                        this.content.css('background-image', '');
                        this.content.css('background-color', '#1C1C1C');
                        this.$('.content-icon-image').first().show();
                    }
                    var newSize = window.resizeImage(width, height, 800, 800);
                    slidesApp.commands.execute('item:resize', newSize.width, newSize.height);
                }
                slidesApp.newValue = {
                    contentType: 'image',
                    content: this.model.get('content'),
                    width: this.model.get('width'),
                    height: this.model.get('height')
                };
                slidesApp.commands.execute('action:push');
            },
            selectGoogleImage: function() {
                slidesApp.commands.execute('mediagallery:show:modal', 'gapi');
            }
        });

        ImageElementModule.Modal = Backbone.Modal.extend({
            template: function () {
                var mustacheAccumulator = {};
                if (this.model) {
                    _.extend(mustacheAccumulator, this.model.toJSON());
                }
                _.extend(mustacheAccumulator);

                return  Mustache.to_html($('#slides-editor-fileupload-modal-template').html(), mustacheAccumulator);
            },
            submitEl: '.bbm-button',
            cancelEl: '.modal-close',
            className: 'file-upload-modal'
        });
    }
});

imageElementModule.on('start', function() {
    slidesApp.commands.execute('toolbar:item:add', {title: 'Image', slideEntityType: 'image'});
});