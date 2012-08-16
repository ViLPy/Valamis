// SCORM RTE API
var SCORM2004_4API = (function () {
    var isInitialized = false;
    var isTerminated = false;
    var diagnosticMessage = "";
    var errorCode = "0";
    var dataModel = null;
    var currentActivityID = 0;
    var currentPackageID = 0;
    var currentOrganizationID = 0;

    var cmiCollections = [];
    var adlNavRequest = "_none_";
    var validNavRequests = "continue, previous, choice, exit, exitAll, abandon, abandonAll";

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

    var isCollection = function (key) {
        var index = key.match(/\.\d+\./g); // match .n. patter for given element
        return (index && index.join('') != "");
    };

    // replace indices for collection keys
    var getOriginalKeyName = function (key) {
        return key.replace(/\.\d+\./g, ".n.");
    };

    var getIndices = function (source) {
        var parsed = [];
        var indexes = source.match(/\.\d+\./g); // match .n. patter for given element
        for (var i = 0; i < indexes.length; i++) {
            parsed.push(parseInt(indexes[i].split('.')[1])); // extract xx from ".xx."
        }

        return {
            primary:(parsed[0] || null),
            secondary:(parsed[1] || null)
        };
    };

    var getCollectionValue = function (key) {
        var parsedIndices = getIndices(key);
        var normalizedKey = getOriginalKeyName(key);
        if (isCommentsFromLearner(key)) {
            switch (normalizedKey) {
                case "cmi.comments_from_learner.n.comment":
                case "cmi.comments_from_learner.n.location":
                case "cmi.comments_from_learner.n.timestamp":
                    var elementCount = cmiCollections["cmi.comments_from_learner._count"];
                    if (parsedIndices.primary < parseInt(elementCount)) {
                        var value = cmiCollections[key];
                        if (value !== undefined && value.length !== 0) {
                            return value;
                        } else {
                            errorCode = "403";
                        }
                    } else {
                        errorCode = "301";
                    }
                    break;
                default:
                    return cmiCollections[key];
                    break;
            }
        } else if (isCommentsFromLMS(key)) {
            switch (normalizedKey) {
                case "cmi.comments_from_lms.n.comment":
                case "cmi.comments_from_lms.n.location":
                case "cmi.comments_from_lms.n.timestamp":
                    var elementCount = cmiCollections["cmi.comments_from_learner._count"];
                    if (parsedIndices.primary < parseInt(elementCount)) {
                        var value = cmiCollections[key];
                        if (value !== undefined && value.length !== 0) {
                            return value;
                        } else {
                            errorCode = "403";
                        }
                    } else {
                        errorCode = "301";
                    }
                    break;
                default:
                    return cmiCollections[key];
                    break;
            }
        }
        return "";
    };

    var setCollectionValue = function (key, value) {
        var parsedIndices = getIndices(key);

        var setCollectionValueHelper = function (key, keyBase, index, value) {
            if (!(cmiCollections[keyBase + "._count"] >= 0)) {
                errorCode = "403";
                return "false";
            }
            var count = cmiCollections[keyBase + "._count"];
            if (count < index) {
                errorCode = "351";
                diagnosticMessage = "Data Model element collection set out of order!";
                return "false";
            } else if (count > index) {
                cmiCollections[key] = value;
            } else {
                ++count;
                cmiCollections[keyBase + "._count"] = count;
                cmiCollections[key] = value;
            }
            return "true";
        };

        var originalName = getOriginalKeyName(key);
        var fieldModel = dataModel.getField(originalName);
        if (!fieldModel) {
            errorCode = "301";
            diagnosticMessage = "Field " + key + " is not specified in DataModel";
            return "";
        }

        // if just rewrite old value
        if (cmiCollections[key]) {
            cmiCollections[key] = value;
        } else {
            // check is out of order, by standard there can be two levels of nesting
            if (isCommentsFromLearner(key)) {
                setCollectionValueHelper(key, "cmi.comments_from_learner", parsedIndices.primary, value);
            } else if (isCommentsFromLMS(key)) {
                setCollectionValueHelper(key, "cmi.comments_from_lms", parsedIndices.primary, value);
            } else if (isInteractions(key)) {
                var count = parseInt(cmiCollections["cmi.interactions._count"]);
                if (count < parsedIndices.primary) {
                    errorCode = "351";
                    diagnosticMessage = "Data Model element collection set out of order!";
                    return "false";
                }
                if ((parsedIndices.primary === 0) && (parsedIndices.length > 1)) {
                    cmiCollections["cmi.interactions._count"] = 1;
                    cmiCollections["cmi.interactions." + parsedIndices.primary + ".objectives._count"] = 0;
                    cmiCollections["cmi.interactions." + parsedIndices.primary + ".correct_responses._count"] = 0;
                }

                if (isInteractionObjectives(key)) {
                    setCollectionValueHelper(key, "cmi.interactions." + parsedIndices.primary + ".objectives", parsedIndices.secondary, value);
                } else if (isInteractionCorrectResponses(key)) {
                    setCollectionValueHelper(key, "cmi.interactions." + parsedIndices.primary + ".correct_responses", parsedIndices.secondary, value);
                } else {
                    setCollectionValueHelper(key, "cmi.interactions", parsedIndices.primary, value);
                    cmiCollections["cmi.interactions." + parsedIndices.primary + ".objectives._count"] = 0;
                    cmiCollections["cmi.interactions." + parsedIndices.primary + ".correct_responses._count"] = 0;
                }

            } else if (isObjectives(key)) {
                setCollectionValueHelper(key, "cmi.objectives", parsedIndices.primary, value);
            }
        }

        return "";
    };

    // data helpers
    var doSyncRequest = function (url, methodType) {
        return window.LearnAjax.syncRequest(Utils.getContextPath() + url, methodType, {
            activityID:currentActivityID,
            packageID:currentPackageID,
            organizationID:currentOrganizationID
        });
    };

    var fetchCollections = function () {
        var merge = function (obj1, obj2) {
            for (var attrName in obj2) {
                obj1[attrName] = obj2[attrName];
            }
        };

        var cmiInteractions = doSyncRequest("/services/rte/GetValue/cmi.interactions");
        if (!cmiInteractions["cmi.interactions._count"]) cmiInteractions["cmi.interactions._count"] = 0;
        var cmiObjectives = doSyncRequest("/services/rte/GetValue/cmi.objectives");
        if (!cmiObjectives["cmi.objectives._count"]) cmiObjectives["cmi.objectives._count"] = 0;
        var cmiCommentsFromLearner = doSyncRequest("/services/rte/GetValue/cmi.comments_from_learner");
        if (!cmiCommentsFromLearner["cmi.comments_from_learner._count"]) cmiCommentsFromLearner["cmi.comments_from_learner._count"] = 0;
        var cmiCommentsFromLMS = doSyncRequest("/services/rte/GetValue/cmi.comments_from_lms");
        if (!cmiCommentsFromLMS["cmi.comments_from_lms._count"]) cmiCommentsFromLMS["cmi.comments_from_lms._count"] = 0;
        merge(cmiCollections, cmiInteractions);
        merge(cmiCollections, cmiObjectives);
        merge(cmiCollections, cmiCommentsFromLearner);
        merge(cmiCollections, cmiCommentsFromLMS);
    };

    var storeData = function () {
        var post = function (data) {
            for (var key in data) {
                window.LearnAjax.post(Utils.getContextPath() + "/services/rte/SetValue", {
                    packageID:currentPackageID,
                    key:key,
                    value:data[key]
                });
            }
        };
        post(dataModel.getAllFieldsData());
        post(cmiCollections);
        return 'true';
    };

    function SCORM2004_4API() {
    }

    SCORM2004_4API.prototype.setActivityID = function (packageID, organizationID, activityID) {
        currentPackageID = packageID;
        currentActivityID = activityID;
        currentOrganizationID = organizationID;
    };

    SCORM2004_4API.prototype.resetTermination = function () {
        isTerminated = false;
    };

    SCORM2004_4API.prototype.Initialize = function (param) {
        errorCode = "0";
        if (param == "") {
            var initResponse = doSyncRequest("/services/rte/Initialize", "POST");
            if (!initResponse.status) {
                errorCode = "102";
                return "false";
            }
            if ((!isInitialized) && (!isTerminated)) {
                // TODO: implement session initialization or not? maybe we can use ActivityID and userID to determine current attempt
                fetchCollections();
                dataModel = new CMIDataModel(/*init values*/);

                isInitialized = true;
                errorCode = "0";
                return "true";
            } else {
                if (isInitialized) {
                    errorCode = "103";
                } else {
                    errorCode = "104";
                }
            }
        } else {
            errorCode = "201";
        }
        return "false";
    };

    SCORM2004_4API.prototype.Terminate = function (param) {
        errorCode = "0";
        if (param == "") {
            if ((isInitialized) && (!isTerminated)) {
                var requestResult = storeData();
                var result = ('true' == requestResult) ? 'true' : 'false';
                errorCode = ('true' == result) ? '0' : '101';
                if ('true' == result) {
                    isInitialized = false;
                    isTerminated = true;
                    if (adlNavRequest != '_none_') {
                        switch (adlNavRequest) {
                            case 'continue':
                                setTimeout('scormGetNext();', 500);
                                break;
                            case 'previous':
                                setTimeout('scormGetPrev();', 500);
                                break;
                            case 'choice':
                                break;
                            case 'exit':
                                break;
                            case 'exitAll':
                                break;
                            case 'abandon':
                                break;
                            case 'abandonAll':
                                break;
                            default:
                                break;
                        }
                    }
                    /*else {
                     // TODO: decide is autocontine needed
                     }*/
                    // TOC update if needed will be here
                } else {
                    diagnosticMessage = "Failure calling the Terminate remote callback: the server replied with HTTP Status " + RequestResult;
                }
                return result;
            } else {
                if (isTerminated) {
                    errorCode = "113";
                } else {
                    errorCode = "112";
                }
            }
        } else {
            errorCode = "201";
        }
        return "false";
    };

    SCORM2004_4API.prototype.GetValue = function (key) {
        errorCode = "0";
        diagnosticMessage = "";
        if ((isInitialized) && (!isTerminated)) {
            if (key !== "") {
                var dataModelName = key.replace(/\.\d+\./g, ".n."); // match .n. patter for given element

                var fieldModel = dataModel.getField(dataModelName);
                // check is model field for given key exists
                if (!fieldModel) {
                    errorCode = "301";
                    diagnosticMessage = "Field " + key + " is not specified in DataModel";
                    return "";
                }

                // field should be readable
                if (fieldModel.mod !== 'w') {

                    if (isCollection(key)) { // collection value
                        return cmiCollections[key];
                    } else { // simple value
                        var response = "";
                        switch (key) {
                            case "cmi.completion_status":
                                var currentValue = fieldModel.getValue();
                                var threshold = dataModel.getField("cmi.completion_threshold").getValue();
                                var progressMeasure = dataModel.getField("cmi.progress_measure").getValue();
                                if (!threshold) {
                                    response = (currentValue && currentValue != "") ? currentValue : "unknown";
                                } else {
                                    response = (parseFloat(progressMeasure) >= parseFloat(threshold)) ? "completed" : "incomplete";
                                }
                                break;
                            default:
                                if (fieldModel.value) {
                                    return fieldModel.value;
                                } else if (fieldModel.defaultValue) {
                                    return fieldModel.defaultValue;
                                } else {
                                    errorCode = "403";
                                }
                                break;
                        }
                    }
                } else {
                    errorCode = "405";
                }
            } else {
                errorCode = "301";
            }
        } else {
            if (isTerminated) {
                errorCode = "123";
            } else {
                errorCode = "122";
            }
        }
        return "";
    };

    SCORM2004_4API.prototype.SetValue = function (key, value) {
        if (key == "adl.nav.request") {
            // navigation request
            if (validNavRequests.indexOf(value) >= 0) {
                adlNavRequest = value;
            } else {
                errorCode = "351";
                return "";
            }
        } else {
            // handle collections
            var originalName = getOriginalKeyName(key)
            var fieldModel = dataModel.getField(originalName);
            if (!fieldModel) {
                errorCode = "301";
                diagnosticMessage = "Field " + key + " is not specified in DataModel";
                return "";
            }
            if (fieldModel.mod.indexOf("w") >= 0) { // can be written
                // TODO: also add validation
                if (isCollection(key)) {
                    setCollectionValue(key, value);
                } else {
                    dataModel.setFieldValue(originalName, value);
                }
            } else {
                errorCode = "404";
            }
        }
        return "";
    };

    SCORM2004_4API.prototype.Commit = function () {
        storeData();
    };

    SCORM2004_4API.prototype.GetLastError = function () {
        return errorCode;
    };

    SCORM2004_4API.prototype.GetErrorString = function (code) {
        var errorString = "";
        switch (code) {
            case "0":
                errorString = "No error";
                break;
            case "101":
                errorString = "General exception";
                break;
            case "102":
                errorString = "General Inizialization Failure";
                break;
            case "103":
                errorString = "Already Initialized";
                break;
            case "104":
                errorString = "Content Instance Terminated";
                break;
            case "111":
                errorString = "General Termination Failure";
                break;
            case "112":
                errorString = "Termination Before Inizialization";
                break;
            case "113":
                errorString = "Termination After Termination";
                break;
            case "122":
                errorString = "Retrieve Data Before Initialization";
                break;
            case "123":
                errorString = "Retrieve Data After Termination";
                break;
            case "132":
                errorString = "Store Data Before Inizialization";
                break;
            case "133":
                errorString = "Store Data After Termination";
                break;
            case "142":
                errorString = "Commit Before Inizialization";
                break;
            case "143":
                errorString = "Commit After Termination";
                break;
            case "201":
                errorString = "General Argument Error";
                break;
            case "301":
                errorString = "General Get Failure";
                break;
            case "351":
                errorString = "General Set Failure";
                break;
            case "391":
                errorString = "General Commit Failure";
                break;
            case "401":
                errorString = "Undefinited Data Model";
                break;
            case "402":
                errorString = "Unimplemented Data Model Element";
                break;
            case "403":
                errorString = "Data Model Element Value Not Initialized";
                break;
            case "404":
                errorString = "Data Model Element Is Read Only";
                break;
            case "405":
                errorString = "Data Model Element Is Write Only";
                break;
            case "406":
                errorString = "Data Model Element Type Mismatch";
                break;
            case "407":
                errorString = "Data Model Element Value Out Of Range";
                break;
            case "408":
                errorString = "Data Model Dependency Not Established";
                break;
            default:
                errorString = code + " is unexpected error! Please contact the administrator";
                break;
        }
        return errorString;
    };

    SCORM2004_4API.prototype.GetDiagnostic = function (param) {
        if (diagnosticMessage != "") {
            return diagnosticMessage;
        }
        return "";
    };

    return SCORM2004_4API;
})();

window.API_1484_11 = new SCORM2004_4API();