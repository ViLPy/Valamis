package com.arcusys.learn.scorm.manifest.service

import com.arcusys.learn.scorm.manifest.model._
import org.scala_tools.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.service.asset.AssetHelper
import com.liferay.portal.service.GroupLocalServiceUtil
import com.liferay.portal.util._
import com.liferay.portal.kernel.dao.orm.QueryUtil
import scala.collection.JavaConversions._
import com.arcusys.scorm.lms.PackageService

class PackagesService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  import storageFactory._

  val jsonModel = new JsonModelBuilder[Manifest](manifest =>
    Map("id" -> manifest.id,
      "title" -> manifest.title,
      "summary" -> manifest.summary,
      "version" -> manifest.version,
      "visibility" -> manifest.visibility,
      "isDefault" -> manifest.isDefault)
  )

  private val packageService = new PackageService()

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

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

    val courseID = parameter("courseID").intRequired
    val pageID = parameter("pageID").required
    jsonPackedModel(packageService.getVisiblePackages(parameter("playerID").required, getAllCourseIDs, courseID, pageID))
  }

  // get all packages for Admin Instance scope
  get("/all") {
    getInInstance
  }

  private def getInInstance = {
    jsonModel(packageStorage.getAllForInstance(getAllCourseIDs))
  }

  private def getAllCourseIDs = {
    val groups = GroupLocalServiceUtil.search(PortalUtil.getCompanyId(request), null, null, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS)
    groups.map(i => i.getGroupId.toInt).toList
  }

  // get packages for Admin Site scope
  get("/allInSite") {
    val courseID = parameter("courseID").intOption(-1)
    jsonModel(packageStorage.getByCourseID(courseID))
  }

  // get packages, only by current CourseID (liferay siteID), visibility for current Player + Scope
  get("/getByScope") {
    val courseID = parameter("courseID").intRequired
    val scope = parameter("scope").required
    val scopeType = ScopeType.withName(scope)
    scopeType match {
      case ScopeType.Page => jsonModel(packageStorage.getByScope(courseID, scopeType, parameter("pageID").required))
      case ScopeType.Player => jsonModel(packageStorage.getByScope(courseID, scopeType, parameter("playerID").required))
      case ScopeType.Site => jsonModel(packageStorage.getByCourseID(Option(courseID)))
      case ScopeType.Instance => getInInstance
    }
  }

  post("/update/:id") {
    val id = parameter("id").intRequired
    val courseID = parameter("courseID").intRequired
    val scope = parameter("scopeType").required
    val scopeType = ScopeType.withName(scope)
    updatePackageSettings(id, parameter("visibility").booleanRequired, parameter("isDefault").booleanRequired, scope, courseID)
    packageStorage.setDescriptions(id, parameter("title").required, parameter("summary").required)

    scopeType match {
      case ScopeType.Site => jsonModel(packageStorage.getByID(id, courseID, scopeType, courseID.toString))
      case ScopeType.Instance => jsonModel(packageStorage.getByID(id, courseID, scopeType, ""))
    }
  }

  post("/updatePackageScopeVisibility/:id") {
    val id = parameter("id").intRequired
    val scope = parameter("scopeType").required
    val scopeType = ScopeType.withName(scope)
    val courseID = parameter("courseID").intRequired
    updatePackageSettings(id, parameter("visibility").booleanRequired, parameter("isDefault").booleanRequired, scope, courseID)

    scopeType match {
      case ScopeType.Site => jsonModel(packageStorage.getByID(id, courseID, scopeType, courseID.toString))
      case ScopeType.Instance => jsonModel(packageStorage.getByID(id, courseID, scopeType, ""))
      case ScopeType.Page => jsonModel(packageStorage.getByID(id, courseID, scopeType, parameter("pageID").required))
    }
  }

  private def updatePackageSettings(id: Int, visibility: Boolean, isDefault: Boolean, scope: String, courseID: Int) {
    scope match {
      case "instanceScope" => {
        packageService.setInstanceScopeVisibility(id, visibility)
        packageScopeRuleStorage.updateIsDefaultProperty(id, ScopeType.Instance, None, isDefault)
      }
      case "siteScope" => {
        packageService.setSiteScopeVisibility(id, courseID, visibility)
        packageScopeRuleStorage.updateIsDefaultProperty(id, ScopeType.Site, Option(courseID.toString), isDefault)
      }
      case "pageScope" => {
        packageService.setPageScopeVisibility(id, parameter("pageID").required, visibility)
        packageScopeRuleStorage.updateIsDefaultProperty(id, ScopeType.Page, Option(parameter("pageID").required), isDefault)
      }
      // For future "Player" scope
      //  case "player" =>{
      //  PackageService.setPlayerScopeVisibility(id, parameter("playerID").required, visibility)
      //  packageScopeRuleStorage.updateIsDefaultProperty(id, ScopeType.Player, Option(parameter("playerID").required), isDefault) }
    }
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

  post("/updatePlayerScope") {
    val scope = parameter("scope").required
    val playerID = parameter("playerID").required
    packageService.setPlayerScope(playerID, scope)
  }

}
