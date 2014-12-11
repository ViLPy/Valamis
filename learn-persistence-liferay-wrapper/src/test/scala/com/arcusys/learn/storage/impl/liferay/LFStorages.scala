package com.arcusys.learn.storage.impl.liferay

import com.arcusys.learn.quiz.storage.impl.{ QuizQuestionCreator, QuizQuestionEntityStorage, QuizQuestionCategoryEntityStorage, QuizEntityStorage }
import com.arcusys.learn.quiz.storage.impl.liferay._
import com.arcusys.learn.questionbank.storage.impl._
import com.arcusys.learn.questionbank.storage.impl.liferay._
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl._
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay._
import com.arcusys.learn.scorm.manifest.storage.impl.ActivityDataEntityStorage
import com.arcusys.learn.scorm.manifest.storage.impl.liferay._
import com.arcusys.learn.scorm.tracking.states.storage.ObjectiveStateStorage
import com.arcusys.learn.scorm.tracking.states.storage.impl.ObjectiveStateEntityStorage
import com.arcusys.learn.scorm.tracking.states.impl.liferay._
import com.arcusys.learn.questionbank.storage.{ QuestionCategoryStorage, QuestionAnswerStorage, QuestionStorage }
import com.arcusys.learn.quiz.storage.{ QuizTreeStorage, QuizStorage, QuizQuestionCategoryStorage }
import com.arcusys.learn.filestorage.storage.impl.FileRecordEntityStorage
import com.arcusys.learn.filestorage.storage.impl.liferay.{ FileStorageImpl, FileStorageEntityContainer, LFFileRecordStorageImpl }
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.scorm.manifest.sequencing.storage.{ SequencingPermissionsStorage, RuleConditionStorage }
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl.liferay._
import com.arcusys.learn.scorm.tracking.storage.impl.liferay._
import com.arcusys.learn.scorm.course.impl.liferay.CourseEntityContainer
import com.arcusys.learn.scorm.tracking.storage.impl.{ DataModelEntityStorage, AttemptCreator, AttemptEntityStorage }
import com.arcusys.learn.scorm.tracking.storage.UserStorage
import com.arcusys.learn.scorm.manifest.storage.{ ActivityDataStorage, ScormPackagesStorage, LessonLimitStorage }
import com.arcusys.learn.tincan.manifest.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.tincan.storage._
import com.arcusys.learn.setting.storage.{ LRSToActivitySettingStorage, SiteDependentSettingStorage }

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

  lazy val tincanLrsEndpointStorage: TincanLrsEndpointStorage = throw new UnsupportedOperationException("TincanLrsEndpointStorage not implemented for LFStorages")

  //def tincanPackageStorage = LFStorageFactory.tincanPackageStorage
  lazy val tincanPackageStorage: TincanPackageStorage = throw new UnsupportedOperationException("TincanPackageStorage not implemented for LFStorages")
  lazy val tincanActivityStorage: TincanManifestActivityStorage = throw new UnsupportedOperationException("TincanActivitiesStorage not implemented for LFStorages")
  lazy val tincanClientApiStorage: TincanClientApiStorage = throw new UnsupportedOperationException("TincanActivitiesStorage not implemented for LFStorages")
  lazy val tincanLrsStatemntStorage: StatementStorage = throw new UnsupportedOperationException("Tincan StatementStorage not implemented for LFStorages")
  lazy val tincanLrsStateStorage: StateStorage = throw new UnsupportedOperationException("Tincan StateStorage not implemented for LFStorages")
  lazy val tincanLrsActivityStorage: TincanActivityStorage = throw new UnsupportedOperationException("Tincan ActivityStorage not implemented for LFStorages")
  lazy val tincanLrsActivityProfileStorage: ActivityProfileStorage = throw new UnsupportedOperationException("Tincan ActivityProfileStorage not implemented for LFStorages")
  lazy val tincanLrsStatementStorage: StatementStorage = throw new UnsupportedOperationException("Tincan LrsStatementStorage not implemented for LFStorages")
  lazy val tincanLrsAgentProfileStorage: AgentProfileStorage = throw new UnsupportedOperationException("Tincan LrsStatementStorage not implemented for LFStorages")

  val fileStorage: FileStorage = new FileStorageImpl

  val quizStorage: QuizStorage = new QuizEntityStorage with LFQuizStorageImpl

  val quizCategoryStorage: QuizQuestionCategoryStorage = new QuizQuestionCategoryEntityStorage with LFQuizQuestionCategoryStorageImpl

  val answerStorage: QuestionAnswerStorage = new QuestionAnswerStorageImpl
  val questionCategoryStorage: QuestionCategoryStorage = new QuestionCategoryStorageImpl

  val questionStorage: QuestionStorage = new QuestionStorageImpl {
    val answerStorage = LFStorages.this.answerStorage
  }

  val quizQuestionStorage = new QuizQuestionEntityStorage with LFQuizQuestionStorageImpl with QuizQuestionCreator {
    val questionStorage = new QuestionStorageImpl {
      override protected def answerStorage: QuestionAnswerStorage = new QuestionAnswerStorageImpl
    }
  }

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

  val dataStorage: ActivityDataStorage = new ActivityDataRepositoryImpl

  val objectiveStateStorage: ObjectiveStateStorage = new ObjectiveStateStorageImpl

  val attemptStorage = new AttemptStorageImpl with AttemptCreator {
    def userStorage: UserStorage = ???
    def packageStorage: ScormPackagesStorage = ???
  }

  val dataModelStorage = new DataModelStorageImpl

  def packageStorage = ???

  def activityStorage = ???

  def resourceStorage = ???

  def quizQuestionCategoryStorage = ???

  //def attemptStorage = LFStorageFactory.attemptStorage

  //def dataModelStorage = LFStorageFactory.dataModelStorage

  def userStorage = ???

  def activityStateTreeStorage = ???

  def activityStateStorage = ???

  def courseStorage = ???

  def packageScopeRuleStorage = ???

  def playerScopeRuleStorage = ???

  //  def certificateStorage = LFStorageFactory.certificateStorage
  //def certificateSiteStorage = LFStorageFactory.certificateSiteStorage
  //  def certificateUserStorage = LFStorageFactory.certificateUserStorage

  def achievementStorage = ???
  def achievementActivityStorage = ???
  def achievementRequiredStorage = ???
  def achievementUserStorage = ???

  def socialPackageStorage = ???
  def packageVoteStorage = ???
  def packageCommentStorage = ???

  def roleStorage = ???

  def settingStorage = ???

  def tincanLrsStatementRefStorage: StatementRefStorage = throw new UnsupportedOperationException("TincanLrsEndpointStorage not implemented for LFStorages")
  def tincanLrsContextActivitiesStorage: ContextActivitiesStorage = throw new UnsupportedOperationException("TincanLrsEndpointStorage not implemented for LFStorages")
  def tincanLrsSubStatementStorage: SubStatementStorage = throw new UnsupportedOperationException("TincanLrsEndpointStorage not implemented for LFStorages")
  def tincanLrsAttachmentStorage: AttachmentStorage = throw new UnsupportedOperationException("TincanLrsEndpointStorage not implemented for LFStorages")
  def tincanLrsResultStorage: TincanResultStorage = throw new UnsupportedOperationException("TincanLrsEndpointStorage not implemented for LFStorages")
  def tincanLrsContextStorage: ContextStorage = throw new UnsupportedOperationException("TincanLrsEndpointStorage not implemented for LFStorages")
  def tincanLrsActorStorage: ActorStorage = throw new UnsupportedOperationException("TincanLrsEndpointStorage not implemented for LFStorages")
  def tincanLrsDocumentStorage: DocumentStorage = throw new UnsupportedOperationException("TincanLrsEndpointStorage not implemented for LFStorages")

  def quizTreeStorage: QuizTreeStorage = throw new UnsupportedOperationException("Not implemented for LFStorages")

  def siteDependentSettingStorage: SiteDependentSettingStorage = ???

  def lrsToActivitySettingStorage: LRSToActivitySettingStorage = ???

}
