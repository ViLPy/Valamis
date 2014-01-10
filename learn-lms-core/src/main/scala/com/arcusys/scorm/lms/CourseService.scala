package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.tracking.model.Course
import com.escalatesoft.subcut.inject.{Injectable, BindingModule}
import com.arcusys.learn.storage.StorageFactoryContract

class CourseService(implicit val bindingModule: BindingModule) extends Injectable {
  val storageFactory = inject[StorageFactoryContract]

  def saveCourseGradeAndComment(courseID: Int, userID: Int, grade: String, comment: String) {
    val course = new Course(courseID, userID, grade, comment, None)
    if (storageFactory.courseStorage.get(courseID, userID) == None)
      storageFactory.courseStorage.create(course)
    else
      storageFactory.courseStorage.modify(course)
  }

  def getCourseGradeAndComment(courseID: Int, userID: Int) = {
    storageFactory.courseStorage.get(courseID, userID)
  }


}
