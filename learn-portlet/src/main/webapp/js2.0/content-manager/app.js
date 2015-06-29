/**
 * Created by igorborisov on 10.04.15.
 */

//TODO add async languages loading
var ContentManager = Marionette.Application.extend({
    channelName: 'contentManager',
    rootNodes: [],
    initialize: function(options) {
        this.addRegions({
            mainRegion: '#contentManagerAppRegion'
        });
    },
    start: function(options){

        var layoutView = new contentManager.Views.AppLayoutView({showGlobalBase : options.showGlobalBase } );

        this.mainRegion.show(layoutView);
    }
});

var contentManager = new ContentManager();


//category methods
contentManager.commands.setHandler('category:edit', function(category){

    var editCategoryView = new contentManager.Views.EditCategoryView({
        model: category
    });

    var modalView = new valamisApp.Views.ModalView({
        header: Valamis.language['editCategoryLabel'],
        contentView: editCategoryView,
        customClassName: 'content-manager-new-category'
    });

    editCategoryView.on('submit', function(category){
        category.save();
    });

    valamisApp.execute('modal:show', modalView);

});

contentManager.commands.setHandler('category:delete', function(category){

    valamisApp.execute('delete:confirm', {message: Valamis.language['warningDeleteMessageLabel']}, function(){
        category.destroy();
    });
});

contentManager.commands.setHandler('category:add', function(category, parent){

    var editCategoryView = new contentManager.Views.EditCategoryView({
        model: category
    });

    var modalView = new valamisApp.Views.ModalView({
        header: Valamis.language['createNewCategoryLabel'],
        contentView: editCategoryView,
        customClassName: 'content-manager-new-category'
    });

    editCategoryView.on('submit', function(category){
        category.save().then(function(){
            parent.nodes.add(category);
        });
    });

    valamisApp.execute('modal:show', modalView);
});


//question methods
contentManager.commands.setHandler('question:edit', function(question){

    var editQuestionView = new contentManager.Views.EditQuestionLayout({
        model: question
    });

    var modalView = new valamisApp.Views.ModalView({
        header: Valamis.language['editQuestionLabel'],
        contentView: editQuestionView
    });

    editQuestionView.on('submit', function(question){
        question.save();
    });

    valamisApp.execute('modal:show', modalView);
});

contentManager.commands.setHandler('question:delete', function(question){

    valamisApp.execute('delete:confirm', {message: Valamis.language['warningDeleteMessageLabel']}, function(){
        question.destroy();
    });
});

contentManager.commands.setHandler('question:add', function(question, parent){

    var editQuestionView = new contentManager.Views.EditQuestionLayout({
        model: question
    });

    var modalView = new valamisApp.Views.ModalView({
        header: Valamis.language[''],
        contentView: editQuestionView
    });

    editQuestionView.on('submit', function(question){
        question.save().then(function(){
            parent.nodes.add(question);
        });
    });

    valamisApp.execute('modal:show', modalView);
});


contentManager.commands.setHandler('content:clone',function(model, parent) {
    var contentType = model.get('contentType');
    var clone = model.clone();
    clone.unset('id');
    clone.unset('uniqueId');

    if(contentType == 'category'){
        contentManager.execute('category:add', clone, parent);
    }else if(contentType == 'question'){
        if(model.get('questionType') == '8') {
            contentManager.execute('content:add', clone, parent);
        }else{
            contentManager.execute('question:add', clone, parent);
        }
    }

});


contentManager.commands.setHandler('content:add', function(content, parent){

    var editQuestionView = new contentManager.Views.EditPlainTextQuestionView({
        model: content
    });

    var modalView = new valamisApp.Views.ModalView({
        header: Valamis.language['createNewContentLabel'],
        contentView: editQuestionView
    });

    editQuestionView.on('submit', function(content){
        content.save().then(function(){
            parent.nodes.add(content);
        });
    });

    valamisApp.execute('modal:show', modalView);
});

contentManager.commands.setHandler('content:edit', function(content){

    var editQuestionView = new contentManager.Views.EditPlainTextQuestionView({
        model: content
    });

    var modalView = new valamisApp.Views.ModalView({
        contentView: editQuestionView
    });

    editQuestionView.on('submit', function(content){
        content.save();
    });

    valamisApp.execute('modal:show', modalView);
});

contentManager.commands.setHandler('content:delete', function(content){
    valamisApp.execute('delete:confirm', {message: Valamis.language['warningDeleteMessageLabel']}, function(){
        content.destroy();
    });
});

contentManager.commands.setHandler('content:items:delete', function(contentItems){

    valamisApp.execute('delete:confirm', {message: Valamis.language['warningDeleteMessageLabel']}, function(){
        _.each(contentItems, function(item){
            item.destroy();
        });
    });
});

contentManager.commands.setHandler('content:items:export', function(contentItems){

    var export_url = path.root + path.api.files + 'export/?action=EXPORT&contentType=question&courseId=' + Utils.getCourseId();
    _.each(contentItems, function(item){
        var id = item.get('id');
        if(item.get('contentType') == 'category'){
            export_url += '&categoryID=' + id;
        }else if(item.get('contentType') == 'question'){
            export_url += '&id=' + id;
        }
    });

    window.location = export_url;
});

contentManager.commands.setHandler('content:items:move:to:course', function(contentItems, parent){

    if(_.isEmpty(contentItems)) {
        //TODO some info about empty list?
        return;
    }

    var siteSelectView = new valamisApp.Views.LiferaySiteSelectLayout({singleSelect: true});

    var modalView = new valamisApp.Views.ModalView({
        header: Valamis.language['moveToCourseLabel'],
        contentView: siteSelectView
    });

    siteSelectView.on('liferay:site:selected', function(site) {

        var newCourseId = site.get('id');

        var categories = contentItems.filter(function(item){
            return item.get('contentType') == 'category';
        });

        var questions = contentItems.filter(function(item){
            return item.get('contentType') == 'question';
        });

        var categoryIds = categories.map(function(item){return  item.get('id')});
        var questionIds = questions.map(function(item){ return item.get('id')});

        //TODO refactor this

        if (!_.isEmpty(categoryIds) && !_.isEmpty(questionIds)) {
            window.LearnAjax.post(path.root + path.api.category, {
                'action': 'MOVETOCOURSE',
                'categoryIDs': categoryIds,
                'newCourseID': newCourseId,
                'courseId': Utils.getCourseId()
            }).success(
                window.LearnAjax.post(path.root + path.api.questions, {
                    'action': 'MOVETOCOURSE',
                    'questionIDs': questionIds,
                    'newCourseID': newCourseId,
                    'courseId': Utils.getCourseId()
                })).success(function () {
                    valamisApp.execute('modal:close', modalView);

                    parent.fetchChildren();

                    toastr.success(Valamis.language['overlayCompleteMessageLabel']);
                }).fail(function () {
                    toastr.error(Valamis.language['overlayFailedMessageLabel']);
                });
        }

        if (_.isEmpty(categoryIds) && !_.isEmpty(questionIds)) {
            window.LearnAjax.post(path.root + path.api.questions, {
                'action': 'MOVETOCOURSE',
                'questionIDs': questionIds,
                'newCourseID': newCourseId,
                'courseId': Utils.getCourseId()
            }).success(function () {
                valamisApp.execute('modal:close', modalView);

                parent.fetchChildren();

                toastr.success(Valamis.language['overlayCompleteMessageLabel']);
            }).fail(function () {
                toastr.error(Valamis.language['overlayFailedMessageLabel']);
            });
        }

        if (!_.isEmpty(categoryIds) && _.isEmpty(questionIds)) {

            window.LearnAjax.post(path.root + path.api.category, {
                'action': 'MOVETOCOURSE',
                'categoryIDs': categoryIds,
                'newCourseID': newCourseId,
                'courseId': Utils.getCourseId()
            }).success(function () {
                valamisApp.execute('modal:close', modalView);

                parent.fetchChildren();

                toastr.success( Valamis.language['overlayCompleteMessageLabel']);
            }).fail(function () {
                toastr.error(Valamis.language['overlayFailedMessageLabel']);
            });
        }
    });

    valamisApp.execute('modal:show', modalView);
});


contentManager.commands.setHandler('move:content:item', function(movedModel, index, parentId, contentType){

    var oldParentId = movedModel.getParentId();
    var newParentId = parentId;

    movedModel.set('arrangementIndex', index);
    movedModel.move({}, {parentId: newParentId, index: index}).then(function(updatedModel){
        var courseId = movedModel.get('courseId');
        var rootNode = contentManager.rootNodes[courseId];

        var oldParent = (!oldParentId || oldParentId <= 0) ? rootNode: rootNode.getChildNode(oldParentId);

        oldParent.fetchChildren();

        if(oldParentId != newParentId) {
            var newParent = (!newParentId || newParentId <= 0)? rootNode : rootNode.getChildNode(newParentId);
            newParent.fetchChildren();
        }
    });

});