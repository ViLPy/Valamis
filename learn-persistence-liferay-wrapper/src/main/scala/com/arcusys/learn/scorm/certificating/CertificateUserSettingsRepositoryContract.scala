package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.{ BaseEntityRepository, SelectEntityRepository }
import com.arcusys.learn.scorm.certificating.models.{ CertificateUserSettings }

/**
 * Created by Iliya Tryapitsin on 30.05.2014.
 */
trait CertificateUserSettingsRepositoryContract extends BaseEntityRepository[CertificateUserSettings] with SelectEntityRepository[CertificateUserSettings] {

}
