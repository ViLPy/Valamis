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
    itemsOnPage: 10,
    startElementNumber: 0,
    endElementNumber: 0,
    currentPage: 1,
    options: [10, 25, 50, 100]
  },
  initialize: function () {
    this.on('change', this.countStartEndElements, this)
  },
  countStartEndElements: function () {
    this.startElementNumber = (this.currentPage - 1) * this.itemsOnPage + 1;
    this.set({startElementNumber: Math.min((this.get('currentPage') - 1) * this.get('itemsOnPage') + 1, this.get('totalElements'))}, {silent: true});
    this.set({endElementNumber: Math.min(this.get('currentPage') * this.get('itemsOnPage'), this.get('totalElements'))}, {silent: true});
  }
});

var ValamisPaginator = Backbone.View.extend({
  events: {
    'click .paginator-previous-page': 'previous',
    'click .paginator-next-page': 'next',
    'change .paginator-items-per-page': 'onItemsPerPageChanged'
  },
  initialize: function (options) {
    if (options === undefined || options.model === undefined) this.model = new PageModel();
    this.language = options.language;
    if (options.needDisplay === undefined)
      this.needDisplay = false;
    else
      this.needDisplay = options.needDisplay;
    this.model.on('change', this.render, this);
  },
  render: function () {
    var templateContainer = jQuery('#paginatorTemplate');
    if (templateContainer.length == 0) throw new Error('Paginator template not found');

    var template = Mustache.to_html(templateContainer.html(), _.extend(this.model.toJSON(), this.language));
    this.$el.html(template);

    if (this.needDisplay) {
      var displayTemplate = Mustache.to_html(jQuery('#paginatorDisplayTemplate').html(), _.extend(this.model.toJSON(), this.language));
      this.$el.find("#paginatorDisplay").html(displayTemplate);
    }
    this.$('.paginator-items-per-page').val(this.model.get('itemsOnPage'));
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
    var current = this.model.get('currentPage');
    if (current == 1) return;
    this.updatePage(current - 1);
  },

  next: function () {
    var current = this.model.get('currentPage');
    if (current >= this.model.get('totalElements') / this.model.get('itemsOnPage')) return;
    this.updatePage(current + 1);
  },
  setItemsPerPage: function(count){
    this.model.set({
      itemsOnPage: count
    });
  },
  onItemsPerPageChanged: function () {
    this.model.set({
      itemsOnPage: this.$('.paginator-items-per-page').val(),
      currentPage: 1
    });

    this.trigger('pageChanged', this);
    this.model.trigger('pageChanged', this);
  },

  updatePage: function (current) {
    this.model.set({ currentPage: current });

    this.trigger('pageChanged', this);
    this.model.trigger('pageChanged', this);
  }
});