/**
 * Gradebook view. Contains simple and detailed view with filter.
 */

GradebookView = Backbone.View.extend({
    events: {
        "change .search-by-name": 'onFilterNameChanged',
        "change .search-by-org": 'onFilterOrgChanged',
        'change .show-mode': 'onShowModeChanged',
        'change .sorting': 'onSortingChanged',
        "change .check-package": "reloadGradeList"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQuery('.gradebookBody');

        this.searchView = new GradebookSearchView();



        this.model = new GradebookModel();
        this.model.get('paginatorModel').on('pageChanged', this.reloadGradeList, this);



        this.showSimpleView();


    },

    render:function () {
        this.$('.sidebar-wrapper').append(this.searchView.render().$el);
        this.renderGradeList();

        return this.$el;
    },

    reloadGradeList: function () {
//        if(jQuery("#detailed").val() == 'true') {
//            this.gradebookListView = new GradebookDetailedListView({$el: this.$('.student-grades'), model: this.model, language: language});
//            this.gradebookListView.on('refreshList', this.renderGradeList, this);
//        }
        this.gradebookListView.model = this.model;
        this.gradebookListView.reloadGradeList();
        this.renderGradeList();
    },

    renderGradeList: function () {
        this.$('.student-grades').html(this.gradebookListView.render());
        this.$('.show-mode').val(this.model.get('showMode'));
        this.$('.sorting').val(this.model.get('sorting'));

    },

    showSimpleView: function () {

        this.gradebookListView = new GradebookListView({$el: this.$('.student-grades'), model: this.model, language: language});
        this.gradebookListView.on('refreshList', this.renderGradeList, this);
        this.gradebookListView.reloadGradeList();

        this.render();
        this.searchView.hidePackagePanel();

    },

    showDetailedView: function () {
        this.gradebookListView = new GradebookDetailedListView({$el: this.$('.student-grades'), model: this.model, language: language});
        this.gradebookListView.on('refreshList', this.renderGradeList, this);
        this.gradebookListView.reloadGradeList();

        this.render();
        this.searchView.showPackagePanel();


    },

    onFilterNameChanged: function () {
        this.model.set('namePattern',this.$('.search-by-name').val());
        this.reloadGradeList();
    },

    onFilterOrgChanged: function () {
        this.model.set('orgPattern',this.$('.search-by-org').val());
        this.reloadGradeList();
    },

    onShowModeChanged: function (res) {
        this.model.set('showMode',this.$('.show-mode').val());
        if(this.model.get('showMode') == 'simpleView')
            this.showSimpleView();
        else
            this.showDetailedView();

    },

    onSortingChanged: function () {
        this.model.set('sorting',this.$('.sorting').val());
        this.reloadGradeList();
    }
});