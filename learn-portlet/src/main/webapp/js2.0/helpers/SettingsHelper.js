var SettingsHelper = Backbone.Model.extend({
  initialize: function(options){
    this.url = options.url;
    this.portlet = options.portlet;
  },
  save: function() {
    if (window.localStorage && JSON.stringify) {
      localStorage.setItem(this.portlet + '_' + this.url, JSON.stringify(this.toJSON()))
    }
  },
  fetch: function() {
    if (window.localStorage && JSON.parse) {
      var data = localStorage.getItem(this.portlet + '_' + this.url);
      this.set(JSON.parse(data));
    }
  }
});