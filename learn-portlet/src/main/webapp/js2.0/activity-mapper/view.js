ActivityMapperApp.module("ViewModule", function(ViewModule, ActivityMapperApp, Backbone, Marionette, $, _){
  var language = {};
  var siteID = 0;

  ViewModule.ActivityMapperRowView = Marionette.ItemView.extend({
    tagName: 'tr',
    template: function (data) {
        return Mustache.to_html(jQuery('#activitySocialMapperRow').html(), _.extend(language, {activityName: language[data.activityID]}))
    },
    events: {
      'change .mapped-activity-verb': 'updateEntry'
    },
    updateEntry: function() {
      this.model.set('mappedVerb', this.$('.mapped-activity-verb').val());
      this.model.persist(siteID);
    },
    onRender: function() {
      this.$('.mapped-activity-verb').val(this.model.get('mappedVerb'))
    }
  });

  ViewModule.ActivityMapperRowCollectionView = Marionette.CollectionView.extend({
    tagName: 'tbody',
    itemView: ViewModule.ActivityMapperRowView
  });

  ViewModule.addInitializer(function(options) {
    if (options) {
      language = options.language;
      siteID = options.siteID;
    }
  })
});
