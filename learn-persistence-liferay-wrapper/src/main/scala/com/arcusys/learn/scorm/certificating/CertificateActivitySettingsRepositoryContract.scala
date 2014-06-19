package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.{ SelectEntityRepository, MutableEntityRepository }
import com.arcusys.learn.scorm.certificating.models.CertificateActivitySettings

/**
 * Created by Iliya Tryapitsin on 28.05.2014.
 */
abstract trait CertificateActivitySettingsRepositoryContract extends MutableEntityRepository[CertificateActivitySettings] with SelectEntityRepository[CertificateActivitySettings]
