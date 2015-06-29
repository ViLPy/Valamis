package com.arcusys.learn.models.Gradebook

import com.arcusys.learn.models.CourseResponse
import com.arcusys.valamis.gradebook.model.PackageGrade
import com.arcusys.valamis.lesson.model.BaseManifest
import com.arcusys.valamis.user.model.User

case class GradedPackageResponse(
  id: Long,
  title: String,
  description: Option[String],
  course: CourseResponse,
  grade: Option[Float],
  autoGrade: Option[Float]
)