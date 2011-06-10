package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import XMLImplicits._
import scala.xml.Elem

class CompletionThresholdParser(val completionThresholdElement: Elem) {
  def parse = {
    val completedByMeasureString = completionThresholdElement %? "completedByMeasure"
    var minProgressMeasureString = completionThresholdElement %? "minProgressMeasure"
    val progressWeightString = completionThresholdElement %? "progressWeight"
    if (completedByMeasureString == None && minProgressMeasureString == None && progressWeightString == None) minProgressMeasureString = Some(completionThresholdElement.text)
    
    val completionThreshold = new CompletionThreshold(
      completedByMeasureString.getOrElse("false").toBoolean,
      BigDecimal(minProgressMeasureString.getOrElse("1")),
      BigDecimal(progressWeightString.getOrElse("1"))
    )
    if (completionThreshold.minProgressMeasure < 0 || completionThreshold.minProgressMeasure > 1) 
      throw new SCORMParserException("Invalid `minProgressMeasure` attribute value for <completionThreshold> element")
    
    if (completionThreshold.progressWeight < 0 || completionThreshold.progressWeight > 1) 
      throw new SCORMParserException("Invalid `progressWeight` attribute value for <completionThreshold> element")
    
    completionThreshold
  }
}