MyApp.module('EntitiesModule', function (EntitiesModule, MyApp, Backbone, Marionette, $, _) {
    EntitiesModule.ElementModel = Backbone.Model.extend({
        defaults: {
            elementType: 'TextElementModule',
            width: 100,
            left: 0,
            top: 0,
            content: ''
        },
        initialize: function() {
            this.id = getUUID();
        }
    });

    EntitiesModule.ElementCollection = Backbone.Collection.extend({
        model: EntitiesModule.ElementModel
    });

    EntitiesModule.PageModel = NestedTypes.Model.extend({
        defaults: {
            pageElements: EntitiesModule.ElementCollection,
            background: ''
        },
        initialize: function() {
            this.id = getUUID();
        }
    });

    EntitiesModule.PageCollection = Backbone.Collection.extend({
        model: EntitiesModule.PageModel
    });

    EntitiesModule.PageGroupModel = NestedTypes.Model.extend({
        defaults: {
            childPages: EntitiesModule.PageCollection
        }
    });

    EntitiesModule.PageGroupCollection = Backbone.Collection.extend({
        url: '/learn-portlet/data/data.json',
        model: EntitiesModule.PageGroupModel
    });

    var data = new EntitiesModule.PageGroupCollection({});

    MyApp.reqres.setHandler('entities:getAll', function(){
        return data;
    });

    EntitiesModule.addInitializer(function () {
        data.fetch();
    });
});