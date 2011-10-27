var ItemView = function(model, controller){
    this.view = null;
    this.model = model;
    this.controller = controller;
    
    this.answerEditView = null;
}

ItemView.prototype = {
    init: function(cache, domElementID) {
        var _this = this;
        
        this.view = $("#" + domElementID);
        
        this.view.append(cache.getTemplate('QuestionEditView'));
        this.view.append(cache.getTemplate('CategoryEdit'));
        this.view.append(cache.getTemplate('CategoryView'));
        
        this.answerEditView = new AnswerView(new AnswerController());
        this.answerEditView.init("SCORMQuestionAnswersEditors", cache);

        (function attachListeners(){
            _this.model.onCreate.attach(function(notifier, entity){
                _this.doEdit(entity);
            });
    
            _this.model.onSelect.attach(function(notifier, entity){
                _this.doView(entity);
            });
    
            _this.model.onClearSelection.attach(function(){
                _this.doClear();
            });
        })();
        
        (function attachControls(){
            // category
            $("#buttonUpdateCategory").click(function(){
                _this.controller.updateCategory({
                    name: $("#SCORMCategoryNameEdit").val(),
                    description: $("#SCORMCategoryDescriptionEdit").val()
                });
            });
            $("#buttonShowCategoryEdit").click(function(){
                var currentElement = _this.model.currentElement;
                _this.doEdit(currentElement);
            });
            $("#buttonShowCategoryInfo").click(function(){
                var currentElement = _this.model.currentElement;
                _this.doView(currentElement);
            });
        
            // question edit
            $("#buttonUpdateQuestion").click(function(){
                _this.controller.updateQuestion({
                    type : $("#SCORMQuestionType").val().replace("type",""),
                    isBounded : $("#SCORMQuestionBounded").is(':checked'),
                    isCaseSensitive : $("#SCORMQuestionCaseSensitive").is(':checked'),
                    title : $("#SCORMQuestionTitleEdit").val(),
                    text : escape($("#SCORMQuestionTextView").html())
                });
            });
        
            $("#SCORMQuestionType").change(function(){
                _this.doUpdateView();
                _this.answerEditView.controller.doEmpty();
            });
            
            $("#SCORMButtonAddAnswer").click(function(){
                _this.answerEditView.controller.doAdd(parseInt($("#SCORMQuestionType").val().replace("type","")));
            });
        })();
        
        this.doClear();
    },
    
    doUpdateView : function() {
        $("#SCORMQuestionIsBounded").hide();
        $("#SCORMQuestionIsCaseSensitive").hide();
        $("#SCORMQuestionAnswers").show();
        
        switch ($("#SCORMQuestionType").val()){
            case "type0":
            case "type3":
                $("#SCORMQuestionIsBounded").show();
                break;
            case "type1":
                $("#SCORMQuestionIsCaseSensitive").show();
                break;
            case "type5":
            case "type6":
                $("#SCORMQuestionAnswers").hide();
                break;
        }
    },
    
    doView: function(entity){
        this.doClear();
        if (entity instanceof CategoryModelProxy) {
            $("#SCORMCategoryNameView").html(entity.title);
            $("#SCORMCategoryDescriptionView").html(entity.description);
            
            $("#SCORMCategoryView").show();
        } else if (entity instanceof QuestionModelProxy) {
            this._showQuestionEdit(entity);
        }
    },
    
    doEdit: function(entity){
        this.doClear();
        if (entity instanceof CategoryModelProxy) {
            $("#SCORMCategoryEdit").show();
            
            $("#SCORMCategoryNameEdit").val(entity.title);
            $("#SCORMCategoryDescriptionEdit").val(entity.description);
        } else if (entity instanceof QuestionModelProxy) {
            this._showQuestionEdit(entity);
        }
    },
    
    doClear: function(){
        $("#SCORMCategoryEdit").hide();
        $("#SCORMCategoryView").hide();
        $("#SCORMQuestionEditor").hide();
    },
    
    _showQuestionEdit : function(entity) {
        this.answerEditView.setModel(this.model.currentElement.answers);
            
        $("#SCORMQuestionType").val("type"+entity.type);
        $("#SCORMQuestionBounded").attr("checked", entity.isBounded);
        $("#SCORMQuestionCaseSensitive").attr("checked", entity.isCaseSensitive);
        $("#SCORMQuestionTitleEdit").val(entity.title);
        $("#SCORMQuestionTextView").html(unescape(entity.text));
        this.doUpdateView();
            
        $("#SCORMQuestionEditor").show();
    }
}