var DeleteConfirmationView = Backbone.View.extend({
  events: {
    'click .confirmation': 'confirmDelete'
  },
  initialize: function (options) {
    this.language = options.language;
    this.template = options.template || '#deleteConfirmationTemplate';
  },
  render: function () {
    var template = Mustache.to_html(jQuery(this.template).html(), this.language);
    this.$el.html(template);
    return this;
  },
  confirmDelete: function () {
    this.trigger('deleteConfirmed', this);
  }
});
