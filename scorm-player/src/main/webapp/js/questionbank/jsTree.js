/// jsTree methods
// pure jsTree
function createTree()
{
    var contextPath = "";
    if ($("#SCORMContextPath") && $("#SCORMContextPath").length > 0){
        contextPath = $("#SCORMContextPath").val() + "/";
    }
    $("#SCORMQuestionBankTree").bind("loaded.jstree", function () {
        selectRootNode();
        openCurrentNode();
    })
    .jstree({
        "types" : {
            "valid_children" : [ "root" ],
            "types" : {
                "default" : {
                    "icon" : {
                        "image" : contextPath + "css/category-bank/book.png"
                    },
                    "valid_children" : "none"
                },
                "root" : {
                    "icon" : {
                        "image" : contextPath + "css/category-bank/database.png"
                    },
                    "valid_children" : [ "folder", "default"]
                },
                "folder" : {
                    "icon" : {
                        "image" : contextPath + "css/category-bank/folder.png"
                    },
                    "valid_children" : [ "folder", "default"]
                }
            }
        },
        "themes" : {
            "url" : contextPath + "css/jstree/style.css",
            "dots" : true,
            "icons" : true
        },
        "json_data" : {
            "data" : [
            { // root
                "data" : "Question base",
                "state" : "closed",
                "attr" : {
                    "id":"-1",
                    "rel" : "root"
                }
            }],
            "ajax" : {
                "url" : "/scorm-player/services/category/Children",
                "data" : function (n) {
                    return {
                        "id" : n.attr ? n.attr("id").replace("node_","") : -1
                    };
                }
            }
        },
        "plugins" : [ "themes", "ui", "json_data", "types" ]
    }).bind("select_node.jstree", function (event, data) {
        switch (data.rslt.obj.attr("rel")) {
            case "folder":
                showCategoryInfo();
                break;
            case "default":
                showQuestionEdit();
                break;
            case "root":
                hideForms();
                break;
        }
    }).bind("dblclick.jstree", function (event) {
        var jsTree = jQuery.jstree._reference('#SCORMQuestionBankTree');
        var currentNode = jsTree.get_selected();
        if (!jsTree.is_leaf(currentNode)){
            if (!jsTree.is_open(currentNode))
                jsTree.open_node(currentNode);
            else
                jsTree.close_node(currentNode);
        }
    });
}

function getCurrentNode() {
    var jsTree = jQuery.jstree._reference('#SCORMQuestionBankTree');
    if (!jsTree) return null;
    var currentNode = jsTree.get_selected();
    if (currentNode.length == 0) { // current node not found, return -1
        return null;
    } else {
        return currentNode;
    }
}

function getCurrentNodeID() {
    var node = getCurrentNode();
    if (!node) { // current node not found, return -1
        return -1;
    } else {
        return node.attr("id");
    }
}

function selectRootNode(node) {
    var jsTree = jQuery.jstree._reference('#SCORMQuestionBankTree');
    var currentNode = getCurrentNode();

    var first = $('#SCORMQuestionBankTree').children("ul:first").children("li:first");
    if (currentNode) jsTree.reselect(currentNode); // drop selection from current
    jsTree.select_node(first);
    return first;
}

function selectNode(node) {
    var jsTree = jQuery.jstree._reference('#SCORMQuestionBankTree');
    jsTree.deselect_all(); // drop selection from current
    jsTree.select_node(node);
}

function selectParentNode() {
    var currentNode = getCurrentNode();

    var jsTree = jQuery.jstree._reference('#SCORMQuestionBankTree');
    var prevNode = jsTree._get_parent(currentNode);
    jsTree.deselect_all(); // drop selection from current
    jsTree.select_node(prevNode);
}

function openCurrentNode() {
    var currentNode = getCurrentNode();
    var jsTree = jQuery.jstree._reference('#SCORMQuestionBankTree');
    if (!jsTree.is_open(currentNode)) jsTree.open_node(currentNode);
}

function createNewNode(data) {
    if (!getCurrentNode()) {
        //select first node
        var first = $('#SCORMQuestionBankTree').children("ul:first").children("li:first");
        jQuery.jstree._reference('#SCORMQuestionBankTree').select_node(first);
    }
    return $('#SCORMQuestionBankTree').jstree("create_node", null, "last", data);
}