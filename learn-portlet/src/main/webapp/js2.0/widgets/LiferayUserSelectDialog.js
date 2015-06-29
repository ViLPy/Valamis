LiferayUserModel = Backbone.Model.extend({
  defaults: {
    userID: '',
    name: '',
    selected: false
  },
  toggle: function(){
    if(this.get('selected')) {
      this.set('selected', false);
      this.trigger('setUnselected', this);
    }
    else {
      this.set('selected', true);
      this.trigger('setSelected', this);
    }
  }
});

LiferayUserCollectionService = new Backbone.Service({ url: '/',
  sync: {
     'read': {
       'path': function (collection, options) {
         if (options.getAllUsers){
           return path.api.users;
         }
         else {
           return path.api.certificates + jQuery('#selectedCertificateID').val() + '/users';
         }
       },
       'data': function (collection, options) {
         var order = options.order;
         var sortBy = order.split(':')[0];
         var asc = order.split(':')[1];

         if (options.getAllUsers)
           return {
             orgId: options.orgId,
             courseId: Utils.getCourseId(),
             filter: options.filter,
             sortBy: sortBy,
             sortAscDirection: asc,
             page: options.currentPage,
             count: options.itemsOnPage
           }
         else
           return {
             action: 'GETNOTCONTAINEDSTUDENTS',
             courseId: Utils.getCourseId(),
             orgId: options.orgId,
             filter: options.filter,
             sortBy: sortBy,
             sortAscDirection: asc,
             page: options.currentPage,
             count: options.itemsOnPage
           }

       },
       'method': 'get'
     }
  },
  targets: {
    saveToCertificate: {
      path: function (model, options) {
        return path.api.certificates + jQuery('#selectedCertificateID').val();
      },
      'data' : function(model, options){
        var params = {
          action: 'ADDUSERS',
          courseId:  Utils.getCourseId(),
          userIDs : options.users
        };

        return params;
      },
      method: 'post'
    }
  }
});

LiferayUserCollection = Backbone.Collection.extend({
  initialize: function(){
    this.modelsToSelect = [];

    var that = this;
    this.on('sync', function(collection){
      collection.each(function(model){
        model.on('setSelected', that.addModelToSelectedModels, that);
        model.on('setUnselected', that.removeModelFromSelectedModels, that);
      });
    });
  },
  addModelToSelectedModels: function(model){
    if(!_.contains(this.modelsToSelect,model)) this.modelsToSelect.push(model.id);
  },
  removeModelFromSelectedModels: function(model){
    var index = this.modelsToSelect.indexOf(model.id);
    if(index > -1) this.modelsToSelect.splice(index, 1);
  },
  model: LiferayUserModel,
  parse: function (response) {
    this.trigger('userCollection:updated', { total: response.total, currentPage: response.currentPage, listed: response.records.length });

    var that = this;
    _.forEach(response.records, function(record){
      if(_.contains(that.modelsToSelect, record.id)) record.selected = true;
    });

    return response.records;
  }
}).extend(LiferayUserCollectionService);

LiferayUserListElement = Backbone.View.extend({
  events: {
    'click .js-toggle-user': 'toggleThis'
  },
  initialize: function (options) {
    this.$el = jQuery('<tr>');
    if(typeof options.getAllUsers !== null && options.getAllUsers !== 'undefined')
      this.getAllUsers = options.getAllUsers;
    else
      this.getAllUsers = false;
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferayUserElementView').html(), this.model.toJSON());
    this.$el.html(template);
    return this.$el;
  },

  toggleThis: function () {
    if (this.getAllUsers)
      this.trigger('lfUserSelected', this.model);
    else {
      this.model.trigger('unsetIsSelectedAll', this.model);
      this.model.toggle();
      this.$('.js-toggle-user').toggleClass('neutral', !this.model.get('selected'));
      this.$('.js-toggle-user').toggleClass('primary', this.model.get('selected'));
    }
  }
});

LiferayUserSelectDialog = Backbone.View.extend({
  SEARCH_TIMEOUT: 800,
  events: {
    'click .js-addUsers': 'addUsers',
    'keyup #searchUsers': 'filterUsers',
    'click .dropdown-menu > li': 'filterUsers',
    'click #selectAllUsers': 'selectAll'
  },
  callback: function (userID, name) {
  },
  initialize: function (options) {
    this.language = options.language;
    if(typeof options.getAllUsers !== null && options.getAllUsers !== 'undefined')
        this.getAllUsers = options.getAllUsers;
    else
        this.getAllUsers = false;

    this.organizations = new LiferayOrganizationCollection();
    this.organizations.on('reset', this.appendOrganizations, this);

    this.paginatorModel = new PageModel();
    this.paginatorModel.set({'itemsOnPage': 10});

    this.inputTimeout = null;

    this.collection = new LiferayUserCollection({getAllUsers: this.getAllUsers});

    this.collection.on('reset', this.showAll, this);
    this.collection.on('unsetIsSelectedAll', this.unsetIsSelectedAll, this);

    var that = this;
    this.collection.on('userCollection:updated', function (details) {
      that.updatePagination(details, that);
    });

    this.isSelectedAll = false;
  },
  render: function () {
    var renderedTemplate = Mustache.to_html(jQuery('#liferayUserDialogView').html(), _.extend({getAllUsers: this.getAllUsers}, this.language));
    this.$el.html(renderedTemplate);

    this.organizations.fetch({reset: true});

    var that = this;
    this.paginator = new ValamisPaginator({
      el: this.$el.find('#userListPaginator'),
      language: this.language,
      model: this.paginatorModel
    });
    this.paginator.on('pageChanged', function () {
      that.reload();
    });
    this.paginatorShowing = new ValamisPaginatorShowing({
      el: this.$el.find('#userListPagingShowing'),
      language: this.language,
      model: this.paginator.model
    });

    this.reloadFirstPage();

    return this;
  },

  appendOrganizations: function () {
    this.organizations.each(function(item) {
      this.$('#userOrganization .dropdown-menu').append('<li data-value="' + item.id + '"> ' + item.get('name') + ' </li>');
    }, this);
    this.$('.dropdown').valamisDropDown();
  },

  filterUsers: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), this.SEARCH_TIMEOUT);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);
    this.reloadFirstPage();
  },

  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
  },

  showAll: function () {
    this.$('#userList').empty();
    this.collection.each(this.showUser, this);
    if (this.collection.length > 0) {
      this.$('.js-addUsers').show();
    } else {
      this.$('#noUsersLabel').show();
    }
  },
  showUser: function (user) {
    var view = new LiferayUserListElement({model: user, getAllUsers: this.getAllUsers});
    var viewDOM = view.render();
    this.$('#userList').append(viewDOM);
    view.on('lfUserSelected', function (item) {
      this.trigger('lfUserSelected', item);
    }, this);
  },

  addUsers: function () {
    var selectedUsers = this.collection.modelsToSelect;

    var that = this;

    this.collection.saveToCertificate({}, { users  : selectedUsers}).then(function (res) {
      that.trigger('closeModal');
      toastr.success(that.language['overlayCompleteMessageLabel']);
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },

  reloadFirstPage: function () {
    jQuery('.js-addUsers').hide();
    jQuery('#noUsersLabel').hide();
    this.fetchCollection(1);
  },
  reload: function () {
    this.fetchCollection(this.paginator.currentPage());
  },
  fetchCollection: function (page) {
    this.collection.fetch({
      reset: true,
      currentPage: page,
      getAllUsers: this.getAllUsers,
      itemsOnPage: this.paginator.itemsOnPage(),
      filter: this.$('#searchUsers').val(),
      orgId: this.$('#userOrganization').data('value'),
      order: this.$('#sortUsers').data('value')
    });
  },

  selectAll: function () {
    this.isSelectedAll = !this.isSelectedAll;
    this.collection.each(this.setSelectAll, this);
  },
  setSelectAll: function (model) {
    var alreadySelected = model.get('selected');

    if (alreadySelected != this.isSelectedAll) {
      model.toggle();
      this.$('#toggleUser_' + model.id).toggleClass('neutral', !model.get('selected'));
      this.$('#toggleUser_' + model.id).toggleClass('primary', model.get('selected'));
    }
  },
  unsetIsSelectedAll: function () {
    this.isSelectedAll = false;
  }
});