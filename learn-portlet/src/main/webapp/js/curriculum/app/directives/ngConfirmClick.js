app.directive('ngConfirmClick', [
    function(){
        return {
            priority: 100,
            restrict: 'A',
            link: {
                pre: function(scope, element, attrs){
                    element.bind('click', function(e){
                        var message = attrs.ngConfirmClick;
                        if(message && !confirm(message)){
                            e.stopImmediatePropagation();
                            e.preventDefault();
                        }
                    });
                }
            }
        }
    }
]);
