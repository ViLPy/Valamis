var PersonalPackageList = Backbone.View.extend({
  initialize: function (options) {
    this.collection.on('reset', this.addAll, this);
    this.language = options.language;
  },
  events: {
    'click #selectPackageButton': 'addPackage'
  },
  render: function () {
    this.$el.empty();
    return this;
  },
  addAll: function () {
    if (this.collection.length == 0) this.$el.html(this.language['noPackagesLabel'])
    else this.collection.forEach(this.addRow, this);
  },
  addRow: function (model) {
    var template = jQuery('#personalPackageListItemTemplate').html();
    this.$el.append(Mustache.to_html(template, model.toJSON()));
  },
  addPackage: function (event) {
    var target = jQuery(event.target);
    var id = target.data('package-id');
    target.parent().remove();
    var packageModel = this.collection.get(id);
    packageModel.addToPlayer();
    this.trigger('add-package', packageModel);
    this.collection.remove(packageModel);
  }
});