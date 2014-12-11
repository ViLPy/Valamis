var BankTreeView = Backbone.View.extend({
    events: {
        'click #qbRootExpand': 'toggleRoot',
        'click #qbRoot > .qbItem': 'selectParentNode',
        'expanded': 'expandCategory'
    },
    initialize: function (options) {
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

      this.categories.on('add', jQuery.proxy(function () {
        this.childCount();
      }, this), this);
      this.questions.on('add', jQuery.proxy(function () {
        this.childCount();
      }, this), this);
      this.categories.on('remove', jQuery.proxy(function () {
        this.childCount();
      }, this), this);
      this.questions.on('remove', jQuery.proxy(function () {
        this.childCount();
      }, this), this);
      this.questions.on('sync', jQuery.proxy(function () {
        this.childCount();
      }, this), this);
    },

    render: function() {
      var template = Mustache.to_html(jQuery('#bankTreeTemplate').html(), _.extend({courseId: this.courseId, baseTitle: this.baseTitle}));
      this.$el.html(template);

      this.fetchForParent(-1, jQuery.proxy(function () {
        if(this.currentCourse) this.selectParentNode();
      }, this));

      this.sortable();

      return this;
    },

    childCount: function () {
        var count = (this.categories.length || 0) + (this.questions.where({categoryID: -1}).length || 0);
        this.$el.find('#qbRoot  > .qbItem > .qbItemTitle').attr('data-count', count);
    },

    toggleRoot: function () {
        this.$('#qbRoot').toggleClass('expanded');
        this.$('#qbRoot').toggleClass('collapsed');
    },

    sortable: function(){
        var self = this;
        this.$('#questionBankGrid_'+this.courseId).nestedSortable({
            handle: '.qbItem',
            items: 'li',
            toleranceElement: '> span',
            listType: 'ul',
            maxLevels: 2,
            isTree: true,
            doNotClear: true,
            expandedClass: 'expanded',
            collapsedClass: 'collapsed',
            expandOnHover: 1,
            disableNestingClass: 'questionRow',
            relocate: function(e, ui){
                var id = jQuery(ui.item).attr('id').replace('q', '');
                var index = jQuery(ui.item).prevAll('.questionRow').length;
                var parentID = jQuery(ui.item).parents('li').first().attr('id').replace('c', '');
                parentID = parentID !== 'qbRoot' ? parentID : -1;
                self.updateQuestionsSorting(id, index, parentID);
            },
            isAllowed: function (next,parent,current){
                return jQuery(current).hasClass('questionRow') && !jQuery(next).nextAll('.categoryRow').length > 0;
            }
        });

    },

    updateQuestionsSorting: function (modelID,  index, parentID) {
        var model = this.questions.get(modelID);
        var self = this;
        model.move({}, {parentID: parentID, index: index}).then(function(){
            model.fetch({id: model.id, reset:true});
            self.fetchForParent(-1, function(){
                self.categories.forEach(function(category){
                    var entity = self.getEntity();
                    if(entity == null)
                        self.selectParentNode();
                    else if (entity.get('type') === "category")
                        self.selectCategoryNode(entity.get('id'));
                    else self.selectQuestionNode(self.getEntity().get('id'));
                    self.categoryChildUpdated(category.get('id'));
                })
            });

        });
    },

    clearSelection: function () {
        jQuery('.selectedEntity').removeClass('selectedEntity');
    },
    selectNode: function (node) {
      this.clearSelection();
      this.$('#' + node).addClass('selectedEntity');
      jQuery('#courseID').val(this.courseId);
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
    expandCategoryNode: function (selectedCategory) {
        this.fetchForParent(selectedCategory, jQuery.proxy(function () {
            var items = this.questions.where({categoryID: selectedCategory });
            var collection = new Backbone.Collection();
            collection.reset(items);
            this.categories.get(selectedCategory).set({childrenAmount: collection.length});
            this.trigger('selectNode', {parent: selectedCategory, qItems: collection, title: this.categories.get(selectedCategory).get('title')});
        }, this));
    },
    selectQuestionNode: function (selectedQuestion) {
        var question = this.questions.get(selectedQuestion);
        var catID = question.get('categoryID');
        var isChild = catID != -1;
        var title = '';
        if (isChild)  title = this.categories.get(catID).get('title');
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
        this.$('#questionBankGrid_'+this.courseId).append(view.render().$el);
    },

    // -questions
    addNewQuestionAndSelect: function (entity) {
        var newQuestion = new QuestionModel(entity);
        this.questions.add(newQuestion);
        this.renderNewQuestion(newQuestion);
        if (newQuestion.get('categoryID') == -1) this.selectParentNode();
        else this.selectCategoryNode(newQuestion.get('categoryID'));

        this.categoryChildUpdated(entity.categoryID);

        return this.getEntityByID('q' + newQuestion.id);
    },
    addQuestion: function (entity) {
        if (this.questions.get(entity.id)) {
            if (!this.multiselectEnabled) return;
            var parentCat = this.categories.get(entity.categoryID);
            var parentSelected = false;
            if (parentCat) parentSelected = this.multiselectEnabled && this.$('#c' + parentCat.id).find('#categorySelection').hasClass('checked');

            this.questions.where({categoryID: parentCat.id}).forEach(function (i) {
                if (parentSelected)
                    jQuery('#q' + i.id).find('#questionSelection').addClass('checked');
                else jQuery('#q' + i.id).find('#questionSelection').removeClass('checked');
            });


            return;
        } // already fetched

        var question = new QuestionModel(entity);
        this.questions.add(question);
        this.renderNewQuestion(question);
    },
    renderNewQuestion: function (question) {
        var parentCat = this.categories.get(question.get('categoryID'));
        var parentSelected = false;
        if (parentCat) parentSelected = this.multiselectEnabled && this.$('#c' + parentCat.id).find('#categorySelection').hasClass('checked');

        var view = new QuestionRowView({
            model: question,
            multiselectEnabled: this.multiselectEnabled,
            selected: parentSelected});
        view.on('onQuestionRemove', this.categoryChildUpdated, this);
        view.on('selectQuestionNode', this.selectQuestionNode, this);
        var renderedView = view.render().$el;
        var categoryID = question.get('categoryID');
        if (categoryID == -1 || categoryID == null) this.$('#questionBankGrid_'+this.courseId).append(renderedView);
        else {
            this.$('#c' + categoryID + ' > ul').append(renderedView);
        }
        view.enableMove();
    },

    categoryChildUpdated: function (catID) {
        if (catID != -1) {
            var self = this;
            var amount = self.questions.where({categoryID: catID}).length || 0;
            if (amount === 0) {
                jQuery('#c' + catID + ' > .qbItem > .qbItemTitle').attr('data-count', amount);
                this.fetchForParent(-1, function(){
                    amount = self.categories.get(catID).get('childrenAmount');
                });
            }else {
                jQuery('#c' + catID + ' > .qbItem > .qbItemTitle').attr('data-count', amount);
            }
        }
    },

    addQuestions: function (questions) {
        _.each(questions, this.addQuestion, this);
    },

    getEntity: function () {
        var id = this.$('.selectedEntity').attr("id");
        return this.getEntityByID(id);
    },

    getEntities: function () {
        if (this.multiselectEnabled) {
            return this.questions.filter(function (i) {
                return jQuery('#q' + i.id).find('#questionSelection').hasClass('checked');
            }).map(function (i) {
                return {id: i.id, title: i.get('title')};
            });
        }
    },

    getEntityByID: function (id) {
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

    //+fetching
    getChildCategories: function (id, courseId) {
        return window.LearnAjax.get(path.root + path.api.category + '?parentId=' + id + '&courseID=' + courseId);
    },

    getChildQuestions: function (id, courseId) {
        return window.LearnAjax.get(path.root + path.api.questions +  id + '?action=getchildren&courseID=' + courseId);
    },

    fetchForParent: function (id, callback) {
        var parentID = -1;
        if (id && id != -1) {
            parentID = id;// this.get(id).get('content').id;
        }

        jQuery.when(this.getChildCategories(parentID, this.courseId), this.getChildQuestions(parentID, this.courseId))
            .done(jQuery.proxy(function (categoriesArgs, questionsArgs) {
                // got AJAX args, data in args[0]

                var categories = categoriesArgs[0];
                var questions = questionsArgs[0];

                this.addCategories(categories);
                this.addQuestions(questions);

                if (callback != undefined) callback();

            }, this));
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
    }
});

var CategoryRowView = Backbone.View.extend({
    events: {
        'click .qbCat': 'selectItem',
        'click .qbCat > .expand-icon': 'toggleCategory',
        'click #categorySelection': 'selectCategory'
    },
    initialize: function (options) {
        this.multiselectEnabled = options.multiselectEnabled || false;
        this.$el = jQuery('<li id=c' + this.model.id + '>');
        this.$el.addClass('expand categoryRow collapsed');
        if (this.model.get('selectOnRender')) this.$el.addClass('selectedEntity');
        this.model.on('change', this.updateView, this);
        this.model.on('destroy', this.removeView, this);
    },
    updateView: function () {
        this.$('.qbItemTitle').first().text(this.model.get('title'));
    },
    render: function () {
        var template = Mustache.to_html(jQuery('#categoryTreeRowTemplate').html(),
            _.extend(this.model.toJSON(), {multiselectEnabled: this.multiselectEnabled}));
        this.$el.html(template);
        return this;
    },
    selectItem: function () {
        this.trigger('selectCategoryNode', this.model.id);
        if (!this.multiselectEnabled) this.$el.addClass('selectedEntity');
    },
    toggleCategory: function () {
        this.$el.toggleClass('expanded');
        this.$el.toggleClass('collapsed');
        if(this.$el.hasClass('expanded')){
            this.trigger('expandCategory', this.$el.attr('id').replace('c',''));
        }
    },
    removeView: function () {
        jQuery('.child.parent' + this.model.id).remove();
        this.remove();
    },
    selectCategory: function () {
        this.$('#categorySelection').toggleClass('checked');
    }
});

var QuestionRowView = Backbone.View.extend({
    events: {
        'click .qbItem': 'selectItem',
        'click #questionSelection': 'selectQuestion'
    },
    initialize: function (options) {
        this.multiselectEnabled = options.multiselectEnabled || false;
        this.model.on('change', this.updateView, this);
        this.model.on('destroy', function () {
            this.trigger('onQuestionRemove', this.model.get('categoryID'));
            this.remove();
        }, this);
        var selected = '';
        if (options.selected) selected = 'selectedEntity';
        this.$el = jQuery('<li id=q' + this.model.id + ' class="questionRow ' + selected + '">');

        if (this.model.get('categoryID') != -1) {
            this.model.set({isChild: true, selected: selected});
        }
    },
    updateView: function () {
        this.$('.qbItemTitle').text(this.getTitle());
        if (this.$el.hasClass('selectedEntity')) this.selectItem();
    },
    getTitle: function () {
        var title = this.model.get('title');
        if (title.length > 15) title = title.substring(0, 15) + '...';
        return title;
    },
    render: function () {
        var template = Mustache.to_html(jQuery('#questionTreeRowTemplate').html(), _.extend(this.model.toJSON(),
            _.extend({fixedTitle: this.getTitle(), multiselectEnabled: this.multiselectEnabled })));
        this.$el.html(template);
        return this;
    },
    enableMove: function () {
    },
    selectItem: function () {
        this.trigger('selectQuestionNode', this.model.id);
        if (!this.multiselectEnabled) this.$el.addClass('selectedEntity');
    },
    selectQuestion: function () {
        this.$('#questionSelection').toggleClass('checked');
    }
});



