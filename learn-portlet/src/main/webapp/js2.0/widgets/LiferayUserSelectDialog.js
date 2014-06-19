LiferayUserModel = Backbone.Model.extend({
  defaults: {
    userID: '',
    name: '',
    selected: false
  }
});

LiferayUserCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'read': function (collection, options) {
      return  'api/certificates/' + jQuery('#selectedCertificateID').val() + '/users' +
        '?action=GETNOTCONTAINEDSTUDENTS' +
        '&orgId=' + jQuery('#userOrganization').val() +
        '&filter=' + jQuery('#userSearch').val() +
        '&sortBy=name' +
        '&sortAscDirection=' + jQuery('#sortUser').val() +
        '&page=' + options.currentPage +
        '&count=' + options.itemsOnPage;
    }
  },
  targets: {
    'saveToCertificate': {
      'path': function (model, options) {
        return 'api/certificates/' + jQuery('#selectedCertificateID').val() + '?action=ADDUSERS&' + options.users;    //userIDs=10963&userIDs=11019&userIDs=10956';
      },
      method: 'post'
    }
  }
});

LiferayUserCollection = Backbone.Collection.extend({
  model: LiferayUserModel,
  parse: function (response) {
    this.trigger('userCollection:updated', { total: response.total, currentPage: response.currentPage, listed: response.records.length });
    return response.records;
  }
}).extend(LiferayUserCollectionService);

// user element

LiferayUserListElement = Backbone.View.extend({
  events: {
    'click .toggleButton': 'toggleThis'
  },
  initialize: function () {
    this.$el = jQuery('<tr>');
    this.model.on('setSelected', this.setSelected, this);
    this.model.on('setUnselected', this.setUnselected, this);
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#liferayUserElementView').html(), this.model.toJSON());
    this.$el.html(template);
    return this.$el;
  },

  toggleThis: function () {
    this.model.trigger('unsetIsSelectedAll', this.model);
    var alreadySelected = this.model.get('selected');
    if (alreadySelected) {
      this.setUnselected();
    }
    else {
      this.setSelected();
    }
  },

  setSelected: function () {
    this.model.set({selected: true });
    this.$('.toggleButton').removeClass('grey');
    this.$('.toggleButton').addClass('green');
  },
  setUnselected: function () {
    this.model.set({selected: false });
    this.$('.toggleButton').removeClass('green');
    this.$('.toggleButton').addClass('grey');
  }
});

// user list

LiferayUserList = Backbone.View.extend({
  events: {
  },

  initialize: function (options) {
    this.language = options.language;
    this.collection = new LiferayUserCollection();

    this.collection.on('reset', this.showAll, this);
    this.collection.on('unsetIsSelectedAll', this.unsetIsSelectedAll, this);

    var that = this;
    this.collection.on('userCollection:updated', function (details) {
      that.updatePagination(details, that);
    });

    this.isSelectedAll = false;
  },

  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
    jQuery('#usersListedAmount').text(details.listed);
  },


  showAll: function () {
    this.$('#userList').empty();
    this.collection.each(this.showUser, this);
    if (this.collection.length > 0) {
      jQuery('#addUsersButton').show();
    } else {
      jQuery('#noUsersLabel').show();
    }
  },
  showUser: function (user) {
    var view = new LiferayUserListElement({model: user});
    var viewDOM = view.render();
    this.$('#userList').append(viewDOM);
  },


  addMembers: function () {
    var selectedUsers = this.collection.filter(function (item) {
      return item.get('selected');
    }).map(function (item) {
        return item.get('id');
      });

    var users = jQuery.param({'userIDs': selectedUsers}, true);
    var that = this;

    this.collection.saveToCertificate({}, {users: users}).then(function (res) {
      that.trigger('usersAdded', that);
      toastr.success(that.language['overlayCompleteMessageLabel']);
    }, function (err, res) {
      toastr.error(that.language['overlayFailedMessageLabel']);
    });
  },

  render: function () {
    var renderedTemplate = Mustache.to_html(jQuery('#liferayUserListView').html(), this.language)
    this.$el.html(renderedTemplate);

    var that = this;
    this.paginator = new ValamisPaginator({el: jQuery('#availableUserListPaginator'), language: this.language});
    this.paginator.on('pageChanged', function () {
      that.reload();
    });

    this.reloadFirstPage();

    return this.$el;
  },

  reloadFirstPage: function () {
    jQuery('#addUsersButton').hide();
    jQuery('#noUsersLabel').hide();
    this.collection.fetch({reset: true, currentPage: 1, itemsOnPage: this.paginator.itemsOnPage()});
  },
  reload: function () {
    this.collection.fetch({reset: true, currentPage: this.paginator.currentPage(), itemsOnPage: this.paginator.itemsOnPage()});
  },

  selectAll: function () {
    this.isSelectedAll = !this.isSelectedAll;
    this.collection.each(this.setSelectAll, this);
  },
  setSelectAll: function (model) {
    var alreadySelected = model.get('selected');
    if (alreadySelected != this.isSelectedAll) {
      if (alreadySelected) {
        model.trigger('setUnselected', this);
      }
      else {
        model.trigger('setSelected', this);
      }

    }
  },
  unsetIsSelectedAll: function () {
    this.isSelectedAll = false;
  }

});

// user dialog

LiferayUserSelectDialog = Backbone.View.extend({
  events: {
    'click #addUsersButton': 'addAllMembers',
    'keyup #userSearch': 'filterUsers',
    'change #sortUser': 'filterUsers',
    'change #userOrganization': 'filterUsers',
    'click .menu-toggle': 'searchMenuToggle',
    'click #selectAllAvailableUsers': 'selectAllUsers'
  },
  callback: function (userID, name) {
  },
  initialize: function (options) {
    this.$el = jQuery('<div>');
    this.language = options.language;

    this.organizations = new LiferayOrganizationCollection();
    this.organizations.on('reset', this.showDefaultView, this);

    this.inputTimeout = null;
  },
  render: function () {
    var renderedTemplate = Mustache.to_html(jQuery('#liferayUserDialogView').html(), this.language);
    this.$el.html(renderedTemplate);

    this.userListView = new LiferayUserList({el: this.$('#allUsersList'), language: this.language});
    this.userListView.on('usersAdded', this.trigCloseModal, this);

    this.organizations.fetch({reset: true});

    return this;
  },

  trigCloseModal: function () {
    this.trigger('closeModal', this)
  },

  showDefaultView: function () {
    this.organizations.each(this.appendOptions, this);
    this.userListView.render();
  },

  appendOptions: function (item) {
    jQuery('#userOrganization').append('<option value="' + item.id + '"> ' + item.get('name') + ' </option>');
  },

  filterUsers: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);
    this.userListView.reloadFirstPage();
  },

  addAllMembers: function () {
    this.userListView.addMembers();
  },

  searchMenuToggle: function (e) {
    e.preventDefault();
    this.$('#liferayUserDialog').toggleClass('active');
  },

  selectAllUsers: function () {
    this.userListView.selectAll();
  }
});