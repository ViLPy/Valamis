var StudentView = Backbone.Marionette.ItemView.extend({
    template: '#studentViewTemplate',
    templateHelpers: {},
    tagName: "tr",
    className: "statementRow"
});

var StudentsListView = Backbone.Marionette.CompositeView.extend({
    itemView: StudentView,
//    tagName: 'tbody',
//    className: 'statementList',
    itemViewContainer: "tbody",
    template: "#studentTableViewTemplate",
    templateHelpers: {},
    triggers: {
        "change .show-mode": "showMode:change"
    },
    collectionEvents: {
        "sync": function(){
            var v=this.$('.show-mode').val();
            this.render();
            this.$('.show-mode').val(v);
        }
    }
});