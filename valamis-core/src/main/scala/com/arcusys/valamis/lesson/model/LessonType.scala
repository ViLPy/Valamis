package com.arcusys.valamis.lesson.model

/** Lesson type for Passing limit and rerun time */
object LessonType extends Enumeration {
  type LessonType = Value
  val Scorm = Value("scormpackage")
  val Tincan = Value("tincanpackage")
}