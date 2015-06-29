/*
 * GradebookStudentModel
 * */
var StudentGradesTargets = {

    'loadStudentInfo': {
        'path': path.api.gradebooks,
        'data': function (model) {
            return {
                action: 'GRADES',
                studyCourseId: Utils.getCourseId(),
                courseId: Utils.getCourseId(),
                studentId: model.get('id'),
                page: model.get('paginatorModel').get('currentPage'),
                count: model.get('paginatorModel').get('itemsOnPage'),
                sortAscDirection: true,
                withStatements: false
            };
        },
        'method': 'GET'
    },

    'loadTotalGrade': {
        'path': path.api.gradebooks,
        'data': function (model) {
            return {
                action: 'TOTAL_GRADE',
                courseId: Utils.getCourseId(),
                studentId: model.get('id')
            };
        },
        'method': 'GET'
    },

    'saveTotalGrade': {
        'path': path.api.gradebooks,
        'data': function (model) {
            return {
                action: 'TOTAL_GRADE',
                studentId: model.get('id'),
                courseId: Utils.getCourseId(),
                totalGrade: model.get('gradeTotal'),
                gradeComment: model.get('commentTotal')
            };
        },
        'method':'POST'
    },

    'loadLastModified': {
        'path': path.api.gradebooks,
        'data': function (model) {
            return {
                action: 'LAST_MODIFIED',
                courseId: Utils.getCourseId(),
                studentId: model.get('id')
            };
        },
        'method': 'GET'
    }
};

StudentGradesService = new Backbone.Service({ url: path.root ,targets: StudentGradesTargets});

var GradebookStudentModel = Backbone.Model.extend({
    defaults: {
        fullname: '',
        avatarUrl: 'http://placehold.it/48x48',
        address: '',
        organizationNames: [],
        lastModified: '',
        gradeTotal: 0,
        commentTotal: '',
        completedPackagesCount: 0,
        packagesCount: 0,
        packageGrades: [],
        paginatorModel: new PageModel({itemsOnPage: 10})
    }
}).extend(StudentGradesService);

var GradebookStudentCollection = Backbone.Collection.extend({
    model: GradebookStudentModel
});