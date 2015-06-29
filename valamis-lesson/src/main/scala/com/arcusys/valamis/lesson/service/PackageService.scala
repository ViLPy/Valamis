package com.arcusys.valamis.lesson.service

import com.arcusys.learn.liferay.constants.QueryUtilHelper
import com.arcusys.learn.liferay.services.GroupLocalServiceHelper
import com.arcusys.valamis.lesson.model.LessonType.LessonType
import com.arcusys.valamis.lesson.model.{ LessonType, PackageScopeRule }
import com.arcusys.valamis.lesson.scorm.storage.ScormPackagesStorage
import com.arcusys.valamis.lesson.scorm.storage.tracking.AttemptStorage
import com.arcusys.valamis.lesson.storage.{ PackageScopeRuleStorage, PlayerScopeRuleStorage }
import com.arcusys.valamis.lesson.tincan.storage.TincanPackageStorage
import com.arcusys.valamis.model.ScopeType
import com.arcusys.valamis.model.ScopeType.ScopeType
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class PackageService(implicit val bindingModule: BindingModule) extends Injectable {
  val packageRepository = inject[ScormPackagesStorage]
  val tincanPackageRepository = inject[TincanPackageStorage]
  val packageScopeRuleRepository = inject[PackageScopeRuleStorage]
  val playerScopeRuleRepository = inject[PlayerScopeRuleStorage]
  val attemptStorage = inject[AttemptStorage]

  private def getPackages(courseID: Option[Int], userID: Int) = {
    val byCourseID = packageRepository.getByCourseId(courseID)
    for {
      pack <- if (userID != 0) packageRepository.getPackagesWithUserAttempts(userID) else packageRepository.getPackagesWithAttempts
      if (byCourseID.filter(scUser => scUser.id == pack.id).size > 0)
    } yield byCourseID.filter(scUser => scUser.id == pack.id).head
  }

  def getScormPackageById(id: Long) = {
    packageRepository.getById(id)
  }
  def getTincanPackageById(id: Long) = {
    tincanPackageRepository.getById(id)
  }

  def getPackagesWithAttemptsByCourseID(courseID: Long, userID: Int) = {
    getPackages(Option(courseID.toInt), userID).map(pack => Map("id" -> pack.id, "name" -> pack.title))
  }

  def getPackagesWithAttemptsByCourseIDNoMap(courseID: Long, userID: Int) = {
    getPackages(Option(courseID.toInt), userID)
  }

  def setInstanceScopeSettings(packageId: Long, visibility: Boolean, isDefault: Boolean): PackageScopeRule = {
    setVisibilityAndIsDefault(packageId, ScopeType.Instance, None, visibility, isDefault)
  }

  def setSiteScopeSettings(packageId: Long, siteID: Int, visibility: Boolean, isDefault: Boolean): PackageScopeRule = {
    setVisibilityAndIsDefault(packageId, ScopeType.Site, Option(siteID.toString), visibility, isDefault)
  }

  def setPageScopeSettings(packageId: Long, pageID: String, visibility: Boolean, isDefault: Boolean): PackageScopeRule = {
    setVisibilityAndIsDefault(packageId, ScopeType.Page, Option(pageID), visibility, isDefault)
  }

  def setPlayerScopeSettings(packageId: Long, portletID: String, visibility: Boolean, isDefault: Boolean): PackageScopeRule = {
    setVisibilityAndIsDefault(packageId, ScopeType.Player, Option(portletID), visibility, isDefault)
  }

  private def setVisibilityAndIsDefault(packageId: Long, scope: ScopeType.Value, scopeID: Option[String], visibility: Boolean, isDefault: Boolean): PackageScopeRule = {
    val instanceScope = packageScopeRuleRepository.get(packageId, scope, scopeID)
    instanceScope match {
      case Some(value) => packageScopeRuleRepository.update(packageId, scope, scopeID, visibility, isDefault)
      case None        => packageScopeRuleRepository.create(packageId, scope, scopeID, visibility, isDefault)
    }
  }

  def getAllCourseIDs(companyID: Long) = {
    val groups = GroupLocalServiceHelper.searchExceptPrivateSites(companyID, QueryUtilHelper.ALL_POS, QueryUtilHelper.ALL_POS)
    groups.map(i => i.getGroupId.toInt).toList
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

  def checkIfCompleteByUser(packageId: Option[Long], userID: Int) = {
    packageId match {
      case Some(pkg) => {
        attemptStorage.checkIfComplete(userID, pkg)
        //if (!isFinished) packageId else None
      }
      case None => false
    }
  }

  def getPackageTitle(packageId: Long): String = {
    tincanPackageRepository.getById(packageId).map(_.title).getOrElse(
      packageRepository.getById(packageId).map(_.title).getOrElse(
        ""
      )
    )
  }

  def getPackageTitle(packageId: Long, packageType: String): String = {
    if (packageId == 0) {
      return null
    }
    packageType match {
      case "scorm" => {
        val scormpackage = packageRepository.getById(packageId)
        if (scormpackage.isDefined)
          return scormpackage.get.title
      }
      case "tincan" => {
        val tcpackage = tincanPackageRepository.getById(packageId)
        if (tcpackage.isDefined)
          return tcpackage.get.title
      }
    }

    null
  }

  def getPackageType(packageId: Long): LessonType = {
    if (packageId == 0)
      return null

    val scormpackage = packageRepository.getById(packageId)
    if (scormpackage.isDefined)
      return LessonType.Scorm

    val tcpackage = tincanPackageRepository.getById(packageId)
    if (tcpackage.isDefined)
      return LessonType.Tincan

    //TODO null???
    null
  }

  def IsPackageExists(packageId: Int): Boolean = {
    if (packageId == 0)
      return false

    val scormpackage = packageRepository.getById(packageId)
    if (scormpackage.isDefined)
      return true

    val tcpackage = tincanPackageRepository.getById(packageId)
    if (tcpackage.isDefined)
      return true

    false
  }

}
