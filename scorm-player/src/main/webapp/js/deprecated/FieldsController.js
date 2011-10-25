var FieldsController = function(model){
    this.model = model;
};

FieldsController.prototype = {
    getAll: function(){
        this.model.get();
    }
};
