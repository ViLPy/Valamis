var AchievementCollection = Backbone.Collection.extend({
    model: Achievement,
    url: '/learn-portlet/services/achievements/achievements',
    comparator: function(achievement){
        return -achievement.get("id");
    },
    initialize: function(){
        this.on('sync', this.getActivities,this);
        this.fetch();
    },
    getActivities: function(){
        this.each(function(achievement){
            achievement.activitiesRequired = new Activities([], {achievement: achievement});
            achievement.activitiesRequired.fetch();
        })
    }
});