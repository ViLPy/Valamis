var AchievedCertificates = Marionette.Application.extend({
  channelName:'achievedCertificates',
  initialize: function() {
    this.addRegions({
      mainRegion: '#achievedCertificatesAppRegion'
    });
  },
  start: function(options){
    this.certificates = new achievedCertificates.Entities.CertificateCollection();
    this.certificates.on('sync', this.showContent, this);
    this.certificates.fetch();
  },
  showContent: function() {
    var layoutView = new achievedCertificates.Views.AppLayoutView({collection: this.certificates});
    this.mainRegion.show(layoutView);
  }
});

var achievedCertificates = new AchievedCertificates();
