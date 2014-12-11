package com.arcusys.learn.scorm.rte.service

import com.arcusys.learn.bl.services.LessonLimitChecker
import com.arcusys.learn.bl.services.lesson.{ PackageServiceContract, ActivityServiceContract, PackageService }
import com.arcusys.learn.controllers.api.BaseApiController
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.net.URLDecoder
import com.arcusys.learn.scorm.manifest.model.{ ResourceUrl, LeafActivity }
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.learn.scorm.tracking.model.sequencing._
import com.arcusys.learn.service.util.LrsEndpointUtil

class SequencingService(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase {
  def this() = this(Configuration)

  val passingLimitChecker = inject[LessonLimitChecker]

  val packageManager = inject[PackageServiceContract]
  val activityManager = inject[ActivityServiceContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  // get possible navigation types, check which navigation controls should be hidden
  get("/sequencing/NavigationRules/:packageID/:currentScormActivityID") {
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("currentScormActivityID").required
    val activity = activityManager.getActivity(packageID, activityID)
    json("hiddenUI" -> activity.hiddenNavigationControls.map(_.toString)).get
  }

  post("/sequencing/Tincan/:packageID") {
    val packageID = parameter("packageID").intRequired

    val mainFileName = packageManager.getTincanLaunchWithLimitTest(packageID, getLiferayUser)

    json(Map("launchURL" -> mainFileName) ++ getEnpointData).get
  }

  get("/sequencing/NavigationRequest/:currentScormPackageID/:currentOrganizationID/:sequencingRequest") {
    val userID = getUserId.toInt
    val packageID = parameter("currentScormPackageID").intRequired
    val organizationID = parameter("currentOrganizationID").required

    if (passingLimitChecker.checkScormPackage(getLiferayUser, packageID)) {

      val currentAttempt = activityManager.getActiveAttempt(userID, packageID, organizationID)
      val tree = activityManager.getActivityStateTreeForAttemptOrCreate(currentAttempt)

      val processor = new SequencingProcessor(currentAttempt, tree)

      val sequencingRequest = URLDecoder.decode(parameter("sequencingRequest").required, "UTF-8")

      val jsonData = json(processor.process(sequencingRequest) match {
        case ProcessorResponseDelivery(tree) => {
          activityManager.updateActivityStateTree(currentAttempt.id, tree)
          val currentActivityID = tree.currentActivity.map(_.item.activity.id).getOrElse("")
          Map("currentActivity" -> currentActivityID, "endSession" -> false) ++ getActivityData(packageID, currentActivityID) ++ getEnpointData
        }
        case ProcessorResponseEndSession(tree) => {
          activityManager.updateActivityStateTree(currentAttempt.id, tree)
          activityManager.markAsComplete(currentAttempt.id)
          val currentActivityID = tree.currentActivity.map(_.item.activity.id).getOrElse("")
          Map("currentActivity" -> currentActivityID, "endSession" -> true) ++ getActivityData(packageID, currentActivityID) ++ getEnpointData
        }
      }).get

      contentType = "text/html"
      val headScriptData = scala.xml.Unparsed(
        """
        function findPlayerView(win) {
          var findPlayerTries = 0;
          while ((win.scormPlayerView == null) && (win.parent != null) && (win.parent != win)) {
            findPlayerTries++;
            if (findPlayerTries > 20) return null;
            win = win.parent;
          }
          return win.scormPlayerView;
        }

        function getPlayerView() {
          var thePlayer = findPlayerView(window);
          if ((thePlayer == null)) {
            if ((window.opener != null) && (typeof(window.opener) != "undefined"))
              thePlayer = thePlayer(window.opener);
            }
          return thePlayer;
        }
        function init(){
          getPlayerView().loadView(""" + jsonData + """);
        }""")
      <html>
        <head>
          <script language="javascript">
            { headScriptData }
          </script>
        </head>
        <body onload="init()"></body>
      </html>

    } else {
      ""
    }
  }

  post("/sequencing/setSession") {
    request.getSession.setAttribute("packageId", params("id"))
    request.getSession.setAttribute("packageType", params("type"))
    request.getSession.setAttribute("packageTitle", params("title"))
    request.getSession.setAttribute("playerID", params("playerID"))
  }
  post("/sequencing/clearSession") {
    request.getSession.removeAttribute("packageId")
    request.getSession.removeAttribute("packageType")
    request.getSession.removeAttribute("packageTitle")
    request.getSession.removeAttribute("playerID")
  }

  // private methods
  private def getActivityData(packageID: Int, id: String): Map[String, Any] = {
    val activityOption = activityManager.getActivityOption(packageID, id)
    if (activityOption.isDefined) {
      val activity = activityOption.get
      if (activity.isInstanceOf[LeafActivity]) {
        val leafActivity = activity.asInstanceOf[LeafActivity]
        val resource = activityManager.getResource(packageID, leafActivity.resourceIdentifier)
        val manifest = packageManager.getScormManifest(packageID)

        val resultedURL = if (resource.href.get.startsWith("http://") || resource.href.get.startsWith("https://")) {
          resource.href.get
        } else {
          val manifestRelativeResourceUrl = ResourceUrl(manifest.base, manifest.resourcesBase, resource.base, resource.href.get, leafActivity.resourceParameters)
          servletContext.getContextPath + "/" + FileSystemUtil.contextRelativeResourceURL(packageID, manifestRelativeResourceUrl)
        }
        Map("activityURL" -> resultedURL,
          "activityTitle" -> leafActivity.title,
          "activityDesc" -> leafActivity.title,
          "hiddenUI" -> leafActivity.hiddenNavigationControls.map(_.toString))
      } else Map()
    } else Map()
  }

  private def getEnpointData = new LrsEndpointUtil().getEnpointData(packageManager.getTincanEndpoint())
}
