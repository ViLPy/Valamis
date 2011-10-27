var CollectionModel = function(){
    this.elements = [];
    this.currentElement = null;
    
    this.onGet = new Event(this);
    this.onAdd = new Event(this);
    this.onCreate = new Event(this);
    this.onUpdate = new Event(this);
    this.onDelete = new Event(this);
    this.onSelect = new Event(this);
    this.onClearSelection = new Event(this);
};

CollectionModel.prototype = {
    doGet: function(parentID){
        var _this = this;
        var _parentID = parentID;
        $.get(Utils.getContextPath() + "/services/category/Children" + "?id=" + parentID,
            function(response) {
                var objects = eval("(" + response + ")");
                for(key in objects) {
                    var object = objects[key];
                    if (object.attr.rel == "folder"){
                        _this.doAddCategory(object);
                    } else {
                        _this.doAddQuestion(object);
                    }
                }
                _this.onGet.notify(_parentID);
            });
    },
    
    doAddCategory: function(data){
        var category = new CategoryModelProxy();
        category.rawJSON = data;
        category.fromJSON(data);
        if (!this.elements["folder" + category.id]) {
            this.elements["folder" + category.id] = category;
            this.bindDefaultEvents(category);
                        
            this.onAdd.notify(category);
        }
    },
    
    doAddQuestion: function(data){
        var question = new QuestionModelProxy();
        question.rawJSON = data;
        question.fromJSON(data);
        if (!this.elements["entity" + question.id]) {
            this.elements["entity" + question.id] = question;
            this.bindDefaultEvents(question);
                        
            this.onAdd.notify(question);
        }
    },
    
    doCreateCategory: function(parentID) {
        var proxyModel = new CategoryModelProxy();
        var _this = this;
        proxyModel.onCreate.attach(function(entity){
            _this.currentElement = entity;
            _this.elements["folder" + entity.id] = entity;
            _this.onCreate.notify(entity);
        });
        
        _this.bindDefaultEvents(proxyModel);
        
        proxyModel.doCreate(parentID);
    },
    
    doCreateQuestion: function(parentID) {
        var proxyModel = new QuestionModelProxy();
        var _this = this;
        proxyModel.onCreate.attach(function(entity){
            _this.currentElement = entity;
            _this.elements["entity" + entity.id] = entity;
            _this.onCreate.notify(entity);
        });
        
        _this.bindDefaultEvents(proxyModel);
        
        proxyModel.doCreate(parentID);
    },
    
    doUpdate: function(data) {
        if (this.currentElement instanceof CategoryModelProxy) {
            this.currentElement.title = data.name;
            this.currentElement.description = data.description;
            
        } else if (this.currentElement instanceof QuestionModelProxy) {
            this.currentElement.type = data.type;
            this.currentElement.isBounded = data.isBounded;
            this.currentElement.isCaseSensitive = data.isCaseSensitive;
            this.currentElement.title = data.title;
            this.currentElement.text = data.text;
        }
        this.currentElement.doUpdate();
    },
    
    doDelete: function(id){
        var elementToDelete = this.elements[id];
        this.currentElement = this.elements["folder" + elementToDelete.parentID];
        elementToDelete.doDelete();
    },
    
    doSelect: function(id){
        this.currentElement = this.elements[id];
        this.onSelect.notify(this.currentElement);
    },
    
    doClearSelection: function() {
        this.currentElement = null;
        this.onClearSelection.notify();
    },
    
    bindDefaultEvents: function(proxyModel){
        var _this = this;
        proxyModel.onUpdate.attach(function(entity){
            _this.onUpdate.notify(entity);
        });
        
        proxyModel.onDelete.attach(function(entity){
            delete _this.elements["folder" + entity.id];
            _this.onDelete.notify(entity.id);
        });
    }
};