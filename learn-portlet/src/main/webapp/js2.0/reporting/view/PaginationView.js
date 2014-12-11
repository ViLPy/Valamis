var PaginationView = Backbone.Marionette.View.extend({
    tagName: 'div',
    render: function () {
        this.isClosed = false;

        this.triggerMethod("before:render", this);

        this.$el.pagination({
            itemsOnPage: this.options.itemsOnPage,
            cssStyle: 'light-theme',
            onPageClick: _.bind(this.onPageSelect, this)
        });

        this.bindUIElements();

        this.triggerMethod("render", this);
        return this;
    },
    setPaginationOptions: function(options) {
        console.log(options);
        this.$el.pagination('updateItems', options.totalStatements);
    },
    onPageSelect: function(page) {
        this.trigger('page:select', page);
    }
});