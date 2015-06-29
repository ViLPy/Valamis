var _Lesson = {};

_Lesson.service = new Backbone.Service({
    url: path.root,
    sync: {
        create: {
            'path': path.api.quiz,
            'data': function () {
                return {
                    action: 'ADD',
                    courseId: Utils.getCourseId()
                }
            },
            'method': 'post'
        },
        update: {
            path: path.api.quiz,
            'data': function () {
                return {
                    action: 'UPDATE',
                    courseId: Utils.getCourseId()
                }
            },
            'method': 'post'
        }
    },
    targets: {
        publish: {
            'path':  path.api.quiz,
            'data': function (model) {
                return {
                    action: 'PUBLISH',
                    id: model.id,
                    courseId: Utils.getCourseId()

                }
            },
            'method': 'post'
        },
        clone: {
            'path': path.api.quiz,
            'data': function (model) {
                return {
                    action: 'CLONE',
                    id: model.id,
                    courseId: Utils.getCourseId()
                }
            },
            'method': 'post'
        },
        deleteLesson: {
            'path': path.api.quiz,
            'data': function (model) {
                return {
                    action: 'DELETE',
                    id: model.id,
                    courseId: Utils.getCourseId()
                }
            },
            'method': 'post'
        },
        updateLogo: {
            'path': path.api.quiz,
            'data': function (model) {
                return {
                    action: 'UPDATELOGO',
                    id: model.id,
                    courseId: Utils.getCourseId()
                }
            },
            'method': 'post'
        }
    }
});

_Lesson.Model = Backbone.Model.extend(_Lesson.service);

_Lesson.Collection = Backbone.Collection.extend({
    model: _Lesson.Model
});

_Lesson.View = _LessonDefaultView.extend({
    tagName: 'li',
    className: 'tile s-12 m-4 l-2',
    templateSelector: '#lesson-item',
    events: {
        'click .js-download-tincan-lesson': function() { this._downloadLesson('tincan'); },
        'click .js-download-scorm-lesson': function () { this._downloadLesson('scorm'); },
        'click .js-edit-lesson-info': function () { _LessonDesigner.config.eventAggregator.trigger('modals:show:editLessonInfoView', this.model); },
        'click .js-edit-lesson-content': function () { _LessonDesigner.config.eventAggregator.trigger('modals:show:editLessonContentView', this.model); },
        'click .js-delete-lesson': 'confirmDeleteLesson',
        'click .js-process-tincan': function() { contentManagerEvent.trigger('modals:show:processTinCan', this.model); },
        'click .js-publish-scorm-lesson': function() { this._publishLesson('scorm') },
        'click .js-clone-lesson': function() { this.model.clone().then(function () { _LessonDesigner.config.eventAggregator.trigger('_LessonDesignerModel:fetchRequired'); }) },
        'click .js-export-lesson': function () { window.location = path.root + path.api.files + 'export/?action=EXPORT&contentType=lesson' + '&id=' + this.model.id; }
    },
    confirmDeleteLesson: function () {
        var confirmationDialog = new ToastrDeleteConfirmation({language: GLOBAL_translations, title: GLOBAL_translations['deleteConfirmationTitle']});
        this.listenTo(confirmationDialog, 'deleteConfirmed', this.deleteLesson);
        confirmationDialog.show();
    },
    deleteLesson: function () {
        this.model.deleteLesson().then(function () {
            toastr.success(GLOBAL_translations['overlayCompleteMessageLabel']);
            _LessonDesigner.config.eventAggregator.trigger('_LessonDesignerModel:fetchRequired');
        }, function () {
            toastr.error(GLOBAL_translations['overlayFailedMessageLabel']);
        });
    },
    _publishLesson: function (lessonType) {
        toastr.info(GLOBAL_translations['overlayProcessMessageLabel']);
        this.model.publish({publishType: lessonType}).then(function (response) {
            if (response.status) {
                toastr.success(GLOBAL_translations['overlayCompleteMessageLabel']);
            } else {
                toastr.error(GLOBAL_translations['overlayContentNeededMessageLabel']);
            }
        }, function () {
            toastr.error(GLOBAL_translations['overlayFailedMessageLabel']);
        });
    },
    _downloadLesson: function (lessonType) {
        window.location = path.root + path.api.files + 'export/?action=DOWNLOAD&contentType=lesson'
            + '&id=' + this.model.id
            + '&courseId=' + Utils.getCourseId()
            + '&publishType=' + lessonType;
    }
});

_Lesson.CollectionView = _DefaultView.extend({
    tagName: 'ul',
    className: 'val-row',
    initialize: function(){
        this.listenTo(this.collection, 'reset', this.render);
        this.listenTo(this.collection, 'change:displayMode', this.toggleDisplayModeClass);
        this.toggleDisplayModeClass();
    },
    toggleDisplayModeClass: function(){
        this.$el.toggleClass('tiles', this.collection.displayMode == 'tile');
        this.$el.toggleClass('list', this.collection.displayMode == 'list');
    },
    render: function(){
        this.$el.html('');
        this.collection.each(this.addOne, this);

        return this;
    },
    addOne: function(model){
        this.$el.append(new _Lesson.View({model: model}).render().$el)
    }
});