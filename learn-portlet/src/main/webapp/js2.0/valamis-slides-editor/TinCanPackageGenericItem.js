slidesApp.module('TinCanPackageGenericItem', {
    Model: SlideElementModel,
    define: function(TinCanPackageGenericItem, slidesApp, Backbone, Marionette, $, _){
        TinCanPackageGenericItem.startWithParent = false;

            TinCanPackageGenericItem.GenericItemView = Marionette.ItemView.extend({
            className: 'rj-element',
            template: '#genericElementTemplate',
            initialize: function(options) {
                this.listenTo(this.model, 'change', this.updateEl);
                switch(this.model.get('slideEntityType')) {
                    case 'text':
                        this.className += ' rj-text no-select';
                        break;
                    case 'question':
                        this.className += ' question-element';
                        break;
                }
            },
            updateEl: function() {
                switch(this.model.get('slideEntityType')) {
                    case 'text':
                        this.content.html(this.model.get('content'));
                        break;
                    case 'image':
                        if(this.model.get('content') === '')
                            this.content.css({'background': '#1C1C1C'});
                        else {
                            var url = slidesApp.RevealModule.getFileURL(this.model.get('content'));
                            if (url.indexOf('docs.google.com/file/d/') != -1) {
                                this.$('iframe').attr('src', url);
                                this.$('iframe').show();
                            }
                            else {
                                this.$('iframe').attr('src', '');
                                this.$('iframe').hide();
                                this.content.css('background-image', url);
                                this.content.css('background-color', 'transparent');
                                this.content.css({
                                    'background': url,
                                    'background-size': '100% 100%'
                                });
                                this.$('.content-icon-image').first().hide();
                            }
                        }
                        break;
                    case 'video':
                        if(this.model.get('content') === '')
                            this.content.css({'background': '#1C1C1C'});
                        else {
                            var url = this.model.get('content');
                            var self = this;
                            if (url.indexOf('docs.google.com/file/d/') != -1) {
                                this.$('iframe').attr('src', url);
                                this.$('iframe').show();
                                this.$('.video-js').hide();
                            }
                            else if (url.indexOf('youtube.com/') != -1) {
                                var videoId = /https?:\/\/(www\.)?youtube\.com\/embed\/([^&]*)/g.exec(url)[2];
                                this.$('iframe').attr('src', 'https://www.youtube.com/embed/' + videoId + '?enablejsapi=1');
                                this.playerInitAttemptCount = 0;
                                initPlayer();
                                function initPlayer() {
                                    if (self.playerInitAttemptCount > 10)
                                        console.warn('Failed to load YouTube Iframe API in 10 attempts. YouTube videos will not be available this time.');
                                    else {
                                        if (window.youtubeIframeAPIReady)
                                            self.player = new YT.Player(self.$('iframe')[0], {
                                                events: {
                                                    'onReady': onPlayerReady,
                                                    'onStateChange': onPlayerStateChange
                                                }
                                            });
                                        else {
                                            self.playerInitAttemptCount++;
                                            setTimeout(initPlayer, 500);
                                        }
                                    }
                                }

                                this.$('iframe').show();

                                var videoTitle, videoDuration;

                                function onPlayerReady(event) {
                                    var lastCheckedPlayerTime = 0;
                                    videoTitle = self.player.getVideoData().title;
                                    videoDuration = self.player.getVideoData().duration;
                                    // Check if the user has skipped part of a video
                                    self.playerCheckInterval = setInterval(function () {
                                        if (Math.abs(lastCheckedPlayerTime - self.player.getCurrentTime()) > 1)
                                            onVideoSkipped(lastCheckedPlayerTime, self.player.getCurrentTime());
                                        lastCheckedPlayerTime = self.player.getCurrentTime();
                                    }, 500);
                                    slidesApp.playerCheckIntervals.push(self.playerCheckInterval);
                                }

                                function onPlayerStateChange(newState) {
                                    switch (newState.data) {
                                        case (YT.PlayerState.PLAYING):
                                            onVideoPlayed(self.player.getCurrentTime());
                                            break;
                                        case (YT.PlayerState.PAUSED):
                                            if (lastPlayerState == YT.PlayerState.PLAYING) {
                                                onVideoWatched(lastPlayerTime, self.player.getCurrentTime())
                                            }
                                            onVideoPaused();
                                            break;
                                        case (YT.PlayerState.ENDED):
                                            onVideoEnded();
                                            break;
                                        case (YT.PlayerState.UNSTARTED):
                                            break;
                                    }
                                    lastPlayerTime = self.player.getCurrentTime();
                                    lastPlayerState = newState.data;
                                }

                                function onVideoPlayed(start) {
                                    console.log('Played ' + videoTitle);
                                    tincan.sendStatement(GetVideoStatement('played', videoId, videoTitle, videoDuration, toTimeString(start)));
                                }

                                function onVideoPaused() {
                                    console.log('Paused ' + videoTitle);
                                    tincan.sendStatement(GetVideoStatement('paused', videoId, videoTitle, videoDuration));
                                }

                                function onVideoWatched(start, finish) {
                                    console.log('Watched ' + videoTitle + ' from ' + start + ' to ' + finish);
                                    tincan.sendStatement(GetVideoStatement('watched', videoId, videoTitle, videoDuration, toTimeString(start), toTimeString(finish)));
                                }

                                function onVideoSkipped(start, finish) {
                                    console.log('Skipped ' + videoTitle + ' from ' + start + ' to ' + finish);
                                    tincan.sendStatement(GetVideoStatement('skipped', videoId, videoTitle, videoDuration, toTimeString(start), toTimeString(finish)));
                                }

                                function onVideoEnded() {
                                    console.log('Ended ' + videoTitle);
                                    tincan.sendStatement(GetVideoStatement('completed', videoId, videoTitle, videoDuration));
                                }
                            }
                            else {
                                this.$('iframe').hide();
                                this.$('.video-js').show();
                                this.$('video').attr('src', url);
                                this.$('video > source').attr('src', url);
                                this.$('video > source').attr('type', (_.invert(mimeToExt.video))[/&ext=([^&]*)/g.exec(url)[1]]);
                                this.$('video').load();
                                this.$('video').on('loadeddata', function () {
                                    slidesApp.commands.execute('item:focus', self);
                                    self.player = videojs(self.$('video')[0], { "controls": true, "autoplay": false, "preload": "auto" }, function () {
                                        // Player (this) is initialized and ready.
                                    });
                                    self.player.on('loadeddata', function () {
//                                    self.player.currentTime(self.player.duration() / 2);
                                        self.player.play();
                                        self.player.pause();
                                    });
                                });
                            }
                            this.content.css('background-color', 'transparent');
                            this.$('.content-icon-video').first().hide();
                        }
                        break;
                    case 'pdf':
                        if(this.model.get('content') === '')
                            this.content.css({'background': '#1C1C1C'});
                        else
                            this.content.find('iframe').attr('src', slidesApp.RevealModule.getFileURL(this.model.get('content')));
                        break;
                    case 'iframe':
                        if(this.model.get('content') === '')
                            this.content.css({'background': '#1C1C1C'});
                        this.content.find('iframe').attr('src', this.model.get('content'));
                        break;
                    case 'question':
                        if(this.model.get('content') === '') {
                            this.content.css({'background': '#1C1C1C'});
                        }
                        else {
                            var questionId = parseInt(this.model.get('content'));
                            var questionModel = slidesApp.questionCollection.get(questionId);
                            var questionTypeString = (_.invert(QuestionType))[questionModel.get('questionType')];

                            // TODO: replace 'replace'
                            var questionTemplate = jQuery('#' + questionTypeString + 'Template' + questionId).html().replace(/placeholder(=")?/g, 'placeholder="' + translations.typeYourAnswerLabel + '"');
                            this.content.html(unescape(questionTemplate));
                            var data_state_prefix = questionTypeString.slice(0, questionTypeString.indexOf('Q')).toLowerCase();
                            jQuery(Reveal.getCurrentSlide()).attr('data-state', (data_state_prefix === 'shortanswer' ? 'short' : data_state_prefix) + '_' + questionId);
                        }
                        break;
                    case 'math':
                        if(this.model.get('content') === '') {
                            this.content.css({'background': '#1C1C1C'});
                        } else {
                            this.content.css({
                               'font-size': this.model.get('height') + 'px',
                                width: 'auto',
                                height: 'auto'
                            });
                            katex.render(this.model.get('content'), this.content[0], { displayMode: true });
                        }
                        break;
                }
                this.content.find('.content-icon-' + this.model.get('slideEntityType')).first().css('font-size', Math.min(this.model.get('width') / 2, this.model.get('height') / 2) + 'px');
            },
            onRender: function() {
                this.content = this.$('.item-content');
                this.updateEl();
                this.$el.css({
                    'width': this.model.get('width'),
                    'height': this.model.get('height'),
                    'top': this.model.get('top') + 'px',
                    'left': this.model.get('left') + 'px'
                });
                this.content.css({
                    'width': this.model.get('width'),
                    'height': this.model.get('height'),
                    'top': this.model.get('top') + 'px',
                    'left': this.model.get('left') + 'px'
                });
            },
            goToSlideActionInit: function() {
                var self = this;
                if( _.indexOf(['text','image'], this.model.get('slideEntityType')) > -1 && this.model.get('correctLinkedSlideId') ) {
                    this.$el.bind('click', {slideId: this.model.get('correctLinkedSlideId')}, self.goToSlideAction);
                }
            },
            goToSlideAction: function(e){
                if(e.data && e.data.slideId ) {
                    if( slidesApp.addedSlideIndices[e.data.slideId] ){
                        var slideIndices = slidesApp.addedSlideIndices[e.data.slideId];
                        Reveal.slide(slideIndices.h, slideIndices.v);
                    }
                }
            }
        });
    }
});
