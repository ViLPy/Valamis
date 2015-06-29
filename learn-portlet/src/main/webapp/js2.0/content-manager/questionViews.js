/**
 * Created by igorborisov on 27.05.15.
 */

contentManager.module("Views", function (Views, ContentManager, Backbone, Marionette, $, _) {

//Editable Question views

    Views.EditQuestionLayout = Marionette.LayoutView.extend({
        tagName: 'div',
        template: '#contentManagerEditQuestionLayoutTemplate',
        regions:{
            'question': '#contentManagerQuestionRegion'
        },
        events: {
            'change .js-question-type': 'onQuestionTypeChanged',
            'click .js-saveQuestion': 'saveQuestion'
        },
        initialize: function(){

        },
        onRender: function(){
            var questionType = this.model.get('questionType');
            this.$('.js-question-type').val('type' + questionType);
            var questionView = new questionViews[questionType]({
                model: this.model
            });

            this.question.show(questionView);
        },
        onQuestionTypeChanged: function(){
            var questionType = this.$('.js-question-type').val().replace('type', '');


            this.model.set('questionType', questionType);

            var questionView = new questionViews[questionType]({
                model: this.model
            });

            this.question.show(questionView);
        },
        saveQuestion: function(){
            if(!this.question.currentView.validate()) return false;

            this.question.currentView.updateModel();
            this.triggerMethod('submit', this.model);
        }
    });

    Views.BaseEditQuestionView = Marionette.LayoutView.extend({
        haveOptions: false,
        className: 'div-table val-info-table small',
        regions:{
            'answersRegion': '#contentManagerQuestionAnswerOptionsRegion'
        },
        onRender: function(){

            this.$('.js-title').val(this.model.get('title'));
            this.$('.js-explanation').val(this.model.get('explanationText'));
            this.$('.js-text').val(this.model.get('text'));

            if(this.$('.js-right-answer')) this.$('.js-right-answer').val(this.model.get('rightAnswerText'));
            if(this.$('.js-wrong-answer')) this.$('.js-wrong-answer').val(this.model.get('wrongAnswerText'));

            var that = this;
            setTimeout(function(){
                that.activateEditor();
            }, 100);

            if(this.haveOptions) {
                this.renderAnserOptions();
            }

        },
        activateEditor: function () {
            CKEDITOR.replace('contentManagerQuestionTextView', {
                toolbarLocation: 'bottom',
                height: 100,
                toolbar: [
                    { name: 'document', items: [ 'Source' ] },
                    { name: 'paragraph', items: [ 'NumberedList', 'BulletedList', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
                    { name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline' ] },
                    { name: 'styles', items: [ 'Font', 'FontSize' ] },
                    { name: 'colors', items: [ 'TextColor', 'BGColor' ] },
                    { name: 'insert', items: [ 'Image'] }
                ]});
        },
        renderAnserOptions: function(){
            var answers = eval(this.model.get('answers'));
            this.optionCollections = new contentManager.Entities.AnswerModelCollection(answers);

            var answerCollectionView = new this.optionsView({
                collection : this.optionCollections
            });

            this.answersRegion.show(answerCollectionView);
        },
        collectAnswers: function(){
            this.answersRegion.currentView.updateModels();
            return JSON.stringify(this.optionCollections);
        },
        validate: function(){
            var title = this.$('.js-title').val();
            if(title.length === 0){
                toastr.warning(Valamis.language['overlayWarningMessageLabel']);
                return false;
            }

            if(this.haveOptions) {
                //TODO validation for answers?
                this.answersRegion.currentView.validate();
            }

            return true;
        },
        updateCommonFieldsModel: function(){
            var title = Utils.getDataFromPlaceholder(this.$('.js-title'));

            var text = CKEDITOR.instances.contentManagerQuestionTextView.getData();
            var explanation = this.$('.js-explanation').val();

            var rightAnswer = this.$('.js-right-answer').val();
            var wrongAnswer = this.$('.js-wrong-answer').val();

            if(!rightAnswer) rightAnswer = Valamis.language['questionRightAnswerDefault'];
            if(!wrongAnswer) wrongAnswer = Valamis.language['questionWrongAnswerDefault'];

            var answers = '[]';
            if(this.haveOptions) {
                answers = this.collectAnswers();
            }

            this.model.set({
                title: title,
                explanationText: explanation,
                rightAnswerText: rightAnswer,
                wrongAnswerText: wrongAnswer,
                text: text,
                answers: answers
            });
        }
    });

    Views.EditChoiceQuestionView =  Views.BaseEditQuestionView.extend({
        haveOptions: true,
        optionsView: Views.ChoiceAnswerCollectionView,
        template: '#contentManagerEditChoiceQuestion',
        onRender:function(){
            Views.BaseEditQuestionView.prototype.onRender.apply(this, arguments);
            this.$('.js-forceCorrectCount').attr('checked', this.model.get('forceCorrectCount'));
        },
        updateModel: function(){
            this.updateCommonFieldsModel();
            this.model.set('forceCorrectCount', this.$('.js-forceCorrectCount').is(':checked'));
        }
    });

    Views.EditShortAnswerQuestionView =  Views.BaseEditQuestionView.extend({
        haveOptions: true,
        optionsView: Views.ShortAnswerCollectionView,
        template: '#contentManagerEditShortAnswerQuestion',
        onRender:function(){
            Views.BaseEditQuestionView.prototype.onRender.apply(this, arguments);

            this.$('.js-caseSensitive').attr('checked', this.model.get('isCaseSensitive'));

        },
        updateModel: function(){
            this.updateCommonFieldsModel();
            this.model.set('isCaseSensitive', this.$('.js-caseSensitive').is(':checked'));

            //this.answersRegion.currentView.updateModels();
            //var answers = JSON.stringify(this.optionCollections);
            //this.model.set('answers', answers);
        }
    });

    Views.EditNumericQuestionView =  Views.BaseEditQuestionView.extend({
        haveOptions: true,
        optionsView: Views.NumericAnswerCollectionView,
        template: '#contentManagerEditNumericQuestion',
        onRender:function(){
            Views.BaseEditQuestionView.prototype.onRender.apply(this, arguments);
        },
        updateModel: function(){
            this.updateCommonFieldsModel();
        }
    });

    Views.EditPositioningQuestionView =  Views.BaseEditQuestionView.extend({
        haveOptions: true,
        optionsView: Views.PositioningAnswerCollectionView,
        template: '#contentManagerEditPositioningQuestion',
        behaviors: {
            ValamisUIControls: {}
        },
        onRender:function(){
            Views.BaseEditQuestionView.prototype.onRender.apply(this, arguments);

        },
        onValamisControlsInit: function(){
            var score = 0;
            if(!this.optionCollections.isEmpty()) {
                score = this.optionCollections.at(0).get('score');
            }

            this.$('.js-score').valamisPlusMinus('value', score);
        },
        updateModel: function(){
            this.updateCommonFieldsModel();
        },
        collectAnswers: function(){
            var score = this.$('.js-score').valamisPlusMinus('value');
            this.optionCollections.each(function(item){
                item.set('score', score);
            });

            this.answersRegion.currentView.updateModels();
            return JSON.stringify(this.optionCollections);
        }
    });

    Views.EditMatchingQuestionView =  Views.BaseEditQuestionView.extend({
        template: '#contentManagerEditMatchingQuestion',
        haveOptions: true,
        optionsView: Views.MatchingAnswerCollectionView,
        onRender:function(){
            Views.BaseEditQuestionView.prototype.onRender.apply(this, arguments);
        },
        updateModel: function(){
            this.updateCommonFieldsModel();
        }
    });

    Views.EditEssayQuestionView =  Views.BaseEditQuestionView.extend({
        template: '#contentManagerEditEssayQuestion',
        onRender:function(){
            Views.BaseEditQuestionView.prototype.onRender.apply(this, arguments);
        },
        updateModel: function(){
            this.updateCommonFieldsModel();
        }
    });

    Views.EditCategorizationQuestionView =  Views.BaseEditQuestionView.extend({
        template: '#contentManagerEditCategorizationQuestion',
        haveOptions: true,
        optionsView: Views.CategorizationAnswerCollectionView,
        onRender:function(){
            Views.BaseEditQuestionView.prototype.onRender.apply(this, arguments);
        },
        updateModel: function(){
            this.updateCommonFieldsModel();
        },
        collectAnswers: function(){
            this.answersRegion.currentView.updateModels();
            return JSON.stringify(this.answersRegion.currentView.collectAnswers());
        },
        renderAnserOptions: function(){
            var answers = eval(this.model.get('answers'));

            var groupedAnswers = _.groupBy( answers, function(item) { return item.answerText ;});

            var mappedAnswers  = _.map(groupedAnswers, function(item, key){
                return {optionKey: key, values: item }
            });

            this.optionCollections = new contentManager.Entities.AnswerModelCollection(mappedAnswers);

            var answerCollectionView = new this.optionsView({
                collection : this.optionCollections
            });

            this.answersRegion.show(answerCollectionView);
        }
    });


    Views.EditPlainTextQuestionView =  Views.BaseEditQuestionView.extend({
        template: '#contentManagerPlainTextQuestion',
        className: '',
        events: {
            'click .js-saveContent': 'saveContent'
        },
        onRender:function(){
            Views.BaseEditQuestionView.prototype.onRender.apply(this, arguments);
        },
        updateModel: function(){
            this.updateCommonFieldsModel();
        },
        saveContent: function(){
            if(!this.validate()) return false;

            this.updateModel();
            this.triggerMethod('submit', this.model);
        }
    });


    var questionViews = {
        '0' : Views.EditChoiceQuestionView,
        '1' : Views.EditShortAnswerQuestionView,
        '2' : Views.EditNumericQuestionView,
        '3' : Views.EditPositioningQuestionView,
        '4' : Views.EditMatchingQuestionView,
        '5' : Views.EditEssayQuestionView,
        '7' : Views.EditCategorizationQuestionView,
        '8' : Views.EditPlainTextQuestionView
    };

});