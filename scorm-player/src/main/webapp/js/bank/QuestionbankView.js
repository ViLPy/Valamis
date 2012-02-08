var currentNodeId ="";
var QuestionbankView = function(collectionModel, collectionController) {
    this.model = collectionModel;
    this.controller = collectionController;
    this.jsTreeHelpers = null;
    this.isSaved=true;
    this.nodeCache = [];
};
QuestionbankView.prototype = {
    
    init : function(domElementID){
        var _this = this;
        // default bindings
        //autoexec function
        (function attachListeners() {
            _this.model.onAdd.attach(function(notifier, entity){
                _this.addItem(notifier, entity, false);
            });
    
            _this.model.onCreate.attach(function(notifier, entity){
                _this.jsTreeHelpers.openCurrentNode();
                _this.addItem(notifier, entity, true);
            });
    
            _this.model.onGet.attach(function(notifier, id){
                _this.nodeCache[id].children("a").removeClass("jstree-loading");
            });
    
            _this.model.onDelete.attach(function(notifier, id) {
                _this.jsTreeHelpers.deleteNode(_this.jsTreeHelpers.getCurrentNode());
                //_this.jsTreeHelpers.deleteNode(_this.nodeCache[id]);
                //delete _this.nodeCache[id];
            });
    
            _this.model.onUpdate.attach(function(notifier, entity){
                _this.jsTreeHelpers.renameNode(_this.jsTreeHelpers.getCurrentNode()/*_this.nodeCache[entity.id]*/, entity.title);
            });
        })();

        // init tree view
        var contextPath = Utils.getContextPath();
        var domElement = $("#" + domElementID);
        domElement.bind("loaded.jstree", function(){
            _this.jsTreeHelpers = new jsTreeHelpers(domElementID);
            _this.jsTreeHelpers.selectParentNode();
            _this.jsTreeHelpers.openCurrentNode();
            _this.nodeCache["-1"] = _this.jsTreeHelpers.getCurrentNode();
        })
        .jstree({
            "types" : {
                "valid_children" : [ "root" ],
                "types" : {
                    "entity" : {
                        "icon" : {
                            "image" : contextPath + "/css/category-bank/book.png"
                        },
                        "valid_children" : "none"
                    },
                    "root" : {
                        "icon" : {
                            "image" : contextPath + "/css/category-bank/database.png"
                        },
                        "valid_children" : [ "folder", "entity"]
                    },
                    "folder" : {
                        "icon" : {
                            "image" : contextPath + "/css/category-bank/folder.png"
                        },
                        "valid_children" : [ "folder", "entity"]
                    }
                }
            },
            "themes" : {
                "url" : contextPath + "/css/jstree/style.css",
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
                }]
            },
            "crrm" : {
                "move" : {
                    "check_move" : function (m) {
                        var dndMode = m.p;
                        var fromRel = m.o.attr("rel");
                        var toRel = m.r.attr("rel");
                        var nextNode = m.r.next();
                        var prevNode = m.r.prev();
                        var p = this._get_parent(m.o);
                        if(!p) return false;
                        if(dndMode=="last" && toRel=="folder")
                            return true;
                        if(dndMode=="inside" && toRel=="folder")
                            return true;
                        if((dndMode=="before" || dndMode=="after") && fromRel=="entity" && toRel=="entity")
                            return true;
                        if(dndMode=="after" && fromRel=="entity" && toRel=="folder" && (nextNode.attr("rel")=="entity" || nextNode.length ==0))
                            return true;
                        if(dndMode=="last" && fromRel=="entity" && toRel=="folder")
                            return true;
                        if( fromRel=="folder" && toRel=="folder")
                            return true;
                        if( fromRel=="folder" && toRel=="entity" && prevNode.attr("rel")=="folder" && dndMode=="before")
                            return true;
                        return false;
                    }
                }
            },
            "dnd" : {
                "drop_target" : false,
                "drag_target" : false
            },
            "plugins" : [ "themes", "ui", "json_data", "types","dnd","crrm" ]
        }).bind("select_node.jstree", function(event, data) {
            switch (data.rslt.obj.attr("rel")) {
                case "folder":
                case "entity":
                    _this.controller.selectItem(data.rslt.obj.attr("rel"), _this.jsTreeHelpers.getCurrentNodeID());
                    break;
                case "root":
                    _this.controller.clearSelection();
                    break;
            }
        }).bind("dblclick.jstree", function() {
            var jsTreeHelper = _this.jsTreeHelpers;
            jsTreeHelper.toggleNode(jsTreeHelper.getCurrentNode());
        }).bind("move_node.jstree", function (event, data){ 
            _this.controller.selectItem(data.rslt.o.attr("rel"),data.rslt.o.attr("id"));
            _this.controller.updateQuestionParent({
                targetId : data.rslt.r.attr("id"),
                dndMode:data.rslt.p,
                itemType:data.rslt.r.attr("rel")
            });
                        
        }).bind("open_node.jstree", function(e, data) {
            var element = data.rslt.obj;
            if (_this.jsTreeHelpers.isLoaded(element)) {
                //if (!_this.nodeCache[element.attr("id")]) {
                element.children("a").addClass("jstree-loading");
                _this.controller.loadData(element.attr("id"));
            }
            _this.jsTreeHelpers.selectNode(element);
        });
    },
    
    addItem: function(notifier, entity, needSelect){
        var currentNode = this.jsTreeHelpers.getCurrentNode();
        var newCategory = null;
        if (entity instanceof CategoryModelProxy) {
            newCategory = this.jsTreeHelpers.createNewNode(entity.rawJSON, this.nodeCache[entity.parentID],needSelect);
            this.nodeCache[newCategory.attr("id")] = newCategory;
            if (needSelect) {
                this.jsTreeHelpers.selectNode(newCategory);
            } else {
                this.jsTreeHelpers.selectNode(currentNode);
            }
        } else if (entity instanceof QuestionModelProxy) {
            newCategory = this.jsTreeHelpers.createNewNode(entity.rawJSON, this.nodeCache[entity.categoryID]);
            //this.nodeCache[newCategory.attr("id")] = newCategory;
            if (needSelect) {
                this.jsTreeHelpers.selectNode(newCategory);
            } else {
                this.jsTreeHelpers.selectNode(currentNode);
            }
        }
    }
};

