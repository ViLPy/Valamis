package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.{ SelectEntityRepository, MutableEntityRepository }
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate

/**
 * Created by Iliya Tryapitsin on 28.05.2014.
 */
abstract trait CertificateRepositoryContract extends MutableEntityRepository[Certificate] with SelectEntityRepository[Certificate] {
  def getByTitle(title: String): Iterable[Certificate]
}
