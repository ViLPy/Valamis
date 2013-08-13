QuizQuestionService = new Backbone.Service({ url: Utils.getContextPath,
    targets: {
        'move': {
            'path': function (model) {
                return "/services/quizquestion/move/" + model.id;
            },
            'method': "post",
            'data': function(model, options) {
                return _.extend(model.toJSON(), options);
            }
        }
    },
    sync: {
        'create': {
            'path': "/services/quizquestion/",
            'method': "post"
        },
        'update': {
            'path': function (model) {
                return "/services/quizquestion/update/" + model.id;
            },
            'method': "post"
        },
        'delete': {
            'path': function (model) {
                return "/services/quizquestion/delete/" + model.id;
            },
            'method': "post"
        }
    }
});

QuizQuestionModel = Backbone.Model.extend({
    defaults:{
        quizID:0,
        title:"New quiz question",
        questionID:-1,
        categoryID:-1,
        question:null,
        url:"",
        questionType:"",
        text:"",
        isNew:false
    },

    initialize:function () {
        if (this.get("questionType") == "QuestionBank") {
            this.set('questionID', this.get('question').id);
        } else if (this.get("questionType") == "PlainText") {
            try {
                this.set('text', decodeURIComponent(this.get('text')));
            } catch(err) {}
        }
    }
}).extend(QuizQuestionService);
