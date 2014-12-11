package com.arcusys.scorm.lms

import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.learn.scorm.course.PlayerScopeRuleStorage
import com.arcusys.learn.scorm.manifest.model.ScopeType.ScopeType
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage.{ ScormPackagesStorage, PackageScopeRuleStorage }
import com.arcusys.learn.scorm.tracking.storage.AttemptStorage
import com.arcusys.learn.tincan.manifest.storage.TincanPackageStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class PackageService(implicit val bindingModule: BindingModule) extends Injectable {
  val packageRepository = inject[ScormPackagesStorage]
  val tincanPackageRepository = inject[TincanPackageStorage]
  val packageScopeRuleRepository = inject[PackageScopeRuleStorage]
  val playerScopeRuleRepository = inject[PlayerScopeRuleStorage]
  val attemptStorage = inject[AttemptStorage]

  private def getPackages(courseID: Option[Int], userID: Int) = {
    val byCourseID = packageRepository.getByCourseID(courseID)
    for {
      pack <- if (userID != 0) packageRepository.getPackagesWithUserAttempts(userID) else packageRepository.getPackagesWithAttempts
      if (byCourseID.filter(scUser => scUser.id == pack.id).size > 0)
    } yield byCourseID.filter(scUser => scUser.id == pack.id).head
  }

  def getPackagesWithAttemptsByCourseID(courseID: Long, userID: Int) = {
    getPackages(Option(courseID.toInt), userID).map(pack => Map("id" -> pack.id, "name" -> pack.title))
  }

  def getPackagesWithAttemptsByCourseIDNoMap(courseID: Long, userID: Int) = {
    getPackages(Option(courseID.toInt), userID)
  }

  def setInstanceScopeSettings(packageID: Int, visibility: Boolean, isDefault: Boolean) {
    setVisibilityAndIsDefault(packageID, ScopeType.Instance, None, visibility, isDefault)
  }

  def setSiteScopeSettings(packageID: Int, siteID: Int, visibility: Boolean, isDefault: Boolean) {
    setVisibilityAndIsDefault(packageID, ScopeType.Site, Option(siteID.toString), visibility, isDefault)
  }

  def setPageScopeSettings(packageID: Int, pageID: String, visibility: Boolean, isDefault: Boolean) {
    setVisibilityAndIsDefault(packageID, ScopeType.Page, Option(pageID), visibility, isDefault)
  }

  def setPlayerScopeSettings(packageID: Int, portletID: String, visibility: Boolean, isDefault: Boolean) {
    setVisibilityAndIsDefault(packageID, ScopeType.Player, Option(portletID), visibility, isDefault)
  }

  private def setVisibilityAndIsDefault(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean) {
    val instanceScope = packageScopeRuleRepository.get(packageID, scope, scopeID)
    instanceScope match {
      case Some(value) => packageScopeRuleRepository.update(packageID, scope, scopeID, visibility, isDefault)
      case None        => packageScopeRuleRepository.create(packageID, scope, scopeID, visibility, isDefault)
    }

  }

  def getVisiblePackages(playerID: String, companyID: Long, courseID: Int, pageID: String) = {
    val rule = playerScopeRuleRepository.get(playerID)

    val scope = if (rule.isEmpty) ScopeType.Site else rule.get.scope
    val packages = scope match {
      case ScopeType.Instance => {
        val courseIDs = getAllCourseIDs(companyID)
        packageRepository.getInstanceScopeOnlyVisible(courseIDs)
      }
      case ScopeType.Site   => packageRepository.getOnlyVisible(scope, courseID.toString)
      case ScopeType.Page   => packageRepository.getOnlyVisible(scope, pageID)
      case ScopeType.Player => packageRepository.getOnlyVisible(scope, playerID) //++  packageStorage.getOnlyVisibile(ScopeType.PlayerPersonal, playerID)
    }

    packages
  }

  def getAllCourseIDs(companyID: Long) = {
    val groups = GroupLocalServiceHelper.searchExceptPrivateSites(companyID, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
    groups.map(i => i.getGroupId.toInt).toList
  }

  def getVisibleTincanPackages(playerID: String, companyID: Long, courseID: Int, pageID: String) = {
    val rule = playerScopeRuleRepository.get(playerID)
    val scope = if (rule.isEmpty) ScopeType.Site else rule.get.scope
    val packages = scope match {
      case ScopeType.Instance => {
        val courseIDs = getAllCourseIDs(companyID)
        tincanPackageRepository.getInstanceScopeOnlyVisible(courseIDs)
      }
      case ScopeType.Site   => tincanPackageRepository.getOnlyVisibile(scope, courseID.toString)
      case ScopeType.Page   => tincanPackageRepository.getOnlyVisibile(scope, pageID)
      case ScopeType.Player => tincanPackageRepository.getOnlyVisibile(scope, playerID) //++  tincanPackageStorage.getOnlyVisibile(ScopeType.PlayerPersonal, playerID)
    }

    packages
  }

  def setPlayerScope(player: String, scope: ScopeType) {
    val rule = playerScopeRuleRepository.get(player)
    if (rule != None) playerScopeRuleRepository.update(player, scope)
    else playerScopeRuleRepository.create(player, scope)
  }

  def getDefaultPackageID(siteID: String, pageID: String, playerID: String) = {
    val playerScope = playerScopeRuleRepository.get(playerID)
    val scope = if (playerScope.isEmpty) ScopeType.Site else playerScope.get.scope
    val scopeID = scope match {
      case ScopeType.Instance => None
      case ScopeType.Site     => Option(siteID)
      case ScopeType.Page     => Option(pageID)
      case ScopeType.Player   => Option(playerID)
    }
    packageScopeRuleRepository.getDefaultPackageID(scope, scopeID)
  }

  def checkIfCompleteByUser(packageID: Option[Int], userID: Int) = {
    packageID match {
      case Some(pkg) => {
        attemptStorage.checkIfComplete(userID, pkg)
        //if (!isFinished) packageID else None
      }
      case None => false
    }
  }

  def getPackageTitle(packageID: Int, packageType: String): String = {
    if (packageID == 0) {
      return null
    }
    packageType match {
      case "scorm" => {
        val scormpackage = packageRepository.getByID(packageID)
        if (scormpackage.isDefined)
          return scormpackage.get.title
      }
      case "tincan" => {
        val tcpackage = tincanPackageRepository.getByID(packageID)
        if (tcpackage.isDefined)
          return tcpackage.get.title
      }
    }

    return null
  }

  def getPackageType(packageID: Int): String = {
    if (packageID == 0)
      return null

    val scormpackage = packageRepository.getByID(packageID)
    if (scormpackage.isDefined)
      return "scorm"

    val tcpackage = tincanPackageRepository.getByID(packageID)
    if (tcpackage.isDefined)
      return "tincan"

    return null
  }

  def IsPackageExists(packageID: Int): Boolean = {
    if (packageID == 0)
      return false

    val scormpackage = packageRepository.getByID(packageID)
    if (scormpackage.isDefined)
      return true

    val tcpackage = tincanPackageRepository.getByID(packageID)
    if (tcpackage.isDefined)
      return true

    return false
  }

}
