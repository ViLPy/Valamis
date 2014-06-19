/*
 * GradebookStudentModel
 * */
var StudentGradesTargets = {
    loadStudentInfo: 'api/gradebook?action=GRADES',//"api/gradebook?action=GRADES&studentId=1&courseId=1&page=0&count=10&sortAscDirection=true",
    loadTotalGrade: 'api/gradebook?action=TOTAL_GRADE',
    saveTotalGrade: {
        path: function (model) {
            return 'api/gradebook?action=TOTAL_GRADE&studentId='+model.id+'&courseId='+jQuery1816Gradebook('#courseID').val()+
                '&totalGrade='+model.get('gradeTotal')+'&gradeComment='+model.get('commentTotal');
        },
        //path:'api/gradebook?action=TOTAL_GRADE',
        method:'POST'
    }
};

StudentGradesService = new Backbone.Service({ url: Utils.getContextPath,targets: StudentGradesTargets});

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

//GradebookStudentCollectionService = new Backbone.Service({ url: Utils.getContextPath,
//    sync: {
//        'read': function (e, options) { // TODO set up parameters
//            var url = "api/gradebook?action=ALL&courseId="+jQuery1816Gradebook('#courseID').val()+"&page=0&count=10&sortAscDirection=true";
//            if (jQuery("#detailed").val() == 'true') {
//                url += "&resultAs=detailed";
//                var s={selectedPackages:getCheckedPackages()};
//                url += "&"+jQuery1816Gradebook.param(s);
//            }
//            return url;
//        }
//    }
//});

var GradebookStudentCollection = Backbone.Collection.extend({
    model: GradebookStudentModel
});
//    .extend(GradebookStudentCollectionService).extend({
//    // records returns for collection
//    parse: function(response) {
//        return response.records;
//    }
//});
