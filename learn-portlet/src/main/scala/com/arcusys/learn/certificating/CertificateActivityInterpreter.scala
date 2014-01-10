package com.arcusys.learn.certificating

import com.liferay.portlet.social.model.{SocialActivityFeedEntry, SocialActivity, BaseSocialActivityInterpreter}
import com.liferay.portal.theme.ThemeDisplay
import com.arcusys.learn.scorm.tracking.model.certificating.{CertificateActionType, Certificate}
import java.lang.String
import com.liferay.portal.kernel.util.{StringBundler, StringPool}
import com.escalatesoft.subcut.inject.Injectable
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.ioc.Configuration

object CertificateActivityInterpreter {
  val _CLASS_NAMES = Seq[String]( classOf[Certificate].getName).toArray
}

class CertificateActivityInterpreter extends BaseSocialActivityInterpreter with Injectable{
  implicit val bindingModule = Configuration
  val storageFactory = inject[StorageFactoryContract]

  override protected def doInterpret(activity: SocialActivity, themeDisplay: ThemeDisplay): SocialActivityFeedEntry = {
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
    return new SocialActivityFeedEntry(StringPool.BLANK, sb.toString, StringPool.BLANK)
  }

  def getClassNames()= CertificateActivityInterpreter._CLASS_NAMES
}
