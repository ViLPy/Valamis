var VideoModel = LessonContentModel.extend({
  defaults: {
    contentType: 'questionVideo',
    title: '',
    url: '',
    selected: false
  }
});

LiferayVideoModel = Backbone.Model.extend({
  defaults:{
    title:'',
    version:'',
    mimeType: ''
  }
});

LiferayVideoService = new Backbone.Service({ url: path.root,
  sync: {
    'read': function (collection, options) {
      return path.api.liferay + '?action=GETVIDEO&groupID='+ jQuery('#courseID').val() +
        '&page=' + options.currentPage +
        '&count=' + options.itemsOnPage;
    }
  }
});
LiferayVideoGallery = Backbone.Collection.extend({
  model: LiferayVideoModel,
  parse: function (response) {
    this.trigger('videoCollection:updated', { total: response.total, currentPage: response.currentPage, listed: response.records.length });
    return response.records;
  }
}).extend(LiferayVideoService);


var VideoView = Backbone.View.extend({
  template: $('#videoTemplate').html(),
  events:{
    'click .videoType':'changeVideoType'
  },
  render: function () {
    var mustacheAccumulator = {};
    _.extend(mustacheAccumulator, this.model.toJSON(), GLOBAL_translations);

    this.$el.html(Mustache.render(this.template, mustacheAccumulator));
    this.$el.find('.url-edit').hide();

    this.videoCollection = new LiferayVideoGallery();
    this.videoCollection.on('reset', this.renderVideoGallery, this);

    this.videoCollection.on("videoCollection:updated", function (details) {
      that.updatePagination(details, that);
    }, this);

    var that = this;
    this.paginator = new ValamisPaginator({el: this.$('#videoPaginator'), language: GLOBAL_translations});
    this.paginator.setItemsPerPage(5);
    this.paginator.on('pageChanged', function () {
      that.videoCollection.fetch({reset: true, currentPage: that.paginator.currentPage(), itemsOnPage: that.paginator.itemsOnPage()});
    });

    this.videoCollection.fetch({reset: true, currentPage: 1, itemsOnPage:  that.paginator.itemsOnPage()});
    return this;
  },
  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
  },
  renderVideoGallery: function(){
    jQuery('#dlvideo').html('');
    this.videoCollection.each(this.addVideo, this);
  },
  addVideo: function(item){
    var view = new VideoElement({model:item});
    view.on('unselectAll', this.unselectAll, this);
    this.$('#dlvideo').append(view.render().$el);
  },
  unselectAll: function(){
    this.videoCollection.each(function(i){
      i.set({selected: false});
    }, this);
  },
  changeVideoType: function(){
    this.$el.find('#dlVideoContainer').toggle();
    this.$el.find('.url-edit').toggle();
  },
  submit: function () {
    var docLibrary = (this.$('input[name=videoType]:checked').val() == 'DL');
    var url = this.$('.url-edit').val();
    if (docLibrary){
      var selectedVideo = this.videoCollection.find(function (item) {
        return item.get('selected');
      });
    }
    this.model.set({
      title: this.$('.title-edit').val() || 'New video',
      url: url,
      uuid: (selectedVideo) ? selectedVideo.get('uuid') : '',
      groupID: (selectedVideo) ? selectedVideo.get('groupID') : '',
      fromDocLibrary: docLibrary
    });
    this.model.save();
    contentManagerEvent.trigger('question:added', this.model);
  }
});

var VideoModal = Backbone.Modal.extend({
  template: _.template(Mustache.render($('#modal-template').html(), _.extend({header: GLOBAL_translations['addVideoLabel']}, GLOBAL_translations))),
  submitEl: '.modal-submit',
  cancelEl: '.close-button',
  className: 'add-external-resource-modal',
  onRender: function () {
    this.view = new VideoView({
      model: this.model,
      el: this.$('.content')
    });
    this.view.render();
  },
  submit: function () {
    if (this.view)
      this.view.submit(this.model);
  }
});

VideoElement = Backbone.View.extend({
  events:{
    'click .toggleButton':'toggleThis'
  },
  initialize:function () {
    this.$el = jQuery('<tr>');
  },
  render:function () {
    var template = Mustache.to_html(jQuery('#liferayVideoElementView').html(), this.model.toJSON());
    this.$el.html(template);
    return this;
  },
  toggleThis:function () {
    var selected = !this.model.get('selected');
    this.trigger('unselectAll', this);
    jQuery('#dlvideo').find('.toggleButton').removeClass('selected');
    if (selected) this.$el.find('.toggleButton').addClass('selected');
    this.model.set({selected: selected});
  }
});