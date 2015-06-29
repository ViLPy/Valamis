var videoElementModule = slidesApp.module('VideoElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function(VideoElementModule, slidesApp, Backbone, Marionette, $, _){
        VideoElementModule.startWithParent = false;

        VideoElementModule.View = this.BaseView.extend({
            template: '#videoElementTemplate',
            className: 'rj-element rj-video no-select',
            events: _.extend({}, this.BaseView.prototype.events, {
                'click .js-select-mediagallery-video': 'selectMediaGalleryVideo',
                'click .js-select-google-video': 'selectGoogleVideo'
            }),
            updateUrl: function(url) {
                slidesApp.viewId = this.cid;
                slidesApp.actionType = 'itemContentChanged';
                slidesApp.oldValue = {contentType: 'video', content: this.model.get('content')};
                var src = url.replace(/watch\?v=/g, 'embed/');
                this.model.set('content', src);
                slidesApp.newValue = {contentType: 'video', content: this.model.get('content')};
                slidesApp.commands.execute('action:push');
                var self = this;
                if(url.indexOf('docs.google.com/file/d/') != -1) {
                    this.$('iframe').attr('src', url);
                    this.$('iframe').show();
                    this.$('.video-js').hide();
                }
                else if(src.indexOf('youtube.com/') != -1) {
                    var videoId = /https?:\/\/(www\.)?youtube\.com\/embed\/([^&]*)/g.exec(src)[2];
                    this.$('iframe').attr('src', 'https://www.youtube.com/embed/' + videoId + '?enablejsapi=1');
                    try {
                        this.player = new YT.Player(self.$('iframe')[0], {});
                    } catch(e) {
                        console.log(e);
                    }
                    this.$('iframe').show();
                    this.$('.video-js').hide();
                }
                else {
                    this.$('iframe').hide();
                    this.$('.video-js').show();
                    this.$('video').attr('src', /(.*)&ext=/g.exec(url)[1]);
                    this.$('video > source').attr('src', /(.*)&ext=/g.exec(url)[1]);
                    this.$('video > source').attr('type', (_.invert(mimeToExt.video))[/&ext=([^&]*)/g.exec(url)[1]]);
                    this.$('video').load();
                    this.$('video').on('loadeddata', function() {
                        slidesApp.commands.execute('item:focus', self);
                        self.player = videojs(self.$('video')[0], { "controls": true, "autoplay": false, "preload": "auto" }, function() {
                            // Player (this) is initialized and ready.
                        });
                        self.player.on('loadeddata', function() {
                            self.player.currentTime(self.player.duration() / 2);
                            self.player.play();
                            self.player.pause();
                        });
                    });
                }
                this.content.css('background-color', 'transparent');
                this.$('.content-icon-video').first().hide();
            },
            selectMediaGalleryVideo: function () {
                slidesApp.commands.execute('mediagallery:show:modal', 'video');
            },
            selectGoogleVideo: function() {
                slidesApp.commands.execute('mediagallery:show:modal', 'gapi');
            }
        });
    }
});

videoElementModule.on('start', function() {
    slidesApp.commands.execute('toolbar:item:add', {title: 'Video', slideEntityType: 'video'});
});