PackageManager.module("PackagesApp", function (PackagesApp, PackageManager, Backbone, Marionette, $, _) {


  PackagesApp.packagesPageContent = new PackagesApp.Common.PageContentLayout();

  PackagesApp.toolBarLayout = new PackagesApp.Common.ToolbarLayout();

  PackagesApp.fileuploadView = new PackagesApp.FileUpload.ButtonView({});

  PackagesApp.initLayouts = function () {

    var lastSearchParams = packageManagerSettings.get('searchParams');
    PackagesApp.searchFormView = new PackagesApp.Search.Form({ searchParams: lastSearchParams });

    PackagesApp.searchFormView.on("search:filter", function (model) {
      packageManagerSettings.set('searchParams', model);
      if (model.resetCurrentPage)
        PackagesApp.packagesListView.collection.paginatorModel.set('currentPage', 1);
      packageManagerSettings.save();
      PackageManager.trigger("packages:filter", model);
    });

    PackageManager.packagesPageContentRegion.show(PackagesApp.packagesPageContent);
    PackageManager.toolbarRegion.show(PackagesApp.toolBarLayout);

    PackagesApp.fileuploadView.on("fileupload:show:modal", function () {

      var model = new PackageManager.Entities.Package();

        var endpointparam = {
          action: 'ADD',
          courseID: Utils.getCourseID(),
          contentType: 'scorm-package'
        };

        var fileUploadModal = new PackagesApp.FileUpload.Modal({endpointParams: endpointparam });
        fileUploadModal.on("fileupload:done", function (result) {
                    var newPackages = new PackageManager.Entities.NewPackageCollection();
                    var i = 0;
                    if(_.isArray(result)){
                        for(i=0;i <  result.length; i++){
                            var pack = result[i];
                            var newPackage = new PackageManager.Entities.Package({
                                id: pack.id,
                                filename: pack.filename,
                                title: pack.filename.substr(0,pack.filename.lastIndexOf('.')),
                                packageType: pack.contentType
                            });
                            newPackages.add(newPackage);
                        }
                    }else {
                        newPackages.add(
                            new PackageManager.Entities.Package({
                                id: result.id,
                                filename: result.filename,
                                title: result.filename.substr(0,result.filename.lastIndexOf('.')),
                                packageType: result.contentType
                            }));
                    }

                    var newPackagesView = new PackagesApp.List.NewPackagesView({collection : newPackages});

                    var newPackagesModal = new PackagesApp.List.NewPackagesModal({view : newPackagesView });
                    PackageManager.request("package:show:editmodal", newPackagesModal);

        });

        PackageManager.request("package:show:modal", fileUploadModal);
      });

    PackageManager.fileuploadRegion.show(PackagesApp.fileuploadView);
    PackageManager.searchRegion.show(PackagesApp.searchFormView);

    var packages = PackageManager.request("package:entities", lastSearchParams);

    var packageListDisplayType = packageManagerSettings.get('layout');

    PackagesApp.packagesListView = new PackagesApp.List.Packages({
      collection: packages,
      displayType: packageListDisplayType
    });

    PackagesApp.packagesListView.on("itemview:package:change:visibility", function (childView, model) {
      var searchForm = PackageManager.request("package:get:search-param");

      model.set('visibility', !model.get('visibility'));
      model.set('scope', searchForm.scope);
      model.save({ scope: searchForm.scope}, {
        success: function () {
          PackageManager.request("package:list:reload");
        }
      });
    });

    PackagesApp.packagesListView.on("itemview:package:change:default", function (childView, model) {
      var searchForm = PackageManager.request("package:get:search-param");
      model.set('isDefault', !model.get('isDefault'));
      model.set('scope', searchForm.scope);
      model.save({ scope: searchForm.scope });
    });

    PackagesApp.packagesListView.on("itemview:package:delete", function (childView, model) {
      var searchForm = PackageManager.request("package:get:search-param");
      model.set('scope', searchForm.scope);
      if (PackagesApp.packagesListView.collection.length == 1) {
        PackagesApp.packagesListView.collection.paginatorModel.set('currentPage', 1);
      }
      model.destroy({success: function () {
        PackageManager.request("package:list:reload");
      }});
    });

    PackagesApp.packagesListView.on("view:displayType:change", function (displayType) {
      packageManagerSettings.set('layout', displayType);
      packageManagerSettings.save();

      PackageManager.request("package:list:reload");
    });

    PackagesApp.packagesListView.on("itemview:package:edit", function (childView, model) {
      var contextPath = Utils.getContextPath();
      model.set('contextPath', contextPath);
      var editModal = new PackagesApp.List.EditPackageModal({model: model});

      editModal.on("imageupload:show:modal", function () {

          PackageManager.request("package:upload:logo", model, true);

      });

      editModal.on("gallery:show:modal", function () {
        var galleryModal = new PackagesApp.Gallery.Modal({folderID: 'package_logo_' + model.get('id')});
        galleryModal.on("savedLogo:done", function (result) {
          model.set('logo', result.fileName);
          model.set('logoSrc', result.src);
        });

        PackageManager.request("package:show:modal", galleryModal);
      });

      PackageManager.request("package:show:editmodal", editModal);
    });

    var paginatorModel = PackagesApp.packagesListView.collection.paginatorModel;

    PackagesApp.pagingView = new PackagesApp.Common.Paginator({  model: paginatorModel, needDisplay: true, language: PackageManager.request("get:languageBank")});
    PackagesApp.bottomPagingView = new PackagesApp.Common.Paginator({  model: paginatorModel, language: PackageManager.request("get:languageBank")});

    PackagesApp.pagingView.on('pageChanged', function () {
      PackageManager.request("package:list:reload");
    });

    PackagesApp.bottomPagingView.on('pageChanged', function () {
      PackageManager.request("package:list:reload");
    });

    PackagesApp.toolBarLayout.paging.show(PackagesApp.pagingView);

    PackageManager.mainRegion.show(PackagesApp.packagesListView);

    PackageManager.bottomPaging.show(PackagesApp.bottomPagingView);
    API.filterListPackages();

  };

  PackagesApp.Router = Marionette.AppRouter.extend({
    appRoutes: {
      "packages": "index"//,
    }
  });

  var API = {
    index: function () {

    },

    filterListPackages: function (filterParam) {
      PackagesApp.packagesListView.collection.reset();
      PackagesApp.packagesListView.collection.fetch({filter: filterParam}).then(function() {
        var paginator = PackagesApp.packagesPageContent.$el.find('#bottomPaging');
        if(PackagesApp.packagesListView.collection.length > 0)
          paginator.show();
        else
          paginator.hide();
      });
    }
  };

  PackageManager.on("packages:filter", function (filterParam) {
    API.filterListPackages(filterParam);
  });

  PackageManager.on("packages:index", function () {
    API.index();
  });

  PackageManager.addInitializer(function () {
    new PackagesApp.Router({
      controller: API
    });
    PackagesApp.initLayouts();
  });

  PackageManager.on("packages:create:modal", function () {
    var modalLayout = new PackagesApp.Common.ModalsLayout();
    PackageManager.modalRegion.show(modalLayout);

    var editModalLayout = new PackagesApp.Common.ModalsLayout();
    PackageManager.editModalRegion.show(editModalLayout);
  });

  PackageManager.on("itemview:resize:to:mobile", function (displayType) {
    PackagesApp.packagesListView.setDisplayType(displayType);

    jQuery('#packageManagerListView').addClass('active');
    jQuery('#packageManagerTilesView').removeClass('active');
  });

  PackageManager.reqres.setHandler("package:show:modal", function (modal) {
    PackageManager.modalRegion.show(modal);
  });

  PackageManager.reqres.setHandler("package:show:editmodal", function (modal) {
    PackageManager.editModalRegion.show(modal);
  });


  PackagesApp.toolBarLayout.on("toolbar:displaytype:change", function (displayType) {
    PackagesApp.packagesListView.setDisplayType(displayType);
  });

  PackageManager.reqres.setHandler("package:save", function (model, callback) {

    var searchForm = Backbone.Syphon.serialize(PackagesApp.searchFormView);

    model.set('scope', searchForm.scope);
    model.save({ scope: searchForm.scope}, {
      success: function () {
        if(callback && _.isFunction(callback)) { callback();}
      }
    });

    if (!packageLogoData.supports()) {
      model.updateLogo();
    }
  });

  PackageManager.reqres.setHandler("packages:remove", function (collection) {
      collection.removePackages();
  });

  PackageManager.reqres.setHandler("package:get:search-param", function () {
    var searchForm = Backbone.Syphon.serialize(PackagesApp.searchFormView);
    return  searchForm;
  });

  PackageManager.reqres.setHandler("package:list:reload", function () {
    PackagesApp.searchFormView.applyFilter();
  });

  PackageManager.reqres.setHandler("get:languageBank", function () {
    return PackageManager.LanguageBankData;
    });

    PackageManager.reqres.setHandler("package:upload:logo", function(packageModel, postponeLoading, callback){

        var endpointparam = {
            action:'ADD',
            courseID:  Utils.getCourseID(),
            contentType: 'icon',
            folderId: 'package_logo_' + packageModel.get('id')
        };

        var fileUploadModal = new PackagesApp.FileUpload.Modal({endpointParams :endpointparam, postponeLoading: postponeLoading });
        fileUploadModal.on("fileupload:done", function(result){
            packageModel.set('logo', result.name);
            packageModel.set('logoSrc', result.src);
            if(_.isFunction(callback)) { callback(packageModel);}
        });

        PackageManager.request("package:show:modal", fileUploadModal);
  });

    PackageManager.reqres.setHandler("packages:update", function (collection) {

        var searchForm = PackageManager.request("package:get:search-param");
        var courseId = Utils.getCourseID();

        var options = {
            courseID: courseId,
            scope: searchForm.scope
        };

        collection.updatePackages({}, options).then(function (res) {
            PackageManager.request("package:list:reload");
        }, function (err, res) {

        });

    });

    PackageManager.reqres.setHandler("packages:remove", function (collection) {
        collection.removePackages();
    });

});