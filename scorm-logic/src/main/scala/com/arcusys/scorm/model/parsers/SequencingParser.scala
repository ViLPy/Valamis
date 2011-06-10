package com.arcusys.scorm.model.parsers

import com.arcusys.scorm.model._
import scala.collection.JavaConversions._
import scala.collection.mutable.Set
import javax.xml.datatype.DatatypeConfigurationException
import javax.xml.datatype.DatatypeFactory
import java.util.Calendar
import XMLImplicits._
import scala.xml.Elem

class SequencingParser(val sequencingElement: Elem, val shared: Boolean) {

  def parse: Sequencing = {
    val ID =  sequencingElement %? "ID"
    val IDRef = sequencingElement %? "IDRef"
    val controlModeElement = sequencingElement \? ("imsss","controlMode")
    val rollupRulesElement = sequencingElement \? ("imsss","rollupRules")
    val objectivesElement = sequencingElement \? ("imsss","objectives")
    if (shared && ID == None)  throw new SCORMParserException("Shared <sequencing> elements must have `ID` attribute specified")    
    if (shared && IDRef != None) throw new SCORMParserException("Shared <sequencing> elements cannot have `IDRef` attribute specified")
    if (!shared && ID != None) throw new SCORMParserException("Non-shared <sequencing> elements cannot have `ID` attribute specified")
    val choicePermittedForChildren = controlModeElement match {case None => true; case Some(e)=> (e %? "choice").getOrElse("true").toBoolean}
    val choicePermittedForNonDescendents = controlModeElement match {case None => true; case Some(e)=> (e %? "choiceExit").getOrElse("true").toBoolean}
    val continuePreviousFlowPermittedForChildren = controlModeElement match {case None => false; case Some(e)=> (e %? "flow").getOrElse("false").toBoolean}
    val forwardOnlyForChildren = controlModeElement match {case None => false; case Some(e)=> (e %? "forwardOnly").getOrElse("false").toBoolean}
    val rollupOnlyCurrentAttemptObjectiveProgressForChildren = controlModeElement match {case None => true; case Some(e)=> (e %? "useCurrentAttemptObjectiveInfo").getOrElse("true").toBoolean}
    val rollupOnlyCurrentAttemptAttemptProgressForChildren = controlModeElement match {case None => true; case Some(e)=> (e %? "useCurrentAttemptProgressInfo").getOrElse("true").toBoolean}
    val (attemptLimit, durationLimitInMilliseconds) = sequencingElement \? ("imsss","limitConditions") match {
      case None => (None, None)
      case Some(e) => (
          (e %? "attemptLimit").map(_.toInt),
          (e %? "attemptAbsoluteDurationLimit").map(limitString =>
            try {BigInt(DatatypeFactory.newInstance().newDuration(limitString).getTimeInMillis(Calendar.getInstance.getTime))}
            catch {case ex: DatatypeConfigurationException => throw new SCORMParserException("Error reading duration value")})
        )
    }
    val (rollupObjectiveSatisfied, rollupProgressCompletion, objectiveMeasureWeight) = rollupRulesElement match{
      case None => (true, true, BigDecimal.apply(1))
      case Some(e) => (
          (e %? "rollupObjectiveSatisfied").getOrElse("true").toBoolean,
          (e %? "rollupProgressCompletion").getOrElse("true").toBoolean,
          BigDecimal((e %? "objectiveMeasureWeight").getOrElse("1"))
        )
    }
    if (objectiveMeasureWeight > 1 || objectiveMeasureWeight < 0) throw new SCORMParserException("Invalid `objectiveMeasureWeight` attribute value")    
    val primaryObjective = objectivesElement.map(e=> new ObjectiveParser(e \! ("imsss","primaryObjective")).parse(true))
    val (randomizationTiming, selectionTiming, childrenSelectCount, reorderChildren) = sequencingElement \? ("imsss","randomizationControls") match {
      case None => (RandomizationTimingType.Never, RandomizationTimingType.Never, None, false)
      case Some(e) => (
          TokenParser.parseRandomizationTimingType((e %? "randomizationTiming").getOrElse("never")),
          TokenParser.parseRandomizationTimingType((e %? "selectionTiming").getOrElse("never")),
          (e %? "selectCount").map(_.toInt),
          (e %? "reorderChildren").getOrElse("false").toBoolean
        )
    }
    if (childrenSelectCount.getOrElse(0) < 0) throw new SCORMParserException("Invalid value of `selectCount` attribute")

    val (tracked, completionSetByContent, objectiveSetByContent) = sequencingElement \? ("imsss","deliveryControls") match {
      case None => (true, false, false)
      case Some(e) => (
          (e %? "tracked").getOrElse("true").toBoolean,
          (e %? "completionSetByContent").getOrElse("false").toBoolean,
          (e %? "objectiveSetByContent").getOrElse("false").toBoolean
        )
    }
    val (preventChildrenActivation, constrainChoice) = sequencingElement \? ("adlseq","constrainedChoiceConsiderations") match {
      case None => (false, false)
      case Some(e) => (
          (e %? "preventActivation").getOrElse("false").toBoolean,
          (e %? "constrainChoice").getOrElse("false").toBoolean
        )
    }
    val (contributeToSatisfiedRollup, contributeToNotSatisfiedRollup, contributeToCompletedRollup, contributeToIncompleteRollup, measureSafisfactionIfActive) =
      sequencingElement \? "adlseq:rollupConsiderations" match {
        case None => (RollupConsiderationType.Always, RollupConsiderationType.Always, RollupConsiderationType.Always, RollupConsiderationType.Always, true)
        case Some(e) =>(
            TokenParser.parseRollupConsiderationType((e %? "requiredForSatisfied").getOrElse("always")),
            TokenParser.parseRollupConsiderationType((e %? "requiredForNotSatisfied").getOrElse("always")),
            TokenParser.parseRollupConsiderationType((e %? "requiredForCompleted").getOrElse("always")),
            TokenParser.parseRollupConsiderationType((e %? "requiredForIncomplete").getOrElse("always")),
            (e %? "measureSafisfactionIfActive").getOrElse("true").toBoolean
          )
      }
    val sequencing = new Sequencing(ID, IDRef,
                                    choicePermittedForChildren, choicePermittedForNonDescendents, continuePreviousFlowPermittedForChildren, forwardOnlyForChildren,
                                    rollupOnlyCurrentAttemptObjectiveProgressForChildren, rollupOnlyCurrentAttemptAttemptProgressForChildren,
                                    attemptLimit, durationLimitInMilliseconds,
                                    rollupObjectiveSatisfied, rollupProgressCompletion, objectiveMeasureWeight,
                                    primaryObjective,
                                    randomizationTiming, childrenSelectCount, reorderChildren, selectionTiming,
                                    tracked, completionSetByContent, objectiveSetByContent,
                                    preventChildrenActivation, constrainChoice,
                                    contributeToSatisfiedRollup, contributeToNotSatisfiedRollup, contributeToCompletedRollup, contributeToIncompleteRollup,measureSafisfactionIfActive
    )

    for(e<-sequencingElement \? ("imsss","sequencingRules")) {
      for(elem<-e\("imsss","preConditionRule")) sequencing.preConditionRules += new SequencingRuleParser(elem.asInstanceOf[Elem]).parsePreConditionRule
      for(elem<-e\("imsss","postConditionRule")) sequencing.postConditionRules += new SequencingRuleParser(elem.asInstanceOf[Elem]).parsePostConditionRule
      for(elem<-e\("imsss","exitConditionRule")) sequencing.exitConditionRules += new SequencingRuleParser(elem.asInstanceOf[Elem]).parseExitConditionRule
    }
    for (e<-rollupRulesElement) 
      for(elem<-e\("imsss","rollupRule")) sequencing.rollupRules += new RollupRuleParser(elem.asInstanceOf[Elem]).parse
    
    for (e<-objectivesElement) {
      val writeSatisfiedStatusMentioned = Set[String]()
      val writeNormalizedMeasureMentioned = Set[String]()
      checkObjectiveMapAttributesMultiplicity(primaryObjective.get, writeSatisfiedStatusMentioned, writeNormalizedMeasureMentioned)
      for(elem<-e\("imsss","objective"))
      {
        val objective = new ObjectiveParser(elem.asInstanceOf[Elem]).parse(false)
        if ((sequencing.nonPrimaryObjectives.containsKey(objective.identifier.get)) || (primaryObjective.get.identifier == objective.identifier))
          throw new SCORMParserException("Objective identifier not unique: " + objective.identifier.get)
        checkObjectiveMapAttributesMultiplicity(objective, writeSatisfiedStatusMentioned, writeNormalizedMeasureMentioned)
        sequencing.nonPrimaryObjectives(objective.identifier.get) = objective
      }
    }
    for (e<-sequencingElement \? ("adlseq","objectives")) {
      val writeRawScoreMentioned = Set[String]()
      val writeMinScoreMentioned = Set[String]()
      val writeMaxScoreMentioned = Set[String]()
      val writeCompletionStatusMentioned = Set[String]()
      val writeProgressMeasureMentioned = Set[String]()
      
      for(extendedObjectiveElement<-e \!! ("adlseq","objective")) {
        val objectiveIdentifier = extendedObjectiveElement.asInstanceOf[Elem] %! "objectiveID"
        if (!sequencing.nonPrimaryObjectives.contains(objectiveIdentifier)) 
          throw new SCORMParserException("<adseq:objective> describes an objective with ID not mentioned in <imsss:objective> " + objectiveIdentifier)
        val extendedMappingElements = extendedObjectiveElement.asInstanceOf[Elem] \!! ("adlseq","mapInfo")
        val objective = sequencing.nonPrimaryObjectives(objectiveIdentifier)
        new ObjectiveAdditionalMappingParser(objective, extendedMappingElements).parse
        checkExtendedObjectiveMapAttributesMultiplicity(objective, writeRawScoreMentioned, writeMinScoreMentioned, writeMaxScoreMentioned, writeCompletionStatusMentioned, writeProgressMeasureMentioned);
      }
    }
    sequencing
  }

  private def checkObjectiveMapAttributesMultiplicity(objective: Objective, writeSatisfiedStatusMentioned: Set[String], writeNormalizedMeasureMentioned: Set[String]) {
    for ((targetIdentifier, mapInfo) <- objective.objectiveMap) {
      if (mapInfo.writeSatisfiedStatus) 
        if (writeSatisfiedStatusMentioned.contains(targetIdentifier))  throw new SCORMParserException("More than one <primaryObjective> or <objective> element per activity defines `writeSatisfiedStatus` attribute as true for activity")
      else writeSatisfiedStatusMentioned += targetIdentifier
      
      if (mapInfo.writeNormalizedMeasure) 
        if (writeNormalizedMeasureMentioned.contains(targetIdentifier)) throw new SCORMParserException("More than one <primaryObjective> or <objective> element per activity defines `writeNormalizedMeasure` attribute as true for activity")
      else writeNormalizedMeasureMentioned += targetIdentifier
      
    }
  }

  private def checkExtendedObjectiveMapAttributesMultiplicity(objective: Objective, writeRawScoreMentioned: Set[String], writeMinScoreMentioned: Set[String], writeMaxScoreMentioned: Set[String], writeCompletionStatusMentioned: Set[String], writeProgressMeasureMentioned: Set[String]) {
    for ((targetIdentifier, mapInfo) <- objective.objectiveMap) {
      if (mapInfo.writeRawScore) 
        if (writeRawScoreMentioned.contains(targetIdentifier)) throw new SCORMParserException("More than one <objective> element per activity defines `writeRawScore` attribute as true for activity")
      else writeRawScoreMentioned += targetIdentifier
      
      if (mapInfo.writeMinScore) 
        if (writeMinScoreMentioned.contains(targetIdentifier)) throw new SCORMParserException("More than one <objective> element per activity defines `writeMinScore` attribute as true for activity")
      else writeMinScoreMentioned += targetIdentifier
      
      if (mapInfo.writeMaxScore) 
        if (writeMaxScoreMentioned.contains(targetIdentifier)) throw new SCORMParserException("More than one <objective> element per activity defines `writeMaxScore` attribute as true for activity")
      else writeMaxScoreMentioned += targetIdentifier
      
      if (mapInfo.writeCompletionStatus)
        if (writeCompletionStatusMentioned.contains(targetIdentifier)) throw new SCORMParserException("More than one <objective> element per activity defines `writeCompletionStatus` attribute as true for activity")
      else writeCompletionStatusMentioned += targetIdentifier
      
      if (mapInfo.writeProgressMeasure) 
        if (writeProgressMeasureMentioned.contains(targetIdentifier)) throw new SCORMParserException("More than one <objective> element per activity defines `writeProgressMeasure` attribute as true for activity")
      else writeProgressMeasureMentioned += targetIdentifier
    }
  }
}