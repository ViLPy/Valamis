var UserAccountView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
    this.render();
  },

  events: {
    'click .js-open-goals': 'openGoals'
  },

  addOne: function (element) {
    var template = Mustache.to_html(jQuery('#userCertificateTileItemView').html(), _.extend({
      decodedDescription: element.description
    }, element, this.language));

    this.$('.js-certificates-list').append(template);
  },

  openGoals: function (e) {
    this.trigger('viewCertificateGoals', {id: jQuery(e.currentTarget).data('certificate')});
  },

  render: function () {
    var template = Mustache.to_html(jQuery('#liferayAccountInfoView').html(), _.extend({},
      this.model.toJSON(),
      this.language
    ));
    this.$el.append(template);

    if (this.model.get('certificates') != null &&
      this.model.get('certificates') != undefined)
    {
      for (var i = 0; i < this.model.get('certificates').length; i++)
      {
        var model = this.model.get('certificates')[i];
        /*Some certificate images are not on local server
         * We need to check this.
         */
        model.isLocal = !(model.id == -1);
        this.addOne(model);
      }
    }
    return this;
  }
});


