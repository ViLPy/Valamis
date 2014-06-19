var EntityView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
    this.clear();
  },

  edit: function () {
    if (this.currentView) {
      this.currentView.renderEdit();
    }
  },
  renderEditor: function () {
    if (this.currentView) {
      this.currentView.renderEditor();
    }
  },

  renderEntityList: function (catCollection, qCollection, isRoot, title) {
    if (this.currentView) this.currentView.remove();

    this.currentView = new qbEntityListView({
      catCollection: catCollection,
      qCollection: qCollection,
      language: this.language,
      isRoot: isRoot,
      title: title
    });
    this.currentView.on('editEntityRow', function (item) {
      this.trigger('editEntityRow', item);
    }, this);
    this.currentView.on('removeEntityRow', function (item) {
      this.trigger('removeEntityRow', item);
    }, this);
    this.$el.html(this.currentView.render().$el);
    this.currentView.renderEntities();
  },


  render: function (model, categoryChild, categoryTitle) {
    if (this.currentView) this.currentView.remove();

    if (model instanceof CategoryModel) {
      this.currentView = new CategoryView({
        model: model,
        language: this.language
      });
      this.currentView.on('qb-entity-updated', function () {
        this.trigger('qb-entity-updated', this);
      }, this);
      this.$el.html(this.currentView.render().$el);
    } else if (model instanceof QuestionModel) {
      this.currentView = new QuestionView({
        model: model,
        categoryChild: categoryChild,
        categoryTitle: categoryTitle,
        language: this.language
      });
      this.currentView.on('qb-entity-updated', function () {
        this.trigger('qb-entity-updated', this);
      }, this);
      this.$el.html(this.currentView.render().$el);
    } else {
      this.clear();
    }
    return this;
  },

  renderEditQuestion: function (model) {
    if (this.currentView) this.currentView.remove();

    if (model instanceof QuestionModel) {
      this.currentView = new QuestionView({
        el: this.$el,
        model: model,
        language: this.language
      });
      this.currentView.on('qb-entity-updated', function () {
        this.trigger('qb-entity-updated', this);
      }, this);
      this.currentView.render();
      this.edit();
    } else {
      this.clear();
    }
    return this;
  },

  clear: function () {
    this.$el.empty();
    var language = this.language;
    this.$el.html(Mustache.to_html(jQuery("#defaultView").html(), language));
  }
});