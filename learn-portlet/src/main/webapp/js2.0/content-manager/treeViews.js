/**
 * Created by igorborisov on 27.05.15.
 */

contentManager.module("Views", function (Views, ContentManager, Backbone, Marionette, $, _) {

    Views.CourseItemView = Marionette.CompositeView.extend({
        template: '#contentManagerContentRootNodeTemplate',
        childViewContainer: '.tree-items',
        childView: Views.ContentsTree
    });

    Views.BaseTreeView = Marionette.CompositeView.extend({
        events: {
            'click .js-tree-item': 'selectNode',
            'click .js-tree-item-icon': 'toggleExpand'
        },
        toggleExpand: function () {
            this.collapsed = !this.collapsed;
            this.updateCollapsed();
        },
        updateCollapsed: function () {
            if (!this.collection.hasChildNodes()) {
                this.$el.removeClass('expanded').removeClass('collapsed');
                this.$('> .js-tree-item > .js-tree-item-icon').removeClass('val-icon-arrow-down').removeClass('val-icon-arrow-right');
            } else if (this.collapsed) {
                this.$el.removeClass('expanded').addClass('collapsed');
                this.$('> .js-tree-item > .js-tree-item-icon').removeClass('val-icon-arrow-down').addClass('val-icon-arrow-right');
            } else {
                this.$el.removeClass('collapsed').addClass('expanded');
                this.$('> .js-tree-item > .js-tree-item-icon').removeClass('val-icon-arrow-right').addClass('val-icon-arrow-down');
            }
        },
        loadChildren: function () {
            var that = this;
            this.model.fetchChildren().then(function () {
                that.collapsed = true;
                that.childrenFetched = true;
                //TODO try to avoid this
                that.render();
            });
        },
        addChild: function (child, ChildView, index) {
            var that = this;
            if (child.isNode()) {
                Marionette.CompositeView.prototype.addChild.apply(this, arguments);
                that.updateCollapsed();
            }
        }
    });

    Views.TreeView = Views.BaseTreeView.extend({
        template: '#contentManagerContentNodeTemplate',
        tagName: 'li',
        className: 'category collapsed',
        childView: Views.TreeView,
        childViewContainer: '.tree-items',
        childEvents: {
            'select:node': function (childView, model) {
                this.triggerMethod('select:node', model);
            }
        },
        initialize: function () {
            this.collapsed = true;
            this.childrenFetched = true;
            this.collection = this.model.nodes;
        },
        modelEvents: {
            'change title': function () {
                this.$('> .js-tree-item > .js-tree-item-title').text(this.model.get('title'));
            },
            'change childrenAmount': function (arg) {
                this.$('> .js-tree-item > .js-tree-item-title').attr('data-count', this.model.get('childrenAmount'));
            }
        },
        onRender: function () {
            if (this.childrenFetched) {
                if (this.collection.length > 0) {
                    this.updateCollapsed();
                }
            }
            this.$el.attr('data-id', this.model ? this.model.get('id') : '');
        },
        templateHelpers: function () {
            return {
                needShowChildrenAmount: this.model.get('childrenAmount') > 0
            }
        },
        selectNode: function (e) {
            e.stopPropagation();
            this.triggerMethod('contents:clean:active');
            this.triggerMethod('contents:activate:category', this.model);

            this.$el.addClass('selected-entity');

            if (!this.childrenFetched) {
                this.loadChildren();
            }
        }
    });

    Views.ContentsTree = Marionette.CompositeView.extend({
        template: '#contentManagerContentRootNodeTemplate',
        childView: Views.TreeView,
        childViewContainer: ".tree-items",
        events: {
            'click .js-root': 'selectThis',
            'click .js-tree-item-icon': 'toggleExpand'
        },
        modelEvents: {
            'change childrenAmount': function () {
                this.$('.js-root > .js-tree-item > .js-tree-item-title').attr('data-count', this.model.get('childrenAmount'));
            }
        },
        toggleExpand: function () {
            this.collapsed = !this.collapsed;
            this.updateCollapsed();
        },
        updateCollapsed: function () {
            if (!this.collection.hasChildNodes()) {
                this.$el.removeClass('expanded').removeClass('collapsed');
                this.$('> .js-tree-item > .js-tree-item-icon').removeClass('val-icon-arrow-down').removeClass('val-icon-arrow-right');
            } else if (this.collapsed) {
                this.$('> ul > li').removeClass('expanded').addClass('collapsed');
                this.$('> ul > li > .js-tree-item > .js-tree-item-icon').first().removeClass('val-icon-arrow-down').addClass('val-icon-arrow-right');
            } else {
                this.$('> ul > li').removeClass('collapsed').addClass('expanded');
                this.$('> ul > li > .js-tree-item > .js-tree-item-icon').first().removeClass('val-icon-arrow-right').addClass('val-icon-arrow-down');
            }
        },
        childEvents: {
            'select:node': function (childView, model) {
                this.selectNode(model);
            }
        },
        addChild: function (child, ChildView, index) {
            if (child.isNode()) {
                Marionette.CompositeView.prototype.addChild.apply(this, arguments);
            }
        },
        initialize: function () {
            this.collapsed = true;
            this.childrenFetched = false;
            if (this.model.nodes.length > 0) {
                this.collapsed = false;
                this.childrenFetched = true;
            }
            this.collection = this.model.nodes;
        },
        onRender: function () {
            this.sortable();
            this.updateCollapsed();
        },
        selectThis: function () {
            this.triggerMethod('contents:clean:active');
            this.selectNode(this.model);
            this.$('li.js-root').addClass('selected-entity');
        },
        selectNode: function (model) {
            var that = this;

            if (that.childrenFetched) {
                that.triggerMethod('contents:activate:category', model);
            } else {
                that.model.fetchChildren().then(function () {
                    that.collapsed = true;
                    that.childrenFetched = true;
                    //TODO try to avoid this
                    that.render();
                    that.triggerMethod('contents:activate:category', model);
                }, function () {
                    that.childrenFetched = true;
                    that.triggerMethod('contents:activate:category', model);
                });
            }
        },
        updateSorting: function (movedModel, index, parentId) {
            contentManager.execute('move:content:item', movedModel, index, parentId, 'category');
        },
        loadChildren: function () {
            var that = this;
            this.model.fetchChildren().then(function () {
                that.collapsed = true;
                that.childrenFetched = true;
                //TODO try to avoid this
                that.render();
            });
        },
        sortable: function () {
            var that = this;
            this.$('ul.tree-items').nestedSortable({
                handle: '.js-tree-item',
                items: 'li',
                toleranceElement: '> span',
                listType: 'ul',
                tabSize: 50,
                isTree: true,
                doNotClear: true,
                expandedClass: 'expanded',
                collapsedClass: 'collapsed',
                expandOnHover: 800,
                disableNestingClass: 'question',
                connectWith: '.ui-sortable',
                forcePlaceholderSize: true,
                placeholder: 'ui-state-highlight',
                relocate: function (e, ui) {
                    var $uiItem = jQueryValamis(ui.item);
                    var id = $uiItem.attr('data-id');
                    var index = $uiItem.prevAll('.category').length + 1;

                    var rawParentId = $uiItem.parents('li').first().attr('data-id');
                    var parentId = parseInt(rawParentId) || '';

                    var movedModel = that.model.getChildNode(id);

                    that.updateSorting(movedModel, index, parentId);
                },
                isAllowed: function (next, parent, current) {
                    return true;
                }
            }).disableSelection();

        }
    });

    Views.CoursesView = Marionette.CollectionView.extend({
        template: '#contentManagerContentRootNodeTemplate',
        childViewContainer: '.tree-items',
        childView: Views.ContentsTree,
        addChild: function (child, ChildView, index) {

            var courseId = child.get('id');
            var node = new contentManager.Entities.TreeCategory({
                title: child.get('title'),
                id: '',
                courseId: courseId
            });
            node.updateContentAmount();

            arguments[0] = node;
            contentManager.rootNodes[courseId] = node;

            Marionette.CollectionView.prototype.addChild.apply(this, arguments);
        }
    });

});