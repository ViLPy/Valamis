package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.util.Extensions._
import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode}

class SequencingRequestService(implicit val bindingModule: BindingModule)
  extends SequencingRequestServiceContract with Injectable {
  private val endAttemptService = inject[EndAttemptServiceContract]

  /**
   * Sequencing Request Process [SB.2.12]
   * Validates the sequencing request
   * @param tree              Activity state tree for attempt
   * @param requestType       Type of the sequencing request
   * @param targetActivityID  ID of the target activity; has sense only for Choice and Jump requests
   * @return                  A delivery request; may indicate control be returned to the LTS; may return an exception code
   */
  def apply(tree: ActivityStateTree, requestType: SequencingRequestType.Value, targetActivityID: String = ""): SequencingResponse = {
    import SequencingRequestType._
    lazy val target = tree(targetActivityID)
    if (requestType.oneOf(Choice, Jump) && target.isEmpty) SequencingResponse.invalid("Target activity does not exist")
    requestType match {
      case Start => start(tree)
      case ResumeAll => resumeAll(tree)
      case Exit => exit(tree)
      case Retry => retry(tree)
      case Continue => continue(tree)
      case Previous => previous(tree)
      case Choice => choice(tree, target.get)
      case Jump => jump(tree, target.get)
    }
  }

  /**
   * Start Sequencing Request Process [SB.2.5]
   * @return a delivery request; may indicate control be returned to the LTS; may return an exception code
   */
  private def start(tree: ActivityStateTree) =
    if (tree.currentActivity.isDefined) SequencingResponse.invalid("Current Activity is defined / Sequencing session already begun")
    else flow(tree, tree, flowForward = true, considerChildren = true)

  /**
   * Resume All Sequencing Request Process [SB.2.6]
   */
  private def resumeAll(tree: ActivityStateTree) =
    if (tree.currentActivity.isDefined || !tree.suspendedActivity.isDefined) SequencingResponse.invalid("Current Activity is defined / Sequencing session already begun, or Suspended Activity is not defined")
    else SequencingResponse.delivery(tree.suspendedActivity.get)

  /**
   * Exit Sequencing Request Process [SB.2.11]
   */
  private def exit(tree: ActivityStateTree) =
    tree.currentActivity match {
      case Some(currentActivity) =>
        if (currentActivity.item.active) SequencingResponse.invalid("Current Activity is active")
        else if (currentActivity.isRoot) SequencingResponse.endSession
        else SequencingResponse.empty
      case _ => SequencingResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }

  /**
   * Retry Sequencing Request Process [SB.2.10]
   */
  private def retry(tree: ActivityStateTree) =
    tree.currentActivity match {
      case Some(currentActivity) => {
        if (currentActivity.item.active || currentActivity.item.suspended) SequencingResponse.invalid("Current Activity is active or suspended")
        else if (!currentActivity.isLeaf)
          flow(tree, currentActivity, flowForward = true, considerChildren = true) match {
            case SequencingResponseDelivery(activity) => SequencingResponse.delivery(activity)
            //TODO: currently this is not reachable, but do we actually consider the case of flow violation in case of retry?
            case _ => SequencingResponse.invalid("Flow Sequencing Control Mode violation")
          }
        else SequencingResponse.delivery(currentActivity)
      }
      case _ => SequencingResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }

  /**
   * Continue Sequencing Request Process [SB.2.7]
   */
  private def continue(tree: ActivityStateTree) =
    tree.currentActivity match {
      case Some(activity) =>
        if (!activity.isRoot && !activity.parent.get.item.sequencingPermissions.flowForChildren)
          SequencingResponse.invalid("Flow Sequencing Control Mode violation")
        else flow(tree, activity, flowForward = true, considerChildren = false)
      case _ => SequencingResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }

  /**
   * Previous Sequencing Request Process [SB.2.8]
   */
  private def previous(tree: ActivityStateTree) =
    tree.currentActivity match {
      case Some(activity) =>
        if (!activity.isRoot && !activity.parent.get.item.sequencingPermissions.flowForChildren)
          SequencingResponse.invalid("Flow Sequencing Control Mode violation")
        else flow(tree, activity, flowForward = false, considerChildren = false)
      case _ => SequencingResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }

  /**
   * Choice Sequencing Request Process [SB.2.9]
   * @param targetActivity target activity
   * @return may return a delivery request; may change the Current Activity; may return an exception code
   */
  private def choice(tree: ActivityStateTree, targetActivity: ActivityStateNode): SequencingResponse = {
    val targetActivityPath = targetActivity.pathToRoot.reverse
    targetActivityPath.foreach(activity => {
      if (!activity.isAvailableChild) return SequencingResponse.invalid("Target activity does not exist or is unavailable")
      // Confirm that control mode allow 'choice' of the target
      if (activity.item.preConditionRuleApplies(PreConditionAction.HiddenFromChoice)) {
        return SequencingResponse.invalid("Target activity hidden from choice")
      }
    })
    if (!targetActivity.isRoot && !targetActivity.parent.get.item.sequencingPermissions.choiceForChildren)
      return SequencingResponse.invalid("Choice Sequencing Control Mode violation")

    val commonAncestor = tree.currentActivity match {
      case Some(currentActivity) => (currentActivity commonAncestor targetActivity).get
      case None => tree
    }
    // Activity path from the common ancestor to the target activity, exclusive of the target activity
    lazy val pathFromAncestorToTargetExclusive = {
      val commonAncestorIndex = targetActivityPath indexOf commonAncestor
      targetActivityPath.slice(commonAncestorIndex, targetActivityPath.length - 1)
    }
    // Activity path from the Current Activity to the common ancestor activity, exclusive if the common ancestor
    lazy val pathFromCurrentToAncestorExclusive = {
      val currentActivityPath = tree.currentActivity.get.pathToRoot
      val commonAncestorIndex = currentActivityPath indexOf commonAncestor
      currentActivityPath.slice(0, commonAncestorIndex)
    }
    val isAnyValidCasesForCurrentActivity = tree.currentActivity match {
      case Some(currentActivity) => {
        // Case #1 - select the current activity
        if (targetActivity == currentActivity) {
          true // do nothing
        } else if (targetActivity isSiblingTo currentActivity) {
          // case #2 - same cluster
          val siblingActivities = currentActivity.parent.get.children
          val targetActivityIndex = siblingActivities indexOf targetActivity
          val currentActivityIndex = siblingActivities indexOf currentActivity
          val traverseForward = (targetActivityIndex > currentActivityIndex)

          val activityList = if (traverseForward) siblingActivities.slice(currentActivityIndex, targetActivityIndex)
          else siblingActivities.slice(targetActivityIndex + 1, currentActivityIndex + 1)

          if (activityList.exists(!canTraverseActivityWithChoice(_, traverseForward))) {
            return SequencingResponse.invalid("Nothing to deliver.") // Nothing to deliver
          }
          true // will break other cases
        } else if (targetActivity == commonAncestor) {
          // Case #4 - path to the target is backward in the activity tree
          // Make sure an activity that should not exit will exit if the target is delivered
          if (pathFromCurrentToAncestorExclusive.exists(!_.item.sequencingPermissions.choiceForNonDescendants)) return SequencingResponse.invalid("No activities to consider")
          true // will break other cases
        } else {
          false
        }
      }
      case _ => false
    }
    // case #3 - path to the target is forward in the activity tree
    if (!isAnyValidCasesForCurrentActivity
      && (tree.currentActivity.isEmpty || (commonAncestor == tree.currentActivity.get))) {
      if (pathFromAncestorToTargetExclusive.exists(!canTraverseActivityWithChoice(_, traverseForward = true))) return SequencingResponse.invalid("Choice Exit Sequencing Control Mode violation")
      if (pathFromAncestorToTargetExclusive.tail.exists(_.item.cannotActivate)) return SequencingResponse.invalid("Choice Exit Sequencing Control Mode violation")
    } else if (!isAnyValidCasesForCurrentActivity) {
      // Case #5 - target is a descendent activity of the common ancestor. Default case
      val preorderedActivityList = tree.flatPreOrderedActivityList
      val currentActivityIndex = preorderedActivityList indexOf tree.currentActivity.get
      val targetActivityIndex = preorderedActivityList indexOf targetActivity
      // Make sure an activity that should not exit will exit if the target is delivered
      if (pathFromCurrentToAncestorExclusive.exists(!_.item.sequencingPermissions.choiceForNonDescendants)) return SequencingResponse.invalid("Choice Exit Sequencing Control Mode violation")
      // Walk up the tree to the common ancestor
      val constrainedActivity = pathFromCurrentToAncestorExclusive.find(_.item.activity.sequencing.constrainChoice)
      if (constrainedActivity.isDefined) {
        val flowDirection = targetActivityIndex > (preorderedActivityList indexOf constrainedActivity)
        val activityToConsider = choiceFlow(tree, constrainedActivity.get, flowDirection)
        // Make sure the target activity is within the set of 'flow' constrained choices
        if (!activityToConsider.hasAvailableDescendent(targetActivity) && targetActivity != activityToConsider && targetActivity != constrainedActivity.get)
          return SequencingResponse.invalid("Unable to choose target activity – constrained choice")
      }

      if (targetActivityIndex > currentActivityIndex) {
        // Walk toward the target activity
        // If the activity being considered is not already active, make sure we are allowed to activate it
        if (pathFromAncestorToTargetExclusive.exists(!canTraverseActivityWithChoice(_, traverseForward = true))) return SequencingResponse.invalid("Choice Exit Sequencing Control Mode violation")
        if (pathFromAncestorToTargetExclusive.tail.exists(_.item.cannotActivate)) return SequencingResponse.invalid("Unable to activate target; target is not a child of the Current Activity")
      } else {
        // If the activity being considered is not already active, make sure we are allowed to activate it
        if (pathFromAncestorToTargetExclusive.tail.exists(_.item.cannotActivate)) return SequencingResponse.invalid("Unable to activate target; target is not a child of the Current Activity")
        if (targetActivity.item.cannotActivate) return SequencingResponse.invalid("Unable to activate target; target is not a child of the Current Activity")
      }
    }
    if (targetActivity.isLeaf) SequencingResponse.delivery(targetActivity)
    // The identified activity is a cluster. Enter the cluster and attempt to find a descendent leaf to deliver
    else flow(tree, targetActivity, flowForward = true, considerChildren = true) match {
      case SequencingResponseDelivery(activity) => SequencingResponse.delivery(activity)
      case _ => {
        // Nothing to deliver, but we succeeded in reaching the target activity - move the current activity
        //Terminate Descendent Attempts Process [UP.3] + end attempt on common ancestor
        tree.currentActivity.get.pathTo(commonAncestor, includeAncestor = true, includeThis = false) foreach endAttemptService.apply
        tree.currentActivity = Some(targetActivity)
        SequencingResponse.invalid("Nothing to deliver")
      }
    }
  }

  /**
   * Choice Flow Subprocess [SB.2.9.1]
   * ++ Choice Flow Tree Traversal Subprocess [SB.2.9.2]
   */
  private def choiceFlow(tree: ActivityStateTree, activity: ActivityStateNode, traverseForward: Boolean) = {
    val preOrderedActivityList = tree.flatPreOrderedActivityList
    val currentActivityIndex = preOrderedActivityList indexOf activity

    if (traverseForward) {
      preOrderedActivityList.drop(currentActivityIndex + 1).find(_.isLeaf) match {
        case Some(foundActivity) => foundActivity
        case _ => activity
      }
    } else {
      preOrderedActivityList.dropRight(preOrderedActivityList.size - currentActivityIndex).reverse.find(_.isLeaf) match {
        case Some(foundActivity) => foundActivity
        case _ => activity
      }
    }
  }

  /**
   * Jump Sequencing Request Process [SB.2.13]
   */
  private def jump(tree: ActivityStateTree, targetActivity: ActivityStateNode) =
    tree.currentActivity match {
      case Some(_) => SequencingResponse.delivery(targetActivity)
      case _ => SequencingResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }

  /**
   * Choice Activity Traversal Subprocess [SB.2.4]
   * @param activity given activity
   * @param traverseForward traversal direction
   * @return True if the activity can be reached; may return an exception code
   */
  private def canTraverseActivityWithChoice(activity: ActivityStateNode, traverseForward: Boolean): Boolean = {
    def invalid(message: String) = {
      false
    }
    if (traverseForward && activity.item.preConditionRuleApplies(PreConditionAction.StopForwardTraversal)) invalid("Forward Traversal Blocked")
    else if (!traverseForward && activity.parent.get.item.sequencingPermissions.forwardOnlyForChildren) invalid("") //Can't be root here!
    else true
  }

  private def flow(tree: ActivityStateTree, activity: ActivityStateNode, flowForward: Boolean, considerChildren: Boolean): SequencingResponse = {
    val allActivitiesFlat = tree.flatPreOrderedActivityList

    /**
     * Advance to the next available activity, disregarding whether it's leaf or not and what are the rules and restrictions
     * @param activityCandidate
     * @param flowForwardCandidate
     * @param considerChildren
     * @param insideBackwardRequest
     * @return
     */
    def flowFromActivity(activityCandidate: ActivityStateNode, flowForwardCandidate: Boolean, considerChildren: Boolean, insideBackwardRequest: Boolean): (SequencingResponse, Option[Boolean]) = {
      assert(!insideBackwardRequest || flowForwardCandidate, "Inside backward request flag has sense only when temporarily flowing forward")
      var reversedDirection = false
      var flowForward = flowForwardCandidate
      var activity = activityCandidate
      if (insideBackwardRequest && activity.isLastAvailableChild) {
        flowForward = false
        activity = activityCandidate.parent.get.availableChildren(0)
        reversedDirection = true
      }
      lazy val activitySiblings = activity.parent.get.children
      lazy val nextSibling = activitySiblings.drop(activitySiblings.indexOf(activity) + 1).filter(_.isAvailableChild).headOption
      lazy val previousSibling = activitySiblings.take(activitySiblings.indexOf(activity)).filter(_.isAvailableChild).lastOption
      if (flowForward) {
        if (allActivitiesFlat.last == activity || activity.isRoot && !considerChildren) {
          //UP.5
          tree.currentActivity.get.pathTo(tree, includeAncestor = false, includeThis = false) foreach endAttemptService.apply
          (SequencingResponseEndSession, None)
        }
        else if (activity.isLeaf || !considerChildren) {
          if (activity.isLastAvailableChild) flowFromActivity(activity.parent.get, flowForwardCandidate = true, considerChildren = false, insideBackwardRequest = false)
          else (SequencingResponseDelivery(nextSibling.get), Some(flowForward))
        }
        else if (activity.availableChildren.size > 0) (SequencingResponseDelivery(activity.availableChildren(0)), Some(flowForward))
        else (SequencingResponse.invalid("No available children"), None)
      }
      else {
        if (activity.isRoot) (SequencingResponse.invalid("Can't go back from root"), None)
        else if (activity.isLeaf || !considerChildren) {
          if (!reversedDirection && activity.parent.get.item.sequencingPermissions.forwardOnlyForChildren) (SequencingResponse.invalid("Sequencing control mode violation"), None)
          else if (activity.isFirstAvailableChild) flowFromActivity(activity.parent.get, flowForwardCandidate = false, considerChildren = false, insideBackwardRequest = false)
          else (SequencingResponseDelivery(previousSibling.get), Some(flowForward))
        }
        else if (activity.availableChildren.size > 0) {
          //Enter activity's forward-only cluster in a backward request and mark that we temporarily move forward
          if (activity.item.sequencingPermissions.forwardOnlyForChildren) (SequencingResponseDelivery(activity.availableChildren(0)), Some(true))
          else (SequencingResponseDelivery(activity.availableChildren.last), Some(false))
        }
        else (SequencingResponse.invalid("No available children"), None)
      }
    }

    /**
     * Check if activity is possible to flow into
     * If activity is disabled to flow into, return an invalid result
     * If an activity should be skipped, continue searching from its closest sibling
     * If an activity is container, search within its children
     * If an activity is a leaf that can be delivered, return a delivery result.
     * @param activity                Activity we're trying to flow into
     * @param flowForward             True if we came to this activity moving forward, false if we were moving backward.
     *                                Note that the top-level sequencing request could be to go backward, but we're moving
     *                                forward because we entered a forward-only cluster
     * @param insideBackwardRequest   True if we're moving forward now, but the request is backward (we're in forward-only cluster)
     * @return
     */
    def flowIntoActivity(activity: ActivityStateNode, flowForward: Boolean, insideBackwardRequest: Boolean): SequencingResponse = {
      assert(!insideBackwardRequest || flowForward, "Inside backward request flag has sense only when temporarily flowing forward")
      if (!activity.parent.get.item.sequencingPermissions.flowForChildren) return SequencingResponse.invalid("Control mode violation")
      if (activity.item.preConditionRuleApplies(PreConditionAction.Skip)) {
        val flowTreeTraversalResult = flowFromActivity(activity, flowForward, considerChildren = false, insideBackwardRequest = insideBackwardRequest)
        flowTreeTraversalResult match {
          case (SequencingResponseDelivery(nextActivity), flowForwardResult) =>
            if (insideBackwardRequest && flowForwardResult == Some(false)) flowIntoActivity(nextActivity, flowForward, insideBackwardRequest = false)
            else flowIntoActivity(nextActivity, flowForward, insideBackwardRequest)
          case _ => flowTreeTraversalResult._1
        }
      }
      else if (!activity.item.deliveryEnabled) SequencingResponse.invalid("Delivery is disabled")
      else if (!activity.isLeaf) {
        val flowTreeTraversalResult = flowFromActivity(activity, flowForward, considerChildren = true, insideBackwardRequest = false)
        flowTreeTraversalResult match {
          case (SequencingResponseDelivery(treeTraversalActivity), flowForwardResult) =>
            if (flowForward == false && flowForwardResult == Some(true)) flowIntoActivity(treeTraversalActivity, flowForward = true, insideBackwardRequest = true)
            else flowIntoActivity(treeTraversalActivity, flowForward, insideBackwardRequest)
          case _ => flowTreeTraversalResult._1
        }
      }
      else SequencingResponseDelivery(activity)
    }

    val flowTreeTraversalResult = flowFromActivity(activity, flowForward, considerChildren, insideBackwardRequest = false)
    flowTreeTraversalResult match {
      case (SequencingResponseDelivery(treeTraversalActivity), flowForwardResult) => flowIntoActivity(treeTraversalActivity, flowForward, insideBackwardRequest = false)
      case _ => flowTreeTraversalResult._1
    }
  }
}