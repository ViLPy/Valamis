// SCORM RTE API
var SCORM2004_4API = (function () {
    // attempt data
    var attemptProgressStatus, attemptCompletionStatus, attemptCompletionAmount;

    var isInitialized, isTerminated, diagnosticMessage, errorCode;
    // activity data
    var currentPackageID, currentActivityID, currentOrganizationID;
    var isActivitySuspended;
    var activityObjectives;
    var dataModelSet;

    // data helpers
    function doSyncRequest(url, methodType) {
        return window.LearnAjax.syncRequest(Utils.getContextPath() + url, methodType, {
            activityID:currentActivityID,
            packageID:currentPackageID,
            organizationID:currentOrganizationID
        });
    }

    function fetchDataModel() {
        // TODO: fetch current data model state from server
    }

    function SCORM2004_4API() {
        isInitialized = false;
        isTerminated = false;
        diagnosticMessage = "";
        errorCode = "0";
        dataModelSet = new DataModelSet();
        currentPackageID = 0;
        currentActivityID = "";
        currentOrganizationID = "";
    }

    SCORM2004_4API.prototype.setActivity = function (packageID, organizationID, activityID, isSuspended, objectives) {
        currentPackageID = packageID;
        currentActivityID = activityID;
        currentOrganizationID = organizationID;
        isActivitySuspended = isSuspended;
        activityObjectives = objectives;
    };

    SCORM2004_4API.prototype.setAttempt = function (progressStatus, completionStatus, completionAmount) {
        attemptProgressStatus = progressStatus;
        attemptCompletionStatus = completionStatus;
        attemptCompletionAmount = completionAmount;
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
                dataModelSet.initValues(fetchDataModel());
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
                                setTimeout('scorm_get_next();', 500);
                                break;
                            case 'previous':
                                setTimeout('scorm_get_prev();', 500);
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
                var entityModel = dataModelSet.get(key);
                if (entityModel) {
                    var response = "";
                    switch (key) {
                        case "cmi.completion_status":
                            var currentValue = entityModel.getValue();
                            var threshold = dataModelSet.get("cmi.completion_threshold").getValue();
                            var progressMeasure = dataModelSet.get("cmi.progress_measure").getValue();
                            if (!threshold) {
                                response = (currentValue && currentValue != "") ? currentValue : "unknown";
                            } else {
                                response = (parseFloat(progressMeasure) >= parseFloat(threshold)) ? "completed" : "incomplete";
                            }
                            break;
                        default:
                            response = entityModel.getValue();
                            break;
                    }
                    errorCode = entityModel.getErrorCode();
                    diagnosticMessage = entityModel.getDiagnosticMessage();
                    return response;
                } else {
                    errorCode = "301";
                    diagnosticMessage = "Field " + key + " is not specified in DataModel";
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
            var entityModel = dataModelSet.get(key);
            if (entityModel) {
                entityModel.setValue(value);
                errorCode = entityModel.getErrorCode();
                diagnosticMessage = entityModel.getDiagnosticMessage();
            } else {
                errorCode = "301";
                diagnosticMessage = "Field " + key + " is not specified in DataModel";
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