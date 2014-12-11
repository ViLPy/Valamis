var LessonContentModelService = new Backbone.Service({
   url: path.root,
  targets: {
    'move': {
      'path': path.api.quiz + '?action=MOVEELEMENT',
      'data': function (model, options) {
        return {
          'lessonId': model.get('lessonId'),
          'id': model.id,
          'categoryId': options.parentID,
          'index': options.index
        }
      },
      'method': 'post'
    }
  },
  sync: {
    create: {
      'path': function (model, options) {
        if (options.bankQuestionIds) {
          return path.api.quiz + '?action=ADD' + model.get('contentType').toUpperCase() + "&" + options.bankQuestionIds;
        }
        else return path.api.quiz + '?action=ADD' + model.get('contentType').toUpperCase();
      },
      'method': 'post'
    },
    update: {
      'path': function (model) {
        return path.api.quiz + '?action=UPDATE' + model.get('contentType').toUpperCase();
      },
      'method': 'post'
    },
    delete: {
      'path': function (model) {
        var type = 'CATEGORY';
        if (model.get('contentType').indexOf('question') === 0) type = 'QUESTION';
        return path.api.quiz + '?action=DELETE' + type;
      },
      data: function(model) {
        return {lessonId: model.get('lessonId'), id: model.id};
      },
      'method': 'post'
    }
  }
});

var LessonContentModel = Backbone.Model.extend({
  /*   question
   ==============
   choiceQuestion,
   shortAnswerQuestion,
   numericQuestion,
   positioningQuestion,
   matchingQuestion,
   essayQuestion,
   categorizationQuestion
   plainText
   ==============

   welcomePage,
   finalPage,

   category,
   liferayArticle,
   picture,
   video,
   externalResource
   */
  defaults: {
    collapsed: true
  }
}).extend(LessonContentModelService);

var LessonContentQuestionModel = LessonContentModel.extend({
  defaults: {
    contentType: 'question',
    collapsed: true
  }
});
var LessonContentQuestionPlainTextModel = LessonContentModel.extend({
  defaults: {
    contentType: 'questionPlainText',
    collapsed: true
  }
});

var LessonContentCategoryModel = LessonContentModel.extend({
  defaults: {
    title: 'new category',
    description: '',
    contentType: 'category',
    collapsed: true,
    selected: false
  }
});

var LessonContentService = new Backbone.Service({
   url: path.root,
  sync: {
    'read': {
      'path': function (model, options) {
        return path.api.quiz + '?action=GETCONTENT'
          + '&id=' + options.id;
      },
      'method': 'get'
    }
  }
});

var LessonContentCollection = Backbone.Collection.extend({
  model: function (attrs, options) {
    switch (attrs.contentType) {
      case 'category':
        return new LessonContentCategoryModel(attrs, options);
      case 'questionExternalResource':
        return new ExternalResourceModel(attrs, options);
      case 'questionPlainText':
        return new LessonContentQuestionPlainTextModel(attrs, options);
      case 'questionRevealJS':
        return new RevealJSModel(attrs, options);
      case 'questionPDF':
        return new PDFModel(attrs, options);
      case 'questionPPTX':
        return new PPTXModel(attrs, options);
      case 'question':
        return new LessonContentQuestionModel(attrs, options);
      case 'questionVideo':
        return new VideoModel(attrs, options);
      case 'questionVideoDL':
            return new VideoModel(attrs, options);
      default:
        throw Error('unsupport question type: ' + attrs.contentType);
    }
  },
  comparator: 'arrangementIndex'
}).extend(LessonContentService);

var LessonContentEditModal = Backbone.Modal.extend({
  template: _.template(Mustache.render($('#modal-clear-template').html(), {header: GLOBAL_translations['editContentLabel']})),
  cancelEl: '.modal-close',
  className: 'lesson-content-edit',

  beforeSubmit: function(){
    // allow to use ENTER key for other purposes
    return false;
  },
  events: {
//      'click .modal-submit': 'bodyOverflowHidden',
      'click .modal-close': 'bodyOverflowHidden'
  },
  onRender: function () {
    jQuery('#content-manager-body').addClass("body-overflow-hidden");
    this.contentView = new LessonContentEditView({ model: this.model});
    this.$('.content').html(this.contentView.render().$el);
    this.model.set({wasChanged: false});
  },
  onClose: function () {
    this.contentView.remove();
    if (this.model.get('wasChanged')) {
      contentManagerEvent.trigger('lesson:model:changed', this.model);
    }
  },
  bodyOverflowHidden: function () {
      jQuery('#content-manager-body').removeClass("body-overflow-hidden");
  }
});

var LessonContentEditView = Backbone.View.extend({
 // template: $('#lesson-edit-content').html(),
  template: _.template(Mustache.to_html($('#lesson-edit-content').html(), GLOBAL_translations)),
  events: {
    'click .add-text-article': 'addTextArticle',
    'click .add-external-resource': 'addExternalResource',
    'click .add-reveal-presentation': 'addRevealJS',
    'click .add-pdf': 'addPDF',
    'click .add-pptx': 'addPPTX',
    'click .add-category ': 'addCategory',
    'click .add-question': 'addBankQuestion',
    'click .add-video': 'addVideo',
    'click #toggle-sidebar': 'toggleSidebar',
    'click .hide-filter': 'hideFilter'
  },
  initialize: function () {
    this.collection = new LessonContentCollection();
    this.collection.fetch({id: this.model.id});

    this.listenTo(this.collection, 'reset', this.render);
    this.listenTo(this.collection, 'change:selected', this.onSelectedChanged);
    this.listenTo(contentManagerEvent, 'question:added', this.onQuestionAdded);
    this.listenTo(contentManagerEvent, 'lesson:collection:sorted', this.updateCollectionSorting);
    this.listenTo(contentManagerEvent, 'lesson:content:changed', function() {this.model.set({wasChanged: true}); });
    this.listenTo(contentManagerEvent, 'lesson:content:deleted', this.deleteCollectionChildren);
  },
  render: function () {
    this.$el.html(this.template);

    this.contentView = new LessonContentCollectionView({
      collection: this.collection
    });
    this.$('.lesson-content').html(this.contentView.render().el);

    return this;
  },
  deleteCollectionChildren: function(deletedModel) {
    var category = this.collection.find(function (i) {
        return i.id == deletedModel.get('categoryId');
    });
    if (!category) return;
    var collectionChildren = category.get('children');

    if (collectionChildren != undefined) {
        for (var i = 0; i < collectionChildren.length; i++) {
            if (collectionChildren[i].id == deletedModel.get('id')) {
                collectionChildren.splice(i, 1);
                break;
            }
        }
    }
  },
  updateCollectionSorting: function (modelID, parentID, index) {
    var model = this.collection.get(modelID);
    var _this = this;
    if (model) {
      model.move({}, {parentID: parentID, index: index}).then(function(){
        _this.collection.fetch({id: _this.model.id, reset:true, silent: true});
      });
    } else {
      // OMG, sorry for this
      var categories = this.collection.filter(function (e) {
        return e.id.indexOf('c_') === 0;
      });

      categories.forEach(function (c) {
        c.get('children').forEach(function (q) {
          if (q.id === modelID) {
            var m = new LessonContentModel(q);
            m.move({}, {parentID: parentID, index: index}).then(function(){
              _this.collection.fetch({id: _this.model.id, reset:true, silent: true});
            });
          }
        });
      });
    }
  },
  onSelectedChanged: function (categoryModel) {
    if (categoryModel.get('selected'))
      this.model.set('selectedCategoryId', categoryModel.get('id'));
    else
      this.model.unset('selectedCategoryId');
  },
  onQuestionAdded: function (questionModel) {
    if (questionModel.isCollection) {
      var that = this;
      questionModel.items.forEach(function(i){ that.addQuestionElement(i)});
    }
    else this.addQuestionElement(questionModel);
    this.model.set({wasChanged: true});
    this.render();
  },
  addQuestionElement: function (questionModel) {
    if (!questionModel.get('categoryId')) {
      this.collection.add(questionModel);
    }
    else {
      var category = this.collection.find(function (i) {
        return i.id == questionModel.get('categoryId');
      });
      if (category) category.get('children').push(questionModel);
    }

    //TODO: replace to ...categoryCollection.add(questionModel)
    this.render();
  },
  addCategory: function () {
    var model = new LessonContentCategoryModel({
      lessonId: this.model.id
    });
    var _this = this;
    model.save({}, {success: function () {
      _this.collection.add(model);
      _this.contentView.toggleSelectedCategory(model);
      _this.onSelectedChanged(model);
    }});
  },
  addTextArticle: function () {
    contentManagerEvent.trigger('modals:show:addTextArticleView', this.model)
  },
  addBankQuestion: function () {
    contentManagerEvent.trigger('modals:show:bankQuestionSelect', this.model)
  },
  addExternalResource: function () {
    var model = new ExternalResourceModel({
      lessonId: this.model.id,
      categoryId: this.model.get('selectedCategoryId')
    });
    contentManagerEvent.trigger('modals:show:addExternalResourceView', model)
  },
  addRevealJS: function () {
    var model = new RevealJSModel({
      lessonId: this.model.id,
      categoryId: this.model.get('selectedCategoryId')
    });
    contentManagerEvent.trigger('modals:show:addRevealJSView', model)
  },
  addPDF: function () {
    var model = new PDFModel({
      lessonId: this.model.id,
      categoryId: this.model.get('selectedCategoryId')
    });
    contentManagerEvent.trigger('modals:show:addPDFView', model)
  },
  addPPTX: function () {
    var model = new PPTXModel({
      lessonId: this.model.id,
      categoryId: this.model.get('selectedCategoryId')
    });
    contentManagerEvent.trigger('modals:show:addPPTXView', model)
  },
  toggleSidebar: function () {
    var searchPanel = this.$('.sidebar-wrapper');       // was .filter-panel
    if (searchPanel.hasClass('show')) searchPanel.removeClass('show');
    else searchPanel.addClass('show');
  },
  hideFilter: function () {
    this.$('.sidebar-wrapper').removeClass('show');    // was .filter-panel
  },
  addVideo: function(){
    var model = new VideoModel({
      lessonId: this.model.id,
      categoryId: this.model.get('selectedCategoryId')
    });
    contentManagerEvent.trigger('modals:show:addVideoView', model)
  }
});

var LessonContentModelView = Backbone.View.extend({
  initialize: function () {
    this.model.on('change', this.render, this);
    this.model.on('sync', this.render, this);
  },
  tagName: 'div',
  events: {
    'click .action-delete': 'deleteFromLesson',
    'click .action-preview': 'preview',
    'click .action-edit': 'edit',
    'click .action-save': 'save',
    'click .action-cancel': 'cancel',
    'change .immediate-answer-flag': 'updateAnswerFlag',
    'keypress .title-edit': 'titleEdit'
  },
  template: $('#contentEditorPageItemView').html(),
  templateEdit: $('#lesson-content-edit-inline-template').html(),
  renderWithTemplate: function (template) {
    var isBankQuestion = this.model.get('contentType') == 'question';
    var mustacheAccumulator = {};
    _.extend(mustacheAccumulator, GLOBAL_translations);
    _.extend(mustacheAccumulator, this.model.attributes);
    _.extend(mustacheAccumulator, {isEdited: !isBankQuestion, isCategory: false, contentType: this.model.get('contentType'),  isQuizQuestion: this.model.get('contentType') === 'question'});
    this.$el.html(Mustache.render(template, mustacheAccumulator));

    this.$el.attr('data-model-id', this.model.id);

    return this;
  },
  render: function () {
    return this.renderWithTemplate(this.template);
  },
  preview: function () {
    contentManagerEvent.trigger('modals:show:lessonContentPreviewView', this.model);
  },
  deleteFromLesson: function () {
    this.model.destroy();
    this.remove();
    this.render();
    contentManagerEvent.trigger('lesson:content:changed', this.model);
    contentManagerEvent.trigger('lesson:content:deleted', this.model);
  },
  edit: function () {
    if (this.model.get('contentType') == 'questionExternalResource')
      contentManagerEvent.trigger('modals:show:addExternalResourceView', this.model);
    else if (this.model.get('contentType') == 'questionRevealJS')
      contentManagerEvent.trigger('modals:show:addRevealJSView', this.model);
    else
      this.renderWithTemplate(this.templateEdit);
  },
  updateAnswerFlag: function() {
    this.model.set('autoShowAnswer', this.$('.immediate-answer-flag').is(':checked'));
    this.model.save();
    this.render();
  },
  save: function () {
    this.model.set('title', this.$('.title-edit').val());
    this.model.save();
    this.render();
  },
  cancel: function () {
    this.render();
  },
  titleEdit: function(e){
    if (e.keyCode == 13) {
      e.stopPropagation();
      this.save();
      return false;
    }
  }

});

LessonContentCategoryView = Backbone.View.extend({
  tagName: 'div',
  className: 'category',
  events: {
    'click .category-icon': 'expandCategory',
    'click .action-delete': 'deleteCategory',
    'click .action-edit': 'edit',
    'click .action-save': 'save',
    'click .action-cancel': 'cancel',
    'click': 'toggleSelect',
    'keypress .title-edit': 'titleEdit'
  },
  expandCategory: function () {
    this.$('.internal-collection').toggleClass('collapsed');
    this.$('.category-expand-button').toggleClass('category-collapsed');

    this.model.set('collapsed', this.$('.internal-collection').hasClass('collapsed'));
  },
  template: $('#contentEditorPageItemView').html(),
  templateEdit: $('#lesson-content-edit-inline-template').html(),
  renderWithTemplate: function (template) {
    var mustacheAccumulator = {};
    _.extend(mustacheAccumulator, GLOBAL_translations);
    _.extend(mustacheAccumulator, this.model.attributes);
    _.extend(mustacheAccumulator, {isCategory: true, isEdited: true, contentType: this.model.get('contentType')});
    this.$el.html(Mustache.render(template, mustacheAccumulator));
    new LessonContentCollectionView({
      collection: new LessonContentCollection(this.model.get('children')),
      el: this.$('.internal-collection')
    }).render();

    this.$el.attr('data-model-id', this.model.id);

    this.onToggleSelect();

    return this;
  },
  render: function () {
    return this.renderWithTemplate(this.template);
  },
  initialize: function () {
    this.model.on('change:selected', this.onToggleSelect, this);
  },
  deleteCategory: function () {
    if (this.model.get('selected')) {
      this.trigger('toggleSelect', this.model);
    }
    this.model.destroy();
    this.remove();
    contentManagerEvent.trigger('lesson:content:changed', this.model);
  },
  edit: function () {
    this.renderWithTemplate(this.templateEdit);
  },
  save: function () {
    this.model.set('title', this.$('.title-edit').val());
    this.model.save();
    this.render();
  },
  cancel: function () {
    this.render();
  },
  toggleSelect: function () {
    this.trigger('toggleSelect', this.model);
  },
  onToggleSelect: function () {
    if (this.model.get('selected'))
      this.$el.addClass('selected');
    else
      this.$el.removeClass('selected');
  },
  titleEdit: function(e){
    if (e.keyCode == 13) {
      e.stopPropagation();
      this.save();
      return false;
    }
  }
});

var LessonContentCollectionView = Backbone.View.extend({
  initialize: function () {
    var _this = this;
    this.collection.on('reset', function () {
      _this.addAll();
      _this._refreshSortable();
    }, this);
    this.collection.on('add', function (elem) {
      _this.addOne(elem);
      _this._refreshSortable();
    }, this);
    this.addAll();
    this._refreshSortable();
  },
  className: 'content-editor-sortable',
  tagName: 'div',
  render: function () {
    return this;
  },
  addAll: function () {
    this.collection.each(this.addOne, this);
  },
  addOne: function (lessonContentItem) {
    if (lessonContentItem.get('contentType').indexOf('question') === 0) {
      this.$el.append(
        new LessonContentModelView({model: lessonContentItem})
          .render().el
      );
    }
    if (lessonContentItem.get('contentType') == 'category') {
      this.$el.append(
        new LessonContentCategoryView({model: lessonContentItem})
          .on('toggleSelect', this.toggleSelectedCategory, this)
          .render().el
      );
    }
  },
  toggleSelectedCategory: function (collectionModel) {
    var wasSelected = collectionModel.get('selected');
    this.collection.each(function (model) {
      if (model.get('contentType') == 'category' && model.get('selected')) model.set('selected', false);
    });
    collectionModel.set('selected', !wasSelected);
  },
  _refreshSortable: function () {
    this._makeSortable(this.$el);
    this._makeSortable(this.$('.content-editor-sortable, .category>.internal-collection'));
  },
  _makeSortable: function (elements) {
    var _this = this;
    elements.each(function (index, element) {
      element = jQuery(element);
      if (element.hasClass('ui-sortable')) {
        element.sortable('refresh');
        return;
      }

      element.sortable({
        placeholder: 'ui-state-highlight',
        connectWith: '.content-editor-sortable, .category>.internal-collection',
        distance: 15,
        opacity: 0.8
      }).on('sort',function (event, ui) {
          var parent = $(ui.placeholder).parent().parent();
          if (ui.item.hasClass('category') && parent.hasClass('category')) {
            ui.placeholder.addClass('ui-wrong-helper');
          } else {
            ui.placeholder.removeClass('ui-wrong-helper');
          }
        }).on('sortstop',function (event, ui) {
          if (ui.placeholder.hasClass('ui-wrong-helper')) {
            event.preventDefault();
          }
        }).on('sortupdate', function (event, ui) {
          if (this !== ui.item.parent()[0]) return;
          var parent = $(ui.item).parent().parent();
          var parentID = parent.attr('data-model-id');
          var index = $(ui.item).index() + 1; // indices in sortabl are zero-based, need to increment them
          _this.updateCollection(ui.item.attr('data-model-id'), parentID, index);
        });
    });
  },
  updateCollection: function (modelID, parentID, index) {
    contentManagerEvent.trigger('lesson:collection:sorted', modelID, parentID, index);
  }
});

