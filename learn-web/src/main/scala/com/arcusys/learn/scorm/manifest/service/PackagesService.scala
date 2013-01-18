package com.arcusys.learn.scorm.manifest.service

import com.arcusys.learn.scorm.manifest.model._
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.util.Extensions._
import com.arcusys.learn.liferay.service.asset.AssetHelper
import com.liferay.portal.service.GroupLocalServiceUtil
import com.liferay.portal.util._
import com.liferay.portal.kernel.dao.orm.QueryUtil
import scala.collection.JavaConversions._
import com.arcusys.scorm.lms.PackageService
import com.arcusys.learn.view.liferay.LiferayHelpers

class PackagesService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[Manifest](manifest =>
    Map("id" -> manifest.id,
      "title" -> manifest.title,
      "summary" -> manifest.summary,
      "version" -> manifest.version,
      "visibility"->manifest.visibility)
  )

  // get only visible packages for Player (now only Site scope)
  get("/") {
    val userID = try {
      request.getHeader("scormUserID").toInt
    } catch {
      case n: NumberFormatException => -1
    } // default id is -1, for guests

    val jsonPackedModel = new JsonModelBuilder[Manifest](manifest => {
      val attempt = attemptStorage.getActive(userID, manifest.id)
      Map("id" -> manifest.id,
        "title" -> manifest.title,
        "summary" -> manifest.summary,
        "version" -> manifest.version,
        "suspendedID" -> (if (attempt.isDefined) activityStateTreeStorage.get(attempt.get.id).map(_.suspendedActivity.map(_.item.activity.id)) else None),
        "attempted" -> attempt.isDefined)
    })

    val courseID = parameter("courseID").intRequired;
    val pageID = parameter("pageID").required
   // jsonPackedModel(packageStorage.getOnlyVisbile(ScopeType.Site, courseID.map(_.toString)))
    jsonPackedModel(PackageService.getVisiblePackages(parameter("playerID").required, getAllCourseIDs, courseID, pageID ))
  }

  // get all packages for Admin Instance scope
  get("/all") {
    //val groups = GroupLocalServiceUtil.search(PortalUtil.getCompanyId(request), null, null, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    //val ids = groups.map(i=> i.getGroupId.toInt).toList
    jsonModel(packageStorage.getAllForInstance(getAllCourseIDs))
  }

  private def getAllCourseIDs()={
    val groups = GroupLocalServiceUtil.search(PortalUtil.getCompanyId(request), null, null, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    groups.map(i=> i.getGroupId.toInt).toList
  }

  // get packages for Admin Site scope
  get("/allInSite"){
    val courseID = parameter("courseID").intOption(-1);
    jsonModel(packageStorage.getByCourseID(courseID))
  }

  // get packages, only by current CourseID (liferay siteID), visibility for current Player + Scope
  get("/getByScope") {
    val courseID = parameter("courseID").intRequired
    val scope = parameter("scope").required
    val scopeType = ScopeType.withName(scope)
    val scopeID = scopeType match {
      case ScopeType.Page=> parameter("pageID").required
      case ScopeType.Player =>parameter("playerID").required
      case _=> ""
    }
    if (scopeID == "") jsonModel(Nil)
    else jsonModel(packageStorage.getByScope(courseID, scopeType , scopeID))
  }

  // not used?
  //get("/Sorted") {
  //  val sidx = parameter("sidx") withDefault ""
  //  val sord = parameter("sord") withDefault "asc"
  //  val courseID = parameter("courseID").intOption(-1);
  //  json(buildJSONResponse(sidx, sord, packageStorage.getByCourseID(courseID)))
  //}

  // not used?
  //post("/UpdateInstanceVisibility") {
  //  val id = parameter("id").intRequired
  //  val visibility = parameter("visibility").booleanRequired
  //  val updateAll = params.getOrElse("all", false).toString.toBoolean
  //  if (updateAll) for (manifest <- packageStorage.getAll) packageStorage.setInstanceScopeVisibility(manifest.id, visibility)
  //  else packageStorage.setInstanceScopeVisibility(id, visibility)
  //}

  // not used?
  //post("/UpdateTitle") {
   // val id = parameter("id").intRequired
   // val title = parameter("title").required
   // val summary = parameter("summary").required
   // val visibility = parameter("visibility").booleanRequired
   // val operation = parameter("oper").required

   // if (operation == "del") packageStorage.delete(id)
   // else {
   //   packageStorage.setDescriptions(id, title, summary)
   //   packageStorage.setVisibility(id, visibility)
   //   json(Map("message" -> "", "id" -> id))
   // }
  //}

  post("/update/:id") {
    val id = parameter("id").intRequired
    val title = parameter("title").required
    val summary = parameter("summary").required
    val visibility = parameter("visibility").booleanRequired
    val scope = parameter("scopeType").required
    val courseID = parameter("courseID").intRequired
    if (scope == "site")
      PackageService.setSiteScopeVisibility(id, courseID, visibility)
    else
      PackageService.setInstanceScopeVisibility(id, visibility)
    packageStorage.setDescriptions(id, title, summary)
    jsonModel(packageStorage.getByID(id))
  }

  post("/updatePackageScopeVisibility/:id") {
    val id = parameter("id").intRequired
    val visibility = parameter("visibility").booleanRequired
    val scope = parameter("scopeType").required
    if (scope == "pageScope")
      PackageService.setPageScopeVisibility(id, parameter("pageID").required, visibility)
    else
      PackageService.setPlayerScopeVisibility(id, parameter("playerID").required, visibility)
    jsonModel(packageStorage.getByID(id))
  }

  post("/delete") {
    val id = parameter("id").intRequired
    val pkg = packageStorage.getByID(id)
    if (pkg.isDefined) {
      if (pkg.get.assetRefID.isDefined) AssetHelper.deletePackage(pkg.get.assetRefID.get)
      packageStorage.delete(id)
      packageScopeRuleStorage.delete(id)
    }
  }

  post ("/updatePlayerScope"){
    val scope = parameter("scope").required
    val playerID = parameter("playerID").required
    PackageService.setPlayerScope(playerID, scope)
  }

  private def buildJSONResponse(sidx: String, sord: String, sequence: Seq[Manifest]) = {
    // sorting
    val newSeq = sidx match {
      case "title" => sequence.sortWith((e1, e2) =>
        (if (sord.equals("asc")) e1.title.toLowerCase < e2.title.toLowerCase
        else e1.title.toLowerCase > e2.title.toLowerCase))
      // or by id
      case _ => sequence.sortWith((e1, e2) =>
        (if (sord.equals("asc")) e1.id < e2.id
        else e1.id > e2.id))
    }
    // create data structure for jqGrid
    Map("total" -> 1,
      "page" -> 0,
      "records" -> newSeq.size,
      "rows" -> newSeq.map(pack => Map("id" -> pack.id,
        "cell" -> List(pack.id, pack.title, pack.summary.getOrElse("")))))
  }

}
