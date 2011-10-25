var QuestionModelProxy = function(answers){
    this.id = 0;
    this.type = 0;
    this.categoryID = -1;
    this.isBounded = false;
    this.isCaseSensitive = false;
    this.title = "New question";
    this.text = "";
    
    this.answers = new AnswersModel();
    
    this.onCreate = new Event(this);
    this.onUpdate = new Event(this);
    this.onAnswersUpdate = new Event(this);
    this.onDelete = new Event(this);
    
    this.toString = function() {
        return "id=" + this.id +
        "&type=" + this.type +
        "&categoryID=" + this.categoryID +
        "&isBounded=" + this.isBounded + 
        "&isCaseSensitive=" + this.isCaseSensitive +
        "&title=" + this.title +
        "&text=" + escape(this.text) + 
        "&answers=" + this.answers.toString();
    }
    
    this.fromJSON = function(data) {
        if (Utils.isExists(data.attr.id)) this.id = data.attr.id;
        if (Utils.isExists(data.data)) this.title = data.data;
        if (Utils.isExists(data.attr.text)) this.text = unescape(data.attr.text);
        if (Utils.isExists(data.attr.isBounded)) this.isBounded = (data.attr.isBounded === "true");
        if (Utils.isExists(data.attr.isCaseSensitive)) this.isCaseSensitive = (data.attr.isCaseSensitive === "true");
        if (Utils.isExists(data.attr.questionType)) this.type = data.attr.questionType;
        if (Utils.isExists(data.attr.categoryID)) this.categoryID = data.attr.categoryID;
        if (Utils.isExists(data.attr.answers)) {
            this.answers.doEmpty();
            var answers = eval("(" + data.attr.answers + ")");
            for (key in answers) {
                var answer = answers[key];
                this.answers.doLoad(this.type, answer);
            }
        }
    }
    
    this.rawJSON = {};
}

QuestionModelProxy.prototype = {
    doCreate : function(parentID){
        var _this = this;
        this.categoryID = parentID;
        
        $.post(Utils.getContextPath() + "/services/question/",
            this.toString(),
            function(response){
                _this.rawJSON = eval("(" + response + ")");
                _this.fromJSON(_this.rawJSON);
                _this.onCreate.notify();
            })
    },
    
    doUpdate : function() {
        var _this = this;
        $.post(Utils.getContextPath() + "/services/question/Update",
            this.toString(),
            function(response){
                _this.rawJSON = eval("(" + response + ")");
                _this.fromJSON(_this.rawJSON);
                _this.onUpdate.notify();
            })
    },
    
    doUpdateAnswers: function() {
        $.post(Utils.getContextPath() + "/services/question/SetAnswers",
        {
            "questionID": this.id,
            "questionType": this.type,
            "answerData": this.answers.toString()
        });
    },
    
    doDelete : function() {
        var _this = this;
        $.post(Utils.getContextPath() + "/services/question/Delete",
            this.toString(),
            function(){
                _this.onDelete.notify();
            });
    }
}