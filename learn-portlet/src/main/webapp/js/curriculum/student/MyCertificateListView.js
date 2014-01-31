MyCertificateListView = Backbone.View.extend({
    events:{
        // "click #mySortList":"sortList",
        // "keyup #myCertificateSearch":"searchList"
        "click #browseAvailable":"browseAvailable"
    },

    initialize:function () {
        this.sortAZ = true;

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('reset', this.addAll, this);

        this.render();
    },

    browseAvailable: function(){
        jQuery("#certificateTabs").tabs('select', 'availableCertificates');
    },

    addOne:function (element) {
        var view = new MyCertificateListItemView({
            model:element,
            language:this.options.language
        });

        this.$("#myCertificateList").prepend(view.render());
    },

    addAll:function () {
        this.$("#myCertificateList").html('');

        if (this.collection.size() > 0) {
            this.collection.each(this.addOne, this);
        }
        else {
            this.$("#myCertificateList").html(Mustache.to_html(jQuery("#noCertificates").html(), _.extend(this.language)));
        }
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
        this.language = language;
        var template = Mustache.to_html(jQuery("#myCertificateListView").html(), _.extend({
            cid:this.cid
        }, language));
        this.$el.append(template);

        var that = this;
        this.collection.on("certificateCollection:updated", function (details) {
            that.updatePagination(details, that);
        });

        jQuery("#myCertificatesPaginator").pagination({
            items:0,
            itemsOnPage:10,
            cssStyle:'light-theme',
            prevText:this.options.language['previous'],
            nextText:this.options.language['next'],
            onPageClick:function (pageNumber, event) {
                that.collection.fetch({reset:true});
            }
        });


        return this;
    },

    updatePagination:function (details, context) {
        jQuery("#myCertificatesPaginator").pagination('updateItems', details.total);
        if (details.total <= 10) jQuery("#myCertificatesPaginator").hide();
        else  jQuery("#myCertificatesPaginator").show();
    }
});
