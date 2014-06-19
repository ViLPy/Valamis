var PackageFilterModel = Backbone.Model.extend({
    defaults: {
        id: -1,
        packageName: '',
        checked: false
    }
});

var PackageFilterCollection = Backbone.Collection.extend({
    model: PackageFilterModel
});