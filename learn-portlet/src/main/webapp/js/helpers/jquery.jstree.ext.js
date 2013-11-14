_.extend(jsTreeView.prototype, {
    selectNextNode:function () {
        this.jsTreeRef.deselect_all();

        var currentNode = this.getCurrentNode();
        if (!this.jsTreeRef.is_leaf(currentNode))
            this.jsTreeRef.open_node(currentNode);

        var nextNode = this.jsTreeRef._get_next(currentNode);
        if (currentNode.length == 0) // current node not found, jmp to first
            nextNode = this.$el.children("ul:first").children("li:first");

        this.jsTreeRef.select_node(nextNode);
    },

    selectPrevNode:function () {
        var currentNode = this.getCurrentNode();
        var prevNode = this.jsTreeRef._get_prev(currentNode);
        if (currentNode.length == 0) // not found
            prevNode = this.$el.children("ul:first").children("li:last");

        if (!this.jsTreeRef.is_leaf(prevNode)) {
            if (!this.jsTreeRef.is_open(prevNode)) {
                this.jsTreeRef.open_node(prevNode);
                prevNode = prevNode.children("ul:first").children("li:last");
            }
        }

        this.jsTreeRef.deselect_all();
        this.jsTreeRef.select_node(prevNode);
    },

    getCheckedNodes:function () {
        // valid only in case of using "checkbox" plugin
        var checkedIDs = [];
        for (key in this.nodeCache) {
            var node = this.nodeCache[key];
            if (this.jsTreeRef.is_checked(node)) checkedIDs.push(key);
        }
        return checkedIDs;
    },

    toggleNode:function (node) {
        if (!this.jsTreeRef.is_leaf(node)) {
            if (!this.jsTreeRef.is_open(node))
                this.jsTreeRef.open_node(node);
            else
                this.jsTreeRef.close_node(node);
        }
    }
});