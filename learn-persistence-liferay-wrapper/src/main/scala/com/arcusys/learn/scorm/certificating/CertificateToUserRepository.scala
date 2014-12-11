package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.liferay.LiferayClasses.{ LDuplicateEntryException }
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK
import com.arcusys.learn.persistence.liferay.service.{ LFCertificateLocalServiceUtil, LFCertificateUserLocalServiceUtil }
import com.arcusys.learn.scorm.certificating.models.CertificateEntityFactory
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import org.joda.time.DateTime

import scala.collection.JavaConverters._
import scala.util.Try

/**
 * Created by Iliya Tryapitsin on 13.05.2014.
 */
class CertificateToUserRepository extends CertificateUserRepositoryContract {
  override def getRight(right: (DateTime, Long)): Seq[Certificate] = {
    LFCertificateUserLocalServiceUtil
      .findByUserID(right._2)
      .asScala
      .map(certificateUser => LFCertificateLocalServiceUtil.getLFCertificate(certificateUser.getCertificateID))
      .map(lfCertificate => CertificateEntityFactory(lfCertificate))
  }

  override def getLeft(left: Certificate): Seq[(DateTime, Long)] = {
    LFCertificateUserLocalServiceUtil
      .findByCertificateID(left.id.toLong)
      .asScala
      .map(c => (new DateTime(c.getAttachedDate), c.getUserID.toLong))
  }

  override def delete(left: Certificate, right: (DateTime, Long)): Unit = {
    val result = LFCertificateUserLocalServiceUtil.findByUserIDAndCertificateID(right._2, left.id.toLong)

    LFCertificateUserLocalServiceUtil.deleteLFCertificateUser(result)
  }

  override def create(left: Certificate, right: (DateTime, Long)): Unit = {
    checkForeignKeys(left.id, right._2)

    val result = Try(LFCertificateUserLocalServiceUtil
      .findByUserIDAndCertificateID(right._2, left.id.toLong))

    if (result.isFailure) {
      val certificateUserEntity = LFCertificateUserLocalServiceUtil.createLFCertificateUser(new LFCertificateUserPK(left.id.toLong, right._2))
      certificateUserEntity.setAttachedDate(right._1.toDate)

      LFCertificateUserLocalServiceUtil.addLFCertificateUser(certificateUserEntity)
    } else
      throw new LDuplicateEntryException()
  }

  private def checkForeignKeys(certificateId: Int, userId: Long) = {
    // check foreign keys
    LFCertificateLocalServiceUtil.getLFCertificate(certificateId)
    UserLocalServiceHelper().getUser(userId)
  }
}
