package com.arcusys.scorm.model

class CompletionThreshold(
  val completedByMeasure: Boolean,
  val minProgressMeasure: BigDecimal,
  val progressWeight: BigDecimal)