package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.scorm.tracking.model.certificating.CertificateUser

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait CertificateUserStorage {
  def getCount(certificateID:Int): Int
  def getByID(id: Int): Option[CertificateUser]
  def getByCertificate(certificateID: Int): Seq[CertificateUser]
  def getByUser(userID: Int): Seq[CertificateUser]
  def createAndGetID(certificateUser: CertificateUser): Int
  def delete(id: Int)
  def deleteUser(userID: Int, certificateID: Int)
  def getAll: Seq[CertificateUser]
  def isUserMember(userID: Int, certificateID: Int): Boolean
  def renew()
}
