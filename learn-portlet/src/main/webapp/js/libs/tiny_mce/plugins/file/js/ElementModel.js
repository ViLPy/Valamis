ElementModel = Backbone.Model.extend({
    defaults:{
        name:"",
        url:"",
        thumb:"",
        isDirectory:false
    }
});

ElementCollection = Backbone.Collection.extend({
    model:ElementModel,
    fetch: function(currentDir){
        this.storage.findAll(currentDir).done(jQuery.proxy(function(resp){
            this['reset'](this.parse(resp), {});
        }, this));
    }
});