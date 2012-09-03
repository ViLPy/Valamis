// Backbone.js + jQuery sync implementation
// model/collection should have valid "storage" field

Backbone.sync = function(method, model, options) {

    var resp;
    var store = model.storage || model.collection.storage;

    if (!store) return;

    switch (method) {
        case "read":
            resp = model.id ? store.find(model) : store.findAll();
            break;
        case "create":
            resp = store.create(model);
            break;
        case "update":
            resp = store.update(model);
            break;
        case "delete":
            resp = store.destroy(model);
            break;
    }

    jQuery.when(resp)
    .then(function(ajaxResult) {
        options.success(ajaxResult);
    })
    .fail(function() {
        options.error("Record not found");
    });
};