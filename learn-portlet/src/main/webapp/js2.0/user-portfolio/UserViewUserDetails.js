var GOAL_TYPE = {
  COURSE: 1,
  STATEMENT: 2,
  ACTIVITY: 3,
  PACKAGE: 4
};
CertificateService = new Backbone.Service({ url: '/',
    sync: {
        'read': {
          'path': function (model) {
            return path.api.certificates + model.id
          },
          'data': function (model) {
            return {
              action: 'GETBYID',
              courseId: Utils.getCourseId()
            }
          },
          'method': 'get'
        }
    }
});

var CertificateModel = Backbone.Model.extend({

}).extend(CertificateService);

var CertificateGoalStatusService = new Backbone.Service({
  url: path.root,
  sync: {
    'read':{
      path: function (e, options) {
        return path.api.users + options.userID + '/certificates/' + options.certificateID + '/goals';
      },
      'method': 'get'
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
}).extend(CertificateGoalStatusService);


var GoalStatusView = Backbone.View.extend({
  initialize: function (options) {
    this.$el = jQuery('<tr>');
    this.language = options.language;
    this.model.set({
      type: options.type,
      certificateID: options.certificateID,
      status: options.status,
      dateFinish: options.dateFinish
    });

    if (options.type == GOAL_TYPE.STATEMENT)
      this.model.set({title: this.language[this.model.get('tincanStmntVerb')] + ' ' + this.model.get('tincanStmntObj')});
    else if (options.type == GOAL_TYPE.ACTIVITY) {
        var name = this.model.get('title');
        this.model.set({activityID: this.model.get('title'), title: this.language[this.model.get('title')], status: this.model.get('status'), dateFinish: this.model.get('dateFinish')});
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
    var renderedTemplate = Mustache.to_html(jQuery('#certificateGoalsListTemplate').html(), language);
    this.$el.html(renderedTemplate);
    return this;
  },
  setCertificateID: function (certificateID, userID, isUserMember) {
    this.userID = userID;
    this.certificateID = certificateID;
    this.isUserMember = isUserMember;
    this.model.set({id: certificateID});
    this.model.fetch().then(function(){
        this.resetStatuses();
    }.bind(this));
  },
  resetStatuses: function () {
      this.statuses.fetch({reset: true, certificateID: this.certificateID, userID: this.userID});
  },
  addAll: function () {
    this.renderGoals(this.model.get('courses'), this.statuses.get('courses'), GOAL_TYPE.COURSE);
    this.renderGoals(this.model.get('statements'), this.statuses.get('statements'), GOAL_TYPE.STATEMENT);
    this.renderGoals(this.model.get('activities'), this.statuses.get('activities'), GOAL_TYPE.ACTIVITY);
    this.renderGoals(this.model.get('packages'), this.statuses.get('packages'), GOAL_TYPE.PACKAGE);
  },
  renderGoals: function (goals, statuses, type) {
    if (goals != undefined) {
      for (var i = 0; i < goals.length; i++) {
        var params;
        var item = new CertificateGoalStatus(goals[i]);

        if (type == GOAL_TYPE.ACTIVITY) {
          item.set({isActivity: true });
        }

        if (statuses != undefined) {
          if (type == GOAL_TYPE.ACTIVITY) {
            params = statuses.filter(function (i) {
              return i.name == item.get('title')
            }).map(function (i) {
                return [i.status, i.dateFinish];
              });
          }
          else if (type == GOAL_TYPE.STATEMENT) {
            params = statuses.filter(function (i) {
              return i.obj == item.get('tincanStmntObj') && i.verb == item.get('tincanStmntVerb')
            }).map(function (i) {
                return [i.status, i.dateFinish];
              });
          }
          else if (type == GOAL_TYPE.COURSE) {
            params = statuses.filter(function (i) {
              return i.id == item.id
            }).map(function (i) {
                return [i.status, i.dateFinish];
              });
          }
          else if (type == GOAL_TYPE.PACKAGE) {
            params = statuses.filter(function (i) {
              return i.packageId == item.get('packageId')
            }).map(function (i) {
              return [i.status, i.dateFinish];
            });
          }
        }

        var view = new GoalStatusView({model: item, status: params[0][0], certificateID: this.model.id, type: type, language: this.options.language, dateFinish: params[0][1]});

        var template = view.render().$el;
        if (type == GOAL_TYPE.COURSE) {
          this.$('#certificateCoursesTable').append(template);
        }
        else if (type == GOAL_TYPE.STATEMENT) {
          this.$('#certificateStatementsTable').append(template);
        }
        else if (type == GOAL_TYPE.ACTIVITY) {
          this.$('#certificateActivitiesTable').append(template);
        }
        else if (type == GOAL_TYPE.PACKAGE) {
          this.$('#lessonGoalsTable').append(template);
        }
      }
    }
  }});
