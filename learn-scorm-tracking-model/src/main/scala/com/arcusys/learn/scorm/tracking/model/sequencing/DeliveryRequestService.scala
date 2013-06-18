package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.manifest.model._
import org.scala_tools.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode}

/**
 * Content Delivery Environment Process [DB.2]
 */
class DeliveryRequestService(implicit val bindingModule: BindingModule) extends DeliveryRequestServiceContract with Injectable {
  private val endAttemptService = inject[EndAttemptServiceContract]

  /**
   * Content Delivery Environment Process [DB.2]
   * @param activityToDeliver activity to deliver
   */
  def apply(tree: ActivityStateTree, activityToDeliver: ActivityStateNode) {

    /**
     * Clear Suspended Activity Subprocess [DB.2.1]
     * may change the Suspended Activity
     */
    def clearSuspendedActivity() {
      if (tree.suspendedActivity.isDefined) {
        val activityPathFromSuspended = tree.suspendedActivity.get.pathToCommonAncestorWith(activityToDeliver, includeCommonAncestor = true)

        activityPathFromSuspended.foreach(activity => {
          activity.item.activity match {
            case l: LeafActivity => activity.item.suspended = false
            case _ => if (!activity.availableChildren.exists(_.item.suspended)) activity.item.suspended = false
          }
        })
        tree.suspendedActivity = None
      }
    }

    // If the attempt on the current activity has not been terminated, we cannot deliver new content
    if (tree.currentActivity.isDefined && tree.currentActivity.get.item.active) {
      return
    }
    // Content is about to be delivered, clear any existing suspend all state
    if (tree.suspendedActivity.isDefined && tree.suspendedActivity != activityToDeliver) clearSuspendedActivity()

    // Make sure that all attempts that should end are terminated
    //Terminate Descendent Attempts Process [UP.3]
    if (tree.currentActivity.isDefined) {
      val path = tree.currentActivity.get pathToCommonAncestorWith activityToDeliver
      if (path.nonEmpty) path.tail.foreach(endAttemptService.apply(_))
    }
    val activityPath = activityToDeliver.pathToRoot.reverse
    activityPath.foreach(activity => {
      if (!activity.item.active) {
        if (activity.item.activity.isTracked) {
          // If the previous attempt on the activity ended due to a suspension, clear the suspended state; do not start a new attempt
          if (activity.item.suspended) {
            activity.item.suspended = false
          } else {
            // Begin a new attempt on the activity
            activity.item.attemptCount += 1
            // TODO: Initialize Objective Progress Information and Attempt Progress Information required for the new attempt

          }
        }
        activity.item.active = true
      }
    })
    tree.currentActivity = Some(activityToDeliver)
    tree.suspendedActivity = None
    if (!activityToDeliver.item.activity.isTracked) {
      // TODO: The Objective and Attempt Progress information for the activity should not be recorded during delivery
      // TODO: The delivery environment begins tracking the Attempt Absolute Duration and the Attempt Experienced Duration
    }
  }
}