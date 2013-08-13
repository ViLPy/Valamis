QuestionBankCollectionProxy = Backbone.Collection.extend({
    model:jsTreeModel,
    initialize:function () {
        var Categories = Backbone.Collection.extend({
            model:CategoryModel
        });

        var Questions = Backbone.Collection.extend({
            model:QuestionModel
        });

        this.categories = new Categories();
        this.questions = new Questions();
    },

    //Create
    addCategory:function (entity) {
        if (this.categories.get(entity.id)) return; // already fetched

        var category = new CategoryModel(entity);
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
    },

    addCategories:function (questions) {
        _.each(questions, this.addCategory, this);
    },

    addQuestion:function (entity) {
        if (this.questions.get(entity.id)) return; // already fetched

        var question = new QuestionModel(entity);
        var parentEntity = this.categories.get(entity.categoryID);
        var parentID = (parentEntity) ? parentEntity.cid : -1; // can be only category or root

        var model = {
            title:entity.title,
            content:question,
            parentID:parentID,
            type:"entity",
            state:null,
            id:question.cid
        };

        this.questions.add(question);
        this.add(model);
    },

    addQuestions:function (questions) {
        _.each(questions, this.addQuestion, this);
    },

    // Read
    getEntity:function (id) {
        var treeModel = this.get(id);
        if (!treeModel) return null;

        if (treeModel.get('content') instanceof CategoryModel) {
            return this.categories.get(id);
        } else if (treeModel.get('content') instanceof QuestionModel) {
            return this.questions.get(id);
        }
        return null;
    },

    //+fetching
    getChildCategories:function (id) {
        return window.LearnAjax.get(Utils.getContextPath() + "services/category/children/" + id + "?courseID="+jQuery("#courseID").val());
    },

    getChildQuestions:function (id) {
        return window.LearnAjax.get(Utils.getContextPath() + "services/question/children/" + id + "?courseID="+jQuery("#courseID").val());
        return window.LearnAjax.get(Utils.getContextPath() + "services/question/children/" + id+"?courseID="+jQuery("#courseID").val());
    },

    fetchForParent:function (id) {
        var parentID = -1;
        if (id && id != -1) {
            parentID = this.get(id).get('content').id;
        }

        jQuery.when(this.getChildCategories(parentID), this.getChildQuestions(parentID))
            .done(jQuery.proxy(function (categoriesArgs, questionsArgs) {
            // got AJAX args, data in args[0]
            var categories = categoriesArgs[0];
            var questions = questionsArgs[0];

            this.addCategories(categories);
            this.addQuestions(questions);
            this.trigger('loaded', id);
            //$.growlUI('Fetching question bank questions', 'Complete!');
        }, this)).fail(function () {
                //$.growlWarning('Fetching question bank questions', 'Failed!');
            });
    },

    // Delete
    drop:function (id) {
        // remove real model from inner collection and destroy it
        var realModel = this.getEntity(id);
        if (realModel instanceof CategoryModel) {
            this.categories.remove(realModel);
        } else if (realModel instanceof QuestionModel) {
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