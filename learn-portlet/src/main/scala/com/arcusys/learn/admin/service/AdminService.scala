package com.arcusys.learn.admin.service

import java.io._
import com.arcusys.scorm.util.FileSystemUtil
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.settings.model.SettingType
import com.arcusys.learn.service.util.{TemplateUpgradeProcess}
import com.arcusys.learn.scorm.tracking.model.achivements.AchievementActivity
import scala.collection.JavaConverters._
import com.arcusys.learn.achievements.BaseWebService
import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import QueryUtilHelper._
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.tincan.model.lrsClient._
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.tincan.model.lrsClient.CommonBasicAuthorization
import scala.Some
import com.arcusys.learn.tincan.model.lrsClient.LrsEndpointSettings
import com.arcusys.learn.models.LrsSettingsRequest
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage

class AdminService(configuration: BindingModule) extends BaseWebService(configuration) {
  def this() = this(Configuration)
  val tincanLrsEndpointStorage: TincanLrsEndpointStorage = inject[TincanLrsEndpointStorage]

  before() {
    response.setHeader("Cache-control", "must-revalidate,no-cache,no-store")
    response.setHeader("Expires", "-1")
  }

  post("/demo/templates") {
    requireAdmin()
    val templates = new TemplateUpgradeProcess
    templates.doUpgrade()
  }

  post("/TincanLrsSettings") (action {
    requireAdmin()

    val lrsSettingsRequest = new LrsSettingsRequest(request)
    if(!lrsSettingsRequest.isExternalLrs) {
      tincanLrsEndpointStorage.set(None)
    } else {
      val settings = lrsSettingsRequest.authType match {

        case AuthorizationType.BASIC => if(lrsSettingsRequest.isCommonCredentials)
          CommonBasicAuthorization(
            lrsSettingsRequest.login,
            lrsSettingsRequest.password)
          else
          UserBasicAuthorization

        case AuthorizationType.OAUTH => OAuthAuthorization(
          lrsSettingsRequest.clientId,
          lrsSettingsRequest.clientSecret)
      }

      tincanLrsEndpointStorage.set(Some(
        LrsEndpointSettings(lrsSettingsRequest.endPoint, settings)))

      true
    }
  })

  post("/RenewDatabase") {
    requireAdmin()

    contentType = "text/plain"
    storageFactory.renewWholeStorage()
    SocialActivityLocalServiceHelper.getActivities(classOf[Certificate].getName, 0, Int.MaxValue).toArray.foreach(i => {
      SocialActivityLocalServiceHelper.deleteActivity(i.asInstanceOf[LSocialActivity].getActivityId)
    })

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

  post("/UpdateIssuerSettings") {
    requireAdmin()

    storageFactory.settingStorage.modify(SettingType.IssuerName, parameter("issuerName").required)
    storageFactory.settingStorage.modify(SettingType.IssuerOrganization, parameter("issuerOrganization").required)
    storageFactory.settingStorage.modify(SettingType.IssuerURL, parameter("issuerUrl").required)
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
