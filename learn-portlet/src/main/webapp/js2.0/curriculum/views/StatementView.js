StatementModel = Backbone.Model.extend({
  defaults: {
    language: '',
    verb: 'http://adlnet.gov/expapi/verbs/answered',
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
    object: ''
  }
});

StatementCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  targets: {
    'saveToCertificate': {
      'path': function (model, options) {
        return 'api/certificates/' + jQuery('#selectedCertificateID').val() + '?action=ADDTINCANSTMNT' +
          '&tincanStmntVerb=' + options.verb +
          '&tincanStmntObj=' + options.obj +
          '&periodValue=0';
      },
      method: 'post'
    }

//  sync: {
//    'create': {
//      'path': function () {
//        return 'services/certificating/?action=ADD&companyID=' + jQuery('#curriculumCompanyID').val();
//      },
//      'method': 'post'
//    }

  }
});

StatementCollection = Backbone.Collection.extend({
}).extend(StatementCollectionService);


StatementListElement = Backbone.View.extend({
  events: {
    'click .val-icon-delete': 'deleteStatement',
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
    return this;
  },
  setVerb: function () {
    this.model.set({verb: this.$('#verbSelection').val()});
  },
  setObject: function () {
    this.model.set({object: this.$('#objectSelection').val()});
  },
  deleteStatement: function () {
    this.model.destroy();
    this.remove();
  }
});

StatementContainer = Backbone.View.extend({
  events: {
    'click .newStatement': 'newStatement',
    'click .addStatements': 'addStatements'
  },
  initialize: function (options) {
    this.language = options.language;
    this.collection = new StatementCollection();
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
    this.collection.each(this.addOne, this);
  },
  addOne: function (model) {
    var that = this;
    this.collection.saveToCertificate({}, {verb: model.get('verb'), obj: model.get('object')}).then(function (res) {
      that.trigCloseModal();
      toastr.success(that.language['overlayCompleteMessageLabel']);
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },
  trigCloseModal: function () {
    this.trigger('closeModal', this)
  }
});


