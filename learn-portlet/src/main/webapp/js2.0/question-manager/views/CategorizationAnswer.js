var CategorizationAnswerView = AnswerView.extend({
  events: {
    'click #SCORMButtonAddOption': 'onAddOption',
    'click #deleteAnswer': 'destroy'
  },

  initialize: function (options) {
    this.optionsList = [];
    this.position = options.position;
    this.language = options.language;
    this.renderType = options.renderType;
    this.$el = jQuery('<tr>');
    this.$el.attr('id', this.cid);

    this.render();
  },

  render: function () {
    var language = this.language;
    var templateName = (this.renderType == 'edit') ? '#categorizationAnswerEditView' : '#categorizationAnswerView'
    var template = Mustache.to_html(jQuery(templateName).html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      position: this.position,
      answerText: decodeURIComponent(this.model.get('answerText'))
    }, language)));
    this.$el.html(template);

    for (key in this.optionsList) {
      this.$('#SCORMAnswerOptions').append(this.optionsList[key].render(this.renderType));
    }

    return this;
  },
  renderEditor: function () {
    if (this.renderType == 'edit') {
      this.editor = CKEDITOR.replace('SCORMAnswerText_' + this.position, { toolbarLocation: 'bottom', height: 100 });
      this.editor.on('change', jQuery.proxy(function () {
        this.updateModel();
      }, this));
    }

    for (key in this.optionsList) {
      this.optionsList[key].renderEditor();
    }
  },

  expandToAnswers: function () {
    this.updateModel();
    var answerModels = [];
    var categoryName = this.model.get('answerText');

    var categorizationModel;

    if (this.optionsList.length == 0) {
      if (categoryName.length > 0) {
        categorizationModel = new CategorizationAnswer({
          answerText: categoryName,
          matchingText: ''
        });
        answerModels.push(categorizationModel.toJSON());
      }
    } else {
      if (categoryName.length > 0) {
        for (key in this.optionsList) {
          categorizationModel = new CategorizationAnswer({
            answerText: categoryName,
            matchingText: this.optionsList[key].getOptionText()
          });
          answerModels.push(categorizationModel.toJSON())
        }
      }
    }

    return answerModels;
  },

  updateModel: function () {
    this.model.set({
      answerText: encodeURIComponent(this.editor.getData())
    });
  },

  addOption: function (option) {
    var view = new CategorizationOptionView({
      optionText: option,
      language: this.language,
      renderType: this.renderType
    });
    this.optionsList.push(view);
    this.$('#SCORMAnswerOptions').append(view.render().$el);
    view.renderEditor();
    view.on('destroy', this.removeOption, this);
  },

  removeOption: function (option) {
    this.optionsList = _.filter(this.optionsList, function (e) {
      return e.cid != option.cid
    }, this);
  },

  onAddOption: function () {
    this.addOption('');
  }
});

var CategorizationOptionView = Backbone.View.extend({
  events: {
    'click #SCORMButtonRemoveOption': 'destroy'
  },

  initialize: function (options) {
    this.$el = jQuery('<tr>');
    this.optionText = options.optionText;
    this.language = options.language;
    this.renderType = options.renderType;
  },

  destroy: function () {
    this.trigger('destroy', this);
    this.remove();
  },

  render: function () {
    var templateName = (this.renderType == 'edit') ? '#categorizationOptionEdit' : '#categorizationOption';
    var template = Mustache.to_html(jQuery(templateName).html(), _.extend({
      text: decodeURIComponent(this.optionText),
      cid: this.cid
    }, this.language));
    this.$el.empty().append(template);
    return this;
  },
  renderEditor: function () {
    if (this.renderType == 'edit') {
      if (jQuery1816Bank('#SCORMAnswerOptionText_' + this.cid).length > 0) {
        this.editor = CKEDITOR.replace('SCORMAnswerOptionText_' + this.cid, { toolbarLocation: 'bottom', height: 80 });
        this.editor.on('change', jQuery.proxy(function () {
          this.updateText();
        }, this));
      }
    }
  },
  getOptionText: function () {
    this.optionText = encodeURIComponent(this.editor.getData());
    return this.optionText;
  },

  updateText: function () {
    this.optionText = encodeURIComponent(this.editor.getData());
  }

});