package com.arcusys.scorm.lms

import com.arcusys.learn.storage.impl.orbroker.StorageFactory
import com.liferay.portal.service.{RoleLocalServiceUtil, UserLocalServiceUtil}
import com.liferay.portal.model.{Role, User}
import com.arcusys.learn.scorm.manifest.model._

object PackageService {
  private def getPackages(courseID: Option[Int], userID: Int) = {
    val byCourseID = StorageFactory.packageStorage.getByCourseID(courseID)
    for {
      pack <- if (userID != 0) StorageFactory.attemptStorage.getPackagesWithUserAttempts(userID) else StorageFactory.attemptStorage.getPackagesWithAttempts
      if (byCourseID.filter(scUser=> scUser.id  == pack.id).size>0)
    } yield byCourseID.filter(scUser=> scUser.id  == pack.id).head
  }

  def getPackagesWithAttemptsByCourseID(courseID: Long, userID: Int)={
    getPackages(Option(courseID.toInt), userID).map(pack => Map("id" -> pack.id, "name" -> pack.title))
  }

  def getPackagesWithAttemptsByCourseIDNoMap(courseID: Long, userID: Int)={
    getPackages(Option(courseID.toInt), userID)
  }

  def setInstanceScopeVisibility(packageID: Int, visibility: Boolean){
    setVisibility(packageID, ScopeType.Instance, None, visibility)
  }
  def setSiteScopeVisibility(packageID: Int, siteID: Int, visibility: Boolean){
    setVisibility(packageID, ScopeType.Site, Option(siteID.toString), visibility)
  }
  def setPageScopeVisibility(packageID: Int, pageID: String, visibility: Boolean){
    setVisibility(packageID, ScopeType.Page, Option(pageID), visibility)
  }
  def setPlayerScopeVisibility(packageID: Int, portletID: String, visibility: Boolean){
    setVisibility(packageID, ScopeType.Player, Option(portletID), visibility)
  }
  private def setVisibility(packageID: Int, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean){
    val instanceScope = StorageFactory.packageScopeRuleStorage.get(packageID, scope, scopeID)
    if (instanceScope != None) { StorageFactory.packageScopeRuleStorage.update(packageID, scope, scopeID, visibility) }
    else StorageFactory.packageScopeRuleStorage.create(packageID, scope, scopeID, visibility)
  }

  def getVisiblePackages(playerID: String, courseIDs: List[Int], courseID: Int, pageID: String)={
    val rule = StorageFactory.playerScopeRuleStorage.get(playerID)
    val scope = if (rule isEmpty) ScopeType.Site else rule.get.scope
    scope match {
      case ScopeType.Instance => StorageFactory.packageStorage.getInstanceScopeOnlyVisbile(courseIDs)
      case ScopeType.Site => StorageFactory.packageStorage.getOnlyVisbile(scope, courseID.toString)
      case ScopeType.Page => StorageFactory.packageStorage.getOnlyVisbile(scope, pageID)
      case ScopeType.Player => StorageFactory.packageStorage.getOnlyVisbile(scope, playerID)
    }
  }

  def setPlayerScope(player: String, scope: String){
    val rule = StorageFactory.playerScopeRuleStorage.get(player)
    val scopeType = ScopeType.withName(scope)
    if (rule != None) StorageFactory.playerScopeRuleStorage.update(player, scopeType)
    else StorageFactory.playerScopeRuleStorage.create(player, scopeType)
  }

}
