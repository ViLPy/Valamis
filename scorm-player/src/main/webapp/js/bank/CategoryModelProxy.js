var CategoryModelProxy = function(){
    this.rawJSON = {};
    
    this.id = 0;
    this.title = "New category";
    this.description = "";
    this.parentID = -1;
    this.position = 0;
    this.dndMode = "";
    this.targetId = -2;
    this.itemType = "";
    
    this.onCreate = new Event(this);
    this.onUpdate = new Event(this);
    this.onDelete = new Event(this);
    
    this.toString = function() {
        return "id=" + this.id + 
        "&title=" + this.title + 
        "&description=" + escape(encodeURIComponent(this.description.replace(/[\n]/g, '\\n'))) + 
        "&parentID=" + this.parentID+
        "&position=" + this.position+
        "&dndMode=" + this.dndMode+
        "&targetId=" + this.targetId+
        "&itemType=" + this.itemType;
    };
    
    this.toRawJSON = function(json) {
        this.rawJSON = {
            "attr": {
                "id": json.id,
                "rel": "folder",
                "description": json.description,
                "parentID": json.parentID,
                "position": json.position
            },
            "data": json.title,
            "state": "closed"
        };
        return this.rawJSON;
    };
    
    this.fromJSON = function(data) {
        if (Utils.isExists(data.attr.id)) this.id = data.attr.id;
        if (Utils.isExists(data.data)) this.title = data.data;
        if (Utils.isExists(data.attr.description)) this.description = unescape(data.attr.description);
        if (Utils.isExists(data.attr.parentID)) this.parentID = data.attr.parentID;
        if (Utils.isExists(data.attr.position)) this.position = data.attr.position;
        if (Utils.isExists(data.attr.dndMode)) this.dndMode = data.attr.dndMode;
        if (Utils.isExists(data.attr.targetId)) this.targetId = data.attr.targetId;
        if (Utils.isExists(data.attr.itemType)) this.itemType = data.attr.itemType;
        if (Utils.isExists(data.attr.isField)) this.isField = data.attr.isField;
    }
};

CategoryModelProxy.prototype = {
    
    doCreate : function(newParentID){
        this.parentID = newParentID;
        var _this = this;
        $.post(Utils.getContextPath() + "/services/category/",
            this.toString(),
            function(response){
                _this.fromJSON(_this.toRawJSON(response));
                _this.onCreate.notify();
            });
    },
       
    doUpdate : function() {
        var _this = this;
        $.post(Utils.getContextPath() + "/services/category/update",
            this.toString(),
            function(response){
                _this.fromJSON(_this.toRawJSON(response));
                _this.onUpdate.notify();
            });
    },
    
    doMove : function() {
        var _this = this;
        $.post(Utils.getContextPath() + "/services/category/move",
            this.toString(),
            function(response){
                _this.fromJSON(_this.toRawJSON(response));
                _this.onUpdate.notify();
            });
    },
    
    doDelete : function(){
        var _this = this;
        $.post(Utils.getContextPath() + "/services/category/delete",
            this.toString(),
            function(){
                _this.onDelete.notify();
            });
    }
};

