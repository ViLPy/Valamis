

/*
 * PackageGradesModel
 * */

var PackageGradesTargets = {
    loadGrade: "api/gradebook?action=GRADES",
    saveGrade: {
        path: function (model) {
            return 'api/gradebook?action=GRADES&studentId='+model.get('studentId')+'&packageId='+model.id+
                '&totalGrade='+model.get('grade')+'&gradeComment='+model.get('comment');
        },
        //path:'api/gradebook?action=TOTAL_GRADE',
        method:'POST'
    }
};

PackageGradesService = new Backbone.Service({ url: Utils.getContextPath,targets: PackageGradesTargets});

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

//StudentGradesCollectionService = new Backbone.Service({ url: Utils.getContextPath,
//    sync: {
//        'read': function () {
//            return "api/gradebook?action=GRADES&studentId=1&courseId=1&page=0&count=10&sortAscDirection=true";
//        }
//    }
//});

var StudentGradesCollection = Backbone.Collection.extend({
    model: PackageGradesModel
});