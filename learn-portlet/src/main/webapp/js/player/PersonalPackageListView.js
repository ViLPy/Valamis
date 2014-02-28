var AddPersonalPackageDialog = Backbone.View.extend({
    initialize:function () {
        this.$el.dialog({
            modal:true,
            autoOpen:false,
            width:640,
            height: 480
        });
    },
    show:function () {
        this.$el.dialog('open');
    },
    close:function () {
        this.$el.dialog('close');
    }
});

var PersonalPackageList = Backbone.View.extend({
    initialize: function() {
        this.collection.on('reset', this.render, this);
    },
    events: {
        'click #selectPackageButton': 'addPackage'
    },
    render: function() {
        this.$el.empty();
        this.collection.forEach(this.addRow, this);
    },
    addRow: function(model){
        var template = jQuery('#personalPackageListItemTemplate').html();
        this.$el.append(Mustache.to_html(template, model.toJSON()));
    },
    addPackage: function(event) {
        var target = jQuery(event.target);
        var id = target.data('package-id');
        target.parent().remove();
        var packageModel = this.collection.get(id);
        packageModel.addToPlayer();
        this.trigger('add-package', packageModel);
        this.collection.remove(packageModel);
    }
});