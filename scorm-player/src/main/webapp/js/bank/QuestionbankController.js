var QuestionbankController = function(model){
    this.model = model;
    this.isSaved=true;
};

QuestionbankController.prototype = {
    loadData: function(parentID){
        this.model.doGet(parentID);
    },
    
    createCategory: function() {
        var parentID = -1;
        var currentNode = this.model.currentElement;
        if (currentNode instanceof CategoryModelProxy) {
            parentID = currentNode.id;
        }
        this.model.doCreateCategory(parentID);
    },
    
    createQuestion: function() {
        var parentID = -1;
        var currentNode = this.model.currentElement;
        if (currentNode instanceof CategoryModelProxy) {
            parentID = currentNode.id;
        } else if (currentNode instanceof QuestionModelProxy) {
            parentID = currentNode.categoryID;
        }
        this.model.doCreateQuestion(parentID);
    },
    
    updateCategory: function(data) {
        this.model.doUpdate(data);
    },
    updateCategoryParent: function(data) {
        this.model.doUpdateParent(data);
    },
    updateQuestion: function(data) {
        this.model.doUpdate(data);
    },
    updateQuestionParent: function(data) {
        this.model.doUpdateParent(data);
    },
    deleteCategory: function() {
        // let's check current node!
        var nodeToDelete = -1;
        var currentNode = this.model.currentElement;
        if (currentNode instanceof CategoryModelProxy) {
            nodeToDelete = "folder" + currentNode.id;
        }
        
        if (nodeToDelete != -1) { // can't delete "super-root"
            if (confirm("Are you sure want to delete this category? All included categories/question will be deleted!") === true) {
                this.model.doDelete(nodeToDelete);
            }
        }
    },
    
    deleteQuestion: function() {
        var currentNode = this.model.currentElement;
        if (currentNode instanceof QuestionModelProxy) {
            var nodeToDelete = "entity" + currentNode.id;
            if (confirm("Are you sure want to delete this question?") === true) {
                this.model.doDelete(nodeToDelete);
            }
        }
    },
    
    selectItem: function(type, id) {
        this.model.doSelect(type + id);
    },
    
    clearSelection: function() {
        this.model.doClearSelection();
    }
};