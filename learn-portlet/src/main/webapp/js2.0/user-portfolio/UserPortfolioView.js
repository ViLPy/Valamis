var UserAccountView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
    this.render();
  },

  events: {
    'click .viewCertificateGoalsCommand': 'openGoals'
  },

  addOne: function (element) {
    var logo = '../../learn-portlet/img/certificate-default.jpg';
    if (element.id == -1) logo = element.logo;
    else if (element.logo != '') logo = path.root + path.api.files + 'images?folderId=' + element.id + '&file=' + element.logo;

//    var viewportWidth = jQuery(window).width();
//    if (viewportWidth <= 767) {
//      var template = '#userCertificateListItemView';
//    } else {
//      var template = '#userCertificateTileItemView';
//    }

      var template = '#userCertificateTileItemView';

    var template = Mustache.to_html(jQuery(template).html(), _.extend(element, _.extend({
      description: decodeURIComponent(element.description),
      logo: logo
    }, this.language)));

    var id = '#userCertificatesList';
    this.$(id).append(template);

  },

  openGoals: function (e) {
    this.trigger('viewCertificateGoals', {id: jQuery(e.currentTarget).data('certificate')});
  },

  render: function () {
    var template = Mustache.to_html(jQuery('#liferayAccountInfoView').html(), _.extend(this.model.toJSON(), _.extend({
      description: decodeURIComponent(this.model.get('description'))}, this.language)));
    this.$el.append(template);

    if (this.model.get('certificates') != null &&
      this.model.get('certificates') != undefined) {
      for (var i = 0; i < this.model.get('certificates').length; i++) {
        this.addOne(this.model.get('certificates')[i]);
      }
    }
    return this;
  }
});


