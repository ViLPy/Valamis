var TemplateLoader = function (onComplete) {
    this.numberOfCachedDocuments = 0;
    this.alreadyCached = 0;
    this.parentElement = 0;
    this.callback = onComplete;
};

TemplateLoader.prototype = {
    fetch:function (templates, parent) {

        function addTemplate(url) {
            jQuery.get(Utils.getContextPath() + url, jQuery.proxy(function (template) {
                jQuery(this.parentElement).append(template);
                this.alreadyCached++;
                checkProgress.call(this);
            }, this));
        }

        function checkProgress() {
            if (this.alreadyCached === this.numberOfCachedDocuments) {
                this.callback.call(this);
            }
        }

        this.parentElement = parent || jQuery('body');

        if (_.isArray(templates)) {
            this.numberOfCachedDocuments = templates.length;
            this.alreadyCached = 0;
            _.each(templates, addTemplate, this);
        } else if (_.isString(templates)) {
            this.numberOfCachedDocuments = 1;
            this.alreadyCached = 0;
            addTemplate.call(this, templates);
        }
    }
};
