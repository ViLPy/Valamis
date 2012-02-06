var Utils = {
    isExists : function(param) {
        return (typeof param != "undefined");
    },

    getContextPath : function(){
        var contextPath = "/scorm-player";
        if ($("#SCORMContextPath") && $("#SCORMContextPath").length > 0){
            contextPath = $("#SCORMContextPath").val() + "/";
        }
        return contextPath;
    },
    
    escapeJSON : function(str) {
        return str
        .replace(/[\"]/g, '\\"')
        .replace(/[\\]/g, '\\\\')
        .replace(/[\/]/g, '\\/')
        .replace(/[\b]/g, '\\b')
        .replace(/[\f]/g, '\\f')
        .replace(/[\n]/g, '\\n')
        .replace(/[\r]/g, '\\r')
        .replace(/[\t]/g, '\\t');
    }
};