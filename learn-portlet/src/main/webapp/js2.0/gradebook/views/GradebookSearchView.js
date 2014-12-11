/**
 * Search for gradebook
 */
var GradebookSearchView = Backbone.Marionette.ItemView.extend({
    template: '#gradebookSearch',
    className: 'search-wrapper',
    tagName: 'div',
    events: {

    },

    initialize: function () {
    },

    onRender: function () {
        if(this.$('.sorting').val() == "last_modified")
            this.$('#update-time').show();
        else
            this.$('#update-time').hide();
    },

    hidePackagePanel: function () {
        this.$('.package-panel').hide();
    },

    showPackagePanel: function () {
        this.$('.package-panel').show();
    }
});