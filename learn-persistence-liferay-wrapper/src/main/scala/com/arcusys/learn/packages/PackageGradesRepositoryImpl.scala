package com.arcusys.learn.packages

import com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage
import com.arcusys.learn.persistence.liferay.service._
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageGradeStoragePK
import com.arcusys.valamis.gradebook.model.PackageGrade
import com.arcusys.valamis.gradebook.storage.PackageGradesStorage
import org.joda.time.DateTime

class PackageGradesRepositoryImpl extends PackageGradesStorage {
  override def get(userId: Long, packageId: Long): Option[PackageGrade] = {
    val primaryKey = new LFPackageGradeStoragePK(userId, packageId)
    Option(LFPackageGradeStorageLocalServiceUtil.fetchLFPackageGradeStorage(primaryKey)).map(export)
  }

  override def delete(userId: Long, packageId: Long): Unit = {
    val primaryKey = new LFPackageGradeStoragePK(userId, packageId)
    LFPackageGradeStorageLocalServiceUtil.deleteLFPackageGradeStorage(primaryKey)
  }

  override def modify(entity: PackageGrade): PackageGrade = {
    val storageEntity = LFPackageGradeStorageLocalServiceUtil.findGrade(entity.userId, entity.packageId)

    storageEntity.setComment(entity.comment)
    storageEntity.setGrade(entity.grade)

    val updatedEntity = LFPackageGradeStorageLocalServiceUtil.updateLFPackageGradeStorage(storageEntity)

    export(updatedEntity)
  }

  override def create(entity: PackageGrade): PackageGrade = {
    val packageGradeStorage = LFPackageGradeStorageLocalServiceUtil
      .createLFPackageGradeStorage(new LFPackageGradeStoragePK(entity.userId, entity.packageId))

    packageGradeStorage.setComment(entity.comment)
    packageGradeStorage.setGrade(entity.grade)
    packageGradeStorage.setDate(DateTime.now().toDate)

    val addedPackageGradeStorage = LFPackageGradeStorageLocalServiceUtil.addLFPackageGradeStorage(packageGradeStorage)
    export(addedPackageGradeStorage)
  }

  private def export(lfEntity: LFPackageGradeStorage) = {
    PackageGrade(
      lfEntity.getUserId,
      lfEntity.getPackageId,
      lfEntity.getGrade,
      lfEntity.getComment,
      Option(lfEntity.getDate).map(new DateTime(_))
    )
  }
}
