var GradebookTargets = {
    loadList: {
        path: function (model) {
            var url = "api/gradebook?action=ALL&courseId="
                +jQuery1816Gradebook('#courseID').val()

                +"&studentName="+model.get('namePattern')
                +"&organizationName="+model.get('orgPattern')
                +"&page="+model.get('paginatorModel').get('currentPage')
                +"&count="+model.get('paginatorModel').get('itemsOnPage')
                +"&sortAscDirection=true";
            if (model.get('showMode') == 'detailedView') {
                url += "&resultAs=detailed";
                var s={selectedPackages:getCheckedPackages()};
                url += "&"+jQuery1816Gradebook.param(s);
            }
            return url;
        },
        method:'GET'
    }
};

GradebookService = new Backbone.Service({ url: Utils.getContextPath,targets: GradebookTargets});

var GradebookModel = Backbone.Model.extend({
    parse: function(response){
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
            sorting: 'nameAsc',
            showMode: 'simpleView'
        });
    }
}).extend(GradebookService);