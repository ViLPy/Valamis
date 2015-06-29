var RecentLessons = Marionette.Application.extend({
  channelName:'recentLessons',
  initialize: function() {
    this.addRegions({
      mainRegion: '#recentLessonsAppRegion'
    });
  },
  start: function(options){
      this.recent = new recentLessons.Entities.RecentCollection();
      this.recent.on('sync', this.showContent, this);
      this.recent.fetch({userId: Valamis.currentUserId});
  },
  showContent: function() {
    this.recent.each(function (model) {
            if (model.get('throughDate') != '' && model.get('throughDate') != 0)
                model.set('throughDate', moment(model.get('throughDate')).max().fromNow());

        });

    var layoutView = new recentLessons.Views.AppLayoutView({collection: this.recent});
    this.mainRegion.show(layoutView);
  }
});

var recentLessons = new RecentLessons();
