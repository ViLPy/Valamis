QuizbankCollectionProxy = Backbone.Collection.extend({
    model:jsTreeModel,
    initialize:function () {
        var Categories = Backbone.Collection.extend({
            model:QuizCategoryModel
        });

        var Questions = Backbone.Collection.extend({
            model:QuizQuestionModel
        });

        this.categories = new Categories();
        this.questions = new Questions();
    },

    //Create
    addCategory:function (entity) {
        if (this.categories.get(entity.id)) return; // already fetched

        var category = new QuizCategoryModel(entity);
        var parentEntity = this.categories.get(entity.parentID);
        var parentID = (parentEntity) ? parentEntity.cid : -1; // can be only category or root

        var model = {
            title:entity.title,
            content:category,
            parentID:parentID,
            type:"folder",
            id:category.cid
        };

        this.categories.add(category);
        this.add(model);
        return category.cid;
    },

    addCategories:function (questions) {
        _.each(questions, this.addCategory, this);
    },

    addQuestion:function (entity) {
        if (this.questions.get(entity.id)) return; // already fetched

        var question = new QuizQuestionModel(entity);
        var parentEntity = this.categories.get(entity.categoryID);
        var parentID = (parentEntity) ? parentEntity.cid : -1; // can be only category or root

        var model = {
            title:question.get('title'),
            content:question,
            parentID:parentID,
            type:"entity",
            state:null,
            id:question.cid
        };

        this.questions.add(question);
        this.add(model);
        return question.cid;
    },

    addQuestions:function (questions) {
        _.each(questions, this.addQuestion, this);
    },

    // Read
    getEntity:function (id) {
        var treeModel = this.get(id);
        if (!treeModel) return null;

        if (treeModel.get('content') instanceof QuizCategoryModel) {
            return this.categories.getByCid(id);
        } else if (treeModel.get('content') instanceof QuizQuestionModel) {
            return this.questions.getByCid(id);
        }
        return null;
    },

    //+fetching
    getChildCategories:function (quizID, id) {
        return window.LearnAjax.get(Utils.getContextPath() + "services/quizcategory/children/" + quizID + "/" + id);
    },

    getChildQuestions:function (quizID, id) {
        return window.LearnAjax.get(Utils.getContextPath() + "services/quizquestion/children/" + quizID + "/" + id);
    },

    getChildQuestionsByList:function (quizID, ids, parent) {
        return window.LearnAjax.post(Utils.getContextPath() + "services/quizquestion/listIntoCategory/" + quizID + "/" + parent, {
            'questionIDs':ids
        });
    },

    createExternalResource:function (quizID, url, parent, title) {
        return window.LearnAjax.post(Utils.getContextPath() + "services/quizquestion/external/" + quizID + "/" + parent, {
            'url':url,
            'title':title || "External quiz resource"
        });
    },

    fetchForParent:function (quizID, id) {
        var parentID = -1;
        if (id && id != -1) {
            parentID = this.get(id).get('content').id;
        }

        jQuery.when(this.getChildCategories(quizID, parentID), this.getChildQuestions(quizID, parentID))
            .then(jQuery.proxy(function (categoriesArgs, questionsArgs) {
            // got AJAX args, data in args[0]
            var categories = categoriesArgs[0];
            var questions = questionsArgs[0];

            this.addCategories(categories);
            this.addQuestions(questions);
            this.trigger('loaded', id);
        }, this));
    },

    fetchQuestionIDList:function (quizID, list, parent) {
        var ids = list.join(';');
        jQuery.when(this.getChildQuestionsByList(quizID, ids, parent))
            .done(jQuery.proxy(function (questions) {
            this.addQuestions(questions);
            this.trigger('loaded', parent);
        }, this));
    },

    // Delete
    drop:function (id) {
        // remove real model from inner collection and destroy it
        var realModel = this.getEntity(id);
        if (realModel instanceof QuizCategoryModel) {
            this.categories.remove(realModel);
        } else if (realModel instanceof QuizQuestionModel) {
            this.questions.remove(realModel);
        }
        realModel.destroy();
        delete realModel;

        // and remove from collection
        var treeModel = this.get(id);
        this.remove(treeModel);
        delete treeModel;
    }
});