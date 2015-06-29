/**
 * Created by igorborisov on 10.04.15.
 */

contentManager.module("Views", function (Views, ContentManager, Backbone, Marionette, $, _) {

    Views.EditCategoryView = Marionette.ItemView.extend({
        template: '#categoryEditView',
        events: {
            'click .js-saveCategory': 'saveCategory'
        },
        updateModel: function () {
            var title = Utils.getDataFromPlaceholder(this.$('.js-category-title'));
            if (title.length === 0) {
                toastr.warning(Valamis.language['overlayWarningMessageLabel']);
                return false;
            }
            this.model.set({
                title: title,
                description: ''
            });
            return true;
        },
        saveCategory: function(){
            if (!this.updateModel()) return false;
            this.triggerMethod('submit', this.model);
        }
    });

    Views.ToolbarView = Marionette.ItemView.extend({
        template: '#contentManagerToolbarTemplate',
        className: 'div-table',
        events: {
            'click .js-add-category': 'addCategory',
            'click .js-add-question' : 'addQuestion',
            'click .js-add-content' : 'addContent',
            'click .js-select-all' : 'selectAll',
            'click .js-delete-items': 'deleteItems',
            'click .js-export-items': 'exportItems',
            'click .js-move-items': 'moveItems'
        },
        initialize: function(){
            this.selectAllValue = false;
        },
        behaviors: {
            ValamisUIControls: {}
        },
        addCategory: function(){
            var newCategory = new contentManager.Entities.TreeCategory({parentId : this.model.get('id'), courseId: this.model.get('courseId')});
            contentManager.execute('category:add', newCategory, this.model);
        },
        addQuestion: function(){
            var newQuestion = new contentManager.Entities.TreeQuestion({categoryID : this.model.get('id'), courseId: this.model.get('courseId') });
            contentManager.execute('question:add', newQuestion, this.model);
        },
        addContent: function(){
            var newQuestion = new contentManager.Entities.TreeQuestion({categoryID : this.model.get('id'), courseId: this.model.get('courseId'), questionType: 8});
            contentManager.execute('content:add', newQuestion, this.model);
        },
        selectAll:function(){
            var that = this;
            that.selectAllValue = !that.selectAllValue;

            that.model.nodes.each(function(item){
               item.set('selected', that.selectAllValue);
            });
        },
        getSelectedItems:function(){
            var selectedItems = this.model.nodes.filter(function(item){
                return item.get('selected');
            });
            return selectedItems;
        },
        deleteItems:function(){
            var selectedItems = this.getSelectedItems();
            contentManager.execute('content:items:delete', selectedItems);
        },
        exportItems:function(){
            var selectedItems = this.getSelectedItems();
            contentManager.execute('content:items:export', selectedItems);
        },
        moveItems:function(){
            var selectedItems = this.getSelectedItems();
            contentManager.execute('content:items:move:to:course', selectedItems, this.model);
        }
    });


    Views.ContentItemView = Marionette.ItemView.extend({
        tagName: 'li',
        events: {
            'click .js-edit-content': 'editItem',
            'click .js-delete-content': 'deleteItem',
            'click .js-clone-content': 'cloneItem',
            'click .js-select-entity': 'selectItem',
            'click' : 'activateItem'
        },
        modelEvents: {
            'change:title': 'render',
            'change:questionType': 'render',
            'change:selected': 'selectedChanged'
        },
        activateItem: function(){
            this.triggerMethod('activate:item');
            this.$el.addClass('active-item');
        },
        onRender: function(){
            this.$el.attr('data-id', this.model.get('id'));
        },
        selectItem: function(){
            this.model.set('selected', this.$('.js-select-entity').is(':checked'), {silent: true});
        },
        selectedChanged: function(){
            this.$('.js-select-entity').attr('checked', this.model.get('selected'));
        },
        cloneItem: function(){
            this.triggerMethod('content:item:clone');
        }
    });

    Views.QuestionContentItemView = Views.ContentItemView.extend({
        className: 'question lesson-item-li',
        template: '#contentManagerContentQuestionTemplate',
        editItem : function(){
            if(this.model.get('questionType') == '8'){
                contentManager.execute('content:edit', this.model);
            }else{
            contentManager.execute('question:edit', this.model);
            }
        },
        deleteItem: function(){
            contentManager.execute('question:delete', this.model);
        }
    });

    Views.CategoryContentItemView = Views.ContentItemView.extend({
        className: 'category lesson-item-li',
        template: '#contentManagerContentCategoryTemplate',
        editItem : function(){
            contentManager.execute('category:edit', this.model);
        },
        deleteItem: function(){
            contentManager.execute('category:delete', this.model);
        }
    });

    //TODO can use CollectionView here
    Views.CategoryContentList = Marionette.CompositeView.extend({
        'tagName': 'div',
        'className': 'val-lesson-content',
        reorderOnSort: true,
        template: '#contentManagerContentListTemplate',
        childViewContainer: "ul.js-content-list",
        initialize: function(){
            this.collection = this.model.nodes;
        },
        getChildView: function(model){
            if(model.get('contentType') == 'question') {
                return Views.QuestionContentItemView;
            }
            if(model.get('contentType') == 'category') {
                return Views.CategoryContentItemView;
            }
        },
        childEvents: {
            'activate:item' : function(childView){
                this.$('li').removeClass('active-item');
                this.triggerMethod('content:list:activate:item', childView.model);
            },
            'content:item:clone': function(childView){
                this.triggerMethod('content:list:clone:item', childView.model);
            }
        },
        onRender: function(){
            this.sortable();
            this.$el.on( "sortstart", function( event, ui ) {
//                ui.item.find(".js-tree-item-drag").show();
//                ui.item.find(".js-tree-item").hide();
            });

            this.$el.on( "sortstop", function( event, ui ) {
//                ui.item.find(".js-tree-item").show();
//                ui.item.find(".js-tree-item-drag").hide();
            });
        },
        updateSorting: function(movedModel, index, parentId, contentType){
            contentManager.execute('move:content:item', movedModel, index, parentId, contentType);
        },
        sortable: function() {
            var that = this;
            this.$('> .js-content-list').nestedSortable({
                handle: '.js-tree-item',
                items: 'li',
                toleranceElement: '> span',
                listType: 'ul',
                tabSize: 20,
                maxLevels: 2,
                isTree: true,
                doNotClear: true,
                expandedClass: 'expanded',
                collapsedClass: 'collapsed',
                expandOnHover: 100,
                placeholder: 'ui-state-highlight',
                disableNestingClass: 'question',
                connectWith: '.ui-sortable',
                forcePlaceholderSize: true,
                relocate: function(e, ui) {
                    var $uiItem = jQueryValamis(ui.item);
                    var id = $uiItem.attr('data-id');

                    var contentType = '';
                    if($uiItem.hasClass('category')){
                        contentType = 'category';
                    }else if($uiItem.hasClass('question')){
                        contentType = 'question';
                    }

                    var index = contentType? $uiItem.prevAll('.' + contentType).length + 1 : 1;

                    var cid = id;
                    if(contentType == 'category'){
                        cid = 'c_' + id;
                    }else if(contentType == 'question'){
                        cid = 'q_' + id;
                    }

                    var movedModel = that.collection.get(cid);

                    var rawParentId =  $uiItem.parents('li').first().attr('data-id');
                    var parentId = parseInt(rawParentId) || that.model.get('id');

                    that.updateSorting(movedModel, index, parentId, contentType);
                },
                isAllowed: function (next, parent, current) {
                    if(jQueryValamis(current).hasClass('question') && !jQueryValamis(next).nextAll('.category').length > 0)
                        return true;
                    if(jQueryValamis(current).hasClass('category') && !jQueryValamis(next).parents('li').hasClass('category'))
                        return true;
                    return false;
                }
            }).disableSelection();

        }
    });

    Views.ContentLayout = Marionette.LayoutView.extend({
        tagName: 'div',
        template: '#contentManagerContentLayoutTemplate',
        className: 'min-height400 content-container div-row',
        initialize:function(){
            this.activeItemId = '';
        },
        regions:{
            'toolbar' : '#contentManagerToolbar',
            'content': '#categoryContentView',
            'contentQuestions': '#categoryContentQuestionsView',
            'preview': '#contentManagerContentPreview'
        },
        childEvents: {
            'content:list:activate:item': function(childView, model){
                if (this.activeItemId === model.get('uniqueId'))
                    this.preview.currentView.$el.toggle();
                else
                    this.preview.show(new Views.PreviewLayout({model: model, parent: this.model}));
                this.activeItemId = model.get('uniqueId');
            },
            'content:list:clone:item': function(childView, model){
                contentManager.execute('content:clone', model, this.model);
            }
        },
        onRender: function() {
            var that = this;
            var toolbarView = new Views.ToolbarView({
                model: that.model
            });
            that.toolbar.show(toolbarView);

            var contentView = new Views.CategoryContentList({
                model : that.model
            });

            that.content.show(contentView);
        }
    });

    Views.AppLayoutView = Marionette.LayoutView.extend({
        tagName: 'div',
        template: '#contentManagerLayoutTemplate',
        regions:{
            'contents': '#contentManagerContentsView',
            'content': '#contentManagerContentView'
        },
        initialize: function(options) {
            this.showGlobalBase = options.showGlobalBase;
        },
        childEvents:{
            'contents:clean:active': function(childView){
                this.contents.currentView.$('li').removeClass('selected-entity');
            },
            'contents:activate:category': function(childView, category){
                var contentLayout = new Views.ContentLayout({model: category});
                this.content.show(contentLayout);
            }
        },
        onRender: function() {
            var that = this;

            var mainRegionWidth = $('#contentManagerAppRegion').width();
            if (mainRegionWidth < 768) // mobile view
                this.$('.portlet-wrapper').addClass('sidebar-hidden');

            if(this.showGlobalBase) {
                var courses = new valamisApp.Entities.LiferaySiteCollection();
                courses.fetch({ currentPage: 1, itemsOnPage: 0,  reset: true });

                var courseList = new Views.CoursesView({
                    collection: courses
                });

                that.contents.show(courseList);

            }else{

                var courseId = Utils.getCourseId();
                var rootNode =  new contentManager.Entities.TreeCategory(
                    { title: Valamis.language['treeRootElement'],
                        courseId: courseId});

                contentManager.rootNodes[courseId] = rootNode;

                rootNode.fetchChildren().then(function(){
                    var contentsTree = new Views.ContentsTree({
                        model: rootNode
                    });

                    that.contents.show(contentsTree);

                    var contentLayout = new Views.ContentLayout({model: rootNode});
                    that.content.show(contentLayout);
                });
            }
        }
    });

});