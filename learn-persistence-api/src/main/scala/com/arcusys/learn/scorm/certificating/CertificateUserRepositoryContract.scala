package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.repositories.BaseManyToManyRepository
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import org.joda.time.DateTime

/**
 * Created by Iliya Tryapitsin on 28.05.2014.
 */
abstract trait CertificateUserRepositoryContract extends BaseManyToManyRepository[Certificate, (DateTime, Long)]
