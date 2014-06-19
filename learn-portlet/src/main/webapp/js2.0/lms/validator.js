var CMIValidator = (function () {
    // TODO: implement validators for rw|w variables

    // String
    this.String250 = function (value) {
        return (value.length <= 250);
    };

    this.String1000 = function (value) {
        return (value.length <= 1000);
    };

    this.String64000 = function (value) {
        return (value.length <= 64000);
    };

    this.LocalizedString250 = function (value) {
        return value == value;
    };

    this.LocalizedString4000 = function (value) {
        return value == value;
    };

    // Numeric
    this.Integer = function (value) {
        return value = value;
    };

    this.Decimal = function (value) {
        return value == value;
    };

    this.LongIdentifier = function (value) {
        return value == value;
    };

    // Time/Date
    this.Timespan = function (value) {
        return value == value;
    };

    this.Time = function (value) {
        return value == value;
    };

    // Misc
    this.Type = function (value) {
        return value == value;
    };

    this.Lang = function (value) {
        return (value.match(/\{lang=([a-zA-Z]{2,3})?(-[a-zA-Z]{2,8})?\}/gi) != null);
    };

    this.State = function (value) {
        return value == value;
    };

    this.Exit = function (value) {
        return "time-out,suspend,logout,normal".indexOf(value) != -1;
    };

    this.Result = function (value) {
        return value == value;
    };

    this.CStatus = function (value) {
        return value == value;
    };

    this.SStatus = function (value) {
        return value == value;
    };

    function CMIValidator() {
    };

    return CMIValidator
})();