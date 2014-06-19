SettingsView = Backbone.View.extend({
  events: {
    'click #visibility': 'updateScopePackageVisibility',
    'click #isDefault': 'updateIsDefaultValue'
  },

  initialize: function (options) {
    this.language= options.language;
    this.$el = jQuery('<tr>');
    this.$el.attr('id', this.model.id);
  },

  setActive: function () {
    this.$el.addClass('SCORMHighlitedPackage');
    this.trigger('change-active', this);
  },

  updateScopePackageVisibility: function () {
    this.model.save({
      visibility: this.$('#visibility').is(':checked')
    });
  },

  updateIsDefaultValue: function () {
    this.model.save({
      isDefault: this.$('#isDefault').is(':checked')
    });
    this.setActive();
    this.trigger('change-isDefault', this);
  },

  render: function () {
    this.showDefault();
    return this.$el;
  },

  showDefault: function () {
    var template = Mustache.to_html(jQuery('#packageScopeRuleRow').html(), _.extend(this.model.toJSON(), this.language,
      {isTincan: this.model.get('type') == 'tincan'}));
    this.$el.html(template);
  },

  onSave: function () {
    this.model.save({
      title: this.$('#title').val(),
      summary: this.$('#summary').val(),
      visibility: this.$('#visibility').is(':checked'),
      isDefault: this.$('#isDefault').is(':checked')
    });
    this.showDefault();
  },

  onDestroy: function () {
    this.model.destroy();
    this.remove();
  }
});

PlayerSettingsListView = Backbone.View.extend({
  events: {
    'click .sortable': 'sortPackages'
  },

  initialize: function (options) {
    this.language = options.language;
    this.activePackageView = null;
    this.sortableAscOrder = [];
    this.collection.on('add', this.addPackage, this);
    this.collection.on('reset', this.addPackagesFromCollection, this);
    this.render();
  },

  render: function () {
    var template = Mustache.to_html(jQuery('#packageScopeRuleListTemplate').html(), this.language);
    this.$el.html(template);
    this.scormPlayerSettingsPackageList = this.$('#SCORMPackageScopeRuleGrid').List();
    this.$('.sortable').each(jQuery.proxy(function (index, element) {
      var dom = jQuery(element);
      this.sortableAscOrder[dom.attr('ref')] = true;
      var icon = jQuery('<div>');
      icon.addClass('ui-icon');
      icon.addClass('ui-icon-triangle-1-n');
      icon.addClass('scormSortIcon');
      dom.append(icon);
    }, this));

    return this.$el;
  },

  filterPackages: function (text) {
    this.scormPlayerSettingsPackageList.filter(text);
  },

  sortPackages: function (event) {
    var targetRow = jQuery(event.target);
    var ref = targetRow.attr('ref');
    this.sortableAscOrder[ref] = !this.sortableAscOrder[ref];
    jQuery('.ui-icon', targetRow).toggleClass('ui-icon-triangle-1-n').toggleClass('ui-icon-triangle-1-s');
    this.scormPlayerSettingsPackageList.sort(ref, this.sortableAscOrder[ref] ? 'asc' : 'desc');
  },

  addPackage: function (pkg) {
    var view = new SettingsView({
      model: pkg,
      language: this.language
    });
    view.on('change-active', this.changeActive, this);
    view.on('change-isDefault', this.changeIsDefault, this);

    var renderedView = view.render();
    this.scormPlayerSettingsPackageList.add(pkg.id, renderedView, pkg.toJSON());
    this.$('#SCORMPackageScopeRuleGrid').append(renderedView);
  },

  changeActive: function (view) {
    if (!this.activeEditing) {
      this.activePackageView = view;
    }
    this.$('tr[id!=' + this.activePackageView.model.id + ']').removeClass('SCORMHighlitedPackage');
  },

  changeIsDefault: function () {
    this.collection.each(this.uncheckDefaults, this)
  },

  uncheckDefaults: function (item) {
    if (item.id != this.activePackageView.model.id) {
      this.$('tr[id=' + item.id + ']>td>#isDefault').attr('checked', false);
    }
  },

  addPackagesFromCollection: function () {
    this.$('#SCORMPackageScopeRuleGrid').empty();
    this.collection.each(this.addPackage, this);
  }
});
