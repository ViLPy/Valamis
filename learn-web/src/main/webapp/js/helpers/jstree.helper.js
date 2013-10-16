jsTreeModel = Backbone.Model.extend({
    defaults:{
        title:"Node",
        content:null,
        parentID:null,
        type:"default",
        state:null
    },

    getID:function () {
        return this.id.toString().replace(this.get('type'), "");
    }
});

jsTreeElements = Backbone.Collection.extend({
    model:jsTreeModel
});

jsTreeView = Backbone.View.extend({
    //ctor
    initialize:function () {
        this.nodeCache = [];

        this.jsTree = this.$el.jstree(this.options.initParams);
        this.jsTreeRef = jQuery.jstree._reference('#' + this.$el.attr('id'));
        this.treeRoot = this.getRootNode();
        this.selectNode(this.treeRoot);

        this.collection.bind("add", this.addNewItem, this);
        this.collection.bind("reset", this.addItemSet, this);
        this.collection.bind("loaded", this.dropLoadingSign, this);
        this.collection.bind("remove", this.destroyItem, this);

    },

    addBind:function (name, handler) {
        this.jsTree.bind(name, handler);
    },

    /**
     * CRUD operations
     */

    addNewItem:function (itemData) {
        var parent = this.nodeCache[itemData.get('parentID')] || this.treeRoot;
        var position = "last";

        var compiledAttr = {
            "rel":itemData.get('type'),
            "id":itemData.id
        };

        var jsTreeData = {
            "attr":compiledAttr,
            "data":itemData.get('title'),
            "state":itemData.get('state')
        };

        this.nodeCache[itemData.id] = this.jsTreeRef.create_node(parent, position, jsTreeData);
        this.openNode(this.getCurrentNode());

        itemData.get('content').bind("change", this.updateItemTitle, this);
        itemData.get('content').bind("destroy", this.destroyItem, this);
        this.trigger('node-added', this.nodeCache[itemData.id]);
    },

    addItemSet:function () {
        _.each(this.collection, this.addNewItem, this);
    },

    getNodeByID:function (id) {
        if (id == -1) {
            return this.treeRoot;
        } else {
            return this.nodeCache[id];
        }
    },

    getCurrentNode:function () {
        if (!this.jsTreeRef) return null;
        var currentNode = this.jsTreeRef.get_selected();
        if (currentNode.length === 0) { // current node not found, return null
            return null;
        } else {
            return currentNode;
        }
    },

    updateItemTitle:function (model) {
        this.jsTreeRef.set_text(this.nodeCache[model.cid], model.get('title'));
    },

    destroyItem:function (model) {
        var modelIDWithinTree;
        if (model instanceof jsTreeModel) {
            modelIDWithinTree = model.id;
        } else {
            modelIDWithinTree = model.cid;
        }
        if (this.nodeCache[modelIDWithinTree]) {
            this.jsTreeRef.delete_node(this.nodeCache[modelIDWithinTree]);
            delete this.nodeCache[modelIDWithinTree];
        }
    },

    /**
     *  Helpers
     */

    getNodeID:function (node) {
        if (!node) { // current node not found, return -1
            return "-1";
        } else {
            return node.attr("id");
        }
    },

    getRootNode:function () {
        return this.$el.children("ul:first").children("li:first");
    },

    selectNode:function (node) {
        this.jsTreeRef.deselect_all(); // drop selection from current
        this.jsTreeRef.select_node(node);
    },

    openNode:function (node) {
        if (!this.jsTreeRef.is_open(node)) this.jsTreeRef.open_node(node);
    },

    isNodeLoaded:function (node) {
        return this.jsTreeRef._is_loaded(node);
    },

    dropLoadingSign:function (id) {
        var parent = this.nodeCache[id] || this.treeRoot;
        parent.children("a").removeClass("jstree-loading");
    }
});