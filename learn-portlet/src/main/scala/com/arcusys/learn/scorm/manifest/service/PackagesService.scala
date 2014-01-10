package com.arcusys.learn.scorm.manifest.service

import com.arcusys.learn.scorm.manifest.model._
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.service.asset.AssetHelper
import com.liferay.portal.service.GroupLocalServiceUtil
import com.liferay.portal.util._
import com.liferay.portal.kernel.dao.orm.QueryUtil
import scala.collection.JavaConversions._
import com.arcusys.scorm.lms.PackageService
import com.arcusys.learn._
import com.arcusys.learn.service.util.{AntiSamyHelper, SessionHandler}

class PackagesService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)
  private val assetHelper = new AssetHelper()

  import storageFactory._

  def serialiseToMap(manifest : Manifest) = Map("id" -> manifest.id,
    "title" -> manifest.title,
    "summary" -> manifest.summary.map(_.replaceAll("\n", "")),
    "version" -> manifest.version,
    "visibility" -> manifest.visibility,
    "isDefault" -> manifest.isDefault,
    "type" -> "scorm")

  def serialiseToMap(manifest : tincan.manifest.model.Manifest) = Map("id" -> manifest.id,
    "title" -> manifest.title,
    "summary" -> manifest.summary.map(_.replaceAll("\n", "")),
    "version" -> "",
    "visibility" -> false,
    "isDefault" -> false,
    "type" -> "tincan")

  val jsonModel = new JsonModelBuilder[Manifest](serialiseToMap)

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

    def serialiseScormToMap(manifest:Manifest) = {
      val attempt = attemptStorage.getActive(userID, manifest.id)
      Map("id" -> manifest.id,
        "title" -> manifest.title,
        "summary" -> manifest.summary.map(_.replaceAll("\n", "")),
        "version" -> manifest.version,
        "suspendedID" -> (if (attempt.isDefined) activityStateTreeStorage.get(attempt.get.id).map(_.suspendedActivity.map(_.item.activity.id)) else None),
        "attempted" -> attempt.isDefined,
        "type" -> "scorm")
    }

    def serialiseTincanToMap(manifest : tincan.manifest.model.Manifest) = Map("id" -> manifest.id,
      "title" -> manifest.title,
      "summary" -> manifest.summary.map(_.replaceAll("\n", "")),
      "version" -> "",
      "suspendedID" -> None,
      "attempted" -> false,
      "type" -> "tincan")


    val courseID = parameter("courseID").intRequired
    val pageID = parameter("pageID").required

    // TODO need filter for tincan packages, and implement sorting (M)
    json(
      packageService.getVisiblePackages(parameter("playerID").required, getAllCourseIDs, courseID, pageID).sortBy(_.title).map(serialiseScormToMap) ++
        tincanPackageStorage.getAll.map(serialiseTincanToMap)
    )
  }

  // get all packages for Admin Instance scope
  get("/all") {
    getInInstance
  }

  private def getInInstance = {
    json(packageStorage.getAllForInstance(getAllCourseIDs).map(serialiseToMap) ++ tincanPackageStorage.getAll.map(serialiseToMap))
  }

  private def getAllCourseIDs = {
    val groups = GroupLocalServiceUtil.search(PortalUtil.getCompanyId(request), null, null, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS)
    groups.map(i => i.getGroupId.toInt).toList
  }

  // get packages for Admin Site scope
  get("/allInSite") {
    val courseID = parameter("courseID").intOption(-1)
    json(packageStorage.getByCourseID(courseID).map(serialiseToMap) ++ tincanPackageStorage.getAll.map(serialiseToMap))
  }

  // get packages, only by current CourseID (liferay siteID), visibility for current Player + Scope
  get("/getByScope") {
    val courseID = parameter("courseID").intRequired
    val scope = parameter("scope").required
    val scopeType = ScopeType.withName(scope)
    scopeType match {
      case ScopeType.Page => json(packageStorage.getByScope(courseID, scopeType, parameter("pageID").required).map(serialiseToMap) ++ tincanPackageStorage.getAll.map(serialiseToMap))
      case ScopeType.Player => json(packageStorage.getByScope(courseID, scopeType, parameter("playerID").required).map(serialiseToMap) ++ tincanPackageStorage.getAll.map(serialiseToMap))
      case ScopeType.Site => json(packageStorage.getByCourseID(Option(courseID)).map(serialiseToMap) ++ tincanPackageStorage.getAll.map(serialiseToMap))
      case ScopeType.Instance => getInInstance
    }
  }

  post("/update/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val courseID = parameter("courseID").intRequired
    val scope = parameter("scopeType").required
    val scopeType = ScopeType.withName(scope)
    updatePackageSettings(id, parameter("visibility").booleanRequired, parameter("isDefault").booleanRequired, scope, courseID)
    packageStorage.setDescriptions(id, parameter("title").required, AntiSamyHelper.sanitize(parameter("summary").required))

    scopeType match {
      case ScopeType.Site => jsonModel(packageStorage.getByID(id, courseID, scopeType, courseID.toString))
      case ScopeType.Instance => jsonModel(packageStorage.getByID(id, courseID, scopeType, ""))
    }
  }

  post("/updatePackageScopeVisibility/:id") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val scope = parameter("scopeType").required
    val scopeType = ScopeType.withName(scope)
    val courseID = parameter("courseID").intRequired
    val visibility = parameter("visibility").booleanOption("null")
    updatePackageSettings(id, visibility.getOrElse(false), parameter("isDefault").booleanRequired, scope, courseID)

    scopeType match {
      case ScopeType.Site => jsonModel(packageStorage.getByID(id, courseID, scopeType, courseID.toString))
      case ScopeType.Instance => jsonModel(packageStorage.getByID(id, courseID, scopeType, ""))
      case ScopeType.Page => jsonModel(packageStorage.getByID(id, courseID, scopeType, parameter("pageID").required))
    }
  }

  private def updatePackageSettings(id: Int, visibility: Boolean, isDefault: Boolean, scope: String, courseID: Int) {
    scope match {
      case "instanceScope" => {
        packageService.setInstanceScopeSettings(id, visibility, isDefault)
        //packageScopeRuleStorage.updateIsDefaultProperty(id, ScopeType.Instance, None, isDefault)
      }
      case "siteScope" => {
        packageService.setSiteScopeSettings(id, courseID, visibility, isDefault)
        //packageScopeRuleStorage.updateIsDefaultProperty(id, ScopeType.Site, Option(courseID.toString), isDefault)
      }
      case "pageScope" => {
        packageService.setPageScopeSettings(id, parameter("pageID").required, visibility, isDefault)
        //packageScopeRuleStorage.updateIsDefaultProperty(id, ScopeType.Page, Option(parameter("pageID").required), isDefault)
      }
      // For future "Player" scope
      //  case "player" =>{
      //  PackageService.setPlayerScopeVisibility(id, parameter("playerID").required, visibility)
      //  packageScopeRuleStorage.updateIsDefaultProperty(id, ScopeType.Player, Option(parameter("playerID").required), isDefault) }
    }
  }

  post("/delete") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val pkg = packageStorage.getByID(id)
    if (pkg.isDefined) {
      if (pkg.get.assetRefID.isDefined) assetHelper.deletePackage(pkg.get.assetRefID.get)
      packageStorage.delete(id)
      packageScopeRuleStorage.delete(id)
    }
  }

  post("/updatePlayerScope") {
    requireTeacherPermissions()

    val scope = parameter("scope").required
    val playerID = parameter("playerID").required
    packageService.setPlayerScope(playerID, scope)
  }

}
