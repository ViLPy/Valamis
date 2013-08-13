package com.arcusys.learn.storage.impl.liferay

import com.arcusys.learn.quiz.storage.impl.{QuizQuestionCreator, QuizQuestionEntityStorage, QuizQuestionCategoryEntityStorage, QuizEntityStorage}
import com.arcusys.learn.quiz.storage.impl.liferay._
import com.arcusys.learn.questionbank.storage.impl._
import com.arcusys.learn.questionbank.storage.impl.liferay._
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl._
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay._
import com.arcusys.learn.scorm.manifest.storage.impl.ActivityDataEntityStorage
import com.arcusys.learn.scorm.manifest.storage.impl.liferay._
import com.arcusys.learn.scorm.tracking.states.storage.impl.ObjectiveStateEntityStorage
import com.arcusys.learn.scorm.tracking.states.impl.liferay._
import com.arcusys.learn.questionbank.storage.{QuestionCategoryStorage, AnswerStorage, QuestionStorage}
import com.arcusys.learn.quiz.storage.{QuizStorage, QuizQuestionCategoryStorage}
import com.arcusys.learn.filestorage.storage.impl.FileRecordEntityStorage
import com.arcusys.learn.filestorage.storage.impl.liferay.{FileStorageEntityContainer, LFFileRecordStorageImpl}
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.scorm.manifest.sequencing.storage.{SequencingPermissionsStorage, RuleConditionStorage}
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay._
import com.arcusys.learn.scorm.tracking.storage.impl.liferay.{LFAttemptDataStorageImpl, LFAttemptStorageImpl, UserEntityContainer, AttemptDataEntityContainer}
import com.arcusys.learn.scorm.course.impl.liferay.CourseEntityContainer
import com.arcusys.learn.scorm.tracking.storage.impl.{DataModelEntityStorage, AttemptCreator, AttemptEntityStorage}
import com.arcusys.learn.scorm.tracking.storage.UserStorage
import com.arcusys.learn.scorm.manifest.storage.PackagesStorage

/**
 * User: dkudinov
 * Date: 19.3.2013
 */
object LFStorages extends StorageFactoryContract {
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
  FileStorageEntityContainer.mockLocalService
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

  val fileStorage: FileStorage = new FileRecordEntityStorage with LFFileRecordStorageImpl

  val quizStorage: QuizStorage = new QuizEntityStorage with LFQuizStorageImpl

  val quizCategoryStorage: QuizQuestionCategoryStorage = new QuizQuestionCategoryEntityStorage with LFQuizQuestionCategoryStorageImpl

  val answerStorage: AnswerStorage = new AnswerEntityStorage with LFAnswerStorageImpl with AnswerCreator
  val questionCategoryStorage: QuestionCategoryStorage = new QuestionCategoryEntityStorage with LFQuestionCategoryStorageImpl

  val questionStorage: QuestionStorage = new QuestionEntityStorage with LFQuestionStorageImpl with QuestionCreator {
    val answerStorage = LFStorages.this.answerStorage
  }

  val quizQuestionStorage = new QuizQuestionEntityStorage with LFQuizQuestionStorageImpl with QuizQuestionCreator {
    val questionStorage = LFStorages.this.questionStorage
  }

  val ruleConditionStorage: RuleConditionStorage = new RuleConditionEntityStorage with LFRuleConditionStorageImpl
  val sequencingPermissionsStorage: SequencingPermissionsStorage = new SequencingPermissionsEntityStorage with LFSequencingPermissionsStorageImpl
  val rollupContributionStorage = new RollupContributionEntityStorage with LFRollupContributionStorageImpl
  val objectiveMapStorage = new ObjectiveMapEntityStorage with LFObjectiveMapStorageImpl
  val objectiveStorage = new ObjectiveEntityStorage with LFObjectiveStorageImpl with ObjectiveEntityCreator{
    val mapStorage = LFStorages.this.objectiveMapStorage
  }
  val childrenSelectionStorage = new ChildrenSelectionEntityStorage with LFChildrenSelectionStorageImpl
  val sequencingTrackingStorage = new SequencingTrackingEntityStorage with LFSequencingTrackingStorageImpl
  val rollupRuleStorage = new RollupRuleEntityStorage with LFRollupRuleStorageImpl with RollupRuleCreator{
    val ruleConditionStorage = LFStorages.this.ruleConditionStorage
  }
  val exitConditionRuleStorage = new ExitConditionRuleEntityStorage with LFExitConditionRuleStorageImpl with ExitConditionRuleCreator{
    val ruleConditionStorage = LFStorages.this.ruleConditionStorage
  }
  val preConditionRuleStorage = new PreConditionRuleEntityStorage with LFPreConditionRuleStorageImpl with PreConditionRuleCreator{
    val ruleConditionStorage = LFStorages.this.ruleConditionStorage
  }
  val postConditionRuleStorage = new PostConditionRuleEntityStorage with LFPostConditionRuleStorageImpl with PostConditionRuleCreator{
    val ruleConditionStorage = LFStorages.this.ruleConditionStorage
  }

  val sequencingStorage = new SequencingEntityStorage with LFSequencingStorageImpl with SequencingCreator{
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

  val dataStorage = new ActivityDataEntityStorage with LFActivityDataMapStorageImpl

  val objectiveStateStorage = new ObjectiveStateEntityStorage with LFObjectiveStateStorageImpl {
    val objectiveMapStorage = LFStorages.this.objectiveMapStorage
  }

  val attemptStorage = new AttemptEntityStorage with LFAttemptStorageImpl with AttemptCreator {
    def userStorage: UserStorage = LFStorages.this.userStorage
    def packageStorage: PackagesStorage = LFStorages.this.packageStorage
  }

  val dataModelStorage = new DataModelEntityStorage with LFAttemptDataStorageImpl

  def packageStorage = LFStorageFactory.packageStorage

  def activityStorage = LFStorageFactory.activityStorage

  def resourceStorage = LFStorageFactory.resourceStorage

  def quizQuestionCategoryStorage = LFStorageFactory.quizQuestionCategoryStorage

  //def attemptStorage = LFStorageFactory.attemptStorage

  //def dataModelStorage = LFStorageFactory.dataModelStorage

  def userStorage = LFStorageFactory.userStorage

  def activityStateTreeStorage = LFStorageFactory.activityStateTreeStorage

  def activityStateStorage = LFStorageFactory.activityStateStorage

  def courseStorage = LFStorageFactory.courseStorage

  def packageScopeRuleStorage = LFStorageFactory.packageScopeRuleStorage

  def playerScopeRuleStorage = LFStorageFactory.playerScopeRuleStorage

  def certificateStorage = LFStorageFactory.certificateStorage
  def certificateSiteStorage = LFStorageFactory.certificateSiteStorage
  def certificateUserStorage = LFStorageFactory.certificateUserStorage

  def socialPackageStorage = LFStorageFactory.socialPackageStorage
  def packageVoteStorage = LFStorageFactory.packageVoteStorage
  def packageCommentStorage = LFStorageFactory.packageCommentStorage
}
