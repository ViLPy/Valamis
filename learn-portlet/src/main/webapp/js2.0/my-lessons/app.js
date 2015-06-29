var MyLessons = Marionette.Application.extend({
  channelName:'myLessons',
  initialize: function() {
    this.addRegions({
      mainRegion: '#myLessonsAppRegion'
    });
  },
  start: function(){
    this.lessons = new myLessons.Entities.LessonCollection();
    this.lessons.on('sync', this.showContent, this);
    this.lessons.fetch({
      userId: Valamis.currentUserId
    });
  },
  showContent: function() {
    var layoutView = new myLessons.Views.AppLayoutView({collection: this.lessons});
    this.mainRegion.show(layoutView);
  }
});

var myLessons = new MyLessons();
