package com.arcusys.learn.scorm.tracking.model.certificating.models

import com.arcusys.learn.scorm.manifest.model.PeriodType
import PeriodType.PeriodType

/**
 * Created by Iliya Tryapitsin on 26.05.2014.
 */
case class CertificateStatementObjSettings(certificateId: Int,
  verb: String,
  obj: String,
  value: Option[Int] = None,
  period: Option[PeriodType] = None)