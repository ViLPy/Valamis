var CategoryModelProxy = function(){
    this.id = 0;
    this.title = "New category";
    this.description = "";
    this.parentID = -1;
    
    this.onCreate = new Event(this);
    this.onUpdate = new Event(this);
    this.onDelete = new Event(this);
    
    this.toString = function() {
        return "id=" + this.id + 
            "&title=" + this.title + 
            "&description=" + escape(this.description) + 
            "&parentID=" + this.parentID;
    };
    
    this.fromJSON = function(data) {
        if (Utils.isExists(data.attr.id)) this.id = data.attr.id;
        if (Utils.isExists(data.data)) this.title = data.data;
        if (Utils.isExists(data.attr.description)) this.description = data.attr.description;
        if (Utils.isExists(data.attr.parentID)) this.parentID = data.attr.parentID;
        if (Utils.isExists(data.attr.isField)) this.isField = data.attr.isField;
    }
    
    this.rawJsTree = {};
};

CategoryModelProxy.prototype = {
    
    doCreate : function(newParentID){
        this.parentID = newParentID;
        var _this = this;
        
        $.post(Utils.getContextPath() + "/services/category",
            this.toString(),
            function(response){
                _this.rawJSON = eval("(" + response + ")");
                _this.fromJSON(_this.rawJSON);
                _this.onCreate.notify();
            });
    },
       
    doUpdate : function() {
        var _this = this;
        $.post(Utils.getContextPath() + "/services/category/Update",
            this.toString(),
            function(response){
                _this.rawJSON = eval("(" + response + ")");
                _this.fromJSON(_this.rawJSON);
                _this.onUpdate.notify();
            });
    },
    
    doDelete : function(){
        var _this = this;
        $.post(Utils.getContextPath() + "/services/category/Delete",
            this.toString(),
            function(){
                _this.onDelete.notify();
            });
    }
};

