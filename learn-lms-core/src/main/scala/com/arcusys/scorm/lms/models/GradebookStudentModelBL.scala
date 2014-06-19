package com.arcusys.scorm.lms.models

case class GradebookStudentModelBL(
  id: Int,
  name: String,
  organization: String,
  address: String,
  avatar: String,
  lastModified: Long,
  coursesDone: String,
  grade: Int,
  comment: String,
  packageGrades: Seq[StudentGradesModelBL])

case class StudentGradesModelBL(
  id: Int,
  packageName: String,
  viewed: Boolean,
  attempts: Int,
  correctShare: Int,
  userResponse: String,
  activities: Seq[StudentGradesModelBL])