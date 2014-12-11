package com.arcusys.learn.storage

import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.scorm.tracking.storage._
import com.arcusys.learn.quiz.storage._
import com.arcusys.learn.questionbank.storage._
import com.arcusys.learn.scorm.tracking.states.storage.{ ActivityStateStorage, ActivityStateTreeStorage }
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.scorm.course.{ PlayerScopeRuleStorage, CourseStorage }
import com.arcusys.learn.social.storage.{ PackageCommentStorage, PackageVoteStorage, SocialPackageStorage }
import com.arcusys.learn.setting.storage.{ LRSToActivitySettingStorage, SiteDependentSettingStorage, SettingStorage }
import com.arcusys.learn.tincan.manifest.storage.{ TincanManifestActivityStorage, TincanPackageStorage }
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.scorm.Archivements.{ AchievementUserStorage, AchievementRequiredStorage, AchievementActivityStorage, AchievementStorage }
import com.arcusys.learn.tincan.storage._

trait StorageFactoryContract {
  def tincanLrsEndpointStorage: TincanLrsEndpointStorage
  def tincanPackageStorage: TincanPackageStorage
  @deprecated
  def tincanActivityStorage: TincanManifestActivityStorage
  def tincanClientApiStorage: TincanClientApiStorage

  def tincanLrsStatementRefStorage: StatementRefStorage
  def tincanLrsContextActivitiesStorage: ContextActivitiesStorage
  def tincanLrsStatementStorage: StatementStorage
  def tincanLrsSubStatementStorage: SubStatementStorage
  def tincanLrsAttachmentStorage: AttachmentStorage
  def tincanLrsStateStorage: StateStorage
  def tincanLrsResultStorage: TincanResultStorage
  def tincanLrsContextStorage: ContextStorage
  def tincanLrsActorStorage: ActorStorage
  def tincanLrsDocumentStorage: DocumentStorage
  def tincanLrsActivityStorage: TincanActivityStorage
  def tincanLrsActivityProfileStorage: ActivityProfileStorage
  def tincanLrsAgentProfileStorage: AgentProfileStorage
  @deprecated
  def packageStorage: ScormPackagesStorage
  @deprecated
  def activityStorage: ActivityStorage
  @deprecated
  def resourceStorage: ResourcesStorage

  @deprecated
  def questionCategoryStorage: QuestionCategoryStorage
  @deprecated
  def questionStorage: QuestionStorage

  def quizStorage: QuizStorage
  def quizTreeStorage: QuizTreeStorage

  def quizQuestionCategoryStorage: QuizQuestionCategoryStorage

  def quizQuestionStorage: QuizQuestionStorage

  def attemptStorage: AttemptStorage

  def dataModelStorage: DataModelStorage

  def userStorage: UserStorage

  def activityStateTreeStorage: ActivityStateTreeStorage

  def activityStateStorage: ActivityStateStorage

  def fileStorage: FileStorage

  @deprecated
  def courseStorage: CourseStorage

  @deprecated
  def packageScopeRuleStorage: PackageScopeRuleStorage

  @deprecated
  def playerScopeRuleStorage: PlayerScopeRuleStorage

  def achievementStorage: AchievementStorage
  def achievementActivityStorage: AchievementActivityStorage
  def achievementRequiredStorage: AchievementRequiredStorage
  def achievementUserStorage: AchievementUserStorage

  def socialPackageStorage: SocialPackageStorage
  def packageCommentStorage: PackageCommentStorage
  def packageVoteStorage: PackageVoteStorage

  def roleStorage: RoleStorage
  def settingStorage: SettingStorage
  def siteDependentSettingStorage: SiteDependentSettingStorage

  def lrsToActivitySettingStorage: LRSToActivitySettingStorage

  def renewWholeStorage() {
    packageStorage.renew()
    activityStorage.renew()
    resourceStorage.renew()
    //    questionCategoryStorage.renew()
    //    questionStorage.renew()
    quizStorage.renew()
    quizQuestionCategoryStorage.renew()
    quizQuestionStorage.renew()
    userStorage.renew()
    attemptStorage.renew()
    dataModelStorage.renew()
    activityStateTreeStorage.renew()
    fileStorage.renew()
    courseStorage.renew()
    packageScopeRuleStorage.renew()
    playerScopeRuleStorage.renew()
    socialPackageStorage.renew()
    packageCommentStorage.renew()
    packageVoteStorage.renew()
    roleStorage.renew()
    settingStorage.renew()
    achievementStorage.renew()
    achievementActivityStorage.renew()
    achievementRequiredStorage.renew()
    achievementUserStorage.renew()

    tincanLrsEndpointStorage.renew()
    tincanPackageStorage.renew()
    tincanActivityStorage.renew()
    //tincanClientApiStorage.renew()
    tincanLrsStatementRefStorage.renew()
    tincanLrsContextActivitiesStorage.renew()
    tincanLrsStatementStorage.renew()
    tincanLrsSubStatementStorage.renew()
    tincanLrsAttachmentStorage.renew()
    tincanLrsStateStorage.renew()
    tincanLrsResultStorage.renew()
    tincanLrsContextStorage.renew()
    tincanLrsActorStorage.renew()
    tincanLrsDocumentStorage.renew()
    tincanLrsActivityStorage.renew()
    tincanLrsActivityProfileStorage.renew()

    siteDependentSettingStorage.renew()
    lrsToActivitySettingStorage.renew()
  }
}
