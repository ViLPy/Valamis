package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.scorm.tracking.model.certificating.Certificate

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait CertificateStorage {
  def getAll: Seq[Certificate]
  def getByID(id: Int): Option[Certificate]
  def createAndGetID(entity: Certificate): Int
  def delete(id: Int)
  def modify(entity: Certificate)
  def renew()
}
