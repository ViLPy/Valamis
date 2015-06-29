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
        'create': {
            'path': path.api.quiz,
            'data': function(model, options){
                var params = _.extend(model.toJSON() ,  {
                    action: 'ADD' + model.get('contentType').toUpperCase(),
                    courseId: Utils.getCourseId()
                });

                if(options.bankQuestionIds){
                    params.bankQuestionIds = options.bankQuestionIds;
                }

                return params;
            },
            'method': 'post'
        },
        'update': {
            'path': function (model) {
                return path.api.quiz + '?action=UPDATE' + model.get('contentType').toUpperCase() +
                    '&courseId=' + Utils.getCourseId();
            },
            //'data': function(model){
            //    return {
            //        action: 'UPDATE' + model.get('contentType').toUpperCase(),
            //        courseId: Utils.getCourseId()
            //   };
            //},
            'method': 'post'
        },
        'delete': {
            'path': path.api.quiz,
            'data': function (model) {
                var type = 'CATEGORY';
                if (model.get('contentType').indexOf('question') === 0) type = 'QUESTION';
                return {
                    action: 'DELETE' + type,
                    lessonId: model.get('lessonId'),
                    id: model.id,
                    courseId: Utils.getCourseId()
                };
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
        collapsed: true,
        icon:'content'
    }
});
var LessonContentQuestionPlainTextModel = LessonContentModel.extend({
    defaults: {
        contentType: 'questionPlainText',
        collapsed: true,
        icon: 'text'
    }
});

var LessonContentCategoryModel = LessonContentModel.extend({
    defaults: {
        title: 'new category',
        description: '',
        contentType: 'category',
        collapsed: false,
        selected: false
    }
});

var LessonContentService = new Backbone.Service({
    url: path.root,
    sync: {
        'read': {
            'path': path.api.quiz,
            'data': function(model, options){
                return {
                    action: 'GETCONTENT',
                    id: options.id,
                    courseId: Utils.getCourseId()
                };
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
    template: function (data) {
      return Mustache.to_html(jQueryValamis('#modal-clear-template').html(), {header: GLOBAL_translations['EditContentLabel']})
    },
    cancelEl: '.modal-close',
    className: 'val-modal lesson-content-edit',

    beforeSubmit: function () {
        // allow to use ENTER key for other purposes
        return false;
    },
    events: {
//      'click .modal-submit': 'bodyOverflowHidden',
        'click .modal-close': 'bodyOverflowHidden'
    },
    cancel:function(){
        this.onClose();
    },
    onRender: function () {
        jQueryValamis('#content-manager-body').addClass("body-overflow-hidden");
        this.contentView = new LessonContentEditView({model: this.model});
        this.$('.js-modal-content').html(this.contentView.render().$el);
        this.model.set({wasChanged: false});
    },
    onClose: function () {
        if (this.model.get('wasChanged')) {
            contentManagerEvent.trigger('lesson:model:changed', this.model);
        }
        this.contentView.stopListenig();
        this.contentView.remove();
    },
    bodyOverflowHidden: function () {
        jQueryValamis('#content-manager-body').removeClass("body-overflow-hidden");
    }
});

var LessonContentEditView = Backbone.View.extend({
    template: function () {
        return _.template(Mustache.to_html(jQueryValamis('#lesson-edit-content').html(),
          _.extend({}, GLOBAL_translations, permissionActionsLessonDesigner)))
    },
    events: {
        'click .js-add-text-article': 'addTextArticle',
        'click .js-add-external-resource': 'addExternalResource',
        'click .js-add-reveal-presentation': 'addRevealJS',
        'click .js-add-pdf': 'addPDF',
        'click .js-add-pptx': 'addPPTX',
        'click .js-add-category ': 'addCategory',
        'click .js-add-question': 'addBankQuestion',
        'click .js-add-video': 'addVideo',
        'click .hide-filter': 'hideFilter'
    },
    stopListenig: function(){
        this.stopListening(contentManagerEvent);
        this.stopListening(this.collection);
    },
    initialize: function () {
        this.collection = new LessonContentCollection();
        this.collection.fetch({id: this.model.id});
        this.listenTo(this.collection, 'reset', this.render);
        this.listenTo(this.collection, 'change:selected', this.onSelectedChanged);
        this.listenTo(contentManagerEvent, 'question:added', this.onQuestionAdded);
        this.listenTo(contentManagerEvent, 'lesson:collection:sorted', this.updateCollectionSorting);
        this.listenTo(contentManagerEvent, 'lesson:content:changed', function () {
            this.model.set({wasChanged: true});
        });
        this.listenTo(contentManagerEvent, 'lesson:content:deleted', this.deleteCollectionChildren);
    },
    render: function () {
        this.$el.html(this.template());

        this.contentView = new LessonContentCollectionView({
            collection: this.collection
        });
        this.$('.js-lesson-content').html(this.contentView.render().el);

        this.$('.dropdown').valamisDropDown();
        return this;
    },
    deleteCollectionChildren: function (deletedModel) {
        var that = this;

        var category = this.collection.find(function (i) {
            return i.id == deletedModel.get('categoryId');
        });
        if (!category) {
            var size = that.model.get('size');
            var children = deletedModel.get('children');
            var amount = children ? children.length : 1;
            that.model.set('size', size - amount);
            return;
        }
        var collectionChildren = category.get('children');
        if (collectionChildren != undefined) {
            for (var i = 0; i < collectionChildren.length; i++) {
                if (collectionChildren[i].id == deletedModel.get('id')) {
                    collectionChildren.splice(i, 1);
                    var size = that.model.get('size');
                    that.model.set('size', size - 1);
                    break;
                }
            }
        }
    },
    updateCollectionSorting: function (modelID, parentID, isParentCollapsed, index) {
        var model = this.collection.get(modelID);
        var _this = this;
        if (model) {
            model.move({}, {parentID: parentID, index: index}).then(function () {
                _this.collection.fetch({id: _this.model.id, silent: true});
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
                        m.move({}, {parentID: parentID, index: index}).then(function () {
                            _this.collection.fetch({id: _this.model.id, silent: true});
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
        var that = this;
        if (questionModel.isCollection) {
            questionModel.items.forEach(function (i) {
                that.addQuestionElement(i);
            });
        } else {
            this.addQuestionElement(questionModel);

        }
        this.model.set({wasChanged: true});
        this.render();
    },
    addQuestionElement: function (questionModel) {
        var size = this.model.get('size');
        this.model.set('size', 1 + size);

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
            lessonId: this.model.id,
            collapsed : true,
            isEmpty: true
        });
        var _this = this;
        model.save({}, {
            success: function () {
                _this.collection.add(model);
                _this.contentView.toggleSelectedCategory(model);
                _this.onSelectedChanged(model);
            }
        });
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
    addVideo: function () {
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

        this.template = jQueryValamis('#contentEditorPageItemView').html();
        this.templateEdit = jQueryValamis('#lesson-content-edit-inline-template').html();
    },
    tagName: 'li',
    className: 'question lesson-item-li',
    events: {
        'click .js-action-delete': 'deleteFromLesson',
        'click .js-action-preview': 'preview',
        'click .js-action-edit': 'edit',
        'click .js-action-save': 'save',
        'click .js-action-cancel': 'cancel',
        'change .js-immediate-answer-flag': 'updateAnswerFlag',
        'keypress .title-edit': 'titleEdit'
    },
    renderWithTemplate: function (template) {
        var isBankQuestion = this.model.get('contentType') === 'question';
        var canSetShowRightAnswer = false;
        if(isBankQuestion) {
            var typeCode = this.model.get('questionTypeCode') || -1;
            var withoutAnswers =[5, 8, 9];
            canSetShowRightAnswer = (withoutAnswers.indexOf(typeCode) < 0);
        }

        var mustacheAccumulator = {};
        _.extend(mustacheAccumulator, GLOBAL_translations);
        _.extend(mustacheAccumulator, this.model.attributes);
        _.extend(mustacheAccumulator, {
            isEdited: !isBankQuestion,
            isCategory: false,
            contentType: this.model.get('contentType'),
            isQuizQuestion: isBankQuestion,
            canSetShowRightAnswer: canSetShowRightAnswer
        });
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
        contentManagerEvent.trigger('lesson:content:changed', this.model);
        contentManagerEvent.trigger('lesson:content:deleted', this.model);

        this.model.destroy();
        this.remove();
        this.render();
    },
    edit: function () {
        if (this.model.get('contentType') == 'questionExternalResource')
            contentManagerEvent.trigger('modals:show:addExternalResourceView', this.model);
        else if (this.model.get('contentType') == 'questionRevealJS')
            contentManagerEvent.trigger('modals:show:addRevealJSView', this.model);
        else
            this.renderWithTemplate(this.templateEdit);
    },
    updateAnswerFlag: function () {
        this.model.set('autoShowAnswer', this.$('.js-immediate-answer-flag').is(':checked'));
        this.model.save();
        this.render();
    },
    save: function () {
        this.model.set('title', this.$('.js-title-edit').val() || 'New name');
        this.model.save();
        this.render();
    },
    cancel: function () {
        this.render();
    },
    titleEdit: function (e) {
        if (e.keyCode == 13) {
            e.stopPropagation();
            this.save();
            return false;
        }
        }

});

LessonContentCategoryView = Backbone.View.extend({
    tagName: 'li',
    className: 'category lesson-item-li',
    events: {
        'click .js-expand-icon': 'expandCategoryClick',
        'click .js-action-delete': 'deleteCategory',
        'click .js-action-edit': 'edit',
        'click .js-action-save': 'save',
        'click .js-action-cancel': 'cancel',
        'click': 'toggleSelect',
        'keypress .title-edit': 'titleEdit'
    },
    initialize: function () {
        this.model.on('change:selected', this.onToggleSelect, this);
        this.template = jQueryValamis('#contentEditorPageItemView').html();
        this.templateEdit = jQueryValamis('#lesson-content-edit-inline-template').html();
    },
    render: function () {
        return this.renderWithTemplate(this.template);
    },
    renderWithTemplate: function (template) {
        var mustacheAccumulator = {};
        _.extend(mustacheAccumulator, GLOBAL_translations);
        _.extend(mustacheAccumulator, this.model.attributes);
        _.extend(mustacheAccumulator, {
            isCategory: true,
            isEdited: true,
            contentType: this.model.get('contentType'),
            isEmpty: this.model.get('children').length <= 0,
            collapsed: this.model.get('children').length <= 0
        });
        this.$el.html(Mustache.render(template, mustacheAccumulator));
        new LessonContentCollectionView({
            collection: new LessonContentCollection(this.model.get('children')),
            el: this.$('.js-internal-collection')
        }).render();

        this.$el.attr('data-model-id', this.model.id);

        this.onToggleSelect();

        var that = this;
        this.listenTo(contentManagerEvent, 'lesson:collection:sorted', function(modelId, parentId, isParentCollapsed, index){
            if(!parentId || that.model.get('id') != parentId) return;
            if (isParentCollapsed)
              that.expandCategory();
        });
        return this;
    },
    deleteCategory: function () {
        if (this.model.get('selected')) {
            this.trigger('toggleSelect', this.model);
        }
        contentManagerEvent.trigger('lesson:content:deleted', this.model);
        contentManagerEvent.trigger('lesson:content:changed', this.model);
        this.model.destroy();
        this.remove();
    },
    edit: function () {
        this.renderWithTemplate(this.templateEdit);
    },
    save: function () {
        this.model.set('title', this.$('.js-title-edit').val() || 'New name');
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
    titleEdit: function (e) {
        if (e.keyCode == 13) {
            e.stopPropagation();
            this.save();
            return false;
        }
    },
    expandCategoryClick: function(e){
        e.stopPropagation();
        e.preventDefault();
        this.expandCategory();
    },
    expandCategory: function () {
        this.$('.js-internal-collection').toggleClass('collapsed');
        var collapsed = this.$('.js-internal-collection').hasClass('collapsed');
        if (collapsed) {
            this.$('.js-expand-icon').removeClass('val-icon-arrow-down').addClass('val-icon-arrow-right');
        }
        else {
            this.$('.js-expand-icon').removeClass('val-icon-arrow-right').addClass('val-icon-arrow-down')
        }
        this.model.set('collapsed', collapsed);
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
    className: 'content-editor-sortable lesson-items',
    tagName: 'ul',
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
        this._makeSortable(this.$('.content-editor-sortable, .category>.js-internal-collection'));
    },
    _makeSortable: function (elements) {
        var _this = this;
        elements.each(function (index, element) {
            element = jQueryValamis(element);
            if (element.hasClass('ui-sortable')) {
                element.sortable('refresh');
                return;
            }

            element.sortable({
                placeholder: 'ui-state-highlight',
                connectWith: '.content-editor-sortable, .category > .js-internal-collection',
                distance: 15,
                opacity: 0.8
            }).on('sort', function (event, ui) {
                var parent = jQueryValamis(ui.placeholder).parent().parent();
                if (ui.item.hasClass('category') && parent.hasClass('category')) {
                    ui.placeholder.addClass('ui-wrong-helper');
                } else {
                    ui.placeholder.removeClass('ui-wrong-helper');
                }
            }).on('sortstop', function (event, ui) {
                if (ui.placeholder.hasClass('ui-wrong-helper')) {
                    event.preventDefault();
                }
            }).on('sortupdate', function (event, ui) {
                if (this !== ui.item.parent()[0]) return;
                var parent = jQueryValamis(ui.item).parent().parent();
                var parentID = parent.attr('data-model-id');
                var isParentCollapsed = parent.find('.js-internal-collection').hasClass('collapsed');
                parent.find('.js-expand-icon').removeClass('empty');
                var index = $(ui.item).index() + 1; // indices in sortable are zero-based, need to increment them
                _this.updateCollection(ui.item.attr('data-model-id'), parentID, isParentCollapsed, index);
            });
        });
    },
    updateCollection: function (modelID, parentID, isParentCollapsed, index) {
        contentManagerEvent.trigger('lesson:collection:sorted', modelID, parentID, isParentCollapsed, index);
    }
});

