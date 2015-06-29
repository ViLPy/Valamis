var PersonalPackageList = Backbone.View.extend({
  initialize: function (options) {
    this.collection.on('reset', this.addAll, this);
    this.language = options.language;
  },
  events: {
    'click #selectPackageButton': 'addPackage'
  },
  className: 'div-table valamis left-bordered medium-table list-table',
  render: function () {
    this.$el.empty();
    return this;
  },
  addAll: function () {
    if (this.collection.length == 0) {
        this.$el.html(this.language['noPackagesLabel']);
        this.$el.addClass('valamis-info-label shifted');
    }
    else this.collection.forEach(this.addRow, this);
  },
  addRow: function (model) {
    var template = jQueryValamis('#personalPackageListItemTemplate').html();
    this.$el.append(Mustache.to_html(template, model.toJSON()));
  },
  addPackage: function (event) {
    var currentTarget = jQueryValamis(event.target);
    var target = currentTarget.hasClass('.js-toggle-site-button') ? currentTarget : currentTarget.parents('.js-toggle-site-button');

    var id = target.data('package-id');
    target.parent().parent().remove();
    var packageModel = this.collection.get(id);
    packageModel.addToPlayer();
    this.trigger('add-package', packageModel);
    this.collection.remove(packageModel);
  }
});
