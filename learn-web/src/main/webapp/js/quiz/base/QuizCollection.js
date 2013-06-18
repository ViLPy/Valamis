// Quiz collection
QuizCollection = Backbone.Collection.extend({
    model:Quiz,
    storage:{
        findAll:function () {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/quiz/" + "?courseID="+jQuery("#courseID").val());
        }
    }
});