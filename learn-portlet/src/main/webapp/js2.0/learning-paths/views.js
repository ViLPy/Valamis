learningPaths.module('Views', function (Views, learningPaths, Backbone, Marionette, $, _) {

  Views.GOAL_TYPE = {
    COURSE: 'course',
    STATEMENT: 'statement',
    ACTIVITY: 'activity',
    PACKAGE: 'package'
  };

  Views.GoalItemView = Marionette.ItemView.extend({
    tagName: 'tr',
    template: '#goalItemViewTemplate',
    templateHelpers: function() {
      return {
        isPackage : this.options.model.get('type') === Views.GOAL_TYPE.PACKAGE,
        isCourse : this.options.model.get('type') === Views.GOAL_TYPE.COURSE
      }
    }
  });

  Views.GoalCollectionView = Marionette.CompositeView.extend({
    template: '#goalCollectionTemplate',
    childViewContainer: '.js-list-view',
    childView: Views.GoalItemView
  });

  Views.CertificateItemView = Marionette.LayoutView.extend({
    template: '#certificatesItemViewTemplate',
    className: 'learning-path-item',
    templateHelpers: function() {
      return {
        isFailed : this.options.model.get('status') === 'Failed'
      }
    },
    regions: {
      'goalsRegion' : '.js-certificate-goals'
    },
    events: {
      'click .js-toggle-goals': 'clickToggleGoals'
    },
    initialize: function(options) {
      this.isGoalsExpanded = options.isSingleCertificate;
    },
    onRender: function() {
      this.toggleGoals();

      var certificateId = this.model.get('id');
      var that = this;
      this.certificate = new learningPaths.Entities.CertificateModel({id: certificateId});
      this.statuses = new learningPaths.Entities.UserGoalModel();
      this.certificate.fetch({
        success: function () {
          that.statuses.fetch({
            certificateId: certificateId,
            userId: Valamis.currentUserId,
            success: function () {
              that.appendGoals();
            }
          });
        }
      });
    },
    clickToggleGoals: function() {
      this.isGoalsExpanded = !this.isGoalsExpanded;
      this.toggleGoals();
    },
    toggleGoals: function() {
      this.$('.js-arrow-icon').toggleClass('val-icon-arrow-up', this.isGoalsExpanded);
      this.$('.js-show-label').toggleClass('hidden', this.isGoalsExpanded);

      this.$('.js-arrow-icon').toggleClass('val-icon-arrow-down', !this.isGoalsExpanded);
      this.$('.js-hide-label').toggleClass('hidden', !this.isGoalsExpanded);
      this.$('.js-certificate-goals').toggleClass('hidden', !this.isGoalsExpanded);
    },
    appendGoals: function() {
      this.goals = new learningPaths.Entities.UserGoalCollection();
      this.achievedAmount = 0;

      this.collectGoals(this.certificate.get('courses'), this.statuses.get('courses'), Views.GOAL_TYPE.COURSE);
      this.collectGoals(this.certificate.get('statements'), this.statuses.get('statements'), Views.GOAL_TYPE.STATEMENT);
      this.collectGoals(this.certificate.get('activities'), this.statuses.get('activities'), Views.GOAL_TYPE.ACTIVITY);
      this.collectGoals(this.certificate.get('packages'), this.statuses.get('packages'), Views.GOAL_TYPE.PACKAGE);

      this.$('.js-achieved-amount').text(this.achievedAmount);
      this.$('.js-total-goals').text(this.goals.length);

      var goalsView = new learningPaths.Views.GoalCollectionView({collection: this.goals});
      this.goalsRegion.show(goalsView);
    },
    collectGoals: function(goal, status, type) {
      var that = this;
      if (goal.length > 0 && status.length > 0) {
        goal.forEach(function(item) {
          var statusItem = Array();
          var goalTitle = '';
          var goalUrl = '';
          var courseLessonsAmount = '';
          var packageCourseName = '';
          var packageCourseUrl = '';

          switch(type) {
            case Views.GOAL_TYPE.ACTIVITY:
              statusItem = status.filter(function (i) {
                return i.name == item['title']
              }).map(function (i) {
                return i.status;
              });
              goalTitle = item['activityCount'] + ' ' + Valamis.language[item['title']];
              break;
            case Views.GOAL_TYPE.STATEMENT:
              statusItem = status.filter(function (i) {
                return i.obj == item['tincanStmntObj'] && i.verb == item['tincanStmntVerb']
              }).map(function (i) {
                return i.status;
              });
              goalTitle = Valamis.language['statementLabel'] + ': ' + Valamis.language[item['tincanStmntVerb']] + ' ' + item['tincanStmntObj'];
              break;
            case Views.GOAL_TYPE.COURSE:
              statusItem = status.filter(function (i) {
                return i.id == item['id']
              }).map(function (i) {
                return i.status;
              });
              goalTitle = item['title'];
              goalUrl = item['url'];
              courseLessonsAmount = item['lessonsAmount'];
              break;
            case Views.GOAL_TYPE.PACKAGE:
              statusItem = status.filter(function (i) {
                return i.packageId == item['packageId']
              }).map(function (i) {
                return i.status;
              });
              goalTitle = item['title'];
              packageCourseName = item['course']['title'];
              packageCourseUrl = item['course']['url'];
              break;
          }

          var statusLabel = (statusItem.length) ? statusItem[0].toLowerCase() : '';
          if (statusLabel === 'success')
            that.achievedAmount++;
          var newGoal = new learningPaths.Entities.UserGoalModel({
            status: statusLabel,
            title: goalTitle,
            url: goalUrl,
            type: type,
            courseLessonsAmount: courseLessonsAmount,
            packageCourseName: packageCourseName,
            packageCourseUrl: packageCourseUrl
          });
          that.goals.add(newGoal);
        });
      }
    }
  });

  Views.AppLayoutView = Marionette.CompositeView.extend({
    template: '#certificatesLayoutTemplate',
    className: 'val-learning-paths',
    childView: Views.CertificateItemView,
    childViewContainer: '.js-list-view',
    childViewOptions: function() {
      return {
        isSingleCertificate: this.options.collection.length === 1
      }
    },
    onRender: function() {
      if(this.collection.length === 0)
        this.$('.js-no-certificates').removeClass('hidden');
    }
  });

});