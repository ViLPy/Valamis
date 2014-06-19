/**
 * Created by igorborisov on 26.05.14.
 */


PackageManager.module("Entities", function(Entities, PackageManager,
                                           Backbone, Marionette, $, _){

    var apiUrl = "api/packages?";

    var packageService = new Backbone.Service({ url: "/learn-portlet/",
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
                        visibility: model.get('isVisible'),
                        isdefault: model.get('isDefault'),
                        courseID: Utils.getCourseID(),
                        scope : model.get('scope'),
                        title: model.get('title'),
                        description: model.get('description'),
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

        }
    });

    Entities.Package = Backbone.Model.extend({
        defaults: {
            id: '',
            title: '',
            description: '',
            packageType: '',
            isVisible: true,
            isDefault: false,
            logo:'',
            //logoURLBig: 'http://placehold.it/260x180',
            //logoURLSmall: 'http://placehold.it/130x90',
            type:'',
            contextPath: '/learn-portlet/'//Utils.getContextPath()
        }
    }).extend(packageService);

    var packageCollectionService = new Backbone.Service({ url: "/learn-portlet/",
        sync: {
            'read': {
                path: function(collection, options) {
                    var filter = options.filter || {
                        scope: 'instance',
                        sort : 'nameAsc'
                    };

                    var getParamsString = function(params){
                        var result = '';

                        result+= 'action=ALL';

                        result+= '&courseID=' + Utils.getCourseID();

                        params.scope = params.scope || 'instance';
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

                    return "api/packages?" + params + pageParams;
                },
                'method': "get"
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
