package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import scala.xml.Elem
import XMLImplicits._

class ObjectiveParser(val objectiveElement: Elem) {
  def parse(primary: Boolean) = {
    val satisfiedByMeasure = (objectiveElement %? "satisfiedByMeasure").getOrElse("false")
    val objectiveID = objectiveElement %? "objectiveID"
    val objectiveMapElements = objectiveElement \ ("imsss","objectiveMap")
    val minNormalizedMeasureElement = objectiveElement \? ("imsss","minNormalizedMeasure")
    val minNormalizedMeasure = minNormalizedMeasureElement match {
      case None => BigDecimal(1)
      case Some(e) => if (e.text.isEmpty) BigDecimal(1) else BigDecimal(e.text)
    }    
    if ((minNormalizedMeasure > 1) || (minNormalizedMeasure < -1)) throw new SCORMParserException("Invalid value for the `minNormalizedMeasure` element")
    val objective = new Objective(satisfiedByMeasure.toBoolean, objectiveID, minNormalizedMeasure)
    objectiveMapElements.foreach(objectiveMapElement => {
      val globalObjectiveIdentifier = objectiveMapElement.asInstanceOf[Elem] %! "targetObjectiveID"
      if (!(objective.objectiveMap.contains(globalObjectiveIdentifier))) objective.objectiveMap(globalObjectiveIdentifier) = new ObjectiveMapInfo(globalObjectiveIdentifier)
      val mapInfo = objective.objectiveMap(globalObjectiveIdentifier);
      val readSatisfiedStatus = (objectiveMapElement.asInstanceOf[Elem] %? "readSatisfiedStatus").getOrElse("true").toBoolean
      val readNormalizedMeasure = (objectiveMapElement.asInstanceOf[Elem] %? "readNormalizedMeasure").getOrElse("true").toBoolean
      val writeSatisfiedStatus = (objectiveMapElement.asInstanceOf[Elem] %? "writeSatisfiedStatus").getOrElse("false").toBoolean
      val writeNormalizedMeasure = (objectiveMapElement.asInstanceOf[Elem] %? "writeNormalizedMeasure").getOrElse("false").toBoolean
      mapInfo.readSatisfiedStatus ||= readSatisfiedStatus
      mapInfo.readNormalizedMeasure ||= readNormalizedMeasure
      mapInfo.writeSatisfiedStatus ||= writeSatisfiedStatus
      mapInfo.writeNormalizedMeasure ||= writeNormalizedMeasure
    })
    if ((objectiveID == None) && ((!primary) || (objective.objectiveMap.size > 0))) throw new SCORMParserException("`ObjectiveID` attribute not defined for objective")
    var readSatisfiedStatusCount = 0
    var readNormalizedMeasureCount = 0
    for ((targetIdentifier, mapInfo) <- objective.objectiveMap) {
      if (mapInfo.readSatisfiedStatus) readSatisfiedStatusCount += 1
      if (mapInfo.readNormalizedMeasure) readNormalizedMeasureCount += 1
    }
    if (readSatisfiedStatusCount > 1) throw new SCORMParserException("Only one global objective map per local objective may have `readSatisfiedStatus` attribute set to true")
    if (readNormalizedMeasureCount > 1) throw new SCORMParserException("Only one global objective map per local objective may have `readNormalizedMeasure` attribute set to true")
    objective
  }
}