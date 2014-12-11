var articleCollectionService = new Backbone.Service({
  url: '/learn-portlet',
  sync: {
    'read': {
      'path': function () {
        return '/services/liferay/article?companyID=' + GLOBAL_companyID;
      },
      'method': 'get'
    }
  }
});

var articleService = new Backbone.Service({
  url: function () {
    return contentManagerActionUrl;
  },
  targets: {
    'getContent': {
      'path': function (model) {
        return '&companyID=' + GLOBAL_companyID
          + '&articleID=' + model.get('articleID')
          + '&language=' + model.get('localeId')
          + '&groupID=' + model.get('groupID');
      },
      'method': 'get'
    }
  }
});

var LiferayArticleModel = Backbone.Model.extend({
  parse: function (response) {
    var model = response;
    model.availableLocales = _.map(model.availableLocales, function (value, key) {
      value.id = key;
      return value;
    });
    model.localeId = model.availableLocales[0].id;
    model.title = model.titles[model.localeId];
    model.selected = false;
    return model;
  }
}).extend(articleService);

var LiferayArticleCollection = Backbone.Collection.extend({
  model: LiferayArticleModel
}).extend(articleCollectionService);

var LiferayArticleView = Backbone.View.extend({
  className: 'liferay-article',
  tagName: 'tr',
  initialize: function () {
    this.model.on('change:localeId', function () {
      this.model.set('title', this.model.get('titles')[this.model.get('localeId')]);
    }, this);

    this.model.on('change:title', function () {
      this.$('.acticle-title').html(this.model.get('title'));
    }, this);

    this.model.on('change:selected', function () {
      if (this.model.get('selected'))
        this.$el.addClass('selected');
      else
        this.$el.removeClass('selected');
    }, this)
  },
  events: {
    'change .article-locale': function () {
      this.model.set('localeId', this.$('.article-locale').val());
    },
    'click': function () {
      this.model.set('selected', true);
    }
  },
  template: $('#articleTemplate').html(),
  render: function () {
    this.$el.html(Mustache.render(this.template, this.model.attributes));
    return this;
  }
});

var LiferayArticleCollectionView = Backbone.View.extend({
  initialize: function () {
    this.collection.on('sync', this.render, this);
  },
  render: function () {
    this.collection.each(this.addOne, this);
  },
  addOne: function (liferayArticleModel) {
    var me = this;
    var liferayArticleView = new LiferayArticleView({model: liferayArticleModel});
    this.$el.append(liferayArticleView.render().el);

    liferayArticleModel.on('change:selected', function () {
      var liferayActicleModel = this;
      if (liferayActicleModel.get('selected')) {
        me.collection.each(function (item) {
          if (item != liferayActicleModel) item.set('selected', false);
        });
      }
    }, liferayArticleModel)
  },
  submit: function (lessonModel) {
    var liferayArticleModel = this.collection.find(function (item) {
      return item.get('selected');
    });

    if (!liferayArticleModel) return;
    liferayArticleModel.getContent().then(function (response) {
      var questionModel = new LessonContentQuestionPlainTextModel({
        categoryId: lessonModel.get('selectedCategoryId'),
        lessonId: lessonModel.id,
        title: liferayArticleModel.get('title'),
        text: response.text
      });
      questionModel.save({}, {});

      contentManagerEvent.trigger('question:added', questionModel);
    });
  }
});

var AddTextArticleModal = Backbone.Modal.extend({
  template: _.template(Mustache.render($('#modal-template').html(), _.extend({header: GLOBAL_translations['addTextArticleLabel']}, GLOBAL_translations))),
  submitEl: '.modal-submit',
  cancelEl: '.close-button',
  className: 'liferay-articles-modal',
  onRender: function () {
    var template = Mustache.to_html(jQuery('#articleTemplateTable').html(), GLOBAL_translations);
    this.$('.content').html(template);
    this.liferayArticleCollection = new LiferayArticleCollection();
    this.liferayArticleCollectionView = new LiferayArticleCollectionView({
      collection: this.liferayArticleCollection,
      el: this.$('#articleList')
    });
    this.liferayArticleCollection.fetch();
  },
  submit: function () {
    if (this.liferayArticleCollectionView)
      this.liferayArticleCollectionView.submit(this.model);
  }
});