QuestionbankSelectDialog = Backbone.View.extend({
    callback: function(){},
    initialize: function() {
	var that = this;
	var tree = this.initQuestionSelectTree(this.$el.append("<div></div>"));
			
	this.questionDialog = $( "#questionChooseDialog" ).dialog({
	    autoOpen: false,
	    modal: true,
	    buttons: {
		Add: function() {
		    var categories = [];
		    var questions = [];
		    var checkedNodes = tree.getCheckedNodes();
		    for (key in checkedNodes) {
			var nodeID = checkedNodes[key];
			var model = tree.collection.getEntity(nodeID);
			if (model instanceof CategoryModel) {
			    categories.push(model.id);
			} else if (model instanceof QuestionModel) {
			    questions.push(model.id);
			}
		    }
		    jQuery.when($.get(Utils.getContextPath() + "/services/category/children/withQuestions/", {
			categories: categories.join(';'), 
			questions: questions.join(';')
		    })).done(function(response) {
			that.callback.call(that.callbackContext,response);
		    })
		    
		    $( this ).dialog( "close" );
		},
		Cancel: function() {
		    $( this ).dialog( "close" );
		}
	    },
	    open: function() {
		tree.jsTreeRef.close_all();
		tree.selectNode(tree.getRootNode());
		tree.openNode(tree.getCurrentNode());
		tree.jsTreeRef.uncheck_all();
	    }
	});
    },
    
    open: function(callback, context) {
	this.callback = callback;
	this.callbackContext = context;
	this.questionDialog.dialog('open');
    },
    
    initQuestionSelectTree: function(node){
	var treeData = new QuestionBankCollectionProxy();
	var treeInitParams = {
	    "themes" : {
		"url" : Utils.getContextPath() + "/css/jstree/style.css",
		"dots" : true,
		"icons" : true
	    }, 
	    "types" : {
		"valid_children" : [ "root" ],
		"types" : {
		    "entity" : {
			"icon" : {
			    "image" : Utils.getContextPath() + "/img/icons/book.png"
			},
			"valid_children" : "none"
		    },
		    "root" : {
			"icon" : {
			    "image" : Utils.getContextPath() + "/img/icons/database.png"
			},
			"valid_children" : [ "folder", "entity"]
		    },
		    "folder" : {
			"icon" : {
			    "image" : Utils.getContextPath() + "/img/icons/folder.png"
			},
			"valid_children" : [ "folder", "entity"]
		    }
		}
	    },
	    "json_data" : {
		"data" : [
		{ // root
		    "data" : "Question base",
		    "state" : "open",
		    "attr" : {
			"id":"-1",
			"rel" : "root"
		    }
		}]
	    },
	    "plugins" : [ "themes", "ui", "json_data", "types", "checkbox" ]
	}
	var treeView = new jsTreeView({
	    el : $(node),
	    collection : treeData,
	    initParams : treeInitParams
	});
			
	treeView.addBind("open_node.jstree", function(e, data){
	    var element = data.rslt.obj;
	    if (treeView.isNodeLoaded(element)) {
		element.children("a").addClass("jstree-loading");
		
		var cid = element.attr("id");
		treeData.fetchForParent(cid);
	    }
	    treeView.selectNode(element);
	});
	
	treeView.addBind("dblclick.jstree", function() {
	    treeView.toggleNode(treeView.getCurrentNode());
	});
	
	treeData.fetchForParent();
	
	return treeView;
    }
});