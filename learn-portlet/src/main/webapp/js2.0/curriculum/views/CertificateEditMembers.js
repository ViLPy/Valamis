CertificateMemberModelService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'delete': {
      'path': function (model) {
        return 'api/certificates/' + jQuery('#selectedCertificateID').val() + '?action=DELETEUSERS' +
          '&userIDs=' + model.id;
      },
      'method': 'post'
    }
  }
});

CertificateMemberModel = Backbone.Model.extend({
  defaults: {
    memberId: '',
    name: '',
    selected: false
  }
}).extend(CertificateMemberModelService);

CertificateMemberCollectionService = new Backbone.Service({ url: Utils.getContextPath,
  sync: {
    'read': function (collection, options) {
      return 'api/certificates/' + jQuery('#selectedCertificateID').val() +
        '/users?action=GETSTUDENTS' +
        '&orgId=' + jQuery('#memberOrganization').val() +
        '&sortBy=' + options.sort[0] +
        '&sortAscDirection=' + options.sort[1] +
        '&filter=' + jQuery('#memberSearch').val() +
        '&page=' + options.currentPage + '&count=' + options.itemsOnPage;
    }
  },
  targets: {
    'deleteFromCertificate': {
      'path': function (model, options) {
        return 'api/certificates/' + jQuery('#selectedCertificateID').val() + '?action=DELETEUSERS&' + options.users;
      },
      method: 'post'
    }
  }
});

CertificateMemberCollection = Backbone.Collection.extend({
  model: CertificateMemberModel,
  parse: function (response) {
    var arr = [];
      jQuery1816Curriculum.map(response.records, function(item) {
          for (var key in item) {
              if (item.hasOwnProperty(key)) {
                  item[key].joinedDate = new Date(key);
                  arr.push(item[key]);
              }
          }
      });

    this.trigger('userCollection:updated', { total: response.total, currentPage: response.currentPage, listed: arr.length });
    console.log(arr);
    return arr;
  }
}).extend(CertificateMemberCollectionService);

// member element

var CertificateMemberListElement = Backbone.View.extend({
  events: {
    'click #selectMemberCheckbox': 'selectThis',
    'click .val-icon-delete': 'deleteMember'
  },
  initialize: function (options) {
    this.language = options.language;
    this.$el = jQuery('<tr>');
    this.model.on('setSelected', this.setSelected, this);
    this.model.on('setUnselected', this.setUnselected, this);
    this.model.on('deleteItem', this.deleteMember, this);
  },
  render: function () {
    var template = Mustache.to_html(jQuery('#certificateMemberElementView').html(), _.extend(
      this.model.toJSON(),
      this.language,
      {status: this.language[this.model.get('status')]}));
    this.$el.html(template);
    return this.$el;
  },

  deleteMember: function () {
    this.model.trigger('changeAmount', this.model);
    this.model.destroy();
    this.remove();
  },

  selectThis: function () {
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
    this.$('#selectMemberCheckbox').addClass('checked');
  },
  setUnselected: function () {
    this.model.set({selected: false });
    this.$('#selectMemberCheckbox').removeClass('checked');
  }

});

// member list view

var MemberList = Backbone.View.extend({
  events: {
    'click .menu-toggle': 'searchActionMenuToggle',
    'click .dropdown-button': 'toggleAction',
    'click #selectAllMembers': 'selectAll',
    'click .deleteMembers': 'deleteSelectedMembers'
  },

  initialize: function (options) {
    this.language = options.language;
    this.collection = new CertificateMemberCollection();

    this.collection.on('reset', this.showAll, this);
    this.collection.on('unsetIsSelectedAll', this.unsetIsSelectedAll, this);
    this.collection.on('changeAmount', function () {
      jQuery('#membersListedAmount').text(this.collection.length - 1);
    }, this);

    var that = this;
    this.collection.on('userCollection:updated', function (details) {
      that.updatePagination(details, that);
    });

    this.isSelectedAll = false;

    this.render();
  },

  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
    jQuery('#membersListedAmount').text(details.listed);
  },

  showAll: function () {
    this.$('#membersList').empty();
    if (this.collection.length > 0) {
      jQuery('#noMembersLabel').hide();
      this.collection.each(this.showUser, this);
    } else {
      jQuery('#noMembersLabel').show();
    }
  },
  showUser: function (user) {
    var view = new CertificateMemberListElement({model: user, language: this.language});
    var viewDOM = view.render();
    this.$('#membersList').append(viewDOM);
  },

  render: function () {
    var renderedTemplate = Mustache.to_html(jQuery('#certificateMembersListView').html(), this.language);
    this.$el.html(renderedTemplate);

    var that = this;
    this.paginator = new ValamisPaginator({el: jQuery('#memberListPaginator'), language: this.language});
    this.paginator.on('pageChanged', function () {
      that.reload();
    });

    return this.$el;
  },

  reloadFirstPage: function () {
    jQuery('#noMembersLabel').hide();
    var sort = jQuery('#sortMembers').val().split(':');
    this.collection.fetch({reset: true, currentPage: 1, itemsOnPage: this.paginator.itemsOnPage(), sort: sort});
  },
  reload: function () {
    var sort = jQuery('#sortMembers').val().split(':');
    this.collection.fetch({reset: true, currentPage: this.paginator.currentPage(), itemsOnPage: this.paginator.itemsOnPage(), sort: sort});
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
  },

  deleteSelectedMembers: function () {
    var selectedUsers = this.collection.filter(function (item) {
      return item.get('selected');
    }).map(function (item) {
        return item.get('id');
      });

    var users = jQuery.param({'userIDs': selectedUsers}, true);
    if (users.length > 0) {
      var that = this;
      this.collection.deleteFromCertificate({}, {users: users}).then(function (res) {
        that.reload();
        that.toggleAction();
        toastr.success(that.language['overlayCompleteMessageLabel']);
      }, function (err, res) {
        toastr.error(that.language['overlayFailedMessageLabel']);
      });
    }
  },

  toggleAction: function () {
    this.$('.dropdown-button').toggleClass('active');
    this.$('.dropdown-button-menu').toggleClass('dropdown-visible');
  },
  searchActionMenuToggle: function (e) {
    e.preventDefault();
    this.$('.popup-sidebar').toggleClass('hidden-xs');
  }

});


// member dialog

var CertificateEditMembersDialog = Backbone.View.extend({
  events: {
    'keyup #memberSearch': 'filterMembers',
    'change #sortMembers': 'filterMembers',
    'change #memberOrganization': 'filterMembers',
    'click .saveCloseCertificate': 'saveClose',
    'click .menu-toggle': 'searchMenuToggle'
  },

  initialize: function (options) {
    this.$el = jQuery('<div>');
    this.language = options.language;

    this.organizations = new LiferayOrganizationCollection();
    this.organizations.on('reset', this.showDefaultView, this);

    this.inputTimeout = null;
  },
  render: function () {
    var renderedTemplate = Mustache.to_html(jQuery('#certificateItemEditMembers').html(), this.language);
    this.$el.html(renderedTemplate);

    this.memberListView = new MemberList({el: this.$('#allMembersList'), language: this.language});

    this.organizations.fetch({reset: true});

    return this;
  },

  reload: function(){
    this.memberListView.reloadFirstPage();
  },

  showDefaultView: function () {
    this.organizations.each(this.appendOptions, this);
    this.memberListView.reloadFirstPage();
  },

  appendOptions: function (item) {
    jQuery('#memberOrganization').append('<option value="' + item.id + '"> ' + item.get('name') + ' </option>');
  },

  filterMembers: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), 800);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);

    this.memberListView.reloadFirstPage();
  },

  saveClose: function () {
    this.trigger('closeCertificate', this);
  },

  searchMenuToggle: function (e) {
    e.preventDefault();
    this.$('#editMembersDialog').toggleClass('active');
  }
});