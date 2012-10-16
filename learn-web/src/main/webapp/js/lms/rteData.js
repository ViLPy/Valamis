SCORM2004_4API.prototype.Commit = function () {
    this.commitActivity();
    var packageID = this.currentPackageID;
    var activityID = this.currentActivityID;
    var postData = function (data) {
        var serialized = {};
        var index = 0;
        for (var key in data) {
            serialized["dataKey" + index] = key;
            serialized["dataValue" + index] = data[key];
            index++;
        }
        serialized["amount"] = index;
        serialized["packageID"] = packageID;
        serialized["activityID"] = activityID;
        return serialized;
    };
    window.LearnAjax.syncRequest(Utils.getContextPath() + "/services/rte/SetValues", "post", postData(this.dataSet.getAllFieldsData()));
    window.LearnAjax.syncRequest(Utils.getContextPath() + "/services/rte/SetValues", "post", postData(this.collectionData));
    return 'true';
};

SCORM2004_4API.prototype.fetchDataModel = function () {
    var baseData = this.doSyncRequest("/services/rte/GetValues");
    for (var key in baseData) {
        var fieldModel = this.dataSet.getField(this.getOriginalKeyName(key));
        // check is model field for given key exists
        if (fieldModel) {
            fieldModel.value = baseData[key];
        }
    }
};

SCORM2004_4API.prototype.fetchCollections = function () {
    var merge = function (obj1, obj2) {
        for (var attrName in obj2) {
            obj1[attrName] = obj2[attrName];
        }
    };

    var cmiInteractions = this.doSyncRequest("/services/rte/GetValue/cmi.interactions.");
    if (!cmiInteractions["cmi.interactions._count"]) {
        cmiInteractions["cmi.interactions._count"] = 0;
    }

    var cmiObjectives = this.doSyncRequest("/services/rte/GetValue/cmi.objectives.");
    if (!cmiObjectives["cmi.objectives._count"]) {
        cmiObjectives["cmi.objectives._count"] = 0;
    }

    var cmiCommentsFromLearner = this.doSyncRequest("/services/rte/GetValue/cmi.comments_from_learner.");
    if (!cmiCommentsFromLearner["cmi.comments_from_learner._count"]) {
        cmiCommentsFromLearner["cmi.comments_from_learner._count"] = 0;
    }

    var cmiCommentsFromLMS = this.doSyncRequest("/services/rte/GetValue/cmi.comments_from_lms.");
    if (!cmiCommentsFromLMS["cmi.comments_from_lms._count"]) {
        cmiCommentsFromLMS["cmi.comments_from_lms._count"] = 0;
    }

    var adlData = this.doSyncRequest("/services/rte/GetValue/adl.data.");
    if (!adlData["adl.data._count"]) {
        adlData["adl.data._count"] = 0;
    }

    merge(this.collectionData, cmiInteractions);
    merge(this.collectionData, cmiObjectives);
    merge(this.collectionData, cmiCommentsFromLearner);
    merge(this.collectionData, cmiCommentsFromLMS);
    merge(this.collectionData, adlData);
};

SCORM2004_4API.prototype.GetValue = function (key) {
    this.errorCode = "0";
    this.diagnosticMessage = "";
    if ((this.isInitialized) && (!this.isTerminated)) {
        if (key !== "") {
            var dataModelName = key.replace(/\.\d+\./g, ".n."); // match .n. patter for given element
            var fieldModel = this.dataSet.getField(dataModelName);
            // check is model field for given key exists
            if (!fieldModel) {
                this.errorCode = "301";
                this.diagnosticMessage = "Field " + key + " is not specified in DataModel";
                return "";
            }

            // field should be readable
            if (fieldModel.mod !== 'w') {
                if (this.isCollection(key)) { // collection value
                    if (this.collectionData[key] !== undefined && this.collectionData[key] !== null) {
                        return this.collectionData[key];
                    } else {
                        this.errorCode = "403";
                    }
                } else { // simple value
                    var response = "";
                    switch (key) {
                        case "cmi.completion_status":
                            response = this.cmiCompletionStatusUpdate();
                            break;
                        case "cmi.success_status":
                            response = this.cmiSuccessStatusUpdate();
                            break;
                        default:
                            if (fieldModel.value !== null && fieldModel.value !== undefined) {
                                response = fieldModel.value;
                            } else if (fieldModel.defaultValue !== null && fieldModel.defaultValue !== undefined) {
                                response = fieldModel.defaultValue;
                            } else {
                                this.errorCode = "403";
                            }
                            break;
                    }
                    return response;
                }
            } else {
                this.errorCode = "405";
            }
        } else {
            this.errorCode = "301";
        }
    } else {
        if (this.isTerminated) {
            this.errorCode = "123";
        } else {
            this.errorCode = "122";
        }
    }
    return "";
};

SCORM2004_4API.prototype.getIndices = function (source) {
    var parsed = [];
    var indexes = source.match(/\.\d+\./g); // match .n. patter for given element
    for (var i = 0; i < indexes.length; i++) {
        parsed.push(parseInt(indexes[i].split('.')[1])); // extract xx from ".xx."
    }

    return {
        primary:(parsed[0]),
        secondary:(parsed[1])
    };
};

SCORM2004_4API.prototype.setCollectionValueHelper = function (key, keyBase, index, value) {
    if (!(this.collectionData[keyBase + "._count"] >= 0)) {
        this.errorCode = "403";
        return "false";
    }
    var count = this.collectionData[keyBase + "._count"];
    if (count < index) {
        this.errorCode = "351";
        this.diagnosticMessage = "Data Model element collection set out of order!";
        return "false";
    } else if (count > index) {
        this.collectionData[key] = value;
    } else {
        ++count;
        this.collectionData[keyBase + "._count"] = count;
        this.collectionData[key] = value;
    }
    return "true";
};

SCORM2004_4API.prototype.setCollectionValue = function (key, value) {
    // checkers
    var isCommentsFromLearner = function (key) {
        return (key.indexOf('cmi.comments_from_learner') != -1);
    };

    var isCommentsFromLMS = function (key) {
        return (key.indexOf('cmi.comments_from_lms') != -1);
    };

    var isInteractions = function (key) {
        return (key.indexOf('cmi.interactions') != -1);
    };

    var isInteractionObjectives = function (key) {
        return isInteractions(key) && (key.indexOf('objectives') != -1);
    };

    var isInteractionCorrectResponses = function (key) {
        return isInteractions(key) && (key.indexOf('correct_responses') != -1);
    };

    var isObjectives = function (key) {
        return (key.indexOf('cmi.objectives') != -1);
    };

    var isAdlData = function (key) {
        return (key.indexOf('adl.data') != -1);
    };

    var parsedIndices = this.getIndices(key);
    var originalName = this.getOriginalKeyName(key);
    var fieldModel = this.dataSet.getField(originalName);
    if (!fieldModel) {
        this.errorCode = "301";
        this.diagnosticMessage = "Field " + key + " is not specified in DataModel";
        return "";
    }

    // if just rewrite old value
    if (this.collectionData[key] !== null && this.collectionData[key] !== undefined) {
        this.collectionData[key] = value;
    } else {
        // check is out of order, by standard there can be two levels of nesting
        if (isCommentsFromLearner(key)) {
            this.setCollectionValueHelper(key, "cmi.comments_from_learner", parsedIndices.primary, value);
        } else if (isCommentsFromLMS(key)) {
            this.setCollectionValueHelper(key, "cmi.comments_from_lms", parsedIndices.primary, value);
        } else if (isInteractions(key)) {
            var count = parseInt(this.collectionData["cmi.interactions._count"]);
            if (count < parsedIndices.primary) {
                this.errorCode = "351";
                this.diagnosticMessage = "Data Model element collection set out of order!";
                return "false";
            }
            if ((parsedIndices.primary === 0) && (parsedIndices.secondary !== undefined)) {
                this.collectionData["cmi.interactions._count"] = 1;
                this.collectionData["cmi.interactions." + parsedIndices.primary + ".objectives._count"] = 0;
                this.collectionData["cmi.interactions." + parsedIndices.primary + ".correct_responses._count"] = 0;
            }

            if (isInteractionObjectives(key)) {
                this.setCollectionValueHelper(key, "cmi.interactions." + parsedIndices.primary + ".objectives", parsedIndices.secondary, value);
            } else if (isInteractionCorrectResponses(key)) {
                this.setCollectionValueHelper(key, "cmi.interactions." + parsedIndices.primary + ".correct_responses", parsedIndices.secondary, value);
            } else {
                this.setCollectionValueHelper(key, "cmi.interactions", parsedIndices.primary, value);
                this.collectionData["cmi.interactions." + parsedIndices.primary + ".objectives._count"] = 0;
                this.collectionData["cmi.interactions." + parsedIndices.primary + ".correct_responses._count"] = 0;
            }

        } else if (isObjectives(key)) {
            this.setCollectionValueHelper(key, "cmi.objectives", parsedIndices.primary, value);
        } else if (isAdlData(key)) {
            this.setCollectionValueHelper(key, "adl.data", parsedIndices.primary, value);
        }
    }

    switch (originalName) {
        case "cmi.objectives.n.progress_measure":
            this.objectiveProgressMeasureImpacts(parsedIndices.primary, value);
            break;
        case "cmi.objectives.n.completion_status":
            this.objectiveCompletionStatusImpacts(parsedIndices.primary, value);
            break;
        case "cmi.objectives.n.success_status":
            this.objectiveSuccessStatusImpacts(parsedIndices.primary, value);
            break;
        case "cmi.objectives.n.score.scaled":
            this.objectiveScaledScoreImpacts(parsedIndices.primary, value);
            break;
    }

    return "";
};

SCORM2004_4API.prototype.SetValue = function (key, value) {
    if (key == "adl.nav.request") {
        // navigation request
        if (this.validNavRequests.indexOf(value.replace(/{.+}/g, "")) >= 0) {
            this.adlNavRequest = value;
        } else {
            this.errorCode = "351";
            return "";
        }
    } else {
        // handle collections
        var originalName = this.getOriginalKeyName(key);
        var fieldModel = this.dataSet.getField(originalName);
        if (!fieldModel) {
            this.errorCode = "301";
            this.diagnosticMessage = "Field " + key + " is not specified in DataModel";
            return "";
        }
        if (fieldModel.mod.indexOf("w") >= 0) { // can be written
            // TODO: also add validation
            if (this.isCollection(key)) {
                this.setCollectionValue(key, value);
            } else {
                this.dataSet.setFieldValue(originalName, value);
                switch (originalName) {
                    case "cmi.completion_threshold":
                        this.completionStatusImpacts(value);
                        break;
                    case "cmi.completion_status":
                        this.completionStatusImpacts(value);
                        break;
                    case "cmi.exit":
                        this.exitImpacts(value);
                        break;
                    case "cmi.score.scaled":
                        if (this.primaryObjective) this.primaryObjective.objectiveNormalizedMeasure = value;
                        this.cmiSuccessStatusUpdate();
                        break;
                    case "cmi.scaled_passing_score":
                        this.cmiSuccessStatusUpdate();
                        break;
                    case "cmi.progress_measure":
                        this.progressMeasureImpacts(value);
                        break;
                    case "cmi.success_status":
                        this.successStatusImpacts(value);
                        //this.cmiSuccessStatusUpdate();
                        break;
                }
            }
            return "true";
        } else {
            this.errorCode = "404";
        }
    }
    return "false";
};

SCORM2004_4API.prototype.completionStatusImpacts = function (newValue) {
    switch (newValue) {
        case "unknown":
            this.attemptProgressStatus = false;
            break;
        case "completed":
            this.attemptProgressStatus = true;
            this.attemptCompletionStatus = true;
            break;
        case "incomplete":
        case "not attempted":
            this.attemptProgressStatus = true;
            this.attemptCompletionStatus = false;
            break;
    }
    //this.cmiCompletionStatusUpdate();
};

SCORM2004_4API.prototype.exitImpacts = function (newValue) {
    switch (newValue) {
        case "time-out":
            // process an "Exit All" navigation request when the SCO is taken away
            break;
        case "suspend":
            this.isActivitySuspended = true;
            break;
        case "logout":
            // process an "Exit All" navigation request when the SCO is taken away
            break;
    }
};

SCORM2004_4API.prototype.progressMeasureImpacts = function (newValue) {
    if ((parseFloat(newValue) >= 0) && (parseFloat(newValue) <= 1)) {
        this.attemptCompletionAmount = newValue;
    } else {
        this.attemptCompletionAmount = "unknown";
    }
    this.cmiCompletionStatusUpdate();
};

SCORM2004_4API.prototype.successStatusImpacts = function (newValue) {
    switch (newValue) {
        case "unknown":
            var objectivesCount = parseInt(this.GetValue("cmi.objectives._count"));
            for (var i = 0; i < objectivesCount; i++) {
                var objectiveID = this.GetValue("cmi.objectives." + i + ".id");
                if (this.primaryObjective && this.primaryObjective.identifier == objectiveID) {
                    if (this.GetValue("cmi.objectives." + i + ".success_status")) {
                        this.primaryObjective.objectiveProgressStatus = false;
                    }
                    break;
                }
            }
            break;
        case "passed":
            if (this.primaryObjective) {
                this.primaryObjective.objectiveProgressStatus = true;
                this.primaryObjective.objectiveSatisfiedStatus = true;
            }
            break;
        case "failed":
            if (this.primaryObjective) {
                this.primaryObjective.objectiveProgressStatus = true;
                this.primaryObjective.objectiveSatisfiedStatus = false;
            }
            break;
    }
};

SCORM2004_4API.prototype.objectiveProgressMeasureImpacts = function (index, newValue) {
    var objectiveID = this.GetValue("cmi.objectives." + index + ".id");
    if (this.primaryObjective && this.primaryObjective.identifier == objectiveID) {
        if ((parseFloat(newValue) >= 0) && (parseFloat(newValue) <= 1)) {
            this.attemptCompletionAmount = newValue;
        } else {
            this.attemptCompletionAmount = "unknown";
        }
    }
};

SCORM2004_4API.prototype.objectiveCompletionStatusImpacts = function (index, newValue) {
    var objectiveID = this.GetValue("cmi.objectives." + index + ".id");
    if (this.primaryObjective && this.primaryObjective.identifier == objectiveID) {
        switch (newValue) {
            case "unknown":
                this.attemptProgressStatus = false;
                break;
            case "completed":
                this.attemptProgressStatus = true;
                this.attemptCompletionStatus = true;
                break;
            case "incomplete":
            case "not attempted":
                this.attemptProgressStatus = true;
                this.attemptCompletionStatus = false;
                break;
        }
    }
};

SCORM2004_4API.prototype.objectiveSuccessStatusImpacts = function (index, newValue) {
    var objectiveID = this.GetValue("cmi.objectives." + index + ".id");
    if (this.activityObjectives && this.activityObjectives[objectiveID]) {
        switch (newValue) {
            case "unknown":
                this.activityObjectives[objectiveID].objectiveProgressStatus = false;
                break;
            case "passed":
                this.activityObjectives[objectiveID].objectiveProgressStatus = true;
                this.activityObjectives[objectiveID].objectiveSatisfiedStatus = true;
                break;
            case "failed":
                this.activityObjectives[objectiveID].objectiveProgressStatus = true;
                this.activityObjectives[objectiveID].objectiveSatisfiedStatus = false;
                break;
        }
    }
};

SCORM2004_4API.prototype.objectiveScaledScoreImpacts = function (index, newValue) {
    var objectiveID = this.GetValue("cmi.objectives." + index + ".id");
    if (this.activityObjectives && this.activityObjectives[objectiveID]) {
        this.activityObjectives[objectiveID].objectiveMeasureStatus = true;
        this.activityObjectives[objectiveID].objectiveNormalizedMeasure = parseFloat(newValue);
    }
};

SCORM2004_4API.prototype.cmiCompletionStatusUpdate = function () {
    var response = "";
    var currentValue = this.dataSet.getField("cmi.completion_status").value;
    var threshold = this.dataSet.getField("cmi.completion_threshold").value;
    var progressMeasure = this.dataSet.getField("cmi.progress_measure").value;
    if (threshold === null || threshold === undefined) {
        response = (currentValue && currentValue != "") ? currentValue : "unknown";
    } else {
        if (progressMeasure === null || progressMeasure === undefined) {
            response = "unknown";
        } else {
            response = (parseFloat(progressMeasure) >= parseFloat(threshold)) ? "completed" : "incomplete";
        }
    }
    this.SetValue("cmi.completion_status", response);

    return response;
};

SCORM2004_4API.prototype.cmiSuccessStatusUpdate = function () {
    var response = "";
    var currentStatus = this.dataSet.getField("cmi.success_status").value;
    var scaledPassingScore = this.dataSet.getField("cmi.scaled_passing_score").value;
    var scaledScore = this.dataSet.getField("cmi.score.scaled").value;

    if (scaledPassingScore === null || scaledPassingScore === undefined) {
        response = (currentStatus && currentStatus != "") ? currentStatus : "unknown";
    } else {
        if (scaledScore === null || scaledScore === undefined) {
            response = "unknown";
        } else {
            response = (parseFloat(scaledPassingScore) >= parseFloat(scaledScore)) ? "failed" : "passed";
        }
    }
    this.SetValue("cmi.success_status", response);

    return response;
};