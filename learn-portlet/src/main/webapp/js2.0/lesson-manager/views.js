/**
 * Created by igorborisov on 03.03.15.
 */

lessonManager.module("Views", function (Views, lessonManager, Backbone, Marionette, $, _) {

    Views.EditPackageView = Marionette.ItemView.extend({
        template: '#packageManagerEditItemView',
        events: {
            'click .js-save-package': 'savePackage',
            'change .js-passing-limit-enable': 'togglePassingLimit',
            'change .js-rerun-interval-enable': 'toggleRerunInterval',
            'change .js-able-to-run-enable' : 'toggleIsAbleToRuns'
        },
        modelEvents: {
            "change:logo": "onModelChanged",
            "change:logoSrc": "onModelLogoChanged"
        },
        behaviors: {
            ValamisUIControls: {},
            ImageUpload: {
                'postponeLoading': true,
                'getFolderId': function(model){
                    return 'package_logo_' + model.get('id');
                },
                'uploadLogoMessage' : function() { return Valamis.language['uploadLogoMessage'];},
                'fileUploadModalHeader' : function() { return Valamis.language['fileUploadModalHeader']; }
            }
        },
        initialize: function () { },
        onValamisControlsInit: function () {
            var that = this;
            this.$('.js-is-able-from').datepicker({
                changeMonth: true,
                numberOfMonths: 1,
                onClose: function (selectedDate) {
                    that.$('.js-is-able-to').datepicker('option', 'minDate', selectedDate);
                    localStorage.setItem('listViewDateFrom', that.$('.js-is-able-from').datepicker('getDate').getTime());
                }
            });
            this.$('.js-is-able-to').datepicker({
                changeMonth: true,
                numberOfMonths: 1,
                onClose: function (selectedDate) {
                    that.$('.js-is-able-from').datepicker('option', 'maxDate', selectedDate);
                    localStorage.setItem('listViewDateTo', that.$('.js-is-able-to').datepicker('getDate').getTime());
                }
            });
            this.$('.js-is-able-to').datepicker('setDate', null);
            this.$('.js-is-able-from').datepicker('setDate', null);

            var hasAbleToRunTo = !_.isEmpty(this.model.get('beginDate'));
            var hasAbleToRunFrom = !_.isEmpty(this.model.get('endDate'));

            var storedFrom = localStorage.getItem('listViewDateFrom') || new Date().getTime();
            var storedTo = localStorage.getItem('listViewDateTo') || new Date().getTime();
            if (storedFrom) {
                this.$('.js-is-able-from').datepicker('setDate', new Date(parseInt(storedFrom)));
            }
            if (storedTo) {
                this.$('.js-is-able-to').datepicker('setDate', new Date(parseInt(storedTo)));
            }

            this.$('.js-able-to-run-enable').attr('checked', hasAbleToRunTo || hasAbleToRunFrom);
            this.updateAbletoRun(hasAbleToRunTo || hasAbleToRunFrom);

            var hasPassingLimit = (parseInt(this.model.get('passingLimit')) || 0) > 0;
            this.$('.js-passing-limit-enable').attr('checked', hasPassingLimit);
            if(hasPassingLimit) {
                this.$('.js-passing-limit').valamisPlusMinus('value', this.model.get('passingLimit'));
            }
            this.updatePassingLimit(hasPassingLimit);

            var rerunType = this.model.get('rerunIntervalType');
            var hasRerunType = (rerunType !== 'UNLIMITED');
            this.$('.js-rerun-interval-enable').attr('checked', hasRerunType);
            if(hasRerunType){
                this.$('.js-rerun-interval-type option[value=' + rerunType + ']').prop('selected', true);
                this.$('.js-rerun-interval').valamisPlusMinus('value', this.model.get('rerunInterval'));
            }
            this.updateRerunInterval(hasRerunType);

            var self = this;
            this.tags = new Valamis.TagCollection();
            this.tags.fetch({reset: true});

            this.tags.on('reset', function() {
                self.populateTagSelect();
            });

            if (!Valamis.permissions.LM_MODIFY) this.$('.js-plus-minus').valamisPlusMinus('disable');
        },
        updatePassingLimit: function(isEnabled){
            if(isEnabled){
                this.$('.js-passing-limit').valamisPlusMinus('enable');
            }else{
                this.$('.js-passing-limit').valamisPlusMinus('disable');
            }
        },
        updateRerunInterval: function(isEnabled){
            this.$('.js-rerun-interval-type').attr('disabled', !isEnabled);
            if(isEnabled){
                this.$('.js-rerun-interval').valamisPlusMinus('enable');
            }else{
                this.$('.js-rerun-interval').valamisPlusMinus('disable');
            }
        },
        updateAbletoRun: function(isEnabled){
            this.$('.js-is-able-from').datepicker("option", "disabled", !isEnabled);
            this.$('.js-is-able-to').datepicker("option", "disabled", !isEnabled);
        },
        togglePassingLimit: function () {
            var passLimitisEnabled = this.$('.js-passing-limit-enable').is(':checked');
            //TODO hide block?
            this.updatePassingLimit(passLimitisEnabled);
            if(passLimitisEnabled){
                if (this.model.get('passingLimit') <= 0 && this.$('.js-passing-limit').valamisPlusMinus('value') <= 0) {
                    this.$('.js-passing-limit').valamisPlusMinus('value', 1);
                }
            }
        },
        toggleRerunInterval: function () {
            var rerunIntervalEnabled = this.$('.js-rerun-interval-enable').is(':checked');
            //TODO hide rerun block?
            this.updateRerunInterval(rerunIntervalEnabled);
            if (rerunIntervalEnabled) {
                if (this.model.get('rerunInterval') <= 0 && this.$('.js-rerun-interval').valamisPlusMinus('value') <= 0) {
                    this.$('.js-rerun-interval').valamisPlusMinus('value', 1);
                }
            }
        },
        toggleIsAbleToRuns: function(){
            var ableToRunEnabled = this.$('.js-able-to-run-enable').is(':checked');
            this.updateAbletoRun(ableToRunEnabled);

        },
        saveModelsTextValues: function () {
            var title = this.$('.js-package-title').val();
            var description = this.$('.js-package-description').val();
            var passingLimit = -1;
            if(this.$('.js-passing-limit-enable').is(':checked')){
                passingLimit = this.$('.js-passing-limit').valamisPlusMinus('value') || -1;
            }

            var rerunInterval = -1;
            var rerunIntervalType = 'UNLIMITED';
            if (this.$('.js-rerun-interval-enable').is(":checked")) {
                rerunInterval = this.$('.js-rerun-interval').valamisPlusMinus('value') || -1;
                rerunIntervalType = this.$('.js-rerun-interval-type').val();
            }

            var ableToRunFrom = '';
            var ableToRunTo = '';
            if (this.$('.js-able-to-run-enable').is(":checked")) {
                ableToRunFrom = this.$ ('.js-is-able-from').datepicker('getDate');
                ableToRunTo = this.$('.js-is-able-to').datepicker('getDate');
            }

            var tagsElem = this.$el.find('.val-tags')[0].selectize;
            var tags = tagsElem.getValue().split(",");
            var taglist = [];
            if(tags) {
                _.forEach(tags, function (tagId) {
                    if(tagId) {
                        taglist.push(tagsElem.options[tagId].text);
                    }
                });
            }

            this.model.set({
                title: title,
                description: description,
                passingLimit: passingLimit,
                rerunInterval: rerunInterval,
                rerunIntervalType: rerunIntervalType,
                beginDate: $.datepicker.formatDate('yy-mm-dd', ableToRunFrom),
                endDate: $.datepicker.formatDate('yy-mm-dd', ableToRunTo),
                tags: tags,
                tagsList: taglist.join(' • ')
            });
        },
        savePackage: function () {
            this.saveModelsTextValues();
            this.triggerMethod('submit', this.model);
        },
        onModelChanged: function () {
            this.saveModelsTextValues();
            this.render();
        },
        onModelLogoChanged: function () {
            this.$('.js-logo').attr('src', this.model.get('logoSrc'));
        },
        populateTagSelect: function(tags) {
            var packageTags = this.model.get('tags');
            var selectTags = [], packageTagIDs = [];

            for(var i = 0; i < this.tags.models.length; i++) {
                selectTags.push({id: this.tags.models[i].get('id'), text: this.tags.models[i].get('text')});
            }
            for(var tagID in packageTags){
                packageTagIDs.push(packageTags[tagID].id);
            }

            var selectize = this.$('#input-tags').selectize({
                delimiter: ',',
                persist: false,
                valueField: 'id',
                options: selectTags,
                create: true
            });
            selectize[0].selectize.setValue(packageTagIDs);
        }
    });

    Views.ToolbarView = Marionette.ItemView.extend({
        template: '#packageManagerToolbarTemplate',
        events: {
            'click .dropdown-menu > li.js-display': 'changePackageType',
            'click .dropdown-menu > li.js-scope': 'changeScope',
            'click .dropdown-menu > li.js-category': 'changeCategory',
            'click .dropdown-menu > li.js-sort': 'changeSort',
            'keyup .js-search': 'changeSearchText',
            'click .js-list-view': 'listDisplayMode',
            'click .js-tile-view': 'tilesDisplayMode'
        },
        triggers: {
            "click .js-package-upload": "toolbar:upload:package"
        },
        behaviors: {
            ValamisUIControls: {}
        },
        initialize: function(){
            this.model.on('change:categories', this.render);
        },
        onValamisControlsInit: function(){
            this.$('.js-scope-filter').valamisDropDown('select', this.model.get('scope'));
            this.$('.js-display-filter').valamisDropDown('select', this.model.get('packageType'));
            this.$('.js-category-filter').valamisDropDown('select', this.model.get('selectedCategories')[0]);
            this.$('.js-sort-filter').valamisDropDown('select', this.model.get('sort'));
            this.$('.js-search').val(this.model.get('searchtext'));
        },
        onShow: function(){},
        changePackageType: function(e){
            this.model.set('packageType', $(e.target).attr("data-value"));
        },
        changeScope: function(e){
            this.model.set('scope', $(e.target).attr("data-value"));
        },
        changeCategory: function(e){
            this.model.set('selectedCategories', [ $(e.target).attr("data-value") ]);
        },
        changeSort: function(e){
            this.model.set('sort', $(e.target).attr("data-value"));
        },
        changeSearchText:function(e){
            var that = this;
            clearTimeout(this.inputTimeout);
            this.inputTimeout = setTimeout(function(){
                that.model.set('searchtext', $(e.target).val());
            }, 800);
        },
        listDisplayMode: function(){
            this.changeDisplayMode('list');
            this.$('.js-list-view').addClass('active');
        },
        tilesDisplayMode: function(){
            this.changeDisplayMode('tiles');
            this.$('.js-tile-view').addClass('active');
        },
        changeDisplayMode: function(displayMode){
            this.triggerMethod('toolbar:displaymode:change', displayMode);
            this.$('.js-display-option').removeClass('active');
        }
    });

    Views.PackageItemView = Marionette.ItemView.extend({
        template: '#packageManagerItemView',
        className: 'tile s-12 m-4 l-2',
        events: {
            'click .dropdown-menu > li.js-package-edit': 'editPackage',
            'click .dropdown-menu > li.js-package-delete': 'deletePackage',
            'click .dropdown-menu > li.js-package-export': 'exportPackage',
            'change input.js-default': 'changeDefault',
            'change input.js-visible': 'changeVisibility'
        },
        behaviors: {
            ValamisUIControls: {}
        },
        //triggers: {
        //    'click .dropdown-menu > li.js-package-edit': 'package:edit'
        //},
        /* set the template used to display this view */
        modelEvents: {
          'package:saved': 'render'
        },
        /* used to show the order in which these method are called */
        initialize: function(options){
        },
        onRender: function(){

        },
        onShow: function(){

        },
        editPackage: function(){
            this.triggerMethod('package:edit');
        },
        deletePackage: function(){
            var that = this;
            valamisApp.execute('delete:confirm', { message: Valamis.language['deleteConfirmationTitle'] }, function(){
                that.deletePack();
            });
        },
        deletePack: function () {
            lessonManager.execute("package:remove", this.model);
        },

        exportPackage: function(){
            window.location = path.root + path.api.files + 'export/?action=EXPORT&contentType=package' +
            '&id=' + this.model.id +
            '&courseId=' + Utils.getCourseId();
        },
        changeDefault: function(e){
            var checked = $(e.target).is(':checked');
            this.model.set('isDefault', checked);
            lessonManager.execute("package:save", this.model);

            this.triggerMethod('package:default:changed', e.target.id, this.model.get('id'));
        },
        changeVisibility: function(e){
            var checked = $(e.target).is(':checked');

            this.model.set('visibility', checked);
            lessonManager.execute("package:save", this.model);
        }
    });

    // TODO create PagedCollectionView
    Views.Packages = Marionette.CollectionView.extend({
        className: 'js-package-items val-row list',
        template: "#packageManagerPackageList",
        childView: Views.PackageItemView,
        initialize: function (options) {
            this.paginatorModel = options.paginatorModel;
        },
        onRender: function() {

        },
        onShow: function(){},
        childEvents: {
            "package:default:changed": function(childView, id, modelId){
                this.$('input.js-default').not("[id='" + id + "']").removeAttr("checked");
                this.collection.each(function(item) {
                  if (item.get('id') != modelId)
                    item.set({isDefault: false, silent:true});
                })
            },
            "package:edit":function(childView){
                this.triggerMethod('packagelist:edit:package', childView.model);
            }
        }
    });

    Views.NewPackagesItemView = Marionette.ItemView.extend({
        template: '#packageManagerNewPackagesItemView',
        tagName: 'tr',
        events: {
            'keyup .js-new-package-title': 'updateTitle',
            'mouseover .js-package-cover-image': 'showUploadButton',
            'mouseout .js-package-cover-image': 'hideUploadButton'
        },
        modelEvents: {
            "change:logo": "onModelChanged",
            "change:logoSrc": "onModelLogoChanged"
        },
        behaviors: {
            ValamisUIControls: {},
            ImageUpload: {
                'postponeLoading': false,
                'getFolderId': function(model){
                    return 'package_logo_' + model.get('id');
                },
                'uploadLogoMessage' : function() { return Valamis.language['uploadLogoMessage'];},
                'fileUploadModalHeader' : function() { return Valamis.language['fileUploadModalHeader']; }
            }
        },
        initialize: function(){
        },
        changing: true,
        updateTitle: function () {
            var me = this;
            var title = me.$('.js-new-package-title').val();
            me.model.set('title', title);
        },
        showUploadButton: function () {
            this.$('.js-package-settings').show();
        },
        hideUploadButton: function () {
            this.$('.js-package-settings').hide();
        },
        onModelChanged: function () {
            this.render();
        },
        onModelLogoChanged: function () {
            this.$('.js-logo').attr('src', this.model.get('logoSrc'));
        }
    });

    Views.NewPackagesView = Marionette.CompositeView.extend({
        tagName: "div",
        template: "#packageManagerNewPackageList",
        childView: Views.NewPackagesItemView,
        childViewContainer: ".js-new-package-items",
        events: {
            'click .js-save-packages-data' : 'savePackages',
            'click .js-cancel-upload-data' : 'cancelUpload'
        },
        initialize: function (options) {
        },
        savePackages: function(){

            lessonManager.execute('packages:update', this.collection);
        },
        cancelUpload: function () {
            lessonManager.execute('packages:remove', this.collection);
        }
    });

    Views.AppLayoutView = Marionette.LayoutView.extend({
        tagName: 'div',
        template: '#lessonManagerLayoutTemplate',
        regions:{
            'toolbar' : '#lessonManagerToolbar',
            'packageList' : '#lessonManagerPackages',
            'paginator': '#lessonManagerPaginator',
            'paginatorShowing': '#lessonManagerToolbarShowing'
        },
        childEvents: {
            'toolbar:displaymode:change': function(childView,displayMode ) {
                this.packageList.currentView.$el.removeClass('list');
                this.packageList.currentView.$el.removeClass('tiles');
                this.packageList.currentView.$el.addClass(displayMode);

                valamisApp.execute('update:tile:sizes', this.packageList.currentView.$el);
            },
            'toolbar:upload:package': function (childView) {
                ////TODO scorm-package?
                var endpointparam = {
                    action: 'ADD',
                    courseId: Utils.getCourseId(),
                    contentType: 'scorm-package'
                };

                var fileUploaderUrl = path.root + path.api.files + "?" + $.param(endpointparam);
                var uploader = new FileUploader({ endpoint: fileUploaderUrl, message:  Valamis.language['uploadPackageMessage'] });
                var uploaderModalView = new valamisApp.Views.ModalView({
                    contentView: uploader,
                    header: Valamis.language['fileUploadModalHeader']
                });

                uploader.on("fileuploaddone", function (result) {
                    var newPackages =  new lessonManager.Entities.NewPackageCollection();
                    var i = 0;
                    if(_.isArray(result)){
                        for(i=0;i < result.length; i++){
                            var pack = result[i];
                            var newPackage = new lessonManager.Entities.Package({
                                id: pack.id,
                                filename: pack.filename,
                                title: pack.filename.substr(0,pack.filename.lastIndexOf('.')),
                                packageType: pack.contentType
                            });
                            newPackages.add(newPackage);
                        }
                    }else {
                        newPackages.add(
                            new lessonManager.Entities.Package({
                                id: result.id,
                                filename: result.filename,
                                title: result.filename.substr(0,result.filename.lastIndexOf('.')),
                                packageType: result.contentType
                            }));
                    }

                    var newPackagesView = new Views.NewPackagesView({collection : newPackages});

                    var newPackagesModalView = new valamisApp.Views.ModalView({
                        contentView: newPackagesView,
                        header: Valamis.language['uploadPackagesLabel'],
                        title: Valamis.language['newPackageTitle'],
                        description: Valamis.language['newPackageDescription']
                    });

                    valamisApp.execute('modal:close', uploaderModalView);
                    valamisApp.execute('modal:show', newPackagesModalView);
                });

                valamisApp.execute('modal:show', uploaderModalView);
            },
            'packagelist:edit:package': function(childView, model){
                var editView = new Views.EditPackageView({model: model});
                var editModalView = new valamisApp.Views.ModalView({
                    contentView: editView,
                    submitEl: '.js-save-package',
                    header: Valamis.language['editPackageItemHeader']
                });

                valamisApp.execute('modal:show', editModalView);


                editView.on('submit', function(model){
                    this.trigger('view:submit:image', function(name) {
                        if (name) {
                            model.set('logo', name);
                            model.updateLogo();
                        }
                        lessonManager.execute("package:save", model);
                    });
                });
            }
        },
        initialize: function() {
            var that = this;
            that.paginatorModel = lessonManager.paginatorModel;
            that.packages = lessonManager.packages;

            that.packages.on('packageCollection:updated', function (details) {
                that.updatePagination(details);
            });
        },
        onRender: function() {
            var toolbarView = new Views.ToolbarView({
                model: lessonManager.filter
            });

            var packageListView = new Views.Packages({
                collection: lessonManager.packages,
                paginatorModel: this.paginatorModel
            });

            this.toolbar.show(toolbarView);

            packageListView.on("render:collection", function(view){
                valamisApp.execute('update:tile:sizes', view.$el);
            });

            this.paginatorView = new ValamisPaginator({
                language: Valamis.language,
                model : this.paginatorModel
            });

            var paginatorShowingView = new ValamisPaginatorShowing({
                language: Valamis.language,
                model: this.paginatorModel
            });
            this.paginator.show(this.paginatorView);
            this.paginatorShowing.show(paginatorShowingView);

            this.paginatorView.on('pageChanged', function () {
                lessonManager.execute('packages:reload');
            }, this);

            this.packageList.show(packageListView);
            lessonManager.execute('packages:reload');
        },

        updatePagination: function (details, context) {
            this.paginatorView.updateItems(details.total);
        },

        /* called when the view displays in the UI */
        onShow: function() {}
    });

});