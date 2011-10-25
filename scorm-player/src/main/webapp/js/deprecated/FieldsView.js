var FieldsView = function(model, controller){
    this.model = model;
    this.controller = controller;
    this.domElement = null;
    
    var _this = this;
    this.model.onGetAll.attach(function(notifier){
        _this.fill();
    });
    
    this.convertToFieldModel = function(category) {
        return {
            id: category.id,
            title: category.title,
            category: this.model.root[category.parentID].title,
            description: category.description
        };
    }
};

FieldsView.prototype = {
    init: function(domElementID){
        this.domElement = $("#" + domElementID);
        this.domElement.dialog({
            modal: true,
            width: 650,
            title: "Quiz fields"
        });
        //this.hide();
        
        this.domElement.append("<table id='SCORMQuizFields'/>");
        $("#SCORMQuizFields").jqGrid({    
            datatype: "local",
            colNames:['#','Field category', 'Field title', 'Description'],
            colModel:[ {
                name:'id',
                index:'id', 
                width:50,
                hidden:true
            }, {
                name:'category',
                index:'category', 
                width:150,
                sorttype:"string"
            }, {
                name:'title',
                index:'title', 
                width:170
            }, {
                name:'description',
                index:'description', 
                width:300
            }],
            rowNum:10,
            rowList:[10,20,30],
            sortname: 'category',
            viewrecords: true,
            sortorder: "desc",
            toolbar: [true,"top"],
            jsonReader: {
                repeatitems : false,
                id: "0"
            },
            grouping:true,
            groupingView : {
                groupField : ['category'],
                groupColumnShow : [false],
                groupCollapse : true
            },
            height: '100%'
        });
        
        $("#t_SCORMQuizFields").height(46)
        .append("<input type='button' id='buttonSCORMNewArea' style='height:30px' value='Add field'/>")
        .append("<input type='button' id='buttonSCORMEditArea' style='height:30px' value='Edit'/>")
        .append("<input type='button' id='buttonSCORMDeleteArea' style='height:30px' value='Delete'/>");
        
        $("#buttonSCORMNewArea").css("margin-left","5px")
        .click(function(){});
        $("#buttonSCORMEditArea").css("margin-left","5px")
        .click(function(){});
        $("#buttonSCORMDeleteArea").css("margin-left","5px")
        .click(function(){});
        
        this.controller.getAll();
    },
    
    fill: function(){
        for(key in this.model.elements){
            var field = this.convertToFieldModel(this.model.elements[key]);
            $("#SCORMQuizFields").jqGrid('addRowData',key,field);
        }
        
        $("#SCORMQuizFields").trigger("reloadGrid");
    },
    
    show: function(){
        this.domElement.dialog("open");
    },
    
    hide: function(){
        this.domElement.dialog("close");
    }
};