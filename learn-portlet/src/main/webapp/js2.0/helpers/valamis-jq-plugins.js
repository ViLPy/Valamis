/**
 * Created by igorborisov on 02.04.15.
 */

// valamis dropdown
(function($) {

    var methods = {
        init : function( options ) {
            this.each(function(){
                var elem = $(this);

                var actionButton = elem.find(".button");
                var dropdwonMenu = elem.find('.dropdown-menu');
                actionButton.unbind('click').on('click', function(){
                    dropdwonMenu.toggleClass("dropdown-visible");
                });

                var dropdownItems = dropdwonMenu.find("li");

                dropdownItems.each(function(ind, itm){
                        var item =$(itm);
                        item.unbind('click').click(function() {
                                if(!elem.hasClass('actions')){
                                    item.addClass('selected').siblings().removeClass('selected');
                                    item.parents('.dropdown')
                                        .data('value', item.data('value'))
                                        .find('.dropdown-text').html(item.html());
                                }

                                dropdwonMenu.removeClass('dropdown-visible');
                            }
                        );
                    }
                );

                $('body').on('click', function(e){
                    if (elem.has(e.target).length === 0) {
                        dropdwonMenu.removeClass('dropdown-visible');
                    }
                });
            });

            return this;
        },
        select: function(options){
            if(this.hasClass('actions')) return;

            var item = this.find('.dropdown-menu > li[data-value='+ options +']');

            item.addClass('selected').siblings().removeClass('selected');
            item.parents('.dropdown')
                .data('value', item.data('value'))
                .find('.dropdown-text').html(item.html());
        }
    };

    $.fn.valamisDropDown = function(method) {

        if ( methods[method] ) {
            return methods[method].apply( this, Array.prototype.slice.call( arguments, 1 ));
        } else if ( typeof method === 'object' || ! method ) {
            return methods.init.apply( this, arguments );
        } else {
            $.error( 'Method ' +  method + ' does not exist in jQuery.valamisDropDown' );
        }

    };
})(jQuery);

//valamis sidebar
(function($) {
    $.fn.valamisSidebar = function() {

        this.each(function(){
            var elem = $(this);
            elem.unbind('click').click(function() {
                elem.parents('.portlet-wrapper').toggleClass('sidebar-hidden');
            });
        });
    };
})(jQuery);

//digits only
(function(){
    // methods
    var methods = {
        init : function(params) {

            return this.each(function() {
                var elem = $(this);

                //TODO add '-' ability
                elem.unbind('keypress').keypress(function(e) {
                    var code = e.keyCode ? e.keyCode : e.charCode;
                    if (($(this).val().indexOf('.') > 0) && e.charCode == 46) {
                        return false
                    }

                    var allowed = [46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 8, 9, 39, 37, 190];
                    if (allowed.indexOf(code) < 0) {
                        return false;
                    }
                });
            });
        }
    };

    $.fn.valamisDigitsOnly = function(method) {
        if ( methods[method] ) {
            return methods[method].apply( this, Array.prototype.slice.call( arguments, 1 ));
        } else if ( typeof method === 'object' || !method ) {
            return methods.init.apply( this, arguments );
        } else {
            $.error( 'Method ' +  method + ' does not exist in jQuery.valamisDigitsOnly' );
        }
    }
})(jQuery);

// `valamis plus-minus control
(function($) {

    var defaults = {
        'min': '0',
        'max': '100',
        'step': '1'
    };


// methods
    var methods = {
        init : function(params) {

            var getFixed = function(step){
                var afterComma = (''+ step).split('.')[1];
                return afterComma? afterComma.length : 0;
            };

            var changeInputWidth = function(textInput, value){
                var amount = ('' + value).length;
                var width = 14 + 8 * (amount);
                if(width < 34) width = 34;
                textInput.css('width', width + 'px');
            };

            var fixValue = function(value){
                var minValue = parseFloat(options.min);
                var maxValue = parseFloat(options.max);
                var step = parseFloat(options.step);

                if(value > maxValue - step) value = maxValue;
                if(value< minValue + step) value = minValue;
                return value;
            };

            var options = $.extend({}, defaults, params);
            options.fixed = getFixed(options.step);

            var html = '<button class="button medium neutral no-text minus-button">'
                + '<span class="val-icon-minus"></span>'
                + '</button>'
                    //+ '<span>'
                + '<input type="text" class="text-input valamis box-sizing" value="0"/>'
                    //+ '</span>'
                + '<button class="button medium neutral no-text plus-button">'
                + '<span class="val-icon-plus"></span>'
                + '</button>';

            return this.each(function(){
                var elem = $(this);
                elem.html(html);
                elem.addClass('valamis-plus-minus');
                var minusButton = elem.find('button.minus-button');
                var plusButton = elem.find('button.plus-button');
                var textInput = elem.find('input[type=text]');

                minusButton.unbind('click').click(function() {
                    var step = parseFloat(options.step);
                    var value = parseFloat(textInput.val() || 0).toFixed(options.fixed);
                    var newValue = parseFloat(value) - step;

                    newValue = fixValue(newValue.toFixed(options.fixed));

                    textInput.val(newValue);
                    changeInputWidth(textInput, newValue);
                });

                plusButton.unbind('click').click(function() {
                    var step = parseFloat(options.step);
                    var maxValue = parseFloat(options.max);
                    var value = parseFloat(textInput.val() || 0).toFixed(options.fixed);
                    var newValue = parseFloat(value) + step;

                    newValue = fixValue(newValue.toFixed(options.fixed));

                    textInput.val(newValue);
                    changeInputWidth(textInput, newValue);
                });

                textInput.unbind('keypress').keypress(function(e){
                    var code = e.keyCode ? e.keyCode : e.charCode;
                    if(($(this).val().indexOf('.') > 0) && e.charCode == 46){
                        return false
                    }

                    var allowed = [46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 8, 9, 39, 37, 190];
                    if (allowed.indexOf(code) < 0) {
                        return false;
                    }

                });

                textInput.unbind('keyup').keyup(function(e){
                    setTimeout(function(){
                        textInput.val(fixValue(textInput.val()));
                        changeInputWidth(textInput, textInput.val());
                    }, 300);

                });

            });
        },
        show : function( ) {
            var elem = $(this);
            elem.show();
        },
        hide : function( ) {
            var elem = $(this);
            elem.hide();
        },
        disable : function() {
            var elem = $(this);
            elem.find('button.minus-button').attr('disabled', true);
            elem.find('button.plus-button').attr('disabled', true);
            elem.find('input[type=text]').attr('disabled', true);
        },
        enable : function() {
            var elem = $(this);
            elem.find('button.minus-button').attr('disabled', false);
            elem.find('button.plus-button').attr('disabled', false);
            elem.find('input[type=text]').attr('disabled', false);
        },
        value: function(value){
            var elem = $(this);
            var textInput = elem.find('input[type=text]');
            if(value){
                textInput.val(parseFloat(value));
            }else{
                return parseFloat(textInput.val());
            }
        },
        destroy : function( ) {

            return this.each(function(){
                var elem = $(this);
                var minusButton = elem.find('button.minus-button');
                var plusButton = elem.find('button.plus-button');
                var textInput = elem.find('input[type=text]');
                minusButton.unbind('click');
                plusButton.unbind('click');
                textInput.unbind('keypress');
                elem.destroy();
            });
        }

    };

    $.fn.valamisPlusMinus = function(method) {
        if ( methods[method] ) {
            return methods[method].apply( this, Array.prototype.slice.call( arguments, 1 ));
        } else if ( typeof method === 'object' || !method ) {
            return methods.init.apply( this, arguments );
        } else {
            $.error( 'Method ' +  method + ' does not exist in jQuery.valamisPlusMinus' );
        }
    }

})(jQuery);