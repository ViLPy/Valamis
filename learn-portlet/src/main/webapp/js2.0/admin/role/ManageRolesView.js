var ManageRolesDialog = Backbone.View.extend({
  events: {
    'click #addTeacher': 'addNewTeacher',
    'click #addStudent': 'addNewStudent'
  },
  callback: function (newGrade) {
  },
  initialize: function (options) {
    this.language = options.language;
    var renderedTemplate = Mustache.to_html(jQuery('#manageRolesTemplate').html(), this.language)
    this.$el.html(renderedTemplate);

    this.fetchRoles();
  },

  addNewStudent: function () {
    this.trigger('clickAddStudent', this);

    window.RolesDialog.choose(Permissions.Student, this.studentTreeData.roles, jQuery.proxy(function (roleID) {
      this.studentTreeData.createRoleMap(roleID, Permissions.Student).done(jQuery.proxy(function (role) {
          this.studentTreeData.addRole(role);
          this.addRoleSuccess();
        }, this)).error(jQuery.proxy(function (err) {
          this.addRoleError();
        }, this));
    }, this));

  },

  addNewTeacher: function () {
    this.trigger('clickAddTeacher', this);

    window.RolesDialog.choose(Permissions.Teacher, this.teacherTreeData.roles, jQuery.proxy(function (roleID) {
      this.addLiferayRole(roleID)
    }, this));
  },
  addLiferayRole: function (roleID) {
    this.teacherTreeData.createRoleMap(roleID, Permissions.Teacher).done(jQuery.proxy(function (role) {
        this.teacherTreeData.addRole(role);
        this.addRoleSuccess();
      }, this)).error(jQuery.proxy(function (err) {
        this.addRoleError();
      }, this));
  },
  addRoleSuccess: function () {
    this.trigger('modalClose', this);
    toastr.success(this.language['overlayCompleteMessageLabel']);
  },
  addRoleError: function () {
    this.trigger('modalClose', this);
    toastr.error(this.language['overlayFailedMessageLabel']);
  },

  fetchRoles: function () {
    var teacherTreeData = this.teacherTreeData = new RoleBankCollectionProxy();
    teacherTreeData.fetchRolesByPermission(Permissions.Teacher);

    var studentTreeData = this.studentTreeData = new RoleBankCollectionProxy();
    studentTreeData.fetchRolesByPermission(Permissions.Student);
  }
});