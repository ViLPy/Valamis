package com.arcusys.learn.scorm.manifest.storage.impl

import com.arcusys.learn.storage.impl.{ EntityStorageExt, EntityStorage }
import com.arcusys.learn.scorm.manifest.storage.{ ActivityDataStorage, ActivityStorage }
import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.util.TreeNode
import collection.mutable
import com.arcusys.learn.scorm.manifest.sequencing.storage.SequencingStorage
import scala.Some

/**
 * User: Yulia.Glushonkova
 * Date: 10.04.13
 */
@deprecated
trait ActivityCreator {
  val sequencingStorage: SequencingStorage
  val activityDataRepository: ActivityDataStorage

  def createActivity(identifierRef: String, id: String, title: String, packageID: Int, organizationId: String, parentId: Option[String],
    hideLMSUI: String, visible: Boolean, resourceParameters: Option[String], masteryScore: Option[String], maxTimeAllowed: Option[String]): Activity = {
    val sequencing = sequencingStorage.get(packageID, id).getOrElse(Sequencing.Default)
    if (parentId.isEmpty)
      new Organization(id, title, objectivesGlobalToSystem = false, sharedDataGlobalToSystem = false, sequencing = sequencing)
    else if (identifierRef.isEmpty)
      new ContainerActivity(
        id,
        title,
        parentId.getOrElse(organizationId),
        organizationId,
        sequencing,
        CompletionThreshold.Default,
        hideLMSUI.split('|').toSet.filter(!_.isEmpty).map(NavigationControlType.withName(_)),
        visible
      )

    else // leaf activity
      new LeafActivity(
        id,
        title,
        parentId.getOrElse(organizationId),
        organizationId,
        identifierRef,
        resourceParameters,
        None, //timeLimitAction
        Some("dataFromLMS"),
        activityDataRepository.getForActivity(packageID, id),
        sequencing,
        CompletionThreshold.Default,
        hideLMSUI.split('|').toSet.filter(!_.isEmpty).map(NavigationControlType.withName(_)),
        visible,
        None,
        masteryScore,
        maxTimeAllowed
      )
  }
}

@deprecated
trait ActivityEntityStorage extends ActivityStorage with EntityStorageExt[Activity] {
  val sequencingStorage: SequencingStorage
  val dataStorage: ActivityDataStorage

  override def renew() {
    doRenew()
    sequencingStorage.renew()
    dataStorage.renew()
  }

  def getAllOrganizations(packageID: Int): Seq[Organization] = getAll("packageID" -> packageID, "parentID" -> null).map(_.asInstanceOf[Organization])
  //getAll("_organization", "packageID" -> packageID).map(_.asInstanceOf[Organization])

  def getOrganizationTree(packageID: Int, organizationID: String): TreeNode[Activity] =
    TreeNode.parseNodes(getAll("packageID" -> packageID, "organizationID" -> organizationID), (a: Activity) => a.id, (a: Activity) => a.parentID, None).head

  def getAllFlat(packageID: Int) = getAll("packageID" -> packageID)

  def getParent(packageID: Int, activityID: String): Option[Activity] = {
    val targetActivity = get(packageID, activityID)
    targetActivity match {
      case Some(activity) => activity.parentID match {
        case Some(parentID) => get(packageID, parentID)
        case _              => None
      }
      case _ => None
    }
  }

  def getChildren(packageID: Int, activityID: Option[String]): Seq[Activity] = {
    getAllFlat(packageID).filter(_.parentID == activityID)
  }

  def getActivityPath(packageID: Int, activityID: String): Seq[Activity] = {
    //Find the activity that is the common ancestor of the Current Activity and the identified activity
    val activities = getAllFlat(packageID)
    val targetActivity = get(packageID, activityID).getOrElse(throw new Exception("Activity not found in package"))
    val mappedActivities = Map(activities.map(activity => (activity.id, activity)): _*)
    val activityPath = mutable.Buffer[Activity](targetActivity)

    while (activityPath.head.parentID != None) {
      activityPath.prepend(mappedActivities.getOrElse(activityPath.last.parentID.get, throw new Exception("Problem in Activity DB.")))
    }
    activityPath
  }

  def get(packageID: Int, id: String): Option[Activity] = getOne("packageID" -> packageID, "id" -> id)

  def create(packageID: Int, entity: Activity) {
    create(entity,
      "packageID" -> packageID,
      "parentID" -> entity.parentID,
      "identifierRef" -> (entity match {
        case l: LeafActivity => l.resourceIdentifier
        case _               => ""
      }),
      "resourceParameters" -> (entity match {
        case l: LeafActivity => l.resourceParameters
        case _               => ""
      }),
      "objectivesGlobalToSystem" -> (entity match {
        case o: Organization => o.objectivesGlobalToSystem
        case _               => false
      }),
      "sharedDataGlobalToSystem" -> (entity match {
        case o: Organization => o.sharedDataGlobalToSystem
        case _               => false
      }),
      "maxTimeAllowed" -> (entity match {
        case l: LeafActivity => l.maxTimeAllowed
        case _               => None
      }),
      "masteryScore" -> (entity match {
        case l: LeafActivity => l.masteryScore
        case _               => None
      }),
      //TODO: is map really needed?
      "hideLMSUI" -> entity.hiddenNavigationControls.map(_.toString).mkString("|")
    )
    if (entity.isInstanceOf[LeafActivity]) entity.asInstanceOf[LeafActivity].data.foreach(data => dataStorage.create(packageID, entity.id, data))
    sequencingStorage.create(packageID, entity.id, entity.sequencing)
  }
}
