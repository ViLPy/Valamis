package com.arcusys.learn.scorm.course

import com.arcusys.learn.scorm.tracking.model.CourseGrade

trait CourseStorage {
  def create(course: CourseGrade)
  def get(courseId: Int, userID: Int): Option[CourseGrade]
  def modify(course: CourseGrade)
  def renew()
}
