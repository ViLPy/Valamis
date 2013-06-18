/**
 * Quiz edit UI
 */
QuizEditView = Backbone.View.extend({
    currentContent: null, // current opened content view
    events: {
        "click #quizAddCategory": "createNewCategory",
        "click #quizAddQuestions": "showContentDialog",
        "click #quizAddLiferayResource": "showLiferayArticleDialog",
        "click #quizAddExternalResource": "showExternalContentDialog",
        "click #quizRemoveElement": "removeSelected",
        "click #elementEdit": "editElement",
        "click #elementUpdate": "updateElement",
        "click #elementCancelUpdate": "cancelUpdateElement",
        "click #elementPreview": "previewElement",
        "click #SCORMEditButtonWelcome": "editWelcomePage",
        "click #SCORMEditButtonFinal": "editFinalPage"
    },

    showLiferayArticleDialog: function () {
        window.JournalArticleDialog.choose(jQuery.proxy(function (groupID, articleID, language) {
            this.treeData.getLiferayArticleContent(groupID, articleID, language).done(jQuery.proxy(function (text) {
                    this.addLiferayArticle(groupID, articleID, language, text);
                }, this)).error(jQuery.proxy(function (err) {
                    jQuery('#projectLearnGeneric').unblock();
                    jQuery.growlWarning(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayFailedMessageLabel']);
                }, this));
        }, this));
    },

    addLiferayArticle: function (groupID, articleID, language, text) {
        this.treeData.createPlainTextResource(this.model.id, this.resolveCurrentParentID(), groupID, articleID, language, text).done(jQuery.proxy(function (param) {
                var id = this.treeData.addQuestion(_.extend(param, {"isNew": false}));
                this.treeView.selectNode(this.treeView.getNodeByID(id));
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayCompleteMessageLabel']);
            }, this)).error(jQuery.proxy(function (err) {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayFailedMessageLabel']);
            }, this));
    },

    showExternalContentDialog: function () {
        window.ExternalQuizDialog.choose(jQuery.proxy(function (url) {
            this.treeData.createExternalResource(this.model.id, url, this.resolveCurrentParentID()).done(jQuery.proxy(function (param) {
                    var id = this.treeData.addQuestion(_.extend(param, {"isNew": true}));
                    this.treeView.selectNode(this.treeView.getNodeByID(id));
                    jQuery('#projectLearnGeneric').unblock();
                    jQuery.growlUI(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayCompleteMessageLabel']);
                }, this)).error(jQuery.proxy(function () {
                    jQuery('#projectLearnGeneric').unblock();
                    jQuery.growlWarning(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayFailedMessageLabel']);
                }, this));
        }, this));
    },

    previewElement: function () {
        var currentID = this.treeView.getNodeID(this.treeView.getCurrentNode());
        var model = this.treeData.getEntity(currentID);

        if (model && model instanceof QuizQuestionModel) {
            var id = model.id;
            var contextPath = Utils.getContextPath();
            window.QuizPreview.show(contextPath + "resource/preview?id=" + id + "&context=" + contextPath);
        }
    },

    editWelcomePage: function () {
        window.RichEdit.show(this.options.language["welcomeContentDialogTitleLabel"], this.$("#SCORMQuizWelcomePage"), this.updateModel, this);
    },

    editFinalPage: function () {
        window.RichEdit.show(this.options.language["finalContentDialogTitleLabel"], this.$("#SCORMQuizFinalPage"), this.updateModel, this);
    },

    updateModel: function () {
        var that = this;
        jQuery('#projectLearnGeneric').block({ message: this.options.language["overlayProcessMessageLabel"] });
        this.model.set({
            welcomePageContent: encodeURIComponent(this.$("#SCORMQuizWelcomePage").html()),
            finalPageContent: encodeURIComponent(this.$("#SCORMQuizFinalPage").html())
        });
        this.model.save({}, {
            success: function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            },
            error: function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlaySaveQuizMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
    },

    editElement: function () {
        if (this.currentContent) {
            this.$('#quizAddCategory').hide();
            this.$('#quizAddQuestions').hide();
            this.$("#elementUpdate").show();
            this.$("#elementCancelUpdate").show();
            this.$("#elementEdit").hide();
            this.$("#elementPreview").hide();
            this.$("#quizAddExternalResource").hide();
            this.$("#quizAddLiferayResource").hide();
            this.currentContent.renderEdit();
        }
    },

    updateElement: function () {
        if (this.currentContent) {
            var model = this.currentContent.model;
            if (model instanceof QuizQuestionModel) {
                this.$('#quizAddCategory').hide();
                this.$("#elementPreview").show();
            } else {
                this.$("#elementPreview").hide();
                this.$('#quizAddCategory').show();
            }
            this.$("#quizAddExternalResource").show();
            this.$("#quizAddLiferayResource").show();
            this.$('#quizAddQuestions').show();
            this.$("#elementUpdate").hide();
            this.$("#elementCancelUpdate").hide();
            this.$("#elementEdit").show();
            this.currentContent.saveModel();
        }
    },

    cancelUpdateElement: function () {
        if (this.currentContent) {
            var model = this.currentContent.model;
            if (model instanceof QuizQuestionModel) {
                this.$('#quizAddCategory').hide();
                this.$("#elementPreview").show();
            } else {
                this.$("#elementPreview").hide();
                this.$('#quizAddCategory').show();
            }
            this.$("#quizAddExternalResource").show();
            this.$("#quizAddLiferayResource").show();
            this.$('#quizAddQuestions').show();
            this.$("#elementUpdate").hide();
            this.$("#elementCancelUpdate").hide();
            this.$("#elementEdit").show();
            this.currentContent.renderView();
        }
    },

    createNewCategory: function () {
        var that = this;
        jQuery('#projectLearnGeneric').block({ message: this.options.language["overlayProcessMessageLabel"] });
        var quizCategory = new QuizCategoryModel({
            quizID: this.model.id,
            parentID: this.resolveCurrentParentID(),
            isNew: true
        });
        quizCategory.save({}, {
            success: jQuery.proxy(function (param) {
                var id = this.treeData.addCategory(_.extend(param.toJSON(), {"isNew": true}));
                this.treeView.selectNode(this.treeView.getNodeByID(id));
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(that.options.language['overlayCreateQuizCategoryMessageLabel'], that.options.language['overlayCompleteMessageLabel']);
            }, this),
            error: function () {
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlWarning(that.options.language['overlayCreateQuizCategoryMessageLabel'], that.options.language['overlayFailedMessageLabel']);
            }
        });
    },

    resolveCurrentParentID: function () {
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

    showContentDialog: function () {
        window.QuizApp.questionChooseDialog.open(this.addContent, this);
    },

    removeSelected: function () {
        if (this.currentContent && confirm(this.options.language['warningDeleteNodeMessageLabel'])) {
            var id = this.treeView.getNodeID(this.treeView.getCurrentNode());
            this.treeData.drop(id);
        }
    },

    addContent: function (data) {
        var questionIDs = [];
        for (var key in data.questions) {
            var question = data.questions[key];
            questionIDs.push(question.id);
        }
        this.treeData.fetchQuestionIDList(this.model.id, questionIDs, this.resolveCurrentParentID())
    },

    initialize: function () {
        this.currentContent = null;
        this.render();
    },

    clearContent: function () {
        this.$("#quizContent_" + this.cid).empty();
        if (this.currentContent) this.currentContent.remove();
        this.currentContent = null;
        this.updateControls('default');
    },

    render: function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#quizPage").html(), _.extend(
            _.extend({cid: this.cid}, language),
            this.model.toJSON()));
        this.$el.html(template);
        // init tree
        this.initQuizCategoriesTree(jQuery("#quizTreeView_" + this.cid));
        this.renderStaticContentData();
        this.updateControls('default');
        return this;
    },

    renderStaticContentData: function () {
        var language = this.options.language;
        this.clearContent();
        var template = Mustache.to_html(jQuery("#quizCustomPagesView").html(), _.extend({
            welcomePage: decodeURIComponent(this.model.get('welcomePageContent')),
            finalPage: decodeURIComponent(this.model.get('finalPageContent'))
        }, language));
        this.$("#quizContent_" + this.cid).append(template);
    },

    renderViewContent: function (view) {
        this.$("#quizContent_" + this.cid).append(view.render().$el);
        this.currentContent = view;
        if (view.model.get("isNew")) {
            view.model.set("isNew", false);
            this.editElement();
        }
    },

    initQuizCategoriesTree: function (node) {
        var treeData = this.treeData = new QuizbankCollectionProxy();

        var treeInitParams = {
            "themes": {
                "url": Utils.getContextPath() + "/css/jstree/style.css",
                "dots": true,
                "icons": true
            },
            "types": {
                "valid_children": [ "root" ],
                "types": {
                    "entity": {
                        "icon": {
                            "image": Utils.getContextPath() + "/img/icons/book.png"
                        },
                        "valid_children": "none"
                    },
                    "root": {
                        "icon": {
                            "image": Utils.getContextPath() + "/img/icons/database.png"
                        },
                        "valid_children": [ "folder", "entity"]
                    },
                    "folder": {
                        "icon": {
                            "image": Utils.getContextPath() + "/img/icons/folder.png"
                        },
                        "valid_children": [ "folder", "entity"]
                    }
                }
            },
            "json_data": {
                "data": [
                    { // root
                        "data": this.options.language['treeRootLabel'],
                        "state": "open",
                        "attr": {
                            "id": "-1",
                            "rel": "root"
                        }
                    }
                ]
            },
            "crrm": {
                "move": {
                    "check_move": function (m) {
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
            "dnd": {
                "drop_target": false,
                "drag_target": false
            },
            "group": function (a, b) {
                var priorities = {
                    "default": 0,
                    "folder": 1,
                    "entity": 2
                };
                var aType = jQuery(a).attr('rel').toLowerCase();
                var bType = jQuery(b).attr('rel').toLowerCase();
                return priorities[aType] - priorities[bType];
            },
            "plugins": [ "themes", "ui", "json_data", "types", "dnd", "crrm", "group" ]
        };

        this.treeView = new jsTreeView({
            el: jQuery(node),
            collection: this.treeData,
            initParams: treeInitParams,
            sort: function (a, b) {
                var priorities = {
                    "default": 0,
                    "folder": 1,
                    "entity": 2
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
                targetId: treeData.getEntity(data.rslt.r.attr("id")).id,
                dndMode: data.rslt.p,
                itemType: data.rslt.r.attr("rel")
            });
        });

        treeView.addBind("create_node.jstree", jQuery.proxy(function () {
            _.delay(jQuery.proxy(this.updateQuizFromServer, this), 1000);
        }, this));

        treeView.addBind("delete_node.jstree", jQuery.proxy(function () {
            _.delay(jQuery.proxy(this.updateQuizFromServer, this), 1000);
        }, this));

        treeData.fetchForParent(this.model.id);

        return treeView;
    },

    updateQuizFromServer: function () {
        this.model.fetch();
    },

    updateControls: function (state) {
        switch (state) {
            case 'question':
                this.$('#quizAddCategory').hide();
                this.$('#quizAddQuestions').show();
                this.$('#quizRemoveElement').show();
                this.$("#elementEdit").hide();
                this.$("#elementUpdate").hide();
                this.$("#elementCancelUpdate").hide();
                this.$("#elementPreview").show();
                break;
            case 'questionExternal':
                this.$('#quizAddCategory').hide();
                this.$('#quizAddQuestions').show();
                this.$('#quizRemoveElement').show();
                this.$("#elementEdit").show();
                this.$("#elementUpdate").hide();
                this.$("#elementCancelUpdate").hide();
                this.$("#elementPreview").show();
                break;
            case 'category':
                this.$('#quizAddCategory').show();
                this.$('#quizAddQuestions').show();
                this.$('#quizRemoveElement').show();
                this.$("#elementEdit").show();
                this.$("#elementUpdate").hide();
                this.$("#elementCancelUpdate").hide();
                this.$("#elementPreview").hide();
                break;
            default:
                this.$("#elementUpdate").hide();
                this.$("#elementCancelUpdate").hide();
                this.$("#elementEdit").hide();
                this.$('#quizAddCategory').show();
                this.$('#quizAddQuestions').show();
                this.$('#quizRemoveElement').show();
                this.$("#elementPreview").hide();
                break;
        }
    },

    onSelectItem: function () {
        var id = this.treeView.getNodeID(this.treeView.getCurrentNode());
        if (id == -1) {
            this.clearContent();
            this.renderStaticContentData();
            return;
        }
        var model = this.treeView.collection.getEntity(id);
        var language = this.options.language;
        this.clearContent();

        if (model instanceof QuizCategoryModel) {
            this.updateControls('category');
            this.renderViewContent(new QuizCategoryView({
                model: model,
                language: language
            }));
        } else if (model instanceof QuizQuestionModel) {
            switch (model.get("questionType")) {
                case "QuestionBank":
                    this.updateControls('question');
                    break;
                case "External":
                    this.updateControls('questionExternal');
                    break;
                case "PlainText":
                    this.updateControls('question');
                    break;
            }
            this.renderViewContent(new QuizQuestionView({
                model: model,
                language: language}));
        }
    }
});