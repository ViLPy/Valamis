var TemplateCache = function(){
    this.numberOfCachedDocuments = 0;
    this.alreadyCached = 0;
    this.templates = [];
    
    this.onComplete = new Event(this);
};

TemplateCache.prototype = {
    addTemplate: function(id, url){
        this.numberOfCachedDocuments++;
        var _this = this;
        var templateID = id;
        
        $.get(Utils.getContextPath() + url, function(template){
            _this.templates[templateID] = template;
            _this.alreadyCached++;
            if (_this.alreadyCached === _this.numberOfCachedDocuments) {
                _this.onComplete.notify();
            }
        });
    },
    
    getTemplate: function(id){
        return this.templates[id];
    },
    
    isComplete: function(){
        return (this.alreadyCached === this.numberOfCachedDocuments);
    }
};