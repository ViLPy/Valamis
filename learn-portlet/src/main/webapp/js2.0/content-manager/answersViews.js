/**
 * Created by igorborisov on 27.05.15.
 */
contentManager.module("Views", function (Views, ContentManager, Backbone, Marionette, $, _) {

//Answers views
    Views.BaseAnswerItemView = Marionette.ItemView.extend({
        tagName: 'tr',
        events: {
            'click .js-delete': 'removeAnswer'
        },
        initialize: function(){
            var position = this.model.collection.indexOf(this.model);
            this.model.set('position', position);
        },
        useEditor: false,
        onRender: function(){
            var that = this;
            if(this.useEditor) {
                setTimeout(function () {
                    that.activateEditor();
                }, 50);
            }
            this.$el.attr('id', this.model.cid);
        },
        getEditorId: function(){
            return 'answerText_' + this.model.get('position');
        },
        activateEditor: function () {
            var editorId = this.getEditorId();
            this.editor = CKEDITOR.replace(editorId, {
                toolbarLocation: 'bottom',
                height: 70,
                toolbar: [
                    { name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline' ] },
                    { name: 'colors', items: [ 'TextColor', 'BGColor' ] },
                    { name: 'insert', items: [ 'Image', 'Iframe' ] }
                ]
            });
        },
        removeAnswer: function(){
            this.model.destroy();
            //TODO how to destroy editor???
            // this.editor.destroy();
            this.destroy();
        }
    });

    Views.BaseAnswerCollectionView = Marionette.CompositeView.extend({
        childViewContainer: '.js-answers',
        events:{
            'click .js-addAnswerOption' : 'addOption'
        },
        sortable: false,
        onRender: function(){
            if(this.sortable) {
                this.makeSortable();
            }
        },
        updateModels: function(){
            this.children.each(function(view){
                view.updateModel();
            });
        },
        makeSortable: function(){
            var that = this;
            that.$('.js-answers').sortable({
                placeholder: 'ui-state-highlight',
                handle: '.handle',
                stop: function(){that.updateAnswerViewPositions();}
            });
        },
        updateAnswerViewPositions: function(){
            var that = this;
            that.updateModels();

            var sorted = that.$('.js-answers').sortable('toArray');
            this.collection.comparator = function(model){
                return sorted.indexOf(model.cid);
            };

            this.collection.sort();
        },
        //TODO validate answers
        validate: function(){
        }
    });

    Views.ChoiceAnswerItemView = Views.BaseAnswerItemView.extend({
        template: '#choiceAnswerEditView',
        useEditor: true,
        behaviors: {
            ValamisUIControls: {}
        },
        onValamisControlsInit: function(){
            this.$('.js-score').valamisPlusMinus('value', this.model.get('score'));
            this.$('.js-answerIsCorrect').attr('checked', this.model.get('isCorrect'));
        },
        updateModel: function () {
            this.model.set({
                answerText: this.editor.getData(),
                isCorrect: this.$('.js-answerIsCorrect').is(':checked'),
                score: this.$('.js-score').valamisPlusMinus('value') || 0
            });
            return this.model;
        }
    });

    Views.ChoiceAnswerCollectionView = Views.BaseAnswerCollectionView.extend({
        template: '#choiseAnswerCollectionView',
        childView: Views.ChoiceAnswerItemView,
        sortable: true,
        addOption: function(){
            this.collection.add(new ContentManager.Entities.ChoiceAnswer());
        }
    });

    Views.ShortAnswerItemView = Views.BaseAnswerItemView.extend({
        template: '#shortAnswerEditView',
        behaviors: {
            ValamisUIControls: {}
        },
        onValamisControlsInit: function(){
            this.$('.js-score').valamisPlusMinus('value', this.model.get('score'));
        },
        updateModel: function () {
            this.model.set({
                answerText: this.$('.js-text').val(),
                score: this.$('.js-score').valamisPlusMinus('value') || 0
            });
        }
    });

    Views.ShortAnswerCollectionView = Views.BaseAnswerCollectionView.extend({
        template: '#shortAnswerCollectionView',
        childView: Views.ShortAnswerItemView,
        sortable: true,
        addOption: function(){
            this.collection.add(new ContentManager.Entities.ShortAnswer());
        }
    });

    Views.NumericAnswerItemView = Views.BaseAnswerItemView.extend({
        template: '#numericAnswerEditView',
        behaviors: {
            ValamisUIControls: {}
        },
        onValamisControlsInit: function(){
            this.$('.js-score').valamisPlusMinus('value', this.model.get('score'));
        },
        updateModel: function () {
            this.model.set({
                answerText: this.$('.js-text').val(),
                score: this.$('.js-score').valamisPlusMinus('value') || 0,
                rangeFrom: parseFloat(this.$('.js-rangeFrom').val()) || 0,
                rangeTo: parseFloat(this.$('.js-rangeTo').val()) || 0
            });
        }
    });

    Views.NumericAnswerCollectionView = Views.BaseAnswerCollectionView.extend({
        template: '#numericAnswerCollectionView',
        childView: Views.NumericAnswerItemView,
        sortable: true,
        addOption: function(){
            this.collection.add(new ContentManager.Entities.NumericAnswer());
        }
    });

    Views.PositioningAnswerItemView = Views.BaseAnswerItemView.extend({
        template: '#positioningAnswerEditView',
        useEditor: true,
        updateModel: function () {
            this.model.set({
                answerText: this.editor.getData()
            });
        }
    });

    Views.PositioningAnswerCollectionView = Views.BaseAnswerCollectionView.extend({
        template: '#positionAnswerCollectionView',
        childView: Views.PositioningAnswerItemView,
        sortable: true,
        addOption: function(){
            this.collection.add(new ContentManager.Entities.PositioningAnswer());
        }
    });

    Views.MatchingAnswerItemView = Views.BaseAnswerItemView.extend({
        template: '#matchingAnswerEditView',
        useEditor: true,
        behaviors: {
            ValamisUIControls: {}
        },
        onValamisControlsInit: function(){
            this.$('.js-score').valamisPlusMinus('value', this.model.get('score'));
        },
        updateModel: function () {
            this.model.set({
                answerText: this.editor.getData(),
                score: this.$('.js-score').valamisPlusMinus('value') || 0,
                matchingText: this.$('.js-matchingText').val()
            });
        }
    });

    Views.MatchingAnswerCollectionView = Views.BaseAnswerCollectionView.extend({
        template: '#matchingAnswerCollectionView',
        childView: Views.MatchingAnswerItemView,
        addOption: function(){
            this.collection.add(new ContentManager.Entities.MatchingAnswer());
        }
    });

    Views.CategorizationAnswerOptionItemView = Views.BaseAnswerItemView.extend({
        template: '#categorizationAnswerOptionEdit',
        useEditor: true,
        initialize: function(){
            Views.BaseAnswerItemView.prototype.initialize.apply(this, arguments);
            this.model.set('editorId', 'answerOptionText_' + this.model.get('position') + this.model.cid);
        },
        behaviors: {
            ValamisUIControls: {}
        },
        getEditorId: function(){
            return this.model.get('editorId');
        },
        onValamisControlsInit: function(){
            this.$('.js-score').valamisPlusMinus('value', this.model.get('score') || 0);
        },
        updateModel: function () {
            this.model.set({
                matchingText: this.editor.getData(),
                score: this.$('.js-score').valamisPlusMinus('value') || 0
            });
        }
    });

    Views.CategorizationAnswerItemView = Marionette.CompositeView.extend({
        tagName: 'tr',
        template: '#categorizationAnswerEditView',
        childViewContainer: '.js-answer-options',
        childView: Views.CategorizationAnswerOptionItemView,
        useEditor: true,
        initialize: function(){
            var answerOptions = this.model.get('values');
            if(answerOptions && answerOptions[0].matchingText) {
                this.collection = new ContentManager.Entities.AnswerModelCollection(answerOptions);
            }else{
                this.collection = new ContentManager.Entities.AnswerModelCollection();
            }

            this.model.set('editorId', 'answerText_' + this.model.cid);
        },
        events: {
            'click .js-delete': 'removeAnswer',
            'click .js-add-answer-option' : 'addAnswerOption'
        },
        onRender: function(){
            var that = this;
            if(this.useEditor) {
                setTimeout(function () {
                    that.activateEditor();
                }, 50);
            }
        },
        activateEditor: function () {
            this.editor = CKEDITOR.replace(this.model.get('editorId'), {
                toolbarLocation: 'bottom',
                height: 70,
                toolbar: [
                    { name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline' ] },
                    { name: 'colors', items: [ 'TextColor', 'BGColor' ] },
                    { name: 'insert', items: [ 'Image', 'Iframe' ] }
                ]
            });
        },
        removeAnswer: function(){
            this.model.destroy();
            //TODO how to destroy editor???
            // this.editor.destroy();
            this.destroy();
        },
        addAnswerOption: function(){
            this.collection.add(new ContentManager.Entities.CategorizationAnswer());
        },
        updateModel: function () {
            this.children.each(function(view){
                view.updateModel();
            });
        },
        collectAnswers: function(){
            var answerText = this.editor.getData();
            this.collection.each(function(item){
                item.set('answerText', answerText);
            });
            return this.collection.toJSON();
        }
    });

    Views.CategorizationAnswerCollectionView = Views.BaseAnswerCollectionView.extend({
        template: '#categorizationCollectionView',
        childView: Views.CategorizationAnswerItemView,
        addOption: function(){
            this.collection.add(new ContentManager.Entities.CategorizationAnswer());
        },
        collectAnswers: function(){
            var answers = [];
            this.children.each(function(view){
                answers = answers.concat(view.collectAnswers());
            });
            return answers;
        }

    });

});