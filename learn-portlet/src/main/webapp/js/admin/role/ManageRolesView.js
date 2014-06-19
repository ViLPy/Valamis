var ManageRolesDialog = Backbone.View.extend({
    events:{
        "click #addTeacher": "addNewTeacher",
        "click #removeTeacher": "removeTeacher",
        "click #addStudent": "addNewStudent",
        "click #removeStudent": "removeStudent"
    },
    callback:function (newGrade) {
    },
    initialize:function (options) {
        this.language = options.language;
        var renderedTemplate = Mustache.to_html(jQuery('#manageRolesTemplate').html(), this.language)
        this.$el.html(renderedTemplate);

        this.fetchRoles();
    },

    removeTeacher: function(){
        if (this.teacherTreeData.isSelected() && confirm(this.language['warningDeleteNodeMessageLabel'])) {
            this.teacherTreeData.drop();
        }
    },
    removeStudent: function(){
        if (this.studentTreeData.isSelected() && confirm(this.language['warningDeleteNodeMessageLabel'])) {
            this.studentTreeData.drop();
        }
    },

    addNewStudent: function(){
        this.trigger('clickAddStudent', this);

        window.RolesDialog.choose(Permissions.Student, this.studentTreeData.roles ,jQuery.proxy(function (roleID) {
            this.studentTreeData.createRoleMap(roleID, Permissions.Student).done(jQuery.proxy(function (role) {
                this.studentTreeData.addRole(role);
                this.addRoleSuccess();
            }, this)).error(jQuery.proxy(function (err) { this.addRoleError(); }, this));
        }, this));

    },

    addNewTeacher: function(){
        this.trigger('clickAddTeacher', this);

        window.RolesDialog.choose(Permissions.Teacher, this.teacherTreeData.roles ,jQuery.proxy(function (roleID) {
            this.addLiferayRole(roleID)
        }, this));

        //jQuery('#modalTemplateDiv').html(window.UsersDialog.render().el);
    },
    addLiferayRole: function (roleID) {
        this.teacherTreeData.createRoleMap(roleID, Permissions.Teacher).done(jQuery.proxy(function (role) {
            this.teacherTreeData.addRole(role);
            this.addRoleSuccess();
        }, this)).error(jQuery.proxy(function (err) { this.addRoleError(); }, this));
    },
    addRoleSuccess: function(){
//        jQuery('#projectLearnGeneric').unblock();
        jQuery.growlUI(this.language['overlayAddExternalMessageLabel'], this.language['overlayCompleteMessageLabel']);
    },
    addRoleError: function(){
//        jQuery('#projectLearnGeneric').unblock();
        jQuery.growlWarning(this.language['overlayAddExternalMessageLabel'], this.language['overlayFailedMessageLabel']);
    },

    fetchRoles: function(){
        var teacherTreeData = this.teacherTreeData = new RoleBankCollectionProxy();
        teacherTreeData.fetchRolesByPermission(Permissions.Teacher);

        var studentTreeData = this.studentTreeData = new RoleBankCollectionProxy();
        studentTreeData.fetchRolesByPermission(Permissions.Student);
    }
});