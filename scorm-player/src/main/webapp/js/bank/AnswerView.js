var AnswerView = function(controller){
    this.model = null;
    this.controller = controller;
    
    this.cache = null;
    this.domElement = null;
    
    this.nextAnswerTitle = 1;
    
    this.setModel = function(model) {
        var _this = this;
        
        if (this.model != null) {
            // clear event bindings to stop propagation
            this.model.onCreate.stopPropagation();
            this.model.onEmpty.stopPropagation();
            this.model.onDelete.stopPropagation();
        }
        
        this.model = model;
        this.controller.setModel(model);
        
        this.model.onCreate.attach(function(notifier, entity){
            _this.doAdd(entity);
        });
        
        this.model.onEmpty.attach(function(){
            _this.doEmpty();
        });
        
        this.model.onDelete.attach(function(notifier, id){
            $("#SCORMAnswer_" + id).remove();
            _this.updateIndeces();
            _this.nextAnswerTitle--;
        });
        
        this.doShow();
    }
}

AnswerView.prototype = {
    init : function(domElementID, cache) {
        var _this = this;
        
        this.domElement = $("#" + domElementID);
        this.cache = cache;
        
        $("#SCORMQuestionAnswersEditors").sortable({
            placeholder: "ui-state-highlight",
            stop: function() { 
                _this.updateIndeces(); 
            }
        }).disableSelection();
    },
    
    updateIndeces: function(){
        var answers = $("#SCORMQuestionAnswersEditors").sortable("toArray");
        this.model.answerOrder = [];
        var currentIndex = 1;
        for (key in answers) {
            var answerID = answers[key].replace("SCORMAnswer_", "");
            this.model.answerOrder.push(answerID);
            $("#SCORMAnswerTitleID_" + answerID).html(currentIndex);
            currentIndex++;
        }
    },
    
    doAdd : function(entity){
        var _this = this;
        var _entityID = entity.id;
        
        if (entity instanceof ChoiceAnswer) {
            this.domElement.append(Mustache.to_html(this.cache.getTemplate("ChoiceAnswerEdit"), entity.toJSON()));
            $("#SCORMAnswerIsCorrect_" + _entityID).attr("checked", entity.isCorrect);
            $("#buttonSCORMEditText_" + _entityID).click(function(){
                RichEditView.show('Answer text','SCORMAnswerText_' + _entityID, function(data){
                    entity.answerText = data;
                });
            });
            $("#SCORMAnswerIsCorrect_" + _entityID).change(function(){
                entity.isCorrect = $("#SCORMAnswerIsCorrect_" + _entityID).is(':checked');
            });
            
        } else if (entity instanceof ShortAnswer) {
            this.domElement.append(Mustache.to_html(this.cache.getTemplate("ShortAnswerEdit"), entity.toJSON()));
            $("#buttonSCORMEditText_" + _entityID).click(function(){
                RichEditView.show('Answer text','SCORMAnswerText_' + _entityID, function(data){
                    entity.answerText = data;
                });
            });
        } else if (entity instanceof NumericAnswer) {
            this.domElement.append(Mustache.to_html(this.cache.getTemplate("NumericAnswerEdit"), entity.toJSON()));
            $("#SCORMAnswerRangeFrom_" + _entityID).change(function(){
                entity.rangeFrom = parseFloat($("#SCORMAnswerRangeFrom_" + _entityID).val());
            });
            $("#SCORMAnswerRangeTo_" + _entityID).change(function(){
                entity.rangeTo = parseFloat($("#SCORMAnswerRangeTo_" + _entityID).val());
            });
            
        } else if (entity instanceof PositioningAnswer) {
            this.domElement.append(Mustache.to_html(this.cache.getTemplate("PositioningAnswerEdit"), entity.toJSON()));
            $("#SCORMAnswerIsCorrect_" + _entityID).attr("checked", entity.isCorrect);
            $("#buttonSCORMEditText_" + _entityID).click(function(){
                RichEditView.show('Answer text','SCORMAnswerText_' + _entityID, function(data){
                    entity.answerText = data;
                });
            });
            $("#SCORMAnswerIsCorrect_" + _entityID).change(function(){
                entity.isCorrect = $("#SCORMAnswerIsCorrect_" + _entityID).is(':checked');
            });
        } else if (entity instanceof MatchingAnswer) {
            this.domElement.append(Mustache.to_html(this.cache.getTemplate("MatchingAnswerEdit"), entity.toJSON()));
            $("#buttonSCORMEditText_" + _entityID).click(function(){
                RichEditView.show('Answer text','SCORMAnswerText_' + _entityID, function(data){
                    entity.answerText = data;
                });
            });
            $("#buttonSCORMEditSubquestionText_" + _entityID).click(function(){
                RichEditView.show('Subquestion text','SCORMAnswerSubquestionText_' + _entityID, function(data){
                    entity.subquestionText = data;
                });
            });
        }
        
        $("#buttonSCORMDeleteAnswer_" + _entityID).click(function(){
            _this.controller.doDelete(_entityID);
        });
        
        $("#SCORMAnswerTitleID_" + _entityID).html(this.nextAnswerTitle);
        this.nextAnswerTitle++;
        
        this.updateIndeces();
    },
    
    doEmpty : function() {
        this.domElement.empty();
        this.nextAnswerTitle = 1;
    },
    
    doShow : function(){
        this.doEmpty();
        for (key in this.model.answers) {
            this.doAdd(this.model.answers[key]);
        }
    }
}