package com.arcusys.learn.scorm.manifest.sequencing.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.model._
import com.arcusys.learn.storage.impl.orbroker.KeyedEntityStorageBaseImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.{SequencingCreator, SequencingEntityStorage, SequencingFieldsMapper}
import com.arcusys.learn.storage.impl.EntityStorageExt

class SequencingStorageImpl extends KeyedEntityStorageBaseImpl[Sequencing]("Sequencing", "id") with SequencingEntityStorage with SequencingExtractor with SequencingCreator {
  val sequencingPermissionsStorage = new SequencingPermissionsStorageImpl
  val rollupContributionStorage = new RollupContributionStorageImpl
  val objectiveStorageStorage = new ObjectiveStorageImpl
  val childrenSelectionStorage = new ChildrenSelectionStorageImpl
  val sequencingTrackingStorage = new SequencingTrackingStorageImpl
  val rollupRuleStorage = new RollupRuleStorageImpl
  val exitConditionRuleStorageImpl = new ExitConditionRuleStorageImpl
  val preConditionRuleStorageImpl = new PreConditionRuleStorageImpl
  val postConditionRuleStorageImpl = new PostConditionRuleStorageImpl
  val objectiveMapStorage = new ObjectiveMapStorageImpl
  val ruleConditionStorage = new RuleConditionStorageImpl
}


trait SequencingExtractor extends RowExtractor[Sequencing] {
  def extract(row: Row) = {
    val mapper = new SequencingFieldsMapper {
      def id = row.integer("id").get
      def sharedId = row.string("sharedId")
      def sharedSequencingIdReference = row.string("sharedSequencingIdReference")
      def onlyCurrentAttemptObjectiveProgressForChildren = row.bit("onlyCurrentAttemptObjectiveProgressForChildren").get
      def onlyCurrentAttemptAttemptProgressForChildren = row.bit("onlyCurrentAttemptAttemptProgressForChildren").get
      def attemptLimit = row.integer("attemptLimit")
      def durationLimitInMilliseconds = row.bigInt("durationLimitInMilliseconds")
      def preventChildrenActivation = row.bit("preventChildrenActivation").get
      def constrainChoice = row.bit("constrainChoice").get
     }
    createSequencing(mapper)
  }
  def createSequencing(mapper: SequencingFieldsMapper): Sequencing
}
