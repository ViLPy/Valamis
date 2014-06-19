PackageManager.module("PackagesApp.List", function (List, PackageManager, Backbone, Marionette, $, _) {
  var DisplayType = {
    LIST: 1,
    TILES: 2
  };

  List.NewPackageModal = Backbone.Modal.extend({
    template: function () {
      var mustacheAccumulator = {};
      if (this.model) {
        _.extend(mustacheAccumulator, this.model.toJSON());
      }
      _.extend(mustacheAccumulator, PackageManager.request("get:languageBank"));

      return  Mustache.to_html($('#packageManagerUploadPackagePreView').html(), _.extend(mustacheAccumulator,
        {title: PackageManager.request("get:languageBank")['newPackageTitle'], description: PackageManager.request("get:languageBank")['newPackageDescription']}));
    },
    submitEl: '.bbm-button',
    cancelEl: '.modal-close',
    onRender: function () {
      this.$el.addClass('package-info');
    },
    events: {
      'click .js-upload-package': 'uploadPackage'
    },
    saveModelsTextValues: function () {
      var title = $.trim(this.$('#packageTitleEdit').val());
      var description = this.$('#packageEditDescription').val();
      this.model.set('title', title);
      this.model.set('description', description);
    },
    uploadPackage: function () {
      //if(this.isValid()) {
      this.saveModelsTextValues();
      this.trigger('packageupload:show:modal', this.model);
      //}
    },
    isValid: function () {
      var title = $.trim(this.$('#packageTitleEdit').val());
      if (title == '') {
        //this.$('#packageTitleEdit').addClass("error");
        return false;
      } else {
        return true
      }
    }
  });


  List.EditPackageModal = Backbone.Modal.extend({
    template: function () {
      var mustacheAccumulator = {};
      if (this.model) {
        _.extend(mustacheAccumulator, this.model.toJSON());
      }
      _.extend(mustacheAccumulator, PackageManager.request("get:languageBank"));

      return  Mustache.to_html($('#packageManagerEditItemView').html(), mustacheAccumulator);
    },
    submitEl: '.bbm-button',
    cancelEl: '.modal-close',
    className: 'edit-package-modal',
    onRender: function () {
      this.$el.addClass('package-info');
    },

    events: {
      'click .js-save-package': 'savePackage',
      'click .js-upload-image': 'uploadImage'
    },
    saveModelsTextValues: function () {
      var title = this.$('#packageTitleEdit').val();
      var description = this.$('#packageEditDescription').val();
      this.model.set('title', title);
      this.model.set('description', description);
    },
    savePackage: function () {
      this.saveModelsTextValues();
      this.close();
      PackageManager.request("package:save", this.model);
    },
    uploadImage: function () {
      this.trigger('imageupload:show:modal');
    },
    onModelChanged: function () {
      this.saveModelsTextValues();
      this.render();
    },
    initialize: function () {
      this.model.on("change:logo", this.onModelChanged, this);
    }

  });

  List.PackageTILES = ValamisItemView.extend({
    tagName: 'div',
    className: 'package-tile clearfix',
    template: '#packageManagerTileItemView',

    events: {
      "click": "highlightName",
      "click .js-package-visibility-flag": "visibilityChanged",
      "click .js-package-default-flag": "defaultChanged",
      "click .js-package-delete": "deletePackage",
      "click .js-package-edit": "editPackage"
    },

    visibilityChanged: function () {
      this.$('.js-package-visibility-flag').toggleClass('checked');
      this.trigger("package:change:visibility", this.model);
    },

    defaultChanged: function (event) {
      this.$('.js-package-default-flag').toggleClass('checked');
      //if ($(event.target).is(':checked')) {
      if (this.$('.js-package-default-flag').hasClass('checked')){
        $('.js-package-default-flag').removeClass('checked');
        this.$('.js-package-default-flag').addClass('checked');
        //$(event.target).prop('checked', true);
      }
      this.trigger("package:change:default", this.model);
    },
    deletePackage: function () {
      var self = this;
      var deletePack = function () {
        self.trigger("package:delete", self.model);
      };

      var confirmView = new DeleteConfirmationView({language: PackageManager.request("get:languageBank")});
      confirmView.on('deleteConfirmed', deletePack, this);

      var title = PackageManager.request("get:languageBank")['deleteConfirmationTitle'];
      toastr.info(confirmView.render().$el, title,
        {
          'positionClass': 'toast-center',
          'timeOut': '0',
          'showDuration': '0',
          'hideDuration': '0',
          'extendedTimeOut': '0'
        });
    },
    editPackage: function () {
      this.trigger("package:edit", this.model);
    }
  });

  List.PackageList = List.PackageTILES.extend({
    className: 'package-list-item clearfix',
    template: '#packageManagerListItemView'
  });

  List.Packages = Marionette.CompositeView.extend({
    tagName: "div",
    className: 'grid-view',
    template: "#package-manager-package-list",
    itemView: List.PackageTILES,
    itemViewContainer: ".js-package-items",

    initialize: function (options) {
      var viewportWidth = jQuery(window).width();
      if (viewportWidth <= 767) {
         this.setDisplayType(options.displayType || DisplayType.LIST);
      }
      else {
        this.setDisplayType(options.displayType || DisplayType.TILES);
      }

      jQuery(window).on('resize', this.resize);
    },
    itemViewsData: {
      1: {
        itemView: List.PackageList
      },
      2: {
        itemView: List.PackageTILES
      }
    },

    setDisplayType: function (displayType) {
      var itemsData = this.itemViewsData[displayType];
      this.itemView = itemsData.itemView;
      this.render();
      this.trigger("view:displayType:change", displayType);
    },

    resize: function () {
      var viewportWidth = jQuery(window).width();
      if (viewportWidth <= 767) {
        PackageManager.trigger("itemview:resize:to:mobile", DisplayType.LIST);

      }
    }
  });
});