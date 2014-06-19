SCORM12API.prototype.LMSCommit = function () {
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
    window.LearnAjax.syncRequest(Utils.getContextPath() + "services/rte/SetValues", "post", postData(this.dataSet.getAllFieldsData()));
    window.LearnAjax.syncRequest(Utils.getContextPath() + "services/rte/SetValues", "post", postData(this.collectionData));
    return 'true';
};

SCORM12API.prototype.fetchDataModel = function () {
    var baseData = this.doSyncRequest("services/rte/GetValues");
    for (var key in baseData) {
        var fieldModel = this.dataSet.getField(this.getOriginalKeyName(key));
        // check is model field for given key exists
        if (fieldModel) {
            fieldModel.value = baseData[key];
        }
    }
};

SCORM12API.prototype.fetchCollections = function () {
    var merge = function (obj1, obj2) {
        for (var attrName in obj2) {
            obj1[attrName] = obj2[attrName];
        }
    };

    var cmiInteractions = this.doSyncRequest("services/rte/GetValue/cmi.interactions.");
    if (!cmiInteractions["cmi.interactions._count"]) {
        cmiInteractions["cmi.interactions._count"] = 0;
    }

    var cmiObjectives = this.doSyncRequest("services/rte/GetValue/cmi.objectives.");
    if (!cmiObjectives["cmi.objectives._count"]) {
        cmiObjectives["cmi.objectives._count"] = 0;
    }

    merge(this.collectionData, cmiInteractions);
    merge(this.collectionData, cmiObjectives);
};

SCORM12API.prototype.LMSGetValue = function (key) {
    this.errorCode = "0";
    this.diagnosticMessage = "";
    if ((this.isInitialized) && (!this.isTerminated)) {
        if (key !== "") {
            var dataModelName = key.replace(/\.\d+\./g, ".n."); // match .n. patter for given element
            var fieldModel = this.dataSet.getField(dataModelName);
            // check is model field for given key exists
            if (!fieldModel) {
                this.errorCode = "401";
                this.diagnosticMessage = "Field " + key + " is not specified in DataModel";
                return "";
            }

            // field should be readable
            if (fieldModel.mod !== 'w') {
                if (this.isCollection(key)) { // collection value
                    if (this.collectionData[key] !== undefined && this.collectionData[key] !== null) {
                        return this.collectionData[key];
                    } else {
                        this.errorCode = "301";
                    }
                } else { // simple value
                    var response = "";
                    if (fieldModel.value !== null && fieldModel.value !== undefined) {
                        response = fieldModel.value;
                    } else if (fieldModel.defaultValue !== null && fieldModel.defaultValue !== undefined) {
                        response = fieldModel.defaultValue;
                    } else {
                        this.errorCode = "301";
                    }
                    return response;
                }
            } else {
                this.errorCode = "404";
            }
        } else {
            this.errorCode = "401";
        }
    } else {
        if (this.isTerminated) {
            this.errorCode = "101";
            this.diagnosticMessage = "RTE Session is terminated";
        } else {
            this.diagnosticMessage = "RTE Session is not initialized";
            this.errorCode = "101";
        }
    }
    return "";
};

SCORM12API.prototype.getIndices = function (source) {
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

SCORM12API.prototype.setCollectionValueHelper = function (key, keyBase, index, value) {
    if (!(this.collectionData[keyBase + "._count"] >= 0)) {
        this.errorCode = "401";
        return "false";
    }
    var count = this.collectionData[keyBase + "._count"];
    if (count < index) {
        this.errorCode = "101";
        this.diagnosticMessage = "Data Model element collection set out of order!";
        return "false";
    } else if (count > index) {
        this.collectionData[key] = value;
        SCORMtoTinCanHandler("SetValue",key,value);
    } else {
        ++count;
        this.collectionData[keyBase + "._count"] = count;
        this.collectionData[key] = value;
        SCORMtoTinCanHandler("SetValue",keyBase + "._count",count);
        SCORMtoTinCanHandler("SetValue",key,value);
    }
    return "true";
};

SCORM12API.prototype.setCollectionValue = function (key, value) {
    // checkers
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
        SCORMtoTinCanHandler("SetValue",key,value);
    } else {
        // check is out of order, by standard there can be two levels of nesting
        if (isInteractions(key)) {
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
                SCORMtoTinCanHandler("SetValue","cmi.interactions._count",1);
                SCORMtoTinCanHandler("SetValue","cmi.interactions." + parsedIndices.primary + ".objectives._count",0);
                SCORMtoTinCanHandler("SetValue","cmi.interactions." + parsedIndices.primary + ".correct_responses._count",0);
            }

            if (isInteractionObjectives(key)) {
                this.setCollectionValueHelper(key, "cmi.interactions." + parsedIndices.primary + ".objectives", parsedIndices.secondary, value);
            } else if (isInteractionCorrectResponses(key)) {
                this.setCollectionValueHelper(key, "cmi.interactions." + parsedIndices.primary + ".correct_responses", parsedIndices.secondary, value);
            } else {
                this.setCollectionValueHelper(key, "cmi.interactions", parsedIndices.primary, value);
                this.collectionData["cmi.interactions." + parsedIndices.primary + ".objectives._count"] = 0;
                this.collectionData["cmi.interactions." + parsedIndices.primary + ".correct_responses._count"] = 0;
                SCORMtoTinCanHandler("SetValue","cmi.interactions." + parsedIndices.primary + ".objectives._count",0);
                SCORMtoTinCanHandler("SetValue","cmi.interactions." + parsedIndices.primary + ".correct_responses._count",0);
            }
            SetInteractionIndex(parsedIndices.primary);
        } else if (isObjectives(key)) {
            this.setCollectionValueHelper(key, "cmi.objectives", parsedIndices.primary, value);
        }
    }

    return "";
};

SCORM12API.prototype.LMSSetValue = function (key, value) {
    // handle collections
    var originalName = this.getOriginalKeyName(key);
    var fieldModel = this.dataSet.getField(originalName);
    if (!fieldModel) {
        this.errorCode = "301";
        this.diagnosticMessage = "Field " + key + " is not specified in DataModel";
        return "";
    }
    if (fieldModel.mod.indexOf("w") >= 0) { // can be written
        if (this.isCollection(key)) {
            this.setCollectionValue(key, value);
        } else {
            this.dataSet.setFieldValue(originalName, value);
            switch (originalName) {
                case "cmi.core.exit":
                    this.exitImpacts(value);
                    break;
                case "cmi.core.lesson_status":
                    this.lessonStatusImpacts(value);
                    break;
            }
        }
        return "true";
    } else {
        this.errorCode = "404";
    }
    return "false";
};

SCORM12API.prototype.exitImpacts = function (newValue) {
    switch (newValue) {
        case "":
        case "time-out":
        case "logout":
            this.dataSet.setFieldValue('cmi.core.entry', '');
            break;
        case "suspend":
            this.dataSet.setFieldValue('cmi.core.entry', 'resume');
            break;
    }
};

SCORM12API.prototype.lessonStatusImpacts = function (newValue) {
    if (newValue == "completed") {
        var masteryScore = this.LMSGetValue('cmi.student_data.mastery_score');
        var rawScore = this.LMSGetValue('cmi.student_data.mastery_score');
        if (masteryScore !== '' && rawScore !== '') {
            if (parseInt(rawScore) >= parseInt(masteryScore)) {
                this.dataSet.setFieldValue('cmi.core.lesson_status', 'passed');
            }
        }
    }
};