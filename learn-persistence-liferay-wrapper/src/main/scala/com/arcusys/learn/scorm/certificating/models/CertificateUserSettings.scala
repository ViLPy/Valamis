package com.arcusys.learn.scorm.certificating.models

import org.joda.time.DateTime

/**
 * Created by Iliya Tryapitsin on 30.05.2014.
 */
case class CertificateUserSettings(userId: Int,
  certificateId: Int,
  attachedDate: DateTime)
