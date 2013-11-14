ExternalResourceSelectDialog = Backbone.View.extend({
    events: {
        "click #previewExternalResource":"doPreview"
    },
    callback:function (url) {
    },
    initialize:function () {
        var that = this;
        this.$el.dialog({
            autoOpen:false,
            modal:true,
            width:640,
            height:480,
            buttons:{
                Add:function () {
                    var src = jQuery("iframe", this).attr("src") || jQuery("#externalResourceUrl", this).val();
                    if (src.indexOf("http") !== 0) src = "http://" + src;
                    that.callback(src);
                    jQuery(this).dialog("close");
                },
                Cancel:function () {
                    jQuery(this).dialog("close");
                }
            }
        });
    },
    choose:function (onChoose) {
        this.callback = onChoose;
        this.$("iframe").attr("src", "");
        this.$("#externalResourceUrl").val("");
        this.$el.dialog('open');
    },
    doPreview:function(){
        var url = this.$("#externalResourceUrl").val();
        if (url.indexOf("http") !== 0) url = "http://" + url;
        this.$("iframe").attr("src", url);
    }
});