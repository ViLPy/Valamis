var AnswersModel = function(){
    this.answers = [];
    this.answerOrder = [];
    this.nextID = 0;
    
    this.onCreate = new Event(this);
    this.onDelete = new Event(this);
    this.onEmpty = new Event(this);
    
    this.toString = function(){
        this.answers = this.answers.filter(function(element){
            return (element != null);
        })
        this.orderedAnswers = [];
        for (var i = 0; i < this.answerOrder.length; i++) {
            this.orderedAnswers.push(this.answers[this.answerOrder[i]]);
        }
        return "[" + this.orderedAnswers.join(",") + "]";
    }
};

AnswersModel.prototype = {
    doCreateChoiceAnswer:  function(data){
        var entity = new ChoiceAnswer();
        entity.id = this.nextID;
        if (Utils.isExists(data)) entity.fromJSON(data);
        this.answers[this.nextID] = entity;
        this.onCreate.notify(entity);
        this.nextID++;
        return entity;
    },
    doCreateShortAnswer:  function(data){
        var entity = new ShortAnswer();
        entity.id = this.nextID;
        if (Utils.isExists(data)) entity.fromJSON(data);
        this.answers[this.nextID] = entity;
        this.onCreate.notify(entity);
        this.nextID++;
        return entity;
    },
    doCreateNumericAnswer:  function(data){
        var entity = new NumericAnswer();
        entity.id = this.nextID;
        if (Utils.isExists(data)) entity.fromJSON(data);
        this.answers[this.nextID] = entity;
        this.onCreate.notify(entity);
        this.nextID++;
        return entity;
    },
    doCreatePositioningAnswer: function(data){
        var entity = new PositioningAnswer();
        entity.id = this.nextID;
        if (Utils.isExists(data)) entity.fromJSON(data);
        this.answers[this.nextID] = entity;
        this.onCreate.notify(entity);
        this.nextID++;
        return entity;
    },
    doCreateMatchingAnswer:  function(data){
        var entity = new MatchingAnswer();
        entity.id = this.nextID;
        if (Utils.isExists(data)) entity.fromJSON(data);
        this.answers[this.nextID] = entity;
        this.onCreate.notify(entity);
        this.nextID++;
        return entity;
    },
    
    doLoad: function(type, data) {
        var fabric = [];
        switch(type) {
            case 0:
                this.doCreateChoiceAnswer(data);
                break;
            case 1:
                this.doCreateShortAnswer(data);
                break;
            case 2:
                this.doCreateNumericAnswer(data);
                break;
            case 3:
                this.doCreatePositioningAnswer(data);
                break;
            case 4:
                this.doCreateMatchingAnswer(data);
                break;
        }
    },
    
    doDelete: function(id) {
        delete this.answers[id];
        this.onDelete.notify(id);
    },
    doEmpty: function() {
        this.answers = [];
        this.onEmpty.notify();
    }
};

//---------------------------------
var ChoiceAnswer = function(){
    this.id = 0;
    this.answerText = "";
    this.isCorrect = false;
    
    this.toString = function(){
        return '{"id":' + this.id + ', "text":"' + this.answerText + '", "isCorrect":"' + this.isCorrect + '"}';
    }
    
    this.toJSON = function() {
        return eval("(" + this.toString() + ")");
    }
    
    this.fromJSON = function(data) {
        if (Utils.isExists(data.text)) this.answerText = data.text;
        if (Utils.isExists(data.isCorrect)) this.isCorrect = (data.isCorrect === "true");
    }
};

var ShortAnswer = function(){
    this.id = 0;
    this.answerText = "";
    
    this.toString = function(){
        return '{"id":' + this.id + ', "text":"' + this.answerText + '"}';
    }
    
    this.toJSON = function() {
        return eval("(" + this.toString() + ")");
    }
    
    this.fromJSON = function(data) {
        if (Utils.isExists(data.text)) this.answerText = data.text;
    }
};

var NumericAnswer = function(){
    this.id = 0;
    this.rangeFrom = 0;
    this.rangeTo = 0;
    
    this.toString = function(){
        return '{"id":' + this.id + ', "from":' + this.rangeFrom + ', "to":' + this.rangeTo + '}';
    }
    
    this.toJSON = function() {
        return eval("(" + this.toString() + ")");
    }
    
    this.fromJSON = function(data) {
        if (Utils.isExists(data.rangeFrom)) this.rangeFrom = data.rangeFrom;
        if (Utils.isExists(data.rangeTo)) this.rangeTo = data.rangeTo;
    }
};

var PositioningAnswer = function(){
    this.id = 0;
    this.answerText = "";
    this.isCorrect = false;
    
    this.toString = function(){
        return '{"id":' + this.id + ', "text":"' + this.answerText + '", "isCorrect":"' + this.isCorrect + '"}';
    }
    
    this.toJSON = function() {
        return eval("(" + this.toString() + ")");
    }
    
    this.fromJSON = function(data) {
        if (Utils.isExists(data.text)) this.answerText = data.text;
        if (Utils.isExists(data.isCorrect)) this.isCorrect = (data.isCorrect === "true");
    }
};

var MatchingAnswer = function(){
    this.id = 0;
    this.answerText = "";
    this.subquestionText = "";
    
    this.toString = function(){
        return '{"id":' + this.id + ', "text":"' + this.answerText + '", "subquestion":"'+this.subquestionText+'"}';
    }
    
    this.toJSON = function() {
        return eval("(" + this.toString() + ")");
    }
    
    this.fromJSON = function(data) {
        if (Utils.isExists(data.text)) this.answerText = data.text;
        if (Utils.isExists(data.subquestionText)) this.subquestionText = data.subquestionText;
    }
};