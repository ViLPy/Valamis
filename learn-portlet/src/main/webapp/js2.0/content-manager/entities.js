/**
 * Created by igorborisov on 21.04.15.
 */

contentManager.module("Entities", function (Entities, contentManager, Backbone, Marionette, $, _) {

    var CategoryService = new Backbone.Service({
        url: path.root,
        targets: {
            'move': {
                'path': path.api.category,
                'data': function (model, options) {
                    return {
                        action: 'move',
                        id: model.get('id'),
                        parentId: options.parentId,
                        index: options.index,
                        courseId: model.get('courseId')
                    };
                },
                'method': 'post'
            },
            'getChildren': {
                'path': path.api.category,
                'data': function (model) {
                    return {
                        parentId: model.get('id'),
                        courseId: model.get('courseId')
                    };
                },
                'method': 'get'
            },
            'getContentAmount': {
                'path': path.api.category,
                'method': 'get',
                'data': function (model, options) {
                    return {
                        'action': 'CONTENTAMOUNT',
                        'parentId': model.get('id'),
                        'courseId': model.get('courseId')
                    };
                }
            }

        },
        sync: {
            'read': {
                'path': path.api.category,
                'data': function (model) {
                    var params = {
                        parentId: model.get('id'),
                        courseId: model.get('courseId')
                    };
                    return params;
                },
                'method': 'get'
            },
            'create': {
                'path': path.api.category,
                'data': function (model) {
                    var params = {
                        action: 'add'
                    };
                    _.extend(params, model.toJSON());
                    return params;
                },
                'method': 'post'
            },
            'update': {
                'path': path.api.category,
                'data': function (model) {
                    var params = {
                        action: 'update'
                    };
                    _.extend(params, model.toJSON());
                    return params;
                },
                'method': 'post'
            },
            'delete': {
                'path': path.api.category,
                'data': function (model) {
                    var params = {
                        action: 'delete',
                        id: model.get('id'),
                        courseId: model.get('courseId')
                    };

                    return params;
                },
                'method': 'post'
            }
        }
    });

    var ContentItemsService = new Backbone.Service({
        url: path.root,
        sync: {
            'read': {
                'path': path.api.category,
                'data': function (collection, options) {
                    var params = {
                        action: 'ALLCHILDREN',
                        parentId: options.parentId,
                        courseId: options.courseId || Utils.getCourseId()
                    };
                    return params;
                },
                'method': 'get'
            }
        }
    });

    var QuestionType = {
        "ChoiceQuestion": 0,
        "ShortAnswerQuestion": 1,
        "NumericQuestion": 2,
        "PositioningQuestion": 3,
        "MatchingQuestion": 4,
        "EssayQuestion": 5,
        "EmbeddedAnswerQuestion": 6,
        "CategorizationQuestion": 7,
        "PlainText": 8,
        "PurePlainText": 9
    };

    var QuestionAnswerType = {
        "ChoiceQuestion": Entities.ChoiceAnswer,
        "ShortAnswerQuestion": Entities.ShortAnswer,
        "NumericQuestion": Entities.NumericAnswer,
        "PositioningQuestion": Entities.PositioningAnswer,
        "MatchingQuestion": Entities.MatchingAnswer,
        "CategorizationQuestion": Entities.CategorizationAnswer
    };

    var QuestionService = new Backbone.Service({
        url: path.root,
        targets: {
            'move': {
                'path': path.api.questions,
                'method': 'post',
                'data': function (model, options) {
                    return {
                        'action': 'move',
                        'id': model.get('id'),
                        'parentID': options.parentId,
                        'index': options.index,
                        'courseId': model.get('courseId')
                    };
                }
            }
        },
        sync: {
            'read': {
                'path': function (model) {
                    return path.api.questions + model.id;
                },
                'data': function (model) {
                    var params = {
                        'action': 'getById',
                        'courseId': model.get('courseId')
                    };

                    return params;
                },
                'method': 'get'
            },
            'create': {
                'path': path.api.questions,
                'data': function (model) {
                    var params = {
                        'action': 'add'
                    };

                    _.extend(params, model.toJSON());
                    return params;
                },
                'method': 'post'
            },
            'update': {
                'path': function (model) {
                    return path.api.questions + model.get('id');
                },
                'data': function (model) {
                    var params = {
                        'action': 'update'
                    };

                    _.extend(params, model.toJSON());
                    return params;
                },
                'method': 'post'
            },
            'delete': {
                'path': function (model) {
                    return path.api.questions + model.get('id');
                },
                'data': function (model) {
                    var params = {
                        'action': 'delete',
                        'courseId': model.get('courseId')
                    };

                    return params;
                },
                'method': 'post'
            }
        }
    });


    //Answers

    Entities.AnswerModel = Backbone.Model.extend({});
    Entities.AnswerModelCollection = Backbone.Collection.extend({
        model: Entities.AnswerModel
    });

    Entities.ChoiceAnswer = Entities.AnswerModel.extend({
        defaults: {
            answerText: '',
            isCorrect: false,
            score: null
        }
    });

    Entities.ShortAnswer = Entities.AnswerModel.extend({
        defaults: {
            answerText: '',
            score: null
        }
    });

    Entities.NumericAnswer = Entities.AnswerModel.extend({
        defaults: {
            rangeFrom: 0,
            rangeTo: 0,
            score: null
        }
    });

    Entities.PositioningAnswer = Entities.AnswerModel.extend({
        defaults: {
            answerText: '',
            isCorrect: false,
            score: null
        }
    });

    Entities.MatchingAnswer = Entities.AnswerModel.extend({
        defaults: {
            answerText: '',
            matchingText: '',
            score: null
        }
    });

    Entities.CategorizationAnswer = Entities.AnswerModel.extend({
        defaults: {
            answerText: '',
            matchingText: '',
            score: null
        }
    });


    Entities.Category = Backbone.Model.extend({
        defaults: {
            title: '',
            description: '',
            parentId: null,
            arrangementIndex: 0,
            contentType: 'category',
            selected: false,
            courseId: ''
        }
    }).extend(CategoryService);

    Entities.Question = Backbone.Model.extend({
        defaults: {
            title: '',
            text: '',
            explanationText: '',
            wrongAnswerText: '',
            rightAnswerText: '',
            questionType: QuestionType.ChoiceQuestion,
            categoryID: null,
            forceCorrectCount: false,
            isCaseSensitive: false,
            answers: '[]',
            type: '',
            contentType: 'question',
            selected: false,
            courseId: ''
        },
        initialize: function () {
            this.updateAnswerModel();
            this.on('change', this.updateAnswerModel, this);
            this.on('sync', this.updateAnswerModel, this);
            this.set('type', this.getStringType());
            this.on('change:questionType', function () {
                this.set('type', this.getStringType());
            }, this);
        },
        getStringType: function () {
            switch (parseInt(this.get('questionType'))) {
                case QuestionType.ChoiceQuestion:
                    return 'Choice question';
                    break;
                case QuestionType.ShortAnswerQuestion:
                    return 'Short answer question';
                    break;
                case QuestionType.NumericQuestion:
                    return 'Numeric question';
                    break;
                case QuestionType.PositioningQuestion:
                    return 'Positioning question';
                    break;
                case QuestionType.MatchingQuestion:
                    return 'Matching question';
                    break;
                case QuestionType.EssayQuestion:
                    return 'Essay question';
                    break;
                case QuestionType.EmbeddedAnswerQuestion:
                    return 'Embedded question';
                    break;
                case QuestionType.CategorizationQuestion:
                    return 'Categorization question';
                    break;
                case QuestionType.PlainText:
                    return 'Plain text';
                    break;
                case QuestionType.PurePlainText:
                    return 'Plain text';
                    break;
                default:
                    return '';
            }
        },
        updateAnswerModel: function () {
            switch (this.get('questionType')) {
                case QuestionType.ChoiceQuestion:
                    this.answerModel = QuestionAnswerType.ChoiceQuestion;
                    break;
                case QuestionType.ShortAnswerQuestion:
                    this.answerModel = QuestionAnswerType.ShortAnswerQuestion;
                    break;
                case QuestionType.NumericQuestion:
                    this.answerModel = QuestionAnswerType.NumericQuestion;
                    break;
                case QuestionType.PositioningQuestion:
                    this.answerModel = QuestionAnswerType.PositioningQuestion;
                    break;
                case QuestionType.MatchingQuestion:
                    this.answerModel = QuestionAnswerType.MatchingQuestion;
                    break;
                case QuestionType.CategorizationQuestion:
                    this.answerModel = QuestionAnswerType.CategorizationQuestion;
                    break;
                default:
                    this.answerModel = null;
            }
        },
        getParentId: function () {
            return this.get('categoryID');
        }//,
        //idAttribute: 'uniqueId'
    }).extend(QuestionService);


    Entities.TreeNode = {
        //defaults: {
        //    title: '',
        //    arrangementIndex: 0,
        //    nodes: [],
        //    parentId: ''
        //},
        idAttribute: 'uniqueId',
        getParentId: function () {
        },
        isNode: function () {
            return true;
        },
        isLeaf: function () {
            return true;
        },
        getDescendants: function () {
            var models = [];
            var children = this.nodes.models;

            models = models.concat(children);
            _(children).each(function (child) {
                if (child.isNode()) {
                    var descendants = child.getDescendants();
                    if (descendants.length) {
                        models = models.concat(descendants);
                    }
                }
            });

            return models;
        },
        getChild: function (filter) {
            return _.filter(this.getDescendants(), filter)[0] || {}
        },
        getChildNode: function (id) {
            return _.filter(this.getDescendants(), function (item) {
                    return item.get('id') == id && item.isNode();
                })[0] || {};
        },
        fetchChildren: function () {
        }
    };

    Entities.TreeNodes = Backbone.Collection.extend({
        model: Entities.TreeNode,
        comparator: function (a, b) {
            if (a.isNode() && b.isLeaf()) {
                return -1;
            } else if (a.isLeaf() && b.isNode()) {
                return 1;
            }

            var arrangementIndexA = a.get('arrangementIndex');
            var arrangementIndexB = b.get('arrangementIndex');

            return arrangementIndexA - arrangementIndexB;
        },
        idAttribute: 'uniqueId'
    });

    Entities.TreeContentItems = Entities.TreeNodes.extend({
        model: function (attrs, options) {
            switch (attrs.contentType) {
                case 'category' :
                    return new Entities.TreeCategory(attrs, options);
                case 'question' :
                    return new Entities.TreeQuestion(attrs, options);
            }
        },
        idAttribute: "uniqueId",
        hasChildNodes: function () {
            return this.some(function (item) {
                return item.isNode();
            });
        }
    }).extend(ContentItemsService);

    Entities.TreeQuestion = Entities.Question.extend(Entities.TreeNode).extend({
        isNode: function () {
            return false;
        },
        getParentId: function () {
            return this.get('categoryID');
        }
    });

    Entities.TreeCategory = Entities.Category.extend(Entities.TreeNode).extend({
        getParentId: function () {
            return this.get('parentId');
        },
        initialize: function (args) {
            var that = this;
            this.nodes = new Entities.TreeContentItems(args.children);
            this.nodes.on('add', function () {
                that.updateContentAmount();
            });
            this.nodes.on('remove', function () {
                that.updateContentAmount();
            });

            this.nodes.on('change:childrenAmount', function () {
                that.updateContentAmount();
            });
        },
        updateContentAmount: function () {
            var that = this;
            this.getContentAmount().then(function (data) {
                that.set('childrenAmount', data || 0);
            });
        },
        fetchChildren: function () {
            this.updateContentAmount();
            return this.nodes.fetch({parentId: this.get('id') || '', courseId: this.get('courseId'), reset: true});
        }
    });
});