/**
 * Created by iliya.tryapitsin on 29.01.14.
 */

var set = function (path, value, root) {
    var segments = path.split('.'),
        cursor = root || window,
        segment,
        i;

    for (i = 0; i < segments.length - 1; ++i) {
        segment = segments[i];
        cursor = cursor[segment] = cursor[segment] || {};
    }

    return cursor[segments[i]] = value;
};

app.directive('jqDatePicker', function () {
    return {
        restrict: 'A',
        link: function (scope, elem, attrs) {
            jQuery1816Curriculum(elem).datepicker();
            jQuery1816Curriculum(elem).datepicker("setDate", new Date(eval('scope.' + attrs.jqDatePicker)));
            jQuery1816Curriculum(elem).change(function(){
                set(attrs.jqDatePicker, Date.parse(jQuery1816Curriculum(elem).val()), scope);
                // TODO remove from this
                if(scope.startDateChanged)
                    scope.startDateChanged()
            })
        }
    };
});