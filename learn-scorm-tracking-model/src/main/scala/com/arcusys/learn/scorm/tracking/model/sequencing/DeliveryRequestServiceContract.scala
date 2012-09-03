package com.arcusys.learn.scorm.tracking.model.sequencing

import com.arcusys.learn.scorm.tracking.model.{ActivityStateTree, ActivityStateNode}

trait DeliveryRequestServiceContract {
  def apply(tree: ActivityStateTree, activityToDeliver: ActivityStateNode)
}
