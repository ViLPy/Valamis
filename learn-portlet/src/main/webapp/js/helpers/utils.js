var Utils = {
    getContextPath:function () {
        var contextPath = "";
        var element = jQuery("#SCORMContextPath");
        if (element && element.length > 0) {
            contextPath = element.val() + "/";
        }
        return contextPath;
    },
    getCourseID: function() {
        var courseID = "";
        var element = jQuery("#courseID");
        if (element && element.length > 0) {
            courseID = element.val();
        }
        return courseID;
    },
    i18nLoader:function (url, defaultLangURL, successCallback, errorCallback) {
        function propertyFileParser(data) {
            function stripLine(line) {
                var result = line;
                if (jQuery.trim(line).indexOf('#') === 0) {
                    result = line.substr(0, line.indexOf('#'));
                }
                return jQuery.trim(result);
            }

            function splitKeyValue(line) {
                var result = {};
                var index = line.indexOf('=');
                if (index >= 0) {
                    result['key'] = jQuery.trim(line.substr(0, index));
                    result['value'] = jQuery.trim(line.substr(index + 1));
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

        function parseData(defaultData, localizationData) {
            var parsedDefault, parsedLocalization;
            if (!defaultData) {
                if (!localizationData) {
                    errorCallback.call(this);
                } else {
                    parsedLocalization = propertyFileParser(localizationData);
                    successCallback.call(this, parsedLocalization);
                }
            } else {
                if (!localizationData) {
                    parsedDefault = propertyFileParser(defaultData);
                    successCallback.call(this, parsedDefault);
                } else {
                    parsedLocalization = propertyFileParser(localizationData);
                    parsedDefault = propertyFileParser(defaultData);
                    for (var key in parsedDefault) {
                        if (parsedLocalization[key] && parsedLocalization[key] != "") {
                            parsedDefault[key] = parsedLocalization[key];
                        }
                    }
                    successCallback.call(this, parsedDefault);
                }
            }
        }

        window.LearnAjax.get(defaultLangURL, undefined, undefined, 'text').done(function (defaultData) {
            window.LearnAjax.get(url, undefined, undefined, 'text').done(function (localizationData) {
                parseData(defaultData, localizationData);
            }).fail(function () {
                    parseData(defaultData, null);
                })
        }).fail(function () {
                window.LearnAjax.get(url, undefined, undefined, 'text').done(function (localizationData) {
                    parseData(null, localizationData);
                }).fail(function () {
                        parseData(null, null);
                    })
            });
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

        LearnAjaxHelper.prototype.ajax = function(url, options) {
            if (_.isObject(url)) {
                options = url;
            } else {
                options.url = url;
            }

            if (options.headers) options.headers = _.extend(options.headers, headers);
            else options.headers = headers;

            return jQuery.ajax(options);
        }
    }

    LearnAjaxHelper.prototype.syncRequest = function (url, method, data) {
        return jQuery.parseJSON(jQuery.ajax({
            url:url,
            async:false,
            type:method || "get",
            headers:headers,
            data:data,
            cache:false
        }).responseText);
    };

    LearnAjaxHelper.prototype.setHeader = function (key, value) {
        headers[key] = value;
    };

    LearnAjaxHelper.prototype.getHeader = function (key) {
        return headers[key];
    };

    return LearnAjaxHelper;
})();

if (!window.LearnAjax) {
    window.LearnAjax = new LearnAjaxHelper();
}

// IE7 JSON
if (typeof JSON !== 'object') {
    JSON = {};
}

(function () {
    'use strict';

    function f(n) {
        return n < 10 ? '0' + n : n;
    }

    if (typeof Date.prototype.toJSON !== 'function') {

        Date.prototype.toJSON = function (key) {

            return isFinite(this.valueOf())
                ? this.getUTCFullYear()     + '-' +
                    f(this.getUTCMonth() + 1) + '-' +
                    f(this.getUTCDate())      + 'T' +
                    f(this.getUTCHours())     + ':' +
                    f(this.getUTCMinutes())   + ':' +
                    f(this.getUTCSeconds())   + 'Z'
                : null;
        };

        String.prototype.toJSON      =
            Number.prototype.toJSON  =
            Boolean.prototype.toJSON = function (key) {
                return this.valueOf();
            };
    }

    var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
        escapable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
        gap,
        indent,
        meta = {    // table of character substitutions
            '\b': '\\b',
            '\t': '\\t',
            '\n': '\\n',
            '\f': '\\f',
            '\r': '\\r',
            '"' : '\\"',
            '\\': '\\\\'
        },
        rep;


    function quote(string) {
        escapable.lastIndex = 0;
        return escapable.test(string) ? '"' + string.replace(escapable, function (a) {
            var c = meta[a];
            return typeof c === 'string'
                ? c
                : '\\u' + ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
        }) + '"' : '"' + string + '"';
    }


    function str(key, holder) {
        var i,          // The loop counter.
            k,          // The member key.
            v,          // The member value.
            length,
            mind = gap,
            partial,
            value = holder[key];

        if (value && typeof value === 'object' &&
                typeof value.toJSON === 'function') {
            value = value.toJSON(key);
        }

        if (typeof rep === 'function') {
            value = rep.call(holder, key, value);
        }

        switch (typeof value) {
        case 'string':
            return quote(value);
        case 'number':
            return isFinite(value) ? String(value) : 'null';
        case 'boolean':
        case 'null':
            return String(value);
        case 'object':
            if (!value) {
                return 'null';
            }
            gap += indent;
            partial = [];
            if (Object.prototype.toString.apply(value) === '[object Array]') {
                length = value.length;
                for (i = 0; i < length; i += 1) {
                    partial[i] = str(i, value) || 'null';
                }
                v = partial.length === 0
                    ? '[]'
                    : gap
                    ? '[\n' + gap + partial.join(',\n' + gap) + '\n' + mind + ']'
                    : '[' + partial.join(',') + ']';
                gap = mind;
                return v;
            }

            if (rep && typeof rep === 'object') {
                length = rep.length;
                for (i = 0; i < length; i += 1) {
                    if (typeof rep[i] === 'string') {
                        k = rep[i];
                        v = str(k, value);
                        if (v) {
                            partial.push(quote(k) + (gap ? ': ' : ':') + v);
                        }
                    }
                }
            } else {
                for (k in value) {
                    if (Object.prototype.hasOwnProperty.call(value, k)) {
                        v = str(k, value);
                        if (v) {
                            partial.push(quote(k) + (gap ? ': ' : ':') + v);
                        }
                    }
                }
            }
            v = partial.length === 0
                ? '{}'
                : gap
                ? '{\n' + gap + partial.join(',\n' + gap) + '\n' + mind + '}'
                : '{' + partial.join(',') + '}';
            gap = mind;
            return v;
        }
    }

    if (typeof JSON.stringify !== 'function') {
        JSON.stringify = function (value, replacer, space) {

            var i;
            gap = '';
            indent = '';

            if (typeof space === 'number') {
                for (i = 0; i < space; i += 1) {
                    indent += ' ';
                }
            } else if (typeof space === 'string') {
                indent = space;
            }

            rep = replacer;
            if (replacer && typeof replacer !== 'function' &&
                    (typeof replacer !== 'object' ||
                    typeof replacer.length !== 'number')) {
                throw new Error('JSON.stringify');
            }
            return str('', {'': value});
        };
    }

    if (typeof JSON.parse !== 'function') {
        JSON.parse = function (text, reviver) {

            var j;
            function walk(holder, key) {
                var k, v, value = holder[key];
                if (value && typeof value === 'object') {
                    for (k in value) {
                        if (Object.prototype.hasOwnProperty.call(value, k)) {
                            v = walk(value, k);
                            if (v !== undefined) {
                                value[k] = v;
                            } else {
                                delete value[k];
                            }
                        }
                    }
                }
                return reviver.call(holder, key, value);
            }

            text = String(text);
            cx.lastIndex = 0;
            if (cx.test(text)) {
                text = text.replace(cx, function (a) {
                    return '\\u' +
                        ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
                });
            }

            if (/^[\],:{}\s]*$/
                    .test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, '@')
                        .replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']')
                        .replace(/(?:^|:|,)(?:\s*\[)+/g, ''))) {

                j = eval('(' + text + ')');

                return typeof reviver === 'function'
                    ? walk({'': j}, '')
                    : j;
            }

            throw new SyntaxError('JSON.parse');
        };
    }
}());