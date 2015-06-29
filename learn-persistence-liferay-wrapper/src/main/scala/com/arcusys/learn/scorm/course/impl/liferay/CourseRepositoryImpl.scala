package com.arcusys.learn.scorm.course.impl.liferay

import com.arcusys.learn.persistence.liferay.model.LFCourse
import com.arcusys.learn.persistence.liferay.service.LFCourseLocalServiceUtil
import com.arcusys.valamis.gradebook.model.CourseGrade
import com.arcusys.valamis.gradebook.storage.CourseGradeStorage
import org.joda.time.DateTime

/**
 * Created by mminin on 15.10.14.
 */
class CourseRepositoryImpl extends CourseGradeStorage {

  override def renew(): Unit = {
    LFCourseLocalServiceUtil.removeAll()
  }

  override def get(courseId: Int, userID: Int): Option[CourseGrade] = {
    extract(LFCourseLocalServiceUtil.fetchByCourseIdAndUserId(courseId, userID))
  }

  override def create(course: CourseGrade): Unit = {
    val lfEntity = LFCourseLocalServiceUtil.createLFCourse()

    lfEntity.setCourseID(course.courseID)
    lfEntity.setUserID(course.userID)
    lfEntity.setGrade(course.grade)
    lfEntity.setComment(course.comment)
    lfEntity.setDate(DateTime.now().toDate)

    LFCourseLocalServiceUtil.addLFCourse(lfEntity)
  }

  override def modify(course: CourseGrade): Unit = {
    val lfEntity = LFCourseLocalServiceUtil.findByCourseIdAndUserId(course.courseID, course.userID)

    lfEntity.setCourseID(course.courseID)
    lfEntity.setUserID(course.userID)
    lfEntity.setGrade(course.grade)
    lfEntity.setComment(course.comment)
    lfEntity.setDate(DateTime.now().toDate)

    LFCourseLocalServiceUtil.updateLFCourse(lfEntity)
  }

  private def extract(lfEntity: LFCourse): Option[CourseGrade] =
    Option(lfEntity).map(lfEntity => CourseGrade(lfEntity.getCourseID,
      lfEntity.getUserID,
      lfEntity.getGrade,
      lfEntity.getComment,
      (if (lfEntity.getDate != null) Option(new DateTime(lfEntity.getDate)) else None)))
}
