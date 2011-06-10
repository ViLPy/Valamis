package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import scala.xml.Elem
import XMLImplicits._

class ObjectiveAdditionalMappingParser(val objective: Objective, extendedMappingElements: Seq[Elem]) {
  def parse {
    for(extendedMappingElement<-extendedMappingElements) {
      val globalObjectiveIdentifier = extendedMappingElement %! "targetObjectiveID"
      if (!(objective.objectiveMap.contains(globalObjectiveIdentifier))) 
        objective.objectiveMap(globalObjectiveIdentifier) = new ObjectiveMapInfo(globalObjectiveIdentifier)
      
      val mapInfo = objective.objectiveMap(globalObjectiveIdentifier)
      val readRawScore = (extendedMappingElement %? "readRawScore").getOrElse("true").toBoolean
      val readMinScore = (extendedMappingElement %? "readMinScore").getOrElse("true").toBoolean
      val readMaxScore = (extendedMappingElement %? "readMaxScore").getOrElse("true").toBoolean
      val readCompletionStatus = (extendedMappingElement %? "readCompletionStatus").getOrElse("true").toBoolean
      val readProgressMeasure = (extendedMappingElement %? "readProgressMeasure").getOrElse("true").toBoolean
      val writeRawScore = (extendedMappingElement %? "writeRawScore").getOrElse("false").toBoolean
      val writeMinScore = (extendedMappingElement %? "writeMinScore").getOrElse("false").toBoolean
      val writeMaxScore = (extendedMappingElement %? "writeMaxScore").getOrElse("false").toBoolean
      val writeCompletionStatus = (extendedMappingElement %? "writeCompletionStatus").getOrElse("false").toBoolean
      val writeProgressMeasure = (extendedMappingElement %? "writeProgressMeasure").getOrElse("false").toBoolean

      mapInfo.readRawScore ||= readRawScore
      mapInfo.readMinScore ||= readMinScore
      mapInfo.readMaxScore ||= readMaxScore
      mapInfo.readCompletionStatus ||= readCompletionStatus
      mapInfo.readProgressMeasure  ||= readProgressMeasure
      mapInfo.writeRawScore ||= writeRawScore
      mapInfo.writeMinScore ||= writeMinScore
      mapInfo.writeMaxScore ||= writeMaxScore
      mapInfo.writeCompletionStatus ||= writeCompletionStatus
      mapInfo.writeProgressMeasure ||= writeProgressMeasure
    }
    var readRawScoreCount = 0
    var readMinScoreCount = 0
    var readMaxScoreCount = 0
    var readCompletionStatusCount = 0
    var readProgressMeasureCount = 0
    for ((targetIdentifier, mapInfo) <- objective.objectiveMap) {
      if (mapInfo.readRawScore) readRawScoreCount += 1
      if (mapInfo.readMinScore) readMinScoreCount += 1
      if (mapInfo.readMaxScore) readMaxScoreCount += 1
      if (mapInfo.readCompletionStatus) readCompletionStatusCount += 1
      if (mapInfo.readProgressMeasure) readProgressMeasureCount += 1
    };
    if (readRawScoreCount > 1)  throw new SCORMParserException("Only one global objective map per local objective may have `readRawScore` attribute set to true")    
    if (readMinScoreCount > 1)  throw new SCORMParserException("Only one global objective map per local objective may have `readMinScore` attribute set to true")
    if (readMaxScoreCount > 1)  throw new SCORMParserException("Only one global objective map per local objective may have `readMaxScore` attribute set to true")   
    if (readCompletionStatusCount > 1) throw new SCORMParserException("Only one global objective map per local objective may have `readCompletionStatus` attribute set to true")    
    if (readProgressMeasureCount > 1) throw new SCORMParserException("Only one global objective map per local objective may have `readProgressMeasure` attribute set to true")    
  }
}