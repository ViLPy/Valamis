var questionElementModule = slidesApp.module('QuestionElementModule', {
    moduleClass: GenericEditorItemModule,
    define: function(QuestionElementModule, slidesApp, Backbone, Marionette, $, _){
        QuestionElementModule.startWithParent = false;

        QuestionElementModule.View = this.BaseView.extend({
            template: '#questionElementTemplate',
            className: 'rj-element rj-text no-select question-element',
            events: _.extend({}, this.BaseView.prototype.events, {
                'click .js-select-question': 'openQuestionBankModal',
                'click .js-item-notify-correct': 'toggleNotifyCorrectAnswer'
            }),
            onRender: function() {
                this.constructor.__super__.onRender.apply(this, arguments);
            },
            updateQuestion: function(questionId) {
                slidesApp.viewId = this.cid;
                slidesApp.actionType = 'itemContentChanged';
                slidesApp.oldValue = {contentType: 'questionId', content: this.model.get('content')};
                this.model.set('content', questionId);
                slidesApp.newValue = {contentType: 'questionId', content: this.model.get('content')};
                slidesApp.commands.execute('action:push');

                var self = this;
                var questionModel = new QuestionModel({});
                if(questionId) {
                    questionModel.set('id', questionId);
                    questionModel.on('sync', function () {
                        if (!slidesApp.questionCollection.get(questionId))
                            slidesApp.questionCollection.add(questionModel);
                        var questionTypeString = (_.invert(QuestionType))[questionModel.get('questionType')];
                        var rawAnswerCategories = [],
                            answerCategories = [];
                        if (questionTypeString === 'CategorizationQuestion') {
                            for (var i in questionModel.get('answers')) {
                                var answer = questionModel.get('answers')[i];
                                rawAnswerCategories[answer.answerText.replace(/\<(\/)*p\>/g, '')] = answer.answerText.replace(/\<(\/)*p\>/g, '');
                            }
                            for (var category in rawAnswerCategories) {
                                answerCategories.push({'categoryText': category});
                            }
                        }
                        questionModel.set('answers', _.shuffle(questionModel.get('answers')));
                        if (answerCategories.length != 0) {
                            var countRows = Math.ceil(questionModel.get('answers').length / answerCategories.length);
    
                            var rawsRandomAnswers = [];
                            for (var i = 0; i < countRows; i++) {
                                var randomAnswers = questionModel.get('answers').splice(0, answerCategories.length);
                                rawsRandomAnswers.push(randomAnswers);
                            }
    
                            questionModel.set('randomAnswers', rawsRandomAnswers);
                            questionModel.set('answers', rawsRandomAnswers);
                        }
                        var questionTemplate = Mustache.to_html(jQueryValamis('#' + questionTypeString + (questionTypeString === 'PlainText' ? 'Question' : '') + 'Template').html(), _.extend(
                            questionModel.toJSON(),
                            window.parent.slidesConfig.translations,
                            {
                                hasExplanation: questionModel.get('explanationText') !== '' ? true : false,
                                explanation: questionModel.get('explanationText'),
                                categories: answerCategories,
                                multipleChoice: (!questionModel.get('forceCorrectCount') || jQueryValamis.grep(questionModel.get('answers'), function(answer) { return answer.isCorrect === true }).length > 1)
                            }
                        ));
    
                        // For each type of questions create arrays containing HTML and JS separately
                        // Then apply HTML part as mustache template, join it with JS part and add to the resulting index.html
                        try {
                            questionTemplate = questionTemplate;
                        }
                        catch (ex) {
                            if(ex instanceof URIError)
                                questionTemplate = unescape(questionTemplate);
                        }
                        self.content.find('.content-icon-question').hide();
                        self.content.find('.content-icon-question').siblings().remove();
                        self.content.append(questionTemplate);
                        self.content.css('background-color', 'transparent');
                        self.model.set('width', 800);
                        slidesApp.activeElement.view = self;
                        self.wrapperUpdate();
                    });
                    questionModel.fetch({model: questionModel});
                }
                else {
                    this.content.find('.content-icon-question').show();
                    this.content.find('.content-icon-question').siblings().remove();
                    this.model.set('width', 800);
                    this.model.set('height', 100);
                    this.content.css({'background': '#1C1C1C'});
                }
            },
            openQuestionBankModal: function() {
                window.slidesConfig.eventAggregator.trigger("show-questionbank",this.model);
            },
            toggleNotifyCorrectAnswer: function() {
                slidesApp.viewId = this.cid;
                slidesApp.actionType = 'correctAnswerNotificationChanged';
                slidesApp.oldValue = this.model.get('notifyCorrectAnswer');
                this.model.set('notifyCorrectAnswer', !this.model.get('notifyCorrectAnswer'));
                this.controls.find('.js-item-notify-correct').toggleClass('active-button', this.model.get('notifyCorrectAnswer'));
                slidesApp.newValue = this.model.get('notifyCorrectAnswer');
                slidesApp.commands.execute('action:push');
            }
        });
    }
});

questionElementModule.on('start', function(){
    slidesApp.commands.execute('toolbar:item:add', {slideEntityType: 'question', title: 'Question'});
});