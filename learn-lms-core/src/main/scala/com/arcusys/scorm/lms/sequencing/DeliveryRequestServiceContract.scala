package com.arcusys.scorm.lms.sequencing

trait DeliveryRequestServiceContract {
  def apply(tree: ActivityStateTree, activityToDeliver: ActivityStateNode)
}
