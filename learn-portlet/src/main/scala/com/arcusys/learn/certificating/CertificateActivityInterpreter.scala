package com.arcusys.learn.certificating

import com.liferay.portlet.social.model.{SocialActivityFeedEntry, SocialActivity, BaseSocialActivityInterpreter}
import com.liferay.portal.theme.ThemeDisplay
import com.arcusys.learn.scorm.tracking.model.certificating.{CertificateActionType, Certificate}
import java.lang.{Exception, String}
import com.liferay.portal.kernel.util.{StringBundler, StringPool}
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.ioc.Configuration
import scala.Predef._
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.scorm.tracking.model.achivements.AchievementActivity
import com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException

object CertificateActivityInterpreter {
  val _CLASS_NAMES = Seq[String]( classOf[AchievementActivity].getName, classOf[Certificate].getName).toArray
}

class CertificateActivityInterpreter extends BaseSocialActivityInterpreter with Injectable{
  implicit val bindingModule = Configuration
  val storageFactory = inject[StorageFactoryContract]
  val achievementStorage = storageFactory.achievementStorage
  val achievementRequiredStorage = storageFactory.achievementRequiredStorage
  val achievementActivityStorage = storageFactory.achievementActivityStorage

  override protected def doInterpret(activity: SocialActivity, themeDisplay: ThemeDisplay): SocialActivityFeedEntry = {
    def interpretCertificate = {
      val creatorUserName = getUserName(activity.getUserId, themeDisplay)
      val activityType: Int = activity.getType
      var titlePattern = ""
      if (activityType == CertificateActionType.PassedCertificate.id) {
        titlePattern = "activity-passed-certificate"
      }
      else {
        titlePattern = "activity-new-certificate"
      }
      val certificate = storageFactory.certificateStorage.getByID(activity.getClassPK.toInt)
      val certificateName = if (certificate.isDefined) certificate.get.title else ""
      val title = themeDisplay.translate(titlePattern, null)
      val sb = new StringBundler(3)
      if (activityType == CertificateActionType.PassedCertificate.id) sb.append(creatorUserName + " ")
      sb.append(title + " ")
      sb.append(certificateName)
      new SocialActivityFeedEntry(StringPool.BLANK, sb.toString, StringPool.BLANK)
    }

    def interpretAchievement = {
        val userName = getUserName(activity.getUserId, themeDisplay)
        val achievementActivity = achievementActivityStorage.getByID(activity.getClassPK.toInt).getOrElse(throw new IllegalStateException("There has to be a required activity"))
        val achievementTitle = achievementStorage.getByID(achievementActivity.achievementId).map(_.title).getOrElse(throw new IllegalStateException("There has to be a required achievement"))
        new SocialActivityFeedEntry("User %s earned %s achievement".format(userName, achievementTitle), StringPool.BLANK)
    }

    //Now we check for 2 activity types only
    val t = activity
    if(activity.getClassName == classOf[Certificate].getName) interpretCertificate
    else interpretAchievement

  }

  def getClassNames()= CertificateActivityInterpreter._CLASS_NAMES
}
