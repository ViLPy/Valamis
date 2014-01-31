package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.scorm.tracking.model.certificating.{CertificatePage, Certificate}

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait CertificateStorage {
  def getAll: Seq[Certificate]
  def getAll(companyId: Int): Seq[Certificate]
  def getPage(companyID: Int, skip: Int, take: Int, filter: String, sortAZ: Boolean): CertificatePage
  def getByID(id: Int): Option[Certificate]
  def createAndGetID(entity: Certificate): Int
  def delete(id: Int)
  def modify(entity: Certificate)
  def saveLogo(id: Int, logo: String)
  def renew()
}
