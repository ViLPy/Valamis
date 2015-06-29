/**
 * Created by igorborisov on 12.03.15.
 */

lessonDesigner.module("Entities", function(Entities, lessonDesigner, Backbone, Marionette, $, _) {

    var apiUrl = path.api.quiz;

    var lessonService = new Backbone.Service({
        url: path.root,
        sync: {
            'create': {
                'path': apiUrl,
                'data': function(model){
                    return  {
                        action: 'ADD',
                        title: model.get('title') || 'New lesson',
                        description: model.get('description') || 'Lesson description',
                        logo: model.get('logo') || '',
                        maxDuration: model.get('maxDuration') || '',
                        courseId: Utils.getCourseId()
                    };
                },
                'method': 'post'
            },
            'update': {
                'path': apiUrl,
                'data': function(model){
                    return  {
                        action: 'UPDATE',
                        id: model.get('id'),
                        title: model.get('title') || 'New lesson',
                        description: model.get('description') || 'Lesson description',
                        maxDuration: model.get('maxDuration') || '',
                        courseId: Utils.getCourseId()
                    };
                },
                'method': 'post'
            },
            'delete': {
                'path': apiUrl,
                'data': function(model){
                    return {
                        action: 'DELETE',
                        id: model.get('id'),
                        courseId: Utils.getCourseId()
                    };
                },
                'method': 'post'
            }
        },
        targets: {
            'publish': {
                'path': apiUrl,
                'data': function (model) {
                    return {
                        action: 'PUBLISH',
                        id: model.get('id'),
                        courseId: Utils.getCourseId()
                    };
                },
                'method': 'post'
            },
            'convert': {
                'path': apiUrl,
                'data': function (model) {
                    return {
                        action: 'CONVERT',
                        id: model.get('id'),
                        courseId: Utils.getCourseId()
                    };
                },
                'method': 'post'
            },
            'clone': {
                'path': apiUrl,
                'data': function(model){
                    return {
                        action: 'CLONE',
                        id: model.get('id'),
                        courseId: Utils.getCourseId()
                    };
                },
                'method': 'post'
            },
            'updateLogo': {
                'path': apiUrl,
                 'data' : function (model) {
                     var params = {
                         action: 'UPDATELOGO',
                         id: model.get('id'),
                         logo: model.get('logo'),
                         courseId: Utils.getCourseId()
                     };
                    return params;
                },
                'method': 'post'
            }
        }
    });

    Entities.LessonModel = Backbone.Model.extend({
        defaults: {
            title: '',
            description: '',
            logo: ''
        }
    }).extend(lessonService);

    var lessonCollectionService = new Backbone.Service({
        url: path.root,
        sync: {
            'read': {
                'path': apiUrl,
                'data': function(collection, options){
                    //TODO complete parameters

                    var filter = options.filter || {
                                sort : 'nameAsc',
                                searchtext: ''
                            };

                        var sortBy = 'TITLE'; //TITLE, CREATIONDATE, DESCRIPTION
                        var sortAscDirection = true;

                        switch (filter.sort) {
                            case 'dateAsc':
                                sortBy = 'CREATIONDATE'; sortAscDirection = true;
                                break;
                            case 'dateDesc':
                                sortBy = 'CREATIONDATE'; sortAscDirection = false;
                                break;
                            case 'nameAsc':
                                sortBy = 'TITLE'; sortAscDirection = true;
                                break;
                            case 'nameDesc':
                                sortBy = 'TITLE'; sortAscDirection = false;
                                break;
                        }

                        var params = {
                            action: "GETALL",
                            courseId: Utils.getCourseId(),
                            filter: filter.searchtext || '',
                            sortAscDirection: sortAscDirection,
                            sortBy:sortBy,
                            page: options.currentPage,
                            count: options.itemsOnPage
                        };

                        return params;
                    },
                'method': 'get'
                }
            }
    });

    Entities.LessonCollection = Backbone.Collection.extend({
        model: Entities.LessonModel,
        parse: function(response){
            this.trigger('lessonCollection:updated', { total: response.total, currentPage: response.currentPage });
            _.forEach(response.records,function(record) {
                record.description = record.description;
            });
            return response.records;
        }
    }).extend(lessonCollectionService);

    Entities.Filter = Backbone.Model.extend({
        defaults: {
            searchtext: '',
            sort: 'nameAsc'
        },
        initialize: function(){}
    });



    var lessonContentModelService = new Backbone.Service({
        url: path.root,
        targets: {
            'move': {
                'path': path.api.quiz + '?action=MOVEELEMENT',
                'data': function (model, options) {
                    return {
                        'lessonId': model.get('lessonId'),
                        'id': model.id,
                        'categoryId': options.parentID,
                        'index': options.index
                    }
                },
                'method': 'post'
            }
        },
        sync: {
            'create': {
                'path': function (model, options) {
                    if (options.bankQuestionIds) {
                        return path.api.quiz + '?action=ADD' + model.get('contentType').toUpperCase() + "&" + options.bankQuestionIds +
                            '&courseId=' + Utils.getCourseId();
                    }
                    else return path.api.quiz + '?action=ADD' + model.get('contentType').toUpperCase() +
                        '&courseId=' + Utils.getCourseId();
                },
                'method': 'post'
            },
            'update': {
                'path': function (model) {
                    return path.api.quiz + '?action=UPDATE' + model.get('contentType').toUpperCase() +
                        '&courseId=' + Utils.getCourseId();
                },
                'method': 'post'
            },
            'delete': {
                'path': function (model) {
                    var type = 'CATEGORY';
                    if (model.get('contentType').indexOf('question') === 0) type = 'QUESTION';
                    return path.api.quiz + '?action=DELETE' + type +
                        '&courseId=' + Utils.getCourseId();
                },
                'data': function(model) {
                    return {lessonId: model.get('lessonId'), id: model.id};
                },
                'method': 'post'
            }
        }
    });

    var LessonContentModel = Backbone.Model.extend({
        /*   question
         ==============
         choiceQuestion,
         shortAnswerQuestion,
         numericQuestion,
         positioningQuestion,
         matchingQuestion,
         essayQuestion,
         categorizationQuestion
         plainText
         ==============

         welcomePage,
         finalPage,

         category,
         liferayArticle,
         picture,
         video,
         externalResource
         */
        defaults: {
            collapsed: true
        }
    }).extend(lessonContentModelService);

    //Questions
    //TODO Entities.LessonContent. ...
    Entities.QuestionModel = LessonContentModel.extend({
        defaults: {
            contentType: 'question',
            collapsed: true
        }
    });

    Entities.QuestionPlainTextModel = LessonContentModel.extend({
        defaults: {
            contentType: 'questionPlainText',
            collapsed: true
        }
    });

    Entities.CategoryModel = LessonContentModel.extend({
        defaults: {
            title: 'new category',
            description: '',
            contentType: 'category',
            collapsed: true,
            selected: false
        }
    });

    Entities.ExternalResourceModel = LessonContentModel.extend({
        defaults: {
            contentType: 'questionExternalResource',
            title: '',
            url: ''
        }
    });

    Entities.RevealJSModel = LessonContentModel.extend({
        defaults: {
            contentType: 'questionRevealJS',
            title: '',
            text: ''
        }
    });

    Entities.PDFModel = LessonContentModel.extend({
        defaults: {
            contentType: 'questionPDF',
            title: '',
            text: ''
        }
    });

    Entities.PPTXModel = LessonContentModel.extend({
        defaults: {
            contentType: 'questionPPTX',
            title: '',
            text: ''
        }
    });

    Entities.VideoModel = LessonContentModel.extend({
        defaults: {
            contentType: 'questionVideo',
            title: '',
            url: '',
            selected: false
        }
    });


    var lessonContentService = new Backbone.Service({
        url: path.root,
        sync: {
            'read': {
                'path': function (model, options) {
                    return path.api.quiz + '?action=GETCONTENT' +
                        '&id=' + options.id +
                        '&courseId=' + Utils.getCourseId();
                },
                'method': 'get'
            }
        }
    });


    Entities.LessonContentCollection =  Backbone.Collection.extend({
        model: function (attrs, options) {
            switch (attrs.contentType) {
                case 'category':
                    return new Entities.CategoryModel(attrs, options);
                case 'questionExternalResource':
                    return new Entities.ExternalResourceModel(attrs, options);
                case 'questionPlainText':
                    return new Entities.QuestionPlainTextModel(attrs, options);
                case 'questionRevealJS':
                    return new Entities.RevealJSModel(attrs, options);
                case 'questionPDF':
                    return new Entities.PDFModel(attrs, options);
                case 'questionPPTX':
                    return new Entities.PPTXModel(attrs, options);
                case 'question':
                    return new Entities.QuestionModel(attrs, options);
                case 'questionVideo':
                    return new Entities.VideoModel(attrs, options);
                case 'questionVideoDL':
                    return new Entities.VideoModel(attrs, options);
                default:
                    throw Error('unsupport question type: ' + attrs.contentType);
            }
        },
        comparator: 'arrangementIndex'
    }).extend(lessonContentService);





    var articleCollectionService = new Backbone.Service({
        url: path.root,
        sync: {
            'read': {
                'path': function () {
                    return '/services/liferay/article?companyID=' + GLOBAL_companyID;
                },
                'method': 'get'
            }
        }
    });

    var articleService = new Backbone.Service({
        url: function () {
            return contentManagerActionUrl;
        },
        targets: {
            'getContent': {
                'path': function (model) {
                    return '&companyID=' + GLOBAL_companyID
                        + '&articleID=' + model.get('articleID')
                        + '&language=' + model.get('localeId')
                        + '&groupID=' + model.get('groupID');
                },
                'method': 'get'
            }
        }
    });

    Entities.LiferayArticleModel = Backbone.Model.extend({
        parse: function (response) {
            var model = response;
            model.availableLocales = _.map(model.availableLocales, function (value, key) {
                value.id = key;
                return value;
            });
            model.localeId = model.availableLocales[0].id;
            model.title = model.titles[model.localeId];
            model.selected = false;
            return model;
        }
    }).extend(articleService);

    Entities.LiferayArticleCollection = Backbone.Collection.extend({
        model: Entities.LiferayArticleModel
    }).extend(articleCollectionService);
});
