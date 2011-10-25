// document ready
$(function() {
    $.blockUI();
    var templateCache = uploadTemplates();
    
    var collectionModel = new CollectionModel();
    var collectionController = new QuestionbankController(collectionModel);
    var collectionView = new QuestionbankView(collectionModel, collectionController);
    var itemView = new ItemView(collectionModel, collectionController);

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
            collectionController.createCategory();
        });
        $("#buttonDeleteCategory").button().click(function(){
            collectionController.deleteCategory();
        });
        $("#buttonAddQuestion").button().click(function(){
            collectionController.createQuestion();
        });
        $("#buttonDeleteQuestion").button().click(function(){
            collectionController.deleteQuestion();
        });
    }

    function initView() {
        collectionView.init("SCORMQuestionBankTree");
        itemView.init(templateCache, "ItemView");
    }
});