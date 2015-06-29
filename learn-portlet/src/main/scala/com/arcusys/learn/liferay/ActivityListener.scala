package com.arcusys.learn.liferay

import java.util.UUID
import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.util.PortalUtilHelper
import com.arcusys.valamis.certificate.service.CertificateCompletionChecker
import com.arcusys.valamis.lrs.service.LrsClientManager
import com.arcusys.valamis.lrs.tincan._
import com.arcusys.valamis.settings.service.SiteDependentSettingServiceImpl
import com.escalatesoft.subcut.inject.Injectable
import com.liferay.portal.model.BaseModelListener
import com.liferay.portal.service.UserLocalServiceUtil
import com.liferay.portal.util.PortalUtil
import com.liferay.portlet.social.model.SocialActivity
import java.util.Locale
import scala.collection.JavaConverters._

class ActivityListener extends BaseModelListener[SocialActivity] with Injectable {
  implicit val bindingModule = Configuration

  private def settingManager = inject[SiteDependentSettingServiceImpl]
  private def lrsReader = inject[LrsClientManager]
  private val certificateCompletionListener = inject[CertificateCompletionChecker]

  override def onAfterCreate(socialActivity: SocialActivity) {
    val userId = socialActivity.getUserId
    val user = UserLocalServiceUtil.getUser(userId)
    val siteId = socialActivity.getGroupId.toInt

    certificateCompletionListener.toggleRequestedCertificatesStatus(userId = Some(userId))
    // check if new
    if (socialActivity.getAssetEntry == null) return

    if (socialActivity.getAssetEntry.getCreateDate != null
      && socialActivity.getAssetEntry.getModifiedDate != null
      && socialActivity.getAssetEntry.getCreateDate.compareTo(socialActivity.getAssetEntry.getModifiedDate) != 0) return

    val setting = settingManager.getSetting(siteId, socialActivity.getClassName)
    if (setting.isDefined) {
      val verb = setting.get match {
        case "completed" =>
          Verb("http://adlnet.gov/expapi/verbs/completed", Map(Locale.US.toLanguageTag() -> "completed"))
        case "attempted" =>
          Verb("http://adlnet.gov/expapi/verbs/attempted", Map(Locale.US.toLanguageTag()-> "attempted"))
        case "interacted" =>
          Verb("http://adlnet.gov/expapi/verbs/interacted", Map(Locale.US.toLanguageTag() -> "interacted"))
        case "experienced" =>
          Verb("http://adlnet.gov/expapi/verbs/experienced", Map(Locale.US.toLanguageTag() -> "experienced"))
        case _ => return
      }

      val titleMap = socialActivity.getAssetEntry.getTitleMap.asScala.filter(!_._2.isEmpty)
        .map(titleTuple => (titleTuple._1.getLanguage, titleTuple._2)).toMap[String, String]
      val descriptionMap = socialActivity.getAssetEntry.getDescriptionMap.asScala.filter(!_._2.isEmpty)
        .map(titleTuple => (titleTuple._1.getLanguage, titleTuple._2)).toMap[String, String]

      val statement = Statement(
        Option(UUID.randomUUID),
        Agent(
          name = Some(user.getFullName),
          mBox = Some("mailto:" + user.getEmailAddress)),
        verb,
        Activity(
          id = s"http://valamislearning.com/SocialActivity/${socialActivity.getPrimaryKey}",
          name = Some(titleMap),
          description = Some(descriptionMap))
      )
      val lrsAuth = lrsReader.getLrsEndpointInfo(AuthorizationScope.All).auth
      lrsReader.statementApi(_.addStatement(statement), lrsAuth)
    }
  }
}
