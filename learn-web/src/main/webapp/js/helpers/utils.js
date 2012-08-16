var Utils = {
    getContextPath:function () {
        var contextPath = "/scorm-player/";
        if ($("#SCORMContextPath") && $("#SCORMContextPath").length > 0) {
            contextPath = $("#SCORMContextPath").val() + "/";
        }
        return contextPath;
    },
    i18nLoader:function (url, successCallback, errorCallback) {
        function propertyFileParser(data) {
            function stripLine(line) {
                var result = line;
                if (line.trim().indexOf('#') === 0) {
                    result = line.substr(0, line.indexOf('#'));
                }
                return result.trim();
            }

            function splitKeyValue(line) {
                var result = {};
                var index = line.indexOf('=');
                if (index >= 0) {
                    result['key'] = line.substr(0, index).trim();
                    result['value'] = line.substr(index + 1).trim();
                    return result;
                }
                return null;
            }

            var parsed = {};
            var lines = data.split(/\r\n|\n|\r/g);
            for (var key in lines) {
                var result = splitKeyValue(stripLine(lines[key]));
                if (result) {
                    parsed[result.key] = result.value;
                }
            }
            return parsed;
        }

        function parse(data) {
            var parsed = propertyFileParser(data);
            successCallback.call(this, parsed);
        }

        window.LearnAjax.get(url, parse).fail(errorCallback);
    }
};

/*
 * Wrapper for jQuery
 */
var LearnAjaxHelper = (function () {

    var headers = {};

    function LearnAjaxHelper() {
        jQuery.each([ "get", "post" ], function (i, method) {
            LearnAjaxHelper.prototype[ method ] = function (url, data, callback, type) {
                // shift arguments if data argument was omitted
                if (jQuery.isFunction(data)) {
                    type = type || callback;
                    callback = data;
                    data = undefined;
                }

                return jQuery.ajax({
                    type:method,
                    url:url,
                    data:data,
                    success:callback,
                    dataType:type,
                    headers:headers,
                    cache:false
                });
            };
        });
    }

    LearnAjaxHelper.prototype.syncRequest = function (url, method, data) {
        return $.parseJSON($.ajax({
            url:url,
            async:false,
            type:method || "get",
            headers:headers,
            data:data
        }).responseText);
    }

    LearnAjaxHelper.prototype.setHeader = function (key, value) {
        headers[key] = value;
    }

    LearnAjaxHelper.prototype.getHeader = function (key) {
        return headers[key];
    }

    return LearnAjaxHelper;
})();

if (!window.LearnAjax) {
    window.LearnAjax = new LearnAjaxHelper();
}