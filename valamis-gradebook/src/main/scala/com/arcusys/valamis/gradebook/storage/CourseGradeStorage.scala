package com.arcusys.valamis.gradebook.storage

import com.arcusys.valamis.gradebook.model.CourseGrade

trait CourseGradeStorage {
  def create(course: CourseGrade)
  def get(courseId: Int, userID: Int): Option[CourseGrade]
  def modify(course: CourseGrade)
  def renew()
}
