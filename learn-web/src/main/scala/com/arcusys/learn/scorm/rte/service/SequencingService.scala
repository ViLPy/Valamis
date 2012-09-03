package com.arcusys.learn.scorm.rte.service

import com.arcusys.learn.scorm.tracking.model.ActivityStateTree
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.net.URLDecoder
import com.arcusys.learn.scorm.manifest.model.{ResourceUrl, LeafActivity}
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.learn.scorm.tracking.model.sequencing._

class SequencingService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  // get possible navigation types, check which navigation controls should be hidden
  get("/NavigationRules/:packageID/:currentScormActivityID") {
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("currentScormActivityID").required
    val activity = activityStorage.get(packageID, activityID)
    json("hiddenUI" -> activity.getOrElse(throw new Exception("Activity not found!")).hiddenNavigationControls.map(_.toString))
  }

  get("/NavigationRequest/:currentScormPackageID/:currentOrganizationID/:sequencingRequest") {
    val userID = try {
      parameter("scormUserID").required.toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("currentScormPackageID").intRequired
    val organizationID = parameter("currentOrganizationID").required
    val currentAttempt = attemptStorage.getActive(userID, packageID) match {
      case Some(attempt) => attempt
      case None => {
        attemptStorage.createAndGetID(userID, packageID, organizationID)
        attemptStorage.getActive(userID, packageID).getOrElse(halt(404, "Okay. Check DB connection."))
      }
    }
    if (activityStateTreeStorage.get(currentAttempt.id).isEmpty) {
      val stateTree = ActivityStateTree(activityStorage.getOrganizationTree(currentAttempt.packageID, currentAttempt.organizationID), None, true, None)
      activityStateTreeStorage.create(currentAttempt.id, stateTree)
    }
    val treeOption = activityStateTreeStorage.get(currentAttempt.id)
    require(treeOption.isDefined, "Tree should exist!")
    //val currentAttempt = attemptStorage.getActive(userID, packageID).getOrElse(halt(404, "Attempt not found for this SCO and user"))
    val processor = new SequencingProcessor(currentAttempt, treeOption.get)

    val sequencingRequest = URLDecoder.decode(parameter("sequencingRequest").required, "UTF-8")

    val jsonData = json(processor.process(sequencingRequest) match {
      case ProcessorResponseDelivery(tree) => {
        activityStateTreeStorage.modify(currentAttempt.id, tree)
        val currentActivityID = tree.currentActivity.map(_.item.activity.id).getOrElse("")
        Map("currentActivity" -> currentActivityID, "endSession" -> false) ++ getActivityData(packageID, currentActivityID)
      }
      case ProcessorResponseEndSession(tree) => {
        activityStateTreeStorage.modify(currentAttempt.id, tree)
        attemptStorage.markAsComplete(currentAttempt.id)
        val currentActivityID = tree.currentActivity.map(_.item.activity.id).getOrElse("")
        Map("currentActivity" -> currentActivityID, "endSession" -> true) ++ getActivityData(packageID, currentActivityID)
      }
    })

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
          {headScriptData}
        </script>
      </head>
      <body onload="init()"></body>
    </html>
  }

  private def getActivityData(packageID: Int, id: String): Map[String, Any] = {
    val activityOption = activityStorage.get(packageID, id)
    if (activityOption.isDefined) {
      val activity = activityOption.get
      if (activity.isInstanceOf[LeafActivity]) {
        val leafActivity = activity.asInstanceOf[LeafActivity]
        val resource = resourceStorage.getByID(packageID, leafActivity.resourceIdentifier).get
        val manifest = packageStorage.getByID(packageID).get
        val manifestRelativeResourceUrl = ResourceUrl(manifest.base, manifest.resourcesBase, resource.base, resource.href.get, leafActivity.resourceParameters)
        Map("activityURL" -> (servletContext.getContextPath + "/" + FileSystemUtil.contextRelativeResourceURL(packageID, manifestRelativeResourceUrl)),
          "hiddenUI" -> leafActivity.hiddenNavigationControls.map(_.toString))
      } else Map()
    } else Map()
  }
}
