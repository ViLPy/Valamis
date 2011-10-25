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
    }
};