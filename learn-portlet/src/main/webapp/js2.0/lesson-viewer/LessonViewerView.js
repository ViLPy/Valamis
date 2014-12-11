PlayerView = Backbone.View.extend({
  // TODO: multiple organizations
  events: {
    'click #SCORMNavigationExit': 'doExit',
    'click #SCORMNavigationSuspend': 'doSuspend',
    'click #SCORMNavigationBackward': 'doPrevious',
    'click #SCORMNavigationForward': 'doContinue',
    'click #SCORMToggleButton': 'toggleLeftMenu',
    'click #PlayerLaunchFullScreen': 'fullScreen',
    'click .scorm-cancel-fullscreen': 'cancelFullscreen',
    'click .tincan-cancel-fullscreen': 'cancelFullscreen'
  },

  initialize: function (options) {
    this.language = options.language;
    this.packageID = null;
    this.packageType = null;
    this.render();

    var that = this;
    this.ourFullscreen = false;
    this.notOurFullscreen = false;
    this.flag = false;
    jQuery1816Player(window).resize(function(){
        if(that.iPadHack) {
            element$ = that.getFullscreeElement();
            that.iPadSetElement2FullScreen(element$);
        }
    });
    document.addEventListener("fullscreenchange", _.bind(this.fullscreenChange, this));
    document.addEventListener("mozfullscreenchange", _.bind(this.fullscreenChange, this));
    document.addEventListener("webkitfullscreenchange", _.bind(this.fullscreenChange, this));
    document.addEventListener("msfullscreenchange",_.bind(this.fullscreenChange, this));

    document.addEventListener("fullscreenerror", _.bind(this.fullscreenerror, this));
    document.addEventListener("webkitfullscreenerror", _.bind(this.fullscreenerror, this));
    document.addEventListener("mozfullscreenerror", _.bind(this.fullscreenerror, this));
    document.addEventListener("MSFullscreenError", _.bind(this.fullscreenerror, this));
  },

  fullscreenerror: function(event) {
    console.log('errror in fullscreen ' + event);
  },

  getFullscreenElement: function() {
    return document.fullscreenElement ||
    document.webkitFullscreenElement ||
    document.mozFullScreenElement ||
    document.msFullscreenElement;
  },

  fullscreenChange: function(event){
    if (!this.ourFullscreen) {
      if (!this.notOurFullscreen) {
        jQuery("#SCORMDataOutput").contents().find(".slides").css("perspective", "none");
        jQuery("#SCORMDataOutput").contents().find("section").css("transform-style", "flat");
        this.notOurFullscreen = true;
      }
      else {
        jQuery("#SCORMDataOutput").contents().find(".slides").css("perspective", "600px");
        jQuery("#SCORMDataOutput").contents().find("section").css("transform-style", "preserve-3d");
        this.notOurFullscreen = false;
        if (document.webkitExitFullscreen){
            this.justHappened = false;
            this.fullscreenState = true;
        }
      }
    }
    else {
      jQuery("#SCORMDataOutput").contents().find(".slides").css("perspective", "600px");
      jQuery("#SCORMDataOutput").contents().find("section").css("transform-style", "preserve-3d");
        this.notOurFullscreen = false;
    }
    this.ourFullscreen = false;

    if(this.justHappened){
      this.justHappened = false;
    } else if(this.fullscreenState){
      this.fullscreenState = false;
    }

    var isfullscreen = document.fullscreen || document.mozFullScreen || (document.webkitCurrentFullScreenElement != null);

    this.cancelFullscreenEscape(isfullscreen);

    if (this.getFullscreenElement() == undefined)
      this.cancelFullscreenHelper()
  },
  render: function () {
    var template = jQuery('#SCORMPlayerContent').html();
    this.$el.html(Mustache.to_html(template, this.language));
  },

  buildTree: function (data) {
    function addTreeItem(item) {
      var response = '';
      if (item.childActivities.length === 0) {
        if (item.visible) response = '<li id=' + item.id + '><a href="#">' + item.title + '</a></li>';
      } else {
        var innerItems = '';
        for (var i = 0; i < item.childActivities.length; i++) {
          var childItem = addTreeItem(item.childActivities[i]);
          if (childItem !== '') {
            innerItems += childItem;
          }
        }
        if (item.visible) {
          var innerWrapper = (innerItems === '') ? ('') : ('<ul>' + innerItems + '</ul>');
          response = '<li id=' + item.id + '><a href="#">' + item.title + '</a>' + innerWrapper + '</li>';
        } else {
          response = innerItems;
        }
      }
      return response;
    }

    var items = '';
    for (var i = 0; i < data.length; i++) {
      items += addTreeItem(data[i]);
    }
    var that = this;
    jQuery('#SCORMTree').html('<ul>' + items + '</ul>');
    jQuery('#SCORMTree').jstree({
      'themes': {
        'url': Utils.getContextPath() + '/css2.0/jstree/style.css',
        'dots': false,
        'icons': false
      },
      'plugins': [ 'html_data', 'ui', 'themes' ]
    }).bind('select_node.jstree',function (event, data) {
      }).bind('click.jstree', function (event) {
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
    this.jsTreeRef = jQuery.jstree._reference('#SCORMTree');
    this.jsTreeRef.open_all();
  },

  initView: function () {
    window.LearnAjax.setHeader('currentScormPackageID', this.packageID.toString());

    function addOption(element, key, value) {
      jQuery(element).
        append(jQuery('<option></option>').
          attr('value', key).
          text(value));
    }

    var organizationsData = window.LearnAjax.syncRequest(Utils.getContextPath() + 'services/organizations/package/' + this.packageID);
    for (var i = 0; i < organizationsData.length; i++) {
      addOption('#SCORMOrganizations', organizationsData[i].id, decodeURIComponent(organizationsData[i].title));
    }
    if (organizationsData.length === 1) {
      jQuery('#SCORMOrganizations').hide('');
    } else if (organizationsData.length === 0) {
      return;
    } else {
      jQuery('#SCORMOrganizations').show('');
    }

    this.organizationID = organizationsData[0].id;
    var activitiesData = window.LearnAjax.syncRequest(path.root + path.api.manifestactivities + '?packageID=' + this.packageID + '&organizationID=' + this.organizationID);
    this.buildTree(activitiesData);
  },

  setName: function (packageName) {
    this.$('#currentPackageName').html(packageName);
  },

  loadView: function (data) {
    function resizeIFrame() {
      var windowHeight = jQuery(window).height() - 150;
      jQuery('#SCORMDataOutput').height(windowHeight);
    }

    function hideNavigationControls(control) {
      switch (control) {
        case 'continue':
          jQuery('#SCORMNavigationForward').hide();
          break;
        case 'previous':
          jQuery('#SCORMNavigationBackward').hide();
          break;
        case 'exitAll':
          jQuery('#SCORMNavigationExit').hide();
          break;
        case 'suspendAll':
          jQuery('#SCORMNavigationSuspend').hide();
          break;
        default:
          break;
      }
    }

    function showNavigationControls() {
      jQuery('#SCORMNavigationForward').show();
      jQuery('#SCORMNavigationBackward').show();
      jQuery('#SCORMNavigationExit').show();
      jQuery('#SCORMNavigationSuspend').show();
    }

    jQuery('#SCORMOrganizationsMenu').show();
    jQuery('#SCORMTree').show();

    if (data.endSession) {
      this.trigger('endSession');
        FinishPackageAttempt(false);
      this.cancelFullscreen();
      jQuery.ajax({
        type: 'POST',
        url: path.root + path.sequencing + "clearSession"
      });
    }

    if (data.currentActivity && !data.endSession) {
      //SetLRS(data);
      this.selectNode(data.currentActivity);

      // Bug in firefox. OpticalIllusions are not shown.
      if(navigator.userAgent.indexOf("Firefox") == -1) jQuery('#SCORMDataOutput').attr('src', data.activityURL);
      resizeIFrame();
      API_1484_11.setActivity(this.packageID, this.organizationID, data.currentActivity);
      API.setActivity(this.packageID, this.organizationID, data.currentActivity);
      SetActivity(data.activityURL, data.activityTitle, data.activityDesc);

      showNavigationControls();
      if (data.hiddenUI) {
        for (var i = 0; i < data.hiddenUI.length; i++) {
          hideNavigationControls(data.hiddenUI[i]);
        }
      }
      if(navigator.userAgent.indexOf("Firefox") != -1) jQuery('#SCORMDataOutput').attr('src', data.activityURL);
    } else {
      if (this.onSuspend) {
        this.onSuspend = false;
        this.trigger('suspend');
      }
      jQuery('#SCORMDataOutput').attr('src', '');
    }
  },

  isTincan: function () {
    return this.packageType == 'tincan';
  },

  openTincanPackage: function (launchUrl, endpoint, auth, secret) {
    var actor = jQuery('#tincanActor').val();

    var src = '{0}SCORMData/{1}?endpoint={2}&auth={3}&actor={4}'
      .replace('{0}', Utils.getContextPath())
      .replace('{1}', launchUrl)
      .replace('{2}', encodeURIComponent(endpoint))
      .replace('{3}', encodeURIComponent(auth))
      .replace('{4}', encodeURIComponent(actor));

    if (secret) {
      var sign = 'asdasd';
      src += '&oauth_signature={0}&oauth_signature_method=HMAC-SHA1'.replace('{0}', sign);
    }

    jQuery('#SCORMDataOutput').attr('src', src);
  },

  loadTincanPackage: function (sendStartStatement) {

    jQuery('#SCORMNavigationForward').hide();
    jQuery('#SCORMNavigationBackward').hide();
    jQuery('#SCORMNavigationSuspend').hide();
    jQuery('#SCORMOrganizationsMenu').hide();
    jQuery('#SCORMTree').hide();

    jQuery('#SCORMNavigationExit').show();

    var windowHeight = jQuery(window).height() - 150;
    jQuery('#SCORMDataOutput').height(windowHeight);

    var player = this;
    player.sendStartStatement = sendStartStatement;
    jQuery.ajax({
      type: 'POST',
      dataType: 'json',
      url: path.root + path.sequencing + 'Tincan/' + this.packageID,

      success: function (data) {
          if(player.sendStartStatement) { // send start package statement
              SetLRS(data);
              StartPackageAttempt(player.packageID, player.packageTitle, player.packageTitle);
          }

        if (data.internal) {
          //var endpoint = document.location.protocol + '//' + document.location.host + Utils.getContextPath() + 'TincanApi/';
          var endpoint = document.location.protocol + '//' + document.location.host + "/" + path.api.prefix;
          player.openTincanPackage(data.launchURL, endpoint, data.auth);
        }
        else {
          if (data.authType == 'Basic') {
            if (data.auth) {
              player.openTincanPackage(data.launchURL, data.endpoint, data.auth);
            }
            else {
              jQuery('#tincanLaunchUrlCredentialsDialog').val(data.launchURL);
              jQuery('#tincanEndpointCredentialsDialog').val(data.endpoint);
              jQuery('#tincanLrsUserCredentials').attr('onclick', 'openTincanPackageFromCredentialsDialog()');
              window.playerLayout.modals.show(window.tincanModal);
            }
          } else if (data.authType === 'OAuth') {
            if (data.auth) {
              player.openTincanPackage(data.launchURL, data.endpoint , data.auth, data.clientSecret);
            }
          }
        }
      }
    })
  },

  load: function (packageID, packageType, packageTitle) {
    this.packageID = packageID;
    this.packageType = packageType;
    this.packageTitle = packageTitle;
    this.initView();
    if (this.isTincan()) {
      this.loadTincanPackage(true);
    }
    else {
        jQuery.ajax({
            type: 'GET',
            dataType: 'json',
            url: path.root + path.api.administrering + 'TincanLrsSettings',

            success: jQuery.proxy(function (data) {
                SetLRS(data);
                StartPackageAttempt(packageID, packageTitle, packageTitle);
                jQuery('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('start'));
            }, this),
            error: function (err, res) {
                // do something in case of an error
                toastr.error(language['loadLRSFailed']);
                this.doExit();
            }
        })
    }
  },

  loadAndResume: function (packageID, packageTitle, packageType) {
    this.packageID = packageID;
    this.packageType = packageType;
    this.packageTitle = packageTitle;
    this.initView();
    if (this.isTincan() || this.packageType == 'tincan') { // Because this.isTincan() is not enough. I have no clue why.
      this.loadTincanPackage(false);
    } else {
        jQuery.ajax({
            type: 'GET',
            dataType: 'json',
            url:  path.root + path.api.administrering + 'TincanLrsSettings',

            success: jQuery.proxy(function (data) {
                SetLRS(data);
                StartPackageAttempt(packageID, packageTitle, packageTitle);
                jQuery('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('resumeAll'));
            }, this),
            error: function (err, res) {
                // do something in case of an error
                toastr.error(language['loadLRSFailed']);
                this.doSuspend();
            }
        })
    }
  },

  getNavigationRequestURL: function (requestType) {
    return path.root + path.sequencing +  'NavigationRequest/' + this.packageID + '/' + this.organizationID + '/' + requestType;
  },

  doPrevious: function () {
    if (!this.isTincan()) {
      // SCORM 1.2, ignore auto doContinue on LMSFinish
      window.API.silenceFinish();
      jQuery('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('previous'));
    }
  },

  doContinue: function () {
    if (!this.isTincan()) {
      // SCORM 1.2, ignore auto doContinue on LMSFinish
      window.API.silenceFinish();
      jQuery('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('continue'));
    }
  },

  doExit: function () {
    if (this.isTincan()) {
      //StartPackageAttempt(this.packageID, this.packageType, this.packageTitle);
      this.trigger('endSession');
      jQuery.ajax({
        type: 'POST',
        url: path.root + path.sequencing + "clearSession"
      });
      jQuery('#SCORMDataOutput').attr('src', '');
      this.trigger('exit');
      FinishPackageAttempt(false);
    } else {
      // SCORM 1.2, ignore auto doContinue on LMSFinish
      window.API.silenceFinish();
      jQuery('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('exitAll')).load(function(){
        this.trigger('exit');
      }.bind(this));
      FinishPackageAttempt(false);
    }
    this.cancelFullscreen();
    window.frames.top.ValamisTick = null; //Destroy valamis tick variable, so that opening package doesn't continue countdown
  },

  doSuspend: function () {
    if (!this.isTincan()) {
      // SCORM 1.2, ignore auto doContinue on LMSFinish
      window.API.silenceFinish();
      jQuery('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('suspendAll'));
      this.onSuspend = true;
        FinishPackageAttempt(true);
    }
    this.cancelFullscreen();
    window.frames.top.ValamisTick = null; //Destroy valamis tick variable, so that opening package doesn't continue countdown
  },

  doChoice: function (id) {
    // SCORM 1.2, ignore auto doContinue on LMSFinish
    window.API.silenceFinish();
    if (!this.isTincan()) jQuery('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('choice{' + id + '}'));
  },
  doJump: function (id) {
    // SCORM 1.2, ignore auto doContinue on LMSFinish
    window.API.silenceFinish();
    if (!this.isTincan()) jQuery('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('jump{' + id + '}'));
  },

  selectNode: function (id) {
    this.jsTreeRef.deselect_all(); // drop selection from current
    this.jsTreeRef.select_node(jQuery('#' + id));
  },

  toggleLeftMenu: function () {
    if (this.$('#SCORMTogglePanel').is(':visible')) {
      this.$('#SCORMTogglePanel').hide('slide');
      this.$('#SCORMToggleButton').toggleClass('toggle-button-active');
    } else {
      this.$('#SCORMTogglePanel').show('slide');
      this.$('#SCORMToggleButton').toggleClass('toggle-button-active');
    }
  },

  getFullscreeElement: function(){
      var element$;
      if(this.isTincan()){
          // We need package view only, nor table of content
          element$ = this.$("#iframe-wrapper");
      } else element$ = this.$el;
      return element$
  },

  iPadSetElement2FullScreen: function(element$){
      element$.height(jQuery(window).height());
      element$.width(jQuery(window).width());
  },

  fullScreen: function () {
    this.ourFullscreen = true;

    this.fullscreenState = true;
    this.justHappened = true;
    this.$('#PlayerLaunchFullScreen').hide();

    var element$ = this.getFullscreeElement();
    var element = element$.get(0);

    if (element.requestFullscreen) {
      element.requestFullscreen();
    } else if (element.mozRequestFullScreen) {
      element.mozRequestFullScreen();
    } else if (element.webkitRequestFullscreen) {
      element.webkitRequestFullscreen();
    } else if (element.msRequestFullscreen) {
      element.msRequestFullscreen();
    } else {
      //iPad doesn't support any sort of fullscreen api.
      this.iPadHack = true;

      element$.addClass('custom-fullscreen');
      this.iPadSetElement2FullScreen(element$);
      jQuery1816Player(".portlet-dockbar").hide();
    }

    if(this.isTincan()){
        element$.find("#SCORMDataOutput").css({ height: "100%", width: "100%" });
        element$.find(".tincan-cancel-fullscreen").show();
    } else {
        element$.find(".scorm-cancel-fullscreen").show();
    }

  },
  iPadExitFullscreen: function() {
    this.iPadHack = false;

    var element$ = this.getFullscreeElement();

    element$.removeClass("custom-fullscreen");
    jQuery1816Player(".portlet-dockbar").show();

    if(!this.isTincan()) element$.removeAttr("width").removeAttr("height").css({ height: "", width: "" });
  },
  cancelFullscreenEscape: function (isFullscreen) {
    if (!isFullscreen){
        this.$('#PlayerLaunchFullScreen').show();
          this.notOurFullscreen = true;
    }
      var rrr = 0;
  },
  cancelFullscreenHelper: function(){
    this.$('#PlayerLaunchFullScreen').show();
    if(this.isTincan()){
      this.$(".tincan-cancel-fullscreen").hide();
      this.getFullscreeElement().removeAttr("width").removeAttr("height").css({width: "100%", height: "100%"})
    } else this.$(".scorm-cancel-fullscreen").hide();

    var windowHeight = jQuery(window).height() - 150;
    this.$('#SCORMDataOutput').height(windowHeight);
},
  cancelFullscreen: function () {
    this.ourFullscreen = true;

    //this.cancelFullscreenHelper();

    if (document.exitFullscreen) {
      document.exitFullscreen();
    } else if (document.mozCancelFullScreen) {
      document.mozCancelFullScreen();
    } else if (document.webkitExitFullscreen) {
      document.webkitExitFullscreen();
    } else {
        this.iPadExitFullscreen();
    }
  }
});