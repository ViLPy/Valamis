package com.arcusys.valamis.lesson.service.extract

import com.arcusys.valamis.lesson.model.LessonType._
import com.arcusys.valamis.lesson.model.{ LessonLimit, LessonType, PackageScopeRule }
import com.arcusys.valamis.lesson.scorm.model.ScormPackage
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.lesson.storage.LessonLimitStorage
import com.arcusys.valamis.lesson.tincan.model.{ TincanManifest, TincanPackage }
import com.arcusys.valamis.model.PeriodTypes

/**
 * Created by mminin on 06.03.15.
 */
trait ManifestExtract {

  protected def lessonLimitStorage: LessonLimitStorage

  private def getLessonLimitOrDefault(packageId: Long, itemType: LessonType) = {
    lessonLimitStorage.getByID(packageId, itemType)
      .getOrElse(LessonLimit(packageId.toInt, itemType, 0, 0, PeriodTypes.UNLIMITED))
  }

  protected def toTincanManifest(tincanPackage: TincanPackage): TincanManifest = {
    toTincanManifest(tincanPackage, None)
  }

  protected def toTincanManifest(tincanPackage: TincanPackage, lessonLimit: LessonLimit): TincanManifest = {
    toTincanManifest(tincanPackage, None, lessonLimit)
  }

  protected def toTincanManifest(tincanPackage: TincanPackage, scopeRule: Option[PackageScopeRule]): TincanManifest = {
    val lessonLimit = getLessonLimitOrDefault(tincanPackage.id, LessonType.Tincan)
    toTincanManifest(tincanPackage, scopeRule, lessonLimit)
  }

  protected def toTincanManifest(tincanPackage: TincanPackage, scopeRule: Option[PackageScopeRule], lessonLimit: LessonLimit): TincanManifest = {
    TincanManifest(
      tincanPackage.id.toInt,
      tincanPackage.title,
      tincanPackage.summary,
      tincanPackage.courseID,
      tincanPackage.assetRefId,
      scopeRule.map(_.visibility),
      tincanPackage.logo,
      scopeRule.exists(_.isDefault), // false by default
      lessonLimit.passingLimit,
      lessonLimit.rerunInterval,
      lessonLimit.rerunIntervalType,
      tincanPackage.beginDate,
      tincanPackage.endDate
    )
  }

  protected def toScormManifest(scormPackage: ScormPackage): Manifest = {
    toScormManifest(scormPackage, None)
  }

  protected def toScormManifest(scormPackage: ScormPackage, lessonLimit: LessonLimit): Manifest = {
    toScormManifest(scormPackage, None, lessonLimit)
  }

  protected def toScormManifest(scormPackage: ScormPackage, scopeRule: Option[PackageScopeRule]): Manifest = {
    val lessonLimit = getLessonLimitOrDefault(scormPackage.id, LessonType.Scorm)
    toScormManifest(scormPackage, scopeRule, lessonLimit)
  }

  protected def toScormManifest(scormPackage: ScormPackage, scopeRule: Option[PackageScopeRule], lessonLimit: LessonLimit): Manifest = {
    new Manifest(
      scormPackage.id.toInt,
      scormPackage.version,
      scormPackage.base,
      scormPackage.scormVersion,
      scormPackage.defaultOrganizationID,
      scormPackage.resourcesBase,
      scormPackage.title,
      scormPackage.summary,
      scormPackage.metadata,
      scormPackage.assetRefId,
      scormPackage.courseID,
      scopeRule.map(_.visibility),
      scormPackage.logo,
      scopeRule.exists(_.isDefault), // false by default
      lessonLimit.passingLimit,
      lessonLimit.rerunInterval,
      lessonLimit.rerunIntervalType,
      scormPackage.beginDate,
      scormPackage.endDate
    )
  }
}
