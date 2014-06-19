package com.arcusys.learn.scorm.certificating

import com.arcusys.learn.{ BaseManyToManyRepository, SelectEntityRepository, MutableEntityRepository }
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate
import org.joda.time.DateTime
import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.scorm.tracking.model.certificating.Certificate

/**
 * Created by Iliya Tryapitsin on 28.05.2014.
 */
abstract trait CertificateUserRepositoryContract extends BaseManyToManyRepository[Certificate, (DateTime, LUser)]
