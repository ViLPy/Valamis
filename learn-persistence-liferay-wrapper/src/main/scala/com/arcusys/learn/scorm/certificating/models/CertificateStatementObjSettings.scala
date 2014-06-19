package com.arcusys.learn.scorm.certificating.models

import com.arcusys.learn.scorm.tracking.model.certificating.PeriodType.PeriodType

/**
 * Created by Iliya Tryapitsin on 26.05.2014.
 */
case class CertificateStatementObjSettings(certificateId: Int,
  verb: String,
  obj: String,
  value: Option[Int] = None,
  period: Option[PeriodType] = None)