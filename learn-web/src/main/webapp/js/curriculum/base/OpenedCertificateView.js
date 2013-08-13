/**
 * View for displaying opened quizes. Contain tabs with quizes.
 */
OpenedCertificateSiteView = Backbone.View.extend({

    getUID:function (id) {
        return "#certificateTab" + id;
    },

    initialize:function () {
        var that = this;
        var certificateTabs = this.$el.tabs({
            add:jQuery.proxy(function (e, ui) {
                var id = ui.panel.id.replace("certificateTab", "");
                // append close thingy
                jQuery(ui.tab).parents('li:first')
                    .append('<span class="ui-tabs-close ui-icon ui-icon-close" title="' + this.options.language['tabsCloseTabButtonLabel'] + '"></span>')
                    .find('span.ui-tabs-close')
                    .click((function (itemID) {
                    return function () {
                        that.collection.remove(itemID);
                    }
                })(id));

                var model = this.collection.get(id);
                if (model.viewMode == "site")
                    var editView = new CertificateSiteEditView({
                    el:jQuery(this.getUID(id)),
                    model:this.collection.get(id),
                    language:this.options.language
                });
                else
                    var editView = new CertificateUserEditView({
                        el:jQuery(this.getUID(id)),
                        model:this.collection.get(id),
                        language:this.options.language
                    });

                // select just added tab
                certificateTabs.tabs('select', '#' + ui.panel.id);
            }, this)
        });

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('remove', this.remove, this);
    },

    remove:function (element) {
        this.$el.tabs('remove', this.$el.children().index(jQuery(this.getUID(element.id))) - 1);
    },

    select:function (element) {
        this.$el.tabs('select', this.getUID(element.id));
    },

    addOne:function (model) {
        model.on('change', this.updateCertificate, this);
        this.$el.tabs('add', this.getUID(model.id), model.get('title'));
    },

    updateCertificate:function (model) {
        this.$("a[href='#certificateTab" + model.id + "'] > span").html(model.get('title'));
    }
});