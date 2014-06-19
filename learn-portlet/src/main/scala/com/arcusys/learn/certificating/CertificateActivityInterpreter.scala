package com.arcusys.learn.certificating

import com.arcusys.learn.scorm.tracking.model.certificating.CertificateActionType
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.ioc.Configuration
import scala.Predef._
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.scorm.tracking.model.achivements.AchievementActivity
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.StringPoolHelper
import com.arcusys.learn.scorm.certificating.CertificateRepositoryContract

object CertificateActivityInterpreter {
  val _CLASS_NAMES = Seq[String](classOf[AchievementActivity].getName, classOf[Certificate].getName).toArray
}

class CertificateActivityInterpreter extends LBaseSocialActivityInterpreter with Injectable {
  implicit val bindingModule = Configuration
  val storageFactory = inject[StorageFactoryContract]
  val certificateRepository = inject[CertificateRepositoryContract]
  val achievementStorage = storageFactory.achievementStorage
  val achievementRequiredStorage = storageFactory.achievementRequiredStorage
  val achievementActivityStorage = storageFactory.achievementActivityStorage

  override protected def doInterpret(activity: LSocialActivity, themeDisplay: LThemeDisplay): LSocialActivityFeedEntry = {
    def interpretCertificate = {
      val creatorUserName = getUserName(activity.getUserId, themeDisplay)
      val activityType: Int = activity.getType
      var titlePattern = ""
      if (activityType == CertificateActionType.PASSED.id) {
        titlePattern = "activity-passed-certificate"
      } else {
        titlePattern = "activity-new-certificate"
      }
      val certificate = certificateRepository.get(("id" -> activity.getClassPK.toInt))
      val title = themeDisplay.translate(titlePattern, null)
      val sb = new StringBuilder
      if (activityType == CertificateActionType.PASSED.id) sb.append(creatorUserName + " ")
      sb.append(title + " ")
      sb.append(certificate.title)
      new LSocialActivityFeedEntry(StringPoolHelper.BLANK, sb.toString(), StringPoolHelper.BLANK)
    }

    def interpretAchievement = {
      val userName = getUserName(activity.getUserId, themeDisplay)
      val achievementActivity = achievementActivityStorage.getByID(activity.getClassPK.toInt).getOrElse(throw new IllegalStateException("There has to be a required activity"))
      val achievementTitle = achievementStorage.getByID(achievementActivity.achievementId).map(_.title).getOrElse(throw new IllegalStateException("There has to be a required achievement"))
      new LSocialActivityFeedEntry("User %s earned %s achievement".format(userName, achievementTitle), StringPoolHelper.BLANK)
    }

    //Now we check for 2 activity types only
    val t = activity
    if (activity.getClassName == classOf[Certificate].getName) interpretCertificate
    else interpretAchievement

  }

  def getClassNames() = CertificateActivityInterpreter._CLASS_NAMES
}
