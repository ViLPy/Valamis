PlayerView = Backbone.View.extend({
  navigationNodeCollection: null,
  // TODO: multiple organizations
  events: {
    'click #SCORMNavigationExit': 'doExit',
    'click #SCORMNavigationSuspend': 'doSuspend',
    'click #SCORMNavigationBackward': 'doPrevious',
    'click #SCORMNavigationForward': 'doContinue',
    'click #SCORMToggleButton': 'toggleLeftMenu',
    'click #PlayerLaunchFullScreen': 'fullScreen',
    'click #PlayerExitFullScreen': 'cancelFullscreen',
    'click #SlideMap': 'slideMap'
  },

  initialize: function (options) {
    this.language = options.language;
    this.packageID = null;
    this.packageType = null;
    this.render();

    var that = this;
    jQueryValamis('#SCORMDataOutput').on('load', function() {
      that.resizeIFrame();
    });

    jQueryValamis(window).resize(function(){
        if(that.iPadHack) {
            var element$ = that.getFullscreenElement();
            that.iPadSetElement2FullScreen(element$);
        }
    });

    document.addEventListener("fullscreenchange", _.bind(this.fullscreenChange, this));
    document.addEventListener("mozfullscreenchange", _.bind(this.fullscreenChange, this));
    document.addEventListener("webkitfullscreenchange", _.bind(this.fullscreenChange, this));
    document.addEventListener("msfullscreenchange",_.bind(this.fullscreenChange, this));
  },

  render: function () {
    var template = jQueryValamis('#SCORMPlayerContent').html();
    this.$el.html(Mustache.to_html(template, this.language));
    this.$el.find('.js-toggle-sidebar').valamisSidebar();
  },

  buildTree: function (data) {
    var parsedData = ScormNodeNavigationCollection.prototype.parseTree(data);
    this.navigationNodeCollection = new ScormNodeNavigationCollection(parsedData);
    this.navigationNodeCollection.afterInitialization();
    var navigationNodeCollectionView = new NavigationNodeCollectionView({collection: this.navigationNodeCollection});
    this.$el.find('#SCORMTree').html(navigationNodeCollectionView.render().$el);

    this.listenTo(this.navigationNodeCollection,'navigate',function(model){
        this.doChoice(model.get('id'));
    });
  },

  initView: function () {
    window.LearnAjax.setHeader('currentScormPackageID', this.packageID.toString());

    function addOption(element, key, value) {
      jQueryValamis(element).
        append(jQueryValamis('<option></option>').
          attr('value', key).
          text(value));
    }

    var organizationsData = window.LearnAjax.syncRequest(Utils.getContextPath() + 'services/organizations/package/' + this.packageID);
    for (var i = 0; i < organizationsData.length; i++) {
      addOption('#SCORMOrganizations', organizationsData[i].id, organizationsData[i].title);
    }
    if (organizationsData.length === 1) {
      this.$el.find('#SCORMOrganizations').hide('');
    } else if (organizationsData.length === 0) {
      return;
    } else {
      this.$el.find('#SCORMOrganizations').show('');
    }

    this.organizationID = organizationsData[0].id;
    var activitiesData = window.LearnAjax.syncRequest(path.root + path.api.manifestactivities + '?packageID=' + this.packageID + '&organizationID=' + this.organizationID);
    this.buildTree(activitiesData);
  },

  setName: function (packageName) {
    this.$el.find('#currentPackageName').html(packageName);
  },

  resizeIFrame: function() {
    var contentHeight = jQueryValamis('#SCORMDataOutput').contents().find('html').outerHeight(true);
    var iframeHeight = Math.max(contentHeight, 700);    // minimum height - 700px;
    jQueryValamis('#SCORMDataOutput').height(iframeHeight);
    this.ifReveal();
  },

  resizeIFrameToFullscreen: function() {
    var headerHeight = this.$el.find('.content-wrapper .content-header').outerHeight(true);
    var footerHeight = this.$el.find('.content-wrapper .content-footer').outerHeight(true);
    if (!this.isTincan)    // place for scorm buttons by default
      footerHeight = Math.max(footerHeight, 38);
    jQueryValamis('#SCORMDataOutput').height(screen.height - headerHeight - footerHeight);
  },

  loadView: function (data) {

    function hideNavigationControls(control) {
      switch (control) {
        case 'continue':
          jQueryValamis('#SCORMNavigationForward').hide();
          break;
        case 'previous':
          jQueryValamis('#SCORMNavigationBackward').hide();
          break;
        case 'exitAll':
          jQueryValamis('#SCORMNavigationExit').hide();
          break;
        case 'suspendAll':
          jQueryValamis('#SCORMNavigationSuspend').hide();
          break;
        default:
          break;
      }
    }

    function showNavigationControls() {
      jQueryValamis('#SCORMNavigationForward').show();
      jQueryValamis('#SCORMNavigationBackward').show();
      jQueryValamis('#SCORMNavigationExit').show();
      jQueryValamis('#SCORMNavigationSuspend').show();
      jQueryValamis('#SlideMap').hide();
    }

    this.$el.find('#SCORMOrganizationsMenu').show();
    this.$el.find('#SCORMTree').show();

    if (data.endSession) {
      this.trigger('player:endSession');

      var sendStatement = !this.isTincan();
      FinishPackageAttempt(sendStatement);
      this.cancelFullscreen();
      jQueryValamis.ajax({
        type: 'POST',
        url: path.root + path.sequencing + "clearSession"
      });
    }

    if (data.currentActivity && !data.endSession) {
      this.selectNode(data.currentActivity);

      // Bug in firefox. OpticalIllusions are not shown.
      if(navigator.userAgent.indexOf("Firefox") == -1) jQueryValamis('#SCORMDataOutput').attr('src', data.activityURL);

      API_1484_11.setActivity(this.packageID, this.organizationID, data.currentActivity);
      API.setActivity(this.packageID, this.organizationID, data.currentActivity);
      SetActivity(data.activityURL, data.activityTitle, data.activityDesc);

      showNavigationControls();
      if (data.hiddenUI) {
        for (var i = 0; i < data.hiddenUI.length; i++) {
          hideNavigationControls(data.hiddenUI[i]);
        }
      }
      if(navigator.userAgent.indexOf("Firefox") != -1) jQueryValamis('#SCORMDataOutput').attr('src', data.activityURL);
    } else {
      if (this.onSuspend) {
        this.onSuspend = false;
        this.trigger('player:endSession');
      }
      jQueryValamis('#SCORMDataOutput').attr('src', '');
    }
  },

  isTincan: function () {
    return this.packageType == 'tincan';
  },

  openTincanPackage: function (launchUrl) {
    var src = '{0}SCORMData/{1}?{2}'
      .replace('{0}', Utils.getContextPath())
      .replace('{1}', launchUrl)
      .replace('{2}', TincanHelper.getLaunchArguments());

    jQueryValamis('#SCORMDataOutput').attr('src', src);
  },

  loadTincanPackage: function () {

    this.$el.find('#SCORMNavigationForward').hide();
    this.$el.find('#SCORMNavigationBackward').hide();
    this.$el.find('#SCORMNavigationSuspend').hide();
    this.$el.find('#SCORMOrganizationsMenu').hide();
    this.$el.find('#SCORMNavigationExit').show();
    this.$el.find('#SlideMap').show();

    var player = this;
    jQueryValamis.ajax({
      type: 'POST',
      dataType: 'json',
      url: path.root + path.sequencing + 'Tincan/' + this.packageID,

      success: function (data) {
        player.openTincanPackage(data.launchURL);
      }
    })
  },

  load: function (packageID, packageType, packageTitle) {
    this.packageID = packageID;
    this.packageType = packageType;
    this.packageTitle = packageTitle;
    this.initView();
    if (this.isTincan()) {
      this.loadTincanPackage();
    }
    else {
      StartPackageAttempt(packageID, packageTitle, packageTitle);
      jQueryValamis('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('start'));
    }
  },

  loadAndResume: function (packageID, packageTitle, packageType) {
    this.packageID = packageID;
    this.packageType = packageType;
    this.packageTitle = packageTitle;
    this.initView();
    if (this.isTincan() || this.packageType == 'tincan') { // Because this.isTincan() is not enough. I have no clue why.
      this.loadTincanPackage();
    } else {
        StartPackageAttempt(packageID, packageTitle, packageTitle);
        jQueryValamis('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('resumeAll'));
    }
  },

  getNavigationRequestURL: function (requestType) {
    return path.root + path.sequencing +  'NavigationRequest/' + this.packageID + '/' + this.organizationID + '/' + requestType;
  },

  doPrevious: function () {
    if (!this.isTincan()) {
      // SCORM 1.2, ignore auto doContinue on LMSFinish
      window.API.silenceFinish();
      jQueryValamis('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('previous'));
    }
  },

  doContinue: function () {
    if (!this.isTincan()) {
      // SCORM 1.2, ignore auto doContinue on LMSFinish
      window.API.silenceFinish();
      jQueryValamis('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('continue'));
    }
  },

  doExit: function () {
    if (this.isTincan()) {
      this.trigger('player:endSession');
      jQueryValamis.ajax({
        type: 'POST',
        url: path.root + path.sequencing + "clearSession"
      });
      jQueryValamis('#SCORMDataOutput').attr('src', '');
      FinishPackageAttempt(false);
    } else {
      // SCORM 1.2, ignore auto doContinue on LMSFinish
      window.API.silenceFinish();
      jQueryValamis('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('exitAll'));
      FinishPackageAttempt(true);
    }
    this.cancelFullscreen();
    window.frames.top.ValamisTick = null; //Destroy valamis tick variable, so that opening package doesn't continue countdown
    navigationProxy.destroyNavigation();
  },

  doSuspend: function () {
    if (!this.isTincan()) {
      // SCORM 1.2, ignore auto doContinue on LMSFinish
      window.API.silenceFinish();
      jQueryValamis('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('suspendAll'));
      this.onSuspend = true;
      FinishPackageAttempt(false);
    }
    this.cancelFullscreen();
    window.frames.top.ValamisTick = null; //Destroy valamis tick variable, so that opening package doesn't continue countdown
    navigationProxy.destroyNavigation()
  },

  doChoice: function (id) {
    // SCORM 1.2, ignore auto doContinue on LMSFinish
    window.API.silenceFinish();
    if (!this.isTincan()) jQueryValamis('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('choice{' + id + '}'));
  },
  doJump: function (id) {
    // SCORM 1.2, ignore auto doContinue on LMSFinish
    window.API.silenceFinish();
    if (!this.isTincan()) jQueryValamis('#SCORMDataOutput').attr('src', this.getNavigationRequestURL('jump{' + id + '}'));
  },

  selectNode: function (id) {
    this.navigationNodeCollection.toggle(id);
  },

  getFullscreenElement: function(){
      var element$ = this.$el;
      return element$
  },

  iPadSetElement2FullScreen: function(element$){
      element$.height(jQueryValamis(window).height());
      element$.width(jQueryValamis(window).width());
      element$.css('position', 'absolute').css('top', '0').css('left', '0');
      jQueryValamis(element$).parents('.val-portlet').css('position', 'initial');
  },

  iPadUnsetElement: function(element$) {
    element$.css('height', '').css('width', '').css('position', '').css('top', '').css('left', '');
    jQueryValamis(element$).parents('.val-portlet').css('position', 'relative');
  },

  fullScreen: function () {
      this.$el.find('#PlayerLaunchFullScreen').hide();
      this.$el.find('#PlayerExitFullScreen').show();

      var element$ = this.getFullscreenElement();
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
          //iPad doesn't support any sort of fullscreen api .
          this.iPadHack = true;

          this.iPadSetElement2FullScreen(element$);
        jQueryValamis(".portlet-dockbar").hide();
      }
      this.resizeIFrameToFullscreen();
  },

  iPadExitFullscreen: function() {
    this.iPadHack = false;
    var element$ = this.getFullscreenElement();
    jQueryValamis(".portlet-dockbar").show();
    this.iPadUnsetElement(element$);
  },

  cancelFullscreenHelper: function () {
    this.$el.find('#PlayerLaunchFullScreen').show();
    this.$el.find('#PlayerExitFullScreen').hide();
    this.resizeIFrame();
  },

  cancelFullscreen: function () {
    this.cancelFullscreenHelper();

    if (document.exitFullscreen) {
      document.exitFullscreen();
    } else if (document.mozCancelFullScreen) {
      document.mozCancelFullScreen();
    } else if (document.webkitExitFullscreen) {
      document.webkitExitFullscreen();
    } else {
        this.iPadExitFullscreen();
    }
  },

  getBrowserFullscreenElement: function() {
    return document.fullscreenElement ||
      document.webkitFullscreenElement ||
      document.mozFullScreenElement ||
      document.msFullscreenElement;
  },

  fullscreenChange: function () {
    if (this.getBrowserFullscreenElement() == undefined)
      this.cancelFullscreenHelper();
  },

  slideMap: function()
  {
    this.playerDisplayContentIframe().Reveal.toggleOverview();
  },

  playerDisplayContentIframe: function() {
    return jQueryValamis("#SCORMDataOutput")[0].contentWindow;
  },

  ifReveal: function()
  { if (this.playerDisplayContentIframe().Reveal) {
      this.$el.find('#SlideMap').show();
    }
    else
    {
      this.$el.find('#SlideMap').hide();
    }
  }
});
