package com.arcusys.valamis.lesson.scorm.service.sequencing

import com.arcusys.valamis.lesson.scorm.model.tracking.{ ActivityStateNode, ActivityStateTree }

trait DeliveryRequestServiceContract {
  def apply(tree: ActivityStateTree, activityToDeliver: ActivityStateNode)
}
