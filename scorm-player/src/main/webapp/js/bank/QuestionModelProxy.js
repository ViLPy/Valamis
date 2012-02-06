var QuestionModelProxy = function(answers){
    this.id = 0;
    this.type = 0;
    this.categoryID = -1;
    this.forceCorrectCount = false;
    this.isCaseSensitive = false;
    this.title = "New question";
    this.text = "";
    this.explanationText="";
    this.position = 0;
    this.dndMode="";
    this.targetId = -2;
    this.itemType = "";
    
    this.answers = new AnswersModel();
    
    this.onCreate = new Event(this);
    this.onUpdate = new Event(this);
    this.onAnswersUpdate = new Event(this);
    this.onDelete = new Event(this);
    
    this.toString = function() {
        return "id=" + this.id +
        "&type=" + this.type +
        "&categoryID=" + this.categoryID +
        "&forceCorrectCount=" + this.forceCorrectCount + 
        "&isCaseSensitive=" + this.isCaseSensitive +
        "&title=" + this.title +
        "&text=" + escape(this.text) + 
        "&explanationText=" + escape(this.explanationText) + 
        "&answers=" + this.answers.toString()+
        "&position=" + this.position+
        "&dndMode=" + this.dndMode+
        "&targetId=" + this.targetId+
        "&itemType=" + this.itemType;
    }
    
    this.fromJSON = function(data) {
        if (Utils.isExists(data.attr.id)) this.id = data.attr.id;
        if (Utils.isExists(data.data)) this.title = data.data;
        if (Utils.isExists(data.attr.text)) this.text = unescape(data.attr.text);
        if (Utils.isExists(data.attr.explanationText)) this.explanationText = unescape(data.attr.explanationText);
        if (Utils.isExists(data.attr.forceCorrectCount)) this.forceCorrectCount = (data.attr.forceCorrectCount === "true");
        if (Utils.isExists(data.attr.isCaseSensitive)) this.isCaseSensitive = (data.attr.isCaseSensitive === "true");
        if (Utils.isExists(data.attr.questionType)) this.type = data.attr.questionType;
        if (Utils.isExists(data.attr.categoryID)) this.categoryID = data.attr.categoryID;
        if (Utils.isExists(data.attr.position)) this.position = data.attr.position;
        if (Utils.isExists(data.attr.dndMode)) this.dndMode = data.attr.dndMode;
        if (Utils.isExists(data.attr.targetId)) this.targetId = data.attr.targetId;
        if (Utils.isExists(data.attr.itemType)) this.itemType = data.attr.itemType;
        if (Utils.isExists(data.attr.answers)) {
            this.answers.doEmpty();
            var answers = eval("(" + data.attr.answers.replace(/\\'/g, "'").replace(/[\n]/g, '\\n').replace(/[\r]/g, '\\r') + ")");
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
                _this.rawJSON = response;
                _this.fromJSON(_this.rawJSON);
                _this.onCreate.notify();
            })
    },
    
    doUpdate : function() {
        var _this = this;
        $.post(Utils.getContextPath() + "/services/question/update",
            this.toString(),
            function(response){
                _this.rawJSON = response;
                _this.fromJSON(_this.rawJSON);
                _this.onUpdate.notify();
            })
    },
    
    doMove : function() {
        var _this = this;
        $.post(Utils.getContextPath() + "/services/question/move",
            this.toString(),
            function(response){
                _this.rawJSON = response;
                _this.fromJSON(_this.rawJSON);
                _this.onUpdate.notify();
            })
    },
    
    doUpdateAnswers: function() {
        $.post(Utils.getContextPath() + "/services/question/setanswers",
        {
            "questionID": this.id,
            "questionType": this.type,
            "answerData": this.answers.toString()
        });
    },
    
    doDelete : function() {
        var _this = this;
        $.post(Utils.getContextPath() + "/services/question/delete",
            this.toString(),
            function(){
                _this.onDelete.notify();
            });
    }
}