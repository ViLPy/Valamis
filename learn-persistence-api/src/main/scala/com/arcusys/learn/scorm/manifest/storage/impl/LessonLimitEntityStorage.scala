package com.arcusys.learn.scorm.manifest.storage.impl

import com.arcusys.learn.scorm.manifest.model.LessonType.LessonType
import com.arcusys.learn.scorm.manifest.storage.LessonLimitStorage
import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.manifest.model.LessonLimit
import scala.Predef._

/**
 * User: dkudinov
 * Date: 3.4.2013
 */
@deprecated
trait LessonLimitEntityStorage extends LessonLimitStorage with EntityStorageExt[LessonLimit] {

  def getByID(itemID: Int, itemType: LessonType): Option[LessonLimit] = getOne("itemID" -> itemID, "itemType" -> itemType.toString)

}
