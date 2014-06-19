/**
 * Student package table view - it locates in Student View,
 * displays content of package - statements with date, verb, object, result and review button
 */
StudentPackageTableView = Backbone.View.extend({
    events: {

    },

    initialize: function (options) {
        this.options = options;
        //this.$el = jQuery('<div>');
        //this.$el.attr("id", this.model.id);
        this.statements = this.model.statements;
    },

    render: function () {
        var template = Mustache.to_html(jQuery("#studentViewPackageContentTableTemplate").html(), _.extend(this.model, language));
        this.$el = jQuery(template);
        this.statements.forEach(this.addStatement, this);
        this.$el.hide();
        return this.$el;
    },

    addStatement: function (statement) {
        var view = new StudentPackageTableRowView({
            language: this.options.language,
            model: statement
        });
        this.$('#statementsGrid').append(view.render());
    }
});

StudentPackageTableRowView = Backbone.View.extend({
    events: {
        "click .more-button": "showMoreInfo"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQuery('<div>');
        //this.$el.attr("id", this.model.id);
    },

    render: function () {
        function escapeHTML(text) {
            var html = text + "";
            return html.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
        }

        function truncateString(str, length) {
            if (str === null || str.length < 4 || str.length <= length) {
                return str;
            }
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
                        answer = " with response '" + escapeHTML(truncateString(getResponseText(stmt), 30)) + "' ";
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
        statement.timestamp = this.model.timestamp ? moment(this.model.timestamp).format("YYYY-MM-DD HH:mm") : '';
        statement.actorName = (stmt.actor !== null ? escapeHTML(stmt.actor) : "No Actor");
        statement.objStr = ' "' + escapeHTML(stmt.target) + '"';
        statement.verbName = escapeHTML(verb);
        statement.resultGrade = result;
        statement.answer = answer !== null ? answer : "";
        statement.userResponse = (this.model.result && this.model.result.response) ? this.model.result.response : '';
        statement.correctResponse = this.model.object.definition.correctResponsesPattern.length ? this.model.object.definition.correctResponsesPattern : '';
        statement.more = (statement.resultGrade || statement.userResponse || statement.correctResponse) ? true : false;
        var template = Mustache.to_html(jQuery("#studentViewPackageContentRowTemplate").html(), _.extend(language, statement));
        this.$el.html(jQuery(template));
        this.$('#more-info-section').hide();
        return this.$el;
    },

    // Review modal
    showMoreInfo: function () {
        this.$('#more-info-section').slideToggle(500);
    }
});
