CertificateMemberModelService = new Backbone.Service({ url: path.root,
  sync: {
    'delete': {
      'path': function (model) {
        return path.api.certificates + jQuery('#selectedCertificateID').val()
      },
      'data': function (model) {
        return {
            action: 'DELETEUSERS',
            courseId: Utils.getCourseId(),
            userIDs: model.id

        }
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
  },
  toggle: function(){
    if(this.get("selected"))
      this.set("selected", false);
    else
      this.set("selected", true);
  }
}).extend(CertificateMemberModelService);

CertificateMemberCollectionService = new Backbone.Service({ url: path.root,
  sync: {
    'read': {
      'path': function (collection, options) {
        return path.api.certificates + jQuery('#selectedCertificateID').val() + '/users';
      },
      'data': function (collection, options) {
        var order = options.order;
        var sortBy = order.split(':')[0];
        var asc = order.split(':')[1];
        return {
          action: 'GETSTUDENTS',
          orgId: options.orgId,
          courseId: Utils.getCourseId(),
          sortBy: sortBy,
          sortAscDirection: asc,
          filter: options.filter,
          page: options.currentPage,
          count: options.itemsOnPage
        }
      },
      'method': 'get'
    }
  },
  targets: {
    'deleteFromCertificate': {
      'path': function(model, options){
       return path.api.certificates + jQuery('#selectedCertificateID').val();
      },
      'data': function (model, options) {
        var params =  {
            action: 'DELETEUSERS',
            courseId: Utils.getCourseId()
        }
        _.extend(params, options.users);
        return params;

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
    return arr;
  }
}).extend(CertificateMemberCollectionService);

// member element

var CertificateMemberListElement = Backbone.View.extend({
  events: {
    'change .js-toggle-member': 'toggleThis',
    'click .js-member-delete': 'deleteMember',
    'click .js-member-details': 'viewDetails'

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
      { status: this.language[this.model.get('status')] },
      this.model.toJSON(),
      this.language,
      permissionActionsCurriculum
      ));
    this.$el.html(template);
    return this.$el;
  },

  deleteMember: function () {
    this.model.trigger('changeAmount', this.model);
    this.model.destroy();
    this.remove();
  },

  viewDetails: function() {
    this.trigger('viewMemberDetails', this.model.id);
  },

  toggleThis: function () {
    this.model.trigger('unsetIsSelectedAll', this.model);
    this.model.toggle();
  }
});

var CertificateEditMembersDialog = Backbone.View.extend({
  SEARCH_TIMEOUT: 800,
  events: {
    'keyup #searchMembers': 'filterMembers',
    'click .dropdown-menu > li': 'filterMembers',
    'click .js-saveCloseCertificate': 'saveClose',

    'click #selectAllMembers': 'selectAll',
    'click .js-deleteMembers': 'deleteSelectedMembers'
  },

  initialize: function (options) {
    this.language = options.language;
    this.organizations = new LiferayOrganizationCollection();
    this.organizations.on('reset', this.appendOrganizations, this);
    this.inputTimeout = null;

    this.paginatorModel = new PageModel();
    this.paginatorModel.set({'itemsOnPage': 10});
    this.collection = new CertificateMemberCollection();
    this.collection.on('reset', this.showAll, this);
    this.collection.on('unsetIsSelectedAll', this.unsetIsSelectedAll, this);

    var that = this;
    this.collection.on('userCollection:updated', function (details) {
      that.updatePagination(details, that);
    });

    this.isSelectedAll = false;
  },
  render: function () {
    var data = _.extend(this.language, permissionActionsCurriculum);
    var renderedTemplate = Mustache.to_html(jQuery('#certificateItemEditMembers').html(), data);
    this.$el.html(renderedTemplate);

    this.organizations.fetch({reset: true});

    var that = this;
    this.paginator = new ValamisPaginator({
      el: this.$el.find("#memberListPaginator"),
      language: this.language,
      model: this.paginatorModel
    });
    this.paginator.on('pageChanged', function () {
      that.reload();
    });
    this.paginatorShowing = new ValamisPaginatorShowing({
      el: this.$el.find("#memberListPagingShowing"),
      language: this.language,
      model: this.paginator.model
    });

    this.reloadFirstPage();
  },

  appendOrganizations: function () {
    this.organizations.each(function(item) {
      this.$('#memberOrganization .dropdown-menu').append('<li data-value="' + item.id + '"> ' + item.get('name') + ' </li>');
    }, this);
    this.$('.dropdown').valamisDropDown();
  },

  filterMembers: function () {
    clearTimeout(this.inputTimeout);
    this.inputTimeout = setTimeout(this.applyFilter.bind(this), this.SEARCH_TIMEOUT);
  },
  applyFilter: function () {
    clearTimeout(this.inputTimeout);
    this.reloadFirstPage();
  },

  saveClose: function () {
    this.trigger('closeCertificate', this);
  },

  updatePagination: function (details, context) {
    this.paginator.updateItems(details.total);
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
    view.on('viewMemberDetails', this.viewDetails, this);
    var viewDOM = view.render();
    this.$('#membersList').append(viewDOM);
  },

  viewDetails: function(id) {
    this.trigger('viewMemberDetails', id);
  },

  reloadFirstPage: function () {
    jQuery('#noMembersLabel').hide();
    this.fetchCollection(1);
  },
  reload: function () {
    this.fetchCollection(this.paginator.currentPage());
  },
  fetchCollection: function (page) {
    this.collection.fetch({
      reset: true,
      currentPage: page,
      itemsOnPage: this.paginator.itemsOnPage(),
      filter: this.$('#searchMembers').val(),
      orgId: this.$('#memberOrganization').data('value'),
      order: this.$('#sortMembers').data('value')
    });
  },

  selectAll: function () {
    this.isSelectedAll = !this.isSelectedAll;
    this.collection.each(this.setSelectAll, this);
  },
  setSelectAll: function (model) {
    var alreadySelected = model.get('selected');

    if (alreadySelected != this.isSelectedAll) {
      model.set('selected', this.isSelectedAll);
      this.$('#toggleMember_' + model.id).prop('checked', model.get('selected'));
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
        toastr.success(that.language['overlayCompleteMessageLabel']);
      }, function (err, res) {
        toastr.error(that.language['overlayFailedMessageLabel']);
      });
    }
  }
});