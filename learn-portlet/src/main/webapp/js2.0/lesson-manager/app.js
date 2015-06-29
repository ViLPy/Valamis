/**
 * Created by igorborisov on 03.03.15.
 */

var LessonManager = Marionette.Application.extend({
    channelName:'lessonManager',
    initialize: function(options) {
        this.addRegions({
            mainRegion: '#lessonManagerAppRegion'
        });

        this.settings = new SettingsHelper({url: window.location.href, portlet: 'packageManager'});
        this.settings.fetch();

    },
    start: function(options){
        var previousFilter = this.settings.get('searchParams');
        this.filter = new lessonManager.Entities.Filter(previousFilter);

        this.filter.on('change', function(){
            lessonManager.execute('packages:reload', true);
            lessonManager.settings.set('searchParams', this.filter.toJSON());
            lessonManager.settings.save();
        }, this);

        this.packages = new lessonManager.Entities.PackageCollection();
        this.paginatorModel = new PageModel();

        var layoutView = new lessonManager.Views.AppLayoutView();

        this.mainRegion.show(layoutView);
    }
});

var lessonManager = new LessonManager();

//package methods
lessonManager.commands.setHandler('package:save', function(model){
    var scope = lessonManager.filter.get('scope');
    var options = {scope: scope, silent: true};
    model.save({}, options);
    model.trigger('package:saved');
});

lessonManager.commands.setHandler('package:remove', function(model){
    model.destroy().then(function(){
        lessonManager.execute('packages:reload');
    });
});

lessonManager.commands.setHandler('packages:reload', function(filterChanged){
    var filter = lessonManager.filter.toJSON();

    if(filterChanged) {
        lessonManager.paginatorModel.set('currentPage', 1);
    }

    lessonManager.packages.fetch({
        reset: true,
        filter: filter,
        currentPage: lessonManager.paginatorModel.get('currentPage'),
        itemsOnPage: lessonManager.paginatorModel.get('itemsOnPage')
    });
});

//package collection methods
lessonManager.commands.setHandler('packages:update', function(collection){
    var scope = lessonManager.filter.get('scope');
    var options = {
        courseId: Utils.getCourseId(),
        scope: scope
    };
    collection.updatePackages({}, options).then(function() {
            lessonManager.execute('packages:reload');
        }
    );
});

lessonManager.commands.setHandler('packages:remove', function(collection){
    collection.removePackages();
    //lessonManager.execute('packages:reload');
});

