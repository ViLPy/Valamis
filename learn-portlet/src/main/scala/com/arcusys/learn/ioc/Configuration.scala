package com.arcusys.learn.ioc

import com.arcusys.learn._
import com.arcusys.learn.facades._
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.filestorage.storage.impl.FileRecordEntityStorage
import com.arcusys.learn.filestorage.storage.impl.liferay.LFFileRecordStorageImpl
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.notifications.MessageTemplateLoader
import com.arcusys.learn.notifications.services.ResourceTemplateLoader
import com.arcusys.learn.packages.PackageGradesRepository
import com.arcusys.learn.questionbank.storage.impl._
import com.arcusys.learn.questionbank.storage.impl.liferay.{ LFAnswerStorageImpl, LFQuestionCategoryStorageImpl, LFQuestionStorageImpl }
import com.arcusys.learn.questionbank.storage.{ AnswerStorage, QuestionCategoryStorage, QuestionStorage }
import com.arcusys.learn.scorm.Archivements.{ AchievementActivityStorage, AchievementRequiredStorage, AchievementStorage, AchievementUserStorage }
import com.arcusys.learn.scorm.certificating._
import com.arcusys.learn.scorm.certificating.impl._
import com.arcusys.learn.scorm.course.CourseStorage
import com.arcusys.learn.scorm.course.impl.CourseEntityStorage
import com.arcusys.learn.scorm.course.impl.liferay.LFCourseStorageImpl
import com.arcusys.learn.scorm.manifest.model.PackageGrade
import com.arcusys.learn.scorm.manifest.storage.impl.liferay.{ LFPackageScopeRuleStorageImpl, LFPackageStorageImpl }
import com.arcusys.learn.scorm.manifest.storage.impl.{ PackageScopeRuleEntityStorage, PackagesEntityStorage }
import com.arcusys.learn.scorm.manifest.storage.{ PackageScopeRuleStorage, PackagesStorage }
import com.arcusys.learn.scorm.tracking.impl.liferay.{ LFRoleStorageImpl, LFUserStorageImpl }
import com.arcusys.learn.scorm.tracking.model.sequencing._
import com.arcusys.learn.scorm.tracking.storage.impl.{ RoleEntityStorage, UserEntityStorage }
import com.arcusys.learn.scorm.tracking.storage.{ RoleStorage, UserStorage }
import com.arcusys.learn.service.util.{ SessionHandler, SessionHandlerContract }
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.setting.storage.impl.SettingEntityStorage
import com.arcusys.learn.settings.model.LFSettingStorageImpl
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.storage.impl.liferay.LFStorageFactory
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.tincan.lrsEndpoint.impl.TincanLrsEndpointEntityStorage
import com.arcusys.learn.tincan.manifest.storage.impl.liferay.{ LFTincanManifestActivityStorageImpl, LFTincanPackageStorageImpl }
import com.arcusys.learn.tincan.manifest.storage.impl.{ TincanManifestActivityEntityStorage, TincanPackageEntityStorage }
import com.arcusys.learn.tincan.manifest.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.learn.tincan.storage._
import com.arcusys.learn.tincan.storage.impl._
import com.arcusys.learn.tincan.storage.impl.liferay._
import com.arcusys.scorm.lms._
import com.escalatesoft.subcut.inject.NewBindingModule

object Configuration extends NewBindingModule({
  implicit module =>
    import module._

    bind[StorageFactoryContract] toSingle LFStorageFactory
    bind[AchievementRepositoryContract] toSingle new AchievementRepository
    bind[ActivityRepositoryContract] toSingle new ActivityRepository
    bind[ClientApiStoreManagerContract] toSingle new ClientApiStoreManager
    bind[TincanLrsEndpointStorage] toSingle new TincanLrsEndpointEntityStorage with LFLrsEndpointStorageImpl
    bind[SettingStorage] toSingle new SettingEntityStorage with LFSettingStorageImpl
    bind[RoleStorage] toSingle new RoleEntityStorage with LFRoleStorageImpl
    bind[FileStorage] toSingle new FileRecordEntityStorage with LFFileRecordStorageImpl
    bind[QuestionCategoryStorage].toSingle(new QuestionCategoryEntityStorage with LFQuestionCategoryStorageImpl)
    //bind[CertificateStorage].toSingle(new CertificateEntityStorage with LFCertificateStorageImpl)
    //bind[CertificateUserStorage].toSingle(new CertificateUserEntityStorage with LFCertificateUserStorageImpl)
    bind[SettingStorage].toSingle(new SettingEntityStorage with LFSettingStorageImpl)
    //bind[CertificateSiteStorage].toSingle(new CertificateSiteEntityStorage with LFCertificateSiteStorageImpl)
    bind[CourseStorage].toSingle(new CourseEntityStorage with LFCourseStorageImpl)
    bind[AnswerStorage].toSingle(new AnswerEntityStorage with LFAnswerStorageImpl with AnswerCreator)

    bind[MutableEntityRepository[PackageGrade]].toSingle(new PackageGradesRepository)

    bind[CertificateRepositoryContract].toSingle(new CertificateRepository)
    bind[CertificateUserRepositoryContract].toSingle(new CertificateToUserRepository)
    bind[CertificateCourseSettingsRepositoryContract].toSingle(new CertificateCourseSettingsRepository)
    bind[CertificateActivitySettingsRepositoryContract].toSingle(new CertificateActivitySettingsRepository)
    bind[CertificateStatementObjSettingsRepositoryContract].toSingle(new CertificateStatementObjSettingsRepository)

    bind[QuestionStorage].toProvider(module => new QuestionEntityStorage with LFQuestionStorageImpl with QuestionCreator {
      val answerStorage = module.inject[AnswerStorage](None)
    })
    bind[ActorStorage].toSingle(new ActorEntityStorage with LFActorStorageImpl)
    bind[TincanActivityStorage].toSingle(new TincanActivityEntityStorage with LFTincanActivityStorageImpl)
    bind[TincanManifestActivityStorage].toSingle(new TincanManifestActivityEntityStorage with LFTincanManifestActivityStorageImpl)
    bind[TincanResultStorage].toSingle(new TincanResultEntityStorage with LFTincanLrsResultStorageImpl)
    bind[StatementRefStorage].toSingle(new StatementRefEntityStorage with LFTincanLrsStatementRefStorageImpl)
    bind[SubStatementStorage].toProvider(module => new SubStatementEntityStorage with LFTincanLrsSubStatementStorageImpl {
      def actorStorage: ActorStorage = module.inject[ActorStorage](None)

      def tincanActivityStorage: TincanActivityStorage = module.inject[TincanActivityStorage](None)

      def tincanStatementRefStorage: StatementRefStorage = module.inject[StatementRefStorage](None)
    })
    bind[ContextActivitiesStorage].toSingle(new ContextActivitiesEntityStorage with LFTincanLrsContextActivitiesStorageImpl)
    bind[ContextStorage].toProvider(module => new ContextEntityStorage with LFTincanLrsContextStorageImpl {
      def actorStorage: ActorStorage = module.inject[ActorStorage](None)

      def contextActivitiesStorage: ContextActivitiesStorage = module.inject[ContextActivitiesStorage](None)
    })
    bind[AttachmentStorage].toSingle(new AttachmentEntityStorage with LFTincanLrsAttachmentStorageImpl)
    bind[StatementStorage].toProvider(module => new StatementEntityStorage with LFTincanLrsStatementStorageImpl {
      def actorStorage: ActorStorage = module.inject[ActorStorage](None)

      def tincanActivityStorage: TincanActivityStorage = module.inject[TincanActivityStorage](None)

      def resultStorage: TincanResultStorage = module.inject[TincanResultStorage](None)

      def tincanStatementRefStorage: StatementRefStorage = module.inject[StatementRefStorage](None)

      def tincanSubStatementStorage: SubStatementStorage = module.inject[SubStatementStorage](None)

      def contextStorage: ContextStorage = module.inject[ContextStorage](None)

      def attachmentStorage: AttachmentStorage = module.inject[AttachmentStorage](None)
    })
    bind[UserStorage].toSingle(new UserEntityStorage with LFUserStorageImpl)
    bind[PackageScopeRuleStorage].toSingle(new PackageScopeRuleEntityStorage with LFPackageScopeRuleStorageImpl)
    bind[PackagesStorage].toProvider(module => new PackagesEntityStorage with LFPackageStorageImpl {
      val packageScopeRuleStorage = module.inject[PackageScopeRuleStorage](None)
    })

    bind[TincanPackageStorage].toProvider(module => new TincanPackageEntityStorage with LFTincanPackageStorageImpl {
      val packageScopeRuleStorage = module.inject[PackageScopeRuleStorage](None)
    })

    bind[UserLocalServiceHelper] toSingle UserLocalServiceHelper()

    bind[CertificateFacadeContract].toSingle(new CertificateFacade)
    bind[FileFacadeContract].toSingle(new FileFacade)
    bind[RoleFacadeContract].toSingle(new RoleFacade)
    bind[CategoryFacadeContract].toSingle(new CategoryFacade)
    bind[QuestionFacadeContract].toSingle(new QuestionFacade)
    bind[GradebookFacadeContract].toSingle(new GradebookFacade)
    bind[ReportFacadeContract].toSingle(new ReportFacade)
    bind[CourseFacadeContract].toSingle(new CourseFacade)
    bind[UserFacadeContract].toSingle(new UserFacade)
    bind[PackageFacadeContract].toSingle(new PackageFacade)
    bind[QuizFacadeContract].toSingle(new QuizFacade)

    bind[AchievementStorage] toSingle LFStorageFactory.achievementStorage
    bind[AchievementRequiredStorage] toSingle LFStorageFactory.achievementRequiredStorage
    bind[AchievementActivityStorage] toSingle LFStorageFactory.achievementActivityStorage
    bind[AchievementUserStorage] toSingle LFStorageFactory.achievementUserStorage

    bind[NavigationRequestServiceContract] toSingle new NavigationRequestService
    bind[TerminationRequestServiceContract] toSingle new TerminationRequestService
    bind[SequencingRequestServiceContract] toSingle new SequencingRequestService
    bind[DeliveryRequestServiceContract] toSingle new DeliveryRequestService
    bind[RollupServiceContract] toSingle new RollupService
    bind[EndAttemptServiceContract] toSingle new EndAttemptService

    bind[SessionHandlerContract] toSingle SessionHandler

    bind[StorageManagerContract].toSingle(new StorageManager)

    bind[MessageTemplateLoader].toSingle(ResourceTemplateLoader)
})