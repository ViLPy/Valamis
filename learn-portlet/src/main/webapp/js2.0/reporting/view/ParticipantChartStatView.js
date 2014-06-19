var ChartStatView = Backbone.Marionette.View.extend({
    tagName: 'div',
    defaults: {
        margin: {top: 20, right: 20, bottom: 80, left: 50},
        width: 630,
        height: 380,
        barHeight: 20,
        animationDuration: 400
    },
    collectionEvents: {
        'sync': 'updateData'
    },
    getData: function () {
        var resultArray = this.collection;
        var preparedData = {};
        resultArray.each(function (value, index) {
            var key = value.get('groupName');
            var amount = value.get('amount');
            if (!preparedData[key]) {
                preparedData[key] = {title: key, amount: amount}
            } else {
                preparedData[key].amount = amount;
            }
        });
        var data = [];
        for (var key in preparedData) {
            data.push(preparedData[key]);
        }
        return data;
    },
    initializeRender: function () {
        this.chart = d3.select(".chartParticipant")
            .attr("width", this.defaults.width+200);

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
        var data = this.getData();
        console.log(data);

        var xmax = d3.max(data, function (d) {
            return d.amount;
        });

        var x = d3.scale.linear()
            .domain([0, Math.max(xmax,20)])
            .range([150, this.defaults.width]);

        this.chart.attr("height", this.defaults.barHeight * data.length*2);

        this.chart.selectAll("g").remove();

        var bars = this.chart.selectAll("g")
            .data(data);

        var bar = bars
            .enter()
            .append("g")
            .attr("transform", function(d, i) { return "translate(0," + (i*2*20) + ")"; });

        bar.append("rect")
            .attr("y", 0)
            .attr("x", x(0))
            .attr("width", function (d) {
                return x(d.amount) - x(0);
            })
            .attr("height", this.defaults.barHeight-1)
            .attr("class", "blue");

        bar.append("text")
            .attr("x", x(0))
            .attr("y", this.defaults.barHeight / 2)
            .attr("dy", ".35em")
            .attr("class", "bar")
            .text(function(d) { return d.amount; });

        bar.append("text")
            .attr("x", function (d) {
                return 120;
            })
            .attr("y", this.defaults.barHeight /2)
            .attr("dy", ".35em")
            .attr("class", "title")
            .text(function(d) { return d.title; });


        bars.exit().remove();

    }
});