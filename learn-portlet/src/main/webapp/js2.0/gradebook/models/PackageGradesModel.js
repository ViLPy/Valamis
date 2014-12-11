/*
 * PackageGradesModel
 * */

var PackageGradesTargets = {
    loadGrade: path.api.gradebooks + "?action=GRADES",
    saveGrade: {
        path: function (model) {
            return path.api.gradebooks + '?action=GRADES&studentId='+model.get('studentId')+'&packageId='+model.id+
                '&totalGrade='+model.get('grade')+'&gradeComment='+model.get('comment');
        },
        method:'POST'
    }
};

PackageGradesService = new Backbone.Service({ url: path.root, targets: PackageGradesTargets});

var PackageGradesModel = Backbone.Model.extend({
    defaults: {
        studentId:'',
        packageName: '',
        description: '',
        finished: false,
        grade: 0,
        comment: '',
        statements: []
    }
}).extend(PackageGradesService);

var StudentGradesCollection = Backbone.Collection.extend({
    model: PackageGradesModel
});