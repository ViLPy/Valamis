var viewportWidth = jQueryValamis(window).width();
var ChartStatView = Backbone.Marionette.View.extend({
    tagName: 'div',
    defaults: {
        margin: {top: 20, right: 20, bottom: 80, left: 50},
        width: 630,//390,//630,
        height: 380,
        animationDuration: 400//280//400
    },
    modelEvents: {
        'change': 'updateData'
    },
    getData: function () {
        this.intervalType = (this.model.get('period') || "").toLowerCase();
        var statementData = _.groupBy(this.model.get('statements'), 'date');
        var preparedData = {};
        _.forEach(statementData, function (value, key) {
            var amount = _.reduce(value, function (memo, v) {
                return memo + v.amount
            }, 0);
            if (!preparedData[key]) {
                preparedData[key] = {'date': key, 'amount': amount}
            } else {
                preparedData[key].amount = amount;
            }
        });
        var data = [];
        for (var key in preparedData) {
            var date;
            if (this.intervalType !== "hour") {
                // local time to UTC
                date = new Date(+preparedData[key].date + new Date().getTimezoneOffset() * 60000);
            } else {
                date = new Date(+preparedData[key].date);
            }
            preparedData[key].date = date;//.toLocaleDateString() + '\n' + date.toLocaleTimeString();
            data.push(preparedData[key]);
        }
        data = _.sortBy(data, function (e) {
            return e.date.getTime()
        });
        return data;
    },
    initializeRender: function () {

        var width = this.defaults.width;
        if (viewportWidth <= 1199)
            width = width - 240;

        this.x = d3.time.scale()
//            .range([0, this.defaults.width]);
            .range([0, width]);

        this.y = d3.scale.linear()
            .range([this.defaults.height, 0]);

        this.xAxis = d3.svg.axis()
            .scale(this.x)
            .orient("bottom");

        this.yAxis = d3.svg.axis()
            .scale(this.y)
            .orient("left");

        this.svg = d3.select(this.el).append("svg")
//            .attr("width", this.defaults.width + this.defaults.margin.left + this.defaults.margin.right)
            .attr("width", width + this.defaults.margin.left + this.defaults.margin.right)
            .attr("height", this.defaults.height + this.defaults.margin.top + this.defaults.margin.bottom)
            .append("g")
            .attr("transform", "translate(" + this.defaults.margin.left + "," + this.defaults.margin.top + ")");

        this.svg.append("g")
            .attr("class", "x axis")
            .attr("transform", "translate(0," + this.defaults.height + ")");

        this.svg.append("g")
            .attr("class", "y axis")
            .append("text")
            .attr("transform", "rotate(-90)")
            .attr("y", 6)
            .attr("dy", ".71em")
            .style("text-anchor", "end")
            .text("Amount");
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
        var width = this.defaults.width;
        var animationDuration = this.defaults.animationDuration;
        if (viewportWidth <= 1199) {
            width = width - 240;
            animationDuration = animationDuration - 120;
        }

        var data = this.getData();
        console.log(data);

        var nxExtent, barWidth;
        if (data.length > 1) {
//            var barRawWidth = this.defaults.width / (d3.time[this.intervalType].range(data[0].date, data[data.length - 1].date).length + 2);
            var barRawWidth = width / (d3.time[this.intervalType].range(data[0].date, data[data.length - 1].date).length + 2);
            var barPadding = 5;
            barWidth = 10;//barRawWidth - (barPadding * 2);

            var xExtent = d3.extent(data, function (d) {
                return d.date;
            });
            nxExtent = [d3.time[this.intervalType].offset(xExtent[0], -1), d3.time[this.intervalType].offset(xExtent[1], 1)];
        } else {
            barWidth = 10;
            nxExtent = d3.extent(data, function (d) {
                return d.date;
            });
        }

        this.x.ticks(data.length + 2);
        this.x.domain(nxExtent);
        this.y.domain([0, d3.max(data, function (d) {
            return d.amount;
        })]);

        this.svg.selectAll("g .x.axis")
            .transition()
//            .duration(this.defaults.animationDuration)
            .duration(animationDuration)
            .call(this.xAxis)
            .selectAll("text")
            .style("text-anchor", "end")
            .attr("dx", "-.8em")
            .attr("dy", ".15em")
            .attr("transform", "rotate(-45)");

        this.svg.selectAll("g .y.axis")
            .transition()
//            .duration(this.defaults.animationDuration)
            .duration(animationDuration)
            .call(this.yAxis);

        var bars = this.svg.selectAll(".bar")
            .data(data, function (d) {
                return d.date;
            });

        bars.enter().append("rect")
            .attr("class", "bar")
            .attr("x", function (d) {
                return this.x(d.date) - barWidth / 2;
            }.bind(this))
            .attr("width", barWidth)
            .attr("y", this.defaults.height)
            .attr("height", 0);

        bars.attr("x", function (d) {
            return this.x(d.date) - barWidth / 2;
        }.bind(this));

        bars.transition()
//            .duration(this.defaults.animationDuration)
            .duration(animationDuration)
            .attr("height", function (d) {
                return this.defaults.height - this.y(d.amount);
            }.bind(this))
            .attr("y", function (d) {
                return this.y(d.amount);
            }.bind(this));

        bars.exit()
            .remove()

    }
});