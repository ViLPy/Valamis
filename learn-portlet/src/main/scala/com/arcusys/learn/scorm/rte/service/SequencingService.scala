package com.arcusys.learn.scorm.rte.service

import com.arcusys.learn.scorm.tracking.model.ActivityStateTree
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import java.net.URLDecoder
import com.arcusys.learn.scorm.manifest.model.{ResourceUrl, LeafActivity}
import com.arcusys.scorm.util.FileSystemUtil
import com.arcusys.learn.scorm.tracking.model.sequencing._
import com.arcusys.learn.tincan.model.{CommonBasicAuthorization, UserBasicAuthorization, LrsEndpointSettings}
import javax.xml.bind.DatatypeConverter

class SequencingService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  // get possible navigation types, check which navigation controls should be hidden
  get("/NavigationRules/:packageID/:currentScormActivityID") {
    val packageID = parameter("packageID").intRequired
    val activityID = parameter("currentScormActivityID").required
    val activity = activityStorage.get(packageID, activityID)
    json("hiddenUI" -> activity.getOrElse(throw new Exception("Activity not found!")).hiddenNavigationControls.map(_.toString))
  }

  post("/Tincan/:packageID") {
    val userID = try {
      parameter("scormUserID").required.toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests
    val packageID = parameter("packageID").intRequired

    val tincanPackage = tincanPackageStorage.getByID(packageID).get
    val activities = tincanActivityStorage.getByPackageID(packageID)
    val firstActivity = activities.find(a => a.launch != null && !a.launch.isEmpty).getOrElse(throw new UnsupportedOperationException("tincan package without launch not supported"))

    val mainFileName = "data/" + tincanPackage.id + "/" + firstActivity.launch.get

    tincanLrsEndpointStorage.get match {
      case Some(LrsEndpointSettings(endpoint, CommonBasicAuthorization(loginName, password))) => {
        json(Map(
          "launchURL" -> mainFileName,
          "endpoint" -> endpoint.trim,
          "authType" -> "Basic",
          "auth" -> ("Basic " + DatatypeConverter.printBase64Binary((loginName + ":" + password).toCharArray.map(_.toByte)))
        ))
      }
      case Some(LrsEndpointSettings(endpoint, UserBasicAuthorization)) => {
        json(Map(
          "launchURL" -> mainFileName,
          "endpoint" -> endpoint.trim,
          "authType" -> "Basic"
        ))
      }
      case None =>{
        json(Map("" +
          "internal" -> true,
          "launchURL" -> mainFileName,
          "authType" -> "Basic",
          "auth" -> ("Basic " + DatatypeConverter.printBase64Binary(("loginName" + ":" + "password").toCharArray.map(_.toByte)))
        ))
      }
      case _ => throw new UnsupportedOperationException()
    }

//    val lrsSettings = tincanLrsEndpointStorage.get
//
//    if (lrsSettings.isEmpty) {
//      throw new UnsupportedOperationException()
//    }
//
//    json(Map(
//      "launchURL" -> mainFileName,
//      "endpoint" -> lrsSettings.get.endpoint,
//      "authType" -> lrsSettings.get.authType,
//      "auth" -> (if (lrsSettings.get.loginName.isEmpty || lrsSettings.get.password.isEmpty) "None"
//      else "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary((lrsSettings.get.loginName.get + ":" + lrsSettings.get.password.get).toCharArray.map(_.toByte)))
//    ))
  }

  get("/NavigationRequest/:currentScormPackageID/:currentOrganizationID/:sequencingRequest") {
    val userID = try {
      parameter("scormUserID").required.toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests

    if (userID > 0 && getSessionUserID != userID) halt(401, userID + " not found")

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

        val resultedURL = if (resource.href.get.startsWith("http://") || resource.href.get.startsWith("https://")) {
          resource.href.get
        } else {
          val manifestRelativeResourceUrl = ResourceUrl(manifest.base, manifest.resourcesBase, resource.base, resource.href.get, leafActivity.resourceParameters)
          servletContext.getContextPath + "/" + FileSystemUtil.contextRelativeResourceURL(packageID, manifestRelativeResourceUrl)
        }
        Map("activityURL" -> resultedURL,
          "hiddenUI" -> leafActivity.hiddenNavigationControls.map(_.toString))
      } else Map()
    } else Map()
  }

  post("/setSession") {
    request.getSession.setAttribute("packageId", params("id"))
    request.getSession.setAttribute("packageType", params("type"))
    request.getSession.setAttribute("packageTitle", params("title"))
    request.getSession.setAttribute("playerID", params("playerID"))
  }
  post("/clearSession") {
    request.getSession.removeAttribute("packageId")
    request.getSession.removeAttribute("packageType")
    request.getSession.removeAttribute("packageTitle")
    request.getSession.removeAttribute("playerID")
  }
}
