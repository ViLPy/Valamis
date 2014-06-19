PackageManager.module("PackagesApp", function(PackagesApp, PackageManager,
                                              Backbone, Marionette, $, _){


    PackagesApp.packagesPageContent = new PackagesApp.Common.PageContentLayout();

    PackagesApp.toolBarLayout = new PackagesApp.Common.ToolbarLayout();

    PackagesApp.fileuploadView = new PackagesApp.FileUpload.ButtonView({});



    PackagesApp.initLayouts = function(){

        var lastSearchParams = packageManagerSettings.get('searchParams');
        PackagesApp.searchFormView = new PackagesApp.Search.Form({ searchParams : lastSearchParams });

        PackagesApp.searchFormView.on("search:filter", function(model){
            packageManagerSettings.set('searchParams', model);
            packageManagerSettings.save();
            PackageManager.trigger("packages:filter", model);
        });

        PackageManager.packagesPageContentRegion.show(PackagesApp.packagesPageContent);
        PackageManager.toolbarRegion.show( PackagesApp.toolBarLayout);

        PackagesApp.fileuploadView.on("fileupload:show:modal", function(){

            var model = new PackageManager.Entities.Package();
            var newPackageModal = new PackagesApp.List.NewPackageModal ({model:  model});

            newPackageModal.on("packageupload:show:modal", function(model){
                var endpointparam = {
                    action:'ADD',
                    courseID:  Utils.getCourseID(),
                    contentType: 'scorm-package'
                };

                var fileUploadModal = new PackagesApp.FileUpload.Modal({endpointParams :endpointparam });
                fileUploadModal.on("fileupload:done", function(result){
                    model.set('id', result.id);
                    model.set('packageType', result.contentType);

                    PackageManager.request("package:save", model);
                    newPackageModal.close();
                });

                PackageManager.request("package:show:modal", fileUploadModal);
            });

            PackageManager.request("package:show:editmodal", newPackageModal);
        });

        PackageManager.fileuploadRegion.show(PackagesApp.fileuploadView);
        PackageManager.searchRegion.show(PackagesApp.searchFormView);

        var packages = PackageManager.request("package:entities", lastSearchParams);

        var packageListDisplayType = packageManagerSettings.get('layout');

        PackagesApp.packagesListView = new PackagesApp.List.Packages({
            collection:packages,
            displayType: packageListDisplayType
        });

        PackagesApp.packagesListView.on("itemview:package:change:visibility", function(childView, model){
            var searchForm  = PackageManager.request("package:get:search-param");

            model.set('isVisible', !model.get('isVisible'));
            model.set('scope', searchForm.scope );
            model.save({ scope : searchForm.scope });
        });

        PackagesApp.packagesListView.on("itemview:package:change:default", function(childView, model){
            var searchForm  = PackageManager.request("package:get:search-param");
            model.set('isDefault', !model.get('isDefault'));
            model.set('scope', searchForm.scope );
            model.save({ scope : searchForm.scope });
        });

        PackagesApp.packagesListView.on("itemview:package:delete", function(childView, model){
            var searchForm = PackageManager.request("package:get:search-param");
            model.set('scope', searchForm.scope );
            model.destroy({success: function(){
                PackageManager.request("package:list:reload");
            }});
        });

        PackagesApp.packagesListView.on("view:displayType:change", function(displayType){
            packageManagerSettings.set('layout', displayType);
            packageManagerSettings.save();
         });

        PackagesApp.packagesListView.on("itemview:package:edit", function(childView, model){
            var contextPath = Utils.getContextPath();
            model.set('contextPath', contextPath);
            var editModal = new PackagesApp.List.EditPackageModal({model:  model});

            editModal.on("imageupload:show:modal", function(){
                var endpointparam = {
                    action:'ADD',
                    courseID:  Utils.getCourseID(),
                    contentType: 'icon',
                    folderId: 'package_logo_' + model.get('id')
                };

                var fileUploadModal = new PackagesApp.FileUpload.Modal({endpointParams :endpointparam });
                fileUploadModal.on("fileupload:done", function(result){
                    model.set('logo', result.name);
                });

                PackageManager.request("package:show:modal", fileUploadModal);
            });

            PackageManager.request("package:show:editmodal", editModal);
        });

        var paginatorModel = PackagesApp.packagesListView.collection.paginatorModel;

        PackagesApp.pagingView = new PackagesApp.Common.Paginator({  model: paginatorModel, language: PackageManager.request("get:languageBank")});
        PackagesApp.bottomPagingView = new PackagesApp.Common.Paginator({  model: paginatorModel, language: PackageManager.request("get:languageBank")});

        PackagesApp.pagingView.on('pageChanged', function(){
            PackageManager.request("package:list:reload");
        });

        PackagesApp.bottomPagingView.on('pageChanged', function(){
            PackageManager.request("package:list:reload");
        });

        PackagesApp.toolBarLayout.paging.show(PackagesApp.pagingView);
        PackageManager.bottomPaging.show(PackagesApp.bottomPagingView);

        PackageManager.mainRegion.show(PackagesApp.packagesListView);

    };

    PackagesApp.Router = Marionette.AppRouter.extend({
        appRoutes: {
            "packages" : "index"//,
        }
    });

    var API = {
        index: function(){

        },

        filterListPackages: function(filterParam){
            PackagesApp.packagesListView.collection.reset();
            PackagesApp.packagesListView.collection.fetch({filter: filterParam});
        }
    };

    PackageManager.on("packages:filter", function(filterParam){
        API.filterListPackages(filterParam);
    });

    PackageManager.on("packages:index", function(){
        API.index();
    });

    PackageManager.addInitializer(function(){
        new PackagesApp.Router({
            controller: API
        });
        PackagesApp.initLayouts();
    });

    PackageManager.on("packages:create:modal", function(){
        var modalLayout = new PackagesApp.Common.ModalsLayout();
        PackageManager.modalRegion.show(modalLayout);

        var editModalLayout = new PackagesApp.Common.ModalsLayout();
        PackageManager.editModalRegion.show(editModalLayout);
    });

    PackageManager.on("itemview:resize:to:mobile", function(displayType){
        PackagesApp.packagesListView.setDisplayType(displayType);

        jQuery('#packageManagerListView').addClass('active');
        jQuery('#packageManagerTilesView').removeClass('active');
    });

    PackageManager.reqres.setHandler("package:show:modal", function(modal){
        PackageManager.modalRegion.show(modal);
    });

    PackageManager.reqres.setHandler("package:show:editmodal", function(modal){
        PackageManager.editModalRegion.show(modal);
    });


    PackagesApp.toolBarLayout.on("toolbar:displaytype:change", function(displayType){
        PackagesApp.packagesListView.setDisplayType(displayType);
    });

    PackageManager.reqres.setHandler("package:save", function(model){
        var searchForm  = Backbone.Syphon.serialize(PackagesApp.searchFormView);

        model.set('scope', searchForm.scope );
        model.save({ scope : searchForm.scope}, {
            success: function(){
                PackageManager.request("package:list:reload");
            }
        });
    });

    PackageManager.reqres.setHandler("package:get:search-param", function(){
        var searchForm = Backbone.Syphon.serialize(PackagesApp.searchFormView);
        return  searchForm;
    });

    PackageManager.reqres.setHandler("package:list:reload", function(){
        PackagesApp.searchFormView.applyFilter();
    });

    PackageManager.reqres.setHandler("get:languageBank", function(){
        return PackageManager.LanguageBankData;
    });
});