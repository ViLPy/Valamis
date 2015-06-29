achievedCertificates.module('Views', function (Views, achievedCertificates, Backbone, Marionette, $, _) {

  Views.CertificateItemView = Marionette.ItemView.extend({
    template: '#achievedCertificatesItemViewTemplate',
    templateHelpers: function() {
      var endDate = this.options.model.get('endDate');
      var dateString = '';
      if (endDate) {
        dateString = new Date(endDate).toLocaleDateString();
      }
      return {
        dateString: dateString
      }
    },
    tagName: 'div',
    className: 'tile'
  });

  Views.AppLayoutView = Marionette.CompositeView.extend({
    tagName: 'div',
    className: 'val-portlet achieved-certificates',
    template: '#achievedCertificatesLayoutTemplate',
    childViewContainer: '.js-list-view',
    childView: Views.CertificateItemView,
    onRender: function() {
      if(this.collection.length === 0)
        this.$('.js-no-certificates').removeClass('hidden');
    }
  });

});