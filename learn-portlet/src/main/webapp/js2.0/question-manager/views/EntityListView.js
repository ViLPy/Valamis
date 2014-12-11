var qbEntityListView = Backbone.View.extend({
  events: {
    'click .selectAll': 'selectAll',
    'click .dropdown-button': 'toggleAction',
    'click .deleteEntities': 'confirmDeleteSelectedEntities',
    'click .moveEntities': 'moveSelectedEntities',
    'click .exportEntities': 'exportSelectedEntities'
  },
  initialize: function (options) {
    this.language = options.language;
    this.catCollection = options.catCollection || new Backbone.Collection();
    this.qCollection = options.qCollection;
    this.baseTitle = options.baseTitle;

    this.model = new Backbone.Model();
    this.views = [];
    this.model.set({
      root: options.isRoot,
      title: options.title
    });
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#entityListTemplate').html(), _.extend({baseTitle: this.baseTitle}, this.model.toJSON(), this.language));
    this.$el.html(template);
    return this;
  },
  renderEntities: function () {
    this.catCollection.each(this.addEntity, this);
    this.qCollection.each(this.addEntity, this);
  },
  addEntity: function (item) {
    var view = new qbEntityRow({model: item, language: this.language });
    this.views[item.id] = view;
    view.on('editEntityRow', function (item) {
      this.trigger('editEntityRow', item);
    }, this);
    view.on('removeEntityRow', function (item) {
      this.trigger('removeEntityRow', item);
    }, this);
    this.$('#qbItemsList').append(view.render().$el);
  },
  selectAll: function () {
    var catNotSelectedItem = this.catCollection.find(function (item) {
      return item.get('selected') != true
    });
    var qNotSelectedItem = this.qCollection.find(function (item) {
      return item.get('selected') != true
    });
    if (catNotSelectedItem || qNotSelectedItem) {
      this.catCollection.each(function (item) {
        item.set({selected: true});
      }, this);
      this.qCollection.each(function (item) {
        item.set({selected: true});
      }, this);
    }
    else {
      this.catCollection.each(function (item) {
        item.set({selected: false});
      }, this);
      this.qCollection.each(function (item) {
        item.set({selected: false});
      }, this);
    }
  },
  toggleAction: function () {
    this.$('.dropdown-button').toggleClass('active');
    this.$('.dropdown-button-menu').toggleClass('dropdown-visible');
  },
  confirmDeleteSelectedEntities: function () {
    this.toggleAction();
    var confirmView = new DeleteConfirmationView({language: this.language});
    confirmView.on('deleteConfirmed', this.deleteSelectedEntities, this);
    toastr.info(confirmView.render().$el, '',
      {
        "positionClass": "toast-center",
        "timeOut": "0",
        "showDuration": "0",
        "hideDuration": "0",
        "extendedTimeOut": "0"
      });
  },
  exportSelectedEntities: function () {
      this.toggleAction();
      var export_url = path.root + path.api.files + 'export/?action=EXPORT&contentType=question&courseID=' + jQuery('#courseID').val();
      this.catCollection.where({selected: true}).forEach(function (item) {
          export_url+= '&categoryID=' + item.id;
      }, this);
      this.qCollection.where({selected: true}).forEach(function (item) {
          export_url+= '&id=' + item.id;
      }, this);
      window.location = export_url;
  },
  deleteSelectedEntities: function () {
    this.catCollection.where({selected: true}).forEach(function (item) {
      this.trigger('removeEntityRow', 'c' + item.id);
      this.views[item.id].drop();
    }, this);
    this.qCollection.where({selected: true}).forEach(function (item) {
      this.trigger('removeEntityRow', 'q' + item.id);
      this.views[item.id].drop();
    }, this);
  },
  moveSelectedEntities: function() {
    var catSelected = this.catCollection.where({selected: true}).map(function (item) {
      return item.get('id');
    });
    var questSelected = this.qCollection.where({selected: true}).map(function (item) {
      return item.get('id');
    });

    var categories = jQuery.param({'categoryIDs': catSelected}, true);
    var questions = jQuery.param({'questionIDs': questSelected}, true);

    if (categories != '' || questions != '') {
      this.toggleAction();
      this.trigger('moveEntityToSite', [categories, questions]);
    }
  }
});

var qbEntityRow = Backbone.View.extend({
  events: {
    'click .val-icon-delete': 'confirmDelete',
    'click .val-icon-edit': 'edit',
    'click #selectEntityCheckbox': 'selectThis'
  },
  initialize: function (options) {
    this.$el = jQuery1816Bank('<tr>');
    this.language = options.language;
    this.model.on('change', this.render, this);
    if (this.model instanceof QuestionModel) this.model.set({type: this.language['typeLabel' + this.model.get('questionType')]})
    else this.model.set({type: 'category'});
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#qbEntityRowTemplate').html(), _.extend(this.model.toJSON(), this.language));
    this.$el.html(template);
    return this;
  },
  confirmDelete: function () {
    var confirmView = new DeleteConfirmationView({language: this.language});
    confirmView.on('deleteConfirmed', this.doDelete, this);
    // var title = this.language['deleteConfirmationTitle'];
    toastr.info(confirmView.render().$el, '',
      {
        "positionClass": "toast-center",
        "timeOut": "0",
        "showDuration": "0",
        "hideDuration": "0",
        "extendedTimeOut": "0"
      });
  },
  doDelete: function () {
    this.drop();
      var prefix = '';
      if (this.model instanceof CategoryModel)
          prefix ='c';
      else if (this.model instanceof QuestionModel)
          prefix ='q';
    this.trigger('removeEntityRow', prefix + this.model.id);
  },
  drop: function () {
    this.remove();
  },
  edit: function () {
    this.trigger('editEntityRow', this.model);
  },
  selectThis: function () {
    var selected = this.model.get('selected');
    this.model.set({selected: !selected});
    this.$('#selectMemberCheckbox').toggleClass('checked');
  }
});

