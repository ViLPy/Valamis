UserAccountView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
    this.render();
  },

  addOne: function (element) {
    var logo = '../../learn-portlet/img/certificate-default.png';
    if (element.id == -1) logo = element.logo;
    else if (element.logo != '') logo = Utils.getContextPath() + 'api/files/images?folderId='+ element.id +'&file=' + element.logo;

    var template = Mustache.to_html(jQuery("#userCertificateItemView").html(), _.extend(element, _.extend({
      description: decodeURIComponent(element.description),
      logo: logo
    }, this.language)));

    var id = "#userCertificatesList";
    this.$(id).append(template);

  },


  render: function () {
    var template = Mustache.to_html(jQuery("#liferayAccountInfoView").html(), _.extend(this.model.toJSON(), _.extend({
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
