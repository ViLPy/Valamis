package com.arcusys.learn.models.Gradebook

/**
 * Created by Iliya Tryapitsin on 15.04.2014.
 */
case class StudentResponse(id: Long,
  fullname: String,
  avatarUrl: String,
  address: Seq[String] = null,
  organizationNames: Seq[String],
  lastModified: String,
  gradeTotal: Float,
  commentTotal: String = null,
  completedPackagesCount: Int = 0, // TODO Forget about this
  packagesCount: Int,
  packageGrades: Seq[PackageGradeResponse] = null)
