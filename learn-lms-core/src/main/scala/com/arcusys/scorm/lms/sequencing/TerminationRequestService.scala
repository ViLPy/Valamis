package com.arcusys.scorm.lms.sequencing

import com.arcusys.scorm.lms.sequencing.model._
import org.scala_tools.subcut.inject.{Injectable, BindingModule}

/**
 * Termination Request Process [TB.2.3]
 * Ends the current attempt on the Current Activity
 */
class TerminationRequestService(implicit val bindingModule: BindingModule) extends TerminationRequestServiceContract with Injectable {

  private val rollupService = inject[RollupServiceContract]
  private val endAttemptService = inject[EndAttemptServiceContract]

  /**
   * Termination Request Process [TB.2.3]
   * Ends the current attempt on the Current Activity
   * @param tree        Activity state tree for attempt
   * @param requestType termination request
   * @return validity of the termination request; may return a sequencing request; may return an exception code
   */
  def apply(tree: ActivityStateTree, requestType: TerminationRequestType.Value): TerminationResponse =
    tree.currentActivity match {
      // If the sequencing session has not begun, there is nothing to terminate.
      case None => TerminationResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
      case Some(currentActivity) => {
        if ((requestType == TerminationRequestType.Exit || requestType == TerminationRequestType.Abandon) && !currentActivity.item.active)
        // If the current activity has already been terminated, there is nothing to terminate.
          TerminationResponse.invalid("Current Activity already terminated")
        else requestType match {
          case TerminationRequestType.Exit => exit(tree)
          case TerminationRequestType.ExitAll => exitAll(tree)
          case TerminationRequestType.SuspendAll => suspendAll(tree)
          case TerminationRequestType.Abandon => abandon(tree)
          case TerminationRequestType.AbandonAll => abandonAll(tree)
          case _ => TerminationResponse.invalid("Undefined termination request")
        }
      }
    }

  /**
   * Termination request is Exit
   * @return Termination request process response
   */
  private def exit(tree: ActivityStateTree): TerminationResponse = {
    def applyPostConditionRules: TerminationResponse =
      tree.applyPostConditionRules match {
        case SequencingRulesResponse(Some(TerminationRequestType.ExitAll), _) => exitAll(tree)
        case SequencingRulesResponse(Some(TerminationRequestType.ExitParent), _) => {
          //If we exit the parent of the current activity, move the current activity to the parent of the current activity
          if (!tree.currentActivity.get.isRoot) {
            tree.currentActivity = tree.currentActivity.get.parent
            endAttemptService(tree.currentActivity.get)
            applyPostConditionRules // on the new current activity
          }
          else TerminationResponse.invalid("Activity tree root has no parent")
        }
        case SequencingRulesResponse(_, sequencingRequestOption) =>
          // If the attempt on the root of the Activity Tree is ending without a Retry, the Sequencing Session also ends
          if (tree.currentActivity.get.isRoot && sequencingRequestOption != Some(SequencingRequestType.Retry)) TerminationResponse(SequencingRequestType.Exit)
          else TerminationResponseValid(sequencingRequestOption)
      }

    // Ensure the state of the current activity is up to date
    endAttemptService(tree.currentActivity.get)
    // Check if any of the current activity's ancestors need to terminate
    // Part of [TB.2.1]. May change the Current Activity
    tree.applyExitConditionRules match {
      case Some(exitActivity) => {
        //End the current attempt on all active descendents  (Terminate Descendent Attempts Process [UP.3]) +  End the current attempt on the 'exiting' activity
        tree.currentActivity.get.pathTo(exitActivity, includeAncestor = true, includeThis = false) foreach endAttemptService.apply
        // Move the current activity to the activity that has been identified for termination
        tree.currentActivity = Some(exitActivity)
      }
      case _ => {}
    }
    applyPostConditionRules
  }

  /**
   * Termination request is ExitAll
   * @return Termination request process response
   */
  private def exitAll(tree: ActivityStateTree): TerminationResponse = {
    if (tree.currentActivity.get.item.active) endAttemptService(tree.currentActivity.get)
    endAttemptService(tree)
    tree.currentActivity = Some(tree)
    TerminationResponse(SequencingRequestType.Exit)
  }

  /**
   * Termination request is SuspendAll
   * @return Termination request process response
   */
  private def suspendAll(tree: ActivityStateTree): TerminationResponse = {
    val currentActivity = tree.currentActivity.get
    // If the current activity is active or already suspended, suspend it and all of its descendants
    if (currentActivity.item.active || currentActivity.item.suspended) {
      // Ensure that any status change to this activity is propagated through the entire activity tree
      rollupService(currentActivity)
      tree.suspendedActivity = Some(currentActivity)
    } else {
      if (!currentActivity.isRoot) tree.suspendedActivity = Some(currentActivity.parent.get)
      else return TerminationResponse.invalid("Cannot suspend an inactive root")
    }
    // Form the activity path as the ordered series of all activities from the Suspended Activity to the root of the activity tree, inclusive
    val path = tree.suspendedActivity.get.pathToRoot
    path.foreach(node => {
      node.item.active = false
      node.item.suspended = true
    })
    tree.currentActivity = Some(tree)
    TerminationResponse(SequencingRequestType.Exit)
  }

  /**
   * Termination request is Abandon
   * @return Termination request process response
   */
  private def abandon(tree: ActivityStateTree): TerminationResponse = {
    tree.currentActivity.get.item.active = false
    TerminationResponseValid()
  }

  /**
   * Termination request is AbandonAll
   * @return Termination request process response
   */
  private def abandonAll(tree: ActivityStateTree): TerminationResponse = {
    // Form the activity path as the ordered series of all activities from the Suspended Activity to the root of the activity tree, inclusive
    val path = tree.currentActivity.get.pathToRoot
    path.foreach(activity=>{
      activity.item.active = false
    })
    tree.currentActivity = Some(tree)
    TerminationResponse(SequencingRequestType.Exit)
  }
}