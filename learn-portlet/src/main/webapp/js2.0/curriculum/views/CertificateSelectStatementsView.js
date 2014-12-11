SelectStatementCollectionService = new Backbone.Service({ url: path.root,
    sync: {
        'read': function (e, options) {
            return path.api.certificates +
                '?action=GETSTATEMENTS' +
                '&page=' + options.currentPage +
                '&count=' + options.itemsOnPage +
                '&filter=' + (jQuery('#statementsSearch').val()?jQuery('#statementsSearch').val():"") +
                '&sortAscDirection=' + (jQuery('#sortStatements').val()?jQuery('#sortStatements').val():"");
        }
    }
});

SelectStatementCollection = Backbone.Collection.extend({
    model: StatementModel,
    parse: function (response) {
        this.trigger('statementCollection:updated', { total: response.total, currentPage: response.currentPage, listed: response.records.length });
        return response.records;
    }
}).extend(SelectStatementCollectionService);

var CertificateSelectStatementsRowView = Backbone.View.extend({
    events: {
        "click .toggleButton": "toggleThis"
    },
    initialize: function (options) {
        function getLangDictionaryValue(value, lang) {
            var langDict = value,
                key;

            if (typeof lang !== "undefined" && typeof langDict[lang] !== "undefined") {
                return langDict[lang];
            }
            if (typeof langDict.und !== "undefined") {
                return langDict.und;
            }
            if (typeof langDict["en-US"] !== "undefined") {
                return langDict["en-US"];
            }
            for (key in langDict) {
                if (langDict.hasOwnProperty(key)) {
                    return langDict[key];
                }
            }

            return "";
        }
        this.options = options;
        this.$el = jQuery('<tr>');
        this.model.on('setSelected', this.setSelected, this);
        this.model.on('setUnselected', this.setUnselected, this);
        this.model.set('verbName',getLangDictionaryValue(this.model.get('verbName')));
        this.model.set('objName',getLangDictionaryValue(this.model.get('objName')));
    },
    render: function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery('#selectStatementsRowView').html(), _.extend(this.model.toJSON(),  language));
        this.$el.html(template);
        return this;
    },
    toggleThis: function () {
        //this.model.trigger('unsetIsSelectedAll', this.model);
        var alreadySelected = this.model.get('selected');
        if (alreadySelected) {
            this.setUnselected();
        }
        else {
            this.setSelected();
        }
    },

    setSelected: function () {
        this.model.set({selected: true });
        this.$('.toggleButton').removeClass('grey');
        this.$('.toggleButton').addClass('green');
    },
    setUnselected: function () {
        this.model.set({selected: false });
        this.$('.toggleButton').removeClass('green');
        this.$('.toggleButton').addClass('grey');
    }
})

var CertificateSelectStatementsListView = Backbone.View.extend({
    events: {
//        'click #addGoals': 'toggleAddGoals',
//        'click #chooseAction': 'toggleAction'
    },
    initialize: function (options) {
        this.options = options;
        this.isSelectedAll = false;

        this.collection = new SelectStatementCollection();
        var that = this;
        this.collection.on('statementCollection:updated', function (details) {
            that.updatePagination(details, that);
        });
        this.collection.on('reset', this.renderElements, this);
    },
    renderElements:function() {
        this.$('#statementsList').empty();
        this.collection.each(function(item){
            var row = new CertificateSelectStatementsRowView({model:item});
            this.$('#statementsList').append(row.render().$el);
        },this);
    },
    updatePagination: function (details, context) {
        this.paginator.updateItems(details.total);
        jQuery('#statementListedAmount').text(details.listed);
    },

    fetchCollection: function () {
        this.collection.fetch({reset: true, currentPage: this.paginator.currentPage(), itemsOnPage: this.paginator.itemsOnPage()});
    },
    reloadFirstPage: function () {
        this.collection.fetch({reset: true, currentPage: 1, itemsOnPage: this.paginator.itemsOnPage()});
    },
    render: function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery('#selectStatementsListView').html(), language);
        this.$el.html(template);


        var that = this;
        this.paginator = new ValamisPaginator({el: this.options.paginator, language: language});
        this.paginator.on('pageChanged', function () {
            that.fetchCollection();
        });

        this.reloadFirstPage();
        return this;
    },
    selectAll: function () {
        this.isSelectedAll = !this.isSelectedAll;
        this.collection.each(this.setSelectAll, this);
    },
    setSelectAll: function (model) {
        var alreadySelected = model.get('selected');
        if (alreadySelected != this.isSelectedAll) {
            if (alreadySelected) {
                model.trigger('setUnselected', this);
            }
            else {
                model.trigger('setSelected', this);
            }

        }
    },
    unsetIsSelectedAll: function () {
        this.isSelectedAll = false;
    },
    addStatements: function () {
        var selectedStatements = this.collection.filter(function (item) {
            return item.get('selected');
        });

        this.options.parentView.options.parentWindow.trigger('addStatements', selectedStatements);
    }
});

var CertificateSelectStatementsDialogView = Backbone.View.extend({
    events: {
        'click #addStatementsButton': 'addStatements',
        'keyup #statementsSearch': 'filterStatements',
        'change #sortStatements': 'filterStatements',
        'click #selectAllStatements': 'selectAllStatements'
    },
    initialize: function (options) {
        this.options = options;

    },
    filterStatements: function () {
        clearTimeout(this.inputTimeout);
        this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
    },
    applyFilter: function () {
        clearTimeout(this.inputTimeout);
        this.listView.reloadFirstPage();
    },
    render: function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery('#selectStatementsDialogView').html(), language);
        this.$el.html(template);
        this.listView = new CertificateSelectStatementsListView({el: this.$('#allStatementsList'),paginator: this.$('#statementListPaginator'),parentView:this, language:this.options.language});
        //this.$('#allStatementsList').append(this.listView.render().$el);
        this.listView.render();
        return this;
    },
    selectAllStatements: function () {
        this.listView.selectAll();
    },
    addStatements: function () {
        this.listView.addStatements();

        this.trigger('closeModal', this);
    }
});