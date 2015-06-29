var viewportWidth = jQueryValamis(window).width();
var ChartStatView = Backbone.Marionette.View.extend({
    tagName: 'div',
    defaults: {
        margin: {top: 20, right: 20, bottom: 80, left: 50},
        width: 600,
        height: 380,
        barHeight: 20,
        animationDuration: 400
    },
    collectionEvents: {
        'sync': 'updateData'
    },
    getData: function () {
        this.intervalType = this.$('#period');
        var resultArray = this.collection;
        var preparedData = {};
        resultArray.each(function (value, index) {
            var key = value.get('groupName');
            var amount1 = value.get('enrollmentsCount');
            var amount2 = value.get('completionsCount');
            if (!preparedData[key]) {
                preparedData[key] = {'title': key, 'amount1': amount1,'amount2': amount2}
            } else {
                preparedData[key].amount1 = amount1;
                preparedData[key].amount2 = amount2;
            }
        });
        var data = [];
        for (var key in preparedData) {
            data.push(preparedData[key]);
        }
        return data;
    },
    initializeRender: function () {
        this.width = this.defaults.width;
        if (viewportWidth <= 1199)
            this.width = this.width - 400;

        this.chart = d3.select(".chart")
            .attr("width", this.width+200);

        this.chart.append("g")
            .attr("transform", function(d, i) { return "translate(0," + (i*3*20) + ")"; });

    },
    render: function () {
        this.isClosed = false;

        this.triggerMethod("before:render", this);
        this.initializeRender();
        this.updateData();

        this.bindUIElements();

        this.triggerMethod("render", this);
        return this;
    },
    updateData: function () {
        this.width = this.defaults.width;
        if (viewportWidth <= 1199)
            this.width = this.width - 400;

        var data = this.getData();

        var max1 = d3.max(data, function (d) {
            return d.amount1;
        });
        var max2 = d3.max(data, function (d) {
            return d.amount2;
        });

        var xmax = Math.max(max1,max2);
        var x = d3.scale.linear()
            .domain([0, Math.max(xmax,20)])
            .range([150, this.width]);

        this.chart.attr("height", this.defaults.barHeight * data.length*3);
//        this.chart.attr("overflow-y", "scroll");

        this.chart.selectAll("g").remove();

        var bars = this.chart.selectAll("g")
            .data(data);

        var bar = bars
            .enter()
            .append("g")
            .attr("transform", function(d, i) { return "translate(0," + (i*2*20) + ")"; });

        bar.append("rect")
            .attr("y", 0)
            .attr("x", x(0)+80)
            .attr("width", function (d) {
                return x(d.amount1) - x(0);
            })
            .attr("height", this.defaults.barHeight-1)
            .attr("class", "blue");

        bar.append("rect")
            .attr("y", this.defaults.barHeight)
            .attr("x", x(0)+80)
            .attr("width", function (d) {
                return x(d.amount2) - x(0);
            })
            .attr("height", this.defaults.barHeight-1)
            .attr("class", "red");

        bar.append("text")
            .attr("x", function(d) { return x(0)+85; })
            .attr("y", this.defaults.barHeight / 2)
            .attr("dy", ".35em")
            .attr("class", "bar")
            .text(function(d) { return d.amount1; });

        bar.append("text")
            .attr("x", function(d) { return x(0)+85; })
            .attr("y", 3*this.defaults.barHeight / 2)
            .attr("dy", ".35em")
            .attr("class", "bar")
            .text(function(d) { return d.amount2; });

        bar.append("rect")
            .attr("y", 0)
            .attr("x", 30)
            .attr("width", "200")
            .attr("height", this.defaults.barHeight*2-1)
            .attr("class", "grey");

        bar.append("text")
            .attr("x", function (d) {
                return 35;
            })
            .attr("y", this.defaults.barHeight)
            .attr("dy", ".35em")
            .attr("class", "title")
            .text(function(d) { return d.title; });


        bars.exit().remove();

    }
});