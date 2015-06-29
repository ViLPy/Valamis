var LearningPaths = Marionette.Application.extend({
  channelName:'learningPaths',
  initialize: function() {
    this.addRegions({
      mainRegion: '#learningPathsAppRegion'
    });
  },
  start: function(){
    this.certificates = new learningPaths.Entities.CertificateCollection();
    this.certificates.on('sync', this.showContent, this);
    this.certificates.fetch();
  },
  showContent: function() {
    var layoutView = new learningPaths.Views.AppLayoutView({collection: this.certificates});
    this.mainRegion.show(layoutView);
  }
});

var learningPaths = new LearningPaths();
