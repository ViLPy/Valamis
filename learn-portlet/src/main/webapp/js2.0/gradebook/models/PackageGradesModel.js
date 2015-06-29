/*
 * PackageGradesModel
 * */

var PackageGradesTargets = {

    'loadStatements': {
        'path': path.api.gradebooks,
        'data': function (model) {
            return {
                action: 'STATEMENTS',
                studentId: model.get('studentId'),
                packageId: model.get('id'),
                courseId: Utils.getCourseId()
            }
        },
        'method': 'GET'
    },
    'saveGrade': {
        'path': path.api.gradebooks,
        'data': function (model) {
            return {
                action: 'GRADES',
                studentId: model.get('studentId'),
                packageId: model.get('id'),
                totalGrade: model.get('grade'),
                gradeComment: model.get('comment'),
                courseId: Utils.getCourseId()
            }
        },
        'method':'POST'
    }
};

PackageGradesService = new Backbone.Service({ url: path.root, targets: PackageGradesTargets});

var PackageGradesModel = Backbone.Model.extend({
    defaults: {
        studentId:'',
        packageName: '',
        description: '',
        finished: false,
        gradeAuto: 0,
        grade: 0,
        comment: '',
        activityIds: [],
        statements: []
    }
}).extend(PackageGradesService);

var StudentGradesCollection = Backbone.Collection.extend({
    model: PackageGradesModel
});