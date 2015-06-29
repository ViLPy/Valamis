package com.arcusys.valamis.lesson.scorm.model.manifest

/** Possible combination of conditions */
object ConditionCombination extends Enumeration {
  type ConditionCombination = Value
  /** 'AND' combination of conditions (all should be met) */
  val All = Value("all")
  /** 'OR' combination of conditions (at least one should be met) */
  val Any = Value("any")
}