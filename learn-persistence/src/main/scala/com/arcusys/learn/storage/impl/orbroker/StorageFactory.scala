package com.arcusys.learn.storage.impl.orbroker

import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.scorm.manifest.storage.impl.orbroker._
import com.arcusys.learn.scorm.tracking.storage._
import com.arcusys.learn.scorm.tracking.storage.impl.orbroker._
import com.arcusys.learn.quiz.storage._
import com.arcusys.learn.quiz.storage.impl.orbroker._
import com.arcusys.learn.questionbank.storage._
import com.arcusys.learn.questionbank.storage.impl.orbroker._
import com.arcusys.scorm.util.PropertyUtil
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.tracking.states.storage.impl.orbroker.{ActivityStateStorageImpl, ActivityStateTreeStorageImpl}
import com.arcusys.learn.scorm.tracking.states.storage.{ActivityStateStorage, ActivityStateTreeStorage}
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.filestorage.storage.impl.orbroker.FileStorageImpl
import com.arcusys.learn.scorm.course.impl.orbroker.{PlayerScopeRuleStorageImpl, CourseStorageImpl}
import com.arcusys.learn.scorm.course.{PlayerScopeRuleStorage, CourseStorage}
import com.arcusys.learn.updater.StorageUpdater
import com.arcusys.learn.updater.impl.orbroker.StorageUpdaterImpl
import com.arcusys.learn.social.storage.{PackageVoteStorage, PackageCommentStorage, SocialPackageStorage}
import com.arcusys.learn.scorm.certificating.{CertificateUserStorage, CertificateSiteStorage, CertificateStorage}
import com.arcusys.learn.tincan.manifest.storage.{TincanManifestActivityStorage, TincanPackageStorage}
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.tincan.storage._

object StorageFactory extends StorageFactoryContract {
  val initBroker = {
    if (!BrokerFactory.isInitialized) BrokerFactory.init(PropertyUtil.load("db"))
  }

  lazy val tincanLrsEndpointStorage: TincanLrsEndpointStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanPackageStorage: TincanPackageStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanActivityStorage: TincanManifestActivityStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsStatementRefStorage: StatementRefStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsContextActivitiesStorage: ContextActivitiesStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsStatementStorage: StatementStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsSubStatementStorage: SubStatementStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsAttachmentStorage: AttachmentStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsStateStorage : StateStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsResultStorage: TincanResultStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsContextStorage: ContextStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsActorStorage: ActorStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsDocumentStorage: DocumentStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsActivityStorage : TincanActivityStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsActivityProfileStorage : ActivityProfileStorage = throw new UnsupportedOperationException("Storage not implemented for orbroker storage")
  lazy val tincanLrsAgentProfileStorage: AgentProfileStorage = throw new UnsupportedOperationException("Storage not implemented for LFStorages")
  lazy val packageStorage: PackagesStorage = new PackagesStorageImpl
  lazy val activityStorage: ActivitiesStorage = new ActivitiesStorageImpl
  //lazy val organizationStorage: OrganizationsStorage = new OrganizationsStorageImpl
  lazy val resourceStorage: ResourcesStorage = new ResourcesStorageImpl
  lazy val questionCategoryStorage: QuestionCategoryStorage = new QuestionCategoryStorageImpl
  lazy val questionStorage: QuestionStorage = new QuestionStorageImpl
  lazy val quizStorage: QuizStorage = new QuizStorageImpl
  lazy val quizQuestionCategoryStorage: QuizQuestionCategoryStorage = new QuizQuestionCategoryStorageImpl
  lazy val quizQuestionStorage: QuizQuestionStorage = new QuizQuestionStorageImpl
  lazy val attemptStorage: AttemptStorage = new AttemptStorageImpl
  lazy val dataModelStorage: DataModelStorage = new DataModelStorageImpl
  lazy val userStorage: UserStorage = new UserStorageImpl
  lazy val activityStateTreeStorage: ActivityStateTreeStorage = new ActivityStateTreeStorageImpl
  lazy val activityStateStorage: ActivityStateStorage = new ActivityStateStorageImpl
  lazy val fileStorage: FileStorage = new FileStorageImpl
  lazy val courseStorage: CourseStorage = new CourseStorageImpl
  lazy val packageScopeRuleStorage: PackageScopeRuleStorage = new PackageScopeRuleStorageImpl
  lazy val playerScopeRuleStorage: PlayerScopeRuleStorage = new PlayerScopeRuleStorageImpl
  lazy val storageUpdater: StorageUpdater = new StorageUpdaterImpl
  lazy val certificateStorage: CertificateStorage = throw new UnsupportedOperationException
  lazy val certificateSiteStorage: CertificateSiteStorage = throw new UnsupportedOperationException
  lazy val certificateUserStorage: CertificateUserStorage = throw new UnsupportedOperationException
  lazy val socialPackageStorage: SocialPackageStorage = throw new UnsupportedOperationException
  lazy val packageCommentStorage: PackageCommentStorage = throw new UnsupportedOperationException
  lazy val packageVoteStorage: PackageVoteStorage = throw new UnsupportedOperationException

  lazy val roleStorage: RoleStorage = throw new UnsupportedOperationException
  lazy val settingStorage: SettingStorage = throw new UnsupportedOperationException
  def dbType = BrokerFactory.dbType
}
