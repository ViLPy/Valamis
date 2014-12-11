PackageManager.module("PackagesApp.List", function (List, PackageManager, Backbone, Marionette, $, _) {
  var DisplayType = {
    LIST: 1,
    TILES: 2
  };

  List.NewPackagesModal = Backbone.Modal.extend({
    customView: null,
    template: function () {
      var mustacheAccumulator = {};
      if (this.model) {
        _.extend(mustacheAccumulator, this.model.toJSON());
      }
      _.extend(mustacheAccumulator, PackageManager.request("get:languageBank"));
      return  Mustache.to_html($('#packageManagerUploadPackagesPreView').html(), _.extend(mustacheAccumulator,
        {title: PackageManager.request("get:languageBank")['newPackageTitle'], description: PackageManager.request("get:languageBank")['newPackageDescription']}));
    },
    viewContainer: '.new-packages-container',
    submitEl: '.bbm-button',
    cancelEl: '.modal-close',

    events: {
      'click .js-save-packages-data': 'savePackages',
      'click .js-cancel-upload-data': 'cancelUpload'
    },

    onRender: function () {
      this.$el.addClass('package-info');
      this.$el.find(this.viewContainer).html(this.customView.render());
      this.$el.find(this.viewContainer).append(this.customView.$el);

    },
    initialize: function (options) {
      if (options) {
        this.customView = options.view || null;
      }
    },
    savePackages: function () {
      PackageManager.request("packages:update", this.customView.collection);
      this.close();
    },
    cancelUpload: function () {
      PackageManager.request("packages:remove", this.customView.collection);
      this.close();
    }
  });

  List.NewPackagesItemView = ValamisItemView.extend({
    tagName: 'tr',
    className: 'package-list-item clearfix',
    template: '#packageManagerNewPackagesItemView',

    events: {
      'click .js-upload-logo': 'uploadLogo',
      'keyup .js-new-package-title': 'updateTitle',
      'mouseover .package-cover-image': 'showUploadButton',
      'mouseout .package-cover-image': 'hideUploadButton'
    },
    uploadLogo: function () {
      var me = this;
      PackageManager.request(
        "package:upload:logo",
        me.model,
        false,
        function () {
          me.render();
        });
    },
    changing: true,
    updateTitle: function () {
      var me = this;
      var title = me.$('.js-new-package-title').val();
      me.model.set('title', title);
    },
    showUploadButton: function () {
      this.$('.package-settings').show();
    },
    hideUploadButton: function () {
      this.$('.package-settings').hide();
    }
  });

  List.NewPackagesView = Marionette.CompositeView.extend({
    tagName: "div",
    className: 'list-view',
    template: "#packageManagerNewPackageList",
    itemView: List.NewPackagesItemView,
    itemViewContainer: ".js-new-package-items",

    initialize: function (options) {
    },
    resize: function () {
      var viewportWidth = jQuery(window).width();
      if (viewportWidth <= 767) {
        PackageManager.trigger("itemview:resize:to:mobile", DisplayType.LIST);
      }
    }
  });

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
      if (this.model.get('passingLimit') <= 0) {
        this.$('.js-toggle-passing-limit').removeClass('checked');
        this.$('.passing-limit-block').hide();
      } else {
        this.$('.js-toggle-passing-limit').addClass('checked');
        this.$('.passing-limit-block').show();
      }
      var rerunType = this.model.get('rerunIntervalType');
      if (rerunType == 'UNLIMITED') {
        this.$('.js-toggle-rerun-interval').removeClass('checked');
        this.$('.rerun-interval-block').hide();
      }
      else {
        this.$('.js-toggle-rerun-interval').addClass('checked');
        this.$('.rerun-interval-block').show();
        this.$('#rerunIntervalType option[value=' + rerunType + ']').prop('selected', true);
      }

    },

    events: {
      'keypress #packagePassingLimitEdit': 'preventNonDigits',
      'click .js-save-package': 'savePackage',
      'click .js-upload-image': 'uploadImage',
      'click .js-openMediaGallery': 'openMediaGallery',
      'click .js-toggle-passing-limit': 'togglePassingLimit',
      'click .js-toggle-rerun-interval': 'toggleRerunInterval'
    },
    togglePassingLimit: function () {
      var flag = this.$('.js-toggle-passing-limit').toggleClass('checked').hasClass('checked');
      if (flag) {
        this.$('.passing-limit-block').show();
        if (this.model.get('passingLimit') <= 0) this.$('#packagePassingLimitEdit').val(1);
      } else {
        this.$('.passing-limit-block').hide();
      }
    },
    toggleRerunInterval: function () {
      var flag = this.$('.js-toggle-rerun-interval').toggleClass('checked').hasClass('checked');
      if (flag) {
        this.$('.rerun-interval-block').show();
        if (this.model.get('rerunInterval') <= 0) this.$('#rerunIntervalValue').val(1);
      } else {
        this.$('.rerun-interval-block').hide();
      }
    },
    preventNonDigits: function (e) {
        if (e.keyCode != 46 && e.keyCode != 8 && e.keyCode != 9) {
            if (String.fromCharCode(e.charCode).match(/[^0-9]/g)) {
                return false;
            }
            else
              this.saveModelsTextValues();
        }
    },
    saveModelsTextValues: function () {
      var title = this.$('#packageTitleEdit').val();
      var description = this.$('#packageEditDescription').val();
      var passingLimit = -1;
      if (this.$('.js-toggle-passing-limit').hasClass('checked'))
        passingLimit = ~~this.$('#packagePassingLimitEdit').val() || -1;

      var rerunInterval = -1;
      var rerunIntervalType = 'UNLIMITED';
      if (this.$('.js-toggle-rerun-interval').hasClass('checked')) {
        rerunInterval = ~~this.$('#rerunIntervalValue').val() || -1;
        rerunIntervalType = this.$('#rerunIntervalType').val();
      }
      this.model.set({
        title: title,
        description: description,
        passingLimit: passingLimit,
        rerunInterval: rerunInterval,
        rerunIntervalType: rerunIntervalType});

    },
    savePackage: function () {
      this.saveModelsTextValues();
      var me = this;
      packageLogoData.submitData(function (name) {
        me.model.set('logo', name);
        me.model.updateLogo();
      });
      this.close();
      PackageManager.request("package:save", this.model, function () {
        PackageManager.request("package:list:reload");
      });
    },
    uploadImage: function () {
      this.trigger('imageupload:show:modal');
    },
    onModelChanged: function () {
      this.saveModelsTextValues();
      this.render();
    },
    onModelLogoChanged: function () {
      this.$('.logo').attr('src', this.model.get('logoSrc'));
    },
    initialize: function () {
      packageLogoData.resetImageSettings('package_logo_' + this.model.id);
      this.model.on("change:logo", this.onModelChanged, this);
      this.model.on("change:logoSrc", this.onModelLogoChanged, this);
    },
    openMediaGallery: function () {
      this.trigger('gallery:show:modal');
    }

  });

  List.PackageTILES = ValamisItemView.extend({
    tagName: 'div',
    className: 'valamis-tile-item clearfix',
    template: '#packageManagerTileItemView',

    events: {
      "click": "highlightName",
      "click .js-package-visibility-flag": "visibilityChanged",
      "click .js-package-default-flag": "defaultChanged",
      "click .js-package-delete": "deletePackage",
      "click .js-package-edit": "editPackage",
      "click .js-package-export": "exportPackage",
      "mouseenter .flip-container": "hoverOn",
      "mouseleave .flip-container": "hoverOff"
    },

    visibilityChanged: function () {
      this.$('.js-package-visibility-flag').toggleClass('checked');
      this.trigger("package:change:visibility", this.model);
    },

    defaultChanged: function (event) {
      this.$('.js-package-default-flag').toggleClass('checked');
      //if ($(event.target).is(':checked')) {
      if (this.$('.js-package-default-flag').hasClass('checked')) {
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
    exportPackage: function () {
      var me = this;
      window.location = path.root + path.api.files + 'export/?action=EXPORT&contentType=package'
        + '&id=' + me.model.id;
    },
    editPackage: function () {
      this.trigger("package:edit", this.model);
    },
    hoverOn: function () {
      this.$el.find('.flip-container .back > div').removeClass('hidden');
    },
    hoverOff: function () {
      this.$el.find('.flip-container .back > div').addClass('hidden');
    }
  });

  List.PackageList = List.PackageTILES.extend({
    className: 'valamis-list-item clearfix',
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
        this.setDisplayType(DisplayType.LIST);
      }
      else {
        this.setDisplayType(DisplayType.TILES);
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
      valamisTileResize(PackageManager.PackagesApp.packagesListView.$el.parent());
    }
  });
});