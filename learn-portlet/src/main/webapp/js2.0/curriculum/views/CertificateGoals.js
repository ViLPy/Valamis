var GOAL_TYPE = {
  COURSE: 1,
  STATEMENT: 2,
  ACTIVITY: 3
};

GoalService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'update': {
      'path': function (model) {

        var certificateID = model.get('certificateID');
        var action = "";
        if (model.get('type') == GOAL_TYPE.COURSE) {
          action = 'api/certificates/' + certificateID + '?action=UPDATECOURSE&courseId=' + model.id;
        }
        else if (model.get('type') == GOAL_TYPE.STATEMENT) {
          action = 'api/certificates/' + certificateID + '?action=UPDATESTMNT';
        }
        else {
          action = 'api/certificates/' + certificateID + '?action=UPDATEACTIVITY&activityId=' + model.get('activityID');
        }
        return action;
      },
      'method': 'post'
    },
    'delete': {
      'path': function (model) {
        var certificateID = model.get('certificateID');
        if (model.get('type') == GOAL_TYPE.COURSE) return 'api/certificates/' + certificateID + '?action=DELETECOURSE&courseId=' + model.id;
        else if (model.get('type') == GOAL_TYPE.STATEMENT) return 'api/certificates/' + certificateID + '?action=DELETETINCANSTMNT';
        else  return 'api/certificates/' + certificateID + '?action=DELETEACTIVITY&activityId=' + model.get('activityID');
      },
      'method': 'post'
    }
  }
});

var GoalModel = Backbone.Model.extend({
  defaults: {
    id: 0,
    isActivity: false,
    selected: false,
    value: "",
    title: ""
  }
}).extend(GoalService);

var GoalView = Backbone.View.extend({
  events: {
    'click .val-icon-delete': 'deleteThis',
    'click .checkbox': 'selectThis',
    'blur #duringPeriod': 'updateThis',
    'change #duringPeriodType': 'updateThis',
    'blur #goalsAmount': 'updateThis'
  },
  initialize: function (options) {
    this.$el = jQuery('<tr>');
    this.language = options.language;

    this.model.set({
      type: options.type,
      certificateID: options.certificateID});
    if (options.type == GOAL_TYPE.STATEMENT)
      this.model.set({title: this.language[this.model.get('tincanStmntVerb')] + ' ' + this.model.get('tincanStmntObj')});
    if (options.type == GOAL_TYPE.ACTIVITY)
      this.model.set({activityID: this.model.get('title'), title: this.language[this.model.get('title')]});
    this.model.on('setSelected', this.setSelected, this);
    this.model.on('setUnselected', this.setUnselected, this)
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#goalRowTemplate').html(), _.extend(this.model.toJSON(), {canDelete: true}, this.language));
    this.$el.html(template);
    return this;
  },
  setPeriod: function () {
    this.$('#duringPeriodType option[value=' + this.model.get('period') + ']').prop('selected', true);
  },
  updateThis: function () {
    this.model.set({
      periodValue: this.$('#duringPeriod').val(),
      periodType: this.$('#duringPeriodType').val(),
      activityCount: this.$('#goalsAmount').val()
    });
    this.model.save();
  },
  deleteThis: function () {
    this.trigger('goalDelete', this);
    this.model.destroy();
    this.remove();
  },
  selectThis: function () {
    var alreadySelected = this.model.get('selected');
    if (alreadySelected) {
      this.setUnselected();
    }
    else {
      this.setSelected();
    }
  },
  setSelected: function () {
    this.model.set({selected: true });
    this.$('.checkbox').addClass('checked');
  },
  setUnselected: function () {
    this.model.set({selected: false });
    this.$('.checkbox').removeClass('checked');
  },
  isSelected: function(){
    return this.model.get('selected');
  },
  getTitle: function(){
    return this.model.get('title').toLowerCase();
  },
  showThis: function(){
    this.$el.show();
  },
  hideThis: function(){
    this.$el.hide();
  }
});


var CertificateGoalsView = Backbone.View.extend({
  events: {
    'click #addGoals': 'toggleAddGoals',
    'click #chooseAction': 'toggleAction',
    'click .deleteGoals': 'deleteSelectedGoals',
    'click #selectAllGoals': 'selectAll',
    'click .addCourse': 'addCourse',
    'click .addStatement': 'addStatement',
    'click .addActivity': 'addActivity',
    'click .menu-toggle': 'searchMenuToggle',
    'keyup #goalSearch': 'searchGoals',
    'keypress .onlyDigits': 'preventNonDigits',
    'click #toggleCourses': 'toggleCourses',
    'click #toggleStatements': 'toggleStatements',
    'click #toggleActivities': 'toggleActivities',
    'click .saveNextCertificate': 'saveNext'
  },
  initialize: function (options) {
    this.options = options;
    this.isSelectedAll = false;

    this.model = new CertificateModel();
    this.model.on('change', this.render, this);
  },

  setCertificateID: function (certificateID) {
    this.model.set({ id: certificateID });
    this.model.fetch();
  },
  fetchModel: function () {
    this.model.fetch();
  },
  render: function () {
    var language = this.options.language;
    this.goalAmount = 0;
    if (this.model.get('courses') != undefined) this.goalAmount += this.model.get('courses').length;
    if (this.model.get('statements') != undefined) this.goalAmount += this.model.get('statements').length;
    if (this.model.get('activities') != undefined) this.goalAmount += this.model.get('activities').length;

    var renderedTemplate = _.template(
      Mustache.to_html(
        jQuery('#certificateItemEditGoalsTemplate').html(),
        _.extend(this.model.toJSON(), _.extend({goalsCount: this.goalAmount}, language))));
    this.$el.html(renderedTemplate);

    var goalsListTemplate = Mustache.to_html(jQuery('#certificateGoalsListTemplate').html(), _.extend(this.model.toJSON(), language));
    this.$('#certificateItemGoals').html(goalsListTemplate);

    this.views = [];
    this.courses = [];
    this.statements = [];
    this.activities = [];
    this.renderGoals(this.model.get('courses'), GOAL_TYPE.COURSE);
    this.renderGoals(this.model.get('statements'), GOAL_TYPE.STATEMENT);
    this.renderGoals(this.model.get('activities'), GOAL_TYPE.ACTIVITY);

    return this;
  },

  renderGoals: function (goals, type) {
    if (goals != undefined) {
      for (var i = 0; i < goals.length; i++) {
        var item = new GoalModel(goals[i]);
        if (type == GOAL_TYPE.ACTIVITY) item.set({isActivity: true });

        var view = new GoalView({model: item, certificateID: this.model.id, type: type, language: this.options.language});
        view.on('goalDelete', function () {
          this.goalAmount -= 1;
          this.$('#goalAmount').text(this.goalAmount);
        }, this);
        var template = view.render().$el;
        view.setPeriod();
        if (type == GOAL_TYPE.COURSE) {
          this.$('#certificateCoursesTable').append(template);
          this.courses.push(item);
        }
        else if (type == GOAL_TYPE.STATEMENT) {
          this.$('#certificateStatementsTable').append(template);
          this.statements.push(item);
        }
        else {
          this.$('#certificateActivitiesTable').append(template);
          this.activities.push(item);
        }

        this.views.push(view);
      }
    }
  },

  searchGoals: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), 200);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);
    var filter = this.$('#goalSearch').val();

    if (filter) {
      this.views.forEach(function (item) {
        if (item.getTitle().indexOf(filter.toLowerCase()) < 0)
          item.hideThis();
        else item.showThis();
      });
    }
    else {
      this.views.forEach(function (item) {
        item.showThis();
      });
    }
  },
  toggleCourses: function () {
    this.$('#toggleCourses').toggleClass('checked');
    this.$('#certificateCoursesTable').toggle();
  },
  toggleStatements: function () {
    this.$('#toggleStatements').toggleClass('checked');
    this.$('#certificateStatementsTable').toggle();
  },
  toggleActivities: function () {
    this.$('#toggleActivities').toggleClass('checked');
    this.$('#certificateActivitiesTable').toggle();
  },

  toggleAddGoals: function () {
    this.$('#addGoals').toggleClass('active');
    this.$('#dropdownGoalsMenu').toggleClass('dropdown-visible');
  },

  toggleAction: function () {
    this.$('#chooseAction').toggleClass('active');
    this.$('#dropdownActionMenu').toggleClass('dropdown-visible');
  },

  deleteSelectedGoals: function () {
    this.views.filter(function(i){ return i.isSelected(); }).forEach(function (item) {
      item.deleteThis();
    });
    this.toggleAction();
  },

  searchMenuToggle: function (e) {
    e.preventDefault();
    this.$('#goalsContentWrapper').toggleClass('active');
  },

  addCourse: function () {
    this.toggleAddGoals();
  },

  addStatement: function () {
    this.toggleAddGoals();
  },

  addActivity: function () {
    this.toggleAddGoals();
  },

  saveNext: function () {
    this.trigger('openMembers', this);
  },


  selectAll: function () {
    this.isSelectedAll = !this.isSelectedAll;

    this.setSelectModel(this.courses);
    this.setSelectModel(this.activities);
    this.setSelectModel(this.statements);
  },

  setSelectModel: function (list) {
    if (list != undefined) {
      for (var i = 0; i < list.length; i++) {
        var item = list[i];
        this.setSelectItem(item);
      }
    }
  },
  preventNonDigits: function (e) {
    if (e.keyCode != 46 && e.keyCode != 8 && e.keyCode != 9) {
      if (String.fromCharCode(e.charCode).match(/[^0-9]/g)) return false;
    }
  },
  setSelectItem: function (model) {
    var alreadySelected = model.get('selected');
    if (alreadySelected != this.isSelectedAll) {
      if (alreadySelected) {
        model.trigger('setUnselected', this);
      }
      else {
        model.trigger('setSelected', this);
      }

    }
  }
});