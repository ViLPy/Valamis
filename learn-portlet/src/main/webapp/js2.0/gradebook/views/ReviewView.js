/*
* Review response student for statement activity and check it with correct response
* READONLY View*/

ReviewView = Backbone.View.extend({
    events: {

    },

    initialize: function (options) {
        this.options = options;
        //this.$el = jQueryValamis('<div>');
        //this.$el.attr("id", this.model.id);
    },

    render: function () {
        var result = this.model.result.score?this.model.result.score.scaled*100+'%':'';
        var userResponse = "user response";
        var correctResponse = "correct response";
        var template = Mustache.to_html(jQueryValamis("#reviewTemplate").html(), _.extend(this.model, language,
            {resultGrade: result,userResponse:userResponse,correctResponse:correctResponse}));
        this.$el.html(template);

        return this.$el;
    }
});