/**
 * Created by igorborisov on 26.05.14.
 */

var PackageManager = new Marionette.Application();

//Marionette.Renderer.render = function(template, data){
//    return Mustache.to_html(template, data);
//};

//ValamisLocalizedView = {
//    templateHelpers: PackageManager.request("get:languageBank")//,
////    render: function(){
////        var data = this.serializeData();
////        data = this.mixinTemplateHelpers(data);
////
////        var template = this.getTemplate();
////        this.$el.html(Mustache.to_html(template, data));
////
////        return this;
////    }
//};

ValamisLocalizedView = {
    render: function(){
        var mustacheAccumulator = {};

        _.extend(mustacheAccumulator, this.serializeData());
        _.extend(mustacheAccumulator, PackageManager.request("get:languageBank"));

        var template = $(this.template).html();
        this.$el.html(Mustache.to_html(template, mustacheAccumulator));

        if(this.onRender) {
            this.onRender();
        }
        return this;
    }
};

//ValamisLocalizedView = {
//    templateHelpers: window.languageBank,
//    render: function(){
////        var mustacheAccumulator = {};
////        if(this.model){
////            _.extend(mustacheAccumulator, this.model.toJSON());
////        }
////        _.extend(mustacheAccumulator, PackageManager.request("get:languageBank"));
//
//        var data = this.serializeData();
//
//
//        data = this.mixinTemplateHelpers(data);
//
//        var template = $(this.template).html();
//        this.$el.html(Mustache.to_html(template, data));
//        //this.$el.html(Mustache.render(template, mustacheAccumulator));
//
//        return this;
//    }
//};

ValamisItemView = Marionette.ItemView.extend(ValamisLocalizedView);
ValamisCompositeView = Marionette.CompositeView.extend(ValamisLocalizedView);
ValamisModalView = Backbone.Modal.extend(ValamisLocalizedView);




PackageManager.addRegions({
    mainRegion: "#packageManagerMainRegion",
    searchRegion: "#package-manager-search-region",
    fileuploadRegion: "#package-manager-fileupload-region",
    modalRegion: '#packageManagerModalRegion',
    packagesPageContentRegion: '#packagesPageContent',
    toolbarRegion: '#toolbarWrapper',
    bottomPaging: '#bottomPaging',
    editModalRegion: '#packageManagerEditModalRegion'
});

PackageManager.navigate = function(route, options){
    options || (options = {});
    Backbone.history.navigate(route, options);
};

PackageManager.getCurrentRoute = function(){
    return Backbone.history.fragment;
};

PackageManager.on("initialize:before", function(options){
    PackageManager.LanguageBankData = options.languageBank;
});

PackageManager.on("initialize:after", function(options){

    if(Backbone.history){
        Backbone.history.start();
    }

    if(this.getCurrentRoute() === ""){
        this.navigate("packages");
        PackageManager.trigger("packages:index");
    }

    //TODO use another way to work with modals
    PackageManager.trigger("packages:create:modal");
});

