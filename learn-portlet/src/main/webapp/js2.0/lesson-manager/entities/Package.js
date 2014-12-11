/**
 * Created by igorborisov on 26.05.14.
 */


PackageManager.module("Entities", function(Entities, PackageManager, Backbone, Marionette, $, _){

    var apiUrl = path.api.packages + "?";

    var packageService = new Backbone.Service({ url: path.root,
        sync: {
            'read': {
                path: function(model, options) {},
                'method': "get"
            },
            'update' : {
                path: function(model){
                    var params = {
                        action : 'UPDATE',
                        id: model.get('id'),
                        visibility: model.get('visibility'),
                        isdefault: model.get('isDefault'),
                        courseID: Utils.getCourseID(),
                        scope : model.get('scope'),
                        title: model.get('title'),
                        description: model.get('description'),
                        passingLimit: model.get('passingLimit'),
                        rerunInterval: model.get('rerunInterval'),
                        rerunIntervalType: model.get('rerunIntervalType'),
                        packageType: model.get('packageType'),
                        logo: model.get('logo')
                    };

                    var reqParams = $.param(params);
                    return apiUrl + reqParams;
                },
                'method': "post"
            },
            'delete': {
                path: function(model){

                    var params ={
                        action: 'DELETE',
                        id: model.get('id'),
                        scope : model.get('scope'),
                        packageType: model.get('packageType')
                    };

                    return apiUrl + $.param(params);
                },
                method: 'post'
            }

        },
      targets: {
        updateLogo: {
          'path': function (model) {
            return apiUrl + 'action=UPDATELOGO';
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
            filename: ''
        }
    }).extend(packageService);

    var packageCollectionService = new Backbone.Service({ url: path.root,
        sync: {
            'read': {
                path: function(collection, options) {
                    var filter = options.filter || {
                        scope: 'site',
                        sort : 'nameAsc',
                        display: 'all'
                    };

                    var getParamsString = function(params){
                        var result = '';

                        result+= 'action=ALL';

                        result+= '&courseID=' + Utils.getCourseID();

                        params.scope = params.scope || 'site';
                        if (params.scope){
                            result+= '&scope=' + params.scope;
                        }
                        if(params.sort == 'nameAsc') {
                            result+= '&sortBy=name&sortAscDirection=true';
                        }else{
                            result+= '&sortBy=name&sortAscDirection=false';
                        }

                        if(params.enteredFilter){
                            result+= '&filter=' + params.enteredFilter;
                        }

                        params.display = params.display || 'all';
                        result+= '&packageType=' + params.display;

                        return result;
                    };

                    var params = getParamsString(filter);

                    var getPageParamsString = function(pageModel){
                        var result = '';
                        result += '&page=' + pageModel.currentPage;
                        result += '&count=' + pageModel.itemsOnPage;
                        return result;
                    };

                    var pageParams = getPageParamsString(collection.paginatorModel.attributes);

                    return  path.api.packages + "?" + params + pageParams;
                },
                'method': "get"
            }
        },
        targets: {
        'removePackages': {
            'path': function (collection, options) {
                var packageIds = collection.map(function (item) {
                    return item.get('id');
                });
                return path.api.packages + '?action=REMOVEPACKAGES&' + jQuery.param({packageIds : packageIds});
            },
            method: 'post'
        },
        'updatePackages': {
            'path': function (collection, options) {

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
                var courseID = options.courseID || '';

                return path.api.packages + '?action=UPDATEPACKAGES&packages=' +packages +"&scope=" + scope + "&courseID=" + courseID;
            },
            method: 'post'
        }
    }
    });

    Entities.PackageCollection = Backbone.Collection.extend({
        parse: function(response){
           this.paginatorModel.set({totalElements: response.total, currentPage: response.page});
           return response.records;
        },
        model: Entities.Package,
        paginatorModel: new PageModel(),
        initialize: function(){
            this.set({
                paginatorModel: new PageModel()
            });
        }
    }).extend(packageCollectionService);

    Entities.NewPackageCollection = Backbone.Collection.extend({
        model: Entities.Package,
        initialize: function(){
        }
    }).extend(packageCollectionService);

    var API = {
        getPackageEntities: function(filterParam){

            var data = {};
            if(filterParam){
                data.sort = filterParam.sort;
                data.scope = filterParam.scope;
                data.enteredFilter = filterParam.enteredFilter;
                data.display = filterParam.display;
            }

            var packages = new Entities.PackageCollection();

            packages.fetch({filter: filterParam});

            return packages;
        },
        getPackageEntity: function(packageId){

            var valamisPackage = new Entities.Package({id: packageId});
            valamisPackage.fetch();

            return valamisPackage;
        }

    };

    PackageManager.reqres.setHandler("package:entities", function(filterParam){
        return API.getPackageEntities(filterParam);
    });

    PackageManager.reqres.setHandler("package:entity", function(id){
        return API.getPackageEntity(id);
    });

});
