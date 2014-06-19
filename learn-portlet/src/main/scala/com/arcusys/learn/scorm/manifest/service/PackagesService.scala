package com.arcusys.learn.scorm.manifest.service

import com.arcusys.learn.scorm.manifest.model._
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.web.ServletBase
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.service.asset.AssetHelper
import scala.collection.JavaConversions._
import com.arcusys.scorm.lms.PackageService
import com.arcusys.learn._
import com.arcusys.learn.service.util.AntiSamyHelper
import scala.collection.JavaConverters._
import com.arcusys.learn.liferay.services._
import scala.Some
import com.arcusys.learn.scorm.manifest.model.Manifest
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.util.PortalUtilHelper

class PackagesService(configuration: BindingModule) extends ServletBase(configuration) {
  def this() = this(Configuration)

  private val assetHelper = new AssetHelper()

  import storageFactory._

  def serializeToMap(manifest: Manifest) = Map("id" -> manifest.id,
    "title" -> manifest.title,
    "summary" -> manifest.summary.map(_.replaceAll("\n", "")),
    "version" -> manifest.version,
    "visibility" -> manifest.visibility.getOrElse(false),
    "isDefault" -> manifest.isDefault,
    "type" -> "scorm",
    "logo" -> manifest.logo)

  def serializeToMap(manifest: tincan.manifest.model.Manifest) = Map("id" -> manifest.id,
    "title" -> manifest.title,
    "summary" -> manifest.summary.map(_.replaceAll("\n", "")),
    "version" -> "",
    "visibility" -> manifest.visibility.getOrElse(false),
    "isDefault" -> manifest.isDefault,
    "type" -> "tincan",
    "logo" -> manifest.logo)

  val jsonModel = new JsonModelBuilder[Manifest](serializeToMap)

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

    def serializeScormToMap(manifest: Manifest) = {
      val attempt = attemptStorage.getActive(userID, manifest.id)
      Map("id" -> manifest.id,
        "title" -> manifest.title,
        "summary" -> manifest.summary.map(_.replaceAll("\n", "")),
        "version" -> manifest.version,
        "suspendedID" -> (if (attempt.isDefined) activityStateTreeStorage.get(attempt.get.id).map(_.suspendedActivity.map(_.item.activity.id)) else None),
        "attempted" -> attempt.isDefined,
        "type" -> "scorm",
        "logo" -> manifest.logo)
    }

    def serializeTincanToMap(manifest: tincan.manifest.model.Manifest) = Map("id" -> manifest.id,
      "title" -> manifest.title,
      "summary" -> manifest.summary.map(_.replaceAll("\n", "")),
      "version" -> "",
      "suspendedID" -> None,
      "attempted" -> false,
      "type" -> "tincan",
      "logo" -> manifest.logo)

    val courseID = parameter("courseID").intRequired
    val pageID = parameter("pageID").required
    val companyID = PortalUtilHelper.getCompanyId(request)
    val filter = parameter("filter").required
    val sortBy = parameter("sortBy").required
    val sortAscDirection = parameter("sortAscDirection").booleanRequired

    val scormFiltered = packageService.getVisiblePackages(parameter("playerID").required, companyID, courseID, pageID)
      .filter(_.title.toLowerCase.contains(filter.toLowerCase))
    val scormSortedAZ = sortBy match {
      case "name" => scormFiltered.sortBy(_.title)
      case "date" => scormFiltered.sortBy(_.id)
    }
    val scormSorted = if (sortAscDirection) scormSortedAZ else scormSortedAZ.reverse

    val tincanFiltered = packageService.getVisibleTincanPackages(parameter("playerID").required, companyID, courseID, pageID)
      .filter(_.title.toLowerCase.contains(filter.toLowerCase))
    val tincanSortedAZ = sortBy match {
      case "name" => tincanFiltered.sortBy(_.title)
      case "date" => tincanFiltered.sortBy(_.id)
    }
    val tincanSorted = if (sortAscDirection) tincanSortedAZ else tincanSortedAZ.reverse
    // TODO need filter for tincan packages, and implement sorting (M)
    json(
      scormSorted.map(serializeScormToMap) ++
        tincanSorted.map(serializeTincanToMap)
    ).get
  }

  // get all packages for Admin Instance scope
  get("/all") {
    getInInstance
  }

  private def getInInstance = {
    val companyID = PortalUtilHelper.getCompanyId(request)
    val courseIds = packageService.getAllCourseIDs(companyID)
    val scormPackages = packageStorage.getAllForInstance(courseIds).map(serializeToMap)
    val tincanPackages = tincanPackageStorage.getAllForInstance(courseIds).map(serializeToMap)
    val result = json(scormPackages ++ tincanPackages).get
    result
  }

  // get packages for Admin Site scope
  get("/allInSite") {
    val courseID = parameter("courseID").intOption(-1)
    json(packageStorage.getByCourseID(courseID).map(serializeToMap) ++ tincanPackageStorage.getByCourseID(courseID).map(serializeToMap)).get
  }

  // get packages, only by current CourseID (liferay siteID), visibility for current Player + Scope
  get("/getByScope") {
    val courseID = parameter("courseID").intRequired
    val scope = parameter("scope").required
    val scopeType = ScopeType.withName(scope)
    scopeType match {
      case ScopeType.Page => {
        val pagePackages = packageStorage.getByScope(courseID, scopeType, parameter("pageID").required).map(serializeToMap)
        val tincanPackages = tincanPackageStorage.getByScope(courseID, scopeType, parameter("pageID").required).map(serializeToMap)
        json(pagePackages ++ tincanPackages).get
      }
      case ScopeType.Player => {
        val playerPackages = packageStorage.getByScope(courseID, scopeType, parameter("playerID").required).map(serializeToMap)
        val tincanPackages = tincanPackageStorage.getByScope(courseID, scopeType, parameter("playerID").required).map(serializeToMap)
        val companyID = PortalUtilHelper.getCompanyId(request)
        val courseIds = packageService.getAllCourseIDs(companyID)
        val personalPackages = packageStorage.getByExactScope(courseIds, scopeType, parameter("playerID").required).map(serializeToMap)
        val personalTincanPackages = tincanPackageStorage.getByExactScope(courseIds, scopeType, parameter("playerID").required).map(serializeToMap)
        json(playerPackages ++ tincanPackages ++ personalPackages ++ personalTincanPackages).get
      }
      case ScopeType.Site => {
        val sitePackages = packageStorage.getByCourseID(Option(courseID)).map(serializeToMap)
        val tincanPackages = tincanPackageStorage.getByCourseID(Option(courseID)).map(serializeToMap)
        json(sitePackages ++ tincanPackages).get
      }
      case ScopeType.Instance => getInInstance
    }
  }

  get("/getPersonalForPlayer/:playerID") {
    val playerID = parameter("playerID").required
    val companyID = PortalUtilHelper.getCompanyId(request)
    val courseIds = packageService.getAllCourseIDs(companyID)
    val layouts = LayoutLocalServiceHelper.getLayouts(UserLocalServiceHelper().getUser(getSessionUserID).getGroupId, true)

    val shown = packageStorage.getByExactScope(courseIds, ScopeType.Player, playerID).map(_.id)
    val personalPackages = packageStorage.getByCourseID(Some(layouts.asScala.last.getGroupId.toInt)).filter(p => !shown.contains(p.id))

    val shownTC = tincanPackageStorage.getByExactScope(courseIds, ScopeType.Player, playerID).map(_.id)
    val personalTincanPackages = tincanPackageStorage.getByCourseID(Some(layouts.asScala.last.getGroupId.toInt)).filter(p => !shownTC.contains(p.id))

    json(personalPackages.map(serializeToMap) ++ personalTincanPackages.map(serializeToMap)).get
  }

  post("/addPackageToPlayer/:playerID") {
    requireTeacherPermissions()

    val playerID = parameter("playerID").required
    val packageID = parameter("id").intRequired
    val isDefault = false
    val isVisible = true
    packageService.setPlayerScopeSettings(packageID, playerID, isVisible, isDefault)
    //updatePackageSettings(packageID, isVisible, isDefault, scope.toString, playerID)
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
      case ScopeType.Site     => jsonModel(packageStorage.getByID(id, courseID, scopeType, courseID.toString))
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
      case ScopeType.Site     => jsonModel(packageStorage.getByID(id, courseID, scopeType, courseID.toString))
      case ScopeType.Instance => jsonModel(packageStorage.getByID(id, courseID, scopeType, ""))
      case ScopeType.Page     => jsonModel(packageStorage.getByID(id, courseID, scopeType, parameter("pageID").required))
      case ScopeType.Player   => jsonModel(packageStorage.getByID(id))
    }
  }

  private def updatePackageSettings(id: Int, visibility: Boolean, isDefault: Boolean, scope: String, courseID: Int) {
    scope match {
      case "instanceScope" => {
        packageService.setInstanceScopeSettings(id, visibility, isDefault)
      }
      case "siteScope" => {
        packageService.setSiteScopeSettings(id, courseID, visibility, isDefault)
      }
      case "pageScope" => {
        packageService.setPageScopeSettings(id, parameter("pageID").required, visibility, isDefault)
      }
      case "playerScope" => {
        packageService.setPlayerScopeSettings(id, parameter("playerID").required, visibility, isDefault)
      }
    }
  }

  post("/delete") {
    requireTeacherPermissions()

    val id = parameter("id").intRequired
    val pkg = packageStorage.getByID(id)
    if (pkg.isDefined) {
      if (pkg.get.assetRefID.isDefined) assetHelper.deletePackage(pkg.get.assetRefID.get)
      packageStorage.delete(id)
    }
  }

  post("/updatePlayerScope") {
    requireTeacherPermissions()

    val scope = parameter("scope").required
    val playerID = parameter("playerID").required
    packageService.setPlayerScope(playerID, scope)
  }

}
