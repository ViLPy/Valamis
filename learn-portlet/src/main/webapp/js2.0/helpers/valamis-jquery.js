/**
 * Created by igorborisov on 03.04.15.
 */
if(typeof jQueryValamis == 'undefined'){
    jQueryValamis = jQuery.noConflict();
    //needed for backbone model binder, should fix in feature
    $ = jQueryValamis;
}