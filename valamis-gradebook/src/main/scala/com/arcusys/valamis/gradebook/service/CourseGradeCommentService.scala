package com.arcusys.valamis.gradebook.service

import com.arcusys.valamis.gradebook.model.CourseGrade
import com.arcusys.valamis.gradebook.storage.CourseGradeStorage
import com.escalatesoft.subcut.inject.{ BindingModule, Injectable }

class CourseGradeCommentService(implicit val bindingModule: BindingModule) extends Injectable {
  val courseRepository = inject[CourseGradeStorage]

  def saveCourseGradeAndComment(courseId: Int, userId: Int, grade: String, comment: String): Unit = {
    val course = new CourseGrade(courseId, userId, grade, comment, None)
    if (courseRepository.get(courseId, userId) == None)
      courseRepository.create(course)
    else
      courseRepository.modify(course)
  }

  def getCourseGradeAndComment(courseId: Int, userId: Int): Option[CourseGrade] = {
    courseRepository.get(courseId, userId)
  }

}
