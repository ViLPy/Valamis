package com.arcusys.learn.ioc

import com.escalatesoft.subcut.inject.NewBindingModule
import com.arcusys.learn.storage.StorageFactoryContract
import com.arcusys.learn.scorm.tracking.model.sequencing._
import com.arcusys.learn.storage.impl.liferay.LFStorageFactory
import com.arcusys.scorm.lms._
import com.arcusys.learn.scorm.Archivements.{AchievementUserStorage, AchievementActivityStorage, AchievementRequiredStorage, AchievementStorage}
import com.arcusys.learn.service.util.{SessionHandlerContract, SessionHandler}
import com.arcusys.learn.tincan.lrsEndpoint.TincanLrsEndpointStorage
import com.arcusys.learn.tincan.lrsEndpoint.impl.TincanLrsEndpointEntityStorage
import com.arcusys.learn.tincan.storage.impl.liferay.LFLrsEndpointStorageImpl

object Configuration extends NewBindingModule({
  implicit module =>
    import module._
    bind[StorageFactoryContract] toSingle LFStorageFactory
    bind[AchievementRepositoryContract] toSingle new AchievementRepository
    bind[ActivityRepositoryContract] toSingle new ActivityRepository
    bind[ClientApiStoreManagerContract] toSingle new ClientApiStoreManager
    bind[TincanLrsEndpointStorage] toSingle new TincanLrsEndpointEntityStorage with LFLrsEndpointStorageImpl

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
})