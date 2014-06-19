package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.scorm.tracking.model.certificating.OldCertificateUser

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait CertificateUserStorage {
  def getCount(certificateID: Int): Int
  def getByID(id: Int): Option[OldCertificateUser]
  def getByCertificate(certificateID: Int): Seq[OldCertificateUser]
  def getByUser(userID: Int): Seq[OldCertificateUser]
  def createAndGetID(certificateUser: OldCertificateUser): Int
  def delete(id: Int)
  def deleteUser(userID: Int, certificateID: Int)
  def getAll: Seq[OldCertificateUser]
  def isUserMember(userID: Int, certificateID: Int): Boolean
  def renew()
}
