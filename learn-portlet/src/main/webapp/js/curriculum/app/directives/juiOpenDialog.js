app.directive('openDialog', function(){
    return {
        restrict: 'A',
        link: function(scope, elem, attr, ctrl) {
            var dialogId = '#' + attr.openDialog;
            elem.bind('click', function(e) {
                jQuery1816Curriculum(dialogId).dialog();
            });
        }
    };
});