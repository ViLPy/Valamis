ActivityMapperApp.module("Entities", function(Entities, ActivityMapperApp, Backbone, Marionette, $, _){
  Entities.ActivityMapperModel = Backbone.Model.extend({
    defaults: {
      activityID: 'unknown activity',
      mappedVerb: null
    },
    persist: function(siteID) {
      var url = path.root + path.api.settingsApi + siteID;
      $.post(url, {
        keyID: this.get('activityID'),
        value: this.get('mappedVerb')
      });
    }
  });

  Entities.ActivityMapperModelCollection = Backbone.Collection.extend({
    model: Entities.ActivityMapperModel
  });

  var collection = new Entities.ActivityMapperModelCollection();

  ActivityMapperApp.reqres.setHandler('setting:list', function () {
    return collection;
  });

  ActivityMapperApp.reqres.setHandler('setting:get', function (id) {
    return collection.get(id);
  });
});