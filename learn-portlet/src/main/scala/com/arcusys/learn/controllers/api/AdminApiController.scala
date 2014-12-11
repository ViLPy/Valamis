package com.arcusys.learn.controllers.api

import java.io._
import com.arcusys.learn.bl.services.lesson.PackageServiceContract
import com.arcusys.learn.bl.services.settings.SettingServiceContract
import com.arcusys.learn.bl.utils.TemplateUpgradeProcess
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.web.ServletBase
import com.arcusys.scorm.util.FileSystemUtil
import com.escalatesoft.subcut.inject.BindingModule
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.service.util.LrsEndpointUtil
import com.arcusys.learn.scorm.tracking.model.achivements.AchievementActivity
import scala.collection.JavaConverters._
import com.arcusys.learn.liferay.services.SocialActivityLocalServiceHelper
import com.arcusys.learn.liferay.constants.QueryUtilHelper
import QueryUtilHelper._
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.tincan.model.lrsClient._
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.tincan.model.lrsClient.CommonBasicAuthorization
import com.arcusys.learn.tincan.model.lrsClient.LrsEndpointSettings
import com.arcusys.learn.models.request.{ AdminActionType, AdminRequest }

class AdminApiController(configuration: BindingModule) extends BaseApiController(configuration) with ServletBase {
  def this() = this(Configuration)

  lazy val packageManager = inject[PackageServiceContract]
  lazy val settingsManager = inject[SettingServiceContract]

  before() {
    scentry.authenticate(LIFERAY_STRATEGY_NAME)
  }

  get("/administering/TincanLrsSettings") {
    val settings = packageManager.getTincanEndpoint()
    jsonAction(new LrsEndpointUtil().getEnpointData(settings))
  }

  post("/administering/demo/templates")(action {
    requireAdmin()
    val templates = new TemplateUpgradeProcess
    templates.doUpgrade()
  })

  post("/administering/TincanLrsSettings")(jsonAction {
    requireAdmin()

    val adminRequest = AdminRequest(this)
    if (!adminRequest.isExternalLrs) {
      packageManager.removeTincanEndpoint()
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

      packageManager.setTincanEndpoint(
        LrsEndpointSettings(adminRequest.endPoint, settings)
      )
      true
    }
  })

  post("/administering(/)")(action {
    requireAdmin()

    val adminRequest = AdminRequest(this)
    adminRequest.actionType match {
      case AdminActionType.RENEW_DATABASE         => renewDatabase()
      case AdminActionType.UPDATE_ISSUER_SETTINGS => updateIssuerSettings(adminRequest)
      case AdminActionType.UPDATE_EMAIL_SETTINGS  => updateEmailSettings(adminRequest)
    }
  })

  private def renewDatabase() = {
    contentType = "text/plain"
    inject[StorageFactoryContract].renewWholeStorage
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
    settingsManager.setIssuerName(adminRequest.issuerName)
    settingsManager.setIssuerOrganization(adminRequest.issuerOrganization)
    settingsManager.setIssuerURL(adminRequest.issuerUrl)
  }

  private def updateEmailSettings(adminRequest: AdminRequest.Model) = {
    settingsManager.setSendMessages(adminRequest.sendMessages.toBoolean)
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
