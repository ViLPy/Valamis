MyApp.module('RevealControlsModule', function (RevealControlsModule, MyApp, Backbone, Marionette, $, _) {
    RevealControlsModule.View = Marionette.ItemView.extend({
        template: '#revealControlsTemplate',
        events: {
            'click .add-page.right': 'addPageRight',
            'click .add-page.down': 'addPageDown',
            'click .slide-delete': 'deleteSlide'
        },
        addPageRight: function() {
            MyApp.commands.execute('reveal:page:addRight');
        },
        addPageDown: function() {
            MyApp.commands.execute('reveal:page:addDown');
        },
        deleteSlide: function() {
            MyApp.commands.execute('reveal:page:delete');
        }
    });

    RevealControlsModule.addInitializer(function () {
        MyApp.revealControls.show(new RevealControlsModule.View());

        jQuery('.change-background').ColorPicker({
          onSubmit: function(hsb, hex, rgb, el) {
            $(el).val(hex);
            $(el).ColorPickerHide();
            MyApp.commands.execute('reveal:page:changeBackground', '#'+hex);
          },
          onBeforeShow: function () {
            $(this).ColorPickerSetColor(jQuery(Reveal.getCurrentSlide()).attr('data-background') || '#000000');
          }
        });

        console.log('controls!');
    });
});