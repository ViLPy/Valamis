package com.arcusys.learn.scorm.manifest.model

/** Lesson type for Passing limit and rerun time */
object LessonType extends Enumeration {
  type LessonType = Value
  val scormPackage = Value("scormpackage")
  val tincanPackage = Value("tincanpackage")
}