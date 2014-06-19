package com.arcusys.learn.models.Gradebook

/**
 * Created by Iliya Tryapitsin on 17.04.2014.
 */
case class PackageGradeResponse(id: Int,
  packageLogo: String,
  packageName: String,
  description: String,
  finished: Boolean,
  grade: String,
  statements: String, //Seq[Statement],
  comment: String = "")
