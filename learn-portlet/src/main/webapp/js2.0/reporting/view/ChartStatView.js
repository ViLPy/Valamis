var viewportWidth = jQueryValamis(window).width();
var ChartStatView = Backbone.Marionette.View.extend({
    tagName: 'div',
    defaults: {
        margin: {top: 20, right: 20, bottom: 80, left: 50},
        width: 530,
        height: 280,
        animationDuration: 400
    },
    modelEvents: {
        'change': 'updateData'
    },
    getData: function () {
        var startedData = _.groupBy(this.model.get('startedData'), 'date');
        var completedData = _.groupBy(this.model.get('completedData'), 'date');
        var experiencedData = _.groupBy(this.model.get('experiencedData'), 'date');
        var preparedData = {};
        _.forEach(startedData, function (value, key) {
            var amount = _.reduce(value, function (memo, v) {
                return memo + v.amount
            }, 0);
            if (!preparedData[key]) {
                preparedData[key] = {'date': key, 'started': amount, 'completed': 0, 'passed': 0}
            } else {
                preparedData[key].started = amount;
            }
        });
        _.forEach(completedData, function (value, key) {
            var amount = _.reduce(value, function (memo, v) {
                return memo + v.amount
            }, 0);
            if (!preparedData[key]) {
                preparedData[key] = {'date': key, 'started': 0, 'completed': amount, 'passed': 0}
            } else {
                preparedData[key].completed = amount;
            }
        });
        _.forEach(experiencedData, function (value, key) {
            var amount = _.reduce(value, function (memo, v) {
                return memo + v.amount
            }, 0);
            if (!preparedData[key]) {
                preparedData[key] = {'date': key, 'started': 0, 'completed': 0, 'passed': amount}
            } else {
                preparedData[key].passed = amount;
            }
        });
        var data = [];
        for (var key in preparedData) {
            var date = new Date(+preparedData[key].date);
            preparedData[key].date = date.toLocaleDateString();
            data.push(preparedData[key]);
        }
        return data;
    },
    initializeRender: function () {
        var margin = this.defaults.margin;
        this.width = this.defaults.width - margin.left - margin.right;

        if (viewportWidth <= 1199)
            this.width = this.width - 100;

        this.height = this.defaults.height - margin.top - margin.bottom;

        this.x0 = d3.scale.ordinal()
            .rangeRoundBands([0, this.width], .1);

        this.x1 = d3.scale.ordinal();

        this.y = d3.scale.linear()
            .range([this.height, 0]);

        this.color = d3.scale.ordinal()
            .range(["#1f77b4", "#ff7f0e", "#2ca02c"]);

        this.xAxis = d3.svg.axis()
            .scale(this.x0)
            .orient("bottom");

        this.yAxis = d3.svg.axis()
            .scale(this.y)
            .orient("left")
            .tickFormat(d3.format(".2s"));

        this.svg = d3.select(this.el).append("svg")
            .attr("width", this.width + margin.left + margin.right)
            .attr("height", this.height + margin.top + margin.bottom)
            .append("g")
            .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

        this.svg.append("g")
            .attr("class", "x axis")
            .attr("transform", "translate(0," + this.height + ")");

        this.svg.append("g")
            .attr("class", "y axis")
            .append("text")
            .attr("transform", "rotate(-90)")
            .attr("y", 6)
            .attr("dy", ".71em")
            .style("text-anchor", "end")
            .text("Amount");

        this.updateData();
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

        var ageNames = d3.keys(data[0]).filter(function (key) {
            return key !== "date";
        });

        data.forEach(function (d) {
            d.ages = ageNames.map(function (name) {
                return {name: name, value: +d[name]};
            });
        });

        if (!this.x0) return;
        this.x0.domain(data.map(function (d) {
            return d.date;
        }));
        this.x1.domain(ageNames).rangeRoundBands([0, this.x0.rangeBand()]);
        this.y.domain([0, d3.max(data, function (d) {
            return d3.max(d.ages, function (d) {
                return d.value;
            });
        })]);

        var animationDuration = this.defaults.animationDuration;
        if (viewportWidth <= 1199)
            animationDuration = animationDuration - 120;

        this.svg.selectAll("g .x.axis")
            .transition()
            .duration(animationDuration)
//            .duration(this.defaults.animationDuration)
            .call(this.xAxis);
        this.svg.selectAll("g .x.axis").selectAll("text")
            .style("text-anchor", "end")
            .attr("dx", "-.8em")
            .attr("dy", ".15em")
            .attr("transform", "rotate(-65)");

        this.svg.selectAll("g .y.axis")
            .transition()
            .duration(animationDuration)
//            .duration(this.defaults.animationDuration)
            .call(this.yAxis);

        var state = this.svg.selectAll(".state")
            .data(data, function (d) {
                return(d.date);
            });

        state.enter().append("g")
            .attr("class", "state")
            .attr("transform", function (d) {
                return "translate(" + this.x0(d.date) + ",0)";
            }.bind(this));

        var subState = state.selectAll("rect")
            .data(function (d) {
                return d.ages;
            });

        subState.enter().append("rect")
            .attr("data-type", function (d) {
                return d.name
            })
            .attr("width", this.x1.rangeBand())
            .attr("x", function (d) {
                return this.x1(d.name);
            }.bind(this))
            .attr("y", this.height)
            .style("fill", function (d) {
                return this.color(d.name);
            }.bind(this))
            .attr("height", function (d) {
                return 0;
            }.bind(this));

        subState.transition()
            .duration(animationDuration)
//            .duration(this.defaults.animationDuration)
            .attr("height", function (d) {
                return this.height - this.y(d.value);
            }.bind(this))
            .attr("y", function (d) {
                return this.y(d.value);
            }.bind(this));

        state.exit().selectAll('rect')
            .transition()
            .duration(animationDuration)
//            .duration(this.defaults.animationDuration)
            .attr('height', 0)
            .attr("y", this.height)
            .remove();
        state.exit()
            .transition()
            .delay(animationDuration)
//            .delay(this.defaults.animationDuration)
            .remove();
    },
    highlight: function (type) {
        var state = this.svg.selectAll(".state");
        state.selectAll('rect')
            .transition()
            .duration(300)
            .style("opacity", function (d) {
                if (!type || d.name === type) {
                    return 1
                } else {
                    return 0.2;
                }
            });
    }
});