package com.arcusys.learn.scorm.course.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import org.orbroker.{Token, Row}
import com.arcusys.learn.scorm.course.CourseStorage
import com.arcusys.learn.scorm.tracking.model.Course

class CourseStorageImpl extends GenericEntityStorageImpl[Course]("Course") with CourseStorage {

  def get(courseID: Int, userID: Int) = getOne("courseID" -> courseID, "userID" -> userID)

  def extract(row: Row) = new Course(
    row.integer("courseId").get,
    row.integer("userID").get,
    row.string("grade").get,
    row.string("comment").get
  )


}
