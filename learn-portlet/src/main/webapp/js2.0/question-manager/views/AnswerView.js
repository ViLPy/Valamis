var AnswerViewFactory = function (answerModel, language) {
  // info: Categorization answer view separated because of complexity
  if (answerModel instanceof ChoiceAnswer) {
    return new ChoiceAnswerView({
      model: answerModel,
      language: language
    });
  } else if (answerModel instanceof ShortAnswer) {
    return new ShortAnswerView({
      model: answerModel,
      language: language
    });
  } else if (answerModel instanceof NumericAnswer) {
    return new NumericAnswerView({
      model: answerModel,
      language: language
    });
  } else if (answerModel instanceof PositioningAnswer) {
    return new PositioningAnswerView({
      model: answerModel,
      language: language
    });
  } else if (answerModel instanceof MatchingAnswer) {
    return new MatchingAnswerView({
      model: answerModel,
      language: language
    });
  } else {
    return new AnswerView({
      model: answerModel,
      language: language
    });
  }
};
// implement base model
var AnswerView = Backbone.View.extend({
  events: {
    'click #SCORMAnswerRemove': 'destroy'
  },
  initialize: function (options) {
    this.language = options.language;
    this.position = options.position;
    this.$el = jQuery('<tr>');
    this.$el.attr('id', this.cid);
  },
  renderEditor: function () {

  },
  destroy: function () {
    this.model.destroy();
    this.remove();
    this.trigger('destroy', this);
  },

  updatePosition: function (position) {
    this.position = position;
    this.render();
  },

  setRenderType: function (renderType) {
    this.renderType = renderType;
  },

  render: function () {
    this.$el.html(this.language['defaultModelViewLabel']);
    return this;
  },

  updateModel: function () {
    return this.model;
  }
});

// Views
var ChoiceAnswerView = AnswerView.extend({
  events: {
    'click #SCORMAnswerRemove': 'destroy',
    'click #SCORMAnswerIsCorrect': 'changeIsCorrect'
  },
  initialize: function (options) {
    this.$el = jQuery('<tr>');
    this.$el.attr('id', this.cid);
    this.language = options.language;
    this.position = options.position;
  },
  render: function () {
    var templateName = (this.renderType == 'edit') ? '#choiceAnswerEditView' : '#choiceAnswerView';
    var template = Mustache.to_html(jQuery(templateName).html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      position: this.position,
      answerText: decodeURIComponent(this.model.get('answerText'))
    }, this.language)));
    this.$el.html(template);

    if (this.model.get('isCorrect'))
      this.$('#SCORMAnswerIsCorrect').addClass('checked');

    return this;
  },
  renderEditor: function () {
    if (this.renderType == 'edit') {
      this.editor = CKEDITOR.replace('SCORMAnswerText_' + this.position, { toolbarLocation: 'bottom', height: 100 });
      this.editor.on('change', jQuery.proxy(function () {
        this.updateModel();
      }, this));
    }
  },
  updateModel: function () {
    this.model.set({
      answerText: encodeURIComponent(this.editor.getData()),
      isCorrect: this.$('#SCORMAnswerIsCorrect').hasClass('checked')
    });
    return this.model;
  },
  changeIsCorrect: function () {
    if (this.renderType == 'edit')
      this.$('#SCORMAnswerIsCorrect').toggleClass('checked');
  }
});

var ShortAnswerView = AnswerView.extend({
  events: {
    'change #SCORMAnswerText': 'updateModel',
    'click #SCORMAnswerRemove': 'destroy'
  },
  initialize: function (options) {
    this.$el = jQuery1816Bank('<tr>');
    this.$el.attr('id', this.cid);
    this.position = options.position;
  },
  render: function () {
    var templateName = (this.renderType == 'edit') ? '#shortAnswerEditView' : '#shortAnswerView';
    var template = Mustache.to_html(jQuery(templateName).html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      position: this.position,
      answerText: decodeURIComponent(this.model.get('answerText'))
    }, this.language)));
    this.$el.html(template);

    return this;
  },
  updateModel: function () {
    this.model.set({
      answerText: encodeURIComponent(this.$('#SCORMAnswerText').val())
    });
    return this.model;
  }
});

var NumericAnswerView = AnswerView.extend({
  events: {
    'change #SCORMAnswerRangeFrom': 'updateModel',
    'change #SCORMAnswerRangeTo': 'updateModel',
    'click #SCORMAnswerRemove': 'destroy'
  },
  initialize: function (options) {
    this.$el = jQuery1816Bank('<tr>');
    this.$el.attr('id', this.cid);
    this.language = options.language;
    this.position = options.position;
  },
  render: function () {
    var templateName = (this.renderType == 'edit') ? '#numericAnswerEditView' : '#numericAnswerView';
    var template = Mustache.to_html(jQuery(templateName).html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      position: this.position
    }, this.language)));
    this.$el.html(template);

    return this;
  },

  updateModel: function () {
    this.model.set({
      rangeFrom: parseFloat(this.$('#SCORMAnswerRangeFrom').val()),
      rangeTo: parseFloat(this.$('#SCORMAnswerRangeTo').val())
    });
    return this.model;
  }
});

var PositioningAnswerView = AnswerView.extend({
  events: {
    'click #SCORMAnswerRemove': 'destroy'
  },
  initialize: function (options) {
    this.$el = jQuery1816Bank('<tr>');
    this.$el.attr('id', this.cid);
    this.language = options.language;
    this.position = options.position;
  },
  render: function () {
    var templateName = (this.renderType == 'edit') ? '#positioningAnswerEditView' : '#positioningAnswerView';
    var template = Mustache.to_html(jQuery(templateName).html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      position: this.position,
      answerText: decodeURIComponent(this.model.get('answerText'))
    }, this.language)));
    this.$el.html(template);

    return this;
  },
  renderEditor: function () {
    if (this.renderType == 'edit') {
      this.editor = CKEDITOR.replace('SCORMAnswerText_' + this.position, { toolbarLocation: 'bottom', height: 100 });
      this.editor.on('change', jQuery.proxy(function () {
        this.updateModel();
      }, this));
    }
  },
  updateModel: function () {
    this.model.set({
      answerText: encodeURIComponent(this.editor.getData())
    });
    return this.model;
  }
});

var MatchingAnswerView = AnswerView.extend({
  events: {
    'change #SCORMAnswerMatchingText': 'updateModel',
    'click #SCORMAnswerRemove': 'destroy'
  },
  initialize: function (options) {
    this.$el = jQuery1816Bank('<tr>');
    this.$el.attr('id', this.cid);
    this.language = options.language;
    this.position = options.position;
  },
  render: function () {
    var templateName = (this.renderType == 'edit') ? '#matchingAnswerEditView' : '#matchingAnswerView';
    var template = Mustache.to_html(jQuery(templateName).html(), _.extend(this.model.toJSON(), _.extend({
      cid: this.cid,
      position: this.position,
      answerText: decodeURIComponent(this.model.get('answerText')),
      matchingText: decodeURIComponent(this.model.get('matchingText'))
    }, this.language)));
    this.$el.html(template);

    return this;
  },
  renderEditor: function () {
    if (this.renderType == 'edit') {
      this.editor = CKEDITOR.replace('SCORMAnswerText_' + this.position, { height: 100 });
      this.editor.on('change', jQuery.proxy(function () {
        this.updateModel();
      }, this));
    }
  },
  updateModel: function () {
    this.model.set({
      answerText: encodeURIComponent(this.editor.getData()),
      matchingText: encodeURIComponent(this.$('#SCORMAnswerMatchingText').val())
    });
    return this.model;
  }
});