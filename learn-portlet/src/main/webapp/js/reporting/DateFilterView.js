var DateFilterView = Backbone.Marionette.ItemView.extend({
    template: '#dateFilter',
    events: {
        'click #getData': 'getData',
        'change #period': 'storePeriod'
    },
    onRender: function () {
        this.$('#from').datepicker({
            defaultDate: 0,
            changeMonth: true,
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                this.$('#to').datepicker('option', 'minDate', selectedDate);
                localStorage.setItem('valamisReportDateFrom', this.$('#from').datepicker('getDate').getTime());
            }.bind(this)
        });
        this.$('#to').datepicker({
            defaultDate: 0,
            changeMonth: true,
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                this.$('#from').datepicker('option', 'maxDate', selectedDate);
                localStorage.setItem('valamisReportDateTo', this.$('#to').datepicker('getDate').getTime());
            }.bind(this)
        });
        var storedFrom = localStorage.getItem('valamisReportDateFrom') || new Date().getTime();
        var storedTo = localStorage.getItem('valamisReportDateTo') || new Date().getTime();
        var period = localStorage.getItem('valamisReportPeriod');
        if (storedFrom) {
            this.$('#from').datepicker('setDate', new Date(parseInt(storedFrom)));
        }
        if (storedTo) {
            this.$('#to').datepicker('setDate', new Date(parseInt(storedTo)));
        }
        if (period) {
            this.$('#period').val(period);
        }
    },
    storePeriod: function(){
        localStorage.setItem('valamisReportPeriod', this.$('#period').val());
    },
    getData: function () {
        var from = this.$('#from').datepicker('getDate');
        var to = this.$('#to').datepicker('getDate');
        if (!(_.isDate(from) && _.isDate(to))) return;

        //jQuery('.portlet-title-text',this.$el.closest(".portlet")).text('Valamis TinCan Reporting by ' + this.$('#period').val());

        this.trigger('fetch', {
            from: from,
            to: to,
            period: this.$('#period').val()
        });
    }
});