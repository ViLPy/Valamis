package com.arcusys.learn.ioc

import com.arcusys.valamis.certificate.repository.{ActivityGoalStorageImpl, CertificateRepositoryImpl, CourseGoalStorageImpl, PackageGoalStorageImpl, _}
import com.arcusys.valamis.certificate.storage.{ActivityGoalStorage, CertificateRepository, CourseGoalStorage, PackageGoalStorage, _}
import com.arcusys.valamis.core.SlickDBInfo
import com.arcusys.valamis.file.FileRepositoryImpl
import com.arcusys.valamis.file.storage.FileStorage
import com.arcusys.valamis.lesson.PackageCategoryGoalStorageImpl
import com.arcusys.valamis.lesson.tincan.storage.PackageCategoryGoalStorage
import com.arcusys.valamis.lrs.TokenRepositoryImpl
import com.arcusys.valamis.lrsEndpoint.storage.LrsTokenStorage
import com.arcusys.valamis.social.repository.{CommentRepositoryImpl, LikeRepositoryImpl}
import com.arcusys.valamis.social.storage.{CommentRepository, LikeRepository}
import com.escalatesoft.subcut.inject.NewBindingModule

class PersistenceSlickConfiguration(dbInfo: => SlickDBInfo) extends NewBindingModule({
  implicit module =>
    import module._

    // we need bind here because binds in parent module not available here
    bind[SlickDBInfo].toSingle(dbInfo)

    bind[FileStorage].toSingle {
      new FileRepositoryImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[LrsTokenStorage].toSingle {
      new TokenRepositoryImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[CourseGoalStorage].toSingle {
      new CourseGoalStorageImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[PackageGoalStorage].toSingle {
      new PackageGoalStorageImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[ActivityGoalStorage].toSingle {
      new ActivityGoalStorageImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[StatementGoalStorage].toSingle {
      new StatementGoalStorageImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[CertificateRepository].toSingle {
      new CertificateRepositoryImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[CertificateStateRepository].toSingle {
      new CertificateStateRepositoryImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[CommentRepository].toSingle {
      new CommentRepositoryImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[LikeRepository].toSingle {
      new LikeRepositoryImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[PackageGoalStorage].toSingle {
      new PackageGoalStorageImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }

    bind[PackageCategoryGoalStorage].toSingle{
      new PackageCategoryGoalStorageImpl(dbInfo.databaseDef, dbInfo.slickProfile)
    }
})