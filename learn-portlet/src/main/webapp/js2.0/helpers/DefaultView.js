if(!('$' in window)) throw new Error('$ is not defined');
if(!('Backbone' in window && 'View' in window.Backbone)) throw new Error('Backbone.View is not defined');
if(!('Mustache' in window)) throw new Error('Mustache is not defined');

var DefaultView = Backbone.View.extend({
    _template: null,
    templateSelector: null,
    getTemplate: function(){
        if(this._template === null) {
            if(this.templateSelector === null) throw new Error('templateSelector is not provided');
            this._template = $(this.templateSelector).html();
        }
        return this._template;
    },
    render: function(){
        this.$el.html(Mustache.render(this.getTemplate(), this.model.attributes));
        return this;
    }
});