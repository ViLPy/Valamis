var FieldsModel = function(){
    this.elements = [];
    this.root = [];
    
    this.onGetAll = new Event(this);
};

FieldsModel.prototype = {
    get: function() {
        var _this = this;
        $.get(Utils.getContextPath() + "/services/category/Fields",
            function(response){
                var objects = eval("(" + response + ")");
                for(key in objects) {  
                    var field = objects[key];
                    var category = new CategoryModelProxy();
                    category.fromJSON(field);
                    
                    // check if this element is parent, then mark it as "global" field of knowledge
                    // in this case we use it only as global parent category for other fields
                    if (category.parentID === -1) {
                        _this.root[category.id] = category;
                    } else { // otherwise mark it as usual field and show in table
                        _this.elements.push(category);
                    }
                }  
            _this.onGetAll.notify(_this);
            });
    },
    
    doAdd: function(parentID){
        var proxyModel = new CategoryModelProxy();
        var _this = this;
        proxyModel.onCreate.attach(function(entity){
            _this.currentElement = entity;
            _this.elements[entity.id] = entity;
            if (entity.parentID === -1) _this.root.push(entity);
            
            _this.onAdd.notify(entity);
        });
        
        proxyModel.onUpdate.attach(function(entity){
            _this.onUpdate.notify(entity);
        });
        
        proxyModel.onDelete.attach(function(entity){
            _this.onDelete.notify(entity);
        });
        
        proxyModel.onSelect.attach(function(entity){
            _this.onSelect.notify(entity);
        });
        
        proxyModel.doCreate("New category", "", parentID, true);
    }
};