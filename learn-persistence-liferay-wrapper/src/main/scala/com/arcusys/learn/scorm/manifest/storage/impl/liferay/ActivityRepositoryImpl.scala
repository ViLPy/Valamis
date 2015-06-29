package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFActivity
import com.arcusys.learn.persistence.liferay.service.LFActivityLocalServiceUtil
import com.arcusys.valamis.lesson.scorm.model.manifest._
import com.arcusys.valamis.lesson.scorm.storage.sequencing.SequencingStorage
import com.arcusys.valamis.lesson.scorm.storage.{ ActivityStorage, ActivityDataStorage }
import com.arcusys.valamis.util.TreeNode
import scala.collection.JavaConverters._
import scala.collection.mutable

/**
 * Created by mminin on 16.10.14.
 */
trait ActivityRepositoryImpl extends ActivityStorage {
  val sequencingStorage: SequencingStorage
  val activityDataRepository: ActivityDataStorage

  override def renew(): Unit = {
    LFActivityLocalServiceUtil.removeAll()
    sequencingStorage.renew()
    activityDataRepository.renew()
  }

  override def getAllFlat(packageID: Long): Seq[Activity] = {
    LFActivityLocalServiceUtil.findByPackageID(packageID.toInt).asScala
      .sortBy(i => (i.getIndexNumber, i.getId)).map(extract)
  }

  override def get(packageId: Long, id: String): Option[Activity] = {
    Option(LFActivityLocalServiceUtil.findByPackageAndID(packageId.toInt, id)) map extract
  }

  /**
   * Forms the activity path as the ordered series of activities from the Current Activity to the common ancestor
   * @param packageId given package ID
   * @param activityID given activity ID
   * @return activity path
   */
  override def getActivityPath(packageId: Long, activityID: String): Seq[Activity] = {
    //Find the activity that is the common ancestor of the Current Activity and the identified activity
    val activities = getAllFlat(packageId)
    val targetActivity = get(packageId, activityID).getOrElse(throw new Exception("Activity not found in package"))
    val mappedActivities = Map(activities.map(activity => (activity.id, activity)): _*)
    val activityPath = mutable.Buffer[Activity](targetActivity)

    while (activityPath.head.parentID != None) {
      activityPath.prepend(mappedActivities.getOrElse(activityPath.last.parentID.get, throw new Exception("Problem in Activity DB.")))
    }
    activityPath
  }

  override def getParent(packageId: Long, activityID: String): Option[Activity] = {
    val targetActivity = get(packageId, activityID)
    targetActivity match {
      case Some(activity) => activity.parentID match {
        case Some(parentID) => get(packageId, parentID)
        case _              => None
      }
      case _ => None
    }
  }

  override def getAllOrganizations(packageId: Long): Seq[Organization] = {
    LFActivityLocalServiceUtil.findByPackageIDAndParentID(packageId.toInt, null.asInstanceOf[String]).asScala
      .sortBy(i => (i.getIndexNumber, i.getId))
      .map(extract).map(_.asInstanceOf[Organization])
  }

  override def getChildren(packageId: Long, activityID: Option[String]): Seq[Activity] = {
    getAllFlat(packageId).filter(_.parentID == activityID)
  }

  override def getOrganizationTree(packageId: Long, organizationID: String): TreeNode[Activity] = {
    TreeNode.parseNodes(
      LFActivityLocalServiceUtil.findByPackageIDAndOrganizationID(packageId.toInt, organizationID).asScala
        .sortBy(i => (i.getIndexNumber, i.getId)).map(extract),
      (a: Activity) => a.id,
      (a: Activity) => a.parentID,
      None
    ).head
  }

  override def getAll: Seq[Activity] = {
    LFActivityLocalServiceUtil.getLFActivities(-1, -1).asScala
      .sortBy(i => (i.getIndexNumber, i.getId)).map(extract)
  }

  override def create(packageId: Long, entity: Activity): Unit = {
    val newEntity = LFActivityLocalServiceUtil.createLFActivity()

    newEntity.setId(entity.id)
    newEntity.setPackageID(packageId.toInt)
    newEntity.setOrganizationID(entity.organizationID)

    newEntity.setParentID(entity.parentID.orNull)

    newEntity.setTitle(entity.title)
    newEntity.setVisible(entity.visible)

    newEntity.setHideLMSUI(entity.hiddenNavigationControls.map(_.toString).mkString("|"))

    entity match {
      case l: LeafActivity =>
        newEntity.setIdentifierRef(l.resourceIdentifier)
        newEntity.setResourceParameters(l.resourceParameters.orNull)
        newEntity.setMasteryScore(l.masteryScore.orNull)
        newEntity.setMaxTimeAllowed(l.maxTimeAllowed.orNull)
      case o: Organization =>
        newEntity.setObjectivesGlobalToSystem(o.objectivesGlobalToSystem)
        newEntity.setSharedDataGlobalToSystem(o.sharedDataGlobalToSystem)
      case _ => {}
    }

    LFActivityLocalServiceUtil.addLFActivity(newEntity)

    if (entity.isInstanceOf[LeafActivity])
      entity.asInstanceOf[LeafActivity].data.foreach(data => activityDataRepository.create(packageId.toInt, entity.id, data))

    sequencingStorage.create(packageId.toInt, entity.id, entity.sequencing)
  }

  private def extract(lfActivity: LFActivity) = {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val sequencing = sequencingStorage.get(lfActivity.getPackageID, lfActivity.getId).getOrElse(Sequencing.Default)

    if (lfActivity.getParentID.toOption.isEmpty)
      new Organization(lfActivity.getId, lfActivity.getTitle, objectivesGlobalToSystem = false, sharedDataGlobalToSystem = false, sequencing = sequencing)
    else if (lfActivity.getIdentifierRef.isEmpty)
      new ContainerActivity(
        lfActivity.getId,
        lfActivity.getTitle,
        lfActivity.getParentID,
        lfActivity.getOrganizationID,
        sequencing,
        CompletionThreshold.Default,
        lfActivity.getHideLMSUI.split('|').toSet.filter(!_.isEmpty).map(NavigationControlType.withName(_)),
        lfActivity.getVisible
      )
    else // leaf activity
      new LeafActivity(
        lfActivity.getId,
        lfActivity.getTitle,
        lfActivity.getParentID,
        lfActivity.getOrganizationID,
        lfActivity.getIdentifierRef,
        Option(lfActivity.getResourceParameters),
        None, //timeLimitAction
        Some("dataFromLMS"),
        activityDataRepository.getForActivity(lfActivity.getPackageID, lfActivity.getId),
        sequencing,
        CompletionThreshold.Default,
        lfActivity.getHideLMSUI.split('|').toSet.filter(!_.isEmpty).map(NavigationControlType.withName(_)),
        lfActivity.getVisible,
        None,
        Option(lfActivity.getMasteryScore),
        Option(lfActivity.getMaxTimeAllowed)
      )
  }
}
