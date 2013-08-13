package com.arcusys.learn.scorm.certificating.impl

import com.arcusys.learn.scorm.certificating.CertificateSiteStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.scorm.tracking.model.certificating.CertificateSite

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait CertificateSiteEntityStorage extends CertificateSiteStorage with KeyedEntityStorageExt[CertificateSite] with EntityStorageExt[CertificateSite] {
  def getCount(certificateID: Int): Int = getAll("certificateID" -> certificateID).size

  def getByCertificate(certificateID: Int) =
    getAll("certificateID" -> certificateID)

  def move(certificateID: Int, siteID: Int, position: Int) =
    modify(new CertificateSite(0, certificateID, siteID, position))
}
