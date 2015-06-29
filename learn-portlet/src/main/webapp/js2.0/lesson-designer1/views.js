/**
 * Created by igorborisov on 12.03.15.
 */


lessonDesigner.module("Views", function (Views, lessonDesigner, Backbone, Marionette, $, _) {


    Views.ToolbarView = ValamisItemView.extend({
        template: '#lessonDesignerToolbarTemplate',
        events: {
            'click .dropdown-menu > li.js-sort': 'changeSort',
            'keyup .js-search': 'changeSearchText',
            'click .js-list-view': 'listDisplayMode',
            'click .js-tile-view': 'tilesDisplayMode'
        },
        triggers: {
            "click .js-lesson-new": "toolbar:lesson:new"
        },
        initialize: function(){
            this.language = lessonDesigner.language;
        },
        onRender: function(){
            this.$('.js-sort-filter').valamisDropDown('select', this.model.get('sort'));
            this.$('.js-search').val(this.model.get('searchtext'));
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

    Views.BaseLessonInfoView = ValamisItemView.extend({
        template: '#lesson-edit-info',
        initialize: function(){
            this.language = lessonDesigner.language;
            if(this.model.get('id')){
                quizLogoData.resetImageSettings('quiz_logo_' + this.model.get('id'));
            }else{
                quizLogoData.resetImageSettings('quiz_logo');
            }

        },
        events: {
            'click .js-upload-new-logo': 'uploadNewLogo',
            'click .logo': 'uploadNewLogo',
            'click .openMediaGallery':'openMediaGallery',
            'click .js-max-duration-checkbox': 'checkboxClicked'
        },
        modelEvents: {
            "change:logo": "onModelChanged",
            "change:logoSrc": "onModelLogoChanged"
        },
        uploadNewLogo: function(){
            this.triggerMethod('upload:image', this.model);
        },
        openMediaGallery: function(){
            this.triggerMethod('open:media:library', this.model);
        },
        setupUI: function(){
            this.$('.js-max-duration-picker').timepicker({
                defaultTime: false,
                showMeridian: false,
                minuteStep: 5
            });
        },
        checkboxClicked: function(){
            var checked = this.$('.js-max-duration-checkbox').is(':checked');
            var picker = this.$(".js-max-duration-picker");
            picker.prop('disabled', !checked);
        },
        getMaxDurationInMinutes: function(){
            var maxDurationInMinutes = null; // Unchecked
            if(this.$(".js-max-duration-checkbox").is(":checked")){
                var maxDuration = this.$(".js-max-duration-picker").val().split(':');

                var maxDurationHours = parseInt(maxDuration[0]);
                var maxDurationMinutes = parseInt(maxDuration[1]);

                maxDurationInMinutes = maxDurationHours * 60 + maxDurationMinutes;
            }
            return maxDurationInMinutes;
        },
        onModelChanged: function () {
            this.saveModelsTextValues();
            this.render();
        },
        onModelLogoChanged: function () {
            this.$('.js-logo').attr('src', this.model.get('logoSrc'));
        },
        saveModelsTextValues: function () {
            this.model.set({
                title: this.$('.js-title-field').val(),
                description: this.$('.js-description-field').val(),
                maxDuration: this.getMaxDurationInMinutes()
            });
        }
    });

    Views.LessonCreateView = Views.BaseLessonInfoView.extend({
        onRender: function(){
            this.setupUI();
        },
        submit: function(){
            this.saveModelsTextValues();
            this.triggerMethod('submit', this.model);
        }
    });

    Views.LessonEditInfoView = Views.BaseLessonInfoView.extend({
       onRender: function(){
           this.setupUI();
           var maxDuration = this.model.get('maxDuration');
           if(maxDuration != null) {
               var hours = Math.floor(maxDuration / 60);
               var minutes = maxDuration % 60;
               this.$('.js-max-duration-picker').timepicker('setTime', hours + ':' + minutes);
           }
       },
        submit: function(){
            this.saveModelsTextValues();
            this.triggerMethod('submit', this.model);
        }
    });

    //todo composite view
    Views.LessonEditContentView = ValamisItemView.extend({
        template: '#lesson-edit-content',
        initialize: function(){
            this.language = lessonDesigner.language;
            this.collection = new lessonDesigner.Entities.LessonContentCollection();
            this.collection.fetch({id: this.model.id});

            this.listenTo(this.collection, 'reset', this.render);
            this.listenTo(this.collection, 'change:selected', this.onSelectedChanged);
        },
        events: {
            'click .js-add-content': 'addContent'
        },
        addContent: function(e){
            var elem = $(e.currentTarget);

            var contentType = elem.data('value');
        }
    });

    Views.LessonItemView = ValamisItemView.extend({
        template: '#lessonDesignerItemView',
        className: 'tile s-12 m-4 l-2',
        events: {
            'click .dropdown-menu > li.js-lesson-edit-info': 'editInfo',
            'click .dropdown-menu > li.js-lesson-edit-content': 'editContent',
            'click .dropdown-menu > li.js-lesson-clone': 'clone',
            'click .dropdown-menu > li.js-lesson-delete': 'deleteLesson',
            'click .dropdown-menu > li.js-process-tincan': 'processTincan',
            'click .dropdown-menu > li.js-lesson-publish-scorm': 'publishScorm',
            'click .dropdown-menu > li.js-lesson-download-scorm': 'downloadScorm',
            'click .dropdown-menu > li.js-lesson-export': 'exportLesson',
            'click .dropdown-menu > li.js-lesson-convert': 'convertLesson'
        },
        //triggers: {
        //    'click .dropdown-menu > li.js-package-edit': 'package:edit'
        //},
        /* set the template used to display this view */
        modelEvents: {
            "change:size": "render",
            "change:title": "render",
            "change:description": "render",
            "change:logo": "render"
        },
        /* used to show the order in which these method are called */
        initialize: function(options){
            this.language = lessonDesigner.language;
        },
        onRender: function(){

        },
        onShow: function(){

        },

        editInfo: function(){
            this.triggerMethod('lesson:edit:info', this.model);
        },
        editContent: function(){
            this.triggerMethod('lesson:edit:content', this.model);
        },
        clone: function(){
            lessonDesigner.commands.execute("lesson:clone", this.model);
        },
        deleteLesson: function(){
            var confirmView = new DeleteConfirmationView({language: this.language});
            confirmView.on('deleteConfirmed', this.deleteLess, this);

            var title = this.language['deleteConfirmationTitle'];
            toastr.info(confirmView.render().$el, title,
                {
                    'positionClass': 'toast-center',
                    'timeOut': '0',
                    'showDuration': '0',
                    'hideDuration': '0',
                    'extendedTimeOut': '0'
                });
        },
        deleteLess: function () {
            lessonDesigner.commands.execute("lesson:remove", this.model);
        },
        processTincan: function(){
            lessonDesigner.commands.execute("lesson:processTincan", this.model);
        },
        publishScorm: function(){
            lessonDesigner.commands.execute("lesson:publish", this.model,'scorm');
        },
        downloadScorm: function(){
            lessonDesigner.commands.execute("lesson:download", this.model.get('id'), 'scorm');
        },
        exportLesson: function(){
            window.location = path.root + path.api.files + 'export/?action=EXPORT&contentType=lesson'
            + '&id=' + this.model.id;
        },
        convertLesson: function(){
            lessonDesigner.commands.execute("lesson:convert", this.model);
        }
    });

    // TODO create PagedCollectionView
    Views.Lessons = Marionette.CollectionView.extend({
        className: 'js-lesson-items val-row list',
        template: "#lessonDesignerLessonList",
        childView: Views.LessonItemView,
        initialize: function (options) {
            this.paginatorModel = options.paginatorModel;
        },
        onRender: function() {

        },
        onShow: function(){},
        childEvents: {
            //"package:edit":function(childView){
            //    this.triggerMethod('packagelist:edit:package', childView.model);
            //}
        }
    });

    Views.AppLayoutView = Marionette.LayoutView.extend({
        tagName: 'div',
        template: '#lessonDesignerLayoutTemplate',
        regions:{
            'toolbar' : '#lessonDesignerToolbar',
            'lessonList' : '#lessonDesignerLessons',
            'paginator': '#lessonDesignerPaginator',
            'paginatorShowing': '#lessonDesignerToolbarShowing',
            modals: {
                selector: '#lessonDesignerModalRegion',
                regionClass: Backbone.Marionette.Modals
            }
        },

        childEvents: {
            'toolbar:displaymode:change': function(childView, displayMode) {
                this.lessonList.currentView.$el.removeClass('list');
                this.lessonList.currentView.$el.removeClass('tiles');
                this.lessonList.currentView.$el.addClass(displayMode);

                lessonDesigner.commands.execute('recompute:size', this.lessonList.currentView.$el);
            },
            'toolbar:lesson:new': function(childView){
                var newLesson = new lessonDesigner.Entities.LessonModel();
                var editNewInfoView = new Views.LessonCreateView({
                    model: newLesson
                });
                var editInfoModalView =new ValamisModalView({
                    contentView: editNewInfoView,
                    header: lessonDesigner.language['editLessonInfoLabel']
                });

                editNewInfoView.on('submit', function(model){
                    lessonDesigner.commands.execute('lesson:create', model);
                });

                editNewInfoView.on('upload:image', function(model){
                    var postponeLoading = true;
                    lessonDesigner.commands.execute('edit:open:modal:upload:image', model, postponeLoading);
                });

                editNewInfoView.on('open:media:library', function(model){
                    lessonDesigner.commands.execute('open:modal:mediagallery', model);
                });


                lessonDesigner.commands.execute('modal:show', editInfoModalView);
            },
            'lesson:edit:info': function(childView, model){
                var editInfoView = new Views.LessonEditInfoView({model: model});
                var editInfoModalView = new ValamisModalView({
                    contentView: editInfoView,
                    header: lessonDesigner.language['editLessonInfoLabel']
                });

                lessonDesigner.commands.execute('modal:show', editInfoModalView);

                editInfoView.on('submit', function(model){
                    if(quizLogoData.isReadyToSubmit()){
                        quizLogoData.submitData( {
                            success: function(name){
                                model.set('logo', name);
                                model.updateLogo().then(function(){
                                    lessonDesigner.commands.execute('lesson:save', model);
                                });
                            },
                            error: function(){
                                lessonDesigner.commands.execute('lesson:save', model);
                            }
                        });
                    }else {
                        lessonDesigner.commands.execute('lesson:save', model);
                    }
                });

                editInfoView.on('upload:image', function(model){
                    var postponeLoading = true;
                    lessonDesigner.commands.execute('edit:open:modal:upload:image', model, postponeLoading);
                });

                editInfoView.on('open:media:library', function(model){
                    lessonDesigner.commands.execute('open:modal:mediagallery', model);
                });
            },
            'lesson:edit:content': function(childView, model){

                //var editContentView = new Views.LessonEditContentView({model: model});
                //var editContentModalView = new ValamisEmptyModalView({
                //    contentView: editContentView,
                //    header: 'HEADER'//lessonManager.language['editPackageItemHeader']
                //});

                var editContent = new LessonContentEditModal({model: model});
                lessonDesigner.commands.execute('modal:show', editContent);
            }
        },
        initialize: function() {
            var that = this;
            that.paginatorModel = lessonDesigner.paginatorModel;
            that.lessons = lessonDesigner.lessons;

            that.lessons.on('lessonCollection:updated', function (details) {
                that.updatePagination(details);
            });
        },
        onRender: function() {
            var toolbarView = new Views.ToolbarView({
                model: lessonDesigner.filter
            });

            var lessonListView = new Views.Lessons({
                collection: lessonDesigner.lessons,
                paginatorModel: this.paginatorModel
            });

            this.toolbar.show(toolbarView);

            lessonListView.on("render:collection", function(view){
                lessonDesigner.commands.execute('recompute:size', view.$el);
            });

            this.paginatorView = new ValamisPaginator({
                language: lessonDesigner.language,
                model : this.paginatorModel
            });

            var paginatorShowingView = new ValamisPaginatorShowing({
                language: lessonDesigner.language,
                model: this.paginatorModel
            });
            this.paginator.show(this.paginatorView);
            this.paginatorShowing.show(paginatorShowingView);

            this.paginatorView.on('pageChanged', function () {
                lessonDesigner.commands.execute('lessons:reload');
            }, this);


            this.lessonList.show(lessonListView);
            lessonDesigner.commands.execute('lessons:reload');
        },

        updatePagination: function (details, context) {
            this.paginatorView.updateItems(details.total);
        },

        /* called when the view displays in the UI */
        onShow: function() {}
    });

});