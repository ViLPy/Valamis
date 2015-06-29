var _LessonSearch = {};

_LessonSearch.Model = Backbone.Model.extend({
    defaults: {
        filter: '',
        sortBy: 'date',
        ascendingOrder: false
    }
});

_LessonSearch.SearchByNameView = _LessonDefaultView.extend({
    inputTimeout: null,
    SEARCH_TIMEOUT: 800,
    templateSelector: '#lesson-search-by-name',
    events: {
        'keyup .js-search-by-name': 'onFilterNameChanged'
    },
    onFilterNameChanged: function () {
        clearTimeout(this.inputTimeout);
        this.inputTimeout = setTimeout(this.applyFilterName.bind(this), this.SEARCH_TIMEOUT);
    },
    applyFilterName: function () {
        clearTimeout(this.inputTimeout);
        this.model.set({filter: this.$('.js-search-by-name').val()});
    }
});

_LessonSearch.OrderView = _LessonDefaultView.extend({
    templateSelector: '#lesson-order',
    events: {
        'click .dropdown-menu > li': 'onFilterSortChanged'
    },
    onFilterSortChanged: function(){
        var order = this.$(".dropdown-menu .selected").data('value').split(':');
        this.model.set({
            sortBy: order[0],
            ascendingOrder: order[1].toLowerCase() == 'asc'
        });
    },
    tagName: 'span'
});
