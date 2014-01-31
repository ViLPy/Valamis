app.directive('juiTabs', ['$timeout',
    function ($timeout) {
        return {
            restrict: 'A',
            link: function (scope, el, attrs) {
                var tabs = jQuery1816Curriculum(el).tabs();

                scope.$watch(attrs.juiTabs, function(){
                    // Hack for refresh tabs. Need refresh after template loaded
                    $timeout(function() {
                        var selectedIndex = tabs.tabs("option", "selected");

                        tabs.tabs('destroy');
                        tabs.tabs();

                        var tabsCount = jQuery1816Curriculum("#certificateTabs").tabs("length");
                        tabs.tabs("option", "selected",
                            selectedIndex > (tabsCount - 1)
                                ? (tabsCount - 1)
                                : selectedIndex);
                    }, 100);
                }, true);
            }
        }
    }
]);