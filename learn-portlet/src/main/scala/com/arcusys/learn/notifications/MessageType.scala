package com.arcusys.learn.notifications

object MessageType extends Enumeration {
  type MessageType = Value

  val CourseCertificateExpiration = Value("course-expiration")
  val CourseCertificateDeadline = Value("course-deadline")
  val EnrolledStudent = Value("enrolled-student")
  val FinishedLearningModule = Value("finished-learning-module")
}
