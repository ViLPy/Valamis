QuizCategoryService = new Backbone.Service({ url: Utils.getContextPath,
    targets: {
        'move': {
            'path': function (model) {
                return "/services/quizcategory/move/" + model.id;
            },
            'method': "post",
            'data': function (model, options) {
                return _.extend(model.toJSON(), options);
            }
        }
    },
    sync: {
        'create': {
            'path': function () {
                return "/services/quizcategory/?courseID=" + Utils.getCourseID()
            },
            'method': "post"
        },
        'update': {
            'path': function (model) {
                return "services/quizcategory/update/" + model.id;
            },
            'method': "post"
        },
        'read': {
            'path': function (model) {
                return "/services/quizcategory/" + model.id + "?courseID=" + Utils.getCourseID();
            }
        },
        'delete': {
            'path': function () {
                return "/services/quizcategory/delete";
            },
            'method': "post"
        }
    }
});

QuizCategoryModel = Backbone.Model.extend({
    defaults: {
        quizID: 0,
        title: "New category",
        description: "",
        parentID: -1,
        isNew: false
    }
}).extend(QuizCategoryService);