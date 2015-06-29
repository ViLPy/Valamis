var TemplateLoader = function (onComplete, $) {
    this.numberOfCachedDocuments = 0;
    this.alreadyCached = 0;
    this.parentElement = 0;
    this.callback = onComplete;
    this.$ = $ || jQuery;
};

TemplateLoader.prototype = {
    fetch:function (templates, parent) {
        var that = this;

        function addTemplate(url) {
            that.$.get(Utils.getContextPath() + url, that.$.proxy(function (template) {
                this.$(this.parentElement).append(template);
                this.alreadyCached++;
                checkProgress.call(this);
            }, this));
        }

        function checkProgress() {
            if (that.alreadyCached === that.numberOfCachedDocuments) {
                that.callback.call(that);
            }
        }

        this.parentElement = parent || this.$('body');

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
