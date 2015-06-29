var TinCanProcessModel = LessonContentModel.extend({
  defaults: {
    contentType: 'questionPDF',
    title: '',
    text: ''
  }
});

var TinCanProcessView = Backbone.View.extend({
  DEFAULT_SCORE: 0.7,
  events: {
    'click .embedTinCanPlayerToggle':'toggleEmbedTinCanPlayer',
    'change .theme-selector': 'updateThemeImage',
    'change .js-toggle-random': 'toggleRandomQuestionOrdering',
    'keypress .js-questionsCountToShowText': 'questionsCountKeyPress',
    'click .js-download-action': 'download',
    'click .js-publish-action': 'publish'
  },
  initialize: function() {
    this.asExternal = false;
  },
  updateThemeImage: function() {
    this.$('.theme-images img.image').hide();
    var selectedTheme = this.$('.theme-selector').val();
    this.$('.theme-images img.image.'+selectedTheme).show();
  },
  render: function () {
    var themes = [{
      id: 'slides',
      title: 'Lesson studio theme'
    }, {
      id: 'default',
      title: 'Default theme'
    },{
      id: 'beige',
      title: 'Beige theme'
    },{
      id: 'blood',
      title: 'Blood theme'
    },{
      id: 'moon',
      title: 'Moon theme'
    },{
      id: 'night',
      title: 'Night theme'
    },{
      id: 'serif',
      title: 'Serif theme'
    },{
      id: 'simple',
      title: 'Simple theme'
    },{
      id: 'sky',
      title: 'Sky theme'
    },{
      id: 'solarized',
      title: 'Solarized theme'
    }];

    var mustacheAccumulator = {themes: themes};
    _.extend(mustacheAccumulator, this.model.toJSON(), GLOBAL_translations);

    this.$el.html(Mustache.render(jQueryValamis('#processTinCanTemplate').html(), mustacheAccumulator));
    this.$('.js-plus-minus').valamisPlusMinus({
        min: 0, max: 1, step: 0.05
    });
    this.$('.js-plus-minus').valamisPlusMinus('value', this.DEFAULT_SCORE);

    this.updateThemeImage();

    return this;
  },
  toggleEmbedTinCanPlayer:function () {
    this.asExternal = !this.asExternal;
    if (this.asExternal) this.$('.embedTinCanPlayerToggle').addClass('selected');
    else this.$('.embedTinCanPlayerToggle').removeClass('selected');
  },
  toggleRandomQuestionOrdering:function() {
    this.randomOrdering = !this.randomOrdering;
    if (this.randomOrdering) {
      this.$('.js-questionsCountToShowText').removeAttr('disabled');
    }
    else {
      this.$('.js-questionsCountToShowText').attr('disabled','disabled');
    }
  },
  questionsCountKeyPress: function(e){
    if (e.keyCode != 46 && e.keyCode != 8 && e.keyCode != 9) {
      if (String.fromCharCode(e.charCode).match(/[^0-9]/g)) return false;
    }
  },
  download: function() {
    var selectedTheme = this.$('.theme-selector').val();
    var action = (this.asExternal)?'DOWNLOAD_EXTERNAL':'DOWNLOAD';
    window.location = path.root + path.api.files + 'export/?action=' + action
      + '&contentType=lesson'
      + '&id=' + this.model.id
      + '&courseId=' + Utils.getCourseId()
      + '&theme=' + selectedTheme
      + '&publishType=tincan'
      + '&randomOrdering=' + this.randomOrdering
      + '&questionsCount=' + this.$('.js-questionsCountToShowText').val();
    this.trigger('publishDownloadClose');
  },
  publish: function() {
    var selectedTheme = this.$('.theme-selector').val();
    var that = this;
    toastr.info(GLOBAL_translations['overlayProcessMessageLabel']);
    this.model.publish({
      publishType: 'tincan',
      theme: selectedTheme,
      randomOrdering: this.randomOrdering,
      questionsCount: this.$('.js-questionsCountToShowText').val(),
        scoreLimit:  this.$('.js-plus-minus').valamisPlusMinus('value')
    }).then(function (response) {
      if (response.status) {
        toastr.success(GLOBAL_translations['overlayCompleteMessageLabel']);
        that.trigger('publishDownloadClose');
      } else {
        toastr.error(GLOBAL_translations['overlayContentNeededMessageLabel']);
      }
    }, function () {
      toastr.error(GLOBAL_translations['overlayFailedMessageLabel']);
    });
  }
});

var TinCanProcessModal = Backbone.Modal.extend({
  template: function (data) {
    return Mustache.to_html(jQueryValamis('#valamisEmptyModalTemplate').html(), _.extend({header: GLOBAL_translations['publishTinCanLabel']}))
  },
  events: {

  },
  cancelEl: '.modal-close',
  className: 'val-modal',
  onRender: function () {
    var me = this;
    this.view = new TinCanProcessView({
      model: this.model,
      el: this.$('.js-modal-content')
    });
    this.view.render();
    this.view.on('publishDownloadClose', function() {
       me.trigger('modal:close');
       //me.close();
    });
  }
});