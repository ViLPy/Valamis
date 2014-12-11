package com.arcusys.learn.bl.services.lesson

import com.arcusys.learn.bl.ioc.DomainConfiguration
import com.arcusys.learn.scorm.manifest.model.{ Organization, Activity, Resource }
import com.arcusys.learn.scorm.manifest.storage.{ ActivityStorage, ResourcesStorage }
import com.arcusys.learn.scorm.tracking.model.{ ActivityStateTree, Attempt }
import com.arcusys.learn.scorm.tracking.states.storage.ActivityStateTreeStorage
import com.arcusys.learn.scorm.tracking.storage.AttemptStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

// TODO refactor
class ActivityService(configuration: BindingModule) extends Injectable with ActivityServiceContract {

  implicit val bindingModule = configuration
  private val activityRepository = inject[ActivityStorage]
  private val resourceRepository = inject[ResourcesStorage]
  private val attemptStorage = inject[AttemptStorage]
  private val activityStateTreeStorage = inject[ActivityStateTreeStorage]

  def this() = this(DomainConfiguration)

  override def getActivity(packageId: Int, activityId: String): Activity = {
    activityRepository.get(packageId, activityId).getOrElse(throw new Exception("activity ot found, packageId: " + packageId + " activityId:" + activityId))
  }

  override def getActivityOption(packageId: Int, activityId: String): Option[Activity] = {
    activityRepository.get(packageId, activityId)
  }

  override def getAllOrganizations(packageId: Int): Seq[Organization] = {
    activityRepository.getAllOrganizations(packageId)
  }

  override def getResource(packageId: Int, resourceIdentifier: String): Resource = {
    resourceRepository.getByID(packageId, resourceIdentifier).get
  }

  override def getActiveAttempt(userId: Int, packageId: Int, organizationId: String): Attempt = {
    attemptStorage.getActive(userId, packageId) match {
      case Some(attempt) => attempt
      case None => {
        attemptStorage.createAndGetID(userId, packageId, organizationId)
        attemptStorage.getActive(userId, packageId).get
      }
    }
  }

  override def getLastAttempltOption(userId: Int, packageId: Int): Option[Attempt] = {
    attemptStorage.getLast(userId, packageId)
  }

  override def markAsComplete(attemptId: Int): Unit = {
    attemptStorage.markAsComplete(attemptId)
  }

  override def getActivityStateTreeForAttemptOption(attempt: Attempt): Option[ActivityStateTree] = {
    activityStateTreeStorage.get(attempt.id)
  }

  override def createActivityStateTreeForAttempt(attempt: Attempt): ActivityStateTree = {
    val stateTree = ActivityStateTree(activityRepository.getOrganizationTree(attempt.packageID, attempt.organizationID), None, true, None)
    activityStateTreeStorage.create(attempt.id, stateTree)
    activityStateTreeStorage.get(attempt.id).get
  }

  override def getActivityStateTreeForAttemptOrCreate(attempt: Attempt): ActivityStateTree = {
    getActivityStateTreeForAttemptOption(attempt) match {
      case Some(tree: ActivityStateTree) => tree
      case None                          => createActivityStateTreeForAttempt(attempt)
    }
  }

  override def updateActivityStateTree(attemptId: Int, activityStateTree: ActivityStateTree): Unit = {
    activityStateTreeStorage.modify(attemptId, activityStateTree)
  }
}
