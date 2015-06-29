var GradebookTargets = {
    'loadList': {
        'path': path.api.gradebooks,
        'data': function (model) {
            var sortBy = model.get('sorting').split(':')[0];
            var asc = model.get('sorting').split(':')[1];
            var res = {
                action: 'ALL',
                courseId: Utils.getCourseId(),
                studentName: model.get('namePattern'),
                organizationName: model.get('orgPattern'),
                page: model.get('paginatorModel').get('currentPage'),
                count: model.get('paginatorModel').get('itemsOnPage'),
                sortBy: sortBy,
                sortAscDirection: asc
            };

            if (model.get('showMode') == 'detailedView') {
                var s={selectedPackages:getCheckedPackages()};
                res = _.extend(res, {resultAs: 'detailed'}, s);
            }
            return res;
        },
        method:'GET'
    }
};

GradebookService = new Backbone.Service({ url: path.root, targets: GradebookTargets});

var GradebookModel = Backbone.Model.extend({
    parse: function(response){
        //Seems that this code is never executed.
        this.get('paginatorModel').set({totalElements: response.total, currentPage: response.page});
        this.set('records',new GradebookStudentCollection(response.records));
    },
    initialize: function(){
        this.set({
            namePattern: "",
            orgPattern: "",
            paginatorModel: new PageModel(),
            packageCollection: [],
            page: 0,
            records: new GradebookStudentCollection(),
            total: 0,
            sorting: 'name:true',
            showMode: 'simpleView'
        });
    }
}).extend(GradebookService);