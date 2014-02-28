package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.storage.impl.KeyedEntityStorage
import com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil
import com.arcusys.learn.persistence.liferay.model.LFCertificateUser
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateUser
import scala.collection.JavaConverters._

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait LFCertificateUserStorageImpl extends KeyedEntityStorage[CertificateUser] {
  protected def doRenew() { LFCertificateUserLocalServiceUtil.removeAll() }

  def extract(entity: LFCertificateUser) = new CertificateUser(
    entity.getId.toInt,
    entity.getCertificateID,
    entity.getUserID)


  def getOne(parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getAll(parameters: (String, Any)*) = {
    val lfResult = parameters match {
      case Seq(("certificateID", certificateID: Int)) =>
        LFCertificateUserLocalServiceUtil.findByCertificateID(certificateID)
      case Seq(("userID", userID: Int)) =>
        LFCertificateUserLocalServiceUtil.findByUserID(userID)
      case Seq(("userID", userID: Int), ("certificateID", certificateID: Int)) =>
        LFCertificateUserLocalServiceUtil.findByUserIDAndCertificateID(userID, certificateID)
    }
    lfResult.asScala.map { extract }
  }

  def create(parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def create(entity: CertificateUser, parameters: (String, Any)*) {throw new UnsupportedOperationException }

  def delete(parameters: (String, Any)*) {
    parameters match{
      case Seq(("id", id: Int)) =>
        //val siteID = LFCertificateUserLocalServiceUtil.getLFCertificateUser(id).getId
        LFCertificateUserLocalServiceUtil.deleteLFCertificateUser(id)
      case Seq(("userID", userID: Int), ("certificateID", certificateID: Int)) =>
        LFCertificateUserLocalServiceUtil.removeByUserIDAndCertificateID(userID, certificateID)
    }
  }

  def modify(parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def modify(entity: CertificateUser, parameters: (String, Any)*) {throw new UnsupportedOperationException }

  def execute(sqlKey: String, parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {throw new UnsupportedOperationException}

  def getByID(id: Int, parameters: (String, Any)*) = {throw new UnsupportedOperationException }

  def createAndGetID(entity: CertificateUser, parameters: (String, Any)*): Int = {
    val existed = LFCertificateUserLocalServiceUtil.findByUserIDAndCertificateID(entity.userID, entity.certificateID)
    if (!existed.isEmpty) return 0;

    val lfEntity = LFCertificateUserLocalServiceUtil.createLFCertificateUser()
    lfEntity.setCertificateID(entity.certificateID)
    lfEntity.setUserID(entity.userID)
    LFCertificateUserLocalServiceUtil.addLFCertificateUser(lfEntity).getId.toInt
  }

  def createAndGetID(parameters: (String, Any)*) = throw new UnsupportedOperationException
}
