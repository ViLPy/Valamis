package com.arcusys.scorm.lms

import com.arcusys.learn.scorm.tracking.model.Course
import com.arcusys.learn.storage.impl.orbroker.StorageFactory

object CourseService {
  def saveCourseGradeAndComment(courseID:Int, userID:Int, grade:String, comment: String){
    val course = new Course(courseID, userID, grade, comment)
    if(StorageFactory.courseStorage.get(courseID, userID)==None)
      StorageFactory.courseStorage.create(course)
    else
      StorageFactory.courseStorage.modify(course)
  }
  def getCourseGradeAndComment(courseID:Int, userID:Int)={
    StorageFactory.courseStorage.get(courseID, userID)
  }
}
