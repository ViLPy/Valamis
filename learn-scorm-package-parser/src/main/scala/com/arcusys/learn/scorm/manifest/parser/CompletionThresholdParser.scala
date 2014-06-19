package com.arcusys.learn.scorm.manifest.parser

import com.arcusys.learn.scorm.manifest.model._
import XMLImplicits._
import scala.xml.Elem

class CompletionThresholdParser(val completionThresholdElement: Elem) {
  def parse = {
    val completedByMeasureString = completionThresholdElement attr "completedByMeasure" optional string
    var minProgressMeasureString = completionThresholdElement attr "minProgressMeasure" optional string
    val progressWeightString = completionThresholdElement attr "progressWeight" optional string
    if (completedByMeasureString.isEmpty && minProgressMeasureString.isEmpty && progressWeightString.isEmpty) minProgressMeasureString = Some(completionThresholdElement.text.trim)

    new CompletionThreshold(
      completedByMeasureString.getOrElse("false").toBoolean,
      BigDecimal(minProgressMeasureString.getOrElse("1")),
      BigDecimal(progressWeightString.getOrElse("1"))
    )
  }
}