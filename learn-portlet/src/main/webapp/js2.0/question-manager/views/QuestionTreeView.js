const MAX_TITLE_LENGTH = 25;

var BankTreeView = Backbone.View.extend({
    events: {
        'click #qbRoot > .js-tree-item': 'selectParentNode',
        'dblclick #qbRoot > .js-tree-item': 'toggleRoot',
        'click #qbRoot > .js-tree-item > .js-tree-item-icon': 'toggleRoot',
        'expanded': 'expandCategory',
        'change input[type="checkbox"]': 'checkElement'
    },
    initialize: function (options) {
        options || (options = {});
      this.isSortable = options.isSortable;
      this.multiselectEnabled = options.multiselectEnabled || false;
      this.courseId = options.courseId;
      this.baseTitle = options.baseTitle;
      this.currentCourse = options.currentCourse;

      var Categories = Backbone.Collection.extend({
        model: CategoryModel
      });

      var Questions = Backbone.Collection.extend({
        model: QuestionModel
      });

      this.categories = new Categories();
      this.questions = new Questions();
      this.nodes = {};

      this.categories.on('add', jQueryValamis.proxy(function () {
        this.updateChildrenCount('add');
      }, this), this);
      this.questions.on('add', jQueryValamis.proxy(function () {
        this.updateChildrenCount('add');
      }, this), this);
      this.categories.on('remove', jQueryValamis.proxy(function () {
        this.updateChildrenCount('remove');
      }, this), this);
      this.questions.on('remove', jQueryValamis.proxy(function () {
        this.updateChildrenCount('remove');
      }, this), this);
      this.questions.on('sync', jQueryValamis.proxy(function () {
        this.updateChildrenCount('add');
      }, this), this);
    },

    render: function() {

        var mustacheAccum = {
            childrenAmount: this.questions.length,
            courseId: this.courseId,
            baseTitle: this.baseTitle
        };

        var template = Mustache.to_html(jQueryValamis('#bankTreeTemplate').html(), mustacheAccum);
      this.$el.html(template);

      this.fetchForParent(-1, jQueryValamis.proxy(function () {
        if(this.currentCourse) this.selectParentNode();
      }, this));

      if (this.isSortable) {
        this.sortable();
        this.$('.val-tree').addClass('sortable-tree');
      }

      this.updateChildrenCount('add');

      return this;
    },

    getQuestionAmount: function(){
        var amount = 0 ;

        this.questions.forEach(function(question) {
            if(question.get('categoryId') == -1 ) amount ++;
        });

        this.categories.forEach(function(category) {
            amount  += category.get('childrenAmount') || 0;
        });
        return amount;
    },
    getChildrenAmount: function(){
        return (this.questions.length || 0 ) + (this.categories.length || 0 );
    },
    updateChildrenCount: function (action) {

        var questionAmount = this.getQuestionAmount();

        this.$('#qbRoot > .js-tree-item > .js-tree-item-title').attr('data-count', questionAmount);

        if(questionAmount == 0) {
            this.$('#qbRoot > .js-tree-item > .js-tree-item-title').not('.tree-root-item').removeAttr('data-count');
        }
        else {
            this.$('#qbRoot > .js-tree-item > .js-tree-item-title').attr('content', 'attr(data-count)');
        }


        var childrenAmount = this.getChildrenAmount();
        var rootIcon = this.$('#qbRoot > .js-tree-item > .js-tree-item-icon');
        var root = this.$('#qbRoot');
        if(childrenAmount == 0){
            if(root.hasClass('expanded')) {
                root.toggleClass('expanded');
                root.toggleClass('collapsed');
            }
            rootIcon.removeClass('val-icon-arrow-right');
            rootIcon.removeClass('val-icon-arrow-down');
        }else{
            if(root.hasClass('collapsed')) {
                if(action === 'add') {
                    root.toggleClass('expanded');
                    root.toggleClass('collapsed');
                }
            }
            rootIcon.removeClass('val-icon-arrow-right');
            rootIcon.addClass('val-icon-arrow-down');
        }
    },

    toggleRoot: function () {
        if (window.getSelection)
            window.getSelection().removeAllRanges();
        else if (document.selection)
            document.selection.empty();

        var childrenAmount = this.getChildrenAmount();
        if(childrenAmount > 0) {
            this.$('#qbRoot').toggleClass('expanded').toggleClass('collapsed');
            this.$('#qbRoot > .js-tree-item > .js-tree-item-icon').toggleClass('val-icon-arrow-right').toggleClass('val-icon-arrow-down');
        }
    },

    sortable: function() {
        var self = this;
        this.$('ul[id^="questionBankGrid_"]').nestedSortable({
            handle: '.js-tree-item',
            items: 'li',
            toleranceElement: '> span',
            listType: 'ul',
            tabSize: 5,
            maxLevels: 2,
            isTree: true,
            doNotClear: true,
            expandedClass: 'expanded',
            collapsedClass: 'collapsed',
            expandOnHover: 1,
            disableNestingClass: 'questionRow',
            connectWith: '.ui-sortable',
            relocate: function(e, ui) {
                var id = jQueryValamis(ui.item).attr('id');
                var index = jQueryValamis(ui.item).attr('id').substr(0, 1) === 'q' ?
                            jQueryValamis(ui.item).prevAll('.questionRow').length :
                            jQueryValamis(ui.item).prevAll('.categoryRow').length + 1;
                var parentID = jQueryValamis(ui.item).parents('li').first().attr('id').replace('c', '');
                parentID = parentID !== 'qbRoot' ? parentID : -1;
                self.updateQuestionsSorting(id, index, parentID);
            },
            isAllowed: function (next,parent,current) {
                if(jQueryValamis(current).hasClass('questionRow') && !jQueryValamis(next).nextAll('.categoryRow').length > 0)
                    return true;
                if(jQueryValamis(current).hasClass('categoryRow') && !jQueryValamis(next).parents('li').hasClass('categoryRow'))
                    return true;
            }
        });

    },

    updateQuestionsSorting: function (modelID,  index, parentID) {
        var model = modelID.substr(0, 1) == 'q' ? this.questions.get(modelID.replace('q', '')) : this.categories.get(modelID.replace('c', ''));
        var self = this;
        model.move({}, {parentID: parentID, index: index}).then(function(){
            model.fetch({id: model.id, reset:true});
            self.fetchForParent(-1, function(){
                self.categories.forEach(function(category){
                    var entity = self.getEntity();
                    if(entity == null)
                        self.selectParentNode();
                    else if (entity.get('contentType') === "category")
                        self.selectCategoryNode(entity.get('id'));
                    else self.selectQuestionNode(self.getEntity().get('id'));
                    self.categoryChildUpdated(category.get('id'));
                })
            });

        });
    },

    clearSelection: function () {
        jQueryValamis('.selected-entity').removeClass('selected-entity');
    },
    selectNode: function (node) {
        this.clearSelection();
        this.$('#' + node).addClass('selected-entity');
      //TODO fix that, I think here we should use another place to store current courseID
      // potentially if page will contain several valamis portlet this value will replaced
      // to wrong value for another valamis-portlet.
      // Also should be changed in models service side
        jQueryValamis('#courseId').val(this.courseId);
    },
    selectParentNode: function () {
        this.selectNode('qbRoot');
        var questions = this.questions.where({ categoryID: -1 });
        var cats = this.categories;
        var qCollection = new Backbone.Collection();
        qCollection.reset(questions);
        this.trigger('selectNode', {parent: -1, catItems: cats, qItems: qCollection});
    },
    selectCategoryNode: function (selectedCategory) {
        this.expandCategoryNode(selectedCategory);
        this.selectNode('c' + selectedCategory);
    },
    expandCategory: function(e, id){
        this.expandCategoryNode(id.replace('c',''));
    },
    expandCategoryNode: function (selectedCategory)
    {
        this.fetchForParent(selectedCategory);
    },
    selectQuestionNode: function (selectedQuestion)
    {
        var question = this.questions.get(selectedQuestion);
        var catId = question.get('categoryId');
        var isChild = (catId != -1);
        var title = '';
        if (isChild)  title = this.categories.get(catId).get('title');
        this.trigger('selectNode', {
            questionModel: true,
            model: question,
            categoryChild: isChild,
            categoryTitle: title
        });
        this.selectNode('q' + selectedQuestion);
    },

    // -categories
    addCategories: function (questions) {
        _.each(questions, this.addCategory, this);
    },
    addNewCategoryAndSelect: function (entity) {
        var newCat = new CategoryModel(entity);
        newCat.set({selectOnRender: true});
        this.categories.add(newCat);
        this.selectCategoryNode(newCat.id);
        this.renderNewCategory(newCat);
        return this.getEntity();
    },
    addCategory: function (entity) {
        if (this.categories.get(entity.id)){
            var category = this.categories.get(entity.id); // already fetched
            category.set(entity);
        }
        else{
            var category = new CategoryModel(entity);
            this.categories.add(category);
            this.renderNewCategory(category);
        }

    },
    renderNewCategory: function (category) {
        var view = new CategoryRowView({model: category, multiselectEnabled: this.multiselectEnabled});
        view.on('selectCategoryNode', this.selectCategoryNode, this);

        var selector = '#questionBankGrid_' + this.courseId + ' #c' + category.get('parentId') + ' > .tree-items'; //append it to category
        if (category.get('parentId') == -1)
            selector = '#questionBankGrid_' + this.courseId; //If parent is root, append it to root

        this.$(selector).append(view.render().$el);

        view.updateView();
    },

    // -questions
    addNewQuestionAndSelect: function (entity) {
        var newQuestion = new QuestionModel(entity);
        this.questions.add(newQuestion);
        this.renderNewQuestion(newQuestion);
        if (newQuestion.get('categoryId') == -1) this.selectParentNode();
        else this.selectCategoryNode(newQuestion.get('categoryId'));

        this.categoryChildUpdated(entity.categoryId);

        return this.getEntityById('q' + newQuestion.id);
    },
    categoryIsChecked: function (categoryId) {
        return this.multiselectEnabled && this.$('#c' + categoryId).find('#categoryCheckbox' + categoryId).is(':checked');
    },
    addQuestion: function (entity) {
        var self = this;
    if (self.questions.get(entity.id)) {
        if (!self.multiselectEnabled) return;
        var parentCat = self.categories.get(entity.categoryId);
        var parentSelected = false;
        if (parentCat) {
            parentSelected = self.categoryIsChecked(parentCat.id);
        }

        self.questions.where({categoryId: parentCat.id}).forEach(function (question) {
            if (parentSelected) self.$('#q' + question.id).find('#questionCheckbox' + question.id).attr('checked', 'checked');
            else self.$('#q' + question.id).find('#questionCheckbox' + question.id).removeAttr('checked');
        });

        return;
    } // already fetched
        var question = new QuestionModel(entity);
        self.questions.add(question);
        self.renderNewQuestion(question);
    },
    renderNewQuestion: function (question) {
        var parentCat = this.categories.get(question.get('categoryId'));
        var parentSelected = false;
        if (parentCat) {
            parentSelected = this.categoryIsChecked(parentCat.id);
        }

        question.on('selected', this.selectParentNode, this);

        var view = new QuestionRowView({
            model: question,
            multiselectEnabled: this.multiselectEnabled,
            selected: parentSelected
        });
        view.on('onQuestionRemove', this.categoryChildUpdated, this);
        view.on('selectQuestionNode', this.selectQuestionNode, this);
        var renderedView = view.render().$el;
        var categoryId = question.get('categoryId');
        if (categoryId == -1 || categoryId == null) this.$('#questionBankGrid_' + this.courseId).append(renderedView);
        else {
            this.$('#c' + categoryId + ' > ul').append(renderedView);
        }
        view.enableMove();
    },

    categoryChildUpdated: function (catID) {
        if (catID != -1) {
            var self = this;
            var amount = self.questions.where({categoryId: catID}).length || 0;
            if (amount === 0)
            {
                jQueryValamis('#c' + catID + ' > .js-tree-category > .js-tree-item-title').removeAttr('data-count');
                this.fetchForParent(-1, function ()
                {
                    amount = self.categories.get(catID).get('childrenAmount');
                });
            } else
            {
                jQueryValamis('#c' + catID + ' > .js-tree-item > .js-tree-item-title').attr('data-count', amount);
            }
        }
    },

    addQuestions: function (questions) {
        _.each(questions, this.addQuestion, this);
    },

    getEntity: function () {
        var id = this.$('.selected-entity').attr("id");
        return this.getEntityById(id);
    },

    guestionIsChecked: function(questionId){
        return this.$('#q' + questionId).find('#questionCheckbox' + questionId).is(':checked');
    },
    getEntities: function () {
        var that = this;
        if (that.multiselectEnabled) {
            return that.questions.filter(function (question) {
                return that.guestionIsChecked(question.id);
            }).map(function (question) {
                return {id: question.id, title: question.get('title')};
            });
        }
    },

    getEntityById: function (id) {
        if (id.indexOf('qbRoot') == 0) {
            return null;
        }
        else if (id.indexOf('c') == 0) {
            var cat = this.categories.get(id.replace('c', ''));
            if (cat instanceof CategoryModel) {
                return cat;
            }
        }
        else if (id.indexOf('q') == 0) {
            var q = this.questions.get(id.replace('q', ''));
            if (q instanceof QuestionModel) {
                return q;
            }
        }
        return null;
    },

    //Using new api from content manager
    getNodes: function (id, courseId)
    {
        return window.LearnAjax.get(path.root + path.api.category + id +
            '?action=ALLCHILDREN&courseId=' + courseId);
    },

    fetchAllNodes: function(parentId, callback)
    {
        jQueryValamis.when(this.getNodes(parentId, this.courseId))
            .done(jQueryValamis.proxy(function (childrenArgs) {

                this.nodes = childrenArgs;
                this.fetchChildren(parentId, this.nodes);

                if (callback != undefined) callback();

            }, this));
    },

    fetchForParent: function (id, callback)
    {
        if (id <= 0) //If it is parent node, get elements and fetch root level
        {
            this.fetchAllNodes(id, callback);
            return;
        }

        //if not, just find them from the tree
        var category = this.categories.findWhere({id: id});
        this.fetchChildren(id, category.get('children'));

        if(callback)
            callback();
    },

    fetchChildren: function (parentId, children)
    {
        var questions = [],
            categories = [];
        children.forEach(function (el)
        {
            switch (el.contentType)
            {
                case 'question':
                    el.categoryId = parentId;
                    questions.push(el);
                    break;
                case 'category':
                    el.parentId = parentId;
                    categories.push(el);
                    break;
            }
        });

        this.addCategories(categories);
        this.addQuestions(questions);
    },

    // Delete
    drop: function (id) {

        // remove real model from inner collection and destroy it
        var realModel = this.getEntityByID(id);
        if (realModel instanceof CategoryModel) {
            this.categories.remove(realModel);
        } else if (realModel instanceof QuestionModel) {
            this.questions.remove(realModel);
        }
        realModel.destroy();
        delete realModel;
    },

    checkElement: function (event)
    {
        var id = event.target.id;

        if (!id.startsWith('category'))
            return; //There is no need to change something when question checked

        this.checkChildrenElements(parseInt(id.replace('categoryCheckbox', '')), event.target.checked);
    },

    checkChildrenElements: function (parentId, checked)
    {
        var that = this;
        this.fetchForParent(parentId, jQueryValamis.proxy(function () {
            var subCategories = that.categories.where({parentId: parentId});
            _.each(subCategories, function(el)
            {
                jQueryValamis('#categoryCheckbox' + el.get('id')).prop('checked', checked);
                that.checkChildrenElements(el.get('id'), checked);
            });

            var questions = that.questions.where({categoryId: parentId});
            _.each(questions, function(el)
            {
                jQueryValamis('#questionCheckbox' + el.get('id')).prop('checked', checked);
            });

        }), this);
    }
});

var CategoryRowView = Backbone.View.extend({
    events: {
        'click .js-tree-category': 'selectItem',
        'click .js-tree-category > .js-tree-item-icon': 'toggleCategory',
        'dblclick .js-tree-category': 'toggleCategory'
    },
    initialize: function (options) {
        options || (options = {});
        this.multiselectEnabled = options.multiselectEnabled || false;
        this.$el = jQueryValamis('<li id=c' + this.model.id + '>');
        this.$el.addClass('expand categoryRow collapsed');
        if (this.model.get('selectOnRender')) this.$el.addClass('selected-entity');
        this.model.on('change', this.updateView, this);
        this.model.on('destroy', this.removeView, this);
    },
    updateView: function () {
        this.$('.js-tree-item-title').first().text(this.model.get('title'));
        var icon = this.$('.js-tree-category > .js-tree-item-icon');

        if(this.model.get('childrenAmount') == 0) {
            this.$('.js-tree-category > .js-tree-item-title').first().removeAttr('data-count');
            icon.removeClass('val-icon-arrow-right');
            icon.removeClass('val-icon-arrow-down');
        }
        else {
            this.$('.js-tree-category > .js-tree-item-title').first().attr('data-count', this.model.get('childrenAmount'));
            if(this.$el.hasClass('collapsed')) {
                icon.addClass('val-icon-arrow-right');
            }else{
                icon.addClass('val-icon-arrow-down');
            }
        }
    },
    render: function () {
        var template = Mustache.to_html(jQueryValamis('#categoryTreeRowTemplate').html(),
            _.extend(this.model.toJSON(), { multiselectEnabled: this.multiselectEnabled }));
        this.$el.html(template);
        return this;
    },
    selectItem: function () {
        this.trigger('selectCategoryNode', this.model.id);
        if (!this.multiselectEnabled) this.$el.addClass('selected-entity');
    },
    toggleCategory: function (e) {
        e.stopPropagation();
        if(this.model.get('childrenAmount') == 0) return;

        this.$el.toggleClass('expanded');
        this.$el.toggleClass('collapsed');

        this.$('.js-tree-category > .js-tree-item-icon').toggleClass('val-icon-arrow-right').toggleClass('val-icon-arrow-down');

        if(this.$el.hasClass('expanded')){
            this.trigger('selectCategoryNode', this.model.id);
        }
    },
    removeView: function () {
        jQueryValamis('.child.parent' + this.model.id).remove();
        this.remove();
    }
});

var QuestionRowView = Backbone.View.extend({
    events: {
        'click .js-tree-item': 'selectItem'
    },
    initialize: function (options) {
        options || (options = {});
        this.multiselectEnabled = options.multiselectEnabled || false;
        this.model.on('change', this.updateView, this);
        this.model.on('destroy', function () {
            this.trigger('onQuestionRemove', this.model.get('categoryId'));
            this.remove();
        }, this);
        var selected = '';
        if (options.selected) selected = 'selected-entity';
        this.$el = jQueryValamis('<li id=q' + this.model.id + ' class="questionRow ' + selected + '">');

        if (this.model.get('categoryId') != -1) {
            this.model.set({isChild: true, selected: selected});
        }
    },
    updateView: function () {
        this.$('.js-tree-item-title').text(this.getTitle());
        if (this.$el.hasClass('selected-entity')) this.selectItem();
    },
    getTitle: function () {
        var title = this.model.get('title');
        if (title.length > MAX_TITLE_LENGTH) title = title.substring(0, MAX_TITLE_LENGTH) + '...';
        return title;
    },
    render: function () {
        var template = Mustache.to_html(jQueryValamis('#questionTreeRowTemplate').html(), _.extend(this.model.toJSON(),
            _.extend({fixedTitle: this.getTitle(), multiselectEnabled: this.multiselectEnabled })));
        this.$el.html(template);
        return this;
    },
    enableMove: function () {
    },
    selectItem: function () {
        this.model.trigger('selected');
        this.trigger('selectQuestionNode', this.model.id);
        if (!this.multiselectEnabled) this.$el.addClass('selected-entity');
    }
});