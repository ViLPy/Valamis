/**
 * Created by igorborisov on 26.05.14.
 */


lessonManager.module("Entities", function(Entities, lessonManager, Backbone, Marionette, $, _){

    var apiUrl = path.api.packages;

    var packageService = new Backbone.Service({ url: path.root,
        sync: {
            'update' : {
                'path': apiUrl,
                'data': function(model, options){

                        //from {id:#, text:###} to ids
                        var tagIds = [];
                        var modelTags = model.get('tags');
                        for(var i in modelTags) {
                            var tag = modelTags[i];
                            tagIds.push( tag.id || tag )
                        }

                        var params = {
                            action : 'UPDATE',
                            id: model.get('id'),
                            ableToRunFrom: model.get('ableToRunFrom'),
                            ableToRunTo: model.get('ableToRunTo'),
                            attemptCount: model.get('attemptCount'),
                            beginDate: model.get('beginDate'),
                            endDate: model.get('endDate'),
                            description: model.get('description') || 'New description',
                            isDefault: model.get('isDefault'),
                            packageType: model.get('packageType'),
                            passingLimit: model.get('passingLimit'),
                            rerunInterval: model.get('rerunInterval'),
                            rerunIntervalType: model.get('rerunIntervalType'),
                            tags: tagIds,
                            visibility: model.get('visibility'),
                            title: model.get('title'),
                            scope:	 options.scope,
                            courseId: Utils.getCourseId()
                        };

                        return params;
                },
                'method': "post"
            },
            'delete': {
                'path': apiUrl,
                'data': function(model){
                    var params ={
                        action: 'DELETE',
                        id: model.get('id'),
                        courseId: Utils.getCourseId(),
                        scope : model.get('scope'),
                        packageType: model.get('packageType')
                    };
                    return params;
                },
                'method': 'post'
            }

        },
      targets: {
        updateLogo: {
            'path': apiUrl,
            'data': function(model){
                var params =  {
                    action: 'UPDATELOGO',
                    id: model.get('id'),
                    logo: model.get('logo'),
                    packageType: model.get('packageType'),
                    courseId : Utils.getCourseId()
                };
                return params;
            },
            'method': 'post'
        }
      }
    });

    Entities.Package = Backbone.Model.extend({
        defaults: {
            id: '',
            title: '',
            description: '',
            packageType: '',
            visibility: true,
            isDefault: false,
            logo:'',
            type:'',
            contextPath: path.root,
            passingLimit: -1,
            rerunInterval: 0,
            rerunIntervalType: 'UNLIMITED',
            ableToRunFrom: '',
            ableToRunTo: '',
            filename: ''
        }
    }).extend(packageService);

    var packageCollectionService = new Backbone.Service({ url: path.root,
        sync: {
            'read': {
                'path': apiUrl,
                'data': function(collection, options) {

                    var filter = options.filter || {
                            scope: 'site',
                            sort : 'nameAsc',
                            packageType: '',
                            searchtext: '',
                            selectedCategories: []
                        };

                    var sortBy =  (filter.sort == 'nameAsc' || filter.sort == 'nameDesc' )? 'name' : '';

                    var tagId = '';
                    if(filter.selectedCategories && filter.selectedCategories.length >0) {
                        tagId = filter.selectedCategories[0];
                    }

                    var params = {
                        action: 'ALL',
                        courseId: Utils.getCourseId(),
                        scope: filter.scope || 'site',
                        sortBy: sortBy,
                        sortAscDirection: filter.sort == 'nameAsc',
                        filter: filter.searchtext || '',
                        packageType: filter.packageType || '',
                        page: options.currentPage,
                        count: options.itemsOnPage,
                        tagID: tagId
                    };

                    return params;
                },
                'method': "get"
            }
        },
        targets: {
        'removePackages': {
            'path': apiUrl,
            'data': function (collection, options) {
                var packageIds = collection.map(function (item) {
                    return item.get('id');
                });
                var params = {
                    action :'REMOVEPACKAGES',
                    packageIds: packageIds,
                    courseId : Utils.getCourseId()
                };
                return params;
            },
            'method': 'post'
        },
        'updatePackages': {
            'path': apiUrl,
            'data': function (collection, options) {
                var packages =JSON.stringify( collection.map(function (item) {
                    return {
                    id: item.get('id'),
                    title: item.get('title') || "New lesson",
                    description: item.get('description') || "New description",
                    packageType: item.get('packageType'),
                    logo: item.get('logo')
                    };
                } ));

                var scope = options.scope || 'site';
                
                var params = {
                    action: 'UPDATEPACKAGES',
                    packages: packages,
                    scope: scope,
                    courseId: Utils.getCourseId()
                };

                return params;
            },
            'method': 'post'
        }
    }
    });

    Entities.PackageCollection = Backbone.Collection.extend({
        model: Entities.Package,
        parse: function(response){
            this.trigger('packageCollection:updated', { total: response.total, currentPage: response.currentPage });
            _.forEach(response.records,function(record){
                var tags = Array();
                record.tags.forEach(function(item) {
                    tags.push(item.text);
                });
                record.tagsList = tags.join(' • ');
            });

           return response.records;
        }
    }).extend(packageCollectionService);

    Entities.NewPackageCollection = Backbone.Collection.extend({
        model: Entities.Package,
        initialize: function(){
        }
    }).extend(packageCollectionService);

    Entities.Filter = Backbone.Model.extend({
        defaults: {
            scope: 'site',
            packageType: '',
            categories: [],
            searchtext: '',
            sort: 'nameAsc',
            selectedCategories: []
        },
        initialize: function(){
            this.tags = new Valamis.TagCollection();
            this.tags.fetch({reset: true});

            this.tags.on('sync', function(){
                this.set('categories', this.tags.toJSON());
            }, this);
        }
    });

});
