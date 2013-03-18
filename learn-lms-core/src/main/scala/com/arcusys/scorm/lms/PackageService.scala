package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.manifest.model._
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract

class PackageService(implicit val bindingModule: BindingModule) extends Injectable {
  val storageFactory = inject[StorageFactoryContract]

  private def getPackages(courseID: Option[Int], userID: Int) = {
    val byCourseID = storageFactory.packageStorage.getByCourseID(courseID)
    for {
      pack <- if (userID != 0) storageFactory.attemptStorage.getPackagesWithUserAttempts(userID) else storageFactory.attemptStorage.getPackagesWithAttempts
      if (byCourseID.filter(scUser => scUser.id == pack.id).size > 0)
    } yield byCourseID.filter(scUser => scUser.id == pack.id).head
  }

  def getPackagesWithAttemptsByCourseID(courseID: Long, userID: Int) = {
    getPackages(Option(courseID.toInt), userID).map(pack => Map("id" -> pack.id, "name" -> pack.title))
  }

  def getPackagesWithAttemptsByCourseIDNoMap(courseID: Long, userID: Int) = {
    getPackages(Option(courseID.toInt), userID)
  }

  def setInstanceScopeVisibility(packageID: Int, visibility: Boolean) {
    setVisibility(packageID, ScopeType.Instance, None, visibility)
  }

  def setSiteScopeVisibility(packageID: Int, siteID: Int, visibility: Boolean) {
    setVisibility(packageID, ScopeType.Site, Option(siteID.toString), visibility)
  }

  def setPageScopeVisibility(packageID: Int, pageID: String, visibility: Boolean) {
    setVisibility(packageID, ScopeType.Page, Option(pageID), visibility)
  }

  def setPlayerScopeVisibility(packageID: Int, portletID: String, visibility: Boolean) {
    setVisibility(packageID, ScopeType.Player, Option(portletID), visibility)
  }

  private def setVisibility(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean) {
    val instanceScope = storageFactory.packageScopeRuleStorage.get(packageID, scope, scopeID)
    if (instanceScope != None) {
      storageFactory.packageScopeRuleStorage.update(packageID, scope, scopeID, visibility)
    }
    else storageFactory.packageScopeRuleStorage.create(packageID, scope, scopeID, visibility)
  }

  def getVisiblePackages(playerID: String, courseIDs: List[Int], courseID: Int, pageID: String) = {
    val rule = storageFactory.playerScopeRuleStorage.get(playerID)
    val scope = if (rule isEmpty) ScopeType.Site else rule.get.scope
    scope match {
      case ScopeType.Instance => storageFactory.packageStorage.getInstanceScopeOnlyVisbile(courseIDs)
      case ScopeType.Site => storageFactory.packageStorage.getOnlyVisbile(scope, courseID.toString)
      case ScopeType.Page => storageFactory.packageStorage.getOnlyVisbile(scope, pageID)
      case ScopeType.Player => storageFactory.packageStorage.getOnlyVisbile(scope, playerID)
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

  def getPackageTitle(packageID: Int) = {
    if (packageID != 0) storageFactory.packageStorage.getByID(packageID).get.title
  }


}
