package com.arcusys.learn.scorm.course.impl.orbroker

import com.arcusys.learn.storage.impl.orbroker.GenericEntityStorageImpl
import org.orbroker.{RowExtractor, Row}
import com.arcusys.learn.scorm.tracking.model.Course
import com.arcusys.learn.scorm.course.impl.CourseEntityStorage

class CourseStorageImpl extends GenericEntityStorageImpl[Course]("Course") with CourseEntityStorage with CourseExtractor


trait CourseExtractor extends RowExtractor[Course] {
  def extract(row: Row) = new Course(
    row.integer("courseId").get,
    row.integer("userID").get,
    row.string("grade").get,
    row.string("comment").get
  )}



