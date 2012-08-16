(function ($) {
    $.fn.List = function () {
        var elements = [];
        var elementSorter = function (key, func) {
            // func returns number as (a.priority - b.priority)
            // less priority level is more significant

            // this will prevent random item swap (like when using array.sort())
            // in case when two items are equal
            var data = [];
            for (var itemKey in elements) {
                data.push(elements[itemKey]);
            }
            if (!data || data.length == 0) return;

            var resulted = [data[0]];
            for (var i = 1; i < data.length; i++) {
                var node = data[i];
                if (func(resulted[resulted.length - 1].values[key], node.values[key]) <= 0) {
                    resulted.push(node);
                } else {
                    var position = -1;
                    for (var j = resulted.length - 1; j > 0; j--) {
                        if (func(resulted[j].values[key], node.values[key]) <= 0) {
                            position = j;
                            break;
                        }
                    }
                    if (position < 0) {
                        resulted.splice(0, 0, node);
                    } else {
                        resulted.splice(position + 1, 0, node);
                    }
                }
            }

            return resulted;
        };

        this.add = function (id, node, values, isPrepend) {
            if (isPrepend) {
                this.prepend(node);
            } else {
                this.append(node);
            }
            elements[id] = new Item(id, node, values);
        };

        this.update = function (id, newValues) {
            for (var key in newValues) {
                elements[id].values[key] = newValues[key];
            }
        };

        this.remove = function (id) {
            delete elements[id];
        };

        this.removeAll = function () {
            for (var id in elements) {
                delete elements[id];
            }
        };

        this.sort = function (key, options) {
            var sorted = [];
            if (typeof options == "string") {
                var asc = (options.toLowerCase() != "desc")
                sorted = elementSorter(key, (function (asc) {
                    return function (a, b) {
                        if (a == b) return 0;
                        if (asc) {
                            return ((a > b)) ? 1 : -1;
                        } else {
                            return ((a < b)) ? 1 : -1;
                        }
                    }
                })(asc));
            } else if (typeof options == "function") {
                sorted = elementSorter(key, options);
            }
            if (!sorted || sorted.length === 0) return;

            var prevKey = null;
            for (key in sorted) {
                if (prevKey) elements[sorted[key].id].node.insertAfter(elements[sorted[prevKey].id].node);
                prevKey = key;
            }
        };

        this.filter = function (expression) {
            var hide = function (item) {
                    item.node.css('display', 'none');
                },
                show = function (item) {
                    item.node.css('display', item.defaultDisplay);
                };

            var matchedItems = [];
            for (key in elements) {
                var element = elements[key];
                if (element.contains(expression)) {
                    matchedItems.push(element);
                }
                hide(element);
            }
            for (var i = 0; i < matchedItems.length; i++) {
                show(matchedItems[i]);
            }
        };

        var Item = function (id, node, values) {
            this.id = id;
            this.node = node;
            this.defaultDisplay = node.css('display') || 'block';
            this.values = values;

            this.contains = function (expression) {
                if (!expression || expression == "") return true;
                for (key in values) {
                    var value = unescape(values[key]);
                    if (value.toLowerCase().search(expression.toLowerCase()) > -1) return true;
                }
                return false;
            }

        };
        return this;
    };
})(jQuery);