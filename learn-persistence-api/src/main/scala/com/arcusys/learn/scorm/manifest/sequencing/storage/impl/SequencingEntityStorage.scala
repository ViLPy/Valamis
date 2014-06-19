package com.arcusys.learn.scorm.manifest.sequencing.storage.impl

import com.arcusys.learn.scorm.manifest.sequencing.storage._
import com.arcusys.learn.storage.impl.{ EntityStorageExt, KeyedEntityStorageExt }
import com.arcusys.learn.scorm.manifest.model.{ PostConditionRule, PreConditionRule, ExitConditionRule, Sequencing }

/**
 * User: Yulia.Glushonkova
 * Date: 09.04.13
 */

trait SequencingEntityStorage extends SequencingStorage with KeyedEntityStorageExt[Sequencing] with EntityStorageExt[Sequencing] {
  val sequencingPermissionsStorage: SequencingPermissionsStorage
  val rollupContributionStorage: RollupContributionStorage
  val objectiveStorageStorage: ObjectiveStorage
  val childrenSelectionStorage: ChildrenSelectionStorage
  val sequencingTrackingStorage: SequencingTrackingStorage
  val rollupRuleStorage: RollupRuleStorage
  val exitConditionRuleStorageImpl: ConditionRuleStorage[ExitConditionRule]
  val preConditionRuleStorageImpl: ConditionRuleStorage[PreConditionRule]
  val postConditionRuleStorageImpl: ConditionRuleStorage[PostConditionRule]

  def objectiveMapStorage: ObjectiveMapStorage
  def ruleConditionStorage: RuleConditionStorage

  override def renew() {
    super.renew()
    sequencingPermissionsStorage.renew()
    rollupContributionStorage.renew()
    objectiveStorageStorage.renew()
    objectiveMapStorage.renew()
    childrenSelectionStorage.renew()
    sequencingTrackingStorage.renew()
    exitConditionRuleStorageImpl.renew()
    preConditionRuleStorageImpl.renew()
    postConditionRuleStorageImpl.renew()
    rollupRuleStorage.renew()
    ruleConditionStorage.renew()
  }

  def create(packageID: Int, activityID: String, sequencing: Sequencing) {
    val id = createAndGetID(sequencing, "packageID" -> packageID, "activityID" -> activityID)

    sequencingPermissionsStorage.create(id, sequencing.permissions)
    rollupContributionStorage.create(id, sequencing.rollupContribution)
    if (sequencing.primaryObjective.isDefined) objectiveStorageStorage.create(id, sequencing.primaryObjective.get, isPrimary = true)
    sequencing.nonPrimaryObjectives.foreach(objectiveStorageStorage.create(id, _, isPrimary = false))
    childrenSelectionStorage.create(id, sequencing.childrenSelection)
    if (sequencing.tracking.isDefined) sequencingTrackingStorage.create(id, sequencing.tracking.get)

    sequencing.rollupRules.foreach(rollupRuleStorage.create(id, _))
    // exit/pre/post rules
    sequencing.exitConditionRules.foreach(exitConditionRuleStorageImpl.create(id, _))
    sequencing.preConditionRules.foreach(preConditionRuleStorageImpl.create(id, _))
    sequencing.postConditionRules.foreach(postConditionRuleStorageImpl.create(id, _))
  }

  def get(packageID: Int, activityID: String): Option[Sequencing] = {
    getOne("packageID" -> packageID, "activityID" -> activityID)
  }

  def delete(packageID: Int, activityID: String) { delete("packageID" -> packageID, "activityID" -> activityID) }

  /*
  override def renew() {
    super.renew()
    sequencingPermissionsStorage.renew()
    rollupContributionStorage.renew()
    objectiveStorageStorage.renew()
    (new ObjectiveMapStorageImpl).renew()
    childrenSelectionStorage.renew()
    sequencingTrackingStorage.renew()
    exitConditionRuleStorageImpl.renew()
    preConditionRuleStorageImpl.renew()
    postConditionRuleStorageImpl.renew()
    rollupRuleStorage.renew()
    (new RuleConditionStorageImpl).renew()
  }
*/
}

trait SequencingFieldsMapper {
  def sharedId: Option[String]
  def sharedSequencingIdReference: Option[String]
  def id: Int
  def onlyCurrentAttemptObjectiveProgressForChildren: Boolean
  def onlyCurrentAttemptAttemptProgressForChildren: Boolean
  def attemptLimit: Option[Int]
  def durationLimitInMilliseconds: Option[Long]
  def preventChildrenActivation: Boolean
  def constrainChoice: Boolean
}

trait SequencingCreator {
  val sequencingPermissionsStorage: SequencingPermissionsStorage
  val rollupContributionStorage: RollupContributionStorage
  val objectiveStorageStorage: ObjectiveStorage
  val childrenSelectionStorage: ChildrenSelectionStorage
  val sequencingTrackingStorage: SequencingTrackingStorage
  val rollupRuleStorage: RollupRuleStorage
  val exitConditionRuleStorageImpl: ConditionRuleStorage[ExitConditionRule]
  val preConditionRuleStorageImpl: ConditionRuleStorage[PreConditionRule]
  val postConditionRuleStorageImpl: ConditionRuleStorage[PostConditionRule]
  def createSequencing(mapper: SequencingFieldsMapper) = {
    import mapper._
    new Sequencing(
      sharedId,
      sharedSequencingIdReference,
      sequencingPermissionsStorage.get(id).get,
      onlyCurrentAttemptObjectiveProgressForChildren,
      onlyCurrentAttemptAttemptProgressForChildren,
      attemptLimit,
      durationLimitInMilliseconds,
      rollupContributionStorage.get(id).get,
      objectiveStorageStorage.getPrimary(id),
      objectiveStorageStorage.getNonPrimary(id),
      childrenSelectionStorage.get(id).get,
      sequencingTrackingStorage.get(id),
      preventChildrenActivation,
      constrainChoice,
      preConditionRuleStorageImpl.getRules(id),
      postConditionRuleStorageImpl.getRules(id),
      exitConditionRuleStorageImpl.getRules(id),
      rollupRuleStorage.get(id)
    )
  }
}
