var VideoModel = LessonContentModel.extend({
    defaults: {
        contentType: 'questionVideo',
        title: '',
        url: '',
        selected: false,
        icon: 'video'
    }
});

LiferayVideoModel = Backbone.Model.extend({
    defaults: {
        title: '',
        version: '',
        mimeType: ''
    }
});

LiferayVideoService = new Backbone.Service({
    url: path.root,
    sync: {
        'read': {
            'path': path.api.liferay,
            data: function (collection, options) {
                return {
                    action: 'GETVIDEO',
                    courseId: Utils.getCourseId(),
                    page: options.currentPage,
                    count: options.itemsOnPage
                }
            },
            'method': 'get'
        }
    }
});
LiferayVideoGallery = Backbone.Collection.extend({
    model: LiferayVideoModel,
    parse: function (response) {
        this.trigger('videoCollection:updated', {
            total: response.total,
            currentPage: response.currentPage,
            listed: response.records.length
        });
        return response.records;
    }
}).extend(LiferayVideoService);


var VideoView = Backbone.View.extend({
    events: {
        'click .videoType': 'changeVideoType'
    },
    render: function () {
        var mustacheAccumulator = {};
        _.extend(mustacheAccumulator, this.model.toJSON(), GLOBAL_translations);

        this.$el.html(Mustache.render(jQueryValamis('#videoTemplate').html(), mustacheAccumulator));
        this.$el.find('.js-url-edit').hide();

        this.videoCollection = new LiferayVideoGallery();
        this.videoCollection.on('reset', this.renderVideoGallery, this);

        this.videoCollection.on("videoCollection:updated", function (details) {
            that.updatePagination(details, that);
        }, this);

        var that = this;
        this.paginator = new ValamisPaginator({el: this.$('#videoPaginator'), language: GLOBAL_translations});
        this.paginator.setItemsPerPage(5);
        this.paginator.on('pageChanged', function () {
            that.videoCollection.fetch({
                reset: true,
                currentPage: that.paginator.currentPage(),
                itemsOnPage: that.paginator.itemsOnPage()
            });
        });

        this.videoCollection.fetch({reset: true, currentPage: 1, itemsOnPage: that.paginator.itemsOnPage()});
        return this;
    },
    updatePagination: function (details, context) {
        this.paginator.updateItems(details.total);
    },
    renderVideoGallery: function () {
        this.$('#dlvideo').html('');
        this.videoCollection.each(this.addVideo, this);
    },
    addVideo: function (item) {
        var view = new VideoElement({model: item});
        view.on('unselectAll', this.unselectAll, this);
        this.$('#dlvideo').append(view.render().$el);
    },
    unselectAll: function () {
        this.videoCollection.each(function (i) {
            i.set({selected: false});
        }, this);
    },
    changeVideoType: function () {
        this.$el.find('#dlVideoContainer').toggle(this.$('input#DL').prop('checked'));
        this.$el.find('#videoPaginator').toggle(this.$('input#DL').prop('checked'));
        this.$el.find('.js-url-edit').toggle(this.$('input#EMBED').prop('checked'));
    },
    submit: function () {
        var docLibrary = (this.$('input[name=videoType]:checked').val() == 'DL');
        var url = this.$('.js-url-edit').val();
        if (docLibrary) {
            var selectedVideo = this.videoCollection.find(function (item) {
                return item.get('selected');
            });
        }
        this.model.set({
            title: this.$('.js-title-edit').val() || this.model.get('lessonId') ? 'New video' : (selectedVideo) ? selectedVideo.get('title') : 'New video',
            mimeType: (selectedVideo) ? selectedVideo.get('mimeType') : '',
            url: url,
            uuid: (selectedVideo) ? selectedVideo.get('uuid') : '',
            groupID: (selectedVideo) ? selectedVideo.get('groupID') : '',
            fromDocLibrary: docLibrary
        });
        if(this.model.get('lessonId')) {
            this.model.save();
            contentManagerEvent.trigger('question:added', this.model);
        } else this.trigger('video:added', this.model);
    }
});

var VideoModal = Backbone.Modal.extend({
  template: function (data) {
    return Mustache.to_html(jQueryValamis('#lessonDesignerEmptyModalTemplate').html(),
      _.extend({header: GLOBAL_translations['AddVideoLabel']}, GLOBAL_translations))
  },
    submitEl: '.bbm-button',
    cancelEl: '.modal-close',
    className: 'val-modal',
    onRender: function () {
        this.view = new VideoView({
            model: this.model,
            el: this.$('.js-modal-content')
        });
        this.view.render();
        var self = this;
        this.view.on('video:added', function(model) { self.trigger('video:added', model) });
    },
    submit: function () {
        if (this.view)
            this.view.submit(this.model);
    }
});

VideoElement = Backbone.View.extend({
    events: {
        'click .js-toggleButton': 'toggleThis'
    },
    tagName: 'tr',
    initialize: function () {
        this.model.on('change', this.render, this);
    },
    render: function () {
        var template = Mustache.to_html(jQueryValamis('#liferayVideoElementView').html(), this.model.toJSON());
        this.$el.html(template);
        return this;
    },
    toggleThis: function () {
        var selected = !this.model.get('selected');
        this.trigger('unselectAll', this);
//    this.$('#dlvideo').find('.js-toggleButton').removeClass('selected');
//    if (selected) this.$el.find('.js-toggleButton').addClass('selected');
        this.model.set({selected: selected});
    }
});