package com.arcusys.learn.scorm.certificating.impl

import com.arcusys.learn.scorm.certificating.CertificateStorage
import com.arcusys.learn.storage.impl.{EntityStorageExt, KeyedEntityStorageExt}
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate

/**
 * User: Yulia.Glushonkova
 * Date: 10.06.13
 */
trait CertificateEntityStorage extends CertificateStorage with KeyedEntityStorageExt[Certificate] with EntityStorageExt[Certificate] {
}
