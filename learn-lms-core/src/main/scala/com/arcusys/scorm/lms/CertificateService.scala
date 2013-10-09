package com.arcusys.scorm.lms

import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil
import com.arcusys.learn.scorm.tracking.model.certificating._
import com.liferay.portal.kernel.util.{UnicodeProperties, StringPool}
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract
import com.liferay.portlet.social.model.SocialActivity
import com.liferay.portal.service.{GroupLocalServiceUtil, UserLocalServiceUtil}
import org.joda.time._
import org.joda.time.format.DateTimeFormat
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import scala.Some


class CertificateService(implicit val bindingModule: BindingModule) extends Injectable {
  val storageFactory = inject[StorageFactoryContract]

  def addNewCertificateActivity(userID: Int, certificateID: Int) {
    val existedActivities = checkIfActivityExists(CertificateActionType.NewCertificate, certificateID, None)
    if (existedActivities) return

    SocialActivityLocalServiceUtil.addActivity(userID, 0, classOf[Certificate].getName,
      certificateID, CertificateActionType.NewCertificate.id, StringPool.BLANK, 0)

  }

  def checkIfActivityExists(action: CertificateActionType.Value, certificateID: Int, userID: Option[Int]) = {
    val curriculumActivities = SocialActivityLocalServiceUtil.getActivities(classOf[Certificate].getName, 0, Int.MaxValue)
    curriculumActivities.toArray.
      exists(x => x.asInstanceOf[SocialActivity].getType == action.id &&
      x.asInstanceOf[SocialActivity].getClassPK == certificateID &&
      (if (userID.isDefined) x.asInstanceOf[SocialActivity].getUserId == userID.get else true))
  }

  def addCertificatePassedActivity(courseID: Int, userID: Int, groupID: Int) {
    val userCertificates = storageFactory.certificateUserStorage.getByUser(userID)
    if (userCertificates.length == 0) return

    val userCertificatesWithCourse = storageFactory.certificateSiteStorage.getByCertificateAndSite(userCertificates.map(x => x.certificateID), courseID)
    userCertificatesWithCourse.foreach(certificateSite => {

      if (passedCertificateHelper(certificateSite.certificateID, userID).status == CertificateValidStatus.Valid) {
        val existedActivities = checkIfActivityExists(CertificateActionType.PassedCertificate, certificateSite.certificateID, Some(userID))

        if (!existedActivities) {

          SocialActivityLocalServiceUtil.getActivities(classOf[Certificate].getName, 0, Int.MaxValue)

          SocialActivityLocalServiceUtil.addActivity(userID, 0, classOf[Certificate].getName,
            certificateSite.certificateID, CertificateActionType.PassedCertificate.id, StringPool.BLANK, 0)

          // Add expando data
          val attribute = "MyCertificate"
          val lfUser = UserLocalServiceUtil.getUser(userID)
          if (!lfUser.getExpandoBridge().hasAttribute(attribute)) {
            lfUser.getExpandoBridge.addAttribute(attribute, false)
            val property = new UnicodeProperties()
            property.setProperty("height", "105")
            property.setProperty("width", "450")
            lfUser.getExpandoBridge.setAttributeProperties(attribute, property, false)
          }
          val oldData = lfUser.getExpandoBridge.getAttribute(attribute, false)
          lfUser.getExpandoBridge.setAttribute(attribute, storageFactory.certificateStorage.getByID(certificateSite.certificateID).get.title +
            "\n" + (if (oldData == null) "" else oldData.toString), false)
        }
      }
    })
  }


  def passedCertificateHelper(certificate: Certificate, userID: Int): CertificateValidation = {
    val certificateSites = storageFactory.certificateSiteStorage.getByCertificate(certificate.id)
    val invalid = new CertificateValidation(CertificateValidStatus.Invalid, None)
    if (certificateSites.length == 0) return invalid

    var expireDate = None.asInstanceOf[Option[DateTime]]
    var status = CertificateValidStatus.Valid

    certificateSites.foreach(site => {
      val course = storageFactory.courseStorage.get(site.siteID, userID)
      if (!course.isDefined) return invalid
      else if (course.get.grade == "" || course.get.grade == null) return invalid
      else if (!certificate.isPermanent && course.get.date.isDefined)
      {
        val date = course.get.date.get
        if (!expireDate.isDefined || expireDate.get.isBefore(date)) expireDate = Option(date)
        if (DateTime.now().isAfter(date.plusYears(1)) )
          status = CertificateValidStatus.Expired
      }
    })
    return new CertificateValidation(status, (if (!expireDate.isDefined) None else Option(expireDate.get.plusYears(1))))
  }

  def passedCertificateHelper(certificateID: Int, userID: Int): CertificateValidation = {
    val certificate = storageFactory.certificateStorage.getByID(certificateID)
    if (certificate.isDefined) passedCertificateHelper(certificate.get, userID)
    else new CertificateValidation(CertificateValidStatus.Invalid)
  }


}
