package com.arcusys.learn.bl.ioc

import com.arcusys.learn.bl.services._
import com.arcusys.learn.bl.services.certificates.{ CertificateStatusCheckerContract, CertificateStatusChecker, CertificateService }
import com.arcusys.learn.bl.services.lesson.{ PackageUploadManager, PlayerScopeRuleManager, ActivityServiceContract, PackageServiceContract }
import com.arcusys.learn.bl.services.settings.{ SiteDependentSettingManager, SettingService, SettingServiceContract }
import com.arcusys.learn.bl.services.tincan._
import com.arcusys.learn.bl.utils.{ PresentationProcessor, PresentationProcessorContract }
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.filestorage.storage.impl.liferay.FileStorageImpl
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.packages.PackageGradesRepository
import com.arcusys.learn.questionbank.storage.impl.liferay.{ QuestionCategoryStorageImpl, QuestionAnswerStorageImpl, QuestionStorageImpl }
import com.arcusys.learn.questionbank.storage.{ QuestionAnswerStorage, QuestionStorage, QuestionCategoryStorage }
import com.arcusys.learn.quiz.storage.impl._
import com.arcusys.learn.quiz.storage.impl.liferay.{ LFQuizQuestionStorageImpl, LFQuizQuestionCategoryStorageImpl, LFQuizTreeStorageImpl, LFQuizStorageImpl }
import com.arcusys.learn.quiz.storage.{ QuizQuestionCategoryStorage, QuizQuestionStorage, QuizTreeStorage, QuizStorage }
import com.arcusys.learn.repositories.MutableEntityRepository
import com.arcusys.learn.scorm.Archivements.impl.{ AchievementUserEntityStorage, AchievementRequiredEntityStorage, AchievementActivityEntityStorage, AchievementEntityStorage }
import com.arcusys.learn.scorm.Archivements.{ AchievementStorage, AchievementRequiredStorage, AchievementUserStorage, AchievementActivityStorage }
import com.arcusys.learn.scorm.achievements.{ LFAchievementUserStorageImpl, LFAchievementRequiredStorageImpl, LFAchievementActivityStorageImpl, LFAchievementStorageImpl }
import com.arcusys.learn.scorm.certificating._
import com.arcusys.learn.scorm.certificating.impl.{ CertificateActivitySettingsRepository, CertificateCourseSettingsRepository, CertificateStatementObjSettingsRepository }
import com.arcusys.learn.scorm.course.impl.liferay.{ PlayerScopeRuleRepositoryImpl, CourseRepositoryImpl }
import com.arcusys.learn.scorm.course.{ CourseStorage, PlayerScopeRuleStorage }
import com.arcusys.learn.scorm.manifest.model.{ PackageGrade, PostConditionRule, PreConditionRule, ExitConditionRule }
import com.arcusys.learn.scorm.manifest.sequencing.storage._
import com.arcusys.learn.scorm.manifest.sequencing.storage.impl._
import com.arcusys.learn.scorm.manifest.storage.impl.liferay._
import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.scorm.sequencing.storage.impl.liferay._
import com.arcusys.learn.scorm.tracking.impl.liferay.{ RoleStorageImpl, UserStorageImpl }
import com.arcusys.learn.scorm.tracking.states.impl.liferay._
import com.arcusys.learn.scorm.tracking.states.storage.impl.ActivityStateTreeCreator
import com.arcusys.learn.scorm.tracking.states.storage._
import com.arcusys.learn.scorm.tracking.storage.impl.AttemptCreator
import com.arcusys.learn.scorm.tracking.storage.impl.liferay.{ DataModelStorageImpl, AttemptStorageImpl }
import com.arcusys.learn.scorm.tracking.storage.{ DataModelStorage, UserStorage, RoleStorage, AttemptStorage }
import com.arcusys.learn.setting.storage.impl.{ SiteDependentSettingEntityStorage, LRSToActivitySettingEntityStorage, SettingEntityStorage }
import com.arcusys.learn.setting.storage.{ SettingStorage, LRSToActivitySettingStorage, SiteDependentSettingStorage }
import com.arcusys.learn.settings.model.{ LFSiteDependentSettingStorageImpl, LFLRSToActivitySettingStorageImpl, LFSettingStorageImpl }
import com.arcusys.learn.social.storage.impl.{ PackageVoteEntityStorage, PackageCommentEntityStorage, SocialPackageEntityStorage }
import com.arcusys.learn.social.storage.impl.liferay.{ LFPackageVoteStorageImpl, LFPackageCommentStorageImpl, LFSocialPackageStorageImpl }
import com.arcusys.learn.social.storage.{ PackageVoteStorage, PackageCommentStorage, SocialPackageStorage }
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.tincan.lrsEndpoint.{ TincanLrsEndpointRepositoryImpl, TincanLrsEndpointStorage }
import com.arcusys.learn.tincan.manifest.storage.impl.liferay.{ TincanManifestActivityRepositoryImpl, TincanPackageRepositoryImpl }
import com.arcusys.learn.tincan.manifest.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.learn.tincan.storage._
import com.arcusys.learn.tincan.storage.impl._
import com.arcusys.learn.tincan.storage.impl.liferay._
import com.arcusys.scorm.lms.{ PackageService, UserManagement, ClientApiStoreManager, ClientApiStoreManagerContract }
import com.escalatesoft.subcut.inject.NewBindingModule

/**
 * Created by igorborisov on 20.10.14.
 */
object DomainConfiguration extends NewBindingModule({
  implicit module =>
    import module._

    // ------------STORAGES----------------------------------
    bind[StorageFactoryContract].toProvider(module => new StorageFactoryContract {
      override def tincanLrsEndpointStorage: TincanLrsEndpointStorage = module.inject[TincanLrsEndpointStorage](None)

      override def attemptStorage: AttemptStorage = module.inject[AttemptStorage](None)

      override def socialPackageStorage: SocialPackageStorage = module.inject[SocialPackageStorage](None)

      override def packageScopeRuleStorage: PackageScopeRuleStorage = module.inject[PackageScopeRuleStorage](None)

      override def siteDependentSettingStorage: SiteDependentSettingStorage = module.inject[SiteDependentSettingStorage](None)

      override def roleStorage: RoleStorage = module.inject[RoleStorage](None)

      override def tincanPackageStorage: TincanPackageStorage = module.inject[TincanPackageStorage](None)

      override def tincanLrsStatementRefStorage: StatementRefStorage = module.inject[StatementRefStorage](None)

      override def quizStorage: QuizStorage = module.inject[QuizStorage](None)

      override def lrsToActivitySettingStorage: LRSToActivitySettingStorage = module.inject[LRSToActivitySettingStorage](None)

      override def playerScopeRuleStorage: PlayerScopeRuleStorage = module.inject[PlayerScopeRuleStorage](None)

      override def tincanLrsActivityProfileStorage: ActivityProfileStorage = module.inject[ActivityProfileStorage](None)

      override def packageCommentStorage: PackageCommentStorage = module.inject[PackageCommentStorage](None)

      override def activityStateStorage: ActivityStateStorage = module.inject[ActivityStateStorage](None)

      override def tincanLrsActorStorage: ActorStorage = module.inject[ActorStorage](None)

      override def tincanLrsDocumentStorage: DocumentStorage = module.inject[DocumentStorage](None)

      override def tincanLrsContextStorage: ContextStorage = module.inject[ContextStorage](None)

      override def tincanLrsSubStatementStorage: SubStatementStorage = module.inject[SubStatementStorage](None)

      override def achievementActivityStorage: AchievementActivityStorage = module.inject[AchievementActivityStorage](None)

      override def quizTreeStorage: QuizTreeStorage = module.inject[QuizTreeStorage](None)

      override def tincanLrsResultStorage: TincanResultStorage = module.inject[TincanResultStorage](None)

      override def tincanLrsAgentProfileStorage: AgentProfileStorage = module.inject[AgentProfileStorage](None)

      override def quizQuestionStorage: QuizQuestionStorage = module.inject[QuizQuestionStorage](None)

      override def tincanLrsContextActivitiesStorage: ContextActivitiesStorage = module.inject[ContextActivitiesStorage](None)

      override def achievementUserStorage: AchievementUserStorage = module.inject[AchievementUserStorage](None)

      override def tincanClientApiStorage: TincanClientApiStorage = module.inject[TincanClientApiStorage](None)

      override def questionCategoryStorage: QuestionCategoryStorage = module.inject[QuestionCategoryStorage](None)

      override def tincanLrsStatementStorage: StatementStorage = module.inject[StatementStorage](None)

      override def userStorage: UserStorage = module.inject[UserStorage](None)

      override def settingStorage: SettingStorage = module.inject[SettingStorage](None)

      override def achievementRequiredStorage: AchievementRequiredStorage = module.inject[AchievementRequiredStorage](None)

      override def tincanLrsAttachmentStorage: AttachmentStorage = module.inject[AttachmentStorage](None)

      override def tincanLrsStateStorage: StateStorage = module.inject[StateStorage](None)

      override def packageVoteStorage: PackageVoteStorage = module.inject[PackageVoteStorage](None)

      override def activityStateTreeStorage: ActivityStateTreeStorage = module.inject[ActivityStateTreeStorage](None)

      override def tincanLrsActivityStorage: TincanActivityStorage = module.inject[TincanActivityStorage](None)

      override def courseStorage: CourseStorage = module.inject[CourseStorage](None)

      override def tincanActivityStorage: TincanManifestActivityStorage = module.inject[TincanManifestActivityStorage](None)

      override def resourceStorage: ResourcesStorage = module.inject[ResourcesStorage](None)

      override def dataModelStorage: DataModelStorage = module.inject[DataModelStorage](None)

      override def activityStorage: ActivityStorage = module.inject[ActivityStorage](None)

      override def quizQuestionCategoryStorage: QuizQuestionCategoryStorage = module.inject[QuizQuestionCategoryStorage](None)

      override def fileStorage: FileStorage = module.inject[FileStorage](None)

      override def achievementStorage: AchievementStorage = module.inject[AchievementStorage](None)

      override def packageStorage: ScormPackagesStorage = module.inject[ScormPackagesStorage](None)

      @deprecated
      override def questionStorage: QuestionStorage = ???

    })

    bind[QuestionAnswerStorage] toSingle new QuestionAnswerStorageImpl

    bind[QuestionStorage] toProvider (module => new QuestionStorageImpl {
      val answerStorage: QuestionAnswerStorage = module.inject[QuestionAnswerStorage](None)
    })

    // Not related to tincan
    bind[ScormPackagesStorage].toProvider(module => new ScormPackageRepositoryImpl {
      val packageScopeRuleRepository = module.inject[PackageScopeRuleStorage](None)
    })

    bind[TincanPackageStorage].toProvider(module => new TincanPackageRepositoryImpl {
      val packageScopeRuleRepository = module.inject[PackageScopeRuleStorage](None)
    })

    bind[TincanManifestActivityStorage] toSingle new TincanManifestActivityRepositoryImpl

    bind[StatementRefStorage] toSingle new StatementRefEntityStorage with LFTincanLrsStatementRefStorageImpl
    bind[ContextActivitiesStorage] toSingle new ContextActivitiesEntityStorage with LFTincanLrsContextActivitiesStorageImpl

    bind[StatementStorage].toProvider(module => new StatementEntityStorage with LFTincanLrsStatementStorageImpl {
      def actorStorage: ActorStorage = module.inject[ActorStorage](None)

      def tincanActivityStorage: TincanActivityStorage = module.inject[TincanActivityStorage](None)

      def resultStorage: TincanResultStorage = module.inject[TincanResultStorage](None)

      def tincanStatementRefStorage: StatementRefStorage = module.inject[StatementRefStorage](None)

      def tincanSubStatementStorage: SubStatementStorage = module.inject[SubStatementStorage](None)

      def contextStorage: ContextStorage = module.inject[ContextStorage](None)

      def attachmentStorage: AttachmentStorage = module.inject[AttachmentStorage](None)
    })

    bind[SubStatementStorage].toProvider(module => new SubStatementEntityStorage with LFTincanLrsSubStatementStorageImpl {
      def actorStorage: ActorStorage = module.inject[ActorStorage](None)

      def tincanActivityStorage: TincanActivityStorage = module.inject[TincanActivityStorage](None)

      def tincanStatementRefStorage: StatementRefStorage = module.inject[StatementRefStorage](None)
    })

    bind[AttachmentStorage] toSingle new AttachmentEntityStorage with LFTincanLrsAttachmentStorageImpl
    bind[TincanResultStorage] toSingle new TincanResultEntityStorage with LFTincanLrsResultStorageImpl
    bind[ContextStorage].toProvider(module => new ContextEntityStorage with LFTincanLrsContextStorageImpl {
      def actorStorage: ActorStorage = module.inject[ActorStorage](None)

      def contextActivitiesStorage: ContextActivitiesStorage = module.inject[ContextActivitiesStorage](None)
    })

    bind[TincanClientApiStorage] toSingle new TincanClientApiEntityStorage with LFClientApiStorageImpl

    bind[ActorStorage] toSingle new ActorEntityStorage with LFActorStorageImpl
    bind[DocumentStorage] toSingle new DocumentEntityStorage with LFDocumentStorageImpl
    bind[StateStorage].toProvider(module => new StateEntityStorage with LFTincanLrsStateStorageImpl {
      def actorStorage: ActorStorage = module.inject[ActorStorage](None)

      def documentStorage: DocumentStorage = module.inject[DocumentStorage](None)
    })
    bind[TincanActivityStorage] toSingle new TincanActivityEntityStorage with LFTincanActivityStorageImpl
    bind[ActivityProfileStorage] toSingle new ActivityProfileEntityStorage with LFActivityProfileStorageImpl
    bind[AgentProfileStorage].toProvider(module => new AgentProfileEntityStorage with LFAgentProfileStorageImpl {
      def actorStorage: ActorStorage = module.inject[ActorStorage](None)

      def documentStorage: LFDocumentStorageImpl = module.inject[DocumentStorage](None).asInstanceOf[LFDocumentStorageImpl]
    })

    bind[ActivityStorage].toProvider(module => new ActivityRepositoryImpl {
      val sequencingStorage = module.inject[SequencingStorage](None)
      val activityDataRepository = module.inject[ActivityDataStorage](None)
    })
    bind[ResourcesStorage] toSingle new ResourcesRepositoryImpl

    //    bind[QuestionCategoryStorage] toSingle new QuestionCategoryEntityStorage with LFQuestionCategoryStorageImpl {}
    //    bind[AnswerStorage] toSingle new AnswerEntityStorage with LFAnswerStorageImpl with AnswerCreator
    bind[QuizStorage] toSingle new QuizEntityStorage with LFQuizStorageImpl
    bind[QuizTreeStorage] toSingle new QuizTreeEntityStorage with LFQuizTreeStorageImpl
    bind[QuestionCategoryStorage] toSingle new QuestionCategoryStorageImpl

    bind[QuizQuestionCategoryStorage] toSingle new QuizQuestionCategoryEntityStorage with LFQuizQuestionCategoryStorageImpl

    bind[QuizQuestionStorage].toProvider(module => new QuizQuestionEntityStorage with LFQuizQuestionStorageImpl with QuizQuestionCreator {
      val questionStorage = module.inject[QuestionStorage](None)
    })

    bind[AttemptStorage].toProvider(module => new AttemptStorageImpl with AttemptCreator {
      def userStorage: UserStorage = module.inject[UserStorage](None)
      def packageStorage = module.inject[ScormPackagesStorage](None)
    })

    bind[DataModelStorage] toSingle new DataModelStorageImpl
    bind[UserStorage] toSingle new UserStorageImpl
    bind[ActivityStateTreeStorage].toProvider(module => new ActivityStateTreeStorageImpl with ActivityStateTreeCreator {
      def activityStateStorage: ActivityStateStorage = module.inject[ActivityStateStorage](None)

      def activityStateNodeStorage: ActivityStateNodeStorage = module.inject[ActivityStateNodeStorage](None)

      def globalObjectiveStorage: GlobalObjectiveStorage = module.inject[GlobalObjectiveStorage](None)
    })
    bind[ActivityStateNodeStorage].toProvider(module => new ActivityStateNodeStorageImpl {
      def activityStateStorage: ActivityStateStorage = module.inject[ActivityStateStorage](None)
    })
    bind[GlobalObjectiveStorage] toSingle new GlobalObjectiveStorageImpl
    bind[ObjectiveStateStorage].toProvider(module => new ObjectiveStateStorageImpl)
    bind[ActivityStateStorage].toProvider(module => new ActivityStateStorageImpl {
      def activitiesStorage: ActivityStorage = module.inject[ActivityStorage](None)

      def objectiveStateStorage: ObjectiveStateStorage = module.inject[ObjectiveStateStorage](None)
    })

    bind[FileStorage] toSingle new FileStorageImpl
    bind[PackageUploadManager] toSingle new PackageUploadManager

    //bind[CourseStorage] toSingle new CourseEntityStorage with LFCourseStorageImpl
    //bind[PackageScopeRuleStorage] toSingle new PackageScopeRuleEntityStorage with LFPackageScopeRuleStorageImpl
    //bind[PlayerScopeRuleStorage] toSingle new PlayerScopeRuleEntityStorage with LFPlayerScopeRuleStorageImpl
    bind[CourseStorage] toSingle new CourseRepositoryImpl
    bind[PackageScopeRuleStorage] toSingle new PackageScopeRuleRepositoryImpl
    bind[PlayerScopeRuleStorage] toSingle new PlayerScopeRuleRepositoryImpl

    bind[SequencingStorage].toProvider(module => new SequencingEntityStorage with LFSequencingStorageImpl with SequencingCreator {
      val sequencingPermissionsStorage = module.inject[SequencingPermissionsStorage](None)
      val rollupContributionStorage = module.inject[RollupContributionStorage](None)
      val objectiveStorageStorage = module.inject[ObjectiveStorage](None)
      val childrenSelectionStorage = module.inject[ChildrenSelectionStorage](None)
      val sequencingTrackingStorage = module.inject[SequencingTrackingStorage](None)
      val rollupRuleStorage = module.inject[RollupRuleStorage](None)
      val exitConditionRuleStorageImpl = module.inject[ConditionRuleStorage[ExitConditionRule]](None)
      val preConditionRuleStorageImpl = module.inject[ConditionRuleStorage[PreConditionRule]](None)
      val postConditionRuleStorageImpl = module.inject[ConditionRuleStorage[PostConditionRule]](None)

      val objectiveMapStorage = module.inject[ObjectiveMapStorage](None)
      val ruleConditionStorage = module.inject[RuleConditionStorage](None)
    })

    bind[RuleConditionStorage] toSingle new RuleConditionEntityStorage with LFRuleConditionStorageImpl
    bind[SequencingPermissionsStorage] toSingle new SequencingPermissionsEntityStorage with LFSequencingPermissionsStorageImpl
    bind[RollupContributionStorage] toSingle new RollupContributionEntityStorage with LFRollupContributionStorageImpl
    bind[ObjectiveMapStorage] toSingle new ObjectiveMapEntityStorage with LFObjectiveMapStorageImpl
    bind[ObjectiveStorage].toProvider(module => new ObjectiveEntityStorage with LFObjectiveStorageImpl with ObjectiveEntityCreator {
      val mapStorage = module.inject[ObjectiveMapStorage](None)
    })

    bind[ChildrenSelectionStorage] toSingle new ChildrenSelectionEntityStorage with LFChildrenSelectionStorageImpl
    bind[SequencingTrackingStorage] toSingle new SequencingTrackingEntityStorage with LFSequencingTrackingStorageImpl
    bind[RollupRuleStorage].toProvider(module => new RollupRuleEntityStorage with LFRollupRuleStorageImpl with RollupRuleCreator {
      val ruleConditionStorage = module.inject[RuleConditionStorage](None)
    })
    bind[ConditionRuleStorage[ExitConditionRule]].toProvider(module => new ExitConditionRuleEntityStorage with LFExitConditionRuleStorageImpl with ExitConditionRuleCreator {
      val ruleConditionStorage = module.inject[RuleConditionStorage](None)
    })
    bind[ConditionRuleStorage[PreConditionRule]].toProvider(module => new PreConditionRuleEntityStorage with LFPreConditionRuleStorageImpl with PreConditionRuleCreator {
      val ruleConditionStorage = module.inject[RuleConditionStorage](None)
    })
    bind[ConditionRuleStorage[PostConditionRule]].toProvider(module => new PostConditionRuleEntityStorage with LFPostConditionRuleStorageImpl with PostConditionRuleCreator {
      def ruleConditionStorage = module.inject[RuleConditionStorage](None)
    })

    bind[ActivityDataStorage] toSingle new ActivityDataRepositoryImpl

    bind[AchievementStorage] toSingle new AchievementEntityStorage with LFAchievementStorageImpl
    bind[AchievementActivityStorage] toSingle new AchievementActivityEntityStorage with LFAchievementActivityStorageImpl
    bind[AchievementRequiredStorage] toSingle new AchievementRequiredEntityStorage with LFAchievementRequiredStorageImpl
    bind[AchievementUserStorage] toSingle new AchievementUserEntityStorage with LFAchievementUserStorageImpl

    bind[SocialPackageStorage] toSingle new SocialPackageEntityStorage with LFSocialPackageStorageImpl
    bind[PackageCommentStorage] toSingle new PackageCommentEntityStorage with LFPackageCommentStorageImpl
    bind[PackageVoteStorage] toSingle new PackageVoteEntityStorage with LFPackageVoteStorageImpl

    bind[RoleStorage] toSingle new RoleStorageImpl

    bind[SettingStorage] toSingle new SettingEntityStorage with LFSettingStorageImpl
    bind[LRSToActivitySettingStorage] toSingle new LRSToActivitySettingEntityStorage with LFLRSToActivitySettingStorageImpl
    bind[SiteDependentSettingStorage] toSingle new SiteDependentSettingEntityStorage with LFSiteDependentSettingStorageImpl

    bind[TincanURIStorage] toSingle new TincanURIEntityStorage with LFTincanURIStorageImpl

    bind[MutableEntityRepository[PackageGrade]] toSingle new PackageGradesRepository
    bind[TincanLrsEndpointStorage] toSingle new TincanLrsEndpointRepositoryImpl
    bind[CertificateRepositoryContract] toSingle new CertificateRepository
    bind[CertificateStatementObjSettingsRepositoryContract] toSingle new CertificateStatementObjSettingsRepository
    bind[CertificateActivitySettingsRepositoryContract] toSingle new CertificateActivitySettingsRepository
    bind[CertificateCourseSettingsRepositoryContract] toSingle new CertificateCourseSettingsRepository
    bind[CertificateUserRepositoryContract] toSingle new CertificateToUserRepository

    bind[LessonLimitStorage] toSingle new LessonLimitRepositoryImpl

    // END----------STORAGES----------------------------------

    // -------------BL-SERVICES----------------------------------

    bind[CertificateServiceContract] toSingle new CertificateService
    bind[CourseServiceContract] toSingle new com.arcusys.learn.bl.services.CourseService
    bind[FileServiceContract] toSingle new FileService
    bind[GradeBookServiceContract] toSingle new GradeBookService
    bind[LRSToActivitySettingServiceContract] toSingle new LRSToActivitySettingService
    bind[QuestionServiceContract].toSingle(new QuestionService)
    bind[QuizServiceContract].toSingle(new QuizService)
    bind[RoleServiceContract].toSingle(new RoleService)
    bind[URIServiceContract].toSingle(new URIService)
    bind[UserServiceContract].toSingle(new UserService)
    bind[UserRoleServiceContract].toSingle(new UserRoleService)
    bind[ValamisPackageServiceContract].toSingle(new ValamisPackageService)
    bind[FileEntryServiceContract].toSingle(new FileEntryService)

    //tincan
    bind[ActivityProfileServiceContract].toSingle(new ActivityProfileService)
    bind[AgentServiceContract].toSingle(new AgentService)
    bind[StatementServiceContract].toSingle(new StatementService)
    bind[StateServiceContract].toSingle(new StateService)

    //lesson
    bind[PackageServiceContract].toSingle(new com.arcusys.learn.bl.services.lesson.PackageService)
    bind[ActivityServiceContract].toSingle(new com.arcusys.learn.bl.services.lesson.ActivityService)

    bind[SettingServiceContract] toSingle new SettingService
    bind[SiteDependentSettingManager] toSingle new SiteDependentSettingManager

    bind[PresentationProcessorContract] toSingle PresentationProcessor

    // END----------BL-SERVICES----------------------------------

    // -------------OTHER----------------------------------
    bind[CertificateStatusCheckerContract] toSingle new CertificateStatusChecker(module)

    bind[ClientApiStoreManagerContract] toSingle new ClientApiStoreManager
    bind[UserManagement].toSingle(new UserManagement)
    bind[LessonLimitChecker].toSingle(new LessonLimitChecker(module))
    bind[UserLocalServiceHelper] toSingle UserLocalServiceHelper()
    bind[PackageService].toSingle(new PackageService)
    bind[PlayerScopeRuleManager].toSingle(new PlayerScopeRuleManager)

  //TODO check that
  //bind[SessionHandlerContract] toSingle SessionHandler
  //bind[MessageTemplateLoader].toSingle(ResourceTemplateLoader)
})
