package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.{LFCertificateUserLocalServiceUtil, LFCertificateSiteLocalServiceUtil, LFCertificateLocalServiceUtil}
import com.arcusys.learn.persistence.liferay.model.LFCertificate
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import scala.collection.JavaConverters._
import com.liferay.portal.util.PortalUtil

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait LFCertificateStorageImpl extends KeyedEntityStorage[Certificate] {
  protected def doRenew() {
    LFCertificateLocalServiceUtil.removeAll()
  }

  def extract(entity: LFCertificate) = new Certificate(
    entity.getId.toInt,
    entity.getTitle,
    entity.getDescription,
    entity.getLogo,
    entity.getIsPermanent,
    entity.getPublishBadge,
    entity.getShortDescription,
    entity.getCompanyID)


  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = parameters match {
    case Seq(("companyID", companyId: Int)) => {
      // update certificates from 1.5 version which does not have companyId
      val defaultCompanyID = PortalUtil.getDefaultCompanyId
      if (companyId == defaultCompanyID){
        val noCompanyCertificates = LFCertificateLocalServiceUtil.findByCompanyID(null)
        noCompanyCertificates.toArray.foreach(i=>{
          i.asInstanceOf[LFCertificate].setCompanyID(defaultCompanyID.toInt)
          LFCertificateLocalServiceUtil.updateLFCertificate(i.asInstanceOf[LFCertificate])
        })
      }
      LFCertificateLocalServiceUtil.findByCompanyID(companyId).asScala.map(extract)
    }
  }


  def create(parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def create(entity: Certificate, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def delete(parameters: (String, Any)*) {
    parameters.find(_._1 == "id").map(_._2.asInstanceOf[Int]) foreach {
      id => {
        val sites = LFCertificateSiteLocalServiceUtil.findByCertificateID(id).asScala
        sites.foreach(s => LFCertificateSiteLocalServiceUtil.deleteLFCertificateSite(s.getId))
        val users = LFCertificateUserLocalServiceUtil.findByCertificateID(id).asScala
        users.foreach(u => LFCertificateUserLocalServiceUtil.deleteLFCertificateUser(u.getId))
        LFCertificateLocalServiceUtil.deleteLFCertificate(id)
      }
    }
  }

  def modify(parameters: (String, Any)*) {
    parameters match {
      case Seq(("id", id: Int), ("logo", logo: String)) => {
        val lfentity = LFCertificateLocalServiceUtil.getLFCertificate(id)
        lfentity.setLogo(logo)
        LFCertificateLocalServiceUtil.updateLFCertificate(lfentity)
      }
    }

  }

  def modify(entity: Certificate, parameters: (String, Any)*) {
    val lfentity = LFCertificateLocalServiceUtil.getLFCertificate(entity.id)
    lfentity.setTitle(entity.title)
    lfentity.setDescription(entity.description)
    lfentity.setIsPermanent(entity.isPermanent)
    lfentity.setPublishBadge(entity.publishBadge)
    lfentity.setShortDescription(entity.shortDescription)
    LFCertificateLocalServiceUtil.updateLFCertificate(lfentity)
  }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getByID(id: Int, parameters: (String, Any)*) = {
    Option(LFCertificateLocalServiceUtil.getLFCertificate(id)) map extract
  }

  def createAndGetID(entity: Certificate, parameters: (String, Any)*) = {
    val lfEntity = LFCertificateLocalServiceUtil.createLFCertificate()
    lfEntity.setTitle(entity.title)
    lfEntity.setDescription(entity.description)
    lfEntity.setIsPermanent(true)
    lfEntity.setPublishBadge(false)
    lfEntity.setShortDescription("")
    lfEntity.setCompanyID(entity.companyId)
    LFCertificateLocalServiceUtil.addLFCertificate(lfEntity).getId.toInt
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException
}
