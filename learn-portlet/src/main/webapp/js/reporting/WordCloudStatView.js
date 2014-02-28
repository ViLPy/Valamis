var WordCloudStatView = Backbone.Marionette.View.extend({
    tagName: 'div',
    defaults: {
        width: 400,
        height: 280,
        animationDuration: 400
    },
    modelEvents: {
        'change': 'updateData'
    },
    initializeRender: function () {
        this.fill = d3.scale.category20b();

        this.words = [];
        this.tags = {};

        this.fontSize = d3.scale.linear().range([20, 60]);
        this.svg = d3.select(this.el).append("svg")
            .attr("width", this.defaults.width)
            .attr("height", this.defaults.height);

        this.vis = this.svg.append("g")
            .attr("transform", "translate(" + [this.defaults.width >> 1, this.defaults.height >> 1] + ")");

        this.layout = d3.layout.cloud()
            .timeInterval(10)
            .size([this.defaults.width, this.defaults.height])
            .fontSize(function (d) {
                return this.fontSize(+d.value);
            }.bind(this))
            .rotate(0)
            .text(function (d) {
                return d.key;
            })
            .on("end", this.draw.bind(this));

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
        this.tags = this.model.get("data");
        this.tags = d3.entries(this.tags).sort(function (a, b) {
            return b.value - a.value;
        });
        this.layout.font('Impact').spiral('rectangular');
        if (this.tags.length) this.fontSize.domain([+this.tags[this.tags.length - 1].value || 1, +this.tags[0].value]);
        this.words = [];
        this.layout.stop().words(this.tags).start();
    },
    draw: function (data, bounds) {
        this.words = data;
        var text = this.vis.selectAll("text")
            .data(this.words, function (d) {
                return d.text.toLowerCase();
            });
        text.transition()
            .duration(600)
            .attr("transform", function (d) {
                return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
            })
            .style("font-size", function (d) {
                return d.size + "px";
            });
        text.enter().append("text")
            .attr("text-anchor", "middle")
            .attr("transform", function (d) {
                return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
            })
            .style("font-size", function (d) {
                return d.size + "px";
            })
            .style("opacity", 1e-6)
            .transition()
            .duration(300)
            .style("opacity", 1);

        text.style("font-family", function (d) {
                return d.font;
            })
            .style("fill", function (d) {
                return this.fill(d.text.toLowerCase());
            }.bind(this))
            .text(function (d) {
                return d.text;
            });
    }
});