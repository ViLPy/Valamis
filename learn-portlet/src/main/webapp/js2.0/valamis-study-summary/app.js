
var ValamisStudySummary = Marionette.Application.extend({

    channelName:'valamisStudySummary',
    onStart: function(){
        var self = this;
        self.addRegions({
            mainRegion: '#valamisStudySummaryAppRegion'
        });
        self.mainRegion.$el
            .find('.valamis-tooltip').tooltip();
        self.mainRegion.$el
            .find('.button-stat-toggle-cont button')
            .bind( 'click', jQueryValamis.proxy(self.statisticShowToggle, self) );

        var callback_func = function(data){
            self.createSummaryPie( self.mainRegion.el + ' .chart-container', data );
        };
        self.getData( callback_func );
    },
    statisticShowToggle: function(e){
        var self = this;
        if(e) {
            e.preventDefault();
        }
        var toggle = !jQueryValamis('.val-statistic:first',self.mainRegion.el).is('.l-only');
        jQueryValamis('.val-statistic',self.mainRegion.el)
            .toggleClass( 'l-only', toggle );
        jQueryValamis(e.target)
            .text(
                toggle
                ? jQueryValamis(e.target).data('text')
                : jQueryValamis(e.target).data('toggle-text')
            );
    },
    createSummaryPie: function( parent_selector, data ){

        var color = d3.rgb('#1D3040'),
            other_color = '#D0D0D0',
            isEmpty = data.length == 0,
            chartWidth = 440,
            chartHeight = 200,
            outerRadius = 100,
            innerRadius = 50;

        _.each(data,function(item,i){
            item.index = i;
        });

        if( isEmpty ) {
            data = [
                {
                    label: 'No Data Applicable',
                    value: 100,
                    color: other_color
                }
            ];
        }

        //pie
        var arc = d3.svg.arc()
            .outerRadius( outerRadius )
            .innerRadius( innerRadius );

        var pie = d3.layout.pie()
            .sort(null)
            .value(function(d) { return d.value; });

        var svg = d3.select( parent_selector )
            .append('svg')
            .attr('width', chartWidth)
            .attr('height', chartHeight)
            .append('g')
            .attr("transform", 'translate(' + outerRadius + ',' + outerRadius + ')');

        var path = svg.selectAll('.arc')
            .data(pie(data))
            .enter().append('g')
            .attr('class', 'arc');

        path.append('path')
            .attr('d', arc)
            .style('fill', function(d) {
                return d.data.index < data.length - 1
                    ? color.brighter(d.data.index).toString()
                    : other_color;
            });

        //tooltip
        if( !isEmpty ) {
            var tooltip = d3.select( parent_selector )
                .append('div')
                .attr('class', 'tooltip right');

            tooltip
                .append('div')
                .attr('class', 'tooltip-inner');

            path.on('mouseover', function(d) {
                var total = d3.sum(data.map(function(d) {
                    return (d.enabled) ? d.value : 0;
                }));
                //var percent = Math.round(1000 * d.data.value / total) / 10;//example
                var text_value = d.data.label + ' <b>' + d.data.value + '%</b>';
                tooltip.select('.tooltip-inner').html( text_value );
                tooltip.style('opacity', 1);
            });

            path.on('mouseout', function() {
                tooltip.style('opacity', 0);
            });

            path.on('mousemove', function(d) {
                var parent_offset = jQueryValamis(parent_selector).offset(),
                    posX = d3.event.clientX - parent_offset.left,
                    posY = d3.event.clientY - parent_offset.top;

                posY += jQueryValamis(window).scrollTop();
                tooltip
                    .style('top', (posY + 15) + 'px')
                    .style('left', (posX + 10) + 'px');
            });
        }

        //legend
        var legendRectSize = 16,
            legendSpacing  = 10;

        var legend = svg.selectAll('.legend')
            .data(data)
            .enter()
            .append('g')
            .attr('class', 'legend')
            .attr('transform', function(d, i) {
                var height = legendRectSize + legendSpacing;
                var horz = outerRadius + 45;
                var offset =  data.length * ( height / 2 - 1 );
                var vert = i * height - offset;
                return 'translate(' + horz + ',' + vert + ')';
            });

        legend.append('rect')
            .attr('width', legendRectSize)
            .attr('height', legendRectSize)
            .attr('rx', '4')
            .style('fill', function(d) {
                return d.index < data.length - 1
                    ? color.brighter(d.index).toString()
                    : other_color;
            });

        legend.append('text')
            .attr('x', legendRectSize + legendSpacing)
            .attr('y', legendRectSize - legendSpacing + 5)
            .attr('dy', '.15em')
            .attr('font-size','11')
            .text(function(d) { return d.label || Valamis.language['otherLabel']; });

        if( !isEmpty ){
            legend.append('text')
                .attr('x', 160)
                .attr('y', legendRectSize - legendSpacing + 5)
                .attr('dy', '.15em')
                .attr('font-size','11')
                .text(function(d) { return d.value + '%'; });
        }
    },
    getData: function( callback_func ){

        var that = this;
        jQueryValamis.ajax( {
                url: path.root + path.api.dashboard + 'summary'
            }
        ).done(function(data){

                var certificatesReceived = data.certificatesReceived || 0;
                var lessonsCompleted = data.lessonsCompleted || 0;
                var learningGoalsAchived = data.learningGoalsAchived || 0;
                var certificatesInProgress = data.certificatesInProgress || 0;

                that.mainRegion.$el.find('.js-lesson-completed').html(lessonsCompleted);
                that.mainRegion.$el.find('.js-certificates-received').html(certificatesReceived);
                that.mainRegion.$el.find('.js-learning-goals-achived').html(learningGoalsAchived);
                that.mainRegion.$el.find('.js-certificates-in-progress').html(certificatesInProgress);

                var pieData = data.piedata;

                if (_.isFunction(callback_func)) {
                    callback_func(pieData);
                }
        });
    }
});

var valamisStudySummary = new ValamisStudySummary();

jQueryValamis(document).bind('ready',function(){
    valamisStudySummary.start();
});
