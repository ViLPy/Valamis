package com.arcusys.valamis.lesson.service

import com.arcusys.valamis.lesson.scorm.model.manifest.{ Activity, Organization, Resource }
import com.arcusys.valamis.lesson.scorm.model.tracking.{ ActivityStateTree, Attempt }

/**
 * Created by igorborisov on 17.10.14.
 */
trait ActivityServiceContract {

  def getActivity(packageId: Int, activityId: String): Activity

  def getActivityOption(packageId: Int, activityId: String): Option[Activity]

  def getAllOrganizations(packageId: Int): Seq[Organization]

  def getResource(packageId: Int, resourceIdentifier: String): Resource

  def getActiveAttempt(userId: Int, packageId: Int, organizationId: String): Attempt

  def getLastAttempltOption(userId: Int, packageId: Int): Option[Attempt]

  def markAsComplete(attemptId: Int): Unit

  def getActivityStateTreeForAttemptOption(attempt: Attempt): Option[ActivityStateTree]

  def createActivityStateTreeForAttempt(attempt: Attempt): ActivityStateTree

  def getActivityStateTreeForAttemptOrCreate(attempt: Attempt): ActivityStateTree

  def updateActivityStateTree(attemptId: Int, activityStateTree: ActivityStateTree): Unit
}
