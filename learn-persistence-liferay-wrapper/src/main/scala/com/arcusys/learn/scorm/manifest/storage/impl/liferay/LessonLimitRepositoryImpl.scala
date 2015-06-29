package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.valamis.lesson.storage.LessonLimitStorage
import com.arcusys.valamis.model.PeriodTypes
import PeriodTypes._
import com.arcusys.learn.persistence.liferay.model.LFLessonLimit
import com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK
import com.arcusys.valamis.lesson.model.{ LessonLimit, LessonType }
import LessonType._
import com.arcusys.valamis.model.PeriodTypes

import scala.collection.JavaConverters._

/**
 * Created by igorborisov on 23.10.14.
 */
class LessonLimitRepositoryImpl extends LessonLimitStorage {
  override def getByID(packageId: Long, itemType: LessonType): Option[LessonLimit] = {
    val key = new LFLessonLimitPK(packageId, itemType.toString)
    Option(LFLessonLimitLocalServiceUtil.fetchLFLessonLimit(key)) map extract
  }

  override def getByIDs(itemIDs: Seq[Long]): Seq[LessonLimit] = {
    if (itemIDs.isEmpty) Seq()
    else LFLessonLimitLocalServiceUtil.findByIDs(itemIDs.toArray.map(i => i: java.lang.Long)).asScala.map(extract)
  }

  override def setLimit(packageId: Long, packageType: LessonType, passingLimit: Int, rerunInterval: Int, rerunIntervalType: PeriodType): LessonLimit = {
    val key = new LFLessonLimitPK(packageId, packageType.toString)

    val limitEntity = Option(
      LFLessonLimitLocalServiceUtil.fetchLFLessonLimit(key)
    ).getOrElse(
        LFLessonLimitLocalServiceUtil.createLFLessonLimit(key)
      )

    limitEntity.setPassingLimit(passingLimit)
    limitEntity.setRerunInterval(rerunInterval)
    limitEntity.setRerunIntervalType(rerunIntervalType.toString)

    val lessonLimit = LFLessonLimitLocalServiceUtil.updateLFLessonLimit(limitEntity)

    extract(lessonLimit)
  }

  private def extract(lfLessonLimit: LFLessonLimit): LessonLimit = {
    val rerunInterval = lfLessonLimit.getRerunInterval
    val rerunIntervalType = lfLessonLimit.getRerunIntervalType
    LessonLimit(
      lfLessonLimit.getItemID.toInt,
      LessonType.withName(lfLessonLimit.getItemType),
      lfLessonLimit.getPassingLimit,
      if (rerunInterval == null) 0 else rerunInterval, // Default value for rerun interval
      if (rerunIntervalType == null) PeriodTypes.UNLIMITED else PeriodTypes.withName(rerunIntervalType)
    )
  }

}
