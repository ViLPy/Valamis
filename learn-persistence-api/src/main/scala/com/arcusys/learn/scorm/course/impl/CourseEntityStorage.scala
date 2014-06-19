package com.arcusys.learn.scorm.course.impl

import com.arcusys.learn.storage.impl.EntityStorageExt
import com.arcusys.learn.scorm.tracking.model.Course
import com.arcusys.learn.scorm.course.CourseStorage

/**
 * Created with IntelliJ IDEA.
 * User: Yulia.Glushonkova
 * Date: 26.03.13
 */
trait CourseEntityStorage extends CourseStorage with EntityStorageExt[Course] {
  def get(courseId: Int, userID: Int): Option[Course] = getOne("courseID" -> courseId, "userID" -> userID)
}
