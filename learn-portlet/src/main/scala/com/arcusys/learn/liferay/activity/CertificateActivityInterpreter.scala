package com.arcusys.learn.liferay.activity

import com.arcusys.learn.ioc.Configuration
import com.arcusys.learn.liferay.LBaseSocialActivityInterpreter
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.constants.StringPoolHelper
import com.arcusys.valamis.certificate.model.{ CertificateActionType, Certificate }
import com.arcusys.valamis.certificate.service.CertificateService
import com.escalatesoft.subcut.inject.Injectable

object CertificateActivityInterpreter {
  val className = Array(classOf[Certificate].getName)
}

class CertificateActivityInterpreter extends LBaseSocialActivityInterpreter with Injectable {
  implicit val bindingModule = Configuration
  lazy val certificateService = inject[CertificateService]

  override protected def doInterpret(activity: LSocialActivity, context: Context): LSocialActivityFeedEntry = {
    def interpretCertificate = {
      val creatorUserName = getUserName(activity.getUserId, context)
      val activityType: Int = activity.getType

      val titlePattern = if (activityType == CertificateActionType.PASSED.id) {
        "activity-passed-certificate"
      } else {
        "activity-new-certificate"
      }

      val certificate = certificateService.getById(activity.getClassPK.toInt)
      val title = context.translate(titlePattern, null)
      val sb = new StringBuilder
      if (activityType == CertificateActionType.PASSED.id) sb.append(creatorUserName + " ")
      sb.append(title + " ")
      sb.append(certificate.title)
      new LSocialActivityFeedEntry(StringPoolHelper.BLANK, sb.toString(), StringPoolHelper.BLANK)
    }

    interpretCertificate
  }

  def getClassNames() = CertificateActivityInterpreter.className
}
