myLessons.module('Views', function (Views, myLessons, Backbone, Marionette, $, _) {

  Views.LessonItemView = Marionette.ItemView.extend({
    className: 'tile',
    template: '#lessonItemViewTemplate',
    templateHelpers: function() {
      var colorClass = '';
      var autoGrade = parseInt(this.model.get('autoGrade')) || 0;
      var teacherGrade = parseInt(this.model.get('grade')) || 0;

      var gradeInt = autoGrade || teacherGrade || 0;

      if (gradeInt < 25)
        colorClass = 'red';
      else if (gradeInt >= 25 && gradeInt < 50)
        colorClass = 'yellow';
      else
        colorClass = 'green';

      var lessonGrade = gradeInt + '%';

      var lessonItemStatusLabel = (gradeInt) ? Valamis.language['inProgressLabel'] : Valamis.language['notStartedLabel'];

      return {
        lessonItemStatusLabel: lessonItemStatusLabel,
        colorClass: colorClass,
        lessonGrade: lessonGrade
      }
    }
  });

  Views.AppLayoutView = Marionette.CompositeView.extend({
    template: '#lessonsLayoutTemplate',
    className: 'my-lessons',
    childView: Views.LessonItemView,
    childViewContainer: '.js-list-view',
    onRender: function() {
      if(this.collection.length === 0)
        this.$('.js-no-lessons').removeClass('hidden');
    }
  });

});