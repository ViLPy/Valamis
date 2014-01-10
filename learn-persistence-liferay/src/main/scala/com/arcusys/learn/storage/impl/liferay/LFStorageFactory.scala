package com.arcusys.learn.storage.impl.liferay

import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.filestorage.storage.impl.FileRecordEntityStorage
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.manifest.storage.{PackageScopeRuleStorage, ResourcesStorage, ActivitiesStorage, PackagesStorage}
import com.arcusys.learn.questionbank.storage.{AnswerStorage, QuestionStorage, QuestionCategoryStorage}
import com.arcusys.learn.quiz.storage.{QuizQuestionStorage, QuizQuestionCategoryStorage, QuizStorage}
import com.arcusys.learn.scorm.tracking.storage.{RoleStorage, UserStorage, DataModelStorage, AttemptStorage}
import com.arcusys.learn.scorm.tracking.states.storage._
import com.arcusys.learn.scorm.course.{PlayerScopeRuleStorage, CourseStorage}
import com.arcusys.learn.updater.StorageUpdater
import com.arcusys.learn.questionbank.storage.impl._
import com.arcusys.learn.questionbank.storage.impl.liferay.{LFAnswerStorageImpl, LFQuestionStorageImpl, LFQuestionCategoryStorageImpl}
import com.arcusys.learn.quiz.storage.impl.{QuizQuestionCreator, QuizQuestionEntityStorage, QuizQuestionCategoryEntityStorage, QuizEntityStorage}
import com.arcusys.learn.quiz.storage.impl.liferay.{LFQuizQuestionStorageImpl, LFQuizQuestionCategoryStorageImpl, LFQuizStorageImpl}
import com.arcusys.learn.filestorage.storage.impl.liferay.LFFileRecordStorageImpl
import com.arcusys.learn.scorm.course.impl.liferay.{LFPlayerScopeRuleStorageImpl, LFCourseStorageImpl}
import com.arcusys.learn.scorm.course.impl.{PlayerScopeRuleEntityStorage, CourseEntityStorage}
import com.arcusys.learn.scorm.tracking.storage.impl._
import com.arcusys.learn.scorm.tracking.impl.liferay.{LFRoleStorageImpl, LFUserStorageImpl}
import com.arcusys.learn.scorm.manifest.sequencing.storage.{ObjectiveMapStorage, SequencingStorage}
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl._
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay._
import com.arcusys.learn.scorm.manifest.storage.impl._
import com.arcusys.learn.scorm.manifest.storage.impl.liferay._
import com.arcusys.learn.scorm.tracking.storage.impl.liferay.{LFAttemptDataStorageImpl, LFAttemptStorageImpl}
import com.arcusys.learn.scorm.tracking.states.storage.impl._
import com.arcusys.learn.scorm.tracking.states.impl.liferay._
import com.arcusys.learn.social.storage.{PackageVoteStorage, PackageCommentStorage, SocialPackageStorage}
import com.arcusys.learn.social.storage.impl.{PackageVoteEntityStorage, PackageCommentEntityStorage, SocialPackageEntityStorage}
import com.arcusys.learn.social.storage.impl.liferay.{LFPackageCommentStorageImpl, LFPackageVoteStorageImpl, LFSocialPackageStorageImpl}
import com.arcusys.learn.scorm.certificating._
import com.arcusys.learn.scorm.certificating.impl.{CertificateUserEntityStorage, CertificateSiteEntityStorage, CertificateEntityStorage}
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.setting.storage.impl.SettingEntityStorage
import com.arcusys.learn.settings.model.LFSettingStorageImpl
import com.arcusys.learn.tincan.manifest.storage.{TincanManifestActivityStorage, TincanPackageStorage}
import com.arcusys.learn.tincan.manifest.storage.impl.{TincanManifestActivityEntityStorage, TincanPackageEntityStorage}
import com.arcusys.learn.tincan.manifest.storage.impl.liferay.{LFTincanManifestActivityStorageImpl, LFTincanPackageStorageImpl}
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.tincan.lrsEndpoint.impl.TincanLrsEndpointEntityStorage
import com.arcusys.learn.tincan.storage.impl.liferay._
import com.arcusys.learn.tincan.storage._
import com.arcusys.learn.tincan.storage.impl._
import com.arcusys.learn.scorm.manifest.storage.impl.ActivityEntityStorage
import com.arcusys.learn.tincan.model.AgentProfile

/**
 * User: dkudinov
 * Date: 12.3.2013
 */
object LFStorageFactory extends StorageFactoryContract {
  lazy val tincanLrsEndpointStorage: TincanLrsEndpointStorage = new TincanLrsEndpointEntityStorage with LFLrsEndpointStorageImpl {}
  lazy val tincanPackageStorage: TincanPackageStorage = new TincanPackageEntityStorage with LFTincanPackageStorageImpl{ }
  lazy val tincanActivityStorage: TincanManifestActivityStorage = new TincanManifestActivityEntityStorage with LFTincanManifestActivityStorageImpl

  lazy val tincanLrsStatementRefStorage: StatementRefStorage = new StatementRefEntityStorage with LFTincanLrsStatementRefStorageImpl
  lazy val tincanLrsContextActivitiesStorage: ContextActivitiesStorage = new ContextActivitiesEntityStorage with LFTincanLrsContextActivitiesStorageImpl

  lazy val tincanLrsStatementStorage: StatementStorage = new StatementEntityStorage with LFTincanLrsStatementStorageImpl{
    def actorStorage: LFActorStorageImpl = LFStorageFactory.this.tincanLrsActorStorage.asInstanceOf[LFActorStorageImpl]
    def tincanActivityStorage: TincanActivityStorage = LFStorageFactory.this.tincanLrsActivityStorage

    def resultStorage: TincanResultStorage = LFStorageFactory.this.tincanLrsResultStorage

    def tincanStatementRefStorage: StatementRefStorage = LFStorageFactory.this.tincanLrsStatementRefStorage

    def tincanSubStatementStorage: SubStatementStorage = LFStorageFactory.this.tincanLrsSubStatementStorage

    def contextStorage: ContextStorage = LFStorageFactory.this.tincanLrsContextStorage

    def attachmentStorage: AttachmentStorage = LFStorageFactory.this.tincanLrsAttachmentStorage
  }

  lazy val tincanLrsSubStatementStorage: SubStatementStorage = new SubStatementEntityStorage with LFTincanLrsSubStatementStorageImpl{
    def actorStorage: LFActorStorageImpl = LFStorageFactory.this.tincanLrsActorStorage.asInstanceOf[LFActorStorageImpl]
    def tincanActivityStorage: TincanActivityStorage = LFStorageFactory.this.tincanLrsActivityStorage

    def tincanStatementRefStorage: StatementRefStorage = LFStorageFactory.this.tincanLrsStatementRefStorage
  }
  lazy val tincanLrsAttachmentStorage: AttachmentStorage = new AttachmentEntityStorage with LFTincanLrsAttachmentStorageImpl
  lazy val tincanLrsResultStorage: TincanResultStorage = new TincanResultEntityStorage with LFTincanLrsResultStorageImpl
  lazy val tincanLrsContextStorage: ContextStorage = new ContextEntityStorage with LFTincanLrsContextStorageImpl{
    def actorStorage: LFActorStorageImpl = LFStorageFactory.this.tincanLrsActorStorage.asInstanceOf[LFActorStorageImpl]
    def contextActivitiesStorage: ContextActivitiesStorage = LFStorageFactory.this.tincanLrsContextActivitiesStorage
  }

  lazy val tincanLrsActorStorage: ActorStorage = new ActorEntityStorage with LFActorStorageImpl
  lazy val tincanLrsDocumentStorage: DocumentStorage = new DocumentEntityStorage with LFDocumentStorageImpl
  lazy val tincanLrsStateStorage: StateStorage = new StateEntityStorage with LFTincanLrsStateStorageImpl{
    def actorStorage: LFActorStorageImpl = LFStorageFactory.this.tincanLrsActorStorage.asInstanceOf[LFActorStorageImpl]
    def documentStorage: DocumentStorage = LFStorageFactory.this.tincanLrsDocumentStorage
  }
  lazy val tincanLrsActivityStorage : TincanActivityStorage = new TincanActivityEntityStorage with LFTincanActivityStorageImpl
  lazy val tincanLrsActivityProfileStorage : ActivityProfileStorage = new ActivityProfileEntityStorage with LFActivityProfileStorageImpl
  lazy val tincanLrsAgentProfileStorage : AgentProfileStorage = new AgentProfileEntityStorage with LFAgentProfileStorageImpl {
    def actorStorage: LFActorStorageImpl = LFStorageFactory.this.tincanLrsActorStorage.asInstanceOf[LFActorStorageImpl]
    def documentStorage: LFDocumentStorageImpl = LFStorageFactory.this.tincanLrsDocumentStorage.asInstanceOf[LFDocumentStorageImpl]
  }

  // Not related to tincan
  lazy val packageStorage: PackagesStorage = new PackagesEntityStorage with LFPackageStorageImpl{
    val packageScopeRuleStorage = LFStorageFactory.this.packageScopeRuleStorage
  }
  lazy val activityStorage: ActivitiesStorage = new ActivityEntityStorage with LFActivityStorageImpl with ActivityCreator{
    val sequencingStorage = LFStorageFactory.this.sequencingStorage
    val dataStorage = LFStorageFactory.this.activityDataStorage
  }
  //lazy val organizationStorage: OrganizationsStorage = new OrganizationsStorageImpl
  lazy val resourceStorage: ResourcesStorage = new ResourceEntityStorage with LFResourceStorageImpl


  lazy val questionCategoryStorage: QuestionCategoryStorage = new QuestionCategoryEntityStorage with LFQuestionCategoryStorageImpl{
  }
  lazy val questionStorage: QuestionStorage = new QuestionEntityStorage with LFQuestionStorageImpl with QuestionCreator {
    val answerStorage = LFStorageFactory.this.answerStorage
    //def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterTarget: Boolean) { throw new UnsupportedOperationException("Not implemented") }
  }
  private lazy val answerStorage: AnswerStorage = new AnswerEntityStorage with LFAnswerStorageImpl with AnswerCreator
  lazy val quizStorage: QuizStorage = new QuizEntityStorage with LFQuizStorageImpl
  lazy val quizQuestionCategoryStorage: QuizQuestionCategoryStorage = new QuizQuestionCategoryEntityStorage with LFQuizQuestionCategoryStorageImpl{
//    def move(id: Int, parentID: Option[Int], siblingID: Option[Int], moveAfterSibling: Boolean) = { throw new UnsupportedOperationException("Not implemented") }
  }
  lazy val quizQuestionStorage: QuizQuestionStorage = new QuizQuestionEntityStorage with LFQuizQuestionStorageImpl with QuizQuestionCreator {
    val questionStorage = LFStorageFactory.this.questionStorage
  }


  lazy val attemptStorage: AttemptStorage = new AttemptEntityStorage with LFAttemptStorageImpl with AttemptCreator{
    def userStorage: UserStorage = LFStorageFactory.this.userStorage
    def packageStorage: PackagesStorage = LFStorageFactory.this.packageStorage
  }

  lazy val dataModelStorage: DataModelStorage = new DataModelEntityStorage with LFAttemptDataStorageImpl
  lazy val userStorage: UserStorage = new UserEntityStorage with LFUserStorageImpl
  lazy val activityStateTreeStorage: ActivityStateTreeStorage = new ActivityStateTreeEntityStorage with LFActivityStateTreeStorageImpl with ActivityStateTreeCreator{
    def activityStateStorage: ActivityStateStorage = LFStorageFactory.this.activityStateStorage

    def activityStateNodeStorage: ActivityStateNodeStorage = LFStorageFactory.this.activityStateNodeStorage

    def globalObjectiveStorage: GlobalObjectiveStorage = LFStorageFactory.this.globalObjectiveStorage
  }
  private lazy val activityStateNodeStorage: ActivityStateNodeStorage = new ActivityStateNodeEntityStorage with LFActivityStateNodeStorageImpl with ActivityStateNodeCreator {
    def activityStateStorage: ActivityStateStorage = LFStorageFactory.this.activityStateStorage
  }
  private lazy val globalObjectiveStorage: GlobalObjectiveStorage = new GlobalObjectiveEntityStorage with LFGlobalObjectiveStorageImpl
  private lazy val objectiveStateStorage: ObjectiveStateStorage = new ObjectiveStateEntityStorage with LFObjectiveStateStorageImpl{
    def objectiveMapStorage: ObjectiveMapStorage = LFStorageFactory.this.objectiveMapStorage
  }
  lazy val activityStateStorage: ActivityStateStorage = new ActivityStateEntityStorage with LFActivityStateStorageImpl with ActivityStateCreator{
    def activitiesStorage: ActivitiesStorage = LFStorageFactory.this.activityStorage

    def objectiveStateStorage: ObjectiveStateStorage = LFStorageFactory.this.objectiveStateStorage
  }

  lazy val fileStorage: FileStorage = new FileRecordEntityStorage with LFFileRecordStorageImpl

  lazy val courseStorage: CourseStorage = new CourseEntityStorage with LFCourseStorageImpl
  lazy val packageScopeRuleStorage: PackageScopeRuleStorage = new PackageScopeRuleEntityStorage with LFPackageScopeRuleStorageImpl
  lazy val playerScopeRuleStorage: PlayerScopeRuleStorage = new PlayerScopeRuleEntityStorage with LFPlayerScopeRuleStorageImpl
  lazy val storageUpdater: StorageUpdater = new StorageUpdater {
    // Liferay handles DB update through Hibernate
    def updateTo1_2() {}
  }

  lazy val sequencingStorage: SequencingStorage = new SequencingEntityStorage with LFSequencingStorageImpl with SequencingCreator{
    val sequencingPermissionsStorage = LFStorageFactory.this.sequencingPermissionsStorage
    val rollupContributionStorage = LFStorageFactory.this.rollupContributionStorage
    val objectiveStorageStorage = LFStorageFactory.this.objectiveStorage
    val childrenSelectionStorage = LFStorageFactory.this.childrenSelectionStorage
    val sequencingTrackingStorage = LFStorageFactory.this.sequencingTrackingStorage
    val rollupRuleStorage = LFStorageFactory.this.rollupRuleStorage
    val exitConditionRuleStorageImpl = LFStorageFactory.this.exitConditionRuleStorage
    val preConditionRuleStorageImpl= LFStorageFactory.this.preConditionRuleStorage
    val postConditionRuleStorageImpl= LFStorageFactory.this.postConditionRuleStorage

    val objectiveMapStorage = LFStorageFactory.objectiveMapStorage
    val ruleConditionStorage = LFStorageFactory.ruleConditionStorage
  }

  lazy val ruleConditionStorage = new RuleConditionEntityStorage with LFRuleConditionStorageImpl
  lazy val sequencingPermissionsStorage = new SequencingPermissionsEntityStorage with LFSequencingPermissionsStorageImpl
  lazy val rollupContributionStorage = new RollupContributionEntityStorage with LFRollupContributionStorageImpl
  lazy val objectiveMapStorage = new ObjectiveMapEntityStorage with LFObjectiveMapStorageImpl
  lazy val objectiveStorage = new ObjectiveEntityStorage with LFObjectiveStorageImpl with ObjectiveEntityCreator{
    val mapStorage = LFStorageFactory.this.objectiveMapStorage
  }
  lazy val childrenSelectionStorage = new ChildrenSelectionEntityStorage with LFChildrenSelectionStorageImpl
  lazy val sequencingTrackingStorage = new SequencingTrackingEntityStorage with LFSequencingTrackingStorageImpl
  lazy val rollupRuleStorage = new RollupRuleEntityStorage with LFRollupRuleStorageImpl with RollupRuleCreator{
    val ruleConditionStorage = LFStorageFactory.this.ruleConditionStorage
  }
  lazy val exitConditionRuleStorage = new ExitConditionRuleEntityStorage with LFExitConditionRuleStorageImpl with ExitConditionRuleCreator{
    val ruleConditionStorage = LFStorageFactory.this.ruleConditionStorage
  }
  lazy val preConditionRuleStorage = new PreConditionRuleEntityStorage with LFPreConditionRuleStorageImpl with PreConditionRuleCreator{
    val ruleConditionStorage = LFStorageFactory.this.ruleConditionStorage
  }
  lazy val postConditionRuleStorage = new PostConditionRuleEntityStorage with LFPostConditionRuleStorageImpl with PostConditionRuleCreator{
    val ruleConditionStorage = LFStorageFactory.this.ruleConditionStorage
  }
  lazy val activityDataStorage = new ActivityDataEntityStorage with LFActivityDataMapStorageImpl

  lazy val certificateStorage: CertificateStorage = new CertificateEntityStorage with LFCertificateStorageImpl
  lazy val certificateSiteStorage: CertificateSiteStorage = new CertificateSiteEntityStorage with LFCertificateSiteStorageImpl
  lazy val certificateUserStorage: CertificateUserStorage = new CertificateUserEntityStorage with LFCertificateUserStorageImpl

  lazy val socialPackageStorage: SocialPackageStorage = new SocialPackageEntityStorage with LFSocialPackageStorageImpl
  lazy val packageCommentStorage: PackageCommentStorage = new PackageCommentEntityStorage with LFPackageCommentStorageImpl
  lazy val packageVoteStorage: PackageVoteStorage = new PackageVoteEntityStorage with LFPackageVoteStorageImpl

  lazy val roleStorage: RoleStorage = new RoleEntityStorage with LFRoleStorageImpl

  lazy val settingStorage: SettingStorage = new SettingEntityStorage with LFSettingStorageImpl

}
