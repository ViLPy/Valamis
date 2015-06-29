/*
 Valamis paginator

 example way of usage:
 this.pageModel = new PageModel();

 this.paginator = new ValamisPaginator({el: jQuery('#testPaginator'), model: this.pageModel});
 this.paginator.on('pageChanged', function(){ console.log('pageChanged!!'); });
 this.paginator.updateItems(54);

 this.bottomPaginator = new ValamisPaginator({el: jQuery('#testPaginator'), model: this.pageModel});
 this.bottomPaginator.on('pageChanged', function(){ console.log('pageChanged!!'); });
 this.paginator.updateItems(54);

 or

 this.pageModel = new PageModel();
 this.paginator = new ValamisPaginator({el: jQuery('.paginator'), model: this.pageModel});
 this.bottomPaginator = new ValamisPaginator({el: jQuery('.bottomPaginator'), model: this.pageModel});
 this.pageModel.on('pageChanged', function(){ console.log('pageChanged!!'); });

 */

var PageModel = Backbone.Model.extend({
    defaults: {
        itemsOnPage: 40,
        startElementNumber: 0,
        endElementNumber: 0,
        navbuttons: [],
        rightDots: false,
        leftDots: false,
        currentPage: 1,
        totalPages: 0,
        firstPage: {page: 0, isActive: false},
        lastPage: {page: 0, isActive: false},
        showPages: 5,
        isPrevVisible: true,
        isNextVisible: false
    },
    initialize: function () {
        this.on('change', this.countStartEndElements, this);
    },
    countStartEndElements: function () {
        var currentPage = this.get('currentPage');
        var itemsOnPage = this.get('itemsOnPage');
        var totalElements = this.get('totalElements');

        var totalPages = Math.floor(totalElements / itemsOnPage);
        if(totalElements % itemsOnPage !== 0 ) totalPages++;

        var showPages = this.get('showPages');

        if(totalPages <= showPages) showPages = totalPages;

        var showPagesHalf = Math.floor(showPages / 2);

        var subStartPage = currentPage - showPagesHalf;

        if(showPages % 2 == 0 ) subStartPage++;

        var subEndPage = currentPage + showPagesHalf;

        if(subStartPage <= 2) {
            subEndPage = showPages;
            if (subStartPage == 2 && showPages < 5) subEndPage++;
            subStartPage = 1;
        }

        if(subEndPage >= totalPages - 1) {
            subStartPage = totalPages - showPages + 1;
            if (subEndPage == totalPages - 1 && showPages < 5) subStartPage--;

            subEndPage = totalPages;
        }

        var leftDots = subStartPage > 2;
        var rightDots = subEndPage < totalPages - 1;

        var navbuttons = [];
        for(var page = subStartPage; page <= subEndPage; page++){
            navbuttons[page - subStartPage] = {
                page: page,
                isActive: page == currentPage
            };
        }

        this.set(
            {
                startElementNumber: Math.min((currentPage - 1) * itemsOnPage + 1, totalElements),
                endElementNumber: Math.min(currentPage * itemsOnPage, totalElements),
                firstPage: { page: 1, isActive: currentPage == 1},
                lastPage: { page: totalPages, isActive: currentPage == totalPages},
                navbuttons: navbuttons,
                leftDots: leftDots,
                rightDots: rightDots,
                isPrevVisible: currentPage > 1,
                isNextVisible: currentPage < totalPages
            }, {silent: true});
    }
});

var ValamisPaginator = Backbone.View.extend({
    events: {
        'click .js-paginator-previous-page': 'previous',
        'click .js-paginator-next-page': 'next',
        'click .js-paginator-change-page': 'onPageChanged'
    },
    initialize: function (options) {
        options = options || {};
        this.options = {};

        if (options.model === undefined) this.model = new PageModel();

        this.options.language = options.language || [];
        this.model.on('change', this.render, this);
    },
    render: function () {
        var templateContainer = jQuery('#paginatorTemplate');
        if (templateContainer.length == 0) throw new Error('Paginator template not found');

        var template = Mustache.to_html(templateContainer.html(), _.extend(this.model.toJSON(), this.options.language));
        this.$el.html(template);

        if (this.model.get('totalElements') <= this.model.get('itemsOnPage')) {
            this.$el.find(".pagination-group").hide();
        }

        return this;
    },

    updateItems: function (total) {
        this.model.set({totalElements: total});
    },

    currentPage: function () {
        return this.model.get('currentPage');
    },
    itemsOnPage: function () {
        return this.model.get('itemsOnPage');
    },

    previous: function () {
        var current = parseInt(this.model.get('currentPage'));
        if (current == 1) return;
        this.updatePage(current - 1);
    },

    next: function () {
        var current = parseInt(this.model.get('currentPage'));
        if (current >= parseInt(this.model.get('totalElements')) / parseInt(this.model.get('itemsOnPage'))) return;
        this.updatePage(current + 1);
    },
    setItemsPerPage: function (count) {
        this.model.set({
            itemsOnPage: count
        });
    },

    onPageChanged: function(event){
        var page = jQuery(event.target).attr('data-id');
        this.updatePage(page);
    },

    updatePage: function (current) {
        this.model.set({currentPage: current});

        this.trigger('pageChanged', this);
        this.model.trigger('pageChanged', this);
    }
});


var ValamisPaginatorShowing = Backbone.View.extend({
    initialize: function (options) {
        var settings = options || {};
        this.options = {};
        this.options.language = settings.language || [];
        this.model.on('change', this.render, this);
    },
    render: function(){
        var templateContainer = jQuery('#paginatorShowingTemplate');
        if (templateContainer.length == 0) throw new Error('PaginatorShowing template not found');
        var template = Mustache.to_html(templateContainer.html(), _.extend(this.model.toJSON(), this.options.language));

        this.$el.html(template);
        return this;
    }
});
