recentLessons.module('Views', function (Views, recentLessons, Backbone, Marionette, $, _) {

  Views.RecentItemView = Marionette.ItemView.extend({
    template: '#recentLessonsItemViewTemplate',
    tagName: 'div',
    className: 'tile'
  });

  Views.AppLayoutView = Marionette.CompositeView.extend({
    tagName: 'div',
    className: 'resent-lessons',
    template: '#recentLessonsLayoutTemplate',
    childViewContainer: '.js-list-view',
    childView: Views.RecentItemView,
    onRender: function() {
      if(this.collection.length === 0)
        this.$('.js-no-recent-lesson').removeClass('hidden');
    }
  });
});