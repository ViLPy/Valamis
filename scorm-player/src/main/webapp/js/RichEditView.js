var RichEditView = {
    domElement : null,
    editElement : null,
    redactor: null,
    callback: function(){},
    
    init : function(domElementID){
        this.domElement = $("#" + domElementID);
        this.domElement.append("<div id='SCORMRichTextEditDialog'><textarea name='SCORMRedactor' id='SCORMRedactor' style='height: 300px; width: 770px;'></textarea></div>");
        
        var _this = this;
        
        $("#SCORMRichTextEditDialog").dialog({
            width: 800, 
            resizable: false,
            autoOpen: false,
            modal: true,
            buttons: {
                Ok: function() {
                    $("#" + _this.editElement).html(_this.redactor.getHtml());
                    $( this ).dialog( "close" );
                    _this.callback(_this.redactor.getHtml());
                },
                Cancel: function() {
                    $( this ).dialog( "close" );
                }
            }
        });
        this.redactor = $('#SCORMRedactor').redactor();
    },
    
    show : function(title, element, callback){
        if (Utils.isExists(callback)) this.callback = callback;
        this.editElement = element;
        this.redactor.setHtml($("#" + this.editElement).html());
        
        $("#SCORMRichTextEditDialog").dialog("option", "title", title);
        $("#SCORMRichTextEditDialog").dialog("open");
    }
};