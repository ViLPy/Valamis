var SaveConfirmationView = Backbone.View.extend({
  events: {
    'click .confirmation': 'confirmSave',
    'click .decline': 'declineSave'
  },
  initialize: function (options) {
    this.language = options.language;
  },
  render: function () {
    var template = Mustache.to_html(jQueryValamis('#saveConfirmationTemplate').html(), this.language);
    this.$el.html(template);
    return this;
  },
  confirmSave: function () {
    this.trigger('saveConfirmed', this);
  },
  declineSave: function () {
    this.trigger('saveDeclined', this);
  }
});

var IframeErrorView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
    },
    render: function () {
        var template = Mustache.to_html(jQueryValamis('#iframeErrorTemplate').html(), this.language);
        this.$el.html(template);
        return this;
    }
});