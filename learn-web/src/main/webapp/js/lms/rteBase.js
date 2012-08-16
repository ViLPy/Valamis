var SCORM2004_4API = function () {
    // attempt data
    this.attemptProgressStatus = null;
    this.attemptCompletionStatus = null;
    this.attemptCompletionAmount = null;

    this.isInitialized = false;
    this.isTerminated = false;
    this.diagnosticMessage = "";
    this.errorCode = "0";
    this.dataSet = new CMIDataModel();
    this.collectionData = [];
    this.currentPackageID = 0;
    this.currentActivityID = "";
    this.currentOrganizationID = "";
    this.adlNavRequest = "_none_";
    this.validNavRequests = "continue, previous, jump, choice, exit, exitAll, abandon, abandonAll";
    this.resetNeeded = false;

    // activity data
    this.isActivitySuspended = false;
    this.activityObjectives = [];
    this.primaryObjective = null;
};

SCORM2004_4API.prototype.doSyncRequest = function (url, methodType) {
    return window.LearnAjax.syncRequest(Utils.getContextPath() + url, methodType, {
        activityID:this.currentActivityID,
        packageID:this.currentPackageID,
        organizationID:this.currentOrganizationID
    });
};

SCORM2004_4API.prototype.isCollection = function (key) {
    return (key.indexOf('cmi.comments_from_learner') != -1) ||
        (key.indexOf('cmi.comments_from_lms') != -1) ||
        (key.indexOf('cmi.interactions') != -1) ||
        (key.indexOf('cmi.objectives') != -1) ||
        (key.indexOf('adl.data') != -1);
};

SCORM2004_4API.prototype.getOriginalKeyName = function (key) {
    return key.replace(/\.\d+\./g, ".n.");
};

SCORM2004_4API.prototype.Initialize = function (param) {
    if (this.resetNeeded) {
        this.resetState();
    }

    this.errorCode = "0";
    if (param == "") {
        var initResponse = this.doSyncRequest("/services/rte/Initialize", "POST");
        if (!initResponse.status) {
            this.errorCode = "102";
            return "false";
        }
        if ((!this.isInitialized) && (!this.isTerminated)) {
            this.dataSet.initValues(this.fetchDataModel());
            this.fetchCollections();
            this.initActivity();
            this.isInitialized = true;
            this.errorCode = "0";
            return "true";
        } else {
            if (this.isInitialized) {
                this.errorCode = "103";
            } else {
                this.errorCode = "104";
            }
        }
    } else {
        this.errorCode = "201";
    }
    return "false";
};

SCORM2004_4API.prototype.setActivity = function (packageID, organizationID, activityID) {
    this.currentPackageID = packageID;
    this.currentActivityID = activityID;
    this.currentOrganizationID = organizationID;

    this.resetNeeded = true;
};

SCORM2004_4API.prototype.initActivity = function () {
    var data = this.doSyncRequest("/services/rte/ActivityInformation/" + this.currentActivityID, "GET");

    this.isActivitySuspended = data.isActivitySuspended;
    this.activityObjectives = data.activityObjectives;
    this.attemptProgressStatus = data.attemptProgressStatus;
    this.attemptCompletionStatus = data.attemptCompletionStatus;
    this.attemptCompletionAmount = data.attemptCompletionAmount;
    this.primaryObjective = data.primaryObjective;
};

SCORM2004_4API.prototype.commitActivity = function () {
    window.LearnAjax.post(Utils.getContextPath() + "/services/rte/ActivityInformation/" + this.currentActivityID, {
        isActivitySuspended:this.isActivitySuspended,
        activityObjectives:this.activityObjectives,
        activityObjectivesCount:this.activityObjectives.length,
        attemptProgressStatus:this.attemptProgressStatus,
        attemptCompletionStatus:this.attemptCompletionStatus,
        attemptCompletionAmount:this.attemptCompletionAmount,
        primaryObjective:this.primaryObjective,
        activityID:this.currentActivityID,
        packageID:this.currentPackageID,
        organizationID:this.currentOrganizationID
    });
};

SCORM2004_4API.prototype.resetState = function () {
    this.isInitialized = false;
    this.isTerminated = false;
    this.diagnosticMessage = "";
    this.errorCode = "0";
    delete this.dataSet;
    this.dataSet = new CMIDataModel();
    this.collectionData = [];
    this.adlNavRequest = "_none_";
};

SCORM2004_4API.prototype.GetLastError = function () {
    return this.errorCode;
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
    if (this.diagnosticMessage != "") {
        return this.diagnosticMessage;
    }
    return "";
};

SCORM2004_4API.prototype.Terminate = function (param) {
    var result = "false";
    this.errorCode = "0";
    if (param == "") {
        if ((this.isInitialized) && (!this.isTerminated)) {
            this.resetNeeded = true;
            var requestResult = this.Commit();
            result = ('true' == requestResult) ? 'true' : 'false';
            this.errorCode = ('true' == result) ? '0' : '101';
            if ('true' == result) {
                this.isInitialized = false;
                this.isTerminated = true;
                if (this.adlNavRequest != '_none_') {
                    switch (this.adlNavRequest.replace(/{.+}/g, "")) {
                        case 'continue':
                            setTimeout('scormGetNext();', 200);
                            break;
                        case 'previous':
                            setTimeout('scormGetPrev();', 200);
                            break;
                        case 'choice':
                            break;
                        case 'jump':
                            var target = this.adlNavRequest.match(/{.+}/).toString().replace('{',"").replace('}',"").replace("target=","");
                            setTimeout('scormJump("'+target+'");', 200);
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
                 // TODO: decide is auto-continue needed
                 }*/
                // TOC update if needed will be here
            } else {
                this.diagnosticMessage = "Failure calling the Terminate remote callback: the server replied with HTTP Status " + result;
            }
        } else {
            if (this.isTerminated) {
                this.errorCode = "113";
            } else {
                this.errorCode = "112";
            }
        }
    } else {
        this.errorCode = "201";
    }
    return result;
};

window.API_1484_11 = new SCORM2004_4API();