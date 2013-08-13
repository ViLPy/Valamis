/**
 * Certificate management UI.
 */
CertificateUserEditView = Backbone.View.extend({
    events:{
        "click #certificateAddUser":"addUsers",
        "click #certificateRemoveUser":"removeUser",
        "click .userCourseReview":"review"
    },

    initialize:function () {
        this.processMessage = this.options.language['overlayProcessMessageLabel'];
        this.render();
    },

    render:function () {
        var language = this.options.language;
        var template = Mustache.to_html(jQuery("#certificateItemEditUsers").html(), _.extend(this.model.toJSON(), _.extend({
            id:this.model.get('id'), description:decodeURIComponent(this.model.get('description'))
        }, language)));
        this.$el.html(template);
        this.initUserTree(this.$("#certificateUserTreeView_" + this.model.get('id')));
        return this;
    },

    addUsers:function () {
        window.UsersDialog.choose(jQuery.proxy(function (userID, name) {
                this.addLiferayUser(userID, name)
        }, this));
    },
    addLiferayUser: function (userID, name) {
        this.treeData.createCertificateUser(this.model.id, userID).done(jQuery.proxy(function (param) {
            if (param != 0){
                var id = this.treeData.addUser({"name": name, "id": param, "userID":userID});
                this.treeView.selectNode(this.treeView.getNodeByID(id));
                jQuery('#projectLearnGeneric').unblock();
                jQuery.growlUI(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayCompleteMessageLabel']);
            }
        }, this)).error(jQuery.proxy(function (err) {
            jQuery('#projectLearnGeneric').unblock();
            jQuery.growlWarning(this.options.language['overlayAddExternalMessageLabel'], this.options.language['overlayFailedMessageLabel']);
        }, this));
    },

    removeUser: function(){
        var id =this.treeView.getNodeID(this.treeView.getCurrentNode());
        if (id == -1) return;

        if (confirm(this.options.language['warningDeleteUserMessageLabel'])) {
            var id = this.treeView.getNodeID(this.treeView.getCurrentNode());
            this.treeData.drop(id);
        }
    },

    onSelectItem: function () {
        var id = this.treeView.getNodeID(this.treeView.getCurrentNode());
        if (id == -1) {
            jQuery("#jsTreeCourseGrade_"+ this.model.get('id')).empty();}
        else {
        var model = this.treeView.collection.getEntity(id);
        var userID = model.get('userID');
        this.renderCertificateProgress(this.model.id, userID);}
    },

    renderCertificateProgress: function(certificateID, userID){
        window.LearnAjax.get(Utils.getContextPath() + "/services/certificating/users/GetCertificateProgress/user/" + userID + "/" + certificateID,
            jQuery.proxy(function (data) {
                this.drawCourseTree(this.formatJsonEntitiesToJSUserTree(data));
            }, this)
        )
    },

    formatJsonEntitiesToJSUserTree: function(entities) {
        var formattedItems = [];
        for(var i in  entities)
        {
            formattedItems.push(this.formatEntityToJSUserTree(entities[i]));
        }
        return formattedItems;
    },

    formatEntityToJSUserTree: function(entity) {
        var grade;
        if (entity.grade != "")
            grade = this.formatGrade(entity.grade); // (Math.round((parseFloat(entity.grade) * 100) * 100) / 100) + "%" ;
        else grade = "-";
        return {
            data:entity.title,
            attr:{
                rel:"entity",
                grade:this.generateGradeDiv(entity.siteID, grade),
                gradeEditing:this.generateGradeEditingButton(entity.siteID)}
        };
    },

    formatGrade:function(grade){
      return (Math.round((parseFloat(grade) * 100) * 100) / 100) + "%" ;
    },

    generateGradeDiv:function(siteID, grade){
        var id ='reviewGrade_' + siteID;
        var response =  "<div id='"+ id + "' >"+ grade + "</div>";
        return response;
    },

    generateGradeEditingButton:function(siteID) {
        var id ='reviewButton_' + siteID;
        var response =  "<button id='"+ id + "'  class='userCourseReview button28 removeQuizButton buttonEdit' ></button>";
        return response;
    },

    review: function(e) {
        var id = e.target.id.replace('reviewButton_', '');

        var gradeLabelID = "#reviewGrade_" + id;
        var model = this.treeView.collection.getEntity(this.treeView.getNodeID(this.treeView.getCurrentNode()));
        var userID = model.get('userID');

        window.LearnAjax.get(Utils.getContextPath() + "/services/certificating/users/GetCourseGrade/user/" + userID + "/" + id,
            jQuery.proxy(function (data) {
                window.CourseGradeDialog.choose(data, jQuery.proxy(function (newGrade) {
                    if (newGrade != null)
                    {
                        var formatted = (Math.round((parseFloat(newGrade) * 100) * 100) / 100) + "%" ;
                        this.$(gradeLabelID).text(formatted);
                    }
                }, this))
            }, this)
        )
    },

    initUserTree: function (node) {
        var treeData = this.treeData = new CertificateUserBankCollectionProxy();

        var treeInitParams = {
            "themes": {
                "url": Utils.getContextPath() + "/css/jstree/style.css",
                "dots": true,
                "icons": true
            },
            "types": {
                "valid_children": [ "root" ],
                "types": {
                    "entity": {
                        "icon": {
                            "image": Utils.getContextPath() + "/img/icons/book.png"
                        },
                        "valid_children": "none"
                    },
                    "root": {
                        "icon": {
                            "image": Utils.getContextPath() + "/img/icons/database.png"
                        },
                        "valid_children": [ "folder", "entity"]
                    }
                }
            },
            "json_data": {
                "data": [
                    { // root
                        "data": this.options.language['userTreeRootLabel'],
                        "state": "open",
                        "attr": {
                            "id": "-1",
                            "rel": "root"
                        }
                    }
                ]
            },
            "plugins": [ "themes", "ui", "json_data", "types"] //"dnd", "crrm", "group" ]
        };

        this.treeView = new jsTreeView({
            el: jQuery(node),
            collection: this.treeData,
            initParams: treeInitParams,
            sort: function (a, b) {
                var priorities = {
                    "default": 0,
                    "folder": 1,
                    "entity": 2
                };
                var aType = a.get('type').toLowerCase();
                var bType = b.get('type').toLowerCase();
                return priorities[aType] - priorities[bType];

            }});

        var treeView = this.treeView;
        treeView.addBind("select_node.jstree", jQuery.proxy(function () {
            this.onSelectItem();
        }, this));
         treeView.addBind("create_node.jstree", jQuery.proxy(function () {
             _.delay(jQuery.proxy(this.updateCertificateFromServer, this), 1000);
         }, this));

        treeView.addBind("delete_node.jstree", jQuery.proxy(function () {
            _.delay(jQuery.proxy(this.updateCertificateFromServer, this), 1000);
        }, this));

        treeData.fetchUsers(this.model.id);

        return treeView;
    },

    updateCertificateFromServer: function(){
        this.model.fetch();
    },

    drawCourseTree: function(jsonData) {
        var id =  "#jsTreeCourseGrade_" + this.model.get('id');
        if (jsonData.length <= 0) {
            jQuery(id).empty().html("");
        } else {
            jQuery(id).empty().jstree({
                plugins:["themes", "json_data", "grid", "types"],
                json_data:{data:jsonData},
                "themes":{
                    "url":Utils.getContextPath() + "/css/jstree/style.css",
                    "dots":true,
                    "icons":true
                },
                "types":{
                    "valid_children":[ "folder" ],
                    "types":{
                        "entity":{
                            "icon":{
                                "image":Utils.getContextPath() + "/img/icons/book.png"
                            },
                            "valid_children":"none"
                        }
                    }
                },
                grid:{
                    columns:[
                        {width:320, header:"Course", title:"_DATA_"},
                        {cellClass:"col0", value:"grade", width:60, header:"Grade", title:"grade"},
                        {cellClass:"col1", value:"gradeEditing", width:50, header:"", title:"gradeEditing"}
                    ],
                    resizable:true
                }
            }).bind("open_node.jstree",function (event, data) {
                    jQuery("#jsTreeCourseGrade .jstree-leaf").removeClass("altRow");
                    jQuery("#jsTreeCourseGrade .jstree-leaf:even").addClass("altRow");
                }).bind("close_node.jstree", function (event, data) {
                    jQuery("#jsTreeCourseGrade .jstree-leaf").removeClass("altRow");
                    jQuery("#jsTreeCourseGrade .jstree-leaf:even").addClass("altRow");
                });

            var jsTreeRef = jQuery.jstree._reference(id);
            jQuery(id).delegate("a", "click", function (e) {
            jQuery(id).jstree("toggle_node", this);
            });
        }
    }
});
