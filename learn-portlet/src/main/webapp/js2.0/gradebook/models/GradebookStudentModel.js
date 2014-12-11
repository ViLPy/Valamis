/*
 * GradebookStudentModel
 * */
var StudentGradesTargets = {
    loadStudentInfo:    path.api.gradebooks + '?action=GRADES',//"api/gradebook?action=GRADES&studentId=1&courseId=1&page=0&count=10&sortAscDirection=true",
    loadTotalGrade:     path.api.gradebooks + '?action=TOTAL_GRADE',
    saveTotalGrade: {
        path: function (model) {
            return path.api.gradebooks + '?action=TOTAL_GRADE&studentId='+model.id+'&courseId='+jQuery1816Gradebook('#courseID').val()+
                '&totalGrade='+model.get('gradeTotal')+'&gradeComment='+model.get('commentTotal');
        },
        method:'POST'
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
        packageGrades: []
    }
}).extend(StudentGradesService);

var GradebookStudentCollection = Backbone.Collection.extend({
    model: GradebookStudentModel
});