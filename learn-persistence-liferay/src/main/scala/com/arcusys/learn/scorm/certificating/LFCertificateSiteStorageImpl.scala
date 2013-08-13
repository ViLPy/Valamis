package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.{LFCertificateSiteLocalServiceUtil, LFCertificateLocalServiceUtil}
import com.arcusys.learn.persistence.liferay.model.{LFCertificateSite, LFCertificate}
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateSite
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait LFCertificateSiteStorageImpl extends KeyedEntityStorage[CertificateSite] {
  protected def doRenew() { LFCertificateSiteLocalServiceUtil.removeAll() }

  def extract(entity: LFCertificateSite) = new CertificateSite(
    entity.getId.toInt,
    entity.getCertificateID,
    entity.getSiteID,
    entity.getArrangementIndex)


  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = {
    val lfResult = parameters match {
      case Seq(("certificateID", certificateID: Int)) =>
        LFCertificateSiteLocalServiceUtil.findByCertificateID(certificateID)
    }
    lfResult.asScala.sortBy(_.getArrangementIndex).map { extract }
  }

  def create(parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def create(entity: CertificateSite, parameters: (String, Any)*) {throw new UnsupportedOperationException }

  def delete(parameters: (String, Any)*) {
    parameters match{
      case Seq(("id", id: Int)) =>
        val siteID = LFCertificateSiteLocalServiceUtil.getLFCertificateSite(id).getId
        LFCertificateSiteLocalServiceUtil.deleteLFCertificateSite(siteID)
    }
  }

  def modify(parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def modify(entity: CertificateSite, parameters: (String, Any)*) {
    val lfentity = LFCertificateSiteLocalServiceUtil.findByCertificateIDAndSiteID(entity.certificateID, entity.siteID).asScala.head;
    lfentity.setArrangementIndex(entity.arrangementIndex)
    LFCertificateSiteLocalServiceUtil.updateLFCertificateSite(lfentity)
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def getByID(id: Int, parameters: (String, Any)*) = {throw new UnsupportedOperationException }

  def createAndGetID(entity: CertificateSite, parameters: (String, Any)*): Int = {
    val existed = LFCertificateSiteLocalServiceUtil.findByCertificateIDAndSiteID(entity.certificateID, entity.siteID)
    if (!existed.isEmpty) return 0;

    val lfEntity = LFCertificateSiteLocalServiceUtil.createLFCertificateSite()
    lfEntity.setCertificateID(entity.certificateID)
    lfEntity.setSiteID(entity.siteID)

    val sites = LFCertificateSiteLocalServiceUtil.findByCertificateID(entity.certificateID).asScala.sortBy(_.getArrangementIndex)
    lfEntity.setArrangementIndex(if (sites.length == 0) 1 else sites.last.getArrangementIndex + 1)

    LFCertificateSiteLocalServiceUtil.addLFCertificateSite(lfEntity).getId.toInt
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException
}
