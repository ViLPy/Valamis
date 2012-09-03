SCORMTinyMCERichEdit = Backbone.View.extend({
    callback:function () {
    },
    initialize:function () {
        this.$el.append("<div id='SCORMRichTextEditDialog" + this.cid + "'><textarea name='SCORMRedactor" + this.cid + "' id='SCORMRedactor" + this.cid + "' style='height: 500px; width: 900px;'></textarea></div>");

        var that = this;

        jQuery("#SCORMRichTextEditDialog" + this.cid).dialog({
            width:930,
            resizable:false,
            autoOpen:false,
            modal:true,
            buttons:{
                Ok:function () {
                    var content = that.redactor.html();
                    jQuery(that.editElement).html(content);
                    jQuery(this).dialog("close");
                    that.callback.call(that.callbackContext, content);
                },
                Cancel:function () {
                    jQuery(this).dialog("close");
                }
            }
        });
        jQuery('#SCORMRedactor' + this.cid).tinymce({
            theme:"advanced",
            plugins:"table,file",
            theme_advanced_buttons2_add:'file',
            theme_advanced_buttons3_add:"tablecontrols",
            fileServiceURL: Utils.getContextPath() + 'services/upload'
        });
        this.redactor = jQuery('#SCORMRedactor' + this.cid);
    },
    show:function (title, element, callback, context) {
        this.callback = callback || this.callback;
        this.callbackContext = context || this;
        this.editElement = element;
        this.redactor.html(jQuery(element).html());

        jQuery("#SCORMRichTextEditDialog" + this.cid).dialog("option", "title", title);
        jQuery("#SCORMRichTextEditDialog" + this.cid).dialog("open");
    }
});