// document ready
$(function() {
    $.blockUI();
    var templateCache = uploadTemplates();
    
    var collectionModel = new CollectionModel();
    var collectionController = new QuestionbankController(collectionModel);
    var collectionView = new QuestionbankView(collectionModel, collectionController);
    var itemView = new ItemView(collectionView,collectionModel, collectionController);

    RichEditView.init("RichTextEdit");
    
    initToolbar();
    $(document).ajaxStop($.unblockUI);
    
    function uploadTemplates(){
        var templateCache = new TemplateCache();
    
        templateCache.addTemplate("ChoiceAnswerEdit", "/templates/ChoiceAnswerEdit.html");
        templateCache.addTemplate("ShortAnswerEdit", "/templates/ShortAnswerEdit.html");
        templateCache.addTemplate("NumericAnswerEdit", "/templates/NumericAnswerEdit.html");
        templateCache.addTemplate("PositioningAnswerEdit", "/templates/PositioningAnswerEdit.html");
        templateCache.addTemplate("MatchingAnswerEdit", "/templates/MatchingAnswerEdit.html");
    
        templateCache.addTemplate("CategoryEdit", "/templates/CategoryEdit.html");
        templateCache.addTemplate("CategoryView", "/templates/CategoryView.html");
        templateCache.addTemplate("QuestionEditView", "/templates/QuestionEditView.html");
    
        templateCache.onComplete.attach(initView);
    
        return templateCache;
    }

    function initToolbar() {
        $("#buttonAddCategory").button().click(function(){
            if(itemView.isSaved == false){
                if(confirm('You really want to exit without saving?'))
                {
                    itemView.isSaved = false;
                    collectionView.isSaved =itemView.isSaved;
                    collectionController.createCategory();
                }else{
                    
            }
            }else{
                itemView.isSaved = false;
                collectionView.isSaved =itemView.isSaved;
                collectionController.createCategory();
            }
        });
        $("#buttonDeleteCategory").button().click(function(){
            if(itemView.isSaved == false){
                if(confirm('You really want to exit without saving?'))
                {
                    itemView.isSaved = true;
                    collectionView.isSaved =itemView.isSaved;
                    collectionController.deleteCategory();
                }else{
                    
            }
            }else{
                itemView.isSaved = true;
                collectionView.isSaved =itemView.isSaved;
                collectionController.deleteCategory();
            }
            
        });
        $("#buttonAddQuestion").button().click(function(){
            if(itemView.isSaved == false){
                if(confirm('You really want to exit without saving?'))
                {
                    itemView.isSaved = false;
                    collectionView.isSaved =itemView.isSaved;
                    collectionController.createQuestion();
                }else{
                    
            }
            }else{
                itemView.isSaved = false;
                collectionView.isSaved =itemView.isSaved;
                collectionController.createQuestion();
            }
            
        });
        $("#buttonDeleteQuestion").button().click(function(){
            if(itemView.isSaved == false){
                if(confirm('You really want to exit without saving?'))
                {
                    itemView.isSaved = true;
                    collectionView.isSaved =itemView.isSaved;
                    collectionController.deleteQuestion();
                }else{
                    
            }
            }else{
                itemView.isSaved = true;
                collectionView.isSaved =itemView.isSaved;
                collectionController.deleteQuestion();
            }
            
        });
    }

    function initView() {
        collectionView.init("SCORMQuestionBankTree");
        itemView.init(templateCache, "ItemView");
    }
});