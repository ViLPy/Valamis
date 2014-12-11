package com.arcusys.learn.scorm.manifest.storage.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFLessonLimit
import com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil
import com.arcusys.learn.scorm.manifest.model.LessonType.LessonType
import com.arcusys.learn.scorm.manifest.model.{ PeriodType, LessonType, LessonLimit }
import com.arcusys.learn.scorm.manifest.storage.LessonLimitStorage

import scala.util.Try

/**
 * Created by igorborisov on 23.10.14.
 */
class LessonLimitRepositoryImpl extends LessonLimitStorage {
  override def getByID(itemID: Int, itemType: LessonType): Option[LessonLimit] =
    Try(LFLessonLimitLocalServiceUtil.findByID(itemID.toLong, itemType.toString)).toOption map extract

  private def extract(lfLessonLimit: LFLessonLimit): LessonLimit = {
    val rerunInterval = lfLessonLimit.getRerunInterval
    val rerunIntervalType = lfLessonLimit.getRerunIntervalType
    LessonLimit(
      lfLessonLimit.getItemID.toInt,
      LessonType.withName(lfLessonLimit.getItemType),
      lfLessonLimit.getPassingLimit,
      if (rerunInterval == null) 0 else rerunInterval, // Default value for rerun interval
      if (rerunIntervalType == null) PeriodType.UNLIMITED else PeriodType.withName(rerunIntervalType)
    )
  }

}
