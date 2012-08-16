package com.arcusys.scorm.lms.sequencing

import com.arcusys.learn.util.TreeNode
import model._
import scala.collection.mutable
import com.arcusys.learn.scorm.manifest.model._

/**
 * The whole activity state tree
 * @param organizationState State of the organization activity
 * @param children          Activity state nodes under organization
 * @param currentActivityID ID of current activity, if any
 */
class ActivityStateTree
(
  organizationState: ActivityState,
  children: Seq[ActivityStateNode],
  currentActivityID: Option[String],
  suspendedActivityID: Option[String],
  val globalObjectiveData: mutable.Map[String, GlobalObjectiveState]
  )
  extends ActivityStateNode(organizationState, children) {
  private val allActivities = mutable.Map[String, ActivityStateNode]()

  private def traverse(node: ActivityStateNode) {
    allActivities(node.item.activity.id) = node
    node.item.objectiveStates.foreach(_._2.globalObjectiveData = globalObjectiveData)
    node.children foreach traverse
  }

  traverse(this)

  require(currentActivityID.isEmpty || allActivities.contains(currentActivityID.get))

  /**State of current activity, if any */
  var currentActivity = currentActivityID map allActivities

  /**State of suspended activity, if any */
  var suspendedActivity = suspendedActivityID map allActivities

  /**Get node with given ID, if found */
  def apply(activityID: String): Option[ActivityStateNode] = allActivities.get(activityID)

  /**Sequencing Exit Action Rules Subprocess [TB.2.1]. */
  def applyExitConditionRules = {
    require(currentActivity.isDefined, "Current activity must be defined")
    //On path from root to parent current activity (inclusive) find first activity with exit rules evaluating to true
    currentActivity.get.pathToRoot.tail.reverse.find(_.item.exitConditionRuleApplies)
  }

  /**
   * Sequencing Post Condition Rules Subprocess [TB.2.2]
   * @return a termination request and a sequencing request
   */
  def applyPostConditionRules: SequencingRulesResponse = {
    require(currentActivity.isDefined, "Current activity must be defined")
    if (currentActivity.get.item.suspended) SequencingRulesResponse()
    // Apply the post condition rules to the current activity.
    else currentActivity.get.item.postConditionRuleAction match {
      case None => SequencingRulesResponse()
      case Some(sequencingRulesCheckResponse: PostConditionAction.Value) => sequencingRulesCheckResponse match {
        case PostConditionAction.ExitParent => SequencingRulesResponse.termination(TerminationRequestType.ExitParent)
        case PostConditionAction.ExitAll => SequencingRulesResponse.termination(TerminationRequestType.ExitAll)
        case PostConditionAction.Retry => SequencingRulesResponse.sequencing(SequencingRequestType.Retry)
        case PostConditionAction.Continue => SequencingRulesResponse.sequencing(SequencingRequestType.Continue)
        case PostConditionAction.Previous => SequencingRulesResponse.sequencing(SequencingRequestType.Previous)
        //TODO: calling code ignores sequencing request in this case. Study other implementations
        case PostConditionAction.RetryAll => SequencingRulesResponse(TerminationRequestType.ExitAll, SequencingRequestType.Retry)
        case _ => SequencingRulesResponse()
      }
    }
  }

  def flatPreOrderedActivityList: Seq[ActivityStateNode] = {
    def traverse(nodes: Seq[ActivityStateNode]): Seq[ActivityStateNode] = {
      nodes.foldLeft(Seq[ActivityStateNode]()) {
        (resultedList, nodeActivity) => {
          (resultedList :+ nodeActivity) ++ traverse(nodeActivity.availableChildren)
        }
      }
    }

    this +: traverse(availableChildren)
  }
}

object ActivityStateTree {
  def apply(organizationTree: TreeNode[Activity], currentActivityID: Option[String], currentActive: Boolean, suspendedActivityID: Option[String]) = {
    val globalObjectivesMapData = new mutable.HashMap[String, GlobalObjectiveState] with mutable.SynchronizedMap[String, GlobalObjectiveState]

    def objectiveState(activity: Activity, objectiveID: Option[String], mapInfo: ObjectiveMap) = new ObjectiveState(satisfied = None, normalizedMeasure = None, objectiveMapInfo = mapInfo)
    def parse(activityNode: TreeNode[Activity]): ActivityStateNode = {
      val objectiveMap: Map[Option[String], ObjectiveState] = activityNode.item.sequencing.nonPrimaryObjectives.map(objective => Some(objective.id.get) -> objectiveState(activityNode.item, Some(objective.id.get), objective.globalObjectiveMap)).toMap ++
        (activityNode.item.sequencing.primaryObjective match {
          case None => Map[Option[String], ObjectiveState]()
          case Some(primaryObjective) => Map[Option[String], ObjectiveState](None -> objectiveState(activityNode.item, primaryObjective.id, primaryObjective.globalObjectiveMap))
        })
      val activityState = new ActivityState(activityNode.item, active = false, suspended = false, attemptCompleted = None, attemptCompletionAmount = None,
        attemptAbsoluteDuration = 0, attemptExperiencedDuration = 0,
        activityAbsoluteDuration = 0, activityExperiencedDuration = 0, attemptCount = 0,
        objectiveStates = objectiveMap)
      val result = new ActivityStateNode(activityState, activityNode.children map parse)
      if ((Some(activityNode.item.id) == currentActivityID && currentActive) ||
        (result.children.exists(a => a.item.active || Some(a.item.activity.id) == currentActivityID))
      ) activityState.active = true
      if ((Some(activityNode.item.id) == suspendedActivityID) || (result.children.exists(a => a.item.suspended))) activityState.suspended = true
      result
    }
    val organizationStateTree = parse(organizationTree)
    new ActivityStateTree(organizationStateTree.item, organizationStateTree.children, currentActivityID, suspendedActivityID, globalObjectivesMapData)
  }
}