var TemplateLoader = function () {
};
// add event support
_.extend(TemplateLoader.prototype, Backbone.Events);

// extend with functions
_.extend(TemplateLoader.prototype, (function () {

    var numberOfCachedDocuments = 0;
    var alreadyCached = 0;
    var parentElement;

    function _addTemplate(url) {
        jQuery.get(Utils.getContextPath() + url, jQuery.proxy(function (template) {
            jQuery(parentElement).append(template);
            alreadyCached++;
            _checkProgress.call(this);
        }, this));
    }

    function _checkProgress() {
        if (alreadyCached === numberOfCachedDocuments) {
            this.trigger('complete');
        }
    }

    function fetch(templates, parent) {
        parentElement = parent || $('body');

        if (_.isArray(templates)) {
            numberOfCachedDocuments = templates.length;
            alreadyCached = 0;
            _.each(templates, _addTemplate, this);
        } else if (_.isString(templates)) {
            numberOfCachedDocuments = 1;
            alreadyCached = 0;
            _addTemplate.call(this, templates);
        }
    }

    return {
        fetch:fetch
    }
})());