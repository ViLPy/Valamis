/*
 * Skeleton V1.1
 * Copyright 2011, Dave Gamache
 * www.getskeleton.com
 * Free to use under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 * 8/17/2011
 */


jQueryValamis(document).ready(function () {

    /* Tabs Activiation
     ================================================== */

    var tabs = jQueryValamis('ul.tabs');

    tabs.each(function (i) {

        //Get all tabs
        var tab = jQueryValamis(this).find('> li > a');
        tab.click(function (e) {

            //Get Location of tab's content
            var contentLocation = jQueryValamis(this).attr('href');

            //Let go if not a hashed one
            if (contentLocation.charAt(0) == "#") {

                e.preventDefault();

                //Make Tab Active
                tab.removeClass('active');
                jQueryValamis(this).addClass('active');

                //Show Tab Content & add active class
                jQueryValamis(contentLocation).show().addClass('active').siblings().hide().removeClass('active');

            }
        });
    });
});