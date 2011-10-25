var AnswerController = function(){
    this.model = null;
};

AnswerController.prototype = {
    setModel: function(model) {
        this.model = model;
    },
    doAdd: function(type) {
        switch(type){
            case 0:
                this.model.doCreateChoiceAnswer();
                break;
            case 1:
                this.model.doCreateShortAnswer();
                break;
            case 2:
                this.model.doCreateNumericAnswer();
                break;
            case 3:
                this.model.doCreatePositioningAnswer();
                break;
            case 4:
                this.model.doCreateMatchingAnswer();
                break;
        }
    },
    
    doEmpty: function() {
        this.model.doEmpty();
    },
    
    doDelete: function(id) {
        this.model.doDelete(id);
    }
};