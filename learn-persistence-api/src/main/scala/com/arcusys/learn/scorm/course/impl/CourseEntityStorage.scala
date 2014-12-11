package com.arcusys.learn.scorm.course.impl

import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.tracking.model.CourseGrade
import com.arcusys.learn.scorm.course.CourseStorage

/**
 * Created with IntelliJ IDEA.
 * User: Yulia.Glushonkova
 * Date: 26.03.13
 */
@deprecated
trait CourseEntityStorage extends CourseStorage with EntityStorageExt[CourseGrade] {
  def get(courseId: Int, userID: Int): Option[CourseGrade] = getOne("courseID" -> courseId, "userID" -> userID)
}
