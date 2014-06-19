package com.arcusys.learn.scorm.certificating.impl

import com.arcusys.learn.persistence.liferay.service.{ LFCertificateLocalServiceUtil, LFCertificateUserLocalServiceUtil }
import scala.util.Try
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK
import com.liferay.portlet.trash.DuplicateEntryException
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.arcusys.learn.liferay.LiferayClasses.LUser
import scala.collection.JavaConverters._
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import org.joda.time.DateTime
import com.arcusys.learn.scorm.certificating.models.CertificateEntityFactory
import com.arcusys.learn.scorm.certificating.CertificateUserRepositoryContract

/**
 * Created by Iliya Tryapitsin on 13.05.2014.
 */
class CertificateToUserRepository extends CertificateUserRepositoryContract {
  override def getRight(right: (DateTime, LUser)): Seq[Certificate] = {
    LFCertificateUserLocalServiceUtil
      .findByUserID(right._2.getUserId)
      .asScala
      .map(certificateUser => LFCertificateLocalServiceUtil.getLFCertificate(certificateUser.getCertificateID))
      .map(lfCertificate => CertificateEntityFactory(lfCertificate))
  }

  override def getLeft(left: Certificate): Seq[(DateTime, LUser)] = {
    LFCertificateUserLocalServiceUtil
      .findByCertificateID(left.id)
      .asScala
      .map(c => (new DateTime(c.getAttachedDate), UserLocalServiceHelper().getUser(c.getUserID)))
  }

  override def delete(left: Certificate, right: (DateTime, LUser)): Unit = {
    val result = LFCertificateUserLocalServiceUtil.findByUserIDAndCertificateID(right._2.getUserId, left.id)

    LFCertificateUserLocalServiceUtil.deleteLFCertificateUser(result)
  }

  override def create(left: Certificate, right: (DateTime, LUser)): Unit = {
    checkForeignKeys(left.id, right._2.getUserId)

    val result = Try(LFCertificateUserLocalServiceUtil
      .findByUserIDAndCertificateID(right._2.getUserId.toInt, left.id))

    if (result.isFailure) {
      val certificateUserEntity = LFCertificateUserLocalServiceUtil.createLFCertificateUser(new LFCertificateUserPK(left.id, right._2.getUserId))
      certificateUserEntity.setAttachedDate(right._1.toDate)

      LFCertificateUserLocalServiceUtil.addLFCertificateUser(certificateUserEntity)
    } else
      throw new DuplicateEntryException()
  }

  private def checkForeignKeys(certificateId: Int, userId: Long) = {
    // check foreign keys
    LFCertificateLocalServiceUtil.getLFCertificate(certificateId)
    UserLocalServiceHelper().getUser(userId)
  }
}
