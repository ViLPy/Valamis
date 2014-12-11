package com.arcusys.learn.liferay

import com.arcusys.learn.bl.services.settings.SiteDependentSettingManager
import com.arcusys.learn.tincan.storage.StatementStorage
import com.liferay.portal.model.BaseModelListener
import com.liferay.portlet.social.model.SocialActivity
import com.arcusys.learn.tincan.model._
import java.util.{ Date, UUID }
import com.arcusys.learn.tincan.model.Statement
import com.arcusys.learn.tincan.model.Agent
import com.arcusys.learn.tincan.model.Verb
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.ioc.Configuration
import com.liferay.portal.service.UserLocalServiceUtil
import scala.collection.JavaConverters._

class ActivityListener extends BaseModelListener[SocialActivity] with Injectable {
  implicit val bindingModule = Configuration

  private val settingManager = inject[SiteDependentSettingManager]
  private val tincanLrsStatementStorage = inject[StatementStorage]

  override def onAfterCreate(socialActivity: SocialActivity) {
    val userId = socialActivity.getUserId
    val user = UserLocalServiceUtil.getUser(userId)
    val siteID = socialActivity.getGroupId.toInt

    // check if new
    if (socialActivity.getAssetEntry == null) return

    if (socialActivity.getAssetEntry.getCreateDate != null
      && socialActivity.getAssetEntry.getModifiedDate != null
      && socialActivity.getAssetEntry.getCreateDate.compareTo(socialActivity.getAssetEntry.getModifiedDate) != 0) return

    val setting = settingManager.getSetting(siteID, socialActivity.getClassName)
    if (setting.isDefined) {
      val verb = setting.get match {
        case "completed" =>
          Verb("http://adlnet.gov/expapi/verbs/completed", Map("en" -> "completed"))
        case "attempted" =>
          Verb("http://adlnet.gov/expapi/verbs/attempted", Map("en" -> "attempted"))
        case "interacted" =>
          Verb("http://adlnet.gov/expapi/verbs/interacted", Map("en" -> "interacted"))
        case "experienced" =>
          Verb("http://adlnet.gov/expapi/verbs/experienced", Map("en" -> "experienced"))
        case _ => return
      }

      val titleMap = socialActivity.getAssetEntry.getTitleMap.asScala.filter(!_._2.isEmpty)
        .map(titleTuple => (titleTuple._1.getLanguage, titleTuple._2)).toMap[String, String]
      val descriptionMap = socialActivity.getAssetEntry.getDescriptionMap.asScala.filter(!_._2.isEmpty)
        .map(titleTuple => (titleTuple._1.getLanguage, titleTuple._2)).toMap[String, String]

      val statement = Statement(
        UUID.randomUUID(),
        Agent("Agent", Some(user.getFullName), Some(user.getEmailAddress),
          mbox_sha1sum = None,
          openid = None, // URI, IRI, IRL figure it out later!!!
          account = None),
        verb,
        Activity("Activity",
          id = "http://valamislearning.com/SocialActivity/" + socialActivity.getPrimaryKey,
          name = Some(titleMap),
          description = Some(descriptionMap),
          theType = None,
          moreInfo = None,
          interactionType = None,
          correctResponsesPattern = Set(),
          choices = Nil,
          scale = Nil,
          source = Nil,
          target = Nil,
          steps = Nil,
          extensions = None),
        result = None,
        context = None,
        timestamp = Some(new Date()),
        stored = Some(new Date()),
        authority = None,
        version = None,
        attachments = Nil
      )

      tincanLrsStatementStorage.create(statement)
    }
  }
}
