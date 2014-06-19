package com.arcusys.learn.controllers.api

import java.io._
import com.arcusys.scorm.util.FileSystemUtil
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.settings.model.SettingType
import com.arcusys.learn.service.util.{ LrsEndpointUtil, TemplateUpgradeProcess }
import com.arcusys.learn.scorm.tracking.model.achivements.AchievementActivity
import scala.collection.JavaConverters._
import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import QueryUtilHelper._
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.tincan.model.lrsClient._
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.tincan.model.lrsClient.CommonBasicAuthorization
import scala.Some
import com.arcusys.learn.tincan.model.lrsClient.LrsEndpointSettings
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.models.request.{ AdminActionType, AdminRequest }
import com.arcusys.learn.setting.storage.SettingStorage

class AdminApiController(configuration: BindingModule) extends BaseApiController(configuration) {
  def this() = this(Configuration)
  def tincanLrsEndpointStorage: TincanLrsEndpointStorage = inject[TincanLrsEndpointStorage]
  def settingStorage: SettingStorage = inject[SettingStorage]

  get("/TincanLrsSettings") {
    val settings = tincanLrsEndpointStorage.get
    jsonAction(new LrsEndpointUtil().getEnpointData(settings))
  }

  post("/demo/templates")(action {
    requireAdmin()
    val templates = new TemplateUpgradeProcess
    templates.doUpgrade()
  })

  post("/TincanLrsSettings")(jsonAction {
    //val user = getLiferayUser

    requireAdmin()

    val adminRequest = AdminRequest(this)
    if (!adminRequest.isExternalLrs) {
      tincanLrsEndpointStorage.set(None)
    } else {
      val settings = adminRequest.authType match {

        case AuthorizationType.BASIC => if (adminRequest.isCommonCredentials)
          CommonBasicAuthorization(
            adminRequest.login,
            adminRequest.password)
        else
          UserBasicAuthorization

        case AuthorizationType.OAUTH => OAuthAuthorization(
          adminRequest.clientId,
          adminRequest.clientSecret)
      }

      tincanLrsEndpointStorage.set(Some(
        LrsEndpointSettings(adminRequest.endPoint, settings)))

      true
    }
  })

  post("/")(action {
    requireAdmin()

    val adminRequest = AdminRequest(this)
    adminRequest.actionType match {
      case AdminActionType.RENEW_DATABASE         => renewDatabase()
      case AdminActionType.UPDATE_ISSUER_SETTINGS => updateIssuerSettings(adminRequest)
    }
  })

  private def renewDatabase() = {
    contentType = "text/plain"
    storageFactory.renewWholeStorage()
    SocialActivityLocalServiceHelper
      .getActivities(classOf[Certificate].getName, 0, Int.MaxValue)
      .toArray
      .foreach(i => SocialActivityLocalServiceHelper.deleteActivity(i.asInstanceOf[LSocialActivity].getActivityId))

    //Also remove all achievement activities
    SocialActivityLocalServiceHelper
      .getActivities(classOf[AchievementActivity].getName, ALL_POS, ALL_POS)
      .asScala
      .foreach(socialActivity => SocialActivityLocalServiceHelper.deleteActivity(socialActivity.getActivityId))

    if (emptyDir(new File(FileSystemUtil.getRealPath("/SCORMData/tmp"))))
      "yep"
    else
      throw new Exception("Can't remove all files!")
  }

  private def updateIssuerSettings(adminRequest: AdminRequest.Model) = {
    settingStorage.modify(SettingType.IssuerName, adminRequest.issuerName)
    settingStorage.modify(SettingType.IssuerOrganization, adminRequest.issuerOrganization)
    settingStorage.modify(SettingType.IssuerURL, adminRequest.issuerUrl)
  }

  private def emptyDir(dir: File): Boolean = {
    if (dir.isDirectory)
      for (item <- dir.list())
        if (!deleteDir(new File(dir, item))) return false
    true
  }

  private def deleteDir(dir: File): Boolean = {
    if (dir.isDirectory)
      for (item <- dir.list())
        if (!deleteDir(new File(dir, item))) return false
    dir.delete
  }
}
