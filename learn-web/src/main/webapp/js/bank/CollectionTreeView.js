QuestionBankCollectionTreeView = Backbone.View.extend({
    initialize:function () {
        this.treeView = this.initQuestionSelectTree();
    },

    initQuestionSelectTree:function () {
        var treeInitParams =
        {
            "themes":{
                "url":Utils.getContextPath() + "/css/jstree/style.css",
                "dots":true,
                "icons":true
            },
            "types":{
                "valid_children":[ "root" ],
                "types":{
                    "entity":{
                        "icon":{
                            "image":Utils.getContextPath() + "/img/icons/book.png"
                        },
                        "valid_children":"none"
                    },
                    "root":{
                        "icon":{
                            "image":Utils.getContextPath() + "/img/icons/database.png"
                        },
                        "valid_children":[ "folder", "entity"]
                    },
                    "folder":{
                        "icon":{
                            "image":Utils.getContextPath() + "/img/icons/folder.png"
                        },
                        "valid_children":[ "folder", "entity"]
                    }
                }
            },
            "json_data":{
                "data":[
                    { // root
                        "data":this.options.language['treeRootElement'],
                        "state":"open",
                        "attr":{
                            "id":"-1",
                            "rel":"root"
                        }
                    }
                ]
            },
            "crrm":{
                "move":{
                    "check_move":function (m) {
                        // ohoho, try to refactor
                        var dndMode = m.p;
                        var fromRel = m.o.attr("rel");
                        var toRel = m.r.attr("rel");
                        var nextNode = m.r.next();
                        var prevNode = m.r.prev();
                        //if(!this._get_parent(m.o)) return false;

                        if (dndMode == "last" && toRel == "folder" && fromRel == "entity")
                            return true;
                        if (dndMode == "inside" && toRel == "folder")
                            return true;
                        if ((dndMode == "before" || dndMode == "after") && fromRel == "entity" && toRel == "entity")
                            return true;
                        if (dndMode == "after" && fromRel == "entity" && toRel == "folder" && (nextNode.attr("rel") == "entity" || nextNode.length == 0))
                            return true;
                        if (dndMode == "last" && fromRel == "entity" && toRel == "folder")
                            return true;
                        if (fromRel == "folder" && toRel == "folder")
                            return true;
                        if (fromRel == "folder" && toRel == "entity" && prevNode.attr("rel") == "folder" && dndMode == "before")
                            return true;
                        return false;
                    }
                }
            },
            "dnd":{
                "drop_target":false,
                "drag_target":false
            },
            "group":function (a, b) {
                var priorities = {
                    "default":0,
                    "folder":1,
                    "entity":2
                };
                var aType = jQuery(a).attr('rel').toLowerCase();
                var bType = jQuery(b).attr('rel').toLowerCase();
                return priorities[aType] - priorities[bType];
            },
            "plugins":[ "themes", "ui", "json_data", "types", "dnd", "crrm", "group"]
        };

        var treeView = new jsTreeView({
            el:this.$el,
            collection:this.collection,
            initParams:treeInitParams
        });


        treeView.addBind("open_node.jstree", jQuery.proxy(function (e, data) {
            var element = data.rslt.obj;
            if (treeView.isNodeLoaded(element)) {
                element.children("a").addClass("jstree-loading");

                var cid = element.attr("id");
                this.collection.fetchForParent(cid);
            }
            treeView.selectNode(element);
        }, this));

        treeView.addBind("select_node.jstree", jQuery.proxy(function () {
            this.onSelectItem();
        }, this));

        treeView.addBind("dblclick.jstree", function () {
            treeView.toggleNode(treeView.getCurrentNode());
        });

        treeView.addBind("move_node.jstree", jQuery.proxy(function (e, data) {
            treeView.selectNode(treeView.getNodeByID(data.rslt.o.attr("id")));
            var id = treeView.getNodeID(treeView.getCurrentNode());
            if (id == -1) return;
            this.collection.getEntity(id).move({
                targetId:this.collection.getEntity(data.rslt.r.attr("id")).id,
                dndMode:data.rslt.p,
                itemType:data.rslt.r.attr("rel")
            });
        }, this));

        return treeView;
    },

    onSelectItem:function () {
        var id = this.treeView.getNodeID(this.treeView.getCurrentNode());
        if (id == -1) {
            // clear view
            this.trigger('clear-selection');
            return;
        }
        this.trigger('model-selection', this.collection.getEntity(id));
    }
});