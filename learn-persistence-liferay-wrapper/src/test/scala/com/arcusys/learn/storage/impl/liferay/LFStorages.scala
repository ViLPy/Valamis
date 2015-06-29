package com.arcusys.learn.storage.impl.liferay

import com.arcusys.learn.quiz.storage.impl.QuizQuestionCategoryEntityStorage
import com.arcusys.learn.quiz.storage.impl.liferay._
import com.arcusys.learn.questionbank.storage.impl.liferay._
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl._
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay._
import com.arcusys.learn.scorm.manifest.storage.impl.liferay._
import com.arcusys.learn.scorm.tracking.states.impl.liferay._
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay._
import com.arcusys.learn.scorm.tracking.storage.impl.liferay._
import com.arcusys.learn.scorm.course.impl.liferay.CourseEntityContainer
import com.arcusys.valamis.lesson.scorm.storage.sequencing.{SequencingPermissionsStorage, RuleConditionStorage}
import com.arcusys.valamis.quiz.storage.QuizQuestionCategoryStorage

/**
 * User: dkudinov
 * Date: 19.3.2013
 */
object LFStorages {
  // do initialize mock services
  ActivityDataMapEntityContainer.mockLocalService
  ActivityEntityContainer.mockLocalService
  ActivityStateNodeEntityContainer.mockLocalService
  AnswerMockEntityContainer.mockLocalService
  AttemptDataEntityContainer.mockLocalService
  AttemptEntityContainer.mockLocalService
  ActivityStateTreeEntityContainer.mockLocalService
  ActivityStateEntityContainer.mockLocalService
  ChildrenSelectionEntityContainer.mockLocalService
  ConditionRuleEntityContainer.mockLocalService
  CourseEntityContainer.mockLocalService
  ObjectiveEntityContainer.mockLocalService
  ObjectiveMapEntityContainer.mockLocalService
  ObjectiveStateEntityContainer.mockLocalService
  GlobalObjectiveStateEntityContainer.mockLocalService
  PackageEntityContainer.mockLocalService
  PackageScopeRuleEntityContainer.mockLocalService
  PlayerScopeRuleEntityContainer.mockLocalService
  QuestionCategoryMockEntityContainer.mockLocalService
  QuestionMockEntityContainer.mockLocalService
  QuizMockEntityContainer.mockLocalService
  QuizQuestionCategoryMockEntityContainer.mockLocalService
  QuizQuestionMockEntityContainer.mockLocalService
  ResourceEntityContainer.mockLocalService
  RollupContributionEntityContainer.mockLocalService
  RollupRuleEntityContainer.mockLocalService
  RuleConditionEntityContainer.mockLocalService
  SequencingEntityContainer.mockLocalService
  SequencingPermissionsEntityContainer.mockLocalService
  SequencingTrackingEntityContainer.mockLocalService
  UserEntityContainer.mockLocalService

  val quizCategoryStorage: QuizQuestionCategoryStorage = new QuizQuestionCategoryEntityStorage with LFQuizQuestionCategoryStorageImpl

  val ruleConditionStorage: RuleConditionStorage = new RuleConditionEntityStorage with LFRuleConditionStorageImpl
  val sequencingPermissionsStorage: SequencingPermissionsStorage = new SequencingPermissionsEntityStorage with LFSequencingPermissionsStorageImpl
  val rollupContributionStorage = new RollupContributionEntityStorage with LFRollupContributionStorageImpl
  val objectiveMapStorage = new ObjectiveMapEntityStorage with LFObjectiveMapStorageImpl
  val objectiveStorage = new ObjectiveEntityStorage with LFObjectiveStorageImpl with ObjectiveEntityCreator {
    val mapStorage = LFStorages.this.objectiveMapStorage
  }
  val childrenSelectionStorage = new ChildrenSelectionEntityStorage with LFChildrenSelectionStorageImpl
  val sequencingTrackingStorage = new SequencingTrackingEntityStorage with LFSequencingTrackingStorageImpl
  val rollupRuleStorage = new RollupRuleEntityStorage with LFRollupRuleStorageImpl with RollupRuleCreator {
    val ruleConditionStorage = LFStorages.this.ruleConditionStorage
  }
  val exitConditionRuleStorage = new ExitConditionRuleEntityStorage with LFExitConditionRuleStorageImpl with ExitConditionRuleCreator {
    val ruleConditionStorage = LFStorages.this.ruleConditionStorage
  }
  val preConditionRuleStorage = new PreConditionRuleEntityStorage with LFPreConditionRuleStorageImpl with PreConditionRuleCreator {
    val ruleConditionStorage = LFStorages.this.ruleConditionStorage
  }
  val postConditionRuleStorage = new PostConditionRuleEntityStorage with LFPostConditionRuleStorageImpl with PostConditionRuleCreator {
    val ruleConditionStorage = LFStorages.this.ruleConditionStorage
  }

  val sequencingStorage = new SequencingEntityStorage with LFSequencingStorageImpl with SequencingCreator {
    val sequencingPermissionsStorage = LFStorages.this.sequencingPermissionsStorage
    val rollupContributionStorage = LFStorages.this.rollupContributionStorage
    val objectiveStorageStorage = LFStorages.this.objectiveStorage
    val childrenSelectionStorage = LFStorages.this.childrenSelectionStorage
    val sequencingTrackingStorage = LFStorages.this.sequencingTrackingStorage
    val rollupRuleStorage = LFStorages.this.rollupRuleStorage
    val exitConditionRuleStorageImpl = LFStorages.this.exitConditionRuleStorage
    val preConditionRuleStorageImpl = LFStorages.this.preConditionRuleStorage
    val postConditionRuleStorageImpl = LFStorages.this.postConditionRuleStorage
    val objectiveMapStorage = LFStorages.objectiveMapStorage
    val ruleConditionStorage = LFStorages.ruleConditionStorage
  }
}
