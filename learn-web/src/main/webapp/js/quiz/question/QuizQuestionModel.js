QuizQuestionModel = Backbone.Model.extend({
    defaults:{
        quizID:0,
        title:"New quiz question",
        questionID:-1,
        categoryID:-1,
        question:null,
        url:"",
        isNew: false
    },

    initialize:function () {
        try {
            this.set('questionID', this.get('question').id);
        } catch (e) {
        }
    },

    move:function (options, callback) {
        jQuery.when(this.storage.move(this, options)).done(callback);
    }
});

_.extend(QuizQuestionModel.prototype, {
    storage:{
        create:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizquestion/", model.toJSON());
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizquestion/update/" + model.id, model.toJSON());
        },

        move:function (model, options) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizquestion/move/" + model.id, _.extend(model.toJSON(), options));
        },

        find:function (model) {
        },

        findAll:function () {
        },

        destroy:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizquestion/delete/" + model.id);
        }
    }
});
