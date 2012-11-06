package com.arcusys.learn.scorm.tracking.model.sequencing

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.util.TreeNode
import com.arcusys.learn.scorm.tracking.model.ActivityStateTree

abstract class ActivityStateTreeTestBase extends FlatSpec with ShouldMatchers with MockFactory with ProxyMockFactory {
  val organizationId = "OR"

  protected def rootOnlyTree(hasCurrent: Boolean = false, currentActive: Boolean = false, hasSuspended: Boolean = false) = {
    val organization = rootActivity()
    ActivityStateTree(new TreeNode[Activity](organization, Nil), if (hasCurrent) Some(organization.id) else None, currentActive, if (hasSuspended) Some(organization.id) else None)
  }

  protected def twoLevelTree(currentLevel: Option[Int] = None, rootPermissions: SequencingPermissions = SequencingPermissions.Default, currentActive: Boolean = false, suspendedLevel: Option[Int] = None) = {
    require(currentLevel.isEmpty || currentLevel.get <= 1)
    val organization = rootActivity(permissions = rootPermissions)
    val leaf1 = leafActivity("L1", Some(organization.id), organization.id)
    val leaf2 = leafActivity("L2", Some(organization.id), organization.id)
    val tree = new TreeNode[Activity](organization, Seq(new TreeNode[Activity](leaf1, Nil), new TreeNode[Activity](leaf2, Nil)))
    val current = currentLevel match {
      case Some(0) => Some(organization.id)
      case Some(1) => Some(leaf1.id)
      case _ => None
    }
    val suspended = suspendedLevel match {
      case Some(0) => Some(organization.id)
      case Some(1) => Some(leaf1.id)
      case _ => None
    }
    ActivityStateTree(tree, current, currentActive, suspended)
  }

  protected def twoLevelWideTree
  (
    currentLevel: Option[Int] = None, rootPermissions: SequencingPermissions = SequencingPermissions.Default,
    leftPermissions: SequencingPermissions = SequencingPermissions.Default, rightPermissions: SequencingPermissions = SequencingPermissions.Default, midPermissions: SequencingPermissions = SequencingPermissions.Default,
    leftPreConditionRules: Seq[PreConditionRule] = Nil, rightPreConditionRules: Seq[PreConditionRule] = Nil, midPreConditionRules: Seq[PreConditionRule] = Nil,
    currentActive: Boolean = false, suspendedLevel: Option[Int] = None) = {
    require(currentLevel.isEmpty || currentLevel.get <= 1)
    val organization = rootActivity(permissions = rootPermissions)
    val leaf1 = leafActivity("L1", Some(organization.id), organization.id, permissions = leftPermissions, preConditionRules = leftPreConditionRules)
    val leaf2 = leafActivity("L2", Some(organization.id), organization.id, permissions = midPermissions, preConditionRules = midPreConditionRules)
    val leaf3 = leafActivity("L2", Some(organization.id), organization.id, permissions = rightPermissions, preConditionRules = rightPreConditionRules)
    val tree = new TreeNode[Activity](organization, Seq(new TreeNode[Activity](leaf1, Nil), new TreeNode[Activity](leaf2, Nil), new TreeNode[Activity](leaf3, Nil)))
    val current = currentLevel match {
      case Some(0) => Some(organization.id)
      case Some(1) => Some(leaf1.id)
      case _ => None
    }
    val suspended = suspendedLevel match {
      case Some(0) => Some(organization.id)
      case Some(1) => Some(leaf1.id)
      case _ => None
    }
    ActivityStateTree(tree, current, currentActive, suspended)
  }

  protected def threeLevelTree(currentLevel: Option[Int] = None, rootPermissions: SequencingPermissions = SequencingPermissions.Default,
                               leftPermissions: SequencingPermissions = SequencingPermissions.Default,
                               rightPermissions: SequencingPermissions = SequencingPermissions.Default,
                               leftLeftPermissions: SequencingPermissions = SequencingPermissions.Default,
                               currentActive: Boolean = false, suspendedLevel: Option[Int] = None, tracking: Option[SequencingTracking] = Some(SequencingTracking.Default),
                               primaryObjectivesSet: Boolean = false, leftPreConditionRules: Seq[PreConditionRule] = Nil,
                               rightRightPreConditionRules: Seq[PreConditionRule] = Nil, rightPreConditionRules: Seq[PreConditionRule] = Nil, rootPreConditionRules: Seq[PreConditionRule] = Nil,
                               rightPreventChildrenActivation: Boolean = false, leftPreventChildrenActivation: Boolean = false, leftLeftPreventChildrenActivation: Boolean = false
                                ) = {
    require(currentLevel.isEmpty || currentLevel.get <= 2)
    val organization = rootActivity(permissions = rootPermissions, tracking = tracking,
      primaryObjective = if (primaryObjectivesSet) Some(new Objective(None, false, 1, ObjectiveMap.Empty)) else None,
      preConditionRules = rootPreConditionRules
    )
    val container1 = containerActivity("C1", Some(organization.id), organization.id, permissions = leftPermissions, tracking = tracking,
      primaryObjective = if (primaryObjectivesSet) Some(new Objective(None, false, 1, ObjectiveMap.Empty)) else None,
      preConditionRules = leftPreConditionRules, preventChildrenActivation = leftPreventChildrenActivation
    )
    val leaf11 = leafActivity("L11", Some(container1.id), organization.id, permissions = leftLeftPermissions, tracking = tracking, primaryObjective = if (primaryObjectivesSet) Some(new Objective(None, false, 1, ObjectiveMap.Empty)) else None,
      preventChildrenActivation = leftLeftPreventChildrenActivation)
    val leaf12 = leafActivity("L12", Some(container1.id), organization.id, tracking = tracking, primaryObjective = if (primaryObjectivesSet) Some(new Objective(None, false, 1, ObjectiveMap.Empty)) else None)
    val container2 = containerActivity("C2", Some(organization.id), organization.id, permissions = rightPermissions, tracking = tracking,
      primaryObjective = if (primaryObjectivesSet) Some(new Objective(None, false, 1, ObjectiveMap.Empty)) else None,
      preConditionRules = rightPreConditionRules, preventChildrenActivation = rightPreventChildrenActivation
    )
    val leaf21 = leafActivity("L21", Some(container2.id), organization.id, tracking = tracking, primaryObjective = if (primaryObjectivesSet) Some(new Objective(None, false, 1, ObjectiveMap.Empty)) else None)
    val leaf22 = leafActivity("L22", Some(container2.id), organization.id, tracking = tracking,
      primaryObjective = if (primaryObjectivesSet) Some(new Objective(None, false, 1, ObjectiveMap.Empty)) else None,
      preConditionRules = rightRightPreConditionRules
    )
    val tree = new TreeNode[Activity](organization, Seq(
      new TreeNode[Activity](container1, Seq(new TreeNode[Activity](leaf11, Nil), new TreeNode[Activity](leaf12, Nil))),
      new TreeNode[Activity](container2, Seq(new TreeNode[Activity](leaf21, Nil), new TreeNode[Activity](leaf22, Nil)))
    ))
    val current = currentLevel match {
      case Some(0) => Some(organization.id)
      case Some(1) => Some(container1.id)
      case Some(2) => Some(leaf11.id)
      case _ => None
    }
    val suspended = suspendedLevel match {
      case Some(0) => Some(organization.id)
      case Some(1) => Some(container1.id)
      case Some(2) => Some(leaf11.id)
      case _ => None
    }
    ActivityStateTree(tree, current, currentActive, suspended)
  }

  protected def rootActivity(permissions: SequencingPermissions = SequencingPermissions.Default, tracking: Option[SequencingTracking] = Some(SequencingTracking.Default),
                             primaryObjective: Option[Objective] = None, preConditionRules: Seq[PreConditionRule] = Nil) =
    new Organization(organizationId, "organization " + organizationId,
      sequencing = sequencing(permissions, None, tracking, primaryObjective, preConditionRules = preConditionRules)
    )

  protected def leafActivity
  (
    id: String, parentId: Option[String], organizationId: String = organizationId,
    permissions: SequencingPermissions = SequencingPermissions.Default, tracking: Option[SequencingTracking] = Some(SequencingTracking.Default),
    progressWeight: BigDecimal = CompletionThreshold.Default.progressWeight,
    primaryObjective: Option[Objective] = None,
    objectiveMeasureWeight: BigDecimal = 1,
    preConditionRules: Seq[PreConditionRule] = Nil,
    preventChildrenActivation: Boolean = false
    ) =
    new LeafActivity(id, "ACTIVITY " + id, parentId.getOrElse(organizationId), organizationId, "RES1",
      sequencing = sequencing(permissions, None, tracking, primaryObjective, objectiveMeasureWeight, preConditionRules, preventChildrenActivation = preventChildrenActivation),
      completionThreshold = new CompletionThreshold(CompletionThreshold.Default.completedByMeasure, CompletionThreshold.Default.minProgressMeasure, progressWeight)
    )

  protected def containerActivity
  (
    id: String, parentId: Option[String], organizationId: String = organizationId,
    permissions: SequencingPermissions = SequencingPermissions.Default, attemptLimit: Option[Int] = None, tracking: Option[SequencingTracking] = Some(SequencingTracking.Default),
    progressWeight: BigDecimal = CompletionThreshold.Default.progressWeight,
    primaryObjective: Option[Objective] = None,
    objectiveMeasureWeight: BigDecimal = 1,
    preConditionRules: Seq[PreConditionRule] = Nil, postConditionRules: Seq[PostConditionRule] = Nil, exitConditionRules: Seq[ExitConditionRule] = Nil,
    preventChildrenActivation: Boolean = false
    ) =
    new ContainerActivity(id, "ACTIVITY " + id, parentId.getOrElse(organizationId), organizationId,
      sequencing = sequencing(permissions, attemptLimit, tracking, primaryObjective, objectiveMeasureWeight,
        preConditionRules, postConditionRules, exitConditionRules, preventChildrenActivation),
      completionThreshold = new CompletionThreshold(CompletionThreshold.Default.completedByMeasure, CompletionThreshold.Default.minProgressMeasure, progressWeight)
    )

  private def sequencing(permissions: SequencingPermissions, attemptLimit: Option[Int], tracking: Option[SequencingTracking],
                         primaryObjective: Option[Objective] = None, objectiveMeasureWeight: BigDecimal = 1,
                         preConditionRules: Seq[PreConditionRule] = Nil, postConditionRules: Seq[PostConditionRule] = Nil, exitConditionRules: Seq[ExitConditionRule] = Nil,
                         preventChildrenActivation: Boolean = false
                          ) = new Sequencing(
    sharedId = None,
    sharedSequencingIdReference = None,
    permissions = permissions,
    onlyCurrentAttemptObjectiveProgressForChildren = true,
    onlyCurrentAttemptAttemptProgressForChildren = true,
    attemptLimit = attemptLimit,
    durationLimitInMilliseconds = None,
    rollupContribution = new RollupContribution(
      satisfaction = Some(new SatisfactionRollupContribution(contributeToSatisfied = RollupConsiderationType.Always, contributeToNotSatisfied = RollupConsiderationType.Always)),
      completion = Some(new CompletionRollupContribution(contributeToCompleted = RollupConsiderationType.Always, contributeToIncomplete = RollupConsiderationType.Always)),
      objectiveMeasureWeight = objectiveMeasureWeight,
      measureSatisfactionIfActive = true
    ),
    primaryObjective = primaryObjective,
    nonPrimaryObjectives = Nil,
    childrenSelection = new ChildrenSelection(),
    tracking = tracking,
    preventChildrenActivation = preventChildrenActivation,
    constrainChoice = false,
    preConditionRules = preConditionRules, postConditionRules = postConditionRules, exitConditionRules = exitConditionRules, rollupRules = Nil
  )
}
