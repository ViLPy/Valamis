package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException
import com.arcusys.learn.persistence.liferay.model.LFCertificate
import com.arcusys.learn.persistence.liferay.service._
import com.arcusys.learn.scorm.certificating.models.CertificateEntityFactory
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import com.liferay.portal.kernel.dao.orm.{ OrderFactoryUtil, RestrictionsFactoryUtil }
import com.liferay.portal.service.CompanyLocalServiceUtil
import org.joda.time.DateTime

import scala.collection.JavaConverters._

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
      LFCertificateUserLocalServiceUtil.findByCertificateID(storageEntity.getId).asScala
        .foreach(LFCertificateUserLocalServiceUtil.deleteLFCertificateUser)

      // Remove all course relationships
      LFCertificateCourseLocalServiceUtil.findByCertificateID(storageEntity.getId).asScala
        .foreach(LFCertificateCourseLocalServiceUtil.deleteLFCertificateCourse)

      // Remove all activities relationships
      LFCertificateActivityLocalServiceUtil.findByCertificateID(storageEntity.getId).asScala
        .foreach(LFCertificateActivityLocalServiceUtil.deleteLFCertificateActivity)

      // Remove all statement relationships
      LFCertificateTincanStatementLocalServiceUtil.findByCertificateID(storageEntity.getId).asScala
        .foreach(LFCertificateTincanStatementLocalServiceUtil.deleteLFCertificateTincanStatement)

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
    case Seq(("companyID", companyId: Int)) => getByCompany(companyId).toSeq
  }

  def getById(id: Int): Certificate = {
    val storageEntity = LFCertificateLocalServiceUtil.getLFCertificate(id)
    CertificateEntityFactory(storageEntity)
  }

  override def getByTitle(title: String): Iterable[Certificate] = LFCertificateLocalServiceUtil.findByTitle(title)
    .asScala
    .map(ent => CertificateEntityFactory(ent))

  def getByCompany(companyId: Int): Iterable[Certificate] = {
    LFCertificateLocalServiceUtil
      .findByCompanyID(companyId)
      .asScala
      .map(lfEntity => CertificateEntityFactory(lfEntity))
  }

  def getCountByCompanyAndTitle(companyId: Int, titlePattern: String): Int = {
    val query = getQueryByCompanyAndTitle(companyId, titlePattern)
    LFCertificateLocalServiceUtil.dynamicQueryCount(query).toInt
  }

  def getByCompanyAndTitle(companyId: Int, titlePattern: String, sortBy: String, ascOrder: Boolean, skip: Int, take: Int): Iterable[Certificate] = {
    val query = getQueryByCompanyAndTitle(companyId, titlePattern)

    if (ascOrder)
      query.addOrder(OrderFactoryUtil.asc(sortBy))
    else
      query.addOrder(OrderFactoryUtil.desc(sortBy))

    if (skip < 0) {
      LFCertificateLocalServiceUtil.dynamicQuery(query).asScala
        .filter(_.isInstanceOf[LFCertificate])
        .map(e => CertificateEntityFactory.apply(e.asInstanceOf[LFCertificate]))
    } else {
      LFCertificateLocalServiceUtil.dynamicQuery(query, skip, skip + take).asScala
        .filter(_.isInstanceOf[LFCertificate])
        .map(e => CertificateEntityFactory.apply(e.asInstanceOf[LFCertificate]))
    }
  }

  private def getQueryByCompanyAndTitle(companyId: Int, titlePattern: String) = {
    val query = LFCertificateLocalServiceUtil.dynamicQuery()
      .add(RestrictionsFactoryUtil.eq("companyID", companyId))

    if (titlePattern != null && !titlePattern.isEmpty)
      query.add(RestrictionsFactoryUtil.ilike("title", "%" + titlePattern + "%"))

    query
  }
}
