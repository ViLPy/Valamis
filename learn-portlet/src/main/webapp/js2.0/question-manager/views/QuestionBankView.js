var QuestionBankView = Backbone.View.extend({
  events: {
    'click .menu-toggle': 'menuToggle',
    'click #questionbankAddCategory': 'addCategory',
    'click #questionbankEditCategory': 'editCategory',
    'click #questionbankAddQuestions': 'addQuestion',
    'click #questionbankEditQuestions': 'editQuestion'
  },

  initialize: function (options) {
    this.language = options.language;
    var template = Mustache.to_html(jQuery('#questionBankTemplate').html(), this.language);
    this.$el.html(template);
    this.selectNodeOnCreation = false;

    this.questionbankCollectionView = new BankTreeView({
      el: this.$('#SCORMQuestionBankTree'),
      language: this.language
    });

    this.entityView = new EntityView({
      el: this.$('#ItemView'),
      language: this.language
    });
    this.entityView.on('editEntityRow', this.triggerPopup, this);
    this.entityView.on('removeEntityRow', this.removeElement, this);
    this.questionbankCollectionView.on('selectNode', this.renderEntityList, this);

  },

  renderEntityList: function (param) {
    if (param.questionModel) {
      this.$('#questionbankAddCategory').hide();
      this.$('#questionbankEditCategory').hide();
      this.$('#questionbankAddQuestions').show();
      this.$('#questionbankEditQuestions').show();
      this.entityView.render(param.model, param.categoryChild, param.categoryTitle);
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
      this.entityView.renderEntityList(param.catItems, param.qItems, (param.parent == -1), param.title);
    }
  },

  menuToggle: function (e) {
    e.preventDefault();
    this.$("#bankContentWrapper").toggleClass("active");
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


   removeElement:function (item) {
    this.questionbankCollectionView.drop(item);
   }
});