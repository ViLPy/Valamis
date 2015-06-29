var TranscriptModel = Backbone.Model.extend({
    defaults: {
    }
}).extend();

UserCertificateCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read': {
            'path': function () {
                return path.api.users
                    + jQuery('#transcriptUserID').val()
                    + '/certificates';
            },
            'data': function () {
                return {
                    companyID: jQuery('#transcriptCompanyID').val(),
                    page: 0,
                    count: 1,
                    isOnlyPublished: true,
                    courseId: Utils.getCourseId()
                }

            }
        },
        'method': 'get'
    }
});


var UserCertificateCollection = Backbone.Collection.extend({
    model: TranscriptModel,
    parse: function (response) {
        return response.records;
    }
}).extend(UserCertificateCollectionService);

// ####

UserCoursesCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read':{
            'path':function () {
                return path.api.users
                    + jQuery('#transcriptUserID').val()
                    + '/courses';
            },
            'method': 'get'
        }
    }
});

var UserCoursesCollection = Backbone.Collection.extend({
    model: TranscriptModel
}).extend(UserCoursesCollectionService);

// ####

PackagesCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read': {
            'path': path.api.gradebooks,
            'data': function (e, options) {
                return {
                    action: "GRADES",
                    studyCourseId: options.courseId,
                    courseId: Utils.getCourseId(),
                    studentId: jQuery('#transcriptUserID').val(),
                    page: "0",
                    count: "1"
                }
            },
            'method': 'get'

        }
    }
});

var PackagesCollection = Backbone.Collection.extend({
    model: TranscriptModel,
    parse: function (response) {
        this.trigger('packageCollection:updated', {totalGrade: response.gradeTotal});
        return response.packageGrades;
    }
}).extend(PackagesCollectionService);

CertificateGoalCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read': {
            'path': function (e, options) {
                return path.api.certificates + options.certificateID;
            },
            'data': function (e, options) {
                return {
                    action: 'GETBYID',
                    courseId: Utils.getCourseId()
                }
            },
            'method': 'get'
        }
    }
});

var CertificateModel = Backbone.Model.extend({
    defaults: {
    }
}).extend();

var CertificateCollection = Backbone.Collection.extend({
    model: TranscriptModel,
    parse: function (response) {
        return response.records;
    }
}).extend(UserCertificateCollectionService);

var CertificateGoalCollection = Backbone.Collection.extend({
    model: CertificateModel,
    parse: function (response) {
        return response;
    }
}).extend(CertificateGoalCollectionService);

var StatementModel = Backbone.Model.extend({
    defaults: {}
});

var CertificateGoalStatusService = new Backbone.Service({ url: path.root,
    sync: {
        'read': {
            path: function (e, options) {
                return path.api.users + jQuery('#transcriptUserID').val() + '/certificates/' + options.certificateID + '/goals';
            },
            'method': 'get'
        }
    }
});

var CertificateGoalStatus = Backbone.Model.extend({
    defaults: {
        id: 0,
        isActivity: false,
        selected: false,
        value: "",
        title: "",
        validPeriod: ""
    }
}).extend(CertificateGoalStatusService)

// Pass amount=0 for filtered statements; amount=-1 for ALL statements
StatementModelCollectionService = new Backbone.Service({ url: '/',
    sync: {
        'read':{
        path: path.api.report,
            'data': function (options) {
                return {
                    action: "USER_LATEST_STATEMENTS",
                    amount: options.amount
                }
            },
            'method': 'get'
        }
    }
});

StatementModelCollection = Backbone.Collection.extend({
    model: StatementModel,
    parse: function (data) {
//        if (_.isObject(data.records)) {
//            this.trigger('update:statementCollection', {totalStatements: data.total, currentPage: data.page});
            return data.records;
//        } else {
//            return data;
//        }
    }
}).extend(StatementModelCollectionService);

PackageStatementCollection = Backbone.Collection.extend({
    model: StatementModel
}).extend();

/*UserModel = Backbone.Model.extend({
    defaults: {
        userID: '',
        name: '',
        selected: false
    }
});*/

UserService = new Backbone.Service({ url: path.root,
    sync: {
        'read': function () {
            return path.api.users + '?userID=' + jQuery('#transcriptUserID').val();
        }
    }
});

var UserCollection = Backbone.Collection.extend({
    parse: function (data) {
        return data.records;
    }
}).extend(UserService);


PrintTranscriptService = new Backbone.Service({ url: '/',
    sync: {
        'read' : function () {

            window.location  = window.location.protocol + "//" +
                                           window.location.host + "/" +
                                           path.api.print + "?action=PRINT_TRANSCRIPT" +
                                           "&companyID=" + jQuery('#transcriptCompanyID').val() +
                                           "&userID=" + jQuery('#transcriptUserID').val() +
                                           "&courseId=" + Utils.getCourseId();
        }
    }
});

var PrintModel = Backbone.Model.extend({
    defaults: {}
}).extend(PrintTranscriptService);