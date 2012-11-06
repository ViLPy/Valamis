Quiz = Backbone.Model.extend({
    defaults:{
        title:"New quiz",
        description:"Quiz info",
        questionCount:0,
        welcomePageContent:"",
        finalPageContent:""
    },
    install:function (callback) {
        jQuery.when(this.storage.install(this)).done(callback)
    }
});

_.extend(Quiz.prototype, {
    storage:{
        create:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quiz/", model.toJSON());
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quiz/update/" + model.id, model.toJSON());
        },

        find:function (model) {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/quiz/" + model.id);
        },

        findAll:function () {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/quiz/");
        },

        destroy:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quiz/delete/" + model.id);
        },

        install:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/generator/ZipInstall/" + model.id);
        }
    }
});