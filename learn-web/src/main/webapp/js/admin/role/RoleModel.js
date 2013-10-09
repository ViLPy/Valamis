RoleService = new Backbone.Service({ url: Utils.getContextPath,
        sync: {
            'update': {
                'path': function (model) {
                    return "services/roles/update/" + model.id + "/" + model.get('permission') + "/" + model.get('isDefault');
                },
                'method': "post"
            },
            'delete': {
                'path': function (model) {
                    return "/services/roles/delete/" + model.get('roleID') + "/" + model.get('permission');
                },
                'method': "post"
            }
        }
})


RoleModel = Backbone.Model.extend({
    defaults:{
        roleName:"",
        roleDescription:"",
        roleID:0,
        permission:"",
        isDefault: false
    }
}).extend(RoleService);

Permissions = {"Teacher": "teacher", "Student": "student"}
