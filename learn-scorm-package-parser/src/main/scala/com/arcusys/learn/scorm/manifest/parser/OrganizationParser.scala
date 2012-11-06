package com.arcusys.learn.scorm.manifest.parser

import com.arcusys.learn.scorm.manifest.model._
import XMLImplicits._
import scala.xml.Elem
import com.arcusys.learn.util.TreeNode

class OrganizationParser(organizationElement: Elem, resourceMap: Map[String, Resource], adlcpNs: String, adlseqNs: String, scormVersion: String, sharedSequencing: Seq[Sequencing]) {
  def parse: TreeNode[Activity] = {
    val id = organizationElement attr "identifier" required string
    //TODO: warning if organizationElement attr "structure" optional string is present and is not "hierarchical"
    val objectivesGlobalToSystem = organizationElement attr(adlseqNs, "objectivesGlobalToSystem") withDefault true
    val sharedDataGlobalToSystem = organizationElement attr(adlcpNs, "sharedDataGlobalToSystem") withDefault true
    val title = organizationElement childElem "title" required string
    val itemElements = organizationElement children "item"
    val metadata = organizationElement childElem "metadata" optional parseMetadata _
    val sequencing = organizationElement childElem("imsss", "sequencing") optional (element => parseActivitySequencing(element, sharedSequencing)) getOrElse (scormVersion match {
      case "1.2" => new Sequencing(
        sharedId = Sequencing.Default.sharedId,
        sharedSequencingIdReference = Sequencing.Default.sharedSequencingIdReference,
        permissions = new SequencingPermissions(choiceForChildren = true, choiceForNonDescendants = true, flowForChildren = true, forwardOnlyForChildren = false),
        onlyCurrentAttemptObjectiveProgressForChildren = Sequencing.Default.onlyCurrentAttemptObjectiveProgressForChildren,
        onlyCurrentAttemptAttemptProgressForChildren = Sequencing.Default.onlyCurrentAttemptAttemptProgressForChildren,
        attemptLimit = Sequencing.Default.attemptLimit,
        durationLimitInMilliseconds = Sequencing.Default.durationLimitInMilliseconds,
        rollupContribution = RollupContribution.Default,
        primaryObjective = Sequencing.Default.primaryObjective,
        nonPrimaryObjectives = Sequencing.Default.nonPrimaryObjectives,
        childrenSelection = Sequencing.Default.childrenSelection,
        tracking = Sequencing.Default.tracking,
        preventChildrenActivation = Sequencing.Default.preventChildrenActivation,
        constrainChoice = Sequencing.Default.constrainChoice,
        preConditionRules = Nil, postConditionRules = Nil, exitConditionRules = Nil, rollupRules = Nil
      )
      case _ => Sequencing.Default
    })
    val completionThreshold = organizationElement childElem("adlcp", "completionThreshold") optional parseCompletionThreshold _ getOrElse CompletionThreshold.Default

    val organization = new Organization(id, title, objectivesGlobalToSystem, sharedDataGlobalToSystem, sequencing, completionThreshold, metadata)
    def parseThisActivity(elem: Elem) = parseActivity(elem, resourceMap, id, None, scormVersion, sharedSequencing)
    val activities = itemElements map parseThisActivity
    new TreeNode[Activity](organization, activities)
  }
}