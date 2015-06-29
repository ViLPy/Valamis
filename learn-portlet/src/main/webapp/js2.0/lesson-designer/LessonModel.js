LessonService = new Backbone.Service({
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
            path:path.api.quiz,
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
            'path': path.api.quiz,
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
            data: function(model){
                return {
                    action: 'UPDATELOGO',
                    id: model.id,
                    courseId: Utils.getCourseId()
                };
            },
            'method': 'post'
        }
    }
});

var LessonModel = Backbone.Model.extend({
    defaults: {
        title: 'New lesson',
        description: 'New description',
        logo: ''
    }
}).extend(LessonService);

var LessonCollection = Backbone.Collection.extend({
    model: LessonModel
});