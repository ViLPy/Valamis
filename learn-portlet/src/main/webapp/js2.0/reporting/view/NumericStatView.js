var NumericStatView = Backbone.Marionette.ItemView.extend({
    template: '#templateStatMenu',
    templateHelpers: {
        started: function () {
            return _.reduce(this.startedData, function (memo, row) {
                return memo + row.amount;
            }, 0);
        },
        completed: function () {
            return _.reduce(this.completedData, function (memo, row) {
                return memo + row.amount;
            }, 0);
        },
        passed: function () {
            return _.reduce(this.experiencedData, function (memo, row) {
                return memo + row.amount;
            }, 0);
        },
        average: function() {
            return ~~(this.averageScore * 100);
        }
    },
    modelEvents: {
        'change': 'render'
    },
    events: {
        'mouseover .filter-area': 'highlight',
        'mouseout .filter-area': 'dropHighlight'
    },
    highlight: function (event) {
        this.trigger('highlight', jQueryValamis(event.target).data('filter-type'));
    },
    dropHighlight: function () {
        this.trigger('highlight', null);
    }
});