package com.arcusys.learn.test.mocks

import com.escalatesoft.subcut.inject.NewBindingModule
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.tracking.model.sequencing._
import com.arcusys.learn.storage.impl.liferay.LFStorageFactory
import com.arcusys.scorm.lms._
import com.arcusys.learn.scorm.Archivements.{ AchievementUserStorage, AchievementActivityStorage, AchievementRequiredStorage, AchievementStorage }
import com.arcusys.learn.scorm.Archivements.impl.{ AchievementUserEntityStorage, AchievementActivityEntityStorage, AchievementRequiredEntityStorage, AchievementEntityStorage }
import com.arcusys.learn.scorm.achievements.{ LFAchievementUserStorageImpl, LFAchievementActivityStorageImpl, LFAchievementRequiredStorageImpl, LFAchievementStorageImpl }
import com.arcusys.learn.scorm.Archivements.{ AchievementUserStorage, AchievementActivityStorage, AchievementRequiredStorage, AchievementStorage }
import com.arcusys.learn.scorm.Archivements.impl.{ AchievementUserEntityStorage, AchievementActivityEntityStorage, AchievementRequiredEntityStorage, AchievementEntityStorage }
import com.arcusys.learn.scorm.achievements.{ LFAchievementUserStorageImpl, LFAchievementActivityStorageImpl, LFAchievementRequiredStorageImpl, LFAchievementStorageImpl }
import com.arcusys.learn.scorm.certificating.{ CertificateSiteStorage, CertificateUserStorage, CertificateStorage }
import com.arcusys.learn.setting.storage.SettingStorage
import com.arcusys.learn.scorm.course.CourseStorage
import com.arcusys.learn.liferay.services.UserLocalServiceHelper
import com.arcusys.learn.mocks.Mocks
import com.arcusys.learn.filestorage.storage.FileStorage
import com.arcusys.learn.service.util.SessionHandlerContract
import com.arcusys.learn.facades.{ FileFacadeContract, CertificateFacadeContract }

/**
 * Created by Iliya Tryapitsin on 14.03.14.
 */

object MockConfiguration extends NewBindingModule(implicit module => {
  import module._

  bind[UserLocalServiceHelper] toSingle Mocks.userLocalServiceHelper
  bind[CourseStorage] toSingle Mocks.courseStorage
  bind[CertificateSiteStorage] toSingle Mocks.certificateSiteStorage
  bind[SettingStorage] toSingle Mocks.settingStorage
  bind[CertificateUserStorage] toSingle Mocks.certificateUserStorage
  bind[CertificateStorage] toSingle Mocks.certificateStorage
  module.bind[FileStorage] toSingle Mocks.fileStorage
  module.bind[SessionHandlerContract] toSingle Mocks.sessionHandlerContract
  module.bind[StorageFactoryContract] toSingle Mocks.storageFactory
  bind[CertificateFacadeContract].toSingle(Mocks.certificateFacadeContract)
  bind[FileFacadeContract].toSingle(Mocks.fileFacadeContract)

  bind[StorageFactoryContract] toSingle LFStorageFactory
  bind[ActivityRepositoryContract] toSingle new ActivityRepository

  bind[AchievementStorage] toSingle new AchievementEntityStorage with LFAchievementStorageImpl
  bind[AchievementRequiredStorage] toSingle new AchievementRequiredEntityStorage with LFAchievementRequiredStorageImpl
  bind[AchievementActivityStorage] toSingle new AchievementActivityEntityStorage with LFAchievementActivityStorageImpl
  bind[AchievementUserStorage] toSingle new AchievementUserEntityStorage with LFAchievementUserStorageImpl

  bind[NavigationRequestServiceContract] toSingle new NavigationRequestService
  bind[TerminationRequestServiceContract] toSingle new TerminationRequestService
  bind[SequencingRequestServiceContract] toSingle new SequencingRequestService
  bind[DeliveryRequestServiceContract] toSingle new DeliveryRequestService
  bind[RollupServiceContract] toSingle new RollupService
  bind[EndAttemptServiceContract] toSingle new EndAttemptService
})