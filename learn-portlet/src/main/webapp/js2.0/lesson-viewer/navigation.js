NavigationNode = Backbone.Model.extend({
    navigateToSlide: function(){
        this.trigger('internal-navigate',this);
    },
    toggleActive: function(){
        if(this.get('active')) this.set('active', false);
        else this.set('active',true)
    },
    setComplete: function(){
        this.set('completed',true)
    }
});

/*  If this is directory: { elementType: 'directory', childElements: [$childElementsArray] } */
NavigationNodeCollection = Backbone.Collection.extend({
    model: NavigationNode,
    previouslyToggled: null,
    navigate: function(){
        throw new Error("Replace me");
    },
    afterInitialization: function(){
        var that = this;
        function afterInitializationHelper(elem){
            elem.each(function(model){
                if(model.get('elementType') == 'directory') {
                    model.internalCollection = new NavigationNodeCollection(model.get('childElements'));
                    afterInitializationHelper(model.internalCollection);
                } else {
                    that.listenTo(model,'internal-navigate',that.navigate);
                }
            })
        }
        afterInitializationHelper(this);
    },
    toggle: function(){
        throw new Error("Replace me");
    },
    toggleHelper: function(toggleModel){
        toggleModel.toggleActive();
        toggleModel.setComplete();
        if(this.previouslyToggled != null) this.previouslyToggled.toggleActive();
        this.previouslyToggled = toggleModel;
    },
    initialToggle: function() {
        function findFirstElem(elem) {
            if(elem.models[0].get('elementType') == 'directory')
                return findFirstElem(elem.models[0].internalCollection);
            else return elem.models[0];
        }
        var toggleModel = findFirstElem(this);
        toggleModel.toggleActive();
        toggleModel.setComplete();
        this.previouslyToggled = toggleModel;
    }
});

NavigationNodeCollectionView = null;
NavigationNodeView = Backbone.View.extend({
    tagName: 'li',
    events: {
        'click': function(){ if(this.model.get('elementType') != 'directory') this.model.navigateToSlide(); },
        'click .js-lesson-category-title': function(){ this.model.set('collapsed', !this.model.get('collapsed')) }
    },
    directoryTemplate: null,
    elementTemplate: null,
    getDirectoryTemplate: function(){
        if(this.directoryTemplate == null) this.directoryTemplate = jQueryValamis('#navigation-category-item').html();
        return this.directoryTemplate;
    },
    getElementTemplate: function(){
        if(this.elementTemplate == null) this.elementTemplate = jQueryValamis('#navigation-question-item').html();
        return this.elementTemplate;
    },
    initialize: function(){
        this.listenTo(this.model, 'change:active', function(){ this.$el.toggleClass('active', this.model.get('active') == true) });
        this.listenTo(this.model, 'change:completed', function(){ this.$el.toggleClass('completed', this.model.get('completed') == true) });
        this.listenTo(this.model, 'change:collapsed', this.toggleCollapsed)
    },
    toggleCollapsed: function(){
        var collapsed = this.model.get('collapsed') == true;
        var elem = this.$('.js-lesson-category-title');
        this.$el.toggleClass('collapsed', collapsed);
        elem.toggleClass('val-icon-arrow-right', collapsed);
        elem.toggleClass('val-icon-arrow-down', !collapsed);
    },
    render: function(){
        if(this.model.get('elementType') == 'directory'){
            this.$el.html(Mustache.to_html(this.getDirectoryTemplate(), this.model.attributes));

            var elementsContainer = this.$('.lesson-items');
            var navigationNodeCollectionView = new NavigationNodeCollectionView({collection: this.model.internalCollection});
            elementsContainer.html(navigationNodeCollectionView.render().$el);

            this.$el.addClass('lesson-category');
            this.toggleCollapsed();
        } else {
            this.$el.html(Mustache.to_html(this.getElementTemplate(), this.model.attributes));

            this.$el.addClass('lesson-item');
            this.$el.toggleClass('active',this.model.get('active') == true);
            this.$el.toggleClass('completed',this.model.get('completed') == true);
        }
        return this;
    }
});

NavigationNodeCollectionView = Backbone.View.extend({
    tagName: 'ul',
    render: function(){
        this.collection.each(this.addOne, this);
        return this;
    },
    addOne: function(model){
        this.$el.append(new NavigationNodeView({model: model}).render().$el);
    }
});
