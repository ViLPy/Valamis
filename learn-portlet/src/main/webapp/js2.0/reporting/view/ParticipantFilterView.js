var ParticipantFilterView = Backbone.Marionette.ItemView.extend({
    template: '#participantReportFilter',
    events: {
        'click #getData': 'getData',
        'change #group_by': 'storeGroupBy'
    },
    onRender: function () {


        var group_by = localStorage.getItem('participantReportGroupBy');

        if (group_by) {
            this.$('#group_by').val(group_by);
            this.storeGroupBy();
        }

    },
    storeGroupBy: function(){
        localStorage.setItem('participantReportGroupBy', this.$('#group_by').val());
    },
    getData: function () {

        this.trigger('fetch', {
            groupBy: this.$('#group_by').val()
        });
    }
});