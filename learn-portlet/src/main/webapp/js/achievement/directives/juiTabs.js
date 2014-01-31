app
    .directive('juiTabs', ['$timeout',
        function ($timeout) {
            return {
                restrict: 'A',
                link: function (scope, el, attrs) {
                    var tabs = jQuery1816Curriculum(el).tabs();

                    scope.$watchCollection(attrs.juiTabs, function () {
                        // Hack for refresh tabs. Need refresh after template loaded
                        $timeout(function () {
                            tabs.tabs('destroy');

                            tabs.tabs();


                            var selectedIndex = tabs.tabs("option", "selected");
                            var tabsCount = jQuery1816Curriculum("#certificateTabs").tabs("length");
                            tabs.tabs("option", "selected",
                                selectedIndex > (tabsCount - 1)
                                    ? (tabsCount - 1)
                                    : selectedIndex);

                        }, 100);
                    }, true);

                    scope.jqTabs = tabs;
                }
            }
        }
    ])
    .controller('tabController', ['$scope', function ($scope) {
        $scope.$watch("tab", function(){
            var index = $scope.tabs.indexOf($scope.tab);
            index++;
            $scope.jqTabs.tabs("option", "selected", index);
        })
    }]);
