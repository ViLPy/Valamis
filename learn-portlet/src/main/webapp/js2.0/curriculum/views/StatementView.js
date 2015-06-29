StatementModel = Backbone.Model.extend({
  defaults: {
    language: '',
    verb: 'http://adlnet.gov/expapi/verbs/answered',
    verbName: 'answered',
    verbs: [
      { id: 'http://adlnet.gov/expapi/verbs/answered', title: 'answered'},
      { id: 'http://adlnet.gov/expapi/verbs/asked', title: 'asked' },
      { id: 'http://adlnet.gov/expapi/verbs/attempted', title: 'attempted' },
      { id: 'http://adlnet.gov/expapi/verbs/attended', title: 'attended' },
      { id: 'http://adlnet.gov/expapi/verbs/commented', title: 'commented'},
      { id: 'http://adlnet.gov/expapi/verbs/completed', title: 'completed'},
      { id: 'http://adlnet.gov/expapi/verbs/exited', title: 'exited' },
      { id: 'http://adlnet.gov/expapi/verbs/experienced', title: 'experienced' },
      { id: 'http://adlnet.gov/expapi/verbs/failed', title: 'failed'},
      { id: 'http://adlnet.gov/expapi/verbs/imported', title: 'imported'},
      { id: 'http://adlnet.gov/expapi/verbs/initialized', title: 'initialized'},
      { id: 'http://adlnet.gov/expapi/verbs/launched', title: 'launched'},
      { id: 'http://adlnet.gov/expapi/verbs/mastered', title: 'mastered'},
      { id: 'http://adlnet.gov/expapi/verbs/passed', title: 'passed'},
      { id: 'http://adlnet.gov/expapi/verbs/preferred', title: 'preferred'},
      { id: 'http://adlnet.gov/expapi/verbs/progressed', title: 'progressed'},
      { id: 'http://adlnet.gov/expapi/verbs/registered', title: 'registered'},
      { id: 'http://adlnet.gov/expapi/verbs/responded', title: 'responded'},
      { id: 'http://adlnet.gov/expapi/verbs/resumed', title: 'resumed'},
      { id: 'http://adlnet.gov/expapi/verbs/scored', title: 'scored'},
      { id: 'http://adlnet.gov/expapi/verbs/shared', title: 'shared'},
      { id: 'http://adlnet.gov/expapi/verbs/suspended', title: 'suspended'},
      { id: 'http://adlnet.gov/expapi/verbs/terminated', title: 'terminated'},
      { id: 'http://adlnet.gov/expapi/verbs/voided', title: 'voided'},
      { id: 'http://adlnet.gov/expapi/verbs/interacted', title: 'interacted'}
    ],
    obj: '',
    objName: '',
    selected: false
  },
  toggle: function(){
    if(this.get('selected')) {
      this.set('selected', false);
    }
    else {
      this.set('selected', true);
    }
  }
});

StatementCollectionService = new Backbone.Service({ url: path.root,
  targets: {
    'saveToCertificate': {
      'path': function (collection, options) {
        var stmnts = JSON.stringify( collection.map(function (item) {
          return {
            verb: item.get('verb'),
            obj: item.get('obj')
          };
        } ));

        return path.api.certificates + jQuery('#selectedCertificateID').val() + '?action=ADDTINCANSTMNTS&courseId=' + Utils.getCourseId() + '&tincanStmnts=' + stmnts;
      },
      method: 'post'
    }
  }
});

StatementCollection = Backbone.Collection.extend({
}).extend(StatementCollectionService);

var Plugin = Backbone.Model.extend({
    label: function () {
        var activity = new TinCan.Activity(this.toJSON());
        return activity + " ("+activity.id+")";
    }
});

var PluginCollection = Backbone.Collection.extend({
    model: Plugin
});




StatementListElement = Backbone.View.extend({
  events: {
    'click .js-statement-delete': 'deleteStatement',
    'click #verbSelection': 'setVerb',
    'keyup #objectSelection': 'setObject'
  },
  initialize: function (options) {
    this.language = options.language;
    this.$el = jQuery('<tr>');
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#statementElementView').html(),
      _.extend(this.model.toJSON(), this.language));
    this.$el.html(template);
      var plugins = new PluginCollection();
      plugins.url = path.root + path.api.activities + '?courseId=' + + Utils.getCourseId();

      new AutoCompleteView({
          input: this.$("#objectSelection"), // your input field
          model: plugins, // your collection
          queryParameter: "activity",
          onSelect: jQuery.proxy(function (model) {
              this.model.set({obj: model.id});
              this.$('#objectSelection').val(model.id);
          },this)
      }).render();
      this.$("#verbSelection [value='"+this.model.get('verb')+"']").attr("selected", "selected");
    return this;
  },
  setVerb: function () {
    this.model.set({verb: this.$('#verbSelection').val()});
  },
  setObject: function () {
    var obj = this.$('#objectSelection').val();
    if (obj.length > 3){

    }
    this.model.set({obj: this.$('#objectSelection').val()});
  },
  deleteStatement: function () {
    this.model.destroy();
    this.remove();
  }
});

StatementContainer = Backbone.View.extend({
  events: {
    'click .js-newStatement': 'newStatement',
    'click .js-addStatements': 'addStatements'
  },
  initialize: function (options) {
    this.language = options.language;
    this.collection = new StatementCollection();
    this.on('addStatements',this.selectStatements);
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#statementDialogView').html(), this.language);
    this.$el.html(template);
    this.newStatement();
    return this;
  },
  newStatement: function () {
    var model = new StatementModel();
    var view = new StatementListElement({ model: model, language: this.language });
    this.collection.add(model);
    this.$('#statementList').append(view.render().$el);
  },
  addStatements: function () {
    var that = this;
    this.collection.saveToCertificate({}).then(function (res) {
      that.trigCloseModal();
      toastr.success(that.language['overlayCompleteMessageLabel']);
    }, function (err, res) {
      that.trigCloseModal();
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },
  selectStatements: function (selectedItems) {
      this.collection.reset();
      this.$('#statementList').empty();
      selectedItems.forEach(jQuery.proxy(function (item){
          this.collection.add(item);
          var view = new StatementListElement({ model: item, language: this.language });
          this.$('#statementList').append(view.render().$el);
      },this));
  },

  trigCloseModal: function () {
    this.trigger('closeModal', this);
  }
});


