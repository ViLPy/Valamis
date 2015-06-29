package com.arcusys.valamis.lesson.scorm.service.parser

import com.arcusys.valamis.lesson.scorm.model.manifest.{ Objective, ObjectiveMap }
import com.arcusys.valamis.util.XMLImplicits
import com.arcusys.valamis.util.XMLImplicits._

import scala.xml.Elem

class ObjectiveParser(objectiveElement: Elem, extendedMap: Map[String, Seq[Elem]]) {
  def parse(primary: Boolean) = {
    val satisfiedByMeasure = objectiveElement attr "satisfiedByMeasure" withDefault false
    val objectiveID = objectiveElement attr "objectiveID" optional string
    val objectiveMapElements = objectiveElement children ("imsss", "mapInfo")
    val minNormalizedMeasure = objectiveElement childElem ("imsss", "minNormalizedMeasure") withDefault BigDecimal(1)
    var readSatisfiedStatusFrom, readNormalizedMeasureFrom, writeSatisfiedStatusTo, writeNormalizedMeasureTo: Option[String] = None
    objectiveMapElements.foreach(objectiveMapElement => {
      val globalObjectiveIdentifier = objectiveMapElement attr "targetObjectiveID" required string
      if (objectiveMapElement attr "readSatisfiedStatus" withDefault true)
        if (readSatisfiedStatusFrom.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `readSatisfiedStatus` attribute set to true")
        else readSatisfiedStatusFrom = Some(globalObjectiveIdentifier)
      if (objectiveMapElement attr "readNormalizedMeasure" withDefault true)
        if (readNormalizedMeasureFrom.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `readNormalizedMeasure` attribute set to true")
        else readNormalizedMeasureFrom = Some(globalObjectiveIdentifier)
      if (objectiveMapElement attr "writeSatisfiedStatus" withDefault false)
        if (writeSatisfiedStatusTo.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `writeSatisfiedStatus` attribute set to true")
        else writeSatisfiedStatusTo = Some(globalObjectiveIdentifier)
      if (objectiveMapElement attr "writeNormalizedMeasure" withDefault false)
        if (writeNormalizedMeasureTo.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `writeNormalizedMeasure` attribute set to true")
        else writeNormalizedMeasureTo = Some(globalObjectiveIdentifier)
    })
    var readRawScoreFrom, readMinScoreFrom, readMaxScoreFrom, readCompletionStatusFrom, readProgressMeasureFrom, writeRawScoreTo, writeMinScoreTo, writeMaxScoreTo, writeCompletionStatusTo, writeProgressMeasureTo: Option[String] = None
    if (objectiveID.isDefined && extendedMap.contains(objectiveID.get)) {
      extendedMap(objectiveID.get).foreach(extendedMappingElement => {
        val globalObjectiveIdentifier = extendedMappingElement attr "targetObjectiveID" required string
        if (extendedMappingElement attr "readRawScore" withDefault true)
          if (readRawScoreFrom.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `readRawScore` attribute set to true")
          else readRawScoreFrom = Some(globalObjectiveIdentifier)
        if (extendedMappingElement attr "readMinScore" withDefault true)
          if (readMinScoreFrom.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `readMinScore` attribute set to true")
          else readMinScoreFrom = Some(globalObjectiveIdentifier)
        if (extendedMappingElement attr "readMaxScore" withDefault true)
          if (readMaxScoreFrom.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `readMaxScore` attribute set to true")
          else readMaxScoreFrom = Some(globalObjectiveIdentifier)
        if (extendedMappingElement attr "readCompletionStatus" withDefault true)
          if (readCompletionStatusFrom.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `readCompletionStatus` attribute set to true")
          else readCompletionStatusFrom = Some(globalObjectiveIdentifier)
        if (extendedMappingElement attr "readProgressMeasure" withDefault true)
          if (readProgressMeasureFrom.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `readProgressMeasure` attribute set to true")
          else readProgressMeasureFrom = Some(globalObjectiveIdentifier)
        if (extendedMappingElement attr "writeRawScore" withDefault false)
          if (writeRawScoreTo.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `writeRawScore` attribute set to true")
          else writeRawScoreTo = Some(globalObjectiveIdentifier)
        if (extendedMappingElement attr "writeMinScore" withDefault false)
          if (writeMinScoreTo.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `writeMinScore` attribute set to true")
          else writeMinScoreTo = Some(globalObjectiveIdentifier)
        if (extendedMappingElement attr "writeMaxScore" withDefault false)
          if (writeMaxScoreTo.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `writeMaxScore` attribute set to true")
          else writeMaxScoreTo = Some(globalObjectiveIdentifier)
        if (extendedMappingElement attr "writeCompletionStatus" withDefault false)
          if (writeCompletionStatusTo.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `writeCompletionStatus` attribute set to true")
          else writeCompletionStatusTo = Some(globalObjectiveIdentifier)
        if (extendedMappingElement attr "writeProgressMeasure" withDefault false)
          if (writeProgressMeasureTo.isDefined) throw new SCORMParserException("Only one global objective map per local objective may have `writeProgressMeasure` attribute set to true")
          else writeProgressMeasureTo = Some(globalObjectiveIdentifier)
      })
    }
    if (objectiveID.isEmpty && (!primary ||
      (readSatisfiedStatusFrom.isDefined || readNormalizedMeasureFrom.isDefined || writeSatisfiedStatusTo.isDefined || writeNormalizedMeasureTo.isDefined)
    )) throw new SCORMParserException("`ObjectiveID` attribute not defined for objective")
    new Objective(objectiveID, satisfiedByMeasure, minNormalizedMeasure,
      new ObjectiveMap(
        readSatisfiedStatusFrom,
        readNormalizedMeasureFrom,
        writeSatisfiedStatusTo,
        writeNormalizedMeasureTo,
        readRawScoreFrom,
        readMinScoreFrom,
        readMaxScoreFrom,
        readCompletionStatusFrom,
        readProgressMeasureFrom,
        writeRawScoreTo,
        writeMinScoreTo,
        writeMaxScoreTo,
        writeCompletionStatusTo,
        writeProgressMeasureTo
      )
    )
  }
}