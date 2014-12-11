var LRS2ActivityMapperApp = new Marionette.Application();

LRS2ActivityMapperApp.addInitializer(function(options){
  var controls = new LRS2ActivityMapperApp.ViewModule.ControlsView({
    el: jQuery('.lrs2activity-controls'),
    language: options.language
  });
  controls.render();

  var collectionView = new LRS2ActivityMapperApp.ViewModule.ActivityMapperRowCollectionView({
    collection: LRS2ActivityMapperApp.request('event:list'), el: jQuery('.social-activities-mapper-data')
  });
  collectionView.render();
});