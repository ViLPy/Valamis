package com.arcusys.learn.scorm.tracking.model.certificating

/**
 * Created by Iliya Tryapitsin on 14.03.14.
 */
object CertificateStateType extends Enumeration {
  type CertificateStateType = Value
  val PUBLISH = Value(2)
  val UNPUBLISH = Value(1)
}
