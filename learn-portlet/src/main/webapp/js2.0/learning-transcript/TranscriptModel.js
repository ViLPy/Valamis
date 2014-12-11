var TranscriptModel = Backbone.Model.extend({
    defaults: {
    }
}).extend();

UserCertificateCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read': function () {

            return path.api.users
                + jQuery('#transcriptUserID').val()
                + '/certificates?'
                + 'companyID=' + jQuery('#transcriptCompanyID').val() +
                '&page=0' +
                '&count=1' +
                '&isOnlyPublished=true';
        }
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
        'read': function () {

            return path.api.users
                + jQuery('#transcriptUserID').val()
                + '/courses';
        }
    }
});

var UserCoursesCollection = Backbone.Collection.extend({
    model: TranscriptModel
}).extend(UserCoursesCollectionService);

// ####

PackagesCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read': function (e, options) {

            return path.api.gradebooks +
                "?action=GRADES" +
                "&courseId=" + options.courseId +
                "&studentId=" + jQuery('#transcriptUserID').val() +
                "&page=0&count=1";
        }
    }
});

var PackagesCollection = Backbone.Collection.extend({
    model: TranscriptModel,
    parse: function (response) {
        return response.packageGrades;
    }
}).extend(PackagesCollectionService);

CertificateGoalCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read': function (e, options/*, model*/) {
            return path.api.certificates + options.certificateID + '?action=GETBYID';
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
        'read': function (e, options) {
            return path.api.users + jQuery('#transcriptUserID').val() + '/certificates/' + options.certificateID + '/goals';
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
        'read': function (options) {
            return path.api.report + '?action=USER_LATEST_STATEMENTS&amount=' + options.amount;
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
//    model: UserModel,
    parse: function (data) {
//        this.trigger('userCollection:updated', { total: data.total, currentPage: data.currentPage, listed: data.records.length });
        return data.records;
    }
}).extend(UserService);


PrintTranscriptService = new Backbone.Service({ url: '/',
    sync: {
        'read' : function () {
            /*return path.api.print + "?action=PRINT_TRANSCRIPT" +
                                    "&companyID=" + jQuery('#transcriptCompanyID').val() +
                                    "&userID=" + jQuery('#transcriptUserID').val() +
                                    "&courseID=" + jQuery('#transcriptCourseID').val();*/
            window.location  = window.location.protocol + "//" +
                                           window.location.host + "/" +
                                           path.api.print + "?action=PRINT_TRANSCRIPT" +
                                           "&companyID=" + jQuery('#transcriptCompanyID').val() +
                                           "&userID=" + jQuery('#transcriptUserID').val() +
                                           "&courseID=" + jQuery('#transcriptCourseID').val();
        }
    }
});

var PrintModel = Backbone.Model.extend({
    defaults: {}
}).extend(PrintTranscriptService);