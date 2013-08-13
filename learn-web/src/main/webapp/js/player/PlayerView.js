PlayerView = Backbone.View.extend({
    // TODO: multiple organizations
    events:{
        "click #SCORMNavigationExit":"doExit",
        "click #SCORMNavigationSuspend":"doSuspend",
        "click #SCORMNavigationBackward":"doPrevious",
        "click #SCORMNavigationForward":"doContinue",
        "click #SCORMToggleButton":"toggleLeftMenu"
    },

    initialize:function () {
        this.packageID = null;
        this.render();
    },
    render:function () {
        var language = this.options.language;
        var template = jQuery("#SCORMPlayerContent").html();
        this.$el.html(Mustache.to_html(template, language));
    },

    buildTree:function (data) {
        function addTreeItem(item) {
            var response = "";
            if (item.childActivities.length === 0) {
                if (item.visible) response = "<li id='" + item.id + "'><a href='#'>" + item.title + "</a></li>";
            } else {
                var innerItems = "";
                for (var i = 0; i < item.childActivities.length; i++) {
                    var childItem = addTreeItem(item.childActivities[i]);
                    if (childItem !== "") {
                        innerItems += childItem;
                    }
                }
                if (item.visible) {
                    var innerWrapper = (innerItems === "") ? ("") : ("<ul>" + innerItems + "</ul>");
                    response = "<li id='" + item.id + "'><a href='#'>" + item.title + "</a>" + innerWrapper + "</li>";
                } else {
                    response = innerItems;
                }
            }
            return response;
        }

        var items = "";
        for (var i = 0; i < data.length; i++) {
            items += addTreeItem(data[i]);
        }
        var that = this;
        jQuery("#SCORMTree").html("<ul>" + items + "</ul>");
        jQuery("#SCORMTree").jstree({
            "themes":{
                "url":Utils.getContextPath() + "/css/jstree/style.css",
                "dots":false,
                "icons":false
            },
            "plugins":[ "html_data", "ui", "themes" ]
        }).bind("select_node.jstree",function (event, data) {
                //updateView(data.rslt.obj.attr("id"));
                //updateNavigationButtons();
                //alert(data.inst.get_text(data.rslt.obj) + " - " + data.rslt.obj.attr("id")); // ID - Text
            }).bind("click.jstree", function (event) {
                var jsTree = jQuery.jstree._reference('#SCORMTree');
                var currentNode = jsTree.get_selected();
                if (!jsTree.is_leaf(currentNode)) {
                    if (!jsTree.is_open(currentNode)) {
                        jsTree.open_node(currentNode);
                    } else {
                        jsTree.close_node(currentNode);
                    }
                } else {
                    that.doChoice(currentNode.attr('id'));
                }
            });
        this.jsTreeRef = jQuery.jstree._reference("#SCORMTree");
        this.jsTreeRef.open_all();
    },

    initView:function () {
        window.LearnAjax.setHeader("currentScormPackageID", this.packageID.toString());

        function addOption(element, key, value) {
            jQuery(element).
                append(jQuery("<option></option>").
                attr("value", key).
                text(value));
        }

        var organizationsData = window.LearnAjax.syncRequest(Utils.getContextPath() + "/services/organizations/package/" + this.packageID);
        for (var i = 0; i < organizationsData.length; i++) {
            addOption('#SCORMOrganizations', organizationsData[i].id, decodeURIComponent(organizationsData[i].title));
        }
        if (organizationsData.length === 1) {
            jQuery('#SCORMOrganizations').hide("");
        } else if (organizationsData.length === 0) {
            return;
        } else {
            jQuery('#SCORMOrganizations').show("");
        }

        this.organizationID = organizationsData[0].id;
        var activitiesData = window.LearnAjax.syncRequest(Utils.getContextPath() + '/services/activities/package/' + this.packageID + '/organization/' + this.organizationID);
        this.buildTree(activitiesData);
    },

    setName:function (packageName) {
        this.$('#currentPackageName').html(packageName);
    },

    loadView:function (data) {
        function resizeIFrame() {
            var windowHeight = jQuery(window).height() - 150;
            jQuery("#SCORMDataOutput").height(windowHeight);
        }

        function hideNavigationControls(control) {
            switch (control) {
                case "continue":
                    jQuery("#SCORMNavigationForward").hide();
                    break;
                case "previous":
                    jQuery("#SCORMNavigationBackward").hide();
                    break;
                case "exitAll":
                    jQuery("#SCORMNavigationExit").hide();
                    break;
                case "suspendAll":
                    jQuery("#SCORMNavigationSuspend").hide();
                    break;
                default:
                    break;
            }
        }

        function showNavigationControls() {
            jQuery("#SCORMNavigationForward").show();
            jQuery("#SCORMNavigationBackward").show();
            jQuery("#SCORMNavigationExit").show();
            jQuery("#SCORMNavigationSuspend").show();
        }

        if (data.endSession) {
            this.trigger('endSession');
            jQuery.ajax({
                type: 'POST',
                url: jQuery("#SCORMContextPath").val()+"/clearSession"
            });
        }

        if (data.currentActivity && !data.endSession) {
            this.selectNode(data.currentActivity);
            jQuery('#SCORMDataOutput').attr("src", data.activityURL);
            resizeIFrame();
            API_1484_11.setActivity(this.packageID, this.organizationID, data.currentActivity);
            API.setActivity(this.packageID, this.organizationID, data.currentActivity);

            showNavigationControls();
            if (data.hiddenUI) {
                for (var i = 0; i < data.hiddenUI.length; i++) {
                    hideNavigationControls(data.hiddenUI[i]);
                }
            }
        } else {
            if (this.onSuspend) {
                this.onSuspend = false;
                this.trigger('suspend');
            }
            jQuery('#SCORMDataOutput').attr("src", "");
        }
    },

    load:function (packageID) {
        this.packageID = packageID;
        this.initView();
        jQuery('#SCORMDataOutput').attr("src", this.getNavigationRequestURL("start"));
    },

    loadAndResume:function (packageID) {
        this.packageID = packageID;
        this.initView();
        jQuery('#SCORMDataOutput').attr("src", this.getNavigationRequestURL("resumeAll"));
    },

    getNavigationRequestURL:function (requestType) {
        //return window.LearnAjax.syncRequest(Utils.getContextPath() + "/services/sequencing/NavigationRequest/" + this.packageID + "/" + this.organizationID + "/" + requestType, "post");
        return Utils.getContextPath() + "/services/sequencing/NavigationRequest/" + this.packageID + "/" + this.organizationID + "/" + requestType + "?scormUserID=" + window.LearnAjax.getHeader("scormUserID");
    },

    doPrevious:function () {
        jQuery('#SCORMDataOutput').attr("src", this.getNavigationRequestURL("previous"));
    },

    doContinue:function () {
        jQuery('#SCORMDataOutput').attr("src", this.getNavigationRequestURL("continue"));
    },

    doExit:function () {
        this.trigger('exit');
        jQuery('#SCORMDataOutput').attr("src", this.getNavigationRequestURL("exitAll"));
    },

    doSuspend:function () {
        jQuery('#SCORMDataOutput').attr("src", this.getNavigationRequestURL("suspendAll"));
        this.onSuspend = true;
    },

    doChoice:function (id) {
        jQuery('#SCORMDataOutput').attr("src", this.getNavigationRequestURL("choice{" + id + "}"));
    },
    doJump:function (id) {
        jQuery('#SCORMDataOutput').attr("src", this.getNavigationRequestURL("jump{" + id + "}"));
    },


    selectNode:function (id) {
        this.jsTreeRef.deselect_all(); // drop selection from current
        this.jsTreeRef.select_node(jQuery("#" + id));
    },

    toggleLeftMenu:function () {
        if (this.$('#SCORMTogglePanel').is(':visible')) {
            this.$("#SCORMTogglePanel").hide("slide");
            this.$("#SCORMToggleButton").toggleClass("toggle-button-active");
        } else {
            this.$("#SCORMTogglePanel").show("slide");
            this.$("#SCORMToggleButton").toggleClass("toggle-button-active");
        }
    }
});