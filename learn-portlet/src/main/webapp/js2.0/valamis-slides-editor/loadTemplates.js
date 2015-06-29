syncTemplateLoader = {
    syncLoadAndAppendTo$el: function(url, $el) {
        var resp = this.syncLoad(url);
        $el.append(resp);
    },
    syncLoad: function (url) {
        return jQueryValamis.ajax({
            type: "GET",
            url: url,
            async: false
        }).responseText;
    }
};