package com.arcusys.learn.models.request

object GradebookActionType extends Enumeration {
  type GradebookActionType = Value

  val ALL = Value("ALL")
  val GRADES = Value("GRADES")
  val TOTAL_GRADE = Value("TOTAL_GRADE")
  val REVIEW = Value("REVIEW")
}
