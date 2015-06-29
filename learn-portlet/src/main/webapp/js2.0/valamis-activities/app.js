var ValamisActivities = Marionette.Application.extend({
  channelName:'valamisActivities',
  initialize: function() {
    this.addRegions({
      mainRegion: '#valamisActivitiesAppRegion'
    });
  },
  start: function(){
    this.userInfoModel = new valamisActivities.Entities.LiferayUserModel;

    var that = this;
    this.userInfoModel.fetch({
      'userId': Valamis.currentUserId,
      success: function() {
        var layoutView = new valamisActivities.Views.AppLayoutView({currentUserModel: that.userInfoModel});
        that.mainRegion.show(layoutView);
      }
    });
  }
});

var valamisActivities = new ValamisActivities();
