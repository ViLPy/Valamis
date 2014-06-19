var CourseEventFilterView = Backbone.Marionette.ItemView.extend({
    template: '#courseEventFilter',
    events: {
        'click #getData': 'getData',
        'change #period': 'storePeriod',
        'change #group_by': 'storeGroupBy',
        'change #duration': 'storeDuration'
    },
    onRender: function () {
        this.$('#from').datepicker({
            defaultDate: 0,
            changeMonth: true,
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                this.$('#to').datepicker('option', 'minDate', selectedDate);
                localStorage.setItem('courseEventReportDateFrom', this.$('#from').datepicker('getDate').getTime());
            }.bind(this)
        });
        this.$('#to').datepicker({
            defaultDate: 0,
            changeMonth: true,
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                this.$('#from').datepicker('option', 'maxDate', selectedDate);
                localStorage.setItem('courseEventReportDateTo', this.$('#to').datepicker('getDate').getTime());
            }.bind(this)
        });
        var storedFrom = localStorage.getItem('courseEventReportDateFrom') || new Date().getTime();
        var storedTo = localStorage.getItem('courseEventReportDateTo') || new Date().getTime();
        var period = localStorage.getItem('courseEventReportPeriod');
        var group_by = localStorage.getItem('courseEventReportGroupBy');
        var duration = localStorage.getItem('courseEventReportDuration');
        if (storedFrom) {
            this.$('#from').datepicker('setDate', new Date(parseInt(storedFrom)));
        }
        if (storedTo) {
            this.$('#to').datepicker('setDate', new Date(parseInt(storedTo)));
        }
        if (period) {
            this.$('#period').val(period);
            this.storePeriod();
        }
        if (group_by) {
            this.$('#group_by').val(group_by);
            this.storeGroupBy();
        }
        if (duration) {
            this.$('#duration').val(duration);
        }
    },
    storePeriod: function(){
        localStorage.setItem('courseEventReportPeriod', this.$('#period').val());
        if(this.$('#period').val() == 'interval'){
            this.$('#from').show();
            this.$('#fromLabel').show();
            this.$('#to').show();
            this.$('#toLabel').show();
        }
        else{
            {
                this.$('#from').hide();
                this.$('#fromLabel').hide();
                this.$('#to').hide();
                this.$('#toLabel').hide();
            }
        }

    },
    storeGroupBy: function(){
        localStorage.setItem('courseEventReportGroupBy', this.$('#group_by').val());
        if(this.$('#group_by').val() == 'duration'){
            this.$('#duration').show();
            this.$('#durationLabel').show();
        }
        else{
            {
                this.$('#duration').hide();
                this.$('#durationLabel').hide();
            }
        }
    },
    storeDuration: function(){
        localStorage.setItem('courseEventReportDuration', this.$('#duration').val());
    },
    getData: function () {
        var from = this.$('#from').datepicker('getDate');
        var to = this.$('#to').datepicker('getDate');
        if (!(_.isDate(from) && _.isDate(to))) return;

        //jQuery('.portlet-title-text',this.$el.closest(".portlet")).text('Valamis TinCan Reporting by ' + this.$('#period').val());

        this.trigger('fetch', {
            from: from,
            to: to,
            period: this.$('#period').val(),
            groupBy: this.$('#group_by').val(),
            groupPeriod: this.$('#duration').val()
        });
    }
});