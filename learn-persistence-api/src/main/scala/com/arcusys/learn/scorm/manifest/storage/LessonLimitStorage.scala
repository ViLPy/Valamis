package com.arcusys.learn.scorm.manifest.storage

import com.arcusys.learn.scorm.manifest.model.LessonLimit
import com.arcusys.learn.scorm.manifest.model.LessonType._

trait LessonLimitStorage {
  def getByID(itemID: Int, itemType: LessonType): Option[LessonLimit]
}
