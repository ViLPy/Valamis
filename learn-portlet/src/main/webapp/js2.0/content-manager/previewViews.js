/**
 * Created by igorborisov on 27.05.15.
 */

contentManager.module("Views", function (Views, ContentManager, Backbone, Marionette, $, _) {

//Previews
    //TODO resolve issues with content, question, categories to remove ifs
    Views.PreviewLayout = Marionette.LayoutView.extend({
        tagName: 'div',
        className: 'min-height400',
        template: '#contentManagerPreviewLayoutTemplate',
        regions:{
            'content': '#contentPreviewRegion'
        },
        events: {
            'click .js-edit': 'editContent',
            'click .js-clone': 'cloneContent',
            'click .js-delete': 'deleteContent'
        },
        initialize: function(options){
            this.parent = options.parent;
            this.model.set('categoryTitle', this.parent.get('title'));
        },
        onRender: function(){
            var that = this;
            var contentType = that.model.get('contentType');
            if(contentType == 'category'){
                that.content.show(new Views.CategoryPreview({model : that.model}));
            }

            if(contentType == 'question'){
                var questionType = that.model.get('questionType');
                var preview = new questionPreviewViews[questionType]({model : that.model});
                that.content.show(preview);
            }
        },
        editContent: function(){
            var contentType = this.model.get('contentType');

            if(contentType == 'category'){
                contentManager.execute('category:edit', this.model);
            }else if(contentType == 'question'){
                if(this.model.get('questionType') == '8') {
                    contentManager.execute('content:edit', this.model);
                }else{
                    contentManager.execute('question:edit', this.model);
                }

            }
        },
        cloneContent: function(){
            contentManager.execute('content:clone', this.model, this.parent);
        },
        deleteContent: function(){
            var contentType = this.model.get('contentType');
            if(contentType == 'category'){
                contentManager.execute('category:delete', this.model);
            }else if(contentType == 'question'){
                contentManager.execute('question:delete', this.model);
            }
            this.destroy();
        }
    });

    Views.BasePreviewView = Marionette.CompositeView.extend({
        childViewContainer: '.js-answers',
        modelEvents: {
            'change:title': 'render',
            'change:questionType': 'render'
        },
        initialize: function(options) {
            this.collection = new Backbone.Collection(this.model.get('answers'));
        }
    });

    Views.ChoiceQuestionPreviewAnswerItemView = Marionette.ItemView.extend({
        tagName: 'tr',
        template: '#choiceQuestionPreviewAnswerTemplate'
    });
    Views.ChoiceQuestionPreview = Views.BasePreviewView.extend({
        childView: Views.ChoiceQuestionPreviewAnswerItemView,
        template: '#choiceQuestionPreviewTemplate'
    });

    Views.ShortAnswerPreviewAnswerItemView = Marionette.ItemView.extend({
        tagName: 'tr',
        template: '#shortAnswerQuestionPreviewAnswerTemplate'
    });
    Views.ShortAnswerPreview = Views.BasePreviewView.extend({
        childView: Views.ShortAnswerPreviewAnswerItemView,
        template: '#shortAnswerQuestionPreviewTemplate'
    });

    Views.NumericQuestoinPreviewAnswerItemView = Marionette.ItemView.extend({
        tagName: 'tr',
        template: '#numericQuestionPreviewAnswerTemplate'
    });
    Views.NumericQuestoinPreview = Views.BasePreviewView.extend({
        childView: Views.NumericQuestoinPreviewAnswerItemView,
        template: '#numericQuestionPreviewTemplate'
    });

    Views.PositioningQuestoinPreviewAnswerItemView = Marionette.ItemView.extend({
        tagName: 'li',
        template: '#positioningQuestionPreviewAnswerTemplate'
    });
    Views.PositioningQuestoinPreview = Views.BasePreviewView.extend({
        childView: Views.PositioningQuestoinPreviewAnswerItemView,
        template: '#positioningQuestionPreviewTemplate',
        initialize: function(){
            Views.BasePreviewView.prototype.initialize.apply(this, arguments);
            var score = 0;
            if(!this.collection.isEmpty()) {
                score = this.collection.at(0).get('score');
            }
            this.model.set('score', score);
        }
    });

    Views.MatchingQuestoinPreviewAnswerItemView = Marionette.ItemView.extend({
        tagName: 'tr',
        template: '#matchingQuestionPreviewAnswerTemplate'
    });
    Views.MatchingQuestoinPreview = Views.BasePreviewView.extend({
        childView: Views.MatchingQuestoinPreviewAnswerItemView,
        template: '#matchingQuestionPreviewTemplate'
    });

    Views.EssayQuestoinPreview = Views.BasePreviewView.extend({
        template: '#essayQuestionPreviewTemplate'
    });

    Views.CategorizationQuestoinPreviewAnswerOptinonItemView = Marionette.ItemView.extend({
        tagName: 'tr',
        template: '#categorizationQuestionPreviewAnswerOptionTemplate'
    });
    Views.CategorizationQuestoinPreviewAnswerItemView = Marionette.CompositeView.extend({
        tagName: 'tr',
        template: '#categorizationQuestionPreviewAnswerTemplate',
        childView: Views.CategorizationQuestoinPreviewAnswerOptinonItemView,
        childViewContainer: '.js-answer-options',
        initialize: function(){
            this.collection = new Backbone.Collection(this.model.get('values'));
        }
    });
    Views.CategorizationQuestoinPreview = Views.BasePreviewView.extend({
        childView: Views.CategorizationQuestoinPreviewAnswerItemView,
        template: '#categorizationQuestionPreviewTemplate',
        initialize: function(){
            var answers = this.model.get('answers');
            var groupedAnswers = _.groupBy( answers, function(item) { return item.answerText ;});

            var mappedAnswers = _.map(groupedAnswers, function(item, key){
                return { optionKey: key, values: item }
            });

            this.collection = new Backbone.Collection(mappedAnswers);
        }
    });

    Views.PlaintTextQuestoinPreview = Views.BasePreviewView.extend({
        template: '#plainTextQuestionPreviewTemplate'
    });

    var questionPreviewViews = {
        '0' : Views.ChoiceQuestionPreview,
        '1' : Views.ShortAnswerPreview,
        '2' : Views.NumericQuestoinPreview,
        '3' : Views.PositioningQuestoinPreview,
        '4' : Views.MatchingQuestoinPreview,
        '5' : Views.EssayQuestoinPreview,
        '7' : Views.CategorizationQuestoinPreview,
        '8' : Views.PlaintTextQuestoinPreview
    };

    Views.CategoryPreview = Marionette.ItemView.extend({
        template: '#contentManagerCategoryDetailsTemplate',
        modelEvents: {
            'change:title': 'render'
        }
    });

});