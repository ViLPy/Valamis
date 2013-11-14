QuizService = new Backbone.Service({ url: Utils.getContextPath,
    targets: {
        'install': {
            'path': function (model) {
                return "/services/generator/ZipInstall/" + model.id + "?courseID=" + Utils.getCourseID()
            },
            'method': "post"
        }
    },
    sync: {
        'create': {
            'path': function () {
                return "/services/quiz/?courseID=" + Utils.getCourseID();
            },
            'method': "post"
        },
        'update': {
            'path': function (model) {
                return "/services/quiz/update/" + model.id
            },
            'method': "post"
        },
        'read': {
            'path': function (model) {
                return "/services/quiz/" + model.id
            }
        },
        'delete': {
            'path': function (model) {
                return "/services/quiz/delete/" + model.id
            },
            'method': "post"
        }
    }
});

Quiz = Backbone.Model.extend({
    defaults: {
        title: "New quiz",
        description: "Quiz info",
        questionCount: 0,
        welcomePageContent: "",
        finalPageContent: ""
    }
}).extend(QuizService);