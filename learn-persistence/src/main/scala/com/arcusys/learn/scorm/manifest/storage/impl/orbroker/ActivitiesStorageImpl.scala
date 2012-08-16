package com.arcusys.learn.scorm.manifest.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.storage.impl.orbroker._
import org.orbroker.Row

import collection.mutable
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker._
import com.arcusys.learn.util.TreeNode

class ActivitiesStorageImpl extends GenericEntityStorageImpl[Activity]("Activity") with ActivitiesStorage {
  private val sequencingStorage = new SequencingStorageImpl
  private val dataStorage = new ActivityDataStorageImpl

  override def renew() {
    super.renew()
    sequencingStorage.renew()
    dataStorage.renew()
  }

  def getAllOrganizations(packageID: Int): Seq[Organization] = getAll("_organization", "packageID" -> packageID).map(_.asInstanceOf[Organization])

  def getOrganizationTree(packageID: Int, organizationID: String): TreeNode[Activity] =
    TreeNode.parseNodes(getAll("packageID" -> packageID, "organizationID" -> organizationID), (a:Activity)=>a.id, (a:Activity)=>a.parentID, None).head

  def getAllFlat(packageID: Int) = getAll("packageID" -> packageID)

  def getParent(packageID: Int, activityID: String): Option[Activity] = {
    val targetActivity = get(packageID, activityID)
    targetActivity match {
      case Some(activity) => activity.parentID match {
        case Some(parentID) => get(packageID, parentID)
        case _ => None
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
        case _ => ""
      }),
      "resourceParameters" -> (entity match {
        case l: LeafActivity => l.resourceParameters
        case _ => ""
      }),
      "objectivesGlobalToSystem" -> (entity match {
        case o: Organization => o.objectivesGlobalToSystem
        case _ => false
      }),
      "sharedDataGlobalToSystem" -> (entity match {
        case o: Organization => o.sharedDataGlobalToSystem
        case _ => false
      }),
      //TODO: is map really needed?
      "hideLMSUI" -> entity.hiddenNavigationControls.map(_.toString).mkString("|")
    )
    if (entity.isInstanceOf[LeafActivity]) entity.asInstanceOf[LeafActivity].data.foreach(data => dataStorage.create(packageID, entity.id, data))
    sequencingStorage.create(packageID, entity.id, entity.sequencing)
  }

  def extract(row: Row) = {
    val identifierRef = row.string("identifierRef").getOrElse("")
    val id = row.string("id").get
    val title = row.string("title").get
    val packageID = row.integer("packageID").get
    val organizationId = row.string("organizationID").get
    val parentId = row.string("parentID")
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
        row.string("hideLMSUI").get.split('|').toSet.filter(!_.isEmpty).map(NavigationControlType.withName(_)),
        row.bit("visible").get
      )

    else // leaf activity
      new LeafActivity(
        id,
        title,
        parentId.getOrElse(organizationId),
        organizationId,
        row.string("identifierRef").get,
        row.string("resourceParameters"),
        None, //timeLimitAction
        Some("dataFromLMS"),
        dataStorage.getForActivity(packageID, id),
        sequencing,
        CompletionThreshold.Default,
        row.string("hideLMSUI").get.split('|').toSet.filter(!_.isEmpty).map(NavigationControlType.withName(_)),
        row.bit("visible").get
      )
  }

}
