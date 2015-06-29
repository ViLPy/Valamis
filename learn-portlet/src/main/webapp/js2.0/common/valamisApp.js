/**
 * Created by igorborisov on 16.04.15.
 */

var Valamis = Valamis || {};

var ValamisApp = Marionette.Application.extend({
    channelName: 'valamis',
    started : false,
    initialize: function(options) {

    },
    start: function(options){
        var appregionId = 'valamisAppRegion';
        //var appregion = jQueryValamis(appregionName);

        if(jQueryValamis('#' + appregionId).length <= 0) {
            var appregionHtml = '<div id="' + appregionId + '" class="portlet-learn-scorm"></div>';
            jQueryValamis('body').append(appregionHtml);
        }

        this.addRegions({
            mainRegion: '#' + appregionId
        });

        var layoutView = new valamisApp.Views.MainLayout();

        this.mainRegion.show(layoutView);
        this.started = true;
    }
});

var valamisApp = new ValamisApp();


valamisApp.commands.setHandler('modal:show', function(modalView){
    valamisApp.mainRegion.currentView.modals.show(modalView);
});

valamisApp.commands.setHandler('modal:close', function(modalView){
    valamisApp.mainRegion.currentView.modals.destroy(modalView);
});

valamisApp.commands.setHandler('update:tile:sizes', function(viewEl){
    jQueryValamis(window).trigger('recompute:tile:sizes', viewEl);
});


valamisApp.commands.setHandler('delete:confirm', function(options, onConfirm){

    var dialog = new valamisApp.Views.DeleteConfirmationView(options);
    dialog.on('deleteConfirmed',function(){
        if(onConfirm && _.isFunction(onConfirm)) {
            onConfirm();
        }
        dialog.destroy();
    });
    dialog.render();
});

valamisApp.commands.setHandler('subapp:start', function(options){
    //TODO check required options!!!;
    var defaultLanguage = 'en';
    var language = options.language;
    var resourceName = options.resourceName;
    var app = options.app;
    var appOptions = options.appOptions;
    var permissions = options.permissions;

    Valamis = Valamis || {};
    Valamis.permissions = Valamis.permissions || {};
    _.extend(Valamis.permissions, permissions);

    Valamis.language = Valamis.language || {};

    var onBankLanguageLoad  = function(properties) {
        _.extend(Valamis.language , properties);

        app.start(appOptions);
    };

    var onBankLanguageError = function() {
        alert('Translation resource loading failed!');
    };

    var getPackSource = function(language){
        return Utils.getContextPath() + 'i18n/'+ resourceName +'_' + language + '.properties';
    };

    var getLanguageBank = function (options) {
        Backbone.emulateJSON = true;
        var defaultURL = getPackSource(defaultLanguage);
        var localizedURL = getPackSource(options.language);

        Utils.i18nLoader(localizedURL, defaultURL, onBankLanguageLoad, onBankLanguageError);
    };

    getLanguageBank({language : language});
});


