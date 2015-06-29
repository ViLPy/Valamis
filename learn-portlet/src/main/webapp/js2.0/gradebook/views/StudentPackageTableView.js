function escapeHTML(text) {
    var html = text + "";
    return html.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/<([^>]+)>/g, '');
}
function cleanHTML(text) {
    var html = text + "";
    return html.replace(/<[^>]+>/ig,"");
}

/**
 * Student package table view - it locates in Student View,
 * displays content of package - statements with date, verb, object, result and review button
 */
StudentPackageTableView = Backbone.View.extend({
    events: {
    },

    initialize: function (options) {
        this.options = options;
        this.statements = this.model.statements;
        this.views = {};
    },

    render: function () {
        var template = Mustache.to_html(jQueryValamis("#studentViewPackageContentTableTemplate").html(), _.extend(this.model, language));
        this.$el = jQueryValamis(template);
        this.statements.forEach(this.addStatement, this);
        this.$el.hide();
        setTimeout(this.loadComments.bind(this),200);
        return this.$el;
    },

    addStatement: function (statement) {
        var view = new StudentPackageTableRowView({
            language: this.options.language,
            activityIds: this.options.activityIds,
            model: statement
        });
        this.$('#statementsGrid').append(view.render());
        this.views[statement.id] = view;
    },

    loadComments: function() {
        var comments = [];
        this.options.activityIds.forEach(function (actId){
            var query = {
                params:{
                    verb: {id:TincanHelper.getVerbId('commented')},
                    activity: {id:actId},
                    related_activities: true,
                    ascending: true
                }
            };
            var result = TincanHelper.getStatements(query);
            result.statementsResult.statements.forEach(function (st){
                comments.push(st);
            }, this);
        }, this);

        comments.filter(function (st) {
            return st.target.objectType == 'StatementRef';
        });
        comments.forEach(function (comment){
            this.views[comment.id] = new CommentRowView({
                language: this.options.language,
                stmtRef: comment.target.id,
                stmt: comment,
                activityIds: this.options.activityIds,
                isNew: false
            });
            if(this.views[comment.target.id])
                this.views[comment.target.id].addComment(this.views[comment.id]);
        }, this);
    }
});

StudentPackageTableRowView = Backbone.View.extend({
    events: {
        "click .more-button": "showMoreInfo",
        "click .comment-link:first": "addNewComment",
        "click .show-comments": "showComments",
        "click .hide-comments": "hideComments"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQueryValamis('<div>');
        //this.$el.attr("id", this.model.id);
    },

    render: function () {


        function truncateString(str, length) {
            if (str === null || str.length < 4 || str.length <= length) {
                return str;
            }
            str = cleanHTML(str)
            return str.substr(0, length - 3) + '...';
        }

        function getResponseText(stmt) {

            var response,
                objDef,
                componentName = null,
                components,
                responses,
                responseStr = [],
                first = true,
                responseId,
                i,
                j,
                source,
                target,
                responseParts;

            if (stmt.result === null || stmt.result.response === null) {
                return "";
            }
            response = stmt.result.response;

            if (stmt.target === null ||
                stmt.target.objectType !== "Activity" ||
                stmt.target.definition === null ||
                stmt.target.definition.type !== "cmi.interaction" ||
                stmt.target.definition.interactionType === null
                ) {
                return response;
            }
            objDef = stmt.target.definition;

            // TODO: move the splitting on [,] of the values into TinCanJS
            if (objDef.interactionType === "matching") {
                if (objDef.source !== null &&
                    objDef.source.length > 0 &&
                    objDef.target !== null &&
                    objDef.target.length > 0
                    ) {
                    source = objDef.source;
                    target = objDef.target;

                    responses = response.split("[,]");

                    for (i = 0; i < responses.length; i += 1) {
                        responseParts = responses[i].split("[.]");

                        for (j = 0; j < source.length; j += 1) {
                            if (responseParts[0] === source[j].id) {
                                if (!first) {
                                    responseStr.push(", ");
                                }
                                responseStr.push(source[j].getLangDictionaryValue("description"));
                                first = false;
                            }
                        }
                        for (j = 0; j < target.length; j += 1) {
                            if (responseParts[1] === target[j].id) {
                                responseStr.push(" -> ");
                                responseStr.push(target[j].getLangDictionaryValue("description"));
                            }
                        }
                    }
                }
            } else {
                if (objDef.interactionType === "choice" || objDef.interactionType === "sequencing") {
                    componentName = "choices";
                }
                else if (objDef.interactionType === "likert") {
                    componentName = "scale";
                }
                else if (objDef.interactionType === "performance") {
                    componentName = "steps";
                }

                if (componentName !== null) {
                    components = objDef[componentName];

                    if (components !== null && components.length > 0) {
                        responses = response.split("[,]");

                        for (i = 0; i < responses.length; i += 1) {
                            for (j = 0; j < components.length; j += 1) {
                                responseId = responses[i];
                                if (objDef.interactionType === "performance") {
                                    responseId = responses[i].split("[.]")[0];
                                }
                                if (responseId === components[j].id) {
                                    if (!first) {
                                        responseStr.push(", ");
                                    }
                                    responseStr.push(components[j].getLangDictionaryValue("description"));

                                    if (objDef.interactionType === "performance") {
                                        responseStr.push(" -> ");
                                        responseStr.push(responses[i].split("[.]")[1]);
                                    }
                                    first = false;
                                }
                            }
                        }
                    }
                }
            }

            if (responseStr.length > 0) {
                return responseStr.join("");
            }

            return response;
        }

        var stmt = new TinCan.Statement(this.model);
        var verb, answer, result;
        if (stmt.context !== null &&
            stmt.context.extensions !== null &&
            typeof stmt.context.extensions.verb !== "undefined"
            ) {
            verb = stmt.context.extensions.verb;
        } else {
            verb = stmt.verb + "";
        }

        if (verb === "interacted") {
            verb = "interacted with";
        } else if (stmt.inProgress === true) {
            verb = verb + " (in progress)";
        }

        answer = null;

        if (typeof stmt.target.definition !== "undefined" && stmt.target.definition !== null) {
            activityType = stmt.target.definition.type;
            if (activityType !== null && (activityType === "question" || activityType.indexOf("interaction") >= 0)) {
                if (stmt.result !== null) {
                    if (stmt.result.success !== null) {
                        verb = (stmt.result.success ? "correctly " : "incorrectly ") + verb;
                    }
                    if (stmt.result.response !== null) {
                        answer = truncateString(getResponseText(stmt), 30);
                    }
                }
            }
        }

        if (stmt.result !== null && stmt.result.score !== null) {
            if (stmt.result.score.scaled !== null) {
                result = Math.round((stmt.result.score.scaled * 100.0)) + "%";
            } else if (stmt.result.score.raw !== null) {
                result = stmt.result.score.raw;
            }
        }


        var statement = new Object();
        statement.timestamp = this.model.stored ? moment(this.model.stored).format("YYYY-MM-DD HH:mm") : '';
        statement.actorName = (stmt.actor !== null ? escapeHTML(stmt.actor) : "No Actor");
        statement.objStr = ' "' + escapeHTML(stmt.target) + '"';
        statement.verbName = verb ? escapeHTML(verb) : escapeHTML(stmt.verb.id);
        statement.resultGrade = result;
        statement.score = (this.model.result && this.model.result.extensions && this.model.result.extensions['http://valamislearning.com/question/score']) ?
          this.model.result.extensions['http://valamislearning.com/question/score'] : '';
        statement.answer = answer !== null ? answer : "";
        statement.userResponse = (this.model.result && this.model.result.response) ? cleanHTML(this.model.result.response) : '';
        statement.correctResponse = this.model.object.definition.correctResponsesPattern.length ? cleanHTML(this.model.object.definition.correctResponsesPattern) : '';
        statement.more = (statement.resultGrade || statement.userResponse || statement.correctResponse) ? true : false;
        var template = Mustache.to_html(jQueryValamis("#studentViewPackageContentRowTemplate").html(), _.extend(language, statement));
        this.$el.html(jQueryValamis(template));
        this.$('#more-info-section').hide();
        return this.$el;
    },

    // Review modal
    showMoreInfo: function () {
        this.$('#more-info-section').slideToggle(500);
    },

    addNewComment: function () {
        this.showComments();
        var view = new CommentRowView({
            language: this.options.language,
            stmtRef: this.model.id,
            activityIds: this.options.activityIds,
            isNew: true
        });
        this.$('.comment-list:first').append(view.render());
        view.$el.slideDown(500);
        view.$('#comment').focus();
        view.on('countComment', this.countComments,this);
    },

    addComment: function (view) {
        this.$('.show-comments').show();
        this.$('.count-comments').show();
        this.$('.link-separator').show();
        this.$('.comment-list:first').append(view.render());
        view.on('countComment', this.countComments,this);
        this.countComments();
        view.$el.show();
    },

    hideComments: function () {
        if(!this.$('.comment-list:first').is(':visible'))
            return;
        this.$('.show-comments').show();
        this.$('.hide-comments').hide();
        this.$('.count-comments').show();
        this.$('.link-separator').show();
        this.$('.comment-list:first').slideUp(500);
    },

    showComments: function () {
        if(this.$('.comment-list:first').is(':visible'))
            return;
        this.$('.show-comments').hide();
        this.$('.hide-comments').show();
        this.$('.count-comments').show();
        this.$('.link-separator').show();
        this.$('.comment-list:first').slideDown(500);
    },

    countComments: function () {
        if(this.commentCount)
            this.commentCount++;
        else
            this.commentCount = 1;
        this.$('.count-comments').text(' ('+this.commentCount + ')');
    }
});


CommentRowView = Backbone.View.extend({
    events: {
        "click .comment-link:first": "addNewComment",
        "click .save-comment": "saveComment",
        "click .cancel-comment": "cancelComment"
    },

    initialize: function (options) {
        this.options = options;
        this.isNew = this.options.isNew;

        this.stmtRef=this.options.stmtRef;
        this.stmt = this.isNew?(new TinCan.Statement({
            actor: new TinCan.Agent(JSON.parse(jQueryValamis('#tincanActor').val())),
            verb: TincanHelper.createVerb('commented'),
            target: new TinCan.StatementRef({objectType:'StatementRef',id:this.stmtRef}),
            context: new TinCan.Context({contextActivities: {grouping:[{id:this.options.activityIds[0], objectType: 'Activity'}]}})
        })):this.options.stmt;

        this.comment = this.stmt.result?this.stmt.result.response:'';
    },

    render: function () {
        var statement = new Object();
        statement.timestamp = moment().format("YYYY-MM-DD HH:mm");
        statement.actorName = this.stmt.actor ? escapeHTML(this.stmt.actor) : "No Actor";
        statement.userComment = this.comment;
        var template = Mustache.to_html(jQueryValamis("#commentRowTemplate").html(), _.extend(this.options.language,
            {isNew:this.isNew},statement));
        this.$el.html(template);
        this.$el.hide();
        return this.$el;
    },

    addNewComment: function () {
        var view = new CommentRowView({
            language: this.options.language,
            stmtRef: this.stmt.id,
            activityIds: this.options.activityIds,
            isNew: true
        });
        this.$('.comment-list:first').append(view.render());
        view.on('countComment', function(){
            this.trigger('countComment');
        });
        this.trigger('countComment');
        view.$el.slideDown(500);
        view.$('#comment').focus();
    },

    addComment: function (view) {
        this.$('.comment-list:first').append(view.render());
        this.trigger('countComment');
        view.$el.show();
    },

    toggleMode: function() {
        this.isNew = !this.isNew;
        this.render();
        this.$el.show();
    },

    saveComment: function() {
        this.comment= this.$('#comment:first').val();
        this.stmt.result = new TinCan.Result({response:this.comment});
        this.sendCommentStatement();
        this.toggleMode();
        this.trigger('countComment');
    },

    cancelComment: function() {
        this.$el.remove();
    },

    sendCommentStatement: function() {
        TincanHelper.sendStatement(this.stmt);
    }
});