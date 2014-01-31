app.directive('openDialog', function(){
    return {
        restrict: 'A',
        link: function(scope, elem, attr, ctrl) {
            var dialogId = '#' + attr.openDialog;
            var config = scope[attr.openDialogConfig];

            elem.bind('click', function(e) {
                jQuery1816Curriculum(dialogId).dialog(config);
            });
        }
    };
});