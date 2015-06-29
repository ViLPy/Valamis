var _DefaultView = Backbone.View.extend({
    afterRender: function(){
        this.$('.dropdown').valamisDropDown();
    }
});

var aop = [];
(function(){
    var oldExtend = _DefaultView.extend;
    var newExtend = function() {
        var result = oldExtend.apply(this,arguments);
        if(!_.contains(aop,result.prototype)) aop.push(result.prototype);
        return result;
    };
    _DefaultView.extend = newExtend;
})();

var _LessonDefaultView = _DefaultView.extend({
    templateSelector: null,
    getTemplate: function(){
        if(this._template == null) this._template = jQueryValamis(this.templateSelector).html();
        return this._template;
    },
    _template: null,
    render: function(){
        this.$el.html(Mustache.render(this.getTemplate(),
            _.extend({},
                _LessonDesigner.config.translations,
                window.permissionActionsLessonDesigner,
                this.model == null ? undefined : this.model.attributes
            )
        ));

        return this;
    }
});