package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageImpl
import com.arcusys.learn.scorm.manifest.sequencing.storage.SequencingStorage
import org.orbroker.Row

class SequencingStorageImpl extends KeyedEntityStorageImpl[Sequencing]("Sequencing", "id") with SequencingStorage {
  private val sequencingPermissionsStorage = new SequencingPermissionsStorageImpl
  private val rollupContributionStorage = new RollupContributionStorageImpl
  private val objectiveStorageStorage = new ObjectiveStorageImpl
  private val childrenSelectionStorage = new ChildrenSelectionStorageImpl
  private val sequencingTrackingStorage = new SequencingTrackingStorageImpl
  private val rollupRuleStorage = new RollupRuleStorageImpl
  private val exitConditionRuleStorageImpl = new ExitConditionRuleStorageImpl
  private val preConditionRuleStorageImpl = new PreConditionRuleStorageImpl
  private val postConditionRuleStorageImpl = new PostConditionRuleStorageImpl

  override def create(packageID: Int, activityID: String, sequencing: Sequencing) {
    val id = createAndGetID(sequencing, "packageID"->packageID, "activityID"->activityID)

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
    getOne("packageID"->packageID, "activityID"->activityID)
  }

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

  def extract(row: Row) = {
    val id = row.integer("id").get
    new Sequencing(
      row.string("sharedId"),
      row.string("sharedSequencingIdReference"),
      sequencingPermissionsStorage.get(id).get,
      row.bit("onlyCurrentAttemptObjectiveProgressForChildren").get,
      row.bit("onlyCurrentAttemptAttemptProgressForChildren").get,
      row.integer("attemptLimit"),
      row.bigInt("durationLimitInMilliseconds"),
      rollupContributionStorage.get(id).get,
      objectiveStorageStorage.getPrimary(id),
      objectiveStorageStorage.getNonPrimary(id),
      childrenSelectionStorage.get(id).get,
      sequencingTrackingStorage.get(id),
      row.bit("preventChildrenActivation").get,
      row.bit("constrainChoice").get,
      preConditionRuleStorageImpl.getRules(id),
      postConditionRuleStorageImpl.getRules(id),
      exitConditionRuleStorageImpl.getRules(id),
      rollupRuleStorage.get(id)
    )
  }
}
