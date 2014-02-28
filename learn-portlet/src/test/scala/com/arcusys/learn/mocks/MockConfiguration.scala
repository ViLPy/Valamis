package com.arcusys.learn.test.mocks

import com.escalatesoft.subcut.inject.NewBindingModule
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.tracking.model.sequencing._
import com.arcusys.learn.storage.impl.liferay.LFStorageFactory
import com.arcusys.scorm.lms._
import com.arcusys.learn.scorm.Archivements.{AchievementUserStorage, AchievementActivityStorage, AchievementRequiredStorage, AchievementStorage}
import com.arcusys.learn.scorm.Archivements.impl.{AchievementUserEntityStorage, AchievementActivityEntityStorage, AchievementRequiredEntityStorage, AchievementEntityStorage}
import com.arcusys.learn.scorm.achievements.{LFAchievementUserStorageImpl, LFAchievementActivityStorageImpl, LFAchievementRequiredStorageImpl, LFAchievementStorageImpl}

object MockConfiguration extends NewBindingModule({
  implicit module =>
    import module._

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