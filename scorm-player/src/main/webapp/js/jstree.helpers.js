var jsTreeHelpers = function(domElementID) {
    var domElement = $("#" + domElementID);
    var jsTreeRef = jQuery.jstree._reference('#' + domElementID);
    
    this.getReference = function(){
        return jsTreeRef;
    }
    
    this.isLoaded = function(node) {
        return jsTreeRef._is_loaded ( node );
    }
    
    this.getCurrentNode = function() {
        if (!jsTreeRef) return null;
        var currentNode = jsTreeRef.get_selected();
        if (currentNode.length == 0) { // current node not found, return -1
            return null;
        } else {
            return currentNode;
        }
    }

    this.getCurrentNodeID = function() {
        var node = this.getCurrentNode();
        if (!node) { // current node not found, return -1
            return -1;
        } else {
            return node.attr("id");
        }
    }

    this.selectNode = function(node) {
        jsTreeRef.deselect_all(); // drop selection from current
        jsTreeRef.select_node(node);
    }

    this.selectParentNode = function() {
        var currentNode = this.getCurrentNode();
        var prevNode;

        if (currentNode == null) {
            prevNode = domElement.children("ul:first").children("li:first");
        } else {
            prevNode = jsTreeRef._get_parent(currentNode);
        }
        jsTreeRef.deselect_all(); // drop selection from current
        jsTreeRef.select_node(prevNode);
    }
    
    this.selectNextNode = function()
    {
        var currentNode = this.getCurrentNode();
        if (!jsTreeRef.is_leaf(currentNode))
            jsTreeRef.open_node(currentNode);
                
        var nextNode = jsTreeRef._get_next(currentNode);
        if (currentNode.length == 0) // current node not found, jmp to first
            nextNode = $('#' + domElementID).children("ul:first").children("li:first");
                
        jsTreeRef.deselect_all();
        jsTreeRef.select_node(nextNode);
    }
            
    this.selectPrevNode = function()
    {
        var currentNode = this.getCurrentNode();
        var prevNode = jsTreeRef._get_prev(currentNode);
        if (currentNode.length == 0) // not found
            prevNode = $('#' + domElementID).children("ul:first").children("li:last");
                
        if (!jsTreeRef.is_leaf(prevNode))
        {
            if (!jsTreeRef.is_open(prevNode))
            {
                jsTreeRef.open_node(prevNode);
                prevNode = prevNode.children("ul:first").children("li:last");
            }
        }
              
        jsTreeRef.deselect_all();
        jsTreeRef.select_node(prevNode);
    }

    this.selectFirstNode = function() {
        var first = $('#' + domElementID).children("ul:first").children("li:first");
        jsTreeRef.deselect_all();
        jsTreeRef.select_node(first);
    }
            
    this.selectLastNode = function() {
        var lastNode = $('#' + domElementID).children("ul:first").children("li:last");
        if (!jsTreeRef.is_leaf(lastNode))
        {
            if (!jsTreeRef.is_open(lastNode))
                jsTreeRef.open_node(lastNode);
            lastNode = lastNode.children("ul:first").children("li:last");
        }
        jsTreeRef.deselect_all();
        jsTreeRef.select_node(lastNode);
    }

    this.openCurrentNode = function() {
        var currentNode = this.getCurrentNode();
        if (!jsTreeRef.is_open(currentNode)) jsTreeRef.open_node(currentNode);
    }

    this.createNewNode = function(data, parent,needSelect) {
        var _this = this;
        var parentNode = parent || (function(){
            var currentNode = _this.getCurrentNode();
            if (!currentNode) { //select first node
                return $('#' + domElementID).children("ul:first").children("li:first");
            } else {
                return currentNode;
            }
        })();
        jsTreeRef.select_node(parentNode);
        if(needSelect){
            if (data.attr.rel=="folder"){
                var children = parentNode.children("ul").children("li"); // get all child nodes
                var position=0;
                for(var i=0;i<children.length; i++ ){
                    
                    if( children[i].attributes.getNamedItem("rel").nodeValue == "folder")
                        position++;
                }
                return $('#' + domElementID).jstree("create_node", null, position, data);
            }
        }
        return $('#' + domElementID).jstree("create_node", null, "last", data);

    }
    
    this.toggleNode = function(node) {
        if (!jsTreeRef.is_leaf(node)){
            if (!jsTreeRef.is_open(node))
                jsTreeRef.open_node(node);
            else
                jsTreeRef.close_node(node);
        }
    }
    
    this.deleteNode = function(node) {
        domElement.jstree("delete_node", node);
        this.selectParentNode();
    }
    
    this.renameNode = function(node, name) {
        jsTreeRef.set_text(node, name);
    }
};