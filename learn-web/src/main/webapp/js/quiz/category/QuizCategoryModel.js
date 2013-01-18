QuizCategoryModel = Backbone.Model.extend({
    defaults:{
        quizID:0,
        title:"New category",
        description:"",
        parentID:-1,
        isNew:false
    },
    move:function (options, callback) {
        jQuery.when(this.storage.move(this, options)).done(callback)
    }
});

_.extend(QuizCategoryModel.prototype, {
    storage:{
        create:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizcategory/?courseID=" + jQuery("#courseID").val, model.toJSON());
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "services/quizcategory/update/" + model.id, model.toJSON());
        },

        move:function (model, options) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizcategory/move/" + model.id, _.extend(model.toJSON(), options));
        },

        find:function (model) {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/quizcategory/" + model.id+"?courseID=" + jQuery("#courseID").val);
        },

        destroy:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quizcategory/delete", model.toJSON());
        }
    }
});