MyApp.module('RevealModule', function (RevealModule, MyApp, Backbone, Marionette, $, _) {
    RevealModule.startWithParent = false;

    RevealModule.View = Marionette.ItemView.extend({
        template: '#revealTemplate',
        className: 'reveal',
        initialize: function() {
            this.elementViews = {};
        },
        loadView: function(collection) {
            function forEachPageGroup(pageGroup) {
                var pageGroupSection = jQuery('<section></section>');
                this.$('.slides').append(pageGroupSection);

                var forEachChildPagePartial = _.partial(forEachChildPage, pageGroupSection);
                pageGroup.get('childPages').forEach(forEachChildPagePartial, this);
            }

            function forEachChildPage(parentEl, childPage) {
                var pageSection = jQuery('<section></section>');
                pageSection.attr('id', childPage.id);
                parentEl.append(pageSection);

                var forEachElementPartial = _.partial(forEachElement, pageSection);
                childPage.get('pageElements').forEach(forEachElementPartial, this);
            }

            function forEachElement(parentEl, elementModel) {
                var moduleName = elementModel.get('elementType');
                if (moduleName && MyApp.module(moduleName)) {
                    var ViewClass = MyApp.module(moduleName).View;
                    var view = new ViewClass({model: elementModel});
                    this.elementViews[elementModel.id] = view;

                    parentEl.append(view.render().$el);
                }
            }

            this.$('.slides').empty();
            collection.forEach(forEachPageGroup, this);
            this.initReveal();
        },
        initReveal: function() {
            Reveal.initialize({
                controls: true,
                progress: false,
                history: true,
                center: true,
                embedded: true,
                // Bounds for smallest/largest possible scale to apply to content
                minScale: 1.0,
                maxScale: 1.0,

                theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
                transition: Reveal.getQueryHash().transition || 'default' // default/cube/page/concave/zoom/linear/fade/none
            });

            Reveal.addEventListener( 'slidechanged', function( event ) {
                this.indexh = event.indexh;
                this.indexv = event.indexv;
            }.bind(this) );

            Reveal.slide( 0, 0);

            /*jQuery('#addPage').click(function(){
                jQuery('.slides').append('<section>new slide</section>');
                Reveal.right();
            });*/
        },
        addPageRight: function() {
            jQuery('<section><section></section></section>').insertAfter(jQuery(Reveal.getCurrentSlide()).parent());
            Reveal.right();
        },
        addPageDown: function() {
            jQuery('<section></section>').insertAfter(jQuery(Reveal.getCurrentSlide()));
            Reveal.down();
        },
        deleteCurrentPage: function() {
            var currentPage = jQuery(Reveal.getCurrentSlide());
            var isOnlyPageInGroup = (jQuery('section', currentPage.parent()).length == 1);
            var currentPageID = currentPage.data('id');
            if (isOnlyPageInGroup) {
                // can delete the whole group and move to the right/left
                var parentID = currentPage.parent().data('id');
                currentPage.parent().remove();
            } else {
                // can delete only section and move to the down/up
                currentPage.remove();
            }
        },
        changeBackground: function(color) {
          console.log(color);

          var slide = jQuery(Reveal.getCurrentSlide());
          slide.attr('data-background', color);
          Reveal.sync();
        }
    });

    var view = new RevealModule.View();

    RevealModule.addInitializer(function () {
        MyApp.commands.setHandler('reveal:page:addRight', view.addPageRight);
        MyApp.commands.setHandler('reveal:page:addDown', view.addPageDown);
        MyApp.commands.setHandler('reveal:page:delete', view.deleteCurrentPage);
        MyApp.commands.setHandler('reveal:page:changeBackground', function(color) {view.changeBackground(color)});
    });

    RevealModule.addInitializer(function () {
        MyApp.editorArea.on('show', view.initReveal);
        MyApp.editorArea.show(view);

        var collection = MyApp.request('entities:getAll');
        view.listenTo(collection, 'sync', view.loadView);
    });
});