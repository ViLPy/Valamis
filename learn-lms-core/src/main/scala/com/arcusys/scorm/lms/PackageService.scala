package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.manifest.model._
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract

class PackageService(implicit val bindingModule: BindingModule) extends Injectable {
  val storageFactory = inject[StorageFactoryContract]

  private def getPackages(courseID: Option[Int], userID: Int) = {
    val byCourseID = storageFactory.packageStorage.getByCourseID(courseID)
    for {
      pack <- if (userID != 0) storageFactory.packageStorage.getPackagesWithUserAttempts(userID) else storageFactory.packageStorage.getPackagesWithAttempts
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
    val instanceScope = storageFactory.packageScopeRuleStorage.get(packageID, scope, scopeID)
    if (instanceScope != None) {
      storageFactory.packageScopeRuleStorage.update(packageID, scope, scopeID, visibility, isDefault)
    }
    else storageFactory.packageScopeRuleStorage.create(packageID, scope, scopeID, visibility, isDefault)
  }

  def getVisiblePackages(playerID: String, courseIDs: List[Int], courseID: Int, pageID: String) = {
    val rule = storageFactory.playerScopeRuleStorage.get(playerID)
    val scope = if (rule.isEmpty) ScopeType.Site else rule.get.scope
    scope match {
      case ScopeType.Instance => storageFactory.packageStorage.getInstanceScopeOnlyVisible(courseIDs)
      case ScopeType.Site => storageFactory.packageStorage.getOnlyVisible(scope, courseID.toString)
      case ScopeType.Page => storageFactory.packageStorage.getOnlyVisible(scope, pageID)
      case ScopeType.Player => storageFactory.packageStorage.getOnlyVisible(scope, playerID) //++ storageFactory.packageStorage.getOnlyVisibile(ScopeType.PlayerPersonal, playerID)
    }
  }

  def getVisibleTincanPackages(playerID: String, courseIDs: List[Int], courseID: Int, pageID: String) = {
    val rule = storageFactory.playerScopeRuleStorage.get(playerID)
    val scope = if (rule.isEmpty) ScopeType.Site else rule.get.scope
    scope match {
      case ScopeType.Instance => storageFactory.tincanPackageStorage.getInstanceScopeOnlyVisible(courseIDs)
      case ScopeType.Site => storageFactory.tincanPackageStorage.getOnlyVisibile(scope, courseID.toString)
      case ScopeType.Page => storageFactory.tincanPackageStorage.getOnlyVisibile(scope, pageID)
      case ScopeType.Player => storageFactory.tincanPackageStorage.getOnlyVisibile(scope, playerID) //++ storageFactory.tincanPackageStorage.getOnlyVisibile(ScopeType.PlayerPersonal, playerID)
    }
  }

  def setPlayerScope(player: String, scope: String) {
    val rule = storageFactory.playerScopeRuleStorage.get(player)
    val scopeType = ScopeType.withName(scope)
    if (rule != None) storageFactory.playerScopeRuleStorage.update(player, scopeType)
    else storageFactory.playerScopeRuleStorage.create(player, scopeType)
  }

  def getDefaultPackageID(siteID: String, pageID: String, playerID: String) = {
    val playerScope = storageFactory.playerScopeRuleStorage.get(playerID)
    val scope = if (playerScope.isEmpty) ScopeType.Site else playerScope.get.scope
    val scopeID = scope match {
      case ScopeType.Instance => None
      case ScopeType.Site => Option(siteID)
      case ScopeType.Page => Option(pageID)
      case ScopeType.Player => Option(playerID)
    }
    storageFactory.packageScopeRuleStorage.getDefaultPackageID(scope, scopeID)
  }

  def checkIfCompleteByUser(packageID: Option[Int], userID: Int) = {
    packageID match {
      case Some(pkg) => {
        storageFactory.attemptStorage.checkIfComplete(userID, pkg)
        //if (!isFinished) packageID else None
      }
      case None => false
    }
  }

  def getPackageTitle(packageID: Int, packageType: String):String = {
    if (packageID == 0) {
      return null
    }
    packageType match {
      case "scorm" => {
        val scormpackage = storageFactory.packageStorage.getByID(packageID)
        if (scormpackage.isDefined)
          return scormpackage.get.title
      }
      case "tincan" => {
        val tcpackage = storageFactory.tincanPackageStorage.getByID(packageID)
        if (tcpackage.isDefined)
          return tcpackage.get.title
      }
    }

    return null
  }

  def getPackageType(packageID: Int): String = {
    if (packageID == 0)
      return null

    val scormpackage = storageFactory.packageStorage.getByID(packageID)
    if (scormpackage.isDefined)
      return "scorm"

    val tcpackage = storageFactory.tincanPackageStorage.getByID(packageID)
    if (tcpackage.isDefined)
      return "tincan"

    return null
  }

  def IsPackageExists(packageID: Int): Boolean = {
    if (packageID == 0)
      return false

    val scormpackage = storageFactory.packageStorage.getByID(packageID)
    if (scormpackage.isDefined)
      return true

    val tcpackage = storageFactory.tincanPackageStorage.getByID(packageID)
    if (tcpackage.isDefined)
      return true

    return false
  }


}
