package com.arcusys.valamis.lesson.service.extract

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.valamis.lesson.model.{ PackageState, ValamisPackage, LessonType }
import com.arcusys.valamis.lesson.scorm.model.manifest.Manifest
import com.arcusys.valamis.lesson.scorm.storage.tracking.{ ActivityStateTreeStorage, AttemptStorage }
import com.arcusys.valamis.lesson.service.{ LessonLimitChecker, TagServiceContract }
import com.arcusys.valamis.lesson.tincan.model.TincanManifest
import com.arcusys.valamis.lrs.api.StatementApi

/**
 * Created by mminin on 06.03.15.
 */
trait ValamisPackageExtract {

  protected def tagService: TagServiceContract
  protected def passingLimitChecker: LessonLimitChecker
  protected def attemptStorage: AttemptStorage
  protected def activityStateTreeStorage: ActivityStateTreeStorage

  protected def toValamisPackage(manifest: TincanManifest, user: LUser, statementApi: StatementApi): ValamisPackage = {
    val isFinished = passingLimitChecker.isTincanPackageFinished(user, manifest.id, statementApi)
    val attemptsCount = passingLimitChecker.getTincanAttemptsCount(user, manifest.id, statementApi)

    val packageState = if (isFinished) PackageState.Finished
    else if (attemptsCount > 0) PackageState.Attempted
    else PackageState.None

    ValamisPackage(manifest.id,
      manifest.title,
      manifest.summary.map(_.replaceAll("\n", "")),
      Some(""),
      manifest.visibility.getOrElse(false),
      manifest.isDefault,
      LessonType.Tincan,
      manifest.logo,
      None,
      manifest.passingLimit,
      manifest.rerunInterval,
      manifest.rerunIntervalType,
      attemptsCount,
      packageState,
      manifest.assetRefId.map(tagService.getEntryTags).getOrElse(Seq()),
      manifest.beginDate,
      manifest.endDate
    )
  }

  protected def toValamisPackage(manifest: Manifest, user: LUser, statementApi: StatementApi) = {
    val userId = user.getUserId.toInt
    val isFinished = passingLimitChecker.isTincanPackageFinished(user, manifest.id, statementApi)
    val attempt = attemptStorage.getActive(userId, manifest.id.toInt)
    val activityId = if (attempt.isDefined) {
      activityStateTreeStorage.get(attempt.get.id).map(_.item.activity.id)
    } else None

    val attemptsCount = passingLimitChecker.getScormAttemptsCount(userId, manifest.id)
    val packageState = if (isFinished) PackageState.Finished
    else if (attemptsCount > 0) PackageState.Attempted
    else PackageState.None

    ValamisPackage(manifest.id,
      manifest.title,
      manifest.summary.map(_.replaceAll("\n", "")),
      manifest.version,
      manifest.visibility.getOrElse(false),
      manifest.isDefault,
      LessonType.Scorm,
      manifest.logo,
      activityId,
      manifest.passingLimit,
      manifest.rerunInterval,
      manifest.rerunIntervalType,
      attemptsCount,
      packageState,
      manifest.assetRefId.map(tagService.getEntryTags).getOrElse(Seq()),
      manifest.beginDate,
      manifest.endDate
    )
  }
}
