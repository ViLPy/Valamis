package com.arcusys.learn.scorm.certificating.impl

import com.arcusys.learn.scorm.tracking.model.certificating.{ Certificate }
import com.arcusys.learn.persistence.liferay.service.{ LFCertificateActivityLocalServiceUtil, LFCertificateCourseLocalServiceUtil, LFCertificateUserLocalServiceUtil, LFCertificateLocalServiceUtil }
import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException
import scala.collection.JavaConverters._
import com.liferay.portal.service.CompanyLocalServiceUtil
import org.joda.time.DateTime
import com.arcusys.learn.scorm.certificating.models.CertificateEntityFactory
import com.arcusys.learn.scorm.certificating.CertificateRepositoryContract

/**
 * Created by Iliya Tryapitsin on 14.05.2014.
 */
class CertificateRepository extends CertificateRepositoryContract {

  override def get(keys: (String, Any)*): Certificate = keys match {
    case Seq(("id", id: Int)) => {
      val storageEntity = LFCertificateLocalServiceUtil.getLFCertificate(id)
      CertificateEntityFactory(storageEntity)
    }

    case _ => throw new NoSuchLFCertificateException()
  }

  override def delete(parameters: (String, Any)*) = parameters match {
    case Seq(("id", id: Int)) => {
      val storageEntity = LFCertificateLocalServiceUtil.getLFCertificate(id)

      // Remove all users relationships
      LFCertificateUserLocalServiceUtil.findByCertificateID(storageEntity.getId)
        .asScala
        .foreach(c => LFCertificateUserLocalServiceUtil.deleteLFCertificateUser(c))

      // Remove all course relationships
      LFCertificateCourseLocalServiceUtil.findByCertificateID(storageEntity.getId)
        .asScala
        .foreach(c => LFCertificateCourseLocalServiceUtil.deleteLFCertificateCourse(c))

      // Remove all activities relationships
      LFCertificateActivityLocalServiceUtil.findByCertificateID(storageEntity.getId)
        .asScala
        .foreach(c => LFCertificateActivityLocalServiceUtil.deleteLFCertificateActivity(c))

      LFCertificateLocalServiceUtil.deleteLFCertificate(storageEntity)
    }

    case _ => throw new NoSuchLFCertificateException()
  }

  override def modify(entity: Certificate): Certificate = {
    val storageEntity = LFCertificateLocalServiceUtil.getLFCertificate(entity.id)

    // check is exist company with id
    CompanyLocalServiceUtil.getCompanyById(entity.companyId)

    LFCertificateLocalServiceUtil.updateLFCertificate(CertificateEntityFactory.toLFCertificate(entity, storageEntity))

    CertificateEntityFactory(storageEntity)
  }

  override def create(entity: Certificate): Certificate = {
    val storageEntity = LFCertificateLocalServiceUtil.createLFCertificate()
    val addedStorageEntity = LFCertificateLocalServiceUtil.addLFCertificate(CertificateEntityFactory.toLFCertificate(entity, storageEntity))
    addedStorageEntity.setCreatedDate(DateTime.now.toDate)

    CertificateEntityFactory(addedStorageEntity)
  }

  override def select(keys: (String, Any)*): Seq[Certificate] = keys match {
    case Seq(("companyID", companyId: Int)) => LFCertificateLocalServiceUtil
      .findByCompanyID(companyId)
      .asScala
      .map(lfEntity => CertificateEntityFactory(lfEntity))

  }

  override def getByTitle(title: String): Iterable[Certificate] = LFCertificateLocalServiceUtil.findByTitle(title)
    .asScala
    .map(ent => CertificateEntityFactory(ent))

}
