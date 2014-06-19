package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.scorm.tracking.model.certificating.CertificateSite

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait CertificateSiteStorage {
  def getCount(certificateID: Int): Int
  def getByID(id: Int): Option[CertificateSite]
  def getByCertificate(certificateID: Int): Seq[CertificateSite]
  def getByCertificateAndSite(certificates: Seq[Int], siteID: Int): Seq[CertificateSite]
  def createAndGetID(certificateSite: CertificateSite): Int
  def delete(id: Int)
  def getAll: Seq[CertificateSite]
  def move(certificateID: Int, siteID: Int, position: Int)
  def renew()
}
