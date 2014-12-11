var GOAL_TYPE = {
  COURSE: 1,
  STATEMENT: 2,
  ACTIVITY: 3
};

var CertificateGoalStatusService = new Backbone.Service({ url: path.root,
  sync: {
    'read': function (e, options) {
      return path.api.users + options.userID + '/certificates/' + options.certificateID + '/goals';
    }
  }
});

var CertificateGoalStatus = Backbone.Model.extend({
  defaults: {
    id: 0,
    isActivity: false,
    selected: false,
    value: "",
    title: ""
  }
}).extend(CertificateGoalStatusService)


var GoalStatusView = Backbone.View.extend({
  initialize: function (options) {
    this.$el = jQuery('<tr>');
    this.language = options.language;

    this.model.set({ type: options.type, certificateID: options.certificateID, status: options.status});

    if (options.type == GOAL_TYPE.STATEMENT)
      this.model.set({title: this.language[this.model.get('tincanStmntVerb')] + ' ' + this.model.get('tincanStmntObj')});
    else if (options.type == GOAL_TYPE.ACTIVITY) {
        var name = this.model.get('title');
        this.model.set({activityID: this.model.get('title'), title: this.language[this.model.get('title')]});
        if (name == 'participation' || name == 'contribution')
            this.model.set({noDate: true });
    }
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#goalRowTemplate').html(), _.extend(this.model.toJSON(), {
      canDelete: false,
      status: this.language[this.model.get('status')]}, this.language));
    this.$el.html(template);
    return this;
  },
  setPeriod: function () {
    this.$('#duringPeriodType option[value=' + this.model.get('period') + ']').prop('selected', true);
  }
});


var ViewUserDetailsDialog = Backbone.View.extend({
  initialize: function (options) {
    this.options = options;
    this.model = new CertificateModel();
    this.statuses = new CertificateGoalStatus();
    this.statuses.on('change', this.addAll, this);
    this.render();
  },
  render: function () {
    var language = this.options.language;
    var renderedTemplate = Mustache.to_html(jQuery('#certificateViewUserDetails').html(), language);
    this.$el.html(renderedTemplate);

    var goalsListTemplate = Mustache.to_html(jQuery('#certificateGoalsListTemplate').html(), language);
    this.$('#userResultsList').html(goalsListTemplate);

    return this;
  },
  setCertificateID: function (certificateID, userID, isUserMember) {
    this.userID = userID;
    this.certificateID = certificateID;
    this.isUserMember = isUserMember;
    this.model.set({id: certificateID});
    this.model.fetch({success: jQuery.proxy(function (){ this.resetStatuses(); }, this) });
  },
  resetStatuses: function () {
    if (this.isUserMember)
      this.statuses.fetch({reset: true, certificateID: this.certificateID, userID: this.userID});
    else
      this.addAll();
  },
  addAll: function () {
    this.renderGoals(this.model.get('courses'), this.statuses.get('courses'), GOAL_TYPE.COURSE);
    this.renderGoals(this.model.get('statements'), this.statuses.get('statements'), GOAL_TYPE.STATEMENT);
    this.renderGoals(this.model.get('activities'), this.statuses.get('activities'), GOAL_TYPE.ACTIVITY);
  },
  renderGoals: function (goals, statuses, type) {
    if (goals != undefined) {
      var isFirstNotPassed = true;
      for (var i = 0; i < goals.length; i++) {
        var status = '';
        var item = new CertificateGoalStatus(goals[i]);
        if (statuses != undefined) {
          if (type == GOAL_TYPE.ACTIVITY) {
            status = statuses.filter(function (i) {
              return i.name == item.get('title')
            }).map(function (i) {
                return i.status;
              });
            item.set({isActivity: true });
          }
          if (type == GOAL_TYPE.STATEMENT) {
            status = statuses.filter(function (i) {
              return i.obj == item.get('tincanStmntObj') && i.verb == item.get('tincanStmntVerb')
            }).map(function (i) {
                return i.status;
              });
          }
          if (type == GOAL_TYPE.COURSE) {
            status = statuses.filter(function (i) {
              return i.id == item.id
            }).map(function (i) {
                return i.status;
              });


          }
        }

        if (type == GOAL_TYPE.COURSE){
          if (status == '' || !isFirstNotPassed) item.set({url: ''});
          if (status != 'Success') isFirstNotPassed = false;
        }
        var view = new GoalStatusView({model: item, status: status, certificateID: this.model.id, type: type, language: this.options.language});

        var template = view.render().$el;
        view.setPeriod();
        if (type == GOAL_TYPE.COURSE) {
          this.$('#certificateCoursesTable').append(template);
        }
        else if (type == GOAL_TYPE.STATEMENT) {
          this.$('#certificateStatementsTable').append(template);
        }
        else if (type == GOAL_TYPE.ACTIVITY) {
          this.$('#certificateActivitiesTable').append(template);
        }
      }
    }
  }

});
