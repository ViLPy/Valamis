MyCertificateListView = Backbone.View.extend({
    events:{
        // note supported because of accordion.
        // accordion contains header and body and there is no parent node for them,
        // that is why List is not supported, it needs parent node for correct work
       // "click #mySortList":"sortList",
       // "keyup #myCertificateSearch":"searchList"
    },

    initialize:function () {
        //this.views = [];
        this.sortAZ = true;

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('reset', this.addAll, this);
    },


    addOne:function (element) {
        var view = new MyCertificateListItemView({
            el:this.$("#myCertificateList"),
            model:element,
            language:this.options.language
        });

        //this.views[element.id] = view;
        view.render();

        //this.certificateList.add(element.id, viewDOM, {"title":element.get('title'), "description":element.get('description')}, true);
    },

    addAll:function () {
        this.render();
        this.collection.each(this.addOne, this);
        this.$("#myCertificateList").accordion();
    },

  /*  searchList:function () {
        this.certificateList.filter(this.$("#myCertificateSearch").val() || "");
    },
    sortList:function () {
        if (this.certificateList) {
            this.certificateList.sort("title", this.sortAZ ? "asc" : "desc");

            var sortOrderString = (this.sortAZ) ? this.options.language['sortOrderAscLabel'] : this.options.language['sortOrderDescLabel'];
            this.$("#mySortList").html(sortOrderString);
            this.sortAZ = !this.sortAZ;
        }
    },*/

    render:function () {
        this.$el.empty();
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#myCertificateListView").html(), _.extend({
            cid:this.cid
        }, language));
        this.$el.append(template);

        //this.certificateList = this.$("#myCertificateList").List();

        return this;
    }
});
