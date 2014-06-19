package com.arcusys.learn.scorm.certificating.impl

import com.arcusys.learn.scorm.certificating.CertificateUserStorage
import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.learn.scorm.tracking.model.certificating.OldCertificateUser

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait CertificateUserEntityStorage extends CertificateUserStorage with KeyedEntityStorageExt[OldCertificateUser] with EntityStorageExt[OldCertificateUser] {
  def getCount(certificateID: Int): Int = getAll("certificateID" -> certificateID).size

  def getByCertificate(certificateID: Int) =
    getAll("certificateID" -> certificateID)

  def getByUser(userID: Int) =
    getAll("userID" -> userID)

  def deleteUser(userID: Int, certificateID: Int) {
    delete("userID" -> userID, "certificateID" -> certificateID)
  }

  def isUserMember(userID: Int, certificateID: Int) = {
    getAll("userID" -> userID, "certificateID" -> certificateID).length > 0
  }
}
