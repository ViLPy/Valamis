package com.arcusys.valamis.lesson.scorm.service.parser

import java.util.Calendar
import javax.xml.datatype.{ DatatypeConfigurationException, DatatypeFactory }

import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.valamis.util.XMLImplicits
import com.arcusys.valamis.util.XMLImplicits._

import scala.xml.Elem

class SequencingParser(val sequencingElement: Elem, val shared: Boolean, sharedSequencing: Seq[Sequencing] = Nil) {

  def parse: Sequencing = {
    val ID = sequencingElement attr "ID" optional string
    val IDRef = sequencingElement attr "IDRef" optional string
    val controlModeElement = sequencingElement childElem ("imsss", "controlMode") optional element
    val limitConditionsElement = sequencingElement childElem ("imsss", "limitConditions") optional element
    val rollupRulesElement = sequencingElement childElem ("imsss", "rollupRules") optional element
    val objectivesElement = sequencingElement childElem ("imsss", "objectives") optional element
    val deliveryControlsElement = sequencingElement childElem ("imsss", "deliveryControls") optional element
    val constrainedChoiceConsiderationsElement = sequencingElement childElem ("adlseq", "constrainedChoiceConsiderations") optional element
    val rollupConsiderationsElement = sequencingElement childElem "adlseq:rollupConsiderations" optional element
    val sequencingRulesElement = sequencingElement childElem ("imsss", "sequencingRules") optional element
    if (shared && ID == None) throw new SCORMParserException("Shared <sequencing> elements must have `ID` attribute specified")
    if (shared && IDRef != None) throw new SCORMParserException("Shared <sequencing> elements cannot have `IDRef` attribute specified")
    if (!shared && ID != None) throw new SCORMParserException("Non-shared <sequencing> elements cannot have `ID` attribute specified")

    val defaultSharedSequencing = if (IDRef != None) {
      sharedSequencing.find(_.sharedId == IDRef) match {
        case Some(sequencing) => sequencing
        case _                => throw new Exception("Shared sequencing doesn't exists")
      }
    } else {
      Sequencing.Default
    }

    val permissions = new SequencingPermissions(
      controlModeElement attr "choice" withDefault defaultSharedSequencing.permissions.choiceForChildren,
      controlModeElement attr "choiceExit" withDefault defaultSharedSequencing.permissions.choiceForNonDescendants,
      controlModeElement attr "flow" withDefault defaultSharedSequencing.permissions.flowForChildren,
      controlModeElement attr "forwardOnly" withDefault defaultSharedSequencing.permissions.forwardOnlyForChildren
    )

    val rollupOnlyCurrentAttemptObjectiveProgressForChildren = controlModeElement attr "useCurrentAttemptObjectiveInfo" withDefault defaultSharedSequencing.onlyCurrentAttemptObjectiveProgressForChildren
    val rollupOnlyCurrentAttemptAttemptProgressForChildren = controlModeElement attr "useCurrentAttemptProgressInfo" withDefault defaultSharedSequencing.onlyCurrentAttemptAttemptProgressForChildren

    val attemptLimitOption = limitConditionsElement attr "attemptLimit" optional int
    val attemptLimit = if (attemptLimitOption.isEmpty) defaultSharedSequencing.attemptLimit else attemptLimitOption

    val durationLimitInMillisecondsOption = (limitConditionsElement attr "attemptAbsoluteDurationLimit" optional string).map(limitString =>
      try {
        DatatypeFactory.newInstance().newDuration(limitString).getTimeInMillis(Calendar.getInstance.getTime)
      } catch {
        case ex: DatatypeConfigurationException => throw new SCORMParserException("Error reading duration value")
      })

    val durationLimitInMilliseconds = if (durationLimitInMillisecondsOption.isEmpty) defaultSharedSequencing.durationLimitInMilliseconds else durationLimitInMillisecondsOption

    //val defaultRollupContribution = Sequencing.Default.rollupContribution
    val rollupSatisfaction = rollupRulesElement attr "rollupObjectiveSatisfied" withDefault defaultSharedSequencing.rollupContribution.satisfaction.isDefined
    val rollupCompletion = rollupRulesElement attr "rollupProgressCompletion" withDefault defaultSharedSequencing.rollupContribution.satisfaction.isDefined
    val objectiveMeasureWeight = rollupRulesElement attr "objectiveMeasureWeight" withDefault defaultSharedSequencing.rollupContribution.objectiveMeasureWeight

    val extendedObjectiveMap = (sequencingElement childElem ("adlseq", "objectives") optional element match {
      case None => Nil
      case Some(e) =>
        for {
          extendedObjectiveElement <- e children ("adlseq", "objective")
          objectiveIdentifier = extendedObjectiveElement attr "objectiveID" required string
          extendedMappingElements = extendedObjectiveElement children ("adlseq", "mapInfo")
        } yield (objectiveIdentifier, extendedMappingElements)
    }).toMap
    //TODO: maybe we should keep this check
    //if (!nonPrimaryObjectiveMap.contains(objectiveIdentifier))
    //  throw new SCORMParserException("<adseq:objective> describes an objective with ID not mentioned in <imsss:objective> " + objectiveIdentifier)
    val primaryObjectiveOption = objectivesElement.map(e => parsePrimaryObjective(e childElem ("imsss", "primaryObjective") required element, extendedObjectiveMap))
    val primaryObjective = if (primaryObjectiveOption.isEmpty) defaultSharedSequencing.primaryObjective else primaryObjectiveOption

    val childrenSelection = sequencingElement childElem ("imsss", "randomizationControls") optional element match {
      case None => defaultSharedSequencing.childrenSelection
      case Some(e) => {
        val count = e attr "selectCount" optional int
        val selectionTiming = e attr "selectionTiming" withDefault "never"
        val reorderChildren = e attr "reorderChildren" withDefault false
        val randomizationTiming = e attr "randomizationTiming" withDefault "never"

        new ChildrenSelection(
          if (count.isDefined)
            if (selectionTiming == "never") throw new SCORMParserException("selectionTiming cannot be 'never' if count is defined")
          else Some(new ChildrenSelectionTake(count.get, RandomizationTimingType.withName(selectionTiming)))
          else None,
          if (reorderChildren)
            if (randomizationTiming == "never") throw new SCORMParserException("randomizationTiming cannot be 'never' if reorderChildren is 'true'")
          else Some(RandomizationTimingType.withName(randomizationTiming))
          else None
        )
      }
    }
    val trackingOption =
      if (deliveryControlsElement attr "tracked" withDefault true) Some(new SequencingTracking(
        deliveryControlsElement attr "completionSetByContent" withDefault SequencingTracking.Default.completionSetByContent,
        deliveryControlsElement attr "objectiveSetByContent" withDefault SequencingTracking.Default.objectiveSetByContent
      ))
      else None

    val tracking = if (trackingOption.isDefined
      && trackingOption.get.completionSetByContent == SequencingTracking.Default.completionSetByContent
      && trackingOption.get.objectiveSetByContent == SequencingTracking.Default.objectiveSetByContent) {
      defaultSharedSequencing.tracking
    } else {
      trackingOption
    }

    val preventChildrenActivation = constrainedChoiceConsiderationsElement attr "preventActivation" withDefault defaultSharedSequencing.preventChildrenActivation
    val constrainChoice = constrainedChoiceConsiderationsElement attr "constrainChoice" withDefault defaultSharedSequencing.constrainChoice

    val satisfactionContribution = new SatisfactionRollupContribution(
      contributeToSatisfied = rollupConsiderationsElement attr "requiredForSatisfied" withDefault (RollupConsiderationType, defaultSharedSequencing.rollupContribution.satisfaction match {
        case Some(data) => data.contributeToSatisfied
        case _          => RollupContribution.Default.satisfaction.get.contributeToSatisfied
      }),
      contributeToNotSatisfied = rollupConsiderationsElement attr "requiredForNotSatisfied" withDefault (RollupConsiderationType, defaultSharedSequencing.rollupContribution.satisfaction match {
        case Some(data) => data.contributeToNotSatisfied
        case _          => RollupContribution.Default.satisfaction.get.contributeToNotSatisfied
      })
    )
    val completionContribution = new CompletionRollupContribution(
      contributeToCompleted = rollupConsiderationsElement attr "requiredForCompleted" withDefault (RollupConsiderationType, defaultSharedSequencing.rollupContribution.completion match {
        case Some(data) => data.contributeToCompleted
        case _          => RollupContribution.Default.completion.get.contributeToCompleted
      }),
      contributeToIncomplete = rollupConsiderationsElement attr "requiredForIncomplete" withDefault (RollupConsiderationType, defaultSharedSequencing.rollupContribution.completion match {
        case Some(data) => data.contributeToIncomplete
        case _          => RollupContribution.Default.completion.get.contributeToIncomplete
      })
    )
    val measureSatisfactionIfActive = rollupConsiderationsElement attr "measureSafisfactionIfActive" withDefault defaultSharedSequencing.rollupContribution.measureSatisfactionIfActive
    //TODO: warning if there's extended contribution stuff defined while activity doesn't contribute at all
    val parsedRollupRules = rollupRulesElement children ("imsss", "rollupRule") map parseRollupRule
    val rollupRules = if (parsedRollupRules.isEmpty) {
      Seq(new RollupRule(ChildActivitySetAll, new RuleConditionSet(Seq(new RuleCondition(ConditionType.ObjectiveSatisfied)), ConditionCombination.Any), RollupAction.Satisfied),
        new RollupRule(ChildActivitySetAll, new RuleConditionSet(Seq(new RuleCondition(ConditionType.ObjectiveStatusKnown)), ConditionCombination.Any), RollupAction.NotSatisfied))
    } else parsedRollupRules

    val preConditionRules = (sequencingRulesElement children ("imsss", "preConditionRule") map parsePreConditionRule) ++ defaultSharedSequencing.preConditionRules
    val postConditionRules = (sequencingRulesElement children ("imsss", "postConditionRule") map parsePostConditionRule) ++ defaultSharedSequencing.postConditionRules
    val exitConditionRules = (sequencingRulesElement children ("imsss", "exitConditionRule") map parseExitConditionRule) ++ defaultSharedSequencing.exitConditionRules

    val nonPrimaryObjectives = (objectivesElement children ("imsss", "objective") map (parseNonPrimaryObjective(_, extendedObjectiveMap))) ++ defaultSharedSequencing.nonPrimaryObjectives

    val rollupContribution = new RollupContribution(
      satisfaction = if (rollupSatisfaction) Some(satisfactionContribution) else None,
      completion = if (rollupCompletion) Some(completionContribution) else None,
      objectiveMeasureWeight = objectiveMeasureWeight,
      measureSatisfactionIfActive = measureSatisfactionIfActive
    )

    new Sequencing(ID, IDRef, permissions, rollupOnlyCurrentAttemptObjectiveProgressForChildren, rollupOnlyCurrentAttemptAttemptProgressForChildren,
      attemptLimit, durationLimitInMilliseconds, rollupContribution, primaryObjective, nonPrimaryObjectives, childrenSelection, tracking,
      preventChildrenActivation, constrainChoice, preConditionRules, postConditionRules, exitConditionRules, rollupRules
    )
  }
}