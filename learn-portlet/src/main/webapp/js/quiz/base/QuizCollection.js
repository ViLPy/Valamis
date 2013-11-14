QuizCollectionService = new Backbone.Service({ url: Utils.getContextPath,
    sync: {
        'read': function () {
            return "/services/quiz/?courseID=" + Utils.getCourseID();
        }
    }
});

QuizCollection = Backbone.Collection.extend({
    model: Quiz
}).extend(QuizCollectionService);