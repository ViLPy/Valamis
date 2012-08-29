package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.util.Extensions._
import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode}

/**
 * Navigation Request Process [NB.2.1] - implementation
 * Checks if a navigation request is valid and whether termination is required to process it.
 * Does not change attempt state / tracking information
 */
class NavigationRequestService extends NavigationRequestServiceContract {
  /**
   * Navigation Request Process [NB.2.1]
   * @param tree              Activity state tree for attempt
   * @param requestType       Type of the navigation request
   * @param targetActivityId  ID of the target activity; has sense only for Choice and Jump requests
   * @return Validity of the navigation request + whether termination is needed
   */
  def apply(tree: ActivityStateTree, requestType: NavigationRequestType.Value, targetActivityId: String): NavigationResponse = {
    import NavigationRequestType._
    lazy val target = tree(targetActivityId)
    if (requestType.oneOf(Choice, Jump) && target.isEmpty) NavigationResponse.invalid("Target activity does not exist")
    else requestType match {
      case Start => start(tree)
      case ResumeAll => resumeAll(tree)
      case Continue => continue(tree)
      case Previous => previous(tree)
      case Choice => choice(tree, target.get)
      case Jump => jump(tree, target.get)
      case Exit => exit(tree)
      case ExitAll => exitAll(tree)
      case SuspendAll => suspendAll(tree)
      case Abandon => abandon(tree)
      case AbandonAll => abandonAll(tree)
    }
  }

  private def start(tree: ActivityStateTree) =
    tree.currentActivity match {
      case None => NavigationResponse.valid(termination = false)
      case Some(_) => NavigationResponse.invalid("Current Activity is already defined / Sequencing session has already begun")
    }

  private def resumeAll(tree: ActivityStateTree) =
    (tree.currentActivity, tree.suspendedActivity) match {
      case (None, Some(_)) => NavigationResponse.valid(termination = false)
      case (None, None) => NavigationResponse.invalid("Suspended Activity is not defined")
      case _ => NavigationResponse.invalid("Current Activity is already defined / Sequencing session has already begun")
    }

  private def continue(tree: ActivityStateTree) =
    tree.currentActivity match {
      case None => NavigationResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
      case Some(currentActivity) => {
        if (!currentActivity.isRoot && currentActivity.parent.get.item.sequencingPermissions.flowForChildren)
          NavigationResponse.valid(termination = currentActivity.item.active)
        else NavigationResponse.invalid("Flow Sequencing Control Mode violation")
      }
    }

  private def previous(tree: ActivityStateTree) =
    tree.currentActivity match {
      case None => NavigationResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
      case Some(currentActivity) => {
        currentActivity.parent match {
          case Some(parentActivity) => {
            if (parentActivity.item.sequencingPermissions.flowForChildren && !parentActivity.item.sequencingPermissions.forwardOnlyForChildren)
              NavigationResponse.valid(termination = currentActivity.item.active)
            else NavigationResponse.invalid("Flow or Forward Only Sequencing Control Mode violation")
          }
          case None => NavigationResponse.invalid("No activity is 'previous' to the root")
        }
      }
    }

  private def choice(tree: ActivityStateTree, targetActivity: ActivityStateNode) = {
    def cannotExit(activity: ActivityStateNode) = activity.item.active && !activity.item.sequencingPermissions.choiceForNonDescendants
    if (targetActivity.isRoot || targetActivity.parent.get.item.sequencingPermissions.choiceForChildren) {
      tree.currentActivity match {
        // Attempt to start the sequencing session through choice.
        case None => NavigationResponse.valid(termination = false)
        case Some(currentActivity) => {
          val exitPath = currentActivity pathToCommonAncestorWith targetActivity
          if (exitPath exists cannotExit) NavigationResponse.invalid("Choice Exit Sequencing Control Mode violation")
          //Current activity is descendant of target - check target as well
          else if (!exitPath.isEmpty && exitPath.last.parent == Some(targetActivity) && cannotExit(targetActivity)) NavigationResponse.invalid("Choice Exit Sequencing Control Mode violation")
          else NavigationResponse.valid(termination = currentActivity.item.active)
        }
      }
    }
    else NavigationResponse.invalid("Choice Sequencing Control Mode violation")
  }

  private def jump(tree: ActivityStateTree, targetActivity: ActivityStateNode) =
    if (targetActivity.isAvailableChild) NavigationResponse.valid(termination = true)
    else NavigationResponse.invalid("Target activity is not available")

  private def exit(tree: ActivityStateTree) =
    tree.currentActivity match {
      case Some(currentActivity) =>
        if (currentActivity.item.active) NavigationResponse.valid(termination = true)
        else NavigationResponse.invalid("Current Activity already terminated")
      case None => NavigationResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }

  private def exitAll(tree: ActivityStateTree) =
    tree.currentActivity match {
      case Some(_) => NavigationResponse.valid(termination = true)
      case None => NavigationResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }

  private def suspendAll(tree: ActivityStateTree) =
    tree.currentActivity match {
      case Some(_) => NavigationResponse.valid(termination = true)
      case None => NavigationResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }

  private def abandon(tree: ActivityStateTree) =
    tree.currentActivity match {
      case Some(currentActivity) =>
        if (currentActivity.item.active) NavigationResponse.valid(termination = true)
        else NavigationResponse.invalid("Current Activity already terminated")
      case None => NavigationResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }

  private def abandonAll(tree: ActivityStateTree) =
    tree.currentActivity match {
      case Some(_) => NavigationResponse.valid(termination = true)
      case None => NavigationResponse.invalid("Current Activity is not defined / Sequencing session has not begun")
    }
}