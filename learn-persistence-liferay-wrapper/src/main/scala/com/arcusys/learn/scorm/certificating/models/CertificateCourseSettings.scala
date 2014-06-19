package com.arcusys.learn.scorm.certificating.models

import com.arcusys.learn.scorm.tracking.model.certificating.PeriodType.PeriodType

/**
 * Created by Iliya Tryapitsin on 27.05.2014.
 */
case class CertificateCourseSettings(certificateId: Int,
  courseId: Int,
  value: Option[Int] = None,
  periodType: Option[PeriodType] = None)
