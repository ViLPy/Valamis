// SCORM 1.2
var SCORM12API = function () {
    this.isInitialized = false;
    this.isTerminated = false;
    this.diagnosticMessage = "";
    this.errorCode = "0";
    this.dataSet = new CMIDataModel12();
    this.collectionData = [];
    this.currentPackageID = 0;
    this.currentActivityID = "";
    this.currentOrganizationID = "";
    this.resetNeeded = false;
    this.silentFinish = false;
    this.navTimeout = null;
};

SCORM12API.prototype.doSyncRequest = function (url, methodType) {
    return window.LearnAjax.syncRequest(path.root + url, methodType, {
        activityID:this.currentActivityID,
        packageID:this.currentPackageID,
        organizationID:this.currentOrganizationID
    });
};

SCORM12API.prototype.isCollection = function (key) {
    return (key.indexOf('cmi.interactions') != -1) || (key.indexOf('cmi.objectives') != -1);
};

SCORM12API.prototype.getOriginalKeyName = function (key) {
    return key.replace(/\.\d+\./g, ".n.");
};

SCORM12API.prototype.LMSInitialize = function (param) {
    clearTimeout(this.navTimeout);
    this.silentFinish = false;
    if (this.resetNeeded) {
        this.resetState();
    }

    this.errorCode = "0";
    if (param == "") {
        var initResponse = this.doSyncRequest(path.rte + "Initialize", "POST");
        if (!initResponse.status) {
            this.errorCode = "101";
            this.diagnosticMessage = "Failure while service initialization";
            return "false";
        }
        if ((!this.isInitialized) && (!this.isTerminated)) {
            SCORMtoTinCanHandler("Initialize");
            this.dataSet.initValues(this.fetchDataModel());
            this.fetchCollections();
            this.isInitialized = true;
            this.errorCode = "0";
            return "true";
        } else {
            if (this.isInitialized) {
                this.diagnosticMessage = "Service is already initialized";
                this.errorCode = "101";
            } else {
                this.diagnosticMessage = "Service is terminated";
                this.errorCode = "101";
            }
        }
    } else {
        this.errorCode = "201";
    }
    return "false";
};

SCORM12API.prototype.setActivity = function (packageID, organizationID, activityID) {
    this.currentPackageID = packageID;
    this.currentActivityID = activityID;
    this.currentOrganizationID = organizationID;

    this.resetNeeded = true;
};

SCORM12API.prototype.resetState = function () {
    this.isInitialized = false;
    this.isTerminated = false;
    this.diagnosticMessage = "";
    this.errorCode = "0";
    delete this.dataSet;
    this.dataSet = new CMIDataModel12();
    this.collectionData = [];
};

SCORM12API.prototype.LMSGetLastError = function () {
    return this.errorCode;
};

SCORM12API.prototype.LMSGetErrorString = function (code) {
    var errorString = "";
    switch (code) {
        case "0":
            errorString = "No error";
            break;
        case "101":
            errorString = "General exception";
            break;
        case "201":
            errorString = "Invalid Argument Error";
            break;
        case "202":
            errorString = "Element cannot have children";
            break;
        case "203":
            errorString = "Element not an array. Cannot have count.";
            break;
        case "301":
            errorString = "Not initialized";
            break;
        case "401":
            errorString = "Not implemented error";
            break;
        case "402":
            errorString = "Invalid set value, element is a keyword";
            break;
        case "403":
            errorString = "Element is read only";
            break;
        case "404":
            errorString = "Element is write only";
            break;
        case "405":
            errorString = "Incorrect data type";
            break;
        default:
            errorString = code + " is unexpected error! Please contact the administrator";
            break;
    }
    return errorString;
};

SCORM12API.prototype.LMSGetDiagnostic = function (param) {
    if (this.diagnosticMessage != "") {
        return this.diagnosticMessage;
    }
    return "";
};

SCORM12API.prototype.LMSFinish = function (param) {
    var result = "false";
    this.errorCode = "0";
    if (param == "") {
        if ((this.isInitialized) && (!this.isTerminated)) {
            this.resetNeeded = true;
            var requestResult = this.LMSCommit();
            result = ('true' == requestResult) ? 'true' : 'false';
            this.errorCode = ('true' == result) ? '0' : '101';
            if ('true' == result) {
                this.isInitialized = false;
                this.isTerminated = true;
                SCORMtoTinCanHandler("Terminate");
                if (!this.silentFinish) this.navTimeout = setTimeout('scormGetNext();', 500);
            } else {
                this.diagnosticMessage = "Failure calling the Terminate remote callback: the server replied with HTTP Status " + result;
            }
        } else {
            if (this.isTerminated) {
                this.errorCode = "101";
                this.diagnosticMessage = "Already terminated";
            } else {
                this.errorCode = "101";
                this.diagnosticMessage = "Cannot terminate if not initialized";
            }
        }
    } else {
        this.errorCode = "201";
    }
    return result;
};

SCORM12API.prototype.silenceFinish = function(){
    this.silentFinish = true;
};

window.API = new SCORM12API();