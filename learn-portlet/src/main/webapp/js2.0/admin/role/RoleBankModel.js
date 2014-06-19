RoleBankCollectionProxy = Backbone.Collection.extend({
  initialize: function () {
    var Roles = Backbone.Collection.extend({
      model: RoleModel
    });

    this.roles = new Roles();
    this.roles.on('delete-role', this.drop, this);

    this.permission = '';
    this.activePackageView = null;
  },

  addRole: function (entity) {
    var entityModel = new RoleModel(entity)
    var view = new RoleView({model: entityModel});
    view.on('change-isDefault', this.changeIsDefault, this);
    var renderedView = view.render();

    if (this.permission == Permissions.Teacher) jQuery('#teacherRoleList').append(renderedView);
    else jQuery('#studentRoleList').append(renderedView);

    this.roles.add(entityModel);
  },

  changeIsDefault: function (id) {
    this.checkedId = id;
    this.roles.each(this.uncheckDefaults, this)
  },

  uncheckDefaults: function (item) {
    if (item.id != this.checkedId) {
      jQuery('tr[id="' + item.id + '"]>td>#isDefaultRole').attr('checked', false);
    }
  },

  addRoles: function (roles) {
    _.each(roles, this.addRole, this);
  },

  createRoleMap: function (roleID, permission) {
    return window.LearnAjax.post(Utils.getContextPath() + 'api/roles/', {'action': 'ADD', 'liferayRoleID': roleID, 'permission': permission});
  },

  drop: function (model) {
    jQuery('tr[id=' + model.id + ']').remove();
    this.roles.remove(model);
    model.destroy();
  },

  fetchRolesByPermission: function (permission) {
    this.permission = permission;
    jQuery.when(this.getRolesList(permission))
      .done(jQuery.proxy(function (roles) {
        this.addRoles(roles);
      }, this));
  },
  getRolesList: function (permission) {
    return window.LearnAjax.get(Utils.getContextPath() + 'api/roles/' + permission);
  }
});


RoleView = Backbone.View.extend({
  events: {
    'click #isDefaultRole': 'updateDefault',
    'click #removeRole': 'removeRole'
  },

  initialize: function () {
    this.$el = jQuery('<tr>');
    this.$el.attr('id', this.model.id);
  },

  updateDefault: function () {
    this.model.save({
      isDefault: this.$('#isDefaultRole').is(':checked')
    });
    this.trigger('change-isDefault', this.model.id);
  },

  render: function () {
    var template = Mustache.to_html(jQuery('#roleItemTemplate').html(), this.model.toJSON());
    this.$el.html(template);
    return this.$el;
  },

  removeRole: function () {
    this.model.trigger('delete-role', this.model);
  }
});
