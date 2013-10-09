package com.arcusys.learn.storage

import com.arcusys.learn.scorm.manifest.storage._
import com.arcusys.learn.scorm.tracking.storage._
import com.arcusys.learn.quiz.storage._
import com.arcusys.learn.questionbank.storage._
import com.arcusys.learn.scorm.tracking.states.storage.{ActivityStateStorage, ActivityStateTreeStorage}
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.scorm.course.{PlayerScopeRuleStorage, CourseStorage}
import com.arcusys.learn.scorm.certificating.{CertificateSiteStorage, CertificateStorage}
import com.arcusys.learn.social.storage.{PackageCommentStorage, PackageVoteStorage, SocialPackageStorage}
import com.arcusys.learn.scorm.certificating.{CertificateUserStorage, CertificateSiteStorage, CertificateStorage}
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.tincan.manifest.storage.{TincanActivityStorage, TincanPackageStorage}
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage

trait StorageFactoryContract {
  def tincanLrsEndpointStorage: TincanLrsEndpointStorage
  def tincanPackageStorage: TincanPackageStorage
  def tincanActivityStorage: TincanActivityStorage

  def packageStorage: PackagesStorage

  def activityStorage: ActivitiesStorage

  //def organizationStorage: OrganizationsStorage
  def resourceStorage: ResourcesStorage

  def questionCategoryStorage: QuestionCategoryStorage

  def questionStorage: QuestionStorage

  def quizStorage: QuizStorage

  def quizQuestionCategoryStorage: QuizQuestionCategoryStorage

  def quizQuestionStorage: QuizQuestionStorage

  def attemptStorage: AttemptStorage

  def dataModelStorage: DataModelStorage

  def userStorage: UserStorage

  def activityStateTreeStorage: ActivityStateTreeStorage

  def activityStateStorage: ActivityStateStorage

  def fileStorage: FileStorage

  def courseStorage: CourseStorage

  def packageScopeRuleStorage: PackageScopeRuleStorage

  def playerScopeRuleStorage: PlayerScopeRuleStorage

  def certificateStorage: CertificateStorage

  def certificateSiteStorage: CertificateSiteStorage

  def certificateUserStorage: CertificateUserStorage

  def socialPackageStorage: SocialPackageStorage
  def packageCommentStorage: PackageCommentStorage
  def packageVoteStorage: PackageVoteStorage

  def roleStorage: RoleStorage
  def settingStorage: SettingStorage

  def renewWholeStorage() {
    packageStorage.renew()
    //organizationStorage.asInstanceOf[OrganizationsStorageImpl].renew()
    activityStorage.renew()
    resourceStorage.renew()
    questionCategoryStorage.renew()
    questionStorage.renew()
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
    certificateStorage.renew()
    certificateSiteStorage.renew()
    socialPackageStorage.renew()
    packageCommentStorage.renew()
    packageVoteStorage.renew()
    certificateUserStorage.renew()
    roleStorage.renew()
    settingStorage.renew()

    tincanActivityStorage.renew()
    tincanPackageStorage.renew()
    tincanLrsEndpointStorage.renew()
  }
}
