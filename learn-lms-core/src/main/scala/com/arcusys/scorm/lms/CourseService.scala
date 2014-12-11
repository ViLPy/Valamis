package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.course.CourseStorage
import com.arcusys.learn.scorm.tracking.model.CourseGrade
import com.escalatesoft.subcut.inject.{ Injectable, BindingModule }

class CourseService(implicit val bindingModule: BindingModule) extends Injectable {
  val courseRepository = inject[CourseStorage]

  def saveCourseGradeAndComment(courseID: Int, userID: Int, grade: String, comment: String) {
    val course = new CourseGrade(courseID, userID, grade, comment, None)
    if (courseRepository.get(courseID, userID) == None)
      courseRepository.create(course)
    else
      courseRepository.modify(course)
  }

  def getCourseGradeAndComment(courseID: Int, userID: Int) = {
    courseRepository.get(courseID, userID)
  }

}
