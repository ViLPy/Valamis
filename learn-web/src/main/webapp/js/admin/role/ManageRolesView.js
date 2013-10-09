ManageRolesDialog = Backbone.View.extend({
    events:{
        "click #addTeacher": "addNewTeacher",
        "click #removeTeacher": "removeTeacher",
        "click #addStudent": "addNewStudent",
        "click #removeStudent": "removeStudent"
    },
    callback:function (newGrade) {
    },
    initialize:function () {
        var language = this.options.language;
        var renderedTemplate = Mustache.to_html(jQuery('#manageRolesTemplate').html(), language)
        this.$el.html(renderedTemplate);

        this.fetchRoles();
    },

    removeTeacher: function(){
        if (confirm(this.options.language['warningDeleteNodeMessageLabel'])) {
            this.teacherTreeData.drop();
        }
    },
    removeStudent: function(){
        if (confirm(this.options.language['warningDeleteNodeMessageLabel'])) {
            this.studentTreeData.drop();
        }
    },

    addNewStudent: function(){
        window.RolesDialog.choose(Permissions.Student, this.studentTreeData.roles ,jQuery.proxy(function (roleID) {
            this.studentTreeData.createRoleMap(roleID, Permissions.Student).done(jQuery.proxy(function (role) {
                this.studentTreeData.addRole(role);
                this.addRoleSuccess();
            }, this)).error(jQuery.proxy(function (err) { this.addRoleError(); }, this));
        }, this));
    },

    addNewTeacher: function(){
        window.RolesDialog.choose(Permissions.Teacher, this.teacherTreeData.roles ,jQuery.proxy(function (roleID) {
            this.addLiferayRole(roleID)
        }, this));
    },
    addLiferayRole: function (roleID) {
        this.teacherTreeData.createRoleMap(roleID, Permissions.Teacher).done(jQuery.proxy(function (role) {
                this.teacherTreeData.addRole(role);
                this.addRoleSuccess();
        }, this)).error(jQuery.proxy(function (err) { this.addRoleError(); }, this));
    },
    addRoleSuccess: function(){
        jQuery('#projectLearnGeneric').unblock();
        jQuery.growlUI(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayCompleteMessageLabel']);
    },
    addRoleError: function(){
        jQuery('#projectLearnGeneric').unblock();
        jQuery.growlWarning(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayFailedMessageLabel']);
    },

    fetchRoles: function(){
        var teacherTreeData = this.teacherTreeData = new RoleBankCollectionProxy();
        teacherTreeData.fetchRolesByPermission(Permissions.Teacher);

        var studentTreeData = this.studentTreeData = new RoleBankCollectionProxy();
        studentTreeData.fetchRolesByPermission(Permissions.Student);
    }
})
