// jsTree helpers
function createNewCategory() {
    // select parent folder, if currently question node selected
    var currentNode = getCurrentNode();
    if (currentNode) {
        if (currentNode.attr("rel") == "default") {
            selectParentNode();
        }
    } else {
		selectRootNode();
		currentNode = getCurrentNode();
	}
    $.post("/scorm-player/services/category",
    {
        title: "New category",//$("#SCORMNewQuestionCategoryTitle").val(),
        description: "",//$("#SCORMNewQuestionCategoryDescription").val(),
        parentID:getCurrentNodeID()
    },
    function(data){
        var newCategory = createNewNode({
            "data" : "New category",
            "attr" : {
                "id" : data,
                "rel" : "folder",
                "description": "",
                "parentID" : getCurrentNodeID()
            }
        });
        selectNode(newCategory);
        showCategoryEdit();
    });
}

function updateCategory(){
    var newCategoryName = $("#SCORMCategoryNameEdit").val();
    var newCategoryDescription = $("#SCORMCategoryDescriptionEdit").val();
    var nodeID = getCurrentNodeID();
    var parentID = getCurrentNode().attr("parentID");
    $.post("/scorm-player/services/category/Update",
    {
        id:nodeID,
        title: newCategoryName,
        description: escape(newCategoryDescription),
        parentID: parentID
    },
    function(){
        var currentNode = getCurrentNode();
        jQuery.jstree._reference('#SCORMQuestionBankTree').set_text(null,newCategoryName);
        currentNode.attr("description",newCategoryDescription);
        showCategoryInfo();
    });
}

function deleteCategory() {
    $.post("/scorm-player/services/category/Delete",
    {
        id : getCurrentNodeID()
    },
    function(data){
        $('#SCORMQuestionBankTree').jstree("delete_node", null);
    });
}

function createNewQuestion() {
    var currentNode = getCurrentNode();
    var parentCategoryID;
    if (!currentNode) {
        parentCategoryID = -1;
    } else {
        if (currentNode.attr("rel") == "default") {
            selectParentNode();
            parentCategoryID = currentNode.attr("categoryID");
        } else {
            parentCategoryID = currentNode.attr("id");
        }
    }
    $.post("/scorm-player/services/question/",
    {
        type : 0,
        categoryID : parentCategoryID,
        isBounded : false,
        isCaseSensitive : false,
        title : "New question",
        text : ""
    },
    function(data){
        var newQuestion = createNewNode({
            "data" : "New question",
            "attr" : {
                "id" : data,
                "rel" : "default",
                "text" : "",
                "categoryID" : parentCategoryID,
                "questionType" : 0,
                "isBounded" : false,
                "isCaseSensitive" : false,
                "answers" : "[]"
            }
        });
        selectParentNode();
        openCurrentNode();
        selectNode(newQuestion);
    });
}

function updateQuestion() {
    var newQuestionTitle = $("#SCORMQuestionTitleEdit").val();
    var newQuestionText = escape($("#SCORMQuestionTextView").html());
    var questionType = getCurrentNode().attr("questionType");
    var nodeID = getCurrentNodeID();
    var isBounded = $("#SCORMQuestionBounded").is(':checked');
    var isCaseSensitive = $("#SCORMQuestionCaseSensitive").is(':checked');
    var parentID = getCurrentNode().attr("categoryID");
    $.post("/scorm-player/services/question/Update",
    {
        "id": nodeID,
        "type": questionType,
        "title": newQuestionTitle,
        "text": newQuestionText,
        "isBounded": isBounded,
        "isCaseSensitive": isCaseSensitive,
        "categoryID": parentID
    },
    function(){
        var currentNode = getCurrentNode();
        jQuery.jstree._reference('#SCORMQuestionBankTree').set_text(null,unescape(newQuestionTitle));
        currentNode.attr("text",newQuestionText);
        currentNode.attr("type",questionType);
        currentNode.attr("isBounded",isBounded);
        currentNode.attr("isCaseSensitive",isCaseSensitive);
        currentNode.attr("categoryID",parentID);
        updateAnswers(nodeID);
    });
}

function updateAnswers(questionID) {
    var serializedAnswers = serializeAnswers();
    var currentNode = getCurrentNode();
    var questionType = currentNode.attr("questionType");
    currentNode.attr("answers",serializedAnswers);
    $.post("/scorm-player/services/question/SetAnswers",
    {
        "questionID": questionID,
        "questionType": questionType,
        "answerData": serializedAnswers
    },
    function(){});
}

function deleteQuestion(){
    $.post("/scorm-player/services/question/Delete",
    {
        id : getCurrentNodeID()
    },
    function(data){
        $('#SCORMQuestionBankTree').jstree("delete_node", null);
    });
}