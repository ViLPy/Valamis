package com.arcusys.learn.scorm.course

import com.arcusys.learn.scorm.tracking.model.Course

trait CourseStorage {
  def create(course: Course)
  def get(courseId: Int, userID: Int): Option[Course]
  def modify(course: Course)
  def renew()
}
