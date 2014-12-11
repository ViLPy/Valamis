var QuestionBankView = Backbone.View.extend({
  events: {
    'click .menu-toggle': 'menuToggle',
    'click #showGlobalBase': 'globalBaseCheckboxToggle',
    'click #questionbankAddCategory': 'addCategory',
    'click #questionbankEditCategory': 'editCategory',
    'click #questionbankAddQuestions': 'addQuestion',
    'click #questionbankEditQuestions': 'editQuestion'
  },

  initialize: function (options) {
    this.language = options.language;
    this.openedCourseId = jQuery('#openedCourseID').val();
    this.selectNodeOnCreation = false;
    this.render();
  },

  render: function(){
    this.trees = [];
    this.courses = undefined;
    var template = Mustache.to_html(jQuery('#questionBankTemplate').html(), this.language);
    this.$el.html(template);

    var view = new BankTreeView({
      language: this.language,
      courseId: this.openedCourseId,
      baseTitle: this.language['treeRootElement'],
      currentCourse: true
    });

    this.trees[this.openedCourseId] = view;
    view.on('selectNode', this.renderEntityList, this);
    this.$('#SCORMQuestionBankTree').append(view.render().$el);
    this.questionbankCollectionView = view;

    this.entityView = new EntityView({
      el: this.$('#ItemView'),
      language: this.language
    });
    this.entityView.on('editEntityRow', this.triggerPopup, this);
    this.entityView.on('moveEntityToSite', this.triggerMoveToPopup, this);
    this.entityView.on('removeEntityRow', this.removeElement, this);
  },

  renderEntityList: function (param) {
    this.questionbankCollectionView = this.trees[jQuery('#courseID').val()];

    if (param.questionModel) {
      this.$('#questionbankAddCategory').hide();
      this.$('#questionbankEditCategory').hide();
      this.$('#questionbankAddQuestions').show();
      this.$('#questionbankEditQuestions').show();
      this.entityView.render(param.model, param.categoryChild, param.categoryTitle, this.questionbankCollectionView.baseTitle);
    }
    else {
      this.$('#questionbankAddQuestions').show();
      this.$('#questionbankEditQuestions').hide();

      if (param.parent == -1) {
        this.$('#questionbankAddCategory').show();
        this.$('#questionbankEditCategory').hide();
      }
      else {
        this.$('#questionbankAddCategory').hide();
        this.$('#questionbankEditCategory').show();
      }
      this.entityView.renderEntityList(param.catItems, param.qItems, (param.parent == -1), param.title, this.questionbankCollectionView.baseTitle);
    }
  },

  menuToggle: function (e) {
    e.preventDefault();
    this.$("#bankContentWrapper").toggleClass("active");
  },

  globalBaseCheckboxToggle: function() {
    this.$('#showGlobalBase').toggleClass('checked');
    this.trees[this.openedCourseId].selectParentNode();
    this.toggleGlobalBase();
  },

  toggleGlobalBase: function () {
    if (this.courses != undefined)
      jQuery('#GLOBALQuestionBankTree').toggleClass('hidden');
    else {
      this.courses = new LiferaySiteCollection();
      this.courses.on('reset', this.renderGlobalBase, this);
      this.courses.fetch({reset: true, currentPage: 1, itemsOnPage: 0});
    }
  },

  renderGlobalBase: function() {
    this.courses.each(this.addCourse, this);
  },

  addCourse: function(course) {
    var cid = course.get('id');
    if (cid != this.openedCourseId) {
      var view = new BankTreeView({
        courseId: cid,
        baseTitle: course.get('title')
      });
      this.trees[cid] = view;
      view.on('selectNode', this.renderEntityList, this);
      this.$('#GLOBALQuestionBankTree').append(view.render().$el);
    }
    else {
      jQuery('#SCORMQuestionBankTree').find('.qbRootItem.qbItemTitle').text(course.get('title'));
      this.trees[this.openedCourseId].baseTitle = course.get('title');
      this.trees[this.openedCourseId].selectParentNode();
    }
  },

  resolveCurrentParentID: function () {
    var model = this.questionbankCollectionView.getEntity();

    var parentID = -1;
    if (model && model instanceof CategoryModel) {
      parentID = model.id;
    } else if (model && model instanceof QuestionModel) {
      parentID = model.get('categoryID');
    }
    return parentID;
  },

  addCategory: function () {

    this.selectNodeOnCreation = true;
    var newCategory = new CategoryModel({
      parentID: -1
    });

    newCategory.save({}, {
      success: jQuery1816Bank.proxy(function (category) {
        var newCat = this.questionbankCollectionView.addNewCategoryAndSelect(category.toJSON());
        this.triggerCategoryPopup(newCat);
        toastr.success(this.language['overlayCompleteMessageLabel']);
      }, this),
      error: jQuery1816Bank.proxy(function () {
        toastr.error(this.language['overlayFailedMessageLabel']);
      }, this)
    });
  },

  editCategory: function () {
    var category = this.questionbankCollectionView.getEntity();
    this.triggerCategoryPopup(category);
  },
  editQuestion: function () {
    var question = this.questionbankCollectionView.getEntity();
    this.triggerQuestionPopup(question);
  },

  addQuestion: function () {

    this.selectNodeOnCreation = true;
    var newQuestion = new QuestionModel({
      categoryID: this.resolveCurrentParentID()
    });

    newQuestion.save({}, {
      success: jQuery1816Bank.proxy(function (question) {
        var newQuestion = this.questionbankCollectionView.addNewQuestionAndSelect(question.toJSON());
        this.triggerQuestionPopup(newQuestion);
        toastr.success(this.language['overlayCompleteMessageLabel']);
      }, this),
      error: jQuery1816Bank.proxy(function () {
        toastr.error(this.language['overlayFailedMessageLabel']);
      }, this)
    });

  },

  triggerPopup: function (item) {
    if (item instanceof CategoryModel)
      this.triggerCategoryPopup(item);
    else this.triggerQuestionPopup(item);
  },
  triggerQuestionPopup: function (question) {
    this.trigger('questionPopup', question);
  },
  triggerCategoryPopup: function (category) {
    this.trigger('categoryPopup', category);
  },

  triggerMoveToPopup: function(item) {
    this.trigger('moveToPopup', item);
  },

  removeElement:function (item) {
    this.questionbankCollectionView.drop(item);
  }
});