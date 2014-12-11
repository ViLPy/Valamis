TranscriptUsersView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.render();
    },

    events: {
        'click #selectUserButton': 'openUserModal',
//        'click #printTranscriptButton': 'printTranscript'
        'click #printTranscriptButton' : 'clickPrintButton'
    },

    render: function () {
        var buttonModel = Backbone.Model.extend({});
        this.model = new buttonModel();
        this.model.set({companyID: jQuery('#transcriptCompanyID').val(), userID: jQuery('#transcriptUserID').val()});
        var template = Mustache.to_html(jQuery('#transcriptButtonsTemplate').html(), _.extend(this.model.toJSON(), this.language));
        this.$el.append(template);
    },

    openUserModal: function (e) {
        e.preventDefault();
        this.trigger('openSelectUserModal', this);
    },

    /*printTranscript: function () {
        var printModel = new PrintModel();
        printModel.fetch({
            data: {

            }*//*,
            success: (function () {
                alert(' Service request success: ');
            }),
            error: (function (e) {
                alert(' Service request failure: ' + e);
            }),
            complete: (function (e) {
                alert(' Service request completed ');
            })*//*
        });
    },*/

    clickPrintButton: function(e) {
//        e.preventDefault();
        jQuery('#printLink')[0].click();
        e.stopPropagation();
    }
});


TranscriptPackagesView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.render();
    },
    events: {
        'click #expandDetailsList.expand-icon': 'expandDetails'
    },
    render: function () {
        this.collection.each(this.addOne, this);
//        this.collection.each(this.addPackageDetails, this);
    },
    addOne: function (item) {
        var template = Mustache.to_html(jQuery('#transcriptPackageItemTemplate').html(), _.extend(item.toJSON()));
        this.$el.append(template);
        this.addPackageDetails(item);
    },
    addPackageDetails: function (item) {
        var packageDetailsView = new TranscriptPackageDetailsView({model: item, language: this.language});
        this.$el.append(packageDetailsView.render().el);
    },
    expandDetails: function () {
        jQuery(arguments[0].target).closest('tr').next().toggleClass('hidden');
        jQuery(arguments[0].target).closest('tr').next().find('#packageDetailsList').toggleClass('hidden');
        jQuery(arguments[0].target).toggleClass('expanded');
    }
});


TranscriptPackageDetailsView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.collection = options.collection;
        this.packageModel = options.model;
        this.statements = JSON.parse(this.packageModel.get('statements')).statements;
        this.timeStarted = 0;
        this.timeFinished = 0;
        this.totalTime = 0;
        this.which = 1;

    },
    render: function () {
        if(this.statements.length == 0) {
            jQuery('#packageDetailsList-' + this.packageModel.id).closest('tr').prev().remove();
            jQuery('#packageDetailsList-' + this.packageModel.id).closest('tr').remove();
            return "";
        }

        var attemptStart = -1, attemptEnd = this.statements.length - 1;
        var allStatements = [];

        for(var i = this.statements.length - 1; i >= 0; i--) {
            if(this.statements[i].object.definition.type.substr(this.statements[i].object.definition.type.lastIndexOf("/") + 1, 6) == "course") {
                if(this.statements[i].verb.id == "http://adlnet.gov/expapi/verbs/attempted") {
                    var attemptStatements = [];
                    attemptStart = i;
                    if(attemptStart >= 0 && attemptEnd < this.statements.length) {
                        for (var j = attemptStart; j <= attemptEnd; j++) {
//                            if(this.statements[j].verb.id == "http://adlnet.gov/expapi/verbs/answered" || this.statements[j].verb.id == "http://adlnet.gov/expapi/verbs/experienced")
                                attemptStatements.push(this.statements[j]);
                        }
                        this.timeStarted = this.statements[i].stored.replace(/T/g, " ").replace(/Z/g, "").replace(/-/g, "/");
                        this.timeFinished = this.statements[attemptEnd - 1].stored.replace(/T/g, " ").replace(/Z/g, "").replace(/-/g, "/");
                        this.totalTime += Math.abs(new Date(this.timeFinished) - new Date(this.timeStarted));
                    }

                    if(i > 0) {
                        if (this.statements[i - 1].verb.id == "http://adlnet.gov/expapi/verbs/completed" &&
                            this.statements[i - 1].object.definition.type.substr(this.statements[i - 1].object.definition.type.lastIndexOf("/") + 1, 6) == "course") {
                            attemptEnd = i - 1;
                        }
                        else {
                            attemptEnd = i;
                        }
                    }

                    var statements = new PackageStatementCollection();
                    statements.add(attemptStatements);
                    allStatements[this.which-1] = statements;
                    this.which++;
                }
            }
        }

        this.days = Math.floor(this.totalTime/(1000*60*60*24));
        this.hours = Math.floor(this.totalTime/(1000*60*60));
        this.minutes = Math.floor(this.totalTime/(1000*60));
        this.seconds = Math.floor(this.totalTime/(1000));
        this.totalTime = (this.days > 0 ? this.days + (((this.days) % 10 == 1 && this.days % 100 != 11) ? " day, " : " days, ") : "")
            + (this.hours > 0 ? (this.hours - this.days*24) + (((this.hours) % 10 == 1 && this.hours % 100 != 11) ? " hour, " : " hours, ") : "")
            + (this.minutes > 0 ? (this.minutes - this.hours*60) + (((this.minutes) % 10 == 1 && this.minutes % 100 != 11) ? " minute, " : " minutes, ") : "")
            + (this.seconds > 0 ? (this.seconds - this.minutes*60) + (((this.seconds) % 10 == 1 && this.seconds % 100 != 11) ? " second." : " seconds.") : "");

        this.model.set({packageId: this.packageModel.id, statementCount: this.statements.length, totalTime: this.totalTime});
        var template = Mustache.to_html(jQuery('#transcriptPackageDetailsTemplate').html(), _.extend(this.model.toJSON()));
        jQuery('#packageDetailsList-' + this.packageModel.id).html(template);
        jQuery('#packageDetailsList-' + this.packageModel.id).toggleClass('hidden');


        for(var i = 0; i < allStatements.length ; i++) {
            this.which = allStatements.length - i;
            var statementAttemptView = new TranscriptPackageAttemptStatementsView({model: new TranscriptModel(), which: this.which, packageId: this.packageModel.id});
            jQuery('#package-' + this.packageModel.id + '-statements').append(statementAttemptView.render().el);
            allStatements[i].each(this.addPackageStatements, this);
        }

        return this;
    },

    addPackageStatements: function(item) {
        var view = new TranscriptPackageStatementItemView({model: item, which: this.which, language: this.language});
        jQuery('#package-' + this.packageModel.id + '-attempt-' + this.which + '-statements').append(view.render().el);
    }
});

TranscriptPackageStatementItemView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.verb = this.language[options.model.get('verb').id].toLowerCase();
        this.object = options.model.get('object').definition.name[Object.keys(options.model.get('object').definition.name)[0]];
        if(options.model.get('result') !== undefined && this.verb == 'answered') {
            this.answer = options.model.get('result').response;
            this.answer = this.answer.replace(/\[\.\]/g, '->').replace(/[\[\]]/g, '').replace(/,/g, ', ');
            if(options.model.get('result').score !== undefined) {
                this.score = options.model.get('result').score.scaled;
                this.model.set({score: this.score});
            }
            this.model.set({answer: this.answer});
        }
        this.storedTime = options.model.get('stored').replace(/T/g, " ").replace(/Z/g, "").replace(/-/g, "/");
        this.which = options.which;
        this.model.set({verb: this.verb, object: this.object, storedTime: this.storedTime, which: this.which});
    },

    tagName: 'tr',

    render: function () {
        var template = Mustache.to_html(jQuery('#transcriptPackageStatementItemTemplate').html(), _.extend(this.model.toJSON(), this.language));
        this.$el.append(template);
        this.$el.css({
            'style': 'border-right: none;'
        });

        return this;
    }
});

TranscriptPackageAttemptStatementsView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.which = options.which;
        this.packageId = options.packageId;
        this.model.set({which: this.which, packageId: this.packageId});
    },

    tagName: 'tr',

    events: {
        'click #expandPackageAttemptStatementsList.expand-icon': 'expandPackageAttemptStatements'
    },

    render: function () {
        var template = Mustache.to_html(jQuery('#transcriptPackageAttemptStatementsTemplate').html(), _.extend(this.model.toJSON(), this.language));
        this.$el.append(template);

        return this;
    },

    expandPackageAttemptStatements: function () {
        jQuery(arguments[0].target).parent().next('#package-' + this.packageId + '-attempt-' + this.which + '-statements').toggleClass('hidden');
        jQuery(arguments[0].target).toggleClass('expanded');
    }
});

// ####

TranscriptCoursesItemView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
    },
    className: 'course-item clearfix',
    events: {
        'click #expandPackageList.expand-icon': 'expandPackages'
    },
    render: function () {
        var template = Mustache.to_html(jQuery('#transcriptCoursesItemTemplate').html(), _.extend(this.model.toJSON(), this.language));
        this.$el.html(template);

        /*if (this.model.packages == undefined) {*/
            var packages = new PackagesCollection();
            var that = this;
            packages.fetch({courseId: this.model.id, success: function () {
                new TranscriptPackagesView({el: that.$el.find('#packagesList>tbody'), collection: packages, language: that.language});
                that.model.packages = packages;
            }});
        /*}*/
        return this;
    },
    expandPackages: function () {
        this.$el.find('#packagesList').toggleClass('hidden');
        jQuery(arguments[0].target).toggleClass('expanded');
    }
});

TranscriptCoursesView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.render();
    },

    render: function () {
        var template = Mustache.to_html(jQuery('#transcriptCoursesTemplate').html(), _.extend(this.language));
        this.$el.append(template);
        this.collection.each(this.addOne, this);
    },

    addOne: function (item) {
        var view = new TranscriptCoursesItemView({language: this.language, model: item});
        this.$el.find('#coursesList').append(view.render().el);
    }
});

// ####

TranscriptCertificatesItemView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
    this.model = options.model;
  },

  render: function () {
    var statements = new StatementModelCollection({amount: 0});

    var certificates = new CertificateGoalCollection({certificateID: this.model.id});
    certificates.fetch({certificateID: this.model.id});
    var statuses = new CertificateGoalStatus({certificateID: this.model.id});

    var that = this;

    statuses.fetch({reset: true, certificateID: that.model.id, userID: jQuery('#transcriptUserID').val(),
        success: function () {
            var datesFinish = [];
            var activities = statuses.get('activities') !== undefined ? statuses.get('activities') : [];
            var courses = statuses.get('courses') !== undefined ? statuses.get('courses') : [];
            var stmnts = statuses.get('statements') !== undefined ? statuses.get('statements') : [];

            // Only if the certificate has goals
            if(activities.length > 0 || courses.length > 0 || stmnts.length > 0) {
                for (var i = 0; i < activities.length; i++) {
                    var item = new CertificateGoalStatus(activities[i]);
                    datesFinish.push([item.get('dateFinish').slice(0, item.get('dateFinish').lastIndexOf("/") + 1), "20", item.get('dateFinish').slice(item.get('dateFinish').lastIndexOf("/") + 1)].join(""));
                }
                for (var i = 0; i < courses.length; i++) {
                    var item = new CertificateGoalStatus(courses[i]);
                    datesFinish.push([item.get('dateFinish').slice(0, item.get('dateFinish').lastIndexOf("/") + 1), "20", item.get('dateFinish').slice(item.get('dateFinish').lastIndexOf("/") + 1)].join(""));
                }
                for (var i = 0; i < stmnts.length; i++) {
                    var item = new CertificateGoalStatus(stmnts[i]);
                    datesFinish.push([item.get('dateFinish').slice(0, item.get('dateFinish').lastIndexOf("/") + 1), "20", item.get('dateFinish').slice(item.get('dateFinish').lastIndexOf("/") + 1)].join(""));
                }

                datesFinish.sort(function (a, b) {
                    return new Date(b) - new Date(a);
                });

                var issueDate = new Date(datesFinish[0]);
            }
            else {
                var issueDate = "";/*new Date(Object.keys(certificates.models[0].get('users'))[0]);*/
            }

            if(issueDate != "") {
                var validPeriodType = certificates.models[0].get('validPeriod').valueType;
                var validDuration = certificates.models[0].get('validPeriod').value;
                if (validPeriodType.toLowerCase() != 'unlimited') {
                    var expirationDate = that.dateAdd(issueDate, validPeriodType, validDuration);
                    expirationDate = that.dateFormat(expirationDate);
                    that.model.set({expires: true, expirationDate: expirationDate});
                }

                issueDate = that.dateFormat(issueDate);
            }
            else {
                that.model.set({expires: true, expirationDate: ""});
            }

            that.model.set({issueDate: issueDate});

            var template = Mustache.to_html(jQuery('#transcriptCertificatesItemTemplate').html(), _.extend(that.model.toJSON(), that.language));
            that.$el.append(template);
        }
    });

    certificates.fetch({certificateID: this.model.id, language: this.language,
      success: function(){
          statuses.fetch({reset: true, certificateID: that.model.id, userID: jQuery('#transcriptUserID').val(),
              success: function(){
                  statements.fetch({
                      success: function(){
                          var goalView = new TranscriptCertificateGoalView({
                              certificates: certificates, statuses: statuses, statements: statements, certificateID: that.model.id, language: scormLanguageDataUser});
                          that.$el.find('#certificate-goal-list-' + that.model.id).append(goalView.render().el.innerHTML);
                      }
                  });
              }
          });
      }
    });

    return this;
  },

  dateAdd :function(date, interval, units) {
    var ret = new Date(date);
    switch(interval.toLowerCase()) {
        case 'year'      :  ret.setFullYear(ret.getFullYear() + units);  break;
        case 'quarter'   :  ret.setMonth(ret.getMonth() + 3*units);  break;
        case 'month'     :  ret.setMonth(ret.getMonth() + units);  break;
        case 'weeks'     :  ret.setDate(ret.getDate() + 7*units);  break;
        case 'days'      :  ret.setDate(ret.getDate() + units);  break;
        case 'hours'     :  ret.setTime(ret.getTime() + units*3600000);  break;
        case 'minutes'   :  ret.setTime(ret.getTime() + units*60000);  break;
        case 'seconds'   :  ret.setTime(ret.getTime() + units*1000);  break;
        case 'unlimited' :  ret = ""; break;
        default          :  ret = undefined;  break;
    }
    return ret;
  },

  dateFormat: function(date) {
      return (date.getDate() < 10 ? "0" : "") + date.getDate() + "/"
           + (date.getMonth() + 1) + "/"
           + date.getFullYear() + " "
           + (date.getHours() < 10 ? "0" : "") + date.getHours() + ":"
           + (date.getMinutes() < 10 ? "0" : "") + date.getMinutes();
  }
});


TranscriptCertificatesView = Backbone.View.extend({
  initialize: function (options) {
    this.language = options.language;
    this.render();
  },
  events: {
      'click #expandGoalsList.expand-icon': 'expandGoals'
  },

  render: function () {
    var template = Mustache.to_html(jQuery('#transcriptCertificatesTemplate').html(), _.extend(this.language));

    this.$el.append(template);
    this.collection.each(this.addOne, this);
  },

  addOne: function (item) {
    if (item.get('status') == 'Success' || item.get('status') == 'Overdue') {
        var view = new TranscriptCertificatesItemView({el: this.$el.find('#certificatesList>tbody'), language: this.language, model: item});
        this.$el.find('#certificatesList>tbody').append(view.render().el);

        item.get()
    }
  },
    expandGoals: function () {
        jQuery(arguments[0].target).closest('tr').next().toggleClass('hidden');
//        jQuery(arguments[0].target).closest('tr').next().find('.hidden').toggleClass('hidden');
//        jQuery(arguments[0].target).closest('tr').next().find('#certificateGoalsList').toggleClass('hidden');
        jQuery(arguments[0].target).toggleClass('expanded');
    }
});

GoalStatusView = Backbone.View.extend({
    initialize: function (options) {
        this.$el = jQuery('<tr style="background: #f2f2f2 !important;">');
        this.language = options.language;
        this.statements = options.statements;
        this.model = options.model;
        this.model.set({
            type: options.type,
            certificateID: options.certificateID,
            status: options.status,
            dateFinish: options.dateFinish
        });

        var obj = this.model.get('tincanStmntObj');
        var verb = this.model.get('tincanStmntVerb');

        if (options.type == GOAL_TYPE.STATEMENT) {
            this.statements.each(function(stmnt){
                for(var key in stmnt.get('object').definition.name) {
                    if(stmnt.get('object').id == obj) {
                        obj = stmnt.get('object').definition.name[key];
                    }
                }
            })

            this.model.set({title: (this.language[verb] != undefined ? this.language[verb] : this.language[this.model.get('tincanStmntVerb')])
                + ' ' + (obj != undefined ? obj : this.model.get('tincanStmntObj'))});
        }
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

TranscriptCertificateGoalView = Backbone.View.extend({
    initialize: function (options) {
        this.language = options.language;
        this.certificateID = options.certificateID;
        this.collection = options.certificates;
        this.statuses = options.statuses;
        this.statements = options.statements;
    },

    render: function() {
        var renderedTemplate = Mustache.to_html(jQuery('#certificateGoalsListTemplate').html(), _.extend(this.language));
        this.$el.append(renderedTemplate);

        this.addAll();

        return this;
    },

    addAll: function () {
        this.collection.each(
            function(item){
                if(item.get('courses').length > 0)
                    this.$el.find('#certificateCoursesTable').closest('div').toggleClass('hidden');
                if(item.get('statements').length > 0)
                    this.$el.find('#certificateStatementsTable').closest('div').toggleClass('hidden');
                if(item.get('activities').length > 0)
                    this.$el.find('#certificateActivitiesTable').closest('div').toggleClass('hidden');

                this.renderGoals(item.get('courses'), this.statuses.get('courses'), GOAL_TYPE.COURSE);
                this.renderGoals(item.get('statements'), this.statuses.get('statements'), GOAL_TYPE.STATEMENT);
                this.renderGoals(item.get('activities'), this.statuses.get('activities'), GOAL_TYPE.ACTIVITY);
            }, this);
    },

    renderGoals: function (goals, statuses, type) {
        if (goals != undefined) {
            for (var i = 0; i < goals.length; i++) {
                var params;
                var item = new CertificateGoalStatus(goals[i]);
                if (statuses != undefined) {
                    if (type == GOAL_TYPE.ACTIVITY) {
                        params = statuses.filter(function (i) {
                            return i.name == item.get('title')
                        }).map(function (i) {
                            return [i.status, i.dateFinish];
                        });
                        item.set({isActivity: true });
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
                }


                var view = new GoalStatusView({model: item, status: params[0][0], certificateID: this.certificateID, statements: this.statements, type: type, language: this.language, dateFinish: params[0][1]});

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
            }
        }
    }
});

var GOAL_TYPE = {
    COURSE: 1,
    STATEMENT: 2,
    ACTIVITY: 3
};