Quiz = Backbone.Model.extend({
    defaults:{
        title:"New quiz",
        description:"Quiz info",
        questionCount:0,
        welcomePageContent:"",
        finalPageContent:""
    },
    install:function (callback) {
        jQuery.when(this.storage.install(this)).done(callback)
    }
});

_.extend(Quiz.prototype, {
    storage:{
        create:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quiz/", model.toJSON());
        },

        update:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quiz/update/" + model.id, model.toJSON());
        },

        find:function (model) {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/quiz/" + model.id);
        },

        findAll:function () {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/quiz/");
        },

        destroy:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/quiz/delete/" + model.id);
        },

        install:function (model) {
            return window.LearnAjax.post(Utils.getContextPath() + "/services/generator/ZipInstall/" + model.id);
        }
    }
});

// Quiz collection
QuizCollection = Backbone.Collection.extend({
    model:Quiz,
    storage:{
        findAll:function () {
            return window.LearnAjax.get(Utils.getContextPath() + "/services/quiz/");
        }
    }
});

/**
 * View for displaying opened quizes. Contain tabs with quizes.
 */
OpenedQuizView = Backbone.View.extend({

    getUID:function (id) {
        return "#quizTab" + id;
    },

    initialize:function () {
        var that = this;
        var quizTabs = this.$el.tabs({
            add:jQuery.proxy(function (e, ui) {
                var id = ui.panel.id.replace("quizTab", "");
                // append close thingy
                jQuery(ui.tab).parents('li:first')
                    .append('<span class="ui-tabs-close ui-icon ui-icon-close" title="' + this.options.language['tabsCloseTabButtonLabel'] + '"></span>')
                    .find('span.ui-tabs-close')
                    .click((function (quizID) {
                    return function () {
                        that.collection.remove(quizID);
                    }
                })(id));

                var editView = new QuizEditView({
                    el:jQuery(this.getUID(id)),
                    model:this.collection.get(id),
                    language:this.options.language
                });

                // select just added tab
                quizTabs.tabs('select', '#' + ui.panel.id);
            }, this)
        });

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('remove', this.remove, this);
    },

    remove:function (element) {
        this.$el.tabs('remove', this.$el.children().index(jQuery(this.getUID(element.id))) - 1);
    },

    select:function (element) {
        this.$el.tabs('select', this.getUID(element.id));
    },

    addOne:function (quizModel) {
        quizModel.on('change', this.updateQuiz, this);
        this.$el.tabs('add', this.getUID(quizModel.id), quizModel.get('title'));
    },

    updateQuiz:function (model) {
        this.$("a[href='#quizTab" + model.id + "'] > span").html(model.get('title'));
    }
});

/**
 * Quiz edit UI
 */
QuizEditView = Backbone.View.extend({
    currentContent:null, // current opened content view
    events:{
        "click #quizAddCategory":"createNewCategory",
        "click #quizAddQuestions":"showContentDialog",
        "click #quizRemoveElement":"removeSelected",
        "click #elementEdit":"editElement",
        "click #elementUpdate":"updateElement",
        "click #SCORMEditButtonWelcome":"editWelcomePage",
        "click #SCORMEditButtonFinal":"editFinalPage"
    },

    editWelcomePage:function () {
        window.RichEdit.show(this.options.language["welcomeContentDialogTitleLabel"], this.$("#SCORMQuizWelcomePage"), this.updateModel, this);
    },

    editFinalPage:function () {
        window.RichEdit.show(this.options.language["finalContentDialogTitleLabel"], this.$("#SCORMQuizFinalPage"), this.updateModel, this);
    },

    updateModel:function () {
        var that = this;
        jQuery('#projectLearnGeneric').block({ message:this.options.language["overlayProcessMessageLabel"] });
        this.model.set({
            welcomePageContent:encodeURIComponent(this.$("#SCORMQuizWelcomePage").html()),
            finalPageContent:encodeURIComponent(this.$("#SCORMQuizFinalPage").html())
        });
        this.model.save({}, {
            success:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            },
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
    },

    editElement:function () {
        if (this.currentContent) {
            this.$('#quizAddCategory').hide();
            this.$('#quizAddQuestions').hide();
            this.$("#elementUpdate").show();
            this.$("#elementEdit").hide();
            this.currentContent.renderEdit();
        }
    },

    updateElement:function () {
        if (this.currentContent) {
            this.$('#quizAddCategory').show();
            this.$('#quizAddQuestions').show();
            this.$("#elementUpdate").hide();
            this.$("#elementEdit").show();
            this.currentContent.saveModel();
        }
    },

    createNewCategory:function () {
        var that = this;
        jQuery('#projectLearnGeneric').block({ message:this.options.language["overlayProcessMessageLabel"] });
        var quizCategory = new QuizCategoryModel({
            quizID:this.model.id,
            parentID:this.resolveCurrentParentID(),
            isNew: true
        });
        quizCategory.save({}, {
            success:jQuery.proxy(function (param) {
                var id = this.treeData.addCategory(_.extend(param.toJSON(), {"isNew":true}));
                this.treeView.selectNode(this.treeView.getNodeByID(id));
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayCreateQuizCategoryMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayCreateQuizCategoryMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
    },

    resolveCurrentParentID:function () {
        var currentID = this.treeView.getNodeID(this.treeView.getCurrentNode());
        var model = this.treeData.getEntity(currentID);

        var parentID = -1;
        if (model && model instanceof QuizCategoryModel) {
            parentID = model.id;
        } else if (model && model instanceof QuizQuestionModel) {
            parentID = model.get('categoryID');
        }
        return parentID;
    },

    showContentDialog:function () {
        window.QuizApp.questionChooseDialog.open(this.addContent, this);
    },

    removeSelected:function () {
        if (this.currentContent && confirm(this.options.language['warningDeleteNodeMessageLabel'])) {
            var id = this.treeView.getNodeID(this.treeView.getCurrentNode());
            this.treeData.drop(id);
        }
    },

    addContent:function (data) {
        var questionIDs = [];
        for (key in data.questions) {
            var question = data.questions[key];
            questionIDs.push(question.id);
        }
        this.treeData.fetchQuestionIDList(this.model.id, questionIDs, this.resolveCurrentParentID())
    },

    initialize:function () {
        this.currentContent = null;
        this.render();
    },

    clearContent:function () {
        this.$("#quizContent_" + this.cid).empty();
        if (this.currentContent) this.currentContent.remove();
        this.currentContent = null;
        this.updateControls('default');
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#quizPage").html(), _.extend(
            _.extend({cid:this.cid}, language),
            this.model.toJSON()));
        this.$el.html(template);
        // init tree
        this.initQuizCategoriesTree(jQuery("#quizTreeView_" + this.cid));
        this.renderStaticContentData();
        this.updateControls('default');
        return this;
    },

    renderStaticContentData:function () {
        var language = this.options.language;
        this.clearContent();
        var template = Mustache.to_html(jQuery("#quizCustomPagesView").html(), _.extend({
            welcomePage:decodeURIComponent(this.model.get('welcomePageContent')),
            finalPage:decodeURIComponent(this.model.get('finalPageContent'))
        }, language));
        this.$("#quizContent_" + this.cid).append(template);
    },

    renderViewContent:function (view) {
        this.clearContent();
        this.$("#quizContent_" + this.cid).append(view.render().$el);
        this.currentContent = view;
        if (view.model.get("isNew")) {
            view.model.set("isNew", false);
            this.editElement();
        }
    },

    initQuizCategoriesTree:function (node) {
        var treeData = this.treeData = new QuizbankCollectionProxy();

        var treeInitParams = {
            "themes":{
                "url":Utils.getContextPath() + "/css/jstree/style.css",
                "dots":true,
                "icons":true
            },
            "types":{
                "valid_children":[ "root" ],
                "types":{
                    "entity":{
                        "icon":{
                            "image":Utils.getContextPath() + "/img/icons/book.png"
                        },
                        "valid_children":"none"
                    },
                    "root":{
                        "icon":{
                            "image":Utils.getContextPath() + "/img/icons/database.png"
                        },
                        "valid_children":[ "folder", "entity"]
                    },
                    "folder":{
                        "icon":{
                            "image":Utils.getContextPath() + "/img/icons/folder.png"
                        },
                        "valid_children":[ "folder", "entity"]
                    }
                }
            },
            "json_data":{
                "data":[
                    { // root
                        "data":this.options.language['treeRootLabel'],
                        "state":"open",
                        "attr":{
                            "id":"-1",
                            "rel":"root"
                        }
                    }
                ]
            },
            "crrm":{
                "move":{
                    "check_move":function (m) {
                        // ohoho, try to refactor
                        var dndMode = m.p;
                        var fromRel = m.o.attr("rel");
                        var toRel = m.r.attr("rel");
                        var nextNode = m.r.next();
                        var prevNode = m.r.prev();
                        if (!this._get_parent(m.o)) return false;

                        if (dndMode == "last" && toRel == "folder" && fromRel == "entity")
                            return true;
                        if (dndMode == "inside" && toRel == "folder")
                            return true;
                        if ((dndMode == "before" || dndMode == "after") && fromRel == "entity" && toRel == "entity")
                            return true;
                        if (dndMode == "after" && fromRel == "entity" && toRel == "folder" && (nextNode.attr("rel") == "entity" || nextNode.length == 0))
                            return true;
                        if (dndMode == "last" && fromRel == "entity" && toRel == "folder")
                            return true;
                        if (fromRel == "folder" && toRel == "folder")
                            return true;
                        if (fromRel == "folder" && toRel == "entity" && prevNode.attr("rel") == "folder" && dndMode == "before")
                            return true;
                        return false;
                    }
                }
            },
            "dnd":{
                "drop_target":false,
                "drag_target":false
            },
            "group":function (a, b) {
                var priorities = {
                    "default":0,
                    "folder":1,
                    "entity":2
                };
                var aType = jQuery(a).attr('rel').toLowerCase();
                var bType = jQuery(b).attr('rel').toLowerCase();
                return priorities[aType] - priorities[bType];
            },
            "plugins":[ "themes", "ui", "json_data", "types", "dnd", "crrm", "group" ]
        };

        this.treeView = new jsTreeView({
            el:jQuery(node),
            collection:this.treeData,
            initParams:treeInitParams,
            sort:function (a, b) {
                var priorities = {
                    "default":0,
                    "folder":1,
                    "entity":2
                };
                var aType = a.get('type').toLowerCase();
                var bType = b.get('type').toLowerCase();
                return priorities[aType] - priorities[bType];
            }
        });

        var treeView = this.treeView;
        treeView.addBind("open_node.jstree", jQuery.proxy(function (e, data) {
            var element = data.rslt.obj;
            if (treeView.isNodeLoaded(element)) {
                element.children("a").addClass("jstree-loading");
                treeData.fetchForParent(this.model.id, element.attr("id").replace("folder", ""));
            }
            treeView.selectNode(element);
        }, this));

        treeView.addBind("select_node.jstree", jQuery.proxy(function () {
            this.onSelectItem();
        }, this));

        treeView.addBind("dblclick.jstree", function () {
            treeView.toggleNode(treeView.getCurrentNode());
        });

        treeView.addBind("move_node.jstree", function (e, data) {
            treeView.selectNode(treeView.getNodeByID(data.rslt.o.attr("id")));
            var id = treeView.getNodeID(treeView.getCurrentNode());
            if (id == -1) return;
            treeData.getEntity(id).move({
                targetId:treeData.getEntity(data.rslt.r.attr("id")).id,
                dndMode:data.rslt.p,
                itemType:data.rslt.r.attr("rel")
            });
        });

        treeView.addBind("create_node.jstree", jQuery.proxy(function () {
            this.updateQuizFromServer();
        }, this));

        treeView.addBind("delete_node.jstree", jQuery.proxy(function () {
            this.updateQuizFromServer();
        }, this));

        treeData.fetchForParent(this.model.id);

        return treeView;
    },

    updateQuizFromServer:function () {
        this.model.fetch();
    },

    updateControls:function (state) {
        switch (state) {
            case 'question':
                this.$('#quizAddCategory').hide();
                this.$('#quizAddQuestions').show();
                this.$('#quizRemoveElement').show();
                this.$("#elementEdit").hide();
                this.$("#elementUpdate").hide();
                break;
            case 'category':
                this.$('#quizAddCategory').show();
                this.$('#quizAddQuestions').show();
                this.$('#quizRemoveElement').show();
                this.$("#elementEdit").show();
                this.$("#elementUpdate").hide();
                break;
            default:
                this.$("#elementUpdate").hide();
                this.$("#elementEdit").hide();
                this.$('#quizAddCategory').show();
                this.$('#quizAddQuestions').show();
                this.$('#quizRemoveElement').show();
                break;
        }
    },

    onSelectItem:function () {
        var id = this.treeView.getNodeID(this.treeView.getCurrentNode());
        if (id == -1) {
            this.clearContent();
            this.renderStaticContentData();
            return;
        }
        var model = this.treeView.collection.getEntity(id);
        var language = this.options.language;

        if (model instanceof QuizCategoryModel) {
            this.updateControls('category');
            this.renderViewContent(new QuizCategoryView({
                model:model,
                language:language
            }));
        } else if (model instanceof QuizQuestionModel) {
            this.updateControls('question');
            this.renderViewContent(new QuizQuestionView({
                model:model,
                language:language}));
        }
    }
});

//---------------------------------------------------
/**
 * Quiz management UI. Contain list of available quizes and management controls.
 */
AvailableQuizListItemView = Backbone.View.extend({
    events:{
        "click #quizDelete":"removeQuiz",
        "click #buttonOpen":"openQuiz",
        "click #buttonDownload":"downloadQuiz",
        "click #buttonInstall":"installQuiz",
        "click #quizEdit":"editQuiz",
        "click #quizUpdate":"updateQuiz",
        "click #SCORMEditText":"editText"
    },

    initialize:function () {
        this.$el = jQuery('<li>');
        this.model.on('change', this.rerender, this);
    },

    openQuiz:function () {
        this.trigger('quiz-open', this.model.id);
    },

    downloadQuiz:function () {
        window.location.href = Utils.getContextPath() + "/services/generator/Zip/" + this.model.id;
    },

    installQuiz:function () {
        var that = this;
        this.model.install(function () {
            alert(that.options.language['infoPackagesHasBeenInstalled']);
        });
    },

    editQuiz:function () {
        this.renderEdit();
    },

    updateQuiz:function () {
        if (this.$("#quizTitle").val().length === 0) {
            this.$("#quizTitle").tipsy('show');
            return false;
        }
        var that = this;
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        this.model.set({
            title:this.$("#quizTitle").val(),
            description:encodeURIComponent(this.$("#quizDescription").html())
        });
        this.model.save({}, {
            success:jQuery.proxy(function (question) {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
        this.renderView();
        return true;
    },

    removeQuiz:function () {
        if (confirm(this.options.language['warningDeleteQuizMessageLabel'])) this.trigger('quiz-remove', this.model.id);
    },

    rerender:function () {
        switch (this.state) {
            case 'edit':
                this.renderEdit();
                break;
            case 'view':
                this.renderView();
                break;
        }
    },

    renderView:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#availableQuizListItemView").html(), _.extend(this.model.toJSON(), _.extend({
            description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.html(template);
        this.state = 'view';
    },

    renderEdit:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#availableQuizListItemEdit").html(), _.extend(this.model.toJSON(), _.extend({
            description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.html(template);
        this.state = 'edit';
        this.$("#quizTitle").tipsy({trigger:'focus', gravity:'w'});
    },

    render:function () {
        this.renderView();
        return this.$el;
    },

    editText:function () {
        window.RichEdit.show(this.options.language['quizDescriptionRichTextWindowTitleLabel'], this.$("#quizDescription"));
    }
});

AvailableQuizListView = Backbone.View.extend({
    events:{
        "click #SCORMButtonAddQuiz":"createQuiz",
        "click #sortList":"sortList",
        "keyup #quizSearch":"searchList"
    },

    initialize:function () {
        this.views = [];
        this.sortAZ = true;

        this.collection.bind('add', this.addOne, this);
        this.collection.bind('reset', this.addAll, this);
        this.collection.bind('remove', this.deleteQuiz, this);

        this.render();
    },

    createQuiz:function () {
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        var quiz = new Quiz();
        quiz.save({}, {
            success:jQuery.proxy(function (quiz, response) {
                quiz.set(response);
                this.collection.add(quiz);
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayCreateQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            }, this),
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayCreateQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
    },

    openQuiz:function (id) {
        this.trigger('quiz-open', this.collection.get(id));
    },

    deleteQuiz:function (model) {
        jQuery('#projectLearnGeneric').block({ message:this.options.language['overlayProcessMessageLabel'] });
        var that = this;
        var modelID = model.id;
        model.destroy({
            success:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayDeleteQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            },
            error:function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayDeleteQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
        this.views[modelID].remove();
        delete this.views[modelID];

        this.trigger('quiz-remove', modelID);
    },

    removeQuiz:function (id) {
        var model = this.collection.get(id);
        this.collection.remove(model);
    },

    addOne:function (element) {
        var view = new AvailableQuizListItemView({
            model:element,
            language:this.options.language
        });

        this.views[element.id] = view;

        var viewDOM = view.render();

        this.$("#quizList").prepend(viewDOM);
        view.on('quiz-open', this.openQuiz, this);
        view.on('quiz-remove', this.removeQuiz, this);

        element.on('change', function (element) {
            this.quizList.update(element.id, {"title":element.get('title'), "description":element.get('description')});
        }, this);

        this.quizList.add(element.id, viewDOM, {"title":element.get('title'), "description":element.get('description')}, true);
    },

    addAll:function () {
        this.collection.each(this.addOne, this);
    },

    searchList:function () {
        this.quizList.filter(this.$("#quizSearch").val() || "");
    },

    sortList:function () {
        if (this.quizList) {
            this.quizList.sort("title", this.sortAZ ? "asc" : "desc");

            var sortOrderString = (this.sortAZ) ? this.options.language['sortOrderAscLabel'] : this.options.language['sortOrderDescLabel'];
            this.$("#sortList").html(sortOrderString);
            this.sortAZ = !this.sortAZ;
        }
    },

    removeQuizView:function (quizView) {
        quizView.remove();
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#availableQuizListView").html(), _.extend({
            cid:this.cid
        }, language));
        this.$el.append(template);

        this.quizList = this.$("#quizList").List();

        return this;
    }
});
